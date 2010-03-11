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
 * Description: This file is part of com.nokia.tools.variant.viewer component.
 */

package com.nokia.tools.variant.viewer.viewer;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.DropTargetListener;

import com.nokia.tools.variant.viewer.validation.ValidationResult;
/**
 * Content provider for {@link SettingsViewer}
 * 
 */
public interface IValuesContentProvider extends ITreeContentProvider {
	/**
	 * 
	 * @param element
	 * @return value of the object, which the widget displays
	 */
	String getValue(Object element);

	/**
	 * 
	 * @param element
	 * @return dirty state of the element, marked as * in ui
	 */
	boolean isDirty(Object element);

	/**
	 * Value in the widget has changed to newValue, so update model accordingly
	 * 
	 * @param newValue
	 * @param element
	 */
	void valueChanged(String newValue, Object element);

	/**
	 * Validate element
	 * 
	 * @param value
	 * @param element
	 * @return
	 */
	public ValidationResult validate(String value, Object element);

	/**
	 * 
	 * @param child
	 * @return DropTargetListener used in the widget for the child
	 */
	DropTargetListener getDropTargetListener(Object child);

	/**
	 * 
	 * @param element
	 * @return has element note defined
	 */
	boolean hasNote(Object element);

	/**
	 * 
	 * @param element
	 * @return is element default
	 */
	boolean isDefault(Object element);

	/**
	 * 
	 * @param data
	 * @return {@link DragSourceListener}, if your widget for the data object
	 *         should be drag source
	 */
	DragSourceListener getDragSourceListener(Object data);
}
