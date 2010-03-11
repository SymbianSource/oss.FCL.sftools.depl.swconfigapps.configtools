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
package configurationemf.validation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.validation.service.AbstractTraversalStrategy;

import configurationemf.ParentSetting;
import configurationemf.RootConf;

public class ATraversalStrategy extends AbstractTraversalStrategy
{
		private Collection roots;
		private boolean contextChanged = true;
		
		/**
		 * Initializes me.
		 */
		public ATraversalStrategy() {
			super();
		}
		
		public void startTraversal(
				Collection traversalRoots,
				IProgressMonitor progressMonitor) {
			List<Object> myRoots = getBasedOnBranch(traversalRoots);
			roots = makeTargetsDisjoint(myRoots);
			
			super.startTraversal(traversalRoots, progressMonitor);
		}
		
		private List<Object> getBasedOnBranch(Collection traversalRoots){
			List<Object> result = new ArrayList<Object>();
			for(Iterator it = traversalRoots.iterator();it.hasNext();){
				Object obj = it.next();
				if(obj instanceof RootConf){
					RootConf conf=(RootConf)obj;
					result.addAll(getBasedOnBranch(conf.getInclude()));
				}
				result.add(obj);
			}
			return result;
		}
		
		private Collection getRoots() {
			return roots;
		}
		
		/* (non-Javadoc)
		 * Implements the inherited method.
		 */
		protected int countElements(Collection ignored) {
			return countRecursive(getRoots());
		}
		
		private int countRecursive(Collection elements) {
			int result = 0;
			
			result = elements.size();
			
			for (Iterator iter = elements.iterator(); iter.hasNext(); ) {
				Object next = iter.next();
				
				if (next instanceof EObject) {
					result = result + countRecursive(
							((EObject)next).eContents());
				}
			}
			
			return result;
		}
		
		/* (non-Javadoc)
		 * Implements the inherited method.
		 */
		protected Iterator createIterator(Collection ignored) {
			return new EcoreUtil.ContentTreeIterator(getRoots()) {
				private static final long serialVersionUID = -5653134989235663973L;

				public Iterator getChildren(Object obj) {
					if (obj == getRoots()) {
						return new Iterator() {
							private final Iterator delegate =
								getRoots().iterator();
							
							public boolean hasNext() {
								return delegate.hasNext();
							}

							public Object next() {
								// if I'm being asked for my next element, then
								//    we are stepping to another traversal root
								contextChanged = true;
								
								return delegate.next();
							}

							public void remove() {
								delegate.remove();
							}};
					}else if(obj instanceof ParentSetting){
						List<EObject> children = new ArrayList<EObject>();
						ParentSetting pset = (ParentSetting)obj;
						children.addAll(pset.getFrames());
						if(pset.getTemplate()!=null)
							children.add(pset.getTemplate());
						return children.iterator();
					}else{
						return super.getChildren(obj);
					}
				}
				
				public Object next() {
					// this will be set to true again the next time we test hasNext() at
					//    the traversal root level
					contextChanged = false;
					
					return super.next();
				}};

		}
		
		
		
		
		public boolean isClientContextChanged() {
			return contextChanged;
		}
		
		private Set makeTargetsDisjoint(Collection objects) {
			Set result = new java.util.HashSet();
			
			// ensure that any contained (descendent) elements of other elements
			//    that we include are not included, because they will be
			//    traversed by recursion, anyway
			
			for (Iterator outer = objects.iterator(); outer.hasNext();) {
				EObject outerNext = (EObject)outer.next();
				
				for (Iterator inner = result.iterator(); inner.hasNext();) {
					EObject innerNext = (EObject)inner.next();
					
					if (EcoreUtil.isAncestor(innerNext, outerNext)) {
						outerNext = null;  // forget this one
						break;
					}
				}
				
				if (outerNext != null) {
					result.add(outerNext);
				}
			}
			
			return result;
		}

		
}
