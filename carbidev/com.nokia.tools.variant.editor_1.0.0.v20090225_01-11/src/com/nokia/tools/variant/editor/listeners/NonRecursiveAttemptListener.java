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

import java.lang.reflect.Field;

import org.eclipse.ui.IPartListener;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.WorkbenchPage;

import com.nokia.tools.variant.editor.editors.CPFEditor;

@SuppressWarnings("restriction")
public class NonRecursiveAttemptListener implements IPartListener {

	public void partActivated(IWorkbenchPart part) {
		IWorkbenchPage activePage = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage();
		try {
			Field declaredField = WorkbenchPage.class
					.getDeclaredField("partBeingActivated");
			declaredField.setAccessible(true);
			declaredField.set(activePage, null);
		} catch (SecurityException e) {

			e.printStackTrace();
		} catch (NoSuchFieldException e) {

			e.printStackTrace();
		} catch (IllegalArgumentException e) {

			e.printStackTrace();
		} catch (IllegalAccessException e) {

			e.printStackTrace();
		}
		if (part instanceof CPFEditor) {
			setSelectionOnPreview(part, activePage);
		}
	}

	private void setSelectionOnPreview(IWorkbenchPart part,
			IWorkbenchPage activePage) {
		IViewPart findView = activePage
				.findView("com.nokia.tools.variant.preview.PreviewView");
		if (findView instanceof ISelectionListener) {
			ISelectionListener l = (ISelectionListener) findView;
			if(part instanceof CPFEditor) {
				l.selectionChanged(part, ((CPFEditor) part).getSelection());
			}
		}
	}

	public void partBroughtToTop(IWorkbenchPart part) {

	}

	public void partClosed(IWorkbenchPart part) {
		IWorkbenchPage activePage = PlatformUI.getWorkbench()
		.getActiveWorkbenchWindow().getActivePage();
		if(activePage!=null){
			setSelectionOnPreview(part, activePage);
		}
	}

	public void partDeactivated(IWorkbenchPart part) {

	}

	public void partOpened(IWorkbenchPart part) {

	}

}
