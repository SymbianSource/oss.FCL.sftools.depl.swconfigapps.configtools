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

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

import com.nokia.tools.s60ct.confml.commands.RemoveSequenceItemCommand;
import com.nokia.tools.s60ct.confml.editor.PluginImages;
import com.nokia.tools.s60ct.confml.viewer.FeatureViewer;
import com.nokia.tools.s60ct.model.confml.EResourceSetting;
import com.nokia.tools.s60ct.model.confml.ESequenceSetting;
import com.nokia.tools.s60ct.model.confml.ESequenceValue;
import com.nokia.tools.s60ct.model.confml.ESequenceValueItem;
import com.nokia.tools.s60ct.model.confml.ESetting;
import com.nokia.tools.s60ct.model.confml.ESimpleSetting;
import com.nokia.tools.s60ct.model.confml.impl.ESequenceSettingImpl;
import com.nokia.tools.s60ct.model.confml.presentation.ConfmlEditor;


public class RemoveSequenceItemsAction extends EditorAction {

	public RemoveSequenceItemsAction() {
		setText("Remove sequence item");
		setImageDescriptor(PluginImages.DELETE);
	//	setEnabled(true);
	}

	@Override
	public void run() {

		IWorkbenchPage page = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage();
		if (page != null) {
			IEditorPart activeEditor = page.getActiveEditor();
			if (activeEditor != null && activeEditor instanceof ConfmlEditor) {
				ConfmlEditor editor = (ConfmlEditor) activeEditor;
				CommandStack commandStack = editor.getCommandStack();
				ISelection selection = editor.getEditorSite()
						.getSelectionProvider().getSelection();
				if (selection instanceof StructuredSelection) {
					StructuredSelection sel = (StructuredSelection) selection;
					Object[] selections = sel.toArray();
					Set<ESequenceValueItem> items2remove = new HashSet<ESequenceValueItem>();
					CompoundCommand compound = new CompoundCommand();
					ESequenceValue seqValue = null;
					for (int i = 0; i < selections.length; i++) {
						Object object = selections[i];
						if (object instanceof ESequenceValueItem) {
							ESequenceValueItem ss = (ESequenceValueItem) object;
							seqValue = (ESequenceValue) ss.eContainer();
							items2remove.add(ss);
						} else if (object instanceof EResourceSetting) {
							
						}
					}

					if (seqValue != null) {
						FeatureViewer viewer = (FeatureViewer) editor.getViewer();
						Map<Object, Composite> elementToWidgetMap = viewer.getElementToWidgetMap();
						for (ESequenceValueItem sequenceItem : items2remove) {
							compound.append(new RemoveSequenceItemCommand(
									(ESequenceSetting)seqValue.eContainer(), sequenceItem));
							Composite comp = elementToWidgetMap.get(sequenceItem);
							comp.getParent().dispose();
							final ConfmlEditor finalEditor = editor;
							Display.getCurrent().asyncExec(new Runnable() {

								public void run() {
									finalEditor.getViewer().refresh();
								}

							});

						}
						commandStack.execute(compound);
					}

				}

			}
		}

	}

	@Override
	public void initSelectionListener() {
		selectionListener = new ISelectionListener() {

			public void selectionChanged(IWorkbenchPart part,
					ISelection selection) {

				if (selection instanceof IStructuredSelection) {
					IStructuredSelection ss = (IStructuredSelection) selection;
					if (!ss.isEmpty()) {
						Object[] array = ss.toArray();
						for (int i = 0; i < array.length; i++) {
							Object object = array[i];
							if (object instanceof ESimpleSetting
									|| object instanceof EResourceSetting) {
								ESequenceSettingImpl seqItem = findSeqSetting((EObject) object);
								if (seqItem != null) {
									if (widget != null
											&& !widget.isDisposed()
											&& widget.getData() instanceof ESetting) {
										ESetting setting = ((ESetting) widget  //WRONG?!?
												.getData());
										if (seqItem == setting) {
											setEnabled(true);
											return;
										} else {
											setEnabled(false);
											return;
										}
									}
								}
							}
						}
					}
				}
			//	setEnabled(false);
			}
		};
	//	this.addListenerObject(selectionListener);
	}

	
	protected static ESequenceSettingImpl findSeqSetting(EObject eObject) {
		if (eObject == null) {
			return null;
		} else if (eObject instanceof ESequenceSettingImpl) {
			return (ESequenceSettingImpl) eObject;
		} else {
			return findSeqSetting(eObject.eContainer());
		}
	}


}
