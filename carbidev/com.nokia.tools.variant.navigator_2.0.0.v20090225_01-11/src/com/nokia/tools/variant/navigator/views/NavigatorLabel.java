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

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Item;


public class NavigatorLabel extends Item {
	
	private static final class DisposeHandler implements DisposeListener {
		static final DisposeHandler INSTANCE = new DisposeHandler();
		
		public void widgetDisposed(DisposeEvent e) {
			((NavigatorLabel)e.widget).handleDispose(e);
		}
	}
	

	public static Color FOCUSED_COLOR = new Color(null, 232, 242, 255);
	protected static final int LABEL_LEFT_MARGIN = 15;
	protected static final int LABEL_RIGHT_MARGIN = 15;
	protected static final int LABEL_TOP_MARGIN = 2;
	protected static final int LABEL_BOTTOM_MARGIN = 4;

	private NavigatorButton parent;
	private NavigatorComposite navigator;
	
	private Font font;
	private String labelText;
	private String tooltipText;
	private String descriptionText;
	private Image image;
	private boolean selected;
	private Color background;
	private Color foreground;
	
	private int x, y, width, height;
	
	private boolean dirty;
	
	public NavigatorLabel(NavigatorButton button) {
		super(button, SWT.NONE);
		this.parent = button;
		this.navigator = button.getNavigator();
		background = navigator.getBackground();
		foreground = navigator.getForeground();
		font = navigator.getFont();
		labelText = "";
		tooltipText = null;
		descriptionText = null;
		image = null;
		dirty = true;
		
		addDisposeListener(DisposeHandler.INSTANCE);
		
		button.labelCreated(this);
	}

	public void handleDispose(DisposeEvent e) {
		parent.labelDisposed(this);
	}

	public Font getFont() {
		return font;
	}
	
	public void setFont(Font font) {
		this.font = font;
		markDirty();
	}
	
	public void setBounds(Rectangle bounds) {
		if (bounds.equals(getBounds())) {
			return;
		}
		x = bounds.x;
		y = bounds.y;
		width = bounds.width;
		height = bounds.height;
		markDirty();
	}

	public Rectangle getBounds() {
		return new Rectangle(x,y,width,height);
	}
	
	private Color calculateBackground(boolean focused) {
		if (isSelected()) {
			return focused ? ColorConstants.darkBlue : ColorConstants.menuBackground;
		}
		return navigator.getBackground();
	};

	private Color calculateForeground(boolean focused) {
		if (isSelected()) {
			return focused ? ColorConstants.white : ColorConstants.black;
		}
		return navigator.getForeground();
	};

	public Point computeSize(int wHint, int hHint) {
		GC gc = new GC(this.navigator);
		try {
			gc.setFont(getFont());
			Point prefSize = labelText == null ? new Point(0, 0) : gc
					.textExtent(labelText);
			// prefSize.x = Math.min(128, prefSize.x);
			prefSize.x += LABEL_LEFT_MARGIN + LABEL_RIGHT_MARGIN;
			prefSize.y += LABEL_TOP_MARGIN + LABEL_BOTTOM_MARGIN;

			if (wHint != SWT.DEFAULT) {
				prefSize.x = wHint;
			}
			if (hHint != SWT.DEFAULT) {
				prefSize.y = wHint;
			}
			return prefSize;
		} finally {
			gc.dispose();
		}
	}

	public void paintControl(PaintEvent e) {
		checkWidget();
		paint(e.gc);
	}

	protected void markDirty() {
		dirty = true;
	}
	
	public boolean isDirty() {
		checkWidget();
		return dirty;
	}
	
	public void setText(String text) {
		checkWidget();
		if (this.labelText.equals(text)) {
			return;
		}
		this.labelText = text;
		markDirty();
	}

	public void setImage(Image image) {
		checkWidget();
		if (this.image == image) {
			return;
		}
		this.image = image;
		markDirty();
	}

	public void setDescriptionText(String descriptionText) {
		checkWidget();
		if (this.descriptionText == null && descriptionText == null) {
			return;
		}
		if (this.descriptionText != null && this.descriptionText.equals(descriptionText)) {
			return;
		}
		
		this.descriptionText = descriptionText;
		markDirty();
	}
	
	public void setToolTipText(String text) {
		checkWidget();
		this.tooltipText = text;
	}

	public boolean isSelected() {
		checkWidget();
		return selected;
	}

	public void setSelected(boolean selected) {
		checkWidget();
		if (this.selected != selected) {
			this.selected = selected;
			markDirty();
		}
		setBackground(calculateBackground(navigator.isFocusControl()));
		setForeground(calculateForeground(navigator.isFocusControl()));
	}

	protected void paint(GC gc) {
		dirty = false;
		Rectangle clipping = gc.getClipping();
		if (!clipping.intersects(x, y, width, height)) {
			return;
		}
		
		gc.setForeground(foreground);
		gc.setBackground(background);
		
		Rectangle fillArea = getBounds();
		fillArea.intersect(clipping);
		gc.fillRectangle(fillArea);
		
		String textToShow = labelText;
		if (textToShow != null) {
			if (gc.textExtent(textToShow).x > width - LABEL_LEFT_MARGIN
					- LABEL_RIGHT_MARGIN) {
				while (textToShow.length() > 0
						&& gc.textExtent(textToShow + "...").x > width
								- LABEL_LEFT_MARGIN - LABEL_RIGHT_MARGIN) {
					textToShow = textToShow.substring(0,
							textToShow.length() - 1);
				}
				textToShow += "...";
			}
			gc.drawText(textToShow, x + LABEL_LEFT_MARGIN, y + LABEL_TOP_MARGIN, true);
		}

		if (!this.selected) {
			gc.setForeground(ColorConstants.black);
		} else {
			gc.setForeground(ColorConstants.gray);
		}
		gc.drawLine(x, y + height - 1, x + width - 1, y + height - 1);
	}

	public NavigatorButton getButton() {
		return parent;
	}
 
	public void setBackground(Color color) {
		checkWidget();
		color = (color == null ? navigator.getBackground() : color);
		if (background == color) {
			return;
		}
		background = color;
		markDirty();
	}
	
	public void setForeground(Color color) {
		checkWidget();
		color = (color == null ? navigator.getForeground() : color);
		if (foreground == color) {
			return;
		}
		foreground = color;
		markDirty();
	}
	
	public void updateColors(boolean focused) {
		setBackground(calculateBackground(focused));
		setForeground(calculateForeground(focused));
	}

	public String getToolTipText() {
		checkWidget();
		return tooltipText;
	}
}
