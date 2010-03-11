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
 * Description: This file is part of com.nokia.tools.vct.appshell component.
 */

package com.nokia.tools.vct.appshell.appshellmodel.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.edit.provider.AttributeValueWrapperItemProvider;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.DelegatingWrapperItemProvider;
import org.eclipse.emf.edit.provider.FeatureMapEntryWrapperItemProvider;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import com.nokia.tools.vct.appshell.AppshellPlugin;
import com.nokia.tools.vct.appshell.appshellmodel.EAppshellModelFactory;
import com.nokia.tools.vct.appshell.appshellmodel.EAppshellModelPackage;
import com.nokia.tools.vct.appshell.appshellmodel.EFolderElement;

/**
 * This is the item provider adapter for a {@link com.nokia.tools.vct.appshell.appshellmodel.EFolderElement} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class EFolderElementItemProvider
	extends ItemProviderAdapter
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
	public EFolderElementItemProvider(AdapterFactory adapterFactory) {
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

			addLockNamePropertyDescriptor(object);
			addLockIconPropertyDescriptor(object);
			addLockDeletePropertyDescriptor(object);
			addLockOrganizePropertyDescriptor(object);
			addIconFilePropertyDescriptor(object);
			addM3gIconFilePropertyDescriptor(object);
			addIconIdPropertyDescriptor(object);
			addMaskIdPropertyDescriptor(object);
			addIconSkinMajorIdPropertyDescriptor(object);
			addIconSkinMinorIdPropertyDescriptor(object);
			addHideChangeSkinPropertyDescriptor(object);
			addHideMemDetailsPropertyDescriptor(object);
			addHideDownloadPropertyDescriptor(object);
			addHideAnimatedIconsPropertyDescriptor(object);
			addTitleNamePropertyDescriptor(object);
			addShortNamePropertyDescriptor(object);
			addLongNamePropertyDescriptor(object);
			addDefaultPropertyDescriptor(object);
			addApplicationGroupNamePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Lock Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLockNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ELockDescriptor_lockName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ELockDescriptor_lockName_feature", "_UI_ELockDescriptor_type"),
				 EAppshellModelPackage.Literals.ELOCK_DESCRIPTOR__LOCK_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Lock Icon feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLockIconPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ELockDescriptor_lockIcon_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ELockDescriptor_lockIcon_feature", "_UI_ELockDescriptor_type"),
				 EAppshellModelPackage.Literals.ELOCK_DESCRIPTOR__LOCK_ICON,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Lock Delete feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLockDeletePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ELockDescriptor_lockDelete_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ELockDescriptor_lockDelete_feature", "_UI_ELockDescriptor_type"),
				 EAppshellModelPackage.Literals.ELOCK_DESCRIPTOR__LOCK_DELETE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Lock Organize feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLockOrganizePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ELockDescriptor_lockOrganize_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ELockDescriptor_lockOrganize_feature", "_UI_ELockDescriptor_type"),
				 EAppshellModelPackage.Literals.ELOCK_DESCRIPTOR__LOCK_ORGANIZE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Hide Change Skin feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addHideChangeSkinPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EHideDescriptor_hideChangeSkin_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EHideDescriptor_hideChangeSkin_feature", "_UI_EHideDescriptor_type"),
				 EAppshellModelPackage.Literals.EHIDE_DESCRIPTOR__HIDE_CHANGE_SKIN,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Hide Mem Details feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addHideMemDetailsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EHideDescriptor_hideMemDetails_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EHideDescriptor_hideMemDetails_feature", "_UI_EHideDescriptor_type"),
				 EAppshellModelPackage.Literals.EHIDE_DESCRIPTOR__HIDE_MEM_DETAILS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Hide Download feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addHideDownloadPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EHideDescriptor_hideDownload_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EHideDescriptor_hideDownload_feature", "_UI_EHideDescriptor_type"),
				 EAppshellModelPackage.Literals.EHIDE_DESCRIPTOR__HIDE_DOWNLOAD,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Hide Animated Icons feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addHideAnimatedIconsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EHideDescriptor_hideAnimatedIcons_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EHideDescriptor_hideAnimatedIcons_feature", "_UI_EHideDescriptor_type"),
				 EAppshellModelPackage.Literals.EHIDE_DESCRIPTOR__HIDE_ANIMATED_ICONS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Icon File feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIconFilePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EIconDescriptor_iconFile_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EIconDescriptor_iconFile_feature", "_UI_EIconDescriptor_type"),
				 EAppshellModelPackage.Literals.EICON_DESCRIPTOR__ICON_FILE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the M3g Icon File feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addM3gIconFilePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EIconDescriptor_m3gIconFile_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EIconDescriptor_m3gIconFile_feature", "_UI_EIconDescriptor_type"),
				 EAppshellModelPackage.Literals.EICON_DESCRIPTOR__M3G_ICON_FILE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Icon Id feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIconIdPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EIconDescriptor_iconId_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EIconDescriptor_iconId_feature", "_UI_EIconDescriptor_type"),
				 EAppshellModelPackage.Literals.EICON_DESCRIPTOR__ICON_ID,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Mask Id feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMaskIdPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EIconDescriptor_maskId_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EIconDescriptor_maskId_feature", "_UI_EIconDescriptor_type"),
				 EAppshellModelPackage.Literals.EICON_DESCRIPTOR__MASK_ID,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Icon Skin Major Id feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIconSkinMajorIdPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EIconDescriptor_iconSkinMajorId_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EIconDescriptor_iconSkinMajorId_feature", "_UI_EIconDescriptor_type"),
				 EAppshellModelPackage.Literals.EICON_DESCRIPTOR__ICON_SKIN_MAJOR_ID,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Icon Skin Minor Id feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIconSkinMinorIdPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EIconDescriptor_iconSkinMinorId_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EIconDescriptor_iconSkinMinorId_feature", "_UI_EIconDescriptor_type"),
				 EAppshellModelPackage.Literals.EICON_DESCRIPTOR__ICON_SKIN_MINOR_ID,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Title Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTitleNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ENameDescriptor_titleName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ENameDescriptor_titleName_feature", "_UI_ENameDescriptor_type"),
				 EAppshellModelPackage.Literals.ENAME_DESCRIPTOR__TITLE_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Default feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDefaultPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EFolderElement_default_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EFolderElement_default_feature", "_UI_EFolderElement_type"),
				 EAppshellModelPackage.Literals.EFOLDER_ELEMENT__DEFAULT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Short Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addShortNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ENameDescriptor_shortName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ENameDescriptor_shortName_feature", "_UI_ENameDescriptor_type"),
				 EAppshellModelPackage.Literals.ENAME_DESCRIPTOR__SHORT_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Long Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLongNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ENameDescriptor_longName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ENameDescriptor_longName_feature", "_UI_ENameDescriptor_type"),
				 EAppshellModelPackage.Literals.ENAME_DESCRIPTOR__LONG_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Application Group Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addApplicationGroupNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EFolderElement_applicationGroupName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EFolderElement_applicationGroupName_feature", "_UI_EFolderElement_type"),
				 EAppshellModelPackage.Literals.EFOLDER_ELEMENT__APPLICATION_GROUP_NAME,
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
			childrenFeatures.add(EAppshellModelPackage.Literals.EFOLDER_ELEMENT__CONTENTS);
		}
		return childrenFeatures;
	}

	@Override
	protected Object createWrapper(EObject object, EStructuralFeature feature,
			Object value, int index) {
	    if (!isWrappingNeeded(object)) return value;

	    if (FeatureMapUtil.isFeatureMap(feature))
	    {
	      value = new FeatureMapEntryWrapperItemProvider((FeatureMap.Entry)value, object, (EAttribute)feature, index, adapterFactory, getResourceLocator()) {
	    	  @Override
	    	protected String addEntryFeature(String text) {
	    		return text;
	    	}
	      };
	    }
	    else if (feature instanceof EAttribute)
	    {
	      value = new AttributeValueWrapperItemProvider(value, object, (EAttribute)feature, index, adapterFactory, getResourceLocator());
	    }
	    else if (!((EReference)feature).isContainment())
	    {
	      value = new DelegatingWrapperItemProvider(value, object, feature, index, adapterFactory);
	    }

	    return value;
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
	 * This returns EFolderElement.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/EFolderElement"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		String label = ((EFolderElement)object).getApplicationGroupName();
		return label == null || label.length() == 0 ?
			getString("_UI_EFolderElement_type") :
			label;
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

		switch (notification.getFeatureID(EFolderElement.class)) {
			case EAppshellModelPackage.EFOLDER_ELEMENT__LOCK_NAME:
			case EAppshellModelPackage.EFOLDER_ELEMENT__LOCK_ICON:
			case EAppshellModelPackage.EFOLDER_ELEMENT__LOCK_DELETE:
			case EAppshellModelPackage.EFOLDER_ELEMENT__LOCK_ORGANIZE:
			case EAppshellModelPackage.EFOLDER_ELEMENT__ICON_FILE:
			case EAppshellModelPackage.EFOLDER_ELEMENT__M3G_ICON_FILE:
			case EAppshellModelPackage.EFOLDER_ELEMENT__ICON_ID:
			case EAppshellModelPackage.EFOLDER_ELEMENT__MASK_ID:
			case EAppshellModelPackage.EFOLDER_ELEMENT__ICON_SKIN_MAJOR_ID:
			case EAppshellModelPackage.EFOLDER_ELEMENT__ICON_SKIN_MINOR_ID:
			case EAppshellModelPackage.EFOLDER_ELEMENT__HIDE_CHANGE_SKIN:
			case EAppshellModelPackage.EFOLDER_ELEMENT__HIDE_MEM_DETAILS:
			case EAppshellModelPackage.EFOLDER_ELEMENT__HIDE_DOWNLOAD:
			case EAppshellModelPackage.EFOLDER_ELEMENT__HIDE_ANIMATED_ICONS:
			case EAppshellModelPackage.EFOLDER_ELEMENT__TITLE_NAME:
			case EAppshellModelPackage.EFOLDER_ELEMENT__SHORT_NAME:
			case EAppshellModelPackage.EFOLDER_ELEMENT__LONG_NAME:
			case EAppshellModelPackage.EFOLDER_ELEMENT__DEFAULT:
			case EAppshellModelPackage.EFOLDER_ELEMENT__APPLICATION_GROUP_NAME:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case EAppshellModelPackage.EFOLDER_ELEMENT__CONTENTS:
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
				(EAppshellModelPackage.Literals.EFOLDER_ELEMENT__CONTENTS,
				 FeatureMapUtil.createEntry
					(EAppshellModelPackage.Literals.EFOLDER_ELEMENT__APPLICATIONS,
					 EAppshellModelFactory.eINSTANCE.createEApplicationElement())));

		newChildDescriptors.add
			(createChildParameter
				(EAppshellModelPackage.Literals.EFOLDER_ELEMENT__CONTENTS,
				 FeatureMapUtil.createEntry
					(EAppshellModelPackage.Literals.EFOLDER_ELEMENT__FOLDERS,
					 EAppshellModelFactory.eINSTANCE.createEFolderElement())));

		newChildDescriptors.add
			(createChildParameter
				(EAppshellModelPackage.Literals.EFOLDER_ELEMENT__CONTENTS,
				 FeatureMapUtil.createEntry
					(EAppshellModelPackage.Literals.EFOLDER_ELEMENT__URLS,
					 EAppshellModelFactory.eINSTANCE.createEURLElement())));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return AppshellPlugin.INSTANCE;
	}

}
