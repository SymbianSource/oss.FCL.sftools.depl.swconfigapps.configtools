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


import helpers.MarkerManager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
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

import cenrep.Bit;
import cenrep.CenrepFactory;
import cenrep.CenrepPackage;
import cenrep.Key;

/**
 * This is the item provider adapter for a {@link cenrep.Key} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class KeyItemProvider
	extends AttributeAndDescriptionItemProvider
	implements	
		IEditingDomainItemProvider,	
		IStructuredItemContentProvider,	
		ITreeItemContentProvider,	
		IItemLabelProvider,	
		IItemPropertySource {
	
	private Object keyImageNormal = null;
	private Object keyImageError = null;
	private Object keyImageWarning = null;
	private Object bitImageNormal = null;
	private Object bitImageError = null;
	private Object bitImageWarning = null;
	
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KeyItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
		// Create icons
		keyImageNormal = getResourceLocator().getImage("full/obj16/Key");
		bitImageNormal = getResourceLocator().getImage("full/obj16/BitmaskKey");
		List<Object> images = new ArrayList<Object>(2);
		images.add(keyImageNormal);
		images.add(getResourceLocator().getImage("full/ovr16/error_co"));
	    keyImageError = new ComposedImage(images);
	    images.clear();
	    images.add(keyImageNormal);
	    images.add(getResourceLocator().getImage("full/ovr16/warning_co"));
	    keyImageWarning = new ComposedImage(images);
	    images.clear();
	    images.add(bitImageNormal);
	    images.add(getResourceLocator().getImage("full/ovr16/warning_co"));
	    bitImageWarning = new ComposedImage(images);
	    images.clear();
	    images.add(bitImageNormal);
	    images.add(getResourceLocator().getImage("full/ovr16/error_co"));
	    bitImageError = new ComposedImage(images);
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
			addGvaluePropertyDescriptor(object);
			addRfsPropertyDescriptor(object);
			addReadOnlyPropertyDescriptor(object);
			addReadAccessPropertyDescriptor(object);
			addWriteAccessPropertyDescriptor(object);
			addGAccessPropertyDescriptor(object);
			addBackupPropertyDescriptor(object);
			addNamePropertyDescriptor(object);
			addIdentPropertyDescriptor(object);
			addTypePropertyDescriptor(object);
			addBitsPropertyDescriptor(object);
			addBitmaskKeyPropertyDescriptor(object);
			addSimpleKeyPropertyDescriptor(object);
			addShortIdentPropertyDescriptor(object);
			addStrTypePropertyDescriptor(object);
			addDecFormatPropertyDescriptor(object);
			addHexFormatPropertyDescriptor(object);
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
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RVG_ref_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RVG_ref_feature", "_UI_RVG_type"),
				 CenrepPackage.Literals.RVG__REF,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Gvalue feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addGvaluePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RVG_gvalue_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RVG_gvalue_feature", "_UI_RVG_type"),
				 CenrepPackage.Literals.RVG__GVALUE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
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
				 getString("_UI_Key_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Key_name_feature", "_UI_Key_type"),
				 CenrepPackage.Literals.KEY__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Ident feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIdentPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Key_ident_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Key_ident_feature", "_UI_Key_type"),
				 CenrepPackage.Literals.KEY__IDENT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Key_type_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Key_type_feature", "_UI_Key_type"),
				 CenrepPackage.Literals.KEY__TYPE,
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
				 getString("_UI_IReadOnly_readOnly_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_IReadOnly_readOnly_feature", "_UI_IReadOnly_type"),
				 CenrepPackage.Literals.IREAD_ONLY__READ_ONLY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
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
	 * This adds a property descriptor for the Bits feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBitsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Key_bits_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Key_bits_feature", "_UI_Key_type"),
				 CenrepPackage.Literals.KEY__BITS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Bitmask Key feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBitmaskKeyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Key_bitmaskKey_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Key_bitmaskKey_feature", "_UI_Key_type"),
				 CenrepPackage.Literals.KEY__BITMASK_KEY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Simple Key feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSimpleKeyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Key_simpleKey_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Key_simpleKey_feature", "_UI_Key_type"),
				 CenrepPackage.Literals.KEY__SIMPLE_KEY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Short Ident feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addShortIdentPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Key_shortIdent_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Key_shortIdent_feature", "_UI_Key_type"),
				 CenrepPackage.Literals.KEY__SHORT_IDENT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Str Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStrTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Key_strType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Key_strType_feature", "_UI_Key_type"),
				 CenrepPackage.Literals.KEY__STR_TYPE,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Dec Format feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDecFormatPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Key_decFormat_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Key_decFormat_feature", "_UI_Key_type"),
				 CenrepPackage.Literals.KEY__DEC_FORMAT,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Hex Format feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addHexFormatPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Key_hexFormat_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Key_hexFormat_feature", "_UI_Key_type"),
				 CenrepPackage.Literals.KEY__HEX_FORMAT,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
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
				 getString("_UI_RVG_rfs_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RVG_rfs_feature", "_UI_RVG_type"),
				 CenrepPackage.Literals.RVG__RFS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
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
			childrenFeatures.add(CenrepPackage.Literals.KEY__VALUE);
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
	 * This returns Key.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @NOT generated
	 */
	@Override
	public Object getImage(Object object)
	{ 
	    Key key = (Key) object; 
	    List<Bit> bits = key.getBits(); 
	    if (bits.size() == 0) {
	    	switch (MarkerManager.getInstance().getProblemStatus(object)) {
		      case IStatus.ERROR:
		    	  return keyImageError;
		      case IStatus.WARNING:
		    	  return keyImageWarning;
		      default:
		    	  return keyImageNormal;
		    }
	    } else {
	    	switch (MarkerManager.getInstance().getProblemStatus(object)) {
	    	case IStatus.ERROR:
		    	  return bitImageError;
		      case IStatus.WARNING:
		    	  return bitImageWarning;
		      default:
		    	  return bitImageNormal;
		    }
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
		String label = ((Key)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Key_type") :
			getString("_UI_Key_type") + " " + label;
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

		switch (notification.getFeatureID(Key.class)) {
			case CenrepPackage.KEY__REF:
			case CenrepPackage.KEY__READ_ONLY:
			case CenrepPackage.KEY__GACCESS:
			case CenrepPackage.KEY__BACKUP:
			case CenrepPackage.KEY__NAME:
			case CenrepPackage.KEY__IDENT:
			case CenrepPackage.KEY__TYPE:
			case CenrepPackage.KEY__BITMASK_KEY:
			case CenrepPackage.KEY__SIMPLE_KEY:
			case CenrepPackage.KEY__SHORT_IDENT:
			case CenrepPackage.KEY__STR_TYPE:
			case CenrepPackage.KEY__DEC_FORMAT:
			case CenrepPackage.KEY__HEX_FORMAT:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case CenrepPackage.KEY__ACCESS:
			case CenrepPackage.KEY__VALUE:
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
				(CenrepPackage.Literals.KEY__VALUE,
				 CenrepFactory.eINSTANCE.createValue()));
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
