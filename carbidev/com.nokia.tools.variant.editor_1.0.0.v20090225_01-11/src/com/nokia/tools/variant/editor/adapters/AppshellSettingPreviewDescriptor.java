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

package com.nokia.tools.variant.editor.adapters;

import java.io.File;

import org.eclipse.swt.graphics.Point;
import org.eclipse.ui.IEditorPart;

import com.nokia.tools.variant.preview.IPreviewDescriptor;
import com.nokia.tools.variant.preview.PreviewController;

/**
 * Provides a basic data about the appshell.
 */
public class AppshellSettingPreviewDescriptor implements IPreviewDescriptor {

	private File file;
	private int sizeX;
	private int sizeY;
	private IEditorPart editor;
	
	/**
	 * Constructs a AppshellSettingPreviewDescriptor.
	 * 
	 * @param editor
	 * @param file
	 * @param sizeX
	 * @param sizeY
	 */
	public AppshellSettingPreviewDescriptor(IEditorPart editor, File file, int sizeX, int sizeY) {
		this.file = file;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.editor = editor;
	}
	
	/**
	 * Creates a new PreviewController
	 * 
	 * @return PreviewController
	 */
	public PreviewController createPreviewControl() {
		return new AppshellSettingPreviewController();
	}

	/**
	 * 
	 * @return File
	 */
	public File getFile() {
		return file;
	}
	
	/**
	 * 
	 * @return Point
	 */
	public Point getSize() {
		return new Point(sizeX, sizeY);
	}
	
	/**
	 * 
	 * @return IEditorPart
	 */
	public IEditorPart getEditorPart() {
		return editor;
	}
}
