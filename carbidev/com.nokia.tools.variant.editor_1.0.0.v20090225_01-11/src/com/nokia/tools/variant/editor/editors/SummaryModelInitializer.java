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
import java.util.EventObject;

import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.commands.CommandStackListener;

import com.nokia.tools.variant.content.confml.ConfmlPackage;
import com.nokia.tools.variant.content.confml.Icon;
import com.nokia.tools.variant.content.confml.LeafGroup;
import com.nokia.tools.variant.content.confml.ParentGroup;
import com.nokia.tools.variant.content.confml.View;
import com.nokia.tools.variant.editor.adapters.SummaryNotifyAdapter;
import com.nokia.tools.variant.editor.listeners.AdapterRemovalDisposeListener;
import com.nokia.tools.variant.editor.summary.SummaryLeafGroup;
import com.nokia.tools.variant.editor.summary.SummaryParentGroup;
import com.nokia.tools.variant.editor.utils.CPFManager;
import com.nokia.tools.variant.navigator.views.NavigatorViewer;
import com.nokia.tools.variant.viewer.viewer.SettingsViewer;
import com.nokia.tools.variant.views.errormodel.ErrorsRoot;

public class SummaryModelInitializer {
	public static void initializeSummaryGroup(final View view,
			final CPFEditor editor) {
		SummaryParentGroup summaryGroup = null;
		for (ParentGroup parentGroup : view.getParentGroup()) {
			if (parentGroup instanceof SummaryParentGroup) {
				summaryGroup = (SummaryParentGroup) parentGroup;
				break;
			}
		}
		if (summaryGroup == null)
			return;

		// Set summary icon
		ArrayList<Icon> iconList = new ArrayList<Icon>();
		iconList.add(CPFManager.loadSummaryIcon());
		summaryGroup.eSet(ConfmlPackage.GROUP__ICON, iconList);
		final NavigatorViewer navigatorViewer = editor.getNavigatorViewer();
		navigatorViewer.update(summaryGroup, null);
		ErrorsRoot errorsRoot = editor.getErrorsRoot();
		SettingsViewer settingsViewer = editor.getSettingsViewer();

		for (LeafGroup leafGroup : summaryGroup.getLeafGroup()) {
			final SummaryLeafGroup summaryLeafGroup = ((SummaryLeafGroup) leafGroup);
			CommandStack commandStack = editor.getCommandStack();
			if (summaryLeafGroup.getTypeGroup() == SummaryLeafGroup.TypeGroup.ERRORS) {
				summaryLeafGroup.setName(errorsRoot.getErrors().size() + " "
						+ Messages.SUMMARY_ERRORS);
				navigatorViewer.update(summaryLeafGroup, null);
				SummaryNotifyAdapter summaryNotifyAdapter = new SummaryNotifyAdapter(
						summaryLeafGroup, navigatorViewer, errorsRoot);
				errorsRoot.eAdapters().add(summaryNotifyAdapter);
				settingsViewer.getControl().addDisposeListener(
						new AdapterRemovalDisposeListener(errorsRoot,
								summaryNotifyAdapter));
			} else if (summaryLeafGroup.getTypeGroup() == SummaryLeafGroup.TypeGroup.NOTES) {

				updateNumberOfNotes(view, editor, navigatorViewer,
						summaryLeafGroup);
				commandStack
						.addCommandStackListener(new CommandStackListener() {

							public void commandStackChanged(EventObject event) {
								updateNumberOfNotes(view, editor,
										navigatorViewer, summaryLeafGroup);

							}

						});

			} else if (summaryLeafGroup.getTypeGroup() == SummaryLeafGroup.TypeGroup.CHANGES) {
				updateNumberOfChanges(view, editor, navigatorViewer,
						summaryLeafGroup);
				commandStack
						.addCommandStackListener(new CommandStackListener() {

							public void commandStackChanged(EventObject event) {
								updateNumberOfChanges(view, editor,
										navigatorViewer, summaryLeafGroup);

							}

						});

			}
		}

	}

	private static void updateNumberOfNotes(View view, CPFEditor editor,
			NavigatorViewer navigatorViewer, SummaryLeafGroup summaryLeafGroup) {
		View view2 = view;
		summaryLeafGroup.setName(editor.getNrOfNotes(view2) + " "
				+ Messages.SUMMARY_NOTES);
		navigatorViewer.update(summaryLeafGroup, null);
	}

	private static void updateNumberOfChanges(View view, CPFEditor editor,
			NavigatorViewer navigatorViewer, SummaryLeafGroup summaryLeafGroup) {
		View view3 = view;
		summaryLeafGroup.setName(editor.getNrOfChanges(view3) + " "
				+ Messages.SUMMARY_CHANGES);
		navigatorViewer.update(summaryLeafGroup, null);
	}
}
