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

import java.util.Collection;
import java.util.List;
import java.util.Set;

import junit.framework.TestCase;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;

public abstract class AbstractConstraintTest extends TestCase {
	protected AbstractModelConstraint constraint = null;
	protected ValidationContext ctx = new ValidationContext();
	
	protected abstract void setUp() throws Exception;
	
	protected void tearDown() throws Exception {
		super.tearDown();
		constraint = null;
	}
	
	protected abstract Pair[] getAcceptedObjects();
	protected abstract Pair[] getRejectedObjects();
	
	public void testAcceptedObjects(){
		assertNotNull("Constraint is not defined.", constraint);
		Pair[] acceptedPairs = getAcceptedObjects();
		assertNotNull("No accepted objects", acceptedPairs);
		for(Pair pair : acceptedPairs){
			ctx.setTarget(pair.getObject());
			IStatus status = constraint.validate(ctx);
			assertEquals(pair.getMsg(), IStatus.OK, status.getSeverity());
		}
	}
	
	public void testRejectedObjects(){
		assertNotNull("Constraint is not defined.", constraint);
		Pair[] rejectedPairs = getRejectedObjects();
		assertNotNull("No rejected objects", rejectedPairs);
		for(Pair pair : rejectedPairs){
			ctx.setTarget(pair.getObject());
			IStatus status = constraint.validate(ctx);
			assertEquals(pair.getMsg(), IStatus.ERROR, status.getSeverity());
		}
	}
	
	protected class Pair{
		private EObject obj=null;
		private String msg=null;
		public Pair(EObject obj, String msg){
			this.obj=obj;
			this.msg=msg;
		}
		public EObject getObject(){
			return obj;
		}
		public String getMsg(){
			return msg;
		}
	}
	
	private class ValidationContext implements IValidationContext {
		Status failtureStatus = new Status(IStatus.ERROR,"id","");
		Status successStatus = new Status(IStatus.OK,"id","");
		EObject target = null;
		
		@Override
		public void addResult(EObject object) {
			
		}

		@Override
		public void addResults(Collection objects) {
			
		}

		@Override
		public IStatus createFailureStatus(Object[] messageArguments) {
			return failtureStatus;
		}

		@Override
		public IStatus createSuccessStatus() {
			return successStatus;
		}

		@Override
		public void disableCurrentConstraint(Throwable exception) {
			
		}

		@Override
		public List getAllEvents() {
			return null;
		}

		@Override
		public Object getCurrentConstraintData() {
			return null;
		}

		@Override
		public String getCurrentConstraintId() {
			return null;
		}

		@Override
		public EMFEventType getEventType() {
			return null;
		}

		@Override
		public EStructuralFeature getFeature() {
			return null;
		}

		@Override
		public Object getFeatureNewValue() {
			return null;
		}

		@Override
		public Set getResultLocus() {
			return null;
		}

		@Override
		public EObject getTarget() {
			return target;
		}

		public void setTarget(EObject target){
			this.target = target;
		}
		
		@Override
		public Object putCurrentConstraintData(Object newData) {
			return null;
		}

		@Override
		public void skipCurrentConstraintFor(EObject object) {
			
		}

		@Override
		public void skipCurrentConstraintForAll(Collection objects) {
			
		}
		
	}
	
}
