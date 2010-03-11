package com.nokia.tools.carbidect.cone.ui.internal.dialogs;

import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.CommonTab;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;

public class LaunchConfigurationTabGroup extends
		AbstractLaunchConfigurationTabGroup {

	public LaunchConfigurationTabGroup() {}

	public void createTabs(ILaunchConfigurationDialog dialog, String mode) {
		ILaunchConfigurationTab[] tabs = new ILaunchConfigurationTab[] {
			new ConeMainTab(),
			new ConeArgumentsTab(),
			new CommonTab()
		};
		
		setTabs(tabs);
	}

}
