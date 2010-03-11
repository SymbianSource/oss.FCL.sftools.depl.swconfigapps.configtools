/*
 * Copyright (c) 2009 Nokia Corporation and/or its subsidiary(-ies). 
 * All rights reserved.
 * This component and the accompanying materials are made available
 * under the terms of the License "Symbian Foundation License v1.0"
 * which accompanies this distribution, and is available
 * at the URL "http://www.symbianfoundation.org/legal/sfl-v10.html".
 * 
 * Initial Contributors:
 * Nokia Corporation - Initial contribution
 * 
 * Contributors:
 * 
 * Description: This file is part of com.nokia.tools.variant.confml.core component.
 */

package com.nokia.tools.variant.confml.internal.core.project;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;

import com.nokia.tools.variant.common.core.utils.PlatformUtil;
import com.nokia.tools.variant.confml.core.ConfMLCore;
import com.nokia.tools.variant.confml.core.model.application.EConfigurationProject;

/**
 * Adapts inbound object into {@link EVariantContributor} or
 * {@link EVariantProject}
 * 
 */
public class ProjectAdapterFactory implements IAdapterFactory {

	static final Class<?>[] ADAPTERS = { EConfigurationProject.class};

	@SuppressWarnings("unchecked")
    public Object getAdapter(Object adaptableObject, Class adapterType) {
		if (!EConfigurationProject.class.equals(adapterType)) {
			return null;
		}

		final IProject project = PlatformUtil.getAdapter(adaptableObject,
				IProject.class, true);
		if (project == null) {
			return null;
		}

		TransactionalEditingDomain domain = ConfMLCore.getEditingDomain();
		EConfigurationProject vp = null;
		try {
			vp = TransactionUtil.runExclusive(domain,
					new RunnableWithResult.Impl<EConfigurationProject>() {
						public void run() {
							setResult(ConfMLCore.getProjectModel(project));
						}
					});
		} catch (InterruptedException e) {
		}

		return vp;
	}

	public Class<?>[] getAdapterList() {
		return ADAPTERS.clone();
	}

}
