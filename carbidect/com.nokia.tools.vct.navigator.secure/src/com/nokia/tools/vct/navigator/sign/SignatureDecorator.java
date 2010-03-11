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

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;

import com.nokia.tools.variant.confml.core.ConfMLCore;
import com.nokia.tools.vct.common.appmodel.EConfMLLayer;
import com.nokia.tools.vct.common.appmodel.EConfigurationProject;
import com.nokia.tools.vct.common.appmodel.util.CPFSigningUtils;
import com.nokia.tools.vct.common.secure.core.SigningStatus;
import com.nokia.tools.vct.common.secure.core.SigningUtils;

public class SignatureDecorator implements ILightweightLabelDecorator {
	
	private ListenerList listenerList;
	
	public SignatureDecorator() {
		listenerList = new ListenerList();
	}

	public void decorate(final Object element, final IDecoration decoration) {
		
		TransactionalEditingDomain domain = ConfMLCore.getEditingDomain();
		try {
			domain.runExclusive(new Runnable() {
				public void run() {
					decorate2(element, decoration);
				}
			});
		} catch (InterruptedException e) {
		}
	}
	
	void decorate2(Object element, IDecoration decoration) {
		if (element instanceof IResource && !(element instanceof IWorkspaceRoot)) {
			IResource resource = (IResource)element;
			
			URI resourceURI = URI.createPlatformResourceURI(resource.getFullPath().toString(), true);
			if (resource instanceof IContainer) {
				resourceURI = resourceURI.appendSegment("");
			}
			
			EConfigurationProject cpf = ConfMLCore.getProjectModel(resource.getProject());
			EConfMLLayer layer = ConfMLCore.getLayer((IResource)element);
			if (cpf == null) {
				return;
			}
			if (resource instanceof IProject) {
				SigningStatus status = CPFSigningUtils.getRootStatus(cpf);
				if (!status.signatureFound) {
					decoration.addSuffix(" [unsigned]");
				} else if (status.contentOK) {
					decoration.addSuffix(" [signed: "+SigningUtils.getShortName(status.certificate)+"]");
				} else {
					decoration.addSuffix(" [signature error]");
				}
				return;
			} else if (layer != null){
				if (resourceURI.equals(layer.getLayerURI())) {
					SigningStatus status = CPFSigningUtils.getLayerStatus(layer);
					if (!status.signatureFound) {
						decoration.addSuffix(" [unsigned]");
					} else if (status.contentOK) {
						decoration.addSuffix(" [signed: "+SigningUtils.getShortName(status.certificate)+"]");
					} else {
						decoration.addSuffix(" [signature error]");
					}
				}
			}
		} else if (element instanceof EConfMLLayer) {
			
		}
	}

	public void addListener(ILabelProviderListener listener) {
		listenerList.add(listener);
	}

	public void dispose() {
		listenerList.clear();
	}

	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	public void removeListener(ILabelProviderListener listener) {
		listenerList.remove(listener);
	}

}
