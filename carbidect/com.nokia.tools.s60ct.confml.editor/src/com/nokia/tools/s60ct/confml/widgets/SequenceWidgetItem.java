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
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Listener;

public class SequenceWidgetItem extends BaseConfMLWidget {

	
	
	private Canvas leftControl;
	private boolean hide;
	// boolean resized;
	private int tempWidth = 0;
	public static final int LEFT_CONTROL_WIDTH = 16;
	public static final int SEPARATOR_HEIGHT = 2;
	private BaseConfMLWidget firstControl;
	int oldHeight = 0;
	Set<Listener> resizeListeners = new LinkedHashSet<Listener>();

	public BaseConfMLWidget getFirstControl() {
		return firstControl;
	}

	private Map<Control, Composite> separators = new LinkedHashMap<Control, Composite>();
	Set<Control> placed = new LinkedHashSet<Control>();

	private static int[] twistieExpanded, twistieCollapsed;
	private Point collapsed, expanded;
	private boolean changed = false;

	public Map<Control, Composite> getSeparators() {
		return separators;
	}

	private Map<Control, Point> cache = new LinkedHashMap<Control, Point>();

	public Map<Control, Point> getCache() {
		return cache;
	}

	private Listener selectionListener;
	private DropTarget leftControlDropTarget;
	private DragSource leftControlDragSource;
	public SequenceWidget parent;
	public BaseConfMLWidget lastWidget;

	private static final int[] onPoints = { 0, 2, 8, 2, 4, 6 };
	private static final int[] offPoints = { 2, -1, 2, 8, 6, 4 };

	public SequenceWidgetItem(SequenceWidget parent, int style) {
		super(parent, style);
		this.parent = parent;
		createControl(style);
	}

	private void createControl(int style) {

		super.setLayout(/*getTestLayout()*/new SequenceLayout());
		leftControl = new Canvas(this, style);
		leftControl.setBackground(getBackground());
		leftControl.addListener(SWT.MouseDown, new Listener() {

			public void handleEvent(Event event) {
				if (event.type == SWT.MouseDown) {
					hide = !hide;
					setCollapsed();
					Composite parent = getParent();
					parent.getParent().getParent().getParent().getParent()
							.getParent().layout(true, true);
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

	}


	private Layout getTestLayout() {
		GridLayout layout = new GridLayout();
		
		return layout;
	}


	private class SequenceLayout extends Layout {

		private int separatorsCount;

		@Override
		protected Point computeSize(Composite composite, int wHint, int hHint,
				boolean flushCache) {

			// composite.getSize().x;
			if (parent != null) {
				if (hide && collapsed != null) {
					// collapsed.x = tempWidth;
					return collapsed;
				} else if (!hide && expanded != null) {
					// expanded.x = tempWidth;
					return expanded;
				}
			}
			Control[] children = composite.getChildren();
			Point s = new Point(0, 0);
			separatorsCount = 0;
			// Collection<Composite> values = childrenWidges.values();
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
					if (firstControl == null) {
						if (control instanceof BaseConfMLWidget) {
							firstControl = (BaseConfMLWidget) control;
						} else {
							firstControl = SequenceWidgetItem.this;
						}
					}
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
				if (parent == null && control instanceof BaseConfMLWidget) {
					separatorsCount++;
				}

			}

			// s.x += 2 * LEFT_CONTROL_WIDTH;
			if (parent != null) {
				if (hide) {
					collapsed = s;
				} else {
					// fireResizeEvent(s.y);
					expanded = s;
				}
			}

			return s;
		}

		private boolean checkChanged(Control control, Point controlSize) {
			Point point = cache.get(control);
			if (point == null) {
				return true;
			}
			return controlSize.y != point.y;
//			return !point.equals(controlSize);

		}

		@Override
		protected void layout(Composite composite, boolean flushCache) {
			boolean resize = false;
			Rectangle cArea = composite.getClientArea();
			if (cArea.width != tempWidth) {
				resize = true;
			}
			if (!changed && placed.size() == cache.size() && !resize) {
				Control[] array = placed.toArray(new Control[placed.size()]);
				for (int i = 0; i < array.length; i++) {
					Control control = array[i];
					if (parent.isCollapsed()) {
						hideEDNComposites(control, cache.get(control));
					} else if (hide && control != firstControl) {
						hideEDNComposites(control, cache.get(control));
					} else {
						showEDNComposites(control, cache.get(control));

					}
				}
				return;
			}

			Point lCSize = leftControl.computeSize(SWT.DEFAULT, SWT.DEFAULT,
					flushCache);
			lCSize.x = LEFT_CONTROL_WIDTH;
			lCSize.y = -1;
			int y = 0;

			Object[] controls = cache.keySet().toArray();
			tempWidth = cArea.width;
			for (int i = 0; i < controls.length; i++) {
				Control control = (Control) controls[i];
				// if (placed.contains(control)){continue;}
				y = resizeControl(cArea, lCSize.x, y, i, control, resize);
				if (lCSize.y == -1 && y > 0) {
					lCSize.y = y;
				}

				if (control instanceof BaseConfMLWidget) {
					BaseConfMLWidget subWidget = (BaseConfMLWidget) control;
					subWidget
							.addPropertyChangeListener(new ItemPropertyListener());
				}
			}

			if (lCSize.y != -1) {
				leftControl.setSize(lCSize);
			}
			leftControl.setLocation((parent == null) ? 0 : LEFT_CONTROL_WIDTH, 0);
			if (firstControl==null)
			{
				return;
			}
			firstControl.getRowComposites().add(leftControl);
			if (parent != null) 
			{
				firstControl.getRowComposites().add(SequenceWidgetItem.this);
			}
			changed = false;
		}

		private int resizeControl(Rectangle cArea, int lCSizeX, int y, int i,
				Control control, boolean flushCache) {

			Point controlSize = null;
			if (flushCache) {
				// resized = false;
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
//			controlSize.x = (y == 0) ? cArea.width - 2 * lCSizeX : cArea.width
//					- 2 * lCSizeX;
			controlSize.x = cArea.width;
			SequenceWidgetItem sWidget = null;
			if (control.getParent() instanceof SequenceWidgetItem) {
				sWidget = (SequenceWidgetItem) control.getParent();
				if (sWidget != null
						&& sWidget.getParent() instanceof SequenceWidgetItem) {
					sWidget = (SequenceWidgetItem) sWidget.getParent();
				}
			}
			// Hide
			if (hide && i > 0) {
				// control.setBounds(lCSize.x, 0, controlSize.x, 0);
				// control.setLocation(lCSize.x, 0);
				// control.setSize(controlSize.x, 0);
				hideEDNComposites(control, controlSize);
			} else {
				// control.setBounds(lCSize.x, y, lCSize.x, controlSize.y);
				control.setSize(controlSize.x, controlSize.y);
				control.setLocation((y == 0) ? 2 * lCSizeX : 0, y);
				showEDNComposites(control, controlSize);
				y += controlSize.y;
			}

			if (controlSize.x > 0 && controlSize.y > 0) {

				placed.add(control);
				if (control instanceof BaseConfMLWidget) {
					lastWidget = (BaseConfMLWidget) control;
				}

			}
//			if (expanded != null && expanded.x < controlSize.x) {
//				expanded.x = controlSize.x;
//			}
//			if (collapsed != null && collapsed.x < controlSize.x) {
//				collapsed.x = controlSize.x;
//			}
			return y;
		}

	}

	private void showEDNComposites(Control control, Point controlSize) {
		// if (true)return;
		if (control instanceof BaseConfMLWidget
				&& !(control instanceof SequenceWidgetItem)) {
			BaseConfMLWidget widget = (BaseConfMLWidget) control;

			Composite comp = widget.getErrorComposite();
			Point controlLoc = control.getLocation();
			Point dispLoc = control.toDisplay(controlLoc);
			dispLoc.y -= controlLoc.y;

			if (comp != null) {
				comp.setVisible(true);
			}

			comp = widget.getDirtyComposite();

			if (comp != null) {
				comp.setVisible(true);
			}
			comp = widget.getNoteComposite();

			if (comp != null) {
				comp.setVisible(true);
			}
		}
	}

	public void hideEDNComposites(Control control, Point controlSize) {
		if (control instanceof BaseConfMLWidget) {
			// Point location = getCoordinates(firstControl, new Point(0,0));
			BaseConfMLWidget widget = (BaseConfMLWidget) control;
			Composite comp = widget.getErrorComposite();
			if (comp != null) {
				comp.setVisible(false);
			}
			comp = widget.getDirtyComposite();
			if (comp != null) {
				comp.setVisible(false);
			}
			comp = widget.getNoteComposite();
			if (comp != null) {
				comp.setVisible(false);
			}
			// if (control instanceof SequenceWidget) {
			// System.out.println(control);
			// // showEDNComposites((SequenceWidget) control,false);
			// }
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
		gc
				.setForeground(leftControl.getDisplay().getSystemColor(
						SWT.COLOR_RED));
		gc.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_BLACK));

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
			leftControl.redraw();
		}
	}

	private void setCollapsed() {
		if (hide) {
			// showComponents(false);
			firstControl.propagateDirty(isDirtyPropagated());
			firstControl.propagateError(isErrorPropagated());
			// firstControl.propagateNote(isNotePropagated());
		} else {
			// showComponents(true);
			firstControl.propagateDirty(false);
			firstControl.propagateError(false);
			// firstControl.propagateNote(false);
		}

		int y = getSize().y;
		if (oldHeight != y) {
			fireResizeEvent(oldHeight - y);
			oldHeight = y;
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
		firstControl.select();
	}

	private class ItemPropertyListener implements PropertyChangeListener {

		public void propertyChange(PropertyChangeEvent evt) {

			String propertyName = evt.getPropertyName();
			Boolean newValue = (Boolean) evt.getNewValue();
			boolean temp = false;
			if (propertyName.equals(BaseConfMLWidget.PROPERTY_DIRTY)) {
				if (newValue) {
					propagateDirty(true);
				} else {
					for (Control control : placed) {
						if (control instanceof BaseConfMLWidget) {
							if (((BaseConfMLWidget) control).isDirty()) {
								temp = true;
								break;
							}
						}
					}
					propagateDirty(temp);
				}
			} else if (propertyName.equals(BaseConfMLWidget.PROPERTY_ERROR)) {
				if (newValue) {
					propagateError(true);
				} else {
					for (Control control : placed) {
						if (control instanceof BaseConfMLWidget) {
							if (((BaseConfMLWidget) control).hasError()) {
								temp = true;
								break;
							}
						}
					}
					propagateError(temp);
				}
			}

		}
	}

	public boolean addExpandListener(Listener listener) {
		return resizeListeners.add(listener);
	}

	public boolean removeExpandListener(Listener listener) {
		return resizeListeners.remove(listener);
	}

	public Set<Listener> getExpandListeners() {
		return resizeListeners;
	}

	private void fireResizeEvent(int offset) {
		Listener[] listeners = resizeListeners
				.toArray(new Listener[resizeListeners.size()]);

		// cache
		HeightChangeEvent event = new HeightChangeEvent(lastWidget, offset);
		for (int i = 0; i < listeners.length; i++) {
			listeners[i].handleEvent(event);
		}
	}

	public void setGrayed(boolean grayed)
	{
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
