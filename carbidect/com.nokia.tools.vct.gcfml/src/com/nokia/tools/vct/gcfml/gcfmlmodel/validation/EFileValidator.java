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
 * Description: This file is part of com.nokia.tools.vct.gcfml component.
 */

package com.nokia.tools.vct.gcfml.gcfmlmodel.validation;

import org.eclipse.emf.common.util.EList;

import com.nokia.tools.vct.gcfml.gcfmlmodel.EOutput;
import com.nokia.tools.vct.gcfml.gcfmlmodel.ESetting;
import com.nokia.tools.vct.gcfml.gcfmlmodel.EStylesheet;

/**
 * A sample validator interface for {@link com.nokia.tools.vct.gcfml.gcfmlmodel.EFile}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface EFileValidator {
	boolean validate();

	boolean validateName(String value);
	boolean validateTarget(String value);
	boolean validateSetting(EList<ESetting> value);

	boolean validateFoo(String value);

	boolean validateXslt(String value);

	boolean validateStylesheet(EStylesheet value);

	boolean validateOutput(EOutput value);

	boolean validateSetting(String value);

	boolean validateSetting(ESetting value);
}
