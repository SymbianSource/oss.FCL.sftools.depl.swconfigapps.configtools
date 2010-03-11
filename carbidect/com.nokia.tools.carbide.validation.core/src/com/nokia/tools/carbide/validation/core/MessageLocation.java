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
 * Description: This file is part of com.nokia.tools.carbide.validation.core component.
 */

package com.nokia.tools.carbide.validation.core;

import org.eclipse.core.resources.IResource;

/**
 * Message location identifies the position of the message in terms of marker
 * location support.
 * 
 * This class shall contain all necessary attributes for supporting marker to
 * editor widget navigation.
 * 
 * modify as necessary
 */
public class MessageLocation {
	/** Target resource */
	private final IResource resource;
	/** Literal location string */
	private final String location;

	private final int lineNumber;
	private final int charStart;
	private final int charEnd;
	
	public MessageLocation(IResource resource) {
		this(resource, null);
	}

	public MessageLocation(IResource resource, String location) {
		this(resource, location, -1, -1, -1);
	}

	public MessageLocation(IResource resource, String location, int lineNumber, int charStart, int charEnd) {
		this.resource = resource;
		this.location = location;
		this.lineNumber= lineNumber;
		this.charStart = charStart;
		this.charEnd = charEnd;
	}

	public String getLocation() {
		return location;
	}

	public IResource getResource() {
		return resource;
	}
	
	public int getLineNumber() {
		return lineNumber;
	}
	
	public int getCharStart() {
		return charStart;
	}
	
	public int getCharEnd() {
		return charEnd;
	}
}
