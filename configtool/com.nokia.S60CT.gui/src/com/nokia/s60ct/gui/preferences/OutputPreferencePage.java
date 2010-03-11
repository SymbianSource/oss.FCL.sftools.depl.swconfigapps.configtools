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
package com.nokia.s60ct.gui.preferences;

import java.io.File;
import java.util.ArrayList;

import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.nokia.s60ct.gui.Activator;

import constants.IS60CTCommonConstants;

/**
 * This class represents a preference page that
 * is contributed to the Preferences dialog. By 
 * subclassing <samp>FieldEditorPreferencePage</samp>, we
 * can use the field support built into JFace that allows
 * us to create a page that is small and knows how to 
 * save, restore and apply itself.
 * <p>
 * This page is used to modify preferences only. They
 * are stored in the preference store that belongs to
 * the main plug-in class. That way, preferences can
 * be accessed directly via the preference store.
 */

public class OutputPreferencePage
	extends FieldEditorPreferencePage
	implements IWorkbenchPreferencePage {

	
	public static final String DEFAULT_COMMAND= "epoc32\\tools\\imaker.cmd";	

	private CustomRadioGroupFieldEditor radioGroupFieldEditor = null;
	
	public OutputPreferencePage() {
		super(GRID);
		
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription("Generation environment and output folder preferences:\n");
	}
	
	/**
	 * Creates the field editors. Field editors are abstractions of
	 * the common GUI blocks needed to manipulate various types
	 * of preferences. Each field editor knows how to save and
	 * restore itself.
	 */
	public void createFieldEditors() {
		
		String localEnv = getPreferenceStore().getString(PreferenceConstants.USED_ENVIRONMENT);
		IEclipsePreferences ePref= new ConfigurationScope().getNode(IS60CTCommonConstants.S60_PREFERENCES);
		final String globalEnv = ePref.get(IS60CTCommonConstants.USED_ENVIRONMENT, localEnv);
		
		addField(new ComboFieldEditor(
				PreferenceConstants.USED_ENVIRONMENT, 
				"Environment (%EPOCROOT%):", 
				getAllPossibleEnvironments(), 
				getFieldEditorParent())
				{

					@Override
					protected void fireValueChanged(String property,
							Object oldValue, Object newValue) {
					
						if (!newValue.equals("ERROR"))
						{
							super.fireValueChanged(property, oldValue, newValue);
							radioGroupFieldEditor.setEnvironment((String)newValue);
						}
					}

					@Override
					protected void doLoad() {
						
						String[][] availableEnvs = getAllPossibleEnvironments();
						
						if (globalEnv!= null && !globalEnv.equals(""))
						{
							radioGroupFieldEditor.setEnvironment(globalEnv);
						}
						else if (availableEnvs.length>0)
						{
							radioGroupFieldEditor.setEnvironment(availableEnvs[0][0]);
						}
						else
						{
							radioGroupFieldEditor.setEnvironment(null);
						}
						checkIfEnvExists(availableEnvs, globalEnv);
						super.doLoad();
					}
				});

		radioGroupFieldEditor = new CustomRadioGroupFieldEditor(
				PreferenceConstants.OUTPUT_FOLDER,
				"\nOutput folder",
				2,
				new String[][] {
								{"As specified in IBYML", IS60CTCommonConstants.IBYML},
								{"Environment              "+globalEnv, IS60CTCommonConstants.EPOCROOT},
								{"<Configuration Tool folder>\\", IS60CTCommonConstants.CTFOLDER}
								},
				getFieldEditorParent());
		
		addField(radioGroupFieldEditor);
		
		
		addField(new BooleanFieldEditor(
				PreferenceConstants.DISPLAY_CLEANUP_DIALOG,
				"&Always clean output folder before generation.",
				getFieldEditorParent())
				);
		
		
	}

	private void checkIfEnvExists(String[][] availableEnvs, String env)
	{
		boolean found = false;
		for (int i = 0 ; i < availableEnvs.length ; i++)
		{
			if (availableEnvs[i][0].equalsIgnoreCase(env))
			{
				found = true;
				break;
			}
		}
		if (!found)
		{
			getPreferenceStore().setToDefault(PreferenceConstants.USED_ENVIRONMENT);
			if (availableEnvs.length>0)
			{
				radioGroupFieldEditor.setEnvironment(availableEnvs[0][0]);
			}
			else
				radioGroupFieldEditor.setEnvironment(null);
		}
	}
	
	private String[][] getAllPossibleEnvironments()
	{
		String[][] entryNamesAndValues = null;
		
		ArrayList<String> temp = new ArrayList<String>();
		File[] files = File.listRoots();
		for(File f: files) {
			String imaker = f.getAbsolutePath()+DEFAULT_COMMAND;
			File file = new File(imaker);
			if(file.exists()) {
				temp.add(f.toString());	
			}
		}
		if (temp.size()>0)
		{
			entryNamesAndValues = new String[temp.size()][2];
			for (int i = 0 ; i < temp.size() ; i++)
			{
				entryNamesAndValues[i][0] = temp.get(i);   //label
				entryNamesAndValues[i][1] = temp.get(i);	//value
			}
		}
		else
		{
			entryNamesAndValues = new String[1][2];
			entryNamesAndValues[0][0] = PreferenceConstants.NO_ENV_FOUND;   //label
			entryNamesAndValues[0][1] = "ERROR";	//value
		}
		
		return entryNamesAndValues;
	}
	

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {
	}
	
}