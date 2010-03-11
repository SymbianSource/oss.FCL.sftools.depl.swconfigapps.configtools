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
 * Description: This file is part of com.nokia.tools.vct.confml.editor.view component.
 */

package com.nokia.tools.vct.confml.editor.view.viewers;

import java.util.Formatter;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import com.nokia.tools.variant.confml.ui.ConfmlUI;
import com.nokia.tools.variant.confml.ui.IConfmlImages;
import com.nokia.tools.vct.confml.editor.view.vemodel.EFeature;
import com.nokia.tools.vct.confml.editor.view.vemodel.ESetting;
import com.nokia.tools.vct.confml.editor.view.vemodel.EView;
import com.nokia.tools.vct.confml.editor.view.vemodel.util.ConverterUtils;

public class ConfmlTreeViewerLabelProvider extends LabelProvider {

	private static final String FMT = "%1$s (%2$s)"; 
	
	public ConfmlTreeViewerLabelProvider() {
	}
	
	public String getText(Object element) {
		
		if (element instanceof String)
		{
			return element.toString();
		}
		if (element instanceof EFeature) {
			EFeature feature = (EFeature)element;
			return new Formatter().format(FMT, feature.getName(), getFeatureOrSettingId(feature)).toString();
		}
		if (element instanceof ESetting) {
			ESetting setting = (ESetting)element;
			return new Formatter().format(FMT, setting.getName(), getFeatureOrSettingId(setting)).toString();
		}
		if (element instanceof EView) {
			String id = ConverterUtils.getViewId((EView) element);
			return ((EView) element).getName() + " (" + id + ")";
		} 
		return "unknown";
	}
	
	private String getFeatureOrSettingId(EObject obj) {
		Map.Entry<?, ?> entry = (Map.Entry<?, ?>)obj.eContainer();
		return (String)entry.getKey();
	}
	
	@Override
	public Image getImage(Object element) {
		
		if (element instanceof EFeature) {
			return ConfmlUI.getImage(IConfmlImages.EDI_FEATURE);
		} 
		else if (element instanceof ESetting) {
			return ConfmlUI.getImage(IConfmlImages.EDI_SETTING); 
		}
		else if (element instanceof EView)
		{
			return ConfmlUI.getImage(IConfmlImages.EDI_VIEW); 
		}
		else if (element instanceof String)
		{
			if (element == ConfmlTreeViewerContentProvider.ALL_FEATURES)
				return ConfmlUI.getImage(IConfmlImages.FLD_FEATURESET);  
			else if (element == ConfmlTreeViewerContentProvider.VIEWS)
				return ConfmlUI.getImage(IConfmlImages.FLD_VIEWSET);  
		}
		return super.getImage(element);
	}

}
