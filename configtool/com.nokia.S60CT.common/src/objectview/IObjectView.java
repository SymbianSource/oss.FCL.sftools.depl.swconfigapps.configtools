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
package objectview;

/**
 * Provides ui for viewing objects. 
 * 
 *
 */
public interface IObjectView {

	boolean canShow(Object object); 
	
	/**
	 * Displays the object. If tryActivate flag is on, the UI 
	 * should try to activate the object in the UI. Anyway, information 
	 * related to the focus object SHOULD NOT be activated, even if
	 * the view is able to show related info. Neither the UI component
	 * associated with the view should not try to grab the UI focus, if
	 * it is not able to show the object as a whole. 
	 * 
	 * @param object
	 */
	void show(Object object, boolean tryActivate);

}
