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
 * Description: This file is part of com.nokia.tools.vct.confml component.
 */

package com.nokia.tools.vct.confml.model.confml1.util;

import java.util.Iterator;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMLSaveImpl;
import org.eclipse.emf.ecore.xml.type.AnyType;
import org.eclipse.emf.ecore.xml.type.SimpleAnyType;

import com.nokia.tools.vct.confml.model.confml1.ERefNamedElement;

public class ConfXMLSaveImpl extends XMLSaveImpl {

	// @Override
	protected void saveElement(EObject o, EStructuralFeature f) {

		EClass eClass = o.eClass();
		EClassifier eType = f.getEType();

		if (extendedMetaData != null && eClass != eType) {
			// Check if it's an anonymous type.
			//
			String name = extendedMetaData.getName(eClass);
			if (name.endsWith("_._type")) {
				String elementName = name.substring(0, name.indexOf("_._"));
				String prefix = helper.getPrefix(eClass.getEPackage());
//				if (!"".equals(prefix)) 
//				{
//					elementName = prefix + ":" + elementName;
//				}
				if (!toDOM) 
				{
					doc.startElement(elementName);
				} 
				else 
				{
					String nsString = helper.getNamespaceURI(prefix);
					
					currentNode = currentNode.appendChild(document
							.createElementNS(nsString,elementName));
					handler.recordValues(currentNode, o.eContainer(), f, o);
				}
				saveElementID(o);
				return;
			}
		}

		if (map != null) {
			XMLResource.XMLInfo info = map.getInfo(eClass);
			if (info != null
					&& info.getXMLRepresentation() == XMLResource.XMLInfo.ELEMENT) {
				if (!toDOM) {
					String elementName = helper.getQName(eClass);
					doc.startElement(elementName);
				} else {
					helper.populateNameInfo(nameInfo, eClass);
					if (currentNode == null) {
						currentNode = document
								.createElementNS(nameInfo.getNamespaceURI(),
										nameInfo.getQualifiedName());
						document.appendChild(currentNode);
						handler.recordValues(currentNode, o.eContainer(), f, o);
					} else {
						currentNode = currentNode.appendChild(document
								.createElementNS(nameInfo.getNamespaceURI(),
										nameInfo.getQualifiedName()));
						handler.recordValues(currentNode, o.eContainer(), f, o);
					}
				}
				saveElementID(o);
				return;
			}
		}
		boolean isAnyType = false;
		if (o instanceof AnyType) {
			isAnyType = true;
			helper.pushContext();
			for (Iterator<FeatureMap.Entry> i = ((AnyType) o).getAnyAttribute()
					.iterator(); i.hasNext();) {
				FeatureMap.Entry entry = i.next();
				if (ExtendedMetaData.XMLNS_URI.equals(extendedMetaData
						.getNamespace(entry.getEStructuralFeature()))) {
					String uri = (String) entry.getValue();
					helper.addPrefix(extendedMetaData.getName(entry
							.getEStructuralFeature()), uri == null ? "" : uri);
				}
			}
		}
		if (!toDOM) {
			/*
			 * modifications to save XPath
			 */
			String featureName = null;
			if (o instanceof ERefNamedElement) {
				featureName = ((ERefNamedElement) o).getRef();
//				String prefix = helper.getPrefix(o.eClass().getEPackage());
//				if (!"".equals(prefix)) {
//					featureName = prefix + ":" + featureName;
//				}
			} else {
				if (o instanceof com.nokia.tools.vct.confml.model.confml2.ERefNamedElement) {
					featureName = ((com.nokia.tools.vct.confml.model.confml2.ERefNamedElement) o).getRef();
//					String prefix = helper.getPrefix(o.eClass().getEPackage());
//					if (!"".equals(prefix)) {
//						featureName = prefix + ":" + featureName;
//					}
				} else{
				featureName = helper.getQName(f);
				}
			}
			doc.startElement(featureName);
		} else {
			if (o instanceof ERefNamedElement) {
				String ref = ((ERefNamedElement) o).getRef();
				nameInfo.setLocalPart(ref);
				nameInfo.setNamespaceURI(o.eClass().getEPackage().getNsURI());
//				String prefix = helper.getPrefix(o.eClass().getEPackage());
//				if (!"".equals(prefix))
//				{
//					nameInfo.setQualifiedName(prefix + ":" + ref);
//				}
//				else
//				{
					nameInfo.setQualifiedName(ref);
//				}
			} else {
				if (o instanceof com.nokia.tools.vct.confml.model.confml2.ERefNamedElement) {
					String ref = ((com.nokia.tools.vct.confml.model.confml2.ERefNamedElement) o).getRef();
					nameInfo.setLocalPart(ref);
					nameInfo.setNamespaceURI(o.eClass().getEPackage().getNsURI());
//					String prefix = helper.getPrefix(o.eClass().getEPackage());
//					if (!"".equals(prefix)) {
//						nameInfo.setQualifiedName(prefix + ":" + ref);
//					} 
//					else 
//					{
						nameInfo.setQualifiedName(ref);
//					}
				} else {
					helper.populateNameInfo(nameInfo, f);
				}
			}

			if (currentNode == null) {
				// this is a root element
				currentNode = document.createElementNS(nameInfo
						.getNamespaceURI(), nameInfo.getQualifiedName());
				document.appendChild(currentNode);
				handler.recordValues(currentNode, o.eContainer(), f, o);
			} else {
				currentNode = currentNode.appendChild(document
						.createElementNS(nameInfo.getNamespaceURI(), nameInfo
								.getQualifiedName()));
				handler.recordValues(currentNode, o.eContainer(), f, o);
			}
		}

		if (saveTypeInfo ? xmlTypeInfo.shouldSaveType(eClass, eType, f)
				: eClass != eType && eClass != anyType) {
			if (eClass == anySimpleType) {
				saveTypeAttribute(((SimpleAnyType) o).getInstanceType());
			} else {
				saveTypeAttribute(eClass);
			}
		}

		saveElementID(o);
		if (isAnyType) {
			helper.popContext();
		}
	}

	public ConfXMLSaveImpl(XMLHelper xmlHelper) {
		super(xmlHelper);
	}

}
