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

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import configurationemf.Configuration;
import configurationemf.ConfigurationemfPackage;
import configurationemf.Feature;
import configurationemf.LeafSetting;
import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import configurationemf.Setting;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Leaf Setting</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class LeafSettingImpl extends SettingImpl implements LeafSetting {
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LeafSettingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigurationemfPackage.Literals.LEAF_SETTING;
	}

	@Override
	public boolean isRo() {
		if(this.eContainer==null)return false;
		return ((Setting)this.eContainer()).isRo();
	}

	public Configuration getDefaultConf() {
		if(defaultConf==null&&this.eContainer()!=null)
			defaultConf=((Setting)this.eContainer()).getDefaultConf();
		return defaultConf;
	}
	
	
	public String getAbsRef() {
		String csAbsRef=null;
		if(this.eContainer() instanceof Setting){
			Setting setting=(Setting)this.eContainer();
			if(setting.eContainer() instanceof Feature){
				csAbsRef = ((Feature)setting.eContainer()).getRef()+"/"+setting.getRef()+"/"+this.getRef();
			}
		}
		return csAbsRef;
	}
	
	
} //LeafSettingImpl