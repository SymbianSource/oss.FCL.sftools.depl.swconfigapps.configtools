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

package com.nokia.tools.variant.editor.dialogs;

import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import com.nokia.tools.variant.editor.Activator;
import com.nokia.tools.variant.editor.cpfInfo.CPFInformation;

/**
 * This dialog is used for choosing CPFInformation from CPF if there is present
 * more than one.
 */
public class SelectConfigurationDialog extends Dialog {

	private static final String KEY_TOOLTIPTEXT = "TOOLTIPTEXT";

	private Table configTable;

	private List<CPFInformation> configurations;

	private int selectedConfigurationIndex = -1;

	public SelectConfigurationDialog(Shell parentShell,
			List<CPFInformation> configurations) {
		super(parentShell);
		this.configurations = configurations;
	}

	/**
	 * Returns selected configuration root file by user
	 * 
	 * @return
	 */
	public CPFInformation getSelectedConfiguration() {
		if (selectedConfigurationIndex != -1) {
			return configurations.get(selectedConfigurationIndex);
		}
		return null;
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		GridLayout layout3 = (GridLayout) parent.getLayout();
		layout3.marginLeft = 0;
		layout3.marginRight = 0;
		layout3.marginTop = 0;
		layout3.marginBottom = 0;
		layout3.horizontalSpacing = 0;
		layout3.verticalSpacing = 0;
		parent.setLayout(layout3);

		Composite dialogArea = (Composite) super.createDialogArea(parent);
		GridLayout layout = new GridLayout(1, false);
		dialogArea.setLayout(layout);

		Composite c = new Composite(dialogArea, SWT.NONE);
		c.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		GridLayout layout2 = new GridLayout(2, false);
		c.setLayout(layout2);
		c.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));

		Label l = new Label(c, SWT.NONE);
		l
				.setText("The file contains multiple configurations. Select configuration and then press OK.");
		l.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		GridData layoutData = new GridData(GridData.FILL_HORIZONTAL);
		layoutData.heightHint = 60;
		layoutData.grabExcessHorizontalSpace = true;
		l.setLayoutData(layoutData);

		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.HORIZONTAL_ALIGN_END;
		gridData.heightHint = 60;
		Label rightLabel = new Label(c, SWT.NO);
		rightLabel.setLayoutData(gridData);

		ImageDescriptor imageDescriptor = Activator
				.getImageDescriptor("icons/saveas_wiz.png");
		Image image = imageDescriptor.createImage();

		rightLabel.setImage(image);
		rightLabel.setBackground(Display.getCurrent().getSystemColor(
				SWT.COLOR_WHITE));

		Rectangle bounds = dialogArea.getShell().getBounds();
		getShell().setBounds(bounds);

		dialogArea.setLayout(new GridLayout());
		configTable = new Table(dialogArea, SWT.FULL_SELECTION);
		final TableViewer viewer = new TableViewer(configTable);

		final Listener labelDisposeListener = new Listener() {
			public void handleEvent(Event event) {
				StyledText styledText = (StyledText) event.widget;
				Shell shell = styledText.getShell();
				switch (event.type) {
				case SWT.MouseDown:
					Event e = new Event();
					e.item = (TableItem) styledText.getData(KEY_TOOLTIPTEXT);
					configTable
							.setSelection(new TableItem[] { (TableItem) e.item });
					configTable.notifyListeners(SWT.Selection, e);
					// dispose shell on mouse down
				case SWT.MouseExit:
					shell.dispose();
					break;
				}
			}
		};

		Listener toolTipDisplayListener = new Listener() {
			Shell tooltipShell = null;
			StyledText styledText = null;

			public void handleEvent(Event event) {
				switch (event.type) {
				case SWT.Dispose:
				case SWT.KeyDown:
				case SWT.MouseMove: 
					if (tooltipShell == null || tooltipShell.isDisposed()) {
						break;
					}
					tooltipShell.dispose();
					tooltipShell = null;
					styledText = null;
					break;
				case SWT.MouseHover: 
					TableItem item = configTable.getItem(new Point(event.x,
							event.y));
					if (item != null) {
						if (tooltipShell != null && !tooltipShell.isDisposed()) {
							tooltipShell.dispose();
						}
						tooltipShell = new Shell(configTable.getShell(), SWT.ON_TOP
								| SWT.TOOL);
						tooltipShell.setLayout(new FillLayout());
						styledText = new StyledText(tooltipShell, SWT.NONE);
						styledText.setEditable(false);
						styledText.getCaret().setVisible(false);
						styledText.setBackground(configTable.getDisplay()
								.getSystemColor(SWT.COLOR_INFO_BACKGROUND));
						styledText.setForeground(configTable.getDisplay()
								.getSystemColor(SWT.COLOR_INFO_FOREGROUND));
						styledText.setData(KEY_TOOLTIPTEXT, item);
						Object data = item.getData();
						CPFInformation cpfInformation = (CPFInformation) data;
						styledText.setText(cpfInformation.getLayerPopupInfoText());
						styledText.addListener(SWT.MouseExit, labelDisposeListener);
						styledText.addListener(SWT.MouseDown, labelDisposeListener);
						Point size = tooltipShell.computeSize(SWT.DEFAULT, SWT.DEFAULT);
						Rectangle rect = item.getBounds(0);
						Point pt = configTable.toDisplay(rect.x, rect.y);
						tooltipShell.setBounds(pt.x, pt.y, size.x, size.y);
						tooltipShell.setVisible(true);
					}
					break;
				}
			}
		};

		configTable.addListener(SWT.Dispose, toolTipDisplayListener);
		configTable.addListener(SWT.KeyDown, toolTipDisplayListener);
		configTable.addListener(SWT.MouseMove, toolTipDisplayListener);
		configTable.addListener(SWT.MouseHover, toolTipDisplayListener);

		
		configTable.setHeaderVisible(true);
		configTable.setLayoutData(new GridData(GridData.FILL_BOTH));

		configTable.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				selectedConfigurationIndex = configTable.getSelectionIndex();
				viewer.setSelection(new StructuredSelection(viewer
						.getElementAt(selectedConfigurationIndex)), true);
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		final String[] columnNames = new String[] { "Name", "Version",
				"Platform", "Release", "Product", "Date" };
		final int[] columnWidths = new int[] { 170, 50, 100, 60, 100, 100 };

		viewer.setColumnProperties(columnNames);

		TableColumn nameColumn = new TableColumn(configTable, SWT.LEFT);
		nameColumn.setText(columnNames[0]);
		nameColumn.setWidth(columnWidths[0]);

		TableColumn versionColumn = new TableColumn(configTable, SWT.LEFT);
		versionColumn.setText(columnNames[1]);
		versionColumn.setWidth(columnWidths[1]);

		TableColumn platformColumn = new TableColumn(configTable, SWT.LEFT);
		platformColumn.setText(columnNames[2]);
		platformColumn.setWidth(columnWidths[2]);

		TableColumn releaseColumn = new TableColumn(configTable, SWT.LEFT);
		releaseColumn.setText(columnNames[3]);
		releaseColumn.setWidth(columnWidths[3]);

		TableColumn productColumn = new TableColumn(configTable, SWT.LEFT);
		productColumn.setText(columnNames[4]);
		productColumn.setWidth(columnWidths[4]);

		TableColumn dateColumn = new TableColumn(configTable, SWT.LEFT);
		dateColumn.setText(columnNames[5]);
		dateColumn.setWidth(columnWidths[5]);

		viewer.setLabelProvider(new ITableLabelProvider() {

			public void removeListener(ILabelProviderListener listener) {
			}

			public boolean isLabelProperty(Object element, String property) {
				return false;
			}

			public void dispose() {
			}

			public void addListener(ILabelProviderListener listener) {
			}

			public String getColumnText(Object element, int columnIndex) {
				if (!(element instanceof CPFInformation)) {
					return null;
				}
				CPFInformation ci = (CPFInformation) element;
				switch (columnIndex) {
				case 0:
					return ci.getName();
				case 1:
					return ci.getVersion();
				case 2:
					return ci.getPlatform();
				case 3:
					return ci.getRelease();
				case 4:
					return ci.getProduct();
				case 5:
					return ci.getDate();
				}
				return null;
			}

			public Image getColumnImage(Object element, int columnIndex) {
				return null;
			}
		});

		ArrayContentProvider provider = new ArrayContentProvider();
		viewer.setContentProvider(provider);

		viewer.setInput(configurations);

		int itemCount = configTable.getItemCount();
		for (int i = 0; i < itemCount; i++) {
			TableItem item = configTable.getItem(i);
			// ToolTip.createToolTip(item, "");
		}
		viewer.setSelection(new StructuredSelection(viewer.getElementAt(0)),
				true);
		dialogArea.setLayoutData(new GridData(GridData.FILL, GridData.FILL,
				true, true));
		return dialogArea;
	}

	@Override
	protected Point getInitialSize() {
		Point size = getShell().computeSize(SWT.DEFAULT, SWT.DEFAULT);
		if (size.y > 600) {
			size.y = 600;
		}
		return size;
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Select configuration");
	}
}
