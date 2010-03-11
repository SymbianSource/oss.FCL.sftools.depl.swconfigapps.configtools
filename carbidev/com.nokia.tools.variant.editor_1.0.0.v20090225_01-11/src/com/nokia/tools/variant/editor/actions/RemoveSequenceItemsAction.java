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
 * Description: This file is part of com.nokia.tools.variant.editor component.
 */

package com.nokia.tools.variant.editor.actions;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.jface.commands.ActionHandler;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.IHandlerService;

import com.nokia.tools.variant.content.confml.FilePath;
import com.nokia.tools.variant.content.confml.FileSystemEntrySetting;
import com.nokia.tools.variant.content.confml.SequenceItem;
import com.nokia.tools.variant.content.confml.SequenceSetting;
import com.nokia.tools.variant.content.confml.Setting;
import com.nokia.tools.variant.content.confml.SimpleSetting;
import com.nokia.tools.variant.content.confml.View;
import com.nokia.tools.variant.editor.commands.RemoveSequenceItemsCommand;
import com.nokia.tools.variant.editor.editors.CPFEditor;
import com.nokia.tools.variant.editor.editors.PluginImages;
import com.nokia.tools.variant.editor.model.UISetting;
import com.nokia.tools.variant.viewer.actions.EditorAction;

/**
 * Action removes selected sequence items from sequence.
 */
public class RemoveSequenceItemsAction extends EditorAction {
	private boolean activated;

	/**
	 * Constructor set label, image and id
	 * "com.nokia.tools.variant.editor.removeSequenceItem" for the action.
	 */
	public RemoveSequenceItemsAction() {
		setText("Remove sequence item");
		setImageDescriptor(PluginImages.DELETE);
		setEnabled(false);
		setActionDefinitionId("com.nokia.tools.variant.editor.removeSequenceItem");
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {

		IWorkbenchPage page = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage();
		if (page != null) {
			IEditorPart activeEditor = page.getActiveEditor();
			if (activeEditor != null && activeEditor instanceof CPFEditor) {
				CPFEditor editor = (CPFEditor) activeEditor;
				CommandStack commandStack = editor.getCommandStack();
				ISelection selection = editor.getEditorSite()
						.getSelectionProvider().getSelection();
				if (selection instanceof StructuredSelection) {
					StructuredSelection sel = (StructuredSelection) selection;
					Object[] selections = sel.toArray();
					Set<SequenceItem> items2remove = new HashSet<SequenceItem>();

					SequenceSetting parentSq = null;
					for (int i = 0; i < selections.length; i++) {
						Object object = selections[i];
						if (object instanceof SimpleSetting) {
							SimpleSetting ss = (SimpleSetting) object;
							EObject ssParent = ss.eContainer();
							SequenceSetting sqSetting = remove(items2remove,
									ssParent, parentSq);
							if (parentSq == null) {
								parentSq = sqSetting;
							}
						} else if (object instanceof FileSystemEntrySetting) {
							if (object instanceof FilePath) {
								FilePath ss = (FilePath) object;
								EObject ssParent = ss.eContainer().eContainer();
								SequenceSetting sqSetting = remove(
										items2remove, ssParent, parentSq);
								if (parentSq == null) {
									parentSq = sqSetting;
								}
							} else {
								FileSystemEntrySetting fses = (FileSystemEntrySetting) object;
								EObject fsesParent = fses.eContainer();
								SequenceSetting sqSetting = remove(
										items2remove, fsesParent, parentSq);
								if (parentSq == null) {
									parentSq = sqSetting;
								}
							}
						}
						if (object instanceof FilePath) {
							FilePath ss = (FilePath) object;
							EObject ssParent = ss.eContainer();
							SequenceSetting sqSetting = remove(items2remove,
									ssParent, parentSq);
							if (parentSq == null) {
								parentSq = sqSetting;
							}
						}
					}

					if (parentSq != null) {

						commandStack.execute(new RemoveSequenceItemsCommand(
								parentSq, items2remove));
					}

				}

			}
		}

	}

	private SequenceSetting remove(Set<SequenceItem> set, EObject ssParent,
			SequenceSetting parentSq) {
		if (ssParent != null && ssParent instanceof SequenceItem) {
			SequenceItem parent = (SequenceItem) ssParent;
			EObject container = parent.eContainer();
			if (container != null && container instanceof SequenceSetting) {
				if (parentSq == null) {
					set.add(parent);
					return (SequenceSetting) container;
				} else if (parentSq == container) {
					set.add(parent);
				}
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see com.nokia.tools.variant.viewer.actions.EditorAction#initSelectionListener()
	 */
	@Override
	public void initSelectionListener() {
		selectionListener = new ISelectionListener() {

			public void selectionChanged(IWorkbenchPart part,
					ISelection selection) {

				setEnabled(false);
				if (selection instanceof IStructuredSelection) {
					IStructuredSelection ss = (IStructuredSelection) selection;
					if (!ss.isEmpty()) {
						Set<Object> set = new HashSet<Object>();
						Object[] array = ss.toArray();
						Boolean setDisabled = false;
						for (int i = 0; i < array.length; i++) {
							Object o = array[i];
							if (o instanceof SimpleSetting
									|| o instanceof FileSystemEntrySetting) {
								SequenceSetting relatedSequenceSetting = findSeqSetting((EObject) o);
								if (relatedSequenceSetting != null) {
									set.add(relatedSequenceSetting);
									if (widget == null) {
										setEnabled(true);
									} else {
										if (!widget.isDisposed()
												&& widget.getData() instanceof UISetting) {
											Setting setting = ((UISetting) widget
													.getData()).getSetting();
											if (setting == relatedSequenceSetting) {
												setEnabled(true);
											}
										}
									}
								} else {
									setEnabled(false);
									return;
								}
							} else {
								setDisabled = true;
							}
							if ((set.size() > 1) || setDisabled) {
								setEnabled(false);
								return;
							}
						}
					}
				}
			}
		};
	}

	protected static SequenceSetting findSeqSetting(EObject eObject) {
		if (eObject == null || eObject instanceof View) {
			return null;
		}
		while (eObject != null && !(eObject instanceof SequenceSetting)) {
			eObject = eObject.eContainer();
		}
		return (SequenceSetting) eObject;
	}

}
