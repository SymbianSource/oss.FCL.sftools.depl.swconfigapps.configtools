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
 * Description: This file is part of com.nokia.tools.vct.confml.editor.include component.
 */

package com.nokia.tools.vct.confml.editor.include.xincmodel.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemColorProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import com.nokia.tools.vct.confml.editor.include.XIncludeEditorPlugin;
import com.nokia.tools.vct.confml.editor.include.xincmodel.EInclude;
import com.nokia.tools.vct.confml.editor.include.xincmodel.EProjectFile;
import com.nokia.tools.vct.confml.editor.include.xincmodel.EXincModelPackage;
import com.nokia.tools.vct.confml.editor.include.xincmodel.command.LinkTargetFileCommand;
import com.nokia.tools.vct.confml.editor.include.xincmodel.util.EXincModelUtils;

/**
 * This is the item provider adapter for a {@link com.nokia.tools.vct.confml.editor.include.xincmodel.EInclude} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * @generated
 */
public class EIncludeItemProvider extends ItemProviderAdapter implements
		IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource, IItemColorProvider {
	/**
	 * This constructs an instance from a factory and a notifier. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EIncludeItemProvider(AdapterFactory adapterFactory) {
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

			addHrefPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Href feature.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addHrefPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EInclude_href_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EInclude_href_feature", "_UI_EInclude_type"),
				 EXincModelPackage.Literals.EINCLUDE__HREF,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns EInclude.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public Object getImage(Object object) {
		EInclude obj = (EInclude) object;
		if (obj.getTarget() != null) {
			switch (obj.getTarget().getVersion()) {
			case CONFML1:
				return overlayImage(object, getResourceLocator().getImage(
						"full/obj16/EIncludeConfML1"));
			case CONFML2:
				return overlayImage(object, getResourceLocator().getImage(
						"full/obj16/EIncludeConfML2"));
			}
		}

		return overlayImage(object, getResourceLocator().getImage(
				"full/obj16/EIncludeMissing"));
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		String label = ((EInclude) object).getHref();
		return label == null || label.length() == 0 ? getString("_UI_EInclude_type")
				: label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to
	 * update any cached children and by creating a viewer notification, which
	 * it passes to {@link #fireNotifyChanged}. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(EInclude.class)) {
		case EXincModelPackage.EINCLUDE__HREF:
			EInclude inc = (EInclude)notification.getNotifier();
			fireNotifyChanged(new ViewerNotification(notification, inc, false, true));
			fireNotifyChanged(new ViewerNotification(notification, inc.eContainer(), false, true));
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

	@Override
	protected Command createDragAndDropCommand(EditingDomain domain,
			Object owner, float location, int operations, int operation,
			Collection<?> collection) {
		boolean onlyFiles = true;
		for (Object obj : collection) {
			if (obj instanceof EProjectFile || obj instanceof IFile) {
				continue;
			}
			onlyFiles = false;
			break;
		}

		if (onlyFiles) {
			return new FileDragAndDropCommand(domain, owner, location,
					operations, operation, collection);
		} else {
			return super.createDragAndDropCommand(domain, owner, location,
					operations, operation, collection);
		}
	}

	@Override
	protected Command createSetCommand(EditingDomain domain, EObject owner,
			EStructuralFeature feature, Object value) {

		if (EXincModelPackage.Literals.EINCLUDE__HREF.equals(feature)) {
			String str = (String) value;
			str = EXincModelUtils.normalizeHref(str);
			CompoundCommand command = new CompoundCommand();
			command.append(super.createSetCommand(domain, owner, feature, str));
			command.append(new LinkTargetFileCommand(domain, (EInclude)owner));
			return command.unwrap();
		}

		return super.createSetCommand(domain, owner, feature, value);
	}

	/**
	 * Return the resource locator for this item provider's resources. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return XIncludeEditorPlugin.INSTANCE;
	}

}
