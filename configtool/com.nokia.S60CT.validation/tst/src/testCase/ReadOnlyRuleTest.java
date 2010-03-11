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

import com.sun.corba.se.impl.ior.WireObjectKeyTemplate;

import cenrep.Access;
import cenrep.CenrepPackage;
import cenrep.IAccessable;
import cenrep.IReadOnly;
import constraints.ReadOnlyRuleConstraint;

public class ReadOnlyRuleTest extends AbstractConstraintTest {

	@Override
	protected Pair[] getAcceptedObjects() {
		Pair[] pair = new Pair[]{
			new Pair(new RAccessableMock(null,false),"test should pass for all readOnly==false"),	
			new Pair(new RAccessableMock(new  WriteCapaExistanceTest.WriteAccessMock(""),true),"write access without capas should be valid"),
			new Pair(new RAccessableMock(new  WriteCapaExistanceTest.WriteAccessMock(null),true),"write access without capas should be valid"),
		};
		return pair;
	}

	@Override
	protected Pair[] getRejectedObjects() {
		Pair[] pair = new Pair[]{
				new Pair(new RAccessableMock(new  WriteCapaExistanceTest.WriteAccessMock("asd"),true),"no writeCapa accepted, if readOnly==true"),
			};
			return pair;
	}

	@Override
	protected void setUp() throws Exception {
		constraint = new ReadOnlyRuleConstraint();
		
	}

	
	static class RAccessableMock implements IReadOnly, IAccessable {
		Access access = null;
		boolean ro=false;
		
		public RAccessableMock(Access access, boolean ro){
			this.access = access;
			this.ro = ro;
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
			return access;
		}

		@Override
		public void setReadAccess(Access value) {
			
		}

		@Override
		public void setWriteAccess(Access value) {
			
		}

		@Override
		public TreeIterator<EObject> eAllContents() {
			return null;
		}

		@Override
		public EClass eClass() {
			return CenrepPackage.eINSTANCE.getIAccessable();
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

		@Override
		public boolean isReadOnly() {
			return ro;
		}

		@Override
		public void setReadOnly(boolean value) {
			
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
