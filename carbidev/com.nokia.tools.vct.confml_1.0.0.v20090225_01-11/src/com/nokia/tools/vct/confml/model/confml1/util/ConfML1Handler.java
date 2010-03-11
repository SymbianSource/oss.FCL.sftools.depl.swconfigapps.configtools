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
import java.util.Map;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.xmi.FeatureNotFoundException;
import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.SAXXMLHandler;

import com.nokia.tools.vct.confml.model.confml1.EConfML1Package;
import com.nokia.tools.vct.confml.model.confml1.EDataElement;
import com.nokia.tools.vct.confml.model.confml1.EFeatureRfs;
import com.nokia.tools.vct.confml.model.confml1.ERefNamedElement;
import com.nokia.tools.vct.confml.model.confml1.ERfsElement;
import com.nokia.tools.vct.confml.model.confml1.ESettingDataContainer;
import com.nokia.tools.vct.confml.model.confml2.EConfML2Package;
import com.nokia.tools.vct.confml.model.confml2.ESettingElement;

public class ConfML1Handler extends SAXXMLHandler {

	// must be here
	public EObject createObject(EFactory eFactory, EClassifier type,
			boolean documentRoot) {
		EObject newObject = helper.createObject(eFactory, type);

		if (newObject != null && !documentRoot) {
			if (disableNotify) {
				newObject.eSetDeliver(false);
			}
			handleObjectAttribs(newObject);
		}
		return newObject;
	}

	@Override
	protected EStructuralFeature getFeature(EObject object, String prefix,
			String name, boolean isElement) {
		EStructuralFeature feature;
		if (isElement) {
			if (object instanceof EDataElement) {
				feature = EConfML1Package.eINSTANCE.getEDataElement_Data();
			} else if (object instanceof ERfsElement) {
				feature = EConfML1Package.eINSTANCE.getERfsElement_Rfs();
			} else if (object instanceof ESettingDataContainer) {
				feature = EConfML1Package.eINSTANCE
						.getESettingDataContainer_Settings();
			} else if (object instanceof EFeatureRfs) {
				feature = EConfML1Package.eINSTANCE.getEFeatureRfs_Settings();
			} else if (object instanceof com.nokia.tools.vct.confml.model.confml2.EDataElement) {
				feature = EConfML2Package.eINSTANCE.getEDataElement_Data();
			} else if (object instanceof com.nokia.tools.vct.confml.model.confml2.ERfsElement) {
				feature = EConfML2Package.eINSTANCE.getERfsElement_Rfs();
			} else if (object instanceof com.nokia.tools.vct.confml.model.confml2.ESettingDataContainer) {
				feature = EConfML2Package.eINSTANCE
						.getESettingDataContainer_Settings();
			} else if (object instanceof com.nokia.tools.vct.confml.model.confml2.EFeatureRfs) {
				feature = EConfML2Package.eINSTANCE.getEFeatureRfs_Settings();
			} else if (object instanceof ESettingElement && "property".equals(name)) {
				feature = EConfML2Package.eINSTANCE.getESettingElement_Properties();
			} else if (object instanceof com.nokia.tools.vct.confml.model.confml1.ESettingElement&& "property".equals(name)) {
				feature = EConfML1Package.eINSTANCE.getESettingElement_Properties();
			} else {
				feature = super.getFeature(object, prefix, name, isElement);
			}
		} else {
			feature = super.getFeature(object, prefix, name, isElement);
		}

		return feature;
	}

	// /@Override
	@SuppressWarnings("deprecation")
	protected void handleFeature(String prefix, String name) {

		EObject peekObject = objects.peekEObject();
		// This happens when processing an element with simple content that has
		// elements content even though it shouldn't.
		//
		if (peekObject == null) {
			types.push(ERROR_TYPE);
			error(new FeatureNotFoundException(name, null, getLocation(),
					getLineNumber(), getColumnNumber()));
			return;
		}

		EStructuralFeature feature = null;
		feature = getFeature(peekObject, prefix, name, true);

		if (feature != null) {
			int kind = helper.getFeatureKind(feature);
			if (kind == XMLHelper.DATATYPE_SINGLE
					|| kind == XMLHelper.DATATYPE_IS_MANY) {
				objects.push(null);
				mixedTargets.push(null);
				types.push(feature);
				if (!isNull()) {
					text = new StringBuffer();
				}
			} else if (extendedMetaData != null) {
				EReference eReference = (EReference) feature;
				boolean isContainment = eReference.isContainment();
				if (!isContainment
						&& !eReference.isResolveProxies()
						&& extendedMetaData.getFeatureKind(feature) != ExtendedMetaData.UNSPECIFIED_FEATURE) {
					isIDREF = true;
					objects.push(null);
					mixedTargets.push(null);
					types.push(feature);
					text = new StringBuffer();
				} else {
					createObject(peekObject, feature);

					EObject childObject = objects.peekEObject();
					updateRefName(name, childObject);
					if (childObject != null) {
						if (isContainment) {
							EStructuralFeature simpleFeature = extendedMetaData
									.getSimpleFeature(childObject.eClass());
							if (simpleFeature != null) {
								isSimpleFeature = true;
								isIDREF = simpleFeature instanceof EReference;
								objects.push(null);
								mixedTargets.push(null);
								types.push(simpleFeature);
								text = new StringBuffer();
							}
						} else if (!childObject.eIsProxy()) {
							text = new StringBuffer();
						}
					}
				}
			} else {
				createObject(peekObject, feature);
			}
		} else {
			// Try to get a general-content feature.
			// Use a pattern that's not possible any other way.
			//
			if (xmlMap != null
					&& (feature = getFeature(peekObject, null, "", true)) != null) {

				EFactory eFactory = getFactoryForPrefix(prefix);

				// This is for the case for a local unqualified element that has
				// been bound.
				//
				if (eFactory == null) {
					eFactory = feature.getEContainingClass().getEPackage()
							.getEFactoryInstance();
				}

				EObject newObject = null;
				if (useNewMethods) {
					newObject = createObject(eFactory, helper.getType(eFactory,
							name), false);
				} else {
					newObject = createObjectFromFactory(eFactory, name);
				}
				newObject = validateCreateObjectFromFactory(eFactory, name,
						newObject, feature);
				if (newObject != null) {
					setFeatureValue(peekObject, feature, newObject);
				}
				processObject(newObject);
			} else {
				// This handles the case of a substitution group.
				//
				if (xmlMap != null) {
					EFactory eFactory = getFactoryForPrefix(prefix);
					EObject newObject = createObjectFromFactory(eFactory, name);
					validateCreateObjectFromFactory(eFactory, name, newObject);
					if (newObject != null) {
						for (Iterator<EReference> i = peekObject.eClass()
								.getEAllReferences().iterator(); i.hasNext();) {
							EReference eReference = i.next();
							if (eReference.getEType().isInstance(newObject)) {
								setFeatureValue(peekObject, eReference,
										newObject);
								processObject(newObject);
								return;
							}
						}
					}
				}

				handleUnknownFeature(prefix, name, true, peekObject, null);
			}
		}
	}

	private void updateRefName(String elementName, EObject object) {
		if (object instanceof ERefNamedElement) {
			((ERefNamedElement) object).setRef(elementName);
		}
	}

	public ConfML1Handler(XMLResource xmiResource, XMLHelper helper,
			Map<?, ?> options) {
		super(xmiResource, helper, options);
	}

	protected EObject createObjectByType(String arg0, String arg1, boolean arg2) {
		EObject object = super.createObjectByType(arg0, arg1, arg2);
		return object;
	}

}
