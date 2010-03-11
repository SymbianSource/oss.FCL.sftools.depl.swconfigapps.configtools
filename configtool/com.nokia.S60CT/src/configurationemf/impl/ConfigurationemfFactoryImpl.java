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
package configurationemf.impl;

import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import configurationemf.ConfigurationemfFactory;
import configurationemf.ConfigurationemfPackage;
import configurationemf.Customer;
import configurationemf.Data;
import configurationemf.Date;
import configurationemf.EXTENSION_POLICY;
import configurationemf.Editor;
import configurationemf.Feature;
import configurationemf.Frame;
import configurationemf.GSetting;
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
import configurationemf.Release;
import configurationemf.Rfs;
import configurationemf.RootConf;
import configurationemf.Status;
import configurationemf.SubConf;
import configurationemf.TYPE;
import configurationemf.TotalDigits;
import configurationemf.Version;
import configurationemf.View;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ConfigurationemfFactoryImpl extends EFactoryImpl implements ConfigurationemfFactory {
	
	
	
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ConfigurationemfFactory init() {
		try {
			ConfigurationemfFactory theConfigurationemfFactory = (ConfigurationemfFactory)EPackage.Registry.INSTANCE.getEFactory("http:///configurationemf.ecore"); 
			if (theConfigurationemfFactory != null) {
				return theConfigurationemfFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ConfigurationemfFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigurationemfFactoryImpl() {
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
			case ConfigurationemfPackage.FEATURE: return createFeature();
			case ConfigurationemfPackage.VIEW: return createView();
			case ConfigurationemfPackage.OPTION: return createOption();
			case ConfigurationemfPackage.META: return createMeta();
			case ConfigurationemfPackage.RELEASE: return createRelease();
			case ConfigurationemfPackage.IDENTIFICATION: return createIdentification();
			case ConfigurationemfPackage.DATE: return createDate();
			case ConfigurationemfPackage.OWNER: return createOwner();
			case ConfigurationemfPackage.EDITOR: return createEditor();
			case ConfigurationemfPackage.STATUS: return createStatus();
			case ConfigurationemfPackage.VERSION: return createVersion();
			case ConfigurationemfPackage.PLATFORM: return createPlatform();
			case ConfigurationemfPackage.PRODUCT: return createProduct();
			case ConfigurationemfPackage.CUSTOMER: return createCustomer();
			case ConfigurationemfPackage.GSETTING: return createGSetting();
			case ConfigurationemfPackage.PROPERTY: return createProperty();
			case ConfigurationemfPackage.PATTERN: return createPattern();
			case ConfigurationemfPackage.LENGTH: return createLength();
			case ConfigurationemfPackage.MAX_LENGTH: return createMaxLength();
			case ConfigurationemfPackage.MIN_LENGTH: return createMinLength();
			case ConfigurationemfPackage.MAX_EXCLUSIVE: return createMaxExclusive();
			case ConfigurationemfPackage.MAX_INCLUSIVE: return createMaxInclusive();
			case ConfigurationemfPackage.MIN_INCLUSIVE: return createMinInclusive();
			case ConfigurationemfPackage.MIN_EXCLUSIVE: return createMinExclusive();
			case ConfigurationemfPackage.TOTAL_DIGITS: return createTotalDigits();
			case ConfigurationemfPackage.LEAF_SETTING: return createLeafSetting();
			case ConfigurationemfPackage.PARENT_SETTING: return createParentSetting();
			case ConfigurationemfPackage.LEAF_GROUP: return createLeafGroup();
			case ConfigurationemfPackage.PARENT_GROUP: return createParentGroup();
			case ConfigurationemfPackage.ICON: return createIcon();
			case ConfigurationemfPackage.LINK: return createLink();
			case ConfigurationemfPackage.ROOT_CONF: return createRootConf();
			case ConfigurationemfPackage.SUB_CONF: return createSubConf();
			case ConfigurationemfPackage.DATA: return createData();
			case ConfigurationemfPackage.RFS: return createRfs();
			case ConfigurationemfPackage.REF: return createRef();
			case ConfigurationemfPackage.FRAME: return createFrame();
			case ConfigurationemfPackage.LEAF_SETTING_DELEGATOR: return createLeafSettingDelegator();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case ConfigurationemfPackage.TYPE:
				return createTYPEFromString(eDataType, initialValue);
			case ConfigurationemfPackage.EXTENSION_POLICY:
				return createEXTENSION_POLICYFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case ConfigurationemfPackage.TYPE:
				return convertTYPEToString(eDataType, instanceValue);
			case ConfigurationemfPackage.EXTENSION_POLICY:
				return convertEXTENSION_POLICYToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
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
	public View createView() {
		ViewImpl view = new ViewImpl();
		return view;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Option createOption() {
		OptionImpl option = new OptionImpl();
		return option;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Meta createMeta() {
		MetaImpl meta = new MetaImpl();
		return meta;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Identification createIdentification() {
		IdentificationImpl identification = new IdentificationImpl();
		return identification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date createDate() {
		DateImpl date = new DateImpl();
		return date;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Owner createOwner() {
		OwnerImpl owner = new OwnerImpl();
		return owner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Editor createEditor() {
		EditorImpl editor = new EditorImpl();
		return editor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Status createStatus() {
		StatusImpl status = new StatusImpl();
		return status;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Version createVersion() {
		VersionImpl version = new VersionImpl();
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Platform createPlatform() {
		PlatformImpl platform = new PlatformImpl();
		return platform;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Product createProduct() {
		ProductImpl product = new ProductImpl();
		return product;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Release createRelease() {
		ReleaseImpl release = new ReleaseImpl();
		return release;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TYPE createTYPEFromString(EDataType eDataType, String initialValue) {
		TYPE result = TYPE.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTYPEToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EXTENSION_POLICY createEXTENSION_POLICYFromString(EDataType eDataType, String initialValue) {
		EXTENSION_POLICY result = EXTENSION_POLICY.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEXTENSION_POLICYToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Customer createCustomer() {
		CustomerImpl customer = new CustomerImpl();
		return customer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public GSetting createGSetting() {
		GSettingImpl gSetting = new GSettingImpl();
		return gSetting;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property createProperty() {
		PropertyImpl property = new PropertyImpl();
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pattern createPattern() {
		PatternImpl pattern = new PatternImpl();
		return pattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Length createLength() {
		LengthImpl length = new LengthImpl();
		return length;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MaxLength createMaxLength() {
		MaxLengthImpl maxLength = new MaxLengthImpl();
		return maxLength;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MinLength createMinLength() {
		MinLengthImpl minLength = new MinLengthImpl();
		return minLength;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MaxExclusive createMaxExclusive() {
		MaxExclusiveImpl maxExclusive = new MaxExclusiveImpl();
		return maxExclusive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MaxInclusive createMaxInclusive() {
		MaxInclusiveImpl maxInclusive = new MaxInclusiveImpl();
		return maxInclusive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MinInclusive createMinInclusive() {
		MinInclusiveImpl minInclusive = new MinInclusiveImpl();
		return minInclusive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MinExclusive createMinExclusive() {
		MinExclusiveImpl minExclusive = new MinExclusiveImpl();
		return minExclusive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TotalDigits createTotalDigits() {
		TotalDigitsImpl totalDigits = new TotalDigitsImpl();
		return totalDigits;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public LeafSetting createLeafSetting() {
		LeafSettingImpl leafSetting = new LeafSettingImpl();
		return leafSetting;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ParentSetting createParentSetting() {
		ParentSettingImpl parentSetting = new ParentSettingImpl();
		return parentSetting;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public LeafGroup createLeafGroup() {
		LeafGroupImpl leafGroup = new LeafGroupImpl();
		return leafGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ParentGroup createParentGroup() {
		ParentGroupImpl parentGroup = new ParentGroupImpl();
		return parentGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Icon createIcon() {
		IconImpl icon = new IconImpl();
		return icon;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Link createLink() {
		LinkImpl link = new LinkImpl();
		return link;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RootConf createRootConf() {
		RootConfImpl rootConf = new RootConfImpl();
		return rootConf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubConf createSubConf() {
		SubConfImpl subConf = new SubConfImpl();
		return subConf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Data createData() {
		DataImpl data = new DataImpl();
		return data;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Rfs createRfs() {
		RfsImpl rfs = new RfsImpl();
		return rfs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Ref createRef() {
		RefImpl ref = new RefImpl();
//		ref.eAdapters().add(RefStoreManager.INSTANCE);
		return ref;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Frame createFrame() {
		FrameImpl frame = new FrameImpl();
		return frame;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LeafSettingDelegator createLeafSettingDelegator() {
		LeafSettingDelegatorImpl leafSettingDelegator = new LeafSettingDelegatorImpl();
		return leafSettingDelegator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigurationemfPackage getConfigurationemfPackage() {
		return (ConfigurationemfPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ConfigurationemfPackage getPackage() {
		return ConfigurationemfPackage.eINSTANCE;
	}

	public void addRelease(String release){
		releasesSet.add(release);
	}
	public Set getReleases(){
		return releasesSet;
	}
} //ConfigurationemfFactoryImpl
