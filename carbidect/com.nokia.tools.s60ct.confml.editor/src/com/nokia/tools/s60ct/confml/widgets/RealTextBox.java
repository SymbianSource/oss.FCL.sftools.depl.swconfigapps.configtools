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
package com.nokia.tools.s60ct.confml.widgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;

public class RealTextBox extends BaseTextBox {

	public RealTextBox(Composite parent, int style, String widgetLabel) {
		super(parent, style, widgetLabel);

	}
	
	public RealTextBox(Composite parent, int style, String widgetLabel,WidgetOptions options, Image image) {
		super(parent, style, widgetLabel,options,image);

	}

	
	protected void buildMainControl() {

		Composite controls = new Composite(group, SWT.NONE);
		controls.setBackground(new Color(group.getDisplay(), 255, 255, 255));
		GridLayout gridLayout = new GridLayout(2, false);
		gridLayout.horizontalSpacing = 0;
		gridLayout.verticalSpacing = 0;
		gridLayout.marginHeight = 0;
		gridLayout.marginWidth = 0;
		gridLayout.marginBottom = 0;
		gridLayout.marginTop = 0;
		gridLayout.marginRight = 0;
		controls.setLayout(gridLayout);
		controls.setLayoutData(layoutDataForGroup());
		text = new Text(controls, SWT.BORDER | SWT.RIGHT);
		GridData data = new GridData();
		text.setBackground(new Color(Display.getDefault(), 255, 255, 255));
		data.widthHint = 60;
		text.setLayoutData(data);
		
		text.addVerifyListener(new VerifyListener(){
			public void verifyText(VerifyEvent e)
			{
				// '-' can be entered only in zeroth index and only once
				String str = text.getText();
				int position = e.start;
				char c = e.character;
				if (Character.getType(c) == Character.CONTROL || c==SWT.DEL || c==SWT.BS)
				{
					e.doit=true;
				}
				else if(Character.isDigit(c)||"-".indexOf(c)!=-1)
				{
					if(str.indexOf("-")==-1 && position==0)
					{
						e.doit="-1234567890.".indexOf(c)!=-1;
					}
					else if(str.indexOf("-")!=-1 && position==0)
					{
						e.doit=false;
					}
					else
					{
						e.doit="1234567890".indexOf(c)!=-1;
					}
				}
				else if (Character.toString(c).equals(".") && str.indexOf(".") == -1 )
				{
					
					e.doit = true;
				}
				else
				{
					e.doit=false;
				}
			}
		});
		buildOptions(controls);
	}

	public void setValid(boolean isValid) {
		if (isValid)
			this.text.setBackground(GUIConstants.COLOR_WHITE);
		else
			this.text.setBackground(GUIConstants.COLOR_ERROROUS_RED);
		this.redraw();
	}

}
