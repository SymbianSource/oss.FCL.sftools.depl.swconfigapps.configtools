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
import org.eclipse.emf.edit.provider.ViewerNotification;

import com.nokia.tools.variant.compare.CompareModelPlugin;
import com.nokia.tools.variant.compare.cmodel.ECompareModelPackage;
import com.nokia.tools.variant.compare.cmodel.EDiffSequenceItem;
import com.nokia.tools.variant.compare.cmodel.EDiffSetting;
import com.nokia.tools.variant.content.confml.SequenceItem;

/**
 * This is the item provider adapter for a
 * {@link com.nokia.tools.variant.compare.cmodel.EDiffSetting} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 */
public class EDiffSettingItemProvider extends ECompareElementItemProvider
		implements IEditingDomainItemProvider, IStructuredItemContentProvider,
		ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource,
		ITableItemLabelProvider, ITableItemColorProvider,
		ITableItemFontProvider, IItemColorProvider, IItemFontProvider,

		IItemCheckEnabledProvider, ITableItemAnnotationProvider {
	/**
	 * This constructs an instance from a factory and a notifier. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EDiffSettingItemProvider(AdapterFactory adapterFactory) {
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
			addCheckedPropertyDescriptor(object);
			addAbsRefPropertyDescriptor(object);
			addNamePropertyDescriptor(object);
			addSourceDefaultPropertyDescriptor(object);
			addTargetDefaultPropertyDescriptor(object);
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
	 * This adds a property descriptor for the Checked feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addCheckedPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_ECheckableElement_checked_feature"), getString(
						"_UI_PropertyDescriptor_description",
						"_UI_ECheckableElement_checked_feature",
						"_UI_ECheckableElement_type"),
				ECompareModelPackage.Literals.ECHECKABLE_ELEMENT__CHECKED,
				true, false, false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				null, null));
	}

	/**
	 * This adds a property descriptor for the Abs Ref feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addAbsRefPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_EDiffSetting_absRef_feature"), getString(
						"_UI_PropertyDescriptor_description",
						"_UI_EDiffSetting_absRef_feature",
						"_UI_EDiffSetting_type"),
				ECompareModelPackage.Literals.EDIFF_SETTING__ABS_REF, true,
				false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null,
				null));
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
				getString("_UI_EDiffSetting_name_feature"), getString(
						"_UI_PropertyDescriptor_description",
						"_UI_EDiffSetting_name_feature",
						"_UI_EDiffSetting_type"),
				ECompareModelPackage.Literals.EDIFF_SETTING__NAME, true, false,
				false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Source Default feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addSourceDefaultPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_EDiffSetting_sourceDefault_feature"), getString(
						"_UI_PropertyDescriptor_description",
						"_UI_EDiffSetting_sourceDefault_feature",
						"_UI_EDiffSetting_type"),
				ECompareModelPackage.Literals.EDIFF_SETTING__SOURCE_DEFAULT,
				true, false, false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				null, null));
	}

	/**
	 * This adds a property descriptor for the Target Default feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addTargetDefaultPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_EDiffSetting_targetDefault_feature"), getString(
						"_UI_PropertyDescriptor_description",
						"_UI_EDiffSetting_targetDefault_feature",
						"_UI_EDiffSetting_type"),
				ECompareModelPackage.Literals.EDIFF_SETTING__TARGET_DEFAULT,
				true, false, false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				null, null));
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 */
	@Override
	public String getText(Object object) {
		String label = ((EDiffSetting) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_ESettingRef_type")
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
		EDiffSetting obj = (EDiffSetting) object;

		if (obj.isExistsInSource() && obj.isExistsInTarget()) {
			return super.getForeground(object, columnIndex);
		} else {
			return URI.createURI("color://rgb/0/0/0");
		}

	}

	@Override
	public Object getColumnImage(Object object, int columnIndex) {
		EDiffSetting obj = (EDiffSetting) object;

		if (columnIndex == 0) {
			return getImage(object);
		}
		if (columnIndex == 2) {
			if (obj.isExistsInSource() && obj.isExistsInTarget()) {
				return getResourceLocator().getImage(
						"full/obj16/warning_obj.gif");
			} else if (!(obj.getSourceObject() != null
					&& (obj.getSourceObject().eContainer() instanceof SequenceItem) || obj
					.getTargetObject() != null
					&& (obj.getTargetObject().eContainer() instanceof SequenceItem))) {
				return getResourceLocator().getImage(
						"full/obj16/fatalerror_obj.gif");
			}

		}

		return super.getColumnImage(object, columnIndex);
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

		switch (notification.getFeatureID(EDiffSetting.class)) {
		case ECompareModelPackage.EDIFF_SETTING__EXISTS_IN_SOURCE:
		case ECompareModelPackage.EDIFF_SETTING__EXISTS_IN_TARGET:
		case ECompareModelPackage.EDIFF_SETTING__ABS_REF:
		case ECompareModelPackage.EDIFF_SETTING__NAME:
		case ECompareModelPackage.EDIFF_SETTING__SOURCE_DEFAULT:
		case ECompareModelPackage.EDIFF_SETTING__TARGET_DEFAULT:
			fireNotifyChanged(new ViewerNotification(notification, notification
					.getNotifier(), false, true));
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

	@Override
	public String getTooltip(Object object, int column) {
		if (column == 2) {
			EDiffSetting obj = (EDiffSetting) object;
			if (obj.isExistsInSource() && obj.isExistsInTarget()
					&& !obj.isTargetDefault()) {
				return "Conflicting Value";
			}
		}
		return super.getTooltip(object, column);
	}

	public boolean isCheckEnabled(Object object) {
		EDiffSetting obj = (EDiffSetting) object;

		return obj.isExistsInSource() && obj.isExistsInTarget();
	}

	public Object getAnnotationFont(Object object, int columnIndex) {
		return URI.createURI("font:////normal");
	}

	public String getAnnotationText(Object object, int columnIndex) {
		EDiffSetting obj = (EDiffSetting) object;
		if (obj.eContainer() instanceof EDiffSequenceItem) {
			return null;
		}
		if (columnIndex == 1) {
			if (obj.isExistsInSource() && obj.isSourceDefault()) {
				return "[default]";
			}
			if (!obj.isExistsInSource()) {
				return "[undefined]";
			}
		}
		if (columnIndex == 3) {
			if (obj.isExistsInTarget() && obj.isTargetDefault()) {
				return "[default]";
			}
			if (!obj.isExistsInTarget()) {
				return "[undefined]";
			}
		}

		return null;
	}

	protected String annotateText(String text, boolean isDefault) {
		if (text == null) {
			return isDefault ? "[missing,default]" : "[missing]";
		}

		return isDefault ? text + " [default]" : text;
	}

	public Object getAnnotationForeground(Object object, int columnIndex) {
		return GRAYED_OUT_COLOR;
	}
}
