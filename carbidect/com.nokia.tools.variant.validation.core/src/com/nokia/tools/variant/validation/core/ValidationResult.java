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

import java.util.ArrayList;
import java.util.List;

public class ValidationResult {
	private List<ValidationMessage> messages;

	/**
	 * At creation time is everything OK
	 */
	public ValidationResult() {
		messages = new ArrayList<ValidationMessage>();
	}

	/**
	 * 
	 * @return validation messages, if empty list then no information is
	 *         available about the result of the validation
	 */
	public List<ValidationMessage> getMessages() {
		return messages;
	}

	/**
	 * Sets validation messages about validated object
	 * 
	 * @param messages
	 */
	public void setMessages(List<ValidationMessage> messages) {
		this.messages = messages;
	}

	/**
	 * Adds validation message
	 * 
	 * @param message
	 *            validation message to add
	 */
	public void addMessage(ValidationMessage message) {
		this.messages.add(message);
	}

	/**
	 * Helper method for checking there is a fatal level message.
	 * 
	 * @return <code>true</code> if the build shall stop
	 */
	public boolean isFatal() {
		for (ValidationMessage message : messages) {
			ValidationStatus status = message.getSeverity();
			if (ValidationStatus.FATAL_ERROR.equals(status)) {
				return true;
			}
		}
		return false;
	}
	
	public void merge(ValidationResult other) {
		this.messages.addAll(other.messages);
	}
}
