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

import com.nokia.tools.vct.appshell.appshellmodel.EURLElement;

public class EURLElementTooltipFigure extends TooltipFigure {
	private Label urlLabel;

	public EURLElementTooltipFigure() {
		super("URL Element");
	}

	@Override
	protected void createGeneralSection(Panel panel, Font bold) {
		super.createGeneralSection(panel, bold);
		
		Label label;
		label = new Label("URL");
		panel.add(label);
		urlLabel = new Label("uid_value");
		panel.add(urlLabel);
	}
	
	@Override
	public void update(EObject model) {
		super.update(model);
		
		EURLElement elem = (EURLElement)model;
		urlLabel.setText(elem.getUrl());
	}
	
}
