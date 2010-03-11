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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.nokia.tools.vct.confml.editor.view.vemodel.EDescriptionContainer;
import com.nokia.tools.vct.confml.editor.view.vemodel.EGroup;
import com.nokia.tools.vct.confml.editor.view.vemodel.EGroupContainer;
import com.nokia.tools.vct.confml.editor.view.vemodel.EGroupEntry;
import com.nokia.tools.vct.confml.editor.view.vemodel.EIconContainer;
import com.nokia.tools.vct.confml.editor.view.vemodel.ERefOption;
import com.nokia.tools.vct.confml.editor.view.vemodel.ERefProperty;
import com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef;
import com.nokia.tools.vct.confml.editor.view.vemodel.EView;
import com.nokia.tools.vct.confml.editor.view.vemodel.EViewsEditorDocument;
import com.nokia.tools.vct.confml.model.confml1.EConfML1Factory;
import com.nokia.tools.vct.confml.model.confml1.EConfMLDocument;
import com.nokia.tools.vct.confml.model.confml1.EConfigurationElement;
import com.nokia.tools.vct.confml.model.confml1.EDescriptionElement;
import com.nokia.tools.vct.confml.model.confml1.EIconElement;
import com.nokia.tools.vct.confml.model.confml1.EOptionElement;
import com.nokia.tools.vct.confml.model.confml1.EPropertyElement;
import com.nokia.tools.vct.confml.model.confml1.ESettingElement;
import com.nokia.tools.vct.confml.model.confml1.EViewElement;
import com.nokia.tools.vct.confml.model.confml1.include.EConfMLIncludeFactory;
import com.nokia.tools.vct.confml.model.confml1.include.EInclude;
import com.nokia.tools.vct.confml.model.confml2.EConfML2Document;
import com.nokia.tools.vct.confml.model.confml2.EConfML2Factory;
import com.nokia.tools.vct.confml.model.xsd.ELength;
import com.nokia.tools.vct.confml.model.xsd.EMaxExclusive;
import com.nokia.tools.vct.confml.model.xsd.EMaxInclusive;
import com.nokia.tools.vct.confml.model.xsd.EMaxLength;
import com.nokia.tools.vct.confml.model.xsd.EMinExclusive;
import com.nokia.tools.vct.confml.model.xsd.EMinInclusive;
import com.nokia.tools.vct.confml.model.xsd.EMinLength;
import com.nokia.tools.vct.confml.model.xsd.EPattern;
import com.nokia.tools.vct.confml.model.xsd.EXSDFacetFactory;

/**
 * Class merges the view editor's model into the persistence container. The
 * class shall be invoked within the transaction context for view editor's
 * model. IMPROVEMENT do we need to perform incremental merging of view's
 * contents instead of generic replacement?
 */
class Editor2PersistenceConverter implements Runnable {

	EViewsEditorDocument document;
	Resource resource;

	public Editor2PersistenceConverter(EViewsEditorDocument source,
			Resource target) {
		this.resource = target;
		this.document = source;
	}

	public void run() {
		EObject object = resource.getContents().get(0);
		if (object instanceof EConfMLDocument) {
			EConfMLDocument document = (EConfMLDocument) object;
			document.getConfiguration().getViews().clear();
			serializeViews(document.getConfiguration());
		} else if (object instanceof EConfML2Document) {
			EConfML2Document document = (EConfML2Document) object;
			document.getConfiguration().getViews().clear();
			serializeViews(document.getConfiguration());
		}
	}

	private void serializeViews(EConfigurationElement configuration) {
		for (Map.Entry<String, EView> entry : document.getViews().entrySet()) {
			EViewElement viewDef = EConfML1Factory.eINSTANCE
					.createEViewElement();

			EView view = entry.getValue();

			viewDef.setId(entry.getKey());
			viewDef.setName(view.getName());

			serializeDescriptionContainer(view, viewDef);
			serializeIconContainer(view, viewDef);

			serializeGroupsAndIncludedViews(view, viewDef);

			configuration.getViews().add(viewDef);
		}
	}

	private void serializeViews(
			com.nokia.tools.vct.confml.model.confml2.EConfigurationElement configuration) {
		for (Map.Entry<String, EView> entry : document.getViews().entrySet()) {
			com.nokia.tools.vct.confml.model.confml2.EViewElement viewDef = EConfML2Factory.eINSTANCE
					.createEViewElement();

			EView view = entry.getValue();

			viewDef.setId(entry.getKey());
			viewDef.setName(view.getName());

			serializeDescriptionContainer(view, viewDef);
			serializeIconContainer(view, viewDef);

			serializeGroupsAndIncludedViews(view, viewDef);

			configuration.getViews().add(viewDef);
		}
	}

	private void serializeGroupsAndIncludedViews(EGroupContainer source,
			com.nokia.tools.vct.confml.model.confml1.EGroupContainer target) {
		for (EGroupEntry entry : source.getGroupsAndViews()) {
			if (entry instanceof EGroup)
			{
				EGroup group = (EGroup)entry;
				com.nokia.tools.vct.confml.model.confml1.EGroup groupDef = EConfML1Factory.eINSTANCE
						.createEGroup();
	
				groupDef.setName(group.getName());
	
				serializeDescriptionContainer(group, groupDef);
				serializeIconContainer(group, groupDef);
	
				serializeGroupsAndIncludedViews(group, groupDef);
	
				for (ESettingRef ref : group.getRefs()) {
					com.nokia.tools.vct.confml.model.confml1.ESettingElement refDef = EConfML1Factory.eINSTANCE
							.createESettingElement();
	
					refDef.setRef(ref.getFeatureId() + "/" + ref.getSettingId());
					refDef.setName(maskEmptyString(ref.getName()));
					serializeDescriptionContainer(ref, refDef);
					serializeConstraints(ref, refDef);
					serializePropsNOpts(ref, refDef);
	
					groupDef.getSettings().add(refDef);
				}
	
				target.getGroups().add(groupDef);
			}
			else if (entry instanceof EView)
			{
				EView view = (EView)entry;
				EInclude includedView = EConfMLIncludeFactory.eINSTANCE.createEInclude();
				
				String uri = view.getInclusionURI();
				includedView.setHref(uri);
				
				target.getIncludes().add(includedView);
			}
		}
	}

	private void serializePropsNOpts(ESettingRef ref, ESettingElement refDef) {
		for (ERefOption src : ref.getOptions()) {
			EOptionElement optionElement = EConfML1Factory.eINSTANCE
					.createEOptionElement();
			optionElement.setMap(maskEmptyString(src.getMap()));
			optionElement.setName(maskEmptyString(src.getName()));
			optionElement.setRelevant(maskEmptyString(src.getRelevant()));
			optionElement.setValue(maskEmptyString(src.getValue()));
			refDef.getOptions().add(optionElement);
		}
		for (ERefProperty src : ref.getProperties()) {
			EPropertyElement propertyElement = EConfML1Factory.eINSTANCE
					.createEPropertyElement();
			propertyElement.setName(maskEmptyString(src.getName()));
			propertyElement.setUnit(maskEmptyString(src.getUnit()));
			propertyElement.setValue(maskEmptyString(src.getValue()));
			refDef.getProperties().add(propertyElement);
		}
	}

	private void serializePropsNOpts(ESettingRef ref,
			com.nokia.tools.vct.confml.model.confml2.ESettingElement refDef) {
		for (ERefOption src : ref.getOptions()) {
			com.nokia.tools.vct.confml.model.confml2.EOptionElement optionElement = EConfML2Factory.eINSTANCE
					.createEOptionElement();
			optionElement.setMap(maskEmptyString(src.getMap()));
			optionElement.setName(maskEmptyString(src.getName()));
			optionElement.setRelevant(maskEmptyString(src.getRelevant()));
			optionElement.setValue(maskEmptyString(src.getValue()));
			refDef.getOptions().add(optionElement);
		}
		for (ERefProperty src : ref.getProperties()) {
			com.nokia.tools.vct.confml.model.confml2.EPropertyElement propertyElement = EConfML2Factory.eINSTANCE
					.createEPropertyElement();
			propertyElement.setName(maskEmptyString(src.getName()));
			propertyElement.setUnit(maskEmptyString(src.getUnit()));
			propertyElement.setValue(maskEmptyString(src.getValue()));
			refDef.getProperties().add(propertyElement);
		}
	}

	private void serializeConstraints(ESettingRef ref, ESettingElement refDef) {
		String tmp = null; 
			
		
		
		if (ref.getLength()!=null)
		{
			tmp = ref.getLength().trim();
			if (tmp.length() > 0) {
				ELength length = EXSDFacetFactory.eINSTANCE.createELength();
				length.setValue(tmp);
				refDef.getLength().add(length);
			}
		}
		
		
		if (ref.getMaxLength()!= null)
		{
			tmp = ref.getMaxLength().trim();
			if (tmp.length() > 0) {
				EMaxLength length = EXSDFacetFactory.eINSTANCE.createEMaxLength();
				length.setValue(tmp);
				refDef.getMaxLength().add(length);
			}
		}
		
		if (ref.getMinLength()!= null)
		{
			tmp = ref.getMinLength().trim();
			if (tmp.length() > 0) {
				EMinLength length = EXSDFacetFactory.eINSTANCE.createEMinLength();
				length.setValue(tmp);
				refDef.getMinLength().add(length);
			}
		}

		if (ref.getMaxExclusive()!= null)
		{
			tmp = ref.getMaxExclusive().trim();
			if (tmp.length() > 0) {
				EMaxExclusive facet = EXSDFacetFactory.eINSTANCE
						.createEMaxExclusive();
				facet.setValue(tmp);
				refDef.getMaxExclusive().add(facet);
			}
		}
		
		if (ref.getMinExclusive()!= null)
		{
			tmp = ref.getMinExclusive().trim();
			if (tmp.length() > 0) {
				EMinExclusive facet = EXSDFacetFactory.eINSTANCE
						.createEMinExclusive();
				facet.setValue(tmp);
				refDef.getMinExclusive().add(facet);
			}
		}

		if (ref.getMaxInclusive()!= null)
		{
			tmp = ref.getMaxInclusive().trim();
			if (tmp.length() > 0) {
				EMaxInclusive facet = EXSDFacetFactory.eINSTANCE
						.createEMaxInclusive();
				facet.setValue(tmp);
				refDef.getMaxInclusive().add(facet);
			}
		}

		if (ref.getMinInclusive()!=null)
		{
			tmp = ref.getMinInclusive().trim();
			if (tmp.length() > 0) {
				EMinInclusive facet = EXSDFacetFactory.eINSTANCE
						.createEMinInclusive();
				facet.setValue(tmp);
				refDef.getMinInclusive().add(facet);
			}
		}
		
		if (ref.getPatterns()!=null)
		{
		tmp = ref.getPatterns().trim();
			if (tmp.length() > 0) {
				String[] tokens = tmp.split("\n");
				for (String tok : tokens) {
					tok = tok.trim();
					if (tok.length() > 0) {
						EPattern facet = EXSDFacetFactory.eINSTANCE
								.createEPattern();
						facet.setValue(tok);
						refDef.getPattern().add(facet);
					}
				}
			}
		}
	}

	private void serializeConstraints(ESettingRef ref,
			com.nokia.tools.vct.confml.model.confml2.ESettingElement refDef) {
		
		String tmp = null;
		
		if ( ref.getLength() != null)
		{
			tmp = ref.getLength().trim();
			if (tmp.length() > 0) {
				ELength length = EXSDFacetFactory.eINSTANCE.createELength();
				length.setValue(tmp);
				refDef.getLength().add(length);
			}
		}
		
		
		if (ref.getMaxLength() != null)
		{
			tmp = ref.getMaxLength().trim();
			if (tmp.length() > 0) {
				EMaxLength length = EXSDFacetFactory.eINSTANCE.createEMaxLength();
				length.setValue(tmp);
				refDef.getMaxLength().add(length);
			}
		}

		
		if (ref.getMinLength() != null)
		{
			tmp = ref.getMinLength().trim();
			if (tmp.length() > 0) {
				EMinLength length = EXSDFacetFactory.eINSTANCE.createEMinLength();
				length.setValue(tmp);
				refDef.getMinLength().add(length);
			}
		}

		if (ref.getMaxExclusive() != null)
		{
			tmp = ref.getMaxExclusive().trim();
			if (tmp.length() > 0) {
				EMaxExclusive facet = EXSDFacetFactory.eINSTANCE
						.createEMaxExclusive();
				facet.setValue(tmp);
				refDef.getMaxExclusive().add(facet);
			}
		}

		if (ref.getMinExclusive() != null)
		{
			tmp = ref.getMinExclusive().trim();
			if (tmp.length() > 0) {
				EMinExclusive facet = EXSDFacetFactory.eINSTANCE
						.createEMinExclusive();
				facet.setValue(tmp);
				refDef.getMinExclusive().add(facet);
			}
		}

		if (ref.getMaxInclusive()!= null)
		{
			tmp = ref.getMaxInclusive().trim();
			if (tmp.length() > 0) {
				EMaxInclusive facet = EXSDFacetFactory.eINSTANCE
						.createEMaxInclusive();
				facet.setValue(tmp);
				refDef.getMaxInclusive().add(facet);
			}
		}

		if (ref.getMinInclusive()!= null)
		{
			tmp = ref.getMinInclusive().trim();
			if (tmp.length() > 0) {
				EMinInclusive facet = EXSDFacetFactory.eINSTANCE
						.createEMinInclusive();
				facet.setValue(tmp);
				refDef.getMinInclusive().add(facet);
			}
		}

		if (ref.getPatterns()!= null)
		{
			tmp = ref.getPatterns().trim();
			if (tmp.length() > 0) {
				String[] tokens = tmp.split("\n");
				for (String tok : tokens) {
					tok = tok.trim();
					if (tok.length() > 0) {
						EPattern facet = EXSDFacetFactory.eINSTANCE
								.createEPattern();
						facet.setValue(tok);
						refDef.getPattern().add(facet);
					}
				}
			}
		}
	}

	private String maskEmptyString(String value) {
		return value != null && value.length() == 0 ? null : value;
	}

	private void serializeGroupsAndIncludedViews(EGroupContainer source,
			com.nokia.tools.vct.confml.model.confml2.EGroupContainer target) {
		for (EGroupEntry entry : source.getGroupsAndViews()) {
			if (entry instanceof EGroup)
			{
				EGroup group = (EGroup)entry;
				com.nokia.tools.vct.confml.model.confml2.EGroup groupDef = EConfML2Factory.eINSTANCE
						.createEGroup();
	
				groupDef.setName(group.getName());
	
				serializeDescriptionContainer(group, groupDef);
				serializeIconContainer(group, groupDef);
	
				serializeGroupsAndIncludedViews(group, groupDef);
	
				for (ESettingRef ref : group.getRefs()) {
					com.nokia.tools.vct.confml.model.confml2.ESettingElement refDef = EConfML2Factory.eINSTANCE
							.createESettingElement();
	
					refDef.setRef(ref.getFeatureId() + "/" + ref.getSettingId());
					refDef.setName(maskEmptyString(ref.getName()));
					serializeDescriptionContainer(ref, refDef);
					serializeConstraints(ref, refDef);
					serializePropsNOpts(ref, refDef);
	
					groupDef.getSettings().add(refDef);
				}
	
				target.getGroups().add(groupDef);
			}
			else if (entry instanceof EView)
			{
				EView view = (EView)entry;
				EInclude includedView = EConfMLIncludeFactory.eINSTANCE.createEInclude();
				
				String uri = view.getInclusionURI();
				includedView.setHref(uri);
				
				target.getIncludes().add(includedView);
			}
		}
	}

	static void serializeDescriptionContainer(
			EDescriptionContainer source,
			com.nokia.tools.vct.confml.model.confml1.EDescriptionContainer target) {
		if (source.getDescriptionText() != null && !source.getDescriptionText().equals("")) {
			EDescriptionElement descr = EConfML1Factory.eINSTANCE
					.createEDescriptionElement();
			descr.setDescription(source.getDescriptionText());
			target.getDescriptions().add(descr);
		}
		if (source.getDescriptionUri() != null) {
			EDescriptionElement descr = EConfML1Factory.eINSTANCE
					.createEDescriptionElement();
			descr.setHref(source.getDescriptionUri().toString());
			descr.setTitle(source.getDescriptionUriTitle());
			target.getDescriptions().add(descr);
		}
	}

	static void serializeDescriptionContainer(
			EDescriptionContainer source,
			com.nokia.tools.vct.confml.model.confml2.EDescriptionContainer target) {
		if (source.getDescriptionText() != null && !source.getDescriptionText().equals("")) {
			com.nokia.tools.vct.confml.model.confml2.EDescriptionElement descr = EConfML2Factory.eINSTANCE
					.createEDescriptionElement();
			descr.setDescription(source.getDescriptionText());
			target.getDescriptions().add(descr);
		}
		if (source.getDescriptionUri() != null) {
			com.nokia.tools.vct.confml.model.confml2.EDescriptionElement descr = EConfML2Factory.eINSTANCE
					.createEDescriptionElement();
			descr.setHref(source.getDescriptionUri().toString());
			descr.setTitle(source.getDescriptionUriTitle());
			target.getDescriptions().add(descr);
		}
	}

	static void serializeIconContainer(EIconContainer source,
			com.nokia.tools.vct.confml.model.confml1.EIconContainer target) {
		if (source.getIconUri() != null) {
			EIconElement icon = EConfML1Factory.eINSTANCE.createEIconElement();
			icon.setHref(source.getIconUri().toString());
			icon.setTitle(source.getIconUriTitle());
			target.getIcons().add(icon);
		}
	}

	static void serializeIconContainer(EIconContainer source,
			com.nokia.tools.vct.confml.model.confml2.EIconContainer target) {
		if (source.getIconUri() != null) {
			com.nokia.tools.vct.confml.model.confml2.EIconElement icon = EConfML2Factory.eINSTANCE
					.createEIconElement();
			icon.setHref(source.getIconUri().toString());
			icon.setTitle(source.getIconUriTitle());
			target.getIcons().add(icon);
		}
	}
}
