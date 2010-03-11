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

package com.nokia.tools.vct.confml.model.confml2.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.ecore.xml.type.XMLTypeFactory;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
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
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import com.nokia.tools.vct.confml.edit.ConfMLEditPlugin;
import com.nokia.tools.vct.confml.model.confml1.edit.provider.ERefNamedElementItemProvider;
import com.nokia.tools.vct.confml.model.confml2.EConfML2Factory;
import com.nokia.tools.vct.confml.model.confml2.EConfML2Package;
import com.nokia.tools.vct.confml.model.confml2.ESettingData;

/**
 * This is the item provider adapter for a {@link com.nokia.tools.vct.confml.model.confml2.ESettingData} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ESettingDataItemProvider extends ItemProviderAdapter implements
		IEditingDomainItemProvider, IStructuredItemContentProvider,
		ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource,
		IItemColorProvider, IItemFontProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ESettingDataItemProvider(AdapterFactory adapterFactory) {
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

			addRefPropertyDescriptor(object);
			addTemplatePropertyDescriptor(object);
			addExtensionPolicyPropertyDescriptor(object);
			addTextPropertyDescriptor(object);
			addMapPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
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
				getString("_UI_ERefNamedElement_ref_feature"), getString(
						"_UI_PropertyDescriptor_description",
						"_UI_ERefNamedElement_ref_feature",
						"_UI_ERefNamedElement_type"),
				EConfML2Package.Literals.EREF_NAMED_ELEMENT__REF, true, false,
				false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Template feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTemplatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_ESettingData_template_feature"), getString(
						"_UI_PropertyDescriptor_description",
						"_UI_ESettingData_template_feature",
						"_UI_ESettingData_type"),
				EConfML2Package.Literals.ESETTING_DATA__TEMPLATE, true, false,
				false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Extension Policy feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addExtensionPolicyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_ESettingData_extensionPolicy_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_ESettingData_extensionPolicy_feature",
						"_UI_ESettingData_type"),
				EConfML2Package.Literals.ESETTING_DATA__EXTENSION_POLICY, true,
				false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null,
				null));
	}

	/**
	 * This adds a property descriptor for the Text feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTextPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_ESettingData_text_feature"), getString(
						"_UI_PropertyDescriptor_description",
						"_UI_ESettingData_text_feature",
						"_UI_ESettingData_type"),
				EConfML2Package.Literals.ESETTING_DATA__TEXT, true, false,
				false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Map feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMapPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory)
								.getRootAdapterFactory(), getResourceLocator(),
						getString("_UI_ESettingData_map_feature"), getString(
								"_UI_PropertyDescriptor_description",
								"_UI_ESettingData_map_feature",
								"_UI_ESettingData_type"),
						EConfML2Package.Literals.ESETTING_DATA__MAP, true,
						false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
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
			childrenFeatures
					.add(EConfML2Package.Literals.ESETTING_DATA_CONTAINER__SETTINGS);
			childrenFeatures.add(EConfML2Package.Literals.ESETTING_DATA__VALUE);
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
	 * This returns ESettingData.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage(
				"full/obj16/ESettingData"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		String label = ((ESettingData) object).getRef();
		return label == null || label.length() == 0 ? getString("_UI_ESettingData_type")
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

		switch (notification.getFeatureID(ESettingData.class)) {
		case EConfML2Package.ESETTING_DATA__REF:
		case EConfML2Package.ESETTING_DATA__TEMPLATE:
		case EConfML2Package.ESETTING_DATA__EXTENSION_POLICY:
		case EConfML2Package.ESETTING_DATA__TEXT:
		case EConfML2Package.ESETTING_DATA__MAP:
			fireNotifyChanged(new ViewerNotification(notification, notification
					.getNotifier(), false, true));
			return;
		case EConfML2Package.ESETTING_DATA__SETTINGS:
		case EConfML2Package.ESETTING_DATA__VALUE:
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
				EConfML2Package.Literals.ESETTING_DATA_CONTAINER__SETTINGS,
				EConfML2Factory.eINSTANCE.createESettingData()));

		newChildDescriptors
				.add(createChildParameter(
						EConfML2Package.Literals.ESETTING_DATA__VALUE,
						FeatureMapUtil
								.createEntry(
										XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__COMMENT,
										"")));

		newChildDescriptors.add(createChildParameter(
				EConfML2Package.Literals.ESETTING_DATA__VALUE,
				FeatureMapUtil.createEntry(
						XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__TEXT,
						"")));

		newChildDescriptors
				.add(createChildParameter(
						EConfML2Package.Literals.ESETTING_DATA__VALUE,
						FeatureMapUtil
								.createEntry(
										XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__PROCESSING_INSTRUCTION,
										XMLTypeFactory.eINSTANCE
												.createProcessingInstruction())));

		newChildDescriptors.add(createChildParameter(
				EConfML2Package.Literals.ESETTING_DATA__VALUE,
				FeatureMapUtil.createEntry(
						XMLTypePackage.Literals.XML_TYPE_DOCUMENT_ROOT__CDATA,
						"")));

		newChildDescriptors.add(createChildParameter(
				EConfML2Package.Literals.ESETTING_DATA__VALUE, FeatureMapUtil
						.createEntry(
								EConfML2Package.Literals.ESETTING_DATA__TEXT,
								"")));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return ConfMLEditPlugin.INSTANCE;
	}

}
