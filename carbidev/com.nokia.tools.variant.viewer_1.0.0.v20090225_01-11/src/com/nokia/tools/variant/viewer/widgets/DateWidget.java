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

package com.nokia.tools.variant.viewer.widgets;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.eclipse.emf.ecore.xml.type.XMLTypeFactory;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.eclipse.emf.ecore.xml.type.internal.XMLCalendar;
import org.eclipse.nebula.widgets.cdatetime.CDT;
import org.eclipse.nebula.widgets.cdatetime.CDateTime;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.internal.win32.OS;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.nokia.tools.variant.viewer.images.PluginImages;
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

	public DateWidget(Composite parent, int style, String widgetLabel) {
		super(parent, style, widgetLabel);

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
		dateChooser = new CDateTime(group, CDT.BORDER | CDT.DROP_DOWN);
		dateChooser.setPattern("yyyy-MM-dd");
		GridData layoutData = new GridData();
		layoutData.widthHint = 83;
		dateChooser.setLayoutData(layoutData);
		dateChooser.setNullText("");

		timeZoneText = new Text(group, SWT.BORDER);
		layoutData = new GridData();
		layoutData.widthHint = 38;
		timeZoneText.setLayoutData(layoutData);
		timeZoneText.addVerifyListener(allowOnlyTimeZoneCharsListener);
	}

	@Override
	protected Layout buildContainerLayout() {
		int columnCount = (image == null) ? 7 : 8;
		if (options != null && options.size() > 0) {
			columnCount++;
		}
		GridLayout layout = new GridLayout(columnCount, false);
		return layout;
	}

	@Override
	public void clearErrorMessage() {

	}

	@Override
	public String getValue() {
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
		if (value != "") {
			try {
				XMLTypeFactory.eINSTANCE.createFromString(
						XMLTypePackage.Literals.DATE, value);
				tempValue = null;
			} catch (IllegalArgumentException iae) {
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
			} catch (IllegalArgumentException e) {
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
			control.addListener(SWT.MouseDown, listener);
		}
		addListener(SWT.Deactivate, new Listener(){

			
			public void handleEvent(Event event) {
				Shell activeShell = Display.getCurrent().getActiveShell();
			
				int getForegroundWindow = OS.GetForegroundWindow();
				if(activeShell.handle!=getForegroundWindow&&isSelected()){
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
		dateChooser.addListener(SWT.MouseDown, listener);
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

}
