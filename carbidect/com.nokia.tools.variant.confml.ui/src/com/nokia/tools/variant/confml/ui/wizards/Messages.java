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

package com.nokia.tools.variant.confml.ui.wizards;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	public static String Add_New;
	public static String Group_Name_Label;
	public static String Description_Label;
	public static String Path_To_Icon_Label;
	public static String Browse_Button;
	
	// Errors
	public static String Image_Not_Valid_Message;
	public static String Not_Entered_All_Values_Message;
	public static String Group_Already_Exists_Message;
	
	// Type
	public static String Type_Group;
	public static String Type_Subgroup;
	public static String Type_View;
	
	
	static {
		NLS.initializeMessages(Messages.class.getName(), Messages.class);
	}
}
