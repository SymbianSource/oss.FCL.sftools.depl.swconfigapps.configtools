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

/**
 * This class contains settings of visual display 
 */
public class GraphicsWidgetModel {
	//width title of the setting (label) in Editor
	private int widthLabelSetting;
	
	public int getWidthLabelSettting(){
		return widthLabelSetting;
	}
	public void setWidthLabelSetting(int width){
		this.widthLabelSetting = width;
	}
}
