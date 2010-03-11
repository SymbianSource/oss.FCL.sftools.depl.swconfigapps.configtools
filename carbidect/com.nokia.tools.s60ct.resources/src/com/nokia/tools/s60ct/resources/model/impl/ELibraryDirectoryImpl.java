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
 * Description: This file is part of com.nokia.tools.variant.resourcelibrary component.
 */

package com.nokia.tools.s60ct.resources.model.impl;

import java.io.File;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.nokia.tools.s60ct.resources.model.ELibraryDirectory;
import com.nokia.tools.s60ct.resources.model.ELibraryElement;
import com.nokia.tools.s60ct.resources.model.ELibraryModelPackage;
import com.nokia.tools.vct.common.core.utils.FileUtils;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Directory</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.s60ct.resources.model.impl.ELibraryDirectoryImpl#getChildren <em>Children</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ELibraryDirectoryImpl extends ELibraryElementImpl implements ELibraryDirectory {
	/**
	 * The cached value of the '{@link #getChildren() <em>Children</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildren()
	 * @generated
	 * @ordered
	 */
	protected EList<ELibraryElement> children;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ELibraryDirectoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ELibraryModelPackage.Literals.ELIBRARY_DIRECTORY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ELibraryElement> getChildren() {
		if (children == null) {
			children = new EObjectContainmentEList<ELibraryElement>(ELibraryElement.class, this, ELibraryModelPackage.ELIBRARY_DIRECTORY__CHILDREN);
		}
		return children;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public ELibraryElement getChild(String name) {
		for (int i=0;i<getChildren().size();i++){
			ELibraryElement child = getChildren().get(i);
			if (child.getName().equalsIgnoreCase(name)){
				return child;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public boolean addChild(ELibraryElement child) {
		return getChildren().add(child);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public int getSize() {
		int size=0;
		for (int i=0;i<getChildren().size();i++){
			ELibraryElement child = getChildren().get(i);
			 if(child instanceof ELibraryDirectory)
				size+=((ELibraryDirectory)child).getSize();
			 else
				 size++;
		}
		return size;

	}

	/**
	 * Deletes directory for resource library together with its content from file system
	 * 
	 * @generated NOT
	 */
	public boolean deleteOnFileSystem() {
		String fullPath = getFullPath();
		return delete(new File(fullPath));
	}

	/**
	 * 
	 */
	public ELibraryElement findChild(IPath path) {
		if (path.isEmpty()) {
			return this;
		}
		ELibraryElement child = this;
		for (String segment: path.segments()) {
			if (child instanceof ELibraryDirectory) {
				child = ((ELibraryDirectory)child).getChild(segment);
			} else {
				return null;
			}
		}
		return child;
	}

	private boolean delete(File f) {
		try {
			FileUtils.deleteDirectory(f);
			return true;
		} catch (Throwable t) {
			return false;
		}
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ELibraryModelPackage.ELIBRARY_DIRECTORY__CHILDREN:
				return ((InternalEList<?>)getChildren()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ELibraryModelPackage.ELIBRARY_DIRECTORY__CHILDREN:
				return getChildren();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ELibraryModelPackage.ELIBRARY_DIRECTORY__CHILDREN:
				getChildren().clear();
				getChildren().addAll((Collection<? extends ELibraryElement>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ELibraryModelPackage.ELIBRARY_DIRECTORY__CHILDREN:
				getChildren().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ELibraryModelPackage.ELIBRARY_DIRECTORY__CHILDREN:
				return children != null && !children.isEmpty();
		}
		return super.eIsSet(featureID);
	}

//	@Override
//	public boolean touchedByReadonlySetting() {
//		for (int i = 0 ; i < settings.size() ; i++) {
//			if (OpenEditorAction.isIsItFileSettingWithReadOnlyLocalPath(settings.get(i))) {
//				return true;
//			}
//		}
//		return processChildrenElements(children);
//	}
	
	private static boolean processChildrenElements(List<ELibraryElement> children) {
		for (int i = 0 ; i < children.size() ; i++) {
			ELibraryElement fse = children.get(i);
			boolean touched = fse.touchedByReadonlySetting();
			if (touched) {
				return true;
			}
		}
		return false;
	}
	
} //DirectoryImpl
