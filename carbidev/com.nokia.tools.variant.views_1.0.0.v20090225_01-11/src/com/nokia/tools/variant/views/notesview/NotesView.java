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
 * Description: This file is part of com.nokia.tools.variant.views component.
 */

package com.nokia.tools.variant.views.notesview;

import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.ui.part.IContributedContentsView;
import org.eclipse.ui.part.IPage;
import org.eclipse.ui.part.MessagePage;
import org.eclipse.ui.part.PageBook;
import org.eclipse.ui.part.PageBookView;

import com.nokia.tools.variant.content.confml.View;
import com.nokia.tools.variant.views.common.ViewsMessages;


public class NotesView extends PageBookView {

	public static final String VIEW_ID = "com.nokia.tools.variant.views.notesview";

	public NotesView() {
		
	}

	@Override
	protected IPage createDefaultPage(PageBook book) {
		MessagePage page = new MessagePage();
		initPage(page);
		page.createControl(getPageBook());
		page.setMessage(ViewsMessages.DEFAULT_TEXT);
		return page;
	}

	@Override
	protected PageRec doCreatePage(IWorkbenchPart part) {
		Object adapter = part.getAdapter(View.class);
		if (adapter instanceof View) {
			View view = (View) adapter;
			NotesViewPage page = new NotesViewPage(view);
			initPage(page);
			page.createControl(getPageBook());
			return new PageRec(part, page);
		}
		return null;
	}

	@Override
	protected void doDestroyPage(IWorkbenchPart part, PageRec pageRecord) {
		if (pageRecord != null) {
			pageRecord.page.dispose();
			pageRecord.dispose();
			pageRecord = null;
		}

	}

	@Override
	protected IWorkbenchPart getBootstrapPart() {
		IWorkbenchPage page = getSite().getPage();
		if (page != null) {
			IEditorPart activeEditor = page.getActiveEditor();
			if (activeEditor instanceof EditorPart) {
				return activeEditor;
			}
		}
		return null;
	}

	@Override
	protected boolean isImportant(IWorkbenchPart part) {
		if (part instanceof EditorPart) {
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public Object getAdapter(Class key) {
		if (key == IContributedContentsView.class) {
			return new IContributedContentsView() {
				public IWorkbenchPart getContributingPart() {
					return getCurrentContributingPart();
				}
			};
		}
		return super.getAdapter(key);
	}

}
