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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.jface.viewers.StructuredViewer;

import com.nokia.tools.variant.editor.model.summaryModel.UIElement;

/**
 * A receiver of notifications. Associated with a {@link UIElement}
 */
public class NotifyAdapter implements Adapter {

	private UIElement uiElement;
	private StructuredViewer settingsViewer;

	/**
	 * Constructs a NotifyAdapter.
	 * 
	 * @param uiElement
	 * @param settingsViewer
	 */
	public NotifyAdapter(UIElement uiElement, StructuredViewer settingsViewer) {
		this.uiElement = uiElement;
		this.settingsViewer = settingsViewer;
	}
	
	public Notifier getTarget() {
		return null;
	}
	
	public boolean isAdapterForType(Object type) {
		return false;
	}

	/**
	 * Notifies that a change to UIElement has occurred.
	 * 
	 * @param notification
	 *            a description of the change.
	 */
	public void notifyChanged(Notification notification) {
		settingsViewer.update(uiElement, null);
	}
	
	public void setTarget(Notifier newTarget) {

	}

}
