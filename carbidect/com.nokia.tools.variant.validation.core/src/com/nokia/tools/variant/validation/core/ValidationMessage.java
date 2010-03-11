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
 * Description: This file is part of com.nokia.tools.variant.validation.core component.
 */

package com.nokia.tools.variant.validation.core;

public class ValidationMessage {
	private final ValidationStatus severity;
//	private final String message;
	private final MessageLocation location;
	private final String type;
	private final MarkerCategory category;
	private final int id;
	private String[] value;

	public ValidationMessage(int id, MessageLocation target, String type,
			MarkerCategory category,String... value) {
		this.value = value;
		this.severity = ValidationCorePlugin.getDefault().getSeverity(type);
		this.location = target;
		this.type = type;
		this.category = category;
		this.id = id;
	}

	public MarkerCategory getCategory() {
		return category;
	}
	
	public String getMessage() {
		return Integer.toString(id).concat(": undefined");
	}
	
	public ValidationStatus getSeverity() {
		return severity;
	}
	
	public MessageLocation getLocation() {
		return location;
	}
	
	public String getType() {
		return type;
	}
	
	public int getId(){
		return id;
	}
	
	@Override
	public String toString() {
		return severity.name() + ": " + getMessage();
	}
}
