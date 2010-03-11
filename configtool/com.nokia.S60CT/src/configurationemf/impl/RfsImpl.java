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

import configurationemf.ConfigurationemfPackage;
import configurationemf.Rfs;
import configurationemf.RootConf;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rfs</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class RfsImpl extends DataImpl implements Rfs {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RfsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigurationemfPackage.Literals.RFS;
	}

	protected void handleRefRemove(){
		if(this.getRef().isEmpty()){
			RootConf conf = (RootConf)this.eContainer();
			if(conf!=null)conf.setRfs(null);
			this.eAdapters().clear();
		}
	}
	
} //RfsImpl
