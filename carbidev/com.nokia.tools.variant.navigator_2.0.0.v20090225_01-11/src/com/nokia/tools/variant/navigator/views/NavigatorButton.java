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
 * Description: This file is part of com.nokia.tools.variant.navigator component.
 */

package com.nokia.tools.variant.navigator.views;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.ListenerList;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Widget;


public class NavigatorButton extends Item {

	private static class DisposeHandler implements DisposeListener {
		static final DisposeHandler INSTANCE = new DisposeHandler();

		public void widgetDisposed(DisposeEvent e) {
			((NavigatorButton) e.widget).handleDispose(e);
		}
	}

	private NavigatorComposite navigator;

	public NavigatorComposite getNavigator() {
		return navigator;
	}

	void handleDispose(DisposeEvent e) {
		for (NavigatorLabel child : getLabels()) {
			child.dispose();
		}
	}

	public NavigatorButton(NavigatorComposite parent) {
		super(parent, SWT.NONE);
		this.navigator = parent;
		this.labels = new ArrayList<NavigatorLabel>();
		this.listeners = new ListenerList();
		this.background = navigator.getBackground();
		this.foreground = navigator.getForeground();
		this.font = navigator.getFont();
		this.buttonDescriptionText = new MultiLineText(parent, SWT.NO_BACKGROUND);
		this.buttonDescriptionText.setHorizontalAlignment(SWT.LEFT);
		this.buttonDescriptionText.setVerticalAlignment(SWT.CENTER);
		this.buttonNameText = new MultiLineText(parent, SWT.NO_BACKGROUND);
		this.buttonNameText.setHorizontalAlignment(SWT.CENTER);
		this.buttonNameText.setVerticalAlignment(SWT.CENTER);
		this.buttonNameText.setForeground(FONT_COLOR_BOLD);

		addDisposeListener(DisposeHandler.INSTANCE);
	}

	// R224, G223, B227
	public static Color BACKGROUND_COLOR = new Color(null, 224, 223, 227);

	public static Color BORDER_SHADOW_COLOR = new Color(null, 157, 157, 161);

	public static Color BORDER_MIDDLE_COLOR = new Color(null, 200, 200, 200);

	public static Color BORDER_HIGHLIGHT_COLOR = new Color(null, 255, 255, 255);

	public static Color FONT_COLOR_BOLD = new Color(null, 51, 51, 51);

	public static int MAX_LABEL_WIDTH = 80;

	protected int collapsed_labels_to_show = 4;

	/** This image is managed externally and shall not be disposed */
	protected Image icon;
	protected String toolTipText = null;

	private MultiLineText buttonDescriptionText;
	private MultiLineText buttonNameText;
	
	protected final List<NavigatorLabel> labels;
	protected final ListenerList listeners;

	protected NavigatorLabel selectedLabel = null;

	private Color background;
	private Color foreground;
	private Font font;

	private boolean dirty;

	private boolean expanded;
	private boolean selected;
	private boolean nonExpanded;

	private int x, y, width, height;

	public void setButtonText(String text) {
		checkWidget();
		buttonNameText.setText(text);
		markDirty();
	}

	public String getButtonText() {
		checkWidget();
		return buttonNameText.getText();
	}

	public String getButtonDescription() {
		checkWidget();
		return buttonDescriptionText.getText();
	}
	
	public void setNonExpanded(boolean nonExpanded) {
		this.nonExpanded = nonExpanded;
		if (nonExpanded) {
			setExpanded(true);
		}
	}
	
	public boolean isNonExpanded() {
		return nonExpanded;
	}

	public Rectangle getBounds() {
		checkWidget();
		return new Rectangle(x, y, width, height);
	}

	public void setBounds(Rectangle bounds) {
		checkWidget();
		if (getBounds().equals(bounds)) {
			return;
		}

		this.x = bounds.x;
		this.y = bounds.y;
		this.width = bounds.width;
		this.height = bounds.height;

		layout();
	}

	private void layout() {
		buttonDescriptionText.setBounds(new Rectangle(x + MAX_LABEL_WIDTH + 5, y + 5, width - MAX_LABEL_WIDTH - 10, height - 10));;

		Rectangle bounds = new Rectangle(x + 5, y + 5, MAX_LABEL_WIDTH - 10, height-10);
		Point nameSize = buttonNameText.computeSize(MAX_LABEL_WIDTH - 10, SWT.DEFAULT);
		Rectangle iconBounds = new Rectangle(0,0,0,0);
		
		if (icon != null) {
			iconBounds = icon.getBounds();
			iconBounds.height += 5;
		}
		bounds.x = x + 5;
		bounds.y = y + (height - nameSize.y - iconBounds.height) / 2 + iconBounds.height;
		bounds.width = nameSize.x;
		bounds.height = nameSize.y;
		
		buttonNameText.setBounds(bounds);
		
		if (width <= MAX_LABEL_WIDTH) {
			// no labels
			Rectangle empty = new Rectangle(0, 0, 0, 0);
			for (NavigatorLabel label : getLabels()) {
				label.setBounds(empty);
			}
			return;
		}

		Rectangle labelBounds = new Rectangle(x + MAX_LABEL_WIDTH, y + 5, width
				- MAX_LABEL_WIDTH - 1, 0);

		for (NavigatorLabel label : getLabels()) {
			Point labelSize = label.computeSize(labelBounds.width, SWT.DEFAULT);
			labelBounds.height = labelSize.y;
			label.setBounds(labelBounds);
			labelBounds.y += labelSize.y;
		}
	}

	public Point computeSize(int wHint, int hHint) {
		checkWidget();

		int width = 0;
		int height = 0;

		if (expanded && (wHint == SWT.DEFAULT || wHint > MAX_LABEL_WIDTH)) {
			int itemWHint = wHint == SWT.DEFAULT ? SWT.DEFAULT : wHint
					- MAX_LABEL_WIDTH;

			for (NavigatorLabel item : getLabels()) {
				Point itemSize = item.computeSize(itemWHint, SWT.DEFAULT);
				width = Math.max(width, itemSize.x);
				height += itemSize.y;
			}
			width += MAX_LABEL_WIDTH;
			height += 10;

			Point size = computeLeftAreaSize(MAX_LABEL_WIDTH, hHint);
			height = Math.max(height, size.y);
		} else {
			Point descriptionSize = buttonDescriptionText.computeSize(wHint == SWT.DEFAULT ? SWT.DEFAULT : wHint - MAX_LABEL_WIDTH - 10, hHint);
			Point size = computeLeftAreaSize(wHint, hHint);
			width = size.x + descriptionSize.x;
			height = Math.max(size.y, descriptionSize.y);
		}
		if (wHint != SWT.DEFAULT) {
			width = wHint;
		}
		if (hHint != SWT.DEFAULT) {
			height = hHint;
		}

		return new Point(width, height);
	}

	private Point computeLeftAreaSize(int wHint, int hHint) {
		int width;
		int height;
		
		Point nameSize = buttonNameText.computeSize(MAX_LABEL_WIDTH - 10, hHint);
		height = nameSize.y + 10;
		if (icon != null) {
			Rectangle iconBounds = icon.getBounds();
			height += iconBounds.height + 5;
		}
		width = MAX_LABEL_WIDTH;
		
		if (wHint != SWT.DEFAULT) {
			width = wHint;
		}
		if (hHint != SWT.DEFAULT) {
			height = hHint;
		}
		return new Point(width, height);
	}

	public NavigatorLabel createLabel() {
		NavigatorLabel label = new NavigatorLabel(this);

//		if (labels.size() == 1) {
//			setSelectedLabel(label);
//		}

		layout();

		return label;
	}

	@Override
	public void dispose() {
		if (navigator.getSelectedButton() == this) {
			navigator.setSelectedWidget(null);
		}
		selectedLabel = null;
		labels.clear();
		super.dispose();
	}

	public void paintControl(PaintEvent e) {

		// border of navigator button
		// e.gc.fillRectangle(0, 0, widgetSize.x, widgetSize.y);
		GC gc = e.gc;

		Rectangle clipping = gc.getClipping();
		
		if (!clipping.intersects(getBounds())) {
			return;
		}
		
		Rectangle fill = getBounds();
		fill.intersect(clipping);
		gc.setBackground(background);
		gc.fillRectangle(fill);
		
		gc.setFont(font);
		
		if (icon != null) {
			Rectangle bounds = icon.getBounds();
			Rectangle nameBounds = buttonNameText.getBounds();
			gc.drawImage(icon, x + (MAX_LABEL_WIDTH - bounds.width) / 2, y + (height - bounds.height - nameBounds.height - 5) / 2);
		}
		
		buttonNameText.paint(gc);
		
		int x1 = x;
		int x2 = x + width - 1;
		int y1 = y;
		int y2 = y1 + height - 1;

		gc.setLineStyle(SWT.LINE_SOLID);
		gc.setLineWidth(0);
		
		gc.setForeground(BORDER_HIGHLIGHT_COLOR);
		gc.drawLine(x1, y1, x2, y1);

		gc.setForeground(BORDER_SHADOW_COLOR);
		gc.drawLine(x2, y2, x1, y2);
		gc.drawLine(x2, y1, x2, y2);
		gc.drawLine(x1, y1, x1, y2);

		if (expanded) {
			for (NavigatorLabel label: getLabels()) {
				label.paint(gc);
			}
		} else if (width > MAX_LABEL_WIDTH){
			buttonDescriptionText.paint(gc);
		}
		

	}

	public void setBackground(Color color) {
		checkWidget();
		color = (color == null ? navigator.getBackground() : color);
		background = color;
	}

	public void setForeground(Color color) {
		color = (color == null ? navigator.getForeground() : color);
		foreground = color;
		buttonDescriptionText.setForeground(color);
		// buttonNameText.setForeground(color);
	}

	public void setImage(Image image) {
		this.icon = image;
		markDirty();
	}

	void markDirty() {
		dirty = true;
	}
	
	public boolean isDirty() {
		return dirty;
	}

	public void addSelectionListener(SelectionListener listener) {
		listeners.add(listener);
	}

	public void removeSelectionListener(SelectionListener listener) {
		listeners.remove(listener);
	}

	public void mouseDoubleClick(MouseEvent e) {
	}

	public void setSelectedLabel(NavigatorLabel label) {
		checkWidget();
		if (selectedLabel != label) {
			if (selectedLabel != null) {
				selectedLabel.setSelected(false);
			}
			selectedLabel = label;
			if (selectedLabel != null) {
				selectedLabel.setSelected(true);
			}
		}
	}

	public void setSelectedLabel(int labelIdx) {
		checkWidget();
		NavigatorLabel label = labels.get(labelIdx);
		setSelectedLabel(label);
	}

	public int getSelectedLabelIndex() {
		checkWidget();
		return labels.indexOf(selectedLabel);
	}

	public NavigatorLabel getSelectedLabel() {
		checkWidget();
		return selectedLabel;
	}

	public boolean isSelected() {
		return selected;
	}
	
	public void mouseUp(MouseEvent e) {
	}

	public void setToolTipText(String string) {
		this.toolTipText = string;
	}

	public void setDescriptionText(String description) {
		checkWidget();
		buttonDescriptionText.setText(description);
	}

	public int getLabelCount() {
		return labels.size();
	}

	public boolean isExpanded() {
		if (nonExpanded)
			return true;

		return expanded;
	}

	public void setExpanded(boolean expanded) {
		checkWidget();
		if (nonExpanded) {
			return;
		}		
		if (this.expanded == expanded) {
			return;
		}
		this.expanded = expanded;
		layout();
		markDirty();
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
		Color background = selected ? NavigatorLabel.FOCUSED_COLOR
				: navigator.getBackground();
		setBackground(background);
	}

	// private Color calculateBackground() {
	// if (selected) {
	// return NavigatorLabel.FOCUSED_COLOR;
	// }
	// return getParent().getBackground();
	// };

	public NavigatorLabel[] getLabels() {
		checkWidget();
		return labels.toArray(new NavigatorLabel[labels.size()]);
	}

	public void disposeLabels() {
		checkWidget();
		for (NavigatorLabel label : getLabels()) {
			label.dispose();
		}
		selectedLabel = null;
	}

	void labelDisposed(NavigatorLabel label) {
		labels.remove(label);
	}

	void labelCreated(NavigatorLabel label) {
		labels.add(label);
	}

	public Widget getLabel(int i) {
		checkWidget();
		return labels.get(i);
	}

	public void setFont(Font font) {
		checkWidget();
		this.font = font == null ? navigator.getFont() : font;
		buttonDescriptionText.setFont(font);
	}

	public Color getBackground() {
		checkWidget();
		return background;
	}
	
	public Color getForeground() {
		checkWidget();
		return foreground;
	}
	
	public Font getFont() {
		checkWidget();
		return font;
	}
}
