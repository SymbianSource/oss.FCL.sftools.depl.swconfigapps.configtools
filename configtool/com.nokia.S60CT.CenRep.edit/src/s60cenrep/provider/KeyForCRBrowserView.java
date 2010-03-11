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

import org.eclipse.emf.common.notify.AdapterFactory;

import cenrep.CenrepPackage;
import cenrep.provider.KeyItemProvider;

public class KeyForCRBrowserView extends KeyItemProvider{

	/*public Collection getChildrenFeatures(Object object) {
	return null;
}*/

public KeyForCRBrowserView(AdapterFactory adapterFactory){
	super(adapterFactory);
}

public Collection getChildrenFeatures(Object object) {
	Collection result =  super.getChildrenFeatures(object);
	result.remove(CenrepPackage.Literals.IACCESSABLE__ACCESS);
	result.remove(CenrepPackage.Literals.KEY__VALUE);
	return result;
}

/* (non-Javadoc)
 * @see cenrep.provider.KeyItemProvider#getText(java.lang.Object)
 */
public String getText(Object object) {
	return super.getText(object);
}


}
