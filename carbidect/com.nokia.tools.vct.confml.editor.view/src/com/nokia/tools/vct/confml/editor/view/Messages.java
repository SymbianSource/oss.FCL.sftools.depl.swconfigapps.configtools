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
 * Description: This file is part of com.nokia.tools.vct.confml.editor.view component.
 */

package com.nokia.tools.vct.confml.editor.view;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	public static String Task_Saving_Content;
	public static String Task_Loading_Content;

	public static String Job_Loading_File;

	// Errors and exceptions
	public static String Exception_Input_Not_Supported;
	public static String Exception_Input_Type_Not_Supported;
	public static String Status_Failed_To_Open_File;
	public static String MB_Text_Invalid_Location;
	public static String Message_Box_Message;
	
	// Buttons
	public static String Collapse_All_Button_Tooltip;
	public static String Expand_All_Button_Tooltip;
	public static String Reset_Button;
	
	// Popup
	public static String Add_new;

	static {
		NLS.initializeMessages(Messages.class.getName(), Messages.class);
	}
}
