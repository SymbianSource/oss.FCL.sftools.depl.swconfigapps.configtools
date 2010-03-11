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
 * Description: This file is part of com.nokia.tools.variant.viewer component.
 */

package com.nokia.tools.s60ct.confml.widgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Scrollable;
import org.eclipse.swt.widgets.Shell;
/**
 * Class serves for displaying error tool tip for the user.
 */
public class ToolTipWidget {


	public static Shell createNewToolTip(Scrollable textBox, 
			String message) {	
		final Shell errorToolTipContainer = buildErrorToolTipContainer(textBox);
		buildErrorMessageLabel(message, errorToolTipContainer);
		calculateLocationOfErrorToolTip(textBox, errorToolTipContainer, 0);
		return errorToolTipContainer;
	}
	
	


	private static Shell buildErrorToolTipContainer(Scrollable textBox) {
		Shell errorToolTip = new Shell(textBox.getShell(), SWT.ON_TOP
				| SWT.NO_FOCUS | SWT.TOOL);
		errorToolTip.setBackground(textBox.getDisplay().getSystemColor(
				SWT.COLOR_INFO_BACKGROUND));
		RowLayout layout = new RowLayout();
		errorToolTip.setLayout(layout);
		return errorToolTip;
	}

	public static void calculateLocationOfErrorToolTip(Scrollable textBox,
			Shell errorToolTipContainer, int location) {
		Point size = errorToolTipContainer
				.computeSize(SWT.DEFAULT, SWT.DEFAULT);
		Rectangle rect = textBox.getClientArea();
		Point pt = textBox.toDisplay(rect.x, rect.y);
		errorToolTipContainer.setBounds(pt.x + 25, pt.y + 25
				+location, size.x, size.y);
	}


	private static void buildErrorMessageLabel(String message,
			Shell errorToolTip) {
		Label textlabel = new Label(errorToolTip, SWT.NONE);
		textlabel.setForeground(errorToolTip.getDisplay().getSystemColor(
				SWT.COLOR_INFO_FOREGROUND));
		textlabel.setBackground(errorToolTip.getDisplay().getSystemColor(
				SWT.COLOR_INFO_BACKGROUND));
		textlabel.setText(message.replaceAll("&", "&&"));
	}


	
}
