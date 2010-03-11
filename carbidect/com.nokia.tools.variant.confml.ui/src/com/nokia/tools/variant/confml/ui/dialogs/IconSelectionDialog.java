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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;

import com.nokia.tools.variant.confml.ui.ConfmlUI;

public class IconSelectionDialog extends ElementTreeSelectionDialog {

	public IconSelectionDialog(Shell parent) {
		super(parent, new IconSelectionLabelProvider(), new IconSelectionContentProvider());

		setEmptyListMessage("No images found in confml directory");
		setAllowMultiple(false);
		setMessage("Select an icon for the group:");
		setTitle("Select image file");

		setValidator(new ISelectionStatusValidator() {
			public IStatus validate(Object[] selection) {
				if (selection.length == 1 && selection[0] instanceof URI) {
					return Status.OK_STATUS;
				} else {
					return new Status(IStatus.ERROR,ConfmlUI.PLUGIN_ID, "Select icon file");
				}
			}
		});
		
	}

}
