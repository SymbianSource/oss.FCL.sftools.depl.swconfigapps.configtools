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
package views;

import org.eclipse.jface.viewers.ColumnPixelData;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.swt.widgets.Composite;


public class CustomProblemsView extends org.eclipse.ui.views.markers.internal.ProblemView{

	public final static String ID = "org.eclipse.ui.views.ProblemView"; 
	//same ID as the original. Replaces totally the build-in problems view.

	public CustomProblemsView()
	{
		super();
	}

	@Override
	public void createPartControl(Composite parent) {
		super.createPartControl(parent);
		
		TableLayout layout = new TableLayout();
		getViewer().getTree().setLayout(layout);

		ColumnPixelData[] layoutData = getDefaultColumnLayouts();
		
		layoutData[0].resizable = true;
		layoutData[0].width = 600;
		layoutData[0].addTrim = false;
		
		layoutData[1].resizable = true;
		layoutData[1].width = 150;
		layoutData[1].addTrim = false;
		
		layoutData[2].resizable = false; //hide "Path" column
		layoutData[2].width = 0;
		layoutData[2].addTrim = false;
		
		layoutData[3].resizable = true;
		layoutData[3].width = 300;
		layoutData[3].addTrim = false;
		
		layoutData[4].resizable = false;
		layoutData[4].width = 0;
		layoutData[4].addTrim = false;
		
		for (int i = 0; i < layoutData.length; i++) {
			layout.addColumnData(layoutData[i]);

		}
		getViewer().getTree().layout(true);
		
	}

}
