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

package views;

import interfaces.CellModifier;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.swt.widgets.Item;


public class AdapterFactoryCellModifier implements ICellModifier {
	
	AdapterFactory adapterFactory=null;
	
	private static final Class CellModifierClass = CellModifier.class;
	
	public AdapterFactoryCellModifier(AdapterFactory adapterFactory){
		this.adapterFactory=adapterFactory;
	}
	public boolean canModify(Object element, String property) {
		CellModifier cellModifier = (CellModifier)adapterFactory.adapt(element, CellModifierClass);
		if(cellModifier!=null)return cellModifier.canModify(element, property);
		else return false;
	}

	public Object getValue(Object element, String property) {
		CellModifier cellModifier = (CellModifier)adapterFactory.adapt(element, CellModifierClass);
		if(cellModifier!=null)return cellModifier.getValue(element, property);
		return null;
	}

	public void modify(Object element, String property, Object value) {
		Object object = ((Item)element).getData();
		CellModifier cellModifier = (CellModifier)adapterFactory.adapt(object, CellModifierClass);
		if(cellModifier!=null)cellModifier.modify(null,object, property,value);
	}
	
	public void setAdapterFactory(AdapterFactory adapterFactory){
		this.adapterFactory=adapterFactory;
	}
}
