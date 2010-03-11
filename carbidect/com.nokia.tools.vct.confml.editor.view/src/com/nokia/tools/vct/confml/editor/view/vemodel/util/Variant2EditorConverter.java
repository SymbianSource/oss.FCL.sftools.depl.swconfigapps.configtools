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

package com.nokia.tools.vct.confml.editor.view.vemodel.util;

import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.transaction.RunnableWithResult;

import com.nokia.tools.variant.confml.core.ConfMLCore;
import com.nokia.tools.vct.common.appmodel.EAppFeature;
import com.nokia.tools.vct.common.appmodel.EAppSequenceType;
import com.nokia.tools.vct.common.appmodel.EAppSetting;
import com.nokia.tools.vct.common.appmodel.EAppSettingType;
import com.nokia.tools.vct.common.appmodel.EConfMLLayer;
import com.nokia.tools.vct.confml.editor.view.vemodel.EFeature;
import com.nokia.tools.vct.confml.editor.view.vemodel.EGroup;
import com.nokia.tools.vct.confml.editor.view.vemodel.EGroupContainer;
import com.nokia.tools.vct.confml.editor.view.vemodel.ESetting;
import com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef;
import com.nokia.tools.vct.confml.editor.view.vemodel.EView;
import com.nokia.tools.vct.confml.editor.view.vemodel.EViewEditorFactory;
import com.nokia.tools.vct.confml.editor.view.vemodel.EViewsEditorDocument;

/**
 * Converter for the application model into the editor's model. The result is a
 * copy suitable for merging or using as such.
 * 
 */
public class Variant2EditorConverter extends
		RunnableWithResult.Impl<EViewsEditorDocument> {

	private URI documentUri;

	public Variant2EditorConverter(URI documentUri) {
		this.documentUri = documentUri;
	}

	public void run() {
		buildDocumentRoot();
	}

	private void buildDocumentRoot() {
		// do not merge new application data, replace the old one and update
		// links
		EViewsEditorDocument document = EViewEditorFactory.eINSTANCE
				.createEViewsEditorDocument();
		setResult(document);

		// two maps for quick index access

		// IMPROVEMENT 
		IPath path = new Path(documentUri.toPlatformString(true));
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
		
		EConfMLLayer variant = ConfMLCore.getLayer(file); // ConverterUtils.getVariantContributor(documentUri);
		if (variant == null) {
			return;
		}

		for (Map.Entry<String, EAppFeature> featureEntry : variant.getFeatures()) {
			
			EAppFeature domainFeature = featureEntry.getValue(); 
			String featureId = featureEntry.getKey();

			EFeature feature = EViewEditorFactory.eINSTANCE.createEFeature();
			feature.setName(domainFeature.getName());

			feature
					.setDescriptionText(domainFeature.getDescription());
//			feature.setDescriptionUri(domainFeature.getType()
//					.getDescriptionUri());
//			feature.setDescriptionUriTitle(domainFeature.getType()
//					.getDescriptionTitle());

			// IMPROVEMENT add locator interface
//			URI uri = getResourceUri(domainFeature.getType());
//			feature.setResourceUri(uri);

			for (Map.Entry<String,EAppSetting> settingEntry : domainFeature.getSettings()) {
				EAppSetting domainSetting = settingEntry.getValue();
				String settingId = settingEntry.getKey();

				ESetting setting = EViewEditorFactory.eINSTANCE
						.createESetting();
				setting.setName(domainSetting.getTypeInfo().getName());

				setting.setDescriptionText(domainSetting.getTypeInfo()
						.getDescription());
				setting.setReadOnly(domainSetting.getTypeInfo().isReadOnly());
				
				if (domainSetting.getTypeInfo() instanceof EAppSequenceType)
				{
					EAppSequenceType seqSet = (EAppSequenceType)domainSetting.getTypeInfo();
					
					for (Map.Entry<String,EAppSettingType> subSettingEntry : seqSet.getTypeMap())
					{
						ESetting subSetting = EViewEditorFactory.eINSTANCE.createESetting();
						EAppSettingType subSettingType = subSettingEntry.getValue();
						
						subSetting.setName(subSettingType.getName());
						subSetting.setDescriptionText(subSettingType.getDescription());
						subSetting.setReadOnly(subSettingType.isReadOnly());
						
						setting.getSubSettings().put(subSettingEntry.getKey(), subSetting);
					}
				}
				
				// IMPROVEMENT add locator interface
//				setting.setDescriptionUri(domainSetting.getType()
//						.getDescriptionUri());
//				setting.setDescriptionUriTitle(domainSetting.getType()
//						.getDescriptionTitle());
//
//				uri = getResourceUri(domainSetting.getType());
//				setting.setResourceUri(uri);

				feature.getSettings().put(settingId, setting);
			}

			document.getFeatures().put(featureId, feature);
		}

		for (EView view : document.getViews().values()) {
			updateGroupRefs(document, view);
		}
		
	}

	private void updateGroupRefs(EViewsEditorDocument document,
			EGroupContainer container) {

		for (EGroup group : container.getGroups()) {
			// recursively process sub-groups.
			updateGroupRefs(document, group);

			for (ESettingRef ref : group.getRefs()) {
				ConverterUtils.updateIndexReference(document, ref);
			}
		}
	}
}
