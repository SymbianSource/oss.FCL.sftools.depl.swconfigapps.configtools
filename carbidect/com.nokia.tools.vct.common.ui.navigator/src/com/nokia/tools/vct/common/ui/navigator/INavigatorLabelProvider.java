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
 * Description: This file is part of com.nokia.tools.vct.common.ui.navigator component.
 */

package com.nokia.tools.vct.common.ui.navigator;

import org.eclipse.jface.viewers.ILabelProvider;

public interface INavigatorLabelProvider extends ILabelProvider {
	 String getDescription(Object element);
	 String getToolTipText(Object element);
}
