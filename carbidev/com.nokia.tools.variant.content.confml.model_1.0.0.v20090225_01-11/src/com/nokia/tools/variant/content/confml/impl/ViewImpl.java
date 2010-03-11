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
 * Description: This file is part of com.nokia.tools.variant.content.confml.model component.
 */

package com.nokia.tools.variant.content.confml.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.nokia.tools.variant.content.confml.ConfmlPackage;
import com.nokia.tools.variant.content.confml.Feature;
import com.nokia.tools.variant.content.confml.Icon;
import com.nokia.tools.variant.content.confml.LeafGroup;
import com.nokia.tools.variant.content.confml.ParentGroup;
import com.nokia.tools.variant.content.confml.Setting;
import com.nokia.tools.variant.content.confml.View;


/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>View</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.variant.content.confml.impl.ViewImpl#getParentGroup <em>Parent Group</em>}</li>
 *   <li>{@link com.nokia.tools.variant.content.confml.impl.ViewImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.nokia.tools.variant.content.confml.impl.ViewImpl#getIcon <em>Icon</em>}</li>
 *   <li>{@link com.nokia.tools.variant.content.confml.impl.ViewImpl#getSharedSettingInstances <em>Shared Setting Instances</em>}</li>
 *   <li>{@link com.nokia.tools.variant.content.confml.impl.ViewImpl#getSharedFeatures <em>Shared Features</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ViewImpl extends EObjectImpl implements View {
	/**
	 * The cached value of the '{@link #getParentGroup() <em>Parent Group</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getParentGroup()
	 * @generated
	 * @ordered
	 */
	protected EList<ParentGroup> parentGroup;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getIcon() <em>Icon</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getIcon()
	 * @generated
	 * @ordered
	 */
	protected EList<Icon> icon;

	/**
	 * The cached value of the '{@link #getSharedSettingInstances() <em>Shared Setting Instances</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSharedSettingInstances()
	 * @generated
	 * @ordered
	 */
	protected EList<Setting> sharedSettingInstances;

	/**
	 * The cached value of the '{@link #getSharedFeatures() <em>Shared Features</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSharedFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<Feature> sharedFeatures;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ViewImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfmlPackage.Literals.VIEW;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ParentGroup> getParentGroup() {
		if (parentGroup == null) {
			parentGroup = new EObjectContainmentEList<ParentGroup>(ParentGroup.class, this, ConfmlPackage.VIEW__PARENT_GROUP);
		}
		return parentGroup;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.VIEW__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Icon> getIcon() {
		if (icon == null) {
			icon = new EObjectContainmentEList<Icon>(Icon.class, this, ConfmlPackage.VIEW__ICON);
		}
		return icon;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Setting> getSharedSettingInstances() {
		if (sharedSettingInstances == null) {
			sharedSettingInstances = new EObjectContainmentEList<Setting>(Setting.class, this, ConfmlPackage.VIEW__SHARED_SETTING_INSTANCES);
		}
		return sharedSettingInstances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Feature> getSharedFeatures() {
		if (sharedFeatures == null) {
			sharedFeatures = new EObjectContainmentEList<Feature>(Feature.class, this, ConfmlPackage.VIEW__SHARED_FEATURES);
		}
		return sharedFeatures;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<Setting> getAllSettings() {

		EList<Setting> allList = new BasicEList<Setting>();
		EList<ParentGroup> listParentGroup = getParentGroup();
		for (ParentGroup parentGroup : listParentGroup) {
			EList<LeafGroup> listLeafGroup = parentGroup.getLeafGroup();

			for (LeafGroup leafGroup : listLeafGroup) {
				allList.addAll(leafGroup.getSettings());

			}
		}
		return allList;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConfmlPackage.VIEW__PARENT_GROUP:
				return ((InternalEList<?>)getParentGroup()).basicRemove(otherEnd, msgs);
			case ConfmlPackage.VIEW__ICON:
				return ((InternalEList<?>)getIcon()).basicRemove(otherEnd, msgs);
			case ConfmlPackage.VIEW__SHARED_SETTING_INSTANCES:
				return ((InternalEList<?>)getSharedSettingInstances()).basicRemove(otherEnd, msgs);
			case ConfmlPackage.VIEW__SHARED_FEATURES:
				return ((InternalEList<?>)getSharedFeatures()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConfmlPackage.VIEW__PARENT_GROUP:
				return getParentGroup();
			case ConfmlPackage.VIEW__NAME:
				return getName();
			case ConfmlPackage.VIEW__ICON:
				return getIcon();
			case ConfmlPackage.VIEW__SHARED_SETTING_INSTANCES:
				return getSharedSettingInstances();
			case ConfmlPackage.VIEW__SHARED_FEATURES:
				return getSharedFeatures();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ConfmlPackage.VIEW__PARENT_GROUP:
				getParentGroup().clear();
				getParentGroup().addAll((Collection<? extends ParentGroup>)newValue);
				return;
			case ConfmlPackage.VIEW__NAME:
				setName((String)newValue);
				return;
			case ConfmlPackage.VIEW__ICON:
				getIcon().clear();
				getIcon().addAll((Collection<? extends Icon>)newValue);
				return;
			case ConfmlPackage.VIEW__SHARED_SETTING_INSTANCES:
				getSharedSettingInstances().clear();
				getSharedSettingInstances().addAll((Collection<? extends Setting>)newValue);
				return;
			case ConfmlPackage.VIEW__SHARED_FEATURES:
				getSharedFeatures().clear();
				getSharedFeatures().addAll((Collection<? extends Feature>)newValue);
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
			case ConfmlPackage.VIEW__PARENT_GROUP:
				getParentGroup().clear();
				return;
			case ConfmlPackage.VIEW__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ConfmlPackage.VIEW__ICON:
				getIcon().clear();
				return;
			case ConfmlPackage.VIEW__SHARED_SETTING_INSTANCES:
				getSharedSettingInstances().clear();
				return;
			case ConfmlPackage.VIEW__SHARED_FEATURES:
				getSharedFeatures().clear();
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
			case ConfmlPackage.VIEW__PARENT_GROUP:
				return parentGroup != null && !parentGroup.isEmpty();
			case ConfmlPackage.VIEW__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ConfmlPackage.VIEW__ICON:
				return icon != null && !icon.isEmpty();
			case ConfmlPackage.VIEW__SHARED_SETTING_INSTANCES:
				return sharedSettingInstances != null && !sharedSettingInstances.isEmpty();
			case ConfmlPackage.VIEW__SHARED_FEATURES:
				return sharedFeatures != null && !sharedFeatures.isEmpty();
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} // ViewImpl
