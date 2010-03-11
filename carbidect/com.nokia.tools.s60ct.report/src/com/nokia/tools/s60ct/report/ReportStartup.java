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
package com.nokia.tools.s60ct.report;

import org.eclipse.ui.IStartup;

public class ReportStartup implements IStartup {

	public void earlyStartup() {
		try {
			ReportPlugin.getDefault().start(ReportPlugin.getDefault().getBundle().getBundleContext());
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
