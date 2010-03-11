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
package configurationemf.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import configurationemf.Configuration;
import configurationemf.ConfigurationemfPackage;
import configurationemf.Icon;
import configurationemf.Link;
import configurationemf.Meta;
import configurationemf.ParentGroup;
import configurationemf.View;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>View</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link configurationemf.impl.ViewImpl#getName <em>Name</em>}</li>
 *   <li>{@link configurationemf.impl.ViewImpl#getConf <em>Conf</em>}</li>
 *   <li>{@link configurationemf.impl.ViewImpl#getMeta <em>Meta</em>}</li>
 *   <li>{@link configurationemf.impl.ViewImpl#getParentGroup <em>Parent Group</em>}</li>
 *   <li>{@link configurationemf.impl.ViewImpl#getLink <em>Link</em>}</li>
 *   <li>{@link configurationemf.impl.ViewImpl#getIcon <em>Icon</em>}</li>
 *   <li>{@link configurationemf.impl.ViewImpl#isReadOnly <em>Read Only</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ViewImpl extends AttributeAndDescImpl implements View {
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
	 * The cached value of the '{@link #getMeta() <em>Meta</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeta()
	 * @generated
	 * @ordered
	 */
	protected Meta meta;

	/**
	 * The cached value of the '{@link #getParentGroup() <em>Parent Group</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentGroup()
	 * @generated
	 * @ordered
	 */
	protected EList<ParentGroup> parentGroup;

	/**
	 * The cached value of the '{@link #getLink() <em>Link</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink()
	 * @generated
	 * @ordered
	 */
	protected EList<Link> link;

	/**
	 * The cached value of the '{@link #getIcon() <em>Icon</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIcon()
	 * @generated
	 * @ordered
	 */
	protected EList<Icon> icon;

	/**
	 * The default value of the '{@link #isReadOnly() <em>Read Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReadOnly()
	 * @generated
	 * @ordered
	 */
	protected static final boolean READ_ONLY_EDEFAULT = false;

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
		return ConfigurationemfPackage.Literals.VIEW;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.VIEW__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Configuration getConf() {
		if (eContainerFeatureID != ConfigurationemfPackage.VIEW__CONF) return null;
		return (Configuration)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConf(Configuration newConf, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newConf, ConfigurationemfPackage.VIEW__CONF, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConf(Configuration newConf) {
		if (newConf != eInternalContainer() || (eContainerFeatureID != ConfigurationemfPackage.VIEW__CONF && newConf != null)) {
			if (EcoreUtil.isAncestor(this, newConf))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newConf != null)
				msgs = ((InternalEObject)newConf).eInverseAdd(this, ConfigurationemfPackage.CONFIGURATION__VIEW, Configuration.class, msgs);
			msgs = basicSetConf(newConf, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.VIEW__CONF, newConf, newConf));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Meta getMeta() {
		return meta;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMeta(Meta newMeta, NotificationChain msgs) {
		Meta oldMeta = meta;
		meta = newMeta;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.VIEW__META, oldMeta, newMeta);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMeta(Meta newMeta) {
		if (newMeta != meta) {
			NotificationChain msgs = null;
			if (meta != null)
				msgs = ((InternalEObject)meta).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfigurationemfPackage.VIEW__META, null, msgs);
			if (newMeta != null)
				msgs = ((InternalEObject)newMeta).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfigurationemfPackage.VIEW__META, null, msgs);
			msgs = basicSetMeta(newMeta, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.VIEW__META, newMeta, newMeta));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ParentGroup> getParentGroup() {
		if (parentGroup == null) {
			parentGroup = new EObjectContainmentEList<ParentGroup>(ParentGroup.class, this, ConfigurationemfPackage.VIEW__PARENT_GROUP);
		}
		return parentGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Link> getLink() {
		if (link == null) {
			link = new EObjectContainmentEList<Link>(Link.class, this, ConfigurationemfPackage.VIEW__LINK);
		}
		return link;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Icon> getIcon() {
		if (icon == null) {
			icon = new EObjectContainmentEList<Icon>(Icon.class, this, ConfigurationemfPackage.VIEW__ICON);
		}
		return icon;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isReadOnly() {
		Configuration parent = (Configuration)this.eContainer;
		if(parent==null)return false;
		return parent.isReadOnly();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConfigurationemfPackage.VIEW__CONF:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetConf((Configuration)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConfigurationemfPackage.VIEW__CONF:
				return basicSetConf(null, msgs);
			case ConfigurationemfPackage.VIEW__META:
				return basicSetMeta(null, msgs);
			case ConfigurationemfPackage.VIEW__PARENT_GROUP:
				return ((InternalEList<?>)getParentGroup()).basicRemove(otherEnd, msgs);
			case ConfigurationemfPackage.VIEW__LINK:
				return ((InternalEList<?>)getLink()).basicRemove(otherEnd, msgs);
			case ConfigurationemfPackage.VIEW__ICON:
				return ((InternalEList<?>)getIcon()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID) {
			case ConfigurationemfPackage.VIEW__CONF:
				return eInternalContainer().eInverseRemove(this, ConfigurationemfPackage.CONFIGURATION__VIEW, Configuration.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConfigurationemfPackage.VIEW__NAME:
				return getName();
			case ConfigurationemfPackage.VIEW__CONF:
				return getConf();
			case ConfigurationemfPackage.VIEW__META:
				return getMeta();
			case ConfigurationemfPackage.VIEW__PARENT_GROUP:
				return getParentGroup();
			case ConfigurationemfPackage.VIEW__LINK:
				return getLink();
			case ConfigurationemfPackage.VIEW__ICON:
				return getIcon();
			case ConfigurationemfPackage.VIEW__READ_ONLY:
				return isReadOnly() ? Boolean.TRUE : Boolean.FALSE;
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
			case ConfigurationemfPackage.VIEW__NAME:
				setName((String)newValue);
				return;
			case ConfigurationemfPackage.VIEW__CONF:
				setConf((Configuration)newValue);
				return;
			case ConfigurationemfPackage.VIEW__META:
				setMeta((Meta)newValue);
				return;
			case ConfigurationemfPackage.VIEW__PARENT_GROUP:
				getParentGroup().clear();
				getParentGroup().addAll((Collection<? extends ParentGroup>)newValue);
				return;
			case ConfigurationemfPackage.VIEW__LINK:
				getLink().clear();
				getLink().addAll((Collection<? extends Link>)newValue);
				return;
			case ConfigurationemfPackage.VIEW__ICON:
				getIcon().clear();
				getIcon().addAll((Collection<? extends Icon>)newValue);
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
			case ConfigurationemfPackage.VIEW__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ConfigurationemfPackage.VIEW__CONF:
				setConf((Configuration)null);
				return;
			case ConfigurationemfPackage.VIEW__META:
				setMeta((Meta)null);
				return;
			case ConfigurationemfPackage.VIEW__PARENT_GROUP:
				getParentGroup().clear();
				return;
			case ConfigurationemfPackage.VIEW__LINK:
				getLink().clear();
				return;
			case ConfigurationemfPackage.VIEW__ICON:
				getIcon().clear();
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
			case ConfigurationemfPackage.VIEW__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ConfigurationemfPackage.VIEW__CONF:
				return getConf() != null;
			case ConfigurationemfPackage.VIEW__META:
				return meta != null;
			case ConfigurationemfPackage.VIEW__PARENT_GROUP:
				return parentGroup != null && !parentGroup.isEmpty();
			case ConfigurationemfPackage.VIEW__LINK:
				return link != null && !link.isEmpty();
			case ConfigurationemfPackage.VIEW__ICON:
				return icon != null && !icon.isEmpty();
			case ConfigurationemfPackage.VIEW__READ_ONLY:
				return isReadOnly() != READ_ONLY_EDEFAULT;
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