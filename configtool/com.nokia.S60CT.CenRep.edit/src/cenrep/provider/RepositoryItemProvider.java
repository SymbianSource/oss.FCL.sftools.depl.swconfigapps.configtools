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
package cenrep.provider;


import cenrep.CenrepFactory;
import cenrep.CenrepPackage;
import cenrep.Repository;

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

/**
 * This is the item provider adapter for a {@link cenrep.Repository} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class RepositoryItemProvider
	extends AttributeAndDescriptionItemProvider
	implements	
		IEditingDomainItemProvider,	
		IStructuredItemContentProvider,	
		ITreeItemContentProvider,	
		IItemLabelProvider,	
		IItemPropertySource {
	
	
	private static Object repositoryImageNormal = null;
	private static Object repositoryImageWarning = null;
	private static Object repositoryImageError = null;
	
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RepositoryItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
		repositoryImageNormal = getResourceLocator().getImage("full/obj16/Repository");
		List<Object> images = new ArrayList<Object>(2);
		images.add(repositoryImageNormal);
		images.add(getResourceLocator().getImage("full/ovr16/error_co"));
		repositoryImageError = new ComposedImage(images);
		images.clear();
		images.add(repositoryImageNormal);
		images.add(getResourceLocator().getImage("full/ovr16/warning_co"));
		repositoryImageWarning = new ComposedImage(images);
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

			addReadAccessPropertyDescriptor(object);
			addWriteAccessPropertyDescriptor(object);
			addGAccessPropertyDescriptor(object);
			addBackupPropertyDescriptor(object);
			addVersionPropertyDescriptor(object);
			addUidNamePropertyDescriptor(object);
			addUidValuePropertyDescriptor(object);
			addInitialisationFileVersionPropertyDescriptor(object);
			addOwnerPropertyDescriptor(object);
			addRfsPropertyDescriptor(object);
			addMetaPropertyDescriptor(object);
			addSimpleKeysPropertyDescriptor(object);
			addBitmaskKeysPropertyDescriptor(object);
			addRangeKeyPropertyDescriptor(object);
			addFileNamePropertyDescriptor(object);
			addProblemsPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
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
				 getString("_UI_Repository_version_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Repository_version_feature", "_UI_Repository_type"),
				 CenrepPackage.Literals.REPOSITORY__VERSION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Uid Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUidNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Repository_uidName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Repository_uidName_feature", "_UI_Repository_type"),
				 CenrepPackage.Literals.REPOSITORY__UID_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Uid Value feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUidValuePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Repository_uidValue_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Repository_uidValue_feature", "_UI_Repository_type"),
				 CenrepPackage.Literals.REPOSITORY__UID_VALUE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Initialisation File Version feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInitialisationFileVersionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Repository_initialisationFileVersion_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Repository_initialisationFileVersion_feature", "_UI_Repository_type"),
				 CenrepPackage.Literals.REPOSITORY__INITIALISATION_FILE_VERSION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
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
				 getString("_UI_Repository_owner_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Repository_owner_feature", "_UI_Repository_type"),
				 CenrepPackage.Literals.REPOSITORY__OWNER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Backup feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBackupPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_IBackup_backup_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_IBackup_backup_feature", "_UI_IBackup_type"),
				 CenrepPackage.Literals.IBACKUP__BACKUP,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Rfs feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRfsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Repository_rfs_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Repository_rfs_feature", "_UI_Repository_type"),
				 CenrepPackage.Literals.REPOSITORY__RFS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Meta feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMetaPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Repository_meta_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Repository_meta_feature", "_UI_Repository_type"),
				 CenrepPackage.Literals.REPOSITORY__META,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Simple Keys feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSimpleKeysPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Repository_simpleKeys_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Repository_simpleKeys_feature", "_UI_Repository_type"),
				 CenrepPackage.Literals.REPOSITORY__SIMPLE_KEYS,
				 false,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Bitmask Keys feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBitmaskKeysPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Repository_bitmaskKeys_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Repository_bitmaskKeys_feature", "_UI_Repository_type"),
				 CenrepPackage.Literals.REPOSITORY__BITMASK_KEYS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Range Key feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRangeKeyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Repository_rangeKey_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Repository_rangeKey_feature", "_UI_Repository_type"),
				 CenrepPackage.Literals.REPOSITORY__RANGE_KEY,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the File Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFileNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Repository_fileName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Repository_fileName_feature", "_UI_Repository_type"),
				 CenrepPackage.Literals.REPOSITORY__FILE_NAME,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Problems feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addProblemsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Repository_problems_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Repository_problems_feature", "_UI_Repository_type"),
				 CenrepPackage.Literals.REPOSITORY__PROBLEMS,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Read Access feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addReadAccessPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_IAccessable_readAccess_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_IAccessable_readAccess_feature", "_UI_IAccessable_type"),
				 CenrepPackage.Literals.IACCESSABLE__READ_ACCESS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Write Access feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addWriteAccessPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_IAccessable_writeAccess_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_IAccessable_writeAccess_feature", "_UI_IAccessable_type"),
				 CenrepPackage.Literals.IACCESSABLE__WRITE_ACCESS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the GAccess feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addGAccessPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_IAccessable_gAccess_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_IAccessable_gAccess_feature", "_UI_IAccessable_type"),
				 CenrepPackage.Literals.IACCESSABLE__GACCESS,
				 false,
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
			childrenFeatures.add(CenrepPackage.Literals.IACCESSABLE__ACCESS);
			childrenFeatures.add(CenrepPackage.Literals.REPOSITORY__KEY);
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
	 * This returns Repository.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		//return overlayImage(object, getResourceLocator().getImage("full/obj16/Repository"));
		switch (MarkerManager.getInstance().getProblemStatus(object)) {
	      case IStatus.ERROR:
	    	  return repositoryImageError;
	      case IStatus.WARNING:
	    	  return repositoryImageWarning;
	      default:
	    	  return repositoryImageNormal;
	    }
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Repository)object).getId();
		return label == null || label.length() == 0 ?
			getString("_UI_Repository_type") :
			getString("_UI_Repository_type") + " " + label;
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

		switch (notification.getFeatureID(Repository.class)) {
			case CenrepPackage.REPOSITORY__GACCESS:
			case CenrepPackage.REPOSITORY__BACKUP:
			case CenrepPackage.REPOSITORY__VERSION:
			case CenrepPackage.REPOSITORY__UID_NAME:
			case CenrepPackage.REPOSITORY__UID_VALUE:
			case CenrepPackage.REPOSITORY__INITIALISATION_FILE_VERSION:
			case CenrepPackage.REPOSITORY__OWNER:
			case CenrepPackage.REPOSITORY__RFS:
			case CenrepPackage.REPOSITORY__FILE_NAME:
			case CenrepPackage.REPOSITORY__PROBLEMS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case CenrepPackage.REPOSITORY__ACCESS:
			case CenrepPackage.REPOSITORY__KEY:
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
				(CenrepPackage.Literals.IACCESSABLE__ACCESS,
				 CenrepFactory.eINSTANCE.createAccess()));

		newChildDescriptors.add
			(createChildParameter
				(CenrepPackage.Literals.REPOSITORY__KEY,
				 CenrepFactory.eINSTANCE.createKey()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return CRPluginModelEditPlugin.INSTANCE;
	}

}
