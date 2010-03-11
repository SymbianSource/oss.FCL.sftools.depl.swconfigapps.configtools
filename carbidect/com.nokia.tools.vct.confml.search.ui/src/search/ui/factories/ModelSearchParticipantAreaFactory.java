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
 * Description: This file is part of com.nokia.tools.vct.confml.search.ui component.
 */

package search.ui.factories;

import org.eclipse.emf.search.ui.areas.IModelSearchArea;
import org.eclipse.emf.search.ui.areas.IModelSearchAreaFactory;
import org.eclipse.emf.search.ui.pages.AbstractModelSearchPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import search.ui.areas.ModelSearchParticipantArea;

/**
 * Wrapper class which create a specific participant area into the model search page.
 */
public class ModelSearchParticipantAreaFactory implements
		IModelSearchAreaFactory {
	public IModelSearchArea createArea(Composite parent,
			AbstractModelSearchPage searchPage) {
		return new ModelSearchParticipantArea(parent, searchPage, SWT.NONE);
	}

	public IModelSearchArea createArea(Composite parent,
			AbstractModelSearchPage searchPage, String nsURI) {
		return new ModelSearchParticipantArea(parent, searchPage, SWT.NONE,
				nsURI);
	}
}
