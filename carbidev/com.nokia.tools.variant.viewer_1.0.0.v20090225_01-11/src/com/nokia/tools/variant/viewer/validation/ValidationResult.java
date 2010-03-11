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

import java.util.ArrayList;
import java.util.List;

public class ValidationResult {

	private List<IResult> resultList;
	private String message;

	public ValidationResult(IResult result) {
		resultList = new ArrayList<IResult>();
		resultList.add(result);
	}

	public ValidationResult(IResult result, String message) {
		resultList = new ArrayList<IResult>();
		resultList.add(result);
		this.message = message;
	}

	public ValidationResult(List<IResult> result) {
		this.resultList = result;
	}

	public ValidationResult(List<IResult> result, String message) {
		this.resultList = result;
		this.message = message;
	}

	public List<IResult> getResult() {
		return resultList;
	}

	public String getMessage() {
		return message;
	}

/*	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ValidationResult) {
			ValidationResult vr = (ValidationResult) obj;
			if (vr.getResult().ordinal() == result.ordinal()) {
				return true;
			} else {
				return false;
			}
		} else {
			throw new RuntimeException();
		}
	}*/

	public String getValidationMessage() {

		if (getResult().contains(EResult.CONSTRAINT_FAILED)) {
			StringBuffer sb = new StringBuffer();
			for (IResult r : getResult()) {
				sb.append(r.getErrorDescription() + " " + getMessage()+ "\n");
			}
			return sb.toString();
		} if (getResult().contains(EResult.THEME_VERSION_NOT_MATCH)) {
			StringBuffer sb = new StringBuffer();
			for (IResult r : getResult()) {
				sb.append(r.getErrorDescription() + "" + getMessage()+ "\n");
			}
			return sb.toString();
		} else if (getResult().contains(EResult.VALID)) {
			return "";
		} else {
			StringBuffer sb = new StringBuffer();
			for (IResult r : getResult()) {
				sb.append(r.getErrorDescription()+ "\n");
			}
			return sb.toString();
		}
	}
}
