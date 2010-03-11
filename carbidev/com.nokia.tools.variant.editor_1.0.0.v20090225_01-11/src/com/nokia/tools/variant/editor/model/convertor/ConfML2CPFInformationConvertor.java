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
import com.nokia.tools.vct.confml.model.confml1.include.EInclude;
import com.nokia.tools.vct.confml.model.confml2.EConfML2Document;
import com.nokia.tools.vct.confml.model.confml2.EConfML2Factory;
import com.nokia.tools.vct.confml.model.confml2.EConfigurationElement;
import com.nokia.tools.vct.confml.model.confml2.EDescriptionElement;
import com.nokia.tools.vct.confml.model.confml2.EIconElement;
import com.nokia.tools.vct.confml.model.confml2.ELinkElement;
import com.nokia.tools.vct.confml.model.confml2.EMetaContent;
import com.nokia.tools.vct.confml.model.confml2.EMetaElement;

public class ConfML2CPFInformationConvertor implements CPFInformationConvertor {

	public void copyCPFInformationToResource(Resource resource,
			CPFInformation cpfi) {
		
		EList<EObject> contents = resource.getContents();
		EConfigurationElement ce = null; 
		if (contents.size() == 0) {
			ce = EConfML2Factory.eINSTANCE.createEConfigurationElement();
			contents.add(ce);
		} else {
			ce = (EConfigurationElement) ((EConfML2Document)contents.get(0)).getConfiguration();
		}
		EList<EMetaElement> metas = ce.getMetas();
		
		EMetaElement me = null;
		if (metas.size() > 0) {
			metas.clear();
			me = EConfML2Factory.eINSTANCE.createEMetaElement();
			metas.add(me);
		} else {
			me = EConfML2Factory.eINSTANCE.createEMetaElement();
			metas.add(me);
		}

		EMetaContent customer = EConfML2Factory.eINSTANCE.createEMetaContent();
		customer.setValue(cpfi.getCustomer());
		me.getCustomer().clear();
		me.getCustomer().add(customer);

		EMetaContent owner = EConfML2Factory.eINSTANCE.createEMetaContent();
		owner.setValue(cpfi.getOwner());
		me.getOwner().clear();
		me.getOwner().add(owner);
		
		EMetaContent version = EConfML2Factory.eINSTANCE.createEMetaContent();
		version.setValue(cpfi.getVersion());
		me.getVersion().clear();
		me.getVersion().add(version);
		
		EMetaContent platform = EConfML2Factory.eINSTANCE.createEMetaContent();
		platform.setValue(cpfi.getPlatform());
		me.getPlatform().clear();
		me.getPlatform().add(platform);
		
		EMetaContent date = EConfML2Factory.eINSTANCE.createEMetaContent();
		date.setValue(cpfi.getDate());
		me.getDate().clear();
		me.getDate().add(date);

		EMetaContent release = EConfML2Factory.eINSTANCE.createEMetaContent();
		release.setValue(cpfi.getRelease());
		me.getRelease().clear();
		me.getRelease().add(release);

		EMetaContent product = EConfML2Factory.eINSTANCE.createEMetaContent();
		product.setValue(cpfi.getProduct());
		me.getProduct().clear();
		me.getProduct().add(product);
		
		// match author(in summary) 2 editor(in meta)
		EMetaContent editor = EConfML2Factory.eINSTANCE.createEMetaContent();
		editor.setValue(cpfi.getAuthor());
		me.getEditor().clear();
		me.getEditor().add(editor);
		
		EMetaContent status = EConfML2Factory.eINSTANCE.createEMetaContent();
		status.setValue(cpfi.getStatus());
		me.getStatus().clear();
		me.getStatus().add(status);
		
		EMetaContent origin = EConfML2Factory.eINSTANCE.createEMetaContent();
		origin.setValue(cpfi.getOrigin());
		me.getOrigin().clear();
		me.getOrigin().add(origin);

		EMetaContent target = EConfML2Factory.eINSTANCE.createEMetaContent();
		target.setValue(cpfi.getTarget());
		me.getTarget().clear();
		me.getTarget().add(target);

		
		EDescriptionElement description = EConfML2Factory.eINSTANCE.createEDescriptionElement();
		description.setDescription(cpfi.getDescription());
		ce.getDescriptions().clear();
		ce.getDescriptions().add(description);

	}

	public CPFInformation loadCPFInformationFromResource(Resource resource) {
		CPFInformation cpfi = CpfInfoFactory.eINSTANCE.createCPFInformation();

		EList<EObject> contents = resource.getContents();
		if (contents.size() > 0) {
			EObject root = contents.get(0);
			if (root instanceof EConfML2Document) {
				EConfML2Document doc = (EConfML2Document) root;
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
					EList<EMetaContent> origins = me.getOrigin();
					EList<EMetaContent> targets = me.getTarget();
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
					EMetaContent origin = ArrayUtils.getFirst(origins);
					EMetaContent target = ArrayUtils.getFirst(targets);
					
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
						cpfi.setStatus(status.getValue());
					}
					if (target != null) {
						cpfi.setTarget(target.getValue());
					}
					if (origin != null) {
						cpfi.setOrigin(origin.getValue());
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
