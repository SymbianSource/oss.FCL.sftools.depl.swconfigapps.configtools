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

import configurationemf.ConfigurationemfFactory;
import configurationemf.ConfigurationemfPackage;
import configurationemf.Setting;

/**
 * This is the item provider adapter for a {@link configurationemf.Setting} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SettingItemProvider
	extends ReferableItemProvider
	implements	
		IEditingDomainItemProvider, 
		IStructuredItemContentProvider, 
		ITreeItemContentProvider, 
		IItemLabelProvider, 
		IItemPropertySource{
	
	
	
	public static final String TYPE_INT = "int";
	public static final int INDEX_INT=0;
	public static final String TYPE_STRING = "string";
	public static final int INDEX_STRING=1;
	public static final String TYPE_FILE = "file";
	public static final int INDEX_FILE=2;
	public static final String TYPE_SELECTION = "selection";
	public static final int INDEX_SELECTION=3;
	public static final String TYPE_BOOLEAN = "boolean";
	public static final int INDEX_BOOLEAN=4;
	public static final String TYPE_SEQUENCE = "sequence";
	public static final int INDEX_SEQUENCE=5;
	final String[] TYPES = new String[]{TYPE_INT,
										TYPE_STRING,
		   								TYPE_FILE,
		   								TYPE_SELECTION,
		   								TYPE_BOOLEAN,
		   								TYPE_SEQUENCE};
	
	
	public static final int  SETTING_REQUIRED = 9;
	public static final int  SETTING_RELEVANT = 8;
	public static final int  SETTING_CONSTRAINT = 7;
	public static final int  SETTING_READ_ONLY = 5;
	public static final int  SETTING_REF = 4;
	public static final int  SETTING_FEATURE = 6;
	public static final int  SETTING_VALUE = 3;
	public static final int  SETTING_DEFAULT_VALUE = 2;
	public static final int  SETTING_TYPE = 1;
	//	setting editor column order
	public static final int  SETTING_NAME = 0;

	private static final String CATEGORY_VALUE ="Values";
	private static final String CATEGORY_SETTING ="Setting";
	
	public Collection getElements(Object object) {
		List result = (List)super.getElements(object); 
		return result;
	}

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SettingItemProvider(AdapterFactory adapterFactory) {
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
			addTypePropertyDescriptor(object);
			addConstraintPropertyDescriptor(object);
			addRelevantPropertyDescriptor(object);
			addReadOnlyPropertyDescriptor(object);
			addRequiredPropertyDescriptor(object);
			addBoolOptionsPropertyDescriptor(object);
			addDefaultValuePropertyDescriptor(object);
			addCurrentValuePropertyDescriptor(object);
			addTopValuePropertyDescriptor(object);
			addCurrentConfPropertyDescriptor(object);
			addDefaultConfPropertyDescriptor(object);
			addRoPropertyDescriptor(object);
			addPossibleValuePropertyDescriptor(object);
			addCurrentTypePropertyDescriptor(object);
			addValueChangeblePropertyDescriptor(object);
			addRfsPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}
	/*
	 * (non-Javadoc)
	 * @see configurationemf.ICellEditorProvider#getComboItems(java.lang.Object, int)
	 */
	
	
	
	
	
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
				 getString("_UI_Setting_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Setting_name_feature", "_UI_Setting_type"),
				 ConfigurationemfPackage.Literals.SETTING__NAME,
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
				 getString("_UI_Setting_type_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Setting_type_feature", "_UI_Setting_type"),
				 ConfigurationemfPackage.Literals.SETTING__TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	

	/**
	 * This adds a property descriptor for the Constraint feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addConstraintPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Setting_constraint_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Setting_constraint_feature", "_UI_Setting_type"),
				 ConfigurationemfPackage.Literals.SETTING__CONSTRAINT,
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
	 * @generated
	 */
	protected void addRelevantPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Setting_relevant_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Setting_relevant_feature", "_UI_Setting_type"),
				 ConfigurationemfPackage.Literals.SETTING__RELEVANT,
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
				 getString("_UI_Setting_readOnly_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Setting_readOnly_feature", "_UI_Setting_type"),
				 ConfigurationemfPackage.Literals.SETTING__READ_ONLY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Required feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addRequiredPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Setting_required_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Setting_required_feature", "_UI_Setting_type"),
				 ConfigurationemfPackage.Literals.SETTING__REQUIRED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 CATEGORY_SETTING,
				 null));
	}

	

	/**
	 * This adds a property descriptor for the Bool Options feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBoolOptionsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Setting_boolOptions_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Setting_boolOptions_feature", "_UI_Setting_type"),
				 ConfigurationemfPackage.Literals.SETTING__BOOL_OPTIONS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Default Value feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addDefaultValuePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Setting_defaultValue_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Setting_defaultValue_feature", "_UI_Setting_type"),
				 ConfigurationemfPackage.Literals.SETTING__DEFAULT_VALUE,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 CATEGORY_VALUE,
				 null));
	}

	/**
	 * This adds a property descriptor for the Current Value feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addCurrentValuePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Setting_currentValue_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Setting_currentValue_feature", "_UI_Setting_type"),
				 ConfigurationemfPackage.Literals.SETTING__CURRENT_VALUE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 CATEGORY_VALUE,
				 null));
	}

	/**
	 * This adds a property descriptor for the Top Value feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addTopValuePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Setting_topValue_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Setting_topValue_feature", "_UI_Setting_type"),
				 ConfigurationemfPackage.Literals.SETTING__TOP_VALUE,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 CATEGORY_VALUE,
				 null));
	}

	/**
	 * This adds a property descriptor for the Current Conf feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCurrentConfPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Setting_currentConf_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Setting_currentConf_feature", "_UI_Setting_type"),
				 ConfigurationemfPackage.Literals.SETTING__CURRENT_CONF,
				 false,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Default Conf feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDefaultConfPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Setting_defaultConf_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Setting_defaultConf_feature", "_UI_Setting_type"),
				 ConfigurationemfPackage.Literals.SETTING__DEFAULT_CONF,
				 false,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Ro feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRoPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Setting_ro_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Setting_ro_feature", "_UI_Setting_type"),
				 ConfigurationemfPackage.Literals.SETTING__RO,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Possible Value feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPossibleValuePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Setting_possibleValue_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Setting_possibleValue_feature", "_UI_Setting_type"),
				 ConfigurationemfPackage.Literals.SETTING__POSSIBLE_VALUE,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Current Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCurrentTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Setting_currentType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Setting_currentType_feature", "_UI_Setting_type"),
				 ConfigurationemfPackage.Literals.SETTING__CURRENT_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Value Changeble feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addValueChangeblePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Setting_valueChangeble_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Setting_valueChangeble_feature", "_UI_Setting_type"),
				 ConfigurationemfPackage.Literals.SETTING__VALUE_CHANGEBLE,
				 false,
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
				 getString("_UI_Setting_rfs_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Setting_rfs_feature", "_UI_Setting_type"),
				 ConfigurationemfPackage.Literals.SETTING__RFS,
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
	 * @generated NOT
	 */
	public Collection getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
//			childrenFeatures.add(ConfigurationemfPackage.Literals.SETTING__OPTION);
//			childrenFeatures.add(ConfigurationemfPackage.Literals.SETTING__BOOL_OPTIONS);
			/*childrenFeatures.add(ConfigurationemfPackage.Literals.SETTING__PROPERTY);
			childrenFeatures.add(ConfigurationemfPackage.Literals.SETTING__MIN_LENGTH);
			childrenFeatures.add(ConfigurationemfPackage.Literals.SETTING__MAX_LENGTH);
			childrenFeatures.add(ConfigurationemfPackage.Literals.SETTING__LENGTH);
			childrenFeatures.add(ConfigurationemfPackage.Literals.SETTING__MAX_INCLUSIVE);
			childrenFeatures.add(ConfigurationemfPackage.Literals.SETTING__MAX_EXCLUSIVE);
			childrenFeatures.add(ConfigurationemfPackage.Literals.SETTING__MIN_EXCLUSIVE);
			childrenFeatures.add(ConfigurationemfPackage.Literals.SETTING__PATTERN);
			childrenFeatures.add(ConfigurationemfPackage.Literals.SETTING__MIN_INCLUSIVE);
			childrenFeatures.add(ConfigurationemfPackage.Literals.SETTING__TOTAL_DIGITS);
			childrenFeatures.add(ConfigurationemfPackage.Literals.SETTING__LINK);
			childrenFeatures.add(ConfigurationemfPackage.Literals.SETTING__ICON);*/
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
	 * 
	 */
	public String getText(Object object) {
		String label = ((Setting)object).getName();
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

		switch (notification.getFeatureID(Setting.class)) {
			case ConfigurationemfPackage.SETTING__NAME:
			case ConfigurationemfPackage.SETTING__TYPE:
			case ConfigurationemfPackage.SETTING__CONSTRAINT:
			case ConfigurationemfPackage.SETTING__RELEVANT:
			case ConfigurationemfPackage.SETTING__READ_ONLY:
			case ConfigurationemfPackage.SETTING__REQUIRED:
			case ConfigurationemfPackage.SETTING__DEFAULT_VALUE:
			case ConfigurationemfPackage.SETTING__CURRENT_VALUE:
			case ConfigurationemfPackage.SETTING__TOP_VALUE:
			case ConfigurationemfPackage.SETTING__RO:
			case ConfigurationemfPackage.SETTING__POSSIBLE_VALUE:
			case ConfigurationemfPackage.SETTING__CURRENT_TYPE:
			case ConfigurationemfPackage.SETTING__VALUE_CHANGEBLE:
			case ConfigurationemfPackage.SETTING__RFS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case ConfigurationemfPackage.SETTING__OPTION:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, true));
				return;
			case ConfigurationemfPackage.SETTING__PROPERTY:
			case ConfigurationemfPackage.SETTING__MIN_LENGTH:
			case ConfigurationemfPackage.SETTING__MAX_LENGTH:
			case ConfigurationemfPackage.SETTING__LENGTH:
			case ConfigurationemfPackage.SETTING__MAX_INCLUSIVE:
			case ConfigurationemfPackage.SETTING__MAX_EXCLUSIVE:
			case ConfigurationemfPackage.SETTING__MIN_EXCLUSIVE:
			case ConfigurationemfPackage.SETTING__PATTERN:
			case ConfigurationemfPackage.SETTING__MIN_INCLUSIVE:
			case ConfigurationemfPackage.SETTING__TOTAL_DIGITS:
			case ConfigurationemfPackage.SETTING__LINK:
			case ConfigurationemfPackage.SETTING__ICON:
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
				(ConfigurationemfPackage.Literals.SETTING__OPTION,
				 ConfigurationemfFactory.eINSTANCE.createOption()));

		newChildDescriptors.add
			(createChildParameter
				(ConfigurationemfPackage.Literals.SETTING__PROPERTY,
				 ConfigurationemfFactory.eINSTANCE.createProperty()));

		newChildDescriptors.add
			(createChildParameter
				(ConfigurationemfPackage.Literals.SETTING__MIN_LENGTH,
				 ConfigurationemfFactory.eINSTANCE.createMinLength()));

		newChildDescriptors.add
			(createChildParameter
				(ConfigurationemfPackage.Literals.SETTING__MAX_LENGTH,
				 ConfigurationemfFactory.eINSTANCE.createMaxLength()));

		newChildDescriptors.add
			(createChildParameter
				(ConfigurationemfPackage.Literals.SETTING__LENGTH,
				 ConfigurationemfFactory.eINSTANCE.createLength()));

		newChildDescriptors.add
			(createChildParameter
				(ConfigurationemfPackage.Literals.SETTING__MAX_INCLUSIVE,
				 ConfigurationemfFactory.eINSTANCE.createMaxInclusive()));

		newChildDescriptors.add
			(createChildParameter
				(ConfigurationemfPackage.Literals.SETTING__MAX_EXCLUSIVE,
				 ConfigurationemfFactory.eINSTANCE.createMaxExclusive()));

		newChildDescriptors.add
			(createChildParameter
				(ConfigurationemfPackage.Literals.SETTING__MIN_EXCLUSIVE,
				 ConfigurationemfFactory.eINSTANCE.createMinExclusive()));

		newChildDescriptors.add
			(createChildParameter
				(ConfigurationemfPackage.Literals.SETTING__PATTERN,
				 ConfigurationemfFactory.eINSTANCE.createPattern()));

		newChildDescriptors.add
			(createChildParameter
				(ConfigurationemfPackage.Literals.SETTING__MIN_INCLUSIVE,
				 ConfigurationemfFactory.eINSTANCE.createMinInclusive()));

		newChildDescriptors.add
			(createChildParameter
				(ConfigurationemfPackage.Literals.SETTING__TOTAL_DIGITS,
				 ConfigurationemfFactory.eINSTANCE.createTotalDigits()));

		newChildDescriptors.add
			(createChildParameter
				(ConfigurationemfPackage.Literals.SETTING__LINK,
				 ConfigurationemfFactory.eINSTANCE.createLink()));

		newChildDescriptors.add
			(createChildParameter
				(ConfigurationemfPackage.Literals.SETTING__ICON,
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
