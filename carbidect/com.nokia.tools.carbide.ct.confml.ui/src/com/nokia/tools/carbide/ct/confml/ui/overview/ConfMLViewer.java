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
package com.nokia.tools.carbide.ct.confml.ui.overview;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;

public class ConfMLViewer extends StructuredViewer implements IOverviewViewer {
	private static String TITLE = "Design";
	private IDocument document;
	private Composite parentComposite;
	private FormToolkit toolkit;
	private ScrolledForm form;
	private String formName = "sfasd";
	private ConfMLViewContentProvider provider;
	
	public ConfMLViewer(Composite parent) {
		parentComposite = parent;
		provider = new ConfMLViewContentProvider();
		setContentProvider(provider);
		setLabelProvider(provider);
	}

	public ISelectionProvider getSelectionProvider() {
		return null;
	}

	public String getTitle() {
		return TITLE;
	}

	public void setDocument(IDocument document, String filename) {
		this.formName = filename;
		this.document = document;
		
		System.out.println(document.get());
		
		
		this.setInput(new Object());
	}

	@Override
	protected Widget doFindInputItem(Object element) {
		return null;
	}

	@Override
	protected Widget doFindItem(Object element) {
		return null;
	}

	@Override
	protected void doUpdateItem(Widget item, Object element, boolean fullMap) {

		
	}

	@Override
	protected List getSelectionFromWidget() {
		List l = new ArrayList();
		l.add(new Object());
		return l;
	}

	@Override
	protected void internalRefresh(Object element) {
		createMainControl();
	}

	private void createMainControl() {
		  toolkit = new FormToolkit(parentComposite.getDisplay());
		  form = toolkit.createScrolledForm(parentComposite);
//		  form.setText(formName);
		  //me
	}

	@Override
	public void reveal(Object element) {

		
	}

	@Override
	protected void setSelectionToWidget(List l, boolean reveal) {

		
	}

	@Override
	public Control getControl() {
		return form;
	}
}
