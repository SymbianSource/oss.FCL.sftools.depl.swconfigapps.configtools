/*
 * Copyright (c) 2009 Nokia Corporation and/or its subsidiary(-ies). 
 * All rights reserved.
 * This component and the accompanying materials are made available
 * under the terms of "Eclipse Public License v1.0"
 * which accompanies this distribution, and is available
 * at the URL "http://www.eclipse.org/legal/epl-v10.html".
 * 
 * Initial Contributors:
 * Nokia Corporation - Initial contribution
 * 
 * Contributors:
 * 
 * Description: This file is part of com.nokia.tools.variant.content.confml.model component.
 */

package com.nokia.tools.variant.content.confml.impl;


import com.nokia.tools.variant.content.confml.*;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.nokia.tools.variant.content.confml.ConfmlFactory;
import com.nokia.tools.variant.content.confml.ConfmlPackage;
import com.nokia.tools.variant.content.confml.Feature;
import com.nokia.tools.variant.content.confml.FilePath;
import com.nokia.tools.variant.content.confml.FileSystemEntrySetting;
import com.nokia.tools.variant.content.confml.Group;
import com.nokia.tools.variant.content.confml.Icon;
import com.nokia.tools.variant.content.confml.LeafGroup;
import com.nokia.tools.variant.content.confml.MaxExclusive;
import com.nokia.tools.variant.content.confml.MaxInclusive;
import com.nokia.tools.variant.content.confml.MinExclusive;
import com.nokia.tools.variant.content.confml.MinInclusive;
import com.nokia.tools.variant.content.confml.Option;
import com.nokia.tools.variant.content.confml.OptionMapEntry;
import com.nokia.tools.variant.content.confml.ParentGroup;
import com.nokia.tools.variant.content.confml.Property;
import com.nokia.tools.variant.content.confml.SequenceItem;
import com.nokia.tools.variant.content.confml.SequenceSetting;
import com.nokia.tools.variant.content.confml.Setting;
import com.nokia.tools.variant.content.confml.SimpleSetting;
import com.nokia.tools.variant.content.confml.TYPE;
import com.nokia.tools.variant.content.confml.View;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ConfmlFactoryImpl extends EFactoryImpl implements ConfmlFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ConfmlFactory init() {
		try {
			ConfmlFactory theConfmlFactory = (ConfmlFactory)EPackage.Registry.INSTANCE.getEFactory("http///confml.ecore"); 
			if (theConfmlFactory != null) {
				return theConfmlFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ConfmlFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfmlFactoryImpl() {
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
			case ConfmlPackage.PARENT_GROUP: return createParentGroup();
			case ConfmlPackage.LEAF_GROUP: return createLeafGroup();
			case ConfmlPackage.SIMPLE_SETTING: return createSimpleSetting();
			case ConfmlPackage.ICON: return createIcon();
			case ConfmlPackage.VIEW: return createView();
			case ConfmlPackage.SEQUENCE_SETTING: return createSequenceSetting();
			case ConfmlPackage.SETTING: return createSetting();
			case ConfmlPackage.SEQUENCE_ITEM: return createSequenceItem();
			case ConfmlPackage.OPTION: return createOption();
			case ConfmlPackage.GROUP: return createGroup();
			case ConfmlPackage.PROPERTY: return createProperty();
			case ConfmlPackage.FILE_SYSTEM_ENTRY_SETTING: return createFileSystemEntrySetting();
			case ConfmlPackage.FEATURE: return createFeature();
			case ConfmlPackage.MIN_INCLUSIVE: return createMinInclusive();
			case ConfmlPackage.MAX_INCLUSIVE: return createMaxInclusive();
			case ConfmlPackage.MAX_EXCLUSIVE: return createMaxExclusive();
			case ConfmlPackage.MIN_EXCLUSIVE: return createMinExclusive();
			case ConfmlPackage.FILE_PATH: return createFilePath();
			case ConfmlPackage.OPTION_MAP_ENTRY: return createOptionMapEntry();
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
			case ConfmlPackage.TYPE:
				return createTYPEFromString(eDataType, initialValue);
			case ConfmlPackage.URI:
				return createURIFromString(eDataType, initialValue);
			case ConfmlPackage.OBJECT:
				return createObjectFromString(eDataType, initialValue);
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
			case ConfmlPackage.TYPE:
				return convertTYPEToString(eDataType, instanceValue);
			case ConfmlPackage.URI:
				return convertURIToString(eDataType, instanceValue);
			case ConfmlPackage.OBJECT:
				return convertObjectToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
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
	public LeafGroup createLeafGroup() {
		LeafGroupImpl leafGroup = new LeafGroupImpl();
		return leafGroup;
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
	public Icon createIcon() {
		IconImpl icon = new IconImpl();
		return icon;
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
	public SequenceSetting createSequenceSetting() {
		SequenceSettingImpl sequenceSetting = new SequenceSettingImpl();
		return sequenceSetting;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Setting createSetting() {
		SettingImpl setting = new SettingImpl();
		return setting;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SequenceItem createSequenceItem() {
		SequenceItemImpl sequenceItem = new SequenceItemImpl();
		return sequenceItem;
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
	public Group createGroup() {
		GroupImpl group = new GroupImpl();
		return group;
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
	public FileSystemEntrySetting createFileSystemEntrySetting() {
		FileSystemEntrySettingImpl fileSystemEntrySetting = new FileSystemEntrySettingImpl();
		return fileSystemEntrySetting;
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
	public MinInclusive createMinInclusive() {
		MinInclusiveImpl minInclusive = new MinInclusiveImpl();
		return minInclusive;
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
	public MaxExclusive createMaxExclusive() {
		MaxExclusiveImpl maxExclusive = new MaxExclusiveImpl();
		return maxExclusive;
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
	public FilePath createFilePath() {
		FilePathImpl filePath = new FilePathImpl();
		return filePath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OptionMapEntry createOptionMapEntry() {
		OptionMapEntryImpl optionMapEntry = new OptionMapEntryImpl();
		return optionMapEntry;
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
	public URI createURIFromString(EDataType eDataType, String initialValue) {
		return (URI)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertURIToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object createObjectFromString(EDataType eDataType, String initialValue) {
		return super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertObjectToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfmlPackage getConfmlPackage() {
		return (ConfmlPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ConfmlPackage getPackage() {
		return ConfmlPackage.eINSTANCE;
	}

} //ConfmlFactoryImpl
