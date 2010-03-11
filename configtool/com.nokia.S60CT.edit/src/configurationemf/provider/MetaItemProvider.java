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
import org.eclipse.emf.edit.provider.ViewerNotification;

import configurationemf.ConfigurationemfFactory;
import configurationemf.ConfigurationemfPackage;
import configurationemf.Meta;







/**
 * This is the item provider adapter for a {@link configurationemf.Meta} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class MetaItemProvider
	extends CommonAttrItemProvider
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
	public MetaItemProvider(AdapterFactory adapterFactory) {
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

			addReleasePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
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
				 getString("_UI_Meta_Release_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Meta_Release_feature", "_UI_Meta_type"),
				 ConfigurationemfPackage.Literals.META__RELEASE,
				 true,
				 false,
				 true,
				 null,
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
			childrenFeatures.add(ConfigurationemfPackage.Literals.META__IDENTIFICATION);
			childrenFeatures.add(ConfigurationemfPackage.Literals.META__OWNER);
			childrenFeatures.add(ConfigurationemfPackage.Literals.META__EDITOR);
			childrenFeatures.add(ConfigurationemfPackage.Literals.META__STATUS);
			childrenFeatures.add(ConfigurationemfPackage.Literals.META__VERSION);
			childrenFeatures.add(ConfigurationemfPackage.Literals.META__PLATFORM);
			childrenFeatures.add(ConfigurationemfPackage.Literals.META__PRODUCT);
			childrenFeatures.add(ConfigurationemfPackage.Literals.META__CUSTOMER);
			childrenFeatures.add(ConfigurationemfPackage.Literals.META__DATE);
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
	 * This returns Meta.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Meta"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Meta)object).getId();
		return label == null || label.length() == 0 ?
			getString("_UI_Meta_type") :
			getString("_UI_Meta_type") + " " + label;
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

		switch (notification.getFeatureID(Meta.class)) {
			case ConfigurationemfPackage.META__IDENTIFICATION:
			case ConfigurationemfPackage.META__OWNER:
			case ConfigurationemfPackage.META__EDITOR:
			case ConfigurationemfPackage.META__STATUS:
			case ConfigurationemfPackage.META__VERSION:
			case ConfigurationemfPackage.META__PLATFORM:
			case ConfigurationemfPackage.META__PRODUCT:
			case ConfigurationemfPackage.META__CUSTOMER:
			case ConfigurationemfPackage.META__DATE:
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
				(ConfigurationemfPackage.Literals.META__IDENTIFICATION,
				 ConfigurationemfFactory.eINSTANCE.createIdentification()));

		newChildDescriptors.add
			(createChildParameter
				(ConfigurationemfPackage.Literals.META__OWNER,
				 ConfigurationemfFactory.eINSTANCE.createOwner()));

		newChildDescriptors.add
			(createChildParameter
				(ConfigurationemfPackage.Literals.META__EDITOR,
				 ConfigurationemfFactory.eINSTANCE.createEditor()));

		newChildDescriptors.add
			(createChildParameter
				(ConfigurationemfPackage.Literals.META__STATUS,
				 ConfigurationemfFactory.eINSTANCE.createStatus()));

		newChildDescriptors.add
			(createChildParameter
				(ConfigurationemfPackage.Literals.META__VERSION,
				 ConfigurationemfFactory.eINSTANCE.createVersion()));

		newChildDescriptors.add
			(createChildParameter
				(ConfigurationemfPackage.Literals.META__PLATFORM,
				 ConfigurationemfFactory.eINSTANCE.createPlatform()));

		newChildDescriptors.add
			(createChildParameter
				(ConfigurationemfPackage.Literals.META__PRODUCT,
				 ConfigurationemfFactory.eINSTANCE.createProduct()));

		newChildDescriptors.add
			(createChildParameter
				(ConfigurationemfPackage.Literals.META__CUSTOMER,
				 ConfigurationemfFactory.eINSTANCE.createCustomer()));

		newChildDescriptors.add
			(createChildParameter
				(ConfigurationemfPackage.Literals.META__DATE,
				 ConfigurationemfFactory.eINSTANCE.createDate()));
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

}
