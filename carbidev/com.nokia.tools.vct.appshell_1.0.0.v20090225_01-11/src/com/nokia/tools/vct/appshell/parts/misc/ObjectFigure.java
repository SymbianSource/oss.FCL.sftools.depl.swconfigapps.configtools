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

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.jface.resource.FontRegistry;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;

public class ObjectFigure extends Figure {

	protected Label typeFigure;
	protected Label nameFigure;


	public ObjectFigure() {

		GridLayout layoutThis = new GridLayout(1, true);
		layoutThis.marginHeight = 5;
		layoutThis.marginWidth = 0;

		this.setLayoutManager(layoutThis);

		createContents();
	}

	/**
	 * @generated
	 */
	protected void createContents() {

		typeFigure = new Label();
		typeFigure.setText("short name");
		FontRegistry fr = new FontRegistry();
		Font bold = fr.getBold(JFaceResources.DEFAULT_FONT);
		typeFigure.setFont(bold);
		typeFigure.setLabelAlignment(PositionConstants.CENTER);
		
		this.add(typeFigure);
		GridData gd = new GridData(SWT.FILL, SWT.TOP, true, false);
		this.getLayoutManager().setConstraint(typeFigure, gd);
		

		nameFigure = new Label();
		nameFigure.setText("very long name 444 444");
		nameFigure.setLabelAlignment(PositionConstants.CENTER);

		this.add(nameFigure);
		gd = new GridData(SWT.FILL, SWT.TOP, true, false);
		this.getLayoutManager().setConstraint(nameFigure, gd);
	}

	public Label getTypeFigure() {
		return typeFigure;
	}
	public Label getNameFigure() {
		return nameFigure;
	}


}
