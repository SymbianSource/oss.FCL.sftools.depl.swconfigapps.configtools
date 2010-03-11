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
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
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
import com.nokia.tools.variant.compare.cmodel.EDiffSequence;
import com.nokia.tools.variant.compare.cmodel.EDiffSequenceItem;

/**
 * This is the item provider adapter for a
 * {@link com.nokia.tools.variant.compare.cmodel.EDiffSequenceItem} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class EDiffSequenceItemItemProvider extends ItemProviderAdapter
		implements IEditingDomainItemProvider, IStructuredItemContentProvider,
		ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource,
		ITableItemLabelProvider, ITableItemColorProvider,
		ITableItemFontProvider, IItemColorProvider, IItemFontProvider,
		ITableItemAnnotationProvider {
	/**
	 * This constructs an instance from a factory and a notifier. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EDiffSequenceItemItemProvider(AdapterFactory adapterFactory) {
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
	 * This returns EDiffSequenceItem.gif. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage(
				"full/obj16/EDiffSequence"));
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		EDiffSequenceItem eDiffSequenceItem = (EDiffSequenceItem) object;
		return getString("_UI_EDiffSequenceItem_type") + " "
				+ eDiffSequenceItem.isExistsInSource();
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

		switch (notification.getFeatureID(EDiffSequenceItem.class)) {
		case ECompareModelPackage.EDIFF_SEQUENCE_ITEM__EXISTS_IN_SOURCE:
		case ECompareModelPackage.EDIFF_SEQUENCE_ITEM__EXISTS_IN_TARGET:
			fireNotifyChanged(new ViewerNotification(notification, notification
					.getNotifier(), false, true));
			return;
		case ECompareModelPackage.EDIFF_SEQUENCE_ITEM__SETTINGS:
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
	 * @generated NOT
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return CompareModelPlugin.INSTANCE;
	}

	@Override
	public String getColumnText(Object object, int columnIndex) {
		if (object instanceof EDiffSequenceItem && columnIndex == 0) {
			EDiffSequenceItem item = (EDiffSequenceItem) object;
			EObject container = item.eContainer();
			if (container instanceof EDiffSequence) {
				return ((EDiffSequence) container).getName();
			}
		}
		return super.getColumnText(object, columnIndex);
	}

	@Override
	public Object getColumnImage(Object object, int columnIndex) {
		if (object instanceof EDiffSequenceItem && columnIndex == 0) {
			return getImage(object);
		}
		return super.getColumnImage(object, columnIndex);
	}

	public String getAnnotationText(Object object, int columnIndex) {
		EDiffSequenceItem obj = (EDiffSequenceItem) object;

		if (columnIndex == 1) {

			if (obj.getSourceObject() == null) {
				return "[undefined]";
			}
		}
		if (columnIndex == 3) {

			if (obj.getTargetObject() == null) {
				return "[undefined]";
			}
		}

		return null;
	}

	public Object getAnnotationFont(Object object, int columnIndex) {

		return URI.createURI("font:////normal");
	}

	public Object getAnnotationForeground(Object object, int columnIndex) {

		return GRAYED_OUT_COLOR;
	}

}
