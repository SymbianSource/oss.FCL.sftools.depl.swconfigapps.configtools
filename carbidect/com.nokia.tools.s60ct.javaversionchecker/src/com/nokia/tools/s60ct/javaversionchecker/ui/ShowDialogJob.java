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
package com.nokia.tools.s60ct.javaversionchecker.ui;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Preferences;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.browser.IWebBrowser;
import org.eclipse.ui.progress.UIJob;

import com.nokia.tools.s60ct.javaversionchecker.Activator;
import com.nokia.tools.s60ct.javaversionchecker.MessageGenerator;
import com.nokia.tools.s60ct.javaversionchecker.PreferenceConstants;
import com.nokia.tools.s60ct.javaversionchecker.SupportedJavaVersions;

/**
 * 
 *
 */
public class ShowDialogJob extends UIJob {

	private Preferences prefs = Activator.getDefault().getPluginPreferences();

	/**
	 * @param name
	 */
	public ShowDialogJob(String name) {
		super(name);
	}

	/**
	 * @see org.eclipse.ui.progress.UIJob#runInUIThread(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public IStatus runInUIThread(IProgressMonitor monitor) {
		boolean response = showDialog();
		
		//If toggle was selected, store preferences
		if (response) {
			prefs.setValue(PreferenceConstants.P_DISABLE_JDK_WARNING, response);
			Activator.getDefault().savePluginPreferences();
		}

		return Status.OK_STATUS;
	}

	/**
	 * Shows JRE warning dialog.
	 * @return state of toggle
	 */
	private static boolean showDialog() {
		MessageDialogWithToggle dialog = new MessageDialogWithToggle(
				PlatformUI.getWorkbench().getDisplay().getActiveShell(), 
				MessageGenerator.generateTitle(), 
				null, 
				MessageGenerator.generateMessage(),
				MessageDialog.WARNING,
				new String[]{ IDialogConstants.OK_LABEL },
				0,
				"Do not warn again", 
				false) {
			protected Control createMessageArea(Composite composite) {
				Image image = getImage();
				if (image != null) {
					imageLabel = new Label(composite, SWT.NULL);
					image.setBackground(imageLabel.getBackground());
					imageLabel.setImage(image);
					GridDataFactory.fillDefaults().align(SWT.CENTER,
							SWT.BEGINNING).applyTo(imageLabel);
				}

				Link link = new Link(composite, getMessageLabelStyle());
				link.setText(message);
				link.addSelectionListener(new SelectionAdapter() {

					public void widgetSelected(SelectionEvent e) {
						if ("Download JRE".equals(e.text)) {

							try {
								IWebBrowser browser = PlatformUI.getWorkbench()
										.getBrowserSupport()
										.getExternalBrowser();
								browser
										.openURL(new URL(SupportedJavaVersions.sunJreDownloadSite));
							} catch (MalformedURLException ex) {
								ex.printStackTrace();
							} catch (PartInitException ex) {
								ex.printStackTrace();
							}
						}else{
							try {
								IWebBrowser browser = PlatformUI.getWorkbench()
										.getBrowserSupport()
										.getExternalBrowser();
								browser
										.openURL(new URL(
												"http://help.eclipse.org/ganymede/index.jsp?topic=/org.eclipse.platform.doc.user/tasks/running_eclipse.htm"));
							} catch (MalformedURLException ex) {
								ex.printStackTrace();
							} catch (PartInitException ex) {
								ex.printStackTrace();
							}

						}
					}
				});

				GridDataFactory
						.fillDefaults()
						.align(SWT.FILL, SWT.BEGINNING)
						.grab(true, false)
						.hint(
								convertHorizontalDLUsToPixels(IDialogConstants.MINIMUM_MESSAGE_AREA_WIDTH),
								SWT.DEFAULT).applyTo(link);

				return composite;
			}
		};

		dialog.open();
		return dialog.getToggleState();
	}
}
