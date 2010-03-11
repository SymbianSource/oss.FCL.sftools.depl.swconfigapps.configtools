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
import configurationemf.ParentSetting;
import configurationemf.TYPE;







/**
 * This is the item provider adapter for a {@link configurationemf.ParentSetting} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ParentSettingItemProvider
	extends SettingItemProvider
	implements	
		IEditingDomainItemProvider,	
		IStructuredItemContentProvider,	
		ITreeItemContentProvider,	
		IItemLabelProvider,	
		IItemPropertySource {
	
	private static Object parentImageNormal = null;
	private static Object parentImageWarning = null;
	private static Object parentImageError = null;
	private static Object sequenceImageNormal = null;
	private static Object sequenceImageWarning = null;
	private static Object sequenceImageError = null;
	
//	public Collection getElements(Object arg0) {
//		List elements = (List)super.getElements(arg0);
//		if(Project.instance().isEditableElement((EObject)arg0)&&!arg0.equals(Project.ZERO_PSETTING))elements.add(null);
//		return elements;
//	}
	
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParentSettingItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
		// Create icon images
		parentImageNormal = getResourceLocator().getImage("full/obj16/ParentSetting");
		List<Object> images = new ArrayList<Object>(2);
		images.add(parentImageNormal);
		images.add(getResourceLocator().getImage("full/ovr16/error_co"));
		parentImageError = new ComposedImage(images);
		images.clear();
		images.add(parentImageNormal);
		images.add(getResourceLocator().getImage("full/ovr16/warning_co"));
		parentImageWarning = new ComposedImage(images);
		sequenceImageNormal = getResourceLocator().getImage("full/obj16/SeqSetting");
		images.clear();
		images.add(sequenceImageNormal);
		images.add(getResourceLocator().getImage("full/ovr16/warning_co"));
		sequenceImageWarning = new ComposedImage(images);
		images.clear();
		images.add(sequenceImageNormal);
		images.add(getResourceLocator().getImage("full/ovr16/error_co"));
		sequenceImageError = new ComposedImage(images);
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

			addTemplatePropertyDescriptor(object);
			addCurrentExtensionPolicyPropertyDescriptor(object);
			addMinOccursPropertyDescriptor(object);
			addMaxOccursPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Template feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTemplatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ParentSetting_template_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ParentSetting_template_feature", "_UI_ParentSetting_type"),
				 ConfigurationemfPackage.Literals.PARENT_SETTING__TEMPLATE,
				 false,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Current Extension Policy feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCurrentExtensionPolicyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ParentSetting_currentExtensionPolicy_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ParentSetting_currentExtensionPolicy_feature", "_UI_ParentSetting_type"),
				 ConfigurationemfPackage.Literals.PARENT_SETTING__CURRENT_EXTENSION_POLICY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
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
				 getString("_UI_ParentSetting_minOccurs_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ParentSetting_minOccurs_feature", "_UI_ParentSetting_type"),
				 ConfigurationemfPackage.Literals.PARENT_SETTING__MIN_OCCURS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
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
				 getString("_UI_ParentSetting_maxOccurs_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ParentSetting_maxOccurs_feature", "_UI_ParentSetting_type"),
				 ConfigurationemfPackage.Literals.PARENT_SETTING__MAX_OCCURS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
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
			childrenFeatures.add(ConfigurationemfPackage.Literals.PARENT_SETTING__LEAF_SETTING);
			childrenFeatures.add(ConfigurationemfPackage.Literals.PARENT_SETTING__FRAMES);
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
	 * This returns ParentSetting.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		
		if (object instanceof ParentSetting)
		{	
			ParentSetting ps = (ParentSetting) object;
			if (ps.getType().getValue() == TYPE.SEQUENCE_VALUE) {
				switch (MarkerManager.getInstance().getProblemStatus(object)) {
			      case IStatus.ERROR:
			    	  return sequenceImageError;
			      case IStatus.WARNING:
			    	  return sequenceImageWarning;
			      default:
			    	  return sequenceImageNormal;
			    }
			}
		}
		switch (MarkerManager.getInstance().getProblemStatus(object)) {
	      case IStatus.ERROR:
	    	  return parentImageError;
	      case IStatus.WARNING:
	    	  return parentImageWarning;
	      default:
	    	  return parentImageNormal;
	    }
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 */
	public String getText(Object object) {
		String label = ((ParentSetting)object).getName();
		return label == null || label.length() == 0 ?
				getString("_UI_No_Name") :label;
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

		switch (notification.getFeatureID(ParentSetting.class)) {
			case ConfigurationemfPackage.PARENT_SETTING__CURRENT_EXTENSION_POLICY:
			case ConfigurationemfPackage.PARENT_SETTING__MIN_OCCURS:
			case ConfigurationemfPackage.PARENT_SETTING__MAX_OCCURS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case ConfigurationemfPackage.PARENT_SETTING__LEAF_SETTING:
			case ConfigurationemfPackage.PARENT_SETTING__FRAMES:
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
				(ConfigurationemfPackage.Literals.PARENT_SETTING__LEAF_SETTING,
				 ConfigurationemfFactory.eINSTANCE.createLeafSetting()));

		newChildDescriptors.add
			(createChildParameter
				(ConfigurationemfPackage.Literals.PARENT_SETTING__FRAMES,
				 ConfigurationemfFactory.eINSTANCE.createFrame()));
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
