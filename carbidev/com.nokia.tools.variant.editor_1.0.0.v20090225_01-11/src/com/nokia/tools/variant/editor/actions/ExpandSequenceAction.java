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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Listener;

import com.nokia.tools.variant.editor.editors.PluginImages;
import com.nokia.tools.variant.viewer.actions.EditorAction;
import com.nokia.tools.variant.viewer.widgets.BaseConfMLWidget;
import com.nokia.tools.variant.viewer.widgets.SequenceWidget;
import com.nokia.tools.variant.viewer.widgets.SequenceWidgetItem;

/**
 * Action expands sequence and all sequence items.
 */
public class ExpandSequenceAction extends EditorAction {
	
	/**
	 * Constructor creates label and image for the action. 
	 */
	public ExpandSequenceAction() {
		setText("Expand all");
		setImageDescriptor(PluginImages.EXPAND_ALL);
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {
		if (widget instanceof SequenceWidget) {
			SequenceWidget w = (SequenceWidget) widget;

			if (w.isCollapsed()) {
				w.setCollapsed(false);
			}
			SequenceWidgetItem firstChanged = null;
			Control[] children = w.getChildren(); 
			for (int i = 0; i < children.length; i++) {
				Control control = children[i];

				if (control instanceof SequenceWidgetItem) {
					SequenceWidgetItem sWidget = (SequenceWidgetItem) control;

					if (sWidget.isCollapsed()) {
						if (firstChanged == null) {
							firstChanged = sWidget;
						} 

						sWidget.setCollapsed(false);
					}
				}
			}

			Composite parent = widget.getParent();
			parent.getParent().getParent().getParent().getParent().getParent()
					.layout(true, true);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.nokia.tools.variant.viewer.actions.EditorAction#initSelectionListener()
	 */
	@Override
	public void initSelectionListener() {
		// do nothing
	}

	/*
	 * (non-Javadoc)
	 * @see com.nokia.tools.variant.viewer.actions.EditorAction#setWidget(com.nokia.tools.variant.viewer.widgets.BaseConfMLWidget)
	 */
	@Override
	public void setWidget(BaseConfMLWidget widget) {
		super.setWidget(widget);
		if (widget instanceof SequenceWidget) {
			final SequenceWidget sw = (SequenceWidget) widget;
			sw.addControlListener(new ControlListener() {

				public void controlMoved(ControlEvent e) {
					// do nothing
				}

				public void controlResized(ControlEvent e) {
					setEnabled(isCollapsed(sw));
				}
			});
		}
	}

	protected boolean isCollapsed(SequenceWidget widget) {
		if (widget.getCache().size()<2){
			return false;
		}
		if (widget.isCollapsed()) {
			return true;
		}
		Control[] children = widget.getChildren(); 
		for (Control control : children) {
			if (control instanceof SequenceWidgetItem) {
				if (((SequenceWidgetItem) control).isCollapsed()) {
					return true;
				}
			}
		}
		return false;
	}

}
