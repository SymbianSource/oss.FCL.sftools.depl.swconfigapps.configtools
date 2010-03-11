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

package com.nokia.tools.vct.internal.common.secure.ui.editor;

import java.security.cert.X509Certificate;

import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.IFontProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

import com.nokia.tools.vct.common.secure.core.IKeyStoreEntry;
import com.nokia.tools.vct.common.secure.core.IKeyStoreManager;
import com.nokia.tools.vct.common.secure.core.SecurityCorePlugin;

public class KeysLabelProvider extends LabelProvider implements
		ITableLabelProvider, IFontProvider, IColorProvider {

	private Font boldFont;

	public KeysLabelProvider(Font boldFont) {
		this.boldFont = boldFont;
	}

	public Image getColumnImage(Object element, int columnIndex) {
		return null;
	}

	public String getColumnText(Object element, int columnIndex) {
		if (element instanceof IKeyStoreEntry) {
			IKeyStoreEntry entry = (IKeyStoreEntry) element;
			
			try {
				switch (columnIndex) {
				case 0:
					return entry.hasPrivateKey() ? "Pair" : "X.509";
				case 1:
					return entry.getName();
				case 2:
					return entry.getOrganization();
				case 3:
					return entry.getDate();
				}
			} catch (Exception ex) {
				return "error";
			}

		}
		return null;
	}

	public Font getFont(Object element) {
		if (element instanceof IKeyStoreEntry) {
			IKeyStoreEntry entry = (IKeyStoreEntry) element;
			IKeyStoreManager manager = SecurityCorePlugin.getKeyStoreManager();
			if (entry.equals(manager.getDefaultEntry())) {
				return boldFont;
			}
		}
		return null;
	}

	public Color getBackground(Object element) {
		return null;
	}

	public Color getForeground(Object element) {
		IKeyStoreEntry entry = (IKeyStoreEntry) element;
		if (entry.hasPrivateKey()) {
			IKeyStoreManager manager = SecurityCorePlugin.getKeyStoreManager();
			try {
				X509Certificate cert = manager.getCertificate(entry);
				cert.checkValidity();
			} catch (Exception ex) {
				return Display.getCurrent().getSystemColor(SWT.COLOR_RED);
			}
		}
		return null;
	}

	@Override
	public void dispose() {
		boldFont.dispose();
	}
}
