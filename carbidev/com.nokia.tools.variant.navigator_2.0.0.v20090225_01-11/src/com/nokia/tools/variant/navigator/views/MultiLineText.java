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

import org.eclipse.core.runtime.Assert;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Item;

public class MultiLineText extends Item {

	private String[] linedText;
	private int[] linedSize;
	private Font font;
	private Color background;
	private Color foreground;
	private Control parent;
	private int lastWHint;
	private int cachedWidth;
	private int cachedHeight;
	private int lineHeight;

	/** Item bounds within the owner surface */
	private int x, y, width, height;
	/**
	 * verticalAlignment specifies how controls will be positioned vertically
	 * within a cell.
	 * 
	 * The default value is CENTER.
	 * 
	 * Possible values are:
	 * <ul>
	 * <li>SWT.BEGINNING (or SWT.TOP): Position the control at the top of the
	 * cell</li>
	 * <li>SWT.CENTER: Position the control in the vertical center of the cell</li>
	 * <li>SWT.END (or SWT.BOTTOM): Position the control at the bottom of the
	 * cell</li>
	 * <li>SWT.FILL: Resize the control to fill the cell vertically</li>
	 * </ul>
	 */
	public int verticalAlignment = SWT.CENTER;

	/**
	 * horizontalAlignment specifies how controls will be positioned
	 * horizontally within a cell.
	 * 
	 * The default value is BEGINNING.
	 * 
	 * Possible values are:
	 * <ul>
	 * <li>SWT.BEGINNING (or SWT.LEFT): Position the control at the left of the
	 * cell</li>
	 * <li>SWT.CENTER: Position the control in the horizontal center of the cell
	 * </li>
	 * <li>SWT.END (or SWT.RIGHT): Position the control at the right of the cell
	 * </li>
	 * <li>SWT.FILL: Resize the control to fill the cell horizontally</li>
	 * </ul>
	 */
	private int horizontalAlignment = SWT.BEGINNING;

	public MultiLineText(Control parent, int style) {
		super(parent, style);
		this.parent = parent;
		this.linedText = null;
		this.linedSize = null;
		this.font = parent.getFont();
		this.cachedHeight = SWT.DEFAULT;
		this.cachedWidth = SWT.DEFAULT;
		this.background = parent.getBackground();
		this.foreground = parent.getForeground();
	}

	public void setHorizontalAlignment(int alignment) {
		checkWidget();
		this.horizontalAlignment = alignment;
	}

	public void setVerticalAlignment(int alignment) {
		checkWidget();
		this.verticalAlignment = alignment;
	}

	public int getHorizontalAlignment() {
		checkWidget();
		return horizontalAlignment;
	}

	public int getVerticalAlignment() {
		checkWidget();
		return verticalAlignment;
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

		boolean reset = true;
		if (this.width == bounds.width && this.height == bounds.height) {
			return;
		} else {
		}

		this.width = bounds.width;
		this.height = bounds.height;

		if (reset) {
			cachedHeight = SWT.DEFAULT;
			cachedWidth = SWT.DEFAULT;
			lastWHint = width;
			linedSize = null;
			linedText = null;
			
			computeCaches();
		}

	}

	public void paint(GC gc) {
		Rectangle clipping = gc.getClipping();
		Rectangle bounds = getBounds();
		if (!clipping.intersects(bounds) || bounds.isEmpty()) {
			return;
		}
		gc.setFont(font);

		if (lastWHint == SWT.DEFAULT) {
			lastWHint = width;
		}
		computeCaches();

		int lineOffset;
		if (verticalAlignment == SWT.BEGINNING || verticalAlignment == SWT.TOP) {
			lineOffset = y;
		} else if (verticalAlignment == SWT.CENTER) {
			lineOffset = y + (height - cachedHeight) / 2;
		} else if (verticalAlignment == SWT.END
				|| verticalAlignment == SWT.BOTTOM) {
			lineOffset = y + height - cachedHeight;
		} else {
			lineOffset = y;
		}

		boolean tranparent = (getStyle() & SWT.NO_BACKGROUND) != 0;
		gc.setBackground(background);
		gc.setForeground(foreground);

		for (int i = 0; i < linedText.length; i++) {
			String text = linedText[i];
			int length = linedSize[i];

			int xOffset;
			if (horizontalAlignment == SWT.BEGINNING || horizontalAlignment == SWT.LEFT) {
				xOffset = x;
			} else if (horizontalAlignment == SWT.END || horizontalAlignment == SWT.RIGHT) {
				xOffset = x + width - length;
			} else if (horizontalAlignment == SWT.CENTER) {
				xOffset = x + (width - length) / 2;
			} else {
				xOffset = x;
			}
			
			gc.drawString(text, xOffset, lineOffset,
					tranparent);

			lineOffset += lineHeight;
		}

	}

	public void setForeground(Color foreground) {
		checkWidget();
		Assert.isNotNull(foreground);
		this.foreground = foreground;
	}
	
	public void setFont(Font font) {
		checkWidget();
		if (this.font != font) {
			this.font = font;
			linedSize = null;
			linedText = null;
			lineHeight = SWT.DEFAULT;
		}
	}

	@Override
	public void setText(String text) {
		checkWidget();
		if (!getText().equals(text)) {
			super.setText(text);
			linedSize = null;
			linedText = null;
		}
	}

	public Point computeSize(int wHint, int hHint) {
		checkWidget();
		int width = 0;
		int height = 0;

		if (lastWHint == wHint && linedText != null) {
		} else if (wHint == SWT.DEFAULT) {
			lastWHint = SWT.DEFAULT;
			linedText = null;
			computeCaches();
			lastWHint = cachedWidth;
		} else {
			lastWHint = wHint;
			linedText = null;
			computeCaches();
		}
		width = cachedWidth;
		height = cachedHeight;
		if (wHint != SWT.DEFAULT) {
			width = wHint;
		}
		if (hHint != SWT.DEFAULT) {
			height = hHint;
		}

		return new Point(width, height);
	}

	private void computeCaches() {
		if (linedText != null) {
			return;
		}
		
		GC gc = new GC(parent);

		gc.setFont(font);
		lineHeight = gc.getFontMetrics().getHeight();
		cachedHeight = cachedWidth = 0;

		if (lastWHint == SWT.DEFAULT) {

			String[] lines = getText().split("\\n");
			linedText = lines;
			linedSize = new int[lines.length];

			for (int i = 0; i < lines.length; i++) {
				String line = lines[i];
				Point size = gc.stringExtent(line);
				cachedWidth = Math.max(cachedWidth, size.x);
				cachedHeight += size.y;
				linedSize[i] = size.x;
			}

		} else {
			String[] lines = getText().split("\\n");
			List<String> lineArray = new ArrayList<String>(lines.length * 2);
			List<Integer> sizeArray = new ArrayList<Integer>(lines.length * 2);

			for (String line : lines) {
				String[] parts = line.split("\\s+");
				int spaceWidth = gc.textExtent(" ", SWT.DRAW_TRANSPARENT
						| SWT.DRAW_DELIMITER).x;
				StringBuilder result = new StringBuilder();
				int lineLenth = 0;

				for (String part : parts) {
					Point partSize = gc.stringExtent(part);
					if (lineLenth == 0) {
						// first word - place as is
						result.append(part);
						lineLenth = partSize.x;
					} else if (lineLenth + partSize.x + spaceWidth < lastWHint) {
						result.append(' ');
						result.append(part);
						lineLenth += partSize.x + spaceWidth;
					} else {
						lineArray.add(result.toString());
						sizeArray.add(lineLenth);
						cachedHeight += lineHeight;
						cachedWidth = Math.max(cachedWidth, lineLenth);
						result.setLength(0);
						result.append(part);
						lineLenth = partSize.x;
					}
				}
				if (result.length() > 0 || parts.length == 0) {
					lineArray.add(result.toString());
					sizeArray.add(lineLenth);
					cachedHeight += lineHeight;
					cachedWidth = Math.max(cachedWidth, lineLenth);
				}
			}
			
			this.linedText = lineArray.toArray(new String[lineArray.size()]);
			this.linedSize = new int[sizeArray.size()];
			for (int i = 0; i < sizeArray.size(); i++) {
				this.linedSize[i] = sizeArray.get(i);
			}
		}
		gc.dispose();
	}
}
