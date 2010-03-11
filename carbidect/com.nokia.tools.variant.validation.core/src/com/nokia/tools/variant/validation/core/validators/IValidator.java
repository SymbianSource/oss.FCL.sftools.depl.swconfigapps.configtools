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

package com.nokia.tools.variant.validation.core.validators;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

import com.nokia.tools.variant.validation.core.ValidationContext;
import com.nokia.tools.variant.validation.core.ValidationResult;

/**
 * Validation extension interface.
 * 
 * Validators are invoked on individual resources inside the project.
 */
public interface IValidator {
	/**
	 * Perform the validation. 
	 * 
	 * @param context
	 *            Validation context to use
	 * @param monitor
	 *            Progress monitor
	 * 
	 * @return
	 * @throws CoreException
	 */
	public ValidationResult validate(ValidationContext context,
			IProgressMonitor monitor) throws CoreException;
}
