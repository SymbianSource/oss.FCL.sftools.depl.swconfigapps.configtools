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
 * Description: This file is part of com.nokia.tools.vct.common.ui component.
 */

package com.nokia.tools.vct.common.ui.dialogs;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

public class SimpleDialogWindow extends Dialog {
	
	final int MARGIN = 10;
	
	String title = null;
	Shell shell = null;
	Composite parent = null;
		
	public SimpleDialogWindow(Shell parent, String title) {
		super(parent);
		setBlockOnOpen(true);
		this.title = title;
	}

    /* (non-Javadoc)
     * Method declared in Window.
     */
    protected void configureShell(Shell shell) {
        super.configureShell(shell);
        this.shell = shell;
        if(title != null)
        	shell.setText(title);
       
//        PlatformUI.getWorkbench().getHelpSystem().setHelp(shell,
//				IWorkbenchHelpContextIds.SAVE_PERSPECTIVE_DIALOG);
       
        setShellStyle(getShellStyle() | SWT.RESIZE);
        
    }
    
    @Override
	protected Control createContents(Composite parent) {
		
		return super.createContents(parent);
	}
    
    protected int getShellStyle() {
        return super.getShellStyle() | SWT.RESIZE;
    }
    
    
	@Override
	protected Control createDialogArea(Composite parent) {
		this.parent = parent;
		Composite comp = (Composite) super.createDialogArea(parent);
		
		GridLayout glayout = new GridLayout();
		glayout.marginTop = MARGIN;
		glayout.marginLeft = MARGIN;
		glayout.marginRight = MARGIN;

		comp.setLayout(glayout);
		
		return comp;
	}
	
}
