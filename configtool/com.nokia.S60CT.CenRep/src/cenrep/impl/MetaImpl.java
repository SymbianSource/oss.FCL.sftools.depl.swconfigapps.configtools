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
package cenrep.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import cenrep.CenrepPackage;
import cenrep.Date;
import cenrep.Editor;
import cenrep.Identification;
import cenrep.Meta;
import cenrep.Owner;
import cenrep.Platform;
import cenrep.Product;
import cenrep.Release;
import cenrep.Status;
import cenrep.Version;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Meta</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cenrep.impl.MetaImpl#getIdentification <em>Identification</em>}</li>
 *   <li>{@link cenrep.impl.MetaImpl#getDate <em>Date</em>}</li>
 *   <li>{@link cenrep.impl.MetaImpl#getPlatform <em>Platform</em>}</li>
 *   <li>{@link cenrep.impl.MetaImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link cenrep.impl.MetaImpl#getEditor <em>Editor</em>}</li>
 *   <li>{@link cenrep.impl.MetaImpl#getStatus <em>Status</em>}</li>
 *   <li>{@link cenrep.impl.MetaImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link cenrep.impl.MetaImpl#getProduct <em>Product</em>}</li>
 *   <li>{@link cenrep.impl.MetaImpl#getRelease <em>Release</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MetaImpl extends CommonAttrsImpl implements Meta {
	/**
	 * The cached value of the '{@link #getIdentification() <em>Identification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentification()
	 * @generated
	 * @ordered
	 */
	protected Identification identification;

	/**
	 * The cached value of the '{@link #getDate() <em>Date</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected Date date;

	/**
	 * The cached value of the '{@link #getPlatform() <em>Platform</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlatform()
	 * @generated
	 * @ordered
	 */
	protected Platform platform;

	/**
	 * The cached value of the '{@link #getOwner() <em>Owner</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwner()
	 * @generated
	 * @ordered
	 */
	protected Owner owner;

	/**
	 * The cached value of the '{@link #getEditor() <em>Editor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEditor()
	 * @generated
	 * @ordered
	 */
	protected Editor editor;

	/**
	 * The cached value of the '{@link #getStatus() <em>Status</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected Status status;

	/**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected Version version;

	/**
	 * The cached value of the '{@link #getProduct() <em>Product</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProduct()
	 * @generated
	 * @ordered
	 */
	protected Product product;

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
		return CenrepPackage.Literals.META;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Identification getIdentification() {
		if (identification != null && identification.eIsProxy()) {
			InternalEObject oldIdentification = (InternalEObject)identification;
			identification = (Identification)eResolveProxy(oldIdentification);
			if (identification != oldIdentification) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CenrepPackage.META__IDENTIFICATION, oldIdentification, identification));
			}
		}
		return identification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Identification basicGetIdentification() {
		return identification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdentification(Identification newIdentification) {
		Identification oldIdentification = identification;
		identification = newIdentification;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CenrepPackage.META__IDENTIFICATION, oldIdentification, identification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getDate() {
		if (date != null && date.eIsProxy()) {
			InternalEObject oldDate = (InternalEObject)date;
			date = (Date)eResolveProxy(oldDate);
			if (date != oldDate) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CenrepPackage.META__DATE, oldDate, date));
			}
		}
		return date;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date basicGetDate() {
		return date;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDate(Date newDate) {
		Date oldDate = date;
		date = newDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CenrepPackage.META__DATE, oldDate, date));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Platform getPlatform() {
		if (platform != null && platform.eIsProxy()) {
			InternalEObject oldPlatform = (InternalEObject)platform;
			platform = (Platform)eResolveProxy(oldPlatform);
			if (platform != oldPlatform) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CenrepPackage.META__PLATFORM, oldPlatform, platform));
			}
		}
		return platform;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Platform basicGetPlatform() {
		return platform;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlatform(Platform newPlatform) {
		Platform oldPlatform = platform;
		platform = newPlatform;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CenrepPackage.META__PLATFORM, oldPlatform, platform));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Owner getOwner() {
		if (owner != null && owner.eIsProxy()) {
			InternalEObject oldOwner = (InternalEObject)owner;
			owner = (Owner)eResolveProxy(oldOwner);
			if (owner != oldOwner) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CenrepPackage.META__OWNER, oldOwner, owner));
			}
		}
		return owner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Owner basicGetOwner() {
		return owner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(Owner newOwner) {
		Owner oldOwner = owner;
		owner = newOwner;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CenrepPackage.META__OWNER, oldOwner, owner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Editor getEditor() {
		if (editor != null && editor.eIsProxy()) {
			InternalEObject oldEditor = (InternalEObject)editor;
			editor = (Editor)eResolveProxy(oldEditor);
			if (editor != oldEditor) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CenrepPackage.META__EDITOR, oldEditor, editor));
			}
		}
		return editor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Editor basicGetEditor() {
		return editor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEditor(Editor newEditor) {
		Editor oldEditor = editor;
		editor = newEditor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CenrepPackage.META__EDITOR, oldEditor, editor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Status getStatus() {
		if (status != null && status.eIsProxy()) {
			InternalEObject oldStatus = (InternalEObject)status;
			status = (Status)eResolveProxy(oldStatus);
			if (status != oldStatus) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CenrepPackage.META__STATUS, oldStatus, status));
			}
		}
		return status;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Status basicGetStatus() {
		return status;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatus(Status newStatus) {
		Status oldStatus = status;
		status = newStatus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CenrepPackage.META__STATUS, oldStatus, status));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Version getVersion() {
		if (version != null && version.eIsProxy()) {
			InternalEObject oldVersion = (InternalEObject)version;
			version = (Version)eResolveProxy(oldVersion);
			if (version != oldVersion) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CenrepPackage.META__VERSION, oldVersion, version));
			}
		}
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Version basicGetVersion() {
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersion(Version newVersion) {
		Version oldVersion = version;
		version = newVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CenrepPackage.META__VERSION, oldVersion, version));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Product getProduct() {
		if (product != null && product.eIsProxy()) {
			InternalEObject oldProduct = (InternalEObject)product;
			product = (Product)eResolveProxy(oldProduct);
			if (product != oldProduct) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CenrepPackage.META__PRODUCT, oldProduct, product));
			}
		}
		return product;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Product basicGetProduct() {
		return product;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProduct(Product newProduct) {
		Product oldProduct = product;
		product = newProduct;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CenrepPackage.META__PRODUCT, oldProduct, product));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CenrepPackage.META__RELEASE, oldRelease, release));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CenrepPackage.META__RELEASE, oldRelease, release));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CenrepPackage.META__IDENTIFICATION:
				if (resolve) return getIdentification();
				return basicGetIdentification();
			case CenrepPackage.META__DATE:
				if (resolve) return getDate();
				return basicGetDate();
			case CenrepPackage.META__PLATFORM:
				if (resolve) return getPlatform();
				return basicGetPlatform();
			case CenrepPackage.META__OWNER:
				if (resolve) return getOwner();
				return basicGetOwner();
			case CenrepPackage.META__EDITOR:
				if (resolve) return getEditor();
				return basicGetEditor();
			case CenrepPackage.META__STATUS:
				if (resolve) return getStatus();
				return basicGetStatus();
			case CenrepPackage.META__VERSION:
				if (resolve) return getVersion();
				return basicGetVersion();
			case CenrepPackage.META__PRODUCT:
				if (resolve) return getProduct();
				return basicGetProduct();
			case CenrepPackage.META__RELEASE:
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
	@SuppressWarnings("unchecked")
		@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CenrepPackage.META__IDENTIFICATION:
				setIdentification((Identification)newValue);
				return;
			case CenrepPackage.META__DATE:
				setDate((Date)newValue);
				return;
			case CenrepPackage.META__PLATFORM:
				setPlatform((Platform)newValue);
				return;
			case CenrepPackage.META__OWNER:
				setOwner((Owner)newValue);
				return;
			case CenrepPackage.META__EDITOR:
				setEditor((Editor)newValue);
				return;
			case CenrepPackage.META__STATUS:
				setStatus((Status)newValue);
				return;
			case CenrepPackage.META__VERSION:
				setVersion((Version)newValue);
				return;
			case CenrepPackage.META__PRODUCT:
				setProduct((Product)newValue);
				return;
			case CenrepPackage.META__RELEASE:
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
			case CenrepPackage.META__IDENTIFICATION:
				setIdentification((Identification)null);
				return;
			case CenrepPackage.META__DATE:
				setDate((Date)null);
				return;
			case CenrepPackage.META__PLATFORM:
				setPlatform((Platform)null);
				return;
			case CenrepPackage.META__OWNER:
				setOwner((Owner)null);
				return;
			case CenrepPackage.META__EDITOR:
				setEditor((Editor)null);
				return;
			case CenrepPackage.META__STATUS:
				setStatus((Status)null);
				return;
			case CenrepPackage.META__VERSION:
				setVersion((Version)null);
				return;
			case CenrepPackage.META__PRODUCT:
				setProduct((Product)null);
				return;
			case CenrepPackage.META__RELEASE:
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
			case CenrepPackage.META__IDENTIFICATION:
				return identification != null;
			case CenrepPackage.META__DATE:
				return date != null;
			case CenrepPackage.META__PLATFORM:
				return platform != null;
			case CenrepPackage.META__OWNER:
				return owner != null;
			case CenrepPackage.META__EDITOR:
				return editor != null;
			case CenrepPackage.META__STATUS:
				return status != null;
			case CenrepPackage.META__VERSION:
				return version != null;
			case CenrepPackage.META__PRODUCT:
				return product != null;
			case CenrepPackage.META__RELEASE:
				return release != null;
		}
		return super.eIsSet(featureID);
	}

} //MetaImpl