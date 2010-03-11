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
 * Enumeration of the supported "simple" data types. This enumeration contains
 * union of the simple types defined in ConfML v1 and v2.
 * </p>
 * <!-- end-user-doc -->
 * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEAppValueType()
 * @model
 * @generated
 */
public enum EAppValueType implements Enumerator {
    /**
	 * The '<em><b>STRING</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @see #STRING_VALUE
	 * @generated
	 * @ordered
	 */
    STRING(0, "STRING", "STRING"),

    /**
	 * The '<em><b>INTEGER</b></em>' literal object.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #INTEGER_VALUE
	 * @generated
	 * @ordered
	 */
    INTEGER(1, "INTEGER", "INTEGER"),

    /**
	 * The '<em><b>DECIMAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #DECIMAL_VALUE
	 * @generated
	 * @ordered
	 */
    DECIMAL(2, "DECIMAL", "DECIMAL"), /**
	 * The '<em><b>SELECTION</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #SELECTION_VALUE
	 * @generated
	 * @ordered
	 */
    SELECTION(4, "SELECTION", "SELECTION"), /**
	 * The '<em><b>BOOLEAN</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #BOOLEAN_VALUE
	 * @generated
	 * @ordered
	 */
    BOOLEAN(5, "BOOLEAN", "BOOLEAN"), /**
	 * The '<em><b>MULTISELECTION</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #MULTISELECTION_VALUE
	 * @generated
	 * @ordered
	 */
    MULTISELECTION(6, "MULTISELECTION", "MULTISELECTION"), /**
	 * The '<em><b>DATE</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @see #DATE_VALUE
	 * @generated
	 * @ordered
	 */
    DATE(7, "DATE", "DATE"), /**
     * The '<em><b>TIME</b></em>' literal object. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #TIME_VALUE
     * @generated
     * @ordered
     */
    TIME(8, "TIME", "TIME"), /**
	 * The '<em><b>DATETIME</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #DATETIME_VALUE
	 * @generated
	 * @ordered
	 */
    DATETIME(9, "DATETIME", "DATETIME"), /**
	 * The '<em><b>DURATION</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #DURATION_VALUE
	 * @generated
	 * @ordered
	 */
    DURATION(10, "DURATION", "DURATION"), /**
	 * The '<em><b>LOCAL FILE</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #LOCAL_FILE_VALUE
	 * @generated
	 * @ordered
	 */
    LOCAL_FILE(11, "LOCAL_FILE", "LOCAL_FILE"), /**
	 * The '<em><b>LOCAL FOLDER</b></em>' literal object.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #LOCAL_FOLDER_VALUE
	 * @generated
	 * @ordered
	 */
    LOCAL_FOLDER(12, "LOCAL_FOLDER", "LOCAL_FOLDER");

    /**
	 * The '<em><b>STRING</b></em>' literal value.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>STRING</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @see #STRING
	 * @model
	 * @generated
	 * @ordered
	 */
    public static final int STRING_VALUE = 0;

    /**
	 * The '<em><b>INTEGER</b></em>' literal value.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>INTEGER</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @see #INTEGER
	 * @model
	 * @generated
	 * @ordered
	 */
    public static final int INTEGER_VALUE = 1;

    /**
	 * The '<em><b>DECIMAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>DECIMAL</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @see #DECIMAL
	 * @model
	 * @generated
	 * @ordered
	 */
    public static final int DECIMAL_VALUE = 2;

    /**
	 * The '<em><b>SELECTION</b></em>' literal value.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>SELECTION</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @see #SELECTION
	 * @model
	 * @generated
	 * @ordered
	 */
    public static final int SELECTION_VALUE = 4;

    /**
	 * The '<em><b>BOOLEAN</b></em>' literal value.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>BOOLEAN</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @see #BOOLEAN
	 * @model
	 * @generated
	 * @ordered
	 */
    public static final int BOOLEAN_VALUE = 5;

    /**
	 * The '<em><b>MULTISELECTION</b></em>' literal value.
	 * <!-- begin-user-doc
     * -->
     * <p>
     * If the meaning of '<em><b>MULTISELECTION</b></em>' literal object isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @see #MULTISELECTION
	 * @model
	 * @generated
	 * @ordered
	 */
    public static final int MULTISELECTION_VALUE = 6;

    /**
	 * The '<em><b>DATE</b></em>' literal value.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>DATE</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @see #DATE
	 * @model
	 * @generated
	 * @ordered
	 */
    public static final int DATE_VALUE = 7;

    /**
	 * The '<em><b>TIME</b></em>' literal value.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>TIME</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @see #TIME
	 * @model
	 * @generated
	 * @ordered
	 */
    public static final int TIME_VALUE = 8;

    /**
	 * The '<em><b>DATETIME</b></em>' literal value.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>DATETIME</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @see #DATETIME
	 * @model
	 * @generated
	 * @ordered
	 */
    public static final int DATETIME_VALUE = 9;

    /**
	 * The '<em><b>DURATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>DURATION</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @see #DURATION
	 * @model
	 * @generated
	 * @ordered
	 */
    public static final int DURATION_VALUE = 10;

    /**
	 * The '<em><b>LOCAL FILE</b></em>' literal value.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>LOCAL FILE</b></em>' literal object isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @see #LOCAL_FILE
	 * @model
	 * @generated
	 * @ordered
	 */
    public static final int LOCAL_FILE_VALUE = 11;

    /**
	 * The '<em><b>LOCAL FOLDER</b></em>' literal value.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>LOCAL FOLDER</b></em>' literal object isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @see #LOCAL_FOLDER
	 * @model
	 * @generated
	 * @ordered
	 */
    public static final int LOCAL_FOLDER_VALUE = 12;

    /**
     * An array of all the '<em><b>EApp Value Type</b></em>' enumerators. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private static final EAppValueType[] VALUES_ARRAY = new EAppValueType[] {
			STRING,
			INTEGER,
			DECIMAL,
			SELECTION,
			BOOLEAN,
			MULTISELECTION,
			DATE,
			TIME,
			DATETIME,
			DURATION,
			LOCAL_FILE,
			LOCAL_FOLDER,
		};

    /**
	 * A public read-only list of all the '<em><b>EApp Value Type</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public static final List<EAppValueType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
	 * Returns the '<em><b>EApp Value Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public static EAppValueType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EAppValueType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

    /**
	 * Returns the '<em><b>EApp Value Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public static EAppValueType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EAppValueType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

    /**
	 * Returns the '<em><b>EApp Value Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public static EAppValueType get(int value) {
		switch (value) {
			case STRING_VALUE: return STRING;
			case INTEGER_VALUE: return INTEGER;
			case DECIMAL_VALUE: return DECIMAL;
			case SELECTION_VALUE: return SELECTION;
			case BOOLEAN_VALUE: return BOOLEAN;
			case MULTISELECTION_VALUE: return MULTISELECTION;
			case DATE_VALUE: return DATE;
			case TIME_VALUE: return TIME;
			case DATETIME_VALUE: return DATETIME;
			case DURATION_VALUE: return DURATION;
			case LOCAL_FILE_VALUE: return LOCAL_FILE;
			case LOCAL_FOLDER_VALUE: return LOCAL_FOLDER;
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
    private EAppValueType(int value, String name, String literal) {
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

} // EAppValueType
