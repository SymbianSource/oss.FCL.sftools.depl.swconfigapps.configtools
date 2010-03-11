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

package com.nokia.s60ct.cli;

import java.util.Vector;

import org.eclipse.emf.ecore.EObject;

public interface IResourceManager {

	public static final String CRML = "crml";
	public static final String VD = "xml";
	public static final String CONFML = "confml";

	public abstract Object readResource(String filePath);

	public abstract <T extends EObject> T[] readAllResources(String[] paths,
			String type);

	public abstract void save(EObject eObj, String masterFilePath);

	public abstract void copyFiles(String srcFolderPath,
			String targetFolderPath, final String type);

	public void saveReportFile(Vector vReports, String reportFile);
	
	public void cleanOutputFolders(String[] folders);
}