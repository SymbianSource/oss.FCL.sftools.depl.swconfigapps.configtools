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

package com.nokia.tools.variant.confml.internal.core.project;

import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

import com.nokia.tools.variant.confml.core.ConfMLCore;

public class GenericBuilder extends IncrementalProjectBuilder {

	class SimpleDeltaVisitor implements IResourceDeltaVisitor {
		
		IProgressMonitor monitor;
		
		public SimpleDeltaVisitor(IProgressMonitor monitor) {
			this.monitor = monitor;
		}
		
		/*
		 * @see IResourceDeltaVisitor#visit(IResourceDelta)
		 */
		public boolean visit(IResourceDelta delta) throws CoreException {
			IResource resource = delta.getResource();
			if (this.monitor != null) {
				this.monitor.subTask("Building" + resource.getProjectRelativePath());
			}
			
			switch (delta.getKind()) {
			case IResourceDelta.ADDED:
				// handle added resource
				buildResource(resource);
				break;
			case IResourceDelta.REMOVED:
				// handle removed resource
				break;
			case IResourceDelta.CHANGED:
				// handle changed resource
				buildResource(resource);
				break;
			}
			// return true to continue visiting children.
			return true;
		}
	}

	class SimpleResourceVisitor implements IResourceVisitor {
		IProgressMonitor monitor;
		
		public SimpleResourceVisitor(IProgressMonitor monitor) {
			this.monitor = monitor;
		}

		/*
		 * @see IResourceVisitor#visit(IResource)
		 */
		public boolean visit(IResource resource) {
			if (monitor != null) {
				monitor.subTask("Building "+resource.getProjectRelativePath());
			}
			
			try {
				buildResource(resource);
			} catch (CoreException e) {
				ConfMLCore.getDefault().getLog().log(e.getStatus());
				return false;
			}
			// return true to continue visiting children.
			return true;
		}
	}

	/*
	 * @see org.eclipse.core.internal.events.InternalBuilder#build(int, Map,
	 * IProgressMonitor)
	 */
	@SuppressWarnings("unchecked")
	protected IProject[] build(int kind, Map args, IProgressMonitor monitor)
			throws CoreException {
		if (kind == FULL_BUILD) {
			fullBuild(monitor);
		} else {
			IResourceDelta delta = getDelta(getProject());
			if (delta == null) {
				fullBuild(monitor);
			} else {
				incrementalBuild(delta, monitor);
			}
		}
		return null;
	}

	protected void buildResource(IResource resource) throws CoreException {
		deleteMarkers(resource);
	}

	protected void deleteMarkers(IResource resource) throws CoreException{
	}

	protected void fullBuild(final IProgressMonitor monitor)
			throws CoreException {
		monitor.beginTask("Full Build", 100);
		getProject().accept(new SimpleResourceVisitor(monitor));
		monitor.done();
	}

	protected void incrementalBuild(IResourceDelta delta,
			IProgressMonitor monitor) throws CoreException {
		monitor.beginTask("Incremental Build", 100);
		delta.accept(new SimpleDeltaVisitor(monitor));
		monitor.done();
	}
}
