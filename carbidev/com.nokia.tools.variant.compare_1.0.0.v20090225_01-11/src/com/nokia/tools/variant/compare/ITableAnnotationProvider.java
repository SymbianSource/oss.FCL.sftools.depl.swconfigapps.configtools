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
 * Description: This file is part of com.nokia.tools.variant.compare component.
 */

package com.nokia.tools.variant.compare;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;

public interface ITableAnnotationProvider {

	Font getAnnotationFont(Object data, int idx);
	String getAnnotationText(Object data, int idx);
	Color getAnnotationForeground(Object data, int idx);
}
