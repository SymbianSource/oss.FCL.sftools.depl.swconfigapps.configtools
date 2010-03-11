/*
 * Copyright (c) 2009 Nokia Corporation and/or its subsidiary(-ies).
 * All rights reserved.
 * This component and the accompanying materials are made available
 * under the terms of "Eclipse Public License v1.0"
 * which accompanies this distribution, and is available
 * at the URL "http://www.eclipse.org/legal/epl-v10.html".
 * 
 * Initial Contributors:
 * Nokia Corporation - Initial contribution
 * 
 * Contributors:
 * 
 * Description: This file is part of com.nokia.tools.variant.confml.ui component.
 */

package com.nokia.tools.variant.confml.ui.actions;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	// Add new group or subgroup
	public static String Add_Action_Sibling_Group;
	public static String Add_Action_Child_Group;

	// Delete group or subgroup
	public static String Delete_Action;

	// Rename group or subgroup
	public static String Rename_Action;

	// Properties
	public static String Properties_Action;

	static {
		NLS.initializeMessages(Messages.class.getName(), Messages.class);
	}
}
