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

package com.nokia.tools.variant.resourcelibrary.actions;

import java.io.File;

import org.eclipse.emf.common.util.EList;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.jface.action.Action;

import com.nokia.tools.variant.resourcelibrary.Activator;
import com.nokia.tools.variant.resourcelibrary.model.Directory;
import com.nokia.tools.variant.resourcelibrary.model.FileSystemElement;
import com.nokia.tools.variant.resourcelibrary.model.ResourceModelRoot;
import com.nokia.tools.variant.resourcelibrary.model.impl.resourcesFactoryImpl;
import com.nokia.tools.variant.resourcelibrary.views.IResourceLibraryPage;

public class RefreshAction extends Action {

	private IResourceLibraryPage page;

	public RefreshAction(IResourceLibraryPage page) {
		super("Refresh", Activator.getImageDescriptor("icons/refresh_nav.gif"));
		this.page = page;
	}

	@Override
	public void run() {

		String tempDirPath = page.getResourceModelRoot().getTempDirPath();
		if (tempDirPath != null) {
			File tempDir = new File(tempDirPath);
			boolean modified = processDir(page.getResourceModelRoot(), tempDir);
			if (modified) {
				CommandStack stack = page.getCommandStack();
				// mark stack as dirty, no undo support
				stack.execute(new RefreshCommand());
			}
		}
	}

	static class RefreshCommand extends Command {
		private RefreshCommand() {
			super("Refresh");
		}	
		@Override
		public boolean canExecute() {
			return true;
		}
		@Override
		public boolean canUndo() {
			return false;
		}
	}
	
	private boolean processDir(Directory dir, File realDir) {
		File[] children = realDir.listFiles();

		boolean modified = false;
		
		for (int i = 0; i < children.length; i++) {

			File file = children[i];
			FileSystemElement child = dir.getChild(file.getName());
			if (child == null) {
				modified = true;
				if (file.isDirectory()) {
					processDir(createDir(dir, file), file);
				} else if (file.isFile()) {
					createFile(dir, file);
				}
			} else if (file.isDirectory()){
				modified |= processDir((Directory)child,file);
			}
		}
		EList<FileSystemElement> resDir = dir.getChildren();
		File root = new File(page.getResourceModelRoot().getTempDirPath());
		
		for (int i = 0; i < resDir.size(); i++) {
			FileSystemElement child = resDir.get(i);
			File f = new File (root, child.getPath2().toOSString());
			if (!f.exists()){
				modified = true;
				resDir.remove(child);
			} else if (f.isFile()) {
				com.nokia.tools.variant.resourcelibrary.model.File file = (com.nokia.tools.variant.resourcelibrary.model.File) child;
				
				long size = f.length();
				if (file.getSize() != size) {
					file.setSize(size);
					modified = true;
				}
			}
			long lastModified = f.lastModified();
			if (child.getTimestamp() != lastModified) {
				child.setTimestamp(lastModified);
				modified = true;
			}
		}
		return modified;
	}

	private void createFile(Directory dir, File file) {
		com.nokia.tools.variant.resourcelibrary.model.File newFile = resourcesFactoryImpl.eINSTANCE
				.createFile();
		newFile.setName(file.getName());
		newFile.setSize(file.length());
		newFile.setTimestamp(file.lastModified());
		dir.addChild(newFile);
	}

	private Directory createDir(Directory parentDir, File file) {
		Directory dir = resourcesFactoryImpl.eINSTANCE.createDirectory();
		dir.setName(file.getName());
		if (parentDir instanceof ResourceModelRoot) {
			dir.setReadOnly(true);
		}
		parentDir.addChild(dir);
		return dir;
	}
}
