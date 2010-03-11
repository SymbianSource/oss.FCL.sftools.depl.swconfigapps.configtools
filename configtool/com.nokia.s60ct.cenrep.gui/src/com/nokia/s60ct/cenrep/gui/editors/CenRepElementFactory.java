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
package com.nokia.s60ct.cenrep.gui.editors;

import helpers.DefaultProject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.URI;
import org.eclipse.ui.IElementFactory;
import org.eclipse.ui.IMemento;

public class CenRepElementFactory implements IElementFactory {

	/**
     * Factory id. The workbench plug-in registers a factory by this name
     * with the "org.eclipse.ui.elementFactories" extension point.
     */
    private static final String ID_FACTORY = "com.nokia.s60ct.cenrep.gui.editors.CenRepElementFactory"; //$NON-NLS-1$

    /**
     * Tag for the IFile.fullPath of the file resource.
     */
    private static final String TAG_PATH = "path"; //$NON-NLS-1$

    /**
     * Creates a new factory.
     */
    public CenRepElementFactory() {
    }

    /* (non-Javadoc)
     * Method declared on IElementFactory.
     */
    public IAdaptable createElement(IMemento memento) {
        // Get the file name.
        String pathList = memento.getString(TAG_PATH);
        if (pathList == null) {
			return null;
		}
        String[] pathArr = pathList.split(File.pathSeparator);
        List<IFile> files = new ArrayList<IFile>();
        for(String path : pathArr){
        	IFile file = DefaultProject.createLinkFile(URI.createFileURI(path));
        	if(file!=null) files.add(file);
        }
        if (!files.isEmpty()) {
			return new CRBrowserEditorInput(files);
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
    public static void saveState(IMemento memento, CRBrowserEditorInput input) {
        StringBuffer buffer = new StringBuffer();
    	for(IFile file : input.getFiles()){
    		if(file.isLinked()){// for DefaultProject
    			buffer.append(file.getRawLocation().toString()+File.pathSeparator);
    		}else // for normal project, not DefaultProject
    			buffer.append(file.getFullPath().toString()+File.pathSeparator);
    	}
        memento.putString(TAG_PATH, buffer.toString());
    }
	
}
