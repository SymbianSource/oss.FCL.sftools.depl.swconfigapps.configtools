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

package com.nokia.tools.s60ct.build.builder;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.EMap;

import com.nokia.tools.variant.confml.core.ConfMLCore;
import com.nokia.tools.vct.common.appmodel.EAppFeature;
import com.nokia.tools.vct.common.appmodel.EAppSequenceType;
import com.nokia.tools.vct.common.appmodel.EAppSetting;
import com.nokia.tools.vct.common.appmodel.EAppSettingType;
import com.nokia.tools.vct.common.core.utils.StringEscapeUtils;

public class NotesBuilder 
{

	private static Map<Object, String> notesMap = null;
	private static NotesBuilder notesBuilder = null;
	private static IProject selectedProject = null;
	
	public NotesBuilder()
	{
		notesBuilder = this;
	}
	
	public static NotesBuilder getNotesBuilder()
	{
		if (notesBuilder==null)
		{
			notesBuilder = new NotesBuilder();
		}
		return notesBuilder;
	}
	
	public void setProject(IProject project)
	{
		selectedProject = project;
	}
	
	private IProject getProject()
	{
		if (selectedProject!=null)
			return selectedProject;
		else
		{
			IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		
			for (int i = 0 ; i < projects.length ; i++)
			{
				if (projects[i].isOpen())
				{
					selectedProject = projects[i];
					break;
				}
			}
			return selectedProject;
		}
	}
	
	public void buildNotes()
	{
		IProject project =  getProject();
		if (project==null)
			return;
		notesMap.clear();
		IFile file = project.getFile(".notes");

		EMap<String, EAppFeature> features = ConfMLCore.getProjectModel(project).getLastLayer().getFeatures();
		if (file.exists())
		{
			try 
		    {
		    	FileInputStream is = (FileInputStream)file.getContents(true);
		    	BufferedReader bReader = new BufferedReader(new InputStreamReader(is,"ASCII"));
		    	String line = null;
		    	
				while((line=bReader.readLine())!=null)
				{
					if (!line.startsWith("#"))
					{
						int index = line.indexOf("=");
						if (index!=-1)
						{
							String ref = line.substring(0, index);
							String note = line.substring(index+1, line.length());
							note = StringEscapeUtils.unescapeJava(note);
							String[] refSegs = ref.split("/");
							String featureRef =refSegs[0];
							EAppFeature feature = features.get(featureRef);
							if (refSegs.length==2)
							{
								String settingRef = refSegs[1];
								EAppSetting setting = feature.getSettings().get(settingRef);
								notesMap.put(setting, note);
							}
							else if (refSegs.length==3)
							{
								String settingRef = refSegs[1];
								EAppSetting setting = feature.getSettings().get(settingRef);
								String subSettingRef = refSegs[2];
								if (setting.getTypeInfo() instanceof EAppSequenceType)
								{
									EAppSequenceType seqType = (EAppSequenceType)setting.getTypeInfo();
									EAppSettingType setType = seqType.getTypeMap().get(subSettingRef);
									notesMap.put(setType, note);
								}
							}
						}
					}
				}
				bReader.close();
			} 
		    catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		
	}
	
	
	public Map<Object, String> getNotes()
	{
		if (notesMap==null)
		{
			notesMap = new HashMap<Object, String>();
			buildNotes();
		}
		return notesMap;
	}
}

