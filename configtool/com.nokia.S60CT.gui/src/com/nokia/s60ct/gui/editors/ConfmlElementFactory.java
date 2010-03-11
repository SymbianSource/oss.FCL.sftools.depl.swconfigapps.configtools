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
package com.nokia.s60ct.gui.editors;

import helpers.DefaultProject;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.URI;
import org.eclipse.ui.IElementFactory;
import org.eclipse.ui.IMemento;

public class ConfmlElementFactory implements IElementFactory {

	/**
     * Factory id. The workbench plug-in registers a factory by this name
     * with the "org.eclipse.ui.elementFactories" extension point.
     */
    private static final String ID_FACTORY = "com.nokia.S60CT.confml"; //$NON-NLS-1$

    /**
     * Tag for the IFile.fullPath of the file resource.
     */
    private static final String TAG_PATH = "path"; //$NON-NLS-1$

    /**
     * Creates a new factory.
     */
    public ConfmlElementFactory() {
    }

    /* (non-Javadoc)
     * Method declared on IElementFactory.
     */
    public IAdaptable createElement(IMemento memento) {
        // Get the file name.
        String fileName = memento.getString(TAG_PATH);
        if (fileName == null) {
			return null;
		}

        // Get a handle to the IFile...which can be a handle
        // to a resource that does not exist in workspace
        IFile file = DefaultProject.createLinkFile(URI.createFileURI(fileName));
        if (file != null) {
			return new CBrowserEditorInput(file);
		} else {
			return null;
		}
    }

    /**
     * Returns the element factory id for this class.
     * 
     * @return the element factory id
     */
    public static String getFactoryId() {
        return ID_FACTORY;
    }

    /**
     * Saves the state of the given file editor input into the given memento.
     *
     * @param memento the storage area for element state
     * @param input the file editor input
     */
    public static void saveState(IMemento memento, CBrowserEditorInput input) {
        IFile file = input.getFile();
        if(file.isLinked())
        	memento.putString(TAG_PATH, file.getRawLocation().toString());
        else
        	memento.putString(TAG_PATH, file.getFullPath().toString());
    }

}
