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

package com.nokia.tools.s60ct.content.confml.impl;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.nokia.tools.s60ct.content.confml.ConfmlPackage;
import com.nokia.tools.s60ct.content.confml.FilePath;
import com.nokia.tools.s60ct.content.confml.FileSystemEntrySetting;
import com.nokia.tools.s60ct.content.confml.LeafGroup;
import com.nokia.tools.s60ct.content.confml.Option;
import com.nokia.tools.s60ct.content.confml.OptionMapEntry;
import com.nokia.tools.s60ct.content.confml.ParentGroup;
import com.nokia.tools.s60ct.content.confml.Property;
import com.nokia.tools.s60ct.content.confml.SequenceItem;
import com.nokia.tools.s60ct.content.confml.SequenceSetting;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>File Path</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.impl.FilePathImpl#getPath <em>Path</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.impl.FilePathImpl#getLastSavedPath <em>Last Saved Path</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.impl.FilePathImpl#getDefaultPath <em>Default Path</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.impl.FilePathImpl#isPathReadOnly <em>Path Read Only</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.impl.FilePathImpl#getPathNameOverride <em>Path Name Override</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.impl.FilePathImpl#getPathDescriptionOverride <em>Path Description Override</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.impl.FilePathImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.impl.FilePathImpl#isContainedInLastLayer <em>Contained In Last Layer</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.impl.FilePathImpl#isLastSavedInLastLayer <em>Last Saved In Last Layer</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FilePathImpl extends FileSystemEntrySettingImpl implements FilePath {
	/**
	 * The default value of the '{@link #getPath() <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected static final String PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPath() <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected String path = PATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getLastSavedPath() <em>Last Saved Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastSavedPath()
	 * @generated
	 * @ordered
	 */
	protected static final String LAST_SAVED_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLastSavedPath() <em>Last Saved Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastSavedPath()
	 * @generated
	 * @ordered
	 */
	protected String lastSavedPath = LAST_SAVED_PATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getDefaultPath() <em>Default Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultPath()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFAULT_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefaultPath() <em>Default Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultPath()
	 * @generated
	 * @ordered
	 */
	protected String defaultPath = DEFAULT_PATH_EDEFAULT;

	/**
	 * The default value of the '{@link #isPathReadOnly() <em>Path Read Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPathReadOnly()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PATH_READ_ONLY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isPathReadOnly() <em>Path Read Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPathReadOnly()
	 * @generated
	 * @ordered
	 */
	protected boolean pathReadOnly = PATH_READ_ONLY_EDEFAULT;

	/**
	 * The default value of the '{@link #getPathNameOverride() <em>Path Name Override</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPathNameOverride()
	 * @generated
	 * @ordered
	 */
	protected static final String PATH_NAME_OVERRIDE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPathNameOverride() <em>Path Name Override</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPathNameOverride()
	 * @generated
	 * @ordered
	 */
	protected String pathNameOverride = PATH_NAME_OVERRIDE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPathDescriptionOverride() <em>Path Description Override</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPathDescriptionOverride()
	 * @generated
	 * @ordered
	 */
	protected static final String PATH_DESCRIPTION_OVERRIDE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPathDescriptionOverride() <em>Path Description Override</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPathDescriptionOverride()
	 * @generated
	 * @ordered
	 */
	protected String pathDescriptionOverride = PATH_DESCRIPTION_OVERRIDE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getParent() <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParent()
	 * @generated
	 * @ordered
	 */
	protected FileSystemEntrySetting parent;

	/**
	 * The default value of the '{@link #isContainedInLastLayer() <em>Contained In Last Layer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isContainedInLastLayer()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CONTAINED_IN_LAST_LAYER_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isContainedInLastLayer() <em>Contained In Last Layer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isContainedInLastLayer()
	 * @generated
	 * @ordered
	 */
	protected boolean containedInLastLayer = CONTAINED_IN_LAST_LAYER_EDEFAULT;

	/**
	 * The default value of the '{@link #isLastSavedInLastLayer() <em>Last Saved In Last Layer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLastSavedInLastLayer()
	 * @generated
	 * @ordered
	 */
	protected static final boolean LAST_SAVED_IN_LAST_LAYER_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isLastSavedInLastLayer() <em>Last Saved In Last Layer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLastSavedInLastLayer()
	 * @generated
	 * @ordered
	 */
	protected boolean lastSavedInLastLayer = LAST_SAVED_IN_LAST_LAYER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FilePathImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfmlPackage.Literals.FILE_PATH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPath() {
		return path;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void setPath(String newPath) {
		String oldPath = path;
		path = newPath;

		// if value is one of options, then remember it
		setChoosenOption(findChosenOption(newPath));

		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ConfmlPackage.FILE_PATH__PATH, oldPath, path));
	}

	/**
	 * Method goes through setting options and 
	 * whether one of them matches to path in argument the chosen option is set.
	 * @param newPath
	 * @return
	 */
	public String findChosenOption(String newPath) {
		chosenOption = null;
		if (option != null && newPath != null) {
			for (Option opt : option) {
				Map<String, OptionMapEntry> optionValues = opt
						.getOptionValues();
				if (optionValues != null) {
					for (String optionKey : optionValues.keySet()) {
						if (newPath.equals(optionValues.get(optionKey)
								.getValue2Save())) {
							return optionKey;
						}
					}
					if (getChosenOption() != null) {
						return getChosenOption();
					}
				}
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLastSavedPath() {
		return lastSavedPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastSavedPath(String newLastSavedPath) {
		String oldLastSavedPath = lastSavedPath;
		lastSavedPath = newLastSavedPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.FILE_PATH__LAST_SAVED_PATH, oldLastSavedPath, lastSavedPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDefaultPath() {
		return defaultPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultPath(String newDefaultPath) {
		String oldDefaultPath = defaultPath;
		defaultPath = newDefaultPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.FILE_PATH__DEFAULT_PATH, oldDefaultPath, defaultPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPathReadOnly() {
		return pathReadOnly;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPathReadOnly(boolean newPathReadOnly) {
		boolean oldPathReadOnly = pathReadOnly;
		pathReadOnly = newPathReadOnly;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.FILE_PATH__PATH_READ_ONLY, oldPathReadOnly, pathReadOnly));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPathNameOverride() {
		return pathNameOverride;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPathNameOverride(String newPathNameOverride) {
		String oldPathNameOverride = pathNameOverride;
		pathNameOverride = newPathNameOverride;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.FILE_PATH__PATH_NAME_OVERRIDE, oldPathNameOverride, pathNameOverride));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPathDescriptionOverride() {
		return pathDescriptionOverride;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPathDescriptionOverride(String newPathDescriptionOverride) {
		String oldPathDescriptionOverride = pathDescriptionOverride;
		pathDescriptionOverride = newPathDescriptionOverride;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.FILE_PATH__PATH_DESCRIPTION_OVERRIDE, oldPathDescriptionOverride, pathDescriptionOverride));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FileSystemEntrySetting getParent() {
		if (parent != null && parent.eIsProxy()) {
			InternalEObject oldParent = (InternalEObject)parent;
			parent = (FileSystemEntrySetting)eResolveProxy(oldParent);
			if (parent != oldParent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConfmlPackage.FILE_PATH__PARENT, oldParent, parent));
			}
		}
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FileSystemEntrySetting basicGetParent() {
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(FileSystemEntrySetting newParent) {
		FileSystemEntrySetting oldParent = parent;
		parent = newParent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.FILE_PATH__PARENT, oldParent, parent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isContainedInLastLayer() {
		return containedInLastLayer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainedInLastLayer(boolean newContainedInLastLayer) {
		boolean oldContainedInLastLayer = containedInLastLayer;
		containedInLastLayer = newContainedInLastLayer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.FILE_PATH__CONTAINED_IN_LAST_LAYER, oldContainedInLastLayer, containedInLastLayer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isLastSavedInLastLayer() {
		return lastSavedInLastLayer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastSavedInLastLayer(boolean newLastSavedInLastLayer) {
		boolean oldLastSavedInLastLayer = lastSavedInLastLayer;
		lastSavedInLastLayer = newLastSavedInLastLayer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.FILE_PATH__LAST_SAVED_IN_LAST_LAYER, oldLastSavedInLastLayer, lastSavedInLastLayer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConfmlPackage.FILE_PATH__PATH:
				return getPath();
			case ConfmlPackage.FILE_PATH__LAST_SAVED_PATH:
				return getLastSavedPath();
			case ConfmlPackage.FILE_PATH__DEFAULT_PATH:
				return getDefaultPath();
			case ConfmlPackage.FILE_PATH__PATH_READ_ONLY:
				return isPathReadOnly() ? Boolean.TRUE : Boolean.FALSE;
			case ConfmlPackage.FILE_PATH__PATH_NAME_OVERRIDE:
				return getPathNameOverride();
			case ConfmlPackage.FILE_PATH__PATH_DESCRIPTION_OVERRIDE:
				return getPathDescriptionOverride();
			case ConfmlPackage.FILE_PATH__PARENT:
				if (resolve) return getParent();
				return basicGetParent();
			case ConfmlPackage.FILE_PATH__CONTAINED_IN_LAST_LAYER:
				return isContainedInLastLayer() ? Boolean.TRUE : Boolean.FALSE;
			case ConfmlPackage.FILE_PATH__LAST_SAVED_IN_LAST_LAYER:
				return isLastSavedInLastLayer() ? Boolean.TRUE : Boolean.FALSE;
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
			case ConfmlPackage.FILE_PATH__PATH:
				setPath((String)newValue);
				return;
			case ConfmlPackage.FILE_PATH__LAST_SAVED_PATH:
				setLastSavedPath((String)newValue);
				return;
			case ConfmlPackage.FILE_PATH__DEFAULT_PATH:
				setDefaultPath((String)newValue);
				return;
			case ConfmlPackage.FILE_PATH__PATH_READ_ONLY:
				setPathReadOnly(((Boolean)newValue).booleanValue());
				return;
			case ConfmlPackage.FILE_PATH__PATH_NAME_OVERRIDE:
				setPathNameOverride((String)newValue);
				return;
			case ConfmlPackage.FILE_PATH__PATH_DESCRIPTION_OVERRIDE:
				setPathDescriptionOverride((String)newValue);
				return;
			case ConfmlPackage.FILE_PATH__PARENT:
				setParent((FileSystemEntrySetting)newValue);
				return;
			case ConfmlPackage.FILE_PATH__CONTAINED_IN_LAST_LAYER:
				setContainedInLastLayer(((Boolean)newValue).booleanValue());
				return;
			case ConfmlPackage.FILE_PATH__LAST_SAVED_IN_LAST_LAYER:
				setLastSavedInLastLayer(((Boolean)newValue).booleanValue());
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
			case ConfmlPackage.FILE_PATH__PATH:
				setPath(PATH_EDEFAULT);
				return;
			case ConfmlPackage.FILE_PATH__LAST_SAVED_PATH:
				setLastSavedPath(LAST_SAVED_PATH_EDEFAULT);
				return;
			case ConfmlPackage.FILE_PATH__DEFAULT_PATH:
				setDefaultPath(DEFAULT_PATH_EDEFAULT);
				return;
			case ConfmlPackage.FILE_PATH__PATH_READ_ONLY:
				setPathReadOnly(PATH_READ_ONLY_EDEFAULT);
				return;
			case ConfmlPackage.FILE_PATH__PATH_NAME_OVERRIDE:
				setPathNameOverride(PATH_NAME_OVERRIDE_EDEFAULT);
				return;
			case ConfmlPackage.FILE_PATH__PATH_DESCRIPTION_OVERRIDE:
				setPathDescriptionOverride(PATH_DESCRIPTION_OVERRIDE_EDEFAULT);
				return;
			case ConfmlPackage.FILE_PATH__PARENT:
				setParent((FileSystemEntrySetting)null);
				return;
			case ConfmlPackage.FILE_PATH__CONTAINED_IN_LAST_LAYER:
				setContainedInLastLayer(CONTAINED_IN_LAST_LAYER_EDEFAULT);
				return;
			case ConfmlPackage.FILE_PATH__LAST_SAVED_IN_LAST_LAYER:
				setLastSavedInLastLayer(LAST_SAVED_IN_LAST_LAYER_EDEFAULT);
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
			case ConfmlPackage.FILE_PATH__PATH:
				return PATH_EDEFAULT == null ? path != null : !PATH_EDEFAULT.equals(path);
			case ConfmlPackage.FILE_PATH__LAST_SAVED_PATH:
				return LAST_SAVED_PATH_EDEFAULT == null ? lastSavedPath != null : !LAST_SAVED_PATH_EDEFAULT.equals(lastSavedPath);
			case ConfmlPackage.FILE_PATH__DEFAULT_PATH:
				return DEFAULT_PATH_EDEFAULT == null ? defaultPath != null : !DEFAULT_PATH_EDEFAULT.equals(defaultPath);
			case ConfmlPackage.FILE_PATH__PATH_READ_ONLY:
				return pathReadOnly != PATH_READ_ONLY_EDEFAULT;
			case ConfmlPackage.FILE_PATH__PATH_NAME_OVERRIDE:
				return PATH_NAME_OVERRIDE_EDEFAULT == null ? pathNameOverride != null : !PATH_NAME_OVERRIDE_EDEFAULT.equals(pathNameOverride);
			case ConfmlPackage.FILE_PATH__PATH_DESCRIPTION_OVERRIDE:
				return PATH_DESCRIPTION_OVERRIDE_EDEFAULT == null ? pathDescriptionOverride != null : !PATH_DESCRIPTION_OVERRIDE_EDEFAULT.equals(pathDescriptionOverride);
			case ConfmlPackage.FILE_PATH__PARENT:
				return parent != null;
			case ConfmlPackage.FILE_PATH__CONTAINED_IN_LAST_LAYER:
				return containedInLastLayer != CONTAINED_IN_LAST_LAYER_EDEFAULT;
			case ConfmlPackage.FILE_PATH__LAST_SAVED_IN_LAST_LAYER:
				return lastSavedInLastLayer != LAST_SAVED_IN_LAST_LAYER_EDEFAULT;
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
		result.append(" (path: ");
		result.append(path);
		result.append(", lastSavedPath: ");
		result.append(lastSavedPath);
		result.append(", defaultPath: ");
		result.append(defaultPath);
		result.append(", pathReadOnly: ");
		result.append(pathReadOnly);
		result.append(", pathNameOverride: ");
		result.append(pathNameOverride);
		result.append(", pathDescriptionOverride: ");
		result.append(pathDescriptionOverride);
		result.append(", containedInLastLayer: ");
		result.append(containedInLastLayer);
		result.append(", lastSavedInLastLayer: ");
		result.append(lastSavedInLastLayer);
		result.append(')');
		return result.toString();
	}

	
	@Override
	public String getName() {
		FileSystemEntrySetting parent = getParent();
		if(parent!=null){
			return parent.getName();
		}
		return super.getName();
	}
	
	@Override
	public boolean isDefault() {
		// The setting is default in case its source or target path are defaults
		if (eContainer()!=null && eContainer().eContainer() instanceof SequenceItem) {
			if(eContainer().eContainer().eContainer() instanceof SequenceSetting){
				return ((SequenceSetting)eContainer().eContainer().eContainer()).isDefault();
			}
		}
		return isPathDefault();
	}
	

	
	private boolean isPathDefault() {
		if (defaultPath == null && path == null
				|| defaultPath == null && path != null
				&& path.equals("") || path == null
				&& defaultPath != null && defaultPath.equals("")) {
			return true;
		}
		if (defaultPath != null && defaultPath.equals(path)&&!isContainedInLastLayer()) {
			return true;
		}
		return false;

	}

//	@Override
//	public boolean isComputedRelevant(){
//		return getParent().isComputedRelevant();
//	}
//	
//	@Override
//	public void setComputedRelevant(boolean value){
//		getParent().setComputedRelevant(value);
//	}
	

	@Override
	public boolean isFile(){
		return getParent().isFile();
	}
	@Override
	public void setFile(boolean value){
		 getParent().setFile(value);
	}
	

	
	@Override
	public EList<Property> getProperty(){
		return getParent().getProperty();
	}	
	
	@Override
	/*
	 * @generated NOT
	 */
	public boolean isDirty() {
	
		
			if (lastSavedPath != null && !lastSavedPath.equals(path)) {
				return true;
			}
			if (lastSavedPath != null && lastSavedPath.equals(path)
					&& lastSavedInLastLayer != containedInLastLayer) {
				return true;
			}
			if (lastSavedPath == null && path != null) {
				return true;
			}

			// return (nrOfChanges!=0)?true:false;

	
		return false;
	}



	@Override
	public void setReadOnly(boolean value){
		setPathReadOnly(value);
	}	
	@Override
	public boolean isReadOnly(){
		return isPathReadOnly();
	}
	@Override
	public void setNote(String value){
		getParent().setNote(value);
	}
	@Override
	public String getNote(){
		return getParent().getNote();
	}	
	@Override
	public EList<LeafGroup> getLeafGroup(){
		return getParent().getLeafGroup();
	}	
	@Override
	public EList<ParentGroup> getParentGroup(){
		return getParent().getParentGroup();
	}	
	@Override
	public FilePath getSourceFilePath(){
		return getParent().getSourceFilePath();
	}	
	@Override
	public FilePath getTargetFilePath(){
		return getParent().getTargetFilePath();
	}	

	

} //FilePathImpl
