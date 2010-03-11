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
 * Description: This file is part of com.nokia.tools.variant.compare.ui component.
 */

package com.nokia.tools.variant.compare.ui;

import java.util.ArrayList;

import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ITreeViewerListener;
import org.eclipse.jface.viewers.TreeExpansionEvent;
import org.eclipse.jface.window.ToolTip;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.widgets.Widget;

import com.nokia.tools.variant.compare.ICheckEnabledLabelProvider;
import com.nokia.tools.variant.compare.ITableAnnotationProvider;
import com.nokia.tools.variant.compare.ITableTooltipProvider;

public class CustomCheckedTreeViewer extends CheckboxTreeViewer {

	/**
	 * Constructor for ContainerCheckedTreeViewer.
	 * 
	 * @see CheckboxTreeViewer#CheckboxTreeViewer(Composite)
	 */
	public CustomCheckedTreeViewer(Composite parent) {
		super(parent);
		initViewer();
	}

	/**
	 * Constructor for ContainerCheckedTreeViewer.
	 * 
	 * @see CheckboxTreeViewer#CheckboxTreeViewer(Composite,int)
	 */
	public CustomCheckedTreeViewer(Composite parent, int style) {
		super(parent, style);
		initViewer();
	}

	/**
	 * Constructor for ContainerCheckedTreeViewer.
	 * 
	 * @see CheckboxTreeViewer#CheckboxTreeViewer(Tree)
	 */
	public CustomCheckedTreeViewer(Tree tree) {
		super(tree);
		initViewer();
	}

	Color tooltipBG;
	Color tooltipFG;
	Color highlightBG;

	private Image disabledCheckBox = ExtendedImageRegistry.INSTANCE
	.getImage(ImportDataUIPlugin.INSTANCE
			.getImage("disabled.bmp"));;
	private boolean updateFlags = true;

	// colors.createColor(IViewerColors.TOOLTIP_BG, new RGB(245, 245, 200));
	// colors.createColor(IViewerColors.TOOLTIP_FG, new RGB(0, 0, 0));

	private void initViewer() {
		tooltipBG = new Color(getTree().getDisplay(), new RGB(245, 245, 200));
		tooltipFG = new Color(getTree().getDisplay(), new RGB(0, 0, 0));
		highlightBG = new Color(getTree().getDisplay(), new RGB(255, 255, 200));


		getTree().addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				tooltipBG.dispose();
				tooltipFG.dispose();
				highlightBG.dispose();
				
			}
		});

		setUseHashlookup(true);
		addCheckStateListener(new ICheckStateListener() {
			public void checkStateChanged(CheckStateChangedEvent event) {
				doCheckStateChanged(event.getElement());
			}
		});
		addTreeListener(new ITreeViewerListener() {
			public void treeCollapsed(TreeExpansionEvent event) {
			}

			public void treeExpanded(TreeExpansionEvent event) {
				Widget item = findItem(event.getElement());

				if (item instanceof TreeItem) {
					initializeItem((TreeItem) item);
				}
			}
		});
		new ToolTip(getControl(), ToolTip.NO_RECREATE, false) {

			@Override
			protected Composite createToolTipContentArea(Event event,
					Composite parent) {
				Composite area = new Composite(parent, SWT.NONE);
				area.setLayout(new GridLayout());

				area.setBackground(tooltipBG);
				area.setForeground(tooltipFG);
				Label label = new Label(area, SWT.NONE);
				label.setText("Unknown");
				label.setBackground(tooltipBG);
				label.setForeground(tooltipFG);

				String text = getTooltipText(new Point(event.x, event.y));
				if (text != null) {
					label.setText(text);
				}

				//    			
				// computeShift(event,parent);

				return area;
			}

			String getTooltipText(Point p) {

				TreeItem item = getTree().getItem(p);
				if (item == null) {
					return null;
				}

				String tooltip = null;
				IBaseLabelProvider blp = getLabelProvider();

				if (blp instanceof ITableTooltipProvider) {
					int offset = 0;
					int width = 0;
					int columnIndex = -1;
					for (int idx : getTree().getColumnOrder()) {
						TreeColumn column = getTree().getColumn(idx);
						int offset2 = offset + column.getWidth();
						if (p.x >= offset && p.x < offset2) {
							columnIndex = idx;
							width = column.getWidth();
							break;
						}
						offset = offset2;
					}

					Rectangle bounds = item.getBounds();
					bounds.x += offset;
					bounds.width = width;

					tooltip = ((ITableTooltipProvider) blp).getColumnTooltip(
							item.getData(), columnIndex);
				}

				return tooltip;
			}

			@Override
			protected Object getToolTipArea(Event event) {
				Point p = new Point(event.x, event.y);

				TreeItem item = getTree().getItem(p);
				if (item == null) {
					return null;
				}

				String tooltip = null;
				IBaseLabelProvider blp = getLabelProvider();

				if (blp instanceof ITableTooltipProvider) {
					int offset = 0;
					int width = 0;
					int columnIndex = -1;
					for (int idx : getTree().getColumnOrder()) {
						TreeColumn column = getTree().getColumn(idx);
						int offset2 = offset + column.getWidth();
						if (event.x >= offset && event.x < offset2) {
							columnIndex = idx;
							width = column.getWidth();
							break;
						}
						offset = offset2;
					}

					Rectangle bounds = item.getBounds();
					bounds.x += offset;
					bounds.width = width;

					tooltip = ((ITableTooltipProvider) blp).getColumnTooltip(
							item.getData(), columnIndex);
					if (tooltip != null && tooltip.trim().length() > 0) {
						return bounds;
					}
				}
				return null;
			}
		};

		getTree().addListener(SWT.EraseItem, new Listener() {
			public void handleEvent(Event event) {
				// Gradient selection color
				if ((event.detail & SWT.SELECTED) != 0) {
					return;
				}

				// event.detail &= ~SWT.HOT;
				// if ((event.detail & SWT.SELECTED) == 0)
				// return; /* item not selected */
				// int clientWidth = getTree().getClientArea().width;
				// GC gc = event.gc;
				// Color oldForeground = gc.getForeground();
				// Color oldBackground = gc.getBackground();
				// //gc.setForeground(gc.getDevice().getSystemColor(SWT.
				// COLOR_BLACK
				// // ));
				// //gc.setBackground(gc.getDevice().getSystemColor(SWT.
				// COLOR_WHITE
				// // ));
				// gc.fillGradientRectangle(0 + clientWidth - 1, event.y,
				// -clientWidth, event.height, false);
				// gc.setForeground(oldForeground);
				// gc.setBackground(oldBackground);
				// event.detail &= ~SWT.SELECTED;
			}
		});

		getTree().addListener(SWT.MeasureItem, new Listener() {
			public void handleEvent(Event event) {
				TreeItem item = (TreeItem) event.item;
				Object data = item.getData();
				IBaseLabelProvider blp = getLabelProvider();
				if (!(blp instanceof ITableAnnotationProvider)) {
					return;
				}
				ITableAnnotationProvider prov = (ITableAnnotationProvider) blp;
				String annotation = prov.getAnnotationText(data, event.index);
				if (annotation == null) {
					return;
				}
				int colWidth = getTree().getColumn(event.index).getWidth();

				GC gc = event.gc;
				Font font = prov.getAnnotationFont(data, event.index);
				gc.setFont(font == null ? item.getFont(event.index) : font);
				Point extent = gc.textExtent(annotation + "  ");
				event.width += extent.x;
				event.width = Math.max(colWidth - 1, event.width);

			}
		});
		getTree().addListener(SWT.PaintItem, new Listener() {
			public void handleEvent(Event event) {
				TreeItem item = (TreeItem) event.item;

				// Rectangle bounds = item.getBounds();
				// if (!event.gc.getClipping().intersects(bounds)) {
				// return;
				// }

				Object data = item.getData();
				IBaseLabelProvider blp = getLabelProvider();
				if (!(blp instanceof ITableAnnotationProvider)) {
					return;
				}
				if (blp instanceof ICheckEnabledLabelProvider) {
					ICheckEnabledLabelProvider checkProvider = (ICheckEnabledLabelProvider) blp;
					if (!checkProvider.isCheckEnabled(data)) {
						redrawTreeItemCheckBox(event, disabledCheckBox);
					}
				}
				ITableAnnotationProvider prov = (ITableAnnotationProvider) blp;
				GC gc = event.gc;

				int offset = 0;
				int width = 0;
				TreeColumn column = null;
				for (int idx : getTree().getColumnOrder()) {
					column = getTree().getColumn(idx);
					width = column.getWidth();

					if (idx == event.index) {
						break;
					}

				}

				String annotation = prov.getAnnotationText(data, event.index);
				if (annotation == null) {
					return;
				}

				String text = item.getText(event.index);
				Point ext2 = gc.textExtent(text);
				int space = gc.getFontMetrics().getAverageCharWidth();

				Font font = prov.getAnnotationFont(data, event.index);
				Color foreground = prov.getAnnotationForeground(data,
						event.index);
				gc.setFont(font == null ? item.getFont(event.index) : font);
				if ((event.detail & SWT.SELECTED) == 0 && foreground != null) {
					gc.setForeground(foreground);
				} else {
					// gc.setForeground(gc.getDevice().getSystemColor(SWT.
					// COLOR_WHITE));
				}

				// gc.setBackground(tooltipBG);
				Point extent = gc.textExtent(annotation + " ");
				if (ext2.x + space + extent.x > column.getWidth()) {
					gc.drawText(" " + annotation, event.x + ext2.x + space,
							event.y + (event.height - extent.y) / 2, true);
				} else {
					gc.drawText(" " + annotation, event.x + width - extent.x,
							event.y + (event.height - extent.y) / 2, true);
				}

				offset += width;

			}
		});
	}

	/**
	 * The item has expanded. Updates the checked state of its children.
	 */
	private void initializeItem(TreeItem item) {
		boolean enabled = true;
		IBaseLabelProvider blp = getLabelProvider();
		if (blp instanceof ICheckEnabledLabelProvider) {
			ICheckEnabledLabelProvider prov = (ICheckEnabledLabelProvider) blp;
			enabled = prov.isCheckEnabled(item.getData());
		}
		if (!enabled) {
			item.setChecked(false);
			item.setGrayed(true);
		}
		if (item.getChecked() && !item.getGrayed()) {
			updateChildrenItems(item);
		}
	}

	/*
	 * (non-Javadoc) Method declared on Viewer.
	 */
	protected void preservingSelection(Runnable updateCode) {
		super.preservingSelection(updateCode);
		Object root = getRoot();
		if (root != null) {
			disable(getTree().getTopItem());
		}
	}

	protected void disable(Item item) {
		if (!(item instanceof TreeItem)) {
			return;
		}

		for (Item child : getChildren(item)) {
			disable(child);
		}

		if (!(item instanceof TreeItem)) {
			return;
		}

		boolean enabled = true;
		if (item instanceof TreeItem) {
			IBaseLabelProvider blp = getLabelProvider();
			if (blp instanceof ICheckEnabledLabelProvider) {
				ICheckEnabledLabelProvider prov = (ICheckEnabledLabelProvider) blp;
				enabled = prov.isCheckEnabled(item.getData());
			}
		}
		if (!enabled) {
			((TreeItem) item).setGrayed(true);
			((TreeItem) item).setChecked(false);
		} else {
			TreeItem ti = (TreeItem) item;
			if (ti.getParentItem() != null) {
				if (!ti.getChecked() && ti.getParentItem().getChecked()) {
					updateParentItems(ti);
				} else if (ti.getChecked() && !ti.getParentItem().getChecked()) {
					updateParentItems(ti);
				}
			}
		}
	}

	@Override
	protected void doUpdateItem(Item item, Object element) {
		super.doUpdateItem(item, element);
		if (item instanceof TreeItem) {
			boolean enabled = true;
			IBaseLabelProvider blp = getLabelProvider();
			if (blp instanceof ICheckEnabledLabelProvider) {
				ICheckEnabledLabelProvider prov = (ICheckEnabledLabelProvider) blp;
				enabled = prov.isCheckEnabled(item.getData());
				if (!enabled) {
					((TreeItem) item).setGrayed(true);
					((TreeItem) item).setChecked(false);
				} else {
					// ((TreeItem)
					// item).setChecked(prov.isChecked(item.getData()));
					// doCheckStateChanged(item.getData());
				}
			}
		}
	}

	@Override
	protected void doUpdateItem(Widget widget, Object element, boolean fullMap) {
		super.doUpdateItem(widget, element, fullMap);
		if (widget instanceof TreeItem) {
			TreeItem treeItem = (TreeItem) widget;
			boolean enabled = true;
			IBaseLabelProvider blp = getLabelProvider();
			if (blp instanceof ICheckEnabledLabelProvider) {
				ICheckEnabledLabelProvider prov = (ICheckEnabledLabelProvider) blp;
				enabled = prov.isCheckEnabled(widget.getData());
				if (!enabled) {
					((TreeItem) widget).setGrayed(true);
					((TreeItem) widget).setChecked(false);
					// } else {
					// treeItem.setChecked(prov.isChecked(widget.getData()));
				}
				prov.setChecked(treeItem.getData(), treeItem.getChecked());
			} else {
				// doCheckStateChanged(widget.getData());
			}
		}
	}

	/**
	 * Update element after a checkstate change.
	 * 
	 * @param element
	 */
	protected void doCheckStateChanged(Object element) {
		Widget item = findItem(element);
		if (item instanceof TreeItem) {
			TreeItem treeItem = (TreeItem) item;
			IBaseLabelProvider blp = getLabelProvider();
			if (blp instanceof ICheckEnabledLabelProvider) {
				ICheckEnabledLabelProvider prov = (ICheckEnabledLabelProvider) blp;
				boolean enabled = prov.isCheckEnabled(item.getData());
				if (enabled) {
					treeItem.setGrayed(false);
				} else {
					treeItem.setGrayed(true);
					treeItem.setChecked(false);

				}
				if (prov.isChecked(item.getData()) != treeItem.getChecked()) {
					prov.setChecked(item.getData(), treeItem.getChecked());
					update(element, null);
				}
			} else {
				treeItem.setGrayed(false);
			}

			updateChildrenItems(treeItem);
			updateParentItems(treeItem.getParentItem());
		}
	}

	/**
	 * Updates the check state of all created children
	 */
	private void updateChildrenItems(TreeItem parent) {
		Item[] children = getChildren(parent);
		boolean state = parent.getChecked();
		for (int i = 0; i < children.length; i++) {
			TreeItem curr = (TreeItem) children[i];
			if (curr.getData() != null) {
				IBaseLabelProvider blp = getLabelProvider();
				if (blp instanceof ICheckEnabledLabelProvider) {
					ICheckEnabledLabelProvider prov = (ICheckEnabledLabelProvider) blp;
					boolean enabled = prov.isCheckEnabled(curr.getData());
					curr.setChecked(enabled ? state : false);
					curr.setGrayed(enabled ? false : true);

					prov.setChecked(curr.getData(), curr.getChecked());
					if (curr != null && curr.getData() != null) {
						update(curr.getData(), null);
					}
				} else {
					curr.setChecked(state);
					curr.setGrayed(false);
				}

				updateChildrenItems(curr);
			}
		}
	}

	/**
	 * Updates the check / gray state of all parent items
	 */
	private void updateParentItems(TreeItem item) {
		if (item != null) {
			Item[] children = getChildren(item);
			boolean containsChecked = false;
			boolean containsUnchecked = false;

			IBaseLabelProvider blp = getLabelProvider();
			ICheckEnabledLabelProvider prov = null;
			if (blp instanceof ICheckEnabledLabelProvider) {
				prov = (ICheckEnabledLabelProvider) blp;
			}
			for (int i = 0; i < children.length; i++) {
				TreeItem curr = (TreeItem) children[i];
				boolean enabled = true;
				if (prov != null) {
					enabled = prov.isCheckEnabled(curr.getData());
				}
				if (enabled) {
					containsChecked |= curr.getChecked();
					containsUnchecked |= (!curr.getChecked() || curr
							.getGrayed());
				}
			}
			if (prov != null) {
				boolean enabled = prov.isCheckEnabled(item.getData());
				item.setChecked(enabled ? containsChecked : false);
				item.setGrayed(enabled ? !(containsChecked ^ containsUnchecked)
						: true);
				prov.setChecked(item.getData(), item.getChecked());
				update(item.getData(), null);
			} else {
				item.setChecked(containsChecked);
				item.setGrayed(!(containsChecked ^ containsUnchecked));
			}

			updateParentItems(item.getParentItem());
		}
	}

	public void updateSelectionFlags() {
		if (updateFlags) {
			Item[] children = getChildren(getTree());
			for (Item child : children) {
				TreeItem treeItem = (TreeItem) child;
				updateSelectionFlags(treeItem);
			}
		}
	}

	protected void updateSelectionFlags(TreeItem item) {
		IBaseLabelProvider blp = getLabelProvider();
		if (!(blp instanceof ICheckEnabledLabelProvider)) {
			return;
		}
		ICheckEnabledLabelProvider prov = (ICheckEnabledLabelProvider) blp;

		TreeItem[] children = item.getItems();

		boolean containsChecked = false;
		boolean containsUnchecked = false;
		boolean containsGrayed = false;

		boolean containsEnabled = false;

		for (TreeItem child : children) {
			updateSelectionFlags(child);
			boolean enabled = prov.isCheckEnabled(child.getData());
			if (enabled) {
				containsEnabled = true;
			}

			if (child.getGrayed()) {
				containsGrayed = true;
			} 
			if (child.getChecked()) {
				containsChecked = true;
			} else {
				containsUnchecked = true;
			}
		}

		Object data = item.getData();
		boolean enabled = prov.isCheckEnabled(data);

		if (!enabled) {
			item.setChecked(false);
			item.setGrayed(true);

			if (prov.isChecked(data) != false) {
				prov.setChecked(data, false);
				update(data, null);
			}
		} else {
			item.setChecked(containsChecked);
			if (children.length == 0) {
				item.setGrayed(false);
			} else {
				item.setGrayed(!containsEnabled || containsGrayed
						|| (containsChecked && containsUnchecked));
			}

			if (data != null && prov.isChecked(data) != containsChecked) {
				prov.setChecked(data, containsChecked);
				update(data, null);
			}
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.ICheckable#setChecked(java.lang.Object,
	 * boolean)
	 */
	public boolean setChecked(Object element, boolean state) {
		IBaseLabelProvider blp = getLabelProvider();
		ICheckEnabledLabelProvider prov = null;
		boolean enabled = true;
		if (blp instanceof ICheckEnabledLabelProvider) {
			prov = (ICheckEnabledLabelProvider) blp;
			enabled = prov.isCheckEnabled(element);
			if (enabled) {
				prov.setChecked(element, state);
			} else {
				prov.setChecked(element, false);
			}
			update(element, null);
		}
		if (enabled) {
			if (super.setChecked(element, state)) {
				doCheckStateChanged(element);
				return true;
			}
			return false;
		} else {
			Widget widget = internalExpand(element, false);
			if (widget instanceof TreeItem) {
				((TreeItem) widget).setChecked(false);
				((TreeItem) widget).setGrayed(true);
			}

			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.viewers.CheckboxTreeViewer#setCheckedElements(java.
	 * lang.Object[])
	 */
	public void setCheckedElements(Object[] elements) {
		super.setCheckedElements(elements);
		for (int i = 0; i < elements.length; i++) {
			doCheckStateChanged(elements[i]);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.viewers.AbstractTreeViewer#setExpanded(org.eclipse.
	 * swt.widgets.Item, boolean)
	 */
	protected void setExpanded(Item item, boolean expand) {
		super.setExpanded(item, expand);
		if (expand && item instanceof TreeItem) {
			initializeItem((TreeItem) item);
		}
		updateSelectionFlags();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.CheckboxTreeViewer#getCheckedElements()
	 */
	public Object[] getCheckedElements() {
		Object[] checked = super.getCheckedElements();
		// add all items that are children of a checked node but not created yet
		ArrayList<Object> result = new ArrayList<Object>();
		for (int i = 0; i < checked.length; i++) {
			Object curr = checked[i];
			result.add(curr);
			Widget item = findItem(curr);
			if (item != null) {
				Item[] children = getChildren(item);
				// check if contains the dummy node
				if (children.length == 1 && children[0].getData() == null) {
					// not yet created
					collectChildren(curr, result);
				}
			}
		}
		return result.toArray();
	}

	/**
	 * Recursively add the filtered children of element to the result.
	 * 
	 * @param element
	 * @param result
	 */
	@SuppressWarnings("unchecked")
	private void collectChildren(Object element, ArrayList result) {
		Object[] filteredChildren = getFilteredChildren(element);
		for (int i = 0; i < filteredChildren.length; i++) {
			Object curr = filteredChildren[i];
			result.add(curr);
			collectChildren(curr, result);
		}
	}

	public void setUpdateFlags(boolean updateFlags) {
		this.updateFlags = updateFlags;
	}

	public boolean isUpdateFlags() {
		return updateFlags;
	}

	private void redrawTreeItemCheckBox(Event event, Image image) {
		if (image != null) {
			int x = event.x - 15;// IMAGE_MARGIN;
			int itemHeight = getTree().getItemHeight();
			int imageHeight = image.getBounds().height;
			int y = event.y + 1 + (itemHeight - imageHeight) / 2;
			if (event.gc != null) {
				event.gc.drawImage(image, x, y);
			}
		}
	}

	

}
