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
package com.nokia.tools.vct.crml.crmodel.util;

import java.lang.reflect.Method;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.WeakHashMap;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.SAXXMIHandler;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Document;
import org.xml.sax.Attributes;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.ext.LexicalHandler;

public class CustomCRMLHandler extends SAXXMIHandler implements LexicalHandler
{
  public CustomCRMLHandler(XMLResource xmiResource, XMLHelper helper,
			Map<?, ?> options) {
		super(xmiResource, helper, options);
	}

protected static final Map<EObject, Map<Object, Object>> userDataMap = Collections.synchronizedMap(new WeakHashMap<EObject, Map<Object, Object>>());

  private static final class LocationMap extends AbstractMap<Object,Object>
  {
    protected static final int UNSET = Integer.MAX_VALUE;
    protected Map<Object, Object> delegateMap;
    private int startLine = UNSET;
    private int endLine = UNSET;

    public Set<java.util.Map.Entry<Object, Object>> entrySet()
    {
      return getDelegateMap().entrySet();
    }

    protected Map<Object, Object> getDelegateMap()
    {
      if (delegateMap == null)
      {
        delegateMap = new HashMap<Object, Object>();
        if (startLine != UNSET)
        {
          delegateMap.put("startLine", startLine);
        }
        if (endLine != UNSET)
        {
          delegateMap.put("endLine", endLine);
        }
      }
      return delegateMap;
    }

    protected int objectToInt(Object value)
    {
      return value == null ? UNSET : ((Integer)value).intValue();
    }

    protected Object intToObject(int value)
    {
      return value == UNSET ? null : value;
    }

    public Object put(Object key, Object value)
    {
      Object result;
      if (delegateMap == null)
      {
        if ("startLine".equals(key))
        {
          result = intToObject(startLine);
          startLine  = objectToInt(value);
        }
        else if ("endLine".equals(key))
        {
          result = intToObject(endLine);
          endLine  = objectToInt(value);
        }
        else
        {
          result = getDelegateMap().put(key, value);
        }
      }
      else
      {
        result = getDelegateMap().put(key, value);
      }
      return result;
    }

    public int getStartLine()
    {
      return delegateMap == null ? startLine : objectToInt(delegateMap.get("startLine"));
    }

    public void setStartLine(int startLine)
    {
      if (delegateMap == null)
      {
        this.startLine = startLine;
      }
      else
      {
        delegateMap.put("startLine", startLine);
      }
    }
  }

  /**
   * Returns the user data associated with the node.
   * If the node has no user data, a new empty map is created.
   * @param node the node to query.
   * @return the user data associated with the node.
   */
  public static Map<Object, Object> getUserData(EObject node)
  {
    return getLocationMap(node);
  }

  private static LocationMap getLocationMap(EObject node)
  {
    LocationMap result = (LocationMap)userDataMap.get(node);
    if (result == null)
    {
      result = new LocationMap();
      userDataMap.put(node, result);
    }
    return result;
  }

  /**
   * Returns the line at which the given node starts.
   * @param node the node to query.
   * @return the line at which the given node starts.
   */
  public static int getStartLine(EObject node)
  {
    int result = getLocationMap(node).getStartLine();
    return result == LocationMap.UNSET ? 1 : result;
  }

  /**
   * Sets the line at which the given node starts.
   * @param node the node to set.
   * @param value the line at which the given node starts.
   */
  public static void setStartLine(EObject node, int value)
  {
    getLocationMap(node).setStartLine(value);
  }

  protected Document document;
  protected Stack<EObject> stack = new Stack<EObject>();
  protected EObject element;
  protected Locator locator;
  protected int line;
  protected String encoding;
  protected StringBuilder cdata;
  protected CDATASection cdataSection;


  public String getEncoding()
  {
    if (locator != null)
    {
      try 
      {
        Method getEncodingMethod = locator.getClass().getMethod("getEncoding", new Class[]{});
        if (getEncodingMethod != null)
        {
          encoding = (String)getEncodingMethod.invoke(locator);
        }
      }
      catch (Exception e) 
      {
       
      }
    }

    return encoding;
  }

  public Document getDocument()
  {
    return document;
  }

  public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
  {
    super.startElement(uri, localName, qName, attributes);
	//Element newElement = document.createElementNS(uri, qName);
	
    stack.push(element); 
    element = objects.peek();
    
    if (element!=null)
    {
    	LocationMap extendedAttributes = getLocationMap(element);
    	extendedAttributes.setStartLine(line);  
    	saveLocation();
    }
  }

  public void setDocumentLocator(Locator locator)
  {
    this.locator = locator;
    super.setDocumentLocator(locator);
  }

  public void startDocument()
  {
    super.startDocument();
	saveLocation();
    document = createDocument();
    stack.clear();

    getEncoding();
  }

  public static Document createDocument()
  {
    try
    {
      DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
      documentBuilderFactory.setNamespaceAware(true);
      documentBuilderFactory.setValidating(false);
      DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
      return documentBuilder.newDocument();
    }
    catch (ParserConfigurationException exception)
    {
      return null;
    }
  }

  public void endDocument()
  {
    super.endDocument();
	element = null;
    saveLocation();
    this.locator = null;
  }

  public void characters(char [] characters, int start, int length) 
  {
    super.characters(characters, start, length);
	if (cdata != null)
    {
      cdata.append(characters, start, length);
    }
    else
    {
      int lineFeed = 0;
      int carriageReturn = 0;
      for (int i = 0; i < length; ++i)
      {
        char character = characters[start + i];
        if (character == '\n')
        {
          ++lineFeed;
          //column = 1;
        }
        else if (character == '\r')
        {
          ++carriageReturn;
          //column = 1;
        }
        else if (character == ' ' && character == '\t')
        {
          //++column;
        }
        else
        {
          // Put the leading whitespace in its own text node.
          if (i != 0)
          {
            //Text textNode = document.createTextNode(new String(characters, start, i));
            //element.appendChild(textNode);
          }
          
          // Create a next node that starts with the non-whitespace.
          //
          line += Math.max(lineFeed, carriageReturn);
          //Text textNode = document.createTextNode(new String(characters, start + i, length - i));
          //element.appendChild(textNode);
          
          EObject textNode = null;
          if (textNode!=null)
          {
        	  LocationMap extendedAttributes = getLocationMap(textNode);
        	  extendedAttributes.setStartLine(line);
        	  saveLocation();
             //extendedAttributes.setEndLine(line);
        	  return;
          }
        }
      }
      //Text textNode = document.createTextNode(new String(characters, start, length));
      //element.appendChild(textNode);
      saveLocation();
    }
  }


  public void startCDATA() 
  {
    super.startCDATA();
	//cdata = new StringBuilder();
    //cdataSection = document.createCDATASection("");
    element = objects.peek();
    LocationMap extendedAttributes = getLocationMap(element);
    extendedAttributes.setStartLine(line);
  }


  protected void saveLocation()
  {
    if (locator != null)
    {
      line = locator.getLineNumber();
    }
  }

}
