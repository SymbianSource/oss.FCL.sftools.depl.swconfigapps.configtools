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
 * A representation of the model object '<em><b>View</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.View#getName <em>Name</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.View#getSharedSettingInstances <em>Shared Setting Instances</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.View#getSharedFeatures <em>Shared Features</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getView()
 * @model
 * @generated
 */
public interface View extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getView_Name()
	 * @model default=""
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.nokia.tools.s60ct.model.confml.View#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Shared Setting Instances</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.s60ct.model.confml.ESetting}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shared Setting Instances</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shared Setting Instances</em>' containment reference list.
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getView_SharedSettingInstances()
	 * @model containment="true"
	 * @generated
	 */
	EList<ESetting> getSharedSettingInstances();

	/**
	 * Returns the value of the '<em><b>Shared Features</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.s60ct.model.confml.EFeature}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shared Features</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shared Features</em>' containment reference list.
	 * @see com.nokia.tools.s60ct.model.confml.ConfmlPackage#getView_SharedFeatures()
	 * @model containment="true"
	 * @generated
	 */
	EList<EFeature> getSharedFeatures();

} // View
