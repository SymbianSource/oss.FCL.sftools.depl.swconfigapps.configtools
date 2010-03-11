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
import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;

import com.nokia.tools.variant.common.core.utils.FileUtils;
import com.nokia.tools.variant.resourcelibrary.model.Directory;
import com.nokia.tools.variant.resourcelibrary.model.FileSystemElement;
import com.nokia.tools.variant.resourcelibrary.model.ResourceModelRoot;

public class RemoveCommand extends Command implements IResourceLibraryCommand {

	public static Command createResourceRemove(ResourceModelRoot root,
			IPath path) {
		FileSystemElement fse = root.findChild(path);
		if (fse != null) {
			return createResourceRemove(fse);
		} else {
			return UnexecutableCommand.INSTANCE;
		}
	}

	public static Command createResourceRemove(FileSystemElement fse) {
		return new RemoveCommand(fse);
	}

	public static Command createResourceRemove(
			List<? extends FileSystemElement> elements) {
		CompoundCommand command = new CompoundCommand();
		command.setLabel("Delete Resources");
		for (FileSystemElement element : elements) {
			command.add(createResourceRemove(element));
		}
		return command.unwrap();
	}

	private final ResourceModelRoot model;
	private final IPath path;
	private int index;
	private File removedFile;
	private FileSystemElement target;
	private com.nokia.tools.variant.resourcelibrary.model.File defaultResource;

	private RemoveCommand(FileSystemElement target) {
		super("Delete Resource");
		this.target = target;
		this.path = target.getPath2();
		this.model = ResourceLibraryCommandHelper.getResourceModelRoot(target);
	}

	private RemoveCommand(ResourceModelRoot model, IPath path) {
		super("Delete Resource");
		this.path = path;
		this.model = model;
	}


	@Override
	public boolean canExecute() {
		FileSystemElement target = model.findChild(path);
		if (target instanceof ResourceModelRoot) {
			return false;
		} else if (target instanceof com.nokia.tools.variant.resourcelibrary.model.File) {
			return !target.isReadOnly();
		} else if (target instanceof Directory) {
			return !ResourceLibraryCommandHelper.hasReadOnly((Directory) target);
		} else {
			return false;
		}
	}



	@Override
	public boolean canUndo() {
		return removedFile != null && removedFile.exists()||target instanceof Directory;
	}

	@Override
	public void undo() {
		if (target == null) {
			return;
		}
		
		File targetFile = new File(model.getTempDirPath(), path.toOSString());
		targetFile.delete();
		
		

		Directory parent = (Directory) model.findChild(path.removeLastSegments(1));
		
		if (target instanceof com.nokia.tools.variant.resourcelibrary.model.File) {
			removedFile.renameTo(targetFile);
			removedFile = null;
			if (defaultResource != null) {
				parent.getChildren().remove(defaultResource);
				defaultResource = null;
			}
		}

		parent.getChildren().add(index, target);
	}

	@Override
	public void execute() {
		FileSystemElement target = model.findChild(path);
		Directory container = (Directory)target.eContainer();
		if (target instanceof com.nokia.tools.variant.resourcelibrary.model.File) {
			com.nokia.tools.variant.resourcelibrary.model.File f = (com.nokia.tools.variant.resourcelibrary.model.File) target;
			try {
				removedFile = File.createTempFile("removed", ".dat");
			} catch (IOException e) {
				throw new RuntimeException("Command failure", e);
			}
			removedFile.delete();

			File targetFile = new File(model.getTempDirPath(), target
					.getPath2().toOSString());
			long temp = targetFile.lastModified();
			targetFile.renameTo(removedFile);
			removedFile.setLastModified(temp);

			index = container.getChildren().indexOf(target);
			container.getChildren().remove(index);

			if (f.getDefaultResource() != null) {
				File defaultFile = f.getDefaultResource();

				defaultResource = (com.nokia.tools.variant.resourcelibrary.model.File) EcoreUtil
						.copy(target);
				defaultResource.setReadOnly(true);
				defaultResource.setSize(defaultFile.length());
				defaultResource.setTimestamp(defaultFile.lastModified());

				FileOutputStream os = null;
				FileInputStream is = null;
				try {
					os = new FileOutputStream(targetFile);
					is = new FileInputStream(defaultFile);
					FileUtils.copyStream(is, os);
					targetFile.setLastModified(defaultFile.lastModified());
				} catch (IOException e) {
					throw new RuntimeException("Command failure", e);
				} finally {
					FileUtils.closeStream(is);
					FileUtils.closeStream(os);
				}

				container.getChildren().add(index, defaultResource);
			}
		} else if (target instanceof Directory) {
			File targetFile = new File(model.getTempDirPath(), target.getPath2().toOSString());
			deleteDirectory(targetFile.getPath());
			targetFile.delete();
			
			index = container.getChildren().indexOf(target);
			container.getChildren().remove(index);
		} else {
			throw new UnsupportedOperationException("Unsupported target type");
		}

	}
	
	private void deleteDirectory(String path) {
		File f = new File(path);
		if (f.isDirectory()) {
			String[] children = f.list();
			if (children.length == 0) {
				f.delete();
			} else {
				for (String p : children) {
					deleteDirectory(f.getPath() + File.separator + p);
				}
			}
		} else {
			f.delete();
		}
	}
}
