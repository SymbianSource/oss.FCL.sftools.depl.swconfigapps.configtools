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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.osgi.framework.Version;

import com.nokia.tools.variant.confml.core.model.application.EConfigurationProject;
import com.nokia.tools.variant.confml.core.model.core.EBinaryResource;
import com.nokia.tools.variant.confml.core.model.core.EConfmlRootFactory;
import com.nokia.tools.variant.confml.core.model.core.EConfmlRootPackage;
import com.nokia.tools.variant.confml.core.model.core.EWorkspaceModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EConfmlRootFactoryImpl extends EFactoryImpl implements EConfmlRootFactory {
	/**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static EConfmlRootFactory init() {
        try {
            EConfmlRootFactory theEConfmlRootFactory = (EConfmlRootFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.nokia.com/xml/ns/confml-core"); 
            if (theEConfmlRootFactory != null) {
                return theEConfmlRootFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new EConfmlRootFactoryImpl();
    }

	/**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EConfmlRootFactoryImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
            case EConfmlRootPackage.EBINARY_RESOURCE: return createEBinaryResource();
            case EConfmlRootPackage.EWORKSPACE_MODEL: return createEWorkspaceModel();
            case EConfmlRootPackage.EPROJECT_ENTRY: return (EObject)createEProjectEntry();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
        switch (eDataType.getClassifierID()) {
            case EConfmlRootPackage.ECLIPSE_IEXTENSION:
                return createEclipse_IExtensionFromString(eDataType, initialValue);
            case EConfmlRootPackage.JAVA_URI:
                return createJava_URIFromString(eDataType, initialValue);
            case EConfmlRootPackage.ECLIPSE_IPATH:
                return createEclipse_IPathFromString(eDataType, initialValue);
            case EConfmlRootPackage.ECLIPSE_IRESOURCE:
                return createEclipse_IResourceFromString(eDataType, initialValue);
            case EConfmlRootPackage.ECLIPSE_IFILE:
                return createEclipse_IFileFromString(eDataType, initialValue);
            case EConfmlRootPackage.ECLIPSE_IPROJECT:
                return createEclipse_IProjectFromString(eDataType, initialValue);
            case EConfmlRootPackage.ECLIPSE_VERSION:
                return createEclipse_VersionFromString(eDataType, initialValue);
            case EConfmlRootPackage.ECLIPSE_IFILE_STORE:
                return createEclipse_IFileStoreFromString(eDataType, initialValue);
            case EConfmlRootPackage.ECORE_URI:
                return createEcore_URIFromString(eDataType, initialValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
        switch (eDataType.getClassifierID()) {
            case EConfmlRootPackage.ECLIPSE_IEXTENSION:
                return convertEclipse_IExtensionToString(eDataType, instanceValue);
            case EConfmlRootPackage.JAVA_URI:
                return convertJava_URIToString(eDataType, instanceValue);
            case EConfmlRootPackage.ECLIPSE_IPATH:
                return convertEclipse_IPathToString(eDataType, instanceValue);
            case EConfmlRootPackage.ECLIPSE_IRESOURCE:
                return convertEclipse_IResourceToString(eDataType, instanceValue);
            case EConfmlRootPackage.ECLIPSE_IFILE:
                return convertEclipse_IFileToString(eDataType, instanceValue);
            case EConfmlRootPackage.ECLIPSE_IPROJECT:
                return convertEclipse_IProjectToString(eDataType, instanceValue);
            case EConfmlRootPackage.ECLIPSE_VERSION:
                return convertEclipse_VersionToString(eDataType, instanceValue);
            case EConfmlRootPackage.ECLIPSE_IFILE_STORE:
                return convertEclipse_IFileStoreToString(eDataType, instanceValue);
            case EConfmlRootPackage.ECORE_URI:
                return convertEcore_URIToString(eDataType, instanceValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EBinaryResource createEBinaryResource() {
        EBinaryResourceImpl eBinaryResource = new EBinaryResourceImpl();
        return eBinaryResource;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EWorkspaceModel createEWorkspaceModel() {
        EWorkspaceModelImpl eWorkspaceModel = new EWorkspaceModelImpl();
        return eWorkspaceModel;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Map.Entry<String, EConfigurationProject> createEProjectEntry() {
        EProjectEntryImpl eProjectEntry = new EProjectEntryImpl();
        return eProjectEntry;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public IExtension createEclipse_IExtensionFromString(EDataType eDataType, String initialValue) {
        return (IExtension)super.createFromString(eDataType, initialValue);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String convertEclipse_IExtensionToString(EDataType eDataType, Object instanceValue) {
        return super.convertToString(eDataType, instanceValue);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public URI createJava_URIFromString(EDataType eDataType, String initialValue) {
        return (URI)super.createFromString(eDataType, initialValue);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String convertJava_URIToString(EDataType eDataType, Object instanceValue) {
        return super.convertToString(eDataType, instanceValue);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public IPath createEclipse_IPathFromString(EDataType eDataType, String initialValue) {
        return (IPath)super.createFromString(eDataType, initialValue);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String convertEclipse_IPathToString(EDataType eDataType, Object instanceValue) {
        return super.convertToString(eDataType, instanceValue);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public IResource createEclipse_IResourceFromString(EDataType eDataType, String initialValue) {
        return (IResource)super.createFromString(eDataType, initialValue);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String convertEclipse_IResourceToString(EDataType eDataType, Object instanceValue) {
        return super.convertToString(eDataType, instanceValue);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public IFile createEclipse_IFileFromString(EDataType eDataType, String initialValue) {
        return (IFile)super.createFromString(eDataType, initialValue);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String convertEclipse_IFileToString(EDataType eDataType, Object instanceValue) {
        return super.convertToString(eDataType, instanceValue);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public IProject createEclipse_IProjectFromString(EDataType eDataType, String initialValue) {
        return (IProject)super.createFromString(eDataType, initialValue);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String convertEclipse_IProjectToString(EDataType eDataType, Object instanceValue) {
        return super.convertToString(eDataType, instanceValue);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Version createEclipse_VersionFromString(EDataType eDataType, String initialValue) {
        return (Version)super.createFromString(eDataType, initialValue);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String convertEclipse_VersionToString(EDataType eDataType, Object instanceValue) {
        return super.convertToString(eDataType, instanceValue);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public IFileStore createEclipse_IFileStoreFromString(EDataType eDataType, String initialValue) {
        return (IFileStore)super.createFromString(eDataType, initialValue);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String convertEclipse_IFileStoreToString(EDataType eDataType, Object instanceValue) {
        return super.convertToString(eDataType, instanceValue);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public org.eclipse.emf.common.util.URI createEcore_URIFromString(EDataType eDataType, String initialValue) {
        return (org.eclipse.emf.common.util.URI)super.createFromString(eDataType, initialValue);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String convertEcore_URIToString(EDataType eDataType, Object instanceValue) {
        return super.convertToString(eDataType, instanceValue);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EConfmlRootPackage getEConfmlRootPackage() {
        return (EConfmlRootPackage)getEPackage();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
	@Deprecated
	public static EConfmlRootPackage getPackage() {
        return EConfmlRootPackage.eINSTANCE;
    }

} //EConfmlRootFactoryImpl
