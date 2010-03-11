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
 * Description: This file is part of com.nokia.tools.variant.preview component.
 */

package com.nokia.tools.variant.preview;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IActionBars;

/**
 * Preview controller
 * 
 * The controller <i>should</i> implement {@link Object#equals(Object)} method
 * for optimization of UI management.
 * 
 */
public abstract class PreviewController {

	private IActionBars actionBars;
	
	public abstract void createControl(Composite parent);

	public abstract void setInput(IPreviewDescriptor descriptor);

	public abstract void dispose();

	public abstract Control getControl();

	
	public void setActionBars(IActionBars actionBars) {
		this.actionBars = actionBars;
	}
	
	public IActionBars getActionBars() {
		return actionBars;
	}
	
	/**
	 * Default implementation for controller comparison.
	 * 
	 * Clients can override.
	 * 
	 * @param arg
	 *            Compared object
	 * @return <code>true</code> if argument has the same runtime type
	 */
	public boolean equals(Object arg) {
		if (arg == null) {
			return false;
		} else if (this == arg) {
			return true;
		}
		return getClass().equals(arg.getClass());
	}
}
