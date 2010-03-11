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
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gef.commands.Command;

import com.nokia.tools.variant.common.core.utils.FileUtils;
import com.nokia.tools.variant.resourcelibrary.model.Directory;
import com.nokia.tools.variant.resourcelibrary.model.FileSystemElement;
import com.nokia.tools.variant.resourcelibrary.model.ResourceModelRoot;
import com.nokia.tools.variant.resourcelibrary.model.resourcesFactory;

public class CreateFolderCommand extends Command implements IResourceLibraryCommand {
	
	public static Command createNewDirectoryCommand(Directory target, IPath path) {
		ResourceModelRoot model = ResourceLibraryCommandHelper.getResourceModelRoot(target);
		return new CreateFolderCommand(model, target.getPath2().append(path));
	}

	public static CreateFolderCommand createNewDirectoryCommand(ResourceModelRoot model, IPath path) {
		return new CreateFolderCommand(model, path);
	}

	private final ResourceModelRoot model;
	private List<Directory> created;
	private final IPath path;
	
	private CreateFolderCommand(ResourceModelRoot model, IPath path) {
		Assert.isNotNull(model);
		Assert.isNotNull(path);
		
		this.model = model;
		this.path = path;
		this.created = new ArrayList<Directory>();
	}
	
	@Override
	public boolean canExecute() {
		if (path.segmentCount() == 0) {
			return false;
		}
		return true;
	}
	
	@Override
	public boolean canUndo() {
		return created != null;
	}
	
	@Override
	public void execute() {
		Directory parent = model;
		File rootFile = new File(model.getTempDirPath());
		File dirFile = rootFile;
		
		for (String segment: path.segments()) {
			FileSystemElement fes = parent.getChild(segment);
			dirFile = new File(dirFile, segment);
			if (fes instanceof Directory) {
				parent = (Directory)fes;
				continue;
			}
			dirFile.mkdir();

			Directory object = resourcesFactory.eINSTANCE.createDirectory();
			object.setName(segment);
			object.setReadOnly(false);
			object.setTimestamp(dirFile.lastModified());
			
			FileSystemElement existing = getExisting(parent, object);
			if (existing == null) {
				created.add(object);
				parent.getChildren().add(object);
			}
			parent = object;
		}
	}
	
	private FileSystemElement getExisting(Directory parent, Directory object) {
		FileSystemElement existing = null;
		EList<FileSystemElement> children = parent.getChildren();
		for (FileSystemElement el : children) {
			if (el.getName().toLowerCase().equals(object.getName().toLowerCase())){
				existing = el;
			}
		}
		return existing;
	}
	
	@Override
	public void undo() {
		if (created.isEmpty()) {
			return;
		}
		
		File rootFile = new File(model.getTempDirPath());
		Directory top = created.get(0);
		File dirFile = new File(rootFile, top.getPath2().toOSString());
		FileUtils.deleteDirectory(dirFile);
		((Directory)top.eContainer()).getChildren().remove(top);
		created.clear();
	}

}
