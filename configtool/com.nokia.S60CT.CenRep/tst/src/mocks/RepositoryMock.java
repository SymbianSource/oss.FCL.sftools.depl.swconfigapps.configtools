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
package mocks;

import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

import cenrep.Access;
import cenrep.Desc;
import cenrep.Key;
import cenrep.Meta;
import cenrep.Repository;

public class RepositoryMock implements Repository {

	EList<Key> keys = new BasicEList<Key>();
	
	
	public EList getAccess() {
		
		return null;
	}

	
	public boolean canGenerate() {
		return true;
	}

	
	public String getFileName() {
		
		return null;
	}

	
	public String getProblems() {
		
		return null;
	}

	
	public String getBackup() {
		
		return null;
	}

	
	public EList getBitmaskKeys() {
		
		return null;
	}

	
	public EList getChange() {
		
		return null;
	}

	
	public String getDesc() {
		
		return null;
	}

	
	public String getInitialisationFileVersion() {
		
		return null;
	}

	
	public EList getKey() {
		return keys;
	}

	
	public List getKey(String release) {
		
		return null;
	}

	
	public Meta getMeta() {
		
		return null;
	}

	
	public String getOwner() {
		
		return null;
	}

	
	public EList getRangeKey() {
		
		return null;
	}

	
	public String getRfs() {
		
		return null;
	}

	
	public EList getSimpleKeys() {
		
		return null;
	}

	
	public String getUidName() {
		
		return null;
	}

	
	public String getUidValue() {
		
		return null;
	}

	
	public String getVersion() {
		
		return null;
	}

	
	public void setBackup(String value) {
		

	}

	
	public void setDesc(Desc value) {
		

	}

	
	public void setInitialisationFileVersion(String value) {
		

	}

	
	public void setMeta(Meta value) {
		

	}

	
	public void setOwner(String value) {
		

	}

	
	public void setRfs(String value) {
		

	}

	
	public void setUidName(String value) {
		

	}

	
	public void setUidValue(String value) {
		

	}

	
	public void setVersion(String value) {
		

	}

	
	public List sortKeys() {
		
		return null;
	}

	
	public String getId() {
		
		return null;
	}

	
	public void setId(String value) {
		

	}

	
	public String getFirstRelease() {
		
		return null;
	}

	
	public String getLastRelease() {
		
		return null;
	}

	
	public void setFirstRelease(String value) {
		

	}

	
	public void setLastRelease(String value) {
		

	}

	
	public TreeIterator<EObject> eAllContents() {
		
		return null;
	}

	
	public EClass eClass() {
		
		return null;
	}

	
	public EObject eContainer() {
		
		return null;
	}

	
	public EStructuralFeature eContainingFeature() {
		
		return null;
	}

	
	public EReference eContainmentFeature() {
		
		return null;
	}

	
	public EList<EObject> eContents() {
		
		return null;
	}

	
	public EList<EObject> eCrossReferences() {
		
		return null;
	}

	
	public Object eGet(EStructuralFeature feature) {
		
		return null;
	}

	
	public Object eGet(EStructuralFeature feature, boolean resolve) {
		
		return null;
	}

	
	public boolean eIsProxy() {
		
		return false;
	}

	
	public boolean eIsSet(EStructuralFeature feature) {
		
		return false;
	}

	
	public Resource eResource() {
		
		return null;
	}

	
	public void eSet(EStructuralFeature feature, Object newValue) {
		

	}

	
	public void eUnset(EStructuralFeature feature) {
		

	}

	
	public EList<Adapter> eAdapters() {
		
		return null;
	}

	
	public boolean eDeliver() {
		
		return false;
	}

	
	public void eNotify(Notification notification) {
		

	}

	
	public void eSetDeliver(boolean deliver) {
		

	}


	@Override
	public boolean isBackup() {
		
		return false;
	}


	@Override
	public boolean isRfs() {
		
		return false;
	}


	@Override
	public void setBackup(boolean value) {
		
		
	}


	@Override
	public void setRfs(boolean value) {
		
		
	}


	@Override
	public String getGAccess() {
		
		return null;
	}


	@Override
	public Access getReadAccess() {
		
		return null;
	}


	@Override
	public Access getWriteAccess() {
		
		return null;
	}


	@Override
	public void setReadAccess(Access value) {
		
		
	}


	@Override
	public void setWriteAccess(Access value) {
		
		
	}


	@Override
	public void setDesc(String value) {
		
		
	}

	

}
