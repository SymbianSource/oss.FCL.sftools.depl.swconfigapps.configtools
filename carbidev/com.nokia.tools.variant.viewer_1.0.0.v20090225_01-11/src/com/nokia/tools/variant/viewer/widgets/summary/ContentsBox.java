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
 * Description: This file is part of com.nokia.tools.variant.viewer component.
 */

package com.nokia.tools.variant.viewer.widgets.summary;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import com.nokia.tools.variant.viewer.widgets.BaseConfMLWidget;
import com.nokia.tools.variant.viewer.widgets.WidgetOption;
import com.nokia.tools.variant.viewer.widgets.WidgetOptions;

/**
 * It represent element in Summary page that contains information about number
 * of groups, features, errors ... and references to Errors, Notes, Changes and
 * Resources view. This class has adapters that listen to changes on Errorsroot
 * (number of errors), View (number of settings changed from default) and
 * Resource Library (number of resource elements)
 * 
 */
public class ContentsBox extends BaseConfMLWidget {

	private List<Control> container;
	private Composite control;
	private Link linkErrors;
	private Link linkNotes;
	private Link linkChanges;
	private Link linkResources;
	private Text groupsText;
	private Text featuresText;
	private Text settingsText;

	public ContentsBox(Composite parent, int style, String widgetLabel) {
		super(parent, style, widgetLabel);
	}

	public ContentsBox(Composite parent, int style, String widgetLabel,
			Image image) {
		super(parent, style, widgetLabel, image);
	}

	@Override
	protected void buildMainControl() {
		control = new Composite(group, SWT.NONE);
		control.setBackground(group.getBackground());
		GridLayout gridLayout = new GridLayout(1, false);

		control.setLayout(gridLayout);
		control.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		container = new ArrayList<Control>();

		linkErrors = new Link(control, SWT.NONE);
		linkErrors.setText("<A>" + "" + " errors</A>");
		linkErrors.setBackground(group.getBackground());
		container.add(linkErrors);

		linkNotes = new Link(control, SWT.NONE);
		linkNotes.setText("<A>" + " notes</A>");
		linkNotes.setBackground(group.getBackground());
		container.add(linkNotes);

		linkChanges = new Link(control, SWT.NONE);
		linkChanges.setText("<A>" + " settings changed from default</A>");
		linkChanges.setBackground(group.getBackground());

		container.add(linkChanges);

		linkResources = new Link(control, SWT.NONE);
		linkResources.setBackground(group.getBackground());
		container.add(linkResources);

		linkResources.setText("<A>" + " resources</A>" + "   ");

		groupsText = new Text(control, SWT.NONE);
		groupsText.setText(" Groups");
		container.add(groupsText);
		featuresText = new Text(control, SWT.NONE);
		featuresText.setText(" Features");
		container.add(featuresText);
		settingsText = new Text(control, SWT.NONE);
		settingsText.setText(" Settings");
		container.add(settingsText);
	}

	@Override
	public void clearErrorMessage() {

	}

	@Override
	public String getValue() {

		return "";
	}

	@Override
	public void setValue(String value) {
	}

	public void buildWidget(Composite composite, String label,
			Map<String, String> options) {

	}

	public void refresh(String currentValue) {

	}

	public void setInitialValue(String initialValue) {

	}

	@Override
	public void addListener(Listener listener) {
		super.addListener(listener);
		for (Control control : container) {
			control.addListener(SWT.MouseDown, listener);
		}
		container.get(container.indexOf(linkErrors)).addListener(SWT.MouseDown,
				new ShowView("com.nokia.tools.variant.views.errorsview"));
		container.get(container.indexOf(linkNotes)).addListener(SWT.MouseDown,
				new ShowView("com.nokia.tools.variant.views.notesview"));
		container.get(container.indexOf(linkChanges)).addListener(
				SWT.MouseDown,
				new ShowView("com.nokia.tools.variant.views.changesview"));
		container
				.get(container.indexOf(linkResources))
				.addListener(
						SWT.MouseDown,
						new ShowView(
								"com.nokia.tools.variant.resourcelibrary.views.ResourceLibraryView"));

	}

	@Override
	protected void drawDeselectUI() {
		super.drawDeselectUI();
		control.setBackground(group.getBackground());
		for (Control control : container) {
			control.setBackground(group.getBackground());
		}
	}

	@Override
	protected void drawSelectUI() {
		super.drawSelectUI();
		control.setBackground(group.getBackground());
		for (Control control : container) {
			control.setBackground(group.getBackground());
		}
	}

	private class ShowView implements Listener {

		private String showedView;

		public ShowView(String showedView) {
			this.showedView = showedView;
		}

		public void handleEvent(Event event) {

			if (showedView != null) {
				Display.getDefault().asyncExec(new Runnable() {
					public void run() {
						if (PlatformUI.getWorkbench()
								.getActiveWorkbenchWindow().getActivePage() != null) {
							try {
								PlatformUI.getWorkbench()
										.getActiveWorkbenchWindow()
										.getActivePage().showView(showedView);
							} catch (PartInitException e) {
								e.printStackTrace();
							}
						}
					}
				});
			}

		}
	}

	@Override
	protected GridData layoutDataForLabel(int width) {
		GridData gridData = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING
				| GridData.VERTICAL_ALIGN_BEGINNING);
		gridData.widthHint = width;
		return gridData;
	}

	@Override
	public void setOptions(WidgetOptions options) {
		if (options != null) {
			Object[] array = options.getOptions().toArray();
			if (array.length == 7) {
				WidgetOption errorString = (WidgetOption) array[0];
				linkErrors.setText(errorString.getValue());
				WidgetOption noteString = (WidgetOption) array[1];
				linkNotes.setText(noteString.getValue());
				WidgetOption defaultString = (WidgetOption) array[2];
				linkChanges.setText(defaultString.getValue());
				WidgetOption resourcesString = (WidgetOption) array[3];
				linkResources.setText(resourcesString.getValue());
				WidgetOption groupString = (WidgetOption) array[4];
				groupsText.setText(groupString.getValue());
				WidgetOption featureString = (WidgetOption) array[5];
				featuresText.setText(featureString.getValue());
				WidgetOption settingString = (WidgetOption) array[6];
				settingsText.setText(settingString.getValue());

			}
		}
	}
}
