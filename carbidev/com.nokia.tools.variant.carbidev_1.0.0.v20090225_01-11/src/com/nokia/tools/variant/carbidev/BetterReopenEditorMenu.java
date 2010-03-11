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
 * Description: This file is part of com.nokia.tools.variant.carbidev component.
 */

package com.nokia.tools.variant.carbidev;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.jface.action.ContributionItem;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.util.SafeRunnable;
import org.eclipse.osgi.util.NLS;
import org.eclipse.osgi.util.TextProcessor;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.internal.EditorHistory;
import org.eclipse.ui.internal.EditorHistoryItem;
import org.eclipse.ui.internal.Workbench;
import org.eclipse.ui.internal.WorkbenchMessages;
import org.eclipse.ui.internal.WorkbenchPlugin;

import com.nokia.tools.variant.editor.actions.OpenCpfAction;


@SuppressWarnings("restriction")
public class BetterReopenEditorMenu extends ContributionItem {
	private IWorkbenchWindow window;
	private EditorHistory history;
	private boolean showSeparator;
	private boolean dirty;
	private IMenuListener menuListener;
	
	public BetterReopenEditorMenu(IWorkbenchWindow window, String id,
			boolean showSeparator) {
		super(id);
		dirty = true;
		menuListener = new IMenuListener() {

			public void menuAboutToShow(IMenuManager manager) {
				OpenCpfAction.clearHistoryTable();
				manager.markDirty();
				dirty = true;
			}

		};
		this.window = window;
		this.showSeparator = showSeparator;
		history = ((Workbench) window.getWorkbench()).getEditorHistory();
	}

	private String calcText(int index, EditorHistoryItem item) {
		StringBuffer sb = new StringBuffer();
		int mnemonic = index + 1;
		sb.append(mnemonic);
		if (mnemonic <= 9)
			sb.insert(sb.length()
					- (new StringBuffer(String.valueOf(mnemonic))).toString()
							.length(), '&');
		sb.append(" ");
		String fileName = item.getName();
		String pathName = item.getToolTipText();
		if (pathName.equals(fileName))
			pathName = "";
		IPath path = new Path(pathName);
		if (path.segmentCount() > 1
				&& path.segment(path.segmentCount() - 1).equals(fileName)) {
			path = path.removeLastSegments(1);
			pathName = path.toString();
		}
		if (fileName.length() + pathName.length() <= 36) {
			sb.append(fileName);
			if (pathName.length() > 0) {
				sb.append("  [");
				sb.append(pathName);
				sb.append("]");
			}
		} else {
			int length = fileName.length();
			if (length > 40) {
				sb.append(fileName.substring(0, 37));
				sb.append("...");
			} else if (length > 33) {
				sb.append(fileName);
			} else {
				sb.append(fileName);
				int segmentCount = path.segmentCount();
				if (segmentCount > 0) {
					length += 7;
					sb.append("  [");
					int i = 0;
					while (i < segmentCount && length < 40) {
						String segment = path.segment(i);
						if (length + segment.length() < 40) {
							sb.append(segment);
							sb.append('/');
							length += segment.length() + 1;
							i++;
							continue;
						}
						if (i == 0) {
							sb.append(segment.substring(0, 40 - length));
							length = 40;
						}
						break;
					}
					sb.append("...");
					for (i = segmentCount - 1; i > 0 && length < 40; i--) {
						String segment = path.segment(i);
						if (length + segment.length() >= 40)
							break;
						sb.append('/');
						sb.append(segment);
						length += segment.length() + 1;
					}

					sb.append("]");
				}
			}
		}
		return TextProcessor.process(sb.toString(), TextProcessor
				.getDefaultDelimiters()
				+ "[]");
	}

	public void fill(final Menu menu, int index) {
		OpenCpfAction.clearHistoryTable();
		if (window.getActivePage() == null
				|| window.getActivePage().getPerspective() == null)
			return;
		if (getParent() instanceof MenuManager)
			((MenuManager) getParent()).addMenuListener(menuListener);
		int itemsToShow = WorkbenchPlugin.getDefault().getPreferenceStore()
				.getInt("RECENT_FILES");
		if (itemsToShow == 0)
			return;
		EditorHistoryItem historyItems[] = history.getItems();
		int n = Math.min(itemsToShow, historyItems.length);
		if (n <= 0)
			return;
		if (showSeparator) {
			new MenuItem(menu, 2, index);
			index++;
		}
		final int menuIndex[] = { index };
		for (int i = 0; i < n; i++) {
			final EditorHistoryItem item = historyItems[i];
			final int historyIndex = i;
			SafeRunner.run(new SafeRunnable() {

				public void run() throws Exception {
					String text = calcText(historyIndex, item);
					MenuItem mi = new MenuItem(menu, 8, menuIndex[0]);
					menuIndex[0]++;
					mi.setText(text);
					mi.addSelectionListener(new SelectionAdapter() {

						public void widgetSelected(SelectionEvent e) {
							open(item);
						}

					});
				}

				public void handleException(Throwable e) {
					WorkbenchPlugin.log(getClass(), "fill", e);
				}

			});
		}

		dirty = false;
	}

	public boolean isDirty() {
		return dirty;
	}

	public boolean isDynamic() {
		return true;
	}

	private void open(EditorHistoryItem item) {
		IWorkbenchPage page = window.getActivePage();
		if (page != null) {
			String itemName = item.getName();
			if (!item.isRestored())
				item.restoreState();
			org.eclipse.ui.IEditorInput input = item.getInput();
			IEditorDescriptor desc = item.getDescriptor();
			if (input == null || desc == null) {
				String title = WorkbenchMessages.OpenRecent_errorTitle;
				String msg = NLS.bind(
						WorkbenchMessages.OpenRecent_unableToOpen, itemName);
				MessageDialog.openWarning(window.getShell(), title, msg);
				history.remove(item);
			} else {
				OpenCpfAction action = new OpenCpfAction();
				action.importProject(item.getToolTipText());
			}
		}
	}
}
