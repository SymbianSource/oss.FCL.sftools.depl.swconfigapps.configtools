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

package com.nokia.tools.variant.confml.ui.views;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import com.nokia.tools.variant.confml.core.model.metadata.ECPFMetadata;
import com.nokia.tools.variant.confml.core.model.metadata.util.ECPFMetadataResourceFactoryImpl;
import com.nokia.tools.variant.confml.ui.ConfmlUI;
import com.nokia.tools.variant.confml.ui.ConverterUtils;
import com.nokia.tools.variant.confml.ui.IConfmlImages;
import com.nokia.tools.variant.confml.ui.views.ConfMLNavigator.Features;
import com.nokia.tools.variant.confml.ui.views.ConfMLNavigator.Options;
import com.nokia.tools.variant.confml.ui.views.ConfMLNavigator.Parents;
import com.nokia.tools.variant.confml.ui.views.ConfMLNavigator.Resources;
import com.nokia.tools.variant.confml.ui.views.ConfMLNavigator.Views;
import com.nokia.tools.vct.common.appmodel.EAppFeature;
import com.nokia.tools.vct.common.appmodel.EAppGroup;
import com.nokia.tools.vct.common.appmodel.EAppSetting;
import com.nokia.tools.vct.common.appmodel.EAppSettingRef;
import com.nokia.tools.vct.common.appmodel.EAppSettingType;
import com.nokia.tools.vct.common.appmodel.EAppView;
import com.nokia.tools.vct.common.appmodel.EConfMLLayer;
import com.nokia.tools.vct.common.appmodel.EConfigurationProject;
import com.nokia.tools.vct.confml.model.confml1.EConfMLDocument;
import com.nokia.tools.vct.confml.model.confml1.EFeatureData;
import com.nokia.tools.vct.confml.model.confml1.EFeatureElement;
import com.nokia.tools.vct.confml.model.confml1.EFeatureRfs;
import com.nokia.tools.vct.confml.model.confml1.EGroup;
import com.nokia.tools.vct.confml.model.confml1.EOptionElement;
import com.nokia.tools.vct.confml.model.confml1.EPropertyElement;
import com.nokia.tools.vct.confml.model.confml1.ESettingData;
import com.nokia.tools.vct.confml.model.confml1.ESettingElement;
import com.nokia.tools.vct.confml.model.confml1.ESettingRfs;
import com.nokia.tools.vct.confml.model.confml1.EViewElement;

public class ConfMLViewLabelProvider extends LabelProvider {

	public String getText(Object obj) {
		if (obj instanceof IProject)
			return getConfigurationRootName(obj);
		else if (obj instanceof Features) {
			return "All Features";
		} else if (obj instanceof Views) {
			return "Views";
		} else if (obj instanceof Resources) {
			return "Resources";
		} else if (obj instanceof Parents) {
			return "Based on";
		} else if (obj instanceof Resource) {
			return ((Resource) obj).getURI().toString();
		} else if (obj instanceof EConfigurationProject) {
			return "Project: " + ((EConfigurationProject) obj).getName();
		} else if (obj instanceof EConfMLLayer) {
			return "" + ((EConfMLLayer) obj).getName();
		} else if (obj instanceof EViewElement) {
			return ((EViewElement) obj).getName();
		} else if (obj instanceof EAppView) {
			EAppView def = (EAppView) obj;
			Map.Entry<String, EAppView> entry = (Entry<String, EAppView>) def.eContainer();
			return def.getName();// + " (" + entry.getKey() + ")";
		} else if (obj instanceof EAppGroup) {
			return ((EAppGroup) obj).getName();
		} else if (obj instanceof EGroup) {
			return ((EGroup) obj).getName();
		} else if (obj instanceof EAppFeature) {
			EAppFeature feature = (EAppFeature) obj;
			return feature.getName() + " ("
					+ ConverterUtils.getFeatureId(feature) + ")";
		} else if (obj instanceof EAppSetting) {
			EAppSetting setting = (EAppSetting) obj;
			return setting.getTypeInfo().getName() + " ("
					+ ConverterUtils.getSettingId(setting) + ")";
		} else if (obj instanceof EFeatureElement) {
			EFeatureElement type = (EFeatureElement) obj;
			return type.getName() + " (" + type.getRef() + ")";
		} else if (obj instanceof ESettingElement) {
			ESettingElement type = (ESettingElement) obj;
			if (type.getName() != null) {
				return type.getName() + " (" + type.getRef() + ")";
			} else {
				return type.getRef();
			}
		} else if (obj instanceof EOptionElement) {
			EOptionElement opt = (EOptionElement) obj;
			return "Opt: " + opt.getName();
		} else if (obj instanceof EPropertyElement) {
			EPropertyElement prop = (EPropertyElement) obj;
			return "Prop: " + prop.getName();
		} else if (obj instanceof EFeatureRfs) {
			EFeatureRfs type = (EFeatureRfs) obj;
			return type.getRef();
		} else if (obj instanceof ESettingRfs) {
			ESettingRfs type = (ESettingRfs) obj;
			return type.getRef();
		} else if (obj instanceof EFeatureData) {
			return ((EFeatureData) obj).getRef();
		} else if (obj instanceof ESettingData) {
			return ((ESettingData) obj).getRef();
		} else if (obj instanceof EAppSettingRef) {
			EAppSettingRef ref = (EAppSettingRef) obj;
			EAppSetting setting = ref.getResolved();
			EAppFeature feature = ConverterUtils.getAncestor(setting,
					EAppFeature.class);
			EAppSettingType settingType = setting.getTypeInfo();
			String name = feature.getName() + "/" + settingType.getName()
					+ " (" + ConverterUtils.getFeatureId(feature) + "/"
					+ ConverterUtils.getSettingId(setting) + ")";

			return name;
		}
		if (obj instanceof EObject) {
			return ((EObject) obj).eClass().getName();
		}
		return String.valueOf(obj);
	}

	public Image getImage(Object obj) {
		String imageKey = ISharedImages.IMG_OBJ_ELEMENT;
		if (obj instanceof EConfMLLayer) {
			return ConfmlUI.getImage(IConfmlImages.FLD_PROJECT);
			// } else if (obj instanceof ResourcesWrapper) {
			// imageKey = ISharedImages.IMG_OBJ_FOLDER;
			// } else if (obj instanceof ApplicationWrapper) {
			// imageKey = ISharedImages.IMG_OBJ_FOLDER;
			// } else if (obj instanceof ViewsWrapper) {
			// imageKey = ISharedImages.IMG_OBJ_FOLDER;
		} else if (obj instanceof EConfigurationProject) {
			imageKey = ISharedImages.IMG_OBJ_FOLDER;
		} else if (obj instanceof EConfMLDocument) {
			return ConfmlUI.getImage(IConfmlImages.FIL_CONFML);
		} else if (obj instanceof Resource) {
			imageKey = ISharedImages.IMG_OBJ_FILE;
		} else if (obj instanceof Parents) {
			return ConfmlUI.getImage(IConfmlImages.FLD_PARENTS);
		} else if (obj instanceof Resources) {
			return ConfmlUI.getImage(IConfmlImages.FLD_RESOURCES);
		} else if (obj instanceof Views) {
			return ConfmlUI.getImage(IConfmlImages.FLD_VIEWSET);
		} else if (obj instanceof Features) {
			return ConfmlUI.getImage(IConfmlImages.FLD_FEATURESET);
		} else if (obj instanceof Options) {
			imageKey = ISharedImages.IMG_OBJ_FOLDER;
		} else if (obj instanceof EAppFeature) {
			return ConfmlUI.getImage(IConfmlImages.EDI_FEATURE);
		} else if (obj instanceof EAppSetting) {
			return ConfmlUI.getImage(IConfmlImages.EDI_SETTING);
		} else if (obj instanceof EFeatureElement) {
			return ConfmlUI.getImage(IConfmlImages.TYP_FEATURE);
		} else if (obj instanceof ESettingElement) {
			ESettingElement setting = (ESettingElement)obj;
			String ref = setting.getRef();
			if (setting.eContainer() instanceof EGroup) {
				if (ref.contains("*")) {			
					return ConfmlUI.getImage(IConfmlImages.EDI_FEATURE);
				} else {
					return ConfmlUI.getImage(IConfmlImages.EDI_SETTING);
				}
			} else {
				return ConfmlUI.getImage(IConfmlImages.TYP_SETTING);
			}
		} else if (obj instanceof EFeatureData) {
			return ConfmlUI.getImage(IConfmlImages.DAT_FEATURE);
		} else if (obj instanceof EFeatureRfs) {
			return ConfmlUI.getImage(IConfmlImages.RFS_FEATURE);
		} else if (obj instanceof ESettingData) {
			return ConfmlUI.getImage(IConfmlImages.DAT_SETTING);
		} else if (obj instanceof ESettingRfs) {
			return ConfmlUI.getImage(IConfmlImages.RFS_SETTING);
		} else if (obj instanceof EAppView) {
			return ConfmlUI.getImage(IConfmlImages.EDI_VIEW);
		} else if (obj instanceof EViewElement) {
			return ConfmlUI.getImage(IConfmlImages.EDI_VIEW);
		} else if (obj instanceof EAppGroup) {
			return ConfmlUI.getImage(IConfmlImages.EDI_GROUP);
		} else if (obj instanceof EGroup) {
			return ConfmlUI.getImage(IConfmlImages.EDI_GROUP);
		} else if (obj instanceof EAppSettingRef) {
			return ConfmlUI.getImage(IConfmlImages.EDI_SETTING);
		}
		return PlatformUI.getWorkbench().getSharedImages().getImage(imageKey);
	}

	private String getConfigurationRootName(Object obj)
	{
		IProject project = (IProject)obj;
		IFile metadataFile = project.getFile(".metadata");
		URI metadataFileURI = URI.createPlatformResourceURI(metadataFile
				.getFullPath().toString(), true);
		Resource resource = new ECPFMetadataResourceFactoryImpl()
				.createResource(metadataFileURI);
		ECPFMetadata metadata = null;
		if (metadataFile.isAccessible()) {
			try {
				resource.load(null);
				metadata = (ECPFMetadata)resource.getContents().get(0);
			} catch (IOException e) {
				// e.printStackTrace();
			}
		} 

		if (metadata==null || metadata.getCpfRootFile()==null)
			return project.getName();
		else
			return project.getName()+"  ("+metadata.getCpfRootFile()+")";
	}
	
	
}
