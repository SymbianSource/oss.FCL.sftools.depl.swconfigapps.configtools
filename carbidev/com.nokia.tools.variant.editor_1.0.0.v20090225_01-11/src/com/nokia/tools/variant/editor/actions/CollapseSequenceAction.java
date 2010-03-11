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

import java.util.Set;

import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import com.nokia.tools.variant.editor.editors.PluginImages;
import com.nokia.tools.variant.viewer.actions.EditorAction;
import com.nokia.tools.variant.viewer.widgets.BaseConfMLWidget;
import com.nokia.tools.variant.viewer.widgets.SequenceWidget;
import com.nokia.tools.variant.viewer.widgets.SequenceWidgetItem;

/**
 * Action collapses all sequence items, but the sequence remains or is expanded.
 */
public class CollapseSequenceAction extends EditorAction {

	/**
	 * Constructor creates label and image for the action. 
	 */
	public CollapseSequenceAction() {
		setText("Collapse all");
		setImageDescriptor(PluginImages.COLLAPSE_ALL);
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.action.Action#run()
	 */
	public void run() {
		if (widget instanceof SequenceWidget) {
			SequenceWidget w = (SequenceWidget) widget;
			boolean change = false;
			if (w.isCollapsed()) {
				w.setCollapsed(false);
				change = true;
			}

			Set<SequenceWidgetItem> placedSequences = w.getPlacedSequences();
			for (SequenceWidgetItem sequenceWidgetItem : placedSequences) {

				if (!sequenceWidgetItem.isCollapsed()) {
					sequenceWidgetItem.setCollapsed(true);
					change = true;
				}

			}
			if (change) {
				Composite parent = widget.getParent();
				parent.getParent().getParent().getParent().getParent()
						.getParent().layout(true, true);
			}
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
					enable(sw);

				}

				private void enable(final SequenceWidget sw) {

					Set<Control> placedSequences = sw.getCache().keySet();
					if (placedSequences.size() < 2) {
						setEnabled(false);
						return;
					}
					if (sw.isCollapsed()) {
						setEnabled(true);
						return;
					}
					boolean b = false;
					for (Control control : placedSequences) {
						if (control instanceof SequenceWidgetItem) {
							SequenceWidgetItem sqWidget = (SequenceWidgetItem) control;
							if (!sqWidget.isCollapsed()) {
								b = true;
								break;
							}
						}
					}
					setEnabled(b);
				}
			});

		}

	}
}
