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

package com.nokia.tools.vct.appshell.appshellmodel.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import com.nokia.tools.vct.appshell.appshellmodel.EApplicationElement;
import com.nokia.tools.vct.appshell.appshellmodel.EAppshellDocument;
import com.nokia.tools.vct.appshell.appshellmodel.EAppshellModelFactory;
import com.nokia.tools.vct.appshell.appshellmodel.EAppshellModelPackage;
import com.nokia.tools.vct.appshell.appshellmodel.EBooleanFlag;
import com.nokia.tools.vct.appshell.appshellmodel.EDataElement;
import com.nokia.tools.vct.appshell.appshellmodel.EFolderElement;
import com.nokia.tools.vct.appshell.appshellmodel.EHideDescriptor;
import com.nokia.tools.vct.appshell.appshellmodel.EIconDescriptor;
import com.nokia.tools.vct.appshell.appshellmodel.ELockDescriptor;
import com.nokia.tools.vct.appshell.appshellmodel.ENameDescriptor;
import com.nokia.tools.vct.appshell.appshellmodel.EURLElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EAppshellModelPackageImpl extends EPackageImpl implements EAppshellModelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eAppshellDocumentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eFolderElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eApplicationElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eurlElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eDataElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eLockDescriptorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eIconDescriptorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eHideDescriptorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eNameDescriptorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eBooleanFlagEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see com.nokia.tools.vct.appshell.appshellmodel.EAppshellModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EAppshellModelPackageImpl() {
		super(eNS_URI, EAppshellModelFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static EAppshellModelPackage init() {
		if (isInited) return (EAppshellModelPackage)EPackage.Registry.INSTANCE.getEPackage(EAppshellModelPackage.eNS_URI);

		// Obtain or create and register package
		EAppshellModelPackageImpl theEAppshellModelPackage = (EAppshellModelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof EAppshellModelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new EAppshellModelPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theEAppshellModelPackage.createPackageContents();

		// Initialize created meta-data
		theEAppshellModelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEAppshellModelPackage.freeze();

		return theEAppshellModelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEAppshellDocument() {
		return eAppshellDocumentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEAppshellDocument_Data() {
		return (EReference)eAppshellDocumentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEFolderElement() {
		return eFolderElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEFolderElement_Contents() {
		return (EAttribute)eFolderElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEFolderElement_Default() {
		return (EAttribute)eFolderElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEFolderElement_ApplicationGroupName() {
		return (EAttribute)eFolderElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEFolderElement_Applications() {
		return (EReference)eFolderElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEFolderElement_Folders() {
		return (EReference)eFolderElementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEFolderElement_Urls() {
		return (EReference)eFolderElementEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEApplicationElement() {
		return eApplicationElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEApplicationElement_Uid() {
		return (EAttribute)eApplicationElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEApplicationElement_View() {
		return (EAttribute)eApplicationElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEURLElement() {
		return eurlElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEURLElement_Url() {
		return (EAttribute)eurlElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEDataElement() {
		return eDataElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEDataElement_Version() {
		return (EAttribute)eDataElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEDataElement_Folder() {
		return (EReference)eDataElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getELockDescriptor() {
		return eLockDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getELockDescriptor_LockName() {
		return (EAttribute)eLockDescriptorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getELockDescriptor_LockIcon() {
		return (EAttribute)eLockDescriptorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getELockDescriptor_LockDelete() {
		return (EAttribute)eLockDescriptorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getELockDescriptor_LockOrganize() {
		return (EAttribute)eLockDescriptorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEIconDescriptor() {
		return eIconDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEIconDescriptor_IconFile() {
		return (EAttribute)eIconDescriptorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEIconDescriptor_M3gIconFile() {
		return (EAttribute)eIconDescriptorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEIconDescriptor_IconId() {
		return (EAttribute)eIconDescriptorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEIconDescriptor_MaskId() {
		return (EAttribute)eIconDescriptorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEIconDescriptor_IconSkinMajorId() {
		return (EAttribute)eIconDescriptorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEIconDescriptor_IconSkinMinorId() {
		return (EAttribute)eIconDescriptorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEHideDescriptor() {
		return eHideDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEHideDescriptor_HideChangeSkin() {
		return (EAttribute)eHideDescriptorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEHideDescriptor_HideMemDetails() {
		return (EAttribute)eHideDescriptorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEHideDescriptor_HideDownload() {
		return (EAttribute)eHideDescriptorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEHideDescriptor_HideAnimatedIcons() {
		return (EAttribute)eHideDescriptorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getENameDescriptor() {
		return eNameDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getENameDescriptor_TitleName() {
		return (EAttribute)eNameDescriptorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getENameDescriptor_ShortName() {
		return (EAttribute)eNameDescriptorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getENameDescriptor_LongName() {
		return (EAttribute)eNameDescriptorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getEBooleanFlag() {
		return eBooleanFlagEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAppshellModelFactory getEAppshellModelFactory() {
		return (EAppshellModelFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		eAppshellDocumentEClass = createEClass(EAPPSHELL_DOCUMENT);
		createEReference(eAppshellDocumentEClass, EAPPSHELL_DOCUMENT__DATA);

		eFolderElementEClass = createEClass(EFOLDER_ELEMENT);
		createEAttribute(eFolderElementEClass, EFOLDER_ELEMENT__CONTENTS);
		createEAttribute(eFolderElementEClass, EFOLDER_ELEMENT__DEFAULT);
		createEAttribute(eFolderElementEClass, EFOLDER_ELEMENT__APPLICATION_GROUP_NAME);
		createEReference(eFolderElementEClass, EFOLDER_ELEMENT__APPLICATIONS);
		createEReference(eFolderElementEClass, EFOLDER_ELEMENT__FOLDERS);
		createEReference(eFolderElementEClass, EFOLDER_ELEMENT__URLS);

		eApplicationElementEClass = createEClass(EAPPLICATION_ELEMENT);
		createEAttribute(eApplicationElementEClass, EAPPLICATION_ELEMENT__UID);
		createEAttribute(eApplicationElementEClass, EAPPLICATION_ELEMENT__VIEW);

		eurlElementEClass = createEClass(EURL_ELEMENT);
		createEAttribute(eurlElementEClass, EURL_ELEMENT__URL);

		eDataElementEClass = createEClass(EDATA_ELEMENT);
		createEAttribute(eDataElementEClass, EDATA_ELEMENT__VERSION);
		createEReference(eDataElementEClass, EDATA_ELEMENT__FOLDER);

		eLockDescriptorEClass = createEClass(ELOCK_DESCRIPTOR);
		createEAttribute(eLockDescriptorEClass, ELOCK_DESCRIPTOR__LOCK_NAME);
		createEAttribute(eLockDescriptorEClass, ELOCK_DESCRIPTOR__LOCK_ICON);
		createEAttribute(eLockDescriptorEClass, ELOCK_DESCRIPTOR__LOCK_DELETE);
		createEAttribute(eLockDescriptorEClass, ELOCK_DESCRIPTOR__LOCK_ORGANIZE);

		eIconDescriptorEClass = createEClass(EICON_DESCRIPTOR);
		createEAttribute(eIconDescriptorEClass, EICON_DESCRIPTOR__ICON_FILE);
		createEAttribute(eIconDescriptorEClass, EICON_DESCRIPTOR__M3G_ICON_FILE);
		createEAttribute(eIconDescriptorEClass, EICON_DESCRIPTOR__ICON_ID);
		createEAttribute(eIconDescriptorEClass, EICON_DESCRIPTOR__MASK_ID);
		createEAttribute(eIconDescriptorEClass, EICON_DESCRIPTOR__ICON_SKIN_MAJOR_ID);
		createEAttribute(eIconDescriptorEClass, EICON_DESCRIPTOR__ICON_SKIN_MINOR_ID);

		eHideDescriptorEClass = createEClass(EHIDE_DESCRIPTOR);
		createEAttribute(eHideDescriptorEClass, EHIDE_DESCRIPTOR__HIDE_CHANGE_SKIN);
		createEAttribute(eHideDescriptorEClass, EHIDE_DESCRIPTOR__HIDE_MEM_DETAILS);
		createEAttribute(eHideDescriptorEClass, EHIDE_DESCRIPTOR__HIDE_DOWNLOAD);
		createEAttribute(eHideDescriptorEClass, EHIDE_DESCRIPTOR__HIDE_ANIMATED_ICONS);

		eNameDescriptorEClass = createEClass(ENAME_DESCRIPTOR);
		createEAttribute(eNameDescriptorEClass, ENAME_DESCRIPTOR__TITLE_NAME);
		createEAttribute(eNameDescriptorEClass, ENAME_DESCRIPTOR__SHORT_NAME);
		createEAttribute(eNameDescriptorEClass, ENAME_DESCRIPTOR__LONG_NAME);

		// Create enums
		eBooleanFlagEEnum = createEEnum(EBOOLEAN_FLAG);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		eFolderElementEClass.getESuperTypes().add(this.getELockDescriptor());
		eFolderElementEClass.getESuperTypes().add(this.getEIconDescriptor());
		eFolderElementEClass.getESuperTypes().add(this.getEHideDescriptor());
		eFolderElementEClass.getESuperTypes().add(this.getENameDescriptor());
		eApplicationElementEClass.getESuperTypes().add(this.getELockDescriptor());
		eApplicationElementEClass.getESuperTypes().add(this.getEIconDescriptor());
		eApplicationElementEClass.getESuperTypes().add(this.getEHideDescriptor());
		eApplicationElementEClass.getESuperTypes().add(this.getENameDescriptor());
		eurlElementEClass.getESuperTypes().add(this.getELockDescriptor());
		eurlElementEClass.getESuperTypes().add(this.getEIconDescriptor());
		eurlElementEClass.getESuperTypes().add(this.getEHideDescriptor());
		eurlElementEClass.getESuperTypes().add(this.getENameDescriptor());

		// Initialize classes and features; add operations and parameters
		initEClass(eAppshellDocumentEClass, EAppshellDocument.class, "EAppshellDocument", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEAppshellDocument_Data(), this.getEDataElement(), null, "data", null, 0, 1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eFolderElementEClass, EFolderElement.class, "EFolderElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEFolderElement_Contents(), ecorePackage.getEFeatureMapEntry(), "contents", null, 0, -1, EFolderElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEFolderElement_Default(), this.getEBooleanFlag(), "default", null, 0, 1, EFolderElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEFolderElement_ApplicationGroupName(), ecorePackage.getEString(), "applicationGroupName", null, 0, 1, EFolderElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEFolderElement_Applications(), this.getEApplicationElement(), null, "applications", null, 0, -1, EFolderElement.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getEFolderElement_Folders(), this.getEFolderElement(), null, "folders", null, 0, -1, EFolderElement.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getEFolderElement_Urls(), this.getEURLElement(), null, "urls", null, 0, -1, EFolderElement.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(eApplicationElementEClass, EApplicationElement.class, "EApplicationElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEApplicationElement_Uid(), ecorePackage.getEString(), "uid", null, 1, 1, EApplicationElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEApplicationElement_View(), ecorePackage.getEString(), "view", null, 0, 1, EApplicationElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eurlElementEClass, EURLElement.class, "EURLElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEURLElement_Url(), ecorePackage.getEString(), "url", null, 0, 1, EURLElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eDataElementEClass, EDataElement.class, "EDataElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEDataElement_Version(), ecorePackage.getEString(), "version", null, 1, 1, EDataElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEDataElement_Folder(), this.getEFolderElement(), null, "folder", null, 0, 1, EDataElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eLockDescriptorEClass, ELockDescriptor.class, "ELockDescriptor", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getELockDescriptor_LockName(), this.getEBooleanFlag(), "lockName", null, 0, 1, ELockDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getELockDescriptor_LockIcon(), this.getEBooleanFlag(), "lockIcon", null, 0, 1, ELockDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getELockDescriptor_LockDelete(), this.getEBooleanFlag(), "lockDelete", null, 0, 1, ELockDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getELockDescriptor_LockOrganize(), this.getEBooleanFlag(), "lockOrganize", null, 0, 1, ELockDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eIconDescriptorEClass, EIconDescriptor.class, "EIconDescriptor", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEIconDescriptor_IconFile(), ecorePackage.getEString(), "iconFile", null, 0, 1, EIconDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEIconDescriptor_M3gIconFile(), ecorePackage.getEString(), "m3gIconFile", null, 0, 1, EIconDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEIconDescriptor_IconId(), ecorePackage.getEString(), "iconId", null, 0, 1, EIconDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEIconDescriptor_MaskId(), ecorePackage.getEString(), "maskId", null, 0, 1, EIconDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEIconDescriptor_IconSkinMajorId(), ecorePackage.getEString(), "iconSkinMajorId", null, 0, 1, EIconDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEIconDescriptor_IconSkinMinorId(), ecorePackage.getEString(), "iconSkinMinorId", null, 0, 1, EIconDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eHideDescriptorEClass, EHideDescriptor.class, "EHideDescriptor", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEHideDescriptor_HideChangeSkin(), this.getEBooleanFlag(), "hideChangeSkin", null, 0, 1, EHideDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEHideDescriptor_HideMemDetails(), this.getEBooleanFlag(), "hideMemDetails", null, 0, 1, EHideDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEHideDescriptor_HideDownload(), this.getEBooleanFlag(), "hideDownload", null, 0, 1, EHideDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEHideDescriptor_HideAnimatedIcons(), this.getEBooleanFlag(), "hideAnimatedIcons", null, 0, 1, EHideDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eNameDescriptorEClass, ENameDescriptor.class, "ENameDescriptor", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getENameDescriptor_TitleName(), ecorePackage.getEString(), "titleName", null, 0, 1, ENameDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getENameDescriptor_ShortName(), ecorePackage.getEString(), "shortName", null, 0, 1, ENameDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getENameDescriptor_LongName(), ecorePackage.getEString(), "longName", null, 0, 1, ENameDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(eBooleanFlagEEnum, EBooleanFlag.class, "EBooleanFlag");
		addEEnumLiteral(eBooleanFlagEEnum, EBooleanFlag.OFF);
		addEEnumLiteral(eBooleanFlagEEnum, EBooleanFlag.ON);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";		
		addAnnotation
		  (eAppshellDocumentEClass, 
		   source, 
		   new String[] {
			 "name", "",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getEAppshellDocument_Data(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "data",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (eFolderElementEClass, 
		   source, 
		   new String[] {
			 "name", "folderType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getEFolderElement_Contents(), 
		   source, 
		   new String[] {
			 "kind", "group",
			 "name", "contents:0"
		   });		
		addAnnotation
		  (getEFolderElement_Default(), 
		   source, 
		   new String[] {
			 "name", "default",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getEFolderElement_ApplicationGroupName(), 
		   source, 
		   new String[] {
			 "name", "applicationgroup_name",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getEFolderElement_Applications(), 
		   source, 
		   new String[] {
			 "name", "application",
			 "kind", "element",
			 "namespace", "##targetNamespace",
			 "group", "#contents:0"
		   });		
		addAnnotation
		  (getEFolderElement_Folders(), 
		   source, 
		   new String[] {
			 "name", "folder",
			 "kind", "element",
			 "namespace", "##targetNamespace",
			 "group", "#contents:0"
		   });		
		addAnnotation
		  (getEFolderElement_Urls(), 
		   source, 
		   new String[] {
			 "name", "url",
			 "kind", "element",
			 "namespace", "##targetNamespace",
			 "group", "#contents:0"
		   });		
		addAnnotation
		  (eApplicationElementEClass, 
		   source, 
		   new String[] {
			 "name", "applicationType",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getEApplicationElement_Uid(), 
		   source, 
		   new String[] {
			 "name", "uid",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getEApplicationElement_View(), 
		   source, 
		   new String[] {
			 "name", "view",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (eurlElementEClass, 
		   source, 
		   new String[] {
			 "name", "urlType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getEURLElement_Url(), 
		   source, 
		   new String[] {
			 "name", "url",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (eDataElementEClass, 
		   source, 
		   new String[] {
			 "name", "dataType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getEDataElement_Version(), 
		   source, 
		   new String[] {
			 "name", "version",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getEDataElement_Folder(), 
		   source, 
		   new String[] {
			 "name", "folder",
			 "kind", "element",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (eLockDescriptorEClass, 
		   source, 
		   new String[] {
			 "name", "lockDescriptorType",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getELockDescriptor_LockName(), 
		   source, 
		   new String[] {
			 "name", "lock_name",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getELockDescriptor_LockIcon(), 
		   source, 
		   new String[] {
			 "name", "lock_icon",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getELockDescriptor_LockDelete(), 
		   source, 
		   new String[] {
			 "name", "lock_delete",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getELockDescriptor_LockOrganize(), 
		   source, 
		   new String[] {
			 "name", "lock_organize",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (eIconDescriptorEClass, 
		   source, 
		   new String[] {
			 "name", "iconDescriptorType",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getEIconDescriptor_IconFile(), 
		   source, 
		   new String[] {
			 "name", "icon_file",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getEIconDescriptor_M3gIconFile(), 
		   source, 
		   new String[] {
			 "name", "m3g_icon_file",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getEIconDescriptor_IconId(), 
		   source, 
		   new String[] {
			 "name", "icon_id",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getEIconDescriptor_MaskId(), 
		   source, 
		   new String[] {
			 "name", "mask_id",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getEIconDescriptor_IconSkinMajorId(), 
		   source, 
		   new String[] {
			 "name", "icon_skin_major_id",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getEIconDescriptor_IconSkinMinorId(), 
		   source, 
		   new String[] {
			 "name", "icon_skin_minor_id",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (eHideDescriptorEClass, 
		   source, 
		   new String[] {
			 "name", "hideDescriptorType",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getEHideDescriptor_HideChangeSkin(), 
		   source, 
		   new String[] {
			 "name", "hide_change_skin",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getEHideDescriptor_HideMemDetails(), 
		   source, 
		   new String[] {
			 "name", "hide_mem_details",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getEHideDescriptor_HideDownload(), 
		   source, 
		   new String[] {
			 "name", "hide_download",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getEHideDescriptor_HideAnimatedIcons(), 
		   source, 
		   new String[] {
			 "name", "hide_animated_icons",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (eNameDescriptorEClass, 
		   source, 
		   new String[] {
			 "name", "nameDescriptorType",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getENameDescriptor_TitleName(), 
		   source, 
		   new String[] {
			 "name", "title_name",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getENameDescriptor_ShortName(), 
		   source, 
		   new String[] {
			 "name", "short_name",
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getENameDescriptor_LongName(), 
		   source, 
		   new String[] {
			 "name", "long_name",
			 "kind", "attribute"
		   });
	}

} //EAppshellModelPackageImpl
