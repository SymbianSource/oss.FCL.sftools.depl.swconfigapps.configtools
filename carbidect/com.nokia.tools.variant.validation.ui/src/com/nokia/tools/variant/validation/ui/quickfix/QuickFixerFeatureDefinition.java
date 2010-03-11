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
 * Description: This file is part of com.nokia.tools.variant.validation.ui component.
 */

package com.nokia.tools.variant.validation.ui.quickfix;

import java.util.ArrayList;

import org.eclipse.core.resources.IMarker;
import org.eclipse.ui.IMarkerResolution;
import org.eclipse.ui.IMarkerResolutionGenerator;

import com.nokia.tools.variant.validation.ui.quickfix.resolution.QuickFixFeatureDefinition;

public class QuickFixerFeatureDefinition implements IMarkerResolutionGenerator {
	public static final String PREFIX = "com.nokia.tools.vct.validation.confml.";
	
	public static final String ID_MISSING_FEATURE_NAME = PREFIX + "vct.confml.type.feature.name.missing";
	public static final String ID_MISSING_FEATURE_NAME2 = PREFIX + "vct.confml2.type.feature.name.missing";
	public static final String ID_MISSING_FEATURE_DESCRIPTION = PREFIX + "vct.confml.type.feature.description.missing";
	public static final String ID_MISSING_FEATURE_DESCRIPTION2 = PREFIX + "vct.confml2.type.feature.description.missing";

	public IMarkerResolution[] getResolutions(IMarker mk) {
		final String messageId = mk.getAttribute("problemId", "");
		String objectUri = mk.getAttribute("objectUri", "");

		ArrayList<IMarkerResolution> list = new ArrayList<IMarkerResolution>();

		if (ID_MISSING_FEATURE_NAME.equals(messageId)) {
			list.add(new QuickFixFeatureDefinition("Fill in the feature name",
					objectUri, ID_MISSING_FEATURE_NAME));
		} else if (ID_MISSING_FEATURE_NAME2.equals(messageId)) {
			list.add(new QuickFixFeatureDefinition("Fill in the feature name",
					objectUri, ID_MISSING_FEATURE_NAME2));
		} else if (ID_MISSING_FEATURE_DESCRIPTION.equals(messageId)) {
			list.add(new QuickFixFeatureDefinition(
					"Fill in the feature description", objectUri,
					ID_MISSING_FEATURE_DESCRIPTION));
		} else if (ID_MISSING_FEATURE_DESCRIPTION2.equals(messageId)) {
			list.add(new QuickFixFeatureDefinition(
					"Fill in the feature description", objectUri,
					ID_MISSING_FEATURE_DESCRIPTION2));
		}
		IMarkerResolution[] resolution = list.toArray(new IMarkerResolution[0]);

		return resolution;
	}
}
