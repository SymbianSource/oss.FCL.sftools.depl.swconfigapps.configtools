/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.nokia.tools.carbide.ct.ui.overview.impl;

import com.nokia.tools.carbide.ct.ui.overview.OverviewPackage;
import com.nokia.tools.carbide.ct.ui.overview.SequenceValueItem;
import com.nokia.tools.carbide.ct.ui.overview.SimpleValue;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sequence Value Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.carbide.ct.ui.overview.impl.SequenceValueItemImpl#getSubValues <em>Sub Values</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SequenceValueItemImpl extends EObjectImpl implements SequenceValueItem {
	/**
	 * The cached value of the '{@link #getSubValues() <em>Sub Values</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubValues()
	 * @generated
	 * @ordered
	 */
	protected EList<SimpleValue> subValues;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SequenceValueItemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OverviewPackage.Literals.SEQUENCE_VALUE_ITEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SimpleValue> getSubValues() {
		if (subValues == null) {
			subValues = new EObjectContainmentEList<SimpleValue>(SimpleValue.class, this, OverviewPackage.SEQUENCE_VALUE_ITEM__SUB_VALUES);
		}
		return subValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OverviewPackage.SEQUENCE_VALUE_ITEM__SUB_VALUES:
				return ((InternalEList<?>)getSubValues()).basicRemove(otherEnd, msgs);
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
			case OverviewPackage.SEQUENCE_VALUE_ITEM__SUB_VALUES:
				return getSubValues();
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
			case OverviewPackage.SEQUENCE_VALUE_ITEM__SUB_VALUES:
				getSubValues().clear();
				getSubValues().addAll((Collection<? extends SimpleValue>)newValue);
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
			case OverviewPackage.SEQUENCE_VALUE_ITEM__SUB_VALUES:
				getSubValues().clear();
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
			case OverviewPackage.SEQUENCE_VALUE_ITEM__SUB_VALUES:
				return subValues != null && !subValues.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SequenceValueItemImpl
