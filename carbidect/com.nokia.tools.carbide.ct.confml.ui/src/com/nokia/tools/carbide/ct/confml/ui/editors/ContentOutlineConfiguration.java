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
package com.nokia.tools.carbide.ct.confml.ui.editors;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.views.navigator.GotoActionGroup;
import org.eclipse.wst.xml.ui.views.contentoutline.XMLContentOutlineConfiguration;
import org.w3c.dom.Element;


import com.nokia.tools.carbide.ct.confml.ui.PluginImages;

public class ContentOutlineConfiguration extends XMLContentOutlineConfiguration
 {

	public ContentOutlineConfiguration() {

		super();
	}

	public ILabelProvider getLabelProvider(TreeViewer viewer) {
		
		final ILabelProvider originalProvider = super.getLabelProvider(viewer);
		
		ILabelProvider customProvider = new ILabelProvider()
		{
			public Image getImage(Object element) {
				String elementString = element.toString();
				
				if (elementString.startsWith("confml:"))
				{
					elementString = elementString.substring(7);
				}
				
				if (elementString.startsWith("setting"))
				{
					return PluginImages.SETTING;
				}
				else if (elementString.startsWith("feature"))
				{
					return PluginImages.FEATURE;
				}
				else if (elementString.startsWith("configuration"))
				{
					if (elementString.indexOf("http://www.s60.com/xml/confml/1")!=-1)
						return PluginImages.CONFIGURATION1;
					else 
						return PluginImages.CONFIGURATION2;
				}
				else if (elementString.startsWith("rfs"))
				{
					return PluginImages.RFS_FEATURE;
				}
				else if (elementString.startsWith("data"))
				{
					return PluginImages.DATA_FEATURE;
				}
				else if (elementString.startsWith("desc"))
				{
					return PluginImages.DESCRIPTION;
				}
				else if (elementString.startsWith("option"))
				{
					return PluginImages.OPTION;
				}
				else if (elementString.startsWith("xml"))
				{
					return PluginImages.XML;
				}
				else if (elementString.startsWith("view"))
				{
					return PluginImages.VIEW;
				}
				else if (elementString.startsWith("group"))
				{
					return PluginImages.GROUP;
				}
				else if (elementString.startsWith("xi:include"))
				{
					return PluginImages.INCLUDE;
				}
				else
				{
					if (element instanceof Element)
					{	
						Element e = (Element)element;
						return getElementImage(e, 0);
					}
					else
						return PluginImages.GENERIC;
				}
				
			}

			private Image getElementImage(Element element, int level)
			{
				if (element.getParentNode() instanceof Element)
				{
					Element parent = (Element)element.getParentNode();

					String elementString = element.toString();
					
					if (elementString.startsWith("confml:"))
					{
						elementString = elementString.substring(7);
					}
					
					if (elementString.startsWith("data"))
					{
						if (level==0)
							return PluginImages.DATA_FEATURE;
						else
							return PluginImages.DATA_SETTING;
					}
					if (elementString.startsWith("rfs"))
					{
						if (level==0)
							return PluginImages.RFS_FEATURE;
						else
							return PluginImages.RFS_SETTING;
					}
					else
					{
						if (level > 5)
							return PluginImages.GENERIC;
						else
							return getElementImage(parent, level+1);
					}
				}
				else
				{
					System.out.println("PARENT NOT ELEMENT\n"+element.toString());
					return PluginImages.GENERIC;
				}
			}
			
			public String getText(Object element) {
				String text = originalProvider.getText(element);
				if (text.startsWith("confml:"))
				{
					return text.substring(7);
				}
				else
					return text;
			}

			public void addListener(ILabelProviderListener listener) {
				originalProvider.addListener(listener);
			}

			public void dispose() {
				originalProvider.dispose();
			}

			public boolean isLabelProperty(Object element, String property) {
				return originalProvider.isLabelProperty(element, property);
			}

			public void removeListener(ILabelProviderListener listener) {
				originalProvider.removeListener(listener);
			}
			
		};

		return customProvider;
	}

	
}
