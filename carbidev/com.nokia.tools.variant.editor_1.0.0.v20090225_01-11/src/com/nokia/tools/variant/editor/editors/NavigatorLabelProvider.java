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

package com.nokia.tools.variant.editor.editors;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.widgets.Display;

import com.nokia.tools.variant.content.confml.Group;
import com.nokia.tools.variant.content.confml.Icon;
import com.nokia.tools.variant.content.confml.LeafGroup;
import com.nokia.tools.variant.content.confml.ParentGroup;
import com.nokia.tools.variant.editor.Activator;
import com.nokia.tools.variant.editor.summary.SummaryLeafGroup;
import com.nokia.tools.variant.navigator.provider.INavigatorLabelProvider;

public class NavigatorLabelProvider implements INavigatorLabelProvider {
	private ViewEditorModel viewEditorInput;

	public NavigatorLabelProvider(ViewEditorModel viewEditorInput) {
		this.viewEditorInput = viewEditorInput;
	}

	public Image getImage(Object element) {

		if (element instanceof Group) {
			EList<Icon> icon = ((Group) element).getIcon();
			return getImageFromIcon(icon);
		}
		return null;
	}

	public String getText(Object element) {
		if (element instanceof SummaryLeafGroup) {
			if (((SummaryLeafGroup) element).getTypeGroup() == SummaryLeafGroup.TypeGroup.TITLE) {
				String name = viewEditorInput.getCpfMetadata().getName();
				if (name != null)
					((SummaryLeafGroup) element).setName(viewEditorInput
							.getCpfMetadata().getName());
			}
		}
		if (element instanceof ParentGroup) {
			return ((ParentGroup) element).getName();
		}
		if (element instanceof LeafGroup) {
			return ((LeafGroup) element).getName();
		}
		return null;
	}

	public void addListener(ILabelProviderListener listener) {

	}

	public void dispose() {
		viewEditorInput = null;
	}

	public boolean isLabelProperty(Object element, String property) {

		return false;
	}

	public void removeListener(ILabelProviderListener listener) {

	}

	public String getDescription(Object element) {
		if (element instanceof ParentGroup) {
			return ((ParentGroup) element).getDesc();
		}
		if (element instanceof LeafGroup) {
			return ((LeafGroup) element).getDesc();
		}
		return null;
	}

	public String getToolTipText(Object element) {
		if (element instanceof ParentGroup) {
			return ((ParentGroup) element).getDesc();
		}
		if (element instanceof LeafGroup) {
			return ((LeafGroup) element).getDesc();
		}
		return null;
	}

	private Image getImageFromIcon(EList<Icon> icon) {
		if (icon.size() > 0) {
			String filePath = icon.get(0).getFilePath();
			if (filePath != null) {
				URI uri = URI.createURI(filePath);
				uri = viewEditorInput.getVariantContributor().getLastLayer()
						.getDocumentMap().get(uri);
				try {
					ImageData imageData;
					Image im;
					if (uri == null && !filePath.contains("summaryIcon.png")) {
						return null;
					}
					if (uri == null && filePath.contains("summaryIcon.png")) {
						imageData = Activator.getImageDescriptor(
								"icons/summaryIcon.png").getImageData();
						im = new Image(Display.getDefault(), imageData);
					} else {
						URIConverter converter = viewEditorInput
								.getVariantContributor().eResource()
								.getResourceSet().getURIConverter();
						InputStream inputStream = converter
								.createInputStream(uri);
						imageData = new ImageData(inputStream);
						im = new Image(Display.getDefault(), imageData);
						inputStream.close();
					}
					return im;
				} catch (IOException e) {

					e.printStackTrace();
				}

			}
		}
		return null;
	}
}
