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
package objectview;

import interfaces.IAssignment;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;

import concepts.EObjectStructuralFeature;

/**
 * We assume that user has interest only in one object inside one focus domain. 
 * All views inside the focus domain tries to view this single object. 
 * 
 * Focus domain contain views, where views
 *  - MUST NOT be exclusive. 
 *  - The views always try to display the focus object to the greatest accuracy
 *    - If the object itself cannot be displayed...
 *    - ...the object's context/container should be displayed...
 *    - ...or its container
 *    
 *
 */
public abstract class EObjectFocusDomain implements IObjectView, ISelectionProvider {
	
	private ITreeSelection focus;
	
	private Set<ISelectionChangedListener> listeners; 
	
	public abstract Collection<IObjectView> getViews();
		
	public EObjectFocusDomain() {
		listeners = new HashSet<ISelectionChangedListener>();  
	}
	
	/**
	 * Transforms given object into a tree path. This is done to 
	 * EObjects, by traveling the container hierarchy up to the root. 
	 * Assignments are associated in the hierarchy with the assigned
	 * items. 
	 * 
	 * NOTE: because there is no dependency to ConfML EMF
	 * package, this method is unable to break down the include structure
	 * of the configurations. In case of s60/activeidle configuration, 
	 * the returned tree path is activeidle, instead of s60/activeidle
	 * 
	 * For example, the hierarchy for the value of reference could be
	 * configuration/setting/
	 */
	public static TreePath toTreePath(Object object) {
		LinkedList<Object> tree = new LinkedList<Object>();  
		Object loc = object; 
		
		while (loc != null) {
			tree.addFirst(loc);
			if (loc instanceof IAssignment) {
				loc = ((IAssignment)loc).getAssigned();
			} else if (loc instanceof EObjectStructuralFeature){
				loc = ((EObjectStructuralFeature)loc).getEObject();
			} else if (loc instanceof EObject){
				loc = ((EObject)loc).eContainer(); 
			} else {
				loc = null; 
			}
		}
		return new TreePath(tree.toArray()); 
	}
	
	/**
	 * Returns the longest tree path, which is actually shown in the UI. 
	 * 
	 * E.g. We may seek to show a property of a Bit, forming a path of
	 * crml/repository/key/bit/property. If we failed to show the property, 
	 * the last element in the tree path is the Bit. In case, we could 
	 * only show the bit mask key, the returned path is (crml/repository/key). 
	 */
	public TreePath canFocusUpTo(TreePath path) {
		try {
			TreePath canShow = null; 
			for (IObjectView objectView : getViews()) {
				TreePath tryShow = path; 
				while (tryShow != null) { 
					if (objectView.canShow(tryShow.getLastSegment())) {
						if (canShow == null || tryShow.getSegmentCount() > canShow.getSegmentCount()) {
							canShow = tryShow;
						}
						break;
					}
					tryShow = tryShow.getParentPath();
				}
			}
			return canShow; 
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e); 
		}
	}
	
	public TreePath canFocusUpTo(Object object) {
		return canFocusUpTo(toTreePath(object)); 
	}

	public TreePath canFocusUpTo(EObject object, EAttribute attribute) {
		return canFocusUpTo(toTreePath(new EObjectStructuralFeature(object, attribute))); 
	}

	/**
	 * Try to display the item of tree path in views in the greatest 
	 * accuracy possible. Returns longest tree path, which is actually 
	 * shown in the UI. 
	 */
	public TreePath focus(TreePath path, boolean tryActivate) {
		try {
			TreeSelection newFocus = new TreeSelection(path);
			if (tryActivate || !newFocus.equals(focus)) {
				focus = newFocus; 
				TreePath shown = null; 
				for (IObjectView objectView : getViews()) {
					TreePath tryShow = path; 
					while (tryShow != null) { 
						if (objectView.canShow(tryShow.getLastSegment())) {
							objectView.show(tryShow.getLastSegment(), tryActivate); 
							if (shown == null || tryShow.getSegmentCount() > shown.getSegmentCount()) {
								shown = tryShow;
							}
							break;
						}
						tryShow = tryShow.getParentPath();
					}
				}
				// Fire selection changed 
				for (ISelectionChangedListener l : listeners) {
					l.selectionChanged(new SelectionChangedEvent(this, focus));
				}
				return shown; 
			} else {
 				return canFocusUpTo(path);
			}
		} catch (Exception e) {
			//e.printStackTrace();
			//throw new RuntimeException(e); 
			return null;
		}
	}
	
	public TreePath focus(Object object, boolean tryActivate) {
		return focus(toTreePath(object), tryActivate); 
	}

	public TreePath focus(EObject object, EStructuralFeature feature, boolean tryActivate) {
		if (feature != null) {
			return focus(toTreePath(new EObjectStructuralFeature(object, feature)), tryActivate);
		} else {
			return focus(toTreePath(object), tryActivate);
		}
	}
	
	
	// From IObjectView

	/**
	 * We return true only, if we can display the object up to the last detail
	 */
	public boolean canShow(Object object) {
		TreePath path = toTreePath(object);
		return canFocusUpTo(path) != null;
	}
	
	public void show(Object object, boolean tryActivate) {
		focus(toTreePath(object), tryActivate); 
	}
	
	public void addSelectionChangedListener(ISelectionChangedListener listener) {
		listeners.add(listener); 
	}

	public ISelection getSelection() {
		return focus;
	}

	public TreePath getFocus() {
		if (focus != null && focus.getPaths().length > 0) {
			return focus.getPaths()[0]; 
		}
		return null; 
	}

	public void setSelection(ISelection selection) {
		if (selection instanceof ITreeSelection 
		    && !((ITreeSelection)selection).isEmpty()) {
			focus(((ITreeSelection)selection).getPaths()[0], false);  
		} else {
			focus(null, false); 
		}
	}

	public void removeSelectionChangedListener(
			ISelectionChangedListener listener) {
		listeners.remove(listener); 
	}

}
