/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.nokia.tools.carbide.ct.ui.overview;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sequence Setting</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.carbide.ct.ui.overview.SequenceSetting#getSubSettings <em>Sub Settings</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.ui.overview.SequenceSetting#getValues <em>Values</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.carbide.ct.ui.overview.OverviewPackage#getSequenceSetting()
 * @model
 * @generated
 */
public interface SequenceSetting extends Setting {
	/**
	 * Returns the value of the '<em><b>Sub Settings</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.carbide.ct.ui.overview.Setting}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Settings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Settings</em>' containment reference list.
	 * @see com.nokia.tools.carbide.ct.ui.overview.OverviewPackage#getSequenceSetting_SubSettings()
	 * @model containment="true"
	 * @generated
	 */
	EList<Setting> getSubSettings();

	/**
	 * Returns the value of the '<em><b>Values</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.carbide.ct.ui.overview.SequenceValueItem}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Values</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Values</em>' containment reference list.
	 * @see com.nokia.tools.carbide.ct.ui.overview.OverviewPackage#getSequenceSetting_Values()
	 * @model containment="true"
	 * @generated
	 */
	EList<SequenceValueItem> getValues();

} // SequenceSetting
