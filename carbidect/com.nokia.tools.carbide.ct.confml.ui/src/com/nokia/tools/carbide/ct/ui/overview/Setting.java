/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.nokia.tools.carbide.ct.ui.overview;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Setting</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.carbide.ct.ui.overview.Setting#getRef <em>Ref</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.ui.overview.Setting#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.carbide.ct.ui.overview.OverviewPackage#getSetting()
 * @model abstract="true"
 * @generated
 */
public interface Setting extends LineNumberContainer {
	/**
	 * Returns the value of the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ref</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ref</em>' attribute.
	 * @see #setRef(String)
	 * @see com.nokia.tools.carbide.ct.ui.overview.OverviewPackage#getSetting_Ref()
	 * @model
	 * @generated
	 */
	String getRef();

	/**
	 * Sets the value of the '{@link com.nokia.tools.carbide.ct.ui.overview.Setting#getRef <em>Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref</em>' attribute.
	 * @see #getRef()
	 * @generated
	 */
	void setRef(String value);

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
	 * @see com.nokia.tools.carbide.ct.ui.overview.OverviewPackage#getSetting_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.nokia.tools.carbide.ct.ui.overview.Setting#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Setting
