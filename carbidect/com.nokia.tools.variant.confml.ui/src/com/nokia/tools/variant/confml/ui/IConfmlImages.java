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
 * Description: This file is part of com.nokia.tools.variant.confml.ui component.
 */

package com.nokia.tools.variant.confml.ui;

import java.util.Map;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.osgi.framework.Bundle;

/**
 * Constants for common images.
 * 
 * This class defines constant values for shared image instances.
 * 
 * @see ConfmlUI#getImage(String)
 */
public interface IConfmlImages {
	/**
	 * Common location prefix
	 * 
	 * @see FileLocator#find(Bundle, IPath, Map) for details.
	 * */
	String PREFIX = "icons/";

	/** Decorator for inherited features and settings */
	String DEC_INHERITED = PREFIX + "dec_inherited.gif";
	/** Alert (warning) overlay */
	String DEC_ALERT = PREFIX + "dec_alert.gif";
	/** Error overlay */
	String DEC_ERROR = PREFIX + "dec_error.gif";

	/** Editor feature icon */
	String EDI_FEATURE = PREFIX + "edi_feature.gif";
	/** Editor setting icon */
	String EDI_SETTING = PREFIX + "edi_setting.gif";
	/** Editor view icon */
	String EDI_VIEW = PREFIX + "edi_view.gif";
	/** Editor view group icon */
	String EDI_GROUP = PREFIX + "edi_group.gif";
	
	/** ConfML resource icon */
	String FIL_CONFML = PREFIX + "fil_confml.gif";
	/** Image resource icon */
	String FIL_IMAGE = PREFIX + "fil_image.gif";
	/** ImplML resource icon */
	String FIL_IMPLML = PREFIX + "fil_implml.gif";
	/** XML resource icon */
	String FIL_XML = PREFIX + "fil_xml.gif";
	
	/** ConfML Container Icon */
	String FLD_CONFML = PREFIX + "fld_confml.gif";
	/** Content Container Icon */
	String FLD_CONTENT = PREFIX + "fld_content.gif";
	/** View Set Container Icon */
	String FLD_VIEWSET = PREFIX + "fld_definedviews.gif";
	/** All Features Container Icon */
	String FLD_FEATURESET = PREFIX + "fld_featuresets.gif";
	/** ImplML Container Icon */
	String FLD_IMPLML = PREFIX + "fld_implml.gif";
	/** Notes (Metadata) Container Icon */
	String FLD_NOTES = PREFIX + "fld_notes.gif";
	/** Parents (imports) Container Icon */
	String FLD_PARENTS = PREFIX + "fld_parents.gif";
	/** CPF (project) Container Icon */
	String FLD_PROJECT = PREFIX + "fld_conf_project.gif";
	/** Layer Container Icon */
	String FLD_LAYER = PREFIX + "fld_project.gif";
	/** Resources Container Icon */
	String FLD_RESOURCES = PREFIX + "fld_resources.gif";

	/** Filter Clear Icon (Disabled) */
	String ICO_CLEAR_DIS = PREFIX + "ico_clear_dis.gif";
	/** Filter Clear Icon (Enabled) */
	String ICO_CLEAR = PREFIX + "ico_clear.gif";
	/** Collapse All Icon */
	String ICO_COLLAPSEALL = PREFIX + "ico_collapseall.gif";
	/** Expand All Icon */
	String ICO_EXPANDALL = PREFIX + "ico_expandall.gif";
	/** View Filter Icon */
	String ICO_FILTER = PREFIX + "ico_filter.gif";
	/** Link with editor icon */
	String ICO_SYNC = PREFIX + "ico_sync.gif";
	
	/** RFS Feature Element */
	String RFS_FEATURE = PREFIX + "rfs_feature.gif";
	/** RFS Setting Element */
	String RFS_SETTING = PREFIX + "rfs_setting.gif";

	/** Data Feature Element */
	String DAT_FEATURE = PREFIX + "dat_feature.gif";
	/** Data Setting Element */
	String DAT_SETTING = PREFIX + "dat_setting.gif";

	/** Type Feature Element */
	String TYP_FEATURE = PREFIX + "typ_feature.gif";
	/** Type Setting Element */
	String TYP_SETTING = PREFIX + "typ_setting.gif";


	/** ConfML Navigator View */
	String TAB_CONFML_NAVIAGATOR = PREFIX + "tab_confmlnavigator.gif";
	/** Navigator View */
	String TAB_NAVIGATOR = PREFIX + "tab_navigator.gif";
	/** Preview View */
	String TAB_PREVIEW = PREFIX + "tab_preview.gif";
	/** Problems View */
	String TAB_PROBLEMS = PREFIX + "tab_problems.gif";
	/** Properties View */
	String TAB_PROPERTIES = PREFIX + "tab_properties.gif";
	
	String DELETE = PREFIX + "delete_obj.gif";
	
}
