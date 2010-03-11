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
 * Description: This file is part of com.nokia.tools.variant.editor component.
 */

package com.nokia.tools.variant.editor.listeners;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.LineStyleEvent;
import org.eclipse.swt.custom.LineStyleListener;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class SaveAsPathCheckerDialog {

	private Shell parentShell, shell;
	private int charPosition;
	private char wrongChar;
	private String path;

	private Button okBtn;
	private Color red, silver;

	/**
	 * 
	 * @param path
	 * @param charPosition
	 * @param wrongChar
	 * @param parentShell
	 */
	public SaveAsPathCheckerDialog(String path, int charPosition, char wrongChar,
			Shell parentShell) {
		super();
		this.path = path;
		this.charPosition = charPosition;
		this.wrongChar = wrongChar;
		this.parentShell = parentShell;
	}

	/**
	 * Configures the shell
	 * 
	 * @param shell
	 *            the shell
	 */
	protected void configureShell(Shell shell) {
		shell.setSize(510, 110);
		shell.setText("Save As - Wrong character in path");

		Image systemImage = Display.getCurrent().getSystemImage(
				SWT.ICON_WARNING);
		shell.setImage(systemImage);
	}

	public int open() {
		shell = new Shell(Display.getCurrent(), SWT.NO | SWT.APPLICATION_MODAL
				| SWT.SHELL_TRIM);

		configureShell(shell);

		red = shell.getDisplay().getSystemColor(SWT.COLOR_RED);
		silver = shell.getDisplay().getSystemColor(SWT.COLOR_GRAY);
		createContents(shell);

		shell.open();
		int returnCode = 0;

		Rectangle bounds = parentShell.getBounds();
		shell.setLocation(bounds.x, bounds.y + 130);

		return returnCode;
	}

	/**
	 * Creates the dialog's contents
	 * 
	 * @param shell
	 */
	private void createContents(final Shell shell) {

		GridLayout childLayout = new GridLayout(1, true);
		childLayout.marginHeight = 0;
		childLayout.marginWidth = 0;
		childLayout.verticalSpacing = 0;
		shell.setLayout(childLayout);

		Composite workArea = new Composite(shell, SWT.NONE
				| SWT.NO_REDRAW_RESIZE | 0x800);

		childLayout = new GridLayout(1, false);
		childLayout.marginHeight = 0;
		childLayout.marginWidth = 0;
		childLayout.verticalSpacing = 0;
		workArea.setLayout(childLayout);
		workArea.setLayoutData(new GridData(GridData.FILL_BOTH));

		createTextComposite(workArea);
		createBtnComposite(workArea);

	}

	private void createTextComposite(Composite workArea) {

		Composite composite = new Composite(workArea, SWT.NATIVE);
		GridLayout gridLayout = new GridLayout(1, false);
		composite.setLayout(gridLayout);

		GridData gridData = new GridData(GridData.FILL);
		gridData.verticalAlignment = GridData.BEGINNING;
		composite.setLayoutData(gridData);

		// -------------
		Composite output = new Composite(composite, SWT.FILL);

		gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		gridData = new GridData(GridData.FILL_HORIZONTAL);

		output.setLayout(gridLayout);
		output.setLayoutData(gridData);

		// -------------
		// -------------
		Label leftLabel = new Label(output, SWT.FILL);
		leftLabel.setText("                        ");

		gridData = new GridData();
		gridData.horizontalAlignment = SWT.LEFT;
		gridData.grabExcessHorizontalSpace = false;
		gridData.minimumWidth = 35;
		leftLabel.setLayoutData(gridData);

		// -------------

		final StyledText projectDir = new StyledText(output, SWT.BORDER);
		projectDir.setText(path);
		// Add the syntax coloring handler
		projectDir.addLineStyleListener(new LineStyleListener() {
			@SuppressWarnings("unchecked")
			public void lineGetStyle(LineStyleEvent event) {
				java.util.List styles = new java.util.ArrayList();
				for (int i = 0, n = event.lineText.length(); i < n; i++) {

					styles.add(new StyleRange(event.lineOffset + i, i
						, silver, null));

					if (event.lineText.charAt(i) == wrongChar) {
						int start = i;
						for (; i < n && event.lineText.charAt(i) == wrongChar; i++)
							;
						styles.add(new StyleRange(event.lineOffset + start, i
								- (start+1), red, null));
					}
				}
				event.styles = (StyleRange[]) styles.toArray(new StyleRange[0]);
			}
		});

		gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.grabExcessHorizontalSpace = true;
		gridData.minimumWidth = 346;
		projectDir.setEditable(false);
		projectDir.setLayoutData(gridData);

		// -------------
		Label rightlabel = new Label(output, SWT.FILL);
		rightlabel.setText("");

		gridData = new GridData();
		gridData.horizontalAlignment = SWT.LEFT;
		gridData.grabExcessHorizontalSpace = false;
		gridData.minimumWidth = 35;
		rightlabel.setLayoutData(gridData);
	}

	/**
	 * 
	 * @param workArea
	 */
	private void createBtnComposite(Composite workArea) {

		Composite composite = new Composite(workArea, SWT.NATIVE);
		GridLayout childLayout = new GridLayout(1, false);
		childLayout.marginHeight = 0;
		childLayout.marginWidth = 15;
		composite.setLayout(childLayout);

		GridData gridData = new GridData(GridData.FILL_BOTH);
		gridData.horizontalAlignment = GridData.END;

		composite.setLayoutData(gridData);

		// ---
		okBtn = new Button(composite, SWT.PUSH);
		okBtn.setText("OK");

		gridData = new GridData();
		gridData.horizontalAlignment = GridData.END;
		gridData.widthHint = 53;
		gridData.heightHint = 22;
		okBtn.setLayoutData(gridData);
		okBtn.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				// String input = dirText.getText();
				// okPressed();
				shell.close();
			}
		});
		okBtn.setEnabled(true);
	}

}
