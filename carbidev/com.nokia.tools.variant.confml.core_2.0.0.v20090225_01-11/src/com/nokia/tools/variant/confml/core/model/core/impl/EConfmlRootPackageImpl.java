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
 * Description: This file is part of com.nokia.tools.variant.confml.core component.
 */

package com.nokia.tools.variant.confml.core.model.core.impl;

import java.net.URI;
import java.util.Map;

import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.osgi.framework.Version;

import com.nokia.tools.variant.confml.core.model.application.EApplicationPackage;
import com.nokia.tools.variant.confml.core.model.application.impl.EApplicationPackageImpl;
import com.nokia.tools.variant.confml.core.model.core.EBinaryResource;
import com.nokia.tools.variant.confml.core.model.core.EConfmlRootFactory;
import com.nokia.tools.variant.confml.core.model.core.EConfmlRootPackage;
import com.nokia.tools.variant.confml.core.model.core.ESourceLocator;
import com.nokia.tools.variant.confml.core.model.core.EWorkspaceModel;
import com.nokia.tools.variant.confml.core.model.metadata.EMetadataPackage;
import com.nokia.tools.variant.confml.core.model.metadata.impl.EMetadataPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EConfmlRootPackageImpl extends EPackageImpl implements EConfmlRootPackage {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass eBinaryResourceEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass eWorkspaceModelEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass eProjectEntryEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass eSourceLocatorEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EDataType eclipse_IExtensionEDataType = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EDataType java_URIEDataType = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EDataType eclipse_IPathEDataType = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EDataType eclipse_IResourceEDataType = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EDataType eclipse_IFileEDataType = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EDataType eclipse_IProjectEDataType = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EDataType eclipse_VersionEDataType = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EDataType eclipse_IFileStoreEDataType = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EDataType ecore_URIEDataType = null;

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
     * @see com.nokia.tools.variant.confml.core.model.core.EConfmlRootPackage#eNS_URI
     * @see #init()
     * @generated
     */
	private EConfmlRootPackageImpl() {
        super(eNS_URI, EConfmlRootFactory.eINSTANCE);
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
	public static EConfmlRootPackage init() {
        if (isInited) return (EConfmlRootPackage)EPackage.Registry.INSTANCE.getEPackage(EConfmlRootPackage.eNS_URI);

        // Obtain or create and register package
        EConfmlRootPackageImpl theEConfmlRootPackage = (EConfmlRootPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof EConfmlRootPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new EConfmlRootPackageImpl());

        isInited = true;

        // Obtain or create and register interdependencies
        EApplicationPackageImpl theEApplicationPackage = (EApplicationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EApplicationPackage.eNS_URI) instanceof EApplicationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EApplicationPackage.eNS_URI) : EApplicationPackage.eINSTANCE);
        EMetadataPackageImpl theEMetadataPackage = (EMetadataPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EMetadataPackage.eNS_URI) instanceof EMetadataPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EMetadataPackage.eNS_URI) : EMetadataPackage.eINSTANCE);

        // Create package meta-data objects
        theEConfmlRootPackage.createPackageContents();
        theEApplicationPackage.createPackageContents();
        theEMetadataPackage.createPackageContents();

        // Initialize created meta-data
        theEConfmlRootPackage.initializePackageContents();
        theEApplicationPackage.initializePackageContents();
        theEMetadataPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theEConfmlRootPackage.freeze();

        return theEConfmlRootPackage;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getEBinaryResource() {
        return eBinaryResourceEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getEWorkspaceModel() {
        return eWorkspaceModelEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getEWorkspaceModel_ProjectMap() {
        return (EReference)eWorkspaceModelEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getEProjectEntry() {
        return eProjectEntryEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getEProjectEntry_Key() {
        return (EAttribute)eProjectEntryEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getEProjectEntry_Value() {
        return (EReference)eProjectEntryEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getESourceLocator() {
        return eSourceLocatorEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getESourceLocator_Uri() {
        return (EAttribute)eSourceLocatorEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EDataType getEclipse_IExtension() {
        return eclipse_IExtensionEDataType;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EDataType getJava_URI() {
        return java_URIEDataType;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EDataType getEclipse_IPath() {
        return eclipse_IPathEDataType;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EDataType getEclipse_IResource() {
        return eclipse_IResourceEDataType;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EDataType getEclipse_IFile() {
        return eclipse_IFileEDataType;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EDataType getEclipse_IProject() {
        return eclipse_IProjectEDataType;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EDataType getEclipse_Version() {
        return eclipse_VersionEDataType;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EDataType getEclipse_IFileStore() {
        return eclipse_IFileStoreEDataType;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EDataType getEcore_URI() {
        return ecore_URIEDataType;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EConfmlRootFactory getEConfmlRootFactory() {
        return (EConfmlRootFactory)getEFactoryInstance();
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
        eBinaryResourceEClass = createEClass(EBINARY_RESOURCE);

        eWorkspaceModelEClass = createEClass(EWORKSPACE_MODEL);
        createEReference(eWorkspaceModelEClass, EWORKSPACE_MODEL__PROJECT_MAP);

        eProjectEntryEClass = createEClass(EPROJECT_ENTRY);
        createEAttribute(eProjectEntryEClass, EPROJECT_ENTRY__KEY);
        createEReference(eProjectEntryEClass, EPROJECT_ENTRY__VALUE);

        eSourceLocatorEClass = createEClass(ESOURCE_LOCATOR);
        createEAttribute(eSourceLocatorEClass, ESOURCE_LOCATOR__URI);

        // Create data types
        eclipse_IExtensionEDataType = createEDataType(ECLIPSE_IEXTENSION);
        java_URIEDataType = createEDataType(JAVA_URI);
        eclipse_IPathEDataType = createEDataType(ECLIPSE_IPATH);
        eclipse_IResourceEDataType = createEDataType(ECLIPSE_IRESOURCE);
        eclipse_IFileEDataType = createEDataType(ECLIPSE_IFILE);
        eclipse_IProjectEDataType = createEDataType(ECLIPSE_IPROJECT);
        eclipse_VersionEDataType = createEDataType(ECLIPSE_VERSION);
        eclipse_IFileStoreEDataType = createEDataType(ECLIPSE_IFILE_STORE);
        ecore_URIEDataType = createEDataType(ECORE_URI);
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

        // Obtain other dependent packages
        EApplicationPackage theEApplicationPackage = (EApplicationPackage)EPackage.Registry.INSTANCE.getEPackage(EApplicationPackage.eNS_URI);
        EMetadataPackage theEMetadataPackage = (EMetadataPackage)EPackage.Registry.INSTANCE.getEPackage(EMetadataPackage.eNS_URI);

        // Add subpackages
        getESubpackages().add(theEApplicationPackage);
        getESubpackages().add(theEMetadataPackage);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes

        // Initialize classes and features; add operations and parameters
        initEClass(eBinaryResourceEClass, EBinaryResource.class, "EBinaryResource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(eWorkspaceModelEClass, EWorkspaceModel.class, "EWorkspaceModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getEWorkspaceModel_ProjectMap(), this.getEProjectEntry(), null, "projectMap", null, 0, -1, EWorkspaceModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(eProjectEntryEClass, Map.Entry.class, "EProjectEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getEProjectEntry_Key(), ecorePackage.getEString(), "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getEProjectEntry_Value(), theEApplicationPackage.getEConfigurationProject(), null, "value", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(eSourceLocatorEClass, ESourceLocator.class, "ESourceLocator", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getESourceLocator_Uri(), this.getEcore_URI(), "uri", null, 0, -1, ESourceLocator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Initialize data types
        initEDataType(eclipse_IExtensionEDataType, IExtension.class, "Eclipse_IExtension", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
        initEDataType(java_URIEDataType, URI.class, "Java_URI", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
        initEDataType(eclipse_IPathEDataType, IPath.class, "Eclipse_IPath", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
        initEDataType(eclipse_IResourceEDataType, IResource.class, "Eclipse_IResource", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
        initEDataType(eclipse_IFileEDataType, IFile.class, "Eclipse_IFile", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
        initEDataType(eclipse_IProjectEDataType, IProject.class, "Eclipse_IProject", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
        initEDataType(eclipse_VersionEDataType, Version.class, "Eclipse_Version", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
        initEDataType(eclipse_IFileStoreEDataType, IFileStore.class, "Eclipse_IFileStore", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
        initEDataType(ecore_URIEDataType, org.eclipse.emf.common.util.URI.class, "Ecore_URI", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

        // Create resource
        createResource(eNS_URI);
    }

} //EConfmlRootPackageImpl
