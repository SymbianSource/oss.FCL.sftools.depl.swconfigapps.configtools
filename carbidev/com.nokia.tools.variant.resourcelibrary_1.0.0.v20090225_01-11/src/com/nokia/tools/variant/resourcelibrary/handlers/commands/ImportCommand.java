/*
 * Copyright (c) 2009 Nokia Corporation and/or its subsidiary(-ies). 
 * All rights reserved.
 * This component and the accompanying materials are made available
 * under the terms of "Eclipse Public License v1.0"
 * which accompanies this distribution, and is available
 * at the URL "http://www.eclipse.org/legal/epl-v10.html".
 * 
 * Initial Contributors:
 * Nokia Corporation - Initial contribution
 * 
 * Contributors:
 * 
 * Description: This file is part of com.nokia.tools.variant.resourcelibrary component.
 */

package com.nokia.tools.variant.resourcelibrary.handlers.commands;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;

import com.nokia.tools.variant.common.core.utils.FileUtils;
import com.nokia.tools.variant.common.ui.utils.SWTUtil;
import com.nokia.tools.variant.resourcelibrary.model.Directory;
import com.nokia.tools.variant.resourcelibrary.model.FileSystemElement;
import com.nokia.tools.variant.resourcelibrary.model.ResourceModelRoot;
import com.nokia.tools.variant.resourcelibrary.model.resourcesFactory;

/**
 * 
 */
public class ImportCommand extends Command implements IResourceLibraryCommand {
	private CreateFolderCommand folderCmd = null;

	public static Command createImportCommand(Directory target, File source) {
		return createImportCommand(target, source, source.getName(), false);
	}

	public static Command createImportCommand(ResourceModelRoot model, IPath path, File source, CreateFolderCommand folderCmd) {
		return new ImportCommand(model, source, path, false, folderCmd);
	}

	public static Command createImportCommand(Directory target, File source, String newName, boolean deleteSource) {
		newName = newName.toLowerCase();
		CompoundCommand command = new CompoundCommand("Import resource");
		if (source.isDirectory()) {
			FileSystemElement existing = checkExisting(target, newName);
			if (existing != null) {
				if (!openCheckDialog(existing)) {
					command.dispose();
					return UnexecutableCommand.INSTANCE;
				}
			}
			createImportDirectory(command, target, source, target.getPath2(), newName, deleteSource);
		} else {
			FileSystemElement existing = checkExisting(target, newName); 
			if (existing != null) {
				if (!openCheckDialog(existing)) {
					command.dispose();
					return UnexecutableCommand.INSTANCE;
				}
			}
			ResourceModelRoot model = ResourceLibraryCommandHelper.getResourceModelRoot(target);
			ImportCommand cmd = new ImportCommand(model, source, target.getPath2().append(newName), deleteSource, null);
			command.add(cmd);
		}
		return command.unwrap();
	}
	
	private static FileSystemElement checkExisting(Directory target, String newName) {
		FileSystemElement existing = null;
		EList<FileSystemElement> children = target.getChildren();
		for (FileSystemElement el : children) {
			if (newName.equals(el.getName().toLowerCase())) {
				existing = el;
				break;
			}
		}
		return existing;
	}
	
	public static boolean openCheckDialog(FileSystemElement existing) {
		MessageDialog dialog = new MessageDialog(SWTUtil
				.getStandardDisplay().getActiveShell(),
				"Replace existing resource", null,
				"Replace existing resource " + existing.getName() + "?",
				MessageDialog.QUESTION, new String[] {
						IDialogConstants.YES_LABEL,
						IDialogConstants.NO_LABEL}, 0);
		return dialog.open() == 0 ? true : false;
	}

	public static Command createImportCommand(Directory target, List<File> sources) {
		if (sources.isEmpty()) {
			return UnexecutableCommand.INSTANCE;
		}
		
		CompoundCommand command = new CompoundCommand("Import Resources");
		
		for (File file: sources) {
			command.add(createImportCommand(target, file, file.getName(), false));
		}
		
		return command.unwrap();
	}
	
	static void createImportDirectory(CompoundCommand command, Directory target, File source, IPath prefix, String localName, boolean deleteSource) {
		IPath newPath = prefix.append(localName);
		ResourceModelRoot model = ResourceLibraryCommandHelper.getResourceModelRoot(target);
		Command cmd = CreateFolderCommand.createNewDirectoryCommand(model, newPath);
		command.add(cmd);
		for (File file: source.listFiles()) {
			if (file.isDirectory()) {
				createImportDirectory(command, target, file, newPath, file.getName(), deleteSource);
			} else {
				ImportCommand ic = new ImportCommand(model, file, newPath.append(file.getName()), deleteSource, null);
				command.add(ic);
			}
		}
	}

	private ResourceModelRoot model;
	private File sourceFile;
	private IPath path;
	private File overridenContent;
	private boolean deleteSource;
	
	private ImportCommand(ResourceModelRoot model, File sourceFile, IPath path, boolean deleteSource, CreateFolderCommand folderCmd) {
		Assert.isNotNull(model);
		Assert.isNotNull(sourceFile);
		Assert.isNotNull(path);
		
		
		setLabel("Import File");
		
		this.folderCmd = folderCmd;
		this.model = model;
		this.sourceFile = sourceFile;
		this.path = path;
		this.deleteSource = deleteSource;
		
	}
	
	@Override
	public boolean canExecute() {
		if (!sourceFile.exists() || !sourceFile.isFile()) {
			return false;
		}
		FileSystemElement element = model.findChild(path.removeLastSegments(1));
		element = model.findChild(path);
		if (element != null) {
			return element instanceof com.nokia.tools.variant.resourcelibrary.model.File;
		}
		return true;
	}
	
	@Override
	public boolean canUndo() {
		return model.findChild(path) instanceof com.nokia.tools.variant.resourcelibrary.model.File;
	}
	
	@Override
	public void dispose() {
		if (overridenContent != null) {
			overridenContent.delete();
			overridenContent = null;
		}
		if (deleteSource) {
			if (!sourceFile.delete()) {
				sourceFile.deleteOnExit();
			}
		}
	}
	
	@Override
	public void execute() {
		Directory parent = (Directory)model.findChild(path.removeLastSegments(1));
		com.nokia.tools.variant.resourcelibrary.model.File fileElement = (com.nokia.tools.variant.resourcelibrary.model.File)parent.getChild(path.lastSegment());
		
		ResourceModelRoot resourceModelRoot = ResourceLibraryCommandHelper.getResourceModelRoot(parent);
		
		File targetFile = new File(resourceModelRoot.getTempDirPath(), parent.getPath2().append(path.lastSegment()).toOSString());
		InputStream is = null;
		OutputStream os = null;

		if (targetFile.exists()) {
			try {
				overridenContent = File.createTempFile("overriden_", ".file");
				overridenContent.delete();
				long time= targetFile.lastModified();
				targetFile.renameTo(overridenContent);
				overridenContent.setLastModified(time);
			} catch (IOException ex) {
				throw new RuntimeException("Failed to import file content", ex);
			}
		}
		
		try {
			is = new FileInputStream(sourceFile);
			os = new FileOutputStream(targetFile);
			FileUtils.copyStream(is, os);
		} catch (IOException ex) {
			throw new RuntimeException("Failed to import file content", ex);
		} finally {
			FileUtils.closeStream(is);
			FileUtils.closeStream(os);
		}
		targetFile.setLastModified(sourceFile.lastModified());
		int index = parent.getChildren().size();
		if (fileElement == null) {
			if (path.lastSegment().endsWith(".tpf")) {
				fileElement = resourcesFactory.eINSTANCE.createThemeFile();
	
				
			} else{
			fileElement = resourcesFactory.eINSTANCE.createFile();}
			fileElement.setDefaultResource(null);
			fileElement.setName(path.lastSegment());
			fileElement.setNote(null);
			fileElement.setReadOnly(false);
			fileElement.setSize(sourceFile.length());
			fileElement.setTimestamp(sourceFile.lastModified());
		} else {
			// this can be only in case of overridden file content
			
			fileElement.setReadOnly(false);
			fileElement.setSize(sourceFile.length());
			fileElement.setTimestamp(sourceFile.lastModified());
			index = parent.getChildren().indexOf(fileElement); 
			parent.getChildren().remove(index);
		}
		
		parent.getChildren().add(index, fileElement);
	}
	
	@Override
	public void undo() {
		com.nokia.tools.variant.resourcelibrary.model.File fileElement = (com.nokia.tools.variant.resourcelibrary.model.File)model.findChild(path);
		File targetFile = new File(model.getTempDirPath(), fileElement.getPath2().toOSString());

		Directory parent = (Directory)fileElement.eContainer();
		int index = parent.getChildren().indexOf(fileElement); 
		parent.getChildren().remove(index);

		if (overridenContent != null) {
			targetFile.delete();
			overridenContent.renameTo(targetFile);
			overridenContent = null;
			
			fileElement.setReadOnly(true);
			fileElement.setSize(targetFile.length());
			fileElement.setTimestamp(targetFile.lastModified());

			parent.getChildren().add(index, fileElement);
		} else if (fileElement.getDefaultResource() != null) {
			File defaultFile = fileElement.getDefaultResource();
			InputStream is = null;
			OutputStream os = null;
			try {
				is = new FileInputStream(defaultFile);
				os = new FileOutputStream(targetFile);
				FileUtils.copyStream(is, os);
			} catch (IOException ex) {
				throw new RuntimeException("Failed to import file content", ex);
			} finally {
				FileUtils.closeStream(is);
				FileUtils.closeStream(os);
			}

			targetFile.setLastModified(defaultFile.lastModified());
			fileElement.setReadOnly(true);
			fileElement.setSize(defaultFile.length());
			fileElement.setTimestamp(defaultFile.lastModified());
			
			parent.getChildren().add(index, fileElement);
		} else {
			targetFile.delete();
		}
	}
}
