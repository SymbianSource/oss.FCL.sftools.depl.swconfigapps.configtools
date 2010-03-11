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

package com.nokia.tools.variant.editor.editors;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

import com.nokia.tools.variant.content.confml.LeafGroup;
import com.nokia.tools.variant.content.confml.ParentGroup;
import com.nokia.tools.variant.content.confml.Setting;
import com.nokia.tools.variant.content.confml.View;
import com.nokia.tools.variant.editor.model.summaryModel.History;
import com.nokia.tools.variant.editor.model.summaryModel.Note;
import com.nokia.tools.variant.editor.model.summaryModel.SUMMARYTYPE;
import com.nokia.tools.variant.editor.model.summaryModel.UIElement;
import com.nokia.tools.variant.editor.model.summaryModel.UISummaryGroup;
import com.nokia.tools.variant.resourcelibrary.model.ResourceModelRoot;
import com.nokia.tools.variant.viewer.viewer.ISettingsLabelProvider;
import com.nokia.tools.variant.viewer.viewer.Type;
import com.nokia.tools.variant.viewer.widgets.WidgetOption;
import com.nokia.tools.variant.viewer.widgets.WidgetOptions;
import com.nokia.tools.variant.views.errormodel.ErrorsRoot;

/**
 * This provider is used to map the UISummaryModel into text strings displayable
 * in the SettingsViewer widgets in the Summary page. The provider has method
 * getText(Object element) that returns name of group or setting.
 * 
 */
public class SummaryViewerLabelProvider implements ISettingsLabelProvider {
	public Image getImage(Object element) {

		return null;
	}

	public String getText(Object element) {
		if (element instanceof UISummaryGroup) {
			String title = ((UISummaryGroup) element).getTitle();
			return title;
		}
		if (element instanceof UIElement) {
			UIElement ui = (UIElement) element;
			return ui.getName();
		}
		return null;
	}

	public void addListener(ILabelProviderListener listener) {

	}

	public void dispose() {

	}

	public boolean isLabelProperty(Object element, String property) {

		return false;
	}

	public void removeListener(ILabelProviderListener listener) {

	}

	public Type getType(Object element) {
		if (element instanceof UIElement) {
			UIElement uiElement = (UIElement) element;
			switch (uiElement.getType()) {
			case DESCRIPTION:
				return Type.DESCRIPTION;
			case CONTENTS:
				return Type.CONTENTS;
			case PRODUCTIMAGES:
				return Type.PRODUCTIMAGES;
			case GUIDELINE:
				return Type.GUIDELINE;
			case HISTORY:
				return Type.HISTORY;
			case CUSTOMER:
			case AUTHOR:
			case OWNER:
				return Type.ELEMENT_EDITABLE;
			case AVR:
				return Type.AVR;
			default:
				return Type.ELEMENT_READONLY;
			}
		} else if (element instanceof UISummaryGroup) {
			return Type.TITLE;
		}

		return Type.STRING;
	}

	public WidgetOptions getOptions(Object element) {
		if (element instanceof UIElement) {
			UIElement uiElement = (UIElement) element;
			if (uiElement.getType().equals(SUMMARYTYPE.HISTORY)) {
				CPFEditor editor;
				IEditorPart activeEditor = PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getActivePage()
						.getActiveEditor();
				if (activeEditor instanceof CPFEditor) {
					editor = (CPFEditor) activeEditor;
				} else {
					return null;
				}
				History history = editor.getViewEditorModel().getHistory();

				EList<Note> notes = history.getNote();
				Set<WidgetOption> widgetOptions = new LinkedHashSet<WidgetOption>();
				for (Note note : notes) {
					WidgetOption o = new WidgetOption(note.getDate(), note
							.getContent(), null, null);
					widgetOptions.add(o);
				}
				WidgetOptions options = new WidgetOptions(widgetOptions);
				return options;
			}
			if (uiElement.getType().equals(SUMMARYTYPE.CONTENTS)) {
				IEditorPart activeEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
				if(activeEditor instanceof CPFEditor){
					CPFEditor cpfEditor = (CPFEditor)activeEditor;

					return createContentsOptions(cpfEditor);
				}
			}

		}
		return null;
	}
	
	private WidgetOptions createContentsOptions(CPFEditor cpfEditor){
		ResourceModelRoot root = (ResourceModelRoot) cpfEditor.getAdapter(ResourceModelRoot.class);
		View view = cpfEditor.getView();
		Set<WidgetOption> widgetOptions = new LinkedHashSet<WidgetOption>();
		WidgetOption errors = new WidgetOption(null, "<A>" +  getNrOfErrors(cpfEditor)
				+ " errors</A>", null, null);
		widgetOptions.add(errors);
		WidgetOption notes = new WidgetOption(null,"<A>"
				+ cpfEditor.getNrOfNotes(view) +" notes</A>", null, null);
		widgetOptions.add(notes);
		WidgetOption changes = new WidgetOption(null,"<A>" + 
				cpfEditor.getNrOfChanges(view) +
				" settings changed from default</A>", null, null);
		widgetOptions.add(changes);
		WidgetOption resources = new WidgetOption(null,
				"<A>" + 
				  root.getSize() +
				 " resources</A>", null, null);
		widgetOptions.add(resources);
		
		EList<Setting> sharedSettingInstances = view
				.getSharedSettingInstances();
			
		//the list of settings that aren't read-only 
		List<Setting> visibleSettings = new ArrayList<Setting>();
		for(Setting setting:sharedSettingInstances){
			if((setting.isVisible()))
				visibleSettings.add(setting);
		}

		Set<String> featureRefSet = new HashSet<String>();
		Set<String> parentGroupSet = new HashSet<String>();
		for (Setting setting : visibleSettings) {
			featureRefSet.add(setting.getFeatureRef());
			EList<LeafGroup> leafGroups = setting.getLeafGroup();
			for (LeafGroup leafGroup : leafGroups) {
				parentGroupSet.add(((ParentGroup) leafGroup.eContainer())
						.getName());
			}

			EList<ParentGroup> parentGroups = setting.getParentGroup();
			for (ParentGroup parentGroup : parentGroups) {
				parentGroupSet.add(parentGroup.getName());
			}

		}
		int nrOfSetting = visibleSettings.size();
		int nrOfFeature = featureRefSet.size();
		int nrOfGroup = parentGroupSet.size();
		
		WidgetOption groups = new WidgetOption(null,nrOfGroup+" Groups", null, null);
		widgetOptions.add(groups);
		WidgetOption features = new WidgetOption(null,nrOfFeature+" Features", null, null);
		widgetOptions.add(features);
		WidgetOption settings = new WidgetOption(null,nrOfSetting+" Settings", null, null);
		widgetOptions.add(settings);
		WidgetOptions options = new WidgetOptions(widgetOptions);
		return options;
	}

	private int getNrOfErrors(CPFEditor editor) {
		ErrorsRoot errorsRoot = (ErrorsRoot) editor
				.getAdapter(ErrorsRoot.class);
		return errorsRoot.getErrors().size();
	}


}
