/*
* Copyright (c) 2009 Nokia Corporation and/or its subsidiary(-ies). 
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
package IBY.impl;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import IBY.Entity2;
import IBY.IBYPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Entity2</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link IBY.impl.Entity2Impl#getPlugin <em>Plugin</em>}</li>
 *   <li>{@link IBY.impl.Entity2Impl#getFiles <em>Files</em>}</li>
 *   <li>{@link IBY.impl.Entity2Impl#getTargets <em>Targets</em>}</li>
 *   <li>{@link IBY.impl.Entity2Impl#getComments <em>Comments</em>}</li>
 *   <li>{@link IBY.impl.Entity2Impl#getEncodings <em>Encodings</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class Entity2Impl extends EntityImpl implements Entity2 {
	/**
	 * The default value of the '{@link #getPlugin() <em>Plugin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlugin()
	 * @generated
	 * @ordered
	 */
	protected static final String PLUGIN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPlugin() <em>Plugin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlugin()
	 * @generated
	 * @ordered
	 */
	protected String plugin = PLUGIN_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFiles() <em>Files</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFiles()
	 * @generated
	 * @ordered
	 */
	protected Map<?, ?> files;

	/**
	 * The cached value of the '{@link #getTargets() <em>Targets</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargets()
	 * @generated
	 * @ordered
	 */
	protected Map<?, ?> targets;

	/**
	 * The cached value of the '{@link #getComments() <em>Comments</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComments()
	 * @generated
	 * @ordered
	 */
	protected Map<?, ?> comments;

	/**
	 * The cached value of the '{@link #getEncodings() <em>Encodings</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEncodings()
	 * @generated
	 * @ordered
	 */
	protected Map<?, ?> encodings;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Entity2Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IBYPackage.Literals.ENTITY2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPlugin() {
		return plugin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlugin(String newPlugin) {
		String oldPlugin = plugin;
		plugin = newPlugin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IBYPackage.ENTITY2__PLUGIN, oldPlugin, plugin));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map<?, ?> getFiles() {
		return files;
	}

	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFiles(Map<?, ?> newFiles) {
		Map<?, ?> oldFiles = files;
		files = newFiles;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IBYPackage.ENTITY2__FILES, oldFiles, files));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map<?, ?> getTargets() {
		return targets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargets(Map<?, ?> newTargets) {
		Map<?, ?> oldTargets = targets;
		targets = newTargets;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IBYPackage.ENTITY2__TARGETS, oldTargets, targets));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map<?, ?> getComments() {
		return comments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComments(Map<?, ?> newComments) {
		Map<?, ?> oldComments = comments;
		comments = newComments;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IBYPackage.ENTITY2__COMMENTS, oldComments, comments));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map<?, ?> getEncodings() {
		return encodings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEncodings(Map<?, ?> newEncodings) {
		Map<?, ?> oldEncodings = encodings;
		encodings = newEncodings;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IBYPackage.ENTITY2__ENCODINGS, oldEncodings, encodings));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IBYPackage.ENTITY2__PLUGIN:
				return getPlugin();
			case IBYPackage.ENTITY2__FILES:
				return getFiles();
			case IBYPackage.ENTITY2__TARGETS:
				return getTargets();
			case IBYPackage.ENTITY2__COMMENTS:
				return getComments();
			case IBYPackage.ENTITY2__ENCODINGS:
				return getEncodings();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case IBYPackage.ENTITY2__PLUGIN:
				setPlugin((String)newValue);
				return;
			case IBYPackage.ENTITY2__FILES:
				setFiles((Map<?, ?>)newValue);
				return;
			case IBYPackage.ENTITY2__TARGETS:
				setTargets((Map<?, ?>)newValue);
				return;
			case IBYPackage.ENTITY2__COMMENTS:
				setComments((Map<?, ?>)newValue);
				return;
			case IBYPackage.ENTITY2__ENCODINGS:
				setEncodings((Map<?, ?>)newValue);
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
			case IBYPackage.ENTITY2__PLUGIN:
				setPlugin(PLUGIN_EDEFAULT);
				return;
			case IBYPackage.ENTITY2__FILES:
				setFiles((Map<?, ?>)null);
				return;
			case IBYPackage.ENTITY2__TARGETS:
				setTargets((Map<?, ?>)null);
				return;
			case IBYPackage.ENTITY2__COMMENTS:
				setComments((Map<?, ?>)null);
				return;
			case IBYPackage.ENTITY2__ENCODINGS:
				setEncodings((Map<?, ?>)null);
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
			case IBYPackage.ENTITY2__PLUGIN:
				return PLUGIN_EDEFAULT == null ? plugin != null : !PLUGIN_EDEFAULT.equals(plugin);
			case IBYPackage.ENTITY2__FILES:
				return files != null;
			case IBYPackage.ENTITY2__TARGETS:
				return targets != null;
			case IBYPackage.ENTITY2__COMMENTS:
				return comments != null;
			case IBYPackage.ENTITY2__ENCODINGS:
				return encodings != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (plugin: ");
		result.append(plugin);
		result.append(", files: ");
		result.append(files);
		result.append(", targets: ");
		result.append(targets);
		result.append(", comments: ");
		result.append(comments);
		result.append(", encodings: ");
		result.append(encodings);
		result.append(')');
		return result.toString();
	}

} //Entity2Impl
