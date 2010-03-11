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

import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseTrackListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

import com.nokia.tools.variant.common.ui.utils.SWTUtil;

/**
 * Class handles error tool tip behavior.
 */
public class ErrorToolTipMouseTrackListener implements MouseTrackListener {
	private Shell errorToolTipContainer;
	private Composite errorComposite;

	private ScrolledComposite scrolledComposite;
	private Composite item;

	public ErrorToolTipMouseTrackListener(Shell errorToolTipContainer,
			Composite errorComposite, int errorLocation) {
		this.errorToolTipContainer = errorToolTipContainer;
		this.errorComposite = errorComposite;

	}

	public ErrorToolTipMouseTrackListener(Shell errorToolTipContainer,
			Composite errorComposite, ScrolledComposite scrolledComposite,
			Composite item) {
		this.errorToolTipContainer = errorToolTipContainer;
		this.errorComposite = errorComposite;
		this.scrolledComposite = scrolledComposite;
		this.item = item;
	}

	public void mouseEnter(MouseEvent e) {

	}

	public void mouseExit(MouseEvent e) {
		getErrorToolTipContainer().setVisible(false);

	}

	public void mouseHover(MouseEvent e) {
		if (item != null && !item.isDisposed()) {
			int absoluteLocation = 0;
			if (item.getParent().getParent().getSize().y == 32) {

				absoluteLocation = absoluteLocation(item.getParent()
						.getParent());
			} else if (item.getParent().getSize().y == 31) {
				absoluteLocation = absoluteLocation(item.getParent());

			} else {
				absoluteLocation = absoluteLocation(item);
			}

			int location = e.y;

			if (Math.abs(absoluteLocation - location) < 10) {
				ErrorToolTipWidget.calculateLocationOfErrorToolTip(
						errorComposite, getErrorToolTipContainer(),
						absoluteLocation);
				getErrorToolTipContainer().setVisible(true);
			}else{
				getErrorToolTipContainer().setVisible(false);
			}
		}
	}

	private int absoluteLocation(Composite textBox) {
		Point location = SWTUtil.getControlLocation(scrolledComposite, textBox);

		return location.y + 11;
	}

	public Shell getErrorToolTipContainer() {
		return errorToolTipContainer;
	}
}
