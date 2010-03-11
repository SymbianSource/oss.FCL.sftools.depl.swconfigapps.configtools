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
package com.nokia.tools.carbide.ct.crml.ui.editors;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.graphics.Image;
import org.eclipse.wst.xml.ui.views.contentoutline.XMLContentOutlineConfiguration;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.nokia.tools.carbide.ct.crml.ui.PluginImages;




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
				//System.out.println(element.toString());
				if (elementString.startsWith("crml:"))
				{
					elementString = elementString.substring(5);
				}
				
				if (elementString.startsWith("repository"))
				{
					return PluginImages.REPOSITORY;
				}
				else if (elementString.startsWith("keyRange"))
				{
					return PluginImages.RANGEKEY;
				}
				else if (elementString.startsWith("key"))
				{
					if (element instanceof Element)
					{
						Element e = (Element)element;
						NodeList nodeList = e.getChildNodes();
						for (int n = 0 ; n < nodeList.getLength() ; n++)
						{
							Node node = nodeList.item(n);
							if (node.toString().startsWith("bit"))
								return PluginImages.BITMASKKEY;
						}
					}
					return PluginImages.SIMPLEKEY;
				}
				else if (elementString.startsWith("access"))
				{
					return PluginImages.ACCESS;
				}
				else if (elementString.startsWith("desc"))
				{
					return PluginImages.DESCRIPTION;
				}
				else if (elementString.startsWith("option"))
				{
					return PluginImages.GENERIC;
				}
				else if (elementString.startsWith("xml"))
				{
					return PluginImages.XML;
				}
				else if (elementString.startsWith("bit"))
				{
					return PluginImages.BIT;
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
					
					if (elementString.startsWith("crml:"))
					{
						elementString = elementString.substring(5);
					}
					
					if (elementString.startsWith("data"))
					{
//						if (level==0)
//							return PluginImages.DATA_FEATURE;
//						else
//							return PluginImages.DATA_SETTING;
						return PluginImages.GENERIC;
					}
					if (elementString.startsWith("rfs"))
					{
//						if (level==0)
//							return PluginImages.RFS_FEATURE;
//						else
//							return PluginImages.RFS_SETTING;
						return PluginImages.GENERIC;
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
				if (text.startsWith("crml:"))
				{
					return text.substring(5);
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
