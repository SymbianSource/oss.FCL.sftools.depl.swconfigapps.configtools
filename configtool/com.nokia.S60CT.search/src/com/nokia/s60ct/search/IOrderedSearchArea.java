/*
* Copyright (c) 2009 Nokia Corporation and/or its subsidiary(-ies). 
* All rights reserved.
* This component and the accompanying materials are made available
* under the terms of "Eclipse Public License v1.0"
* which accompanies this distribution, and is available
* at the URL "http://www.eclipse.org/legal/epl-v10.html".
*
* Initial Contributors:
* Nokia Corporation - initial contribution.
*
* Contributors:
*
* Description:
*
*/
package com.nokia.s60ct.search;

import java.util.Comparator;

/**
 * Used to find e.g. matches nearby to the UI cursor location.  
 * 
 *
 * @param <T>
 */
public interface IOrderedSearchArea<T> extends ISearchArea<T> {	
	int getOrder(T t); 
}
