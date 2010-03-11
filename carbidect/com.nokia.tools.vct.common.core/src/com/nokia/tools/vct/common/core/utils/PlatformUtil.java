/*
 * Copyright (c) 2009 Nokia Corporation and/or its subsidiary(-ies).
 * All rights reserved.
 * This component and the accompanying materials are made available
 * under the terms of "Eclipse Public License v1.0"
 * which accompanies this distribution, and is available
 * at the URL "http://www.eclipse.org/legal/epl-v10.html".
 * 
 * Initial Contributors:
 * Nokia Corporation - Initial contribution
 * 
 * Contributors:
 * 
 * Description: This file is part of com.nokia.tools.vct.common.core component.
 */

package com.nokia.tools.vct.common.core.utils;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.PlatformObject;
import org.eclipse.core.runtime.jobs.ISchedulingRule;

/**
 * Platform utilities. Bits and pieces are taken from different places.
 * 
 */
public class PlatformUtil {

	/**
	 * If it is possible to adapt the given object to the given type, this
	 * returns the adapter. Performs the following checks:
	 * 
	 * <ol>
	 * <li>Returns <code>sourceObject</code> if it is an instance of the adapter
	 * type.</li>
	 * <li>If sourceObject implements IAdaptable, it is queried for adapters.</li>
	 * <li>If sourceObject is not an instance of PlatformObject (which would
	 * have already done so), the adapter manager is queried for adapters</li>
	 * </ol>
	 * 
	 * Otherwise returns <code>null</code>.
	 * 
	 * @param sourceObject
	 *            object to adapt, or <code>null</code>
	 * @param adapter
	 *            type to adapt to
	 * @param activatePlugins
	 *            true if IAdapterManager.loadAdapter should be used (may
	 *            trigger plugin activation)
	 * @return a representation of sourceObject that is assignable to the
	 *         adapter type, or null if no such representation exists
	 */
	public static <T> T getAdapter(Object sourceObject, Class<T> adapter,
			boolean activatePlugins) {
		Assert.isNotNull(adapter);
		if (sourceObject == null) {
			return null;
		}
		if (adapter.isInstance(sourceObject)) {
			return adapter.cast(sourceObject);
		}

		if (sourceObject instanceof IAdaptable) {
			IAdaptable adaptable = (IAdaptable) sourceObject;

			Object result = adaptable.getAdapter(adapter);
			if (adapter.isInstance(result)) {
				return adapter.cast(result);
			}
		}

		if (!(sourceObject instanceof PlatformObject)) {
			Object result;
			if (activatePlugins) {
				result = Platform.getAdapterManager().loadAdapter(sourceObject,
						adapter.getName());
			} else {
				result = Platform.getAdapterManager().getAdapter(sourceObject,
						adapter);
			}
			if (adapter.isInstance(result)) {
				return adapter.cast(result);
			}
		}

		return null;
	}

	/**
	 * Runs the given action as an atomic model operation.
	 * <p>
	 * After running a method that modifies elements, registered listeners
	 * receive after-the-fact notification of what just transpired, in the form
	 * of a element changed event. This method allows clients to call a number
	 * of methods that modify elements and only have element changed event
	 * notifications reported at the end of the entire batch.
	 * </p>
	 * <p>
	 * If this method is called outside the dynamic scope of another such call,
	 * this method runs the action and then reports a single element changed
	 * event describing the net effect of all changes done to java elements by
	 * the action.
	 * </p>
	 * <p>
	 * If this method is called in the dynamic scope of another such call, this
	 * method simply runs the action.
	 * </p>
	 * 
	 * @param action
	 *            the action to perform
	 * @param monitor
	 *            a progress monitor, or <code>null</code> if progress reporting
	 *            and cancellation are not desired
	 * @exception CoreException
	 *                if the operation failed.
	 */
	public static void run(IWorkspaceRunnable action, IProgressMonitor monitor)
			throws CoreException {
		run(action, ResourcesPlugin.getWorkspace().getRoot(), monitor);
	}

	/**
	 * Runs the given action as an atomic workspace operation.
	 * <p>
	 * After running a method that modifies workspace elements, registered
	 * listeners receive after-the-fact notification of what just transpired, in
	 * the form of a element changed event. This method allows clients to call a
	 * number of methods that modify java elements and only have element changed
	 * event notifications reported at the end of the entire batch.
	 * </p>
	 * <p>
	 * If this method is called outside the dynamic scope of another such call,
	 * this method runs the action and then reports a single element changed
	 * event describing the net effect of all changes done to elements by the
	 * action.
	 * </p>
	 * <p>
	 * If this method is called in the dynamic scope of another such call, this
	 * method simply runs the action.
	 * </p>
	 * <p>
	 * The supplied scheduling rule is used to determine whether this operation
	 * can be run simultaneously with workspace changes in other threads. See
	 * <code>IWorkspace.run(...)</code> for more details.
	 * </p>
	 * 
	 * @param action
	 *            the action to perform
	 * @param rule
	 *            the scheduling rule to use when running this operation, or
	 *            <code>null</code> if there are no scheduling restrictions for
	 *            this operation.
	 * @param monitor
	 *            a progress monitor, or <code>null</code> if progress reporting
	 *            and cancellation are not desired
	 * @exception CoreException
	 *                if the operation failed.
	 */
	public static void run(IWorkspaceRunnable action, ISchedulingRule rule,
			IProgressMonitor monitor) throws CoreException {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		if (workspace.isTreeLocked()) {
			new WorkspaceOperation(action).run(monitor);
		} else {
			// use IWorkspace.run(...) to ensure that a build will be done in
			// autobuild mode
			workspace.run(new WorkspaceOperation(action), rule,
					IWorkspace.AVOID_UPDATE, monitor);
		}
	}

	public static void run(WorkspaceOperation action, IProgressMonitor monitor)
			throws CoreException {
		run(action, ResourcesPlugin.getWorkspace().getRoot(), monitor);
	}

	public static void run(WorkspaceOperation action, ISchedulingRule rule,
			IProgressMonitor monitor) throws CoreException {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		if (workspace.isTreeLocked()) {
			action.run(monitor);
		} else {
			// use IWorkspace.run(...) to ensure that a build will be done in
			// autobuild mode
			workspace.run(action, rule, IWorkspace.AVOID_UPDATE, monitor);
		}
	}
}
