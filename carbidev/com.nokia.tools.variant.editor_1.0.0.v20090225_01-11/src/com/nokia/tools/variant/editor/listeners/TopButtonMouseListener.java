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

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;

import com.nokia.tools.variant.content.confml.Group;
import com.nokia.tools.variant.editor.editors.CPFEditor;
import com.nokia.tools.variant.editor.summary.SummaryLeafGroup;
import com.nokia.tools.variant.editor.summary.SummaryParentGroup;

public class TopButtonMouseListener implements MouseListener {
	private CPFEditor editor;

	public TopButtonMouseListener(CPFEditor editor) {
		this.editor = editor;
	}

	public void mouseDoubleClick(MouseEvent e) {

	}

	public void mouseDown(MouseEvent e) {
		IStructuredSelection selection = (IStructuredSelection) editor
				.getNavigatorViewer().getSelection();
		Object firstElement = selection.getFirstElement();
		if (firstElement instanceof Group
				&& !(firstElement instanceof SummaryLeafGroup)&& !(firstElement instanceof SummaryParentGroup)) {
			Group l = (Group) firstElement;

			editor.getSettingsViewer().setInput(
					editor.getViewModelToUIModelConvertor().createUIModel(l));
			editor.refreshAndHandleWidgetState();
		
			editor.setDirtySorting(false);
			editor.setErrorSorting(false);
			editor.setNotesSorting(false);
		}

	}

	public void mouseUp(MouseEvent e) {

	}
}
