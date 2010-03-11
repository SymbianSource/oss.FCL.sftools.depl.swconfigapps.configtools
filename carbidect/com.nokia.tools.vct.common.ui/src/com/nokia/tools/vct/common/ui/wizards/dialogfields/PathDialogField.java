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
 * Description: This file is part of com.nokia.tools.vct.common.ui component.
 */

package com.nokia.tools.vct.common.ui.wizards.dialogfields;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;


public class PathDialogField extends StringDialogField {
	public PathDialogField() {
		super();
	}
	
	public boolean isValidPath() {
		String value = getText().trim();
		return new Path("").isValidSegment(value);
	}
	
	public IPath getPath() {
		if (isValidPath()) {
			return new Path(getText().trim());
		} else {
			return null;
		}
	}
	
	public void setPath(IPath path) {
		if (path == null) {
			setText("");
		} else {
			setText(path.toPortableString());
		}
	}
}
