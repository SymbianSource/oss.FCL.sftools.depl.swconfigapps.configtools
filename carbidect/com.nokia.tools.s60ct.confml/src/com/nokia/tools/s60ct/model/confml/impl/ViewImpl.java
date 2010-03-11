/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.nokia.tools.s60ct.model.confml.impl;

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
import org.eclipse.emf.ecore.util.InternalEList;

import com.nokia.tools.s60ct.model.confml.ConfmlPackage;
import com.nokia.tools.s60ct.model.confml.EFeature;
import com.nokia.tools.s60ct.model.confml.ESetting;
import com.nokia.tools.s60ct.model.confml.View;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>View</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.ViewImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.ViewImpl#getSharedSettingInstances <em>Shared Setting Instances</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.ViewImpl#getSharedFeatures <em>Shared Features</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ViewImpl extends EObjectImpl implements View {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSharedSettingInstances() <em>Shared Setting Instances</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSharedSettingInstances()
	 * @generated
	 * @ordered
	 */
	protected EList<ESetting> sharedSettingInstances;

	/**
	 * The cached value of the '{@link #getSharedFeatures() <em>Shared Features</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSharedFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<EFeature> sharedFeatures;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ViewImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfmlPackage.Literals.VIEW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.VIEW__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @NOT generated
	 */
	public EList<ESetting> getSharedSettingInstances()
	{
		EList<ESetting> settings = new BasicEList<ESetting>();
		
		for (int i = 0 ; i < sharedFeatures.size() ; i++)
		{
			settings.addAll(sharedFeatures.get(i).getSettings());
		}
		
		return settings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EFeature> getSharedFeatures() {
		if (sharedFeatures == null) {
			sharedFeatures = new EObjectContainmentEList<EFeature>(EFeature.class, this, ConfmlPackage.VIEW__SHARED_FEATURES);
		}
		return sharedFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConfmlPackage.VIEW__SHARED_SETTING_INSTANCES:
				return ((InternalEList<?>)getSharedSettingInstances()).basicRemove(otherEnd, msgs);
			case ConfmlPackage.VIEW__SHARED_FEATURES:
				return ((InternalEList<?>)getSharedFeatures()).basicRemove(otherEnd, msgs);
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
			case ConfmlPackage.VIEW__NAME:
				return getName();
			case ConfmlPackage.VIEW__SHARED_SETTING_INSTANCES:
				return getSharedSettingInstances();
			case ConfmlPackage.VIEW__SHARED_FEATURES:
				return getSharedFeatures();
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
			case ConfmlPackage.VIEW__NAME:
				setName((String)newValue);
				return;
			case ConfmlPackage.VIEW__SHARED_SETTING_INSTANCES:
				getSharedSettingInstances().clear();
				getSharedSettingInstances().addAll((Collection<? extends ESetting>)newValue);
				return;
			case ConfmlPackage.VIEW__SHARED_FEATURES:
				getSharedFeatures().clear();
				getSharedFeatures().addAll((Collection<? extends EFeature>)newValue);
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
			case ConfmlPackage.VIEW__NAME:
				setName(NAME_EDEFAULT);
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ConfmlPackage.VIEW__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ConfmlPackage.VIEW__SHARED_SETTING_INSTANCES:
				return sharedSettingInstances != null && !sharedSettingInstances.isEmpty();
			case ConfmlPackage.VIEW__SHARED_FEATURES:
				return sharedFeatures != null && !sharedFeatures.isEmpty();
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //ViewImpl
