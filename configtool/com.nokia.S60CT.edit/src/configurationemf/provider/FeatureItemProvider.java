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


import helpers.MarkerManager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedImage;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import configurationemf.ConfigurationemfFactory;
import configurationemf.ConfigurationemfPackage;
import configurationemf.Feature;
import configurationemf.Project;








/**
 * This is the item provider adapter for a {@link configurationemf.Feature} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class FeatureItemProvider
	extends ReferableItemProvider
	implements	
		IEditingDomainItemProvider,	
		IStructuredItemContentProvider,	
		ITreeItemContentProvider,	
		IItemLabelProvider,	
		IItemPropertySource	{
	
	private static Object featureImageNormal = null;
	private static Object featureImageWarning = null;
	private static Object featureImageError = null;
	
	
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
		featureImageNormal = getResourceLocator().getImage("full/obj16/Feature");
		List<Object> images = new ArrayList<Object>(2);
		images.add(featureImageNormal);
		images.add(getResourceLocator().getImage("full/ovr16/error_co"));
		featureImageError = new ComposedImage(images);
		images.clear();
		images.add(featureImageNormal);
		images.add(getResourceLocator().getImage("full/ovr16/warning_co"));
		featureImageWarning = new ComposedImage(images);
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
			addRelevantPropertyDescriptor(object);
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
				 getString("_UI_Feature_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Feature_name_feature", "_UI_Feature_type"),
				 ConfigurationemfPackage.Literals.FEATURE__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Relevant feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addRelevantPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Feature_relevant_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Feature_relevant_feature", "_UI_Feature_type"),
				 ConfigurationemfPackage.Literals.FEATURE__RELEVANT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 "Feature",
				 null));
	}

	/**
	 * This adds a property descriptor for the Read Only feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addReadOnlyPropertyDescriptor(Object object) {
//		itemPropertyDescriptors.add
//			(createItemPropertyDescriptor
//				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
//				 getResourceLocator(),
//				 getString("_UI_Feature_readOnly_feature"),
//				 getString("_UI_PropertyDescriptor_description", "_UI_Feature_readOnly_feature", "_UI_Feature_type"),
//				 ConfigurationemfPackage.Literals.FEATURE__READ_ONLY,
//				 true,
//				 false,
//				 false,
//				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
//				 null,
//				 null));
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
			childrenFeatures.add(ConfigurationemfPackage.Literals.FEATURE__PARENT_SETTING);
			childrenFeatures.add(ConfigurationemfPackage.Literals.FEATURE__LINK);
			childrenFeatures.add(ConfigurationemfPackage.Literals.FEATURE__ICON);
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
	 * This returns Feature.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		//return overlayImage(object, getResourceLocator().getImage("full/obj16/Feature"));
		
		switch (MarkerManager.getInstance().getProblemStatus(object)) {
	      case IStatus.ERROR:
	    	  return featureImageError;
	      case IStatus.WARNING:
	    	  return featureImageWarning;
	      default:
	    	  return featureImageNormal;
	    }
		
		
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 */
	public String getText(Object object) {
		String label = ((Feature)object).getName();
		return label == null || label.length() == 0 ?
				getString("_UI_No_Name") :label;
	}

	public Collection getElements(Object arg0) {
		List elements = (List)super.getElements(arg0); 
		if(Project.instance().isEditableElement((EObject)arg0))elements.add(Project.ZERO_PSETTING);
		return elements;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);
		Feature feature = (Feature)notification.getNotifier();
		switch (notification.getFeatureID(Feature.class)) {
			case ConfigurationemfPackage.FEATURE__NAME:
				if(feature.getRef()==null){
					feature.setRef(notification.getNewStringValue().replaceAll(" ", ""));
				}
			case ConfigurationemfPackage.FEATURE__RELEVANT:
			case ConfigurationemfPackage.FEATURE__READ_ONLY:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case ConfigurationemfPackage.FEATURE__PARENT_SETTING:
			case ConfigurationemfPackage.FEATURE__LINK:
			case ConfigurationemfPackage.FEATURE__ICON:
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
				(ConfigurationemfPackage.Literals.FEATURE__PARENT_SETTING,
				 ConfigurationemfFactory.eINSTANCE.createParentSetting()));

		newChildDescriptors.add
			(createChildParameter
				(ConfigurationemfPackage.Literals.FEATURE__PARENT_SETTING,
				 ConfigurationemfFactory.eINSTANCE.createGSetting()));

		newChildDescriptors.add
			(createChildParameter
				(ConfigurationemfPackage.Literals.FEATURE__LINK,
				 ConfigurationemfFactory.eINSTANCE.createLink()));

		newChildDescriptors.add
			(createChildParameter
				(ConfigurationemfPackage.Literals.FEATURE__ICON,
				 ConfigurationemfFactory.eINSTANCE.createIcon()));
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
