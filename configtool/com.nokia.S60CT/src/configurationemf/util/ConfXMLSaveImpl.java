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
package configurationemf.util;

import java.util.Iterator;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMLSaveImpl;
import org.eclipse.emf.ecore.xml.type.AnyType;
import org.eclipse.emf.ecore.xml.type.SimpleAnyType;

import configurationemf.ConfigurationemfPackage;
import configurationemf.Ref;

public class ConfXMLSaveImpl extends XMLSaveImpl {
	
	
	
	
	
	//@Override
	protected void saveElement(EObject o, EStructuralFeature f) {
		
		EClass eClass = o.eClass();
		    EClassifier eType = f.getEType();

		    if (extendedMetaData != null && eClass != eType)
		    {
		      // Check if it's an anonymous type.
		      //
		      String name = extendedMetaData.getName(eClass);
		      if (name.endsWith("_._type"))
		      {
		        String elementName = name.substring(0, name.indexOf("_._"));
		        String prefix = helper.getPrefix(eClass.getEPackage());
		        if (!"".equals(prefix))
		        {
		          elementName = prefix + ":" + elementName;
		        }
		        if (!toDOM)
		        {
		          doc.startElement(elementName);
		        }
		        else
		        {
		          currentNode = currentNode.appendChild(document.createElementNS(helper.getNamespaceURI(prefix), elementName));
		          handler.recordValues(currentNode, o.eContainer(), f, o);
		        }
		        saveElementID(o);
		        return;
		      }
		    }

		    if (map != null)
		    {
		      XMLResource.XMLInfo info = map.getInfo(eClass);
		      if (info != null && info.getXMLRepresentation() == XMLResource.XMLInfo.ELEMENT)
		      {
		        if (!toDOM)
		        {
		          String elementName = helper.getQName(eClass);
		          doc.startElement(elementName);
		        }
		        else
		        {
		          helper.populateNameInfo(nameInfo, eClass);
		          if (currentNode == null)
		          {
		            currentNode = document.createElementNS(nameInfo.getNamespaceURI(), nameInfo.getQualifiedName());
		            document.appendChild(currentNode);
		            handler.recordValues(currentNode, o.eContainer(), f, o);
		          }
		          else
		          {
		            currentNode = currentNode.appendChild(document.createElementNS(nameInfo.getNamespaceURI(), nameInfo.getQualifiedName()));
		            handler.recordValues(currentNode, o.eContainer(), f, o);
		          }
		        }
		        saveElementID(o);
		        return;
		      }
		    }
		    boolean isAnyType = false;
		    if (o instanceof AnyType)
		    {
		      isAnyType = true;
		      helper.pushContext();
		      for (Iterator i = ((AnyType)o).getAnyAttribute().iterator(); i.hasNext(); )
		      {
		        FeatureMap.Entry entry = (FeatureMap.Entry)i.next();
		        if (ExtendedMetaData.XMLNS_URI.equals(extendedMetaData.getNamespace(entry.getEStructuralFeature())))
		        {
		          String uri = (String)entry.getValue();
		          helper.addPrefix(extendedMetaData.getName(entry.getEStructuralFeature()), uri == null ? "" : uri);
		        }
		      }
		    }
		    if (!toDOM)
		    {
		    	/*
		    	 * modifications to save XPath
		    	 */
		    	String featureName=null;
		    	if(f.equals(ConfigurationemfPackage.eINSTANCE.getData_Ref())||
		    			f.equals(ConfigurationemfPackage.eINSTANCE.getRef_Ref())){
		    	  featureName=((Ref)o).getName();
		    	}else{
		    		featureName = helper.getQName(f);
		    	}
		    	doc.startElement(featureName);
		    }
		    else
		    {
		      helper.populateNameInfo(nameInfo, f);
		      if (currentNode == null)
		      {
		        // this is a root element
		        currentNode = document.createElementNS(nameInfo.getNamespaceURI(), nameInfo.getQualifiedName());
		        document.appendChild(currentNode);
		        handler.recordValues(currentNode, o.eContainer(), f, o);
		      }
		      else
		      {
		        currentNode = currentNode.appendChild(document.createElementNS(nameInfo.getNamespaceURI(), nameInfo.getQualifiedName()));
		        handler.recordValues(currentNode, o.eContainer(), f, o);
		      }
		    }
		    
		    if (saveTypeInfo ? xmlTypeInfo.shouldSaveType(eClass, eType, f) : eClass != eType && eClass != anyType)
		    {
		      if (eClass == anySimpleType)
		      {
		        saveTypeAttribute(((SimpleAnyType)o).getInstanceType());
		      }
		      else
		      {
		        saveTypeAttribute(eClass);
		      }
		    }

		    saveElementID(o);
		    if (isAnyType)
		    {
		      helper.popContext();
		    }
	}

	public ConfXMLSaveImpl(XMLHelper xmlHelper){
		super(xmlHelper);
	}

	
	
}
