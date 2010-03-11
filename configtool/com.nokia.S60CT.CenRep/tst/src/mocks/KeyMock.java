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
import cenrep.Bit;
import cenrep.Desc;
import cenrep.Key;
import cenrep.TYPE;

public class KeyMock implements Key {

	String ref = null;
	EList<Bit> bits = new BasicEList<Bit>();
	boolean gValueSet = false;
	
	public KeyMock(String ref){
		this.ref=ref;
	}
	
	
	public EList getAccess() {
		return null;
	}

	
	public EList getBits() {
		return bits;
	}

	
	

	
	@Override
	public String getDesc() {
		return null;
	}


	public String getFirstInt() {
		return null;
	}

	
	public String getIdent() {
		return null;
	}

	
	public String getLastInt() {
		return null;
	}

	
	public String getName() {
		return null;
	}

	
	public String getShortIdent() {
		return null;
	}

	
	public String getStrType() {
		return null;
	}

	
	public TYPE getType() {
		return null;
	}

	
	public EList getValue() {
		return null;
	}

	
	public boolean isBackup() {
		return false;
	}

	
	public boolean isBitmaskKey() {
		return false;
	}

	
	public boolean isDecFormat() {
		return false;
	}

	
	public boolean isHexFormat() {
		return false;
	}

	
	public boolean isRangeKey() {
		return false;
	}

	
	public boolean isReadOnly() {
		return false;
	}

	
	public boolean isRfs() {
		return false;
	}

	
	public boolean isSimpleKey() {
		return false;
	}

	
	public void setBackup(boolean value) {

	}

	
	public void setBitmaskKey(boolean value) {

	}

	
	public void setDesc(Desc value) {

	}

	
	public void setFirstInt(String value) {

	}

	
	public void setIdent(String value) {

	}

	
	public void setLastInt(String value) {

	}

	
	public void setName(String value) {

	}

	
	public void setRangeKey(boolean value) {

	}

	
	public void setReadOnly(boolean value) {

	}

	
	public void setRfs(boolean value) {

	}

	
	public void setShortIdent(String value) {

	}

	
	public void setSimpleKey(boolean value) {

	}

	
	public void setType(TYPE value) {

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

	
	public String getGvalue() {
		return null;
	}

	
	public String getRef() {
		return ref;
	}

	
	public void setGvalue(String value) {
		gValueSet=true;

	}

	
	public void setRef(String value) {

	}

	

	public boolean isGValueSet() {
		return gValueSet;
	}

	
	public boolean canGenerate() {
		return false;
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


	@Override
	public String getFolder() {
		return null;
	}


	@Override
	public int getGPriority() {
		return 0;
	}


	@Override
	public void setGConf(String confName) {
		
	}


	@Override
	public void setGvalue(Object value) {
		
	}


	@Override
	public void setPriority(String prio) {
		
	}

}
