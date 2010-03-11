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
package com.nokia.s60ct.search;

import java.util.Collection;

/**
 * The generic parameter T describes the items that are searched over. E 
 * describes the class of matches in the search result. 
 * 
 */
public class Search<T,E> {
	
	private ISearchArea<T> searchArea; 

	private IQuery<T, E> query; 
	
	private SearchResult<E> result; 
	
	public Search(ISearchArea<T> searchArea, IQuery<T, E> query) {
		this.searchArea = searchArea; 
		this.query = query;
	}
	
	public ISearchArea<T> getSearchArea() {
		return searchArea;
	}
	
	public IQuery<T, E> getQuery() {
		return query; 
	}
	
	public void updateSearch() {
		this.result = new SearchResult<E>(); 
		for (T object : searchArea) {
			Collection<E> matches = query.getMatches(object);
			for (E match : matches) {
				result.add(match); 
			}
		}
	}
	
	public SearchResult<E> getResult() {
		if (result == null) {
			updateSearch(); 
		}
		return result; 
	}

}