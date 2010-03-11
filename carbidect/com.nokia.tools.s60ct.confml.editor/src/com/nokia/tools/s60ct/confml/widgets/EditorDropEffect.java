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


import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.dnd.DropTargetEffect;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;



/**
 * 
 * @author hajduivo
 * 
 */
public class EditorDropEffect extends DropTargetEffect {

	private RulerComposite ruler;
	private ScrolledComposite scrolledComposite;
	private SequenceWidget item;
	private int hysteresis = 10;
	private static int time;
	private int delay = 700;
	private static int eventLocation;
	private static int direction = 0;
	private Control next;
	private Control prev;

	public EditorDropEffect(Control control, RulerComposite ruler) {
		super(control);
		item = checkSequence(control);
		this.ruler = ruler;
		scrolledComposite = ruler.getScrolledComposite();

	}

	private SequenceWidget checkSequence(Control control) {
		if (control != null) {
			if (control instanceof SequenceWidget) {
				return (SequenceWidget) control;
			} else {
				return checkSequence(control.getParent());
			}
		}
		return null;
	}

	@Override
	public void dragOver(DropTargetEvent event) {
		Point eventPoint = scrolledComposite.toControl(event.x, event.y);
		if (eventLocation == -1) {
			eventLocation = event.y;
		}
		if (event.y > eventLocation) {
			direction = -1;
		} else if (event.y < eventLocation) {
			direction = 1;
		}

		if ((eventLocation + hysteresis < event.y || eventLocation - hysteresis > event.y)
				|| (event.time - time > delay)) {
			eventLocation = event.y;
			if (ruler != null) {
				Point origin = scrolledComposite.getOrigin();
				int rulerHeight = scrolledComposite.getClientArea().height;

				Control control = findSqWidget(getControl());
				Point controlPosition = getCoordinates(control);

				int maxOrigin = scrolledComposite.getContent().getSize().y
						- rulerHeight;

				// scroll down
				if (direction == -1) {
					next = findNext(item);
					// scroll whether widget is not whole visible
					if (controlPosition.y < eventPoint.y + origin.y
							&& control.getSize().y + controlPosition.y > rulerHeight
									+ origin.y) {
						if (maxOrigin > origin.y) {
							setOrigin(origin.x, controlPosition.y
									+ control.getSize().y - rulerHeight+SequenceWidget.SEPARATOR_HEIGHT,
									event.time);
						}

					}
					if (next != null) {
						// scroll if mouse is near the end of client area and
						// sequence has next item
						Point nextPosition = getCoordinates(next);
						Point nextSize = next.getSize();
						if (eventPoint.y + origin.y + 3 * hysteresis > nextPosition.y
								&& nextSize.y + nextPosition.y > rulerHeight
										+ origin.y) {
							setOrigin(origin.x, nextPosition.y + nextSize.y
									- rulerHeight+SequenceWidget.SEPARATOR_HEIGHT, event.time);
						}
					}
				}
				// scroll up
				else if (direction == 1) {
					prev = findPrev(item);
					// scroll whether widget is not whole visible
					if (controlPosition.y < origin.y) {
						setOrigin(origin.x, controlPosition.y-SequenceWidget.SEPARATOR_HEIGHT, event.time);
					}

					// scroll if mouse is near the end of client area and
					// sequence has next item
					if (prev != null) {
						Point prevPosition = getCoordinates(prev);
						Point nextSize = prev.getSize();
						if (eventPoint.y + origin.y - 3 * hysteresis < prevPosition.y
								+ nextSize.y
								&& prevPosition.y < origin.y) {
							setOrigin(origin.x, prevPosition.y-SequenceWidget.SEPARATOR_HEIGHT, event.time);
						}
					}
				}
			}
		}
	}

	private Control findSqWidget(Control control) {
		if (control == null) {
			return null;
		} else if (control instanceof SequenceWidget) {
			return control;
		} else {
			return findSqWidget(control.getParent());
		}
	}

	private Control findNext(SequenceWidget item) {
		Composite parent = item.getParent();
		if (parent instanceof SequenceWidget) {
			Control[] children = parent.getChildren();
			for (int i = 0; i < children.length; i++) {
				Control c = children[i];
				if (item == c && i < children.length - 1) {
					return children[i + 1];
				}
			}
		}
		return null;
	}

	private Control findPrev(SequenceWidget item) {
		Composite parent = item.getParent();
		if (parent instanceof SequenceWidget) {
			Control[] children = parent.getChildren();
			for (int i = 0; i < children.length; i++) {
				Control c = children[i];
				if (item == c) {
					if (i > 0) {
						return children[i - 1];
					} else {
						return null;
					}

				}
			}
		}
		return null;
	}

	private Point getCoordinates(Control control) {
		return getCoordinates(control, new Point(0, 0));
	}

	private Point getCoordinates(Control control, Point point) {
		Point location = control.getLocation();
		if (control.getParent() == scrolledComposite) {
			return point;
		} else {
			return getCoordinates(control.getParent(), new Point(point.x
					+ location.x, point.y + location.y));
		}
	}

	private void setOrigin(int x, int y, int time) {
		scrolledComposite.setOrigin(x, y);
		eventLocation = -1;
		EditorDropEffect.time = time;
		Point size = scrolledComposite.getSize();
		scrolledComposite.redraw(0,0,size.x,size.y,true);
		scrolledComposite.update();
	}
}
