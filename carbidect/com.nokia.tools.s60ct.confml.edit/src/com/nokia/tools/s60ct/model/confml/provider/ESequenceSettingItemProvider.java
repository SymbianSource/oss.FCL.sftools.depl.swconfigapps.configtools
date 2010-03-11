/*
* Copyright (c) 2007 Nokia Corporation and/or its subsidiary(-ies). 
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
package com.nokia.tools.s60ct.model.confml.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import com.nokia.tools.s60ct.model.confml.ConfmlFactory;
import com.nokia.tools.s60ct.model.confml.ConfmlPackage;
import com.nokia.tools.s60ct.model.confml.ESequenceSetting;

/**
 * This is the item provider adapter for a {@link com.nokia.tools.s60ct.model.confml.ESequenceSetting} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ESequenceSettingItemProvider
	extends ESettingItemProvider
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ESequenceSettingItemProvider(AdapterFactory adapterFactory) {
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

			addMinOccursPropertyDescriptor(object);
			addMaxOccursPropertyDescriptor(object);
			addMapKeyPropertyDescriptor(object);
			addMapValuePropertyDescriptor(object);
			addVisibleSubSettingsPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Min Occurs feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMinOccursPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ESequenceSetting_minOccurs_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ESequenceSetting_minOccurs_feature", "_UI_ESequenceSetting_type"),
				 ConfmlPackage.Literals.ESEQUENCE_SETTING__MIN_OCCURS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Max Occurs feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMaxOccursPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ESequenceSetting_maxOccurs_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ESequenceSetting_maxOccurs_feature", "_UI_ESequenceSetting_type"),
				 ConfmlPackage.Literals.ESEQUENCE_SETTING__MAX_OCCURS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Map Key feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMapKeyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ESequenceSetting_mapKey_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ESequenceSetting_mapKey_feature", "_UI_ESequenceSetting_type"),
				 ConfmlPackage.Literals.ESEQUENCE_SETTING__MAP_KEY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Map Value feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMapValuePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ESequenceSetting_mapValue_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ESequenceSetting_mapValue_feature", "_UI_ESequenceSetting_type"),
				 ConfmlPackage.Literals.ESEQUENCE_SETTING__MAP_VALUE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Visible Sub Settings feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addVisibleSubSettingsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ESequenceSetting_visibleSubSettings_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ESequenceSetting_visibleSubSettings_feature", "_UI_ESequenceSetting_type"),
				 ConfmlPackage.Literals.ESEQUENCE_SETTING__VISIBLE_SUB_SETTINGS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
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
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(ConfmlPackage.Literals.ESETTING_CONTAINER__SUB_TYPES);
			childrenFeatures.add(ConfmlPackage.Literals.ESEQUENCE_SETTING__ITEMS);
			childrenFeatures.add(ConfmlPackage.Literals.ESEQUENCE_SETTING__TEMPLATE);
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
	 * This returns ESequenceSetting.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ESequenceSetting"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((ESequenceSetting)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_ESequenceSetting_type") :
			getString("_UI_ESequenceSetting_type") + " " + label;
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

		switch (notification.getFeatureID(ESequenceSetting.class)) {
			case ConfmlPackage.ESEQUENCE_SETTING__MIN_OCCURS:
			case ConfmlPackage.ESEQUENCE_SETTING__MAX_OCCURS:
			case ConfmlPackage.ESEQUENCE_SETTING__MAP_KEY:
			case ConfmlPackage.ESEQUENCE_SETTING__MAP_VALUE:
			case ConfmlPackage.ESEQUENCE_SETTING__VISIBLE_SUB_SETTINGS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case ConfmlPackage.ESEQUENCE_SETTING__SUB_TYPES:
			case ConfmlPackage.ESEQUENCE_SETTING__ITEMS:
			case ConfmlPackage.ESEQUENCE_SETTING__TEMPLATE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
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
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(ConfmlPackage.Literals.ESETTING_CONTAINER__SUB_TYPES,
				 ConfmlFactory.eINSTANCE.createESimpleSetting()));

		newChildDescriptors.add
			(createChildParameter
				(ConfmlPackage.Literals.ESETTING_CONTAINER__SUB_TYPES,
				 ConfmlFactory.eINSTANCE.createESequenceSetting()));

		newChildDescriptors.add
			(createChildParameter
				(ConfmlPackage.Literals.ESETTING_CONTAINER__SUB_TYPES,
				 ConfmlFactory.eINSTANCE.createEResourceSetting()));

		newChildDescriptors.add
			(createChildParameter
				(ConfmlPackage.Literals.ESEQUENCE_SETTING__ITEMS,
				 ConfmlFactory.eINSTANCE.createEItemSetting()));

		newChildDescriptors.add
			(createChildParameter
				(ConfmlPackage.Literals.ESEQUENCE_SETTING__TEMPLATE,
				 ConfmlFactory.eINSTANCE.createEItemSetting()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == ConfmlPackage.Literals.ESETTING__VALUE ||
			childFeature == ConfmlPackage.Literals.ESETTING__DEFAULT_VALUE ||
			childFeature == ConfmlPackage.Literals.ESEQUENCE_SETTING__ITEMS ||
			childFeature == ConfmlPackage.Literals.ESEQUENCE_SETTING__TEMPLATE;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
