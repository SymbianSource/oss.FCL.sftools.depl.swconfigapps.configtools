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
package com.nokia.s60ct.general;

import generate.CenrepGenerator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.validation.model.IConstraintStatus;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import cenrep.Key;
import cenrep.Repository;
import configurationemf.Configuration;
import configurationemf.Data;
import configurationemf.Ref;
import configurationemf.RootConf;

public class Validator {

	
	public Validator()
	{
		
	}
	/*
	public int getNumberOfErrors(IStatus[] status)
	{
		System.out.println("getNumberOfErrors");
		int errors = 0;
		for (int i = 0 ; i < status.length ; i++)
		{
			if (status[i].getChildren().length==0)
			{
				if (status[i].getSeverity() == IStatus.ERROR)
					errors++;
				else
					System.out.println("STATUS: "+status[i].getSeverity());
			}
			for (IStatus iStatus : status[i].getChildren())
			{
				System.out.println("inside for loop");
				if (iStatus instanceof IConstraintStatus)
				{
					if (iStatus.getSeverity() == IStatus.ERROR)
						errors++;
					else
						System.out.println("STATUS: "+status[i].getSeverity());
				}
				else //if (iStatus instanceof AbstractValidator$AggregateStatus)
				{
					for (IStatus iStatusChildren : iStatus.getChildren()) {
						if (iStatusChildren.getSeverity() == IStatus.ERROR)
							errors++;
						else
							System.out.println("STATUS: "+status[i].getSeverity());
					}
				}
			}
		}
		return errors;
	}*/
	
	public Collection getRootConfiguration() //only for GUI
	{
		Vector collection = new Vector();
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
						if (resource != null && resource.getContents().size() > 0)
						{
							if(!resource.getContents().isEmpty())
							{
								EObject obj = resource.getContents().get(0);
								if (obj instanceof RootConf) //we want to exclude based-on confs
								{
									RootConf rootConf = (RootConf)obj;
									if (rootConf.getRoot() == null)
										collection.add(obj);
								}
							}
						}
					}
				}
			}
		}
		return collection;
	}
	
	public Collection getCRMLs(Configuration conf)
	{
		Vector collection = new Vector();
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
						if(!resource.getContents().isEmpty()){
							EObject obj = resource.getContents().get(0);
							if (obj instanceof Repository)
								collection.add(obj); //adds all the crmls
						}
					}
				}
			}
		}

		if (conf == null)
			return collection;
		else
			return filterCRMLCollection(conf, collection);
	}
	
	public Collection filterCRMLCollection(Configuration conf, Vector collection)
	{
		Vector resultCollection= new Vector(collection.size());
		List<Ref> collectionOfRefs= collectRefs(conf);
		for (int i=0; i<collection.size();i++) {
			Repository rep = (Repository)collection.elementAt(i);
			boolean foundRep=false;
			for (Key key : rep.getKey()) {
				for (Ref ref : collectionOfRefs) {
					if(key.getRef()!=null){
						String[] refs = key.getRef().split("/");
						if (refs[0].equals(ref.getAbsRef()))
						{
							foundRep=true;
							resultCollection.add(rep);
							break;
						}
					}
				}
				if(foundRep)
					break;
				
			}
			if(!foundRep && rep.getRangeKey()!=null && (rep.getKey()==null || rep.getKey().size()==0))
				resultCollection.add(rep);
		}
		return resultCollection;
	}
	
	private List collectRefs(Configuration conf){
		List<Ref> refs = new ArrayList<Ref>();
		Data data = conf.getData();
		if(data!=null)
			refs = data.getRef();
		
		if (((RootConf)conf).getInclude()!= null)
		for (RootConf childConf : ((RootConf)conf).getInclude()) {
			List<Ref> childRefs = collectRefs(childConf);
			if(childRefs!=null)
			{
				for (int i = 0 ; i < childRefs.size() ; i++)
					if (childRefs.get(i) instanceof Ref)
						refs.add(childRefs.get(i));
			}
		}
		return refs; 
	}
	
	public static String getStrSeverity(IStatus status){
		switch(status.getSeverity()){
		case IStatus.INFO:
			return "INFO";
		case IStatus.WARNING:
			return "WARNING";
		case IStatus.ERROR:
			return "ERROR";
		
		}
		return ":)";
	}
}
