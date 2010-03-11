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
package com.nokia.s60ct.search.gui;

import java.util.Iterator;

import objectview.EObjectFocusDomain;
import objectview.IObjectView;
import objectview.ObjectViewRegistry;

import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import cenrep.util.CenrepResourceImpl;
import com.nokia.s60ct.search.ISearchArea;
import com.nokia.s60ct.search.Search;
import com.nokia.s60ct.search.SearchResult;
import com.nokia.s60ct.search.actions.NextAction;
import com.nokia.s60ct.search.actions.PreviousAction;
import com.nokia.s60ct.search.conf.KeySearchArea;
import com.nokia.s60ct.search.conf.SettingSearchArea;
import com.nokia.s60ct.search.conf.WorkspaceSearchArea;
import com.nokia.s60ct.search.emf.AnyEAttributeContainsQuery;
import com.nokia.s60ct.search.emf.EmfMatch;
import com.nokia.s60ct.search.emf.EmfResultSearchArea;
import com.nokia.s60ct.search.emf.EmfSearch;

public class SearchPane {
	
	/**
	 * 
	 */

	// UI
	private enum TraversalDirection {
		FORWARD, 
		BACKWARD
	};
	
	private Text queryText = null;
	
	private Composite composite = null;
	
	private final Color COLOR_RED;
	private final Color COLOR_NORMAL;
	private boolean isColorRed = false;
	
	// Search
	private Search<EObject, EmfMatch> search = null;
	
	// Selection
	private EObject searchCursor; 
	private int searchCursorOrder;
	
	// Mode (what action was selected last)
	private TraversalDirection direction = TraversalDirection.FORWARD; 
	// We use this flag to update the search depending of that whether arrow or enter was used last time
	private boolean skipSearchCursor; 
	
	private static SearchPane pane = null;
	
				
	public SearchPane(Composite parent){
		pane = this;
		COLOR_RED = new Color(parent.getDisplay(), 203,94,94);
		COLOR_NORMAL = new Color(parent.getDisplay(), 255,255,255);
		createControl(parent); 
		
	}
	
	public Control getControl() {
		return composite;
	}
	
	public static SearchPane getSearchPane()
	{
		return pane;
	}
	
	
	/**
	 * Informs us, that the environment might have changed, so we have to update
	 * results. 
	 */
	private boolean updateResults;

	/**
	 * Informs us, that the environment might have changed, so we have to update
	 * cache. 
	 */
	private boolean updateCache = true;

	/**
	 * Informs us, that we are tinkering ourselves with the UI activation.
	 * Ignore focus events. 
	 */
	private boolean activatingUi = false;
	
	
	private int focusCount = 0; 
	private FocusListener focusListener = new FocusListener() {
		public void focusGained(FocusEvent e) {
			if (focusCount == 0) {
				SearchPane.this.focusGained(); 
			}
			focusCount++; 
		}
		public void focusLost(FocusEvent e) {
			focusCount--; 
		}
	};
	
	protected void focusGained() {
		if (!activatingUi) {
			update(); 
			queryText.selectAll(); 
		}
	}
	
	/**
	 * This UI component utilizes caches, because its operations
	 * are very expensive and these caches have
	 * to be updated before its functionality can be used.
	 * The danger is in 'finding' modified/removed 'matches', 
	 * missing newly added items, or traversing the list in 
	 * obsolete order. Also the search cursor needs updating. 
	 */
	protected void update() {
		updateResults = true; 
		updateCache = true; 
		lastShown = null; 
		direction = TraversalDirection.FORWARD;
		skipSearchCursor = false;
		
		searchCursor = getUserSelectedEObject();
	}
	
	/**
	 * This UI component utilizes caches and these caches have
	 * to be updated before its functionality can be used.
	 * We expect the component to be up to date, if it is focused. 
	 * If the focus is outside, the changes in the environment
	 * may have obsoleted the cache
	 */
	protected void prepareForUsage() {
		if (focusCount == 0) {
			update(); 
		}
	}
	
	//
	// UI code
	// 
	private void createControl(Composite parent) {
		
		GridLayout buttonLayout = new GridLayout(2,false);
		buttonLayout.marginLeft = 0;
		buttonLayout.marginRight = 0;		
		buttonLayout.marginTop = -2;
		buttonLayout.marginBottom = -2;
		
		composite = new Composite(parent,SWT.NONE);
		composite.setLayout(buttonLayout);
		composite.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true));
		
		Label label = new Label(composite, SWT.CENTER);
		label.setText("Find:");
		label.setLayoutData(new GridData(SWT.CENTER,SWT.CENTER,true,true));
		label.pack();
		
		queryText = new Text(composite,SWT.BORDER);
		queryText.setEnabled(true); 
		queryText.setEditable(true);
		queryText.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true));
		queryText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				updateResults(); 
			}
		});
		
		queryText.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {
				if (e.character == '\r' && (e.stateMask & SWT.SHIFT) > 0) {
					if (updateResults) {
						direction = TraversalDirection.BACKWARD;
						updateResults(); 
					} else {
						prevVisibleEObject(); 
					}
				} else if (e.character == '\r' && (e.stateMask & SWT.SHIFT) == 0) {
					if (updateResults) {
						direction = TraversalDirection.FORWARD;
						updateResults(); 
					} else {
						nextVisibleEObject(); 
					}
				} 
			}
			public void keyReleased(KeyEvent e) {
			}
		});
		queryText.pack();
		
		queryText.addFocusListener(focusListener);
		label.addFocusListener(focusListener);
		composite.addFocusListener(focusListener);
	}	
	
	//
	// Selection control
	//
	
	private ISelectionProvider activeSelectionProvider = null; 
	
	private ISelectionProvider getActiveSelectionProvider() {
		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		IWorkbenchPage page = window.getActivePage();
		IWorkbenchPart part = page.getActivePart();	
		if (part instanceof IViewerProvider) {
			return ((IViewerProvider)part).getViewer();
		}
		return null; 
	}
	
	private int selectedMatch = 0; 
	
	private TreePath lastShown = null; 
	
	private enum SelectReturn {
		CANNOT_SHOW, 
		SHOWS_SAME_AS_BEFORE,
		SHOWS_NEW
	};
	
	public SelectReturn singleSelect(Object object) {
 		
		try {
			activatingUi = true;
			Iterator<IObjectView> views = ObjectViewRegistry.getInstance().getViewsFor(object).iterator();
			
			if (views.hasNext()) {
				IObjectView view = views.next();
				if (view instanceof EObjectFocusDomain) {
					EObjectFocusDomain focusDomain = (EObjectFocusDomain)view; 
					TreePath shown = focusDomain.canFocusUpTo(object);
					if (shown.equals(lastShown)) {
						return SelectReturn.SHOWS_SAME_AS_BEFORE;
					}
					focusDomain.focus(shown, true); // quite heavy operation, do only if it makes difference
					lastShown = shown; 
					return SelectReturn.SHOWS_NEW; 
				} else {
					view.show(object, true);
					return SelectReturn.SHOWS_NEW; // we hope
				}
			}
		} finally {
			activatingUi = false; 
		}
		return SelectReturn.CANNOT_SHOW; 
	}
	
	private SelectReturn select(Object object) {
 		if (search != null ) {
			try {
				activatingUi = true;
				Iterator<IObjectView> views = ObjectViewRegistry.getInstance().getViewsFor(object).iterator();
				
				if (views.hasNext()) {
					IObjectView view = views.next();
					if (view instanceof EObjectFocusDomain) {
						EObjectFocusDomain focusDomain = (EObjectFocusDomain)view; 
						TreePath shown = focusDomain.canFocusUpTo(object);
						if (shown.equals(lastShown)) {
							return SelectReturn.SHOWS_SAME_AS_BEFORE;
						}
						focusDomain.focus(shown, true); // quite heavy operation, do only if it makes difference
						queryText.setFocus();
						lastShown = shown; 
						return SelectReturn.SHOWS_NEW; 
					} else {
						view.show(object, true);
						queryText.setFocus();
						return SelectReturn.SHOWS_NEW; // we hope
					}
				}
			} finally {
				activatingUi = false; 
			}
		}
		return SelectReturn.CANNOT_SHOW; 
	}
	
	private SelectReturn select(int i) {
		if (search != null && i >= 0 && i < search.getResult().size()) {
			return select(search.getResult().get(i));
		}
		return SelectReturn.CANNOT_SHOW;
	}
	
	private EObject getUserSelectedEObject() {
		ISelectionProvider provider = getActiveSelectionProvider();
		if (provider != null) {
			ISelection selection = provider.getSelection();
			if (selection instanceof ITreeSelection) {
				EObject ret = null; 
				for (TreePath path : ((ITreeSelection)selection).getPaths()) {
					for (int i = 0; i < path.getSegmentCount(); i++) {
						if (path.getSegment(i) instanceof CenrepResourceImpl
							&& ((CenrepResourceImpl)path.getSegment(i)).getContents().size() > 0) {
							ret = ((CenrepResourceImpl)path.getSegment(i)).getContents().get(0); 
						} else if (path.getSegment(i) instanceof EObject) {
							ret = (EObject)path.getSegment(i);
						}
					}
					if (ret != null) {
						break;
					}
				}
				return ret; 
			}
			if (selection instanceof IStructuredSelection) {
				IStructuredSelection structured = (IStructuredSelection)selection;
				for (Object object : structured.toArray()) {
					if (object instanceof CenrepResourceImpl && ((CenrepResourceImpl)object).getContents().size() > 0) {
						return ((CenrepResourceImpl)object).getContents().get(0); 
					} else if (object instanceof EObject) {
						return (EObject)object;
					}
				}
			}
		}	
		return null;
	}
	
	private int getMatchFollowingSearchCursor() {
		if (searchCursor != null) {
			// Let's go forth with n*log(n) search. This is one of those
			// divide and conquer searches. It utilize the knowledge that 
			// search result is ordered and it will fail horribly, if the result
			// is not
			int searchCursorOrder = selectedSearchArea.getOrder(searchCursor); 
			
			SearchResult<EmfMatch> result = search.getResult();
			// ASSUME: searchResult is ordered 

			int bottom = 0;  
			int top = result.size(); 
			
			while (bottom < top) {
				int guess = (bottom + top)/2; 
				int guessOrder = selectedSearchArea.getOrder(result.get(guess).getEObject());

				if (guessOrder == searchCursorOrder) {
					return guess; 
				} 
				if (guessOrder < searchCursorOrder) {
					bottom = guess+1;
				}
				if (guessOrder > searchCursorOrder) {
					top = guess;
				}
			}
			return top % result.size(); // wrap
		}
		return 0; 
	}
	
	private int getMatchPrecedingSearchCursor() {
		int following = getMatchFollowingSearchCursor(); 
		if (searchCursor == search.getResult().get(following).getEObject()) {
			return following; 
		}
		return following - 1; 
	}


	private void selectVisibleMatchCloseSearchCursor() {
		/* Assumption: There is visible match. If there isn't, this method
		 * will never return, but instead it will freeze. 
		 */
		switch (direction) {
			case FORWARD: {
				selectedMatch = getMatchFollowingSearchCursor();
				if (skipSearchCursor && searchCursor == search.getResult().get(selectedMatch).getEObject()) {
					selectedMatch++; 
				}
				while (select(selectedMatch) == SelectReturn.CANNOT_SHOW) {
					if (++selectedMatch >= search.getResult().size()) {
						selectedMatch = 0; 
					}
				}
				return;
			}
			case BACKWARD: {
				selectedMatch = getMatchPrecedingSearchCursor();
				if (skipSearchCursor && searchCursor == search.getResult().get(selectedMatch).getEObject()) {
					selectedMatch--;
				}
				while (select(selectedMatch) == SelectReturn.CANNOT_SHOW) {
					if (--selectedMatch < 0) {
						selectedMatch = search.getResult().size() - 1;  
					}
				}
				return; 
			}
		}
		throw new IllegalStateException();
	}

	//
	// Search control
	//
	
	public WorkspaceSearchArea getSearchArea()
	{
		return selectedSearchArea;
	}
	
	private WorkspaceSearchArea mainSearchArea = new WorkspaceSearchArea(); 
	private WorkspaceSearchArea settingSearchArea = new SettingSearchArea(); 
	private WorkspaceSearchArea keySearchArea = new KeySearchArea(); 
	private WorkspaceSearchArea selectedSearchArea = mainSearchArea;
		
	private String oldText = null; 
	
	
	public void searchRef(String ref, boolean searchSetting) { //for jump-to actions
		updateResults = false; 
		
		if (ref.length() > 0) {
			
			if (searchSetting)
			{
				selectedSearchArea = settingSearchArea;
			}
			else
			{
				selectedSearchArea = keySearchArea;
			}
			
			search = new EmfSearch(selectedSearchArea, 
		  						   new AnyEAttributeContainsQuery(ref)); 

			// The eObjects may have been added/removed/relocated changing the object order
			//if (updateCache) {
				selectedSearchArea.updateOrderCache(); 
				//updateCache = false; 
			//}
			
			if (hasVisibleMatch()) {
				// Select next visible match
				selectVisibleMatchCloseSearchCursor(); 
			} 
			else 
			{
				String message = "";
				
				if (searchSetting)
					message = "Setting with matching reference could not be found";
				else
					message = "Key with matching reference could not be found";
				
				IWorkbench workbench = PlatformUI.getWorkbench();
				IWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();
				MessageDialog.openError(
						workbenchWindow.getShell(),
						"Error!",
						message); 
			}
		} else {
			select(searchCursor); 
			search = null; 
		}
		oldText = ref;
	}
	
	
	
	
	private void updateResults() {
		selectedSearchArea = mainSearchArea;
		updateResults = false; 
		String newText = queryText.getText();
		if (newText.length() > 0) {
			ISearchArea<EObject> searchArea = null; 
			
			// If we can use existing search results as base for new search, let's use them  
			if (oldText != null && search != null 
				&& newText.length() >= oldText.length() 
				&& newText.substring(0, oldText.length()).equals(oldText)
				&& !updateCache) {
				searchArea = new EmfResultSearchArea(search.getResult());
			} else {
				searchArea = mainSearchArea;
			}
			search = new EmfSearch(searchArea, 
		  						   new AnyEAttributeContainsQuery(queryText.getText())); 

			// The eObjects may have been added/removed/relocated changing the object order
			if (updateCache) {
				mainSearchArea.updateOrderCache(); 
				updateCache = false; 
			}
			
			if (hasVisibleMatch()) {
				setRedBackground(false);
				// Select next visible match
				selectVisibleMatchCloseSearchCursor(); 
			} else {
				setRedBackground(true);
			}
		} else {
			select(searchCursor); 
			search = null; 
		}
		oldText = newText; 
	}
	
	public boolean hasVisibleMatch() {
		prepareForUsage();
		SearchResult<EmfMatch> result = search.getResult();
		for (EmfMatch match : result) {
			if (ObjectViewRegistry.getInstance().canShow(match)) {
				return true; 
			}
			if (ObjectViewRegistry.getInstance().canShow(match.getEObject())) {
				return true; 
			}
		}
		return false;
	}
	
	//
	// Traversal
	//
	
	public void nextVisibleEObject() {
		selectedSearchArea = mainSearchArea;
		prepareForUsage();
		direction = TraversalDirection.FORWARD;
		if (updateResults) {
			updateResults(); 
		}
		skipSearchCursor = true; 
		
		if (search != null && search.getResult().size() > 0) {
			searchCursor = search.getResult().get(selectedMatch).getEObject();
			
			// Move to the last attribute of the same object, as UI cannot 
			// Display the attributes anyway
			EObject current = search.getResult().get(selectedMatch).getEObject(); 
			EObject begin = current; 
			
			while (true) {
				// Seeks the next EObject (skip EmfMatches of same EObject)
				while (true) {
 					if (++selectedMatch >= search.getResult().size()) {
 						selectedMatch = 0;
 						break;
 					} else if (search.getResult().get(selectedMatch).getEObject() != current) {
 						break;
					}
				}
				current = search.getResult().get(selectedMatch).getEObject();
				
				if (current == begin) break; // Next was not found
				
				if (select(selectedMatch) == SelectReturn.SHOWS_NEW) break; // We could display it, stop
			}			
		}
	}

	public void prevVisibleEObject() {
		selectedSearchArea = mainSearchArea;
		prepareForUsage();
		direction = TraversalDirection.BACKWARD;
		if (updateResults) {
			updateResults(); 
		}
		skipSearchCursor = true; 

		if (search != null && search.getResult().size() > 0) {
			searchCursor = search.getResult().get(selectedMatch).getEObject();
			
			// Move to the last attribute of the same object, as UI cannot 
			// Display the attributes anyway
			EObject current = search.getResult().get(selectedMatch).getEObject(); 
			EObject begin = current; 
			
			while (true) {
				// Seeks the next EObject (skip EmfMatches of same EObject)
				while (true) {
 					if (--selectedMatch < 0) {
 						selectedMatch =  search.getResult().size()-1;
 						break;
 					} else if (search.getResult().get(selectedMatch).getEObject() != current) {
 						break;
					}
				}
				current = search.getResult().get(selectedMatch).getEObject();
				
				if (current == begin) break; // Next was not found

				if (select(selectedMatch) == SelectReturn.SHOWS_NEW) break; // We could display it, stop
			}				
		}
	}

	//
	// UI utils
	//

	public void setRedBackground(boolean set) {
		if (set && !isColorRed) {	
			isColorRed = true;
			queryText.setBackground(COLOR_RED);
			NextAction.setEnabled(false);
			PreviousAction.setEnabled(false);
		} else if (!set && isColorRed) {
			isColorRed = false;
			queryText.setBackground(COLOR_NORMAL);
			NextAction.setEnabled(true);
			PreviousAction.setEnabled(true);
		}
		
	}
	
	/** The searchable the search is using just changed */
	
}
