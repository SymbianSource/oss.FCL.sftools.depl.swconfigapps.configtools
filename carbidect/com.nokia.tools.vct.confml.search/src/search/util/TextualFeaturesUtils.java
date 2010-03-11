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
 * Description: This file is part of com.nokia.tools.vct.confml.search component.
 */

package search.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;

import com.nokia.tools.vct.confml.model.confml1.EConfML1Package;
import com.nokia.tools.vct.confml.model.confml2.EConfML2Package;
import com.nokia.tools.vct.confml.model.xsd.EXSDFacetPackage;

public class TextualFeaturesUtils

{

	public TextualFeaturesUtils() {
	}

	private static TextualFeaturesUtils instance;

	public static TextualFeaturesUtils instance() {
		return instance == null ? instance = new TextualFeaturesUtils()
				: instance;
	}

	public List<ETypedElement> getParticipantTextualTypedElement() {
		List<ETypedElement> list = new ArrayList<ETypedElement>();

		list.addAll(getEConfML1PackageParticipantTextualTypedElement());
		list.addAll(getEConfML2PackageParticipantTextualTypedElement());
		list.addAll(getEXSDFacetPackageParticipantTextualTypedElement());

		return list;
	}

	public List<ETypedElement> getEConfML1PackageParticipantTextualTypedElement() {
		return Arrays.asList(new ETypedElement[] {

		EConfML1Package.Literals.EGROUP__NAME,
				EConfML1Package.Literals.EDESCRIPTION_ELEMENT__DESCRIPTION,
				EConfML1Package.Literals.ECONFIGURATION_ELEMENT__VERSION,
				EConfML1Package.Literals.ECONFIGURATION_ELEMENT__NAME,
				EConfML1Package.Literals.ESETTING_RFS__RFS,
				EConfML1Package.Literals.EX_LINK_REFERENCE__HREF,
				EConfML1Package.Literals.EX_LINK_REFERENCE__TITLE,
				EConfML1Package.Literals.EMETA_CONTENT__VALUE,
				EConfML1Package.Literals.EFEATURE_ELEMENT__NAME,
				EConfML1Package.Literals.EFEATURE_ELEMENT__REF,
				EConfML1Package.Literals.EFEATURE_ELEMENT__RELEVANT,
				EConfML1Package.Literals.ESETTING_DATA__TEMPLATE,
				EConfML1Package.Literals.ESETTING_DATA__TEXT,
				EConfML1Package.Literals.ESETTING_DATA__EXTENSION_POLICY,
				EConfML1Package.Literals.ECOMMON_ATTRS__ID,
				EConfML1Package.Literals.EPROPERTY_ELEMENT__NAME,
				EConfML1Package.Literals.EPROPERTY_ELEMENT__VALUE,
				EConfML1Package.Literals.EPROPERTY_ELEMENT__UNIT,
				EConfML1Package.Literals.EREF_NAMED_ELEMENT__REF,
				EConfML1Package.Literals.EOPTION_ELEMENT__MAP,
				EConfML1Package.Literals.EOPTION_ELEMENT__VALUE,
				EConfML1Package.Literals.EOPTION_ELEMENT__NAME,
				EConfML1Package.Literals.EOPTION_ELEMENT__RELEVANT,
				EConfML1Package.Literals.ESETTING_ELEMENT__NAME,
				EConfML1Package.Literals.ESETTING_ELEMENT__CONSTRAINT,
				EConfML1Package.Literals.ESETTING_ELEMENT__TYPE,
				EConfML1Package.Literals.ESETTING_ELEMENT__MAP_VALUE,
				EConfML1Package.Literals.ESETTING_ELEMENT__READ_ONLY,
				EConfML1Package.Literals.ESETTING_ELEMENT__REQUIRED,
				EConfML1Package.Literals.ESETTING_ELEMENT__REF,
				EConfML1Package.Literals.ESETTING_ELEMENT__MAP_KEY,
				EConfML1Package.Literals.ESETTING_ELEMENT__RELEVANT,
				EConfML1Package.Literals.EVIEW_ELEMENT__NAME });
	}

	public List<ETypedElement> getEConfML2PackageParticipantTextualTypedElement() {
		return Arrays.asList(new ETypedElement[] {

		EConfML2Package.Literals.EGROUP__NAME,
				EConfML2Package.Literals.EDESCRIPTION_ELEMENT__DESCRIPTION,
				EConfML2Package.Literals.ECONFIGURATION_ELEMENT__VERSION,
				EConfML2Package.Literals.ECONFIGURATION_ELEMENT__NAME,
				EConfML2Package.Literals.ESETTING_RFS__RFS,
				EConfML2Package.Literals.EX_LINK_REFERENCE__HREF,
				EConfML2Package.Literals.EX_LINK_REFERENCE__TITLE,
				EConfML2Package.Literals.EMETA_CONTENT__VALUE,
				EConfML2Package.Literals.EFEATURE_ELEMENT__NAME,
				EConfML2Package.Literals.EFEATURE_ELEMENT__REF,
				EConfML2Package.Literals.EFEATURE_ELEMENT__RELEVANT,
				EConfML2Package.Literals.ESETTING_DATA__TEMPLATE,
				EConfML2Package.Literals.ESETTING_DATA__TEXT,
				EConfML2Package.Literals.ESETTING_DATA__EXTENSION_POLICY,
				EConfML2Package.Literals.ECOMMON_ATTRS__ID,
				EConfML2Package.Literals.EPROPERTY_ELEMENT__NAME,
				EConfML2Package.Literals.EPROPERTY_ELEMENT__VALUE,
				EConfML2Package.Literals.EPROPERTY_ELEMENT__UNIT,
				EConfML1Package.Literals.EREF_NAMED_ELEMENT__REF,
				EConfML2Package.Literals.EOPTION_ELEMENT__MAP,
				EConfML2Package.Literals.EOPTION_ELEMENT__VALUE,
				EConfML2Package.Literals.EOPTION_ELEMENT__NAME,
				EConfML2Package.Literals.EOPTION_ELEMENT__RELEVANT,
				EConfML2Package.Literals.ESETTING_ELEMENT__NAME,
				EConfML2Package.Literals.ESETTING_ELEMENT__CONSTRAINT,
				EConfML2Package.Literals.ESETTING_ELEMENT__TYPE,
				EConfML2Package.Literals.ESETTING_ELEMENT__MAP_VALUE,
				EConfML2Package.Literals.ESETTING_ELEMENT__READ_ONLY,
				EConfML2Package.Literals.ESETTING_ELEMENT__REQUIRED,
				EConfML2Package.Literals.ESETTING_ELEMENT__REF,
				EConfML2Package.Literals.ESETTING_ELEMENT__MAP_KEY,
				EConfML2Package.Literals.ESETTING_ELEMENT__RELEVANT,
				EConfML2Package.Literals.ELOCAL_PATH_ELEMENT__CONSTRAINT,
				EConfML2Package.Literals.ELOCAL_PATH_ELEMENT__MAP,
				EConfML2Package.Literals.ELOCAL_PATH_ELEMENT__READ_ONLY,
				EConfML2Package.Literals.ELOCAL_PATH_ELEMENT__REQUIRED,
				EConfML2Package.Literals.ETARGET_PATH_ELEMENT__CONSTRAINT,
				EConfML2Package.Literals.ETARGET_PATH_ELEMENT__MAP,
				EConfML2Package.Literals.ETARGET_PATH_ELEMENT__READ_ONLY,
				EConfML2Package.Literals.ETARGET_PATH_ELEMENT__REQUIRED,
				EConfML2Package.Literals.EVIEW_ELEMENT__NAME });
	}

	public List<ETypedElement> getEXSDFacetPackageParticipantTextualTypedElement() {
		return Arrays.asList(new ETypedElement[] {

		EXSDFacetPackage.Literals.EFACET__VALUE,
				EXSDFacetPackage.Literals.EFACET__FIXED });
	}

	public List<ETypedElement> getOwnedETypedElementsFromEObject(EObject obj) {
		List<ETypedElement> list = new ArrayList<ETypedElement>();
		for (ETypedElement e : getParticipantTextualTypedElement()) {
			if (e instanceof EStructuralFeature) {
				try {
					Object o = obj.eGet((EStructuralFeature) e);
					if (o instanceof String) {
						list.add(e);
					}
				} catch (Throwable t) {
					//ugly
				}
			}
		}
		return list;
	}

	public String getTextFromETypedElement(EObject obj, ETypedElement elem) {
		if (elem instanceof EStructuralFeature) {
			Object o = obj.eGet((EStructuralFeature) elem);
			if (o instanceof String) {
				return (String) o;
			} else {
				return String.valueOf(o);
			}
		}
		return null;
	}

	public String getTextFromEStructuralFeatureIfAny(EObject obj) {
		List<ETypedElement> lst = getOwnedETypedElementsFromEObject(obj);
		if (!lst.isEmpty()) {
			ETypedElement elem = lst.get(0);
			if (elem instanceof EStructuralFeature) {
				Object o = obj.eGet((EStructuralFeature) elem);
				if (o instanceof String) {
					return (String) o;
				}
			}
		}
		return null;
	}

	public void setTextForEStructuralFeatureIfAny(EObject obj, Object val) {
		for (ETypedElement e : getParticipantTextualTypedElement()) {
			if (e instanceof EStructuralFeature) {
				try {
					if (val instanceof String) {
						obj.eSet((EStructuralFeature) e, val);
					}
				} catch (Throwable ex) {
					//IMPROVEMENT: User to handle exception in an elegant way
				}
			}
		}
	}

	public void setTextForETypedElement(EObject obj, ETypedElement elem,
			Object val) {
		if (elem instanceof EStructuralFeature) {
			try {
				if (val instanceof String) {
					obj.eSet((EStructuralFeature) elem, val);
				}
			} catch (Throwable ex) {
				//IMPROVEMENT: User to handle exception in an elegant way
			}
		}
	}
}
