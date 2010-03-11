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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.datatype.DatatypeConstants;

import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.xml.type.XMLTypeFactory;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.eclipse.emf.ecore.xml.type.internal.XMLDuration;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

import com.nokia.tools.variant.viewer.images.PluginImages;
/**
 * Widget graphically represents duration setting.
 */
public class DurationWidget extends BaseConfMLWidget {

	private static final Color COLOR_WHITE = Display.getCurrent()
			.getSystemColor(SWT.COLOR_WHITE);
	protected Text yearText;
	protected Label firstSeparationLabel;
	protected Text monthText;
	protected Label secondSeparationLabel;
	protected Text dayText;

	protected Listener listener;
	private Label thirdSeparationLabel;
	private Text hourText;
	private Label fourthSeparationLabel;
	private Text minuteText;
	private Label fifthSeparationLabel;
	private Text secondText;
	private Label sixthSeparationLabel;
	private String tempValue;

	public DurationWidget(Composite parent, int style, String widgetLabel) {
		super(parent, style, widgetLabel);

	}

	public DurationWidget(Composite parent, int style, String widgetLabel,
			WidgetOptions options) {
		super(parent, style, widgetLabel, options);
	}

	@Override
	protected void buildMainControl() {
		VerifyListener allowOnlyNumbersListener = new VerifyListener() {

			public void verifyText(VerifyEvent e) {
				char character = e.character;
				String s = character + "";
				if (s.equals(" ")) {
					e.doit = false;
					return;
				}
				if (s.trim().equals("") || s.trim().equals("")) {
					return;
				}
				try {
					Integer.valueOf(character + "");
				} catch (NumberFormatException ex) {
					e.doit = false;
				}
			}
		};

		VerifyListener allowOnlyRealNumbersListener = new VerifyListener() {

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
					int indexOfPoint = newText.indexOf(".");
					int lengthOfDecimals = 0;
					if (indexOfPoint != -1) {
						lengthOfDecimals = newText.substring(indexOfPoint + 1)
								.length();
						if (e.end > indexOfPoint && lengthOfDecimals > 3) {
							e.doit = false;
							return;
						}
					}
					if (s.trim().equals(".")) {
						if (!text.contains(".")) {
							return;
						} else {
							e.doit = false;
							return;
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

		yearText = new Text(group, SWT.BORDER);
		yearText.addVerifyListener(allowOnlyNumbersListener);

		GridData layoutData = new GridData();
		layoutData.widthHint = 25;
		yearText.setLayoutData(layoutData);
		firstSeparationLabel = new Label(group, SWT.NONE);
		firstSeparationLabel.setText("Y");
		firstSeparationLabel.setBackground(COLOR_WHITE);
		monthText = new Text(group, SWT.BORDER);
		monthText.addVerifyListener(allowOnlyNumbersListener);
		layoutData = new GridData();
		layoutData.widthHint = 25;
		monthText.setLayoutData(layoutData);
		secondSeparationLabel = new Label(group, SWT.NONE);
		secondSeparationLabel.setText("M");
		secondSeparationLabel.setBackground(COLOR_WHITE);
		dayText = new Text(group, SWT.BORDER);
		dayText.addVerifyListener(allowOnlyNumbersListener);
		layoutData = new GridData();
		layoutData.widthHint = 25;
		dayText.setLayoutData(layoutData);
		thirdSeparationLabel = new Label(group, SWT.NONE);
		thirdSeparationLabel.setText("D");
		thirdSeparationLabel.setBackground(COLOR_WHITE);
		hourText = new Text(group, SWT.BORDER);
		layoutData = new GridData();
		layoutData.widthHint = 25;
		hourText.setLayoutData(layoutData);
		hourText.addVerifyListener(allowOnlyNumbersListener);
		fourthSeparationLabel = new Label(group, SWT.NONE);
		fourthSeparationLabel.setText("H");
		fourthSeparationLabel.setBackground(COLOR_WHITE);
		minuteText = new Text(group, SWT.BORDER);
		minuteText.addVerifyListener(allowOnlyNumbersListener);
		layoutData = new GridData();
		layoutData.widthHint = 25;
		minuteText.setLayoutData(layoutData);
		fifthSeparationLabel = new Label(group, SWT.NONE);
		fifthSeparationLabel.setText("Min");
		fifthSeparationLabel.setBackground(COLOR_WHITE);
		secondText = new Text(group, SWT.BORDER);
		layoutData = new GridData();
		layoutData.widthHint = 27;
		secondText.setLayoutData(layoutData);
		secondText.addVerifyListener(allowOnlyRealNumbersListener);
		sixthSeparationLabel = new Label(group, SWT.NONE);
		sixthSeparationLabel.setText("Sec");
		sixthSeparationLabel.setBackground(COLOR_WHITE);

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
		if (yearText != null && !yearText.isDisposed()) {
			StringBuilder stringBuilder = new StringBuilder();
			String numberOfYears = yearText.getText().trim();
			if (!numberOfYears.equals("")) {
				stringBuilder.append(numberOfYears);
				stringBuilder.append("Y");
			}
			String numberOfMonths = monthText.getText().trim();
			if (!numberOfMonths.equals("")) {
				stringBuilder.append(numberOfMonths);
				stringBuilder.append("M");
			}

			String numberOfDays = dayText.getText().trim();
			if (!numberOfDays.equals("")) {
				stringBuilder.append(numberOfDays);
				stringBuilder.append("D");
			}
			String numberOfHours = hourText.getText().trim();
			if (!numberOfHours.equals("")) {
				stringBuilder.append("T");
				stringBuilder.append(numberOfHours);
				stringBuilder.append("H");
			}
			String numberOfMinutes = minuteText.getText().trim();
			if (!numberOfMinutes.equals("")) {
				if (numberOfHours.equals("")) {
					stringBuilder.append("T");
				}
				stringBuilder.append(numberOfMinutes);
				stringBuilder.append("M");
			}
			String numberOfSeconds = secondText.getText().trim();
			if (!numberOfSeconds.equals("")) {
				if (numberOfHours.equals("") && numberOfMinutes.equals("")) {
					stringBuilder.append("T");
				}
				stringBuilder.append(numberOfSeconds);
				stringBuilder.append("S");
			}
			if (!stringBuilder.toString().equals("")) {
				return "P".concat(stringBuilder.toString());
			} else {
				return stringBuilder.toString();
			}
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
						XMLTypePackage.Literals.DURATION, value);
				tempValue = null;
			} catch (IllegalArgumentException iae) {
				tempValue = value;
				if (value.endsWith("\"]")) {
					value = value.substring(0, value.length() - 2);
					value = value.substring(value.lastIndexOf('"') + 1, value
							.length());
				}
			}
		}
		yearText.setText("");
		monthText.setText("");
		dayText.setText("");
		hourText.setText("");
		minuteText.setText("");
		secondText.setText("");
		try {
			XMLDuration d = new XMLDuration(value);
			Number yearField = d.getField(DatatypeConstants.YEARS);
			if (yearField != null) {
				int years = d.getYears();

				yearText.setText((years + "").trim());
			}
			Number monthField = d.getField(DatatypeConstants.MONTHS);
			if (monthField != null) {
				int months = d.getMonths();
				monthText.setText((months + "").trim());
			}
			Number dayField = d.getField(DatatypeConstants.DAYS);
			if (dayField != null) {
				int days = d.getDays();
				dayText.setText((days + "").trim());
			}
			Number hourField = d.getField(DatatypeConstants.HOURS);
			if (hourField != null) {
				int hours = d.getHours();
				hourText.setText((hours + "").trim());
			}
			Number minuteField = d.getField(DatatypeConstants.MINUTES);
			if (minuteField != null) {
				int minutes = d.getMinutes();
				minuteText.setText((minutes + "").trim());
			}
			Number secondField = d.getField(DatatypeConstants.SECONDS);
			if (secondField != null) {
				double seconds = secondField.doubleValue();

				String secondsString = seconds + "";
				if (secondsString.endsWith(".0")) {
					secondText.setText(secondField.intValue() + "");
				} else if (value.endsWith(".")) {
					secondText.setText(secondsString.trim() + ".");
				} else {
					secondText.setText(secondsString.trim());
				}
			}
		} catch (IllegalArgumentException x) {

			String replaceAll = value.replaceAll("P", "");
			replaceAll = replaceAll.replaceAll("Y", "//");
			replaceAll = replaceAll.replaceAll("M", "//");
			replaceAll = replaceAll.replaceAll("DT", "//");
			replaceAll = replaceAll.replaceAll("D", "//");
			replaceAll = replaceAll.replaceAll("T", "//");
			replaceAll = replaceAll.replaceAll("H", "//");
			replaceAll = replaceAll.replaceAll("S", "");
			replaceAll = replaceAll.replaceAll("////", "//" + " " + "//");

			replaceAll = replaceAll.replaceAll("////", "//" + " " + "//");
			Path p = new Path(replaceAll);
			List<String> segments = Arrays.asList(p.segments());
			if (value.startsWith("-")) {
				List<String> l = new ArrayList<String>();
				l.addAll(segments);
				l.add(0, "");
				segments = l;

			}
			yearText.setText("");
			monthText.setText("");
			dayText.setText("");
			hourText.setText("");
			minuteText.setText("");
			secondText.setText("");
			for (int i = 0; i < segments.size(); i++) {
				if (i == 0) {
					yearText.setText(segments.get(i).trim());
				}
				if (i == 1) {
					monthText.setText(segments.get(i).trim());
				}
				if (i == 2) {
					dayText.setText(segments.get(i).trim());

				}
				if (i == 3) {
					hourText.setText(segments.get(i).trim());
				}
				if (i == 4) {
					minuteText.setText(segments.get(i).trim());
				}
				if (i == 5) {
					secondText.setText(segments.get(i).trim());

				}
			}
		}
		tempValue = null;
	}

	protected void removeModifyListeners() {
		if (listener != null) {
			removeAllModifyListeners(yearText);
			removeAllModifyListeners(dayText);
			removeAllModifyListeners(monthText);

			removeAllModifyListeners(hourText);
			removeAllModifyListeners(minuteText);
			removeAllModifyListeners(secondText);
		}
	}

	private void removeAllModifyListeners(Text text) {
		Listener[] listeners = text.getListeners(SWT.Modify);
		for (Listener listener : listeners) {
			text.removeListener(SWT.Modify, listener);
		}
	}

	protected void addModifyListeners() {
		if (listener != null) {
			yearText.addListener(SWT.Modify, listener);
			dayText.addListener(SWT.Modify, listener);
			monthText.addListener(SWT.Modify, listener);

			hourText.addListener(SWT.Modify, listener);
			minuteText.addListener(SWT.Modify, listener);
			secondText.addListener(SWT.Modify, listener);
		}
	}

	@Override
	protected void drawSelectUI() {
		Color selectionColor = PluginImages.BACKGROUND_COLOR;
		group.setBackground(selectionColor);
		secondSeparationLabel.setBackground(selectionColor);
		firstSeparationLabel.setBackground(selectionColor);
		thirdSeparationLabel.setBackground(selectionColor);
		fourthSeparationLabel.setBackground(selectionColor);
		fifthSeparationLabel.setBackground(selectionColor);
		sixthSeparationLabel.setBackground(selectionColor);
		super.drawSelectUI();
	}

	@Override
	protected void drawDeselectUI() {
		group.setBackground(COLOR_WHITE);
		secondSeparationLabel.setBackground(COLOR_WHITE);
		firstSeparationLabel.setBackground(COLOR_WHITE);
		thirdSeparationLabel.setBackground(COLOR_WHITE);
		fourthSeparationLabel.setBackground(COLOR_WHITE);
		fifthSeparationLabel.setBackground(COLOR_WHITE);
		sixthSeparationLabel.setBackground(COLOR_WHITE);
		super.drawDeselectUI();
	}

	@Override
	public void addListener(Listener listener) {
		yearText.addListener(SWT.Modify, listener);
		dayText.addListener(SWT.Modify, listener);
		monthText.addListener(SWT.Modify, listener);

		hourText.addListener(SWT.Modify, listener);
		minuteText.addListener(SWT.Modify, listener);
		secondText.addListener(SWT.Modify, listener);
		yearText.addListener(SWT.MouseDown, listener);
		dayText.addListener(SWT.MouseDown, listener);
		monthText.addListener(SWT.MouseDown, listener);

		hourText.addListener(SWT.MouseDown, listener);
		minuteText.addListener(SWT.MouseDown, listener);
		secondText.addListener(SWT.MouseDown, listener);
		firstSeparationLabel.addListener(SWT.MouseDown, listener);
		secondSeparationLabel.addListener(SWT.MouseDown, listener);
		thirdSeparationLabel.addListener(SWT.MouseDown, listener);
		fourthSeparationLabel.addListener(SWT.MouseDown, listener);
		fifthSeparationLabel.addListener(SWT.MouseDown, listener);
		sixthSeparationLabel.addListener(SWT.MouseDown, listener);
		group.addListener(SWT.MouseDown, listener);
		this.listener = listener;
		super.addListener(listener);
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

		if (hasFocus(yearText)) {
			return true;
		}
		if (hasFocus(dayText)) {
			return true;
		}
		if (hasFocus(monthText)) {
			return true;
		}
		if (hasFocus(hourText)) {
			return true;
		}
		if (hasFocus(minuteText)) {
			return true;
		}
		if (hasFocus(secondText)) {
			return true;
		}

		return false;
	}

}
