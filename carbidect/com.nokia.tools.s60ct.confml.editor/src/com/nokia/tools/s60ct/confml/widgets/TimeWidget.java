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
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.eclipse.emf.ecore.xml.type.XMLTypeFactory;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.eclipse.nebula.widgets.cdatetime.CDT;
import org.eclipse.nebula.widgets.cdatetime.CDateTime;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

import com.nokia.tools.s60ct.confml.editor.PluginImages;

/**
 * Widget graphically represents time setting.
 */
public class TimeWidget extends BaseConfMLWidget {

	private static final Color COLOR_WHITE = Display.getCurrent()
			.getSystemColor(SWT.COLOR_WHITE);

	protected Listener listener;

	private Text timeZoneText;

	private String tempValue;

	private CDateTime timeChooser;
	
	private String keyValue="";

	public TimeWidget(Composite parent, int style, String widgetLabel,WidgetOptions options, Image image) {
		super(parent, style, widgetLabel,options,image);

	}

	public TimeWidget(Composite parent, int style, String widgetLabel,
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
		
		GridData layoutData = new GridData();

		timeChooser = new CDateTime(controls, CDT.BORDER | CDT.DROP_DOWN
				| CDT.CLOCK_12_HOUR | CDT.TIME_MEDIUM);
		timeChooser.setPattern("HH:mm:ss");
		layoutData.widthHint = 93;
		timeChooser.setLayoutData(layoutData);
		timeChooser.setNullText("");

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
		
		if(keyValue!=null&&keyValue.contains("[key="))
			return keyValue;
		
		if (tempValue != null) {
			return tempValue;
		}
		String timeText = timeChooser.getText();
		if (timeText==null){
			return "";
		}
		if (timeText.endsWith(".000")) {
			timeText = timeText.substring(0, timeText.indexOf("."));
		}
		if (timeText != "" && timeText != null) {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append(timeText);
			if (timeZoneText != null && !timeZoneText.isDisposed()) {
				stringBuilder.append(timeZoneText.getText().trim());
			}
			
			
			String value = stringBuilder.toString();
	
			return value;
		}
		return "";
	}

	@Override
	public void setValue(String value) {
		removeModifyListeners();
		//setValue2(value);
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
						XMLTypePackage.Literals.TIME, value);
				tempValue = null;
			} catch (Exception iae) {
				tempValue = value;
				if (value.endsWith("\"]")) {
					value = value.substring(0, value.length() - 2);
					value = value.substring(value.lastIndexOf('"') + 1, value
							.length());
				}
			}
			int hoursIndex = value.indexOf(":");
			int hours = 0;
			if (hoursIndex != -1) {
				hours = Integer.valueOf(value.substring(0, hoursIndex));
			}
			int minutesIndex = value.indexOf(":", hoursIndex + 1);
			int minutes = 0;
			if (minutesIndex != -1) {
				minutes = Integer.valueOf(value.substring(hoursIndex + 1,
						minutesIndex));
			}
			String secsAndZone = value.substring(minutesIndex + 1);
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
					ms = Integer.valueOf(seconds
							.substring(seconds.indexOf(".") + 1));
					sec = Integer.valueOf(seconds.substring(0, seconds
							.indexOf(".")));
				} else {
					sec = Integer.valueOf(seconds);
				}
			}
			if (value != null && !"".equals(value)) {
				try {
					XMLTypeFactory.eINSTANCE.createFromString(
							XMLTypePackage.Literals.TIME, value);

					Calendar cal = Calendar.getInstance();
					cal.set(Calendar.HOUR_OF_DAY, hours);
					cal.set(Calendar.MINUTE, minutes);
					cal.set(Calendar.SECOND, sec);
					cal.set(Calendar.MILLISECOND, ms);
					Date date = new Date(cal.getTimeInMillis());
					
					timeChooser.setSelection(date);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				}
			}
			tempValue = null;
		} else {
			timeChooser.setSelection(null);
			timeZoneText.setText("");
		}

	}

	protected void removeModifyListeners() {
		if (listener != null) {
			removeAllModifyListeners(timeChooser);
			removeAllModifyListeners(timeZoneText);
		}
	}

	private void removeAllModifyListeners(Control text) {
		Listener[] listeners = text.getListeners(SWT.Modify);
		for (Listener listener : listeners) {
			text.removeListener(SWT.Modify, listener);
		}
	}

	protected void addModifyListeners() {
		if (listener != null) {
			timeChooser.addListener(SWT.Modify, listener);
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
		Control[] children = timeChooser.getChildren();

		for (Control control : children) {
			//control.addListener(SWT.MouseDown, listener);
			control.addListener(SWT.KeyDown, new Listener(){

				public void handleEvent(Event event) {

					if (event.character == SWT.DEL)
						return;

					if (timeChooser != null) {
						Date date = timeChooser.getSelection();
						if (date == null) {
							date = new Date(System.currentTimeMillis());
							timeChooser.setSelection(date);
						}

					}
				}
			});
		}

		timeChooser.addListener(SWT.FocusOut, new Listener() {

			public void handleEvent(Event event) {
				if (timeChooser.isOpen() && !isSelected()) {
					timeChooser.setOpen(false);
				}
			}
		});

		timeChooser.addListener(SWT.Dispose, new Listener() {

			public void handleEvent(Event event) {
				if (timeChooser.isOpen()) {
					Method focusMethod = getDisposePickerMethod();
					try {
						focusMethod.invoke(timeChooser);
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
		//timeZoneText.addListener(SWT.MouseDown, listener);
		timeChooser.addListener(SWT.Modify, listener);
		timeChooser.addListener(SWT.MouseDown, listener);
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

		if (hasFocus(timeChooser)) {
			return true;
		}
		if (hasFocus(timeZoneText)) {
			return true;
		}

		return false;
	}

	@Override
	public void setGrayed(boolean grayed) {
		
		timeChooser.setEnabled(!grayed);
		timeZoneText.setEnabled(!grayed);
		
		if (grayed)
		{
			timeChooser.setForeground(timeChooser.getDisplay().getSystemColor(SWT.COLOR_GRAY));
			timeZoneText.setForeground(timeZoneText.getDisplay().getSystemColor(SWT.COLOR_GRAY));
			label.setForeground(label.getDisplay().getSystemColor(SWT.COLOR_GRAY));
		}
		else
		{
			timeChooser.setForeground(timeChooser.getDisplay().getSystemColor(SWT.COLOR_BLACK));
			timeZoneText.setForeground(timeZoneText.getDisplay().getSystemColor(SWT.COLOR_BLACK));
			label.setForeground(label.getDisplay().getSystemColor(SWT.COLOR_BLACK));
		}
		setOptionsEnabled(!grayed);
	}

	public void buildWidget(Composite composite, String label,
			Map<String, String> options) {
		
	}

//	@Override
//	protected void disableEditing() {
//		if(timeChooser!=null&&!timeChooser.isDisposed()&&timeZoneText!=null&&!timeZoneText.isDisposed()){
//			timeChooser.setEnabled(false);
//			timeZoneText.setEditable(false);
//		}
//		
//	}
//
//	@Override
//	protected void enableEditing() {
//		if(timeChooser!=null&&!timeChooser.isDisposed()&&timeZoneText!=null&&!timeZoneText.isDisposed()){
//			timeChooser.setEnabled(true);
//			timeZoneText.setEditable(true);
//		}
//		
//	}

}
