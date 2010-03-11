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

import com.nokia.tools.vct.confml.editor.view.vemodel.EDescriptionContainer;

/**
 * This ViewTreeViewer has 4 nodes. The ROOT node of tree is VIEW element.
 * Second node is GROUP element. Third node is SUBGROUP and fourth node is SETTING. Tree is 
 * created in the {@link CreateViewPage2} and it provides VIEW, which will be created.  
 * into ViewTreeViewer
 * 
 */

public class ViewTreeViewer extends TreeViewer {

	public ViewTreeViewer(Composite parent, int style) {
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

	protected void updateTooltip(int x, int y) {
		TreeItem item = getTree().getItem(new Point(x, y));
		String text = null;
		if (item != null) {
			Object data = item.getData();
			if (data instanceof EDescriptionContainer) {
				text = ((EDescriptionContainer) data).getDescriptionText();
			}
		}
		getTree().setToolTipText(text);
	}

	
}
