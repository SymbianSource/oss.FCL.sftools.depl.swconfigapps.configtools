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

package com.nokia.tools.variant.editor.listeners;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;

public class AdapterRemovalDisposeListener implements DisposeListener {

	private Notifier view2;
	private Object adapter;

	public AdapterRemovalDisposeListener(Notifier view2, Object adapter) {
		this.view2 = view2;
		this.adapter = adapter;
	}

	public void widgetDisposed(DisposeEvent e) {
		view2.eAdapters().remove(adapter);

	}
}
