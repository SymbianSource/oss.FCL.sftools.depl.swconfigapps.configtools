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
package com.nokia.tools.s60ct.confml.commands;

import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.nokia.tools.s60ct.model.confml.ConfmlFactory;
import com.nokia.tools.s60ct.model.confml.ESequenceSetting;
import com.nokia.tools.s60ct.model.confml.ESequenceValue;
import com.nokia.tools.s60ct.model.confml.ESequenceValueItem;
import com.nokia.tools.s60ct.model.confml.presentation.ConfmlEditor;

public class DuplicateSequencesCommand extends AbstractSelectionCommand
{
	protected EList <ESequenceValueItem> items = null;
	protected ESequenceValue container = null;
	protected ConfmlFactory factory = ConfmlFactory.eINSTANCE;
	protected  ESequenceSetting setting = null;
    protected ConfmlEditor editor = null;
	
	public DuplicateSequencesCommand(EList<ESequenceValueItem> items, ESequenceSetting setting,ConfmlEditor editor) 
	{
		this.items = items;
		this.setting = setting;
		this.editor = editor;
	}


	public void execute() 
	{
		
		ESequenceValue seqVal = (ESequenceValue)setting.getValue();
		
		int size = items.size();
		for ( int index = 0; index < size; index++)
		{
			ESequenceValueItem source = items.get(index);
			ESequenceValueItem templateCopy = (ESequenceValueItem) EcoreUtil.copy(source);
			templateCopy.setEditable(true);
			URIEditorInput editorInput = (URIEditorInput) editor.getEditorInput();
			URI editorUri = editorInput.getURI();
			templateCopy.setFrameLocationUri(URI.createURI(editorUri.scheme() + ":"+ editorUri.path()));
			seqVal.getItems().add(templateCopy);
			
		}
	}

	public void undo() 
	{
	}

	public Object getModel() 
	{
		return items;
	}


	public void redo() {
		System.out.println("DuplicateSequencesCommand.redo()");
	}

}
