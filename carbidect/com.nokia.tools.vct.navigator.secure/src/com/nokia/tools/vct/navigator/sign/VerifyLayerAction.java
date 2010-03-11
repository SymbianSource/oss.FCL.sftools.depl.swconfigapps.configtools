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

package com.nokia.tools.vct.navigator.sign;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.nokia.tools.vct.common.appmodel.EConfMLLayer;
import com.nokia.tools.vct.common.appmodel.util.CPFSigningUtils;
import com.nokia.tools.vct.common.secure.core.SigningStatus;

public class VerifyLayerAction extends Action {

	private EConfMLLayer layer;

	public VerifyLayerAction(EConfMLLayer layer) {
		setText("Verify Layer Signature");
		this.layer = layer;
	}

	@Override
	public void run() {
		SigningStatus status = CPFSigningUtils.getLayerStatus(layer);
		
		final Shell shell = Display.getCurrent().getActiveShell();
		if (status.contentOK) {
			MessageDialog.openInformation(shell, "Layer verification", "Layer is correctly signed");
		} else if (!status.signatureFound) {
			MessageDialog.openError(shell, "Layer verification", "Layer is not signed");
		} else if (!status.signatureParsed) {
			MessageDialog.openError(shell, "Layer verification", "Layer signature can not be parsed");
		} else if (!status.signatureValid) {
			MessageDialog.openError(shell, "Layer verification", "Layer signature file is modified");
		} else {
			StringBuilder tmp = new StringBuilder();
			tmp.append("Layer contents is modified:\n");
			tmp.append("Unsigned files: ").append(status.addedFiles.size()).append("\n");
			for (URI uri : status.addedFiles) {
				tmp.append("\t").append(uri.toString()).append("\n");
			}
			tmp.append("Removed files: ").append(status.removedFiles.size()).append("\n");
			for (URI uri : status.removedFiles) {
				tmp.append("\t").append(uri.toString()).append("\n");
			}
			tmp.append("Modified files: ").append(status.tamperedFiles.size()).append("\n");
			for (URI uri : status.tamperedFiles) {
				tmp.append("\t\"").append(uri.toString()).append("\"\n");
			}
			MessageDialog.openError(shell, "Layer verification", tmp.toString());
		}
	}

}
