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

/**
 * Class serves for storing setting option in UI model. 
 */
public class WidgetOption implements Comparable<WidgetOption>{

	private String relevant,mapValue;
	private String value;
	private String key;
	private boolean selected;
	
	public WidgetOption(String key, String value, String relevant,String mapValue) {
		this.key = key;
		this.value = value;
		this.relevant = relevant;
		this.mapValue = mapValue;
	}

	public int compareTo(WidgetOption o) {
		return getKey().compareTo(o.getKey());
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setRelevant(String relevant) {
		this.relevant = relevant;
	}

	public String getRelevant() {
		return relevant;
	}

	public void setMapValue(String mapValue) {
		this.mapValue = mapValue;
	}

	public String getMapValue() {
		return mapValue;
	}
	
}
