/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.nokia.tools.carbide.ct.ui.overview;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sequence Value Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.carbide.ct.ui.overview.SequenceValueItem#getSubValues <em>Sub Values</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.carbide.ct.ui.overview.OverviewPackage#getSequenceValueItem()
 * @model
 * @generated
 */
public interface SequenceValueItem extends EObject {
	/**
	 * Returns the value of the '<em><b>Sub Values</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.carbide.ct.ui.overview.SimpleValue}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Values</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Values</em>' containment reference list.
	 * @see com.nokia.tools.carbide.ct.ui.overview.OverviewPackage#getSequenceValueItem_SubValues()
	 * @model containment="true"
	 * @generated
	 */
	EList<SimpleValue> getSubValues();

} // SequenceValueItem
