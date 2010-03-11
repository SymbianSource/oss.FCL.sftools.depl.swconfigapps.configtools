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

package com.nokia.s60ct.gui.viewer;

import interfaces.CellModifier;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;

public class DCAdapterFactoryContentProvider extends
		AdapterFactoryContentProvider implements CellModifier {

	private static final Class CellModifierKlass = CellModifier.class;
	
	public DCAdapterFactoryContentProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}
	
	public boolean canModify(Object element, String property) {
		CellModifier cmp = (CellModifier)adapterFactory.adapt(element, CellModifierKlass);
		return cmp!=null?cmp.canModify(element, property):false;
	}

	public Object getValue(Object element, String property) {
		CellModifier cmp = (CellModifier)adapterFactory.adapt(element, CellModifierKlass);
		return cmp!=null?cmp.getValue(element, property):null;
	}

	public void modify(Object parent,Object element, String property, Object value) {
		CellModifier cmp = (CellModifier)adapterFactory.adapt(element, CellModifierKlass);
		if(cmp!=null)cmp.modify(parent,element, property, value);
	}

	private Object getParentObject(){
		ISelection selection = viewer.getSelection();
		if(selection instanceof IStructuredSelection){
			
		}
		return null;
	}
}
