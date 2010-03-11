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
 * Description: This file is part of com.nokia.tools.variant.javascript component.
 */
package com.nokia.tools.variant.javascript.jsmodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.nokia.tools.variant.javascript.jsmodel.EJSModelFactory
 * @model kind="package"
 * @generated
 */
public interface EJSModelPackage extends EPackage {
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "jsmodel";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "platform://com.nokia.tools.variant.javascript/js.ecore";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "js";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EJSModelPackage eINSTANCE = com.nokia.tools.variant.javascript.jsmodel.impl.EJSModelPackageImpl.init();

    /**
     * The meta object id for the '{@link com.nokia.tools.variant.javascript.jsmodel.impl.EJSDocumentImpl <em>EJS Document</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.nokia.tools.variant.javascript.jsmodel.impl.EJSDocumentImpl
     * @see com.nokia.tools.variant.javascript.jsmodel.impl.EJSModelPackageImpl#getEJSDocument()
     * @generated
     */
    int EJS_DOCUMENT = 0;

    /**
     * The feature id for the '<em><b>Script</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EJS_DOCUMENT__SCRIPT = 0;

    /**
     * The number of structural features of the '<em>EJS Document</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EJS_DOCUMENT_FEATURE_COUNT = 1;


    /**
     * Returns the meta object for class '{@link com.nokia.tools.variant.javascript.jsmodel.EJSDocument <em>EJS Document</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>EJS Document</em>'.
     * @see com.nokia.tools.variant.javascript.jsmodel.EJSDocument
     * @generated
     */
    EClass getEJSDocument();

    /**
     * Returns the meta object for the attribute '{@link com.nokia.tools.variant.javascript.jsmodel.EJSDocument#getScript <em>Script</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Script</em>'.
     * @see com.nokia.tools.variant.javascript.jsmodel.EJSDocument#getScript()
     * @see #getEJSDocument()
     * @generated
     */
    EAttribute getEJSDocument_Script();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    EJSModelFactory getEJSModelFactory();

    /**
     * <!-- begin-user-doc -->
     * Defines literals for the meta objects that represent
     * <ul>
     *   <li>each class,</li>
     *   <li>each feature of each class,</li>
     *   <li>each enum,</li>
     *   <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * @generated
     */
    interface Literals {
        /**
         * The meta object literal for the '{@link com.nokia.tools.variant.javascript.jsmodel.impl.EJSDocumentImpl <em>EJS Document</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.nokia.tools.variant.javascript.jsmodel.impl.EJSDocumentImpl
         * @see com.nokia.tools.variant.javascript.jsmodel.impl.EJSModelPackageImpl#getEJSDocument()
         * @generated
         */
        EClass EJS_DOCUMENT = eINSTANCE.getEJSDocument();

        /**
         * The meta object literal for the '<em><b>Script</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EJS_DOCUMENT__SCRIPT = eINSTANCE.getEJSDocument_Script();

    }

} //EJSModelPackage
