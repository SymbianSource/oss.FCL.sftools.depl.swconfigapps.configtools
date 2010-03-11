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

package com.nokia.tools.variant.confml.ui.editors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.ListenerList;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.jface.util.SafeRunnable;
import org.eclipse.jface.viewers.IPostSelectionProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TreeViewer;

public class CompositeSelectionProvider implements IPostSelectionProvider {

    private ListenerList listeners = new ListenerList();
    
    private ListenerList postListeners = new ListenerList();
    
    private boolean setting;

    private ISelectionChangedListener selectionChangeListener = new ISelectionChangedListener() {
	
		public void selectionChanged(SelectionChangedEvent event) {
			if (setting && lastSelectedViewer != event.getSelectionProvider()) {
				return;
			}
			
			lastSelectedViewer = (StructuredViewer)event.getSelectionProvider();
			Object[] listenersArray = listeners.getListeners();
			fireEventChange(event, listenersArray);
		}
	};

	private StructuredViewer lastSelectedViewer = null;
	
	/**
	 * Nested selection providers
	 */
	private List<StructuredViewer> selectionProviders = new ArrayList<StructuredViewer>();


    public CompositeSelectionProvider(TreeViewer viewTv, TreeViewer confmlTv) {
    	selectionProviders.add(viewTv);
    	selectionProviders.add(confmlTv);
        for (ISelectionProvider nestedProvider : selectionProviders) {
        	nestedProvider.addSelectionChangedListener(selectionChangeListener);
		}
    }

    public CompositeSelectionProvider(StructuredViewer ... providers) {
    	selectionProviders.addAll(Arrays.asList(providers));
        for (ISelectionProvider nestedProvider : selectionProviders) {
        	nestedProvider.addSelectionChangedListener(selectionChangeListener);
		}
    }

    
    public void addSelectionChangedListener(ISelectionChangedListener listener) {
        listeners.add(listener);
    }

    public void addPostSelectionChangedListener(ISelectionChangedListener listener) {
    	postListeners.add(listener);
	}

    public void fireSelectionChanged(final SelectionChangedEvent event) {
        Object[] listeners = this.listeners.getListeners();
        fireEventChange(event, listeners);
    }

    public void firePostSelectionChanged(final SelectionChangedEvent event) {
		Object[] listeners = postListeners.getListeners();
		fireEventChange(event, listeners);
	}

	private void fireEventChange(final SelectionChangedEvent event, Object[] listeners) {
		for (int i = 0; i < listeners.length; ++i) {
            final ISelectionChangedListener l = (ISelectionChangedListener) listeners[i];
            SafeRunner.run(new SafeRunnable() {
                public void run() {
                    l.selectionChanged(event);
                }
            });
        }
	}
    
    public ISelection getSelection() {
    	if (lastSelectedViewer == null) {
    		return StructuredSelection.EMPTY;
    	}
    	return lastSelectedViewer.getSelection();
    }

    /* (non-JavaDoc)
     * Method declaed on <code>ISelectionProvider</code>.
     */
    public void removeSelectionChangedListener(
            ISelectionChangedListener listener) {
        listeners.remove(listener);
    }
    
    /**
     * Removes a listener for post selection changes in this multi page selection provider.
     *
     * @param listener a selection changed listener
     * @since 3.2
     */
    public void removePostSelectionChangedListener(ISelectionChangedListener listener) {
    	postListeners.remove(listener);
	}

	/* (non-Javadoc)
     * Method declared on <code>ISelectionProvider</code>.
     */
    public void setSelection(ISelection selection) {
    	setting = true;
    	for (StructuredViewer provider: selectionProviders) {
    		provider.setSelection(selection, true);
    	}
    	setting = false;
    }
    
    public void dispose() {
    	for (int i = 0 ; i < selectionProviders.size() ; i++) {
    		ISelectionProvider postSelectionProvider = selectionProviders.get(i);
    		Object[] listeners2 = listeners.getListeners();
    		for (int j = 0 ; j < listeners2.length ; j++) {
    			ISelectionChangedListener listener = (ISelectionChangedListener) listeners2[j];
    			postSelectionProvider.removeSelectionChangedListener(listener);
    		}
    	}
    }
}
