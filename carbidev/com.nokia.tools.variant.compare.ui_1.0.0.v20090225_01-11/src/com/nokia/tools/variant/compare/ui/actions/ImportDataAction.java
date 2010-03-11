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
 * Description: This file is part of com.nokia.tools.variant.compare.ui component.
 */

package com.nokia.tools.variant.compare.ui.actions;

import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IPageChangingListener;
import org.eclipse.jface.dialogs.PageChangingEvent;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.IContributedContentsView;

import com.nokia.tools.variant.compare.ui.ImportDataUIPlugin;
import com.nokia.tools.variant.compare.ui.wizards.ImportDataWizard;
import com.nokia.tools.variant.compare.ui.wizards.ImportDataWizardPageOne;
import com.nokia.tools.variant.editor.editors.ViewEditorModel;

public class ImportDataAction implements IWorkbenchWindowActionDelegate {

	private IWorkbenchWindow window;
	private IWorkbenchPart modelPart;

	public void init(IWorkbenchWindow window) {
		this.window = window;
		window.getActivePage().addPartListener(new IPartListener() {
			public void partClosed(IWorkbenchPart part) {
				if (modelPart == part) {
					modelPart = null;
				}
			}

			public void partActivated(IWorkbenchPart part) {
			}

			public void partBroughtToTop(IWorkbenchPart part) {
			};

			public void partDeactivated(IWorkbenchPart part) {
			}

			public void partOpened(IWorkbenchPart part) {
			}
		});
	}

	public void dispose() {
	}

	public void run(IAction action) {

		final ImportDataWizard wizard;

		if (modelPart == null) {
			// no CPF is open
			wizard = new ImportDataWizard();
		} else {
			// Opened CPF is set as target
			wizard = new ImportDataWizard(modelPart);
			wizard.setTargetModel((ViewEditorModel) modelPart
					.getAdapter(ViewEditorModel.class));
		}

		IWorkbenchWindow window = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow();
		WizardDialog dialog = new WizardDialog(window.getShell(), wizard) {
			@Override
			protected void configureShell(Shell newShell) {
				super.configureShell(newShell);
				Image image = ExtendedImageRegistry.INSTANCE
						.getImage(ImportDataUIPlugin.INSTANCE
								.getImage("copyvalues_16_tlb.png"));
				newShell.setImage(image);
			}
		};
		dialog.addPageChangingListener(new IPageChangingListener() {
			public void handlePageChanging(PageChangingEvent event) {
				if (event.getCurrentPage() == wizard
						.getPage(ImportDataWizardPageOne.PAGE_ID)) {
					try {
						if (!wizard.isCpfOpened()) {
							wizard.loadSourceAndTargetModel();
						} else {
							wizard.loadSourceModel();
						}
						event.doit = true;
					} catch (Exception ex) {
						event.doit = false;
						((WizardPage) event.getCurrentPage())
								.setErrorMessage(ex.toString());
					}
				}
			}
		});

		GC gc = new GC(window.getShell());
		FontMetrics fm = gc.getFontMetrics();
		gc.dispose();
		int minWidth = Dialog.convertWidthInCharsToPixels(fm, 35);
		int minHeight = Dialog.convertHeightInCharsToPixels(fm, 25);
		dialog.setMinimumPageSize(minWidth, minHeight);
		dialog.open();

	}

	public void selectionChanged(IAction action, ISelection selection) {
		modelPart = null;
		IWorkbenchPage page = window.getActivePage();
		if (page != null) {
			IWorkbenchPart part = page.getActivePart();
			while (part != null) {
				if (part.getAdapter(ViewEditorModel.class) != null) {
					modelPart = part;
					break;
				}

				IContributedContentsView contributed = (IContributedContentsView) part
						.getAdapter(IContributedContentsView.class);
				if (contributed != null) {
					part = contributed.getContributingPart();
				} else {
					part = null;
				}
			}
		}

	}

}
