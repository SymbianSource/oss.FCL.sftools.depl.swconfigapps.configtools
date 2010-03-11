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
 * Description: This file is part of com.nokia.tools.variant.preview.theme component.
 */

package com.nokia.tools.variant.preview.theme;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.jface.util.SafeRunnable;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

public class ImageGallery extends Composite implements ISelectionProvider {

	private List<Thumbnail> images;
	private Thumbnail selected;

	private int borderWidth = 3;
	private Point imageSize = new Point(64, 64);
	private ILabelProvider labelProvider;

	class Thumbnail extends Canvas implements PaintListener {
		int index;
		private MouseListener thumbnailMouseListener;

		public Thumbnail(int idx) {
			super(ImageGallery.this, SWT.NONE);
			this.index = idx;
			// RowData rowData = new RowData(imageSize.x + borderWidth * 2,
			// imageSize.y + borderWidth * 2);
			// setLayoutData(rowData);
			addPaintListener(this);
			thumbnailMouseListener = new MouseListener() {

				public void mouseDoubleClick(MouseEvent e) {
				}

				public void mouseDown(MouseEvent e) {
					selectImage(Thumbnail.this);
					ImageGallery.this.setFocus();
				}

				public void mouseUp(MouseEvent e) {
				}

			};
			addMouseListener(thumbnailMouseListener);

			setBackground(getParent().getBackground());
		}

		@Override
		public Point computeSize(int wHint, int hHint, boolean changed) {
			Point size = new Point(imageSize.x + borderWidth * 2, imageSize.y
					+ borderWidth * 2);
			if (wHint != SWT.DEFAULT) {
				size.x = wHint;
			}
			if (hHint != SWT.DEFAULT) {
				size.y = hHint;
			}
			return size;
		}

		@Override
		public void setData(Object data) {
			super.setData(data);
			String tooltip = labelProvider.getText(data);
			if (tooltip != null) {
				setToolTipText(tooltip);
			}
		}

		public void paintControl(PaintEvent e) {
			paintImage(this, e.gc);
		}

		@Override
		public boolean setFocus() {
			return false;
		}

		@Override
		public void dispose() {
			removePaintListener(this);
			removeMouseListener(thumbnailMouseListener);
			thumbnailMouseListener = null;
			super.dispose();
		}

	}

	boolean inFocus;
	private KeyListener galleryKeyListener;
	private Listener galleryResizeListener;

	public ImageGallery(Composite parent, int style,
			ILabelProvider labelProvider) {
		super(parent, style);
		this.labelProvider = labelProvider;
		images = new ArrayList<Thumbnail>();
		RowLayout layout = new RowLayout(SWT.HORIZONTAL);
		layout.marginBottom = 0;
		layout.marginTop = 0;
		layout.marginLeft = 0;
		layout.marginRight = 0;
		setLayout(layout);
		selected = null;
		setBackground(parent.getBackground());
		addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				inFocus = true;
				if (selected != null) {
					selected.redraw();
				}
			}

			public void focusLost(FocusEvent e) {
				inFocus = false;
				if (selected != null) {
					selected.redraw();
				}
			};
		});
		galleryKeyListener = new KeyListener() {
			public void keyPressed(KeyEvent e) {
				int index = images.indexOf(selected);

				if (e.keyCode == SWT.ARROW_LEFT && e.stateMask == 0) {
					if (index > 0 && images.size() > 0) {
						selectImage(images.get(index - 1));
					}
				} else if (e.keyCode == SWT.ARROW_RIGHT && e.stateMask == 0) {
					if (index >= 0 && index < images.size() - 1) {
						selectImage(images.get(index + 1));
					}
				} else if (e.keyCode == SWT.HOME && e.stateMask == 0) {
					if (images.size() > 0) {
						selectImage(images.get(0));
					}
				} else if (e.keyCode == SWT.END && e.stateMask == 0) {
					if (images.size() > 0) {
						selectImage(images.get(images.size() - 1));
					}
				}
			}

			public void keyReleased(KeyEvent e) {
			}
		};
		addKeyListener(galleryKeyListener);
		galleryResizeListener = new Listener() {
			public void handleEvent(Event event) {
				if (images.size() > 0) {
					calculateImageSize(images.get(0).getData());
				} else {
					calculateImageSize(null);
				}
				layout(true);
			}
		};
		addListener(SWT.Resize, galleryResizeListener);
	}

	@Override
	public Point computeSize(int wHint, int hHint) {
		// return super.computeSize(hint, imageSize.y + borderWidth * 2);
		return super.computeSize(wHint, hHint);
	}

	@Override
	public Point computeSize(int wHint, int hHint, boolean changed) {
		/*
		 * int width = images.size() (imageSize.x + borderWidth 2); int height =
		 * imageSize.y + borderWidth 2;
		 * 
		 * if (wHint != SWT.DEFAULT) { width = wHint; } if (hHint !=
		 * SWT.DEFAULT) { height = hHint; }
		 */

		return super.computeSize(wHint, hHint, changed);
		// return new Point(width, height);
	}

	protected void paintImage(Thumbnail widget, GC gc) {
		Image image = labelProvider.getImage(widget.getData());

		Rectangle area = widget.getClientArea();
		Rectangle ib = image.getBounds();
		gc.drawImage(image, 0, 0, ib.width, ib.height, area.x + borderWidth,
				area.y + borderWidth, area.width - borderWidth * 2, area.height
						- borderWidth * 2);

		if (widget == selected) {
			Color color;
			if (isFocusControl()) {
				color = ColorConstants.darkBlue;
			} else {
				color = ColorConstants.blue;
			}
			gc.setForeground(color);
			for (int i = 0; i < borderWidth; i++) {
				gc.drawRectangle(area.x + i, area.y + i,
						area.width - i - i - 1, area.height - i - i - 1);
			}
		}

	}

	@Override
	public boolean setFocus() {
		return super.setFocus();
	}

	public void addUserObject(Object userObject) {
		if (userObject == null) {
			throw new NullPointerException();
		}

		final int index = images.size();
		if (index == 0) {
			calculateImageSize(userObject);
		}
		Thumbnail item = new Thumbnail(index);
		item.setData(userObject);
		// RowData rowData = new RowData(imageSize.x + borderWidth * 2,
		// imageSize.y + borderWidth * 2);
		// item.setLayoutData(rowData);
		images.add(item);

		// Point size = computeSize(SWT.DEFAULT, getSize().y, true);
		// setSize(size);
		// layout(new Control[]{item});
		layout(true, true);
		if (index == 0) {
			selectImage(item);
		}
		redraw();
	}

	private void calculateImageSize(Object userObject) {
		Image tmp = null;
		if (userObject != null) {
			tmp = labelProvider.getImage(userObject);
		}
		if (tmp != null) {
			Rectangle bounds = tmp.getBounds();
			int caHeight = getClientArea().height - borderWidth * 2;

			// double sfWidth = (double)bounds.width / caHeight;
			double sfHeight = (double) bounds.height / caHeight;
			int width = (int) Math.round(bounds.width / sfHeight);
			int height = (int) Math.round(bounds.height / sfHeight);
			imageSize = new Point(width, height);
		} else {
			imageSize = new Point(64, 64);
		}

		// for (Thumbnail thumb: images) {
		// RowData rowData = new RowData(imageSize.x + borderWidth * 2,
		// imageSize.y + borderWidth * 2);
		// thumb.setLayoutData(rowData);
		// }
	}

	@Override
	public void dispose() {
		cleanup();
		removeListener(SWT.Resize, galleryResizeListener);
		galleryResizeListener = null;
		removeKeyListener(galleryKeyListener);
		galleryKeyListener = null;
		images = null;
		listeners.clear();
		listeners = null;
		super.dispose();
	}

	public void cleanup() {
		selected = null;
		for (Thumbnail thumbnail : images) {
			thumbnail.dispose();
		}
		images.clear();

		for (Control child : getChildren()) {
			if (child != null && !child.isDisposed()) {
				child.dispose();
			}
		}
	}

	public void selectImage(Thumbnail widget) {
		if (selected == widget) {
			return;
		}
		Thumbnail oldSelected = selected;
		selected = widget;
		if (selected != null) {
			selected.redraw();
		}
		if (oldSelected != null) {
			oldSelected.redraw();
		}
		notifySelectionChanged();
	}

	public ISelection getSelection() {
		if (selected == null) {
			return StructuredSelection.EMPTY;
		} else {
			return new StructuredSelection(selected.getData());
		}
	}

	public void setSelection(ISelection selection) {
		Object first = null;
		if (selection instanceof IStructuredSelection) {
			first = ((IStructuredSelection) selection).getFirstElement();
		}
		if (first == null) {
			selectImage(null);
			return;
		}
		for (Thumbnail widget : images) {
			if (widget.getData().equals(first)) {
				selectImage(widget);
				return;
			}
		}
		selectImage(null);
	}

	List<ISelectionChangedListener> listeners = new ArrayList<ISelectionChangedListener>();

	public void addSelectionChangedListener(ISelectionChangedListener listener) {
		listeners.add(listener);
	}

	public Thumbnail getSelected() {
		return selected;
	}

	public void removeSelectionChangedListener(
			ISelectionChangedListener listener) {
		listeners.remove(listener);
	}

	protected void notifySelectionChanged() {
		final SelectionChangedEvent event = new SelectionChangedEvent(this,
				getSelection());
		ISelectionChangedListener[] copy = listeners
				.toArray(new ISelectionChangedListener[listeners.size()]);
		for (final ISelectionChangedListener listener : copy) {
			SafeRunner.run(new SafeRunnable() {
				public void run() throws Exception {
					listener.selectionChanged(event);
				}
			});
		}
	}
}
