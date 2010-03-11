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
 * Description: This file is part of com.nokia.tools.vct.confml.edit component.
 */

package com.nokia.tools.vct.confml.model.confml1.edit.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemColorProvider;
import org.eclipse.emf.edit.provider.IItemFontProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import com.nokia.tools.vct.confml.model.confml1.EConfML1Factory;
import com.nokia.tools.vct.confml.model.confml1.EConfML1Package;
import com.nokia.tools.vct.confml.model.confml1.ESettingElement;
import com.nokia.tools.vct.confml.model.xsd.EXSDFacetFactory;

/**
 * This is the item provider adapter for a {@link com.nokia.tools.vct.confml.model.confml1.ESettingElement} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ESettingElementItemProvider extends ECommonAttrsItemProvider
		implements IEditingDomainItemProvider, IStructuredItemContentProvider,
		ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource,
		IItemColorProvider, IItemFontProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ESettingElementItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addLinksPropertyDescriptor(object);
			addRefPropertyDescriptor(object);
			addReadOnlyPropertyDescriptor(object);
			addRelevantPropertyDescriptor(object);
			addRequiredPropertyDescriptor(object);
			addMapKeyPropertyDescriptor(object);
			addMapValuePropertyDescriptor(object);
			addNamePropertyDescriptor(object);
			addConstraintPropertyDescriptor(object);
			addTypePropertyDescriptor(object);
			addMinOccursPropertyDescriptor(object);
			addMaxOccursPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Links feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLinksPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_ELinkContainer_links_feature"), getString(
						"_UI_PropertyDescriptor_description",
						"_UI_ELinkContainer_links_feature",
						"_UI_ELinkContainer_type"),
				EConfML1Package.Literals.ELINK_CONTAINER__LINKS, true, false,
				true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Ref feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRefPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_ESettingElement_ref_feature"), getString(
						"_UI_PropertyDescriptor_description",
						"_UI_ESettingElement_ref_feature",
						"_UI_ESettingElement_type"),
				EConfML1Package.Literals.ESETTING_ELEMENT__REF, true, false,
				false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Read Only feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addReadOnlyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_ESettingElement_readOnly_feature"), getString(
						"_UI_PropertyDescriptor_description",
						"_UI_ESettingElement_readOnly_feature",
						"_UI_ESettingElement_type"),
				EConfML1Package.Literals.ESETTING_ELEMENT__READ_ONLY, true,
				false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null,
				null));
	}

	/**
	 * This adds a property descriptor for the Relevant feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRelevantPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_ESettingElement_relevant_feature"), getString(
						"_UI_PropertyDescriptor_description",
						"_UI_ESettingElement_relevant_feature",
						"_UI_ESettingElement_type"),
				EConfML1Package.Literals.ESETTING_ELEMENT__RELEVANT, true,
				false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null,
				null));
	}

	/**
	 * This adds a property descriptor for the Required feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRequiredPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_ESettingElement_required_feature"), getString(
						"_UI_PropertyDescriptor_description",
						"_UI_ESettingElement_required_feature",
						"_UI_ESettingElement_type"),
				EConfML1Package.Literals.ESETTING_ELEMENT__REQUIRED, true,
				false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null,
				null));
	}

	/**
	 * This adds a property descriptor for the Map Key feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMapKeyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_ESettingElement_mapKey_feature"), getString(
						"_UI_PropertyDescriptor_description",
						"_UI_ESettingElement_mapKey_feature",
						"_UI_ESettingElement_type"),
				EConfML1Package.Literals.ESETTING_ELEMENT__MAP_KEY, true,
				false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null,
				null));
	}

	/**
	 * This adds a property descriptor for the Map Value feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMapValuePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_ESettingElement_mapValue_feature"), getString(
						"_UI_PropertyDescriptor_description",
						"_UI_ESettingElement_mapValue_feature",
						"_UI_ESettingElement_type"),
				EConfML1Package.Literals.ESETTING_ELEMENT__MAP_VALUE, true,
				false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null,
				null));
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_ESettingElement_name_feature"), getString(
						"_UI_PropertyDescriptor_description",
						"_UI_ESettingElement_name_feature",
						"_UI_ESettingElement_type"),
				EConfML1Package.Literals.ESETTING_ELEMENT__NAME, true, false,
				false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Constraint feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addConstraintPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_ESettingElement_constraint_feature"), getString(
						"_UI_PropertyDescriptor_description",
						"_UI_ESettingElement_constraint_feature",
						"_UI_ESettingElement_type"),
				EConfML1Package.Literals.ESETTING_ELEMENT__CONSTRAINT, true,
				false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null,
				null));
	}

	/**
	 * This adds a property descriptor for the Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_ESettingElement_type_feature"), getString(
						"_UI_PropertyDescriptor_description",
						"_UI_ESettingElement_type_feature",
						"_UI_ESettingElement_type"),
				EConfML1Package.Literals.ESETTING_ELEMENT__TYPE, true, false,
				false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Min Occurs feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMinOccursPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_ESettingElement_minOccurs_feature"), getString(
						"_UI_PropertyDescriptor_description",
						"_UI_ESettingElement_minOccurs_feature",
						"_UI_ESettingElement_type"),
				EConfML1Package.Literals.ESETTING_ELEMENT__MIN_OCCURS, true,
				false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null,
				null));
	}

	/**
	 * This adds a property descriptor for the Max Occurs feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMaxOccursPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_ESettingElement_maxOccurs_feature"), getString(
						"_UI_PropertyDescriptor_description",
						"_UI_ESettingElement_maxOccurs_feature",
						"_UI_ESettingElement_type"),
				EConfML1Package.Literals.ESETTING_ELEMENT__MAX_OCCURS, true,
				false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null,
				null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(
			Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(EConfML1Package.Literals.ECONTENTS__CONTENTS);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns ESettingElement.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage(
				"full/obj16/ESettingElement"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		String label = ((ESettingElement) object).getRef();
		return label == null || label.length() == 0 ? getString("_UI_ESettingElement_type")
				: label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(ESettingElement.class)) {
		case EConfML1Package.ESETTING_ELEMENT__DESCRIPTIONS:
		case EConfML1Package.ESETTING_ELEMENT__LINKS:
		case EConfML1Package.ESETTING_ELEMENT__SETTINGS:
		case EConfML1Package.ESETTING_ELEMENT__ICONS:
		case EConfML1Package.ESETTING_ELEMENT__REF:
		case EConfML1Package.ESETTING_ELEMENT__READ_ONLY:
		case EConfML1Package.ESETTING_ELEMENT__RELEVANT:
		case EConfML1Package.ESETTING_ELEMENT__REQUIRED:
		case EConfML1Package.ESETTING_ELEMENT__MAP_KEY:
		case EConfML1Package.ESETTING_ELEMENT__MAP_VALUE:
		case EConfML1Package.ESETTING_ELEMENT__NAME:
		case EConfML1Package.ESETTING_ELEMENT__CONSTRAINT:
		case EConfML1Package.ESETTING_ELEMENT__OPTIONS:
		case EConfML1Package.ESETTING_ELEMENT__PROPERTIES:
		case EConfML1Package.ESETTING_ELEMENT__TYPE:
		case EConfML1Package.ESETTING_ELEMENT__MIN_OCCURS:
		case EConfML1Package.ESETTING_ELEMENT__MAX_OCCURS:
		case EConfML1Package.ESETTING_ELEMENT__MIN_EXCLUSIVE:
		case EConfML1Package.ESETTING_ELEMENT__MAX_EXCLUSIVE:
		case EConfML1Package.ESETTING_ELEMENT__MIN_INCLUSIVE:
		case EConfML1Package.ESETTING_ELEMENT__MAX_INCLUSIVE:
		case EConfML1Package.ESETTING_ELEMENT__MIN_LENGTH:
		case EConfML1Package.ESETTING_ELEMENT__MAX_LENGTH:
		case EConfML1Package.ESETTING_ELEMENT__LENGTH:
		case EConfML1Package.ESETTING_ELEMENT__TOTAL_DIGITS:
		case EConfML1Package.ESETTING_ELEMENT__PATTERN:
			fireNotifyChanged(new ViewerNotification(notification, notification
					.getNotifier(), false, true));
			return;
		case EConfML1Package.ESETTING_ELEMENT__CONTENTS:
			fireNotifyChanged(new ViewerNotification(notification, notification
					.getNotifier(), true, false));
			return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(
			Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add(createChildParameter(
				EConfML1Package.Literals.EDESCRIPTION_CONTAINER__DESCRIPTIONS,
				EConfML1Factory.eINSTANCE.createEDescriptionElement()));

		newChildDescriptors.add(createChildParameter(
				EConfML1Package.Literals.ELINK_CONTAINER__LINKS,
				EConfML1Factory.eINSTANCE.createELinkElement()));

		newChildDescriptors.add(createChildParameter(
				EConfML1Package.Literals.ESETTING_TYPE_CONTAINER__SETTINGS,
				EConfML1Factory.eINSTANCE.createESettingElement()));

		newChildDescriptors.add(createChildParameter(
				EConfML1Package.Literals.EICON_CONTAINER__ICONS,
				EConfML1Factory.eINSTANCE.createEIconElement()));

		newChildDescriptors.add(createChildParameter(
				EConfML1Package.Literals.ESETTING_ELEMENT__OPTIONS,
				EConfML1Factory.eINSTANCE.createEOptionElement()));

		newChildDescriptors.add(createChildParameter(
				EConfML1Package.Literals.ESETTING_ELEMENT__PROPERTIES,
				EConfML1Factory.eINSTANCE.createEPropertyElement()));

		newChildDescriptors.add(createChildParameter(
				EConfML1Package.Literals.ESETTING_ELEMENT__MIN_EXCLUSIVE,
				EXSDFacetFactory.eINSTANCE.createEMinExclusive()));

		newChildDescriptors.add(createChildParameter(
				EConfML1Package.Literals.ESETTING_ELEMENT__MAX_EXCLUSIVE,
				EXSDFacetFactory.eINSTANCE.createEMaxExclusive()));

		newChildDescriptors.add(createChildParameter(
				EConfML1Package.Literals.ESETTING_ELEMENT__MIN_INCLUSIVE,
				EXSDFacetFactory.eINSTANCE.createEMinInclusive()));

		newChildDescriptors.add(createChildParameter(
				EConfML1Package.Literals.ESETTING_ELEMENT__MAX_INCLUSIVE,
				EXSDFacetFactory.eINSTANCE.createEMaxInclusive()));

		newChildDescriptors.add(createChildParameter(
				EConfML1Package.Literals.ESETTING_ELEMENT__MIN_LENGTH,
				EXSDFacetFactory.eINSTANCE.createEMinLength()));

		newChildDescriptors.add(createChildParameter(
				EConfML1Package.Literals.ESETTING_ELEMENT__MAX_LENGTH,
				EXSDFacetFactory.eINSTANCE.createEMaxLength()));

		newChildDescriptors.add(createChildParameter(
				EConfML1Package.Literals.ESETTING_ELEMENT__LENGTH,
				EXSDFacetFactory.eINSTANCE.createELength()));

		newChildDescriptors.add(createChildParameter(
				EConfML1Package.Literals.ESETTING_ELEMENT__TOTAL_DIGITS,
				EXSDFacetFactory.eINSTANCE.createETotalDigits()));

		newChildDescriptors.add(createChildParameter(
				EConfML1Package.Literals.ESETTING_ELEMENT__PATTERN,
				EXSDFacetFactory.eINSTANCE.createEPattern()));
	}

}
