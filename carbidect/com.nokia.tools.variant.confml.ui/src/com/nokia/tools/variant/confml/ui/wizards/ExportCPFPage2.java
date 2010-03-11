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
 * Description: This file is part of com.nokia.tools.variant.confml.ui component.
 */

package com.nokia.tools.variant.confml.ui.wizards;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.TableColumn;

import com.nokia.tools.variant.confml.ui.ConfmlUI;
import com.nokia.tools.variant.confml.ui.IConfmlImages;
import com.nokia.tools.vct.common.appmodel.EConfMLLayer;
import com.nokia.tools.vct.common.appmodel.EConfigurationProject;
import com.nokia.tools.vct.common.appmodel.util.CPFSigningUtils;
import com.nokia.tools.vct.common.secure.core.SigningStatus;
import com.nokia.tools.vct.common.secure.core.SigningUtils;

public class ExportCPFPage2 extends WizardPage {

	class SignatureLabelProvider extends LabelProvider implements ITableLabelProvider {

		public Image getColumnImage(Object element, int columnIndex) {
			if (!(element instanceof URI)) {
				return null;
			}
			URI uri = (URI)element;
			SigningStatus status = sigingMap.get(uri);
			if (columnIndex == 0) {
				if (status.modelObject instanceof EConfigurationProject) {
					return ConfmlUI.getImage(IConfmlImages.FLD_PROJECT);
				} else if (status.modelObject instanceof EConfMLLayer) {
					return ConfmlUI.getImage(IConfmlImages.FLD_LAYER);
				} else {
					return null;
				}
			} else {
				return null;
			}
		}

		public String getColumnText(Object element, int columnIndex) {
			if (!(element instanceof URI)) {
				return null;
			}
			URI uri = (URI)element;
			SigningStatus status = sigingMap.get(uri);
			if (columnIndex == 0) {
				if (status.modelObject instanceof EConfigurationProject) {
					EConfigurationProject project = (EConfigurationProject)status.modelObject;
					IPath path = new Path(project.getRootConfml().toPlatformString(true)).removeFirstSegments(1);;
					return path.toString();
				} else if (status.modelObject instanceof EConfMLLayer) {
					EConfMLLayer layer = (EConfMLLayer)status.modelObject;
					IPath path = new Path(layer.getLayerURI().toPlatformString(true)).removeFirstSegments(1);;
					return path.toString();
				} else {
					return null;
				}
			} else if (columnIndex == 1) {
				if (status.contentOK) {
					return "signed";
				} else if (!status.signatureFound) {
					return "unsigned";
				} else {
					return "modified";
				}
			} else if (columnIndex == 2) {
				if (status.contentOK) {
					return SigningUtils.getShortName(status.certificate);
				} else {
					return "n/a";
				}
			} else {
				return null;
			}
		}
		
	}
	
	static final String PAGE_ID = ExportCPFPage2.class.getName();
	
	private CheckboxTableViewer viewer;
	private List<EConfigurationProject> context;
	private Map<URI, SigningStatus> sigingMap;
	private List<URI> signingList;
	
	public ExportCPFPage2(List<EConfigurationProject> context) {
		super(PAGE_ID);
		setTitle("CPF Content Siging");
		setDescription("Specify configuration roots and layers you want to sign with your key.");
		this.context = context;
		this.sigingMap = new LinkedHashMap<URI, SigningStatus>();
		this.signingList = new ArrayList<URI>();
	}
	
	
	public void createControl(Composite parent) {
		Composite control = new Composite(parent, SWT.NONE);
		TableColumnLayout layout = new TableColumnLayout();
		control.setLayout(layout);
		viewer = CheckboxTableViewer.newCheckList(control, SWT.BORDER | SWT.CHECK | SWT.FULL_SELECTION);
		viewer.setContentProvider(new ArrayContentProvider());
		viewer.setLabelProvider(new SignatureLabelProvider());
		
		viewer.getTable().setHeaderVisible(true);
		viewer.getTable().setLinesVisible(true);
		
		TableColumn column1 = new TableColumn(viewer.getTable(), SWT.LEFT);
		column1.setText("Element");
		TableColumn column2 = new TableColumn(viewer.getTable(), SWT.LEFT);
		column2.setText("Status");
		TableColumn column3 = new TableColumn(viewer.getTable(), SWT.LEFT);
		column3.setText("Certificate");
		
		layout.setColumnData(column1, new ColumnWeightData(15, 200));
		layout.setColumnData(column2, new ColumnWeightData(5, 50));
		layout.setColumnData(column3, new ColumnWeightData(10, 150));
		
		viewer.setInput(signingList);
		
		viewer.addCheckStateListener(new ICheckStateListener() {
			public void checkStateChanged(CheckStateChangedEvent event) {
				validateComplete();
			}
		});
		
		setControl(control);
	}
	
	void validateComplete() {
		for (URI next: signingList) {
			SigningStatus status = sigingMap.get(next);
			if (!status.contentOK) {
				if (!viewer.getChecked(next)) {
					setPageComplete(false);
					return;
				}
			}
		}
		setPageComplete(true);
		return;
	}
	
	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		if (visible) {
			setPageComplete(false);
			final IRunnableWithProgress update = new IRunnableWithProgress() {
				public void run(IProgressMonitor monitor)
						throws InvocationTargetException, InterruptedException {
					monitor.beginTask("Checking signatures", 100 * context.size() + 100);
					signingList.clear();
					
					for (EConfigurationProject next: context) {
						// URIConverter converter = next.eResource().getResourceSet().getURIConverter();
						// converter.getURIMap().put(CPFUtil.CPF_BASE_URI, next.eResource().getURI());

						if (sigingMap.containsKey(next.getRootConfml())) {
							monitor.worked(100);
							continue;
						}
						SigningStatus status = CPFSigningUtils.getRootStatus(next);
						sigingMap.put(next.getRootConfml(), status);
						
						for (EConfMLLayer layer: next.getLayers()) {
							if (sigingMap.containsKey(layer.getLayerURI())) {
								continue;
							}
							status = CPFSigningUtils.getLayerStatus(layer);
							sigingMap.put(layer.getLayerURI(), status);
						}
						monitor.worked(100);
						// converter.getURIMap().remove(CPFUtil.CPF_BASE_URI);
					}
					Set<URI> filter = new LinkedHashSet<URI>();
					for (EConfigurationProject next: context) {
						signingList.add(next.getRootConfml());
					}					
					for (EConfigurationProject next: context) {
						for (EConfMLLayer layer: next.getLayers()) {
							if (filter.contains(layer.getLayerURI())) {
								continue;
							}
							filter.add(layer.getLayerURI());
							signingList.add(layer.getLayerURI());
						}
					}					
					monitor.worked(100);
					monitor.done();
				}
			};
			Display.getCurrent().asyncExec(new Runnable() {
				public void run() {
					try {
						getContainer().run(true, false, update);
					} catch (Exception e) {
						e.printStackTrace();
					}
					viewer.refresh();
					
					List<URI> toCheck = new ArrayList<URI>();
					for (URI uri: signingList) {
						SigningStatus status = sigingMap.get(uri);
						if (!status.contentOK) {
							toCheck.add(uri);
						}
					}
					
					viewer.setCheckedElements(toCheck.toArray());
					setPageComplete(true);
				}
			});
		}
	}
	
	public Object[] getSignTargets() {
		Object[] checked = viewer.getCheckedElements();
		List<Object> result = new ArrayList<Object>(checked.length);
		for (Object next: checked) {
			SigningStatus status = sigingMap.get(next);
			result.add(status.modelObject);
		}
		return result.toArray();
	}
}
