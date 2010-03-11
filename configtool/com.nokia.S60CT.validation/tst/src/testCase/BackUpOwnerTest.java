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
package testCase;

import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

import cenrep.Access;
import cenrep.Key;
import cenrep.KeyRange;
import cenrep.Meta;
import cenrep.Repository;
import constraints.RepositoryBUpOwnerConstraint;

public class BackUpOwnerTest extends AbstractConstraintTest {

	@Override
	protected Pair[] getAcceptedObjects() {
		Pair[] pair = new Pair[]{
				new Pair(new RepositoryMock("qwe",true),"Accepted when owner defined, bUp = true"),
				new Pair(new RepositoryMock("qwe",false),"Accepted when owner defined, bUp = false"),
				new Pair(new RepositoryMock(null,false),"Accepted when owner not defined, bUp = false"),
				new Pair(new RepositoryMock("",false),"Accepted when owner.isEmpty, bUp = false"),
		};
		return pair;
	}

	@Override
	protected Pair[] getRejectedObjects() {
		Pair[] pair = new Pair[]{
				new Pair(new RepositoryMock("",true),"Accepted when owner is empty, bUp = true"),
				new Pair(new RepositoryMock(null,true),"Accepted when owner not defined, bUp = true"),
		};
		return pair;
	}

	@Override
	protected void setUp() throws Exception {
		constraint = new RepositoryBUpOwnerConstraint();

	}
	
	class RepositoryMock implements Repository {
		String owner=null;
		boolean bUp = false;
		
		public RepositoryMock(String owner, boolean bUp){
			this.owner = owner;
			this.bUp = bUp;
		}
		
		

		@Override
		public boolean canGenerate() {
			return false;
		}

		@Override
		public EList<Key> getBitmaskKeys() {
			return null;
		}

		@Override
		public String getFileName() {
			return null;
		}

		@Override
		public String getInitialisationFileVersion() {
			return null;
		}

		@Override
		public EList<Key> getKey() {
			return null;
		}

		@Override
		public List getKey(String release) {
			return null;
		}

		@Override
		public Meta getMeta() {
			return null;
		}

		@Override
		public String getOwner() {
			return owner;
		}

		@Override
		public String getProblems() {
			return null;
		}

		@Override
		public EList<KeyRange> getRangeKey() {
			return null;
		}

		@Override
		public EList<Key> getSimpleKeys() {
			return null;
		}

		@Override
		public String getUidName() {
			return null;
		}

		@Override
		public String getUidValue() {
			return null;
		}

		@Override
		public String getVersion() {
			return null;
		}

		@Override
		public boolean isBackup() {
			return bUp;
		}

		@Override
		public boolean isRfs() {
			return false;
		}

		@Override
		public void setBackup(boolean value) {
			
		}

		@Override
		public void setInitialisationFileVersion(String value) {
			
		}

		@Override
		public void setMeta(Meta value) {
			
		}

		@Override
		public void setOwner(String value) {
			
		}

		@Override
		public void setRfs(boolean value) {
			
		}

		@Override
		public void setUidName(String value) {
			
		}

		@Override
		public void setUidValue(String value) {
			
		}

		@Override
		public void setVersion(String value) {
			
		}

		@Override
		public List sortKeys() {
			return null;
		}

		@Override
		public String getId() {
			return null;
		}

		@Override
		public void setId(String value) {
			
		}

		@Override
		public EList<Access> getAccess() {
			return null;
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
		public EList<Adapter> eAdapters() {
			return null;
		}

		@Override
		public boolean eDeliver() {
			return false;
		}

		@Override
		public void eNotify(Notification notification) {
			
		}

		@Override
		public void eSetDeliver(boolean deliver) {
			
		}

		@Override
		public String getDesc() {
			return null;
		}

		@Override
		public void setDesc(String value) {
			
		}

		@Override
		public TreeIterator<EObject> eAllContents() {
			return null;
		}

		@Override
		public EClass eClass() {
			return null;
		}

		@Override
		public EObject eContainer() {
			return null;
		}

		@Override
		public EStructuralFeature eContainingFeature() {
			return null;
		}

		@Override
		public EReference eContainmentFeature() {
			return null;
		}

		@Override
		public EList<EObject> eContents() {
			return null;
		}

		@Override
		public EList<EObject> eCrossReferences() {
			return null;
		}

		@Override
		public Object eGet(EStructuralFeature feature, boolean resolve) {
			return null;
		}

		@Override
		public Object eGet(EStructuralFeature feature) {
			return null;
		}

		@Override
		public boolean eIsProxy() {
			return false;
		}

		@Override
		public boolean eIsSet(EStructuralFeature feature) {
			return false;
		}

		@Override
		public Resource eResource() {
			return null;
		}

		@Override
		public void eSet(EStructuralFeature feature, Object newValue) {
			
		}

		@Override
		public void eUnset(EStructuralFeature feature) {
		}
		
	}
}
