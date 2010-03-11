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
 * Description: This file is part of com.nokia.tools.vct.appshell component.
 */

package com.nokia.tools.vct.appshell.parts.misc;

import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.Panel;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.graphics.Font;

import com.nokia.tools.vct.appshell.appshellmodel.EFolderElement;

public class EFolderElementTooltipFigure extends TooltipFigure {
	private Label applicationGroupNameLabel;
	private Label defaultFlag;

	public EFolderElementTooltipFigure() {
		super("Folder Element");
	}

	@Override
	protected void createGeneralSection(Panel panel, Font bold) {
		super.createGeneralSection(panel, bold);
		
		Label label;
		label = new Label("Application Group Name");
		panel.add(label);
		applicationGroupNameLabel = new Label("uid_value");
		panel.add(applicationGroupNameLabel);
		label = new Label("Default Flag");
		panel.add(label);
		defaultFlag = new Label("Default Flag");
		panel.add(defaultFlag);
	}
	
	@Override
	public void update(EObject model) {
		super.update(model);
		
		EFolderElement elem = (EFolderElement)model;
		applicationGroupNameLabel.setText(elem.getApplicationGroupName());
		defaultFlag.setText(convert(elem.getDefault()));
	}
	
}
