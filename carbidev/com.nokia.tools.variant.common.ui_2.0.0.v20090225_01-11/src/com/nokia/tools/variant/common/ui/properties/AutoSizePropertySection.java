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

package com.nokia.tools.variant.common.ui.properties;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

/**
 * A base class of property section that is never wider then the client area of
 * a parent scrollable composite.
 */
public abstract class AutoSizePropertySection extends AbstractPropertySection {

	private Composite control;

	/**
	 * Must be called by subclass
	 */
	public final void createControls(Composite parent,
			TabbedPropertySheetPage tabbedPropertySheetPage) {
		control = new Composite(parent, SWT.NONE) {
			@Override
			public Point computeSize(int wHint, int hHint, boolean changed) {
				if (wHint == SWT.DEFAULT) {
					ScrolledComposite sc = findScrolledComposite();
					wHint = sc.getClientArea().width;
					resizeContent();
				}

				return super.computeSize(wHint, hHint, changed);
			}
		};
		control.setLayout(new FillLayout());

		super.createControls(control, tabbedPropertySheetPage);

		/**
		 * calls method implemented by subclass (to populate parent composite)
		 */
		createSpecificControls(control, tabbedPropertySheetPage);

	}

	// pseudo abstract
	protected void resizeContent() {
	};

	/**
	 * Is called by createControls method. Supposed to be used by subclass to
	 * populate parent Composite by own content
	 * 
	 * @param parent
	 * @param tabbedPropertySheetPage
	 */
	protected abstract void createSpecificControls(Composite parent,
			TabbedPropertySheetPage tabbedPropertySheetPage);

	@Override
	public final void refresh() {
		ScrolledComposite sc = findScrolledComposite();
		if (sc == null) {
			return;
		}
		sc.setLayoutDeferred(true);
		sc.setRedraw(false);
		try {
			doRefresh();
		} finally {
			sc.setLayoutDeferred(false);
			sc.setRedraw(true);
			Display.getCurrent().asyncExec(new Runnable() {

				public void run() {
					if (!control.isDisposed()) {
						layoutControls();
					}
				}

			});

		}
	}

	/**
	 * Update the section content as needed. This operation may also modify the
	 * widget tree. After this operation the complete layout is recalculated.
	 */
	protected abstract void doRefresh();

	@Override
	public void aboutToBeShown() {
		ScrolledComposite sc = findScrolledComposite();
		if (sc == null) {
			return;
		}
		sc.setRedraw(false);
		try {
			layoutControls();
		} finally {
			sc.setRedraw(true);
		}
	}

	protected void layoutControls() {
		ScrolledComposite sc = findScrolledComposite();
		if (sc == null) {
			return;
		}

		Rectangle ca = sc.getClientArea();
		Control content = sc.getContent();
		Point size = content.computeSize(ca.width, SWT.DEFAULT, true);
		content.setSize(size);
		sc.setMinSize(size);
		((Composite) content).layout(true, true);
		sc.layout(true, true);
		sc.setOrigin(0, 0);
	}

	protected ScrolledComposite findScrolledComposite() {
		Composite ptr = control;
		while (!(ptr instanceof ScrolledComposite)) {
			ptr = ptr.getParent();
			if (ptr == null) {
				return null;
			}
		}
		ScrolledComposite sc = (ScrolledComposite) ptr;
		return sc;
	}

	/**
	 * Cleans up the mess in the tabbed properties view
	 */
	public void dispose() {
		control.dispose();
		super.dispose();
	}
}
