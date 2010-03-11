/*
 * Copyright (c) 2009 Nokia Corporation and/or its subsidiary(-ies).
 * All rights reserved.
 * This component and the accompanying materials are made available
 * under the terms of "Eclipse Public License v1.0"
 * which accompanies this distribution, and is available
 * at the URL "http://www.eclipse.org/legal/epl-v10.html".
 * 
 * Initial Contributors:
 * Nokia Corporation - Initial contribution
 * 
 * Contributors:
 * 
 * Description: This file is part of com.nokia.tools.variant.validation.ui component.
 */

package com.nokia.tools.variant.validation.ui.quickfix.resolution;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.CharBuffer;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.nokia.tools.variant.validation.ui.quickfix.QuickFixerSettingDefinition;
import com.nokia.tools.vct.confml.model.confml1.impl.EConfMLDocumentImpl;
import com.nokia.tools.vct.confml.model.confml1.util.EConfML1ResourceImpl;
import com.nokia.tools.vct.confml.model.confml2.impl.EConfML2DocumentImpl;
import com.nokia.tools.vct.confml.model.confml2.util.EConfML2ResourceImpl;

public class QuickFixAddMissingNamespace extends ConfMLMarkerResolution {
	private String problemId;


	public QuickFixAddMissingNamespace(String label, String objectUri,
			String problemId) {
		super(label, null, null);
		this.problemId = problemId;
	}

	@Override
	protected boolean applyFix(IMarker marker, Resource resource)
			throws CoreException {

		String confmlNamespaceString = null;
		String newNamespaceString = null;
		
		if (problemId.equals(QuickFixerSettingDefinition.ID_MISSING_NAMESPACE_XS))
			newNamespaceString = " xmlns:xs=\"http://www.w3.org/2001/XMLSchema\"";
		else if (problemId.equals(QuickFixerSettingDefinition.ID_MISSING_NAMESPACE_XI))
			newNamespaceString = " xmlns:xi=\"http://www.w3.org/2001/XInclude\"";
		else
			return false;
		
		URI uri = null;
		
		if (resource instanceof EConfML1ResourceImpl)
		{
			EConfML1ResourceImpl confmlRes = (EConfML1ResourceImpl)resource;
			uri = confmlRes.getURI();	
			EList<EObject> contents =  confmlRes.getContents();
			if (contents!=null && contents.get(0) instanceof EConfMLDocumentImpl)
			{
				confmlNamespaceString = "xmlns:confml=\"http://www.s60.com/xml/confml/1\"";
			}
			else if (contents!=null && contents.get(0) instanceof EConfML2DocumentImpl)
			{
				confmlNamespaceString = "xmlns:confml=\"http://www.s60.com/xml/confml/2\"";
			}
		}
		else if (resource instanceof EConfML2ResourceImpl) {
			EConfML2ResourceImpl confmlRes = (EConfML2ResourceImpl)resource;
			uri = confmlRes.getURI();
			confmlNamespaceString = "xmlns:confml=\"http://www.s60.com/xml/confml/2\"";
		}
		
		String platformUri = uri.toPlatformString(true);
		String projectURI = ResourcesPlugin.getWorkspace().getRoot().getLocationURI().getPath();
	    String fullPath = projectURI+platformUri;
		File file = new File(fullPath);
		try 
		{
			int fileSize = (int)file.length();
			FileReader reader = new FileReader(file);
			
			CharBuffer cBuffer = CharBuffer.allocate(fileSize);
			reader.read(cBuffer);
			String contentString = new String(cBuffer.array());
			if (contentString.indexOf(newNamespaceString)!= -1)
				return false;
			int i = contentString.indexOf(confmlNamespaceString);
			if (i!=-1)
			{
				int j = i + confmlNamespaceString.length();
				String firstPart = contentString.substring(0, j);
				String lastPart = contentString.substring(j);
				String newConfml = firstPart+newNamespaceString+lastPart;

				FileWriter writer = new FileWriter(file);
				writer.write(newConfml);
				writer.close();
				Path path = new Path(platformUri);
				IFile iFile = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
				iFile.refreshLocal(IFile.DEPTH_INFINITE, null);	
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return false; //must return false
	}

	public boolean canRunMultiple()
	{
		return true;
	}
	
	@Override
	protected boolean canHandle(IMarker marker) {
		String msgId = marker.getAttribute("problemId", "");
		return msgId
				.equals(QuickFixerSettingDefinition.ID_MISSING_NAMESPACE_XI)
				|| msgId
						.equals(QuickFixerSettingDefinition.ID_MISSING_NAMESPACE_XS);
	}
}
