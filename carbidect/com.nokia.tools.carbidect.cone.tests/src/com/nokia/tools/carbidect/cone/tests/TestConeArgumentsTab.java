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
package com.nokia.tools.carbidect.cone.tests;


import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Widget;

import abbot.swt.finder.WidgetFinder;
import abbot.swt.finder.generic.MultipleFoundException;
import abbot.swt.finder.generic.NotFoundException;
import abbot.swt.finder.matchers.WidgetClassMatcher;
import abbot.swt.finder.matchers.WidgetMatcher;
import abbot.swt.junit.extensions.SWTTestCase;
import abbot.swt.tester.ShellTester;
import abbot.swt.tester.TextTester;

import com.nokia.tools.carbidect.cone.ui.IConeConfigurationConstants;
import com.nokia.tools.carbidect.cone.ui.internal.dialogs.ConeArgumentsTab;

public class TestConeArgumentsTab extends SWTTestCase {

	private final String TITLE = "Sample shell";
	private Shell shell;
	private ConeArgumentsTab argsTab;

	private WidgetFinder finder = getFinder();
	private TextTester textTester = TextTester.getTextTester();
	
	private final String ENGINE_ARGS_TEXT = "arguments_text";
	
	private Text getTextWidget(final String textData) throws NotFoundException, 
	MultipleFoundException {
		WidgetMatcher matcher = new WidgetClassMatcher(
				Text.class) {
			public boolean matches(Widget widget) {
				return super.matches(widget)
				&& textData.equals(textTester
						.getData(widget));
			}
		};
		
		Widget text = finder.find(shell, matcher);
		return (Text) text;
	}

	public TestConeArgumentsTab(String name) {
		super(name);
	}
	
	@Override
	protected void setUp() throws Exception {	
		// Create & open a CelsiusConverter.
		getDisplay().syncExec(new Runnable() {
			public void run() {
			shell = new Shell(getDisplay());
			shell.setLayout(new GridLayout(1,true));
			shell.setText(TITLE);
			argsTab = new ConeArgumentsTab();
			argsTab.createControl(shell);
			displayShell();
			}
		});

		// Wait for it to open.
		ShellTester.waitVisible(TITLE);		
//		super.setUp();
	}
	
	
	@Override
	protected void tearDown() throws Exception {
		if (shell != null) {
			getDisplay().syncExec(new Runnable() {
				public void run() {
					shell.close();
				}
			});
			shell = null;
		}
	}
	
	public void testThatArgumentsControlIsCreated() throws Exception {
		Text text = getTextWidget(ENGINE_ARGS_TEXT);
		assertNotNull(text);
	}

	
	public void testInitializeFromAndPerformApply() throws Exception {
		ILaunchManager manager = DebugPlugin.getDefault().getLaunchManager();

		ILaunchConfigurationType type = manager
				.getLaunchConfigurationType(IConeConfigurationConstants.LAUNCH_CONFIGURATIONTYPE_ID);

		final ILaunchConfigurationWorkingCopy workingCopy = type.newInstance(
				null, "sample");
		String args = "--all-layers --imp-tag=target:uda";
		workingCopy.setAttribute(IConeConfigurationConstants.ATTR_ARGUMENTS,
				args);

		getDisplay().syncExec(new Runnable() {
			public void run() {
				argsTab.initializeFrom(workingCopy);
			}
		});
		
		Text text = getTextWidget(ENGINE_ARGS_TEXT);
		String content = textTester.getText(text);
		assertEquals(args, content);

		final ILaunchConfigurationWorkingCopy workingCopy2 = type.newInstance(
				null, "sample2");
		getDisplay().syncExec(new Runnable() {
			public void run() {
				argsTab.performApply(workingCopy2);
			}
		});

		assertEquals(args, workingCopy2.getAttribute(
				IConeConfigurationConstants.ATTR_ARGUMENTS, ""));
	}	
	
	private void displayShell() {
		shell.setSize(600, 500);
		shell.open();
//		while (!shell.isDisposed()) {
//			if (!getDisplay().readAndDispatch())
//				getDisplay().sleep();
//		}		
	}	
}
