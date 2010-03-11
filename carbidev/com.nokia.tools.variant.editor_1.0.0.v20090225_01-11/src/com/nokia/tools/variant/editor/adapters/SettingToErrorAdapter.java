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
 * Description: This file is part of com.nokia.tools.variant.editor component.
 */

package com.nokia.tools.variant.editor.adapters;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;

import com.nokia.tools.variant.views.errormodel.Error;

/**
 * Used to get Error from Setting
 * 
 */
public class SettingToErrorAdapter extends AdapterImpl {

	private Error error;

	/**
	 * Constructs a SettingToErrorAdapter.
	 * 
	 * @param error
	 */
	public SettingToErrorAdapter(Error error) {
		this.error = error;
	}

	public Notifier getTarget() {
		return null;
	}

	/**
	 * Returns whether the adapter is of the given type.
	 * 
	 * @param type
	 *            the type.
	 * @return whether the adapter is of the given type.
	 * @see AdapterFactory#isFactoryForType
	 */
	public boolean isAdapterForType(Object type) {
		if (type == SettingToErrorAdapter.class) {
			return true;
		}
		return false;
	}

	public void setTarget(Notifier newTarget) {

	}

	/**
	 * 
	 * @return Error
	 */
	public Error getError() {
		return error;
	}
}
