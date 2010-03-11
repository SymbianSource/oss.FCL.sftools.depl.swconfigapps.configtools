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

package com.nokia.tools.variant.editor.utils;

import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.ui.IMemento;

/**
 * An  implementation of an {@link org.eclipse.ui.IEditorInput} to wrap
 * a {@link org.eclipse.emf.common.util.URI}. 
 */
public class FileEditorInput extends URIEditorInput {

	/**
	 * Constructs EditorInput
	 * @param uri
	 */
	public FileEditorInput(URI uri) {
		super(uri);
	}

	/**
	 * Getter for ToolTipText <br>
	 * Returns URI as String
	 */
	public String getToolTipText() {
		if (getURI().isFile()) {
			return getURI().toFileString();
		}
		return super.getToolTipText();
	}

	/**
	 * Getter for FileEditorInputFactory id
	 */
	public String getFactoryId() {
		return FileEditorInputFactory.getFactoryId();
	}

	/**
	 * Save editor's files
	 * 
	 * @see {@link #saveState(IMemento)}
	 */
	public void saveState(IMemento memento) {
		FileEditorInputFactory.saveState(memento, this);
	}

}
