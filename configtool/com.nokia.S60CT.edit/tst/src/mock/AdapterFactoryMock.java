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
package mock;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notifier;

public class AdapterFactoryMock implements AdapterFactory {

	public AdapterFactoryMock() {
		
	}

	
	public Object adapt(Object object, Object type) {
		
		return null;
	}

	
	public Adapter adapt(Notifier target, Object type) {
		
		return null;
	}

	
	public void adaptAllNew(Notifier notifier) {
		

	}

	
	public Adapter adaptNew(Notifier target, Object type) {
		
		return null;
	}

	
	public boolean isFactoryForType(Object type) {
		
		return false;
	}

}
