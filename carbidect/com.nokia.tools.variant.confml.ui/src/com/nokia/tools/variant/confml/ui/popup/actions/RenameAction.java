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

package com.nokia.tools.variant.confml.ui.popup.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;

public class RenameAction implements IViewActionDelegate {

	private ISelection selection;
	private IViewPart iViewPart;

	public void run(IAction action) {

		// Display.getDefault().asyncExec(new Runnable() {
		// @SuppressWarnings("deprecation")
		// public void run() {
		//
		// Display display = Display.getDefault();
		// Shell shell = new Shell(display);
		// // createContents(shell, selection);
		// }
		// });
	}

	// private void createContents(final Shell shell, ISelection selection) {
	// Composite parent=new Composite(shell, SWT.NATIVE);
	// shell.setLayout(new GridLayout(2, true));
	// shell.setLayoutData(GridData.FILL_HORIZONTAL);

	// shell.setLayout(new RowLayout());
	//		
	// if (selection instanceof StructuredSelection) {
	// StructuredSelection element = (StructuredSelection) selection;
	// eVariantProject = init(element.getFirstElement(), selection);
	// }
	// final Label label = new Label(shell, SWT.NONE);
	// label.setText("New Name : ");
	//		
	//		
	// InputDialog dlg = new InputDialog( shell, "Rename Resource",
	// "", eVariantProject.getProject().getName(), null);
	//		
	// shell.layout(true, true);
	//		
	// String input = "";
	// dlg.open();
	// if (input != null) {
	// // User clicked OK; set the text into the label
	// // label.setText(input);
	// dlg.close();
	// }
	// }

	// private EVariantProject init(Object element, ISelection selection) {
	//
	// if (element instanceof EVariantProjectImpl) { // Project
	// EVariantProjectImpl eVariantProjectImpl = (EVariantProjectImpl) element;
	// iProject = eVariantProjectImpl.getProject();
	// eVariantProject = getVariantProject(iProject);
	//
	// } else if (element instanceof ConfMLNavigator.Options) { //
	// ConfMLNavigator
	// ConfMLNavigator.Options options = (ConfMLNavigator.Options) element;
	//
	// eVariantProject = options.getParent();
	// iProject = eVariantProject.getProject();
	//
	// } else if (element instanceof EObjectImpl) {
	//
	// TreeSelection treeSelection = (TreeSelection) selection;
	//
	// int segmentCount = treeSelection.getPaths()[0].getSegmentCount();
	// for (int i = 0; i < segmentCount; i++) {
	// Object segment = treeSelection.getPaths()[0].getSegment(i);
	//
	// if (segment instanceof EVariantProjectImpl) {
	// EVariantProjectImpl eVariantProjectImpl = (EVariantProjectImpl) segment;
	// iProject = eVariantProjectImpl.getProject();
	// eVariantProject = getVariantProject(iProject);
	// break;
	// }
	// }
	//
	// } else if (element instanceof IResource) {
	// IResource resource = (IResource) element;//
	// iProject = resource.getProject();
	// eVariantProject = getVariantProject(iProject);
	// }
	// return eVariantProject;
	//
	// }

	public void init(IViewPart view) {
		this.iViewPart = view;
	}

	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
	}

}
