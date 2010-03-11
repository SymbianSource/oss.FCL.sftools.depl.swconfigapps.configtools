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
package com.nokia.tools.s60ct.confml.actions;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import com.nokia.tools.s60ct.confml.commands.EmptySequenceCommand;
import com.nokia.tools.s60ct.confml.editor.PluginImages;
import com.nokia.tools.s60ct.confml.widgets.SequenceWidget;
import com.nokia.tools.s60ct.model.confml.ConfmlFactory;
import com.nokia.tools.s60ct.model.confml.ESequenceValue;
import com.nokia.tools.s60ct.model.confml.ESequenceValueItem;
import com.nokia.tools.s60ct.model.confml.impl.ESequenceSettingImpl;
import com.nokia.tools.s60ct.model.confml.presentation.ConfmlEditor;


public class EmptySequenceAction extends EditorAction {

	public EmptySequenceAction() {
		setText("Set sequence to empty");
		setImageDescriptor(PluginImages.EMPTY_SEQUENCE);
	//	setEnabled(true);
	}

	@Override
	public void run() {

		IWorkbenchPage page = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage();
		if (page != null) {
			IEditorPart activeEditor = page.getActiveEditor();
			ConfmlEditor editor = null;
			if (activeEditor != null && activeEditor instanceof ConfmlEditor) {
				editor = (ConfmlEditor) activeEditor;
				CommandStack commandStack = editor.getCommandStack();
				
				Object data = widget.getData();
				((SequenceWidget) widget).setCollapsed(false);
				if (data instanceof ESequenceSettingImpl) {
					ESequenceSettingImpl eSeqSetImpl = (ESequenceSettingImpl) data;
					
					ESequenceValueItem template = ((ESequenceValue) eSeqSetImpl
							.getDefaultValue()).getTemplate();
					
					ESequenceValueItem emptyItem = null;
					
					if (template == null && eSeqSetImpl.getItems().size() > 0) {
						// template = eSeqSetImpl.getItems().get(0);
						template = ((ESequenceValue) eSeqSetImpl
								.getDefaultValue()).getItems().get(0);
					}
					if (template != null)
					{
						emptyItem = ConfmlFactory.eINSTANCE.createESequenceValueItem();
						
						URIEditorInput editorInput = (URIEditorInput) editor
								.getEditorInput();
						URI editorUri = editorInput.getURI();
						emptyItem.setFrameLocationUri(URI
								.createURI(editorUri.scheme() + ":"
										+ editorUri.path()));
					}
					
					Command addCommand = new EmptySequenceCommand(eSeqSetImpl, emptyItem);
					commandStack.execute(addCommand);
					
					final ConfmlEditor finalEditor = editor;
					Display.getCurrent().asyncExec(new Runnable() {

						public void run() {
							finalEditor.getViewer().refresh();
						}

					});
				} 
			}
		}
	}

	@Override
	public void initSelectionListener() {

	}


}
