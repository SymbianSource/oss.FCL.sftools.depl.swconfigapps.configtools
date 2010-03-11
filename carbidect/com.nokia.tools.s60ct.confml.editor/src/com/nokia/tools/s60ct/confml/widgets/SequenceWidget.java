/*
* Copyright (c) 2009 Nokia Corporation and/or its subsidiary(-ies). 
* All rights reserved.
* This component and the accompanying materials are made available
* under the terms of "Eclipse Public License v1.0"
* which accompanies this distribution, and is available
* at the URL "http://www.eclipse.org/legal/epl-v10.html".
*
* Initial Contributors:
* Nokia Corporation - initial contribution.
*
* Contributors:
*
* Description:
*
*/
package com.nokia.tools.s60ct.confml.widgets;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Collection;
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
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
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

//import com.nokia.tools.variant.common.ui.utils.SWTUtil;

public class SequenceWidget extends BaseConfMLWidget implements Listener {

	Canvas leftControl;
	boolean hide;
	boolean resized;
	public static final int LEFT_CONTROL_WIDTH = 16;
	public static final int SEPARATOR_HEIGHT = 2;
	Map<BaseConfMLWidget, Composite> childrenWidges = new LinkedHashMap<BaseConfMLWidget, Composite>();
	Map<Control, Composite> separators = new LinkedHashMap<Control, Composite>();
	Set<Control> placed = new HashSet<Control>();
	Set<SequenceWidgetItem> placedS = new HashSet<SequenceWidgetItem>();
	static int[] twistieExpanded, twistieCollapsed;
	boolean changed = false, fire = false;
	int oldHeight = 0;
	Set<Listener> resizeListeners = new LinkedHashSet<Listener>();

	public Map<Control, Composite> getSeparators() {
		return separators;
	}

	Map<Control, Point> cache = new LinkedHashMap<Control, Point>();

	public Map<Control, Point> getCache() {
		return cache;
	}

	public Map<BaseConfMLWidget, Composite> getChildrenWidges() {
		return childrenWidges;
	}

	List<SequenceWidgetItem> notChangeItems = new ArrayList<SequenceWidgetItem>();

	Listener selectionListener;
	DropTarget leftControlDropTarget;
	DragSource leftControlDragSource;
	public boolean pDirty;
	public boolean pError;
	protected int offset;
	// Sequence does not have note
	// public boolean pNote;

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

	public void resizeRowComponent() {
		if (label != null) {
			resizeLeftComponent(errorComposite);
			resizeLeftComponent(noteComposite);
			resizeLeftComponent(dirtyComposite);
		}
	}

	private void resizeLeftComponent(Composite comp) {
		if (comp != null) {
			Point size = comp.getSize();
			comp.setSize(size.x, group.getSize().y);
		}
	}

	private void createControl(int style) {

		super.setLayout(new SequenceLayout());
		leftControl = new Canvas(this, style);
		leftControl.setData(SequenceWidget.this);
		leftControl.setBackground(getBackground());
		leftControl.addListener(SWT.MouseDown, new Listener() {

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
		});
		leftControl.addPaintListener(new PaintListener() {

			public void paintControl(PaintEvent e) {
				paintTwistie(e.gc);
			}
		});
		int x = LEFT_CONTROL_WIDTH / 2;
		twistieCollapsed = translate(offPoints, x, 14);
		twistieExpanded = translate(onPoints, x, 14);

		addControlListener(new ControlListener() {

			public void controlMoved(ControlEvent e) {
				// do nothing

			}

			public void controlResized(ControlEvent e) {
				// System.out.println(SequenceWidgetItem.this + " " +
				// getSize());
				int y = getSize().y;
				if (oldHeight != y) {
					// fireResizeEvent((hide) ? expanded.y - 32 : 32 -
					// expanded.y);
					// moveEDNItems
					offset = oldHeight - y;
					oldHeight = y;
					fire = true;
				}
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

	private void fireResizeEvent(int offset)
	{
		Listener[] listeners = resizeListeners
				.toArray(new Listener[resizeListeners.size()]);
		HeightChangeEvent event = new HeightChangeEvent(this, offset);
		for (int i = 0; i < listeners.length; i++) {
			listeners[i].handleEvent(event);
		}
		fire = false;
	}

	private class SequenceLayout extends Layout {

		private int separatorsCount;

		@Override
		protected Point computeSize(Composite composite, int wHint, int hHint,
				boolean flushCache) {

			Control[] children = composite.getChildren();
			Point s = new Point(0, 0);
			separatorsCount = 0;
			Collection<Composite> values = childrenWidges.values();

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

				if (control != leftControl && !values.contains(control)) {
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
					if (hide) {
						return s;
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
				if (fire) {
					fireResizeEvent(offset);
				}
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
			if (fire) {
				fireResizeEvent(offset);
			}
			changed = false;

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
					if (hide /* && i > 0 */) {
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
				// hideEDNComposites(control, controlSize);
			}

			if (controlSize.x > 0 && controlSize.y > 0) {

				if (control instanceof SequenceWidgetItem) {
					SequenceWidgetItem swi = (SequenceWidgetItem) control;
					placedS.add(swi);
					// swi.firstControl
					// .addPropertyChangeListener(new ItemPropertyListener(
					// SequenceWidget.this));
					swi.addPropertyChangeListener(new ItemPropertyListener());
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

		if (!hide)
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

	public void buildWidget(Composite composite, String label,
			Map<String, String> options) {
		setBackground(composite.getBackground());

	}

	public boolean isCollapsed() {
		return hide;
	}

	public void setCollapsed(boolean hide) {
		if (hide != this.hide) {
			this.hide = hide;
			setCollapsed();
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
		}
		super.addDropListener(listener);
	}

	@Override
	public void select() {
		if (!isSelected()) {
			label.setFocus();
			selected = true;
			drawSelectUI();
		}
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
			// else if (propertyName
			// .equals(BaseConfMLWidget.PROPERTY_PROPAGATE_NOTE)) {
			// if (newValue) {
			// pNote = true;
			// } else {
			// for (Control control : placedS) {
			// if (control instanceof SequenceWidgetItem) {
			// if (((SequenceWidgetItem) control)
			// .isNotePropagated()) {
			// temp = true;
			// }
			// }
			// }
			// pNote = temp;
			// }
			// }

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
		// HeightChangeEvent e = (HeightChangeEvent) event
		 System.out.println("handleEvent :"+event);
		// BaseConfMLWidget source = e.getSource();
	}

	private void moveEDNComposites() {
		for (SequenceWidgetItem item : placedS) {
			/*
			int locationOnRuler = SWTUtil.getControlLocation(item.getRuler().getScrolledComposite(), item).y;
			// getRulerCoordinates(item, item.getRuler()
			// .getScrolledComposite());
			Control[] array = item.placed.toArray(new Control[item.placed
					.size()]);
			for (int i = 0; i < array.length; i++) {
				Control control = array[i];
				if (control instanceof BaseConfMLWidget) {
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
			*/
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

	// private int getRulerCoordinates(Control control, Control rulerS) {
	// int location = 0;
	// for (;;) {
	// if (control == rulerS) {
	// location += control.getLocation().y;
	// break;
	// }
	// location += control.getLocation().y;
	// control = control.getParent();
	// }
	//
	// return location;
	//
	// }

	// private int getRulerCoordinates(Control control, int point, Control
	// rulerS) {
	// Point location = control.getLocation();
	// if (control != null && rulerS != null) {
	// if (control.getParent() == rulerS) {
	// return point;
	// } else {
	// return getRulerCoordinates(control.getParent(), point
	// + location.y, rulerS);
	// }
	// } else {
	// return point;
	// }
	// }

	public void setGrayed(boolean grayed)
	{
		toolBar.setEnabled(!grayed);
		if (grayed)
		{
			label.setForeground(label.getDisplay().getSystemColor(SWT.COLOR_GRAY));
		}
		else
		{
			label.setForeground(label.getDisplay().getSystemColor(SWT.COLOR_BLACK));
		}
	}

	
}
