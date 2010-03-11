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
 * Description: This file is part of com.nokia.tools.variant.content.confml.model component.
 */

package com.nokia.tools.variant.content.confml.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.nokia.tools.variant.content.confml.Option;

/**
 * Utility for working with MultiSelection data type
 * 
 */
public class SettingValueUtils {
	
	/**
	 * Sorts <code>multiSelectionValue</code> 's values to achieve same order between equals sets.
	 * Example value1="A" "B" C value2=C B "A" 
	 * 
	 * Result multiselections value1 & value2 are equal.
	 * @param multiSelectionValue is value to order
	 * @return ordered value of multi selection
	 */
	public static String sortMultiSelectionValue(String multiSelectionValue) {
		
		List<String> values = parseMultiSelectionValues(multiSelectionValue);
		
		
		return createMultiSelectionValue(values);
	}

	/**
	 * 
	 * @param values list of option values
	 * @return multiselection value combined from values list
	 * 
	 * example:
	 * List<String> = [A,X,Z]
	 * 
	 * retuns "A" "X" "Z"
	 * 
	 */
	public static String createMultiSelectionValue(List<String> values) {
		Collections.sort(values);
		StringBuilder sb = new StringBuilder();
		for (int i = 0 ; i < values.size() ; i++) {
			if (i > 0) {
				sb.append(' ');
			}
			
			sb.append("\"" + values.get(i) + "\"");
		}
		
		return sb.toString();
	}

	/**
	 * 
	 * @param multiSelectionValue value containing checked options of multiselection setting
	 * @return e.g. list of strings "A" "B" "C" from String "A" "B" "C" 
	 */
	public static List<String> parseMultiSelectionValues(String multiSelectionValue) {
		if (multiSelectionValue == null) {
			return new ArrayList<String>();
		}
		
		// boolean quoted value
		boolean isCurrentValueQuoted = false;
		boolean valueProcessingBegan = false;
		
		StringBuilder sb = new StringBuilder();
		List<String> values = new ArrayList<String>();
		
		for (int i = 0 ; i <= multiSelectionValue.length() ; i++) {
			if (i == multiSelectionValue.length()) {
				if (sb.length() > 0) {
					values.add(sb.toString());
				}
				break;
			}
			char c = multiSelectionValue.charAt(i);

			if (!valueProcessingBegan) {
				if (c == ' ') {// skip spaces between values
					continue;
				}
			}
			
			if (!valueProcessingBegan) {
				if (c == '"') {
					isCurrentValueQuoted = true;
					valueProcessingBegan = true;
				} else {
					isCurrentValueQuoted = false;
					valueProcessingBegan = true;
					sb.append(c);
					continue;
				}
			} else {
				if (isCurrentValueQuoted) {
					if (c == '"') {
						values.add(sb.toString());
						sb.setLength(0);
						valueProcessingBegan = false;
						isCurrentValueQuoted = false;
					} else {
						sb.append(c);
					}
				} else {
					if (c == ' ') {
						values.add(sb.toString());
						sb.setLength(0);
						valueProcessingBegan = false;
						isCurrentValueQuoted = false;
					} else {
						sb.append(c);
					}
				}
				
			}
			
		}
		return values;
	}

	/*
			if (afterFirstQuote && afterSecondQuote) {
				if (c == ' ') {
					afterFirstQuote = false;
					afterSecondQuote = false;
					continue;
				}
			}
			
			if (afterFirstQuote && c == '"') {
				values.add(sb.toString());
				afterSecondQuote = true;
			}
			
			if (!afterFirstQuote && c == '"') {
				afterFirstQuote = true;
				sb.setLength(0);
			}
			
			if (afterFirstQuote && c != '"') {
				sb.append(c);
			}

	 */
	
	
	public static String getValueConvertedToOptionNames(String value, List<Option> optionList) {
		
		Map<String, String> options = new HashMap<String, String>();
		for (Option o : optionList) {
			options.put(o.getName(), o.getValue());
		}
		
		
		
		List<String> names = new ArrayList<String>();
		
		List<String> listOfValues = parseMultiSelectionValues(value);
		Set<String> nameSet = options.keySet();
		for (String n: nameSet) {
			String v = options.get(n);
			if (listOfValues.contains(v)) {
				names.add(n);
			}
		}
		
		return createMultiSelectionValue(names);
	}
}
