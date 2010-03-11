package com.nokia.tools.carbidect.cone.ui.internal.dialogs;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

import com.nokia.tools.carbidect.cone.ui.ConeUIPlugin;
import com.nokia.tools.carbidect.cone.ui.IConeConfigurationConstants;

public class ConeArgumentsTab extends AbstractLaunchConfigurationTab {
	
	private Text argumentsText;

	public void createControl(Composite parent) {
		Composite comp = new Composite(parent, SWT.NONE);
		setControl(comp);
		comp.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		comp.setLayout(new GridLayout(1, true));
		comp.setFont(parent.getFont());
		
		createArgumentsGroup(comp);
	}

	private void createArgumentsGroup(Composite comp) {
		Group group = new Group(comp,SWT.NONE);
		group.setText("Program Arguments");
		GridData layoutData = new GridData(GridData.FILL_HORIZONTAL);
		group.setLayoutData(layoutData);
		group.setLayout(new GridLayout(1,false));

		
		argumentsText = new Text(group,SWT.MULTI|SWT.BORDER|SWT.V_SCROLL|SWT.H_SCROLL);
		layoutData = new GridData(GridData.FILL_HORIZONTAL);
		layoutData.horizontalSpan = 4;
		layoutData.heightHint = 100;
		argumentsText.setLayoutData(layoutData);
		argumentsText.setData("arguments_text");
	}

	private String getArgumentsText() {
		return argumentsText.getText().trim();
	}

	
	public String getName() {
		return "Arguments";
	}

	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			argumentsText.setText(configuration.getAttribute(IConeConfigurationConstants.ATTR_ARGUMENTS, ""));
		} catch (CoreException e) {
			argumentsText.setText("");
		}
	}

	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(IConeConfigurationConstants.ATTR_ARGUMENTS, getArgumentsText());
	}

	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {}

	@Override
	public Image getImage() {
		ImageRegistry imageRegistry = ConeUIPlugin.getDefault().getImageRegistry();
		Image myImage = imageRegistry.get(ConeUIPlugin.IMAGE_ID_ARGUMENTS_TAB);
		return myImage;
	}
}
