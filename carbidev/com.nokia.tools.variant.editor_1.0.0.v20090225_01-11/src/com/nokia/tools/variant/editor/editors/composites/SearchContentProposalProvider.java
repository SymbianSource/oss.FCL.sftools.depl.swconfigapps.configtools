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
 * Description: This file is part of com.nokia.tools.variant.editor component.
 */

package com.nokia.tools.variant.editor.editors.composites;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.jface.fieldassist.IContentProposalProvider;

import com.nokia.tools.variant.content.confml.SequenceItem;
import com.nokia.tools.variant.content.confml.SequenceSetting;
import com.nokia.tools.variant.content.confml.Setting;
import com.nokia.tools.variant.content.confml.View;


public class SearchContentProposalProvider implements IContentProposalProvider {

	private List<Setting> settings;
	
	public SearchContentProposalProvider(View view) {
		if (view == null) {
			return;
		}
		this.settings = view.getSharedSettingInstances();
	}
	
	public IContentProposal[] getProposals(String contents, int position) {
		String[] settingNames = getSettingNames(contents);
		List<IContentProposal> proposals = new ArrayList<IContentProposal>();
		for (int i = 0 ; i < settingNames.length ; i++) {
			proposals.add(createProposal(settingNames[i]));
		}
		return proposals.toArray(new IContentProposal[proposals.size()]);
	}
	
	private String getSettingName(final Setting s) {
		if (s.getNameOverride() != null) {
			return s.getNameOverride();
		} else {
			return s.getName();
		}
	}
	
	protected IContentProposal createProposal(final String s) {
		return new IContentProposal() {
			public String getContent() {
				return s;
			}

			
			public int getCursorPosition() {
				return s.length();
			}
			
			public String getDescription() {
				return null;
			}
			
			public String getLabel() {
				return null;
			}
		};
	}
	
	
	/**
	 * 
	 * @return array of names of all settings [except empty or undefined names]
	 */
	public String[] getSettingNames(String keyword) {
		Set<String> settingNames = new HashSet<String>();

		addSettingNames2Set(settings, settingNames, keyword);
		String[] names = settingNames.toArray(new String[0]);
		Arrays.sort(names);
		return names;
	}

	/**
	 * Add all setting and subsetting names to the list of proposals for auto
	 * completion
	 * 
	 * @param allSettings
	 *            list of settings in the model
	 * @param settingNames
	 *            list of all names of settings in the model
	 */
	private void addSettingNames2Set(List<Setting> allSettings,
			Set<String> settingNames, String keyword) {
		
		for (int i = 0; i < allSettings.size(); i++) {
			Setting setting = allSettings.get(i);
			if (setting.isVisible()) {// skip non-displayed settings 
				if (setting.isComputedRelevant()) {// propose only relevant settings
					String name = getSettingName(setting);
					if (name != null && !name.equals("") && containsStringIgnoreCase(name, keyword)) {// skip non-relevant settings
						settingNames.add(name);
					}
				}	
				if (setting instanceof SequenceSetting) {
					SequenceSetting ss = (SequenceSetting) setting;
					EList<SequenceItem> items = ss.getSequenceItem();
					for (int j = 0 ; j < items.size () ; j++) {
						SequenceItem si = items.get(j); 
						
						EList<Setting> subsettings = si.getSetting();
						for (int k = 0; k < subsettings.size(); k++) {
							Setting subs = subsettings.get(k);
							if (!subs.isReadOnly()) {// skip readonly settings
								if (subs.isComputedRelevant()) {// propose only relevant settings
									String subSettingName = getSettingName(subs);
									if (subSettingName != null && !subSettingName.equals("") && containsStringIgnoreCase(subSettingName, keyword)) {// skip non-relevant settings
										settingNames.add(subSettingName);
									}
								}
							}
						}
					}
				}
			}
		}
	}

	public static boolean containsStringIgnoreCase(String text, String keyword) {
		String aText = text.toLowerCase();
		String aKeyword = keyword.toLowerCase();
		if (aText.contains(aKeyword)) {
			return true;
		}
		
		return false;
	}

}
