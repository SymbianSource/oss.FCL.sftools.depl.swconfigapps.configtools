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

package com.nokia.s60ct.cenrep.gui.ExternalActions;

import org.eclipse.emf.common.util.URI;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;

import com.nokia.s60ct.cenrep.gui.CenRepPlugin;
import com.nokia.s60ct.cenrep.gui.Actions.OpenCrMLFile;

public class QuickFixOpenCRMLFile {

	public QuickFixOpenCRMLFile(Shell shell)
	{
		String[] fileExtensionFilter = new String[1];
		fileExtensionFilter[0]="*." + CenRepPlugin.INSTANCE.getString("_UI_CenrepFilenameExtension");
		
		String[] filePath = OpenCrMLFile.openFilePathDialog(shell, fileExtensionFilter,SWT.OPEN|SWT.MULTI);
		URI[] uris = new URI[filePath.length];
		for (int i = 0 ; i < uris.length ; i++)
			uris[i] = URI.createFileURI(filePath[i]);
		
		OpenCrMLFile.openEditor(uris);
	}
}
