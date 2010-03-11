/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.nokia.tools.s60ct.model.confml.impl;

import com.nokia.tools.s60ct.model.confml.ConfmlPackage;
import com.nokia.tools.s60ct.model.confml.EFeature;
import com.nokia.tools.s60ct.model.confml.EGroup;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EGroup</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.EGroupImpl#getDescriptionText <em>Description Text</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.EGroupImpl#getDescriptionUri <em>Description Uri</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.EGroupImpl#getDescriptionUriText <em>Description Uri Text</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.EGroupImpl#getFeatures <em>Features</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.EGroupImpl#getSettingOrder <em>Setting Order</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.EGroupImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EGroupImpl extends EObjectImpl implements EGroup {
	/**
	 * The default value of the '{@link #getDescriptionText() <em>Description Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescriptionText()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_TEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescriptionText() <em>Description Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescriptionText()
	 * @generated
	 * @ordered
	 */
	protected String descriptionText = DESCRIPTION_TEXT_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescriptionUri() <em>Description Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescriptionUri()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescriptionUri() <em>Description Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescriptionUri()
	 * @generated
	 * @ordered
	 */
	protected String descriptionUri = DESCRIPTION_URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescriptionUriText() <em>Description Uri Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescriptionUriText()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_URI_TEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescriptionUriText() <em>Description Uri Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescriptionUriText()
	 * @generated
	 * @ordered
	 */
	protected String descriptionUriText = DESCRIPTION_URI_TEXT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFeatures() <em>Features</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<EFeature> features;

	/**
	 * The cached value of the '{@link #getSettingOrder() <em>Setting Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSettingOrder()
	 * @generated
	 * @ordered
	 */
	protected EList<String> settingOrder;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EGroupImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfmlPackage.Literals.EGROUP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescriptionText() {
		return descriptionText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescriptionText(String newDescriptionText) {
		String oldDescriptionText = descriptionText;
		descriptionText = newDescriptionText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.EGROUP__DESCRIPTION_TEXT, oldDescriptionText, descriptionText));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescriptionUri() {
		return descriptionUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescriptionUri(String newDescriptionUri) {
		String oldDescriptionUri = descriptionUri;
		descriptionUri = newDescriptionUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.EGROUP__DESCRIPTION_URI, oldDescriptionUri, descriptionUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescriptionUriText() {
		return descriptionUriText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescriptionUriText(String newDescriptionUriText) {
		String oldDescriptionUriText = descriptionUriText;
		descriptionUriText = newDescriptionUriText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.EGROUP__DESCRIPTION_URI_TEXT, oldDescriptionUriText, descriptionUriText));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EFeature> getFeatures() {
		if (features == null) {
			features = new EObjectResolvingEList<EFeature>(EFeature.class, this, ConfmlPackage.EGROUP__FEATURES);
		}
		return features;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getSettingOrder() {
		return settingOrder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSettingOrder(EList<String> newSettingOrder) {
		EList<String> oldSettingOrder = settingOrder;
		settingOrder = newSettingOrder;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.EGROUP__SETTING_ORDER, oldSettingOrder, settingOrder));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.EGROUP__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConfmlPackage.EGROUP__DESCRIPTION_TEXT:
				return getDescriptionText();
			case ConfmlPackage.EGROUP__DESCRIPTION_URI:
				return getDescriptionUri();
			case ConfmlPackage.EGROUP__DESCRIPTION_URI_TEXT:
				return getDescriptionUriText();
			case ConfmlPackage.EGROUP__FEATURES:
				return getFeatures();
			case ConfmlPackage.EGROUP__SETTING_ORDER:
				return getSettingOrder();
			case ConfmlPackage.EGROUP__NAME:
				return getName();
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
			case ConfmlPackage.EGROUP__DESCRIPTION_TEXT:
				setDescriptionText((String)newValue);
				return;
			case ConfmlPackage.EGROUP__DESCRIPTION_URI:
				setDescriptionUri((String)newValue);
				return;
			case ConfmlPackage.EGROUP__DESCRIPTION_URI_TEXT:
				setDescriptionUriText((String)newValue);
				return;
			case ConfmlPackage.EGROUP__FEATURES:
				getFeatures().clear();
				getFeatures().addAll((Collection<? extends EFeature>)newValue);
				return;
			case ConfmlPackage.EGROUP__SETTING_ORDER:
				setSettingOrder((EList<String>)newValue);
				return;
			case ConfmlPackage.EGROUP__NAME:
				setName((String)newValue);
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
			case ConfmlPackage.EGROUP__DESCRIPTION_TEXT:
				setDescriptionText(DESCRIPTION_TEXT_EDEFAULT);
				return;
			case ConfmlPackage.EGROUP__DESCRIPTION_URI:
				setDescriptionUri(DESCRIPTION_URI_EDEFAULT);
				return;
			case ConfmlPackage.EGROUP__DESCRIPTION_URI_TEXT:
				setDescriptionUriText(DESCRIPTION_URI_TEXT_EDEFAULT);
				return;
			case ConfmlPackage.EGROUP__FEATURES:
				getFeatures().clear();
				return;
			case ConfmlPackage.EGROUP__SETTING_ORDER:
				setSettingOrder((EList<String>)null);
				return;
			case ConfmlPackage.EGROUP__NAME:
				setName(NAME_EDEFAULT);
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
			case ConfmlPackage.EGROUP__DESCRIPTION_TEXT:
				return DESCRIPTION_TEXT_EDEFAULT == null ? descriptionText != null : !DESCRIPTION_TEXT_EDEFAULT.equals(descriptionText);
			case ConfmlPackage.EGROUP__DESCRIPTION_URI:
				return DESCRIPTION_URI_EDEFAULT == null ? descriptionUri != null : !DESCRIPTION_URI_EDEFAULT.equals(descriptionUri);
			case ConfmlPackage.EGROUP__DESCRIPTION_URI_TEXT:
				return DESCRIPTION_URI_TEXT_EDEFAULT == null ? descriptionUriText != null : !DESCRIPTION_URI_TEXT_EDEFAULT.equals(descriptionUriText);
			case ConfmlPackage.EGROUP__FEATURES:
				return features != null && !features.isEmpty();
			case ConfmlPackage.EGROUP__SETTING_ORDER:
				return settingOrder != null;
			case ConfmlPackage.EGROUP__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
		result.append(" (descriptionText: ");
		result.append(descriptionText);
		result.append(", descriptionUri: ");
		result.append(descriptionUri);
		result.append(", descriptionUriText: ");
		result.append(descriptionUriText);
		result.append(", settingOrder: ");
		result.append(settingOrder);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //EGroupImpl
