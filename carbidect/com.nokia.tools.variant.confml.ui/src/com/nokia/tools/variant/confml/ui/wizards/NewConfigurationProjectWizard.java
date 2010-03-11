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
 * Description: This file is part of com.nokia.tools.variant.confml.ui component.
 */

package com.nokia.tools.variant.confml.ui.wizards;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import org.eclipse.emf.common.util.URI;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveDescriptor;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.WorkbenchException;

import com.nokia.tools.variant.confml.core.ConfMLUtil;
import com.nokia.tools.variant.confml.core.model.metadata.ECPFMetadata;
import com.nokia.tools.variant.confml.core.model.metadata.EMetadataFactory;
import com.nokia.tools.variant.confml.core.operation.ImportCPFOperation;
import com.nokia.tools.variant.confml.ui.ConfmlUI;
import com.nokia.tools.variant.confml.ui.perspective.ConfMLPerspective;
import com.nokia.tools.vct.common.appmodel.util.CPFUtil;
import com.nokia.tools.vct.common.ui.utils.SWTUtil;

public class NewConfigurationProjectWizard extends NewElementWizard {
	private NewVariantPageOne pageOne;
	private NewVariantPageTwo pageTwo;
	private IProject createdElement;

	/**
	 * Constructor for NewVariantLayerWizard.
	 */
	public NewConfigurationProjectWizard() {
		super();
		setNeedsProgressMonitor(true);
		setWindowTitle("New Configuration Project");
	}

	/**
	 * Adding the page to the wizard.
	 */

	public void addPages() {
		pageOne = new NewVariantPageOne();
		pageTwo = new NewVariantPageTwo("NewVariantPageTwo");

		addPage(pageOne);
		addPage(pageTwo);
	}

	@Override
	protected void finishPage(IProgressMonitor monitor)
	throws InterruptedException, CoreException {
		try {
			String template = pageTwo.getTemplateLocation();
			if(template==null||template.equals("")) {
				ECPFMetadata settings = EMetadataFactory.eINSTANCE
				.createECPFMetadata();

				final java.net.URI locationURI = pageOne.getProjectLocationURI();
				final String projectName = pageOne.getProjectName();
				final IProject project = ResourcesPlugin.getWorkspace().getRoot()
				.getProject(projectName);

				ConfMLUtil.createConfMLProject(project, locationURI, monitor,
						settings);
				project.open(new SubProgressMonitor(monitor, 0));
				createdElement = project;

				IProjectDescription description = createdElement.getDescription();
				createdElement.setDescription(description,
						new NullProgressMonitor());
				// createdElement.setDescription(description, monitor);

				SWTUtil.getStandardDisplay().syncExec(new Runnable() {
					public void run() {
						IWorkbenchWindow window = PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow();
						if (window == null || window.getActivePage() == null) {
							try {
								PlatformUI.getWorkbench().openWorkbenchWindow(
										ConfMLPerspective.PERSPECTIVE_ID,
										project.getWorkspace());
							} catch (WorkbenchException e) {
								ConfmlUI.logWarning(e);
							}
						} else {
							IPerspectiveDescriptor perspective = PlatformUI
							.getWorkbench().getPerspectiveRegistry()
							.findPerspectiveWithId(
									ConfMLPerspective.PERSPECTIVE_ID);
							window.getActivePage().setPerspective(perspective);
						}
						IViewPart view = window.getActivePage().findView(
								IPageLayout.ID_RES_NAV);
						if (view != null) {
							view.getViewSite().getSelectionProvider().setSelection(
									new StructuredSelection(project));
						}
					}
				});
			} else {
				System.out.println("create from file="+template);
				final ImportCPFOperation operation = new ImportCPFOperation();
				operation.setProjectName(pageOne.getProjectName());
				
				File f = new File(template);
				System.err.println(f.getAbsolutePath());
				
				URI fileUrl = URI.createFileURI(f.getAbsolutePath());
				operation.setContentProvider(CPFUtil.selectCPFContentProvider(fileUrl));

				IRunnableWithProgress runnable = new IRunnableWithProgress() {
					public void run(IProgressMonitor monitor)
					throws InvocationTargetException, InterruptedException {
						Display display = PlatformUI.getWorkbench().getDisplay();
						final IProgressMonitor mt = monitor;
						display.syncExec(new Runnable() {

							public void run() {
								try {
									ResourcesPlugin.getWorkspace().run(operation,
											ResourcesPlugin.getWorkspace().getRoot(),
											IWorkspace.AVOID_UPDATE, mt);
								} catch (CoreException e) {
									e.printStackTrace();
								}
								
							}
							
						});
					}
				};
				try {
					getContainer().run(false, false, runnable);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	@Override
	public Object getCreatedElement() {
		return createdElement;
	}
}
