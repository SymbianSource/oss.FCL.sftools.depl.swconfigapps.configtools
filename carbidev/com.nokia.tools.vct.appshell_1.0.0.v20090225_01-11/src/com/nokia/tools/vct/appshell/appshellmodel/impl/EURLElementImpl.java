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
 * Description: This file is part of com.nokia.tools.vct.appshell component.
 */

package com.nokia.tools.vct.appshell.appshellmodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import com.nokia.tools.vct.appshell.appshellmodel.EAppshellModelPackage;
import com.nokia.tools.vct.appshell.appshellmodel.EBooleanFlag;
import com.nokia.tools.vct.appshell.appshellmodel.EHideDescriptor;
import com.nokia.tools.vct.appshell.appshellmodel.EIconDescriptor;
import com.nokia.tools.vct.appshell.appshellmodel.ENameDescriptor;
import com.nokia.tools.vct.appshell.appshellmodel.EURLElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EURL Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.appshell.appshellmodel.impl.EURLElementImpl#getLockName <em>Lock Name</em>}</li>
 *   <li>{@link com.nokia.tools.vct.appshell.appshellmodel.impl.EURLElementImpl#getLockIcon <em>Lock Icon</em>}</li>
 *   <li>{@link com.nokia.tools.vct.appshell.appshellmodel.impl.EURLElementImpl#getLockDelete <em>Lock Delete</em>}</li>
 *   <li>{@link com.nokia.tools.vct.appshell.appshellmodel.impl.EURLElementImpl#getLockOrganize <em>Lock Organize</em>}</li>
 *   <li>{@link com.nokia.tools.vct.appshell.appshellmodel.impl.EURLElementImpl#getIconFile <em>Icon File</em>}</li>
 *   <li>{@link com.nokia.tools.vct.appshell.appshellmodel.impl.EURLElementImpl#getM3gIconFile <em>M3g Icon File</em>}</li>
 *   <li>{@link com.nokia.tools.vct.appshell.appshellmodel.impl.EURLElementImpl#getIconId <em>Icon Id</em>}</li>
 *   <li>{@link com.nokia.tools.vct.appshell.appshellmodel.impl.EURLElementImpl#getMaskId <em>Mask Id</em>}</li>
 *   <li>{@link com.nokia.tools.vct.appshell.appshellmodel.impl.EURLElementImpl#getIconSkinMajorId <em>Icon Skin Major Id</em>}</li>
 *   <li>{@link com.nokia.tools.vct.appshell.appshellmodel.impl.EURLElementImpl#getIconSkinMinorId <em>Icon Skin Minor Id</em>}</li>
 *   <li>{@link com.nokia.tools.vct.appshell.appshellmodel.impl.EURLElementImpl#getHideChangeSkin <em>Hide Change Skin</em>}</li>
 *   <li>{@link com.nokia.tools.vct.appshell.appshellmodel.impl.EURLElementImpl#getHideMemDetails <em>Hide Mem Details</em>}</li>
 *   <li>{@link com.nokia.tools.vct.appshell.appshellmodel.impl.EURLElementImpl#getHideDownload <em>Hide Download</em>}</li>
 *   <li>{@link com.nokia.tools.vct.appshell.appshellmodel.impl.EURLElementImpl#getHideAnimatedIcons <em>Hide Animated Icons</em>}</li>
 *   <li>{@link com.nokia.tools.vct.appshell.appshellmodel.impl.EURLElementImpl#getTitleName <em>Title Name</em>}</li>
 *   <li>{@link com.nokia.tools.vct.appshell.appshellmodel.impl.EURLElementImpl#getShortName <em>Short Name</em>}</li>
 *   <li>{@link com.nokia.tools.vct.appshell.appshellmodel.impl.EURLElementImpl#getLongName <em>Long Name</em>}</li>
 *   <li>{@link com.nokia.tools.vct.appshell.appshellmodel.impl.EURLElementImpl#getUrl <em>Url</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EURLElementImpl extends EObjectImpl implements EURLElement {
	/**
	 * The default value of the '{@link #getLockName() <em>Lock Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLockName()
	 * @generated
	 * @ordered
	 */
	protected static final EBooleanFlag LOCK_NAME_EDEFAULT = EBooleanFlag.OFF;

	/**
	 * The cached value of the '{@link #getLockName() <em>Lock Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLockName()
	 * @generated
	 * @ordered
	 */
	protected EBooleanFlag lockName = LOCK_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getLockIcon() <em>Lock Icon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLockIcon()
	 * @generated
	 * @ordered
	 */
	protected static final EBooleanFlag LOCK_ICON_EDEFAULT = EBooleanFlag.OFF;

	/**
	 * The cached value of the '{@link #getLockIcon() <em>Lock Icon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLockIcon()
	 * @generated
	 * @ordered
	 */
	protected EBooleanFlag lockIcon = LOCK_ICON_EDEFAULT;

	/**
	 * The default value of the '{@link #getLockDelete() <em>Lock Delete</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLockDelete()
	 * @generated
	 * @ordered
	 */
	protected static final EBooleanFlag LOCK_DELETE_EDEFAULT = EBooleanFlag.OFF;

	/**
	 * The cached value of the '{@link #getLockDelete() <em>Lock Delete</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLockDelete()
	 * @generated
	 * @ordered
	 */
	protected EBooleanFlag lockDelete = LOCK_DELETE_EDEFAULT;

	/**
	 * The default value of the '{@link #getLockOrganize() <em>Lock Organize</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLockOrganize()
	 * @generated
	 * @ordered
	 */
	protected static final EBooleanFlag LOCK_ORGANIZE_EDEFAULT = EBooleanFlag.OFF;

	/**
	 * The cached value of the '{@link #getLockOrganize() <em>Lock Organize</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLockOrganize()
	 * @generated
	 * @ordered
	 */
	protected EBooleanFlag lockOrganize = LOCK_ORGANIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getIconFile() <em>Icon File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIconFile()
	 * @generated
	 * @ordered
	 */
	protected static final String ICON_FILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIconFile() <em>Icon File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIconFile()
	 * @generated
	 * @ordered
	 */
	protected String iconFile = ICON_FILE_EDEFAULT;

	/**
	 * The default value of the '{@link #getM3gIconFile() <em>M3g Icon File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM3gIconFile()
	 * @generated
	 * @ordered
	 */
	protected static final String M3G_ICON_FILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getM3gIconFile() <em>M3g Icon File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getM3gIconFile()
	 * @generated
	 * @ordered
	 */
	protected String m3gIconFile = M3G_ICON_FILE_EDEFAULT;

	/**
	 * The default value of the '{@link #getIconId() <em>Icon Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIconId()
	 * @generated
	 * @ordered
	 */
	protected static final String ICON_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIconId() <em>Icon Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIconId()
	 * @generated
	 * @ordered
	 */
	protected String iconId = ICON_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaskId() <em>Mask Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaskId()
	 * @generated
	 * @ordered
	 */
	protected static final String MASK_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMaskId() <em>Mask Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaskId()
	 * @generated
	 * @ordered
	 */
	protected String maskId = MASK_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getIconSkinMajorId() <em>Icon Skin Major Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIconSkinMajorId()
	 * @generated
	 * @ordered
	 */
	protected static final String ICON_SKIN_MAJOR_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIconSkinMajorId() <em>Icon Skin Major Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIconSkinMajorId()
	 * @generated
	 * @ordered
	 */
	protected String iconSkinMajorId = ICON_SKIN_MAJOR_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getIconSkinMinorId() <em>Icon Skin Minor Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIconSkinMinorId()
	 * @generated
	 * @ordered
	 */
	protected static final String ICON_SKIN_MINOR_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIconSkinMinorId() <em>Icon Skin Minor Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIconSkinMinorId()
	 * @generated
	 * @ordered
	 */
	protected String iconSkinMinorId = ICON_SKIN_MINOR_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getHideChangeSkin() <em>Hide Change Skin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHideChangeSkin()
	 * @generated
	 * @ordered
	 */
	protected static final EBooleanFlag HIDE_CHANGE_SKIN_EDEFAULT = EBooleanFlag.OFF;

	/**
	 * The cached value of the '{@link #getHideChangeSkin() <em>Hide Change Skin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHideChangeSkin()
	 * @generated
	 * @ordered
	 */
	protected EBooleanFlag hideChangeSkin = HIDE_CHANGE_SKIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getHideMemDetails() <em>Hide Mem Details</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHideMemDetails()
	 * @generated
	 * @ordered
	 */
	protected static final EBooleanFlag HIDE_MEM_DETAILS_EDEFAULT = EBooleanFlag.OFF;

	/**
	 * The cached value of the '{@link #getHideMemDetails() <em>Hide Mem Details</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHideMemDetails()
	 * @generated
	 * @ordered
	 */
	protected EBooleanFlag hideMemDetails = HIDE_MEM_DETAILS_EDEFAULT;

	/**
	 * The default value of the '{@link #getHideDownload() <em>Hide Download</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHideDownload()
	 * @generated
	 * @ordered
	 */
	protected static final EBooleanFlag HIDE_DOWNLOAD_EDEFAULT = EBooleanFlag.OFF;

	/**
	 * The cached value of the '{@link #getHideDownload() <em>Hide Download</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHideDownload()
	 * @generated
	 * @ordered
	 */
	protected EBooleanFlag hideDownload = HIDE_DOWNLOAD_EDEFAULT;

	/**
	 * The default value of the '{@link #getHideAnimatedIcons() <em>Hide Animated Icons</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHideAnimatedIcons()
	 * @generated
	 * @ordered
	 */
	protected static final EBooleanFlag HIDE_ANIMATED_ICONS_EDEFAULT = EBooleanFlag.OFF;

	/**
	 * The cached value of the '{@link #getHideAnimatedIcons() <em>Hide Animated Icons</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHideAnimatedIcons()
	 * @generated
	 * @ordered
	 */
	protected EBooleanFlag hideAnimatedIcons = HIDE_ANIMATED_ICONS_EDEFAULT;

	/**
	 * The default value of the '{@link #getTitleName() <em>Title Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitleName()
	 * @generated
	 * @ordered
	 */
	protected static final String TITLE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTitleName() <em>Title Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitleName()
	 * @generated
	 * @ordered
	 */
	protected String titleName = TITLE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getShortName() <em>Short Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShortName()
	 * @generated
	 * @ordered
	 */
	protected static final String SHORT_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getShortName() <em>Short Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShortName()
	 * @generated
	 * @ordered
	 */
	protected String shortName = SHORT_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getLongName() <em>Long Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLongName()
	 * @generated
	 * @ordered
	 */
	protected static final String LONG_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLongName() <em>Long Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLongName()
	 * @generated
	 * @ordered
	 */
	protected String longName = LONG_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getUrl() <em>Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUrl()
	 * @generated
	 * @ordered
	 */
	protected static final String URL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUrl() <em>Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUrl()
	 * @generated
	 * @ordered
	 */
	protected String url = URL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EURLElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EAppshellModelPackage.Literals.EURL_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EBooleanFlag getLockName() {
		return lockName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLockName(EBooleanFlag newLockName) {
		EBooleanFlag oldLockName = lockName;
		lockName = newLockName == null ? LOCK_NAME_EDEFAULT : newLockName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EAppshellModelPackage.EURL_ELEMENT__LOCK_NAME, oldLockName, lockName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EBooleanFlag getLockIcon() {
		return lockIcon;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLockIcon(EBooleanFlag newLockIcon) {
		EBooleanFlag oldLockIcon = lockIcon;
		lockIcon = newLockIcon == null ? LOCK_ICON_EDEFAULT : newLockIcon;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EAppshellModelPackage.EURL_ELEMENT__LOCK_ICON, oldLockIcon, lockIcon));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EBooleanFlag getLockDelete() {
		return lockDelete;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLockDelete(EBooleanFlag newLockDelete) {
		EBooleanFlag oldLockDelete = lockDelete;
		lockDelete = newLockDelete == null ? LOCK_DELETE_EDEFAULT : newLockDelete;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EAppshellModelPackage.EURL_ELEMENT__LOCK_DELETE, oldLockDelete, lockDelete));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EBooleanFlag getLockOrganize() {
		return lockOrganize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLockOrganize(EBooleanFlag newLockOrganize) {
		EBooleanFlag oldLockOrganize = lockOrganize;
		lockOrganize = newLockOrganize == null ? LOCK_ORGANIZE_EDEFAULT : newLockOrganize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EAppshellModelPackage.EURL_ELEMENT__LOCK_ORGANIZE, oldLockOrganize, lockOrganize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EBooleanFlag getHideChangeSkin() {
		return hideChangeSkin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHideChangeSkin(EBooleanFlag newHideChangeSkin) {
		EBooleanFlag oldHideChangeSkin = hideChangeSkin;
		hideChangeSkin = newHideChangeSkin == null ? HIDE_CHANGE_SKIN_EDEFAULT : newHideChangeSkin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EAppshellModelPackage.EURL_ELEMENT__HIDE_CHANGE_SKIN, oldHideChangeSkin, hideChangeSkin));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EBooleanFlag getHideMemDetails() {
		return hideMemDetails;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHideMemDetails(EBooleanFlag newHideMemDetails) {
		EBooleanFlag oldHideMemDetails = hideMemDetails;
		hideMemDetails = newHideMemDetails == null ? HIDE_MEM_DETAILS_EDEFAULT : newHideMemDetails;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EAppshellModelPackage.EURL_ELEMENT__HIDE_MEM_DETAILS, oldHideMemDetails, hideMemDetails));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EBooleanFlag getHideDownload() {
		return hideDownload;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHideDownload(EBooleanFlag newHideDownload) {
		EBooleanFlag oldHideDownload = hideDownload;
		hideDownload = newHideDownload == null ? HIDE_DOWNLOAD_EDEFAULT : newHideDownload;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EAppshellModelPackage.EURL_ELEMENT__HIDE_DOWNLOAD, oldHideDownload, hideDownload));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EBooleanFlag getHideAnimatedIcons() {
		return hideAnimatedIcons;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHideAnimatedIcons(EBooleanFlag newHideAnimatedIcons) {
		EBooleanFlag oldHideAnimatedIcons = hideAnimatedIcons;
		hideAnimatedIcons = newHideAnimatedIcons == null ? HIDE_ANIMATED_ICONS_EDEFAULT : newHideAnimatedIcons;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EAppshellModelPackage.EURL_ELEMENT__HIDE_ANIMATED_ICONS, oldHideAnimatedIcons, hideAnimatedIcons));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIconFile() {
		return iconFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIconFile(String newIconFile) {
		String oldIconFile = iconFile;
		iconFile = newIconFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EAppshellModelPackage.EURL_ELEMENT__ICON_FILE, oldIconFile, iconFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getM3gIconFile() {
		return m3gIconFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setM3gIconFile(String newM3gIconFile) {
		String oldM3gIconFile = m3gIconFile;
		m3gIconFile = newM3gIconFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EAppshellModelPackage.EURL_ELEMENT__M3G_ICON_FILE, oldM3gIconFile, m3gIconFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIconId() {
		return iconId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIconId(String newIconId) {
		String oldIconId = iconId;
		iconId = newIconId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EAppshellModelPackage.EURL_ELEMENT__ICON_ID, oldIconId, iconId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMaskId() {
		return maskId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaskId(String newMaskId) {
		String oldMaskId = maskId;
		maskId = newMaskId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EAppshellModelPackage.EURL_ELEMENT__MASK_ID, oldMaskId, maskId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIconSkinMajorId() {
		return iconSkinMajorId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIconSkinMajorId(String newIconSkinMajorId) {
		String oldIconSkinMajorId = iconSkinMajorId;
		iconSkinMajorId = newIconSkinMajorId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EAppshellModelPackage.EURL_ELEMENT__ICON_SKIN_MAJOR_ID, oldIconSkinMajorId, iconSkinMajorId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIconSkinMinorId() {
		return iconSkinMinorId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIconSkinMinorId(String newIconSkinMinorId) {
		String oldIconSkinMinorId = iconSkinMinorId;
		iconSkinMinorId = newIconSkinMinorId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EAppshellModelPackage.EURL_ELEMENT__ICON_SKIN_MINOR_ID, oldIconSkinMinorId, iconSkinMinorId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUrl(String newUrl) {
		String oldUrl = url;
		url = newUrl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EAppshellModelPackage.EURL_ELEMENT__URL, oldUrl, url));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTitleName() {
		return titleName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTitleName(String newTitleName) {
		String oldTitleName = titleName;
		titleName = newTitleName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EAppshellModelPackage.EURL_ELEMENT__TITLE_NAME, oldTitleName, titleName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getShortName() {
		return shortName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShortName(String newShortName) {
		String oldShortName = shortName;
		shortName = newShortName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EAppshellModelPackage.EURL_ELEMENT__SHORT_NAME, oldShortName, shortName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLongName() {
		return longName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLongName(String newLongName) {
		String oldLongName = longName;
		longName = newLongName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EAppshellModelPackage.EURL_ELEMENT__LONG_NAME, oldLongName, longName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EAppshellModelPackage.EURL_ELEMENT__LOCK_NAME:
				return getLockName();
			case EAppshellModelPackage.EURL_ELEMENT__LOCK_ICON:
				return getLockIcon();
			case EAppshellModelPackage.EURL_ELEMENT__LOCK_DELETE:
				return getLockDelete();
			case EAppshellModelPackage.EURL_ELEMENT__LOCK_ORGANIZE:
				return getLockOrganize();
			case EAppshellModelPackage.EURL_ELEMENT__ICON_FILE:
				return getIconFile();
			case EAppshellModelPackage.EURL_ELEMENT__M3G_ICON_FILE:
				return getM3gIconFile();
			case EAppshellModelPackage.EURL_ELEMENT__ICON_ID:
				return getIconId();
			case EAppshellModelPackage.EURL_ELEMENT__MASK_ID:
				return getMaskId();
			case EAppshellModelPackage.EURL_ELEMENT__ICON_SKIN_MAJOR_ID:
				return getIconSkinMajorId();
			case EAppshellModelPackage.EURL_ELEMENT__ICON_SKIN_MINOR_ID:
				return getIconSkinMinorId();
			case EAppshellModelPackage.EURL_ELEMENT__HIDE_CHANGE_SKIN:
				return getHideChangeSkin();
			case EAppshellModelPackage.EURL_ELEMENT__HIDE_MEM_DETAILS:
				return getHideMemDetails();
			case EAppshellModelPackage.EURL_ELEMENT__HIDE_DOWNLOAD:
				return getHideDownload();
			case EAppshellModelPackage.EURL_ELEMENT__HIDE_ANIMATED_ICONS:
				return getHideAnimatedIcons();
			case EAppshellModelPackage.EURL_ELEMENT__TITLE_NAME:
				return getTitleName();
			case EAppshellModelPackage.EURL_ELEMENT__SHORT_NAME:
				return getShortName();
			case EAppshellModelPackage.EURL_ELEMENT__LONG_NAME:
				return getLongName();
			case EAppshellModelPackage.EURL_ELEMENT__URL:
				return getUrl();
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
			case EAppshellModelPackage.EURL_ELEMENT__LOCK_NAME:
				setLockName((EBooleanFlag)newValue);
				return;
			case EAppshellModelPackage.EURL_ELEMENT__LOCK_ICON:
				setLockIcon((EBooleanFlag)newValue);
				return;
			case EAppshellModelPackage.EURL_ELEMENT__LOCK_DELETE:
				setLockDelete((EBooleanFlag)newValue);
				return;
			case EAppshellModelPackage.EURL_ELEMENT__LOCK_ORGANIZE:
				setLockOrganize((EBooleanFlag)newValue);
				return;
			case EAppshellModelPackage.EURL_ELEMENT__ICON_FILE:
				setIconFile((String)newValue);
				return;
			case EAppshellModelPackage.EURL_ELEMENT__M3G_ICON_FILE:
				setM3gIconFile((String)newValue);
				return;
			case EAppshellModelPackage.EURL_ELEMENT__ICON_ID:
				setIconId((String)newValue);
				return;
			case EAppshellModelPackage.EURL_ELEMENT__MASK_ID:
				setMaskId((String)newValue);
				return;
			case EAppshellModelPackage.EURL_ELEMENT__ICON_SKIN_MAJOR_ID:
				setIconSkinMajorId((String)newValue);
				return;
			case EAppshellModelPackage.EURL_ELEMENT__ICON_SKIN_MINOR_ID:
				setIconSkinMinorId((String)newValue);
				return;
			case EAppshellModelPackage.EURL_ELEMENT__HIDE_CHANGE_SKIN:
				setHideChangeSkin((EBooleanFlag)newValue);
				return;
			case EAppshellModelPackage.EURL_ELEMENT__HIDE_MEM_DETAILS:
				setHideMemDetails((EBooleanFlag)newValue);
				return;
			case EAppshellModelPackage.EURL_ELEMENT__HIDE_DOWNLOAD:
				setHideDownload((EBooleanFlag)newValue);
				return;
			case EAppshellModelPackage.EURL_ELEMENT__HIDE_ANIMATED_ICONS:
				setHideAnimatedIcons((EBooleanFlag)newValue);
				return;
			case EAppshellModelPackage.EURL_ELEMENT__TITLE_NAME:
				setTitleName((String)newValue);
				return;
			case EAppshellModelPackage.EURL_ELEMENT__SHORT_NAME:
				setShortName((String)newValue);
				return;
			case EAppshellModelPackage.EURL_ELEMENT__LONG_NAME:
				setLongName((String)newValue);
				return;
			case EAppshellModelPackage.EURL_ELEMENT__URL:
				setUrl((String)newValue);
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
			case EAppshellModelPackage.EURL_ELEMENT__LOCK_NAME:
				setLockName(LOCK_NAME_EDEFAULT);
				return;
			case EAppshellModelPackage.EURL_ELEMENT__LOCK_ICON:
				setLockIcon(LOCK_ICON_EDEFAULT);
				return;
			case EAppshellModelPackage.EURL_ELEMENT__LOCK_DELETE:
				setLockDelete(LOCK_DELETE_EDEFAULT);
				return;
			case EAppshellModelPackage.EURL_ELEMENT__LOCK_ORGANIZE:
				setLockOrganize(LOCK_ORGANIZE_EDEFAULT);
				return;
			case EAppshellModelPackage.EURL_ELEMENT__ICON_FILE:
				setIconFile(ICON_FILE_EDEFAULT);
				return;
			case EAppshellModelPackage.EURL_ELEMENT__M3G_ICON_FILE:
				setM3gIconFile(M3G_ICON_FILE_EDEFAULT);
				return;
			case EAppshellModelPackage.EURL_ELEMENT__ICON_ID:
				setIconId(ICON_ID_EDEFAULT);
				return;
			case EAppshellModelPackage.EURL_ELEMENT__MASK_ID:
				setMaskId(MASK_ID_EDEFAULT);
				return;
			case EAppshellModelPackage.EURL_ELEMENT__ICON_SKIN_MAJOR_ID:
				setIconSkinMajorId(ICON_SKIN_MAJOR_ID_EDEFAULT);
				return;
			case EAppshellModelPackage.EURL_ELEMENT__ICON_SKIN_MINOR_ID:
				setIconSkinMinorId(ICON_SKIN_MINOR_ID_EDEFAULT);
				return;
			case EAppshellModelPackage.EURL_ELEMENT__HIDE_CHANGE_SKIN:
				setHideChangeSkin(HIDE_CHANGE_SKIN_EDEFAULT);
				return;
			case EAppshellModelPackage.EURL_ELEMENT__HIDE_MEM_DETAILS:
				setHideMemDetails(HIDE_MEM_DETAILS_EDEFAULT);
				return;
			case EAppshellModelPackage.EURL_ELEMENT__HIDE_DOWNLOAD:
				setHideDownload(HIDE_DOWNLOAD_EDEFAULT);
				return;
			case EAppshellModelPackage.EURL_ELEMENT__HIDE_ANIMATED_ICONS:
				setHideAnimatedIcons(HIDE_ANIMATED_ICONS_EDEFAULT);
				return;
			case EAppshellModelPackage.EURL_ELEMENT__TITLE_NAME:
				setTitleName(TITLE_NAME_EDEFAULT);
				return;
			case EAppshellModelPackage.EURL_ELEMENT__SHORT_NAME:
				setShortName(SHORT_NAME_EDEFAULT);
				return;
			case EAppshellModelPackage.EURL_ELEMENT__LONG_NAME:
				setLongName(LONG_NAME_EDEFAULT);
				return;
			case EAppshellModelPackage.EURL_ELEMENT__URL:
				setUrl(URL_EDEFAULT);
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
			case EAppshellModelPackage.EURL_ELEMENT__LOCK_NAME:
				return lockName != LOCK_NAME_EDEFAULT;
			case EAppshellModelPackage.EURL_ELEMENT__LOCK_ICON:
				return lockIcon != LOCK_ICON_EDEFAULT;
			case EAppshellModelPackage.EURL_ELEMENT__LOCK_DELETE:
				return lockDelete != LOCK_DELETE_EDEFAULT;
			case EAppshellModelPackage.EURL_ELEMENT__LOCK_ORGANIZE:
				return lockOrganize != LOCK_ORGANIZE_EDEFAULT;
			case EAppshellModelPackage.EURL_ELEMENT__ICON_FILE:
				return ICON_FILE_EDEFAULT == null ? iconFile != null : !ICON_FILE_EDEFAULT.equals(iconFile);
			case EAppshellModelPackage.EURL_ELEMENT__M3G_ICON_FILE:
				return M3G_ICON_FILE_EDEFAULT == null ? m3gIconFile != null : !M3G_ICON_FILE_EDEFAULT.equals(m3gIconFile);
			case EAppshellModelPackage.EURL_ELEMENT__ICON_ID:
				return ICON_ID_EDEFAULT == null ? iconId != null : !ICON_ID_EDEFAULT.equals(iconId);
			case EAppshellModelPackage.EURL_ELEMENT__MASK_ID:
				return MASK_ID_EDEFAULT == null ? maskId != null : !MASK_ID_EDEFAULT.equals(maskId);
			case EAppshellModelPackage.EURL_ELEMENT__ICON_SKIN_MAJOR_ID:
				return ICON_SKIN_MAJOR_ID_EDEFAULT == null ? iconSkinMajorId != null : !ICON_SKIN_MAJOR_ID_EDEFAULT.equals(iconSkinMajorId);
			case EAppshellModelPackage.EURL_ELEMENT__ICON_SKIN_MINOR_ID:
				return ICON_SKIN_MINOR_ID_EDEFAULT == null ? iconSkinMinorId != null : !ICON_SKIN_MINOR_ID_EDEFAULT.equals(iconSkinMinorId);
			case EAppshellModelPackage.EURL_ELEMENT__HIDE_CHANGE_SKIN:
				return hideChangeSkin != HIDE_CHANGE_SKIN_EDEFAULT;
			case EAppshellModelPackage.EURL_ELEMENT__HIDE_MEM_DETAILS:
				return hideMemDetails != HIDE_MEM_DETAILS_EDEFAULT;
			case EAppshellModelPackage.EURL_ELEMENT__HIDE_DOWNLOAD:
				return hideDownload != HIDE_DOWNLOAD_EDEFAULT;
			case EAppshellModelPackage.EURL_ELEMENT__HIDE_ANIMATED_ICONS:
				return hideAnimatedIcons != HIDE_ANIMATED_ICONS_EDEFAULT;
			case EAppshellModelPackage.EURL_ELEMENT__TITLE_NAME:
				return TITLE_NAME_EDEFAULT == null ? titleName != null : !TITLE_NAME_EDEFAULT.equals(titleName);
			case EAppshellModelPackage.EURL_ELEMENT__SHORT_NAME:
				return SHORT_NAME_EDEFAULT == null ? shortName != null : !SHORT_NAME_EDEFAULT.equals(shortName);
			case EAppshellModelPackage.EURL_ELEMENT__LONG_NAME:
				return LONG_NAME_EDEFAULT == null ? longName != null : !LONG_NAME_EDEFAULT.equals(longName);
			case EAppshellModelPackage.EURL_ELEMENT__URL:
				return URL_EDEFAULT == null ? url != null : !URL_EDEFAULT.equals(url);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == EIconDescriptor.class) {
			switch (derivedFeatureID) {
				case EAppshellModelPackage.EURL_ELEMENT__ICON_FILE: return EAppshellModelPackage.EICON_DESCRIPTOR__ICON_FILE;
				case EAppshellModelPackage.EURL_ELEMENT__M3G_ICON_FILE: return EAppshellModelPackage.EICON_DESCRIPTOR__M3G_ICON_FILE;
				case EAppshellModelPackage.EURL_ELEMENT__ICON_ID: return EAppshellModelPackage.EICON_DESCRIPTOR__ICON_ID;
				case EAppshellModelPackage.EURL_ELEMENT__MASK_ID: return EAppshellModelPackage.EICON_DESCRIPTOR__MASK_ID;
				case EAppshellModelPackage.EURL_ELEMENT__ICON_SKIN_MAJOR_ID: return EAppshellModelPackage.EICON_DESCRIPTOR__ICON_SKIN_MAJOR_ID;
				case EAppshellModelPackage.EURL_ELEMENT__ICON_SKIN_MINOR_ID: return EAppshellModelPackage.EICON_DESCRIPTOR__ICON_SKIN_MINOR_ID;
				default: return -1;
			}
		}
		if (baseClass == EHideDescriptor.class) {
			switch (derivedFeatureID) {
				case EAppshellModelPackage.EURL_ELEMENT__HIDE_CHANGE_SKIN: return EAppshellModelPackage.EHIDE_DESCRIPTOR__HIDE_CHANGE_SKIN;
				case EAppshellModelPackage.EURL_ELEMENT__HIDE_MEM_DETAILS: return EAppshellModelPackage.EHIDE_DESCRIPTOR__HIDE_MEM_DETAILS;
				case EAppshellModelPackage.EURL_ELEMENT__HIDE_DOWNLOAD: return EAppshellModelPackage.EHIDE_DESCRIPTOR__HIDE_DOWNLOAD;
				case EAppshellModelPackage.EURL_ELEMENT__HIDE_ANIMATED_ICONS: return EAppshellModelPackage.EHIDE_DESCRIPTOR__HIDE_ANIMATED_ICONS;
				default: return -1;
			}
		}
		if (baseClass == ENameDescriptor.class) {
			switch (derivedFeatureID) {
				case EAppshellModelPackage.EURL_ELEMENT__TITLE_NAME: return EAppshellModelPackage.ENAME_DESCRIPTOR__TITLE_NAME;
				case EAppshellModelPackage.EURL_ELEMENT__SHORT_NAME: return EAppshellModelPackage.ENAME_DESCRIPTOR__SHORT_NAME;
				case EAppshellModelPackage.EURL_ELEMENT__LONG_NAME: return EAppshellModelPackage.ENAME_DESCRIPTOR__LONG_NAME;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == EIconDescriptor.class) {
			switch (baseFeatureID) {
				case EAppshellModelPackage.EICON_DESCRIPTOR__ICON_FILE: return EAppshellModelPackage.EURL_ELEMENT__ICON_FILE;
				case EAppshellModelPackage.EICON_DESCRIPTOR__M3G_ICON_FILE: return EAppshellModelPackage.EURL_ELEMENT__M3G_ICON_FILE;
				case EAppshellModelPackage.EICON_DESCRIPTOR__ICON_ID: return EAppshellModelPackage.EURL_ELEMENT__ICON_ID;
				case EAppshellModelPackage.EICON_DESCRIPTOR__MASK_ID: return EAppshellModelPackage.EURL_ELEMENT__MASK_ID;
				case EAppshellModelPackage.EICON_DESCRIPTOR__ICON_SKIN_MAJOR_ID: return EAppshellModelPackage.EURL_ELEMENT__ICON_SKIN_MAJOR_ID;
				case EAppshellModelPackage.EICON_DESCRIPTOR__ICON_SKIN_MINOR_ID: return EAppshellModelPackage.EURL_ELEMENT__ICON_SKIN_MINOR_ID;
				default: return -1;
			}
		}
		if (baseClass == EHideDescriptor.class) {
			switch (baseFeatureID) {
				case EAppshellModelPackage.EHIDE_DESCRIPTOR__HIDE_CHANGE_SKIN: return EAppshellModelPackage.EURL_ELEMENT__HIDE_CHANGE_SKIN;
				case EAppshellModelPackage.EHIDE_DESCRIPTOR__HIDE_MEM_DETAILS: return EAppshellModelPackage.EURL_ELEMENT__HIDE_MEM_DETAILS;
				case EAppshellModelPackage.EHIDE_DESCRIPTOR__HIDE_DOWNLOAD: return EAppshellModelPackage.EURL_ELEMENT__HIDE_DOWNLOAD;
				case EAppshellModelPackage.EHIDE_DESCRIPTOR__HIDE_ANIMATED_ICONS: return EAppshellModelPackage.EURL_ELEMENT__HIDE_ANIMATED_ICONS;
				default: return -1;
			}
		}
		if (baseClass == ENameDescriptor.class) {
			switch (baseFeatureID) {
				case EAppshellModelPackage.ENAME_DESCRIPTOR__TITLE_NAME: return EAppshellModelPackage.EURL_ELEMENT__TITLE_NAME;
				case EAppshellModelPackage.ENAME_DESCRIPTOR__SHORT_NAME: return EAppshellModelPackage.EURL_ELEMENT__SHORT_NAME;
				case EAppshellModelPackage.ENAME_DESCRIPTOR__LONG_NAME: return EAppshellModelPackage.EURL_ELEMENT__LONG_NAME;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (lockName: ");
		result.append(lockName);
		result.append(", lockIcon: ");
		result.append(lockIcon);
		result.append(", lockDelete: ");
		result.append(lockDelete);
		result.append(", lockOrganize: ");
		result.append(lockOrganize);
		result.append(", iconFile: ");
		result.append(iconFile);
		result.append(", m3gIconFile: ");
		result.append(m3gIconFile);
		result.append(", iconId: ");
		result.append(iconId);
		result.append(", maskId: ");
		result.append(maskId);
		result.append(", iconSkinMajorId: ");
		result.append(iconSkinMajorId);
		result.append(", iconSkinMinorId: ");
		result.append(iconSkinMinorId);
		result.append(", hideChangeSkin: ");
		result.append(hideChangeSkin);
		result.append(", hideMemDetails: ");
		result.append(hideMemDetails);
		result.append(", hideDownload: ");
		result.append(hideDownload);
		result.append(", hideAnimatedIcons: ");
		result.append(hideAnimatedIcons);
		result.append(", titleName: ");
		result.append(titleName);
		result.append(", shortName: ");
		result.append(shortName);
		result.append(", longName: ");
		result.append(longName);
		result.append(", url: ");
		result.append(url);
		result.append(')');
		return result.toString();
	}

} //EURLElementImpl
