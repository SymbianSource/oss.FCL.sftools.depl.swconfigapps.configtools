/*
* Copyright (c) 2009 Nokia Corporation and/or its subsidiary(-ies). 
* All rights reserved.
* This component and the accompanying materials are made available
* under the terms of "Eclipse Public License v1.0"
* which accompanies this distribution, and is available
* at the URL "http://www.eclipse.org/legal/epl-v10.html".
*
* Initial Contributors:
* Nokia Corporation - initial contribution.
*
* Contributors:
*
* Description:
*
*/
package search.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;

import com.nokia.tools.vct.ibyml.ibymodel.EIBYModelPackage;

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

		list.addAll(getEIBYModelPackageParticipantTextualTypedElement());

		return list;
	}

	public List<ETypedElement> getEIBYModelPackageParticipantTextualTypedElement() {
		return Arrays.asList(new ETypedElement[] {

		EIBYModelPackage.Literals.EENTITY__REF,
				EIBYModelPackage.Literals.EENTITY__VALUE,
				EIBYModelPackage.Literals.EFILE_NAME__PLUGIN,
				EIBYModelPackage.Literals.EIBY_FILE__NAME,
				EIBYModelPackage.Literals.EIBY_FILE__FLAG });
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
					//User to handle exception in an elegant way
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
				//User to handle exception in an elegant way
			}
		}
	}
}