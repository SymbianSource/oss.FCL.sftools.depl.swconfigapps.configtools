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

package com.nokia.s60ct.genconfml;

import gcmodel.File;
import gcmodel.Setting;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import com.nokia.s60ct.generate.GeneratedContent;
import com.nokia.s60ct.generate.GenerationReport;
import com.nokia.s60ct.interfaces.IContentCreator;

public class GenerateCall implements IContentCreator
{
	protected TransformerFactory factory = null;
	
	protected static final String xmlHeader = "<?xml version=\"1.0\"?>\n<configuration>\n<data>\n";
	protected static final String xmlFooter = "\n</data>\n</configuration>";
	protected static final String xsltEncoding = "encoding=";
	
	protected Map<String, Object> keyMap = new HashMap<String, Object>();
	
	private GenerationReport report = null;
	
	/**
	 * Constructor
	 */
	public GenerateCall()
	{
		factory = TransformerFactory.newInstance();
	}
	
	/**
	 * Transforms XML input using XSLT template
	 * 
	 * @param xml Input XML string
	 * @param xslt Input XSLT template string
	 * @return Transformed XML string
	 * 
	 * @throws TransformerConfigurationException
	 * @throws TransformerException
	 */
	private String transform(String xml, String xslt, GcfmlErrorListener errorListener)
	throws TransformerConfigurationException, TransformerException
	{
		// Do the transformation
		factory.setErrorListener(errorListener);
		Transformer transformer = factory.newTransformer(new StreamSource(new StringReader(xslt)));
		transformer.setErrorListener(errorListener);
		StringWriter result = new StringWriter();
		transformer.transform(new StreamSource(new StringReader(xml)), new StreamResult(result));
		return result.toString();
	}
	
	/**
	 * @see IContentCreator
	 */
	public Collection<Object> setRefValue(Map<String, Object> refToValue)
	{
		List<Object> result = new ArrayList<Object>();
		try
		{
			keyMap.clear();
			File files[] = GenConfMlPluginInitializer.getInstance().getFileModels();
			for (File file : files) {
				int fileLevel = Integer.MAX_VALUE;
				for (Setting setting : file.getSettings()) {
					String[] refs = setting.getRef().split("/");
					for (String key : refToValue.keySet()) {
						String[] keys = key.split(",");
						String[] settings = keys[2].split("/");
						if (settings[0].compareTo(refs[0]) == 0) {
							// Add setting to keymap if it matches
							if (refs[1].compareTo("*") == 0 || settings[1].compareTo(refs[1]) == 0) {
								keyMap.put(keys[2], refToValue.get(key));
								result.add(null); // To skip validation warnings. Nothing to validate yet.
								int level = Integer.valueOf(keys[1]);
								if (level < fileLevel) {
									file.setFolder(keys[0]);
									fileLevel = level;
								}
							}
						}
					}
				}
			}
			return result;
		}
		catch (Exception e)
		{
			return result;
		}
		
	}
	
	/**
	 * @see IContentCreator
	 */
	public Object generate()
	{
		report = new GenerationReport();
		GeneratedContent result = new GeneratedContent();
		String xml = xmlHeader + getDataXml(keyMap) + xmlFooter;
		File files[] = GenConfMlPluginInitializer.getInstance().getFileModels();
		for ( File file : files )
		{
			// Check if even one key is found
			boolean keyFound = false;
			for ( Setting setting : file.getSettings() )
			{
				String[] refs = setting.getRef().split("/");
				if (refs[1].compareTo("*") == 0) {
					// * as setting so check if feature found
					for (String key : keyMap.keySet()) {
						if (key.startsWith(refs[0])) {
							keyFound = true;
							break;
						}
					}
				} else {
					// Check if feature/setting found
					String ref = refs[0] + "/" + refs[1];
					if (keyMap.containsKey(ref))
					{
						keyFound = true;
						break;
					}
				}
			}
			if (keyFound) {
				GcfmlErrorListener errorListener = new GcfmlErrorListener();
				// At least one key found, do the transformation
				try {
					String xslt = file.getTemplate();
					String output = transform( xml, xslt, errorListener );
					String fileName = file.getName();
					String target = file.getTarget();
					String folder = file.getFolder();
					if (target == null) target = "";
					target = target.replace("/", java.io.File.separator);
					if (!target.equals("") && !target.endsWith(java.io.File.separator)) 
						target += java.io.File.separator;
					
					fileName = fileName.replace("/", java.io.File.separator);
					String pathFromName = null;
					if (fileName.indexOf(java.io.File.separator) != -1)
					{
						pathFromName = fileName.substring(0, fileName.lastIndexOf(java.io.File.separator));
					}
					if (!fileName.startsWith(target))
					{
						fileName = target+fileName;
					}
					
					if (pathFromName != null)
						target = target+pathFromName+java.io.File.separator;
					
					if (folder != null && !folder.matches("")) {
						// Special case where variant configuration available so name starts with \
						if (fileName.startsWith(java.io.File.separator))
							fileName = java.io.File.separator + folder + fileName;
						else
							fileName = java.io.File.separator + folder + java.io.File.separator + fileName;
					}
					
					result.put(fileName, output);
					result.addComment(fileName, file.getParent());
					
					
					result.addTarget(fileName, target);
					String encoding = "UTF-16LE"; // Default encoding
					if (xslt.contains(xsltEncoding)) {
						// Parse encoding from XSLT string
						int first = xslt.indexOf("\"", xslt.indexOf(xsltEncoding));
						encoding = xslt.substring(first + 1, xslt.indexOf("\"", first + 1));
					}
					result.addEncoding(fileName, encoding);
				} catch (Exception exception) {
					// Catch XSLT errors
					report.addGenConfmlError(file.getParent() + ": " + errorListener.getErrors(), null);
				}
			} else {
				// Warning removed because it seems just to confuse users
				//report.addGenConfmlError("WARNING: " + file.getParent() + " does not match any open confml", null);
			}
		}
		for (String s : GenConfMlPluginInitializer.getInstance().getUnknownFiles()) {
			report.addGenConfmlError(s, null);
		}
		return result;
	}
	
	private String getDataXml(Map<String, Object> keyMap) {
		StringBuffer result = new StringBuffer();
		for (String ref : keyMap.keySet()) {
			String fRef = ref.split("/")[0];
			String psRef = ref.split("/")[1];
			Object value = keyMap.get(ref);
			int writeHereIndex = result.indexOf("</" + fRef + ">");
			if(writeHereIndex == -1) {
				result.append("<" + fRef + ">\n" + "</" + fRef + ">");
				writeHereIndex=result.indexOf("</" + fRef + ">");
			}		
			if (value instanceof String) {
				result.insert(writeHereIndex, "<" + psRef + ">" + value + "</" + psRef + ">\n");
			} else if (value instanceof Object[][]) {
				Object[][] frames = (Object[][]) value;
				for(int column = 1; column<frames[0].length;column++) {
					result.insert(writeHereIndex, "<" + psRef + ">\n");
					writeHereIndex = result.indexOf("</" + fRef + ">");
					for(int row = 0; row < frames.length; row++) {
						String lsRef = (String) frames[row][0];
						String lsValue = (String) frames[row][column];
						if (lsValue == null) lsValue = "";
						lsValue = encode(lsValue);
						result.insert(writeHereIndex,"<" + lsRef+">" + lsValue + "</" + lsRef + ">\n" );
						writeHereIndex=result.indexOf("</" + fRef + ">");
					}
					result.insert(writeHereIndex, "</" + psRef + ">\n");
					writeHereIndex=result.indexOf("</" + fRef + ">");			
				}
			}
		}
		return result.toString();
	}

	public String encode(String value)
	{
		if (value.length() == 0) return value;
		
		if (value.indexOf("&") > -1) value = value.replaceAll("&", "&#38;"); //&amp;
		if (value.indexOf("\"") > -1) value = value.replaceAll("\"", "&#34;"); //&quot;
		if (value.indexOf("'") > -1) value = value.replaceAll("'", "&#39;"); //&apos;
		if (value.indexOf("<") > -1) value = value.replaceAll("<", "&#60;"); //&lt;
		if (value.indexOf(">") > -1) value = value.replaceAll(">", "&#62;"); //&gt;
		if (value.indexOf("Ä") > -1) value = value.replaceAll("Ä", "&#196;"); //&Auml;
		if (value.indexOf("ä") > -1) value = value.replaceAll("ä", "&#228;"); //&auml;
		if (value.indexOf("Ö") > -1) value = value.replaceAll("Ö", "&#214;"); //&Ouml;
		if (value.indexOf("ö") > -1) value = value.replaceAll("ö", "&#246;"); //&ouml;
		if (value.indexOf("å") > -1) value = value.replaceAll("å", "&#229;"); //&aring;
		if (value.indexOf("Å") > -1) value = value.replaceAll("Å", "&#197"); //&Aring;
		if (value.indexOf("€") > -1) value = value.replaceAll("€", "&#128;"); //&euro; &#8364;
		if (value.indexOf("£") > -1) value = value.replaceAll("£", "&#163;"); //&pound;
		if (value.indexOf("ê") > -1) value = value.replaceAll("ê", "&#234;"); //&ecirc;
		if (value.indexOf("Ê") > -1) value = value.replaceAll("Ê", "&#202;"); //&Ecirc;
		if (value.indexOf("ë") > -1) value = value.replaceAll("ë", "&#235;"); //&euml;
		if (value.indexOf("µ") > -1) value = value.replaceAll("µ", "&#181;"); //&micro;
		if (value.indexOf("©") > -1) value = value.replaceAll("©", "&copy;"); //&#169;
		if (value.indexOf("ü") > -1) value = value.replaceAll("ü", "&#252;"); //&uuml;
		if (value.indexOf("Ü") > -1) value = value.replaceAll("Ü", "&#220;"); //&Uuml;
		return value;
	}
	
	
	@Override
	public GenerationReport getReport()
	{
		return report;
	}
}
