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
 * Description: This file is part of com.nokia.tools.variant.content.confml.model component.
 */

package com.nokia.tools.variant.content.confml;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>TYPE</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.nokia.tools.variant.content.confml.ConfmlPackage#getTYPE()
 * @model
 * @generated
 */
public enum TYPE implements Enumerator {
	/**
	 * The '<em><b>Int</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INT_VALUE
	 * @generated
	 * @ordered
	 */
	INT(0, "int", "int"),

	/**
	 * The '<em><b>String</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STRING_VALUE
	 * @generated
	 * @ordered
	 */
	STRING(1, "string", "string"),

	/**
	 * The '<em><b>Real</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REAL_VALUE
	 * @generated
	 * @ordered
	 */
	REAL(2, "real", "real"),

	/**
	 * The '<em><b>Selection</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SELECTION_VALUE
	 * @generated
	 * @ordered
	 */
	SELECTION(3, "selection", "selection"),

	/**
	 * The '<em><b>Boolean</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BOOLEAN_VALUE
	 * @generated
	 * @ordered
	 */
	BOOLEAN(4, "boolean", "boolean"),

	/**
	 * The '<em><b>File</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FILE_VALUE
	 * @generated
	 * @ordered
	 */
	FILE(6, "file", "file"),

	/**
	 * The '<em><b>Folder</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FOLDER_VALUE
	 * @generated
	 * @ordered
	 */
	FOLDER(7, "folder", "folder"), /**
	 * The '<em><b>Sequence</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SEQUENCE_VALUE
	 * @generated
	 * @ordered
	 */
	SEQUENCE(8, "sequence", "sequence"), /**
	 * The '<em><b>Date Time</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DATE_TIME_VALUE
	 * @generated
	 * @ordered
	 */
	DATE_TIME(9, "dateTime", "dateTime"), /**
	 * The '<em><b>Date</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DATE_VALUE
	 * @generated
	 * @ordered
	 */
	DATE(10, "date", "date"), /**
	 * The '<em><b>Time</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TIME_VALUE
	 * @generated
	 * @ordered
	 */
	TIME(11, "time", "time"), /**
	 * The '<em><b>Duration</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DURATION_VALUE
	 * @generated
	 * @ordered
	 */
	DURATION(12, "duration", "duration"), /**
	 * The '<em><b>Multiselection</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MULTISELECTION_VALUE
	 * @generated
	 * @ordered
	 */
	MULTISELECTION(13, "multiselection", "multiselection"), /**
	 * The '<em><b>Simple file</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SIMPLE_FILE_VALUE
	 * @generated
	 * @ordered
	 */
	SIMPLE_FILE(14, "simple_file", ""), /**
	 * The '<em><b>Simple folder</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SIMPLE_FOLDER_VALUE
	 * @generated
	 * @ordered
	 */
	SIMPLE_FOLDER(15, "simple_folder", "simple_folder"), /**
	 * The '<em><b>Filesource</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FILESOURCE_VALUE
	 * @generated
	 * @ordered
	 */
	FILESOURCE(16, "filesource", "filesource"), /**
	 * The '<em><b>Filetarget</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FILETARGET_VALUE
	 * @generated
	 * @ordered
	 */
	FILETARGET(17, "filetarget", "filetarget");

	/**
	 * The '<em><b>Int</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Int</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INT
	 * @model name="int"
	 * @generated
	 * @ordered
	 */
	public static final int INT_VALUE = 0;

	/**
	 * The '<em><b>String</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>String</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STRING
	 * @model name="string"
	 * @generated
	 * @ordered
	 */
	public static final int STRING_VALUE = 1;

	/**
	 * The '<em><b>Real</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Real</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #REAL
	 * @model name="real"
	 * @generated
	 * @ordered
	 */
	public static final int REAL_VALUE = 2;

	/**
	 * The '<em><b>Selection</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Selection</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SELECTION
	 * @model name="selection"
	 * @generated
	 * @ordered
	 */
	public static final int SELECTION_VALUE = 3;

	/**
	 * The '<em><b>Boolean</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Boolean</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BOOLEAN
	 * @model name="boolean"
	 * @generated
	 * @ordered
	 */
	public static final int BOOLEAN_VALUE = 4;

	/**
	 * The '<em><b>File</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>File</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FILE
	 * @model name="file"
	 * @generated
	 * @ordered
	 */
	public static final int FILE_VALUE = 6;

	/**
	 * The '<em><b>Folder</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Folder</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FOLDER
	 * @model name="folder"
	 * @generated
	 * @ordered
	 */
	public static final int FOLDER_VALUE = 7;

	/**
	 * The '<em><b>Sequence</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Sequence</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SEQUENCE
	 * @model name="sequence"
	 * @generated
	 * @ordered
	 */
	public static final int SEQUENCE_VALUE = 8;

	/**
	 * The '<em><b>Date Time</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Date Time</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DATE_TIME
	 * @model name="dateTime"
	 * @generated
	 * @ordered
	 */
	public static final int DATE_TIME_VALUE = 9;

	/**
	 * The '<em><b>Date</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Date</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DATE
	 * @model name="date"
	 * @generated
	 * @ordered
	 */
	public static final int DATE_VALUE = 10;

	/**
	 * The '<em><b>Time</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Time</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TIME
	 * @model name="time"
	 * @generated
	 * @ordered
	 */
	public static final int TIME_VALUE = 11;

	/**
	 * The '<em><b>Duration</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Duration</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DURATION
	 * @model name="duration"
	 * @generated
	 * @ordered
	 */
	public static final int DURATION_VALUE = 12;

	/**
	 * The '<em><b>Multiselection</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Multiselection</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MULTISELECTION
	 * @model name="multiselection"
	 * @generated
	 * @ordered
	 */
	public static final int MULTISELECTION_VALUE = 13;

	/**
	 * The '<em><b>Simple file</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Simple file</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SIMPLE_FILE
	 * @model name="simple_file" literal=""
	 * @generated
	 * @ordered
	 */
	public static final int SIMPLE_FILE_VALUE = 14;

	/**
	 * The '<em><b>Simple folder</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Simple folder</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SIMPLE_FOLDER
	 * @model name="simple_folder"
	 * @generated
	 * @ordered
	 */
	public static final int SIMPLE_FOLDER_VALUE = 15;

	/**
	 * The '<em><b>Filesource</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Filesource</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FILESOURCE
	 * @model name="filesource"
	 * @generated
	 * @ordered
	 */
	public static final int FILESOURCE_VALUE = 16;

	/**
	 * The '<em><b>Filetarget</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Filetarget</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FILETARGET
	 * @model name="filetarget"
	 * @generated
	 * @ordered
	 */
	public static final int FILETARGET_VALUE = 17;

	/**
	 * An array of all the '<em><b>TYPE</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final TYPE[] VALUES_ARRAY =
		new TYPE[] {
			INT,
			STRING,
			REAL,
			SELECTION,
			BOOLEAN,
			FILE,
			FOLDER,
			SEQUENCE,
			DATE_TIME,
			DATE,
			TIME,
			DURATION,
			MULTISELECTION,
			SIMPLE_FILE,
			SIMPLE_FOLDER,
			FILESOURCE,
			FILETARGET,
		};

	/**
	 * A public read-only list of all the '<em><b>TYPE</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<TYPE> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>TYPE</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TYPE get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TYPE result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>TYPE</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TYPE getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TYPE result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>TYPE</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TYPE get(int value) {
		switch (value) {
			case INT_VALUE: return INT;
			case STRING_VALUE: return STRING;
			case REAL_VALUE: return REAL;
			case SELECTION_VALUE: return SELECTION;
			case BOOLEAN_VALUE: return BOOLEAN;
			case FILE_VALUE: return FILE;
			case FOLDER_VALUE: return FOLDER;
			case SEQUENCE_VALUE: return SEQUENCE;
			case DATE_TIME_VALUE: return DATE_TIME;
			case DATE_VALUE: return DATE;
			case TIME_VALUE: return TIME;
			case DURATION_VALUE: return DURATION;
			case MULTISELECTION_VALUE: return MULTISELECTION;
			case SIMPLE_FILE_VALUE: return SIMPLE_FILE;
			case SIMPLE_FOLDER_VALUE: return SIMPLE_FOLDER;
			case FILESOURCE_VALUE: return FILESOURCE;
			case FILETARGET_VALUE: return FILETARGET;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private TYPE(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //TYPE
