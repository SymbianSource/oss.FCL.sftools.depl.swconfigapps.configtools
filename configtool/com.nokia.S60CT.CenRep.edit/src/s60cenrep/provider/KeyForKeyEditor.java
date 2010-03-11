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
package s60cenrep.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.ITableItemLabelProvider;

import cenrep.Key;
import cenrep.provider.KeyItemProvider;

public class KeyForKeyEditor extends KeyItemProvider implements ITableItemLabelProvider {
	
	public String getText(Object object) {
		return super.getText(object);
	}
	public KeyForKeyEditor(AdapterFactory adapterFactory){
		super(adapterFactory);
	}
	public Object getColumnImage(Object object, int columnIndex) {
		if(columnIndex==0)
			return getImage(object);
		return null;
	}

	public String getColumnText(Object object, int columnIndex) {
		Key keyObj = (Key)object;
		switch(columnIndex){
		case 0://Key's name 
			return this.getText(object);
		case 1://setting's type
			return keyObj.getIdent();
		case 2: 
			return keyObj.getStrType();
		}
		return null;
	}
	
	public Collection getChildrenFeatures(Object object) {
		Collection result =  super.getChildrenFeatures(object);
		return result;
	}
	public Collection getElements(Object object) {
		List elements = (List)super.getElements(object);
		elements.add(null);
		return elements;
	}
	
	
	
}
