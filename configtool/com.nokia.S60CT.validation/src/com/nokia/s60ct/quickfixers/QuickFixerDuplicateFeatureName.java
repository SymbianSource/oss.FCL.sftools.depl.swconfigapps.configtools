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
package com.nokia.s60ct.quickfixers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IMarkerResolution;
import org.eclipse.ui.IMarkerResolutionGenerator;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import cenrep.Bit;
import cenrep.CenrepPackage;
import cenrep.Key;
import cenrep.KeyRange;
import cenrep.Repository;

import com.nokia.s60ct.cenrep.gui.ExternalActions.QuickFixOpenCRMLFile;

import configurationemf.ConfigurationemfPackage;
import configurationemf.Feature;
import configurationemf.ParentSetting;
import configurationemf.RootConf;


public class QuickFixerDuplicateFeatureName implements IMarkerResolutionGenerator {
	
	@Override
	public IMarkerResolution[] getResolutions(IMarker marker) {
		return new IMarkerResolution[]{new Fixer()};
	}

	
	private class Fixer implements IMarkerResolution
	{

		@Override
		public String getLabel() {
			return "Merge duplicate features.";
		}

		private void updateCRMLRefs(String oldRef, String newRef)
		{
			boolean found = false;
			Vector repositories = getCRMLs();
			
			for (int i = 0 ; i < repositories.size() ; i++)
			{
				Repository rep = (Repository)repositories.elementAt(i);
				for (Key key : rep.getSimpleKeys())
				{
					try
					{
						System.out.println("splitting ref "+key.getRef());
						String featureRef = key.getRef().split("/")[0];
						if (featureRef.equals(oldRef))
						{
							found = true;
							String settingRef = key.getRef().split("/")[1];
							EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(rep);
							Command cmd = SetCommand.create(domain, key, CenrepPackage.eINSTANCE.getRVG_Ref(), newRef+"/"+settingRef);
							if (cmd != null) {
								domain.getCommandStack().execute(cmd);
							}
						}
					}
					catch (NullPointerException npe)
					{
						
					}
				}
				for (Key key : rep.getBitmaskKeys())
				{
					for (Bit bit : key.getBits())
					{
						try
						{
							String featureRef = bit.getRef().split("/")[0];
							if (featureRef.equals(oldRef))
							{
								found = true;
								String settingRef = bit.getRef().split("/")[1];
								EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(rep);
								Command cmd = SetCommand.create(domain, bit, CenrepPackage.eINSTANCE.getRVG_Ref(), newRef+"/"+settingRef);
								if (cmd != null) {
									domain.getCommandStack().execute(cmd);
								}
							}
						}
						catch (NullPointerException npe)
						{
							
						}
					}
				}
				for (KeyRange range : rep.getRangeKey())
				{
					try
					{
						String featureRef = range.getRef().split("/")[0];
						if (featureRef.equals(oldRef))
						{
							found = true;
							String settingRef = range.getRef().split("/")[1];
							EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(rep);
							Command cmd = SetCommand.create(domain, range, CenrepPackage.eINSTANCE.getRVG_Ref(), newRef+"/"+settingRef);
							if (cmd != null) {
								domain.getCommandStack().execute(cmd);
							}
						}
					}
					catch (NullPointerException npe)
					{
						
					}
				}
			}
			
			if (!found)
			{
				MessageDialog questionDialog = new MessageDialog(null, "CRML not found", null, "CRML file was not updated since matching reference was not found.\nThis probably means that the CRML file was not opened.\nDo you want to open the correct CRML file?", MessageDialog.QUESTION, new String[]{"Open...", "Cancel"}, 2)
				{					
					
				};
				
				questionDialog.setBlockOnOpen(true);
				int retCode = questionDialog.open();
				if (retCode == 0)
				{
					IWorkbench workbench = PlatformUI.getWorkbench();
					IWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();
					new QuickFixOpenCRMLFile(workbenchWindow.getShell());
					updateCRMLRefs(oldRef, newRef);
				}
			}
			
		}
		
		
		
		private Vector getCRMLs()
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
								{
									collection.add(obj); //adds all the crmls
								}
							}
						}
					}
				}
			}
			return collection;
		}
		
		@Override
		public void run(IMarker marker) {
			// Search marker confml in editors
			IWorkbenchPage[] pages = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getPages();
			for (IWorkbenchPage page : pages) {
				for (IEditorReference editorRef : page.getEditorReferences()) {
					IEditorPart editorPart = editorRef.getEditor(true);
					EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(editorPart);
					if (domain != null)
					{
						ResourceSet rset =  domain.getResourceSet();
						for (org.eclipse.emf.ecore.resource.Resource resource : rset.getResources()) {
							if (resource.getURI().lastSegment().equals(marker.getResource().getName())) {
								// Get RootConf
								if (!resource.getContents().isEmpty())
								{
									RootConf rootConf = (RootConf) resource.getContents().get(0);
									Map<String, Feature> noDupMap = new HashMap<String, Feature>();
									List<Feature> removeFeatures = new ArrayList<Feature>();
									Vector<Command> commands = new Vector<Command>();
									// Search marker feature
									for(Iterator<Feature> iFeature = rootConf.getFeature().iterator() ; iFeature.hasNext();){
									//for (Feature feature : rootConf.getFeature()) {
											Feature feature = iFeature.next();
											if (!noDupMap.keySet().contains(feature.getName()))  // Feature ref saved in bookmark
												noDupMap.put(feature.getName(), feature);
											else {
												
													Feature removable = noDupMap.get(feature.getName());
													for (ParentSetting setting : removable.getParentSetting()) {
														Command command = AddCommand.create(domain, feature, ConfigurationemfPackage.eINSTANCE.getFeature_ParentSetting(), setting);
														commands.add(command);
													}
													for (Command cmd : commands)
														if(cmd != null) domain.getCommandStack().execute(cmd);
													noDupMap.remove(feature.getName());
													noDupMap.put(feature.getName(), feature);
													removeFeatures.add(removable);
													updateCRMLRefs(removable.getRef(), feature.getRef());
												}
									}
									Command command = RemoveCommand.create(domain, removeFeatures);
									if(command != null) domain.getCommandStack().execute(command);
									
								}
							}
						}
					}
				}
			}
			try 
			{
				marker.delete();
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
	}
}
