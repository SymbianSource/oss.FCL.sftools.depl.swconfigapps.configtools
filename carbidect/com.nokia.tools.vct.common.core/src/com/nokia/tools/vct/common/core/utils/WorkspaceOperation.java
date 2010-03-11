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

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubProgressMonitor;

public class WorkspaceOperation implements IWorkspaceRunnable, IProgressMonitor {

	public static final String HAS_MODIFIED_RESOURCE_ATTR = "hasModifiedResource"; //$NON-NLS-1$
	public static final String TRUE = "true"; //$NON-NLS-1$

	private static final ThreadLocal<Stack<WorkspaceOperation>> operationStacks = new ThreadLocal<Stack<WorkspaceOperation>>();

	protected IProgressMonitor progressMonitor;
	protected IWorkspaceRunnable target;
	protected Map<Object,Object> attributes;

	public WorkspaceOperation() {
		this(null);
	}

	public WorkspaceOperation(IWorkspaceRunnable target) {
		this.target = target;
	}

	public final void run(IProgressMonitor monitor) throws CoreException {
		this.progressMonitor = monitor;

		pushOperation(this);
		try {
			execute();
		} finally {
			monitor.done();
			popOperation();
		}
	}

	protected void execute() throws CoreException {
		if (target != null) {
			target.run(progressMonitor);
		}
	}

	private static void pushOperation(WorkspaceOperation operation) {
		Stack<WorkspaceOperation> stack = getCurrentOperationStack();
		stack.push(operation);
	}

	private static Stack<WorkspaceOperation> getCurrentOperationStack() {
		Stack<WorkspaceOperation> stack = operationStacks.get();
		if (stack == null) {
			stack = new Stack<WorkspaceOperation>();
			operationStacks.set(stack);
		}
		return stack;
	}

	private static WorkspaceOperation popOperation() {
		Stack<WorkspaceOperation> stack = operationStacks.get();
		WorkspaceOperation operation = stack.pop();
		if (stack.isEmpty()) {
			operationStacks.set(null);
		}
		return operation;
	}

	// *** monitor operations

	public void beginTask(String name, int totalWork) {
		progressMonitor.beginTask(name, totalWork);
	}

	public void done() {
		progressMonitor.done();
	}

	public void internalWorked(double work) {
		progressMonitor.internalWorked(work);
	}

	public boolean isCanceled() {
		return progressMonitor.isCanceled();
	}

	public void setCanceled(boolean value) {
		progressMonitor.setCanceled(value);
	}

	public void setTaskName(String name) {
		progressMonitor.setTaskName(name);
	}

	public void subTask(String name) {
		progressMonitor.subTask(name);
	}

	public void worked(int work) {
		progressMonitor.worked(work);
	}

	
	// *** Attributes
	
	/*
	 * Registers the given attribute at the given key with the top level operation.
	 */
	protected static void setAttribute(Object key, Object attribute) {
		Stack<WorkspaceOperation> stack = getCurrentOperationStack();
		if (stack.size() == 0)
			return;
		WorkspaceOperation top = stack.lastElement();
		if (top.attributes == null) {
			top.attributes = new HashMap<Object, Object>();
		}
		top.attributes.put(key, attribute);
	}

	
	// *** Helper operations

	protected IProgressMonitor getSubProgressMonitor(int workAmount) {
		IProgressMonitor sub = new SubProgressMonitor(progressMonitor,
				workAmount, SubProgressMonitor.PREPEND_MAIN_LABEL_TO_SUBTASK);
		return sub;
	}

	/**
	 * Convenience method to copy resources
	 */
	protected void copyResources(IResource[] resources, IPath destinationPath)
			throws CoreException {
		IProgressMonitor subProgressMonitor = getSubProgressMonitor(resources.length);
		IWorkspace workspace = resources[0].getWorkspace();

		workspace.copy(resources, destinationPath, false, subProgressMonitor);
		setAttribute(HAS_MODIFIED_RESOURCE_ATTR, TRUE);
	}

	/**
	 * Convenience method to create a file
	 */
	protected void createFile(IContainer folder, String name,
			InputStream contents, boolean forceFlag) throws CoreException {
		IFile file = folder.getFile(new Path(name));
		file.create(contents, forceFlag ? IResource.FORCE
				| IResource.KEEP_HISTORY : IResource.KEEP_HISTORY,
				getSubProgressMonitor(1));
		setAttribute(HAS_MODIFIED_RESOURCE_ATTR, TRUE);
	}

	/**
	 * Convenience method to create a folder
	 */
	protected void createFolder(IContainer parentFolder, String name,
			boolean forceFlag) throws CoreException {
		createFolder(parentFolder, new Path(name), forceFlag);
	}

	protected void createFolder(IContainer parentFolder, IPath name,
			boolean forceFlag) throws CoreException {
		IFolder folder = parentFolder.getFolder(name);
		// we should use true to create the file locally. Only VCM should
		// use true/false
		if(!folder.exists())
			folder.create(forceFlag ? IResource.FORCE | IResource.KEEP_HISTORY
					: IResource.KEEP_HISTORY, true, // local
					getSubProgressMonitor(1));
		setAttribute(HAS_MODIFIED_RESOURCE_ATTR, TRUE);
	}

	/**
	 * Convenience method to create a project
	 */
	protected void createProject(IProgressMonitor monitor, IProject project, IProjectDescription description) throws CoreException{
		project.create(description, monitor);
		setAttribute(HAS_MODIFIED_RESOURCE_ATTR, TRUE);
	}

}
