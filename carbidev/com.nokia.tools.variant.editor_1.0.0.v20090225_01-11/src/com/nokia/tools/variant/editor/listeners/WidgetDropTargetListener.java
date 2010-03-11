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

package com.nokia.tools.variant.editor.listeners;

import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import com.nokia.tools.variant.content.confml.FileSystemEntrySetting;
import com.nokia.tools.variant.content.confml.SequenceItem;
import com.nokia.tools.variant.content.confml.SequenceSetting;
import com.nokia.tools.variant.content.confml.Setting;
import com.nokia.tools.variant.editor.actions.DragAndDropActionRegistry;
import com.nokia.tools.variant.editor.actions.MoveSequenceItemAction;
import com.nokia.tools.variant.editor.model.UISetting;
import com.nokia.tools.variant.viewer.widgets.BaseConfMLWidget;
import com.nokia.tools.variant.viewer.widgets.SequenceWidget;


public class WidgetDropTargetListener implements DropTargetListener {

	private UISetting uiSetting;
	private SequenceWidget sqWidget;
	private Composite composite;
	boolean movingUp = false;
	boolean movingDown = false;

	public WidgetDropTargetListener(BaseConfMLWidget widget, Object object) {
		Control sw = findSequenceWidget(widget);
		if (sw != null && sw instanceof SequenceWidget) {
			this.sqWidget = (SequenceWidget) sw;
		}
		if (object instanceof UISetting) {
			this.uiSetting = (UISetting) object;
		}
	}

	public void dragEnter(DropTargetEvent event) {

		UISetting startSetting = DragAndDropActionRegistry.getStartUISetting();
		if (startSetting != null) {

			EObject endItem = checkFileSetting(uiSetting.getSetting())
					.eContainer();
			EObject startItem = checkFileSetting(startSetting.getSetting())
					.eContainer();
			if (startItem != endItem) {
				EObject container = endItem.eContainer();
				if (container != null && container instanceof SequenceSetting) {
					EList<SequenceItem> items = ((SequenceSetting) container)
							.getSequenceItem();
					int indexOfEndItem = items.indexOf(endItem);
					int indexOfStartItem = items.indexOf(startItem);

				


						Map<Control, Composite> separatorsMap = sqWidget
								.getSeparators();
						Object[] separators = separatorsMap.values().toArray();
						if (indexOfStartItem < indexOfEndItem) {
							indexOfEndItem++;
							movingDown = true;
						} else {
							movingUp = true;
						}
						composite = (Composite) separators[indexOfEndItem];
						composite.setBackground(composite.getDisplay()
								.getSystemColor(SWT.COLOR_BLACK));

				}
			}
		} else if (((DropTarget) event.getSource()).getDropListeners().length == 1) {
			event.detail = DND.DROP_NONE;
		}

	}

	private Control findSequenceWidget(Control control) {
		if (control == null) {
			return null;
		}
		if (control instanceof SequenceWidget) {
			return control;
		} else {
			return findSequenceWidget(control.getParent());
		}
	}

	public void dragLeave(DropTargetEvent event) {
		if (composite != null) {
			composite.setBackground(sqWidget.getBackground());
		}
	}

	public void dragOperationChanged(DropTargetEvent event) {
	}

	public void dragOver(DropTargetEvent event) {
		if (composite != null) {
			composite.redraw();
		}
		event.feedback = DND.FEEDBACK_SCROLL;
	}

	public void drop(DropTargetEvent event) {
		if (event.data instanceof StructuredSelection && uiSetting != null) {
			StructuredSelection ss = (StructuredSelection) event.data;
			Object firstElement = ss.getFirstElement();
			if (firstElement instanceof UISetting) {
				Setting source = ((UISetting) firstElement).getSetting();
				Setting target = uiSetting.getSetting();

				EObject sourceParent = checkFileSetting(source).eContainer();
				EObject targetParent = checkFileSetting(target).eContainer();
				if (sourceParent instanceof SequenceItem
						&& targetParent instanceof SequenceItem
						&& sourceParent.eContainer() == targetParent
								.eContainer() && sourceParent != targetParent) {

					MoveSequenceItemAction action = new MoveSequenceItemAction(
							(SequenceItem) sourceParent,
							(SequenceItem) targetParent);
					DragAndDropActionRegistry.setAction(action);

				}

			}

		}
		DragAndDropActionRegistry.setStartUISettingWidget(null);
	}

	public void dropAccept(DropTargetEvent event) {
		// do nothing
	}

	private EObject checkFileSetting(EObject setting) {
		EObject container = setting.eContainer();
		if (container != null && container instanceof FileSystemEntrySetting) {
			return (Setting) container;
		}
		return setting;
	}

}
