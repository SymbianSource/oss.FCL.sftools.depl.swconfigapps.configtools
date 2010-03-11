package com.nokia.tools.carbidect.cone.ui.internal.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import com.nokia.tools.carbidect.cone.ui.IConeConfigurationConstants;
import com.nokia.tools.variant.confml.core.ConfMLCore;
import com.nokia.tools.vct.common.appmodel.EConfigurationProject;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class GenerateHandler extends AbstractHandler {
	/**
	 * The constructor.
	 */
	public GenerateHandler() {
	}

	/**
	 * the command has been executed, so extract extract the needed information
	 * from the application context.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		
		if(selection instanceof IStructuredSelection) {
			IStructuredSelection ss = (IStructuredSelection) selection;
			Object element = ss.getFirstElement();
			IProject project = null;
			IFile configuration = null;
			
			if(element instanceof IFile) {
				configuration = (IFile) element;
				project = configuration.getProject();
				createAndRunConfiguration(project, configuration);
			} else if (element instanceof IProject) {
				project = (IProject) element;
				configuration = getActiveConfigurationRoot(project);
				createAndRunConfiguration(project, configuration);				
			} else{}
		}
		return null;
	}

	private IFile getActiveConfigurationRoot(IProject project) {
		EConfigurationProject model = ConfMLCore.getProjectModel(project);
		URI root = model.getRootConfml();
		return project.getFile(root.segment(root.segmentCount()-1));
	}

	private void createAndRunConfiguration(IProject project, IFile configuration) {
		if(project==null||configuration==null) {
			//report error
		}
		ILaunchConfiguration runLaunch = null;
		ILaunchManager manager = DebugPlugin.getDefault().getLaunchManager();
		
		ILaunchConfigurationType type = manager.getLaunchConfigurationType(IConeConfigurationConstants.LAUNCH_CONFIGURATIONTYPE_ID);
		try {
			ILaunchConfiguration[] launchConfigurations = manager.getLaunchConfigurations(type);
			ILaunchConfiguration lConfig = null;
			for (int i = 0; i < launchConfigurations.length; i++) {
				String a_p = launchConfigurations[i].getAttribute(IConeConfigurationConstants.ATTR_PROJECT, "");
				String a_c = launchConfigurations[i].getAttribute(IConeConfigurationConstants.ATTR_CONFIGURATION, "");
				if(project.getName().equals(a_p)&&configuration.getName().equals(a_c)) {
					lConfig = launchConfigurations[i];
					break;
				}
			}
			if(lConfig!=null) {
				runLaunch = lConfig; 
			} else {
				ILaunchConfigurationWorkingCopy workingCopy = createNewLaunchConfiguration(
						project, configuration, type);
				runLaunch = workingCopy;
			}
			launch(runLaunch);
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	private ILaunchConfigurationWorkingCopy createNewLaunchConfiguration(
			IProject project, IFile configuration, ILaunchConfigurationType type)
			throws CoreException {
		ILaunchConfigurationWorkingCopy workingCopy = type.newInstance(null, configuration.getName());
		workingCopy.setAttribute(IConeConfigurationConstants.ATTR_PROJECT, project.getName());
		workingCopy.setAttribute(IConeConfigurationConstants.ATTR_CONFIGURATION, configuration.getName());
		
		workingCopy.setAttribute(IConeConfigurationConstants.ATTR_OUTPUT,
				IConeConfigurationConstants.ATTR_VALUE_DEFAULT_OUTPUT);
		workingCopy.setAttribute(IConeConfigurationConstants.ATTR_LOGFILE,
				IConeConfigurationConstants.ATTR_VALUE_DEFAULT_LOGFILE);
		workingCopy.setAttribute(IConeConfigurationConstants.ATTR_VERBOSE,
				IConeConfigurationConstants.ATTR_VALUE_DEFAULT_VERBOSE);
		workingCopy.setAttribute(IConeConfigurationConstants.ATTR_TARGET,
				IConeConfigurationConstants.ATTR_VALUE_DEFAULT_TARGET);
		workingCopy.doSave();
		return workingCopy;
	}

	private void launch(ILaunchConfiguration runLaunch) {
//		ConeUIPlugin plugin = ConeUIPlugin.getDefault();
//		ConeBuilderJob job = new ConeBuilderJob("Generating target content ...", runLaunch);
//		job.setPriority(Job.LONG);
//		job.setUser(true);
//		job.setRule(plugin.getConeRule());
//		job.addJobChangeListener(new JobChangeAdapter() {
//
//			@Override
//			public void done(IJobChangeEvent event) {
//				refreshOutput();
//				Display display = window.getShell().getDisplay();
//				display.asyncExec(new Runnable() {
//
//					public void run() {
//						try {
//							if(outputFolder.isAccessible()) {
//								outputFolder.refreshLocal(IResource.DEPTH_INFINITE, null);									
//							}
//						} catch (CoreException e) {
//							e.printStackTrace();
//						}
//					}
//					
//				});
//			}
//			
//		});
//		prepareOutput(project);
//		if(verifyConePrefs(plugin)) {
//			job.schedule();					
//		}
//		job.schedule();
		DebugUITools.launch(runLaunch, "run");		
	}
}
