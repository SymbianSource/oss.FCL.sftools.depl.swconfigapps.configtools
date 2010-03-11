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
 * Description: This file is part of com.nokia.tools.variant.viewer component.
 */

package com.nokia.tools.variant.viewer.widgets;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Listener;

import com.nokia.tools.variant.common.ui.utils.SWTUtil;
import com.nokia.tools.variant.viewer.listeners.EditorDropEffect;

/**
 * Widget graphically represents sequence setting. It is container for sequence
 * items.
 */
public class SequenceWidget extends BaseConfMLWidget implements Listener {

	Canvas leftControl;
	boolean hide = true;
	boolean resized;
	public static final int LEFT_CONTROL_WIDTH = 16;
	public static final int SEPARATOR_HEIGHT = 2;
	Map<Control, Composite> separators = new LinkedHashMap<Control, Composite>();
	Set<Control> placed = new HashSet<Control>();
	Set<SequenceWidgetItem> placedS = new HashSet<SequenceWidgetItem>();
	static int[] twistieExpanded, twistieCollapsed;
	boolean changed = false;
	Set<Listener> resizeListeners = new LinkedHashSet<Listener>();

	public Map<Control, Composite> getSeparators() {
		return separators;
	}

	Map<Control, Point> cache = new LinkedHashMap<Control, Point>();

	public Map<Control, Point> getCache() {
		return cache;
	}

	List<SequenceWidgetItem> notChangeItems = new ArrayList<SequenceWidgetItem>();

	Listener selectionListener;
	DropTarget leftControlDropTarget;
	DragSource leftControlDragSource;
	public boolean pDirty;
	public boolean pError;
	protected int offset;
	public PropertyChangeListener itemPropertyListener;
	private Listener collapseListener;
	// Sequence does not have note
	// public boolean pNote;
	private PaintListener twistiePaintListener;
	private EditorDropEffect dropEffect;

	static final int[] onPoints = { 0, 2, 8, 2, 4, 6 };
	static final int[] offPoints = { 2, -1, 2, 8, 6, 4 };

	public SequenceWidget(Composite parent, int style) {
		super(parent, style);
		createControl(style);
	}

	public SequenceWidget(Composite parent, int style, String widgetLabel) {
		super(parent, style, widgetLabel);
		createControl(style);
	}

	private void createControl(int style) {
		itemPropertyListener = new ItemPropertyListener();
		super.setLayout(new SequenceLayout());

		leftControl = new Canvas(this, style);
		leftControl.setData(SequenceWidget.this);
		leftControl.setBackground(getBackground());
		leftControl.setSize(20, 20);
		collapseListener = new Listener() {

			public void handleEvent(Event event) {
				if (placedS.size() > 0) {
					if (event.type == SWT.MouseDown) {
						hide = !hide;
						setCollapsed();
						Composite parent = getParent();
						parent.getParent().getParent().getParent().getParent()
								.getParent().layout(true, true);
					}
				}
			}
		};

		leftControl.addListener(SWT.MouseDown, collapseListener);
		twistiePaintListener = new PaintListener() {

			public void paintControl(PaintEvent e) {
				paintTwistie(e.gc);
			}
		};

		int x = LEFT_CONTROL_WIDTH / 2;
		twistieCollapsed = translate(offPoints, x, 12);
		twistieExpanded = translate(onPoints, x, 12);
		
		leftControl.addPaintListener(twistiePaintListener);
		leftControl.addDisposeListener(new DisposeListener() {

			public void widgetDisposed(DisposeEvent e) {
				leftControl.removeListener(SWT.MouseDown, collapseListener);
				collapseListener = null;
				leftControl.removePaintListener(twistiePaintListener);
				twistiePaintListener = null;
				leftControl.removeDisposeListener(this);
			}
		});

	}

	public void addExpandListener(Listener listener) {
		resizeListeners.add(listener);
	}

	public void removeExpandListener(Listener listener) {
		resizeListeners.remove(listener);
	}

	public Set<Listener> getExpandListeners() {
		return resizeListeners;
	}

	private class SequenceLayout extends Layout {

		private int separatorsCount;

		@Override
		protected Point computeSize(Composite composite, int wHint, int hHint,
				boolean flushCache) {

			Control[] children = composite.getChildren();
			Point s = new Point(0, 0);
			separatorsCount = 0;

			for (int i = 0; i < children.length; i++) {

				Control control = children[i];
				// skip additional row composites
				Object data = control.getData();
				if (data != null
						&& (data.equals("pRow") || (data.equals("separator")))) {
					continue;
				}
				// skip separators - due some post computing
				// separator count must be solved before they are added

				if (control != leftControl) {
					Point controlSize = control.computeSize(SWT.DEFAULT,
							SWT.DEFAULT);

					if (checkChanged(control, controlSize)) {
						cache.put(control, controlSize);
						changed = true;
					}

					if (s.x < controlSize.x) {
						s.x = controlSize.x;
					}
					if (control == label || !(hide && i > 1)) {
						s.y += controlSize.y;
					}

				}
				if (control instanceof SequenceWidgetItem) {
					separatorsCount++;
				}
			}
			// count with separators
			if (cache.size() > 1) {
				if (!hide) {
					s.y += (++separatorsCount) * SEPARATOR_HEIGHT;
				}
			}
			s.x += LEFT_CONTROL_WIDTH;

			return s;
		}

		private boolean checkChanged(Control control, Point controlSize) {
			Point point = cache.get(control);
			if (point == null) {
				return true;
			}
			// return controlSize.y != point.y;
			return !point.equals(controlSize);

		}

		@Override
		protected void layout(Composite composite, boolean flushCache) {

			if (!changed && placed.size() + placedS.size() == cache.size()) {
				showEDNComposites(SequenceWidget.this, getSize());
				return;
			}
			Rectangle cArea = composite.getClientArea();

			Point lCSize = leftControl.computeSize(SWT.DEFAULT, SWT.DEFAULT,
					flushCache);
			lCSize.x = LEFT_CONTROL_WIDTH;
			lCSize.y = -1;
			int y = 0;

			boolean localDirty = false, error = false, note = false;
			Object[] controls = cache.keySet().toArray();
			for (int i = 0; i < controls.length; i++) {
				Control control = (Control) controls[i];
				// if (placed.contains(control)){continue;}
				y = resizeControl(cArea, lCSize.x, y, i, control, flushCache);
				if (lCSize.y == -1 && y > 0) {
					lCSize.y = y;
				}

				Composite separator = separators.get(control);
				if (separator == null && controls.length > 1) {
					separator = new Composite(SequenceWidget.this, SWT.BORDER);
					separator
							.setBackground(SequenceWidget.this.getBackground());
					separators.put(control, separator);
					separator.setData("separator");
				}

				if (separator != null) {
					int height = (hide) ? 0 : SEPARATOR_HEIGHT;
					separator.setBounds(0, y, cArea.width, height);
					separator.setSize(cArea.width, height);
					separator.setLocation(0, y);
					y += height;
				}

				if (control instanceof BaseConfMLWidget) {
					BaseConfMLWidget subWidget = (BaseConfMLWidget) control;
					// solve markers
					if (subWidget.isDirtyPropagated()
							|| (subWidget.isDirty() && !localDirty)) {
						localDirty = true;
					}
					if (subWidget.isErrorPropagated()
							|| (subWidget.hasError() && !error)) {
						error = true;
					}
					if (subWidget.isNotePropagated()
							|| (subWidget.hasNote() && !note)) {
						note = true;
					}
				}

			}

			if (lCSize.y != -1) {
				leftControl.setSize(lCSize);
			}
			leftControl.setLocation(0, 0);
			getRowComposites().add(leftControl);

			// populateMarkers(firstControl, localDirty, error, note);
			moveEDNComposites();
			changed = false;
			errorComposite.getParent().getParent().layout(true, true);
			errorComposite.redraw();
			noteComposite.redraw();
			dirtyComposite.redraw();
		}

		private int resizeControl(Rectangle cArea, int lCSizeX, int y, int i,
				Control control, boolean flushCache) {

			Point controlSize = null;
			if (flushCache || resized) {
				resized = false;
				controlSize = control.computeSize(SWT.DEFAULT, SWT.DEFAULT);
			} else {
				controlSize = cache.get(control);
				if (placed.contains(control)) {
					if (hide && y > 0) {
						// hideEDNComposites(control, controlSize);
						return y;
					} else {
						// showEDNComposites(control, controlSize);
						return controlSize.y + y;
					}
				}
			}

			controlSize.x = (y == 0) ? cArea.width - 2 * lCSizeX : cArea.width;
			SequenceWidget sWidget = null;
			if (control.getParent() instanceof SequenceWidget) {
				sWidget = (SequenceWidget) control.getParent();
				if (sWidget != null
						&& sWidget.getParent() instanceof SequenceWidget) {
					sWidget = (SequenceWidget) sWidget.getParent();
				}
			}
			// Hide
			if (hide && i > 0) {
				// control.setBounds(lCSize.x, 0, controlSize.x, 0);
				// control.setLocation(lCSize.x, 0);
				// control.setSize(controlSize.x, 0);
				// hideEDNComposites(control, controlSize);
			} else if (sWidget != null && !sWidget.hide) {
				// control.setBounds(lCSize.x, y, lCSize.x, controlSize.y);
				control.setSize(controlSize.x, controlSize.y);
				control.setLocation((y == 0) ? 2 * lCSizeX : 0, y);
				// showEDNComposites(control, controlSize);
				y += controlSize.y;
			} else {
				control.setSize(controlSize.x, controlSize.y);
				control.setLocation((y == 0) ? 2 * lCSizeX : 0, y);
				// hideEDNComposites(control, controlSize);
			}

			if (controlSize.x > 0 && controlSize.y > 0) {

				if (control instanceof SequenceWidgetItem) {
					SequenceWidgetItem swi = (SequenceWidgetItem) control;
					placedS.add(swi);
					swi.addPropertyChangeListener(itemPropertyListener);
				} else {
					placed.add(control);
				}
			}
			return y;
		}

	}

	@Override
	public String toString() {
		if (label == null) {
			return super.toString();
		} else {
			return super.toString().concat(label.getText());
		}
	}

	protected void paintTwistie(GC gc) {
		// gc
		// .setForeground(leftControl.getDisplay().getSystemColor(
		// SWT.COLOR_RED));
		if (placedS.size() > 0) {
			gc.setBackground(Display.getCurrent().getSystemColor(
					SWT.COLOR_BLACK));
		} else {
			gc.setBackground(Display.getCurrent().getSystemColor(
					SWT.COLOR_DARK_GRAY));
		}

		if (!hide || placedS.size() == 0)
			gc.fillPolygon(twistieExpanded);
		else
			gc.fillPolygon(twistieCollapsed);

	}

	private int[] translate(int[] data, int x, int y) {
		int[] target = new int[data.length];
		for (int i = 0; i < data.length; i += 2) {
			target[i] = data[i] + x;
		}
		for (int i = 1; i < data.length; i += 2) {
			target[i] = data[i] + y;
		}
		return target;
	}

	@Override
	public void addListener(Listener listener) {
		selectionListener = listener;
		leftControl.addListener(SWT.MouseDown, selectionListener);
		super.addListener(listener);
	}

	@Override
	protected void buildMainControl() {
	}

	@Override
	public void clearErrorMessage() {

	}

	@Override
	public String getValue() {
		return null;
	}

	@Override
	public void setValue(String value) {
		// do nothing
	}

	@Override
	public void buildWidget(Composite composite, String widgetLabel) {
		setBackground(composite.getBackground());
		super.buildWidget(composite, widgetLabel);
	}

	public boolean isCollapsed() {
		return hide;
	}

	public void setCollapsed(boolean hide) {
		if (hide != this.hide) {
			this.hide = hide;
			setCollapsed();
			leftControl.redraw();
		}
	}

	private void setCollapsed() {
		if (hide) {
			// showComponents(false);
			propagateDirty(pDirty);
			propagateError(pError);
			// propagateNote(pNote);
		} else {
			// showComponents(true);
			propagateDirty(false);
			propagateError(false);
			// propagateNote(false);
		}
	}

	@Override
	public void setLayout(Layout layout) {
		checkWidget();
	}

	@Override
	public void addDragListener(DragSourceListener listener) {
		if (leftControl != null) {
			if (leftControlDragSource == null) {
				leftControlDragSource = initDragSource(leftControl);
			}
			leftControlDragSource.addDragListener(listener);
		}
		super.addDragListener(listener);
	}

	@Override
	public void addDropListener(DropTargetListener listener) {
		if (leftControl != null) {
			if (leftControlDropTarget == null) {
				leftControlDropTarget = initDropTarget(leftControl);
			}
			leftControlDropTarget.addDropListener(listener);
			leftControlDropTarget.addDisposeListener(new DisposeListener() {

				public void widgetDisposed(DisposeEvent e) {
					leftControlDropTarget.setDropTargetEffect(null);
					leftControlDropTarget.removeDisposeListener(this);
					dropEffect = null;
				}
			});

			if (dropEffect == null) {
				dropEffect = new EditorDropEffect(leftControl, getRuler());
			}
			leftControlDropTarget.setDropTargetEffect(dropEffect);
		}
		super.addDropListener(listener);
	}

	private class ItemPropertyListener implements PropertyChangeListener {

		// private BaseConfMLWidget widget;
		public ItemPropertyListener() {
			// this.widget = widget;
		}

		public void propertyChange(PropertyChangeEvent evt) {
			String propertyName = evt.getPropertyName();
			Boolean newValue = (Boolean) evt.getNewValue();
			boolean temp = false;
			if (propertyName.equals(BaseConfMLWidget.PROPERTY_PROPAGATE_DIRTY)) {
				if (newValue) {
					pDirty = true;
					if (hide) {
						propagateDirty(true);
					}
				} else {
					for (Control control : placedS) {
						if (control instanceof SequenceWidgetItem) {
							if (((SequenceWidgetItem) control)
									.isDirtyPropagated()) {
								temp = true;
							}
						}
					}
					pDirty = temp;
				}
			} else if (propertyName
					.equals(BaseConfMLWidget.PROPERTY_PROPAGATE_ERROR)) {
				if (newValue) {
					pError = true;
					if (hide) {
						propagateError(true);
					}
				} else {
					for (Control control : placedS) {
						if (control instanceof SequenceWidgetItem) {
							if (((SequenceWidgetItem) control)
									.isErrorPropagated()) {
								temp = true;
							}
						}
					}
					pError = temp;
				}
			}

		}

	}

	private void showEDNComposites(Control control, Point controlSize) {

		if (control instanceof BaseConfMLWidget
				&& !(control instanceof SequenceWidgetItem)) {
			BaseConfMLWidget widget = (BaseConfMLWidget) control;

			Composite comp = widget.getErrorComposite();
			Point controlLoc = control.getLocation();
			Point dispLoc = control.toDisplay(controlLoc);
			dispLoc.y -= controlLoc.y;

			if (comp != null) {
				// Composite parent = comp.getParent();
				// Point location = comp.getLocation();
				// Point newLoc = parent.toControl(dispLoc);
				// location.y = newLoc.y;
				// comp.setLocation(location);
				comp.setVisible(true);
			}

			comp = widget.getDirtyComposite();

			if (comp != null) {
				// Composite parent = comp.getParent();
				// Point location = comp.getLocation();
				// Point newLoc = parent.toControl(dispLoc);
				// location.y = newLoc.y;
				// comp.setLocation(location);
				comp.setVisible(true);
			}
			comp = widget.getNoteComposite();

			if (comp != null) {
				// Composite parent = comp.getParent();
				// Point location = comp.getLocation();
				// Point newLoc = parent.toControl(dispLoc);
				// location.y = newLoc.y;
				// comp.setLocation(location);
				comp.setVisible(true);
			}
		}
	}

	public Set<SequenceWidgetItem> getPlacedSequences() {
		return placedS;
	}

	public void handleEvent(Event event) {
		// HeightChangeEvent e = (HeightChangeEvent) event;
		// System.out.println(e+" "+e.getChanged());
		// BaseConfMLWidget source = e.getSource();
	}

	private void moveEDNComposites() {
		for (SequenceWidgetItem item : placedS) {
			int locationOnRuler = SWTUtil.getControlLocation(item.getRuler()
					.getScrolledComposite(), item).y;
			// getRulerCoordinates(item, item.getRuler()
			// .getScrolledComposite());
			Control[] array = item.placed.toArray(new Control[item.placed
					.size()]);
			for (int i = 0; i < array.length; i++) {
				Control control = array[i];
				if (control instanceof BaseConfMLWidget
						&& !control.isDisposed()) {
					BaseConfMLWidget widget = (BaseConfMLWidget) control;
					Composite comp = widget.getErrorComposite();
					relocate(item, locationOnRuler, i, comp);
					comp = widget.getNoteComposite();
					relocate(item, locationOnRuler, i, comp);
					comp = widget.getDirtyComposite();
					relocate(item, locationOnRuler, i, comp);
				}
				locationOnRuler += control.getSize().y;
			}
		}
	}

	private void relocate(SequenceWidgetItem item, int locationOnRuler, int i,
			Composite comp) {
		if (comp != null) {
			comp.setLocation(-1, locationOnRuler);
			if (item.isCollapsed() && i > 0) {
				comp.setVisible(false);
			}
		}
	}

	@Override
	public void dispose() {
		if (leftControlDragSource != null) {
			DragSourceListener[] dragListeners = leftControlDragSource
					.getDragListeners();
			for (int i = 0; i < dragListeners.length; i++) {
				leftControlDragSource.removeDragListener(dragListeners[i]);
			}
		}
		if (leftControlDropTarget != null) {
			DropTargetListener[] dropListeners = leftControlDropTarget
					.getDropListeners();
			for (int i = 0; i < dropListeners.length; i++) {
				leftControlDropTarget.removeDropListener(dropListeners[i]);
			}
		}if(!leftControl.isDisposed()){
			leftControl.removeListener(SWT.MouseDown, selectionListener);
		}
		itemPropertyListener = null;
		resizeListeners.clear();
		separators.clear();
		placed.clear();
		placedS.clear();
		cache.clear();
		super.dispose();
	}

	protected void buildControlContainer(Composite composite) {
		group = new Composite(composite, SWT.NONE);
		group.setBackground(new Color(Display.getDefault(), 255, 255, 255));
		group.setData("group");
	}

}
