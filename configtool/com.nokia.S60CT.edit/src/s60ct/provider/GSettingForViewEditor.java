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
package s60ct.provider;

import java.util.Collection;

import org.eclipse.emf.common.notify.AdapterFactory;

import configurationemf.provider.GSettingItemProvider;

public class GSettingForViewEditor extends GSettingItemProvider {

	public GSettingForViewEditor(AdapterFactory adapterFactory) {
		super(adapterFactory);

	}

	public Object getColumnImage(Object object, int columnIndex) {
		if(columnIndex == 0)
			return getImage(object);
		return null;
	}

	public String getColumnText(Object object, int columnIndex) {
		switch(columnIndex){
		case 0://setting's name 
			return this.getText(object);
		}
		return null;
	}
	public Collection getChildrenFeatures(Object object) {
		Collection result =  super.getChildrenFeatures(object);
		return result;
	}
}
