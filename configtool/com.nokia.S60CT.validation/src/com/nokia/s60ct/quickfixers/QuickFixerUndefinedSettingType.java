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

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IMarkerResolution;
import org.eclipse.ui.IMarkerResolutionGenerator;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import configurationemf.ConfigurationemfPackage;
import configurationemf.RootConf;
import configurationemf.Setting;
import configurationemf.TYPE;



public class QuickFixerUndefinedSettingType implements IMarkerResolutionGenerator {
	
	@Override
	public IMarkerResolution[] getResolutions(IMarker marker) {
		String value = marker.getAttribute("extrainfo", "");
		return new IMarkerResolution[]{new Fixer(value)};
	}

	
	private class Fixer implements IMarkerResolution
	{

		String value = "";
		
		public Fixer(String value)
		{
			this.value = value;
		}
		
		@Override
		public String getLabel() {
			return "Set type to integer (value: "+value+").";
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
									for (Setting setting : rootConf.getAllSettings())
									{
										if (setting.getType().getValue()==TYPE.UNDEFINED_VALUE)
										{
											String value = setting.getDefaultValue();
											if (value!=null)
											{
												try
												{
													int intValue = Integer.parseInt(value);
													if (intValue!=0 && intValue!=1)
													{
														Command command = SetCommand.create(domain, setting, ConfigurationemfPackage.eINSTANCE.getSetting_Type(), TYPE.INT);
														if(command != null) 
															domain.getCommandStack().execute(command);
													}
												}
												catch (NumberFormatException nfe)
												{
													
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
			try {
				marker.delete();
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
	}
}
