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
 * Description: This file is part of com.nokia.tools.variant.editor component.
 */

package com.nokia.tools.variant.editor.model.summaryModel;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>SUMMARYTYPE</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.nokia.tools.variant.editor.model.summaryModel.SummaryModelPackage#getSUMMARYTYPE()
 * @model
 * @generated
 */
public enum SUMMARYTYPE implements Enumerator {
	/**
	 * The '<em><b>Name</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NAME_VALUE
	 * @generated
	 * @ordered
	 */
	NAME(0, "name", "name"), /**
	 * The '<em><b>Owner</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OWNER_VALUE
	 * @generated
	 * @ordered
	 */
	OWNER(1, "owner", "owner"), /**
	 * The '<em><b>Contents</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONTENTS_VALUE
	 * @generated
	 * @ordered
	 */
	CONTENTS(2, "contents", "contents"), /**
	 * The '<em><b>Customer</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CUSTOMER_VALUE
	 * @generated
	 * @ordered
	 */
	CUSTOMER(3, "customer", "customer"), /**
	 * The '<em><b>Author</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AUTHOR_VALUE
	 * @generated
	 * @ordered
	 */
	AUTHOR(4, "author", "author"), /**
	 * The '<em><b>Productimages</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PRODUCTIMAGES_VALUE
	 * @generated
	 * @ordered
	 */
	PRODUCTIMAGES(5, "productimages", "productimages"), /**
	 * The '<em><b>Guideline</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GUIDELINE_VALUE
	 * @generated
	 * @ordered
	 */
	GUIDELINE(6, "guideline", "guideline"), /**
	 * The '<em><b>Description</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DESCRIPTION_VALUE
	 * @generated
	 * @ordered
	 */
	DESCRIPTION(7, "description", "description"), /**
	 * The '<em><b>Version</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VERSION_VALUE
	 * @generated
	 * @ordered
	 */
	VERSION(8, "version", "version"), /**
	 * The '<em><b>Date</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DATE_VALUE
	 * @generated
	 * @ordered
	 */
	DATE(9, "date", "date"), /**
	 * The '<em><b>History</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HISTORY_VALUE
	 * @generated
	 * @ordered
	 */
	HISTORY(10, "history", "history"), /**
	 * The '<em><b>Product</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PRODUCT_VALUE
	 * @generated
	 * @ordered
	 */
	PRODUCT(11, "product", "product"), /**
	 * The '<em><b>Platform</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PLATFORM_VALUE
	 * @generated
	 * @ordered
	 */
	PLATFORM(12, "platform", "platform"), /**
	 * The '<em><b>Release</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RELEASE_VALUE
	 * @generated
	 * @ordered
	 */
	RELEASE(13, "release", "release"), /**
	 * The '<em><b>AVR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AVR_VALUE
	 * @generated
	 * @ordered
	 */
	AVR(14, "AVR", "AVR"), /**
	 * The '<em><b>Status</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STATUS_VALUE
	 * @generated
	 * @ordered
	 */
	STATUS(15, "status", "status"), /**
	 * The '<em><b>Origin</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ORIGIN_VALUE
	 * @generated
	 * @ordered
	 */
	ORIGIN(16, "origin", "origin"), /**
	 * The '<em><b>Target</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TARGET_VALUE
	 * @generated
	 * @ordered
	 */
	TARGET(17, "target", "target");

	/**
	 * The '<em><b>Name</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Name</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NAME
	 * @model name="name"
	 * @generated
	 * @ordered
	 */
	public static final int NAME_VALUE = 0;

	/**
	 * The '<em><b>Owner</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Owner</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OWNER
	 * @model name="owner"
	 * @generated
	 * @ordered
	 */
	public static final int OWNER_VALUE = 1;

	/**
	 * The '<em><b>Contents</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Contents</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CONTENTS
	 * @model name="contents"
	 * @generated
	 * @ordered
	 */
	public static final int CONTENTS_VALUE = 2;

	/**
	 * The '<em><b>Customer</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Customer</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CUSTOMER
	 * @model name="customer"
	 * @generated
	 * @ordered
	 */
	public static final int CUSTOMER_VALUE = 3;

	/**
	 * The '<em><b>Author</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Author</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AUTHOR
	 * @model name="author"
	 * @generated
	 * @ordered
	 */
	public static final int AUTHOR_VALUE = 4;

	/**
	 * The '<em><b>Productimages</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Productimages</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PRODUCTIMAGES
	 * @model name="productimages"
	 * @generated
	 * @ordered
	 */
	public static final int PRODUCTIMAGES_VALUE = 5;

	/**
	 * The '<em><b>Guideline</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Guideline</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GUIDELINE
	 * @model name="guideline"
	 * @generated
	 * @ordered
	 */
	public static final int GUIDELINE_VALUE = 6;

	/**
	 * The '<em><b>Description</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Description</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DESCRIPTION
	 * @model name="description"
	 * @generated
	 * @ordered
	 */
	public static final int DESCRIPTION_VALUE = 7;

	/**
	 * The '<em><b>Version</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Version</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VERSION
	 * @model name="version"
	 * @generated
	 * @ordered
	 */
	public static final int VERSION_VALUE = 8;

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
	public static final int DATE_VALUE = 9;

	/**
	 * The '<em><b>History</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>History</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HISTORY
	 * @model name="history"
	 * @generated
	 * @ordered
	 */
	public static final int HISTORY_VALUE = 10;

	/**
	 * The '<em><b>Product</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Product</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PRODUCT
	 * @model name="product"
	 * @generated
	 * @ordered
	 */
	public static final int PRODUCT_VALUE = 11;

	/**
	 * The '<em><b>Platform</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Platform</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PLATFORM
	 * @model name="platform"
	 * @generated
	 * @ordered
	 */
	public static final int PLATFORM_VALUE = 12;

	/**
	 * The '<em><b>Release</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Release</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RELEASE
	 * @model name="release"
	 * @generated
	 * @ordered
	 */
	public static final int RELEASE_VALUE = 13;

	/**
	 * The '<em><b>AVR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>AVR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AVR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int AVR_VALUE = 14;

	/**
	 * The '<em><b>Status</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Status</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STATUS
	 * @model name="status"
	 * @generated
	 * @ordered
	 */
	public static final int STATUS_VALUE = 15;

	/**
	 * The '<em><b>Origin</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Origin</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ORIGIN
	 * @model name="origin"
	 * @generated
	 * @ordered
	 */
	public static final int ORIGIN_VALUE = 16;

	/**
	 * The '<em><b>Target</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Target</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TARGET
	 * @model name="target"
	 * @generated
	 * @ordered
	 */
	public static final int TARGET_VALUE = 17;

	/**
	 * An array of all the '<em><b>SUMMARYTYPE</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final SUMMARYTYPE[] VALUES_ARRAY =
		new SUMMARYTYPE[] {
			NAME,
			OWNER,
			CONTENTS,
			CUSTOMER,
			AUTHOR,
			PRODUCTIMAGES,
			GUIDELINE,
			DESCRIPTION,
			VERSION,
			DATE,
			HISTORY,
			PRODUCT,
			PLATFORM,
			RELEASE,
			AVR,
			STATUS,
			ORIGIN,
			TARGET,
		};

	/**
	 * A public read-only list of all the '<em><b>SUMMARYTYPE</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<SUMMARYTYPE> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>SUMMARYTYPE</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SUMMARYTYPE get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SUMMARYTYPE result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>SUMMARYTYPE</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SUMMARYTYPE getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SUMMARYTYPE result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>SUMMARYTYPE</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SUMMARYTYPE get(int value) {
		switch (value) {
			case NAME_VALUE: return NAME;
			case OWNER_VALUE: return OWNER;
			case CONTENTS_VALUE: return CONTENTS;
			case CUSTOMER_VALUE: return CUSTOMER;
			case AUTHOR_VALUE: return AUTHOR;
			case PRODUCTIMAGES_VALUE: return PRODUCTIMAGES;
			case GUIDELINE_VALUE: return GUIDELINE;
			case DESCRIPTION_VALUE: return DESCRIPTION;
			case VERSION_VALUE: return VERSION;
			case DATE_VALUE: return DATE;
			case HISTORY_VALUE: return HISTORY;
			case PRODUCT_VALUE: return PRODUCT;
			case PLATFORM_VALUE: return PLATFORM;
			case RELEASE_VALUE: return RELEASE;
			case AVR_VALUE: return AVR;
			case STATUS_VALUE: return STATUS;
			case ORIGIN_VALUE: return ORIGIN;
			case TARGET_VALUE: return TARGET;
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
	private SUMMARYTYPE(int value, String name, String literal) {
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
	
} //SUMMARYTYPE
