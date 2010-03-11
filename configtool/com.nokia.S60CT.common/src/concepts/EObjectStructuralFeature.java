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
package concepts;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * Represents the structural feature of a specific EObject. 
 */
public class EObjectStructuralFeature {
	
	private EObject object;
	
	private EStructuralFeature feature; 

	public EObjectStructuralFeature(EObject object, EStructuralFeature feature) {
		this.object = object; 
		this.feature = feature; 
	}
	
	public EObject getEObject() {
		return object; 
	}
	
	public EStructuralFeature getEStructuralFeature() {
		return feature; 
	}
	
	public Object eGet() {
		return object.eGet(feature);
	}
	
	public String toString() {
		return "" + feature.getName() + "@" + object.eClass().getName() + "=" + eGet(); 
	}
}
