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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import configurationemf.ConfigurationemfPackage;
import configurationemf.Customer;
import configurationemf.Date;
import configurationemf.Editor;
import configurationemf.Identification;
import configurationemf.Meta;
import configurationemf.Owner;
import configurationemf.Platform;
import configurationemf.Product;
import configurationemf.Release;
import configurationemf.Status;
import configurationemf.Version;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Meta</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link configurationemf.impl.MetaImpl#getIdentification <em>Identification</em>}</li>
 *   <li>{@link configurationemf.impl.MetaImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link configurationemf.impl.MetaImpl#getEditor <em>Editor</em>}</li>
 *   <li>{@link configurationemf.impl.MetaImpl#getStatus <em>Status</em>}</li>
 *   <li>{@link configurationemf.impl.MetaImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link configurationemf.impl.MetaImpl#getPlatform <em>Platform</em>}</li>
 *   <li>{@link configurationemf.impl.MetaImpl#getProduct <em>Product</em>}</li>
 *   <li>{@link configurationemf.impl.MetaImpl#getCustomer <em>Customer</em>}</li>
 *   <li>{@link configurationemf.impl.MetaImpl#getDate <em>Date</em>}</li>
 *   <li>{@link configurationemf.impl.MetaImpl#getRelease <em>Release</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MetaImpl extends CommonAttrImpl implements Meta {
	/**
	 * The cached value of the '{@link #getIdentification() <em>Identification</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentification()
	 * @generated
	 * @ordered
	 */
	protected Identification identification;

	/**
	 * The cached value of the '{@link #getOwner() <em>Owner</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwner()
	 * @generated
	 * @ordered
	 */
	protected Owner owner;

	/**
	 * The cached value of the '{@link #getEditor() <em>Editor</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEditor()
	 * @generated
	 * @ordered
	 */
	protected Editor editor;

	/**
	 * The cached value of the '{@link #getStatus() <em>Status</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected Status status;

	/**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected Version version;

	/**
	 * The cached value of the '{@link #getPlatform() <em>Platform</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlatform()
	 * @generated
	 * @ordered
	 */
	protected Platform platform;

	/**
	 * The cached value of the '{@link #getProduct() <em>Product</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProduct()
	 * @generated
	 * @ordered
	 */
	protected Product product;

	/**
	 * The cached value of the '{@link #getCustomer() <em>Customer</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCustomer()
	 * @generated
	 * @ordered
	 */
	protected Customer customer;

	/**
	 * The cached value of the '{@link #getDate() <em>Date</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected Date date;

	/**
	 * The cached value of the '{@link #getRelease() <em>Release</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelease()
	 * @generated
	 * @ordered
	 */
	protected Release release;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MetaImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigurationemfPackage.Literals.META;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Identification getIdentification() {
		return identification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIdentification(Identification newIdentification, NotificationChain msgs) {
		Identification oldIdentification = identification;
		identification = newIdentification;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.META__IDENTIFICATION, oldIdentification, newIdentification);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdentification(Identification newIdentification) {
		if (newIdentification != identification) {
			NotificationChain msgs = null;
			if (identification != null)
				msgs = ((InternalEObject)identification).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfigurationemfPackage.META__IDENTIFICATION, null, msgs);
			if (newIdentification != null)
				msgs = ((InternalEObject)newIdentification).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfigurationemfPackage.META__IDENTIFICATION, null, msgs);
			msgs = basicSetIdentification(newIdentification, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.META__IDENTIFICATION, newIdentification, newIdentification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Owner getOwner() {
		return owner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwner(Owner newOwner, NotificationChain msgs) {
		Owner oldOwner = owner;
		owner = newOwner;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.META__OWNER, oldOwner, newOwner);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(Owner newOwner) {
		if (newOwner != owner) {
			NotificationChain msgs = null;
			if (owner != null)
				msgs = ((InternalEObject)owner).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfigurationemfPackage.META__OWNER, null, msgs);
			if (newOwner != null)
				msgs = ((InternalEObject)newOwner).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfigurationemfPackage.META__OWNER, null, msgs);
			msgs = basicSetOwner(newOwner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.META__OWNER, newOwner, newOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Editor getEditor() {
		return editor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEditor(Editor newEditor, NotificationChain msgs) {
		Editor oldEditor = editor;
		editor = newEditor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.META__EDITOR, oldEditor, newEditor);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEditor(Editor newEditor) {
		if (newEditor != editor) {
			NotificationChain msgs = null;
			if (editor != null)
				msgs = ((InternalEObject)editor).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfigurationemfPackage.META__EDITOR, null, msgs);
			if (newEditor != null)
				msgs = ((InternalEObject)newEditor).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfigurationemfPackage.META__EDITOR, null, msgs);
			msgs = basicSetEditor(newEditor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.META__EDITOR, newEditor, newEditor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStatus(Status newStatus, NotificationChain msgs) {
		Status oldStatus = status;
		status = newStatus;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.META__STATUS, oldStatus, newStatus);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatus(Status newStatus) {
		if (newStatus != status) {
			NotificationChain msgs = null;
			if (status != null)
				msgs = ((InternalEObject)status).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfigurationemfPackage.META__STATUS, null, msgs);
			if (newStatus != null)
				msgs = ((InternalEObject)newStatus).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfigurationemfPackage.META__STATUS, null, msgs);
			msgs = basicSetStatus(newStatus, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.META__STATUS, newStatus, newStatus));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Version getVersion() {
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVersion(Version newVersion, NotificationChain msgs) {
		Version oldVersion = version;
		version = newVersion;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.META__VERSION, oldVersion, newVersion);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersion(Version newVersion) {
		if (newVersion != version) {
			NotificationChain msgs = null;
			if (version != null)
				msgs = ((InternalEObject)version).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfigurationemfPackage.META__VERSION, null, msgs);
			if (newVersion != null)
				msgs = ((InternalEObject)newVersion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfigurationemfPackage.META__VERSION, null, msgs);
			msgs = basicSetVersion(newVersion, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.META__VERSION, newVersion, newVersion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Platform getPlatform() {
		return platform;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPlatform(Platform newPlatform, NotificationChain msgs) {
		Platform oldPlatform = platform;
		platform = newPlatform;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.META__PLATFORM, oldPlatform, newPlatform);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlatform(Platform newPlatform) {
		if (newPlatform != platform) {
			NotificationChain msgs = null;
			if (platform != null)
				msgs = ((InternalEObject)platform).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfigurationemfPackage.META__PLATFORM, null, msgs);
			if (newPlatform != null)
				msgs = ((InternalEObject)newPlatform).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfigurationemfPackage.META__PLATFORM, null, msgs);
			msgs = basicSetPlatform(newPlatform, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.META__PLATFORM, newPlatform, newPlatform));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProduct(Product newProduct, NotificationChain msgs) {
		Product oldProduct = product;
		product = newProduct;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.META__PRODUCT, oldProduct, newProduct);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProduct(Product newProduct) {
		if (newProduct != product) {
			NotificationChain msgs = null;
			if (product != null)
				msgs = ((InternalEObject)product).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfigurationemfPackage.META__PRODUCT, null, msgs);
			if (newProduct != null)
				msgs = ((InternalEObject)newProduct).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfigurationemfPackage.META__PRODUCT, null, msgs);
			msgs = basicSetProduct(newProduct, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.META__PRODUCT, newProduct, newProduct));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCustomer(Customer newCustomer, NotificationChain msgs) {
		Customer oldCustomer = customer;
		customer = newCustomer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.META__CUSTOMER, oldCustomer, newCustomer);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCustomer(Customer newCustomer) {
		if (newCustomer != customer) {
			NotificationChain msgs = null;
			if (customer != null)
				msgs = ((InternalEObject)customer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfigurationemfPackage.META__CUSTOMER, null, msgs);
			if (newCustomer != null)
				msgs = ((InternalEObject)newCustomer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfigurationemfPackage.META__CUSTOMER, null, msgs);
			msgs = basicSetCustomer(newCustomer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.META__CUSTOMER, newCustomer, newCustomer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDate(Date newDate, NotificationChain msgs) {
		Date oldDate = date;
		date = newDate;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.META__DATE, oldDate, newDate);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDate(Date newDate) {
		if (newDate != date) {
			NotificationChain msgs = null;
			if (date != null)
				msgs = ((InternalEObject)date).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfigurationemfPackage.META__DATE, null, msgs);
			if (newDate != null)
				msgs = ((InternalEObject)newDate).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfigurationemfPackage.META__DATE, null, msgs);
			msgs = basicSetDate(newDate, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.META__DATE, newDate, newDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Release getRelease() {
		if (release != null && release.eIsProxy()) {
			InternalEObject oldRelease = (InternalEObject)release;
			release = (Release)eResolveProxy(oldRelease);
			if (release != oldRelease) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConfigurationemfPackage.META__RELEASE, oldRelease, release));
			}
		}
		return release;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Release basicGetRelease() {
		return release;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelease(Release newRelease) {
		Release oldRelease = release;
		release = newRelease;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.META__RELEASE, oldRelease, release));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConfigurationemfPackage.META__IDENTIFICATION:
				return basicSetIdentification(null, msgs);
			case ConfigurationemfPackage.META__OWNER:
				return basicSetOwner(null, msgs);
			case ConfigurationemfPackage.META__EDITOR:
				return basicSetEditor(null, msgs);
			case ConfigurationemfPackage.META__STATUS:
				return basicSetStatus(null, msgs);
			case ConfigurationemfPackage.META__VERSION:
				return basicSetVersion(null, msgs);
			case ConfigurationemfPackage.META__PLATFORM:
				return basicSetPlatform(null, msgs);
			case ConfigurationemfPackage.META__PRODUCT:
				return basicSetProduct(null, msgs);
			case ConfigurationemfPackage.META__CUSTOMER:
				return basicSetCustomer(null, msgs);
			case ConfigurationemfPackage.META__DATE:
				return basicSetDate(null, msgs);
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
			case ConfigurationemfPackage.META__IDENTIFICATION:
				return getIdentification();
			case ConfigurationemfPackage.META__OWNER:
				return getOwner();
			case ConfigurationemfPackage.META__EDITOR:
				return getEditor();
			case ConfigurationemfPackage.META__STATUS:
				return getStatus();
			case ConfigurationemfPackage.META__VERSION:
				return getVersion();
			case ConfigurationemfPackage.META__PLATFORM:
				return getPlatform();
			case ConfigurationemfPackage.META__PRODUCT:
				return getProduct();
			case ConfigurationemfPackage.META__CUSTOMER:
				return getCustomer();
			case ConfigurationemfPackage.META__DATE:
				return getDate();
			case ConfigurationemfPackage.META__RELEASE:
				if (resolve) return getRelease();
				return basicGetRelease();
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
			case ConfigurationemfPackage.META__IDENTIFICATION:
				setIdentification((Identification)newValue);
				return;
			case ConfigurationemfPackage.META__OWNER:
				setOwner((Owner)newValue);
				return;
			case ConfigurationemfPackage.META__EDITOR:
				setEditor((Editor)newValue);
				return;
			case ConfigurationemfPackage.META__STATUS:
				setStatus((Status)newValue);
				return;
			case ConfigurationemfPackage.META__VERSION:
				setVersion((Version)newValue);
				return;
			case ConfigurationemfPackage.META__PLATFORM:
				setPlatform((Platform)newValue);
				return;
			case ConfigurationemfPackage.META__PRODUCT:
				setProduct((Product)newValue);
				return;
			case ConfigurationemfPackage.META__CUSTOMER:
				setCustomer((Customer)newValue);
				return;
			case ConfigurationemfPackage.META__DATE:
				setDate((Date)newValue);
				return;
			case ConfigurationemfPackage.META__RELEASE:
				setRelease((Release)newValue);
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
			case ConfigurationemfPackage.META__IDENTIFICATION:
				setIdentification((Identification)null);
				return;
			case ConfigurationemfPackage.META__OWNER:
				setOwner((Owner)null);
				return;
			case ConfigurationemfPackage.META__EDITOR:
				setEditor((Editor)null);
				return;
			case ConfigurationemfPackage.META__STATUS:
				setStatus((Status)null);
				return;
			case ConfigurationemfPackage.META__VERSION:
				setVersion((Version)null);
				return;
			case ConfigurationemfPackage.META__PLATFORM:
				setPlatform((Platform)null);
				return;
			case ConfigurationemfPackage.META__PRODUCT:
				setProduct((Product)null);
				return;
			case ConfigurationemfPackage.META__CUSTOMER:
				setCustomer((Customer)null);
				return;
			case ConfigurationemfPackage.META__DATE:
				setDate((Date)null);
				return;
			case ConfigurationemfPackage.META__RELEASE:
				setRelease((Release)null);
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
			case ConfigurationemfPackage.META__IDENTIFICATION:
				return identification != null;
			case ConfigurationemfPackage.META__OWNER:
				return owner != null;
			case ConfigurationemfPackage.META__EDITOR:
				return editor != null;
			case ConfigurationemfPackage.META__STATUS:
				return status != null;
			case ConfigurationemfPackage.META__VERSION:
				return version != null;
			case ConfigurationemfPackage.META__PLATFORM:
				return platform != null;
			case ConfigurationemfPackage.META__PRODUCT:
				return product != null;
			case ConfigurationemfPackage.META__CUSTOMER:
				return customer != null;
			case ConfigurationemfPackage.META__DATE:
				return date != null;
			case ConfigurationemfPackage.META__RELEASE:
				return release != null;
		}
		return super.eIsSet(featureID);
	}

} //MetaImpl