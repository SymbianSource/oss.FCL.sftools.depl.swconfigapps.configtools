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
 * Description: This file is part of com.nokia.tools.variant.viewer component.
 */

package com.nokia.tools.variant.viewer.validation;

public class Result implements IResult {	
	
	private String errorDescription;

	/**
	 * 
	 * @param strings
	 */
	public  Result constructMessage(String ... strings){
		StringBuffer sb=new StringBuffer();
		for (int i = 0; i < strings.length; i++) {
			sb.append(strings[i]);
		}
		errorDescription=sb.toString();
		return this;
	}
	
	
	public String getErrorDescription() {
		return errorDescription;
	}

}
