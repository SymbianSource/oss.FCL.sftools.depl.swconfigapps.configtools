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
 * Description: This file is part of com.nokia.tools.variant.editor component.
 */

package com.nokia.tools.variant.editor.utils;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;

/**
 * Class to storage errors
 */
public class OpenCPFErrors {
	private static String fatalError = "";
	// for validation is not non fatal errors relevant, should be used later
	private static List<String> error = new ArrayList<String>();

	/**
	 * Clears list of errors + reset fatal error
	 */
	public static void clear() {
		fatalError = "";
		error = new ArrayList<String>();
	}

	/**
	 * Setter for fatal error
	 * @param msg
	 */
	public static void setFatalError(String msg) {
		if(fatalError == "")//not replace first fatal error
		fatalError = msg;
	}

	/**
	 * Adds an  error to list
	 * @param msg
	 */
	public static void addError(String msg) {
		error.add(msg);
	}

	/**
	 * not implemented
	 * @return true, if error is removed from list
	 */
	public static boolean removeError() {
		return false;
	}

	/**
	 * Getter for fatalError
	 * @return String
	 */
	public static String getFatalError() {
		return fatalError;
	}

	/**
	 * Getter for list of errors
	 * @return List<String>
	 */
	public static List<String> getError() {
		return error;
	}

	/**
	 * If fatal error exists shows classic error dialog
	 * @return false if fatal error is empty else true
	 */
	public static boolean showFatalError() {
		if (fatalError == "") {
			return false;
		}
		MessageDialog.openError(Display.getCurrent().getActiveShell(),
				"Fatal Error", fatalError);
		return true;
	}
}
