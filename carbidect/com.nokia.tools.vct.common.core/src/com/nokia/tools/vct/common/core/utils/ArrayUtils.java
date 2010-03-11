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
 * Description: This file is part of com.nokia.tools.vct.common.core component.
 */

package com.nokia.tools.vct.common.core.utils;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.List;

/**
 * Generic array manipulation utilities
 * 
 */
public class ArrayUtils {

	/**
	 * Create a snapshot copy of the collection elements of given type
	 * 
	 * @param <T>
	 *            Type of contained element
	 * @param type
	 *            Runtime class for array elements
	 * @param source
	 *            Source collection
	 * @return Array containing collection elements
	 */
	public static <T> T[] createCopy(Class<T> type,
			Collection<? extends T> source) {
		T[] result = newArray(type, source.size());
		result = source.toArray(result);
		return result;
	}

	/**
	 * Helper method for allocating new array of a given type and length
	 * 
	 * @param <T>
	 *            Type of contained element
	 * @param type
	 *            Runtime class for array elements
	 * @param length
	 *            Array length
	 * @return Allocated array
	 */
	@SuppressWarnings("unchecked")
	public static <T> T[] newArray(Class<T> type, int length) {
		Object result = Array.newInstance(type, length);
		return (T[]) result;
	}

	public static<T> T getLast(List<T> source) {
		return source.isEmpty() ? null : source.get(source.size() - 1);
	}

	public static<T> T getFirst(List<T> source) {
		return source.isEmpty() ? null : source.get(0);
	}
}
