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

import com.nokia.tools.variant.compare.cmodel.ECompareModelPackage;
import com.nokia.tools.variant.compare.cmodel.EDiffSimple;

/**
 * This is the item provider adapter for a
 * {@link com.nokia.tools.variant.compare.cmodel.EDiffSimple} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 */
public class EDiffSimpleItemProvider extends EDiffSettingItemProvider implements
		IEditingDomainItemProvider, IStructuredItemContentProvider,
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
	public EDiffSimpleItemProvider(AdapterFactory adapterFactory) {
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

			addSourceValuePropertyDescriptor(object);
			addTargetValuePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Source Value feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addSourceValuePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EDiffSimple_sourceValue_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EDiffSimple_sourceValue_feature", "_UI_EDiffSimple_type"),
				 ECompareModelPackage.Literals.EDIFF_SIMPLE__SOURCE_VALUE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Target Value feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addTargetValuePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EDiffSimple_targetValue_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EDiffSimple_targetValue_feature", "_UI_EDiffSimple_type"),
				 ECompareModelPackage.Literals.EDIFF_SIMPLE__TARGET_VALUE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns EDiffSimple.gif. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/EDiffSimple"));
	}

	@Override
	public Object getColumnImage(Object object, int columnIndex) {
		EDiffSimple obj = (EDiffSimple) object;

		if (columnIndex == 2) {
			if (obj.isExistsInSource() && obj.isExistsInTarget()) {
				if (obj.isSourceDefault() && obj.isTargetDefault()) {
					return null;
				}
				if (!obj.isSourceDefault() && obj.isTargetDefault()) {
					return null;
				}
			}
		}
		return super.getColumnImage(object, columnIndex);
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 */
	@Override
	public String getText(Object object) {
		String label = ((EDiffSimple) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_ESimpleSetting_type")
				: label;
	}

	@Override
	public Object getFont(Object object, int columnIndex) {
		// EDiffSimple obj = (EDiffSimple) object;
		//
		// if (columnIndex == 1) {
		// return obj.isSourceDefault() ? ITALIC_FONT : NORMAL_FONT;
		// }
		// if (columnIndex == 3) {
		// return obj.isTargetDefault() ? ITALIC_FONT : NORMAL_FONT;
		// }
		//
		return super.getFont(object, columnIndex);
	}

	@Override
	public Object getBackground(Object object, int columnIndex) {
		EDiffSimple obj = (EDiffSimple) object;

		if (obj.isExistsInSource() && obj.isExistsInTarget()) {
			if (columnIndex == 1 && obj.isChecked()) {
				return URI.createURI("color://rgb/255/255/200");
			}
			if (columnIndex == 3 && !obj.isChecked()) {
				return URI.createURI("color://rgb/255/255/200");
			}
		}

		return super.getBackground(object, columnIndex);
	}

	@Override
	public String getTooltip(Object object, int columnIndex) {
		EDiffSimple obj = (EDiffSimple) object;
		if (obj.isExistsInSource() && obj.isExistsInTarget()) {
			if (columnIndex == 1) {
				if (!obj.isSourceDefault() && obj.isTargetDefault()) {
					return "This choice is recommended";
				}
			}
			if (columnIndex == 3) {
				// if (!obj.isTargetDefault() && obj.isSourceDefault()) {
				// return URI.createURI("color://rgb/255/255/200");
				// }
				if (obj.isTargetDefault() && obj.isSourceDefault()) {
					return "This choice is recommended";
				}
			}
		}
		
		return super.getTooltip(object, columnIndex);
	}

	@Override
	public String getColumnText(Object object, int columnIndex) {
		EDiffSimple obj = (EDiffSimple) object;

		if (columnIndex == 1) {
			return obj.getSourceValue();
		}
		if (columnIndex == 3) {
			return obj.getTargetValue();
		}

		
		return super.getColumnText(object, columnIndex);
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(EDiffSimple.class)) {
			case ECompareModelPackage.EDIFF_SIMPLE__SOURCE_VALUE:
			case ECompareModelPackage.EDIFF_SIMPLE__TARGET_VALUE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
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

}
