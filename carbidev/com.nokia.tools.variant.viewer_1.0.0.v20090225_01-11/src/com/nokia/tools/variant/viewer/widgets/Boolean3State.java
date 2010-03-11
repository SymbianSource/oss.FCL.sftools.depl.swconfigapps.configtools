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

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

/**
 * Three state check box. In Carbide.V widget serves for providing information,
 * whether value of boolean setting is not declared.
 * <table>
 * <tr>
 * <td>state 0</td>
 * <td>not selected</td>
 * </tr>
 * <tr>
 * <td>state 1</td>
 * <td>selected</td>
 * </tr>
 * <tr>
 * <td>state 2</td>
 * <td>not defined (intermediate)</td>
 * </tr>
 * </table>
 */
public class Boolean3State extends Button {

	private int state = 0;

	public Boolean3State(Composite parent, int style) {
		super(parent, style);
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		if (state == 0) {
			setGrayed(false);
			super.setSelection(false);
			this.state = 0;
		} else if (state == 1) {
			setGrayed(false);
			super.setSelection(true);
			this.state = 1;
		} else if (state > 1) {
			setGrayed(true);
			super.setSelection(true);
			this.state = 2;
		}

	}

	@Override
	protected void checkSubclass() {
		// do not check package
	}

	@Override
	public void setSelection(boolean selected) {
		if (state > 0) {
			setState(0);
		} else {
			setState(1);
		}

	}

}
