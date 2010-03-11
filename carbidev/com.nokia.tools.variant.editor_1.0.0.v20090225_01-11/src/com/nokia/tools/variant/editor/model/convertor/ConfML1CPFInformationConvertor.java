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
 * Description: This file is part of com.nokia.tools.variant.editor component.
 */

package com.nokia.tools.variant.editor.model.convertor;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.nokia.tools.variant.common.core.utils.ArrayUtils;
import com.nokia.tools.variant.editor.cpfInfo.CPFInformation;
import com.nokia.tools.variant.editor.cpfInfo.CpfInfoFactory;
import com.nokia.tools.vct.confml.model.confml1.EConfML1Factory;
import com.nokia.tools.vct.confml.model.confml1.EConfMLDocument;
import com.nokia.tools.vct.confml.model.confml1.EConfigurationElement;
import com.nokia.tools.vct.confml.model.confml1.EDescriptionElement;
import com.nokia.tools.vct.confml.model.confml1.EIconElement;
import com.nokia.tools.vct.confml.model.confml1.ELinkElement;
import com.nokia.tools.vct.confml.model.confml1.EMetaContent;
import com.nokia.tools.vct.confml.model.confml1.EMetaElement;
import com.nokia.tools.vct.confml.model.confml1.include.EInclude;

public class ConfML1CPFInformationConvertor implements CPFInformationConvertor {

	public void copyCPFInformationToResource(Resource resource,
			CPFInformation cpfi) {
		
		EList<EObject> contents = resource.getContents();
		EConfigurationElement ce = null; 
		if (contents.size() == 0) {
			ce = EConfML1Factory.eINSTANCE.createEConfigurationElement();
			contents.add(ce);
		} else {
			ce = (EConfigurationElement) ((EConfMLDocument)contents.get(0)).getConfiguration();
		}
		EList<EMetaElement> metas = ce.getMetas();
		
		EMetaElement me = null;
		if (metas.size() > 0) {
			metas.clear();
			me = EConfML1Factory.eINSTANCE.createEMetaElement();
			metas.add(me);
		} else {
			me = EConfML1Factory.eINSTANCE.createEMetaElement();
			metas.add(me);
		}

		EMetaContent customer = EConfML1Factory.eINSTANCE.createEMetaContent();
		customer.setValue(cpfi.getCustomer());
		me.getCustomer().clear();
		me.getCustomer().add(customer);

		EMetaContent owner = EConfML1Factory.eINSTANCE.createEMetaContent();
		owner.setValue(cpfi.getOwner());
		me.getOwner().clear();
		me.getOwner().add(owner);
		
		EMetaContent version = EConfML1Factory.eINSTANCE.createEMetaContent();
		version.setValue(cpfi.getVersion());
		me.getVersion().clear();
		me.getVersion().add(version);
		
		EMetaContent platform = EConfML1Factory.eINSTANCE.createEMetaContent();
		platform.setValue(cpfi.getPlatform());
		me.getPlatform().clear();
		me.getPlatform().add(platform);
		
		EMetaContent date = EConfML1Factory.eINSTANCE.createEMetaContent();
		date.setValue(cpfi.getDate());
		me.getDate().clear();
		me.getDate().add(date);

		EMetaContent release = EConfML1Factory.eINSTANCE.createEMetaContent();
		release.setValue(cpfi.getRelease());
		me.getRelease().clear();
		me.getRelease().add(release);

		EMetaContent product = EConfML1Factory.eINSTANCE.createEMetaContent();
		product.setValue(cpfi.getProduct());
		me.getProduct().clear();
		me.getProduct().add(product);

	
		// match author(in summary) 2 editor(in meta)
		EMetaContent editor = EConfML1Factory.eINSTANCE.createEMetaContent();
		editor.setValue(cpfi.getAuthor());
		me.getEditor().clear();
		me.getEditor().add(editor);

		EMetaContent status = EConfML1Factory.eINSTANCE.createEMetaContent();
		status.setValue(cpfi.getStatus());
		me.getStatus().clear();
		me.getStatus().add(status);

		EDescriptionElement description = EConfML1Factory.eINSTANCE.createEDescriptionElement();
		description.setDescription(cpfi.getDescription());
		ce.getDescriptions().clear();
		ce.getDescriptions().add(description);

	}

	
	
	public CPFInformation loadCPFInformationFromResource(Resource resource) {
		CPFInformation cpfi = CpfInfoFactory.eINSTANCE.createCPFInformation();

		EList<EObject> contents = resource.getContents();
		if (contents.size() > 0) {
			EObject root = contents.get(0);
			if (root instanceof EConfMLDocument) {
				EConfMLDocument doc = (EConfMLDocument) root;
				EConfigurationElement ce = doc.getConfiguration();
				
				EList<EInclude> includes = ce.getIncludes();
				String layerInfo = "Layers:\n---------\n";
				for (int i = 0 ; i < includes.size() ; i++) {
					EInclude include = includes.get(i);
					String href = include.getHref();
					if (i > 0) {
						layerInfo += "\n";
					}
					layerInfo += "Layer " + (i+1) + ": ";
					layerInfo += href;
				}
				cpfi.setLayerPopupInfoText(layerInfo);
				EList<EMetaElement> metas = ce.getMetas();
				
				if (metas.size() > 0) {
					EMetaElement me = metas.get(0);
					EList<EDescriptionElement> descriptions = ce.getDescriptions();
					EList<EMetaContent> customers = me.getCustomer();
					EList<EMetaContent> dates = me.getDate();
					EList<EMetaContent> editors = me.getEditor();
					EList<EIconElement> icons = me.getIcons();
					EList<EMetaContent> ids = me.getId();
					EList<ELinkElement> links = me.getLinks();
					EList<EMetaContent> owners = me.getOwner();
					EList<EMetaContent> platforms = me.getPlatform();
					EList<EMetaContent> products = me.getProduct();
					EList<EMetaContent> releases = me.getRelease();
					EList<EMetaContent> statuses = me.getStatus();
					EList<EMetaContent> versions = me.getVersion();
	
					EMetaContent owner = ArrayUtils.getFirst(owners);
					EMetaContent version = ArrayUtils.getFirst(versions);
					EMetaContent platform = ArrayUtils.getFirst(platforms);
					EMetaContent date = ArrayUtils.getFirst(dates);
					EMetaContent release = ArrayUtils.getFirst(releases);
					EMetaContent product = ArrayUtils.getFirst(products);
					EMetaContent customer = ArrayUtils.getFirst(customers);
					EMetaContent editor = ArrayUtils.getFirst(editors);
					EMetaContent status = ArrayUtils.getFirst(statuses);
					EDescriptionElement description = ArrayUtils.getFirst(descriptions);

					
					if (owner != null) {
						cpfi.setOwner(owner.getValue());
					}
					if (version != null) {
						cpfi.setVersion(version.getValue());
					}
					if (platform != null) {
						cpfi.setPlatform(platform.getValue());
					}
					if (date != null) {
						cpfi.setDate(date.getValue());
					}
					if (release != null) {
						cpfi.setRelease(release.getValue());
					}
					if (product != null) {
						cpfi.setProduct(product.getValue());
					}
					if (customer != null) {
						cpfi.setCustomer(customer.getValue());
					}
					if (editor != null) {
						// match author(in summary) 2 editor(in meta)
						cpfi.setAuthor(editor.getValue());
					}
					if (status != null) {
						// match author(in summary) 2 editor(in meta)
						cpfi.setStatus(status.getValue());
					}
					
					if (description != null) {
						cpfi.setDescription(description.getDescription());
					}
					
					cpfi.setName(ce.getName());
				}
			}
		}
		return cpfi;
	}

}
