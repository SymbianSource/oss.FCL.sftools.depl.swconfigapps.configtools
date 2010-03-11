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
 * Description: This file is part of com.nokia.tools.vct.confml.editor.view component.
 */

package com.nokia.tools.vct.confml.editor.view.viewers;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListener;
import org.eclipse.emf.transaction.ResourceSetListenerImpl;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Display;

import com.nokia.tools.vct.common.ui.utils.SWTUtil;
import com.nokia.tools.vct.confml.editor.view.vemodel.EFeature;
import com.nokia.tools.vct.confml.editor.view.vemodel.ERefTarget;
import com.nokia.tools.vct.confml.editor.view.vemodel.ESetting;
import com.nokia.tools.vct.confml.editor.view.vemodel.EView;
import com.nokia.tools.vct.confml.editor.view.vemodel.EViewEditorPackage;
import com.nokia.tools.vct.confml.editor.view.vemodel.EViewsEditorDocument;

public class ConfmlTreeViewerContentProvider implements ITreeContentProvider {

	private StructuredViewer viewer;
	private TransactionalEditingDomain domain;
	private EObject rootElement;
	public final static String ALL_FEATURES = "All Features";
	public final static String VIEWS = "Views";
	private final String[] rootBranches = new String[]{ALL_FEATURES, VIEWS};
	private EViewsEditorDocument topLevel;
	
	private ResourceSetListener resourceSetListener = new ResourceSetListenerImpl() {
		public boolean isPostcommitOnly() {
			return true;
		};

		@Override
		public void resourceSetChanged(ResourceSetChangeEvent event) {

			Transaction t = event.getTransaction();
			//System.out.println("RS Changed: ConfML Tree : "+t);
			
			long start = System.currentTimeMillis();
			
			final Set<EObject> updates = new HashSet<EObject>();
			final Set<EObject> refreshes = new HashSet<EObject>();

			for (Notification msg : event.getNotifications()) {
				final boolean refresh;
				final boolean update;

				switch (msg.getEventType()) {
				case Notification.ADD:
				case Notification.ADD_MANY:
				case Notification.MOVE:
				case Notification.REMOVE:
				case Notification.REMOVE_MANY:
					refresh = true;
					update = false;
					break;
				case Notification.SET:
				case Notification.UNSET:
					refresh = false;
					update = true;
					break;
				default:
					continue;
				}

				Object obj = msg.getNotifier();
				if (!(obj instanceof EObject)) {
					continue;
				}
				EObject eobj = (EObject) obj;
				if (!EcoreUtil.isAncestor(rootElement, eobj)) {
					continue;
				}

				boolean ok = false;
				EObject test = eobj;
				if (test instanceof Map.Entry) {
					test = test.eContainer();
				}

				if (test instanceof EViewsEditorDocument)  {
					ok = true;
				} 
				else if (test instanceof ESetting || test instanceof EFeature) 
				{
					if (refresh) {
						int id = msg.getFeatureID(ERefTarget.class);
						if (id == EViewEditorPackage.EREF_TARGET__REFS) {
							eobj = test.eContainer().eContainer();
						}
					}
					ok = true;
				}
				else if (test instanceof EView)
				{
					if (refresh) {
						eobj = test.eContainer();
					}
					ok = true;
				}
				

				if (update && ok) {
					updates.add(eobj);
				}
				if (refresh && ok ) {
					refreshes.add(eobj);
				}
			}

			
			long end = System.currentTimeMillis();
			//System.out.println("Changes received: "+(end - start)+ " ms :"+updates.size() + "/"+refreshes.size());

			if (updates.isEmpty() && refreshes.isEmpty()) {
				return;
			}

			if (Display.getCurrent() != null) {
				invokeUpdateViewer(updates, refreshes);
			} else {
				SWTUtil.getStandardDisplay().asyncExec(new Runnable() {
					public void run() {
						invokeUpdateViewer(updates, refreshes);
					}
				});
			}
			
		}

		private void invokeUpdateViewer(final Set<EObject> updates,
				final Set<EObject> refreshes) {
			long start = System.currentTimeMillis();

			updateViewer(updates, refreshes);

			long end = System.currentTimeMillis();
			//System.out.println("Changes processed  (Feature Tree): "+(end - start)+ " ms");
		}
	};

	public Object[] getChildren(final Object element) {
		
		try {
			Object[] retVal = TransactionUtil.runExclusive(domain, new RunnableWithResult.Impl<Object[]>() {
				public void run() {
					if (element instanceof EViewsEditorDocument) {
						topLevel = (EViewsEditorDocument) element;
						setResult(rootBranches);
						return;
					}
					if (element instanceof String)
					{
						if (element == ConfmlTreeViewerContentProvider.ALL_FEATURES)
							setResult(topLevel.getFeatures().values().toArray()); 
						else if (element == ConfmlTreeViewerContentProvider.VIEWS)
							setResult(topLevel.getAllViews().toArray()); 
						return;
					}
					if (element instanceof EFeature) {
						EFeature feature = (EFeature) element;
						setResult(feature.getSettings().values().toArray());
						return;
					}
					if (element instanceof ESetting) {
						ESetting setting = (ESetting) element;
						setResult(setting.getSubSettings().values().toArray());
						return;
					} 
					else {
						setResult(new Object[0]);
					}
				}
			});
			return retVal;
		} catch (InterruptedException e) {
			return new Object[0];
		}
	}

	public Object getParent(final Object element) {
		if(domain==null){
			return null;
		}
		try {
			return TransactionUtil.runExclusive(domain, new RunnableWithResult.Impl<EObject>() {
				public void run() {
					if (element instanceof EFeature || element instanceof ESetting) {
						setResult(((EObject) element).eContainer().eContainer());
					} 
					else if (element instanceof EView)
					{
						setResult(((EObject) element).eContainer());
					}
					else if (element instanceof EObject) {
						setResult(((EObject) element).eContainer());
					}
					else if (element instanceof String)
					{
						setResult(topLevel);
					}
				}
			});
		} catch (InterruptedException e) {
			return null;
		}
	}

	public boolean hasChildren(Object element) {
		return getChildren(element).length > 0;
	}

	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	public void dispose() {
		if (this.rootElement != null) {
			this.domain.removeResourceSetListener(resourceSetListener);
		}
		this.rootElement = null;
		this.domain = null;
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

		if (this.rootElement != null) {
			this.domain.removeResourceSetListener(resourceSetListener);
		}

		this.viewer = (StructuredViewer) viewer;
		this.domain = null;
		this.rootElement = null;

		if (newInput instanceof EObject) {
			EObject input = (EObject) newInput;
			this.rootElement = input;
			this.domain = TransactionUtil.getEditingDomain(input);
			this.domain.addResourceSetListener(resourceSetListener);
		}
	}

	private void updateViewer(final Set<EObject> updates,
			final Set<EObject> refreshes) {
		try {
			TransactionUtil.runExclusive(domain, new RunnableWithResult.Impl<Void>() {
				public void run() {
					viewer.getControl().setRedraw(false);
					try {
						if (!refreshes.isEmpty()) {
//							HashSet<EObject> copy = new HashSet<EObject>();
//							for (EObject obj : refreshes) {
//								// optimization - kill child changes as the refresh is recursive
//								if (EcoreUtil.isAncestor(copy, obj)) {
//									continue;
//								}
//								copy.add(obj);
//							}
							
							for (EObject obj : refreshes) {
								viewer.refresh(obj, false);
							}
						} 
						if (!updates.isEmpty()) {
							viewer.update(updates.toArray(), null);
						}
					} catch (Exception ex) {
						ex.printStackTrace();
					} finally {
						viewer.getControl().setRedraw(true);
					}
				}
			});
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}

	
	
}
