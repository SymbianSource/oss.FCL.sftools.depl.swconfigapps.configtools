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


import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.URI;
import org.eclipse.ui.IElementFactory;
import org.eclipse.ui.IMemento;

/**
 * Part of save and load for list of recently opened files.
 * 
 */
public class FileEditorInputFactory implements IElementFactory {
	private static final String ID_FACTORY = "com.nokia.tools.variant.editor.utils.FileEditorInputFactory";
	private static final String TAG_FILE = "file";
	
	public FileEditorInputFactory() {
	}

	/**
	 * Creates {@link FileEditorInput} from given {@link IMemento}
	 * 
	 * @param IMemento
	 * @return IAdaptable (FileEditorInput)
	 */
	public IAdaptable createElement(IMemento memento) {

		String fileName = memento.getString(TAG_FILE);
		if (fileName == null)
			return null;
		String file = fileName;
		if (file != null) {
			return new FileEditorInput(URI.createURI(file));
		} else {
			return null;
		}
	}

	/**
	 * Getter for FileEditorInputFactory id
	 */
	public static String getFactoryId() {
		return ID_FACTORY;
	}

	/**
	 * Save editor's files	 
	 */
	public static void saveState(IMemento memento,
			FileEditorInput input) {
		memento.putString(TAG_FILE, input.getURI().toString());
	}
}
