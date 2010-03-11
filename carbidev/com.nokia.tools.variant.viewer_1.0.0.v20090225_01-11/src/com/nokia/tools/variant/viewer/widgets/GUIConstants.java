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

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
/**
 * Editor GUI constants.
 */
public class GUIConstants {
	public static final Color COLOR_DARK_BLUE = new Color(Display.getDefault(), 157, 185, 235);
	public static final Color COLOR_LIGHT_BLUE = new Color(Display.getDefault(), 232, 242, 255);
	public static final Color COLOR_WHITE = new Color(Display.getDefault(), 255, 255, 255);
	public static final Color COLOR_LIGHT_GREEN = new Color(Display.getDefault(), 50, 180, 50);
	public static final Color COLOR_SECTION_LABEL = COLOR_DARK_BLUE;
	public static final Color COLOR_ERROROUS_RED = new Color(Display.getDefault(), 246, 152, 157);
	public static final Color COLOR_BORDER_SELECTED_FOCUS = COLOR_WHITE;
	public static final Color COLOR_BORDER_DESELECTED_FOCUS = new Color(Display.getDefault(),206,149,58);
	//color of background - setting is selected
	public static final Color COLOR_SELECTED_BACKGROUND =Display.getDefault().getSystemColor(SWT.COLOR_LIST_SELECTION);
	//color of background - setting is not selected
	public static final Color COLOR_DESELECTED_BACKGROUND = COLOR_WHITE;
	
}
