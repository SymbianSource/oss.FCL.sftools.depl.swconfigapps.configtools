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
import java.util.Calendar;
import java.util.Date;

import org.eclipse.emf.ecore.xml.type.XMLTypeFactory;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.eclipse.nebula.widgets.cdatetime.CDT;
import org.eclipse.nebula.widgets.cdatetime.CDateTime;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

import com.nokia.tools.variant.viewer.images.PluginImages;

/**
 * Widget graphically represents date time setting.
 */
public class DateTimeWidget extends BaseConfMLWidget {

	private static final Color COLOR_WHITE = Display.getCurrent()
			.getSystemColor(SWT.COLOR_WHITE);

	protected Text timeZoneText;
	// protected Composite controls;
	protected Listener listener;

	private String tempValue;

	private CDateTime dateTimeChooser;

	public DateTimeWidget(Composite parent, int style, String widgetLabel) {
		super(parent, style, widgetLabel);

	}

	public DateTimeWidget(Composite parent, int style, String widgetLabel,
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
		group.setBackground(COLOR_WHITE);

		GridData layoutData = new GridData();

		dateTimeChooser = new CDateTime(group, CDT.BORDER | CDT.DROP_DOWN
				| CDT.DATE_SHORT | CDT.TIME_SHORT);
		dateTimeChooser.setPattern("yyyy-MM-dd HH:mm:ss.SSS");
		layoutData.widthHint = 153;
		dateTimeChooser.setLayoutData(layoutData);
		dateTimeChooser.setNullText("");

		timeZoneText = new Text(group, SWT.BORDER);
		layoutData = new GridData();
		layoutData.widthHint = 38;
		timeZoneText.setLayoutData(layoutData);
		timeZoneText.addVerifyListener(allowOnlyTimeZoneCharsListener);
	}

	@Override
	protected Layout buildContainerLayout() {
		int columnCount = (image == null) ? 13 : 14;
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
		String dateTimeText = dateTimeChooser.getText();
		if (dateTimeText.endsWith(".000")) {
			dateTimeText = dateTimeText.substring(0, dateTimeText.indexOf("."));
		}
		dateTimeText = dateTimeText.replace(" ", "T");
		if (dateTimeText != "" && dateTimeText != null) {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append(dateTimeText);
			if (timeZoneText != null && !timeZoneText.isDisposed()) {
				stringBuilder.append(timeZoneText.getText().trim());
			}
			String string = stringBuilder.toString();
			return string;
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
						XMLTypePackage.Literals.DATE_TIME, value);
				tempValue = null;
			} catch (IllegalArgumentException iae) {
				tempValue = value;
				if (value.endsWith("\"]")) {
					value = value.substring(0, value.length() - 2);
					value = value.substring(value.lastIndexOf('"') + 1, value
							.length());
				}
			}

			if (value.contains("T")) {
				String datePart = value.substring(0, value.indexOf("T"));
				int years = 0;
				int months = 0;
				int days = 0;

				int yearIndex = datePart.indexOf("-");
				if (yearIndex != -1) {
					years = Integer.valueOf(datePart.substring(0, yearIndex));
				}
				int monthIndex = datePart.indexOf("-", yearIndex + 1);
				if (monthIndex != -1) {
					months = Integer.valueOf(datePart.substring(yearIndex + 1,
							monthIndex));
				}
				days = Integer.valueOf(datePart.substring(monthIndex + 1));

				String timePart = value.substring(value.indexOf("T") + 1);
				int hoursIndex = timePart.indexOf(":");
				int hours = 0;
				if (hoursIndex != -1) {
					hours = Integer.valueOf(timePart.substring(0, hoursIndex));
				}
				int minutesIndex = timePart.indexOf(":", hoursIndex + 1);
				int minutes = 0;
				if (minutesIndex != -1) {
					minutes = Integer.valueOf(timePart.substring(
							hoursIndex + 1, minutesIndex));
				}
				String secsAndZone = timePart.substring(minutesIndex + 1);
				String seconds = "";
				int index = secsAndZone.indexOf("+");
				if (index == -1) {
					index = secsAndZone.indexOf("-");
				}
				if (index == -1) {
					index = secsAndZone.indexOf("Z");
				}

				if (index != -1) {
					seconds = secsAndZone.substring(0, index);
					timeZoneText.setText(secsAndZone.substring(index));
				}
				int ms = 0;
				int sec = 0;
				if (seconds != "") {
					if (seconds.contains(".")) {
						ms = Integer.valueOf(seconds.substring(seconds
								.indexOf(".") + 1));
						sec = Integer.valueOf(seconds.substring(0, seconds
								.indexOf(".")));
					} else {
						sec = Integer.valueOf(seconds);
					}
				}

				try {
					XMLTypeFactory.eINSTANCE.createFromString(
							XMLTypePackage.Literals.DATE_TIME, value);

					Calendar cal = Calendar.getInstance();
					cal.set(Calendar.YEAR, years);
					cal.set(Calendar.MONTH, months - 1);
					cal.set(Calendar.DAY_OF_MONTH, days);
					cal.set(Calendar.HOUR_OF_DAY, hours);
					cal.set(Calendar.MINUTE, minutes);
					cal.set(Calendar.SECOND, sec);
					cal.set(Calendar.MILLISECOND, ms);
					Date date = new Date(cal.getTimeInMillis());
					dateTimeChooser.setSelection(date);
				} catch (IllegalArgumentException e) {
				}
				tempValue = null;
			}
		} else {
			dateTimeChooser.setSelection(null);
			timeZoneText.setText("");
		}
	}

	protected void removeModifyListeners() {
		if (listener != null) {
			removeAllModifyListeners(dateTimeChooser);
			removeAllModifyListeners(timeZoneText);
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
			timeZoneText.addListener(SWT.Modify, listener);
			dateTimeChooser.addListener(SWT.Modify, listener);

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
		Control[] children = dateTimeChooser.getChildren();

		for (Control control : children) {
			control.addListener(SWT.MouseDown, listener);
		}
		addListener(SWT.Deactivate, new Listener() {

			public void handleEvent(Event event) {
				if (dateTimeChooser.isOpen() && !isSelected()) {
					dateTimeChooser.setOpen(false);
				}
			}
		});

		dateTimeChooser.addListener(SWT.FocusOut, new Listener() {

			public void handleEvent(Event event) {
				if (dateTimeChooser.isOpen() && !isSelected()) {
					dateTimeChooser.setOpen(false);
				}
			}
		});

		dateTimeChooser.addListener(SWT.Dispose, new Listener() {

			public void handleEvent(Event event) {
				if (dateTimeChooser.isOpen()) {
					Method focusMethod = getDisposePickerMethod();
					try {
						focusMethod.invoke(dateTimeChooser);
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

		timeZoneText.addListener(SWT.Modify, listener);
		timeZoneText.addListener(SWT.MouseDown, listener);
		dateTimeChooser.addListener(SWT.Modify, listener);
		dateTimeChooser.addListener(SWT.MouseDown, listener);
		group.addListener(SWT.MouseDown, listener);
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
		if (hasFocus(dateTimeChooser)) {
			return true;
		}

		return false;
	}

}
