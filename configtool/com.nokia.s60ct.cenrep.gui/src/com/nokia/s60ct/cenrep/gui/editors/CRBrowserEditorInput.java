/*
* Copyright (c) 2009 Nokia Corporation and/or its subsidiary(-ies). 
* All rights reserved.
* This component and the accompanying materials are made available
* under the terms of "Eclipse Public License v1.0"
* which accompanies this distribution, and is available
* at the URL "http://www.eclipse.org/legal/epl-v10.html".
*
* Initial Contributors:
* Nokia Corporation - initial contribution.
*
* Contributors:
*
* Description:
*
*/
package com.nokia.s60ct.cenrep.gui.editors;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IPersistableElement;

public class CRBrowserEditorInput implements IEditorInput, IPersistableElement {

	private List<IFile> inputFiles = null;
	
	public CRBrowserEditorInput(List<IFile> files) {
		inputFiles = files;
	}

	public CRBrowserEditorInput(IFile file) {
		inputFiles = new ArrayList<IFile>();
		inputFiles.add(file);
	}


	@Override
	public boolean exists() {
		return !inputFiles.isEmpty();
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		return null;
	}

	@Override
	public String getName() {
		return "name";
	}

	@Override
	public IPersistableElement getPersistable() {
		return this;
	}

	@Override
	public String getToolTipText() {
		return "crml";
	}

	@Override
	public Object getAdapter(Class adapter) {
		return null;
	}

	@Override
	public String getFactoryId() {
		return CenRepElementFactory.getFactoryId();
	}

	@Override
	public void saveState(IMemento memento) {
		CenRepElementFactory.saveState(memento, this);
	}

	public List<IFile> getFiles() {
		return inputFiles;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		List<IFile> otherFiles = new ArrayList<IFile>();
		if (obj instanceof IFileEditorInput) {
			IFileEditorInput other = (IFileEditorInput) obj;
			otherFiles.add(other.getFile());
		}else if(obj instanceof CRBrowserEditorInput){
			CRBrowserEditorInput other = (CRBrowserEditorInput) obj;
			otherFiles.addAll(other.getFiles());
		}else{
			return false;
		}
		for(IFile file : otherFiles){
			if(inputFiles.indexOf(file)==-1)
				return false;
		}
		return true;
	}
	
	
}
