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

package com.nokia.tools.variant.editor.model.convertor;

import org.eclipse.emf.common.util.URI;

import com.nokia.tools.variant.confml.core.model.application.EConfigurationProject;
import com.nokia.tools.variant.content.confml.View;


public interface ViewModel2ConfMLPersistenceModelConvertor {

	/**
	 * Copy edited values and group structure from UI model
	 * <code>fromView</code> back to variant contributor <code>vp</code>
	 * 
	 * @param fromView
	 *            UI model
	 * @param toVariantContributor
	 *            model to update
	 * @param toViewId
	 *            id of the view which should be used for modification (e.g. in
	 *            case that some groups were modified in UI model)
	 */
	public abstract void copyValues(View fromView,
			EConfigurationProject toVariantContributor, String toViewId,
			URI pathToSave);

	public abstract void removeHiddenSettings(View fromView,
			EConfigurationProject cp);

}
