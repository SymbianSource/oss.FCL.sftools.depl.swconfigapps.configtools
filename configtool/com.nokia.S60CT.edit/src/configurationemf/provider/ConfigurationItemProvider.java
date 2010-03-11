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
package configurationemf.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
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

import variantdata.VariantDataFactory;
import configurationemf.Configuration;
import configurationemf.ConfigurationemfFactory;
import configurationemf.ConfigurationemfPackage;





/**
 * This is the item provider adapter for a {@link configurationemf.Configuration} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ConfigurationItemProvider
	extends AttributeAndDescItemProvider
	implements	
		IEditingDomainItemProvider,	
		IStructuredItemContentProvider,	
		ITreeItemContentProvider,	
		IItemLabelProvider,	
		IItemPropertySource{
	
	
	

	
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigurationItemProvider(AdapterFactory adapterFactory) {
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

			addNamePropertyDescriptor(object);
			addVersPropertyDescriptor(object);
			addReadOnlyPropertyDescriptor(object);
			addMetaIdPropertyDescriptor(object);
			addOwnerPropertyDescriptor(object);
			addEditorPropertyDescriptor(object);
			addStatusPropertyDescriptor(object);
			addVersionPropertyDescriptor(object);
			addPlatformPropertyDescriptor(object);
			addProductPropertyDescriptor(object);
			addCustomerPropertyDescriptor(object);
			addDatePropertyDescriptor(object);
			addReleasePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Configuration_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Configuration_name_feature", "_UI_Configuration_type"),
				 ConfigurationemfPackage.Literals.CONFIGURATION__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Vers feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addVersPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Configuration_vers_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Configuration_vers_feature", "_UI_Configuration_type"),
				 ConfigurationemfPackage.Literals.CONFIGURATION__VERS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Read Only feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addReadOnlyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Configuration_readOnly_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Configuration_readOnly_feature", "_UI_Configuration_type"),
				 ConfigurationemfPackage.Literals.CONFIGURATION__READ_ONLY,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Meta Id feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMetaIdPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Configuration_metaId_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Configuration_metaId_feature", "_UI_Configuration_type"),
				 ConfigurationemfPackage.Literals.CONFIGURATION__META_ID,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_MetaPropertyCategory"),
				 null));
	}

/**
	 * This adds a property descriptor for the Owner feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOwnerPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Configuration_owner_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Configuration_owner_feature", "_UI_Configuration_type"),
				 ConfigurationemfPackage.Literals.CONFIGURATION__OWNER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_MetaPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Editor feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEditorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Configuration_editor_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Configuration_editor_feature", "_UI_Configuration_type"),
				 ConfigurationemfPackage.Literals.CONFIGURATION__EDITOR,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_MetaPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Status feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStatusPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Configuration_status_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Configuration_status_feature", "_UI_Configuration_type"),
				 ConfigurationemfPackage.Literals.CONFIGURATION__STATUS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_MetaPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Version feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addVersionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Configuration_version_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Configuration_version_feature", "_UI_Configuration_type"),
				 ConfigurationemfPackage.Literals.CONFIGURATION__VERSION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_MetaPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Platform feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPlatformPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Configuration_platform_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Configuration_platform_feature", "_UI_Configuration_type"),
				 ConfigurationemfPackage.Literals.CONFIGURATION__PLATFORM,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_MetaPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Product feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addProductPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Configuration_product_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Configuration_product_feature", "_UI_Configuration_type"),
				 ConfigurationemfPackage.Literals.CONFIGURATION__PRODUCT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_MetaPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Customer feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCustomerPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Configuration_customer_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Configuration_customer_feature", "_UI_Configuration_type"),
				 ConfigurationemfPackage.Literals.CONFIGURATION__CUSTOMER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_MetaPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Date feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Configuration_date_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Configuration_date_feature", "_UI_Configuration_type"),
				 ConfigurationemfPackage.Literals.CONFIGURATION__DATE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_MetaPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Release feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addReleasePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Configuration_release_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Configuration_release_feature", "_UI_Configuration_type"),
				 ConfigurationemfPackage.Literals.CONFIGURATION__RELEASE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_MetaPropertyCategory"),
				 null));
	}

	//	protected void addMetaPropertyDescriptor(Object object) {
//		itemPropertyDescriptors.add(new PlatformPropertyDescriptor());
//		itemPropertyDescriptors.add(new VersionPropertyDescriptor());
//		itemPropertyDescriptors.add(new EditorPropertyDescriptor());
//		itemPropertyDescriptors.add(new OwnerPropertyDescriptor());
//		itemPropertyDescriptors.add(new IdPropertyDescriptor());
//		itemPropertyDescriptors.add(new CustomerPropertyDescriptor());
//		itemPropertyDescriptors.add(new ProductPropertyDescriptor());
//		itemPropertyDescriptors.add(new DatePropertyDescriptor());
//		itemPropertyDescriptors.add(new StatusPropertyDescriptor());
//		
//	}
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
			childrenFeatures.add(ConfigurationemfPackage.Literals.CONFIGURATION__FEATURE);
			childrenFeatures.add(ConfigurationemfPackage.Literals.CONFIGURATION__VIEW);
			childrenFeatures.add(ConfigurationemfPackage.Literals.CONFIGURATION__META);
			childrenFeatures.add(ConfigurationemfPackage.Literals.CONFIGURATION__ICON);
			childrenFeatures.add(ConfigurationemfPackage.Literals.CONFIGURATION__LINK);
			childrenFeatures.add(ConfigurationemfPackage.Literals.CONFIGURATION__DATA);
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
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Configuration)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Configuration_type") :
			getString("_UI_Configuration_type") + " " + label;
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

		switch (notification.getFeatureID(Configuration.class)) {
			case ConfigurationemfPackage.CONFIGURATION__NAME:
			case ConfigurationemfPackage.CONFIGURATION__VERS:
			case ConfigurationemfPackage.CONFIGURATION__READ_ONLY:
			case ConfigurationemfPackage.CONFIGURATION__META_ID:
			case ConfigurationemfPackage.CONFIGURATION__OWNER:
			case ConfigurationemfPackage.CONFIGURATION__EDITOR:
			case ConfigurationemfPackage.CONFIGURATION__STATUS:
			case ConfigurationemfPackage.CONFIGURATION__VERSION:
			case ConfigurationemfPackage.CONFIGURATION__PLATFORM:
			case ConfigurationemfPackage.CONFIGURATION__PRODUCT:
			case ConfigurationemfPackage.CONFIGURATION__CUSTOMER:
			case ConfigurationemfPackage.CONFIGURATION__DATE:
			case ConfigurationemfPackage.CONFIGURATION__RELEASE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case ConfigurationemfPackage.CONFIGURATION__FEATURE:
			case ConfigurationemfPackage.CONFIGURATION__VIEW:
			case ConfigurationemfPackage.CONFIGURATION__META:
			case ConfigurationemfPackage.CONFIGURATION__ICON:
			case ConfigurationemfPackage.CONFIGURATION__LINK:
			case ConfigurationemfPackage.CONFIGURATION__DATA:
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
				(ConfigurationemfPackage.Literals.CONFIGURATION__FEATURE,
				 ConfigurationemfFactory.eINSTANCE.createFeature()));

		newChildDescriptors.add
			(createChildParameter
				(ConfigurationemfPackage.Literals.CONFIGURATION__VIEW,
				 ConfigurationemfFactory.eINSTANCE.createView()));

		newChildDescriptors.add
			(createChildParameter
				(ConfigurationemfPackage.Literals.CONFIGURATION__META,
				 ConfigurationemfFactory.eINSTANCE.createMeta()));

		newChildDescriptors.add
			(createChildParameter
				(ConfigurationemfPackage.Literals.CONFIGURATION__ICON,
				 ConfigurationemfFactory.eINSTANCE.createIcon()));

		newChildDescriptors.add
			(createChildParameter
				(ConfigurationemfPackage.Literals.CONFIGURATION__LINK,
				 ConfigurationemfFactory.eINSTANCE.createLink()));

		newChildDescriptors.add
			(createChildParameter
				(ConfigurationemfPackage.Literals.CONFIGURATION__DATA,
				 ConfigurationemfFactory.eINSTANCE.createData()));

		newChildDescriptors.add
			(createChildParameter
				(ConfigurationemfPackage.Literals.CONFIGURATION__DATA,
				 ConfigurationemfFactory.eINSTANCE.createRfs()));

		newChildDescriptors.add
			(createChildParameter
				(ConfigurationemfPackage.Literals.CONFIGURATION__DATA,
				 VariantDataFactory.eINSTANCE.createVariantData()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return ConfigurationEMFEditPlugin.INSTANCE;
	}

	public IItemPropertyDescriptor getPropertyDescriptor(Object arg0, Object arg1) {
		return super.getPropertyDescriptor(arg0, arg1);
	}

	public Object getPropertyValue(Object arg0, String arg1) {
		return super.getPropertyValue(arg0, arg1);
	}
	
	
}
