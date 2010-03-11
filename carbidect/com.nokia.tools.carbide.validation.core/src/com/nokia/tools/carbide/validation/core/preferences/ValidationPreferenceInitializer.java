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

package com.nokia.tools.carbide.validation.core.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;

import com.nokia.tools.carbide.validation.core.ConfmlMarkerUtils;
import com.nokia.tools.carbide.validation.core.ValidationCorePlugin;

public class ValidationPreferenceInitializer extends
		AbstractPreferenceInitializer {

	@Override
	public void initializeDefaultPreferences() {
		
		ValidationCorePlugin.getDefault().getPreferenceStore().setDefault(ConfmlMarkerUtils.CONFML_PROBLEM_MARKER, "ERROR");
		
	}

}
