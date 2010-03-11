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

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

public class NewImplMLWizard extends NewElementWizard {
	private static final String CRML_EDITOR_ID = "com.nokia.tools.carbide.ct.crml.ui.editors.CRMLMultiPageEditorPart";
	public static final String TEMPLATES_FOLDER = "templates/implml";
	private NewImplMLWizardPageOne pageOne;

	private IFile createdElement;

	/**
	 * Constructor for NewCRMLWizard.
	 */
	public NewImplMLWizard() {
		super();
		setNeedsProgressMonitor(true);
		setWindowTitle("New ImplML file");
	}

	/**
	 * Adding the page to the wizard.
	 */

	public void addPages() {
		pageOne = new NewImplMLWizardPageOne();

		for (Object obj : getSelection().toArray()) {
			if (obj instanceof IContainer) {
				pageOne.setInitialContainer((IContainer) obj);
				break;
			} else if (obj instanceof IResource) {
				pageOne.setInitialContainer(((IResource) obj).getParent());
				break;
			}
		};
		addPage(pageOne);
	}

	@Override
	public boolean canFinish() {
		return pageOne.isPageComplete();
	}

	@Override
	protected void finishPage(IProgressMonitor monitor)
	throws InterruptedException, CoreException {
		final IFile file = pageOne.getSelectedFile();
		
		file.create(getInitialContent(file), true, null);
		
		if(file.getFileExtension().equals("crml")) {
			openResource(file, CRML_EDITOR_ID);
		}
	}

	private InputStream getInitialContent(IFile file) {
		File templates = new File(TEMPLATES_FOLDER);
		File[] files = templates.listFiles();
		for (int i = 0; i < files.length; i++) {
			File f = files[i];
			String ext = WizardUtils.getExtension(f.getName());
			if(WizardUtils.getExtension(file.getName()).equals(ext)) {
			      try {
					return new FileInputStream(f);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}

			}
		}
		return new ByteArrayInputStream(new byte[0]);
	}

	@Override
	public Object getCreatedElement() {
		return createdElement;
	}

}
