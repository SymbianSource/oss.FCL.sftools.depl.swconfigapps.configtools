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

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Scrollable;
import org.eclipse.swt.widgets.Shell;

public class ErrorToolTipWidget {

	private static final int ERRRO_TOOL_TIP_PADDING = 5;

	public static Shell createNewErrorToolTip(Scrollable textBox, 
			String message) {
		
	
		final Shell errorToolTipContainer = buildErrorToolTipContainer(textBox);
//		buildErrorImage(errorToolTipContainer);
		buildErrorMessageLabel(message, errorToolTipContainer);
		calculateLocationOfErrorToolTip(textBox, errorToolTipContainer);

	
//		ToolTipDisposer ttd = new ToolTipDisposer(errorToolTipContainer);
//		Display.getCurrent().timerExec(5000, ttd);
		return errorToolTipContainer;
	}
	
	private static void attachListener(Shell errorToolTipContainer) {
		Listener listener = listener(errorToolTipContainer);
		errorToolTipContainer.addListener(SWT.MouseExit, listener);
		errorToolTipContainer.addListener(SWT.MouseDown, listener);
	
	}

	private static Listener listener(final Shell errorToolTipContainer) {
		return new Listener() {

			public void handleEvent(Event event) {
				switch (event.type) {
				case SWT.MouseDown:
				case SWT.MouseExit:
				case SWT.MouseMove:
				case SWT.FocusOut:
					errorToolTipContainer.setVisible(false);
				}
			}

		};
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
			Shell errorToolTipContainer) {
		Point size = errorToolTipContainer
				.computeSize(SWT.DEFAULT, SWT.DEFAULT);
		Rectangle rect = textBox.getClientArea();
		Point pt = textBox.toDisplay(rect.x, rect.y);
		errorToolTipContainer.setBounds(pt.x + 15, pt.y + size.y
				- ERRRO_TOOL_TIP_PADDING, size.x, size.y);
	}


	private static void buildErrorMessageLabel(String message,
			Shell errorToolTip) {
		Label textlabel = new Label(errorToolTip, SWT.NONE);
		textlabel.setForeground(errorToolTip.getDisplay().getSystemColor(
				SWT.COLOR_INFO_FOREGROUND));
		textlabel.setBackground(errorToolTip.getDisplay().getSystemColor(
				SWT.COLOR_INFO_BACKGROUND));
		textlabel.setText(message);
	}

	private static void buildErrorImage(Shell errorToolTip) {
		Label imageLabel = new Label(errorToolTip, SWT.NONE);
		imageLabel.setForeground(errorToolTip.getDisplay().getSystemColor(
				SWT.COLOR_INFO_FOREGROUND));
		imageLabel.setBackground(errorToolTip.getDisplay().getSystemColor(
				SWT.COLOR_INFO_BACKGROUND));
		imageLabel.setImage(JFaceResources
				.getImage(Dialog.DLG_IMG_MESSAGE_ERROR));
	}

	private static void disposeOldToolTip(Shell tip) {
		if (null != tip)
			tip.dispose();
	}
	
	private static class ToolTipDisposer implements Runnable{

		Shell ttip;
		
		public ToolTipDisposer(Shell toolTip){
			this.ttip = toolTip;
		}
		
		public void run() {
			try{
				//Thread.sleep(5000);
				if(!ttip.isDisposed())
					ttip.dispose();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
