package com.nokia.tools.carbidect.cone.ui.internal.dialogs;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ContainerSelectionDialog;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.model.BaseWorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;

import com.nokia.tools.carbidect.cone.core.ConeCore;
import com.nokia.tools.carbidect.cone.ui.ConeUIPlugin;
import com.nokia.tools.carbidect.cone.ui.IConeConfigurationConstants;
import com.nokia.tools.variant.confml.core.ConfMLCore;
import com.nokia.tools.vct.common.appmodel.EConfMLLayer;
import com.nokia.tools.vct.common.appmodel.EConfigurationProject;

public class ConeMainTab extends AbstractLaunchConfigurationTab {
	private class MainTabListener extends SelectionAdapter implements ModifyListener {

		/* (non-Javadoc)
		 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
		 */
		public void modifyText(ModifyEvent e) {
			updateLaunchConfigurationDialog();
		}
		
		/* (non-Javadoc)
		 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
		 */
		public void widgetSelected(SelectionEvent e) {
		}

	}
	
	private MainTabListener fListener= new MainTabListener();
	private Text textProject;
	private Text textConfiguration;
	private Button buttonDefaultEngine;
	private Button buttonCustomEngine;
	private Combo comboEngineSelection;
	private Text textOutput;
	private Text textLogfile;
	private Combo comboVerbose;
	private String selectedDir;
	private Combo comboTarget;
	private Combo comboLayer;
	
	public ConeMainTab() {}

	public void createControl(Composite parent) {
		Composite comp = new Composite(parent, SWT.NONE);
		setControl(comp);
		comp.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		comp.setLayout(new GridLayout(2, true));
		comp.setFont(parent.getFont());
		
		createStorageGroup(comp);
		createGenerationOptionsGroup(comp);
		createConfigurationEngineGroup(comp);
	}

	private void createGenerationOptionsGroup(Composite comp) {
		Group group = new Group(comp,SWT.NONE);
		group.setText("Generation options");
		GridData layoutData = new GridData(GridData.FILL_HORIZONTAL);
		layoutData.horizontalSpan = 2;
		
		group.setLayoutData(layoutData);
		
		group.setLayout(new GridLayout(3,false));

		//target
		Label label = new Label(group,SWT.NONE);
		label.setText("Target:");
		label.setData("target_label");
		
		comboTarget = new Combo(group,SWT.NONE);
		layoutData = new GridData();
		layoutData.horizontalSpan = 2;
		comboTarget.setLayoutData(layoutData);
		comboTarget.setData("target_combo");
		comboTarget.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) 
			{
				updateLaunchConfigurationDialog();
			}
		});
		populateTargets();
		
		
		Label layerLabel = new Label(group,SWT.NONE);
		layerLabel.setText("Layer:");
		layerLabel.setData("layer_label");
		
		comboLayer = new Combo(group,SWT.NONE);
		layoutData = new GridData(GridData.FILL_HORIZONTAL);
		layoutData.horizontalSpan = 2;
		comboLayer.setLayoutData(layoutData);
		comboLayer.setData("layer_combo");
		comboLayer.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) 
			{
				updateLaunchConfigurationDialog();
			}
		});
		
		populateLayers();
		
		// storage widgets
		label = new Label(group,SWT.NONE);
		label.setText("Output folder:");
		label.setData("output_label");
		
		textOutput = new Text(group,SWT.SINGLE|SWT.BORDER);
		layoutData = new GridData(GridData.FILL_HORIZONTAL);
		textOutput.setLayoutData(layoutData);
		textOutput.setData("output_text");
		
		Button button = new Button(group,SWT.PUSH);
		button.setText("Browse...");
		button.setData("output_browse");
		button.addSelectionListener(new SelectionAdapter() {


			@Override
			public void widgetSelected(SelectionEvent e) {
		        DirectoryDialog directoryDialog = new DirectoryDialog(getShell());
		        
		        directoryDialog.setFilterPath(selectedDir);
		        directoryDialog.setMessage("Please select a directory and click OK");
		        
		        String dir = directoryDialog.open();
		        if(dir != null) {
		        	textOutput.setText(dir);
		          selectedDir = dir;
		        }
			}
			
		});

		// storage widgets
		label = new Label(group,SWT.NONE);
		label.setText("Log file:");
		label.setData("logfile_label");
		
		textLogfile = new Text(group,SWT.SINGLE|SWT.BORDER);
		layoutData = new GridData(GridData.FILL_HORIZONTAL);
		textLogfile.setLayoutData(layoutData);
		textLogfile.setData("logfile_text");
		textLogfile.addSelectionListener(fListener);
		
		button = new Button(group,SWT.PUSH);
		button.setText("Browse...");
		button.setData("logfile_browse");
		
		label = new Label(group,SWT.NONE);
		label.setText("Verbose:");
		label.setData("verbose_label");
		
		comboVerbose = new Combo(group,SWT.NONE);
		layoutData = new GridData();
		layoutData.horizontalSpan = 2;
		comboVerbose.setLayoutData(layoutData);
		comboVerbose.setData("verbose_combo");
		
		populateVerboses();
	}

	private void populateTargets() {
		comboTarget.setItems(ConeCore.getConeTargetsList());
		comboTarget.select(IConeConfigurationConstants.ATTR_VALUE_DEFAULT_TARGET);
	}
	
	private void populateLayers() {
		
		IProject project = getProject();
		if (project==null)
			return;
		EConfigurationProject confProject = ConfMLCore.getProjectModel(project);
		if (confProject!=null)
		{
			EList<EConfMLLayer> layers = confProject.getLayers();
			
			String[] items = new String[layers.size()+1];
			
			items[0] = "All";
			int index = 1;
			for (int i = layers.size()-1 ; i >=0 ; i--)
			{
				if (i == layers.size()-1)
					items[index] = layers.get(i).getName()+" (latest)";
				else
					items[index] = layers.get(i).getName();
				index++;
			}
			
			comboLayer.setItems(items);
			comboLayer.select(IConeConfigurationConstants.ATTR_VALUE_DEFAULT_LAYER);
		}
		
	}

	private void populateVerboses() {
		comboVerbose.setItems(ConeCore.getConeVerboseList());
		comboVerbose.select(IConeConfigurationConstants.ATTR_VALUE_DEFAULT_VERBOSE);
	}

	private void createStorageGroup(Composite comp) {
		Group group = new Group(comp,SWT.NONE);
		group.setText("Storage");
		GridData layoutData = new GridData(GridData.FILL_HORIZONTAL);
		layoutData.horizontalSpan = 2;
		
		group.setLayoutData(layoutData);
		
		group.setLayout(new GridLayout(3,false));

		// storage widgets
		Label label = new Label(group,SWT.NONE);
		label.setText("Project:");
		label.setData("project_label");
		
		textProject = new Text(group,SWT.SINGLE|SWT.BORDER);
		layoutData = new GridData(GridData.FILL_HORIZONTAL);
		textProject.setLayoutData(layoutData);
		textProject.setData("project_text");
		textProject.addSelectionListener(fListener);
		
		Button button = new Button(group,SWT.PUSH);
		button.setText("Browse..");
		button.setData("project_browse");
		button.addSelectionListener(new SelectionAdapter() {


			@Override
			public void widgetSelected(SelectionEvent e) {
				ContainerSelectionDialog dialog = new ContainerSelectionDialog(getShell(), null, true, "Select a project:");
				dialog.setTitle("Select Project");
				
				if (dialog.open() == Window.OK) {
					Object[] selection = dialog.getResult();
					if(selection.length>0) {
						Object sel = selection[0];
						IPath path = (IPath) sel;
						String projectName = path.segment(0);
						setProject(projectName);
					}
				}
			}
			
		});			

		// storage widgets
		label = new Label(group,SWT.NONE);
		label.setText("Configuration:");
		label.setData("configuration_label");
		
		textConfiguration = new Text(group,SWT.SINGLE|SWT.BORDER);
		layoutData = new GridData(GridData.FILL_HORIZONTAL);
		textConfiguration.setLayoutData(layoutData);
		textConfiguration.setData("configuration_text");
		textConfiguration.addSelectionListener(fListener);
		
		button = new Button(group,SWT.PUSH);
		button.setText("Browse..");
		button.setData("configuration_browse");
		button.addSelectionListener(new SelectionAdapter() {


			@Override
			public void widgetSelected(SelectionEvent e) {
				
				
				ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(
						getShell(), new WorkbenchLabelProvider(),
						new BaseWorkbenchContentProvider());
				dialog.setTitle("ConfML file Selection");
				dialog.setMessage("Select ConfML file from the tree:");
				dialog.setInput(ResourcesPlugin.getWorkspace().getRoot());
				if (dialog.open() == Window.OK) {
					Object[] selection = dialog.getResult();
					if(selection.length>0) {
						Object sel = selection[0];
						if(sel instanceof IFile) {
							IFile file = (IFile) sel;
							textConfiguration.setText(file.getName());			
							updateLaunchConfigurationDialog();
						}
					}
				}
			}
			
		});			
		
	}
	
	protected IProject getProject()
	{
		String projectName = textProject.getText();
		System.out.println("project selected: "+projectName);
		if (projectName==null || projectName.equals(""))
			return null;
		return ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
	}

	protected void setProject(String projectName) {
		textProject.setText(projectName);
		System.out.println("setProject: "+projectName);
		populateLayers();
		updateLaunchConfigurationDialog();
		
	}

	private void createConfigurationEngineGroup(Composite comp) {
		Group group = new Group(comp,SWT.NONE);
		group.setText("Configuration Engine Executable");
		GridData layoutData = new GridData(GridData.FILL_HORIZONTAL);
		layoutData.horizontalSpan = 2;
		group.setLayoutData(layoutData);
		group.setLayout(new GridLayout(2,false));
		
		// default button
		buttonDefaultEngine = new Button(group,SWT.RADIO);
		buttonDefaultEngine.setText("Use default (Shipped with Carbide.ct)");
		buttonDefaultEngine.setData("engine_default");
		layoutData = new GridData(); 
		layoutData.horizontalSpan = 2;
		buttonDefaultEngine.setLayoutData(layoutData);
		buttonDefaultEngine.setSelection(true);
		buttonDefaultEngine.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				comboEngineSelection.setEnabled(false);
			}
		});
		
		
		// default button
		buttonCustomEngine = new Button(group,SWT.RADIO);
		buttonCustomEngine.setText("Use following:");
		buttonCustomEngine.setData("engine_custom");
		layoutData = new GridData(); 
		buttonCustomEngine.setLayoutData(layoutData);
		buttonCustomEngine.setSelection(false);
		buttonCustomEngine.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				comboEngineSelection.setEnabled(true);
			}
		});
		
		
		comboEngineSelection = new Combo(group,SWT.NONE);
		comboEngineSelection.setLayoutData(new GridData());
		comboEngineSelection.setData("engine_selection_combo");
		comboEngineSelection.setEnabled(false);
	}

	public String getName() {
		return "Main";
	}

	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			setProject(configuration.getAttribute(IConeConfigurationConstants.ATTR_PROJECT, ""));
		} catch (CoreException e) {
			textProject.setText("");
		}
		try {
			textConfiguration.setText(configuration.getAttribute(IConeConfigurationConstants.ATTR_CONFIGURATION, ""));
		} catch (CoreException e) {
			textConfiguration.setText("");
		}
		
		// generation options
		try {
			textOutput.setText(configuration.getAttribute(
					IConeConfigurationConstants.ATTR_OUTPUT,
					IConeConfigurationConstants.ATTR_VALUE_DEFAULT_OUTPUT));
		} catch (CoreException e) {
			textOutput.setText(IConeConfigurationConstants.ATTR_VALUE_DEFAULT_OUTPUT);
		}
		try {
			textLogfile.setText(configuration.getAttribute(
					IConeConfigurationConstants.ATTR_LOGFILE, 
					IConeConfigurationConstants.ATTR_VALUE_DEFAULT_LOGFILE));
		} catch (CoreException e) {
			textLogfile.setText(IConeConfigurationConstants.ATTR_VALUE_DEFAULT_LOGFILE);
		}
		try {
			int target = configuration.getAttribute(
					IConeConfigurationConstants.ATTR_TARGET,
					IConeConfigurationConstants.ATTR_VALUE_DEFAULT_TARGET);
			comboTarget.select(target);
		} catch (CoreException e) {
			comboTarget.select(IConeConfigurationConstants.ATTR_VALUE_DEFAULT_TARGET);
		}
		try {
			int verbose = configuration.getAttribute(
					IConeConfigurationConstants.ATTR_VERBOSE,
					IConeConfigurationConstants.ATTR_VALUE_DEFAULT_VERBOSE);
			comboVerbose.select(verbose);
		} catch (CoreException e) {
			comboVerbose.select(IConeConfigurationConstants.ATTR_VALUE_DEFAULT_VERBOSE);
		}
		
		//configuration engine
		try {
			String engine = configuration.getAttribute(IConeConfigurationConstants.ATTR_CONFIGURATION_ENGINE, "");
			if (engine.equals(IConeConfigurationConstants.ATTR_VALUE_CONFIGURATION_ENGINE_CUSTOM)) {
				buttonCustomEngine.setSelection(true);
				buttonDefaultEngine.setSelection(false);
			}
		} catch (CoreException e) {
			buttonDefaultEngine.setSelection(true);
			buttonCustomEngine.setSelection(false);
		}
	}

	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(IConeConfigurationConstants.ATTR_PROJECT, getProjectText());
		configuration.setAttribute(IConeConfigurationConstants.ATTR_CONFIGURATION, getConfigurationText());
		
		configuration.setAttribute(IConeConfigurationConstants.ATTR_OUTPUT, getOutputText());
		configuration.setAttribute(IConeConfigurationConstants.ATTR_LOGFILE, getLogfileText());
		configuration.setAttribute(IConeConfigurationConstants.ATTR_VERBOSE, getVerbose());
		configuration.setAttribute(IConeConfigurationConstants.ATTR_TARGET, getTarget());
		configuration.setAttribute(IConeConfigurationConstants.ATTR_LAYER, getLayer());
		configuration.setAttribute(IConeConfigurationConstants.ATTR_CONFIGURATION_ENGINE, getCone());
	}

	private String getCone() {
		if(buttonDefaultEngine.getSelection()) {
			return "";			
		} else {
			return IConeConfigurationConstants.ATTR_VALUE_CONFIGURATION_ENGINE_CUSTOM;
		}
	}

	private String getOutputText() {
		return textOutput.getText().trim();
	}
	
	private String getLogfileText() {
		return textLogfile.getText().trim();
	}
	
	private int getVerbose() {
		return comboVerbose.getSelectionIndex();
	}

	private int getTarget() {
		return comboTarget.getSelectionIndex();
	}
	
	private int getLayer() {
		int selectionIndex= comboLayer.getSelectionIndex();
		return -selectionIndex;
	}
	

	private String getProjectText() {
		return textProject.getText().trim();
	}

	private String getConfigurationText() {
		return textConfiguration.getText().trim();
	}

	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
	}

	@Override
	public Image getImage() {
		ImageRegistry imageRegistry = ConeUIPlugin.getDefault().getImageRegistry();
		Image myImage = imageRegistry.get(ConeUIPlugin.IMAGE_ID_MAIN_TAB);
		return myImage;
	}

	@Override
	public boolean isValid(ILaunchConfiguration launchConfig) {
	    setErrorMessage(null);
	    try {
	    	IProject project = getProject();
	    	if (!project.exists()) {
	    		setErrorMessage("Project: Doesn't exist!");
	    		return false;
			}
	    } catch(Exception e) {
	    	setErrorMessage("Project: Doesn't exist!");				
	        return false;
	    }
	    
	    try {
	    	IFile file = getProject().getFile(getConfigurationText());
	    	if (!file.exists()) {
	    		setErrorMessage("Configuration: Doesn't exist!");
	    		return false;
	    	}
	    } catch(NumberFormatException nfe) {
	    	setErrorMessage("Configuration: Doesn't exist!");
	        return false;
	    }
	    return true;
	}
}
