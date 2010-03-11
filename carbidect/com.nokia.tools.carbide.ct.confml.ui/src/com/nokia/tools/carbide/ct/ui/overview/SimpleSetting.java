/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.nokia.tools.carbide.ct.ui.overview;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple Setting</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.carbide.ct.ui.overview.SimpleSetting#getType <em>Type</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.ui.overview.SimpleSetting#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.carbide.ct.ui.overview.OverviewPackage#getSimpleSetting()
 * @model
 * @generated
 */
public interface SimpleSetting extends Setting {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' reference.
	 * @see #setValue(SimpleValue)
	 * @see com.nokia.tools.carbide.ct.ui.overview.OverviewPackage#getSimpleSetting_Value()
	 * @model
	 * @generated
	 */
	SimpleValue getValue();

	/**
	 * Sets the value of the '{@link com.nokia.tools.carbide.ct.ui.overview.SimpleSetting#getValue <em>Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(SimpleValue value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see com.nokia.tools.carbide.ct.ui.overview.OverviewPackage#getSimpleSetting_Type()
	 * @model
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link com.nokia.tools.carbide.ct.ui.overview.SimpleSetting#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

} // SimpleSetting
