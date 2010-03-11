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
package com.nokia.tools.carbide.ct.ui.refactoring.internal.wizards;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.ltk.ui.refactoring.UserInputWizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.nokia.tools.carbide.ct.ui.refactoring.CarbideRefactoringUIPlugin;

public class RenameConfmlInputPage extends UserInputWizardPage {
	private static final String PAGE_NAME = "Name"; 
	private static final String DS_KEY = "DS_KEY";
	private static final String DS_UPDATE_BUNDLE = "UPDATE_BUNDLE"; //$NON-NLS-1$
	private static final String DS_ALL_PROJECTS  = "ALL_PROJECTS"; //$NON-NLS-1$
		
	private IDialogSettings dialogSettings;
	private Text txtNewName;
	private IResource originalResource;
	private List<String> container_files = new ArrayList<String>();
	private String newName;
	
	public RenameConfmlInputPage(IResource resource) {
		super(PAGE_NAME);
		originalResource = resource;
		getContainerFiles(resource.getParent());
		initDialogSettings();
	}
	
	private void getContainerFiles(final IContainer res) {
		IResource[] members;
		try {
			members = res.members();
			for (int i = 0; i < members.length; i++) {
				IResource member = members[i];
				container_files.add(member.getName());
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	public void createControl( final Composite parent ) {
	    Composite composite = createRootComposite( parent );
	    setControl( composite );

	    createLblNewName( composite );
	    createTxtNewName( composite );	    
	    validate();
	  }

	  private Composite createRootComposite( final Composite parent ) {
	    Composite result = new Composite( parent, SWT.NONE );
	    GridLayout gridLayout = new GridLayout( 2, false );
	    gridLayout.marginWidth = 10;
	    gridLayout.marginHeight = 10;
	    result.setLayout( gridLayout );
	    initializeDialogUnits( result );
	    Dialog.applyDialogFont( result );
	    return result;
	  }
	  
	  private void createLblNewName( final Composite composite ) {
	    Label lblNewName = new Label( composite, SWT.NONE );
	    lblNewName.setText("New name:");
	  }

	  private void createTxtNewName(Composite composite) {
	    txtNewName = new Text( composite, SWT.BORDER );
	    txtNewName.setText(originalResource.getName());
	    txtNewName.setLayoutData( new GridData( GridData.FILL_HORIZONTAL ) );
	    txtNewName.selectAll();
	    txtNewName.addKeyListener( new KeyAdapter() {
	      public void keyReleased( final KeyEvent e ) {
	        validate();
	      }
	    } );
	  }

	  
	  private void initDialogSettings() {
	    IDialogSettings ds = CarbideRefactoringUIPlugin.getDefault().getDialogSettings();
	    dialogSettings = ds.getSection( DS_KEY );
	    if( dialogSettings == null ) {
	      dialogSettings = ds.addNewSection( DS_KEY );
	      // init default values
	      dialogSettings.put( DS_UPDATE_BUNDLE, true );
	      dialogSettings.put( DS_ALL_PROJECTS, false );
	    }
	  }
	  
	  private void validate() {
	    String txt = txtNewName.getText();
	    if(txt.length()>1) {
	    	if(!container_files.contains(txt)) {
	    		setNewName(txt);
	    		setPageComplete(true);	    		
	    	} else {
	    		setPageComplete(false);	    		
	    	}
	    } else {
	    	setPageComplete(false);
	    }
	  }

	private void setNewName(String newName) {
		this.newName = newName;
	}

	public String getNewName() {
		return newName;
	}
}
