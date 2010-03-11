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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EDiff Resource Setting2</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.variant.compare.cmodel.EDiffResourceSetting2#getSourcePath <em>Source Path</em>}</li>
 *   <li>{@link com.nokia.tools.variant.compare.cmodel.EDiffResourceSetting2#getTargetPath <em>Target Path</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.variant.compare.cmodel.ECompareModelPackage#getEDiffResourceSetting2()
 * @model
 * @generated
 */
public interface EDiffResourceSetting2 extends EDiffSetting {
	/**
	 * Returns the value of the '<em><b>Source Path</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Path</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Path</em>' containment reference.
	 * @see #setSourcePath(EDiffLocalPathSetting)
	 * @see com.nokia.tools.variant.compare.cmodel.ECompareModelPackage#getEDiffResourceSetting2_SourcePath()
	 * @model containment="true"
	 * @generated
	 */
	EDiffLocalPathSetting getSourcePath();

	/**
	 * Sets the value of the '{@link com.nokia.tools.variant.compare.cmodel.EDiffResourceSetting2#getSourcePath <em>Source Path</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Path</em>' containment reference.
	 * @see #getSourcePath()
	 * @generated
	 */
	void setSourcePath(EDiffLocalPathSetting value);

	/**
	 * Returns the value of the '<em><b>Target Path</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Path</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Path</em>' containment reference.
	 * @see #setTargetPath(EDiffSimple)
	 * @see com.nokia.tools.variant.compare.cmodel.ECompareModelPackage#getEDiffResourceSetting2_TargetPath()
	 * @model containment="true"
	 * @generated
	 */
	EDiffSimple getTargetPath();

	/**
	 * Sets the value of the '{@link com.nokia.tools.variant.compare.cmodel.EDiffResourceSetting2#getTargetPath <em>Target Path</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Path</em>' containment reference.
	 * @see #getTargetPath()
	 * @generated
	 */
	void setTargetPath(EDiffSimple value);

} // EDiffResourceSetting2
