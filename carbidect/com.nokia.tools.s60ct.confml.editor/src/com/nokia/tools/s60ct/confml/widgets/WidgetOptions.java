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

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.emf.ecore.xml.type.internal.XMLCalendar;
import org.eclipse.emf.ecore.xml.type.internal.XMLDuration;

import com.nokia.tools.s60ct.model.confml.ESettingValueType;
/**
 * Class serves for storing setting options in UI model. 
 */
public class WidgetOptions {

//	public enum SettingType {
//		INT, STRING, REAL, SELECTION, BOOLEAN, FILE, FOLDER, SEQUENCE, DATE_TIME, DATE, TIME, DURATION, MULTISELECTION, SIMPLE_FILE, SIMPLE_FOLDER,
//	};

//	private Map<String, WidgetOption> map = new LinkedHashMap<String, WidgetOption>();
	private Set<WidgetOption> options;
	
	public WidgetOptions(Set<WidgetOption> options, ESettingValueType type) {
		WidgetOption[] array = options
				.toArray(new WidgetOption[options.size()]);

		Arrays.sort(array, new WidgetOptionComparator(type));
		this.options = new LinkedHashSet<WidgetOption>();
		for (WidgetOption option : array) {
//			map.put(option.getKey(), option);
			this.options.add(option);
		}
	}

	public WidgetOptions(Set<WidgetOption> options) {
		this.setOptions(options);
	}

//	public String getValue(String key) {
//		return map.get(key).getValue();
//	}

//	public String getRelevant(String key) {
//		return map.get(key).getRelevant();
//	}

	public int size() {
		return options.size();
	}

//	public Collection<WidgetOption> values() {
//		return map.values();
//	}

//	public void setMap(Map<String, WidgetOption> map) {
//		this.map = map;
//	}
//
//	public Map<String, WidgetOption> getMap() {
//		return map;
//	}

	public void setOptions(Set<WidgetOption> options) {
		this.options = options;
	}

	public Set<WidgetOption> getOptions() {
		return options;
	}

	private class WidgetOptionComparator implements Comparator<WidgetOption> {

		private ESettingValueType type;

		public WidgetOptionComparator(ESettingValueType type) {
			this.type = type;
		}

		public int compare(WidgetOption o1, WidgetOption o2) {
			String value1 = o1.getMapValue() == null ? o1.getValue() : o1.getKey();
			String value2 = o2.getMapValue() == null ? o2.getValue() : o2.getKey();
			try {
				if (type == null || type == ESettingValueType.STRING) {
					return value1.compareTo(value2);
				} else if (type == ESettingValueType.DATE
						|| type == ESettingValueType.DATETIME) {
					XMLCalendar d1 = new XMLCalendar(value1,
							XMLCalendar.DATETIME);
					XMLCalendar d2 = new XMLCalendar(value1,
							XMLCalendar.DATETIME);
					return d1.compare(d2);
				} else if (type == ESettingValueType.DURATION) {
					XMLDuration d1 = fillNullValues(value1);
					XMLDuration d2 = fillNullValues(value2);
					return d1.compare(d2);
				} else if (type == ESettingValueType.INTEGER) {
					Integer i1 = Integer.valueOf(value1);
					Integer i2 = Integer.valueOf(value2);
					return i1.compareTo(i2);
				} else if (type == ESettingValueType.DECIMAL) {
					Double d1 = new Double(Double.parseDouble(value1));
					Double d2 = new Double(Double.parseDouble(value2));
					return d1.compareTo(d2);
				}
			} catch (NumberFormatException nfe) {
				// do nothing
			} catch (IllegalArgumentException iae) {
				// do nothing
			}
			return value1.compareTo(value2);
		}

		/**
		 * Method prevents <CODE>NullPointerexception</CODE>
		 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=259794
		 * @param duration
		 * @return
		 * @throws IllegalArgumentException
		 */
		private XMLDuration fillNullValues(String duration)
				throws IllegalArgumentException {
			XMLDuration zeroDuration = new XMLDuration("P0Y0M0DT0H0M0S");
			XMLDuration d = new XMLDuration(duration);
			return new XMLDuration(d.add(zeroDuration).toString());
		}

	}

}
