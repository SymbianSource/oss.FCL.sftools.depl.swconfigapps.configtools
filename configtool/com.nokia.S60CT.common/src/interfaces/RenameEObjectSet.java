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

public interface RenameEObjectSet {
	public Object[][] getTypes();
	
	public static final int CLASS_INDEX=0;
	public static final int NAME_ATTRIBUTE_INDEX=1;
	public static final int RO_ATTRIBUTE_INDEX=2;
}
