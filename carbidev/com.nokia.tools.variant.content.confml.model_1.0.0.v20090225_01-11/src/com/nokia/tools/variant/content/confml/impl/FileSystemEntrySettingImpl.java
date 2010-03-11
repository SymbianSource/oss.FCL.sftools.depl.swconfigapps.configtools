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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.nokia.tools.variant.content.confml.ConfmlPackage;
import com.nokia.tools.variant.content.confml.FilePath;
import com.nokia.tools.variant.content.confml.FileSystemEntrySetting;
import com.nokia.tools.variant.content.confml.SequenceItem;
import com.nokia.tools.variant.content.confml.SequenceSetting;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>File System Entry Setting</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.variant.content.confml.impl.FileSystemEntrySettingImpl#isFile <em>File</em>}</li>
 *   <li>{@link com.nokia.tools.variant.content.confml.impl.FileSystemEntrySettingImpl#getSourceFilePath <em>Source File Path</em>}</li>
 *   <li>{@link com.nokia.tools.variant.content.confml.impl.FileSystemEntrySettingImpl#getTargetFilePath <em>Target File Path</em>}</li>
 *   <li>{@link com.nokia.tools.variant.content.confml.impl.FileSystemEntrySettingImpl#getChoosenOption <em>Choosen Option</em>}</li>
 *   <li>{@link com.nokia.tools.variant.content.confml.impl.FileSystemEntrySettingImpl#getPattern <em>Pattern</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FileSystemEntrySettingImpl extends SettingImpl implements
		FileSystemEntrySetting {
	/**
	 * The default value of the '{@link #isFile() <em>File</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isFile()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FILE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isFile() <em>File</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isFile()
	 * @generated
	 * @ordered
	 */
	protected boolean file = FILE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSourceFilePath() <em>Source File Path</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceFilePath()
	 * @generated
	 * @ordered
	 */
	protected FilePath sourceFilePath;

	/**
	 * The cached value of the '{@link #getTargetFilePath() <em>Target File Path</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetFilePath()
	 * @generated
	 * @ordered
	 */
	protected FilePath targetFilePath;

	/**
	 * The default value of the '{@link #getChoosenOption() <em>Choosen Option</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChoosenOption()
	 * @generated
	 * @ordered
	 */
	protected static final String CHOOSEN_OPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getChoosenOption() <em>Choosen Option</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChoosenOption()
	 * @generated
	 * @ordered
	 */
	protected String choosenOption = CHOOSEN_OPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getPattern() <em>Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPattern()
	 * @generated
	 * @ordered
	 */
	protected static final String PATTERN_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getPattern() <em>Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPattern()
	 * @generated
	 * @ordered
	 */
	protected String pattern = PATTERN_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected FileSystemEntrySettingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfmlPackage.Literals.FILE_SYSTEM_ENTRY_SETTING;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFile() {
		return file;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setFile(boolean newFile) {
		boolean oldFile = file;
		file = newFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.FILE_SYSTEM_ENTRY_SETTING__FILE, oldFile, file));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FilePath getSourceFilePath() {
		return sourceFilePath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSourceFilePath(FilePath newSourceFilePath, NotificationChain msgs) {
		FilePath oldSourceFilePath = sourceFilePath;
		sourceFilePath = newSourceFilePath;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfmlPackage.FILE_SYSTEM_ENTRY_SETTING__SOURCE_FILE_PATH, oldSourceFilePath, newSourceFilePath);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceFilePath(FilePath newSourceFilePath) {
		if (newSourceFilePath != sourceFilePath) {
			NotificationChain msgs = null;
			if (sourceFilePath != null)
				msgs = ((InternalEObject)sourceFilePath).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfmlPackage.FILE_SYSTEM_ENTRY_SETTING__SOURCE_FILE_PATH, null, msgs);
			if (newSourceFilePath != null)
				msgs = ((InternalEObject)newSourceFilePath).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfmlPackage.FILE_SYSTEM_ENTRY_SETTING__SOURCE_FILE_PATH, null, msgs);
			msgs = basicSetSourceFilePath(newSourceFilePath, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.FILE_SYSTEM_ENTRY_SETTING__SOURCE_FILE_PATH, newSourceFilePath, newSourceFilePath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FilePath getTargetFilePath() {
		return targetFilePath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTargetFilePath(FilePath newTargetFilePath, NotificationChain msgs) {
		FilePath oldTargetFilePath = targetFilePath;
		targetFilePath = newTargetFilePath;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfmlPackage.FILE_SYSTEM_ENTRY_SETTING__TARGET_FILE_PATH, oldTargetFilePath, newTargetFilePath);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetFilePath(FilePath newTargetFilePath) {
		if (newTargetFilePath != targetFilePath) {
			NotificationChain msgs = null;
			if (targetFilePath != null)
				msgs = ((InternalEObject)targetFilePath).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfmlPackage.FILE_SYSTEM_ENTRY_SETTING__TARGET_FILE_PATH, null, msgs);
			if (newTargetFilePath != null)
				msgs = ((InternalEObject)newTargetFilePath).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfmlPackage.FILE_SYSTEM_ENTRY_SETTING__TARGET_FILE_PATH, null, msgs);
			msgs = basicSetTargetFilePath(newTargetFilePath, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.FILE_SYSTEM_ENTRY_SETTING__TARGET_FILE_PATH, newTargetFilePath, newTargetFilePath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getChoosenOption() {
		return choosenOption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setChoosenOption(String newChoosenOption) {
//		String oldChoosenOption = choosenOption;
		choosenOption = newChoosenOption;
//		if (eNotificationRequired())
//			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.FILE_SYSTEM_ENTRY_SETTING__CHOOSEN_OPTION, oldChoosenOption, choosenOption));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPattern() {
		return pattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPattern(String newPattern) {
		String oldPattern = pattern;
		pattern = newPattern;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.FILE_SYSTEM_ENTRY_SETTING__PATTERN, oldPattern, pattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConfmlPackage.FILE_SYSTEM_ENTRY_SETTING__SOURCE_FILE_PATH:
				return basicSetSourceFilePath(null, msgs);
			case ConfmlPackage.FILE_SYSTEM_ENTRY_SETTING__TARGET_FILE_PATH:
				return basicSetTargetFilePath(null, msgs);
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
			case ConfmlPackage.FILE_SYSTEM_ENTRY_SETTING__FILE:
				return isFile() ? Boolean.TRUE : Boolean.FALSE;
			case ConfmlPackage.FILE_SYSTEM_ENTRY_SETTING__SOURCE_FILE_PATH:
				return getSourceFilePath();
			case ConfmlPackage.FILE_SYSTEM_ENTRY_SETTING__TARGET_FILE_PATH:
				return getTargetFilePath();
			case ConfmlPackage.FILE_SYSTEM_ENTRY_SETTING__CHOOSEN_OPTION:
				return getChoosenOption();
			case ConfmlPackage.FILE_SYSTEM_ENTRY_SETTING__PATTERN:
				return getPattern();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ConfmlPackage.FILE_SYSTEM_ENTRY_SETTING__FILE:
				setFile(((Boolean)newValue).booleanValue());
				return;
			case ConfmlPackage.FILE_SYSTEM_ENTRY_SETTING__SOURCE_FILE_PATH:
				setSourceFilePath((FilePath)newValue);
				return;
			case ConfmlPackage.FILE_SYSTEM_ENTRY_SETTING__TARGET_FILE_PATH:
				setTargetFilePath((FilePath)newValue);
				return;
			case ConfmlPackage.FILE_SYSTEM_ENTRY_SETTING__CHOOSEN_OPTION:
				setChoosenOption((String)newValue);
				return;
			case ConfmlPackage.FILE_SYSTEM_ENTRY_SETTING__PATTERN:
				setPattern((String)newValue);
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
			case ConfmlPackage.FILE_SYSTEM_ENTRY_SETTING__FILE:
				setFile(FILE_EDEFAULT);
				return;
			case ConfmlPackage.FILE_SYSTEM_ENTRY_SETTING__SOURCE_FILE_PATH:
				setSourceFilePath((FilePath)null);
				return;
			case ConfmlPackage.FILE_SYSTEM_ENTRY_SETTING__TARGET_FILE_PATH:
				setTargetFilePath((FilePath)null);
				return;
			case ConfmlPackage.FILE_SYSTEM_ENTRY_SETTING__CHOOSEN_OPTION:
				setChoosenOption(CHOOSEN_OPTION_EDEFAULT);
				return;
			case ConfmlPackage.FILE_SYSTEM_ENTRY_SETTING__PATTERN:
				setPattern(PATTERN_EDEFAULT);
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
			case ConfmlPackage.FILE_SYSTEM_ENTRY_SETTING__FILE:
				return file != FILE_EDEFAULT;
			case ConfmlPackage.FILE_SYSTEM_ENTRY_SETTING__SOURCE_FILE_PATH:
				return sourceFilePath != null;
			case ConfmlPackage.FILE_SYSTEM_ENTRY_SETTING__TARGET_FILE_PATH:
				return targetFilePath != null;
			case ConfmlPackage.FILE_SYSTEM_ENTRY_SETTING__CHOOSEN_OPTION:
				return CHOOSEN_OPTION_EDEFAULT == null ? choosenOption != null : !CHOOSEN_OPTION_EDEFAULT.equals(choosenOption);
			case ConfmlPackage.FILE_SYSTEM_ENTRY_SETTING__PATTERN:
				return PATTERN_EDEFAULT == null ? pattern != null : !PATTERN_EDEFAULT.equals(pattern);
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
		result.append(" (file: ");
		result.append(file);
		result.append(", choosenOption: ");
		result.append(choosenOption);
		result.append(", pattern: ");
		result.append(pattern);
		result.append(')');
		return result.toString();
	}

	public boolean isDirty() {
		
/*		
		if(lastSavedSourcePath!=null&& !lastSavedSourcePath.equals(sourcePath)){
			return true;
		}
		if(lastSavedTargetPath!=null&& !lastSavedTargetPath.equals(targetPath)){
			return true;
		}
//		if(lastSavedSourcePath==null&& sourcePath!=null){
//			return true;
//		}
//		if(lastSavedTargetPath==null&& targetPath!=null){
//			return true;
//		}
		if(lastSavedSourcePath!=null&& lastSavedSourcePath.equals(sourcePath)&&lastSavedInLastLayer!=sourceFilePath.isContainedInLastLayer()){
			return true;
		}
		if(lastSavedTargetPath!=null&& lastSavedTargetPath.equals(targetPath)&&lastSavedInLastLayer!=targetFilePath.isContainedInLastLayer()){
			return true;
		}
		
		if ((lastSavedSourcePath == null) && (sourcePath)!= null) {
			return true;
		}
		if ((lastSavedTargetPath == null) && (targetPath)!= null) {
			return true;
		}
		if ((lastSavedSourcePath == null) && (sourcePath)!= null) {
			return true;
		}
		if ((lastSavedTargetPath == null) && (targetPath)!= null) {
			return true;
		}
		return false;
*/
		return getSourceFilePath().isDirty()||getTargetFilePath().isDirty();
	}
/*
	private boolean isSourcePathDefault() {
		if (defaultSourcePath == null && sourcePath == null
				|| defaultSourcePath == null && sourcePath != null
				&& sourcePath.equals("") || sourcePath == null
				&& defaultSourcePath != null && defaultSourcePath.equals("")) {
			return true;
		}
		if (defaultSourcePath != null && defaultSourcePath.equals(sourcePath)&&! getSourceFilePath().isContainedInLastLayer()) {
			return true;
		}
		return false;

	}

	private boolean isTargetPathDefault() {
		if (defaultTargetPath == null && targetPath == null
				|| defaultTargetPath == null && targetPath != null
				&& targetPath.equals("") || targetPath == null
				&& defaultTargetPath != null && defaultTargetPath.equals("")) {
			return true;
		}
		if (defaultTargetPath != null && defaultTargetPath.equals(targetPath) && !getTargetFilePath().isContainedInLastLayer()) {
			return true;
		}
		return false;

	}
*/
	@Override
	public boolean isDefault() {
		// The setting is default in case its source or target path are defaults
		if (eContainer() instanceof SequenceItem) {
			if(eContainer().eContainer() instanceof SequenceSetting){
				return ((SequenceSetting)eContainer().eContainer()).isDefault();
			}
		}
		return sourceFilePath.isDefault() && targetFilePath.isDefault() ;
	}
	
	@Override
	public boolean isReadOnly() {
		return readOnly||(getSourceFilePath().isPathReadOnly()&&getTargetFilePath().isPathReadOnly());
	}
	

} // FileSystemEntrySettingImpl
