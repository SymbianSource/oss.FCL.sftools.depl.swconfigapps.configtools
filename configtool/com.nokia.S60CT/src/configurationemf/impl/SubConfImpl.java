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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import configurationemf.ConfigurationemfPackage;
import configurationemf.RootConf;
import configurationemf.Setting;
import configurationemf.SubConf;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sub Conf</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class SubConfImpl extends ConfigurationImpl implements SubConf {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SubConfImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigurationemfPackage.Literals.SUB_CONF;
	}

	public boolean isReadOnly() {
		return ((RootConf)this.eContainer()).isReadOnly();
	}

	@Override
	public EList<Setting> getAllSettings() {
		return null;
	}
	
	

} //SubConfImpl