/*
* Copyright (c) 2007 Nokia Corporation and/or its subsidiary(-ies). 
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
package com.nokia.tools.s60ct.model.confml.provider;


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
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import com.nokia.tools.s60ct.model.confml.ConfmlFactory;
import com.nokia.tools.s60ct.model.confml.ConfmlPackage;
import com.nokia.tools.s60ct.model.confml.ESetting;

/**
 * This is the item provider adapter for a {@link com.nokia.tools.s60ct.model.confml.ESetting} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ESettingItemProvider
	extends ItemProviderAdapter
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ESettingItemProvider(AdapterFactory adapterFactory) {
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

			addDescriptionTextPropertyDescriptor(object);
			addDescriptionUriPropertyDescriptor(object);
			addDescriptionUriTextPropertyDescriptor(object);
			addIconUriTitlePropertyDescriptor(object);
			addIconUriPropertyDescriptor(object);
			addLinkUriPropertyDescriptor(object);
			addLinkUriTitlePropertyDescriptor(object);
			addNamePropertyDescriptor(object);
			addRefPropertyDescriptor(object);
			addRfsPropertyDescriptor(object);
			addDefaultRfsPropertyDescriptor(object);
			addReadOnlyPropertyDescriptor(object);
			addConstraintPropertyDescriptor(object);
			addRelevantPropertyDescriptor(object);
			addRequiredPropertyDescriptor(object);
			addDeprecatedPropertyDescriptor(object);
			addModifiedPropertyDescriptor(object);
			addSetdefaultPropertyDescriptor(object);
			addComputedRelevantPropertyDescriptor(object);
			addComputedConstraintPropertyDescriptor(object);
			addRelevantASTPropertyDescriptor(object);
			addConstraintASTPropertyDescriptor(object);
			addDependenciesPropertyDescriptor(object);
			addOptionDependenciesPropertyDescriptor(object);
			addValueNullPropertyDescriptor(object);
			addNotesPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Description Text feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDescriptionTextPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EDescriptionContainer_descriptionText_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EDescriptionContainer_descriptionText_feature", "_UI_EDescriptionContainer_type"),
				 ConfmlPackage.Literals.EDESCRIPTION_CONTAINER__DESCRIPTION_TEXT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Description Uri feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDescriptionUriPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EDescriptionContainer_descriptionUri_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EDescriptionContainer_descriptionUri_feature", "_UI_EDescriptionContainer_type"),
				 ConfmlPackage.Literals.EDESCRIPTION_CONTAINER__DESCRIPTION_URI,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Description Uri Text feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDescriptionUriTextPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EDescriptionContainer_descriptionUriText_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EDescriptionContainer_descriptionUriText_feature", "_UI_EDescriptionContainer_type"),
				 ConfmlPackage.Literals.EDESCRIPTION_CONTAINER__DESCRIPTION_URI_TEXT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Icon Uri Title feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIconUriTitlePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EIconContainer_iconUriTitle_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EIconContainer_iconUriTitle_feature", "_UI_EIconContainer_type"),
				 ConfmlPackage.Literals.EICON_CONTAINER__ICON_URI_TITLE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Icon Uri feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIconUriPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EIconContainer_iconUri_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EIconContainer_iconUri_feature", "_UI_EIconContainer_type"),
				 ConfmlPackage.Literals.EICON_CONTAINER__ICON_URI,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Link Uri feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLinkUriPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ELinkContainer_linkUri_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ELinkContainer_linkUri_feature", "_UI_ELinkContainer_type"),
				 ConfmlPackage.Literals.ELINK_CONTAINER__LINK_URI,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Link Uri Title feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLinkUriTitlePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ELinkContainer_linkUriTitle_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ELinkContainer_linkUriTitle_feature", "_UI_ELinkContainer_type"),
				 ConfmlPackage.Literals.ELINK_CONTAINER__LINK_URI_TITLE,
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
				 getString("_UI_ESetting_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ESetting_name_feature", "_UI_ESetting_type"),
				 ConfmlPackage.Literals.ESETTING__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
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
				 getString("_UI_ESetting_ref_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ESetting_ref_feature", "_UI_ESetting_type"),
				 ConfmlPackage.Literals.ESETTING__REF,
				 true,
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
				 getString("_UI_ESetting_rfs_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ESetting_rfs_feature", "_UI_ESetting_type"),
				 ConfmlPackage.Literals.ESETTING__RFS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Default Rfs feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDefaultRfsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ESetting_defaultRfs_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ESetting_defaultRfs_feature", "_UI_ESetting_type"),
				 ConfmlPackage.Literals.ESETTING__DEFAULT_RFS,
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
				 getString("_UI_ESetting_readOnly_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ESetting_readOnly_feature", "_UI_ESetting_type"),
				 ConfmlPackage.Literals.ESETTING__READ_ONLY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
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
				 getString("_UI_ESetting_constraint_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ESetting_constraint_feature", "_UI_ESetting_type"),
				 ConfmlPackage.Literals.ESETTING__CONSTRAINT,
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
				 getString("_UI_ESetting_relevant_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ESetting_relevant_feature", "_UI_ESetting_type"),
				 ConfmlPackage.Literals.ESETTING__RELEVANT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Required feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRequiredPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ESetting_required_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ESetting_required_feature", "_UI_ESetting_type"),
				 ConfmlPackage.Literals.ESETTING__REQUIRED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Deprecated feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDeprecatedPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ESetting_deprecated_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ESetting_deprecated_feature", "_UI_ESetting_type"),
				 ConfmlPackage.Literals.ESETTING__DEPRECATED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Modified feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addModifiedPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ESetting_modified_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ESetting_modified_feature", "_UI_ESetting_type"),
				 ConfmlPackage.Literals.ESETTING__MODIFIED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Setdefault feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSetdefaultPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ESetting_setdefault_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ESetting_setdefault_feature", "_UI_ESetting_type"),
				 ConfmlPackage.Literals.ESETTING__SETDEFAULT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Computed Relevant feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addComputedRelevantPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ESetting_computedRelevant_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ESetting_computedRelevant_feature", "_UI_ESetting_type"),
				 ConfmlPackage.Literals.ESETTING__COMPUTED_RELEVANT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Computed Constraint feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addComputedConstraintPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ESetting_computedConstraint_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ESetting_computedConstraint_feature", "_UI_ESetting_type"),
				 ConfmlPackage.Literals.ESETTING__COMPUTED_CONSTRAINT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Relevant AST feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRelevantASTPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ESetting_relevantAST_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ESetting_relevantAST_feature", "_UI_ESetting_type"),
				 ConfmlPackage.Literals.ESETTING__RELEVANT_AST,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Constraint AST feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addConstraintASTPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ESetting_constraintAST_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ESetting_constraintAST_feature", "_UI_ESetting_type"),
				 ConfmlPackage.Literals.ESETTING__CONSTRAINT_AST,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Dependencies feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDependenciesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ESetting_dependencies_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ESetting_dependencies_feature", "_UI_ESetting_type"),
				 ConfmlPackage.Literals.ESETTING__DEPENDENCIES,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Option Dependencies feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOptionDependenciesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ESetting_optionDependencies_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ESetting_optionDependencies_feature", "_UI_ESetting_type"),
				 ConfmlPackage.Literals.ESETTING__OPTION_DEPENDENCIES,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Value Null feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addValueNullPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ESetting_valueNull_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ESetting_valueNull_feature", "_UI_ESetting_type"),
				 ConfmlPackage.Literals.ESETTING__VALUE_NULL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Notes feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNotesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ESetting_notes_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ESetting_notes_feature", "_UI_ESetting_type"),
				 ConfmlPackage.Literals.ESETTING__NOTES,
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
			childrenFeatures.add(ConfmlPackage.Literals.ESETTING__VALUE);
			childrenFeatures.add(ConfmlPackage.Literals.ESETTING__DEFAULT_VALUE);
			childrenFeatures.add(ConfmlPackage.Literals.ESETTING__PROPERTIES);
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
	 * This returns ESetting.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ESetting"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((ESetting)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_ESetting_type") :
			getString("_UI_ESetting_type") + " " + label;
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

		switch (notification.getFeatureID(ESetting.class)) {
			case ConfmlPackage.ESETTING__DESCRIPTION_TEXT:
			case ConfmlPackage.ESETTING__DESCRIPTION_URI:
			case ConfmlPackage.ESETTING__DESCRIPTION_URI_TEXT:
			case ConfmlPackage.ESETTING__ICON_URI_TITLE:
			case ConfmlPackage.ESETTING__ICON_URI:
			case ConfmlPackage.ESETTING__LINK_URI:
			case ConfmlPackage.ESETTING__LINK_URI_TITLE:
			case ConfmlPackage.ESETTING__NAME:
			case ConfmlPackage.ESETTING__REF:
			case ConfmlPackage.ESETTING__RFS:
			case ConfmlPackage.ESETTING__DEFAULT_RFS:
			case ConfmlPackage.ESETTING__READ_ONLY:
			case ConfmlPackage.ESETTING__CONSTRAINT:
			case ConfmlPackage.ESETTING__RELEVANT:
			case ConfmlPackage.ESETTING__REQUIRED:
			case ConfmlPackage.ESETTING__DEPRECATED:
			case ConfmlPackage.ESETTING__MODIFIED:
			case ConfmlPackage.ESETTING__SETDEFAULT:
			case ConfmlPackage.ESETTING__COMPUTED_RELEVANT:
			case ConfmlPackage.ESETTING__COMPUTED_CONSTRAINT:
			case ConfmlPackage.ESETTING__RELEVANT_AST:
			case ConfmlPackage.ESETTING__CONSTRAINT_AST:
			case ConfmlPackage.ESETTING__DEPENDENCIES:
			case ConfmlPackage.ESETTING__OPTION_DEPENDENCIES:
			case ConfmlPackage.ESETTING__VALUE_NULL:
			case ConfmlPackage.ESETTING__NOTES:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case ConfmlPackage.ESETTING__VALUE:
			case ConfmlPackage.ESETTING__DEFAULT_VALUE:
			case ConfmlPackage.ESETTING__PROPERTIES:
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
				(ConfmlPackage.Literals.ESETTING__VALUE,
				 ConfmlFactory.eINSTANCE.createESimpleValue()));

		newChildDescriptors.add
			(createChildParameter
				(ConfmlPackage.Literals.ESETTING__VALUE,
				 ConfmlFactory.eINSTANCE.createESequenceValue()));

		newChildDescriptors.add
			(createChildParameter
				(ConfmlPackage.Literals.ESETTING__VALUE,
				 ConfmlFactory.eINSTANCE.createEResourceValue()));

		newChildDescriptors.add
			(createChildParameter
				(ConfmlPackage.Literals.ESETTING__DEFAULT_VALUE,
				 ConfmlFactory.eINSTANCE.createESimpleValue()));

		newChildDescriptors.add
			(createChildParameter
				(ConfmlPackage.Literals.ESETTING__DEFAULT_VALUE,
				 ConfmlFactory.eINSTANCE.createESequenceValue()));

		newChildDescriptors.add
			(createChildParameter
				(ConfmlPackage.Literals.ESETTING__DEFAULT_VALUE,
				 ConfmlFactory.eINSTANCE.createEResourceValue()));

		newChildDescriptors.add
			(createChildParameter
				(ConfmlPackage.Literals.ESETTING__PROPERTIES,
				 ConfmlFactory.eINSTANCE.createEProperty()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == ConfmlPackage.Literals.ESETTING__VALUE ||
			childFeature == ConfmlPackage.Literals.ESETTING__DEFAULT_VALUE;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return S60ct_confmlEditPlugin.INSTANCE;
	}

}
