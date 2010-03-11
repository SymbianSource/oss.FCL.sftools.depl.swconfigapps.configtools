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
import java.util.Map;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.ITableItemLabelProvider;

import configurationemf.provider.ParentGroupItemProvider;

public class GroupForSettingEditor extends ParentGroupItemProvider implements ITableItemLabelProvider {

	/* (non-Javadoc)
	 * @see configurationemf.IDynamicColumnProvider#getConfValues(java.lang.Object)
	 */
	public Map getConfValues(Object object) {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.edit.provider.ITableItemLabelProvider#getColumnImage(java.lang.Object, int)
	 */
	public Object getColumnImage(Object object, int arg1) {
		return getImage(object);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.edit.provider.ITableItemLabelProvider#getColumnText(java.lang.Object, int)
	 */
	public String getColumnText(Object object, int arg1) {
		return this.getText(object);
	}

	public GroupForSettingEditor(AdapterFactory adapterFactory) {
		super(adapterFactory);
		
	}


	/* (non-Javadoc)
	 * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#getElements(java.lang.Object)
	 */
	public Collection getElements(Object arg0) {
		Collection collection =  super.getElements(arg0);
		return collection;
		
	}
	
	
	
}
