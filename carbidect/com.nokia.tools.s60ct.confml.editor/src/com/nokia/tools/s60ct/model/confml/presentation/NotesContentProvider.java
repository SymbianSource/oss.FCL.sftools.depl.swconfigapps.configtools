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
 * Description: This file is part of com.nokia.tools.variant.views component.
 */

package com.nokia.tools.s60ct.model.confml.presentation;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListener;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;

import com.nokia.tools.variant.confml.core.ConfMLCore;
import com.nokia.tools.vct.common.ui.utils.SWTUtil;



public class NotesContentProvider implements IStructuredContentProvider,
ITreeContentProvider, ResourceSetListener {

	
	TableViewer v;
	TransactionalEditingDomain editingDomain;

	public void inputChanged(Viewer v, Object oldInput, Object newInput) {
		editingDomain = ConfMLCore.getEditingDomain();
		editingDomain.addResourceSetListener(this);
		
		this.v = (TableViewer) v;
	}

	public void dispose() {
		ConfMLCore.getEditingDomain().removeResourceSetListener(this);
	}

	public Object[] getElements(Object parent) {
		return getChildren(parent);
	}

	public Object getParent(Object child) {
		
		if (child instanceof EObject) {
			EObject cont = ((EObject) child).eContainer();
			if (cont instanceof Map.Entry) {
				return cont.eContainer();
			}
		}

		return null;
	}

	public NotificationFilter getFilter() {
		return NotificationFilter.NOT_TOUCH;
	}

	public boolean isAggregatePrecommitListener() {
		return false;
	}

	public boolean isPostcommitOnly() {
		return true;
	}

	public boolean isPrecommitOnly() {
		return false;
	}

	public Command transactionAboutToCommit(ResourceSetChangeEvent event)
			throws RollbackException {
		return null;
	}

	public void resourceSetChanged(ResourceSetChangeEvent event) {
		final Set<Object> notifiers = new HashSet<Object>();
		for (Notification notification : event.getNotifications()) {
			Object source = notification.getNotifier();
			notifiers.add(source);
		}

		SWTUtil.getStandardDisplay().asyncExec(new Runnable() {
			public void run() {
				for (Object obj : notifiers) {
					v.refresh(obj);
				}
			}
		});
	}

	public Object[] getChildren(final Object parent) {
		Object[] result = null;
		try {
			result = TransactionUtil.runExclusive(editingDomain,
					new RunnableWithResult.Impl<Object[]>() {
						public void run() {
							Object[] objects = {};
							if (parent instanceof Map)
							{
								Map<Object, String> notes = (Map)parent;
								objects = notes.entrySet().toArray();							
							}
							setResult(objects);
							setStatus(Status.OK_STATUS);
						}
					});
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}

		return result;
	}

	public boolean hasChildren(Object parent) {
		return getChildren(parent).length > 0;
	}

}

