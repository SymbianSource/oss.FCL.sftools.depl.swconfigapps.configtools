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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;

/**
 * Base class for natures
 * 
 */
public abstract class GenericNature implements IProjectNature {
	/** Nature's project */
	private IProject project;
	/** Nature name (ID) */
	private String natureName;
	/** Nature builder name (ID) */
	private List<String> builderNames;

	protected GenericNature(String natureName, String... builderNames) {
		this.natureName = natureName;
		this.builderNames = Arrays.asList(builderNames);
	}

	/**
	 * Get the builder name (ID)
	 * 
	 * @return Builder name
	 */
	protected final String[] getBuilderNames() {
		return builderNames.toArray(new String[builderNames.size()]);
	}

	/**
	 * Get this nature name (ID)
	 * 
	 * @return Nature name
	 */
	protected final String getNatureName() {
		return natureName;
	}

	/*
	 * @see IProjectNature#configure()
	 */
	public void configure() throws CoreException {
		configure(new NullProgressMonitor());
	}

	/**
	 * The sub-class shall override this method if the build command require
	 * command-specific parameters.
	 * 
	 * @param builderName
	 *            Builder name
	 * @param command
	 *            Command to configure
	 */
	protected void configureCommand(String builderName, ICommand command) {
		command.setBuilderName(builderName);
	}

	/*
	 * @see IProjectNature#deconfigure()
	 */
	public void deconfigure() throws CoreException {
		deconfigure(new NullProgressMonitor());
	}
	
	public void configure(IProgressMonitor monitor) throws CoreException {
		IProjectDescription description = getProject().getDescription();
		ICommand[] commands = description.getBuildSpec();
		ArrayList<ICommand> result = new ArrayList<ICommand>();
		for (ICommand command : commands) {
			if (!builderNames.contains(command.getBuilderName())) {
				result.add(command);
			}
		}
		for (String builderName : builderNames) {
			ICommand command = description.newCommand();
			configureCommand(builderName, command);
		}
		project.setDescription(description, monitor);
	}
	
	public void deconfigure(IProgressMonitor monitor) throws CoreException {
		IProjectDescription description = getProject().getDescription();
		ICommand[] commands = description.getBuildSpec();
		ArrayList<ICommand> result = new ArrayList<ICommand>();
		for (ICommand command : commands) {
			if (!builderNames.contains(command.getBuilderName())) {
				result.add(command);
			}
		}

		if (result.size() != commands.length) {
			description.setBuildSpec(result
					.toArray(new ICommand[result.size()]));
			getProject().setDescription(description, monitor);
		}
	}

	/*
	 * @see IProjectNature#getProject()
	 */
	public IProject getProject() {
		return project;
	}

	/*
	 * @see IProjectNature#setProject(IProject)
	 */
	public void setProject(IProject project) {
		this.project = project;
	}

	/**
	 * Toggles nature on a project.
	 * 
	 * @param project
	 *            to have nature added or removed
	 * @param natureId
	 *            Nature ID
	 * @param monitor
	 *            Progress monitor
	 * @throws CoreException
	 *             if project information can not be modified
	 */
	public static void toggleNature(IProject project, String natureId,
			IProgressMonitor monitor) throws CoreException {
		IProjectDescription description = project.getDescription();
		List<String> result = new ArrayList<String>();
		String natures[] = description.getNatureIds();
		boolean found = false;
		for (String nid : natures) {
			if (nid.equals(natureId)) {
				found = true;
			} else {
				result.add(nid);
			}
		}
		if (!found) {
			result.add(natureId);
		}
		description.setNatureIds(result.toArray(new String[result.size()]));
		project.setDescription(description, monitor);
	}

	/**
	 * Re-configure nature
	 * 
	 * @param project
	 * @param natureId
	 * @param monitor
	 * @throws CoreException
	 */
	public static void configureNature(IProject project, String natureId,
			IProgressMonitor monitor) throws CoreException {
		IProjectDescription description = project.getDescription();
		List<String> result = new ArrayList<String>();
		String natures[] = description.getNatureIds();
		for (String nid : natures) {
			if (!nid.equals(natureId)) {
				result.add(nid);
			}
		}
		result.add(natureId);
		description.setNatureIds(result.toArray(new String[result.size()]));
		project.setDescription(description, monitor);
	}
	
	public static void configureBuilder(IProject project, String builderName, IProgressMonitor monitor) throws CoreException {
		IProjectDescription description = project.getDescription();
		ICommand[] oldBuildSpec = description.getBuildSpec();
		for (int i = 0 ; i < oldBuildSpec.length ; i++) {
			if (oldBuildSpec[i].getBuilderName().equals(builderName)) {
				return;
			}
		}
		List<ICommand> newBuildSpec = new ArrayList<ICommand>();
		newBuildSpec.addAll(Arrays.asList(oldBuildSpec));
		
		// create new builder spec
		ICommand builderSpec = project.getDescription().newCommand();
		builderSpec.setBuilderName(builderName);

		newBuildSpec.add(builderSpec);
		description.setBuildSpec(newBuildSpec.toArray(new ICommand[newBuildSpec.size()]));
		project.setDescription(description, monitor);
	}

}
