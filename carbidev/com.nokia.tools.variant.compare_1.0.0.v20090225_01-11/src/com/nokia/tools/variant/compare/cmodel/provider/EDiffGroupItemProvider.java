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
 * Description: This file is part of com.nokia.tools.variant.compare component.
 */

package com.nokia.tools.variant.compare.cmodel.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemColorProvider;
import org.eclipse.emf.edit.provider.IItemFontProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITableItemColorProvider;
import org.eclipse.emf.edit.provider.ITableItemFontProvider;
import org.eclipse.emf.edit.provider.ITableItemLabelProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import com.nokia.tools.variant.compare.CompareModelPlugin;
import com.nokia.tools.variant.compare.cmodel.ECompareModelFactory;
import com.nokia.tools.variant.compare.cmodel.ECompareModelPackage;
import com.nokia.tools.variant.compare.cmodel.EDiffGroup;
import com.nokia.tools.variant.compare.cmodel.EDiffSetting;

/**
 * This is the item provider adapter for a
 * {@link com.nokia.tools.variant.compare.cmodel.EDiffGroup} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class EDiffGroupItemProvider extends ItemProviderAdapter implements
		IEditingDomainItemProvider, IStructuredItemContentProvider,
		ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource,
		ITableItemLabelProvider, ITableItemColorProvider,
		ITableItemFontProvider, IItemColorProvider, IItemFontProvider,
		IItemCheckEnabledProvider {
	/**
	 * This constructs an instance from a factory and a notifier. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EDiffGroupItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addExistsInSourcePropertyDescriptor(object);
			addExistsInTargetPropertyDescriptor(object);
			addSourceObjectPropertyDescriptor(object);
			addTargetObjectPropertyDescriptor(object);
			addNamePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Exists In Source feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addExistsInSourcePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory)
								.getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_ECompareElement_existsInSource_feature"),
						getString("_UI_PropertyDescriptor_description",
								"_UI_ECompareElement_existsInSource_feature",
								"_UI_ECompareElement_type"),
						ECompareModelPackage.Literals.ECOMPARE_ELEMENT__EXISTS_IN_SOURCE,
						true, false, false,
						ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Exists In Target feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addExistsInTargetPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory)
								.getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_ECompareElement_existsInTarget_feature"),
						getString("_UI_PropertyDescriptor_description",
								"_UI_ECompareElement_existsInTarget_feature",
								"_UI_ECompareElement_type"),
						ECompareModelPackage.Literals.ECOMPARE_ELEMENT__EXISTS_IN_TARGET,
						true, false, false,
						ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Source Object feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addSourceObjectPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_ECompareElement_sourceObject_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_ECompareElement_sourceObject_feature",
						"_UI_ECompareElement_type"),
				ECompareModelPackage.Literals.ECOMPARE_ELEMENT__SOURCE_OBJECT,
				true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Target Object feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addTargetObjectPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_ECompareElement_targetObject_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_ECompareElement_targetObject_feature",
						"_UI_ECompareElement_type"),
				ECompareModelPackage.Literals.ECOMPARE_ELEMENT__TARGET_OBJECT,
				true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Name feature. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_EDiffGroup_name_feature"), getString(
						"_UI_PropertyDescriptor_description",
						"_UI_EDiffGroup_name_feature", "_UI_EDiffGroup_type"),
				ECompareModelPackage.Literals.EDIFF_GROUP__NAME, true, false,
				false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to
	 * deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand},
	 * {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in
	 * {@link #createCommand}. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(
			Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures
					.add(ECompareModelPackage.Literals.EGROUP_CONTAINER__GROUPS);
			childrenFeatures
					.add(ECompareModelPackage.Literals.EDIFF_SETTING_CONTAINER__SETTINGS);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper
		// feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns EDiffGroup.gif. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage(
				"full/obj16/EDiffGroup"));
	}

	@Override
	public Object getColumnImage(Object object, int columnIndex) {
		// EDiffGroup obj = (EDiffGroup)object;

		if (columnIndex == 0) {
			return getImage(object);
		}
		// if (columnIndex == 2) {
		// return obj.isExistsInTarget() && obj.isExistsInSource() ? null :
		// getResourceLocator().getImage("full/obj16/warning_obj.gif");
		// }

		return null;
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 */
	@Override
	public String getText(Object object) {
		String label = ((EDiffGroup) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_EGroup_type")
				: label;
	}

	@Override
	public String getColumnText(Object object, int columnIndex) {
		if (columnIndex == 0) {
			return getText(object);
		}
		return super.getColumnText(object, columnIndex);
	}

	@Override
	public Object getForeground(Object object, int columnIndex) {
		// EDiffGroup obj = (EDiffGroup)object;
		//		
		// return obj.isExistsInTarget() && obj.isExistsInSource() ? null :
		// URI.createURI("color://rgb/255/0/0") ;
		return null;
	}

	@Override
	public Object getBackground(Object object, int columnIndex) {
		// EDiffGroup obj = (EDiffGroup)object;
		// return obj.isExistsInTarget() && obj.isExistsInSource() ? null :
		// URI.createURI("color://rgb/255/240/240") ;

		return null;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to
	 * update any cached children and by creating a viewer notification, which
	 * it passes to {@link #fireNotifyChanged}. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(EDiffGroup.class)) {
		case ECompareModelPackage.EDIFF_GROUP__EXISTS_IN_SOURCE:
		case ECompareModelPackage.EDIFF_GROUP__EXISTS_IN_TARGET:
		case ECompareModelPackage.EDIFF_GROUP__NAME:
			fireNotifyChanged(new ViewerNotification(notification, notification
					.getNotifier(), false, true));
			return;
		case ECompareModelPackage.EDIFF_GROUP__GROUPS:
		case ECompareModelPackage.EDIFF_GROUP__SETTINGS:
			fireNotifyChanged(new ViewerNotification(notification, notification
					.getNotifier(), true, false));
			return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s
	 * describing the children that can be created under this object. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(
			Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add(createChildParameter(
				ECompareModelPackage.Literals.EGROUP_CONTAINER__GROUPS,
				ECompareModelFactory.eINSTANCE.createEDiffGroup()));

		newChildDescriptors
				.add(createChildParameter(
						ECompareModelPackage.Literals.EDIFF_SETTING_CONTAINER__SETTINGS,
						ECompareModelFactory.eINSTANCE.createEDiffSimple()));

		newChildDescriptors
				.add(createChildParameter(
						ECompareModelPackage.Literals.EDIFF_SETTING_CONTAINER__SETTINGS,
						ECompareModelFactory.eINSTANCE.createEDiffSequence()));

		newChildDescriptors
				.add(createChildParameter(
						ECompareModelPackage.Literals.EDIFF_SETTING_CONTAINER__SETTINGS,
						ECompareModelFactory.eINSTANCE
								.createEDiffResourceSetting2()));

		newChildDescriptors
				.add(createChildParameter(
						ECompareModelPackage.Literals.EDIFF_SETTING_CONTAINER__SETTINGS,
						ECompareModelFactory.eINSTANCE
								.createEDiffLocalPathSetting()));

		newChildDescriptors
				.add(createChildParameter(
						ECompareModelPackage.Literals.EDIFF_SETTING_CONTAINER__SETTINGS,
						ECompareModelFactory.eINSTANCE.createEDiffMismatch()));
	}

	/**
	 * Return the resource locator for this item provider's resources. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return CompareModelPlugin.INSTANCE;
	}

	public boolean isCheckEnabled(Object object) {
		if(object instanceof EDiffGroup){
			EDiffGroup group = (EDiffGroup)object;
			EList<EDiffSetting> settings = group.getSettings();
			for (EDiffSetting diffSetting : settings) {
				
				if(diffSetting.isExistsInSource() && diffSetting.isExistsInTarget()){
					return true;
				}
			}
			EList<EDiffGroup> groups = group.getGroups();
			for (EDiffGroup diffGroup : groups) {
				EList<EDiffSetting> settings2 = diffGroup.getSettings();
				for (EDiffSetting diffSetting : settings2) {
					if(diffSetting.isExistsInSource() && diffSetting.isExistsInTarget()){
						return true;
					}
				}
			}
		}
		return false;
	}

	public boolean isChecked(Object object) {
	
		return false;
	}

	public boolean setChecked(Object object, boolean checked) {
		
		return false;
	}

	



}
