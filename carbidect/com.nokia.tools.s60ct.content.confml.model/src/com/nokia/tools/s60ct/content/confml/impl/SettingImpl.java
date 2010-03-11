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

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.nokia.tools.s60ct.content.confml.ConfmlPackage;
import com.nokia.tools.s60ct.content.confml.Group;
import com.nokia.tools.s60ct.content.confml.LeafGroup;
import com.nokia.tools.s60ct.content.confml.Option;
import com.nokia.tools.s60ct.content.confml.OptionMapEntry;
import com.nokia.tools.s60ct.content.confml.ParentGroup;
import com.nokia.tools.s60ct.content.confml.Property;
import com.nokia.tools.s60ct.content.confml.Setting;
import com.nokia.tools.s60ct.content.confml.TYPE;
import com.nokia.tools.s60ct.content.confml.View;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Setting</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.impl.SettingImpl#getAbsRef <em>Abs Ref</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.impl.SettingImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.impl.SettingImpl#getProperty <em>Property</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.impl.SettingImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.impl.SettingImpl#getLeafGroup <em>Leaf Group</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.impl.SettingImpl#getType <em>Type</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.impl.SettingImpl#isRfsValue <em>Rfs Value</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.impl.SettingImpl#getFeatureName <em>Feature Name</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.impl.SettingImpl#getNote <em>Note</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.impl.SettingImpl#getRelevant <em>Relevant</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.impl.SettingImpl#isRequired <em>Required</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.impl.SettingImpl#getConstraint <em>Constraint</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.impl.SettingImpl#isComputedRelevant <em>Computed Relevant</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.impl.SettingImpl#isComputedConstraint <em>Computed Constraint</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.impl.SettingImpl#isReadOnly <em>Read Only</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.impl.SettingImpl#isValueNull <em>Value Null</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.impl.SettingImpl#getNameOverride <em>Name Override</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.impl.SettingImpl#getDescriptionOverride <em>Description Override</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.impl.SettingImpl#getDependencies <em>Dependencies</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.impl.SettingImpl#getOption <em>Option</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.impl.SettingImpl#getParentGroup <em>Parent Group</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.impl.SettingImpl#getOptionDependencies <em>Option Dependencies</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.impl.SettingImpl#getRelevantAST <em>Relevant AST</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.impl.SettingImpl#getConstraintAST <em>Constraint AST</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.content.confml.impl.SettingImpl#getGroupOptionMap <em>Group Option Map</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SettingImpl extends EObjectImpl implements Setting {
	/**
	 * The default value of the '{@link #getAbsRef() <em>Abs Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAbsRef()
	 * @generated
	 * @ordered
	 */
	protected static final String ABS_REF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAbsRef() <em>Abs Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAbsRef()
	 * @generated
	 * @ordered
	 */
	protected String absRef = ABS_REF_EDEFAULT;

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
	 * The cached value of the '{@link #getProperty() <em>Property</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperty()
	 * @generated
	 * @ordered
	 */
	protected EList<Property> property;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLeafGroup() <em>Leaf Group</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeafGroup()
	 * @generated
	 * @ordered
	 */
	protected EList<LeafGroup> leafGroup;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final TYPE TYPE_EDEFAULT = TYPE.INT;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected TYPE type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #isRfsValue() <em>Rfs Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRfsValue()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RFS_VALUE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isRfsValue() <em>Rfs Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRfsValue()
	 * @generated
	 * @ordered
	 */
	protected boolean rfsValue = RFS_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getFeatureName() <em>Feature Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureName()
	 * @generated
	 * @ordered
	 */
	protected static final String FEATURE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFeatureName() <em>Feature Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureName()
	 * @generated
	 * @ordered
	 */
	protected String featureName = FEATURE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getNote() <em>Note</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNote()
	 * @generated
	 * @ordered
	 */
	protected static final String NOTE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNote() <em>Note</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNote()
	 * @generated
	 * @ordered
	 */
	protected String note = NOTE_EDEFAULT;

	/**
	 * The default value of the '{@link #getRelevant() <em>Relevant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelevant()
	 * @generated
	 * @ordered
	 */
	protected static final String RELEVANT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRelevant() <em>Relevant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelevant()
	 * @generated
	 * @ordered
	 */
	protected String relevant = RELEVANT_EDEFAULT;

	/**
	 * The default value of the '{@link #isRequired() <em>Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRequired()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REQUIRED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isRequired() <em>Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRequired()
	 * @generated
	 * @ordered
	 */
	protected boolean required = REQUIRED_EDEFAULT;

	/**
	 * The default value of the '{@link #getConstraint() <em>Constraint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraint()
	 * @generated
	 * @ordered
	 */
	protected static final String CONSTRAINT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getConstraint() <em>Constraint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraint()
	 * @generated
	 * @ordered
	 */
	protected String constraint = CONSTRAINT_EDEFAULT;

	/**
	 * The default value of the '{@link #isComputedRelevant() <em>Computed Relevant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isComputedRelevant()
	 * @generated
	 * @ordered
	 */
	protected static final boolean COMPUTED_RELEVANT_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isComputedRelevant() <em>Computed Relevant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isComputedRelevant()
	 * @generated
	 * @ordered
	 */
	protected boolean computedRelevant = COMPUTED_RELEVANT_EDEFAULT;

	/**
	 * The default value of the '{@link #isComputedConstraint() <em>Computed Constraint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isComputedConstraint()
	 * @generated
	 * @ordered
	 */
	protected static final boolean COMPUTED_CONSTRAINT_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isComputedConstraint() <em>Computed Constraint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isComputedConstraint()
	 * @generated
	 * @ordered
	 */
	protected boolean computedConstraint = COMPUTED_CONSTRAINT_EDEFAULT;

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
	 * The cached value of the '{@link #isReadOnly() <em>Read Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReadOnly()
	 * @generated
	 * @ordered
	 */
	protected boolean readOnly = READ_ONLY_EDEFAULT;

	/**
	 * The default value of the '{@link #isValueNull() <em>Value Null</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isValueNull()
	 * @generated
	 * @ordered
	 */
	protected static final boolean VALUE_NULL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isValueNull() <em>Value Null</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isValueNull()
	 * @generated
	 * @ordered
	 */
	protected boolean valueNull = VALUE_NULL_EDEFAULT;

	/**
	 * The default value of the '{@link #getNameOverride() <em>Name Override</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNameOverride()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_OVERRIDE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNameOverride() <em>Name Override</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNameOverride()
	 * @generated
	 * @ordered
	 */
	protected String nameOverride = NAME_OVERRIDE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescriptionOverride() <em>Description Override</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescriptionOverride()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_OVERRIDE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescriptionOverride() <em>Description Override</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescriptionOverride()
	 * @generated
	 * @ordered
	 */
	protected String descriptionOverride = DESCRIPTION_OVERRIDE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDependencies() <em>Dependencies</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependencies()
	 * @generated
	 * @ordered
	 */
	protected EList<Object> dependencies;

	/**
	 * The cached value of the '{@link #getOption() <em>Option</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOption()
	 * @generated
	 * @ordered
	 */
	protected EList<Option> option;

	/**
	 * The cached value of the '{@link #getParentGroup() <em>Parent Group</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentGroup()
	 * @generated
	 * @ordered
	 */
	protected EList<ParentGroup> parentGroup;

	/**
	 * The cached value of the '{@link #getOptionDependencies() <em>Option Dependencies</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOptionDependencies()
	 * @generated
	 * @ordered
	 */
	protected EList<Setting> optionDependencies;

	/**
	 * The default value of the '{@link #getRelevantAST() <em>Relevant AST</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelevantAST()
	 * @generated
	 * @ordered
	 */
	protected static final Object RELEVANT_AST_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRelevantAST() <em>Relevant AST</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelevantAST()
	 * @generated
	 * @ordered
	 */
	protected Object relevantAST = RELEVANT_AST_EDEFAULT;

	/**
	 * The default value of the '{@link #getConstraintAST() <em>Constraint AST</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraintAST()
	 * @generated
	 * @ordered
	 */
	protected static final Object CONSTRAINT_AST_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getConstraintAST() <em>Constraint AST</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraintAST()
	 * @generated
	 * @ordered
	 */
	protected Object constraintAST = CONSTRAINT_AST_EDEFAULT;

	/**
	 * The cached value of the '{@link #getGroupOptionMap() <em>Group Option Map</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroupOptionMap()
	 * @generated
	 * @ordered
	 */
	protected Map<Group, EList<Option>> groupOptionMap;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SettingImpl() {
		super();
	}
	protected String featureRef;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfmlPackage.Literals.SETTING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAbsRef() {
		return absRef;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.SETTING__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDefault() {
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAbsRef(String newAbsRef) {
		String oldAbsRef = absRef;
		absRef = newAbsRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.SETTING__ABS_REF, oldAbsRef, absRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDirty() {
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getFeatureRef() {
		if(featureRef == null){
			featureRef = absRef.split("/")[0];
		}
		return featureRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getSettingRef() {
		String[] split = absRef.split("/");
		if(split.length==3){
			return absRef.split("/")[2];
		}else{
			return absRef.split("/")[1];
		}
		
	}

	/**
	 * Handle the visibility of the setting in the view.
	 * 
	 * @generated NOT
	 */
	public boolean isVisible() {
		if (isReadOnly()||!isComputedRelevant()) {
			return false;
		}
		return /*isSettingOrItsParentContainedInSomeGroup(this)*/true;
	}
	
	/**
	 * 
	 * Acquires a view in which is this setting defined. 
	 * Returns null, if this setting is not in the view.
	 * 
	 * @generated NOT
	 */
	public View getView() {
		EObject parent = this;
		while (parent.eContainer() != null) {
			parent = parent.eContainer();
			if (parent instanceof View) {
				return (View) parent;
			}
		}
		
		return null; 
	}

//	private boolean isSettingOrItsParentContainedInSomeGroup(Setting s) { //commented because of performance, is not needed since hide from view is not allowed
//		if (s.getLeafGroup().size() > 0 || s.getParentGroup().size() > 0) {
//			return true;
//		} else {
//			EObject c = s.eContainer();
//			if (c instanceof Setting) {
//				Setting ps = (Setting) c;
//				return isSettingOrItsParentContainedInSomeGroup(ps);
//			} else if (c instanceof SequenceItem) {
//				SequenceItem si = (SequenceItem) c;
//				EObject c2 = si.eContainer();
//				if (c2 instanceof Setting) {
//					Setting ps = (Setting) c2;
//					return isSettingOrItsParentContainedInSomeGroup(ps);
//				} else {
//					return false;
//				}
//			} else {
//				return false;
//			}
//		}
//	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Property> getProperty() {
		if (property == null) {
			property = new EObjectContainmentEList<Property>(Property.class, this, ConfmlPackage.SETTING__PROPERTY);
		}
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.SETTING__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LeafGroup> getLeafGroup() {
		if (leafGroup == null) {
			leafGroup = new EObjectResolvingEList<LeafGroup>(LeafGroup.class, this, ConfmlPackage.SETTING__LEAF_GROUP);
		}
		return leafGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TYPE getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(TYPE newType) {
		TYPE oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.SETTING__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRfsValue() {
		return rfsValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRfsValue(boolean newRfsValue) {
		boolean oldRfsValue = rfsValue;
		rfsValue = newRfsValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.SETTING__RFS_VALUE, oldRfsValue, rfsValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFeatureName() {
		return featureName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeatureName(String newFeatureName) {
		String oldFeatureName = featureName;
		featureName = newFeatureName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.SETTING__FEATURE_NAME, oldFeatureName, featureName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNote() {
		return note;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNote(String newNote) {
		String oldNote = note;
		note = newNote;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.SETTING__NOTE, oldNote, note));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRelevant() {
		return relevant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelevant(String newRelevant) {
		String oldRelevant = relevant;
		relevant = newRelevant;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.SETTING__RELEVANT, oldRelevant, relevant));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRequired() {
		return required;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequired(boolean newRequired) {
		boolean oldRequired = required;
		required = newRequired;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.SETTING__REQUIRED, oldRequired, required));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getConstraint() {
		return constraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConstraint(String newConstraint) {
		String oldConstraint = constraint;
		constraint = newConstraint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.SETTING__CONSTRAINT, oldConstraint, constraint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isComputedRelevant() {
		return computedRelevant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComputedRelevant(boolean newComputedRelevant) {
		boolean oldComputedRelevant = computedRelevant;
		computedRelevant = newComputedRelevant;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.SETTING__COMPUTED_RELEVANT, oldComputedRelevant, computedRelevant));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isComputedConstraint() {
		return computedConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComputedConstraint(boolean newComputedConstraint) {
		boolean oldComputedConstraint = computedConstraint;
		computedConstraint = newComputedConstraint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.SETTING__COMPUTED_CONSTRAINT, oldComputedConstraint, computedConstraint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isReadOnly() {
		return readOnly;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReadOnly(boolean newReadOnly) {
		boolean oldReadOnly = readOnly;
		readOnly = newReadOnly;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.SETTING__READ_ONLY, oldReadOnly, readOnly));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isValueNull() {
		return valueNull;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValueNull(boolean newValueNull) {
		boolean oldValueNull = valueNull;
		valueNull = newValueNull;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.SETTING__VALUE_NULL, oldValueNull, valueNull));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNameOverride() {
		return nameOverride;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNameOverride(String newNameOverride) {
		String oldNameOverride = nameOverride;
		nameOverride = newNameOverride;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.SETTING__NAME_OVERRIDE, oldNameOverride, nameOverride));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescriptionOverride() {
		return descriptionOverride;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescriptionOverride(String newDescriptionOverride) {
		String oldDescriptionOverride = descriptionOverride;
		descriptionOverride = newDescriptionOverride;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.SETTING__DESCRIPTION_OVERRIDE, oldDescriptionOverride, descriptionOverride));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Object> getDependencies() {
		return dependencies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDependencies(EList<Object> newDependencies) {
		EList<Object> oldDependencies = dependencies;
		dependencies = newDependencies;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.SETTING__DEPENDENCIES, oldDependencies, dependencies));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Option> getOption() {
		if (option == null) {
			option = new EObjectContainmentEList<Option>(Option.class, this, ConfmlPackage.SETTING__OPTION);
		}
		return option;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ParentGroup> getParentGroup() {
		if (parentGroup == null) {
			parentGroup = new EObjectResolvingEList<ParentGroup>(ParentGroup.class, this, ConfmlPackage.SETTING__PARENT_GROUP);
		}
		return parentGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Setting> getOptionDependencies() {
		return optionDependencies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOptionDependencies(EList<Setting> newOptionDependencies) {
		EList<Setting> oldOptionDependencies = optionDependencies;
		optionDependencies = newOptionDependencies;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.SETTING__OPTION_DEPENDENCIES, oldOptionDependencies, optionDependencies));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getRelevantAST() {
		return relevantAST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelevantAST(Object newRelevantAST) {
		Object oldRelevantAST = relevantAST;
		relevantAST = newRelevantAST;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.SETTING__RELEVANT_AST, oldRelevantAST, relevantAST));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getConstraintAST() {
		return constraintAST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConstraintAST(Object newConstraintAST) {
		Object oldConstraintAST = constraintAST;
		constraintAST = newConstraintAST;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.SETTING__CONSTRAINT_AST, oldConstraintAST, constraintAST));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Map<Group, EList<Option>> getGroupOptionMap() {
		if(groupOptionMap == null){
			groupOptionMap = new HashMap<Group, EList<Option>>();
		}
		return groupOptionMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGroupOptionMap(Map<Group, EList<Option>> newGroupOptionMap) {
		Map<Group, EList<Option>> oldGroupOptionMap = groupOptionMap;
		groupOptionMap = newGroupOptionMap;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.SETTING__GROUP_OPTION_MAP, oldGroupOptionMap, groupOptionMap));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConfmlPackage.SETTING__PROPERTY:
				return ((InternalEList<?>)getProperty()).basicRemove(otherEnd, msgs);
			case ConfmlPackage.SETTING__OPTION:
				return ((InternalEList<?>)getOption()).basicRemove(otherEnd, msgs);
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
			case ConfmlPackage.SETTING__ABS_REF:
				return getAbsRef();
			case ConfmlPackage.SETTING__NAME:
				return getName();
			case ConfmlPackage.SETTING__PROPERTY:
				return getProperty();
			case ConfmlPackage.SETTING__DESCRIPTION:
				return getDescription();
			case ConfmlPackage.SETTING__LEAF_GROUP:
				return getLeafGroup();
			case ConfmlPackage.SETTING__TYPE:
				return getType();
			case ConfmlPackage.SETTING__RFS_VALUE:
				return isRfsValue() ? Boolean.TRUE : Boolean.FALSE;
			case ConfmlPackage.SETTING__FEATURE_NAME:
				return getFeatureName();
			case ConfmlPackage.SETTING__NOTE:
				return getNote();
			case ConfmlPackage.SETTING__RELEVANT:
				return getRelevant();
			case ConfmlPackage.SETTING__REQUIRED:
				return isRequired() ? Boolean.TRUE : Boolean.FALSE;
			case ConfmlPackage.SETTING__CONSTRAINT:
				return getConstraint();
			case ConfmlPackage.SETTING__COMPUTED_RELEVANT:
				return isComputedRelevant() ? Boolean.TRUE : Boolean.FALSE;
			case ConfmlPackage.SETTING__COMPUTED_CONSTRAINT:
				return isComputedConstraint() ? Boolean.TRUE : Boolean.FALSE;
			case ConfmlPackage.SETTING__READ_ONLY:
				return isReadOnly() ? Boolean.TRUE : Boolean.FALSE;
			case ConfmlPackage.SETTING__VALUE_NULL:
				return isValueNull() ? Boolean.TRUE : Boolean.FALSE;
			case ConfmlPackage.SETTING__NAME_OVERRIDE:
				return getNameOverride();
			case ConfmlPackage.SETTING__DESCRIPTION_OVERRIDE:
				return getDescriptionOverride();
			case ConfmlPackage.SETTING__DEPENDENCIES:
				return getDependencies();
			case ConfmlPackage.SETTING__OPTION:
				return getOption();
			case ConfmlPackage.SETTING__PARENT_GROUP:
				return getParentGroup();
			case ConfmlPackage.SETTING__OPTION_DEPENDENCIES:
				return getOptionDependencies();
			case ConfmlPackage.SETTING__RELEVANT_AST:
				return getRelevantAST();
			case ConfmlPackage.SETTING__CONSTRAINT_AST:
				return getConstraintAST();
			case ConfmlPackage.SETTING__GROUP_OPTION_MAP:
				return getGroupOptionMap();
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
			case ConfmlPackage.SETTING__ABS_REF:
				setAbsRef((String)newValue);
				return;
			case ConfmlPackage.SETTING__NAME:
				setName((String)newValue);
				return;
			case ConfmlPackage.SETTING__PROPERTY:
				getProperty().clear();
				getProperty().addAll((Collection<? extends Property>)newValue);
				return;
			case ConfmlPackage.SETTING__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case ConfmlPackage.SETTING__LEAF_GROUP:
				getLeafGroup().clear();
				getLeafGroup().addAll((Collection<? extends LeafGroup>)newValue);
				return;
			case ConfmlPackage.SETTING__TYPE:
				setType((TYPE)newValue);
				return;
			case ConfmlPackage.SETTING__RFS_VALUE:
				setRfsValue(((Boolean)newValue).booleanValue());
				return;
			case ConfmlPackage.SETTING__FEATURE_NAME:
				setFeatureName((String)newValue);
				return;
			case ConfmlPackage.SETTING__NOTE:
				setNote((String)newValue);
				return;
			case ConfmlPackage.SETTING__RELEVANT:
				setRelevant((String)newValue);
				return;
			case ConfmlPackage.SETTING__REQUIRED:
				setRequired(((Boolean)newValue).booleanValue());
				return;
			case ConfmlPackage.SETTING__CONSTRAINT:
				setConstraint((String)newValue);
				return;
			case ConfmlPackage.SETTING__COMPUTED_RELEVANT:
				setComputedRelevant(((Boolean)newValue).booleanValue());
				return;
			case ConfmlPackage.SETTING__COMPUTED_CONSTRAINT:
				setComputedConstraint(((Boolean)newValue).booleanValue());
				return;
			case ConfmlPackage.SETTING__READ_ONLY:
				setReadOnly(((Boolean)newValue).booleanValue());
				return;
			case ConfmlPackage.SETTING__VALUE_NULL:
				setValueNull(((Boolean)newValue).booleanValue());
				return;
			case ConfmlPackage.SETTING__NAME_OVERRIDE:
				setNameOverride((String)newValue);
				return;
			case ConfmlPackage.SETTING__DESCRIPTION_OVERRIDE:
				setDescriptionOverride((String)newValue);
				return;
			case ConfmlPackage.SETTING__DEPENDENCIES:
				setDependencies((EList<Object>)newValue);
				return;
			case ConfmlPackage.SETTING__OPTION:
				getOption().clear();
				getOption().addAll((Collection<? extends Option>)newValue);
				return;
			case ConfmlPackage.SETTING__PARENT_GROUP:
				getParentGroup().clear();
				getParentGroup().addAll((Collection<? extends ParentGroup>)newValue);
				return;
			case ConfmlPackage.SETTING__OPTION_DEPENDENCIES:
				setOptionDependencies((EList<Setting>)newValue);
				return;
			case ConfmlPackage.SETTING__RELEVANT_AST:
				setRelevantAST(newValue);
				return;
			case ConfmlPackage.SETTING__CONSTRAINT_AST:
				setConstraintAST(newValue);
				return;
			case ConfmlPackage.SETTING__GROUP_OPTION_MAP:
				setGroupOptionMap((Map<Group, EList<Option>>)newValue);
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
			case ConfmlPackage.SETTING__ABS_REF:
				setAbsRef(ABS_REF_EDEFAULT);
				return;
			case ConfmlPackage.SETTING__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ConfmlPackage.SETTING__PROPERTY:
				getProperty().clear();
				return;
			case ConfmlPackage.SETTING__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case ConfmlPackage.SETTING__LEAF_GROUP:
				getLeafGroup().clear();
				return;
			case ConfmlPackage.SETTING__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case ConfmlPackage.SETTING__RFS_VALUE:
				setRfsValue(RFS_VALUE_EDEFAULT);
				return;
			case ConfmlPackage.SETTING__FEATURE_NAME:
				setFeatureName(FEATURE_NAME_EDEFAULT);
				return;
			case ConfmlPackage.SETTING__NOTE:
				setNote(NOTE_EDEFAULT);
				return;
			case ConfmlPackage.SETTING__RELEVANT:
				setRelevant(RELEVANT_EDEFAULT);
				return;
			case ConfmlPackage.SETTING__REQUIRED:
				setRequired(REQUIRED_EDEFAULT);
				return;
			case ConfmlPackage.SETTING__CONSTRAINT:
				setConstraint(CONSTRAINT_EDEFAULT);
				return;
			case ConfmlPackage.SETTING__COMPUTED_RELEVANT:
				setComputedRelevant(COMPUTED_RELEVANT_EDEFAULT);
				return;
			case ConfmlPackage.SETTING__COMPUTED_CONSTRAINT:
				setComputedConstraint(COMPUTED_CONSTRAINT_EDEFAULT);
				return;
			case ConfmlPackage.SETTING__READ_ONLY:
				setReadOnly(READ_ONLY_EDEFAULT);
				return;
			case ConfmlPackage.SETTING__VALUE_NULL:
				setValueNull(VALUE_NULL_EDEFAULT);
				return;
			case ConfmlPackage.SETTING__NAME_OVERRIDE:
				setNameOverride(NAME_OVERRIDE_EDEFAULT);
				return;
			case ConfmlPackage.SETTING__DESCRIPTION_OVERRIDE:
				setDescriptionOverride(DESCRIPTION_OVERRIDE_EDEFAULT);
				return;
			case ConfmlPackage.SETTING__DEPENDENCIES:
				setDependencies((EList<Object>)null);
				return;
			case ConfmlPackage.SETTING__OPTION:
				getOption().clear();
				return;
			case ConfmlPackage.SETTING__PARENT_GROUP:
				getParentGroup().clear();
				return;
			case ConfmlPackage.SETTING__OPTION_DEPENDENCIES:
				setOptionDependencies((EList<Setting>)null);
				return;
			case ConfmlPackage.SETTING__RELEVANT_AST:
				setRelevantAST(RELEVANT_AST_EDEFAULT);
				return;
			case ConfmlPackage.SETTING__CONSTRAINT_AST:
				setConstraintAST(CONSTRAINT_AST_EDEFAULT);
				return;
			case ConfmlPackage.SETTING__GROUP_OPTION_MAP:
				setGroupOptionMap((Map<Group, EList<Option>>)null);
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
			case ConfmlPackage.SETTING__ABS_REF:
				return ABS_REF_EDEFAULT == null ? absRef != null : !ABS_REF_EDEFAULT.equals(absRef);
			case ConfmlPackage.SETTING__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ConfmlPackage.SETTING__PROPERTY:
				return property != null && !property.isEmpty();
			case ConfmlPackage.SETTING__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case ConfmlPackage.SETTING__LEAF_GROUP:
				return leafGroup != null && !leafGroup.isEmpty();
			case ConfmlPackage.SETTING__TYPE:
				return type != TYPE_EDEFAULT;
			case ConfmlPackage.SETTING__RFS_VALUE:
				return rfsValue != RFS_VALUE_EDEFAULT;
			case ConfmlPackage.SETTING__FEATURE_NAME:
				return FEATURE_NAME_EDEFAULT == null ? featureName != null : !FEATURE_NAME_EDEFAULT.equals(featureName);
			case ConfmlPackage.SETTING__NOTE:
				return NOTE_EDEFAULT == null ? note != null : !NOTE_EDEFAULT.equals(note);
			case ConfmlPackage.SETTING__RELEVANT:
				return RELEVANT_EDEFAULT == null ? relevant != null : !RELEVANT_EDEFAULT.equals(relevant);
			case ConfmlPackage.SETTING__REQUIRED:
				return required != REQUIRED_EDEFAULT;
			case ConfmlPackage.SETTING__CONSTRAINT:
				return CONSTRAINT_EDEFAULT == null ? constraint != null : !CONSTRAINT_EDEFAULT.equals(constraint);
			case ConfmlPackage.SETTING__COMPUTED_RELEVANT:
				return computedRelevant != COMPUTED_RELEVANT_EDEFAULT;
			case ConfmlPackage.SETTING__COMPUTED_CONSTRAINT:
				return computedConstraint != COMPUTED_CONSTRAINT_EDEFAULT;
			case ConfmlPackage.SETTING__READ_ONLY:
				return readOnly != READ_ONLY_EDEFAULT;
			case ConfmlPackage.SETTING__VALUE_NULL:
				return valueNull != VALUE_NULL_EDEFAULT;
			case ConfmlPackage.SETTING__NAME_OVERRIDE:
				return NAME_OVERRIDE_EDEFAULT == null ? nameOverride != null : !NAME_OVERRIDE_EDEFAULT.equals(nameOverride);
			case ConfmlPackage.SETTING__DESCRIPTION_OVERRIDE:
				return DESCRIPTION_OVERRIDE_EDEFAULT == null ? descriptionOverride != null : !DESCRIPTION_OVERRIDE_EDEFAULT.equals(descriptionOverride);
			case ConfmlPackage.SETTING__DEPENDENCIES:
				return dependencies != null;
			case ConfmlPackage.SETTING__OPTION:
				return option != null && !option.isEmpty();
			case ConfmlPackage.SETTING__PARENT_GROUP:
				return parentGroup != null && !parentGroup.isEmpty();
			case ConfmlPackage.SETTING__OPTION_DEPENDENCIES:
				return optionDependencies != null;
			case ConfmlPackage.SETTING__RELEVANT_AST:
				return RELEVANT_AST_EDEFAULT == null ? relevantAST != null : !RELEVANT_AST_EDEFAULT.equals(relevantAST);
			case ConfmlPackage.SETTING__CONSTRAINT_AST:
				return CONSTRAINT_AST_EDEFAULT == null ? constraintAST != null : !CONSTRAINT_AST_EDEFAULT.equals(constraintAST);
			case ConfmlPackage.SETTING__GROUP_OPTION_MAP:
				return groupOptionMap != null;
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
		result.append(" (absRef: ");
		result.append(absRef);
		result.append(", name: ");
		result.append(name);
		result.append(", description: ");
		result.append(description);
		result.append(", type: ");
		result.append(type);
		result.append(", rfsValue: ");
		result.append(rfsValue);
		result.append(", featureName: ");
		result.append(featureName);
		result.append(", note: ");
		result.append(note);
		result.append(", relevant: ");
		result.append(relevant);
		result.append(", required: ");
		result.append(required);
		result.append(", constraint: ");
		result.append(constraint);
		result.append(", computedRelevant: ");
		result.append(computedRelevant);
		result.append(", computedConstraint: ");
		result.append(computedConstraint);
		result.append(", readOnly: ");
		result.append(readOnly);
		result.append(", valueNull: ");
		result.append(valueNull);
		result.append(", nameOverride: ");
		result.append(nameOverride);
		result.append(", descriptionOverride: ");
		result.append(descriptionOverride);
		result.append(", dependencies: ");
		result.append(dependencies);
		result.append(", optionDependencies: ");
		result.append(optionDependencies);
		result.append(", relevantAST: ");
		result.append(relevantAST);
		result.append(", constraintAST: ");
		result.append(constraintAST);
		result.append(", groupOptionMap: ");
		result.append(groupOptionMap);
		result.append(')');
		return result.toString();
	}

} //SettingImpl
