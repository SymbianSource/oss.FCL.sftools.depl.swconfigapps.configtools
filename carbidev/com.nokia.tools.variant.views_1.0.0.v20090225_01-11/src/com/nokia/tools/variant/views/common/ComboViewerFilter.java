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
 * Description: This file is part of com.nokia.tools.variant.views component.
 */

package com.nokia.tools.variant.views.common;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

/**
 * Filter for table viewer, which is handled by ComboBox.
 * 
 */

public class ComboViewerFilter extends ViewerFilter {

	private int selectFrom;
	private int selectTo;
	private int counter;

	public ComboViewerFilter(String selectedItem) {
		String[] split = selectedItem.split("-");
		selectFrom = Integer.valueOf(split[0]);
		selectTo = Integer.valueOf(split[1]);
		counter = 0;
	}

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		counter++;
		if (selectFrom <= counter && counter <= selectTo) {
			return true;
		}

		return false;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}
}
