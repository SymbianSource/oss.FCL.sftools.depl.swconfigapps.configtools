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
 * Description: This file is part of com.nokia.tools.variant.common.ui component.
 */

package com.nokia.tools.variant.common.ui.utils;

import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.ui.dialogs.PatternFilter;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.nokia.tools.variant.common.ui.CommonUIPlugin;
import com.nokia.tools.variant.common.ui.ISharedImages;


public class TreeViewerFilterToolbar {
	AbstractTreeViewer viewer;
	PatternFilter filter;

	Composite viewToolbar;
	Text filterText;
	String filterString;
	boolean ignoreModify;

	public TreeViewerFilterToolbar() {
		filterString = "";
	}

	public void init(AbstractTreeViewer viewer, PatternFilter filter) {
		this.viewer = viewer;
		this.filter = filter;

		filter.setPattern(filterString);
		viewer.refresh();
	}

	protected void showHideSearchSection(boolean show) {
		GridData gd = (GridData) viewToolbar.getLayoutData();
		gd.exclude = !show;
		viewToolbar.setVisible(show);
		viewToolbar.getParent().layout();

		if (filterText != null) {
			String newPattern = null;
			if (show) {
				String text = filterString;
				if (text.length() > 0) {
					newPattern = text;
				}
			} else {
				String text = filterString;
				if (text.length() > 0) {
					newPattern = "";
				}
			}
			if (newPattern != null) {
				viewer.getControl().setRedraw(false);
				try {
					filter.setPattern(newPattern);
					viewer.refresh();
				} finally {
					viewer.getControl().setRedraw(true);
				}
			}
		}
	}

	public void createToolbar(ToolBar toolbar, Composite parent,
			FormToolkit formToolkit) {
		final ToolItem toolItem = new ToolItem(toolbar, SWT.CHECK
				| SWT.FLAT);
		
		toolItem.setImage(CommonUIPlugin.getImage(ISharedImages.ICO_FILTER));
		toolItem.setToolTipText("Enable/disable filter on the view");
		toolItem.setSelection(false);
		toolItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				showHideSearchSection(toolItem.getSelection());
			}
		});

		viewToolbar = formToolkit.createComposite(parent, SWT.NONE);
		viewToolbar.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false));
		GridLayout gl = new GridLayout(2, false);
		gl.marginHeight = gl.marginWidth = 0;
		viewToolbar.setLayout(gl);
		showHideSearchSection(false);

		filterText = formToolkit.createText(viewToolbar, "", SWT.BORDER
				| SWT.SINGLE);
		filterText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				true));

		final Button resetFilterBtn = formToolkit.createButton(viewToolbar,
				null, SWT.PUSH);
		resetFilterBtn.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				false, false));

		ToolItem expandAllBtn = new ToolItem(toolbar, SWT.PUSH);
		// expandAllBtn.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
		// false, false));

		ToolItem collapseAllBtn = new ToolItem(toolbar, SWT.PUSH);
		// collapseAllBtn.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER,
		// false, false));

		collapseAllBtn.setImage(CommonUIPlugin
				.getImage(ISharedImages.ICO_COLLAPSEALL));
		collapseAllBtn.setToolTipText("Collapse All");
		collapseAllBtn.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				viewer.getControl().setRedraw(false);
				try {
					viewer.collapseAll();
				} finally {
					viewer.getControl().setRedraw(true);
				}
			}
		});

		expandAllBtn.setImage(CommonUIPlugin
				.getImage(ISharedImages.ICO_EXPANDALL));
		expandAllBtn.setToolTipText("Expand All");
		expandAllBtn.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				viewer.getControl().setRedraw(false);
				try {
					viewer.expandAll();
				} finally {
					viewer.getControl().setRedraw(true);
				}
			}
		});

		resetFilterBtn.setImage(CommonUIPlugin
				.getImage(ISharedImages.ICO_CLEAR_DIS));
		resetFilterBtn.setToolTipText("Reset Filter");
		resetFilterBtn.setEnabled(false);
		resetFilterBtn.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				filterString = "";
				filterText.setText(filterString);
				resetFilterBtn.setEnabled(false);
				resetFilterBtn.setImage(CommonUIPlugin
						.getImage(ISharedImages.ICO_CLEAR_DIS));
			}
		});

		filterString = "";
		filterText.setForeground(ColorConstants.gray);
		ignoreModify = true;
		filterText.setText("Enter value for filter");
		ignoreModify = false;

		// is it necessary to have special font? if yes, it must be
		// recycled/released somewhere

		// Font initialFont = filterText.getFont();
		// FontData[] fontData = initialFont.getFontData();
		// fontData[0].setHeight(10);
		// Font newFont = new Font(Display.getCurrent(), fontData);
		// filterText.setFont(newFont);

		filterText
				.setToolTipText("Enter a value to filter out tree content");
		filterText.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				switch (e.keyCode) {
				case SWT.ESC:
					filterText.setText("");
					break;
				}
			}
		});
		filterText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				if (ignoreModify) {
					return;
				}
				filterString = filterText.getText().trim();
				boolean enabled = filterString.length() != 0;
				resetFilterBtn.setEnabled(enabled);
				resetFilterBtn.setImage(CommonUIPlugin
						.getImage(enabled ? ISharedImages.ICO_CLEAR
								: ISharedImages.ICO_CLEAR_DIS));
				viewer.getControl().setRedraw(false);
				try {
					filter.setPattern(filterString);
					viewer.refresh();
				} finally {
					viewer.getControl().setRedraw(true);
				}
			}
		});
		filterText.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				ignoreModify = true;
				filterText.setText(filterString);
				filterText.setSelection(0, filterString.length());
				filterText.setForeground(viewToolbar.getForeground());
				ignoreModify = false;
			}

			public void focusLost(FocusEvent e) {
				if (filterString.length() == 0) {
					filterText.setForeground(ColorConstants.gray);
					ignoreModify = true;
					filterText.setText("Enter value for filter");
					ignoreModify = false;
				} else {
					// ok
				}
			}
		});
	}

}
