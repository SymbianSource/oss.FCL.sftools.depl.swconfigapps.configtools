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
 * Description: This file is part of com.nokia.tools.vct.confml.editor.view component.
 */

package com.nokia.tools.vct.confml.editor.view.viewers;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.widgets.Widget;

import com.nokia.tools.vct.confml.editor.view.vemodel.EDescriptionContainer;


/**
 * This ConfmlTreeViewer has 2 nodes. The ROOT node of tree is FEATURE element.
 * Second node is SETTING element. Tree is created in the {@link CreateViewPage2}
 * and it provides list of SETTINGS packed in FEATURES for shifting 
 * into ViewTreeViewer
 * 
 */

public class ConfmlTreeViewer extends TreeViewer implements IConfmlTreeViewer {

	public ConfmlTreeViewer(Composite parent, int style) {
		super(parent, style);
		getTree().addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				updateTooltip(e.x, e.y);
			}
			@Override
			public void mouseExit(MouseEvent e) {
				getTree().setToolTipText(null);
			}
			@Override
			public void mouseHover(MouseEvent e) {
				updateTooltip(e.x, e.y);
			}
		});
	}

	
	


	@Override
	protected void internalRefresh(Object element, boolean updateLabels) {
		// TODO Auto-generated method stub
		super.internalRefresh(element, updateLabels);
	}





	@Override
	protected void internalRefresh(Widget widget, Object element,
			boolean doStruct, boolean updateLabels) {
		// TODO Auto-generated method stub
//		if (element instanceof String)
//			return;
//		else
			super.internalRefresh(widget, element, doStruct, updateLabels);
	}





	@Override
	protected void internalRefreshStruct(Widget widget, Object element,
			boolean updateLabels) {
		// TODO Auto-generated method stub
//		if (element instanceof String)
//			return;
//		else
			super.internalRefreshStruct(widget, element, updateLabels);
	}





	protected void updateTooltip(int x, int y) {
		TreeItem item = getTree().getItem(new Point(x, y));
		String text = null;
		if (item != null) {
			Object data = item.getData();
			if (data instanceof EDescriptionContainer) {
				text = ((EDescriptionContainer)data).getDescriptionText();
			}
		}
		getTree().setToolTipText(text);
	}

}
