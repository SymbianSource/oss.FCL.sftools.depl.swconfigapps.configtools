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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import configurationemf.Configuration;
import configurationemf.ConfigurationemfFactory;
import configurationemf.ConfigurationemfPackage;
import configurationemf.EXTENSION_POLICY;
import configurationemf.Feature;
import configurationemf.Frame;
import configurationemf.LeafSetting;
import configurationemf.LeafSettingDelegator;
import configurationemf.ParentSetting;
import configurationemf.Ref;
import configurationemf.RootConf;
import configurationemf.Setting;
import configurationemf.TYPE;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parent Setting</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link configurationemf.impl.ParentSettingImpl#getLeafSetting <em>Leaf Setting</em>}</li>
 *   <li>{@link configurationemf.impl.ParentSettingImpl#getFrames <em>Frames</em>}</li>
 *   <li>{@link configurationemf.impl.ParentSettingImpl#getTemplate <em>Template</em>}</li>
 *   <li>{@link configurationemf.impl.ParentSettingImpl#getCurrentExtensionPolicy <em>Current Extension Policy</em>}</li>
 *   <li>{@link configurationemf.impl.ParentSettingImpl#getMinOccurs <em>Min Occurs</em>}</li>
 *   <li>{@link configurationemf.impl.ParentSettingImpl#getMaxOccurs <em>Max Occurs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ParentSettingImpl extends SettingImpl implements ParentSetting {
	/**
	 * The cached value of the '{@link #getLeafSetting() <em>Leaf Setting</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeafSetting()
	 * @generated
	 * @ordered
	 */
	protected EList<LeafSetting> leafSetting;
	
	public LeafSetting getLeafSettingByRef(String ref) {
		for (LeafSetting ls : leafSetting) {
			if (ls.getRef().equals(ref)) {
				return ls;
			}
		}
		return null;
	}
	
	/**
	 * The cached value of the '{@link #getFrames() <em>Frames</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrames()
	 * @generated
	 * @ordered
	 */
	protected EList<Frame> frames;

	protected List<Frame> myFrames=null;
	protected List<Frame> basedOnFrames=null;
	/**
	 * The cached value of the '{@link #getTemplate() <em>Template</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTemplate()
	 * @generated
	 * @ordered
	 */
	protected Frame template;

	/**
	 * The default value of the '{@link #getCurrentExtensionPolicy() <em>Current Extension Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentExtensionPolicy()
	 * @generated
	 * @ordered
	 */
	protected static final EXTENSION_POLICY CURRENT_EXTENSION_POLICY_EDEFAULT = EXTENSION_POLICY.REPLACE;

	/**
	 * The default value of the '{@link #getMinOccurs() <em>Min Occurs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinOccurs()
	 * @generated
	 * @ordered
	 */
	protected static final int MIN_OCCURS_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getMinOccurs() <em>Min Occurs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinOccurs()
	 * @generated
	 * @ordered
	 */
	protected int minOccurs = MIN_OCCURS_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxOccurs() <em>Max Occurs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxOccurs()
	 * @generated NOT
	 * @ordered
	 */
	protected static final int MAX_OCCURS_EDEFAULT = Integer.MAX_VALUE;

	/**
	 * The cached value of the '{@link #getMaxOccurs() <em>Max Occurs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxOccurs()
	 * @generated
	 * @ordered
	 */
	protected int maxOccurs = MAX_OCCURS_EDEFAULT;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParentSettingImpl() {
		super();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigurationemfPackage.Literals.PARENT_SETTING;
	}

	

	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LeafSetting> getLeafSetting() {
		if (leafSetting == null) {
			leafSetting = new EObjectContainmentEList<LeafSetting>(LeafSetting.class, this, ConfigurationemfPackage.PARENT_SETTING__LEAF_SETTING);
		}
		return leafSetting;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Frame> getFrames() {
		if (frames == null) {
			frames = new EObjectContainmentEList<Frame>(Frame.class, this, ConfigurationemfPackage.PARENT_SETTING__FRAMES);
		}
		if(frames.isEmpty()&&this.getType()==TYPE.SEQUENCE){
			frames.addAll(mergeFrames(getMyCurrentFrames(), getCurrentBasedOnFrames(), 
									  this.getCurrentExtensionPolicy(),this.getCurrentConf()));
		}
		return frames;
	}
	
	public List<Frame> getMyCurrentFrames(){
		if(myFrames==null)
			myFrames=this.getMyFrames(getCurrentConf());
		return myFrames;
	}
	
	private List<Frame> getCurrentBasedOnFrames(){
		if(basedOnFrames==null){
			basedOnFrames = getFramesInBasedOn((RootConf)getCurrentConf());
		}
		return basedOnFrames;
	}
	
	private List<Frame> getMyFrames(Configuration conf){
		return createFrames(conf);
	}
	
	private List<Frame> getFramesInBasedOn(RootConf configuration){
		List<Frame> boFrames = new ArrayList<Frame>();
		
		if(configuration.getInclude().isEmpty()&&!configuration.equals(getCurrentConf())){ 
			//this is for developer only! do nothing
		}
		else{
			boFrames = new ArrayList<Frame>();
			for(RootConf basedOn : configuration.getInclude()){
				boFrames.addAll(mergeFrames(
							this.getMyFrames(basedOn), //take from this level
							getFramesInBasedOn(basedOn),//go to next level 
							getPolicyInConf(basedOn),basedOn)
							);
			}
		}
		
		return boFrames;
	}
	
	private boolean isEmptyIn(Configuration conf){
		for(Ref ref : getRefs()){
			if(!ref.getConfiguration().equals(conf))continue;
			if(ref.isEmpty()){
				return true;
			}
		}
		return false;
	}
	
	private List<Frame> mergeFrames(List<Frame> myFrames,List<Frame> boFrames,EXTENSION_POLICY extensionPolicy,Configuration conf){
		List<Frame> result=new ArrayList<Frame>();
		if(this.isEmptyIn(conf))return result;
		if(extensionPolicy==EXTENSION_POLICY.NO_POLICY){
			result.addAll(boFrames);
		}else if(extensionPolicy==EXTENSION_POLICY.REPLACE){
			result.addAll(myFrames);
		}else if(extensionPolicy==EXTENSION_POLICY.APPEND){
			result.addAll(boFrames);
			result.addAll(myFrames);
		}else if(extensionPolicy==EXTENSION_POLICY.PREFIX){
			result.addAll(myFrames);
			result.addAll(boFrames);
		}
		
		return result;
	}
	
	private List<Frame> createFrames(Configuration conf){
		List<Frame> aFrames = new ArrayList<Frame>();
		for(Ref ref : getRefs()){
			if(!ref.getConfiguration().equals(conf))continue;
			if(ref.isTemplate())continue;
			if(ref.isEmpty()){
				aFrames.clear();
				break;
			}
			Frame frame = ConfigurationemfFactory.eINSTANCE.createFrame();
			frame.setRef(ref);
			createLsDelegators(ref, frame);
			if(!frame.getLeafSettings().isEmpty()){
				aFrames.add(frame);
			}
		}
		return aFrames;
	}

	private void createLsDelegators(Ref ref, Frame frame) {
		for(LeafSetting leafSetting : getLeafSetting()){
			LeafSettingDelegator delegator = ConfigurationemfFactory.eINSTANCE.createLeafSettingDelegator();
			delegator.setLeafSetting(leafSetting);
			frame.getLeafSettings().add(delegator);
		}
		for(Ref lRef : ref.getRef()){
			for(LeafSettingDelegator delegator :frame.getLeafSettings()){
				LeafSetting lSetting = delegator.getLeafSetting();
				if(lRef.getName().compareTo(lSetting.getRef())==0){
					delegator.setRef(lRef);
				}
			}
		}
	}

	public void makeTemplateRef(){
		Ref ref = null;
		for(Ref myRef: getRefs()){
			if(myRef.getConfiguration().equals(getCurrentConf()))ref=myRef;
		}
		if(ref!=null){
			ref.setValue(null);
			ref.setTemplate(true);
		}else{
			ref = ConfigurationemfFactory.eINSTANCE.createRef();
			ref.setName(getRef());
			ref.setTemplate(true);
			Ref featureRef = this.getCreateFeatureRef(getCurrentConf());
			featureRef.getRef().add(ref);
			this.getRefs().add(ref);
		}
	}
	
	public void removeTemplateRef(){
		for(Ref ref : getRefs()){
			Ref featureRef = (Ref)ref.eContainer();
			featureRef.getRef().remove(ref);
		}
		this.getRefs().clear();
		this.getLeafSetting().removeAll(getLeafSetting());
		this.template=null;
		frames.clear();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Frame getTemplate() {
		if (getType() == TYPE.SEQUENCE) {
			if (template == null) {
				template = ConfigurationemfFactory.eINSTANCE.createFrame();
				template.setTemplate(true);
				template.setTemplateOwner(this);
				
				for (Ref ref : getRefs()) {
					if (ref.isTemplate()) {
						template.setRef(ref);
						createLsDelegators(ref, template);
						break; // Only first one handled
					}
				}
			}
			return template;
		} else
			return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTemplate(Frame newTemplate, NotificationChain msgs) {
		Frame oldTemplate = template;
		template = newTemplate;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.PARENT_SETTING__TEMPLATE, oldTemplate, newTemplate);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EXTENSION_POLICY getCurrentExtensionPolicy() {
		return getPolicyInConf(getCurrentConf());
	}

	private EXTENSION_POLICY getPolicyInConf(Configuration conf) {
		EXTENSION_POLICY extension_policy=EXTENSION_POLICY.NO_POLICY;
		for(Ref ref : getRefs()){
			if(!ref.getConfiguration().equals(conf))continue;
			if(extension_policy==EXTENSION_POLICY.NO_POLICY)
				extension_policy=ref.getExtensionPolicy();
			if(ref.getExtensionPolicy()!=EXTENSION_POLICY.REPLACE)
				extension_policy=ref.getExtensionPolicy();
		}
		return extension_policy;
	}

	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setCurrentExtensionPolicy(EXTENSION_POLICY newCurrentExtensionPolicy) {
		EXTENSION_POLICY oldExPolicy = getCurrentExtensionPolicy();
		if(oldExPolicy!=newCurrentExtensionPolicy){
			List<Frame> myFrames = this.getMyCurrentFrames();
			if(!myFrames.isEmpty()){
				makeNotEmptySequence();
				//Ref policyRef = (Ref)myFrames.get(0).getLeafSettings().get(0).getRef().eContainer(); //LeafSettingDeligator's ref can be null in some cases.
				Ref policyRef = (Ref)myFrames.get(0).getRef(); //same ref
				policyRef.setExtensionPolicy(newCurrentExtensionPolicy);
			}
			getFrames().clear();
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.PARENT_SETTING__CURRENT_EXTENSION_POLICY, oldExPolicy, newCurrentExtensionPolicy));
		}
	}

	public void makeEmptySequence(){
		for(Frame myFrame : getMyCurrentFrames())
			removeFrame(myFrame);
		Ref myFeatureRef = getCreateFeatureRef(getCurrentConf());
		Ref myEmptyRef = createRef(myFeatureRef, getRefs());
		
		myEmptyRef.setEmpty(true);
		this.getRefs().add(myEmptyRef);
		this.myFrames=null;
		this.getFrames().clear();
		
	}

	
	
	public RootConf getGConf() {
		if(type==TYPE.SEQUENCE){
			List<Frame> frames = getFrames();
			int level = Integer.MAX_VALUE;
			RootConf gConf = null;
			for(Frame frame : frames){
				RootConf conf = (RootConf)frame.getRef().getConfiguration();
				int temp = conf.getLevel();
				if(temp<level){
					gConf=conf;
					level=temp;
				}
			}
			return gConf;
		}else return super.getGConf();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMinOccurs() {
		return minOccurs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinOccurs(int newMinOccurs) {
		int oldMinOccurs = minOccurs;
		minOccurs = newMinOccurs;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.PARENT_SETTING__MIN_OCCURS, oldMinOccurs, minOccurs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMaxOccurs() {
		return maxOccurs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxOccurs(int newMaxOccurs) {
		int oldMaxOccurs = maxOccurs;
		maxOccurs = newMaxOccurs;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationemfPackage.PARENT_SETTING__MAX_OCCURS, oldMaxOccurs, maxOccurs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void addFrame() {
		
		makeNotEmptySequence();
		
		Frame newFrame = ConfigurationemfFactory.eINSTANCE.createFrame();
		getMyCurrentFrames().add(newFrame);
		getFrames().clear();
		
		Ref frameRef = createRef(getCreateFeatureRef(getCurrentConf()), getRefs());
		newFrame.setRef(frameRef);

		Frame templateFrame = this.getTemplate();
		for(Setting leafSetting : getLeafSetting()){
			if(templateFrame!=null){
				for(LeafSettingDelegator delegator : templateFrame.getLeafSettings()){
					if(delegator.getLeafSetting().equals(leafSetting)){
						String delegatorValue= delegator.getValue();
						if(delegatorValue!=null){
							Ref lsRef = ConfigurationemfFactory.eINSTANCE.createRef();
							leafSetting.getRefs().add(lsRef);
							lsRef.setName(leafSetting.getRef());
							lsRef.setValue(delegator.getValue());
							frameRef.getRef().add(lsRef);
						}
					}
				}
			}
			
		}
		createLsDelegators(frameRef, newFrame);
	}

	public void addFrame(Frame newFrame) {
		
		makeNotEmptySequence();
		
		getMyCurrentFrames().add(newFrame);
		getFrames().clear();
		
		Ref frameRef = createRef(getCreateFeatureRef(getCurrentConf()), getRefs());
		newFrame.setRef(frameRef);

		
		Frame templateFrame = this.getTemplate();
		for(Setting leafSetting : getLeafSetting()){
			if(templateFrame!=null){
				for(LeafSettingDelegator delegator : newFrame.getLeafSettings()){
					if(delegator.getLeafSetting().equals(leafSetting)){
						String delegatorValue= delegator.getValue();
						if(delegatorValue!=null){
							Ref lsRef = ConfigurationemfFactory.eINSTANCE.createRef();
							leafSetting.getRefs().add(lsRef);
							lsRef.setName(leafSetting.getRef());
							lsRef.setValue(delegator.getValue());
							
							frameRef.getRef().add(lsRef);
						}
					}
				}
			}
			
		}
		
		//createLsDelegators(frameRef, newFrame);
	}
	
	public void makeNotEmptySequence(){
		Ref emptyRef = null;
		for(Ref ref : getRefs()){
			if(ref.getConfiguration().equals(getCurrentConf())){
				if(ref.isEmpty()){
					emptyRef=ref;
					break;
				}
			}
		}
		if(emptyRef!=null){
			this.getRefs().remove(emptyRef);
			((Ref)emptyRef.eContainer()).getRef().remove(emptyRef);
		}
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean canAddFrame() {
		return !this.getLeafSetting().isEmpty()&&this.getFrames().size()<this.getMaxOccurs();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void removeFrame(Frame frame) {
		Ref parentRef = frame.getRef();
		EXTENSION_POLICY currentEP = getCurrentExtensionPolicy(); 
		EXTENSION_POLICY refEP = parentRef.getExtensionPolicy();
		
		//remove corresponding ref
		//1. disconnect leafSettings
		for(LeafSettingDelegator delegator : frame.getLeafSettings()){
			Ref lref = delegator.getRef();
			Setting setting = delegator.getLeafSetting();
			if(lref!=null){
				setting.getRefs().remove(lref);
				parentRef.getRef().remove(lref);
			}
		}
		//2. disconnect parentSetting
		if(parentRef.eContainer()!=null) ((Ref)parentRef.eContainer()).getRef().remove(parentRef);
		this.getRefs().remove(parentRef);
		
		frames.clear();
		myFrames=null;
	
		if(refEP!=EXTENSION_POLICY.REPLACE
				&&currentEP!=EXTENSION_POLICY.REPLACE){
			this.setCurrentExtensionPolicy(refEP);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean canRemoveFrame(Frame frame) {
		return this.getFrames().size()>this.getMinOccurs()&&this.getMyCurrentFrames().contains(frame);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean canSetExtPolicy(EXTENSION_POLICY policy) {
		if(!getMyCurrentFrames().isEmpty()){
				if(policy==EXTENSION_POLICY.APPEND||policy==EXTENSION_POLICY.PREFIX)
					return canAddFrame();
				else return true;
			}
		return false;
	}

	
	

	@Override
	public boolean isRo() {
		if (this.eContainer == null)
			return false;
		if(eContainer instanceof Feature){
		return ((Feature) this.eContainer()).isReadOnly();
		}
		return false;
	}
	
	/*
	 * Object[][] result - for sequence settings
	 * e.g [ 
	 *       ["ref1",1,2,3],
	 *       ["ref2",q,w,r],
	 *       ["ref3",,,]
	 *     ] 
	 */
	public Object getGValue() {
		if(getType()==TYPE.SEQUENCE){
			Object[][] result =null;
			List<Frame> frames = getFrames();
			int leafSettingSize = getLeafSetting().size();
			int numberOfFrames = frames.size();
			if(leafSettingSize>0){
				result = new Object[leafSettingSize][numberOfFrames+1];
			}
			for(int iLeafSettigIndex = 0; iLeafSettigIndex<leafSettingSize;iLeafSettigIndex++){
				result[iLeafSettigIndex][0] = getLeafSetting().get(iLeafSettigIndex).getRef();
				for(int iFrameIndex=0;iFrameIndex<numberOfFrames;iFrameIndex++)
					result[iLeafSettigIndex][iFrameIndex+1]=frames.get(iFrameIndex).getLeafSettings().get(iLeafSettigIndex).getValue();
			}
			return result;
		}else return super.getGValue();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConfigurationemfPackage.PARENT_SETTING__LEAF_SETTING:
				return ((InternalEList<?>)getLeafSetting()).basicRemove(otherEnd, msgs);
			case ConfigurationemfPackage.PARENT_SETTING__FRAMES:
				return ((InternalEList<?>)getFrames()).basicRemove(otherEnd, msgs);
			case ConfigurationemfPackage.PARENT_SETTING__TEMPLATE:
				return basicSetTemplate(null, msgs);
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
			case ConfigurationemfPackage.PARENT_SETTING__LEAF_SETTING:
				return getLeafSetting();
			case ConfigurationemfPackage.PARENT_SETTING__FRAMES:
				return getFrames();
			case ConfigurationemfPackage.PARENT_SETTING__TEMPLATE:
				return getTemplate();
			case ConfigurationemfPackage.PARENT_SETTING__CURRENT_EXTENSION_POLICY:
				return getCurrentExtensionPolicy();
			case ConfigurationemfPackage.PARENT_SETTING__MIN_OCCURS:
				return new Integer(getMinOccurs());
			case ConfigurationemfPackage.PARENT_SETTING__MAX_OCCURS:
				return new Integer(getMaxOccurs());
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
			case ConfigurationemfPackage.PARENT_SETTING__LEAF_SETTING:
				getLeafSetting().clear();
				getLeafSetting().addAll((Collection<? extends LeafSetting>)newValue);
				return;
			case ConfigurationemfPackage.PARENT_SETTING__FRAMES:
				getFrames().clear();
				getFrames().addAll((Collection<? extends Frame>)newValue);
				return;
			case ConfigurationemfPackage.PARENT_SETTING__CURRENT_EXTENSION_POLICY:
				setCurrentExtensionPolicy((EXTENSION_POLICY)newValue);
				return;
			case ConfigurationemfPackage.PARENT_SETTING__MIN_OCCURS:
				setMinOccurs(((Integer)newValue).intValue());
				return;
			case ConfigurationemfPackage.PARENT_SETTING__MAX_OCCURS:
				setMaxOccurs(((Integer)newValue).intValue());
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
			case ConfigurationemfPackage.PARENT_SETTING__LEAF_SETTING:
				getLeafSetting().clear();
				return;
			case ConfigurationemfPackage.PARENT_SETTING__FRAMES:
				getFrames().clear();
				return;
			case ConfigurationemfPackage.PARENT_SETTING__CURRENT_EXTENSION_POLICY:
				setCurrentExtensionPolicy(CURRENT_EXTENSION_POLICY_EDEFAULT);
				return;
			case ConfigurationemfPackage.PARENT_SETTING__MIN_OCCURS:
				setMinOccurs(MIN_OCCURS_EDEFAULT);
				return;
			case ConfigurationemfPackage.PARENT_SETTING__MAX_OCCURS:
				setMaxOccurs(MAX_OCCURS_EDEFAULT);
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
			case ConfigurationemfPackage.PARENT_SETTING__LEAF_SETTING:
				return leafSetting != null && !leafSetting.isEmpty();
			case ConfigurationemfPackage.PARENT_SETTING__FRAMES:
				return frames != null && !frames.isEmpty();
			case ConfigurationemfPackage.PARENT_SETTING__TEMPLATE:
				return template != null;
			case ConfigurationemfPackage.PARENT_SETTING__CURRENT_EXTENSION_POLICY:
				return getCurrentExtensionPolicy() != CURRENT_EXTENSION_POLICY_EDEFAULT;
			case ConfigurationemfPackage.PARENT_SETTING__MIN_OCCURS:
				return minOccurs != MIN_OCCURS_EDEFAULT;
			case ConfigurationemfPackage.PARENT_SETTING__MAX_OCCURS:
				return maxOccurs != MAX_OCCURS_EDEFAULT;
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
		result.append(" (minOccurs: ");
		result.append(minOccurs);
		result.append(", maxOccurs: ");
		result.append(maxOccurs);
		result.append(')');
		return result.toString();
	}

	@Override
	public Configuration getDefaultConf() {
		EObject e = null;
		if (defaultConf == null && this.eContainer() != null) {
			
			e = eContainer();
			while (!(e instanceof Configuration)) {
				e = e.eContainer();
			}
			defaultConf = (Configuration) e;
		}
		
		return defaultConf;
	}
	
	public String getAbsRef() {
		String csAbsRef=null;
		if(this.eContainer() instanceof Feature){
			csAbsRef = ((Feature)this.eContainer()).getRef()+"/"+this.getRef();			
		}
		return csAbsRef;
	}
	
	
} //ParentSettingImpl