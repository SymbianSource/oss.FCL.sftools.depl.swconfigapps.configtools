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

package com.nokia.tools.variant.editor.editors;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	public static String SUMMARY_ERRORS;
	public static String SUMMARY_NOTES;
	public static String SUMMARY_CHANGES;
	public static String SaveProblem;
	public static String SaveEditorHistory;
	public static String LoadProblem;
	public static String LoadEditorHistory;
	public static String LoadMemento;
	public static String CreateFileProblem;
	


	
	static {
		NLS.initializeMessages(Messages.class.getName(), Messages.class);
	}
}
