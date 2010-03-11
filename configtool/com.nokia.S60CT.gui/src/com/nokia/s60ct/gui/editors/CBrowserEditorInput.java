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
package com.nokia.s60ct.gui.editors;

import helpers.DefaultProject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.part.FileEditorInput;

public class CBrowserEditorInput extends FileEditorInput {
	EObject rootObject=null;
	
	public CBrowserEditorInput(IFile file) {
		super(file);
	}

	public CBrowserEditorInput(FileEditorInput input) {
		super(input.getFile());
	}

	@Override
	public String getFactoryId() {
		return ConfmlElementFactory.getFactoryId();
	}

	@Override
	public void saveState(IMemento memento) {
		ConfmlElementFactory.saveState(memento,this);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof IFileEditorInput)) {
			return false;
		}
		IFileEditorInput other = (IFileEditorInput) obj;
		List<IFile> myFiles = getAllFiles();
		int index = myFiles.indexOf(other.getFile());
		if(index!=-1){
			return true;
		}else return false;
	}

	public void setRootEObject(EObject object) {
		rootObject=object;
	}
	
	public EObject getRootEObject() {
		return rootObject; 
	}
	
	private List<IFile> getAllFiles(){
		List<IFile> result = new ArrayList<IFile>();
		if(rootObject!=null){
			collectFiles(rootObject,result,new HashSet<EObject>());
		}else result.add(getFile());
		return result;
	}

	private void collectFiles(EObject rootObj, List<IFile> result,final Set<EObject> set) {
		if(rootObj==null||rootObj.eResource()==null||set.contains(rootObj))return;
		set.add(rootObj);
		result.add(DefaultProject.getLinkFile(rootObj.eResource().getURI()));
		for(EObject obj :rootObj.eCrossReferences())
			collectFiles(obj, result,set);
	}

}
