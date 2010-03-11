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
package com.nokia.tools.variant.confml.ui.properties;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

import com.nokia.tools.variant.confml.core.ConfMLCore;
import com.nokia.tools.variant.confml.ui.properties.fields.StringFieldEditor;
import com.nokia.tools.vct.common.appmodel.EAppIncludeElement;
import com.nokia.tools.vct.common.appmodel.EAppView;
import com.nokia.tools.vct.common.appmodel.EConfMLLayer;
import com.nokia.tools.vct.common.appmodel.EConfigurationProject;

public class ConfigurationProjectSection extends AbstractPropertySection {

		private Section control;
		private IProject project;
		private StringFieldEditor layerInfo;
		private StringFieldEditor rootInfo;
		private StringFieldEditor defaultViewInfo;
		private StringFieldEditor dataInfo;

		public ConfigurationProjectSection() {
			
			layerInfo = new StringFieldEditor(SWT.MULTI);
			layerInfo.setLabelText("Layers");
			layerInfo.setEditable(false);
			
			rootInfo = new StringFieldEditor();
			rootInfo.setLabelText("Conf. Root");
			rootInfo.setEditable(false);
			
			defaultViewInfo = new StringFieldEditor();
			defaultViewInfo.setLabelText("Default View");
			defaultViewInfo.setEditable(false);
			
			dataInfo = new StringFieldEditor();
			dataInfo.setLabelText("Data Confml");
			dataInfo.setEditable(false);
		}
		
		@Override
		public void setInput(IWorkbenchPart part, ISelection selection) {
			super.setInput(part, selection);
			if (selection instanceof IStructuredSelection) {
				Object top = ((IStructuredSelection)selection).getFirstElement();
				if (top instanceof IProject) 
				{
					project = (IProject)top;
				} 
				else 
				{
					project = null;
				}
			}
			refresh();
		}
		
		@Override
		public void refresh() {
			super.refresh();

			//TransactionalEditingDomain domain = project == null ? null : TransactionUtil.getEditingDomain(project);

			if (project == null) 
			{
				layerInfo.setTextValue("");
				rootInfo.setTextValue("");
				defaultViewInfo.setTextValue("");
				dataInfo.setTextValue("");
			} 
			else
			{
//				try {
//					TransactionUtil.runExclusive(domain, new RunnableWithResult.Impl<Void>() {
//						public void run() 
//						{
							EConfigurationProject confProject = ConfMLCore.getProjectModel(project);
							if (confProject==null)
							{
								layerInfo.setTextValue("");
								rootInfo.setTextValue("");
								defaultViewInfo.setTextValue("");
								dataInfo.setTextValue("");
								return;
							}
							URI rootConfmlURI = confProject.getRootConfml();
							EConfMLLayer lastLayer = confProject.getLastLayer();
							
							EAppView defaultView = confProject.getDefaultView();
							if (defaultView!=null)
								defaultViewInfo.setTextValue(defaultView.getName());
							else
								defaultViewInfo.setTextValue("");
								
							if (lastLayer!=null)
							{
								EList<EAppIncludeElement> includes = lastLayer.getIncludes();
						
								if (includes.size()>0)
									dataInfo.setTextValue(uriTrimmer(includes.get(includes.size()-1).getTarget()));
								else
									dataInfo.setTextValue("");
							}
							else
								dataInfo.setTextValue("");
							
							rootInfo.setTextValue(uriTrimmer(rootConfmlURI));
							
							StringBuffer layersString = new StringBuffer();
							
							EList<EConfMLLayer> layers = confProject.getLayers();
							
							if (layers!=null)
							{
								for (int i = 0 ; i < layers.size() ; i++)
								{
									EConfMLLayer layer = layers.get(i);
									String layerName = layer.getName();
									String layerUri = uriTrimmer(layer.getLayerURI());
	
									layersString.append(layerUri);
									if (i < layers.size()-1)
										layersString.append("\n");
								}
								layerInfo.setTextValue(layersString.toString());
							}
							else
								layerInfo.setTextValue("");

			}
//					});
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
				
//			}
		}
		
		private String uriTrimmer(URI uri)
		{
			if (uri==null)
				return "";
			String uriString = uri.toPlatformString(true);
			uriString = uriString.substring(1);
			uriString = uriString.substring(uriString.indexOf("/"));
			return uriString;
		}
		
		@Override
		public void createControls(Composite parent,
				TabbedPropertySheetPage tabbedPropertySheetPage) {
			super.createControls(parent, tabbedPropertySheetPage);

			TabbedPropertySheetWidgetFactory factory =  getWidgetFactory();
			
			control = factory.createSection(parent, Section.TITLE_BAR);
			control.setText("Configuration Project Information");
			Composite content = factory.createComposite(control);
			control.setClient(content);
			content.setLayout(new GridLayout(3, false));
			
			rootInfo.fillIntoGrid(content, 3, factory);
			dataInfo.fillIntoGrid(content, 3, factory);
			defaultViewInfo.fillIntoGrid(content, 3, factory);
			layerInfo.fillIntoGrid(content, 3, factory);
		}
		
		@Override
		public void dispose() {
			if (control != null) {
				control.dispose();
			}
			super.dispose();
		}

	}

