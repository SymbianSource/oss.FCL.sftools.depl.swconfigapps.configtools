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

import constraints.ReadOnlyBackUpConstraint;

import cenrep.IBackup;
import cenrep.IReadOnly;

public class ReadOnlyBackUpTest extends AbstractConstraintTest {

	@Override
	protected Pair[] getAcceptedObjects() {
		Pair[] pair = new Pair[]{
				new Pair(new Mock(true,false),"Accept bUp=true, ro=false"),
				new Pair(new Mock(false,false),"Accept bUp=false, ro=false"),
				new Pair(new Mock(false,true),"Accept bUp=false, ro=true"),
		};
		return pair;
	}

	@Override
	protected Pair[] getRejectedObjects() {
		Pair[] pair = new Pair[]{
				new Pair(new Mock(true,true),"Accept bUp=true, ro=true"),
		};
		return pair;
	}

	@Override
	protected void setUp() throws Exception {
		constraint = new ReadOnlyBackUpConstraint();

	}

	class Mock implements IBackup,IReadOnly{
		boolean bUp=false;
		boolean readOnly=false;
		public Mock(boolean bUp,boolean readOnly){
			this.bUp=bUp;
			this.readOnly=readOnly;
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
		public boolean isBackup() {
			return bUp;
		}

		@Override
		public void setBackup(boolean value) {
			
		}

		@Override
		public boolean isReadOnly() {
			return readOnly;
		}

		@Override
		public void setReadOnly(boolean value) {
			
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
