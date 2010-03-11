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

import org.eclipse.jface.layout.TreeColumnLayout;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TreeColumn;

import com.nokia.tools.vct.common.secure.core.SigningUtils;

public class ImportCPFPage2 extends WizardPage {
	static final class CertContentProvider extends ArrayContentProvider implements ITreeContentProvider {
		public Object[] getChildren(Object parentElement) {
			return new Object[0];
		}
		public boolean hasChildren(Object element) {
			return getChildren(element).length > 0;
		}
		public Object getParent(Object element) {
			return null;
		}
	}
	
	static final class CertLabelProvider extends LabelProvider implements ITableLabelProvider {
		
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}
		
		public String getColumnText(Object element, int columnIndex) {
			if (!(element instanceof X509Certificate)) {
				return null;
			}
			X509Certificate cert = (X509Certificate)element;
			switch (columnIndex) {
			case 0:
				return SigningUtils.getShortName(cert);
			case 1:
				DateFormat fmt = DateFormat.getDateInstance(DateFormat.LONG);
				return fmt.format(cert.getNotAfter());
			}
			
			return null;
		}
	}
	
	static final String PAGE_NAME = ImportCPFPage2.class.getName();

	private TreeViewer viewer;

	public ImportCPFPage2() {
		super(PAGE_NAME);

		setTitle("CPF Encryption Information");
	}

	public void createControl(Composite parent) {
		Composite control = new Composite(parent, SWT.NONE);
		TreeColumnLayout layout = new TreeColumnLayout();
		control.setLayout(layout);

		viewer = new TreeViewer(control, SWT.FULL_SELECTION | SWT.BORDER);
		viewer.getTree().setHeaderVisible(true);
		TreeColumn column1 = new TreeColumn(viewer.getTree(), SWT.LEFT);
		TreeColumn column2 = new TreeColumn(viewer.getTree(), SWT.LEFT);
		column1.setText("Certificate");
		column2.setText("");
		layout.setColumnData(column1, new ColumnWeightData(15, 200));
		layout.setColumnData(column2, new ColumnWeightData(5, 60));

		viewer.setContentProvider(new CertContentProvider());
		viewer.setLabelProvider(new CertLabelProvider());
		
		setControl(control);
	}

	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		
		if (visible) {
			ImportCPFPage1 page1 = (ImportCPFPage1)getWizard().getPage(ImportCPFPage1.PAGE_ID);
			if (viewer.getInput() == null) {
				viewer.setInput(page1.getUsers());
			} else {
				viewer.refresh();
			}
		}
	}
}
