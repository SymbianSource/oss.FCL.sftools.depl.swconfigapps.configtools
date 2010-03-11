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
package interfaces;

import configurationemf.EXTENSION_POLICY;

public interface ISequenceSettingMenu {
	// true, if possible to add more items
	boolean isAddAllowed(Object setting);
	// true, if child can be removed from parent
	boolean isRemoveItemAllowed(Object parent, Object child);
	// true, if setting is empty
	boolean isSequenceEmpty(Object setting);
	
	/*
	 * APPEND, PREFIX, REPLACE
	 */
	EXTENSION_POLICY getExtensionPolicy(Object setting);
	
	// true if policy is allowed to be set
	boolean isAllowedPolicy(Object setting, EXTENSION_POLICY policy);
}
