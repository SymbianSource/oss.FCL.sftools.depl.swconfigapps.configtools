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

import com.nokia.tools.variant.editor.editors.Messages;
import com.nokia.tools.variant.editor.summary.SummaryLeafGroup;
import com.nokia.tools.variant.navigator.views.NavigatorViewer;
import com.nokia.tools.variant.views.errormodel.ErrorsRoot;

/** 
 * A receiver of notifications. 
 * <br/>
 * Associated with a {@link com.nokia.tools.variant.views.errormodel.ErrorsRoot} 
 */
public class SummaryNotifyAdapter implements Adapter {

	private SummaryLeafGroup summaryLeafGroup;
	private ErrorsRoot errorsRoot;
	private NavigatorViewer viewer;

	
	/**
	 * Constructs a SummaryNotifyAdapter.
	 * 
	 * @param summaryLeafGroup2
	 * @param viewer
	 * @param errorsRoot
	 */
	public SummaryNotifyAdapter(SummaryLeafGroup summaryLeafGroup2,
			NavigatorViewer viewer, ErrorsRoot errorsRoot) {
		this.summaryLeafGroup = summaryLeafGroup2;
		this.viewer = viewer;
		this.errorsRoot = errorsRoot;
	}

	public Notifier getTarget() {
		return null;
	}

	public boolean isAdapterForType(Object type) {
		return false;
	}

	
	/**
	 * Notifies that a change to ErrorsRoot has occurred.
	 * <br/>
	 * Needed to update (StructuredViewer) NavigatorViewer - SummaryLeafGroup	 
	 * 
	 * @param notification
	 *            a description of the change.
	 *            
	 * @see org.eclipse.jface.viewers.StructuredViewer#update(Object, String[])
	 */
	public void notifyChanged(Notification notification) {
		if (notification.getEventType() == Notification.REMOVING_ADAPTER) {
			return;
		}
		summaryLeafGroup.setName(errorsRoot.getErrors().size() + " "
				+ Messages.SUMMARY_ERRORS);
		viewer.update(summaryLeafGroup, null);
	}

	public void setTarget(Notifier newTarget) {
	}

}
