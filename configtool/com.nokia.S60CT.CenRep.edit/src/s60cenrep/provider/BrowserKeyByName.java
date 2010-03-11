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

import org.eclipse.emf.common.notify.AdapterFactory;

import cenrep.Key;

public class BrowserKeyByName extends BrowserKeyAbstract {

	public BrowserKeyByName(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public String getText(Object object) {
		String result = ((Key)object).getName();
		return result == null || result.length() == 0 ?
				getString("_UI_No_Name") :
					result;
	}

}
