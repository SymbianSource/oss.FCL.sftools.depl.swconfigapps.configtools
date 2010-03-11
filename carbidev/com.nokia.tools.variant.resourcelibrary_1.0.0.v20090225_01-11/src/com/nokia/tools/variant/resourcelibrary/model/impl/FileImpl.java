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

package com.nokia.tools.variant.resourcelibrary.model.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.content.IContentDescription;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.nokia.tools.variant.common.core.utils.FileUtils;
import com.nokia.tools.variant.resourcelibrary.actions.OpenEditorAction;
import com.nokia.tools.variant.resourcelibrary.model.File;
import com.nokia.tools.variant.resourcelibrary.model.resourcesPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>File</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.variant.resourcelibrary.model.impl.FileImpl#getSize <em>Size</em>}</li>
 *   <li>{@link com.nokia.tools.variant.resourcelibrary.model.impl.FileImpl#getContentDescription <em>Content Description</em>}</li>
 *   <li>{@link com.nokia.tools.variant.resourcelibrary.model.impl.FileImpl#getDefaultResource <em>Default Resource</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FileImpl extends FileSystemElementImpl implements File {
	/**
	 * The default value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected static final long SIZE_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected long size = SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getContentDescription() <em>Content Description</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getContentDescription()
	 * @generated
	 * @ordered
	 */
	protected static final IContentDescription CONTENT_DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getContentDescription() <em>Content Description</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getContentDescription()
	 * @generated
	 * @ordered
	 */
	protected IContentDescription contentDescription = CONTENT_DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getDefaultResource() <em>Default Resource</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getDefaultResource()
	 * @generated
	 * @ordered
	 */
	protected static final java.io.File DEFAULT_RESOURCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefaultResource() <em>Default Resource</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getDefaultResource()
	 * @generated
	 * @ordered
	 */
	protected java.io.File defaultResource = DEFAULT_RESOURCE_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected FileImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return resourcesPackage.Literals.FILE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public long getSize() {
		return size;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSize(long newSize) {
		long oldSize = size;
		size = newSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, resourcesPackage.FILE__SIZE, oldSize, size));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public IContentDescription getContentDescription() {
		if (contentDescription == null) {
			recomputeContentDescription();
		}

		return contentDescription;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public java.io.File getDefaultResource() {
		return defaultResource;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultResource(java.io.File newDefaultResource) {
		java.io.File oldDefaultResource = defaultResource;
		defaultResource = newDefaultResource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, resourcesPackage.FILE__DEFAULT_RESOURCE, oldDefaultResource, defaultResource));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public InputStream getInputStream() {
		try {
			return new FileInputStream(getFullPath());
		} catch (FileNotFoundException e) {
			return null;
		}
	}

	/**
	 * Recomputes content description after its underlying resource has been changed.
	 * This method needs to be called to refresh its content description.
	 */
	public void recomputeContentDescription() {
		try {
			InputStream contents = getInputStream();
			try {
				contentDescription = Platform.getContentTypeManager()
						.getDescriptionFor(contents, getName(),
								IContentDescription.ALL);
			} finally {
				FileUtils.closeStream(contents);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case resourcesPackage.FILE__SIZE:
				return new Long(getSize());
			case resourcesPackage.FILE__CONTENT_DESCRIPTION:
				return getContentDescription();
			case resourcesPackage.FILE__DEFAULT_RESOURCE:
				return getDefaultResource();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case resourcesPackage.FILE__SIZE:
				setSize(((Long)newValue).longValue());
				return;
			case resourcesPackage.FILE__DEFAULT_RESOURCE:
				setDefaultResource((java.io.File)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case resourcesPackage.FILE__SIZE:
				setSize(SIZE_EDEFAULT);
				return;
			case resourcesPackage.FILE__DEFAULT_RESOURCE:
				setDefaultResource(DEFAULT_RESOURCE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case resourcesPackage.FILE__SIZE:
				return size != SIZE_EDEFAULT;
			case resourcesPackage.FILE__CONTENT_DESCRIPTION:
				return CONTENT_DESCRIPTION_EDEFAULT == null ? contentDescription != null : !CONTENT_DESCRIPTION_EDEFAULT.equals(contentDescription);
			case resourcesPackage.FILE__DEFAULT_RESOURCE:
				return DEFAULT_RESOURCE_EDEFAULT == null ? defaultResource != null : !DEFAULT_RESOURCE_EDEFAULT.equals(defaultResource);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (size: ");
		result.append(size);
		result.append(", contentDescription: ");
		result.append(contentDescription);
		result.append(", defaultResource: ");
		result.append(defaultResource);
		result.append(')');
		return result.toString();
	}

	
	
	@Override
	public boolean touchedByReadonlySetting() {
		boolean readOnly = false;
		for (int i = 0 ; i < settings.size() ; i++) {
			if (OpenEditorAction.isIsItFileSettingWithReadOnlyLocalPath(settings.get(i))) {
				return true;
			}
		}
		return readOnly;
	}
} // FileImpl
