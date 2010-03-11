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
 * Description: This file is part of com.nokia.tools.variant.common.core component.
 */

package com.nokia.tools.variant.common.core.utils;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

/**
 * Generic utilities for processing exceptions
 * 
 */
public class ExceptionUtils {

	/**
	 * Helper method for re-throwing exceptions when they match the declared
	 * type.
	 * 
	 * @param <T>
	 *            Exception type to throw
	 * @param type
	 *            Runtime exception class
	 * @param thr
	 *            Exception object to check
	 * @throws T
	 *             Given object if it matches the given type
	 */
	public static <T extends Throwable> void throwIfMatches(Class<T> type,
			Throwable thr) throws T {
		if (type.isInstance(thr)) {
			throw type.cast(thr);
		}
	}

	/**
	 * Convert given throwable into {@link CoreException} object
	 * 
	 * @param thr
	 *            Throwable to convert
	 * @param plugin
	 *            Plugin for status
	 * @param message
	 *            Message for status
	 * @return The given throwable if it is of {@link CoreException} type or new
	 *         {@link CoreException} object
	 */
	public static CoreException wrapCoreException(Throwable thr, String plugin,
			String message) {
		if (thr instanceof CoreException) {
			return (CoreException) thr;
		}
		return new CoreException(
				new Status(IStatus.ERROR, plugin, message, thr));
	}
}
