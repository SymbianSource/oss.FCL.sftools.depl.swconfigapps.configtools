/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.nokia.tools.s60ct.model.confml;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EGroup</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.EGroup#getFeatures <em>Features</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.EGroup#getSettingOrder <em>Setting Order</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.EGroup#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getEGroup()
 * @model
 * @generated
 */
public interface EGroup extends EDescriptionContainer {
	/**
	 * Returns the value of the '<em><b>Features</b></em>' reference list.
	 * The list contents are of type {@link com.nokia.tools.s60ct.model.confml.EFeature}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Features</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Features</em>' reference list.
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getEGroup_Features()
	 * @model
	 * @generated
	 */
	EList<EFeature> getFeatures();

	/**
	 * Returns the value of the '<em><b>Setting Order</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Setting Order</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Setting Order</em>' attribute.
	 * @see #setSettingOrder(EList)
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getEGroup_SettingOrder()
	 * @model many="false" transient="true"
	 * @generated
	 */
	EList<String> getSettingOrder();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.EGroup#getSettingOrder <em>Setting Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Setting Order</em>' attribute.
	 * @see #getSettingOrder()
	 * @generated
	 */
	void setSettingOrder(EList<String> value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getEGroup_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.EGroup#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // EGroup
