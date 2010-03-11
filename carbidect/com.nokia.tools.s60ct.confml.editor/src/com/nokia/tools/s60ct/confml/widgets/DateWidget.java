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

package com.nokia.tools.s60ct.confml.widgets;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Map;

import org.eclipse.emf.ecore.xml.type.XMLTypeFactory;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.eclipse.emf.ecore.xml.type.internal.XMLCalendar;
import org.eclipse.nebula.widgets.cdatetime.CDT;
import org.eclipse.nebula.widgets.cdatetime.CDateTime;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.internal.win32.OS;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.nokia.tools.s60ct.confml.editor.PluginImages;


/**
 * Widget graphically represents date setting.
 */
@SuppressWarnings("restriction")
public class DateWidget extends BaseConfMLWidget {

	private static final Color COLOR_WHITE = Display.getCurrent()
			.getSystemColor(SWT.COLOR_WHITE);
	protected Text timeZoneText;
	protected CDateTime dateChooser;
	protected Listener listener;
	private String tempValue;
	private String keyValue = "";

	public DateWidget(Composite parent, int style, String widgetLabel,WidgetOptions options, Image image) {
		super(parent, style, widgetLabel,options,image);

	}

	public DateWidget(Composite parent, int style, String widgetLabel,
			WidgetOptions options) {
		super(parent, style, widgetLabel, options);
	}

	@Override
	protected void buildMainControl() {

		VerifyListener allowOnlyTimeZoneCharsListener = new VerifyListener() {

			public void verifyText(VerifyEvent e) {
				char character = e.character;
				String s = character + "";
				if (s.equals(" ")) {
					e.doit = false;
					return;
				}
				if (s.trim().equals("") || s.trim().equals("")) {
					return;
				} else if (e.widget instanceof Text) {
					String text = ((Text) e.widget).getText();
					String newText = text.substring(0, e.end) + s
							+ text.substring(e.end);
					if (!newText.startsWith("Z") && !newText.startsWith("+")
							&& !newText.startsWith("-")) {
						e.doit = false;
						return;
					}
					if (text.contains("Z")) {
						e.doit = false;
						return;
					}
					if (s.trim().equals(":")) {
						if (!text.contains(":") && !text.contains("Z")) {
							return;
						} else {
							e.doit = false;
							return;
						}
					} else if (s.trim().equals("-")) {
						if (!text.contains("-") && !text.contains("Z")
								&& !text.contains("+")) {
							return;
						} else {
							e.doit = false;
							return;
						}
					} else if (s.trim().equals("Z")) {
						if (!text.contains("Z") && !text.contains("-")
								&& !text.contains("+") && !text.contains(":")) {
							return;
						} else {
							e.doit = false;
							return;
						}
					} else if (s.trim().equals("+")) {
						if (!text.contains("+") && !text.contains("Z")
								&& !text.contains("-")) {
							return;
						} else {
							e.doit = false;
							return;
						}
					} else {
						String[] split = newText.split("\\D");
						for (String string : split) {
							if (string.length() > 2) {
								e.doit = false;
								return;
							}
						}
					}
				}
				try {
					Integer.valueOf(character + "");
				} catch (NumberFormatException ex) {
					e.doit = false;
				}
			}
		};
		Composite controls = new Composite(group, SWT.NONE);
		controls.setBackground(new Color(group.getDisplay(), 255, 255, 255));
		
		GridLayout gridLayout = new GridLayout(3, false);
		gridLayout.horizontalSpacing = 0;
		gridLayout.verticalSpacing = 0;
		gridLayout.marginHeight = 0;
		gridLayout.marginWidth = 0;
		gridLayout.marginBottom = 0;
		gridLayout.marginTop = 0;
		gridLayout.marginRight = 0;
		controls.setLayout(gridLayout);
		controls.setLayoutData(layoutDataForGroup());
		
		dateChooser = new CDateTime(controls, CDT.BORDER | CDT.DROP_DOWN);
		dateChooser.setPattern("yyyy-MM-dd");
		GridData layoutData = new GridData();
		layoutData.widthHint = 83;
		dateChooser.setLayoutData(layoutData);
		dateChooser.setNullText("");

		timeZoneText = new Text(controls, SWT.BORDER);
		layoutData = new GridData();
		layoutData.widthHint = 38;
		timeZoneText.setLayoutData(layoutData);
		timeZoneText.addVerifyListener(allowOnlyTimeZoneCharsListener);
		buildOptions(controls);
	}

//	@Override
//	protected Layout buildContainerLayout() {
//		int columnCount = (image == null) ? 7 : 8;
//		if (options != null && options.size() > 0) {
//			columnCount++;
//		}
//		GridLayout layout = new GridLayout(columnCount, false);
//		return layout;
//	}

	@Override
	public void clearErrorMessage() {

	}

	@Override
	public String getValue() {
		if (keyValue != null && keyValue.contains("[key="))
			return keyValue;

		if (tempValue != null) {
			return tempValue;
		}
		String dateText = dateChooser.getText();

		if (dateText != "" && dateText != null) {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append(dateText);
			if (timeZoneText != null && !timeZoneText.isDisposed()) {
				stringBuilder.append(timeZoneText.getText().trim());
			}
			return stringBuilder.toString();
		}
		return "";
	}

	@Override
	public void setValue(String value) {
		removeModifyListeners();
		internalSetValue(value);
		notifyListener();
		addModifyListeners();
		setGrayed(!isEditable());
	}

	private void notifyListener() {
		if (listener != null) {
			Event event = new Event();
			event.type = SWT.Modify;
			listener.handleEvent(event);
		}
	}

	protected void internalSetValue(String value) {
		if (value == null) {
			value = "";
		}
		keyValue = value;

		if (value != "") {
			try {
				XMLTypeFactory.eINSTANCE.createFromString(
						XMLTypePackage.Literals.DATE, value);
				tempValue = null;
			} catch (Exception iae) {
				tempValue = value;
				if (value.endsWith("\"]")) {
					value = value.substring(0, value.length() - 2);
					value = value.substring(value.lastIndexOf('"') + 1, value
							.length());
				}
			}

			try {
				XMLTypeFactory.eINSTANCE.createFromString(
						XMLTypePackage.Literals.DATE, value);

				XMLCalendar calend = new XMLCalendar(value, XMLCalendar.DATE);
				dateChooser.setSelection(calend.getDate());
			} catch (Exception e) {
			}

			int yearIndex = value.indexOf("-");
			int monthIndex = value.indexOf("-", yearIndex + 1);
			String daysAndZone = value.substring(monthIndex + 1);
			int index = daysAndZone.indexOf("+");
			if (index == -1) {
				index = daysAndZone.indexOf("-");
			}
			if (index == -1) {
				index = daysAndZone.indexOf("Z");
			}
			if (index != -1) {
				timeZoneText.setText(daysAndZone.substring(index));
			}
			tempValue = null;
		} else {
			dateChooser.setSelection(null);
			timeZoneText.setText("");
		}
	}

	protected void removeModifyListeners() {
		if (listener != null) {
			removeAllModifyListeners(timeZoneText);
			removeAllModifyListeners(dateChooser);
		}
	}

	private void removeAllModifyListeners(Control control) {
		Listener[] listeners = control.getListeners(SWT.Modify);
		for (Listener listener : listeners) {
			control.removeListener(SWT.Modify, listener);
		}
	}

	protected void addModifyListeners() {
		if (listener != null) {
			dateChooser.addListener(SWT.Modify, listener);
			timeZoneText.addListener(SWT.Modify, listener);
		}
	}

	@Override
	protected void drawSelectUI() {
		Color selectionColor = PluginImages.BACKGROUND_COLOR;
		group.setBackground(selectionColor);
		super.drawSelectUI();
	}

	@Override
	protected void drawDeselectUI() {
		group.setBackground(COLOR_WHITE);
		super.drawDeselectUI();
	}

	@Override
	public void addListener(Listener listener) {
		Control[] children = dateChooser.getChildren();

		for (Control control : children) {
			//control.addListener(SWT.MouseDown, listener);

			control.addListener(SWT.KeyDown, new Listener() {

				public void handleEvent(Event event) {

					if (event.character == SWT.DEL)
						return;

					if (dateChooser != null) {
						Date date = dateChooser.getSelection();
						if (date == null) {
							date = new Date(System.currentTimeMillis());
							dateChooser.setSelection(date);
						}

					}
				}
			});
		}
		addListener(SWT.Deactivate, new Listener() {

			public void handleEvent(Event event) {
				Shell activeShell = Display.getCurrent().getActiveShell();

				int getForegroundWindow = OS.GetForegroundWindow();
				if (activeShell.handle != getForegroundWindow && isSelected()) {
					dateChooser.setOpen(false);
				}

			}

		});
		dateChooser.addListener(SWT.FocusOut, new Listener() {

			public void handleEvent(Event event) {
				if (dateChooser.isOpen() && !isSelected()) {
					dateChooser.setOpen(false);
				}
			}
		});

		dateChooser.addListener(SWT.Dispose, new Listener() {

			public void handleEvent(Event event) {
				if (dateChooser.isOpen()) {
					Method focusMethod = getDisposePickerMethod();
					try {
						focusMethod.invoke(dateChooser);
					} catch (IllegalArgumentException e) {

						e.printStackTrace();
					} catch (IllegalAccessException e) {

						e.printStackTrace();
					} catch (InvocationTargetException e) {

						e.printStackTrace();
					}
				}
			}
		});

		dateChooser.addListener(SWT.Modify, listener);
		//dateChooser.addListener(SWT.MouseDown, listener);
		timeZoneText.addListener(SWT.Modify, listener);
		timeZoneText.addListener(SWT.MouseDown, listener);
		this.listener = listener;
		super.addListener(listener);
	}

	private Method getDisposePickerMethod() {
		Method declaredMethod = null;
		try {
			declaredMethod = CDateTime.class.getDeclaredMethod("disposePicker");
		} catch (SecurityException e) {

			e.printStackTrace();
		} catch (NoSuchMethodException e) {

			e.printStackTrace();
		}
		declaredMethod.setAccessible(true);
		return declaredMethod;

	}

	@Override
	public boolean setFocus() {
		if (timeZoneText.isDisposed()) {
			return false;
		}
		boolean checkFocus = checkFocus();
		if (checkFocus) {
			return true;
		}
		return super.setFocus();

	}

	protected boolean checkFocus() {
		if (hasFocus(timeZoneText)) {
			return true;
		}
		if (hasFocus(dateChooser)) {
			return true;
		}
		return false;
	}

	@Override
	public void setGrayed(boolean grayed) {
		dateChooser.setEnabled(!grayed);
		timeZoneText.setEnabled(!grayed);
		
		if (grayed)
		{
			dateChooser.setForeground(dateChooser.getDisplay().getSystemColor(SWT.COLOR_GRAY));
			timeZoneText.setForeground(timeZoneText.getDisplay().getSystemColor(SWT.COLOR_GRAY));
			label.setForeground(label.getDisplay().getSystemColor(SWT.COLOR_GRAY));
		}
		else
		{
			dateChooser.setForeground(dateChooser.getDisplay().getSystemColor(SWT.COLOR_BLACK));
			timeZoneText.setForeground(timeZoneText.getDisplay().getSystemColor(SWT.COLOR_BLACK));
			label.setForeground(label.getDisplay().getSystemColor(SWT.COLOR_BLACK));
		}
		setOptionsEnabled(!grayed);
	}

	public void buildWidget(Composite composite, String label,
			Map<String, String> options) {
		// Auto-generated method stub
		
	}

//	@Override
//	protected void disableEditing() {
//		if (dateChooser != null && !dateChooser.isDisposed()
//				&& timeZoneText != null && !timeZoneText.isDisposed()) {
//			dateChooser.setEnabled(false);
//
//			timeZoneText.setEditable(false);
//		}
//
//	}
//
//	@Override
//	protected void enableEditing() {
//		if (dateChooser != null && !dateChooser.isDisposed()
//				&& timeZoneText != null && !timeZoneText.isDisposed()) {
//			dateChooser.setEnabled(true);
//
//			timeZoneText.setEditable(true);
//		}
//
//	}

}
