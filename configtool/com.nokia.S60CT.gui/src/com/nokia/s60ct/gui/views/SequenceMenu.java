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
package com.nokia.s60ct.gui.views;

import java.net.URL;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;

import s60ct.provider.SequenceMenuItemProvider;

import com.nokia.s60ct.gui.S60CtEditorPlugin;
import command.EmptySequenceCommand;
import command.RemoveFrameCommand;
import command.ShowDefaultCommand;

import configurationemf.ConfigurationemfPackage;
import configurationemf.EXTENSION_POLICY;
import configurationemf.Frame;
import configurationemf.LeafSettingDelegator;
import configurationemf.ParentSetting;
import configurationemf.TYPE;

//import com.nokia.s60ct.gui.actions.MoveDownFrameAction;
//import com.nokia.s60ct.gui.actions.MoveUpFrameAction;

public class SequenceMenu extends Composite{
	
	private Button buttonAdd=null;
	private Button buttonRemove=null;
	private Button buttonRemoveAll=null;
	
//	private Button moveUp = null;
//	private Button moveDown = null;
	
	private SettingEditorView view = null;
	
	private Button buttonExPolReplace=null;
	private Button buttonExPolPrefix=null;
	private Button buttonExPolAppend=null;
	private static final int REMOVE_OWN = 0;
	private static final int REMOVE_ALL = 1;

	private final URL ICON_ADD_ROW = (URL)S60CtEditorPlugin.INSTANCE.getImage("Add_Row_enabled");
	private final URL ICON_REMOVE_ROW = (URL)S60CtEditorPlugin.INSTANCE.getImage("Delete_Row_enabled");
	private final URL ICON_REMOVE_ALL = (URL)S60CtEditorPlugin.INSTANCE.getImage("Delete_enabled");
	private final URL ICON_SHOW_DEFAULT = (URL)S60CtEditorPlugin.INSTANCE.getImage("Default_Set_enabled");
	
	//private final URL ICON_UP = (URL)S60CtEditorPlugin.INSTANCE.getImage("sequence_up");
	//private final URL ICON_DOWN = (URL)S60CtEditorPlugin.INSTANCE.getImage("sequence_down");
	
	//Combo comboEP=null;
	
	//final static int NAME_INDEX = 0;
	//final static int POLICY_INDEX = 1;
	
	
	ParentSetting setting = null;
	Frame frame = null;
	SequenceMenuItemProvider itemProvider = new SequenceMenuItemProvider(null);
	
	protected int currentNumber = 1;
	protected int upNumber = 1;
	protected int downNumber = 1;
	//protected MoveDownFrameAction md = new MoveDownFrameAction();
	//protected MoveUpFrameAction mu = new MoveUpFrameAction();
	
	INotifyChangedListener itemChangeListener = new INotifyChangedListener(){
		public void notifyChanged(Notification notification) {
			//updateMenu();
		}
	};
	
	private final SelectionAdapter REMOVE_ALL_ADAPTER = new SelectionAdapter(){
		
		public void widgetSelected(SelectionEvent e) {
			
			if(itemProvider.isSequenceEmpty(setting)){
				EditingDomain domain =  AdapterFactoryEditingDomain.getEditingDomainFor(setting);
				Command command = itemProvider.createCommand(setting, domain, ShowDefaultCommand.class, 
						new CommandParameter(setting,ConfigurationemfPackage.eINSTANCE.getParentSetting_Frames(),null));
				domain.getCommandStack().execute(command);
				frame=null;
				updateMenu();
			}
			else
			{
				//open confirmation dialog when Remove All... button is clicked
				if (isDeveloperMode())
				{
					new DeveloperRemoveDialog();
				}
				else
				{
					new VariantEngineerRemoveDialog();
				}

			}
		}
	};
	
	private final SelectionAdapter SHOW_DEFAULT = new SelectionAdapter(){
		
	};
	
	
	public SequenceMenu(Composite parent, SettingEditorView view){
		super(parent,SWT.NONE);
		this.view = view;
		RowLayout rowLayout = new RowLayout();
		rowLayout.wrap= true;
		this.setLayout(rowLayout);
		createControl(this);
		itemProvider.addListener(itemChangeListener);
	}

	private void createControl(Composite menuComposite) {
		
		GridLayout buttonLayout = new GridLayout(3,true);
		GridLayout radioButtonLayout = new GridLayout(4,false);
		GridLayout layoutForGroup =new GridLayout(2,false);
		GridData buttonGridData = new GridData(SWT.FILL,SWT.NONE,false,false);
		buttonGridData.minimumWidth = 130;
		buttonGridData.widthHint = 150;
		
		
		GridLayout baseLayout =new GridLayout(1,false);
		baseLayout.marginLeft = -5; 
		baseLayout.marginRight = -5; //this removes the extra space around SS group.
		baseLayout.marginTop = -7;
		baseLayout.marginBottom = -5;
		
		menuComposite.setLayout(baseLayout);
		menuComposite.setLayoutData(new GridData(SWT.FILL,SWT.NONE,true,false));
		
		Group seqSettingGroup = new Group(menuComposite,SWT.NONE);
		seqSettingGroup.setText("Sequence Settings");
		seqSettingGroup.setLayout(layoutForGroup);
		seqSettingGroup.setLayoutData(new GridData(SWT.FILL,SWT.CENTER,true,false));
		
		Composite composite = new Composite(seqSettingGroup,SWT.NONE);
		composite.setLayout(buttonLayout);
		composite.setLayoutData(new GridData(SWT.FILL,SWT.CENTER,true,false));
		
		buttonAdd = new Button(composite,SWT.PUSH);
		buttonAdd.setText("Add Sequence");
		buttonAdd.setLayoutData(buttonGridData);
		buttonAdd.setImage(ImageDescriptor.createFromURL(ICON_ADD_ROW).createImage());
		buttonAdd.setEnabled(false);
		buttonAdd.pack();
		buttonAdd.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e) {
				EditingDomain domain =  AdapterFactoryEditingDomain.getEditingDomainFor(setting);
				Command command = itemProvider.createCommand(setting, domain, AddCommand.class, new CommandParameter(setting,ConfigurationemfPackage.eINSTANCE.getParentSetting_Frames(),null));
				domain.getCommandStack().execute(command);
				frame=null;
				updateMenu();
			}
		});
		buttonRemove = new Button(composite,SWT.PUSH);
		buttonRemove.setText("Remove Sequence");
		buttonRemove.setLayoutData(buttonGridData);
		buttonRemove.setImage(ImageDescriptor.createFromURL(ICON_REMOVE_ROW).createImage());
		buttonRemove.setEnabled(false);
		buttonRemove.pack();
		buttonRemove.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e) {
				EditingDomain domain =  AdapterFactoryEditingDomain.getEditingDomainFor(setting);
				Command command = itemProvider.createCommand(setting, domain, RemoveCommand.class, new CommandParameter(setting,ConfigurationemfPackage.eINSTANCE.getParentSetting_Frames(),frame));
				domain.getCommandStack().execute(command);
				frame=null;
				updateMenu();
			}
		});
		
		buttonRemoveAll = new Button(composite,SWT.PUSH);
		buttonRemoveAll.setText("Remove All...");
		buttonRemoveAll.setLayoutData(buttonGridData);
		buttonRemoveAll.setImage(ImageDescriptor.createFromURL(ICON_REMOVE_ALL).createImage());
		buttonRemoveAll.setEnabled(false);
		buttonRemoveAll.pack();
		buttonRemoveAll.addSelectionListener(REMOVE_ALL_ADAPTER);
		
		/*
		moveUp = new Button(composite,SWT.PUSH);
		moveUp.setText("Up");
		moveUp.setLayoutData(buttonGridData);
		moveUp.setEnabled(false);
		moveUp.pack();
		moveUp.addSelectionListener(mu);
		
		moveDown = new Button(composite,SWT.PUSH);
		moveDown.setText("Down");
		moveDown.setLayoutData(buttonGridData);
		moveDown.setEnabled(false);
		moveDown.pack();
		moveDown.addSelectionListener(md);
		*/
		Composite radioButtoncomposite = new Composite(seqSettingGroup,SWT.NONE);
		radioButtoncomposite.setLayout(radioButtonLayout);
		radioButtoncomposite.setLayoutData(new GridData(SWT.RIGHT,SWT.CENTER,true,false));
		
		Label label2 = new Label(radioButtoncomposite,SWT.NONE);
		label2.setText("Extension Policy:");
		
		
		buttonExPolReplace = new Button(radioButtoncomposite,SWT.RADIO);
		buttonExPolReplace.setText("Replace");
		buttonExPolReplace.setEnabled(false);
		buttonExPolReplace.pack();
		buttonExPolReplace.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e) {
				setting.setCurrentExtensionPolicy(EXTENSION_POLICY.REPLACE);
				updateMenu();
			}
		});
		
		buttonExPolAppend = new Button(radioButtoncomposite,SWT.RADIO);
		buttonExPolAppend.setText("Append");
		buttonExPolAppend.setEnabled(false);
		buttonExPolAppend.pack();
		buttonExPolAppend.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e) {
				setting.setCurrentExtensionPolicy(EXTENSION_POLICY.APPEND);
				updateMenu();
			}
		});
		
		buttonExPolPrefix = new Button(radioButtoncomposite,SWT.RADIO);
		buttonExPolPrefix.setText("Prefix");
		buttonExPolPrefix.setEnabled(false);
		buttonExPolPrefix.pack();
		buttonExPolPrefix.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e) {
				setting.setCurrentExtensionPolicy(EXTENSION_POLICY.PREFIX);
				updateMenu();
			}
		});
		
		buttonExPolAppend.setSelection(true);
		
	}
	
	public void setSetting(Object object){
		
		
		boolean enabled = false;
		ParentSetting setting = null;
		if(object instanceof ParentSetting)
		{
			setting=(ParentSetting)object;
			this.frame=null;
		}
		else if(object instanceof Frame)
		{
			this.frame = (Frame)object;
			setting=(ParentSetting)frame.eContainer();
			if (!frame.isTemplate() ) // So it's an instance of template
			{
				/*
				if ( frame.getNumber() == 1 && setting.getFrames().size() > 1 )
				{
					md.setFrame(frame);
					this.enableDown();
					this.disableUp();
				}
				else if (frame.getNumber() == setting.getFrames().size() )
				{
					mu.setFrame(frame);
					this.enableUp();
					this.disableDown();
				}
				else if (setting.getFrames().size() == 1)
				{
					this.disableUp();
					this.disableDown();
				}
			    
				else
				{
					md.setFrame(frame);
					mu.setFrame(frame);
					this.enableDown();
					this.enableUp();
				}
				
				enabled = true;
				*/
			}
		}
		else if(object instanceof LeafSettingDelegator)
		{
			this.frame=(Frame)((LeafSettingDelegator)object).eContainer();
			if(frame!=null)setting=(ParentSetting)frame.eContainer();

		}
		/*
		if (!enabled)
		{
			this.disableDown();
			this.disableUp();
		}
		*/
		changeSetting(setting);
	}

	private void changeSetting(ParentSetting setting){
		if(setting!=null&&setting.getType()==TYPE.SEQUENCE){
			if(!setting.equals(this.setting)){
				connectSetting(setting);
			}
		}else{
			disconnectSetting();
		}
		updateMenu();
	}
	
	private void disableMenu(){
		buttonAdd.setEnabled(false);
		buttonRemove.setEnabled(false);
		buttonRemoveAll.setEnabled(false);
		buttonExPolAppend.setEnabled(false);
		buttonExPolPrefix.setEnabled(false);
		buttonExPolReplace.setEnabled(false);
	}
	/*
	public void disableUp()
	{
		moveUp.setEnabled(false);
	}
	
	public void enableUp()
	{
		moveUp.setEnabled(true);
	}

	public void disableDown()
	{
		moveDown.setEnabled(false);
	}
	
	public void enableDown()
	{
		moveDown.setEnabled(true);
	}
	*/
	
	private void updateMenu(){
		if(setting==null) disableMenu();
		else{
			buttonAdd.setEnabled(itemProvider.isAddAllowed(setting));
			buttonRemove.setEnabled(itemProvider.isRemoveItemAllowed(setting, frame));
			if(itemProvider.isSequenceEmpty(setting)){
				buttonRemoveAll.setText("Show Default");
				buttonRemoveAll.setImage(ImageDescriptor.createFromURL(ICON_SHOW_DEFAULT).createImage());
				buttonRemoveAll.setEnabled(true);
			}else{
				buttonRemoveAll.setText("Remove All...");
				buttonRemoveAll.setImage(ImageDescriptor.createFromURL(ICON_REMOVE_ALL).createImage());
				buttonRemoveAll.setEnabled(true);
			}
			
			if (isDeveloperMode())
			{
				buttonExPolPrefix.setEnabled(false);
				buttonExPolReplace.setEnabled(false);
				buttonExPolAppend.setEnabled(false);
			}
			else
			{
				buttonExPolAppend.setEnabled(itemProvider.isAllowedPolicy(setting, EXTENSION_POLICY.APPEND));
				buttonExPolPrefix.setEnabled(itemProvider.isAllowedPolicy(setting, EXTENSION_POLICY.PREFIX));
				buttonExPolReplace.setEnabled(itemProvider.isAllowedPolicy(setting, EXTENSION_POLICY.REPLACE));
			}
			EXTENSION_POLICY ep = itemProvider.getExtensionPolicy(setting);
			switch (ep.getValue())
			{
				case EXTENSION_POLICY.APPEND_VALUE: 	buttonExPolReplace.setSelection(false);
														buttonExPolPrefix.setSelection(false);
														buttonExPolAppend.setSelection(true); break;
				
				
				case EXTENSION_POLICY.PREFIX_VALUE: 	buttonExPolReplace.setSelection(false);
														buttonExPolPrefix.setSelection(true);
														buttonExPolAppend.setSelection(false); break;
				
				
				case EXTENSION_POLICY.REPLACE_VALUE: 	buttonExPolReplace.setSelection(true);
														buttonExPolPrefix.setSelection(false);
														buttonExPolAppend.setSelection(false); break;
				
				
				case EXTENSION_POLICY.NO_POLICY_VALUE:	buttonExPolReplace.setSelection(false);
														buttonExPolPrefix.setSelection(false);
														buttonExPolAppend.setSelection(true);
														setting.setCurrentExtensionPolicy(EXTENSION_POLICY.APPEND); break;
			}
		}
		view.updateView();
	}

	private void connectSetting(ParentSetting setting){
		disconnectSetting();
		this.setting=setting;
		this.setting.eAdapters().add(itemProvider);

	}
	
	private void disconnectSetting(){
		if(this.setting!=null)setting.eAdapters().remove(itemProvider);
		this.setting=null;
		this.frame=null;
	}
	
	private void makeEmpty()
	{
		EditingDomain domain =  AdapterFactoryEditingDomain.getEditingDomainFor(setting);
		Command command = itemProvider.createCommand(setting, domain, EmptySequenceCommand.class, 
				new CommandParameter(setting,ConfigurationemfPackage.eINSTANCE.getParentSetting_Frames(),null));
		domain.getCommandStack().execute(command);
		frame=null;
		updateMenu();
	}
	
	private void removeOwn()
	{
		EditingDomain domain =  AdapterFactoryEditingDomain.getEditingDomainFor(setting);
		Command command = itemProvider.createCommand(setting, domain, RemoveFrameCommand.class,
				new CommandParameter(setting,ConfigurationemfPackage.eINSTANCE.getParentSetting_Frames(),null));
		domain.getCommandStack().execute(command);
		frame=null;
		updateMenu();
	}
	
	private boolean isDeveloperMode()
	{
		if (setting.getDefaultConf().equals(setting.getCurrentConf()))
			return true;
		else
			return false;
	}
	
	
	private class VariantEngineerRemoveDialog extends MessageDialog
	{					
		boolean removeOwnSelected = true;
		
		public VariantEngineerRemoveDialog()
		{
			super(null, "Remove All...", null, "Select what do you want to remove", MessageDialog.QUESTION, new String[]{"Remove", "Cancel"}, 2);
			this.setBlockOnOpen(true);
			int rValue = this.open();
			if (rValue == REMOVE_OWN)
			{
				removeOwn();
			}
			else if (rValue == REMOVE_ALL)
			{
				makeEmpty();
			}
		}

		protected Control createCustomArea(Composite parent)
		{
			Composite buttonComposite = new Composite(parent,SWT.NONE);
			
			GridLayout buttonLayout =new GridLayout(1,false);
			buttonLayout.marginLeft = 40;
			buttonComposite.setLayout(buttonLayout);
			
			Button radioButton1 = new Button(buttonComposite,SWT.RADIO);
			radioButton1.setText("Remove only own sequences and leave based on sequences ");
			radioButton1.addSelectionListener(new SelectionAdapter()
			{
				public void widgetSelected(SelectionEvent e) 
				{
					removeOwnSelected = true;
				}
			});
			radioButton1.pack();
			
			Button radioButton2 = new Button(buttonComposite,SWT.RADIO);
			radioButton2.setText("Remove both own and based on sequences");
			radioButton2.addSelectionListener(new SelectionAdapter()
			{
				public void widgetSelected(SelectionEvent e) 
				{
					removeOwnSelected = false;
				}
			});
			radioButton2.pack();
			
			return buttonComposite;
		}
		
		public int open()
		{
			int rValue = super.open();
			if (rValue == 0) //remove clicked
			{
				if (removeOwnSelected)//radiobuttons cannot be accessed now since they are already disposed 
					return REMOVE_OWN;
				else
					return REMOVE_ALL;
			}
			else if (rValue == 1) //cancel clicked
			{
				return -1;
			}
			return -1;
		}
	}
	
	private class DeveloperRemoveDialog extends MessageDialog
	{					
		boolean removeOwnSelected = true;
		
		public DeveloperRemoveDialog()
		{
			super(null, "Remove All...", null, "Remove all sequences?\n\nThe template will not be removed.", MessageDialog.QUESTION, new String[]{"OK", "Cancel"}, 2);
			this.setBlockOnOpen(true);
			int rValue = this.open();
			if (rValue == 0)
			{
				removeOwn();
			}
			//else do nothing
		}
	}
	
	
}



