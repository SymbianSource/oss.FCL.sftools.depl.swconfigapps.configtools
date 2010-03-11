/*
* Copyright (c) 2007 Nokia Corporation and/or its subsidiary(-ies). 
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
package com.nokia.tools.s60ct.model.confml.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.nokia.tools.s60ct.model.confml.ConfmlPackage;
import com.nokia.tools.s60ct.model.confml.EFeature;
import com.nokia.tools.s60ct.model.confml.EIconContainer;
import com.nokia.tools.s60ct.model.confml.ELinkContainer;
import com.nokia.tools.s60ct.model.confml.EProperty;
import com.nokia.tools.s60ct.model.confml.ESequenceSetting;
import com.nokia.tools.s60ct.model.confml.ESetting;
import com.nokia.tools.s60ct.model.confml.ESettingValue;
import com.nokia.tools.s60ct.model.confml.View;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ESetting</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.ESettingImpl#getDescriptionText <em>Description Text</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.ESettingImpl#getDescriptionUri <em>Description Uri</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.ESettingImpl#getDescriptionUriText <em>Description Uri Text</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.ESettingImpl#getIconUriTitle <em>Icon Uri Title</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.ESettingImpl#getIconUri <em>Icon Uri</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.ESettingImpl#getLinkUri <em>Link Uri</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.ESettingImpl#getLinkUriTitle <em>Link Uri Title</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.ESettingImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.ESettingImpl#getRef <em>Ref</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.ESettingImpl#getRfs <em>Rfs</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.ESettingImpl#getValue <em>Value</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.ESettingImpl#getDefaultValue <em>Default Value</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.ESettingImpl#getDefaultRfs <em>Default Rfs</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.ESettingImpl#isReadOnly <em>Read Only</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.ESettingImpl#getConstraint <em>Constraint</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.ESettingImpl#getRelevant <em>Relevant</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.ESettingImpl#isRequired <em>Required</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.ESettingImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.ESettingImpl#isDeprecated <em>Deprecated</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.ESettingImpl#isModified <em>Modified</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.ESettingImpl#isSetdefault <em>Setdefault</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.ESettingImpl#isComputedRelevant <em>Computed Relevant</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.ESettingImpl#isComputedConstraint <em>Computed Constraint</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.ESettingImpl#getRelevantAST <em>Relevant AST</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.ESettingImpl#getConstraintAST <em>Constraint AST</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.ESettingImpl#getDependencies <em>Dependencies</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.ESettingImpl#getOptionDependencies <em>Option Dependencies</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.ESettingImpl#isValueNull <em>Value Null</em>}</li>
 *   <li>{@link com.nokia.tools.s60ct.model.confml.impl.ESettingImpl#getNotes <em>Notes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ESettingImpl extends EObjectImpl implements ESetting {
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
	 * The default value of the '{@link #getIconUriTitle() <em>Icon Uri Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIconUriTitle()
	 * @generated
	 * @ordered
	 */
	protected static final String ICON_URI_TITLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIconUriTitle() <em>Icon Uri Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIconUriTitle()
	 * @generated
	 * @ordered
	 */
	protected String iconUriTitle = ICON_URI_TITLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getIconUri() <em>Icon Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIconUri()
	 * @generated
	 * @ordered
	 */
	protected static final String ICON_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIconUri() <em>Icon Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIconUri()
	 * @generated
	 * @ordered
	 */
	protected String iconUri = ICON_URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getLinkUri() <em>Link Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinkUri()
	 * @generated
	 * @ordered
	 */
	protected static final String LINK_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLinkUri() <em>Link Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinkUri()
	 * @generated
	 * @ordered
	 */
	protected String linkUri = LINK_URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getLinkUriTitle() <em>Link Uri Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinkUriTitle()
	 * @generated
	 * @ordered
	 */
	protected static final String LINK_URI_TITLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLinkUriTitle() <em>Link Uri Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinkUriTitle()
	 * @generated
	 * @ordered
	 */
	protected String linkUriTitle = LINK_URI_TITLE_EDEFAULT;

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
	 * The default value of the '{@link #getRef() <em>Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRef()
	 * @generated
	 * @ordered
	 */
	protected static final String REF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRef() <em>Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRef()
	 * @generated
	 * @ordered
	 */
	protected String ref = REF_EDEFAULT;

	/**
	 * The default value of the '{@link #getRfs() <em>Rfs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRfs()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean RFS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRfs() <em>Rfs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRfs()
	 * @generated
	 * @ordered
	 */
	protected Boolean rfs = RFS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected ESettingValue value;

	/**
	 * The cached value of the '{@link #getDefaultValue() <em>Default Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultValue()
	 * @generated
	 * @ordered
	 */
	protected ESettingValue defaultValue;

	/**
	 * The default value of the '{@link #getDefaultRfs() <em>Default Rfs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultRfs()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean DEFAULT_RFS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefaultRfs() <em>Default Rfs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultRfs()
	 * @generated
	 * @ordered
	 */
	protected Boolean defaultRfs = DEFAULT_RFS_EDEFAULT;

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
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<EProperty> properties;

	/**
	 * The default value of the '{@link #isDeprecated() <em>Deprecated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDeprecated()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DEPRECATED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDeprecated() <em>Deprecated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDeprecated()
	 * @generated
	 * @ordered
	 */
	protected boolean deprecated = DEPRECATED_EDEFAULT;

	/**
	 * The default value of the '{@link #isModified() <em>Modified</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isModified()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MODIFIED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isModified() <em>Modified</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isModified()
	 * @generated
	 * @ordered
	 */
	protected boolean modified = MODIFIED_EDEFAULT;

	/**
	 * The default value of the '{@link #isSetdefault() <em>Setdefault</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetdefault()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SETDEFAULT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSetdefault() <em>Setdefault</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetdefault()
	 * @generated
	 * @ordered
	 */
	protected boolean setdefault = SETDEFAULT_EDEFAULT;

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
	 * The cached value of the '{@link #getDependencies() <em>Dependencies</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependencies()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> dependencies;

	/**
	 * The cached value of the '{@link #getOptionDependencies() <em>Option Dependencies</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOptionDependencies()
	 * @generated
	 * @ordered
	 */
	protected EList<ESetting> optionDependencies;

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
	 * The default value of the '{@link #getNotes() <em>Notes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNotes()
	 * @generated
	 * @ordered
	 */
	protected static final String NOTES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNotes() <em>Notes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNotes()
	 * @generated
	 * @ordered
	 */
	protected String notes = NOTES_EDEFAULT;

	private boolean notesChanged = false;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ESettingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfmlPackage.Literals.ESETTING;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.ESETTING__DESCRIPTION_TEXT, oldDescriptionText, descriptionText));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.ESETTING__DESCRIPTION_URI, oldDescriptionUri, descriptionUri));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.ESETTING__DESCRIPTION_URI_TEXT, oldDescriptionUriText, descriptionUriText));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIconUriTitle() {
		return iconUriTitle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIconUriTitle(String newIconUriTitle) {
		String oldIconUriTitle = iconUriTitle;
		iconUriTitle = newIconUriTitle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.ESETTING__ICON_URI_TITLE, oldIconUriTitle, iconUriTitle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIconUri() {
		return iconUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIconUri(String newIconUri) {
		String oldIconUri = iconUri;
		iconUri = newIconUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.ESETTING__ICON_URI, oldIconUri, iconUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLinkUri() {
		return linkUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinkUri(String newLinkUri) {
		String oldLinkUri = linkUri;
		linkUri = newLinkUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.ESETTING__LINK_URI, oldLinkUri, linkUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLinkUriTitle() {
		return linkUriTitle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinkUriTitle(String newLinkUriTitle) {
		String oldLinkUriTitle = linkUriTitle;
		linkUriTitle = newLinkUriTitle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.ESETTING__LINK_URI_TITLE, oldLinkUriTitle, linkUriTitle));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.ESETTING__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRef() {
		return ref;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRef(String newRef) {
		String oldRef = ref;
		ref = newRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.ESETTING__REF, oldRef, ref));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getRfs() {
		return rfs;
	}

	public String getAbsRef() //doesn't return the third part of sequence setting ref, but so far this is not needed
	{
		if(this.eContainer() instanceof EFeature)
		{
			return ((EFeature)this.eContainer()).getRef()+"/"+this.getRef();			
		}
		else
		{
			return ((ESetting)this.eContainer()).getAbsRef();
		}
	}
	
	public String getFeatureRef()
	{
		if(this.eContainer() instanceof EFeature)
		{
			return ((EFeature)this.eContainer()).getRef();			
		}
		else
		{
			return ((ESetting)this.eContainer()).getFeatureRef();
		}
	}
	
	
	private EFeature getFeature()
	{
		EObject obj = this;
		do
		{
			if (obj.eContainer()==null)
				return null;
			obj = obj.eContainer();
			if(obj instanceof EFeature)
			{
				return (EFeature)obj;
			}
		}
		while (true);
	}
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRfs(Boolean newRfs) {
		Boolean oldRfs = rfs;
		rfs = newRfs;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.ESETTING__RFS, oldRfs, rfs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ESettingValue getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetValue(ESettingValue newValue, NotificationChain msgs) {
		ESettingValue oldValue = value;
		value = newValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfmlPackage.ESETTING__VALUE, oldValue, newValue);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(ESettingValue newValue) {
		if (newValue != value) {
			NotificationChain msgs = null;
			if (value != null)
				msgs = ((InternalEObject)value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfmlPackage.ESETTING__VALUE, null, msgs);
			if (newValue != null)
				msgs = ((InternalEObject)newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfmlPackage.ESETTING__VALUE, null, msgs);
			msgs = basicSetValue(newValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.ESETTING__VALUE, newValue, newValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ESettingValue getDefaultValue() {
		return defaultValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDefaultValue(ESettingValue newDefaultValue, NotificationChain msgs) {
		ESettingValue oldDefaultValue = defaultValue;
		defaultValue = newDefaultValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfmlPackage.ESETTING__DEFAULT_VALUE, oldDefaultValue, newDefaultValue);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultValue(ESettingValue newDefaultValue) {
		if (newDefaultValue != defaultValue) {
			NotificationChain msgs = null;
			if (defaultValue != null)
				msgs = ((InternalEObject)defaultValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfmlPackage.ESETTING__DEFAULT_VALUE, null, msgs);
			if (newDefaultValue != null)
				msgs = ((InternalEObject)newDefaultValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfmlPackage.ESETTING__DEFAULT_VALUE, null, msgs);
			msgs = basicSetDefaultValue(newDefaultValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.ESETTING__DEFAULT_VALUE, newDefaultValue, newDefaultValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getDefaultRfs() {
		return defaultRfs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultRfs(Boolean newDefaultRfs) {
		Boolean oldDefaultRfs = defaultRfs;
		defaultRfs = newDefaultRfs;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.ESETTING__DEFAULT_RFS, oldDefaultRfs, defaultRfs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isReadOnly() {
		
		EFeature f = getFeature();
		if (f != null && !f.isComputedRelevant())
		{
			return true;
		}
		if (!isComputedRelevant())
		{
			return true;
		}
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.ESETTING__READ_ONLY, oldReadOnly, readOnly));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.ESETTING__CONSTRAINT, oldConstraint, constraint));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.ESETTING__RELEVANT, oldRelevant, relevant));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.ESETTING__REQUIRED, oldRequired, required));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EProperty> getProperties() {
		if (properties == null) {
			properties = new EObjectContainmentEList<EProperty>(EProperty.class, this, ConfmlPackage.ESETTING__PROPERTIES);
		}
		return properties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDeprecated() {
		return deprecated;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeprecated(boolean newDeprecated) {
		boolean oldDeprecated = deprecated;
		deprecated = newDeprecated;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.ESETTING__DEPRECATED, oldDeprecated, deprecated));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isModified() {
		return modified;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModified(boolean newModified) {
		boolean oldModified = modified;
		modified = newModified;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.ESETTING__MODIFIED, oldModified, modified));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetdefault() {
		return setdefault;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSetdefault(boolean newSetdefault) {
		boolean oldSetdefault = setdefault;
		setdefault = newSetdefault;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.ESETTING__SETDEFAULT, oldSetdefault, setdefault));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.ESETTING__COMPUTED_RELEVANT, oldComputedRelevant, computedRelevant));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.ESETTING__COMPUTED_CONSTRAINT, oldComputedConstraint, computedConstraint));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.ESETTING__RELEVANT_AST, oldRelevantAST, relevantAST));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.ESETTING__CONSTRAINT_AST, oldConstraintAST, constraintAST));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getDependencies() {
		return dependencies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDependencies(EList<EObject> newDependencies) {
		EList<EObject> oldDependencies = dependencies;
		dependencies = newDependencies;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.ESETTING__DEPENDENCIES, oldDependencies, dependencies));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ESetting> getOptionDependencies() {
		return optionDependencies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOptionDependencies(EList<ESetting> newOptionDependencies) {
		EList<ESetting> oldOptionDependencies = optionDependencies;
		optionDependencies = newOptionDependencies;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.ESETTING__OPTION_DEPENDENCIES, oldOptionDependencies, optionDependencies));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @NOT generated
	 */
	public boolean isValueNull() {
		if (getValue()==null)
			return true;
		return false;
		
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.ESETTING__VALUE_NULL, oldValueNull, valueNull));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNotes() {
		return notes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @NOT generated
	 */
	public void setNotes(String newNotes) {
		String oldNotes = notes;
		notesChanged = true;
		notes = newNotes;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfmlPackage.ESETTING__NOTES, oldNotes, notes));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @NOT generated
	 */
	public boolean isDirty() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void clearDirty() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDefault() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @NOT generated
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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConfmlPackage.ESETTING__VALUE:
				return basicSetValue(null, msgs);
			case ConfmlPackage.ESETTING__DEFAULT_VALUE:
				return basicSetDefaultValue(null, msgs);
			case ConfmlPackage.ESETTING__PROPERTIES:
				return ((InternalEList<?>)getProperties()).basicRemove(otherEnd, msgs);
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
			case ConfmlPackage.ESETTING__DESCRIPTION_TEXT:
				return getDescriptionText();
			case ConfmlPackage.ESETTING__DESCRIPTION_URI:
				return getDescriptionUri();
			case ConfmlPackage.ESETTING__DESCRIPTION_URI_TEXT:
				return getDescriptionUriText();
			case ConfmlPackage.ESETTING__ICON_URI_TITLE:
				return getIconUriTitle();
			case ConfmlPackage.ESETTING__ICON_URI:
				return getIconUri();
			case ConfmlPackage.ESETTING__LINK_URI:
				return getLinkUri();
			case ConfmlPackage.ESETTING__LINK_URI_TITLE:
				return getLinkUriTitle();
			case ConfmlPackage.ESETTING__NAME:
				return getName();
			case ConfmlPackage.ESETTING__REF:
				return getRef();
			case ConfmlPackage.ESETTING__RFS:
				return getRfs();
			case ConfmlPackage.ESETTING__VALUE:
				return getValue();
			case ConfmlPackage.ESETTING__DEFAULT_VALUE:
				return getDefaultValue();
			case ConfmlPackage.ESETTING__DEFAULT_RFS:
				return getDefaultRfs();
			case ConfmlPackage.ESETTING__READ_ONLY:
				return isReadOnly() ? Boolean.TRUE : Boolean.FALSE;
			case ConfmlPackage.ESETTING__CONSTRAINT:
				return getConstraint();
			case ConfmlPackage.ESETTING__RELEVANT:
				return getRelevant();
			case ConfmlPackage.ESETTING__REQUIRED:
				return isRequired() ? Boolean.TRUE : Boolean.FALSE;
			case ConfmlPackage.ESETTING__PROPERTIES:
				return getProperties();
			case ConfmlPackage.ESETTING__DEPRECATED:
				return isDeprecated() ? Boolean.TRUE : Boolean.FALSE;
			case ConfmlPackage.ESETTING__MODIFIED:
				return isModified() ? Boolean.TRUE : Boolean.FALSE;
			case ConfmlPackage.ESETTING__SETDEFAULT:
				return isSetdefault() ? Boolean.TRUE : Boolean.FALSE;
			case ConfmlPackage.ESETTING__COMPUTED_RELEVANT:
				return isComputedRelevant() ? Boolean.TRUE : Boolean.FALSE;
			case ConfmlPackage.ESETTING__COMPUTED_CONSTRAINT:
				return isComputedConstraint() ? Boolean.TRUE : Boolean.FALSE;
			case ConfmlPackage.ESETTING__RELEVANT_AST:
				return getRelevantAST();
			case ConfmlPackage.ESETTING__CONSTRAINT_AST:
				return getConstraintAST();
			case ConfmlPackage.ESETTING__DEPENDENCIES:
				return getDependencies();
			case ConfmlPackage.ESETTING__OPTION_DEPENDENCIES:
				return getOptionDependencies();
			case ConfmlPackage.ESETTING__VALUE_NULL:
				return isValueNull() ? Boolean.TRUE : Boolean.FALSE;
			case ConfmlPackage.ESETTING__NOTES:
				return getNotes();
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
			case ConfmlPackage.ESETTING__DESCRIPTION_TEXT:
				setDescriptionText((String)newValue);
				return;
			case ConfmlPackage.ESETTING__DESCRIPTION_URI:
				setDescriptionUri((String)newValue);
				return;
			case ConfmlPackage.ESETTING__DESCRIPTION_URI_TEXT:
				setDescriptionUriText((String)newValue);
				return;
			case ConfmlPackage.ESETTING__ICON_URI_TITLE:
				setIconUriTitle((String)newValue);
				return;
			case ConfmlPackage.ESETTING__ICON_URI:
				setIconUri((String)newValue);
				return;
			case ConfmlPackage.ESETTING__LINK_URI:
				setLinkUri((String)newValue);
				return;
			case ConfmlPackage.ESETTING__LINK_URI_TITLE:
				setLinkUriTitle((String)newValue);
				return;
			case ConfmlPackage.ESETTING__NAME:
				setName((String)newValue);
				return;
			case ConfmlPackage.ESETTING__REF:
				setRef((String)newValue);
				return;
			case ConfmlPackage.ESETTING__RFS:
				setRfs((Boolean)newValue);
				return;
			case ConfmlPackage.ESETTING__VALUE:
				setValue((ESettingValue)newValue);
				return;
			case ConfmlPackage.ESETTING__DEFAULT_VALUE:
				setDefaultValue((ESettingValue)newValue);
				return;
			case ConfmlPackage.ESETTING__DEFAULT_RFS:
				setDefaultRfs((Boolean)newValue);
				return;
			case ConfmlPackage.ESETTING__READ_ONLY:
				setReadOnly(((Boolean)newValue).booleanValue());
				return;
			case ConfmlPackage.ESETTING__CONSTRAINT:
				setConstraint((String)newValue);
				return;
			case ConfmlPackage.ESETTING__RELEVANT:
				setRelevant((String)newValue);
				return;
			case ConfmlPackage.ESETTING__REQUIRED:
				setRequired(((Boolean)newValue).booleanValue());
				return;
			case ConfmlPackage.ESETTING__PROPERTIES:
				getProperties().clear();
				getProperties().addAll((Collection<? extends EProperty>)newValue);
				return;
			case ConfmlPackage.ESETTING__DEPRECATED:
				setDeprecated(((Boolean)newValue).booleanValue());
				return;
			case ConfmlPackage.ESETTING__MODIFIED:
				setModified(((Boolean)newValue).booleanValue());
				return;
			case ConfmlPackage.ESETTING__SETDEFAULT:
				setSetdefault(((Boolean)newValue).booleanValue());
				return;
			case ConfmlPackage.ESETTING__COMPUTED_RELEVANT:
				setComputedRelevant(((Boolean)newValue).booleanValue());
				return;
			case ConfmlPackage.ESETTING__COMPUTED_CONSTRAINT:
				setComputedConstraint(((Boolean)newValue).booleanValue());
				return;
			case ConfmlPackage.ESETTING__RELEVANT_AST:
				setRelevantAST(newValue);
				return;
			case ConfmlPackage.ESETTING__CONSTRAINT_AST:
				setConstraintAST(newValue);
				return;
			case ConfmlPackage.ESETTING__DEPENDENCIES:
				setDependencies((EList<EObject>)newValue);
				return;
			case ConfmlPackage.ESETTING__OPTION_DEPENDENCIES:
				setOptionDependencies((EList<ESetting>)newValue);
				return;
			case ConfmlPackage.ESETTING__VALUE_NULL:
				setValueNull(((Boolean)newValue).booleanValue());
				return;
			case ConfmlPackage.ESETTING__NOTES:
				setNotes((String)newValue);
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
			case ConfmlPackage.ESETTING__DESCRIPTION_TEXT:
				setDescriptionText(DESCRIPTION_TEXT_EDEFAULT);
				return;
			case ConfmlPackage.ESETTING__DESCRIPTION_URI:
				setDescriptionUri(DESCRIPTION_URI_EDEFAULT);
				return;
			case ConfmlPackage.ESETTING__DESCRIPTION_URI_TEXT:
				setDescriptionUriText(DESCRIPTION_URI_TEXT_EDEFAULT);
				return;
			case ConfmlPackage.ESETTING__ICON_URI_TITLE:
				setIconUriTitle(ICON_URI_TITLE_EDEFAULT);
				return;
			case ConfmlPackage.ESETTING__ICON_URI:
				setIconUri(ICON_URI_EDEFAULT);
				return;
			case ConfmlPackage.ESETTING__LINK_URI:
				setLinkUri(LINK_URI_EDEFAULT);
				return;
			case ConfmlPackage.ESETTING__LINK_URI_TITLE:
				setLinkUriTitle(LINK_URI_TITLE_EDEFAULT);
				return;
			case ConfmlPackage.ESETTING__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ConfmlPackage.ESETTING__REF:
				setRef(REF_EDEFAULT);
				return;
			case ConfmlPackage.ESETTING__RFS:
				setRfs(RFS_EDEFAULT);
				return;
			case ConfmlPackage.ESETTING__VALUE:
				setValue((ESettingValue)null);
				return;
			case ConfmlPackage.ESETTING__DEFAULT_VALUE:
				setDefaultValue((ESettingValue)null);
				return;
			case ConfmlPackage.ESETTING__DEFAULT_RFS:
				setDefaultRfs(DEFAULT_RFS_EDEFAULT);
				return;
			case ConfmlPackage.ESETTING__READ_ONLY:
				setReadOnly(READ_ONLY_EDEFAULT);
				return;
			case ConfmlPackage.ESETTING__CONSTRAINT:
				setConstraint(CONSTRAINT_EDEFAULT);
				return;
			case ConfmlPackage.ESETTING__RELEVANT:
				setRelevant(RELEVANT_EDEFAULT);
				return;
			case ConfmlPackage.ESETTING__REQUIRED:
				setRequired(REQUIRED_EDEFAULT);
				return;
			case ConfmlPackage.ESETTING__PROPERTIES:
				getProperties().clear();
				return;
			case ConfmlPackage.ESETTING__DEPRECATED:
				setDeprecated(DEPRECATED_EDEFAULT);
				return;
			case ConfmlPackage.ESETTING__MODIFIED:
				setModified(MODIFIED_EDEFAULT);
				return;
			case ConfmlPackage.ESETTING__SETDEFAULT:
				setSetdefault(SETDEFAULT_EDEFAULT);
				return;
			case ConfmlPackage.ESETTING__COMPUTED_RELEVANT:
				setComputedRelevant(COMPUTED_RELEVANT_EDEFAULT);
				return;
			case ConfmlPackage.ESETTING__COMPUTED_CONSTRAINT:
				setComputedConstraint(COMPUTED_CONSTRAINT_EDEFAULT);
				return;
			case ConfmlPackage.ESETTING__RELEVANT_AST:
				setRelevantAST(RELEVANT_AST_EDEFAULT);
				return;
			case ConfmlPackage.ESETTING__CONSTRAINT_AST:
				setConstraintAST(CONSTRAINT_AST_EDEFAULT);
				return;
			case ConfmlPackage.ESETTING__DEPENDENCIES:
				setDependencies((EList<EObject>)null);
				return;
			case ConfmlPackage.ESETTING__OPTION_DEPENDENCIES:
				setOptionDependencies((EList<ESetting>)null);
				return;
			case ConfmlPackage.ESETTING__VALUE_NULL:
				setValueNull(VALUE_NULL_EDEFAULT);
				return;
			case ConfmlPackage.ESETTING__NOTES:
				setNotes(NOTES_EDEFAULT);
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
			case ConfmlPackage.ESETTING__DESCRIPTION_TEXT:
				return DESCRIPTION_TEXT_EDEFAULT == null ? descriptionText != null : !DESCRIPTION_TEXT_EDEFAULT.equals(descriptionText);
			case ConfmlPackage.ESETTING__DESCRIPTION_URI:
				return DESCRIPTION_URI_EDEFAULT == null ? descriptionUri != null : !DESCRIPTION_URI_EDEFAULT.equals(descriptionUri);
			case ConfmlPackage.ESETTING__DESCRIPTION_URI_TEXT:
				return DESCRIPTION_URI_TEXT_EDEFAULT == null ? descriptionUriText != null : !DESCRIPTION_URI_TEXT_EDEFAULT.equals(descriptionUriText);
			case ConfmlPackage.ESETTING__ICON_URI_TITLE:
				return ICON_URI_TITLE_EDEFAULT == null ? iconUriTitle != null : !ICON_URI_TITLE_EDEFAULT.equals(iconUriTitle);
			case ConfmlPackage.ESETTING__ICON_URI:
				return ICON_URI_EDEFAULT == null ? iconUri != null : !ICON_URI_EDEFAULT.equals(iconUri);
			case ConfmlPackage.ESETTING__LINK_URI:
				return LINK_URI_EDEFAULT == null ? linkUri != null : !LINK_URI_EDEFAULT.equals(linkUri);
			case ConfmlPackage.ESETTING__LINK_URI_TITLE:
				return LINK_URI_TITLE_EDEFAULT == null ? linkUriTitle != null : !LINK_URI_TITLE_EDEFAULT.equals(linkUriTitle);
			case ConfmlPackage.ESETTING__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ConfmlPackage.ESETTING__REF:
				return REF_EDEFAULT == null ? ref != null : !REF_EDEFAULT.equals(ref);
			case ConfmlPackage.ESETTING__RFS:
				return RFS_EDEFAULT == null ? rfs != null : !RFS_EDEFAULT.equals(rfs);
			case ConfmlPackage.ESETTING__VALUE:
				return value != null;
			case ConfmlPackage.ESETTING__DEFAULT_VALUE:
				return defaultValue != null;
			case ConfmlPackage.ESETTING__DEFAULT_RFS:
				return DEFAULT_RFS_EDEFAULT == null ? defaultRfs != null : !DEFAULT_RFS_EDEFAULT.equals(defaultRfs);
			case ConfmlPackage.ESETTING__READ_ONLY:
				return readOnly != READ_ONLY_EDEFAULT;
			case ConfmlPackage.ESETTING__CONSTRAINT:
				return CONSTRAINT_EDEFAULT == null ? constraint != null : !CONSTRAINT_EDEFAULT.equals(constraint);
			case ConfmlPackage.ESETTING__RELEVANT:
				return RELEVANT_EDEFAULT == null ? relevant != null : !RELEVANT_EDEFAULT.equals(relevant);
			case ConfmlPackage.ESETTING__REQUIRED:
				return required != REQUIRED_EDEFAULT;
			case ConfmlPackage.ESETTING__PROPERTIES:
				return properties != null && !properties.isEmpty();
			case ConfmlPackage.ESETTING__DEPRECATED:
				return deprecated != DEPRECATED_EDEFAULT;
			case ConfmlPackage.ESETTING__MODIFIED:
				return modified != MODIFIED_EDEFAULT;
			case ConfmlPackage.ESETTING__SETDEFAULT:
				return setdefault != SETDEFAULT_EDEFAULT;
			case ConfmlPackage.ESETTING__COMPUTED_RELEVANT:
				return computedRelevant != COMPUTED_RELEVANT_EDEFAULT;
			case ConfmlPackage.ESETTING__COMPUTED_CONSTRAINT:
				return computedConstraint != COMPUTED_CONSTRAINT_EDEFAULT;
			case ConfmlPackage.ESETTING__RELEVANT_AST:
				return RELEVANT_AST_EDEFAULT == null ? relevantAST != null : !RELEVANT_AST_EDEFAULT.equals(relevantAST);
			case ConfmlPackage.ESETTING__CONSTRAINT_AST:
				return CONSTRAINT_AST_EDEFAULT == null ? constraintAST != null : !CONSTRAINT_AST_EDEFAULT.equals(constraintAST);
			case ConfmlPackage.ESETTING__DEPENDENCIES:
				return dependencies != null;
			case ConfmlPackage.ESETTING__OPTION_DEPENDENCIES:
				return optionDependencies != null;
			case ConfmlPackage.ESETTING__VALUE_NULL:
				return valueNull != VALUE_NULL_EDEFAULT;
			case ConfmlPackage.ESETTING__NOTES:
				return NOTES_EDEFAULT == null ? notes != null : !NOTES_EDEFAULT.equals(notes);
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
		if (baseClass == EIconContainer.class) {
			switch (derivedFeatureID) {
				case ConfmlPackage.ESETTING__ICON_URI_TITLE: return ConfmlPackage.EICON_CONTAINER__ICON_URI_TITLE;
				case ConfmlPackage.ESETTING__ICON_URI: return ConfmlPackage.EICON_CONTAINER__ICON_URI;
				default: return -1;
			}
		}
		if (baseClass == ELinkContainer.class) {
			switch (derivedFeatureID) {
				case ConfmlPackage.ESETTING__LINK_URI: return ConfmlPackage.ELINK_CONTAINER__LINK_URI;
				case ConfmlPackage.ESETTING__LINK_URI_TITLE: return ConfmlPackage.ELINK_CONTAINER__LINK_URI_TITLE;
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
		if (baseClass == EIconContainer.class) {
			switch (baseFeatureID) {
				case ConfmlPackage.EICON_CONTAINER__ICON_URI_TITLE: return ConfmlPackage.ESETTING__ICON_URI_TITLE;
				case ConfmlPackage.EICON_CONTAINER__ICON_URI: return ConfmlPackage.ESETTING__ICON_URI;
				default: return -1;
			}
		}
		if (baseClass == ELinkContainer.class) {
			switch (baseFeatureID) {
				case ConfmlPackage.ELINK_CONTAINER__LINK_URI: return ConfmlPackage.ESETTING__LINK_URI;
				case ConfmlPackage.ELINK_CONTAINER__LINK_URI_TITLE: return ConfmlPackage.ESETTING__LINK_URI_TITLE;
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
		result.append(" (descriptionText: ");
		result.append(descriptionText);
		result.append(", descriptionUri: ");
		result.append(descriptionUri);
		result.append(", descriptionUriText: ");
		result.append(descriptionUriText);
		result.append(", iconUriTitle: ");
		result.append(iconUriTitle);
		result.append(", iconUri: ");
		result.append(iconUri);
		result.append(", linkUri: ");
		result.append(linkUri);
		result.append(", linkUriTitle: ");
		result.append(linkUriTitle);
		result.append(", name: ");
		result.append(name);
		result.append(", ref: ");
		result.append(ref);
		result.append(", rfs: ");
		result.append(rfs);
		result.append(", defaultRfs: ");
		result.append(defaultRfs);
		result.append(", readOnly: ");
		result.append(readOnly);
		result.append(", constraint: ");
		result.append(constraint);
		result.append(", relevant: ");
		result.append(relevant);
		result.append(", required: ");
		result.append(required);
		result.append(", deprecated: ");
		result.append(deprecated);
		result.append(", modified: ");
		result.append(modified);
		result.append(", setdefault: ");
		result.append(setdefault);
		result.append(", computedRelevant: ");
		result.append(computedRelevant);
		result.append(", computedConstraint: ");
		result.append(computedConstraint);
		result.append(", relevantAST: ");
		result.append(relevantAST);
		result.append(", constraintAST: ");
		result.append(constraintAST);
		result.append(", dependencies: ");
		result.append(dependencies);
		result.append(", optionDependencies: ");
		result.append(optionDependencies);
		result.append(", valueNull: ");
		result.append(valueNull);
		result.append(", notes: ");
		result.append(notes);
		result.append(')');
		return result.toString();
	}

} //ESettingImpl
