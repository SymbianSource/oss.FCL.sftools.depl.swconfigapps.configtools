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
import com.nokia.tools.vct.confml.model.confml1.EConfigurationElement;
import com.nokia.tools.vct.confml.model.confml1.include.EConfMLIncludeFactory;

/**
 * This is the item provider adapter for a {@link com.nokia.tools.vct.confml.model.confml1.EConfigurationElement} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class EConfigurationElementItemProvider extends ECommonAttrsItemProvider
		implements IEditingDomainItemProvider, IStructuredItemContentProvider,
		ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource,
		IItemColorProvider, IItemFontProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EConfigurationElementItemProvider(AdapterFactory adapterFactory) {
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
			addNamePropertyDescriptor(object);
			addVersionPropertyDescriptor(object);
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
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_EConfigurationElement_name_feature"), getString(
						"_UI_PropertyDescriptor_description",
						"_UI_EConfigurationElement_name_feature",
						"_UI_EConfigurationElement_type"),
				EConfML1Package.Literals.ECONFIGURATION_ELEMENT__NAME, true,
				false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null,
				null));
	}

	/**
	 * This adds a property descriptor for the Version feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addVersionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_EConfigurationElement_version_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_EConfigurationElement_version_feature",
						"_UI_EConfigurationElement_type"),
				EConfML1Package.Literals.ECONFIGURATION_ELEMENT__VERSION, true,
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
	 * This returns EConfigurationElement.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage(
				"full/obj16/EConfigurationElement"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		String label = ((EConfigurationElement) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_EConfigurationElement_type")
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

		switch (notification.getFeatureID(EConfigurationElement.class)) {
		case EConfML1Package.ECONFIGURATION_ELEMENT__LINKS:
		case EConfML1Package.ECONFIGURATION_ELEMENT__ICONS:
		case EConfML1Package.ECONFIGURATION_ELEMENT__DESCRIPTIONS:
		case EConfML1Package.ECONFIGURATION_ELEMENT__METAS:
		case EConfML1Package.ECONFIGURATION_ELEMENT__CONFIGURATIONS:
		case EConfML1Package.ECONFIGURATION_ELEMENT__FEATURES:
		case EConfML1Package.ECONFIGURATION_ELEMENT__VIEWS:
		case EConfML1Package.ECONFIGURATION_ELEMENT__DATA:
		case EConfML1Package.ECONFIGURATION_ELEMENT__RFS:
		case EConfML1Package.ECONFIGURATION_ELEMENT__NAME:
		case EConfML1Package.ECONFIGURATION_ELEMENT__VERSION:
		case EConfML1Package.ECONFIGURATION_ELEMENT__INCLUDES:
			fireNotifyChanged(new ViewerNotification(notification, notification
					.getNotifier(), false, true));
			return;
		case EConfML1Package.ECONFIGURATION_ELEMENT__CONTENTS:
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
				EConfML1Package.Literals.ELINK_CONTAINER__LINKS,
				EConfML1Factory.eINSTANCE.createELinkElement()));

		newChildDescriptors.add(createChildParameter(
				EConfML1Package.Literals.EICON_CONTAINER__ICONS,
				EConfML1Factory.eINSTANCE.createEIconElement()));

		newChildDescriptors.add(createChildParameter(
				EConfML1Package.Literals.EDESCRIPTION_CONTAINER__DESCRIPTIONS,
				EConfML1Factory.eINSTANCE.createEDescriptionElement()));

		newChildDescriptors.add(createChildParameter(
				EConfML1Package.Literals.EMETA_CONTAINER__METAS,
				EConfML1Factory.eINSTANCE.createEMetaElement()));

		newChildDescriptors
				.add(createChildParameter(
						EConfML1Package.Literals.ECONFIGURATION_ELEMENT__CONFIGURATIONS,
						EConfML1Factory.eINSTANCE.createEConfigurationElement()));

		newChildDescriptors.add(createChildParameter(
				EConfML1Package.Literals.ECONFIGURATION_ELEMENT__FEATURES,
				EConfML1Factory.eINSTANCE.createEFeatureElement()));

		newChildDescriptors.add(createChildParameter(
				EConfML1Package.Literals.ECONFIGURATION_ELEMENT__VIEWS,
				EConfML1Factory.eINSTANCE.createEViewElement()));

		newChildDescriptors.add(createChildParameter(
				EConfML1Package.Literals.ECONFIGURATION_ELEMENT__DATA,
				EConfML1Factory.eINSTANCE.createEDataElement()));

		newChildDescriptors.add(createChildParameter(
				EConfML1Package.Literals.ECONFIGURATION_ELEMENT__RFS,
				EConfML1Factory.eINSTANCE.createERfsElement()));

		newChildDescriptors.add(createChildParameter(
				EConfML1Package.Literals.ECONFIGURATION_ELEMENT__INCLUDES,
				EConfMLIncludeFactory.eINSTANCE.createEInclude()));
	}

}
