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
package com.nokia.s60ct.search.conf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import com.nokia.s60ct.search.IOrderedSearchArea;
import com.nokia.s60ct.search.ISearchArea;
import com.nokia.s60ct.search.emf.EObjectSearchArea;

import cenrep.Repository;
import configurationemf.Ref;
import configurationemf.RootConf;

public class WorkspaceSearchArea implements IOrderedSearchArea<EObject> {
		
	public WorkspaceSearchArea() {
	}
	
	public Collection<RootConf> getRootConfigurations()
	{
		Vector<RootConf> collection = new Vector<RootConf>();
		IWorkbenchPage[] pages = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getPages();
		for(IWorkbenchPage page : pages){
			for(IEditorReference eref :page.getEditorReferences()){
				IEditorPart editorPart = eref.getEditor(true);
				EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(editorPart);
				if (domain != null)
				{
					ResourceSet rset =  domain.getResourceSet();
					for(Resource resource : rset.getResources())
					{
						if(!resource.getContents().isEmpty())
						{
							EObject obj = resource.getContents().get(0);
							if (obj instanceof RootConf)
							{
								RootConf rootConf = (RootConf)obj;
								collection.add((RootConf)obj);
							}
						}
					}
				}
			}
		}
		return collection;
	}
	
	public Collection<Repository> getRepositories(){
		Vector<Repository> collection = new Vector<Repository>();
		IWorkbenchPage[] pages = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getPages();
		for(IWorkbenchPage page : pages){
			for(IEditorReference eref :page.getEditorReferences()){
				IEditorPart editorPart = eref.getEditor(true);
				EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(editorPart);
				if (domain != null)
				{
					ResourceSet rset =  domain.getResourceSet();
					for(Resource resource : rset.getResources())
					{
						if(!resource.getContents().isEmpty())
						{
							EObject obj = resource.getContents().get(0);
							if (obj instanceof Repository)
							{
								collection.add((Repository)obj); //adds all the crmls
							}
						}
					}
				}
			}
		}
		return collection;
	}

	public Iterator<EObject> iterator() {
		return new Iterator<EObject>() {
			private Collection<RootConf> rootConfs = getRootConfigurations();
			private Collection<Repository> repositories = getRepositories(); 
			private Iterator<EObject> iterator = null; 
			private EObject next = null; 
			public boolean hasNext() {
				while ((next == null) && (iterator == null || !iterator.hasNext())) {
					if (rootConfs.size() > 0) {
						RootConf conf = rootConfs.iterator().next(); 
						next = conf;
						iterator = new ConfigurationSearchArea(conf).iterator();
						rootConfs.remove(conf); 
					} else if (repositories.size() > 0) {
						Repository repository = repositories.iterator().next(); 
						next = repository;
						iterator = new EObjectSearchArea(repository).iterator();
						repositories.remove(repository);
					} else {
						return false;
					}
				}
				if (next == null) {
					next = iterator.next(); 
				}
				return true;
			}
			
			public void filter() {
				// Ref's will mess up the searching order and the assignment 
				// is searched in the settings anyway, causing redundant match
				if (next instanceof Ref) {
					next = null;
					if (hasNext()) {
						filter(); 
					} 
				}
			}
			
			public EObject next() {
				hasNext(); // prepares the iterator
				
				EObject ret = next; 
				next = null; 
				if (hasNext()) {
					filter();
				}
				return ret;
			}
			
			public void remove() {
			}
		};
	}
	
	private ArrayList<EObject> cache; 
	
	/** Comparation is based on cache */
	public void updateOrderCache() {
		cache = new ArrayList<EObject>(100); 
		for (EObject object : this) {
			cache.add(object); 
		}
	}
	
	private ArrayList<EObject> getOrderCache() {
		if (cache == null) {
			updateOrderCache(); 
		}
		return cache; 
	}
	
	public int getOrder(EObject object) {
		return cache.indexOf(object);
	}

	public int compare(EObject arg0, EObject arg1) {
		ArrayList<EObject> cache = getOrderCache(); 
		return cache.indexOf(arg0) - cache.indexOf(arg1);
	}

}
