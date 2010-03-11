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
 * Description: This file is part of com.nokia.tools.vct.common.secure.core component.
 */

package com.nokia.tools.vct.common.secure.core;

import java.math.BigInteger;
import java.util.EventObject;

public class KeyStoreEvent extends EventObject {

	/** Serialization code */
	private static final long serialVersionUID = 1L;

	public static final int OBJECTS_ADDED = 1;
	public static final int OBJECTS_REMOVED = 2;
	public static final int DEFAULT_CHANGED = 3;

	public static final int CERTIFICATE = 1 << 0;
	public static final int PUBLIC_KEY = 1 << 1;
	public static final int PRIVATE_KEY = 1 << 2;
	public static final int SECRET_KEY = 1 << 3;

	public int type;
	public int flags;
	public BigInteger serial;

	public KeyStoreEvent(Object source) {
		super(source);
	}

}
