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
 * Description: This file is part of com.nokia.tools.variant.validation.core component.
 */

package com.nokia.tools.variant.validation.core;


/**
 * Marker category for IDE marker grouping
 */
public enum MarkerCategory {

	/** Layer-type errors */
	LAYER(10), 
	/** Type definition errors */
	TYPE(20), 
	/** Value errors */
	DATA(30), 
	/** RFS errors */
	RFS(40), 
	/** View errors */ 
	VIEW(50), 
	/** Other (uncategorized) errors */
	OTHER(60),
	/** XML errors */
	XML(70);

	private final int categoryValue;

	private MarkerCategory(int value) {
		this.categoryValue = value;
	}

	public int getCategoryValue() {
		return categoryValue;
	}
}
