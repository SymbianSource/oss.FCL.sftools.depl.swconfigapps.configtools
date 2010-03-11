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
package com.nokia.tools.s60ct.genconfml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.ErrorListener;
import javax.xml.transform.TransformerException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.nokia.tools.s60ct.build.builder.utils.SettingImplementationCollector;
import com.nokia.tools.variant.confml.core.ConfMLCore;
import com.nokia.tools.vct.common.appmodel.EConfigurationProject;
import com.nokia.tools.vct.gcfml.gcfmlmodel.EFile;
import com.nokia.tools.vct.gcfml.gcfmlmodel.ESetting;


public class GenconfmlManager {
	private static GenconfmlManager singleton;

	private GenconfmlManager() {
		
	}
	
	static public GenconfmlManager getInstance() {
		if(singleton==null) {
			singleton = new GenconfmlManager();
		}
		return singleton;
	}
	
	public Element findElement(Element parent, String element)
	{
		NodeList nodes = parent.getElementsByTagName(element);
		return (Element) nodes.item(0);
	}
	
	// Initialize DOM
	public DOMImplementation initializeDom(){
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		try {
			db = dbf.newDocumentBuilder();
			return db.getDOMImplementation();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String processGcfmlFile(IProject pr, IResource resource){
		//process that only gathers implementation files.
		//System.out.println("building file: " + resource.getName());
		ResourceSet resourceSet = new ResourceSetImpl();
		String gcfmlOutputFile = "";
		// Get the URI of the model file.
		
		
		try 
		{
			URI fileURI = URI.createPlatformResourceURI(resource.getFullPath().toString(), true);

			// Create a resource for this file.
			Resource gcfmlResource = resourceSet.getResource(fileURI, true);
			
			// Initialize DOM
			DOMImplementation domi = initializeDom();
			EFile gcfmlFile = (EFile) gcfmlResource.getContents().get(0); // Load gcfml contents
			EConfigurationProject project = ConfMLCore.getProjectModel(pr);
			// Go through gcfml settings
			for (ESetting gcfmlSetting : gcfmlFile.getSetting()) {
				
				gcfmlFile.setLocation(fileURI.toPlatformString(true));
				SettingImplementationCollector.addImplementation(gcfmlSetting.getRef(), gcfmlFile);
			}
		} catch (Exception e) {
			EcorePlugin.INSTANCE.log(e);
		}
		return gcfmlOutputFile;
	}
	
	/*
	public String processGcfmlFile(IProject pr, IResource resource){

		//System.out.println("building file: " + resource.getName());
		ResourceSet resourceSet = new ResourceSetImpl();
		String gcfmlOutputFile = "";
		// Get the URI of the model file.
		URI fileURI = URI.createPlatformResourceURI(resource.getFullPath().toString(), true);

		// Create a resource for this file.
		Resource gcfmlResource = resourceSet.getResource(fileURI, true);
		
		try {
			// Initialize DOM
			DOMImplementation domi = initializeDom();
			EFile gcfmlFile = (EFile) gcfmlResource.getContents().get(0); // Load gcfml contents
			EConfigurationProject project = ConfMLCore.getProjectModel(pr);
			// Go through gcfml settings
			for (ESetting gcfmlSetting : gcfmlFile.getSetting()) {
				
				SettingImplementationCollector.addImplementation(gcfmlSetting.getRef(), gcfmlFile);

				String[] refs = gcfmlSetting.getRef().split("/");
				// Go through confml layers
				for (EConfMLLayer layer : project.getLayers()) {
					// Create DOM document
					Document doc = domi.createDocument(null, "configuration", null);
					Element configuration = doc.getDocumentElement();
					Element data = doc.createElement("data");
					configuration.appendChild(data);
					boolean settingMatch = false;
					if (layer.getFeatures().containsKey(refs[0])) {
						// Feature ref matches
						for (String confmlSetting : layer.getFeatures().get(refs[0]).getSettings().keySet()) {
							if (refs[1].equals("*") || refs[1].equals(confmlSetting)) {
								settingMatch = true;
								// Use all settings
								Element featureElement = findElement(data, refs[0]);
								if (featureElement == null) {
									featureElement = doc.createElement(refs[0]);
									//createFeature = true;
									data.appendChild(featureElement);
								}
								
								EAppSettingData settingValue = layer.getFeatures().get(refs[0]).getSettings().get(confmlSetting).getValueInfo();
								
								if (settingValue instanceof EAppSimpleData) {
									
									Element settingElement = findElement(featureElement, confmlSetting);
									if (settingElement == null) {
										settingElement = doc.createElement(confmlSetting);
										//createSetting = true;
										featureElement.appendChild(settingElement);
									}
									
									Node node = null;
									String value = ((EAppSimpleData) settingValue).getValue();
									if (value == null) value = "";
									node = doc.createTextNode(value);
									settingElement.appendChild(node);
								}
								else if (settingValue instanceof EAppSequenceDataImpl) {
									// handle this type
									for (EAppSequenceDataItem sequence : ((EAppSequenceDataImpl)settingValue).getItems())
									{
										Element settingElement = doc.createElement(confmlSetting);
										featureElement.appendChild(settingElement);
										
										EMap<String, EAppSettingData> map = sequence.getSubSettings();
										for (Iterator<Entry<String, EAppSettingData>> iterator = map.iterator(); iterator.hasNext();)
										{
											Entry<String, EAppSettingData> entry = iterator.next();
											String subSettingName = entry.getKey();
											Element subSettingElement = doc.createElement(subSettingName);
											EAppSimpleData subSettingData = (EAppSimpleData)entry.getValue();
											String value = subSettingData.getValue();
											if (value == null) value = "";
											Node node = doc.createTextNode(value);
											settingElement.appendChild(subSettingElement);
											subSettingElement.appendChild(node);
										}
									}
								}
								else if (settingValue instanceof EAppResourceData)
								{
									Element settingElement = findElement(featureElement, confmlSetting);
									if (settingElement == null) {
										settingElement = doc.createElement(confmlSetting);
										//createSetting = true;
										featureElement.appendChild(settingElement);
									}
									
									String ref = layer.getFeatures().get(refs[0]).getSettings().get(confmlSetting).getRef();
									String value = null;
									if (ref.equals("localPath")) {
										value = ((EAppSimpleData) ((EAppResourceData) settingValue).getLocalPath()).getValue();
									} else if (ref.equals("targetPath")) {
										value = ((EAppSimpleData) ((EAppResourceData) settingValue).getTargetPath()).getValue();
									} else {
										throw new UnsupportedOperationException();
									}
									if (value == null) value = "";
									Node node = doc.createTextNode(value);
									settingElement.appendChild(node);
								} 
								else
								{
									throw new UnsupportedOperationException();
								}
							}
						}
					}
					if (settingMatch) {
						// Transform DOM to XML
						DOMSource doms = new DOMSource(doc);
						TransformerFactory factory = TransformerFactory.newInstance();
						factory.setErrorListener(new GcfmlErrorListener((IFile) resource));
						Transformer transformer = factory.newTransformer();
						StringWriter writer = new StringWriter();
						StreamResult result = new StreamResult(writer);
						transformer.transform(doms, result);
						// Transform XML with XSLT
						transformer = factory.newTransformer(new StreamSource(new StringReader(gcfmlFile.getStylesheet().getContent())));
						StringWriter output = new StringWriter();
						transformer.transform(new StreamSource(new StringReader(writer.toString())), new StreamResult(output));
						// Create output file
						String buildFolderName = layer.getLayerURI().toPlatformString(true) + "build";
						if (buildFolderName.charAt(0) == '/') buildFolderName = buildFolderName.substring(1); // Remove first /
						buildFolderName = buildFolderName.substring(buildFolderName.indexOf("/") + 1); // Remove first path
						IFolder folder = pr.getFolder(buildFolderName);
						if (!folder.exists()) {
							folder.create(true, true, null);
						}
						//gcfmlFileName can also have folders
						String gcfmlFileName = gcfmlFile.getName(); 
						if (gcfmlFileName.indexOf("/")!=-1)
						{
							String[] otherFolders = gcfmlFileName.split("/");
							String temp = "/";
							for (int i = 0 ; i < otherFolders.length-1 ; i++)
							{
								IFolder otherFolder = pr.getFolder(buildFolderName+temp+otherFolders[i]);
								temp = temp+otherFolders[i]+"/";
								if (!otherFolder.exists()) {
									otherFolder.create(true, true, null);
								}
							}
						}
						gcfmlOutputFile = buildFolderName + "/" + gcfmlFile.getName();
						IFile file = pr.getFile(gcfmlOutputFile);
						if (file.exists()) file.delete(true, null);
						String encoding = gcfmlFile.getStylesheet().getOutput().getEncoding();
						if (encoding.equals(CommonFolderApis.UTF_8_ID)) {
							file.create(new ByteArrayInputStream(output.toString().getBytes(CommonFolderApis.UTF_8_ID)), true, null);
					    } else if (encoding.equals(CommonFolderApis.UTF_16BE_ID)) {
					    	file.create(new ByteArrayInputStream(output.toString().getBytes(CommonFolderApis.UTF_16BE_ID)), true, null);
					    } else {
					    	// UTF-16LE as default
					    	file.create(new ByteArrayInputStream(output.toString().getBytes(CommonFolderApis.UTF_16LE_ID)), true, null);
					    }
					}
				}
			}
		} catch (Exception e) {
			EcorePlugin.INSTANCE.log(e);
		}
		return gcfmlOutputFile;
	}*/
	
	class GcfmlErrorListener implements ErrorListener {

		private IFile file = null;
		
		public GcfmlErrorListener(IFile resource)
		{
			this.file = resource;
		}

		private void createMarker(int severity, TransformerException exception)
		{
			try {
				IMarker marker = file.createMarker("com.nokia.tools.variant.validation.core.xmlproblem"); //own marker type
				if (marker != null && marker.exists()) {
					marker.setAttribute(IMarker.SEVERITY, severity);
					marker.setAttribute(IMarker.LOCATION, exception.getLocationAsString()); // ?
					marker.setAttribute(IMarker.MESSAGE, exception.getMessage());
				}
			} catch (CoreException e) {
				EcorePlugin.INSTANCE.log(e);
			}
		}
		
		public void error(TransformerException exception) throws TransformerException
		{
			createMarker(IMarker.SEVERITY_ERROR, exception);
		}
		
		public void fatalError(TransformerException exception) throws TransformerException
		{
			createMarker(IMarker.SEVERITY_ERROR, exception);
		}

		public void warning(TransformerException exception) throws TransformerException
		{
			createMarker(IMarker.SEVERITY_WARNING, exception);
		}
	}
	
}
