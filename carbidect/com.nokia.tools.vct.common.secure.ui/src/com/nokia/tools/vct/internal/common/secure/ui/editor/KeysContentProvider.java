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

package com.nokia.tools.vct.internal.common.secure.ui.editor;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Display;

import com.nokia.tools.vct.common.secure.core.IKeyStoreListener;
import com.nokia.tools.vct.common.secure.core.IKeyStoreManager;
import com.nokia.tools.vct.common.secure.core.KeyStoreEvent;

public class KeysContentProvider implements IStructuredContentProvider,
		IKeyStoreListener {

	private Display display;
	private StructuredViewer viewer;
	private IKeyStoreManager manager;
	private boolean asyncUpdate;

	public Object[] getElements(Object inputElement) {
		return manager.listEntries();
	}

	public void dispose() {
		if (manager != null) {
			manager.removeListener(this);
			manager = null;
		}
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		this.viewer = (StructuredViewer) viewer;
		this.display = viewer.getControl().getDisplay();

		if (manager != null) {
			manager.removeListener(this);
			manager = null;
		}

		if (newInput instanceof IKeyStoreManager) {
			manager = (IKeyStoreManager) newInput;
			manager.addListener(this);
		}
	}

	public void handleEvent(KeyStoreEvent event) {
		synchronized (this) {
			if (asyncUpdate) {
				return;
			}
			asyncUpdate = true;
		}
		display.asyncExec(new Runnable() {
			public void run() {
				scheduleUpdate();
			}
		});
	}

	void scheduleUpdate() {
		synchronized (this) {
			if (!asyncUpdate) {
				return;
			}
			asyncUpdate = false;
		}
		if (viewer != null && !viewer.getControl().isDisposed()) {
			viewer.refresh();
		}
	}

}
