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
 * Description: This file is part of com.nokia.tools.vct.appshell component.
 */

package com.nokia.tools.vct.appshell.appshellmodel.util;

import java.lang.reflect.Field;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.SAXXMLHandler;
import org.eclipse.emf.ecore.xmi.impl.XMLLoadImpl;
import org.xml.sax.helpers.DefaultHandler;

import com.nokia.tools.vct.appshell.AppshellPlugin;
import com.sun.org.apache.xerces.internal.xni.XMLAttributes;

@SuppressWarnings("restriction")
public class EAppshellXMLLoad extends XMLLoadImpl {

	public EAppshellXMLLoad(XMLHelper helper) {
		super(helper);
	}

	@Override
	protected DefaultHandler makeDefaultHandler() {

		return new SAXXMLHandler(resource, helper, options) {
			@Override
			protected void handleObjectAttribs(EObject obj) {

				if (attribs != null) {
					XMLAttributes impl = null;
					try {
						Field f = attribs.getClass().getDeclaredField(
								"fAttributes");
						f.setAccessible(true);
						Object inner = f.get(attribs);

						impl = (XMLAttributes) inner;
					} catch (Exception ex) {
						AppshellPlugin.getPlugin().getLog().log(new Status(IStatus.ERROR, "com.nokia.tools.vct.appshell", "Appshell Error", ex));
					}
					// XMLAttributes fAttributes;

					InternalEObject internalEObject = (InternalEObject) obj;
					for (int i = 0, size = attribs.getLength(); i < size; ++i) {
						String name = attribs.getQName(i);
						if (name.equals(idAttribute)) {
							xmlResource.setID(internalEObject,
									getNonNormalizedValue(impl, i));
						} else if (name.equals(hrefAttribute)
								&& (!recordUnknownFeature
										|| types.peek() != UNKNOWN_FEATURE_TYPE || obj
										.eClass() != anyType)) {
							handleProxy(internalEObject, getNonNormalizedValue(impl, i));
						} else if (isNamespaceAware) {
							String namespace = attribs.getURI(i);
							if (!ExtendedMetaData.XSI_URI.equals(namespace)) {
								setAttribValue(obj, name,
										getNonNormalizedValue(impl, i));
							}
						} else if (!name.startsWith(XMLResource.XML_NS)
								&& !notFeatures.contains(name)) {
							setAttribValue(obj, name, getNonNormalizedValue(impl, i));
						}
					}
				}
			}

			private String getNonNormalizedValue(XMLAttributes impl, int i) {
				return impl == null ? attribs
						.getValue(i) : impl
						.getNonNormalizedValue(i);
			}
		};
	}
}
