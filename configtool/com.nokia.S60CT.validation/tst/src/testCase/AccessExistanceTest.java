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

import cenrep.Access;
import cenrep.CenrepFactory;
import cenrep.CenrepPackage;
import cenrep.IAccessable;
import constraints.AccessExistanceConstraint;

public class AccessExistanceTest extends AbstractConstraintTest {

	@Override
	protected void setUp() throws Exception {
		constraint = new AccessExistanceConstraint();
	}

	@Override
	protected Pair[] getAcceptedObjects() {
		Access someCapAccess = CenrepFactory.eINSTANCE.createAccess();
		someCapAccess.setCapabilities("test");
		Pair[] pairs = new Pair[]{
				new Pair(new MockAccessable(someCapAccess), "Even weird access cas should be accepted by this rule.")
		};
		return pairs;
	}

	@Override
	protected Pair[] getRejectedObjects() {
		Access accessNullCap = CenrepFactory.eINSTANCE.createAccess();
		accessNullCap.setCapabilities(null);
		
		Access accessEmptyCap = CenrepFactory.eINSTANCE.createAccess();
		accessEmptyCap.setCapabilities(" ");
		
		Pair[] pairs = new Pair[]{
			new Pair(new MockAccessable(null),"ReadAccess should not be null."),
			new Pair(new MockAccessable(accessNullCap),"ReadAccess should not accept null capabilities."),
			new Pair(new MockAccessable(accessEmptyCap),"ReadAccess should not accept empty string for capabilities.")
		};
		return pairs;
	}

	class MockAccessable implements IAccessable{
		Access rac = null;
		public MockAccessable(Access access){
			this.rac = access;
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
			
			return rac;
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
