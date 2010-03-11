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

package com.nokia.tools.variant.confml.ui.dialogs;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.program.Program;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import com.nokia.tools.vct.common.appmodel.EConfMLLayer;

/**
 * This class provides the labels for the file tree
 */

public class IconSelectionLabelProvider extends LabelProvider {
	private ImageRegistry imageRegistry;

	public IconSelectionLabelProvider() {
		super();
	}

	public Image getImage(Object element) {
		if (element instanceof EConfMLLayer) {
			return PlatformUI.getWorkbench().getSharedImages().getImage(
					ISharedImages.IMG_OBJ_FOLDER);
		} else if (element instanceof URI) {
			String extension = ((URI) element).fileExtension();
			if (imageRegistry == null)
				imageRegistry = new ImageRegistry();
			Image image = imageRegistry.get(extension);
			if (image != null)
				return image;

			Program program = Program.findProgram(extension);
			ImageData imageData = (program == null ? null : program
					.getImageData());
			if (imageData != null) {
				image = new Image(Display.getCurrent(), imageData);
				imageRegistry.put(extension, image);
			} else {
				image = PlatformUI.getWorkbench().getSharedImages().getImage(
						ISharedImages.IMG_OBJ_FILE);
			}
			return image;
		}

		return null;
	}

	public String getText(Object element) {
		if (element instanceof EConfMLLayer) {
			return ((EConfMLLayer) element).getName();
		} else if (element instanceof URI) {
			return element.toString(); 
		}
		return "Undefined";
	}

	public void dispose() {
		if (imageRegistry != null) {
			imageRegistry.dispose();
		}
	}

}
