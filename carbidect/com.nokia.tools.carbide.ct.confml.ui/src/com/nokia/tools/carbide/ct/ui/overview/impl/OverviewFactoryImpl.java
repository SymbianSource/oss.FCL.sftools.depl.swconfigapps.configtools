/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.nokia.tools.carbide.ct.ui.overview.impl;

import com.nokia.tools.carbide.ct.ui.overview.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OverviewFactoryImpl extends EFactoryImpl implements OverviewFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static OverviewFactory init() {
		try {
			OverviewFactory theOverviewFactory = (OverviewFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.s60.com/overview"); 
			if (theOverviewFactory != null) {
				return theOverviewFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new OverviewFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OverviewFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case OverviewPackage.CONFIGURATION: return createConfiguration();
			case OverviewPackage.FEATURE: return createFeature();
			case OverviewPackage.SIMPLE_SETTING: return createSimpleSetting();
			case OverviewPackage.SEQUENCE_SETTING: return createSequenceSetting();
			case OverviewPackage.SEQUENCE_VALUE_ITEM: return createSequenceValueItem();
			case OverviewPackage.SIMPLE_VALUE: return createSimpleValue();
			case OverviewPackage.LINE_NUMBER_CONTAINER: return createLineNumberContainer();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Configuration createConfiguration() {
		ConfigurationImpl configuration = new ConfigurationImpl();
		return configuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Feature createFeature() {
		FeatureImpl feature = new FeatureImpl();
		return feature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleSetting createSimpleSetting() {
		SimpleSettingImpl simpleSetting = new SimpleSettingImpl();
		return simpleSetting;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SequenceSetting createSequenceSetting() {
		SequenceSettingImpl sequenceSetting = new SequenceSettingImpl();
		return sequenceSetting;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SequenceValueItem createSequenceValueItem() {
		SequenceValueItemImpl sequenceValueItem = new SequenceValueItemImpl();
		return sequenceValueItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleValue createSimpleValue() {
		SimpleValueImpl simpleValue = new SimpleValueImpl();
		return simpleValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LineNumberContainer createLineNumberContainer() {
		LineNumberContainerImpl lineNumberContainer = new LineNumberContainerImpl();
		return lineNumberContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OverviewPackage getOverviewPackage() {
		return (OverviewPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static OverviewPackage getPackage() {
		return OverviewPackage.eINSTANCE;
	}

} //OverviewFactoryImpl
