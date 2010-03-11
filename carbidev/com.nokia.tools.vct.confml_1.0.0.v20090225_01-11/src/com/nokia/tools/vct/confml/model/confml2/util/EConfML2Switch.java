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

package com.nokia.tools.vct.confml.model.confml2.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import com.nokia.tools.vct.confml.model.confml1.ERefNamedElement;
import com.nokia.tools.vct.confml.model.confml2.ECommonAttrs;
import com.nokia.tools.vct.confml.model.confml2.EConfML2Document;
import com.nokia.tools.vct.confml.model.confml2.EConfML2Package;
import com.nokia.tools.vct.confml.model.confml2.EConfigurationElement;
import com.nokia.tools.vct.confml.model.confml2.EContents;
import com.nokia.tools.vct.confml.model.confml2.EDataElement;
import com.nokia.tools.vct.confml.model.confml2.EDescriptionContainer;
import com.nokia.tools.vct.confml.model.confml2.EDescriptionElement;
import com.nokia.tools.vct.confml.model.confml2.EFeatureData;
import com.nokia.tools.vct.confml.model.confml2.EFeatureElement;
import com.nokia.tools.vct.confml.model.confml2.EFeatureRfs;
import com.nokia.tools.vct.confml.model.confml2.EGroup;
import com.nokia.tools.vct.confml.model.confml2.EGroupContainer;
import com.nokia.tools.vct.confml.model.confml2.EIconContainer;
import com.nokia.tools.vct.confml.model.confml2.EIconElement;
import com.nokia.tools.vct.confml.model.confml2.ELinkContainer;
import com.nokia.tools.vct.confml.model.confml2.ELinkElement;
import com.nokia.tools.vct.confml.model.confml2.ELocalPathElement;
import com.nokia.tools.vct.confml.model.confml2.EMetaContainer;
import com.nokia.tools.vct.confml.model.confml2.EMetaContent;
import com.nokia.tools.vct.confml.model.confml2.EMetaElement;
import com.nokia.tools.vct.confml.model.confml2.EOptionElement;
import com.nokia.tools.vct.confml.model.confml2.EPropertyElement;
import com.nokia.tools.vct.confml.model.confml2.ERfsElement;
import com.nokia.tools.vct.confml.model.confml2.ESettingData;
import com.nokia.tools.vct.confml.model.confml2.ESettingDataContainer;
import com.nokia.tools.vct.confml.model.confml2.ESettingElement;
import com.nokia.tools.vct.confml.model.confml2.ESettingRfs;
import com.nokia.tools.vct.confml.model.confml2.ESettingTypeContainer;
import com.nokia.tools.vct.confml.model.confml2.ETargetPathElement;
import com.nokia.tools.vct.confml.model.confml2.EViewElement;
import com.nokia.tools.vct.confml.model.confml2.EXLinkReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see com.nokia.tools.vct.confml.model.confml2.EConfML2Package
 * @generated
 */
public class EConfML2Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static EConfML2Package modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EConfML2Switch() {
		if (modelPackage == null) {
			modelPackage = EConfML2Package.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		} else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return eSuperTypes.isEmpty() ? defaultCase(theEObject) : doSwitch(
					eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
		case EConfML2Package.ECONFIGURATION_ELEMENT: {
			EConfigurationElement eConfigurationElement = (EConfigurationElement) theEObject;
			T result = caseEConfigurationElement(eConfigurationElement);
			if (result == null)
				result = caseECommonAttrs(eConfigurationElement);
			if (result == null)
				result = caseEContents(eConfigurationElement);
			if (result == null)
				result = caseELinkContainer(eConfigurationElement);
			if (result == null)
				result = caseEIconContainer(eConfigurationElement);
			if (result == null)
				result = caseEDescriptionContainer(eConfigurationElement);
			if (result == null)
				result = caseEMetaContainer(eConfigurationElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EConfML2Package.ECONTENTS: {
			EContents eContents = (EContents) theEObject;
			T result = caseEContents(eContents);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EConfML2Package.EFEATURE_ELEMENT: {
			EFeatureElement eFeatureElement = (EFeatureElement) theEObject;
			T result = caseEFeatureElement(eFeatureElement);
			if (result == null)
				result = caseECommonAttrs(eFeatureElement);
			if (result == null)
				result = caseEDescriptionContainer(eFeatureElement);
			if (result == null)
				result = caseELinkContainer(eFeatureElement);
			if (result == null)
				result = caseESettingTypeContainer(eFeatureElement);
			if (result == null)
				result = caseEIconContainer(eFeatureElement);
			if (result == null)
				result = caseEContents(eFeatureElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EConfML2Package.EFEATURE_DATA: {
			EFeatureData eFeatureData = (EFeatureData) theEObject;
			T result = caseEFeatureData(eFeatureData);
			if (result == null)
				result = caseERefNamedElement(eFeatureData);
			if (result == null)
				result = caseESettingDataContainer(eFeatureData);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EConfML2Package.ESETTING_TYPE_CONTAINER: {
			ESettingTypeContainer eSettingTypeContainer = (ESettingTypeContainer) theEObject;
			T result = caseESettingTypeContainer(eSettingTypeContainer);
			if (result == null)
				result = caseEContents(eSettingTypeContainer);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EConfML2Package.ESETTING_ELEMENT: {
			ESettingElement eSettingElement = (ESettingElement) theEObject;
			T result = caseESettingElement(eSettingElement);
			if (result == null)
				result = caseECommonAttrs(eSettingElement);
			if (result == null)
				result = caseEDescriptionContainer(eSettingElement);
			if (result == null)
				result = caseELinkContainer(eSettingElement);
			if (result == null)
				result = caseESettingTypeContainer(eSettingElement);
			if (result == null)
				result = caseEIconContainer(eSettingElement);
			if (result == null)
				result = caseEContents(eSettingElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EConfML2Package.ESETTING_DATA_CONTAINER: {
			ESettingDataContainer eSettingDataContainer = (ESettingDataContainer) theEObject;
			T result = caseESettingDataContainer(eSettingDataContainer);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EConfML2Package.ESETTING_DATA: {
			ESettingData eSettingData = (ESettingData) theEObject;
			T result = caseESettingData(eSettingData);
			if (result == null)
				result = caseERefNamedElement(eSettingData);
			if (result == null)
				result = caseESettingDataContainer(eSettingData);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EConfML2Package.EVIEW_ELEMENT: {
			EViewElement eViewElement = (EViewElement) theEObject;
			T result = caseEViewElement(eViewElement);
			if (result == null)
				result = caseECommonAttrs(eViewElement);
			if (result == null)
				result = caseEGroupContainer(eViewElement);
			if (result == null)
				result = caseEMetaContainer(eViewElement);
			if (result == null)
				result = caseELinkContainer(eViewElement);
			if (result == null)
				result = caseEDescriptionContainer(eViewElement);
			if (result == null)
				result = caseEIconContainer(eViewElement);
			if (result == null)
				result = caseEContents(eViewElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EConfML2Package.EGROUP: {
			EGroup eGroup = (EGroup) theEObject;
			T result = caseEGroup(eGroup);
			if (result == null)
				result = caseECommonAttrs(eGroup);
			if (result == null)
				result = caseEGroupContainer(eGroup);
			if (result == null)
				result = caseELinkContainer(eGroup);
			if (result == null)
				result = caseEDescriptionContainer(eGroup);
			if (result == null)
				result = caseEIconContainer(eGroup);
			if (result == null)
				result = caseEContents(eGroup);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EConfML2Package.EGROUP_CONTAINER: {
			EGroupContainer eGroupContainer = (EGroupContainer) theEObject;
			T result = caseEGroupContainer(eGroupContainer);
			if (result == null)
				result = caseELinkContainer(eGroupContainer);
			if (result == null)
				result = caseEDescriptionContainer(eGroupContainer);
			if (result == null)
				result = caseEIconContainer(eGroupContainer);
			if (result == null)
				result = caseEContents(eGroupContainer);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EConfML2Package.EFEATURE_RFS: {
			EFeatureRfs eFeatureRfs = (EFeatureRfs) theEObject;
			T result = caseEFeatureRfs(eFeatureRfs);
			if (result == null)
				result = caseERefNamedElement(eFeatureRfs);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EConfML2Package.ESETTING_RFS: {
			ESettingRfs eSettingRfs = (ESettingRfs) theEObject;
			T result = caseESettingRfs(eSettingRfs);
			if (result == null)
				result = caseERefNamedElement(eSettingRfs);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EConfML2Package.EMETA_CONTAINER: {
			EMetaContainer eMetaContainer = (EMetaContainer) theEObject;
			T result = caseEMetaContainer(eMetaContainer);
			if (result == null)
				result = caseEContents(eMetaContainer);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EConfML2Package.EMETA_ELEMENT: {
			EMetaElement eMetaElement = (EMetaElement) theEObject;
			T result = caseEMetaElement(eMetaElement);
			if (result == null)
				result = caseELinkContainer(eMetaElement);
			if (result == null)
				result = caseEIconContainer(eMetaElement);
			if (result == null)
				result = caseEContents(eMetaElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EConfML2Package.EOPTION_ELEMENT: {
			EOptionElement eOptionElement = (EOptionElement) theEObject;
			T result = caseEOptionElement(eOptionElement);
			if (result == null)
				result = caseECommonAttrs(eOptionElement);
			if (result == null)
				result = caseELinkContainer(eOptionElement);
			if (result == null)
				result = caseEIconElement(eOptionElement);
			if (result == null)
				result = caseEDescriptionContainer(eOptionElement);
			if (result == null)
				result = caseEContents(eOptionElement);
			if (result == null)
				result = caseEXLinkReference(eOptionElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EConfML2Package.EPROPERTY_ELEMENT: {
			EPropertyElement ePropertyElement = (EPropertyElement) theEObject;
			T result = caseEPropertyElement(ePropertyElement);
			if (result == null)
				result = caseECommonAttrs(ePropertyElement);
			if (result == null)
				result = caseELinkContainer(ePropertyElement);
			if (result == null)
				result = caseEIconElement(ePropertyElement);
			if (result == null)
				result = caseEDescriptionContainer(ePropertyElement);
			if (result == null)
				result = caseEContents(ePropertyElement);
			if (result == null)
				result = caseEXLinkReference(ePropertyElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EConfML2Package.EDESCRIPTION_CONTAINER: {
			EDescriptionContainer eDescriptionContainer = (EDescriptionContainer) theEObject;
			T result = caseEDescriptionContainer(eDescriptionContainer);
			if (result == null)
				result = caseEContents(eDescriptionContainer);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EConfML2Package.EDESCRIPTION_ELEMENT: {
			EDescriptionElement eDescriptionElement = (EDescriptionElement) theEObject;
			T result = caseEDescriptionElement(eDescriptionElement);
			if (result == null)
				result = caseECommonAttrs(eDescriptionElement);
			if (result == null)
				result = caseEXLinkReference(eDescriptionElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EConfML2Package.EICON_CONTAINER: {
			EIconContainer eIconContainer = (EIconContainer) theEObject;
			T result = caseEIconContainer(eIconContainer);
			if (result == null)
				result = caseEContents(eIconContainer);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EConfML2Package.EICON_ELEMENT: {
			EIconElement eIconElement = (EIconElement) theEObject;
			T result = caseEIconElement(eIconElement);
			if (result == null)
				result = caseECommonAttrs(eIconElement);
			if (result == null)
				result = caseEXLinkReference(eIconElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EConfML2Package.ELINK_CONTAINER: {
			ELinkContainer eLinkContainer = (ELinkContainer) theEObject;
			T result = caseELinkContainer(eLinkContainer);
			if (result == null)
				result = caseEContents(eLinkContainer);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EConfML2Package.ELINK_ELEMENT: {
			ELinkElement eLinkElement = (ELinkElement) theEObject;
			T result = caseELinkElement(eLinkElement);
			if (result == null)
				result = caseECommonAttrs(eLinkElement);
			if (result == null)
				result = caseEXLinkReference(eLinkElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EConfML2Package.EDATA_ELEMENT: {
			EDataElement eDataElement = (EDataElement) theEObject;
			T result = caseEDataElement(eDataElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EConfML2Package.ERFS_ELEMENT: {
			ERfsElement eRfsElement = (ERfsElement) theEObject;
			T result = caseERfsElement(eRfsElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EConfML2Package.EX_LINK_REFERENCE: {
			EXLinkReference exLinkReference = (EXLinkReference) theEObject;
			T result = caseEXLinkReference(exLinkReference);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EConfML2Package.ECOMMON_ATTRS: {
			ECommonAttrs eCommonAttrs = (ECommonAttrs) theEObject;
			T result = caseECommonAttrs(eCommonAttrs);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EConfML2Package.EMETA_CONTENT: {
			EMetaContent eMetaContent = (EMetaContent) theEObject;
			T result = caseEMetaContent(eMetaContent);
			if (result == null)
				result = caseECommonAttrs(eMetaContent);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EConfML2Package.ECONF_ML2_DOCUMENT: {
			EConfML2Document eConfML2Document = (EConfML2Document) theEObject;
			T result = caseEConfML2Document(eConfML2Document);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EConfML2Package.ELOCAL_PATH_ELEMENT: {
			ELocalPathElement eLocalPathElement = (ELocalPathElement) theEObject;
			T result = caseELocalPathElement(eLocalPathElement);
			if (result == null)
				result = caseECommonAttrs(eLocalPathElement);
			if (result == null)
				result = caseEDescriptionContainer(eLocalPathElement);
			if (result == null)
				result = caseEIconContainer(eLocalPathElement);
			if (result == null)
				result = caseELinkContainer(eLocalPathElement);
			if (result == null)
				result = caseEContents(eLocalPathElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case EConfML2Package.ETARGET_PATH_ELEMENT: {
			ETargetPathElement eTargetPathElement = (ETargetPathElement) theEObject;
			T result = caseETargetPathElement(eTargetPathElement);
			if (result == null)
				result = caseECommonAttrs(eTargetPathElement);
			if (result == null)
				result = caseEDescriptionContainer(eTargetPathElement);
			if (result == null)
				result = caseEIconContainer(eTargetPathElement);
			if (result == null)
				result = caseELinkContainer(eTargetPathElement);
			if (result == null)
				result = caseEContents(eTargetPathElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EConfiguration Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EConfiguration Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEConfigurationElement(EConfigurationElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EContents</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EContents</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEContents(EContents object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EFeature Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EFeature Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEFeatureElement(EFeatureElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EFeature Data</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EFeature Data</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEFeatureData(EFeatureData object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ESetting Type Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ESetting Type Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseESettingTypeContainer(ESettingTypeContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ESetting Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ESetting Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseESettingElement(ESettingElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ESetting Data Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ESetting Data Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseESettingDataContainer(ESettingDataContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ESetting Data</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ESetting Data</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseESettingData(ESettingData object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EView Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EView Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEViewElement(EViewElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EGroup</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EGroup</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEGroup(EGroup object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EGroup Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EGroup Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEGroupContainer(EGroupContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EFeature Rfs</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EFeature Rfs</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEFeatureRfs(EFeatureRfs object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ESetting Rfs</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ESetting Rfs</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseESettingRfs(ESettingRfs object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EMeta Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EMeta Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEMetaContainer(EMetaContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EMeta Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EMeta Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEMetaElement(EMetaElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EOption Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EOption Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEOptionElement(EOptionElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EProperty Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EProperty Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEPropertyElement(EPropertyElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EDescription Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EDescription Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEDescriptionContainer(EDescriptionContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EDescription Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EDescription Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEDescriptionElement(EDescriptionElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EIcon Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EIcon Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEIconContainer(EIconContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EIcon Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EIcon Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEIconElement(EIconElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ELink Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ELink Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseELinkContainer(ELinkContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ELink Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ELink Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseELinkElement(ELinkElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EData Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EData Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEDataElement(EDataElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ERfs Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ERfs Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseERfsElement(ERfsElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EX Link Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EX Link Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEXLinkReference(EXLinkReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ECommon Attrs</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ECommon Attrs</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseECommonAttrs(ECommonAttrs object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EMeta Content</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EMeta Content</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEMetaContent(EMetaContent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ERef Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ERef Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseERefNamedElement(ERefNamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Document</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Document</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEConfML2Document(EConfML2Document object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ELocal Path Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ELocal Path Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseELocalPathElement(ELocalPathElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ETarget Path Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ETarget Path Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseETargetPathElement(ETargetPathElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //EConfML2Switch
