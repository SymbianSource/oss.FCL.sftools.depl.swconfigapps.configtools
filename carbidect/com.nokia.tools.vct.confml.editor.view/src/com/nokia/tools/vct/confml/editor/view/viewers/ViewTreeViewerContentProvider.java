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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMap;
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
import com.nokia.tools.vct.confml.editor.view.vemodel.EGroup;
import com.nokia.tools.vct.confml.editor.view.vemodel.ERefTarget;
import com.nokia.tools.vct.confml.editor.view.vemodel.ESetting;
import com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef;
import com.nokia.tools.vct.confml.editor.view.vemodel.EView;
import com.nokia.tools.vct.confml.editor.view.vemodel.EViewsEditorDocument;
import com.nokia.tools.vct.confml.editor.view.vemodel.impl.EViewEntryImpl;

public class ViewTreeViewerContentProvider implements ITreeContentProvider {

	private StructuredViewer viewer;
	private TransactionalEditingDomain domain;
	private EViewsEditorDocument rootElement;
	
	private ResourceSetListener resourceSetListener = new ResourceSetListenerImpl() {
		public boolean isPostcommitOnly() {
			return true;
		};

		@Override
		public void resourceSetChanged(ResourceSetChangeEvent event) {

			Transaction t = event.getTransaction();
			//System.out.println("RS Changed: View Model Tree : " + t);

			long start = System.currentTimeMillis();

			final List<EObject> updates = new ArrayList<EObject>();
			final List<EObject> refreshes = new ArrayList<EObject>();

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

				boolean relevant = false;
				if (eobj instanceof EViewsEditorDocument) {
					relevant = true;
				} else if (eobj instanceof EView) {
					relevant = true;
				} else if (eobj instanceof EGroup) {
					relevant = true;
				} else if (eobj instanceof ESettingRef) {
					relevant = true;
//				} else {
//					if (eobj instanceof ESetting || eobj instanceof EFeature) {
//						if (refresh) {
//							Object oldValue = msg.getOldValue();
//							Object newValue = msg.getOldValue();
//
//							if (oldValue instanceof ESettingRef) {
//								refreshes.add((ESettingRef) oldValue);
//							} else if (oldValue instanceof List) {
//								for (Object o : (List<?>) oldValue) {
//									if (o instanceof ESettingRef) {
//										refreshes.add((ESettingRef) o);
//									}
//								}
//							}
//							if (newValue instanceof ESettingRef) {
//								refreshes.add((ESettingRef) newValue);
//							} else if (newValue instanceof List) {
//								for (Object o : (List<?>) newValue) {
//									if (o instanceof ESettingRef) {
//										refreshes.add((ESettingRef) o);
//									}
//								}
//							}
//						}
//					}
				}

				if (update && relevant) {
					updates.add(eobj);
				}
				if (refresh && relevant) {
					refreshes.add(eobj);
				}
			}

			long end = System.currentTimeMillis();
			//System.out.println("Changes received: " + (end - start) + " ms :"+ updates.size() + "/" + refreshes.size());

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
		private void invokeUpdateViewer(final List<EObject> updates,
				final List<EObject> refreshes) {
			long start = System.currentTimeMillis();

			updateViewer(updates, refreshes);

			long end = System.currentTimeMillis();
			//System.out.println("Changes processed (View Tree): " + (end - start)+ " ms");
		}
		
		
	};

	private void updateViewer(final List<EObject> updates,
			final List<EObject> refreshes) {
		try {
			TransactionUtil.runExclusive(domain,
					new RunnableWithResult.Impl<Void>() {
						public void run() {
							viewer.getControl().setRedraw(false);
							try {
								if (!refreshes.isEmpty()) {
//									for (EObject o : refreshes) {
//										viewer.refresh(o, true);
//									}
									viewer.refresh(true);
								}  else if (!updates.isEmpty()) {
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

	//	
	// private EContentAdapter contentAdapter = new EContentAdapter() {
	// @Override
	// public void notifyChanged(Notification msg) {
	// super.notifyChanged(msg);
	//
	// final boolean refresh;
	// final boolean update;
	//			
	// switch (msg.getEventType()) {
	// case Notification.ADD:
	// case Notification.ADD_MANY:
	// case Notification.MOVE:
	// case Notification.REMOVE:
	// case Notification.REMOVE_MANY:
	// refresh = true;
	// update = false;
	// break;
	// case Notification.SET:
	// case Notification.UNSET:
	// refresh = false;
	// update = true;
	// break;
	// default:
	// return;
	// }
	//						
	// final Object notifier = msg.getNotifier();
	// if (viewer != null) {
	// SWTUtil.getStandardDisplay().asyncExec(new Runnable() {
	// public void run() {
	// try {
	// if (refresh) {
	// viewer.refresh(notifier);
	// }
	// if (update) {
	// viewer.update(notifier, null);
	// }
	// } catch (Exception ex) {
	// ex.printStackTrace();
	// }
	// };
	// });
	//				
	// }
	// }
	// };

	public Object[] getChildren(Object element) {
		if (element instanceof EView) {
			List<Object> result = new ArrayList<Object>();
			EView v = (EView) element;
			result.addAll(v.getGroupsAndViews());
			return result.toArray();
		}
		if (element instanceof EViewEntryImpl)
		{
			List<Object> result = new ArrayList<Object>();
			EView v = ((EViewEntryImpl) element).getValue();
			result.addAll(v.eContents());
			return result.toArray();
		}
		if (element instanceof EViewsEditorDocument) {			
			return ((EViewsEditorDocument) element).getViews().values()
					.toArray();
		}
		if (element instanceof EGroup) {
			List<Object> result = new ArrayList<Object>();
			result.addAll(((EGroup) element).getGroups());
			result.addAll(((EGroup) element).getRefs());
			return result.toArray();
		}
		if (element instanceof ESettingRef) {
			ESettingRef ref=(ESettingRef)element;
			ERefTarget target = ref.getTarget();
			if (target != null) {
				if (target instanceof EFeature) {
					EFeature eFeature = (EFeature) target;
					List<Object> result = new ArrayList<Object>();
					result.addAll(eFeature.getSettings());					
					return result.toArray();
				}
				if (target instanceof ESetting) {
					List<Object> result = new ArrayList<Object>();
					result.addAll(ref.getOptions());
					result.addAll(ref.getProperties());
					return result.toArray();
				}
			} 
		}
		return new Object[0];
	}

	public Object getParent(Object element) {
		if (element instanceof ESettingRef || element instanceof EGroup) {
			return ((EObject) element).eContainer();
		}
		if (element instanceof EView) {
			return ((EObject) element).eContainer();
		}

		return null;
	}

	public boolean hasChildren(Object element) {
		return getChildren(element).length > 0;
	}

	public Object[] getElements(Object element) {
		return getChildren(element);
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

		if (newInput instanceof EViewsEditorDocument) {
			EViewsEditorDocument input = (EViewsEditorDocument) newInput;
			this.rootElement = input;
			this.domain = TransactionUtil.getEditingDomain(input);
			this.domain.addResourceSetListener(resourceSetListener);
		}
	}

}
