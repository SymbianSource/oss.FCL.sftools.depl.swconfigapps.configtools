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

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;

import com.nokia.tools.variant.common.core.utils.FileUtils;
import com.nokia.tools.variant.resourcelibrary.model.Directory;
import com.nokia.tools.variant.resourcelibrary.model.File;
import com.nokia.tools.variant.resourcelibrary.model.FileSystemElement;
import com.nokia.tools.variant.resourcelibrary.model.ResourceModelRoot;
import com.nokia.tools.variant.resourcelibrary.model.resourcesFactory;

public class CopyResourcesCommand {

	private static class CopyFileCommand extends Command implements
			IResourceLibraryCommand {

		private final Directory container;
		private final File source;
		private java.io.File targetCopyFile;
		private final ResourceModelRoot modelRoot;
		private final IPath path;
		private File copied;
		private boolean wasReplaced;

		public CopyFileCommand(Directory target, File source, IPath path) {
			Assert.isNotNull(target);
			Assert.isNotNull(source);
			Assert.isNotNull(path);

			setLabel("Copy File");
			this.container = target;
			this.source = source;
			this.path = path;
			this.modelRoot = ResourceLibraryCommandHelper
					.getResourceModelRoot(target);
		}

		public CopyFileCommand(Directory target, File source) {
			this(target, source, new Path(source.getName()));
		}

		@Override
		public boolean canExecute() {
			for (int i = 0; i < path.segmentCount() - 1; i++) {
				FileSystemElement fse = container.findChild(path
						.removeLastSegments(path.segmentCount() - i - 1));
				if (fse != null && !(fse instanceof Directory)) {
					return false;
				}
			}

			return true;
		}

		@Override
		public boolean canUndo() {
			return copied != null;
		}

		private void copy(java.io.File source, java.io.File target) {
			InputStream is = null;
			OutputStream os = null;
			try {
				is = new FileInputStream(source);
				os = new FileOutputStream(target);
				FileUtils.copyStream(is, os);
				target.setLastModified(source.lastModified());
			} catch (IOException ex) {
				throw new RuntimeException("Failed to copy content", ex);
			} finally {
				FileUtils.closeStream(is);
				FileUtils.closeStream(os);
			}
		}

		@Override
		public void execute() {
			java.io.File rootFile = new java.io.File(modelRoot.getTempDirPath());
			java.io.File sourceFile = new java.io.File(rootFile, source
					.getPath2().toOSString());
			java.io.File targetFile = new java.io.File(rootFile, container
					.getPath2().append(path).toOSString());

			if (targetFile.exists()) {
				try {
					targetCopyFile = java.io.File.createTempFile(targetFile
							.getName(), null);
				} catch (IOException e) {
					throw new RuntimeException("Failed to copy content", e);
				}
				copy(targetFile, targetCopyFile);
				targetCopyFile.deleteOnExit();
			}
			if (copied == null) {
				copied = resourcesFactory.eINSTANCE.createFile();
				copied.setName(path.lastSegment());
				copied.setReadOnly(false);
				copied.setSize(source.getSize());
				copied.setTimestamp(source.getTimestamp());
			}
			copy(sourceFile, targetFile);

			Directory parent = (Directory) container.findChild(path
					.removeLastSegments(1));
			FileSystemElement existing = parent.findChild(path);
			if (existing != null) {
				parent.getChildren().remove(existing);
				wasReplaced = true;
			}
			parent.addChild(copied);
		}

		@Override
		public void undo() {
			java.io.File rootFile = new java.io.File(modelRoot.getTempDirPath());
			java.io.File file = new java.io.File(rootFile, copied.getPath2()
					.toOSString());
			if (wasReplaced) {
				copy(targetCopyFile, file);
				targetCopyFile.delete();
			} else {
				file.delete();
				((Directory) copied.eContainer()).getChildren().remove(copied);
			}
		}
	}

	public static Command createCopyCommand(Directory target,
			List<FileSystemElement> elements) {
		CompoundCommand command = new CompoundCommand("Copy Resources");
		for (FileSystemElement element : elements) {
			Command tmp = createCopyCommand(target, element);
			command.add(tmp);
		}
		return command.unwrap();
	}

	public static Command createCopyCommand(Directory target,
			FileSystemElement source) {
		return createCopyCommand(target, source, source.getName());
	}

	public static Command createCopyCommand(Directory target,
			FileSystemElement source, String newName) {
		if (source instanceof Directory) {
			return createDirCopyCommand(target, (Directory) source, newName);
		} else if (source instanceof File) {
			return createFileCopyCommand(target, (File) source, newName);
		} else {
			return UnexecutableCommand.INSTANCE;
		}
	}

	public static Command createFileCopyCommand(Directory target, File source,
			String newName) {
		CompoundCommand compoundCommand = new CompoundCommand();
		
		if (!Path.EMPTY.isValidSegment(newName)) {
			return UnexecutableCommand.INSTANCE;
		}
		FileSystemElement existing = target.getChild(newName);
		if (existing != null) {
			if (!ImportCommand.openCheckDialog(existing)) {
				return UnexecutableCommand.INSTANCE;
			} else {
				Command resourceRemove = RemoveCommand.createResourceRemove(existing);
				compoundCommand.add(resourceRemove);
			}
		}
		CopyFileCommand copyFileCommand = new CopyFileCommand(target, source, new Path(newName));
		compoundCommand.add(copyFileCommand);
		return compoundCommand;
	}

	public static Command createDirCopyCommand(Directory target,
			Directory source, String newName) {
		if (!Path.EMPTY.isValidSegment(newName)) {
			return UnexecutableCommand.INSTANCE;
		}
		FileSystemElement existing = target.getChild(newName);
		if (existing != null) {
			if (!ImportCommand.openCheckDialog(existing)) {
				return UnexecutableCommand.INSTANCE;
			}
		}

		CompoundCommand compound = new CompoundCommand("Copy Directory");
		addCreateDirectory(compound, target, source, Path.EMPTY, newName);
		return compound;
	}

	static void addCreateDirectory(CompoundCommand command, Directory target,
			Directory source, IPath prefix, String newName) {
		IPath newPath = prefix.append(newName);
		Command tmp = CreateFolderCommand.createNewDirectoryCommand(target,
				newPath);
		command.add(tmp);
		for (FileSystemElement child : source.getChildren()) {
			if (child instanceof Directory) {
				addCreateDirectory(command, target, (Directory) child, newPath,
						child.getName());
			} else {
				tmp = new CopyFileCommand(
						target,
						(com.nokia.tools.variant.resourcelibrary.model.File) child,
						newPath.append(child.getName()));
				command.add(tmp);
			}
		}
	}
}
