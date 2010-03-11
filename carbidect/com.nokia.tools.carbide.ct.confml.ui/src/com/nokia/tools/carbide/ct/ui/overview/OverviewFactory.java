/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.nokia.tools.carbide.ct.ui.overview;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.nokia.tools.carbide.ct.ui.overview.OverviewPackage
 * @generated
 */
public interface OverviewFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OverviewFactory eINSTANCE = com.nokia.tools.carbide.ct.ui.overview.impl.OverviewFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Configuration</em>'.
	 * @generated
	 */
	Configuration createConfiguration();

	/**
	 * Returns a new object of class '<em>Feature</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Feature</em>'.
	 * @generated
	 */
	Feature createFeature();

	/**
	 * Returns a new object of class '<em>Simple Setting</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simple Setting</em>'.
	 * @generated
	 */
	SimpleSetting createSimpleSetting();

	/**
	 * Returns a new object of class '<em>Sequence Setting</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sequence Setting</em>'.
	 * @generated
	 */
	SequenceSetting createSequenceSetting();

	/**
	 * Returns a new object of class '<em>Sequence Value Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sequence Value Item</em>'.
	 * @generated
	 */
	SequenceValueItem createSequenceValueItem();

	/**
	 * Returns a new object of class '<em>Simple Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simple Value</em>'.
	 * @generated
	 */
	SimpleValue createSimpleValue();

	/**
	 * Returns a new object of class '<em>Line Number Container</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Line Number Container</em>'.
	 * @generated
	 */
	LineNumberContainer createLineNumberContainer();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	OverviewPackage getOverviewPackage();

} //OverviewFactory
