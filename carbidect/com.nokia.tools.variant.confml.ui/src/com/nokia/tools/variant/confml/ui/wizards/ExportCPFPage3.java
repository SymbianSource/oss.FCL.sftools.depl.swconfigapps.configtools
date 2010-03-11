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

import java.security.cert.X509Certificate;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.layout.TableColumnLayout;
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
import org.eclipse.swt.widgets.TableColumn;

import com.nokia.tools.vct.common.core.utils.ArrayUtils;
import com.nokia.tools.vct.common.secure.core.IKeyStoreEntry;
import com.nokia.tools.vct.common.secure.core.IKeyStoreManager;
import com.nokia.tools.vct.common.secure.core.SecurityCorePlugin;
import com.nokia.tools.vct.common.secure.core.SigningUtils;

public class ExportCPFPage3 extends WizardPage {

	static final String PAGE_ID = ExportCPFPage3.class.getName();

	private CheckboxTableViewer viewer;

	static class SiginingLabelProvider extends LabelProvider implements
			ITableLabelProvider {
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		public String getColumnText(Object element, int columnIndex) {
			IKeyStoreEntry entry = (IKeyStoreEntry)element;
			IKeyStoreManager manager = SecurityCorePlugin.getKeyStoreManager();
			X509Certificate certificate = manager.getCertificate(entry);
			switch (columnIndex) {
			case 0:
				return SigningUtils.getShortName(certificate);
			case 1:
				certificate = manager.getCertificate(entry);
				return DateFormat.getDateInstance(DateFormat.LONG).format(certificate.getNotAfter());
			default:
				return null;
			}
		}
	}

	public ExportCPFPage3() {
		super(PAGE_ID);
		setTitle("CPF Encryption");
		setDescription("Select users who will have content access.");
	}

	public void createControl(Composite parent) {
		Composite control = new Composite(parent, SWT.NONE);

		TableColumnLayout layout = new TableColumnLayout();
		control.setLayout(layout);

		viewer = CheckboxTableViewer.newCheckList(control, SWT.BORDER
				| SWT.FULL_SELECTION);
		viewer.setContentProvider(new ArrayContentProvider());
		viewer.setLabelProvider(new SiginingLabelProvider());
		viewer.addCheckStateListener(new ICheckStateListener() {
			public void checkStateChanged(CheckStateChangedEvent event) {
				validatePage();
			}
		});
		
		viewer.getTable().setHeaderVisible(true);
		
		TableColumn column1 = new TableColumn(viewer.getTable(), SWT.LEFT);
		column1.setText("Cerficiate");
		TableColumn column2 = new TableColumn(viewer.getTable(), SWT.LEFT);
		column2.setText("Expires");
		layout.setColumnData(column1, new ColumnWeightData(10, 200));
		layout.setColumnData(column2, new ColumnWeightData(5, 150));
		
		viewer.setInput(SecurityCorePlugin.getKeyStoreManager().listEntries());

		setControl(control);
	}
	
	void validatePage() {
		Object[] checked = viewer.getCheckedElements();
		if (checked.length == 0) {
			setPageComplete(false);
			return;
		}
		setPageComplete(true);
	}
	
	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		if (visible) {
			validatePage();
		}
	}
	
	public X509Certificate[] getCertificates() {
		List<X509Certificate> result = new ArrayList<X509Certificate>();
		IKeyStoreManager manager = SecurityCorePlugin.getKeyStoreManager();
		for (Object next: viewer.getCheckedElements()) {
			X509Certificate certificate = manager.getCertificate((IKeyStoreEntry)next);
			result.add(certificate);
		}
		
		return ArrayUtils.createCopy(X509Certificate.class, result);
	}
}
