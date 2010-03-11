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
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import configurationemf.ConfigurationemfFactory;
import configurationemf.ConfigurationemfPackage;
import configurationemf.Frame;
import configurationemf.LeafSetting;
import configurationemf.LeafSettingDelegator;
import configurationemf.ParentSetting;
import configurationemf.Ref;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Frame</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link configurationemf.impl.FrameImpl#getLeafSettings <em>Leaf Settings</em>}</li>
 *   <li>{@link configurationemf.impl.FrameImpl#getNumber <em>Number</em>}</li>
 *   <li>{@link configurationemf.impl.FrameImpl#isTemplate <em>Template</em>}</li>
 *   <li>{@link configurationemf.impl.FrameImpl#getTemplateOwner <em>Template Owner</em>}</li>
 *   <li>{@link configurationemf.impl.FrameImpl#getRef <em>Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FrameImpl extends EObjectImpl implements Frame {
	/**
	 * The cached value of the '{@link #getLeafSettings() <em>Leaf Settings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeafSettings()
	 * @generated
	 * @ordered
	 */
	protected EList<LeafSettingDelegator> leafSettings;

	/**
	 * The default value of the '{@link #getNumber() <em>Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumber()
	 * @generated
	 * @ordered
	 */
	protected static final int NUMBER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNumber() <em>Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumber()
	 * @generated
	 * @ordered
	 */
	protected int number = NUMBER_EDEFAULT;

	/**
	 * The default value of the '{@link #isTemplate() <em>Template</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTemplate()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TEMPLATE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isTemplate() <em>Template</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTemplate()
	 * @generated
	 * @ordered
	 */
	protected boolean template = TEMPLATE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTemplateOwner() <em>Template Owner</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTemplateOwner()
	 * @generated
	 * @ordered
	 */
	protected ParentSetting templateOwner;

	/**
	 * The cached value of the '{@link #getRef() <em>Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRef()
	 * @generated
	 * @ordered
	 */
	protected Ref ref;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FrameImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigurationemfPackage.Literals.FRAME;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LeafSettingDelegator> getLeafSettings() {
		if (leafSettings == null) {
			leafSettings = new EObjectContainmentEList<LeafSettingDelegator>(LeafSettingDelegator.class, this, ConfigurationemfPackage.FRAME__LEAF_SETTINGS);
		}
		return leafSettings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getNumber() {
		if(this.eContainer()!=null)
			return ((ParentSetting)this.eContainer()).getFrames().indexOf(this)+1;
		else return -1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTemplate() {
		return template;
	}

	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTemplate(boolean newTemplate) {
		boolean oldTemplate = template;
		template = newTemplate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.FRAME__TEMPLATE, oldTemplate, template));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParentSetting getTemplateOwner() {
		return templateOwner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTemplateOwner(ParentSetting newTemplateOwner) {
		ParentSetting oldTemplateOwner = templateOwner;
		templateOwner = newTemplateOwner;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.FRAME__TEMPLATE_OWNER, oldTemplateOwner, templateOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Ref getRef() {
		return ref;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRef(Ref newRef) {
		Ref oldRef = ref;
		ref = newRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.FRAME__REF, oldRef, ref));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getConfName() {
		String result="";
		if(!getLeafSettings().isEmpty()){
			result = getRef().getConfiguration().getName();
		}
		return result;
	}
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isMyFrame() {
		if(isTemplate()){
			return !getTemplateOwner().isRo();
		}else{
			return ((ParentSetting)eContainer()).isRo();
		}
	}

	public LeafSettingDelegator addDelegator(LeafSetting leafSetting){
		LeafSettingDelegator delegator = ConfigurationemfFactory.eINSTANCE.createLeafSettingDelegator();
		delegator.setLeafSetting(leafSetting);
		this.getLeafSettings().add(delegator);
		return delegator;
	}
	public void deleteDelegator(LeafSetting leafSetting){
		
		EList<LeafSettingDelegator> delegators = this.getLeafSettings();
		
		for (LeafSettingDelegator delegator : delegators)
		{
			if (delegator.getLeafSetting().equals(leafSetting))
			{
				this.getLeafSettings().remove(delegator);
				return;
			}
		}
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void addLeafSetting(LeafSetting leafSetting) {
		if(isTemplate()){
			ParentSettingImpl owner = (ParentSettingImpl)getTemplateOwner();
		/*	if(getLeafSettings().isEmpty()){
				Ref ref = owner.createRef(owner.getCreateFeatureRef(owner.getCurrentConf()), owner.getRefs());
				ref.setTemplate(true);
			}*/
			owner.getLeafSetting().add(leafSetting);
			List<Frame> frames = owner.getFrames();
			for(Frame frame:frames){
				((FrameImpl)frame).addDelegator(leafSetting);
			}
			this.addDelegator(leafSetting);
			
			
		}
	}
	
	public void deleteLeafSetting(LeafSetting leafSetting) {
		if(isTemplate()){
			ParentSettingImpl owner = (ParentSettingImpl)getTemplateOwner();
			owner.getLeafSetting().remove(leafSetting);
			List<Frame> frames = owner.getFrames();
			for(Frame frame:frames){
				((FrameImpl)frame).deleteDelegator(leafSetting);
			}
			this.deleteDelegator(leafSetting);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConfigurationemfPackage.FRAME__LEAF_SETTINGS:
				return ((InternalEList<?>)getLeafSettings()).basicRemove(otherEnd, msgs);
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
			case ConfigurationemfPackage.FRAME__LEAF_SETTINGS:
				return getLeafSettings();
			case ConfigurationemfPackage.FRAME__NUMBER:
				return new Integer(getNumber());
			case ConfigurationemfPackage.FRAME__TEMPLATE:
				return isTemplate() ? Boolean.TRUE : Boolean.FALSE;
			case ConfigurationemfPackage.FRAME__TEMPLATE_OWNER:
				return getTemplateOwner();
			case ConfigurationemfPackage.FRAME__REF:
				return getRef();
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
			case ConfigurationemfPackage.FRAME__LEAF_SETTINGS:
				getLeafSettings().clear();
				getLeafSettings().addAll((Collection<? extends LeafSettingDelegator>)newValue);
				return;
			case ConfigurationemfPackage.FRAME__TEMPLATE:
				setTemplate(((Boolean)newValue).booleanValue());
				return;
			case ConfigurationemfPackage.FRAME__TEMPLATE_OWNER:
				setTemplateOwner((ParentSetting)newValue);
				return;
			case ConfigurationemfPackage.FRAME__REF:
				setRef((Ref)newValue);
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
			case ConfigurationemfPackage.FRAME__LEAF_SETTINGS:
				getLeafSettings().clear();
				return;
			case ConfigurationemfPackage.FRAME__TEMPLATE:
				setTemplate(TEMPLATE_EDEFAULT);
				return;
			case ConfigurationemfPackage.FRAME__TEMPLATE_OWNER:
				setTemplateOwner((ParentSetting)null);
				return;
			case ConfigurationemfPackage.FRAME__REF:
				setRef((Ref)null);
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
			case ConfigurationemfPackage.FRAME__LEAF_SETTINGS:
				return leafSettings != null && !leafSettings.isEmpty();
			case ConfigurationemfPackage.FRAME__NUMBER:
				return number != NUMBER_EDEFAULT;
			case ConfigurationemfPackage.FRAME__TEMPLATE:
				return template != TEMPLATE_EDEFAULT;
			case ConfigurationemfPackage.FRAME__TEMPLATE_OWNER:
				return templateOwner != null;
			case ConfigurationemfPackage.FRAME__REF:
				return ref != null;
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
		result.append(" (number: ");
		result.append(number);
		result.append(", template: ");
		result.append(template);
		result.append(')');
		return result.toString();
	}

} //FrameImpl
