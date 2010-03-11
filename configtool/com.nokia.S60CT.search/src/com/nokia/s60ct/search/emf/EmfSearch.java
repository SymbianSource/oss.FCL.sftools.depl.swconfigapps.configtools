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

package com.nokia.s60ct.search.emf;

import org.eclipse.emf.ecore.EObject;

import com.nokia.s60ct.search.IQuery;
import com.nokia.s60ct.search.Search;
import com.nokia.s60ct.search.ISearchArea;

public class EmfSearch extends Search<EObject, EmfMatch> {

	public EmfSearch(ISearchArea<EObject> searchArea,
			IQuery<EObject, EmfMatch> query) {
		super(searchArea, query);
	}

}
