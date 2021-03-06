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

public enum ValidationStatus {
	/**
	 * Information level message. 
	 */
	INFO, 
	/**
	 * Warning level message. 
	 */
	WARNING, 
	/**
	 * Error level message. 
	 */
	ERROR, 
	/**
	 * Error level message. The build shall stop. 
	 */
	FATAL_ERROR;
}
