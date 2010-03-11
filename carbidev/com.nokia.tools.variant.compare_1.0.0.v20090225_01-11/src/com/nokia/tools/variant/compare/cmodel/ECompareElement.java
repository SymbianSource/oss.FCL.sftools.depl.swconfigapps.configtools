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
 * Description: This file is part of com.nokia.tools.variant.compare component.
 */

package com.nokia.tools.variant.compare.cmodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ECompare Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.variant.compare.cmodel.ECompareElement#isExistsInSource <em>Exists In Source</em>}</li>
 *   <li>{@link com.nokia.tools.variant.compare.cmodel.ECompareElement#isExistsInTarget <em>Exists In Target</em>}</li>
 *   <li>{@link com.nokia.tools.variant.compare.cmodel.ECompareElement#getSourceObject <em>Source Object</em>}</li>
 *   <li>{@link com.nokia.tools.variant.compare.cmodel.ECompareElement#getTargetObject <em>Target Object</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.variant.compare.cmodel.ECompareModelPackage#getECompareElement()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface ECompareElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Exists In Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exists In Source</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exists In Source</em>' attribute.
	 * @see #setExistsInSource(boolean)
	 * @see com.nokia.tools.variant.compare.cmodel.ECompareModelPackage#getECompareElement_ExistsInSource()
	 * @model
	 * @generated
	 */
	boolean isExistsInSource();

	/**
	 * Sets the value of the '{@link com.nokia.tools.variant.compare.cmodel.ECompareElement#isExistsInSource <em>Exists In Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exists In Source</em>' attribute.
	 * @see #isExistsInSource()
	 * @generated
	 */
	void setExistsInSource(boolean value);

	/**
	 * Returns the value of the '<em><b>Exists In Target</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exists In Target</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exists In Target</em>' attribute.
	 * @see #setExistsInTarget(boolean)
	 * @see com.nokia.tools.variant.compare.cmodel.ECompareModelPackage#getECompareElement_ExistsInTarget()
	 * @model
	 * @generated
	 */
	boolean isExistsInTarget();

	/**
	 * Sets the value of the '{@link com.nokia.tools.variant.compare.cmodel.ECompareElement#isExistsInTarget <em>Exists In Target</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exists In Target</em>' attribute.
	 * @see #isExistsInTarget()
	 * @generated
	 */
	void setExistsInTarget(boolean value);

	/**
	 * Returns the value of the '<em><b>Source Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Object</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Object</em>' reference.
	 * @see #setSourceObject(EObject)
	 * @see com.nokia.tools.variant.compare.cmodel.ECompareModelPackage#getECompareElement_SourceObject()
	 * @model
	 * @generated
	 */
	EObject getSourceObject();

	/**
	 * Sets the value of the '{@link com.nokia.tools.variant.compare.cmodel.ECompareElement#getSourceObject <em>Source Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Object</em>' reference.
	 * @see #getSourceObject()
	 * @generated
	 */
	void setSourceObject(EObject value);

	/**
	 * Returns the value of the '<em><b>Target Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Object</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Object</em>' reference.
	 * @see #setTargetObject(EObject)
	 * @see com.nokia.tools.variant.compare.cmodel.ECompareModelPackage#getECompareElement_TargetObject()
	 * @model
	 * @generated
	 */
	EObject getTargetObject();

	/**
	 * Sets the value of the '{@link com.nokia.tools.variant.compare.cmodel.ECompareElement#getTargetObject <em>Target Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Object</em>' reference.
	 * @see #getTargetObject()
	 * @generated
	 */
	void setTargetObject(EObject value);

} // ECompareElement
