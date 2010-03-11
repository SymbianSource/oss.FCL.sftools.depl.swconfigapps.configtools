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
package configurationemf;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>EXTENSION POLICY</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see configurationemf.ConfigurationemfPackage#getEXTENSION_POLICY()
 * @model
 * @generated
 */
public enum EXTENSION_POLICY implements Enumerator {
	/**
	 * The '<em><b>Replace</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REPLACE_VALUE
	 * @generated
	 * @ordered
	 */
	REPLACE(0, "replace", "replace"),

	/**
	 * The '<em><b>Append</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #APPEND_VALUE
	 * @generated
	 * @ordered
	 */
	APPEND(1, "append", "append"),

	/**
	 * The '<em><b>Prefix</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PREFIX_VALUE
	 * @generated
	 * @ordered
	 */
	PREFIX(2, "prefix", "prefix"), /**
	 * The '<em><b>No policy</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NO_POLICY_VALUE
	 * @generated
	 * @ordered
	 */
	NO_POLICY(-1, "no_policy", "no_policy");

	/**
	 * The '<em><b>Replace</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Replace</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #REPLACE
	 * @model name="replace"
	 * @generated
	 * @ordered
	 */
	public static final int REPLACE_VALUE = 0;

	/**
	 * The '<em><b>Append</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Append</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #APPEND
	 * @model name="append"
	 * @generated
	 * @ordered
	 */
	public static final int APPEND_VALUE = 1;

	/**
	 * The '<em><b>Prefix</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Prefix</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PREFIX
	 * @model name="prefix"
	 * @generated
	 * @ordered
	 */
	public static final int PREFIX_VALUE = 2;

	/**
	 * The '<em><b>No policy</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>No policy</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NO_POLICY
	 * @model name="no_policy"
	 * @generated
	 * @ordered
	 */
	public static final int NO_POLICY_VALUE = -1;

	/**
	 * An array of all the '<em><b>EXTENSION POLICY</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final EXTENSION_POLICY[] VALUES_ARRAY =
		new EXTENSION_POLICY[] {
			REPLACE,
			APPEND,
			PREFIX,
			NO_POLICY,
		};

	/**
	 * A public read-only list of all the '<em><b>EXTENSION POLICY</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<EXTENSION_POLICY> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>EXTENSION POLICY</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EXTENSION_POLICY get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EXTENSION_POLICY result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>EXTENSION POLICY</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EXTENSION_POLICY getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EXTENSION_POLICY result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>EXTENSION POLICY</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EXTENSION_POLICY get(int value) {
		switch (value) {
			case REPLACE_VALUE: return REPLACE;
			case APPEND_VALUE: return APPEND;
			case PREFIX_VALUE: return PREFIX;
			case NO_POLICY_VALUE: return NO_POLICY;
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
	private EXTENSION_POLICY(int value, String name, String literal) {
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
	
} //EXTENSION_POLICY
