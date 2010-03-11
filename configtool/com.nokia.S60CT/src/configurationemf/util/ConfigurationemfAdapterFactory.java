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
package configurationemf.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import configurationemf.AttributeAndDesc;
import configurationemf.CommonAttr;
import configurationemf.Configuration;
import configurationemf.ConfigurationemfPackage;
import configurationemf.Content;
import configurationemf.Customer;
import configurationemf.DIL;
import configurationemf.Data;
import configurationemf.Date;
import configurationemf.Editor;
import configurationemf.Feature;
import configurationemf.Frame;
import configurationemf.GSetting;
import configurationemf.Group;
import configurationemf.Icon;
import configurationemf.Identification;
import configurationemf.LeafGroup;
import configurationemf.LeafSetting;
import configurationemf.LeafSettingDelegator;
import configurationemf.Length;
import configurationemf.Link;
import configurationemf.MaxExclusive;
import configurationemf.MaxInclusive;
import configurationemf.MaxLength;
import configurationemf.Meta;
import configurationemf.MinExclusive;
import configurationemf.MinInclusive;
import configurationemf.MinLength;
import configurationemf.Option;
import configurationemf.Owner;
import configurationemf.ParentGroup;
import configurationemf.ParentSetting;
import configurationemf.Pattern;
import configurationemf.Platform;
import configurationemf.Product;
import configurationemf.Property;
import configurationemf.Ref;
import configurationemf.Referable;
import configurationemf.Release;
import configurationemf.Rfs;
import configurationemf.RootConf;
import configurationemf.Setting;
import configurationemf.Status;
import configurationemf.SubConf;
import configurationemf.TotalDigits;
import configurationemf.Version;
import configurationemf.View;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see configurationemf.ConfigurationemfPackage
 * @generated
 */
public class ConfigurationemfAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ConfigurationemfPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigurationemfAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ConfigurationemfPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch the delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConfigurationemfSwitch<Adapter> modelSwitch =
		new ConfigurationemfSwitch<Adapter>() {
			@Override
			public Adapter caseConfiguration(Configuration object) {
				return createConfigurationAdapter();
			}
			@Override
			public Adapter caseFeature(Feature object) {
				return createFeatureAdapter();
			}
			@Override
			public Adapter caseSetting(Setting object) {
				return createSettingAdapter();
			}
			@Override
			public Adapter caseAttributeAndDesc(AttributeAndDesc object) {
				return createAttributeAndDescAdapter();
			}
			@Override
			public Adapter caseView(View object) {
				return createViewAdapter();
			}
			@Override
			public Adapter caseGroup(Group object) {
				return createGroupAdapter();
			}
			@Override
			public Adapter caseCommonAttr(CommonAttr object) {
				return createCommonAttrAdapter();
			}
			@Override
			public Adapter caseOption(Option object) {
				return createOptionAdapter();
			}
			@Override
			public Adapter caseMeta(Meta object) {
				return createMetaAdapter();
			}
			@Override
			public Adapter caseRelease(Release object) {
				return createReleaseAdapter();
			}
			@Override
			public Adapter caseIdentification(Identification object) {
				return createIdentificationAdapter();
			}
			@Override
			public Adapter caseDate(Date object) {
				return createDateAdapter();
			}
			@Override
			public Adapter caseOwner(Owner object) {
				return createOwnerAdapter();
			}
			@Override
			public Adapter caseEditor(Editor object) {
				return createEditorAdapter();
			}
			@Override
			public Adapter caseStatus(Status object) {
				return createStatusAdapter();
			}
			@Override
			public Adapter caseVersion(Version object) {
				return createVersionAdapter();
			}
			@Override
			public Adapter casePlatform(Platform object) {
				return createPlatformAdapter();
			}
			@Override
			public Adapter caseProduct(Product object) {
				return createProductAdapter();
			}
			@Override
			public Adapter caseCustomer(Customer object) {
				return createCustomerAdapter();
			}
			@Override
			public Adapter caseGSetting(GSetting object) {
				return createGSettingAdapter();
			}
			@Override
			public Adapter caseProperty(Property object) {
				return createPropertyAdapter();
			}
			@Override
			public Adapter casePattern(Pattern object) {
				return createPatternAdapter();
			}
			@Override
			public Adapter caseLength(Length object) {
				return createLengthAdapter();
			}
			@Override
			public Adapter caseMaxLength(MaxLength object) {
				return createMaxLengthAdapter();
			}
			@Override
			public Adapter caseMinLength(MinLength object) {
				return createMinLengthAdapter();
			}
			@Override
			public Adapter caseMaxExclusive(MaxExclusive object) {
				return createMaxExclusiveAdapter();
			}
			@Override
			public Adapter caseMaxInclusive(MaxInclusive object) {
				return createMaxInclusiveAdapter();
			}
			@Override
			public Adapter caseMinInclusive(MinInclusive object) {
				return createMinInclusiveAdapter();
			}
			@Override
			public Adapter caseMinExclusive(MinExclusive object) {
				return createMinExclusiveAdapter();
			}
			@Override
			public Adapter caseTotalDigits(TotalDigits object) {
				return createTotalDigitsAdapter();
			}
			@Override
			public Adapter caseLeafSetting(LeafSetting object) {
				return createLeafSettingAdapter();
			}
			@Override
			public Adapter caseParentSetting(ParentSetting object) {
				return createParentSettingAdapter();
			}
			@Override
			public Adapter caseLeafGroup(LeafGroup object) {
				return createLeafGroupAdapter();
			}
			@Override
			public Adapter caseParentGroup(ParentGroup object) {
				return createParentGroupAdapter();
			}
			@Override
			public Adapter caseContent(Content object) {
				return createContentAdapter();
			}
			@Override
			public Adapter caseIcon(Icon object) {
				return createIconAdapter();
			}
			@Override
			public Adapter caseLink(Link object) {
				return createLinkAdapter();
			}
			@Override
			public Adapter caseDIL(DIL object) {
				return createDILAdapter();
			}
			@Override
			public Adapter caseRootConf(RootConf object) {
				return createRootConfAdapter();
			}
			@Override
			public Adapter caseSubConf(SubConf object) {
				return createSubConfAdapter();
			}
			@Override
			public Adapter caseData(Data object) {
				return createDataAdapter();
			}
			@Override
			public Adapter caseRfs(Rfs object) {
				return createRfsAdapter();
			}
			@Override
			public Adapter caseRef(Ref object) {
				return createRefAdapter();
			}
			@Override
			public Adapter caseReferable(Referable object) {
				return createReferableAdapter();
			}
			@Override
			public Adapter caseFrame(Frame object) {
				return createFrameAdapter();
			}
			@Override
			public Adapter caseLeafSettingDelegator(LeafSettingDelegator object) {
				return createLeafSettingDelegatorAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link configurationemf.Configuration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see configurationemf.Configuration
	 * @generated
	 */
	public Adapter createConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link configurationemf.Feature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see configurationemf.Feature
	 * @generated
	 */
	public Adapter createFeatureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link configurationemf.Setting <em>Setting</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see configurationemf.Setting
	 * @generated
	 */
	public Adapter createSettingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link configurationemf.AttributeAndDesc <em>Attribute And Desc</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see configurationemf.AttributeAndDesc
	 * @generated
	 */
	public Adapter createAttributeAndDescAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link configurationemf.View <em>View</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see configurationemf.View
	 * @generated
	 */
	public Adapter createViewAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link configurationemf.Group <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see configurationemf.Group
	 * @generated
	 */
	public Adapter createGroupAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link configurationemf.CommonAttr <em>Common Attr</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see configurationemf.CommonAttr
	 * @generated
	 */
	public Adapter createCommonAttrAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link configurationemf.Option <em>Option</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see configurationemf.Option
	 * @generated
	 */
	public Adapter createOptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link configurationemf.Meta <em>Meta</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see configurationemf.Meta
	 * @generated
	 */
	public Adapter createMetaAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link configurationemf.Identification <em>Identification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see configurationemf.Identification
	 * @generated
	 */
	public Adapter createIdentificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link configurationemf.Date <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see configurationemf.Date
	 * @generated
	 */
	public Adapter createDateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link configurationemf.Owner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see configurationemf.Owner
	 * @generated
	 */
	public Adapter createOwnerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link configurationemf.Editor <em>Editor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see configurationemf.Editor
	 * @generated
	 */
	public Adapter createEditorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link configurationemf.Status <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see configurationemf.Status
	 * @generated
	 */
	public Adapter createStatusAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link configurationemf.Version <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see configurationemf.Version
	 * @generated
	 */
	public Adapter createVersionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link configurationemf.Platform <em>Platform</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see configurationemf.Platform
	 * @generated
	 */
	public Adapter createPlatformAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link configurationemf.Product <em>Product</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see configurationemf.Product
	 * @generated
	 */
	public Adapter createProductAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link configurationemf.Release <em>Release</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see configurationemf.Release
	 * @generated
	 */
	public Adapter createReleaseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link configurationemf.Referable <em>Referable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see configurationemf.Referable
	 * @generated
	 */
	public Adapter createReferableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link configurationemf.Frame <em>Frame</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see configurationemf.Frame
	 * @generated
	 */
	public Adapter createFrameAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link configurationemf.LeafSettingDelegator <em>Leaf Setting Delegator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see configurationemf.LeafSettingDelegator
	 * @generated
	 */
	public Adapter createLeafSettingDelegatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link configurationemf.Customer <em>Customer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see configurationemf.Customer
	 * @generated
	 */
	public Adapter createCustomerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link configurationemf.GSetting <em>GSetting</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see configurationemf.GSetting
	 * @generated
	 */
	public Adapter createGSettingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link configurationemf.Property <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see configurationemf.Property
	 * @generated
	 */
	public Adapter createPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link configurationemf.Pattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see configurationemf.Pattern
	 * @generated
	 */
	public Adapter createPatternAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link configurationemf.Length <em>Length</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see configurationemf.Length
	 * @generated
	 */
	public Adapter createLengthAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link configurationemf.MaxLength <em>Max Length</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see configurationemf.MaxLength
	 * @generated
	 */
	public Adapter createMaxLengthAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link configurationemf.MinLength <em>Min Length</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see configurationemf.MinLength
	 * @generated
	 */
	public Adapter createMinLengthAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link configurationemf.MaxExclusive <em>Max Exclusive</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see configurationemf.MaxExclusive
	 * @generated
	 */
	public Adapter createMaxExclusiveAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link configurationemf.MaxInclusive <em>Max Inclusive</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see configurationemf.MaxInclusive
	 * @generated
	 */
	public Adapter createMaxInclusiveAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link configurationemf.MinInclusive <em>Min Inclusive</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see configurationemf.MinInclusive
	 * @generated
	 */
	public Adapter createMinInclusiveAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link configurationemf.MinExclusive <em>Min Exclusive</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see configurationemf.MinExclusive
	 * @generated
	 */
	public Adapter createMinExclusiveAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link configurationemf.TotalDigits <em>Total Digits</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see configurationemf.TotalDigits
	 * @generated
	 */
	public Adapter createTotalDigitsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link configurationemf.LeafSetting <em>Leaf Setting</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see configurationemf.LeafSetting
	 * @generated
	 */
	public Adapter createLeafSettingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link configurationemf.ParentSetting <em>Parent Setting</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see configurationemf.ParentSetting
	 * @generated
	 */
	public Adapter createParentSettingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link configurationemf.LeafGroup <em>Leaf Group</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see configurationemf.LeafGroup
	 * @generated
	 */
	public Adapter createLeafGroupAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link configurationemf.ParentGroup <em>Parent Group</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see configurationemf.ParentGroup
	 * @generated
	 */
	public Adapter createParentGroupAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link configurationemf.Content <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see configurationemf.Content
	 * @generated
	 */
	public Adapter createContentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link configurationemf.Icon <em>Icon</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see configurationemf.Icon
	 * @generated
	 */
	public Adapter createIconAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link configurationemf.Link <em>Link</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see configurationemf.Link
	 * @generated
	 */
	public Adapter createLinkAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link configurationemf.DIL <em>DIL</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see configurationemf.DIL
	 * @generated
	 */
	public Adapter createDILAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link configurationemf.RootConf <em>Root Conf</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see configurationemf.RootConf
	 * @generated
	 */
	public Adapter createRootConfAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link configurationemf.SubConf <em>Sub Conf</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see configurationemf.SubConf
	 * @generated
	 */
	public Adapter createSubConfAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link configurationemf.Data <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see configurationemf.Data
	 * @generated
	 */
	public Adapter createDataAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link configurationemf.Rfs <em>Rfs</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see configurationemf.Rfs
	 * @generated
	 */
	public Adapter createRfsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link configurationemf.Ref <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see configurationemf.Ref
	 * @generated
	 */
	public Adapter createRefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ConfigurationemfAdapterFactory
