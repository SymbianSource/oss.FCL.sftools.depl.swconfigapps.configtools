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
 * Description: This file is part of com.nokia.tools.variant.views component.
 */

package com.nokia.tools.variant.views.common;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TableColumn;

import com.nokia.tools.variant.content.confml.FileSystemEntrySetting;
import com.nokia.tools.variant.content.confml.LeafGroup;
import com.nokia.tools.variant.content.confml.ParentGroup;
import com.nokia.tools.variant.content.confml.SequenceSetting;
import com.nokia.tools.variant.content.confml.Setting;
import com.nokia.tools.variant.content.confml.SimpleSetting;
import com.nokia.tools.variant.views.changesview.ChangesContentProvider;
import com.nokia.tools.variant.views.errormodel.Error;
import com.nokia.tools.variant.views.errorview.ErrorsContentProvider;
import com.nokia.tools.variant.views.notesview.NotesContentProvider;
import com.nokia.tools.variant.views.searchresultsview.SearchContentProvider;

/**
 * Provides sorting for tables embedded in these views: Errors, Changes, Notes
 * and Search result. Sorting is implemented for each column.
 * 
 */
public class Sorter extends ViewerSorter {

	private TableColumn currentColumn;
	private int dir;

	public Sorter(TableColumn currentColumn, int dir) {
		super();
		this.currentColumn = currentColumn;
		this.dir = dir;
	}

	@Override
	public int compare(Viewer viewer, Object e1, Object e2) {
		int returnValue = 0;

		IContentProvider contentProvider = null;

		if (viewer instanceof TableViewer) {

			TableViewer tv = (TableViewer) viewer;
			contentProvider = tv.getContentProvider();

		}

		if (contentProvider instanceof ErrorsContentProvider) {

			Error er1 = (Error) e1;
			Error er2 = (Error) e2;

			if (currentColumn.getText() == ViewsMessages.ERROR_COLUMN_1_NAME) {
				returnValue = er1.getSetting().getName().compareTo(
						er2.getSetting().getName());
			}

			if (currentColumn.getText() == ViewsMessages.ERROR_COLUMN_2_NAME) {
				returnValue = er1.getDescription().compareTo(
						er2.getDescription());
			}

			if (currentColumn.getText() == ViewsMessages.ERROR_COLUMN_3_NAME) {
				String location1 = getLocation(er1.getSetting());
				String location2 = getLocation(er2.getSetting());
				returnValue = location1.compareTo(location2);
			}

		} else if (contentProvider instanceof ChangesContentProvider) {

			Setting s1 = (Setting) e1;
			Setting s2 = (Setting) e2;

			if (currentColumn.getText() == ViewsMessages.CHANGES_COLUMN_1_NAME) {
				returnValue = s1.getName().compareTo(s2.getName());
			}

			if (currentColumn.getText() == ViewsMessages.CHANGES_COLUMN_2_NAME) {
				if (s1 instanceof SimpleSetting && s2 instanceof SimpleSetting) {
					SimpleSetting simples1 = (SimpleSetting) s1;
					SimpleSetting simples2 = (SimpleSetting) s2;
					returnValue = simples1.getValue().compareTo(
							simples2.getValue());
				}

				if (s1 instanceof SimpleSetting
						&& (s2 instanceof FileSystemEntrySetting || s2 instanceof SequenceSetting))
					returnValue = -1;

				if ((s1 instanceof FileSystemEntrySetting || s1 instanceof SequenceSetting)
						&& s2 instanceof SimpleSetting)
					returnValue = 1;

				if ((s1 instanceof FileSystemEntrySetting || s1 instanceof SequenceSetting)
						&& (s2 instanceof FileSystemEntrySetting || s2 instanceof SequenceSetting))
					return 0;

			}

			if (currentColumn.getText() == ViewsMessages.CHANGES_COLUMN_3_NAME) {
				if (s1 instanceof SimpleSetting && s2 instanceof SimpleSetting) {
					String default1 = ((SimpleSetting) s1).getDefaultValue();
					String default2 = ((SimpleSetting) s2).getDefaultValue();
					if (default1 == null) {
						default1 = "";
					}
					if (default2 == null) {
						default2 = "";
					}
					returnValue = default1.compareTo(default2);
				}

				if (s1 instanceof SimpleSetting
						&& (s2 instanceof FileSystemEntrySetting || s2 instanceof SequenceSetting))
					returnValue = -1;

				if ((s1 instanceof FileSystemEntrySetting || s1 instanceof SequenceSetting)
						&& s2 instanceof SimpleSetting)
					returnValue = 1;

				if ((s1 instanceof FileSystemEntrySetting || s1 instanceof SequenceSetting)
						&& (s2 instanceof FileSystemEntrySetting || s2 instanceof SequenceSetting))
					return 0;
			}

			if (currentColumn.getText() == ViewsMessages.CHANGES_COLUMN_4_NAME) {
				String location1 = getLocation(s1);
				String location2 = getLocation(s2);
				returnValue = location1.compareTo(location2);
			}

		} else if (contentProvider instanceof NotesContentProvider) {

			Setting s1 = (Setting) e1;
			Setting s2 = (Setting) e2;

			if (currentColumn.getText() == ViewsMessages.NOTES_COLUMN_1_NAME) {
				returnValue = s1.getName().compareTo(s2.getName());
			}

			if (currentColumn.getText() == ViewsMessages.NOTES_COLUMN_2_NAME) {
				returnValue = s1.getNote().compareTo(s2.getNote());
			}

			if (currentColumn.getText() == ViewsMessages.NOTES_COLUMN_3_NAME) {
				String location1 = getLocation(s1);
				String location2 = getLocation(s2);
				returnValue = location1.compareTo(location2);
			}

		} else if (contentProvider instanceof SearchContentProvider) {

			Setting s1 = (Setting) e1;
			Setting s2 = (Setting) e2;
			int column = 0;
			if (currentColumn.getText() == ViewsMessages.SEARCH_COLUMN_1_NAME)
				column = 1;
			if (currentColumn.getText() == ViewsMessages.SEARCH_COLUMN_2_NAME)
				column = 2;
			if (column == 2) {
				returnValue = detectNull(s1.getDescription(), s2
						.getDescription());
				if (returnValue == 2)
					returnValue = s1.getDescription().compareTo(
							s2.getDescription());
				if (returnValue == 0)
					column = 1;
			}
			if (column == 1) {
				returnValue = detectNull(s1.getName(), s2.getName());
				if (returnValue == 2)
					returnValue = s1.getName().compareTo(s2.getName());
			}
			if (currentColumn.getText() == ViewsMessages.SEARCH_COLUMN_3_NAME) {
				String location1 = getLocation(s1);
				String location2 = getLocation(s2);
				returnValue = location1.compareTo(location2);
			}

		}

		// ******
		if (dir == SWT.UP) {
			return -returnValue;
		}
		return returnValue;
	}

	private String getLocation(Setting setting) {
		String location = "";
		if (setting.getLeafGroup().size() > 0) {
			LeafGroup leafGroup = setting.getLeafGroup().get(0);
			EObject container = leafGroup.eContainer();
			if (container instanceof ParentGroup) {
				ParentGroup parentGroup = (ParentGroup) container;
				location = leafGroup.getName() + " - " + parentGroup.getName();
			}
		} else if (setting.eContainer().eContainer() instanceof SequenceSetting) {
			SequenceSetting sequenceSetting = (SequenceSetting) setting
					.eContainer().eContainer();
			if (sequenceSetting.getLeafGroup().size() > 0) {
				LeafGroup leafGroup = sequenceSetting.getLeafGroup().get(0);
				EObject container = leafGroup.eContainer();
				if (container instanceof ParentGroup) {
					ParentGroup parentGroup = (ParentGroup) container;
					location = leafGroup.getName() + " - "
							+ parentGroup.getName();
				}
			} else if (sequenceSetting.getParentGroup().size() > 0) {
				ParentGroup parentGroup = sequenceSetting.getParentGroup().get(
						0);
				location = parentGroup.getName();
			}
		} else if ((setting.eContainer() != null) && (setting.eContainer().eContainer() != null)
				&& (setting.eContainer().eContainer().eContainer() instanceof SequenceSetting)) {
			SequenceSetting sequenceSetting = (SequenceSetting) setting
					.eContainer().eContainer().eContainer();
			if (sequenceSetting.getLeafGroup().size() > 0) {
				LeafGroup leafGroup = sequenceSetting.getLeafGroup()
						.get(0);
				EObject container = leafGroup.eContainer();
				if (container instanceof ParentGroup) {
					ParentGroup parentGroup = (ParentGroup) container;
					location = parentGroup.getName() + " - "
							+ leafGroup.getName();
				}
			} else if (sequenceSetting.getParentGroup().size() > 0) {
				ParentGroup parentGroup = sequenceSetting.getParentGroup().get(0);
				location = parentGroup.getName();
			}
		} else if (setting.getParentGroup().size() > 0) {
			ParentGroup parentGroup = setting.getParentGroup().get(0);
			location = parentGroup.getName();
		}
		return location;
	}

	/**
	 * 
	 * @param obj1
	 * @param obj2
	 * @return
	 */
	private int detectNull(Object obj1, Object obj2) {
		if (obj1 == null && obj2 == null)
			return 0;
		if (obj1 == null && obj2 != null)
			return 1;
		if (obj1 != null && obj2 == null)
			return -1;

		return 2;
	}
}
