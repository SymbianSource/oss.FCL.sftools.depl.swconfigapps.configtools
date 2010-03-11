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
 * Description: This file is part of com.nokia.tools.variant.common.ui component.
 */

package com.nokia.tools.variant.common.ui.utils;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.accessibility.AccessibleAdapter;
import org.eclipse.swt.accessibility.AccessibleEvent;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Caret;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.ScrollBar;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.FormText;

/**
 * Utility class to simplify access to some SWT resources.
 * 
 * The idea is taken from JFace forms and JDT utilities
 */
public class SWTUtil {
	/**
	 * Magic constant for disabling focus scrolling. Used in other places of
	 * Eclipse internal API
	 */
	public static final String FOCUS_SCROLLING = "focusScrolling"; //$NON-NLS-1$

	/**
	 * Returns the standard display to be used. The method first checks, if the
	 * thread calling this method has an associated display. If so, this display
	 * is returned. Otherwise the method returns the default display.
	 */
	public static Display getStandardDisplay() {
		Display display;
		display = Display.getCurrent();
		if (display == null)
			display = Display.getDefault();
		return display;
	}

	/**
	 * Returns the shell for the given widget. If the widget doesn't represent a
	 * SWT object that manage a shell, <code>null</code> is returned.
	 * 
	 * @return the shell for the given widget
	 */
	public static Shell getShell(Widget widget) {
		if (widget instanceof Control)
			return ((Control) widget).getShell();
		if (widget instanceof Caret)
			return ((Caret) widget).getParent().getShell();
		if (widget instanceof DragSource)
			return ((DragSource) widget).getControl().getShell();
		if (widget instanceof DropTarget)
			return ((DropTarget) widget).getControl().getShell();
		if (widget instanceof Menu)
			return ((Menu) widget).getParent().getShell();
		if (widget instanceof ScrollBar)
			return ((ScrollBar) widget).getParent().getShell();

		return null;
	}

	/**
	 * Get active page inside the active workbench window (if exists)
	 * 
	 * @return Page or <code>null</code>
	 */
	public static IWorkbenchPage getActivePage() {
		IWorkbenchWindow window = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow();
		if (window == null)
			return null;
		return window.getActivePage();
	}

	/**
	 * Get active editor inside the active workbench window (if exists)
	 * 
	 * @return Page or <code>null</code>
	 */
	public static IEditorPart getActiveEditor() {
		IWorkbenchPage page = getActivePage();
		if (page == null)
			return null;
		return page.getActiveEditor();
	}

	/**
	 * Returns a width hint for a button control.
	 * 
	 * @param button
	 *            the button
	 * @return the width hint
	 */
	public static int getButtonWidthHint(Button button) {
		button.setFont(JFaceResources.getDialogFont());
		PixelConverter converter = new PixelConverter(button);
		int widthHint = converter
				.convertHorizontalDLUsToPixels(IDialogConstants.BUTTON_WIDTH);
		return Math.max(widthHint, button.computeSize(SWT.DEFAULT, SWT.DEFAULT,
				true).x);
	}

	/**
	 * Sets width and height hint for the button control. <b>Note:</b> This is a
	 * NOP if the button's layout data is not an instance of
	 * <code>GridData</code>.
	 * 
	 * @param button
	 *            the button for which to set the dimension hint
	 */
	public static void setButtonDimensionHint(Button button) {
		Assert.isNotNull(button);
		Object gd = button.getLayoutData();
		if (gd instanceof GridData) {
			((GridData) gd).widthHint = getButtonWidthHint(button);
			((GridData) gd).horizontalAlignment = GridData.FILL;
		}
	}

	public static int getTableHeightHint(Table table, int rows) {
		if (table.getFont().equals(JFaceResources.getDefaultFont()))
			table.setFont(JFaceResources.getDialogFont());
		int result = table.getItemHeight() * rows + table.getHeaderHeight();
		if (table.getLinesVisible())
			result += table.getGridLineWidth() * (rows - 1);
		return result;
	}

	/**
	 * Adds an accessibility listener returning the given fixed name.
	 * 
	 * @param control
	 *            the control to add the accessibility support to
	 * @param text
	 *            the name
	 */
	public static void setAccessibilityText(Control control, final String text) {
		control.getAccessible().addAccessibleListener(new AccessibleAdapter() {
			public void getName(AccessibleEvent e) {
				e.result = text;
			}
		});
	}

	/**
	 * Create plain grid layout with zero margins and given number of columns
	 * 
	 * @param columns
	 *            Number of columns
	 * @return Grid layout with zero margins
	 */
	public static GridLayout newLayoutNoMargins(int columns) {
		GridLayout layout = new GridLayout(columns, false);
		layout.marginWidth = 0;
		layout.marginHeight = 0;
		return layout;
	}

	/**
	 * Find a parent {@link ScrolledComposite} for the control if exists
	 * 
	 * @param c
	 *            Control to start with
	 * @return The closest part {@link ScrolledComposite} or <code>null</code>
	 *         if not found
	 */
	public static ScrolledComposite getScrolledComposite(Control c) {
		Composite parent = c.getParent();

		while (parent != null) {
			if (parent instanceof ScrolledComposite) {
				return (ScrolledComposite) parent;
			}
			parent = parent.getParent();
		}
		return null;
	}

	/**
	 * Helper method for adjusting scrolled composite to display the given
	 * control.
	 * 
	 * If the control is already visible, nothing is done
	 * 
	 * @param c
	 *            Control to make visible.
	 */
	public static void ensureVisible(Control c) {
		ScrolledComposite scomp = getScrolledComposite(c);
		if (scomp != null) {
			Object data = scomp.getData(FOCUS_SCROLLING);
			if (data == null || !data.equals(Boolean.FALSE))
				ensureVisible(scomp, c);
		}
	}

	/**
	 * Calculate the location of the given control inside the parent composite
	 * 
	 * @param scomp
	 *            Parent composite
	 * @param control
	 *            Control
	 * @return Location point
	 */
	public static Point getControlLocation(ScrolledComposite scomp,
			Control control) {
		int x = 0;
		int y = 0;
		Control content = scomp.getContent();
		Control currentControl = control;
		for (;;) {
			if (currentControl == content)
				break;
			Point location = currentControl.getLocation();
			x += location.x;
			y += location.y;
		
			currentControl = currentControl.getParent();
		}
		return new Point(x, y);
	}

	public static void ensureVisible(ScrolledComposite scomp, Control control) {
		if (scomp==null){
			scomp = getScrolledComposite(control);
		}
		// if the control is a FormText we do not need to scroll since it will
		// ensure visibility of its segments as necessary
		if (control instanceof FormText)
			return;
		Point controlSize = control.getSize();
		Point controlOrigin = getControlLocation(scomp, control);
		ensureVisible(scomp, controlOrigin, controlSize);
	}

	public static void ensureVisible(ScrolledComposite scomp,
			Point controlOrigin, Point controlSize) {
		
		Rectangle area = scomp.getClientArea();
		Point scompOrigin = scomp.getOrigin();

		int x = scompOrigin.x;
		int y = scompOrigin.y;

		// horizontal right, but only if the control is smaller
		// than the client area
		if (controlSize.x < area.width
				&& (controlOrigin.x + controlSize.x > scompOrigin.x
						+ area.width)) {
			x = controlOrigin.x + controlSize.x - area.width;
		}
		// horizontal left - make sure the left edge of
		// the control is showing
		if (controlOrigin.x < x) {
			if (controlSize.x < area.width)
				x = controlOrigin.x + controlSize.x - area.width;
			else
				x = controlOrigin.x;
		}
		// vertical bottom
		if (controlSize.y < area.height
				&& (controlOrigin.y + controlSize.y > scompOrigin.y
						+ area.height)) {
			y = controlOrigin.y + controlSize.y - area.height;
		}
		// vertical top - make sure the top of
		// the control is showing
		if (controlOrigin.y < y) {
			if (controlSize.y < area.height)
				y = controlOrigin.y + controlSize.y - area.height;
			else
				y = controlOrigin.y;
		}

		if (scompOrigin.x != x || scompOrigin.y != y) {
			// scroll to reveal
			scomp.setOrigin(x, y);
		}
	}

}
