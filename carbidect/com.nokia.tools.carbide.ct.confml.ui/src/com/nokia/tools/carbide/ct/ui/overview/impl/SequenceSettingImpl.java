/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.nokia.tools.carbide.ct.ui.overview.impl;

import com.nokia.tools.carbide.ct.ui.overview.OverviewPackage;
import com.nokia.tools.carbide.ct.ui.overview.SequenceSetting;
import com.nokia.tools.carbide.ct.ui.overview.SequenceValueItem;
import com.nokia.tools.carbide.ct.ui.overview.Setting;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sequence Setting</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.carbide.ct.ui.overview.impl.SequenceSettingImpl#getSubSettings <em>Sub Settings</em>}</li>
 *   <li>{@link com.nokia.tools.carbide.ct.ui.overview.impl.SequenceSettingImpl#getValues <em>Values</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SequenceSettingImpl extends SettingImpl implements SequenceSetting {
	/**
	 * The cached value of the '{@link #getSubSettings() <em>Sub Settings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubSettings()
	 * @generated
	 * @ordered
	 */
	protected EList<Setting> subSettings;

	/**
	 * The cached value of the '{@link #getValues() <em>Values</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValues()
	 * @generated
	 * @ordered
	 */
	protected EList<SequenceValueItem> values;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SequenceSettingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OverviewPackage.Literals.SEQUENCE_SETTING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Setting> getSubSettings() {
		if (subSettings == null) {
			subSettings = new EObjectContainmentEList<Setting>(Setting.class, this, OverviewPackage.SEQUENCE_SETTING__SUB_SETTINGS);
		}
		return subSettings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SequenceValueItem> getValues() {
		if (values == null) {
			values = new EObjectContainmentEList<SequenceValueItem>(SequenceValueItem.class, this, OverviewPackage.SEQUENCE_SETTING__VALUES);
		}
		return values;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OverviewPackage.SEQUENCE_SETTING__SUB_SETTINGS:
				return ((InternalEList<?>)getSubSettings()).basicRemove(otherEnd, msgs);
			case OverviewPackage.SEQUENCE_SETTING__VALUES:
				return ((InternalEList<?>)getValues()).basicRemove(otherEnd, msgs);
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
			case OverviewPackage.SEQUENCE_SETTING__SUB_SETTINGS:
				return getSubSettings();
			case OverviewPackage.SEQUENCE_SETTING__VALUES:
				return getValues();
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
			case OverviewPackage.SEQUENCE_SETTING__SUB_SETTINGS:
				getSubSettings().clear();
				getSubSettings().addAll((Collection<? extends Setting>)newValue);
				return;
			case OverviewPackage.SEQUENCE_SETTING__VALUES:
				getValues().clear();
				getValues().addAll((Collection<? extends SequenceValueItem>)newValue);
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
			case OverviewPackage.SEQUENCE_SETTING__SUB_SETTINGS:
				getSubSettings().clear();
				return;
			case OverviewPackage.SEQUENCE_SETTING__VALUES:
				getValues().clear();
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
			case OverviewPackage.SEQUENCE_SETTING__SUB_SETTINGS:
				return subSettings != null && !subSettings.isEmpty();
			case OverviewPackage.SEQUENCE_SETTING__VALUES:
				return values != null && !values.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SequenceSettingImpl
