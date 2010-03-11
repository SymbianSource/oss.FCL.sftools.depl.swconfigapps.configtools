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
 * Description: This file is part of com.nokia.tools.vct.common.appmodel component.
 */

package com.nokia.tools.vct.common.appmodel;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * <p>
 * Configuration project storage class.
 * </p>
 * <p>
 * The configuration project may have a form of file structure, ZIP archive or
 * encrypted form.
 * </p>
 * <!-- end-user-doc -->
 * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEStorageClass()
 * @model
 * @generated
 */
public enum EStorageClass implements Enumerator {
    /**
	 * The '<em><b>PROJECT</b></em>' literal object.
	 * <!-- begin-user-doc -->
     * <p>
     * IDE project structure
     * </p>
     * <!-- end-user-doc -->
	 * @see #PROJECT_VALUE
	 * @generated
	 * @ordered
	 */
    PROJECT(0, "PROJECT", "PROJECT"),

    /**
	 * The '<em><b>PKZIP</b></em>' literal object.
	 * <!-- begin-user-doc -->
     * <p>
     * Project structure in a form of ZIP
     * </p>
     * <!-- end-user-doc -->
	 * @see #PKZIP_VALUE
	 * @generated
	 * @ordered
	 */
    PKZIP(1, "PKZIP", "PKZIP"),

    /**
	 * The '<em><b>SECURE M0</b></em>' literal object.
	 * <!-- begin-user-doc -->
     * <p>
     * Project structure in a form of encrypted archive with embedded key.
     * </p>
     * <!-- end-user-doc -->
	 * @see #SECURE_M0_VALUE
	 * @generated
	 * @ordered
	 */
    SECURE_M0(2, "SECURE_M0", "SECURE_M0"), /**
	 * The '<em><b>ENCRYPTED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ENCRYPTED_VALUE
	 * @generated
	 * @ordered
	 */
	ENCRYPTED(3, "ENCRYPTED", "ENCRYPTED");

    /**
	 * The '<em><b>PROJECT</b></em>' literal value.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>PROJECT</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @see #PROJECT
	 * @model
	 * @generated
	 * @ordered
	 */
    public static final int PROJECT_VALUE = 0;

    /**
	 * The '<em><b>PKZIP</b></em>' literal value.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>PKZIP</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @see #PKZIP
	 * @model
	 * @generated
	 * @ordered
	 */
    public static final int PKZIP_VALUE = 1;

    /**
	 * The '<em><b>SECURE M0</b></em>' literal value.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>SECURE M0</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @see #SECURE_M0
	 * @model
	 * @generated
	 * @ordered
	 */
    public static final int SECURE_M0_VALUE = 2;

    /**
	 * The '<em><b>ENCRYPTED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ENCRYPTED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ENCRYPTED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ENCRYPTED_VALUE = 3;

				/**
     * An array of all the '<em><b>EStorage Class</b></em>' enumerators. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private static final EStorageClass[] VALUES_ARRAY = new EStorageClass[] {
			PROJECT,
			PKZIP,
			SECURE_M0,
			ENCRYPTED,
		};

    /**
	 * A public read-only list of all the '<em><b>EStorage Class</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public static final List<EStorageClass> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
	 * Returns the '<em><b>EStorage Class</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public static EStorageClass get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EStorageClass result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

    /**
	 * Returns the '<em><b>EStorage Class</b></em>' literal with the specified name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public static EStorageClass getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EStorageClass result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

    /**
	 * Returns the '<em><b>EStorage Class</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public static EStorageClass get(int value) {
		switch (value) {
			case PROJECT_VALUE: return PROJECT;
			case PKZIP_VALUE: return PKZIP;
			case SECURE_M0_VALUE: return SECURE_M0;
			case ENCRYPTED_VALUE: return ENCRYPTED;
		}
		return null;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    private final int value;

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    private final String name;

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    private final String literal;

    /**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @generated
	 */
    private EStorageClass(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public int getValue() {
	  return value;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public String getName() {
	  return name;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public String getLiteral() {
	  return literal;
	}

    /**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public String toString() {
		return literal;
	}

} // EStorageClass
