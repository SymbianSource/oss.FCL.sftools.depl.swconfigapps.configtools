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

package cenrep.provider;

import java.util.Map;

public interface ICellEditorProvider {
	public static final int NO_EDITOR = 0;
	public static final int STRING_TEXT = 1;
	public static final int INT_TEXT = 2;
	public static final int BOOLEAN_COMBO = 3;
	public static final int COMBO_STRING = 4;
	public static final int COMBO_INT = 5;
	public static final int COMBO_RO = 6;
	public static final int FILE_BUTTON = 7;
	public static final int XPATH_BOOLEAN = 8;
	
	public int getCellEditor(Object key, int column); 
	public String[] getComboItems(Object keys,int column);
	public Map getPairItems(Object keys, int column);
	
}
