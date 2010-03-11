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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

import cenrep.ACCESS_TYPE;
import cenrep.Access;
import cenrep.CenrepPackage;
import constraints.CapaAmount;

public class CapaAmountTest extends AbstractConstraintTest {

	@Override
	protected Pair[] getAcceptedObjects() {
		Pair[] pair = new Pair[]{
			new Pair(new AccessMock("z,x,c,v,b,n,m"),"Accept 7 unknown caps."),
			new Pair(new AccessMock("z,x,c","222"),"Accept 3 with SID unknown caps."),
		};
		return pair;
	}

	@Override
	protected Pair[] getRejectedObjects() {
		Pair[] pair = new Pair[]{
				new Pair(new AccessMock("a,s,d,f,g,h,j,k"),"reject 8 unknown caps."),
				new Pair(new AccessMock("z,x,c,2","222"),"Accept 3 with SID unknown caps."),
		};
			return pair;
	}

	@Override
	protected void setUp() throws Exception {
		constraint = new CapaAmount();
	}
	
	class AccessMock implements Access{
		String cap=null;
		String sid=null;
		
		public AccessMock(String cap){
			this.cap=cap;
		}
		
		public AccessMock(String cap,String sid){
			this.cap=cap;
			this.sid = sid;
		}
		
		@Override
		public String getCapabilities() {
			return cap;
		}

		@Override
		public String getSid() {
			return sid;
		}

		@Override
		public String getStrFormat() {
			return null;
		}

		@Override
		public ACCESS_TYPE getType() {
			return null;
		}

		@Override
		public void setCapabilities(String value) {
			
		}

		@Override
		public void setSid(String value) {
			
		}

		@Override
		public void setType(ACCESS_TYPE value) {
			
		}

		@Override
		public String getDesc() {
			return null;
		}

		@Override
		public void setDesc(String value) {
			
		}

		@Override
		public String getId() {
			return null;
		}

		@Override
		public void setId(String value) {
			
		}

		@Override
		public TreeIterator<EObject> eAllContents() {
			return null;
		}

		@Override
		public EClass eClass() {
			return CenrepPackage.eINSTANCE.getAccess();
		}

		@Override
		public EObject eContainer() {
			return this;
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
		
	}
}
