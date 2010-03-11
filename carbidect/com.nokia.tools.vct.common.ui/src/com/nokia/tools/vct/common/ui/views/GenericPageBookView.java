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
 * Description: This file is part of com.nokia.tools.vct.common.ui component.
 */

package com.nokia.tools.vct.common.ui.views;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.ISaveablePart;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.IContributedContentsView;
import org.eclipse.ui.part.IPage;
import org.eclipse.ui.part.IPageBookViewPage;
import org.eclipse.ui.part.MessagePage;
import org.eclipse.ui.part.PageBook;
import org.eclipse.ui.part.PageBookView;

import com.nokia.tools.vct.common.core.utils.PlatformUtil;

/**
 * Base class for page book view implementations. This implementation is a
 * mix-in of the code found in the outline and property views. The view supports
 * all the code for page contributor location, selection mechanism (both in and
 * out) and context reset.
 * 
 * @param <T> Page interface type. Should extend the {@link IPage} or {@link IPageBookViewPage}
 */
public class GenericPageBookView<T extends IPage> extends PageBookView
		implements ISelectionProvider,
		ISelectionListener {

	/** The interface of the page this view install would support */
	private final Class<T> pageInterface;
	/** Text for "no content" page */
	private final String defaultText;
	/** Help context ID for this view */
	private final String helpContextId;

	/** Last received selection */
	private ISelection lastSelection;
	/** Last received selection source */
	private IWorkbenchPart lastSelectionSource;

	/**
	 * Part listener for resetting selection when the selection source has been
	 * closed.
	 */
	private final IPartListener partListener = new IPartListener() {
		public void partActivated(IWorkbenchPart part) {
		}

		public void partBroughtToTop(IWorkbenchPart part) {
		}

		public void partClosed(IWorkbenchPart part) {
			if (lastSelectionSource == part) {
				selectionChanged(null, StructuredSelection.EMPTY);
			}
		}

		public void partDeactivated(IWorkbenchPart part) {
		}

		public void partOpened(IWorkbenchPart part) {
		}
	};

	/**
	 * Construct the view and initialize it
	 * 
	 * @param interfaceType
	 *            {@link IPage} extension interface to look for
	 * @param defaultText
	 *            Default view message
	 * @param helpId
	 *            Help context ID or <code>null</code>
	 */
	protected GenericPageBookView(Class<T> interfaceType, String defaultText,
			String helpId) {
		this.pageInterface = interfaceType;
		this.defaultText = defaultText;
		this.helpContextId = helpId;
		lastSelection = StructuredSelection.EMPTY;
		
	}

	/**
	 * {@inheritDoc}
	 */
	public void addSelectionChangedListener(ISelectionChangedListener listener) {
		getSelectionProvider().addSelectionChangedListener(listener);
	}

	/**
	 * {@inheritDoc}
	 */
	protected IPage createDefaultPage(PageBook book) {
		MessagePage page = new MessagePage();
		initPage(page);
		page.createControl(book);
		page.setMessage(defaultText);
		return page;
	}

	/**
	 * Simply create default control and set help context Id if defined.
	 * 
	 * @param parent
	 *            Parent composite
	 * @see PageBookView#createPartControl(Composite)
	 */
	public void createPartControl(Composite parent) {
		super.createPartControl(parent);
		if (helpContextId != null) {
			PlatformUI.getWorkbench().getHelpSystem().setHelp(getPageBook(),
					helpContextId);
		}
	}

	/**
	 * Try to obtain the page using the adapter technology
	 * 
	 * @see PageBookView#doCreatePage(IWorkbenchPart)
	 */
	protected PageRec doCreatePage(IWorkbenchPart part) {
		T page = PlatformUtil.getAdapter(part, pageInterface, false);
		if (page != null) {
			if (page instanceof IPageBookViewPage) {
				initPage((IPageBookViewPage) page);
			}
			page.createControl(getPageBook());
			return new PageRec(part, page);
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	protected void doDestroyPage(IWorkbenchPart part, PageRec rec) {
		rec.page.dispose();
		rec.dispose();
	}

	/**
	 * Extends the default implementation for the
	 * {@link IContributedContentsView} support.
	 * 
	 * @see IContributedContentsView
	 */
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

	/**
	 * The default bootstrap part is the active editor of the current page.
	 */
	protected IWorkbenchPart getBootstrapPart() {
		IWorkbenchPage page = getSite().getPage();
		if (page != null) {
			return page.getActiveEditor();
		}
		return null;
	}

	public ISelection getSelection() {
		// get the selection from the selection provider
		return getSelectionProvider().getSelection();
	}

	/**
	 * By default, only the editors are important
	 * 
	 * @see PageBookView#isImportant(IWorkbenchPart)
	 */
	protected boolean isImportant(IWorkbenchPart part) {
		// We only care about editors
		return (part instanceof IEditorPart);
	}

	public void partBroughtToTop(IWorkbenchPart part) {
		partActivated(part);
	}

	public void removeSelectionChangedListener(
			ISelectionChangedListener listener) {
		getSelectionProvider().removeSelectionChangedListener(listener);
	}

	public void setSelection(ISelection selection) {
		getSelectionProvider().setSelection(selection);
	}

	@Override
	public void partActivated(IWorkbenchPart part) {
		IContributedContentsView view = PlatformUtil.getAdapter(part,
				IContributedContentsView.class, true);
		IWorkbenchPart source = null;
		if (view != null) {
			source = view.getContributingPart();
		}
		if (source != null) {
			super.partActivated(source);
		} else {
			super.partActivated(part);
		}

		// // When the view is first opened, pass the selection to the page
		// IPage page = getCurrentPage();
		// if (page instanceof ISelectionListener) {
		// ((ISelectionListener) page).selectionChanged(part,
		// lastSelection);
		// }
	}

	/**
	 * The <code>ContentOutline</code> implementation of this
	 * <code>PageBookView</code> method extends the behavior of its parent to
	 * use the current page as a selection provider.
	 * 
	 * @param pageRec
	 *            the page record containing the page to show
	 */
	protected void showPageRec(PageRec pageRec) {
		IPage current = getCurrentPage();
		IPage newPage = pageRec.page;

		if (current != newPage && current instanceof ISelectionListener) {
			((ISelectionListener) current).selectionChanged(
					lastSelectionSource, StructuredSelection.EMPTY);
		}

		super.showPageRec(pageRec);

		if (current != newPage && newPage instanceof ISelectionListener) {
			((ISelectionListener) newPage).selectionChanged(
					lastSelectionSource, lastSelection);
		}
	}

	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		// we ignore our own selection or null selection
		if (part == this || selection == null) {
			return;
		}

		lastSelection = selection;

		if (lastSelectionSource != part) {
			unbindSelectionListener();
			lastSelectionSource = part;
			if (lastSelectionSource != null) {
				lastSelectionSource.getSite().getPage().addPartListener(
						partListener);
			}
		}

		// pass the selection to the page
		IPage page = getCurrentPage();
		if (page instanceof ISelectionListener) {
			((ISelectionListener) page).selectionChanged(part, selection);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	protected Object getViewAdapter(Class key) {
		if (ISaveablePart.class.equals(key)) {
			return getSaveablePart();
		}
		return super.getViewAdapter(key);
	}

	protected ISaveablePart getSaveablePart() {
		IWorkbenchPart part = getCurrentContributingPart();
		if (part instanceof ISaveablePart) {
			return (ISaveablePart) part;
		}
		return null;
	}

	/**
	 * Initialize the site.
	 */
	@Override
	protected void setSite(IWorkbenchPartSite site) {
		super.setSite(site);
		getSite().getPage().addSelectionListener(this);
	}

	/**
	 * Dispose
	 */
	@Override
	public void dispose() {
		getSite().getPage().removeSelectionListener(this);
		unbindSelectionListener();
		super.dispose();
	}

	/**
	 * Remove selection listener if exists for the {@link ISelectionProvider}
	 */
	private void unbindSelectionListener() {
		if (lastSelectionSource != null) {
			lastSelectionSource.getSite().getPage().removePartListener(
					partListener);
			lastSelectionSource = null;
		}
	}

}
