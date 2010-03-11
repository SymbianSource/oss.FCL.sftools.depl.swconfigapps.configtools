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

package com.nokia.tools.s60ct.build.builder.utils;

public class CommonFolderApis {

	public static final String BUILD_FOLDER = "build";
	public static String RESULT_FOLDER = BUILD_FOLDER;
	public static final String UTF_8_ID = "UTF-8";
	public static final String UTF_8_BOM = "\uEFBBBF";
	public static final String UTF_16BE_ID = "UTF-16BE";
	public static final String UTF_16BE_BOM = "\uFFFE";
	public static final String UTF_16LE_ID = "UTF-16LE";
	public static final String UTF_16LE_BOM = "\uFEFF";
	
	public static String getFileSaveLayer(String layerUri) {
		String buildUri = getLayerFolderName(layerUri) + "/" + BUILD_FOLDER;
		return buildUri;
	}

	public static String getLayerFolderName(String layerUri){
		if(layerUri.charAt(layerUri.length()-1) == '/')
			layerUri = layerUri.substring(0, layerUri.length()-1);
		int lastIndexOf = layerUri.lastIndexOf("/");
		return layerUri.substring(lastIndexOf+1);
	}
	
}
