package com.nokia.tools.carbidect.cone.ui.internal.delegate;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;

import com.nokia.tools.carbidect.cone.core.ConeCore;
import com.nokia.tools.carbidect.cone.core.actions.IConeActionConfiguration;
import com.nokia.tools.carbidect.cone.core.actions.IGenerateAction;
import com.nokia.tools.carbidect.cone.ui.ConeUIPlugin;
import com.nokia.tools.carbidect.cone.ui.IConeConfigurationConstants;

public class Delegate implements ILaunchConfigurationDelegate {

	public void launch(ILaunchConfiguration configuration, String mode,
			ILaunch launch, IProgressMonitor monitor) throws CoreException {
		
		ConeUIPlugin plugin = ConeUIPlugin.getDefault();
		MessageConsole console = plugin.getConsole();
		console.activate();
		
		MessageConsoleStream stream = console.newMessageStream();
		IGenerateAction action = (IGenerateAction) ConeCore.getDefault().createConeAction(IGenerateAction.class);
		
		IConeActionConfiguration actionConfig = action.getActionConfigiration();
		setStorageAndConfiguration(actionConfig,configuration);
		setArguments(actionConfig,configuration);
		
		action.run(stream, monitor);

		try {
			stream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private void setArguments(IConeActionConfiguration actionConfig,
			ILaunchConfiguration configuration) {
		try {
			String args = configuration.getAttribute(IConeConfigurationConstants.ATTR_ARGUMENTS, "");
			actionConfig.addArgumentWithNoValue(args);
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	private void setStorageAndConfiguration(
			IConeActionConfiguration actionConfig,
			ILaunchConfiguration configuration) {
		try {
			String projectName = configuration.getAttribute(IConeConfigurationConstants.ATTR_PROJECT, "");
			String configName = configuration.getAttribute(IConeConfigurationConstants.ATTR_CONFIGURATION, "");
			IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
			IProject project = root.getProject(projectName);

			String projectLoc = project.getLocation().toOSString();
			actionConfig.setStorage(projectLoc);
			actionConfig.setConfiguration(configName);
			
			//target
			int target = configuration.getAttribute(
					IConeConfigurationConstants.ATTR_TARGET,
					IConeConfigurationConstants.ATTR_VALUE_DEFAULT_TARGET);
			actionConfig.setTarget(target);
			
			int layer =configuration.getAttribute(IConeConfigurationConstants.ATTR_LAYER, IConeConfigurationConstants.ATTR_VALUE_DEFAULT_LAYER);
			actionConfig.setLayer(layer);
			
			//verbose
			actionConfig.setVerbose(configuration.getAttribute(
					IConeConfigurationConstants.ATTR_VERBOSE,
					IConeConfigurationConstants.ATTR_VALUE_DEFAULT_VERBOSE));
			
			//output
			String output = configuration.getAttribute(
					IConeConfigurationConstants.ATTR_OUTPUT,
					IConeConfigurationConstants.ATTR_VALUE_DEFAULT_OUTPUT);
			File f = new File(output);
			if (f.isAbsolute()) {
				actionConfig.setOutput(f.getAbsolutePath());
			} else {
				actionConfig.setOutput(projectLoc
								+ File.separator + output);
			}

			//log file
			String log = configuration.getAttribute(
					IConeConfigurationConstants.ATTR_LOGFILE,
					IConeConfigurationConstants.ATTR_VALUE_DEFAULT_LOGFILE);
			f = new File(log);
			if (f.isAbsolute()) {
				actionConfig.setLog(f.getAbsolutePath());
			} else {
				actionConfig.setLog(projectLoc
						+ File.separator + log);
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

}
