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

package com.nokia.tools.variant.editor.listeners;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.PaletteData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Control;

import com.nokia.tools.variant.editor.actions.DragAndDropActionRegistry;
import com.nokia.tools.variant.editor.model.UISetting;
import com.nokia.tools.variant.viewer.widgets.BaseConfMLWidget;
import com.nokia.tools.variant.viewer.widgets.SequenceWidgetItem;

public class WidgetDragSourceListener implements DragSourceListener {

	private UISetting uiSetting;

	public WidgetDragSourceListener(Object object) {
		if (object instanceof UISetting) {
			this.uiSetting = (UISetting) object;
		}
	}

	public void dragFinished(DragSourceEvent event) {
		Action action = DragAndDropActionRegistry.getAction();
		if (action != null) {
			action.run();
			DragAndDropActionRegistry.setAction(null);
			DragAndDropActionRegistry.setStartUISettingWidget(null);
		}
	}

	public void dragSetData(DragSourceEvent event) {
		if (uiSetting != null) {
			event.data = uiSetting;
			StructuredSelection selection = new StructuredSelection(uiSetting);
			LocalSelectionTransfer.getTransfer().setSelection(selection);
		}
	}

	public void dragStart(DragSourceEvent event) {
		Object source = event.getSource();
		if (source instanceof DragSource) {
			DragSource dSource = (DragSource) source;
			Control control = findSequenceItem(dSource.getControl());
			if (control != null) {
				Point size = control.getSize();
				if (control instanceof BaseConfMLWidget) {
					com.nokia.tools.variant.viewer.composite.RulerComposite ruler = ((BaseConfMLWidget) control)
							.getRuler();
					if (ruler != null) {
						Rectangle clientArea = ruler.getScrolledComposite()
								.getClientArea();
						Point location = control.getLocation();
						size.x = clientArea.width-location.x;
					}
				}
				GC gc = new GC(control);
				PaletteData pallete = new PaletteData(0xFF, 0xFF00, 0xff0000);
				ImageData imageData = new ImageData(size.x, size.y, 32, pallete);
				Image image = new Image(control.getDisplay(), imageData);
				gc.copyArea(image, 0, 0);
				ImageData data = image.getImageData();
				imageData.data = data.data;
				Image img = new Image(control.getDisplay(), imageData);
				gc.dispose();
//				event.image = img;
				image.dispose();
			}
			DragAndDropActionRegistry.setStartUISettingWidget(uiSetting);
		}
	}

	private Control findSequenceItem(Control control) {
		if (control == null) {
			return null;
		}
		if (control instanceof SequenceWidgetItem) {
			return control;
		} else {
			return findSequenceItem(control.getParent());
		}
	}
}
