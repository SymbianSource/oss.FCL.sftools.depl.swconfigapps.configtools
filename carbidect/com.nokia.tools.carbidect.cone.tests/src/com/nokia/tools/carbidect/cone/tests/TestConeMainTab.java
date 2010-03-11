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
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Widget;

import abbot.swt.finder.WidgetFinder;
import abbot.swt.finder.generic.MultipleFoundException;
import abbot.swt.finder.generic.NotFoundException;
import abbot.swt.finder.matchers.WidgetClassMatcher;
import abbot.swt.finder.matchers.WidgetMatcher;
import abbot.swt.junit.extensions.SWTTestCase;
import abbot.swt.tester.ButtonTester;
import abbot.swt.tester.ComboTester;
import abbot.swt.tester.LabelTester;
import abbot.swt.tester.ShellTester;
import abbot.swt.tester.TextTester;

import com.nokia.tools.carbidect.cone.ui.IConeConfigurationConstants;
import com.nokia.tools.carbidect.cone.ui.internal.dialogs.ConeMainTab;

public class TestConeMainTab extends SWTTestCase {

	private final String TITLE = "Sample shell";
	private Shell shell;
	private ConeMainTab mainTab;

	private WidgetFinder finder = getFinder();
	private LabelTester labelTester = LabelTester.getLabelTester();
	private TextTester textTester = TextTester.getTextTester();
	private ButtonTester buttonTester = ButtonTester.getButtonTester();
	private ComboTester comboTester = ComboTester.getComboTester();
	private final String PROJECT_TEXT = "project_text";
	private final String CONFIGURATION_TEXT = "configuration_text";

	
	private final String OUTPUT_TEXT = "output_text";
	private final String LOGFILE_TEXT = "logfile_text";
	private final String VERBOSE_COMBO = "verbose_combo";

	private final String ENGINE_DEFAULT_BUTTON = "engine_default";
	private final String ENGINE_CUSTOM_BUTTON = "engine_custom";
	private final String ENGINE_SELECTION_COMBO = "engine_selection_combo";

	private Label getLabelWidget(final String labelData)
			throws NotFoundException, MultipleFoundException {
		WidgetMatcher matcher = new WidgetClassMatcher(Label.class) {
			public boolean matches(Widget widget) {
				Object data = labelTester.getData(widget);
				return super.matches(widget) && labelData.equals(data);
			}
		};

		Widget label = finder.find(shell, matcher);
		return (Label) label;
	}

	private Text getTextWidget(final String textData) throws NotFoundException,
			MultipleFoundException {
		WidgetMatcher matcher = new WidgetClassMatcher(Text.class) {
			public boolean matches(Widget widget) {
				return super.matches(widget)
						&& textData.equals(textTester.getData(widget));
			}
		};

		Widget text = finder.find(shell, matcher);
		return (Text) text;
	}

	private Button getButtonWidget(final String buttonData)
			throws NotFoundException, MultipleFoundException {
		WidgetMatcher matcher = new WidgetClassMatcher(Button.class) {
			public boolean matches(Widget widget) {
				return super.matches(widget)
						&& buttonData.equals(buttonTester.getData(widget));
			}
		};

		Widget text = finder.find(shell, matcher);
		return (Button) text;
	}

	private Combo getComboWidget(final String data) throws NotFoundException,
			MultipleFoundException {
		WidgetMatcher matcher = new WidgetClassMatcher(Combo.class) {
			public boolean matches(Widget widget) {
				return super.matches(widget)
						&& data.equals(comboTester.getData(widget));
			}
		};

		Widget text = finder.find(shell, matcher);
		return (Combo) text;
	}

	public TestConeMainTab(String name) {
		super(name);
	}

	@Override
	protected void setUp() throws Exception {
		// Create & open a CelsiusConverter.
		getDisplay().syncExec(new Runnable() {
			public void run() {
				shell = new Shell(getDisplay());
				shell.setLayout(new GridLayout(1, true));
				shell.setText(TITLE);
				mainTab = new ConeMainTab();
				mainTab.createControl(shell);
				displayShell();
			}
		});

		// Wait for it to open.
		ShellTester.waitVisible(TITLE);
		// super.setUp();
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

	private Text getProjectText() throws NotFoundException,
			MultipleFoundException {
		return getTextWidget(PROJECT_TEXT);
	}

	private Text getConfigurationText() throws NotFoundException,
			MultipleFoundException {
		return getTextWidget(CONFIGURATION_TEXT);
	}

	private String getTextText(Text text) {
		return textTester.getText(text);
	}

	public void testThatProjectSelectionControlsAreCreated() throws Exception {
		Label label = getLabelWidget("project_label");
		assertNotNull(label);
		Text text = getProjectText();
		assertNotNull(text);
		Button button = getButtonWidget("project_browse");
		assertNotNull(button);
	}

	public void testThatConfigurationSelectionControlsAreCreated()
			throws Exception {
		Label label = getLabelWidget("configuration_label");
		assertNotNull(label);
		Text text = getConfigurationText();
		assertNotNull(text);
		Button button = getButtonWidget("configuration_browse");
		assertNotNull(button);
	}

	public void testThatGenerationOptionsControlsAreCreated()
	throws Exception {
		Text text = getTextWidget(OUTPUT_TEXT);
		assertNotNull(text);
		Combo combo = getComboWidget(VERBOSE_COMBO);
		assertNotNull(combo);
		text = getTextWidget(LOGFILE_TEXT);
		assertNotNull(text);
	}
	
	public void testThatConfigurationEngineControlsAreCreated()
			throws Exception {
		Button button = getButtonWidget("engine_default");
		assertNotNull(button);
		boolean selection = buttonTester.getSelection(button);
		assertTrue("(Use default) button is not selected!", selection);

		button = getButtonWidget(ENGINE_CUSTOM_BUTTON);
		assertNotNull(button);

		Combo combo = getComboWidget("engine_selection_combo");
		assertNotNull(combo);
	}

	public void testInitializeFromAndPerformApply() throws Exception {
		ILaunchManager manager = DebugPlugin.getDefault().getLaunchManager();

		ILaunchConfigurationType type = manager
				.getLaunchConfigurationType(IConeConfigurationConstants.LAUNCH_CONFIGURATIONTYPE_ID);

		final ILaunchConfigurationWorkingCopy workingCopy = type.newInstance(
				null, "sample");
		String project = "sample_project";
		String configuration = "sample_configuration";
		workingCopy.setAttribute(IConeConfigurationConstants.ATTR_PROJECT,
				project);
		workingCopy.setAttribute(
				IConeConfigurationConstants.ATTR_CONFIGURATION, configuration);
		
		workingCopy
				.setAttribute(
						IConeConfigurationConstants.ATTR_CONFIGURATION_ENGINE,
						IConeConfigurationConstants.ATTR_VALUE_CONFIGURATION_ENGINE_CUSTOM);
		workingCopy
		.setAttribute(
				IConeConfigurationConstants.ATTR_OUTPUT,
				IConeConfigurationConstants.ATTR_VALUE_DEFAULT_OUTPUT);
		workingCopy
		.setAttribute(
				IConeConfigurationConstants.ATTR_LOGFILE,
				IConeConfigurationConstants.ATTR_VALUE_DEFAULT_LOGFILE);

		workingCopy
		.setAttribute(
				IConeConfigurationConstants.ATTR_VERBOSE,
				IConeConfigurationConstants.ATTR_VALUE_DEFAULT_VERBOSE);

		getDisplay().syncExec(new Runnable() {
			public void run() {
				mainTab.initializeFrom(workingCopy);
			}
		});

		assertEquals(project, getTextText(getProjectText()));
		assertEquals(configuration, getTextText(getConfigurationText()));

		Button button = getButtonWidget(ENGINE_CUSTOM_BUTTON);
		boolean selection = buttonTester.getSelection(button);
		assertTrue("(Use following) button is not selected!", selection);

		final ILaunchConfigurationWorkingCopy workingCopy2 = type.newInstance(
				null, "sample2");
		getDisplay().syncExec(new Runnable() {
			public void run() {
				mainTab.performApply(workingCopy2);
			}
		});

		assertEquals(project, workingCopy2.getAttribute(
				IConeConfigurationConstants.ATTR_PROJECT, ""));
		assertEquals(configuration, workingCopy2.getAttribute(
				IConeConfigurationConstants.ATTR_CONFIGURATION, ""));
		assertEquals(
				IConeConfigurationConstants.ATTR_VALUE_CONFIGURATION_ENGINE_CUSTOM,
				workingCopy2.getAttribute(
						IConeConfigurationConstants.ATTR_CONFIGURATION_ENGINE,
						""));
		
		//assert generation options
		assertEquals(
				IConeConfigurationConstants.ATTR_VALUE_DEFAULT_OUTPUT,
				workingCopy2.getAttribute(
						IConeConfigurationConstants.ATTR_OUTPUT,
				""));
		assertEquals(
				IConeConfigurationConstants.ATTR_VALUE_DEFAULT_LOGFILE,
				workingCopy2.getAttribute(
						IConeConfigurationConstants.ATTR_LOGFILE,
				""));
		assertEquals(
				IConeConfigurationConstants.ATTR_VALUE_DEFAULT_VERBOSE,
				workingCopy2.getAttribute(
						IConeConfigurationConstants.ATTR_VERBOSE,
				3));

	}
	
	public void testConfigurationEngineExecutableButtons() throws Exception {
		Button button = getButtonWidget(ENGINE_DEFAULT_BUTTON);
		boolean selection = buttonTester.getSelection(button);
		assertTrue(selection);
		button = getButtonWidget(ENGINE_CUSTOM_BUTTON);
		selection = buttonTester.getSelection(button);
		assertFalse(selection);
		
		checkConeSelectionComboBoxEnablement(false);
	}

	private void checkConeSelectionComboBoxEnablement(boolean expected) throws NotFoundException,
			MultipleFoundException {
		boolean enabled = comboTester.getEnabled(getComboWidget(ENGINE_SELECTION_COMBO));
		assertEquals(expected, enabled);
	}
	
	public void testCustomConfigurationEngineSelectionEnablesSelectionCombo() throws Exception {
		Button button = getButtonWidget(ENGINE_CUSTOM_BUTTON);
		buttonTester.actionClick(button);
		boolean selection = buttonTester.getSelection(button);
		assertTrue(selection);
		checkConeSelectionComboBoxEnablement(true);
	}

	private void displayShell() {
		shell.setSize(600, 500);
		shell.open();
		// while (!shell.isDisposed()) {
		// if (!getDisplay().readAndDispatch())
		// getDisplay().sleep();
		// }
	}
}
