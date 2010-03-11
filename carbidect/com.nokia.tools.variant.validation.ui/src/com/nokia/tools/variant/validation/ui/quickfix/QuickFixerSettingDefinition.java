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

import com.nokia.tools.variant.validation.ui.quickfix.resolution.QuickFixAddMissingNamespace;
import com.nokia.tools.variant.validation.ui.quickfix.resolution.QuickFixChangeType;
import com.nokia.tools.variant.validation.ui.quickfix.resolution.QuickFixSettingDefinition;
import com.nokia.tools.vct.common.core.utils.ArrayUtils;

public class QuickFixerSettingDefinition implements IMarkerResolutionGenerator {
	final public static String SETTING_TYPE_INT = "int";
	final public static String SETTING_TYPE_REAL = "real";
	final public static String SETTING_TYPE_STRING = "string";
	final public static String SETTING_TYPE_BOOLEAN = "boolean";
	final public static String SETTING_TYPE_DATE = "date";
	final public static String SETTING_TYPE_TIME = "time";
	final public static String SETTING_TYPE_DATETIME = "dateTime";
	final public static String SETTING_TYPE_DURATION = "duration";
	
	public static final String PREFIX = "com.nokia.tools.vct.validation.confml.";

	public static final String ID_MISSING_SETTING_TYPE = PREFIX + "vct.confml.type.setting.type.invalid";
	public static final String ID_MISSING_SETTING_TYPE2 = PREFIX + "vct.confml2.type.setting.type.invalid";
	public static final String ID_MISSING_SETTING_NAME = PREFIX + "vct.confml.type.setting.name.missing";
	public static final String ID_MISSING_SETTING_NAME2 = PREFIX + "vct.confml2.type.setting.name.missing";
	public static final String ID_MISSING_SETTING_DESCRIPTION = PREFIX + "vct.confml.type.setting.description.missing";
	public static final String ID_MISSING_SETTING_DESCRIPTION2 = PREFIX + "vct.confml2.type.setting.description.missing";
	public static final String ID_MISSING_NAMESPACE_XS = PREFIX + "vct.confml.type.setting.missing.namespace.xs";
	public static final String ID_MISSING_NAMESPACE_XI = PREFIX + "vct.confml.type.setting.missing.namespace.xi";
	
	public IMarkerResolution[] getResolutions(IMarker mk) {
		final String messageId = mk.getAttribute("problemId", "");
		String objectUri = mk.getAttribute("objectUri", "");
		ArrayList<IMarkerResolution> list = new ArrayList<IMarkerResolution>();
		
		if (!messageId.equals(""))
			System.out.println("found");
		
		if (ID_MISSING_SETTING_TYPE.equals(messageId)){
			list.add(new QuickFixChangeType("Change type to '"+SETTING_TYPE_INT+"'",objectUri,SETTING_TYPE_INT));
			list.add(new QuickFixChangeType("Change type to '"+SETTING_TYPE_BOOLEAN+"'",objectUri,SETTING_TYPE_BOOLEAN));
			list.add(new QuickFixChangeType("Change type to '"+SETTING_TYPE_REAL+"'",objectUri,SETTING_TYPE_REAL));
			list.add(new QuickFixChangeType("Change type to '"+SETTING_TYPE_STRING+"'",objectUri,SETTING_TYPE_STRING));
		}
		if (ID_MISSING_SETTING_TYPE2.equals(messageId)){
			list.add(new QuickFixChangeType("Change type to '"+SETTING_TYPE_INT+"'",objectUri,SETTING_TYPE_INT));
			list.add(new QuickFixChangeType("Change type to '"+SETTING_TYPE_BOOLEAN+"'",objectUri,SETTING_TYPE_BOOLEAN));
			list.add(new QuickFixChangeType("Change type to '"+SETTING_TYPE_REAL+"'",objectUri,SETTING_TYPE_REAL));
			list.add(new QuickFixChangeType("Change type to '"+SETTING_TYPE_STRING+"'",objectUri,SETTING_TYPE_STRING));
			list.add(new QuickFixChangeType("Change type to '"+SETTING_TYPE_DATE+"'",objectUri,SETTING_TYPE_DATE));
			list.add(new QuickFixChangeType("Change type to '"+SETTING_TYPE_TIME+"'",objectUri,SETTING_TYPE_TIME));
			list.add(new QuickFixChangeType("Change type to '"+SETTING_TYPE_DATETIME+"'",objectUri,SETTING_TYPE_DATETIME));
			list.add(new QuickFixChangeType("Change type to '"+SETTING_TYPE_DURATION+"'",objectUri,SETTING_TYPE_DURATION));
		}
		if (ID_MISSING_SETTING_NAME.equals(messageId)) {
			list.add(new QuickFixSettingDefinition("Fill in the setting name",
					objectUri, ID_MISSING_SETTING_NAME));
		}
		if (ID_MISSING_SETTING_NAME2.equals(messageId)) {
			list.add(new QuickFixSettingDefinition("Fill in the setting name",
					objectUri, ID_MISSING_SETTING_NAME2));
		}
		if (ID_MISSING_SETTING_DESCRIPTION.equals(messageId)) {
			list.add(new QuickFixSettingDefinition(
				"Fill in the setting description", objectUri,
				ID_MISSING_SETTING_DESCRIPTION));
		}
		if (ID_MISSING_SETTING_DESCRIPTION2.equals(messageId)) {
			list.add(new QuickFixSettingDefinition(
				"Fill in the setting description", objectUri,
				ID_MISSING_SETTING_DESCRIPTION2));
		}
		if (ID_MISSING_NAMESPACE_XS.equals(messageId)) {
			list.add(new QuickFixAddMissingNamespace(
				"Fill in the missing namespace", objectUri,
				ID_MISSING_NAMESPACE_XS));
		}
		if (ID_MISSING_NAMESPACE_XI.equals(messageId)) {
			list.add(new QuickFixAddMissingNamespace(
				"Fill in the missing namespace", objectUri,
				ID_MISSING_NAMESPACE_XI));
		}
	
		return ArrayUtils.createCopy(IMarkerResolution.class, list);
	}

}
