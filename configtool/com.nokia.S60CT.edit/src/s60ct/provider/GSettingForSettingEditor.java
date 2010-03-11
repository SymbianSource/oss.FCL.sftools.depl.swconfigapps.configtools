/*
* Copyright (c) 2009 Nokia Corporation and/or its subsidiary(-ies). 
* All rights reserved.
* This component and the accompanying materials are made available
* under the terms of "Eclipse Public License v1.0"
* which accompanies this distribution, and is available
* at the URL "http://www.eclipse.org/legal/epl-v10.html".
*
* Initial Contributors:
* Nokia Corporation - initial contribution.
*
* Contributors:
*
* Description:
*
*/
package s60ct.provider;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.ITableItemLabelProvider;

import configurationemf.IDynamicColumnProvider;
import configurationemf.IPVContentProvider;
import configurationemf.Option;
import configurationemf.Setting;
import configurationemf.provider.GSettingItemProvider;

public class GSettingForSettingEditor extends GSettingItemProvider implements
		ITableItemLabelProvider, IDynamicColumnProvider, IPVContentProvider {

	
	public static final String TYPE_INT = "int";
	public static final String TYPE_STRING = "string";
	public static final String TYPE_FILE = "file";
	public static final String TYPE_SEQUENCE = "sequence";
	public static final String TYPE_SELECTION = "selection";
	public static final String TYPE_MULTISELECTION = "multiSelection";
	
	public GSettingForSettingEditor(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	public Object getColumnImage(Object arg0, int arg1) {
		return null;
	}

	public String getColumnText(Object object, int columnIndex) {
		return null;
	}

	public Map getConfValues(Object object) {
		return null;
	}
	public int getSequenceNumber(Object leafSetting) {
		return 0;
	}
	
	// Possible Values Interface
	public String[] getPossibleValues(Object object) {
		Setting setting = (Setting)object;
		//Object currentValue = getValue(object);
		String[] result = null;
		/*if(currentValue instanceof String){ 
			result= new String[setting.getOption().size()+1];
			result[result.length-1] = (String)currentValue;
		}else*/ result= new String[setting.getOption().size()];
		 
		for(int i=0;i<setting.getOption().size();i++){
			result[i]=((Option)setting.getOption().get(i)).getName();
		}
		return result;
	}
	
	public Object getValue(Object object) {
		Object value = getColumnText(object, 2);
		String[] possibleValues = getPossibleValues(object);
		int index = -1;
		if(possibleValues.length>0&&value!=null){
			for(index=0;index<possibleValues.length&&!possibleValues[index].equals(value);index++);
		}
		return index>-1 && index<possibleValues.length? Integer.valueOf(index):value;
	}

//	functions for possible values
	protected String getIntValue(Setting setting,String value){
		List options = setting.getOption();
		for(Iterator iterator=options.iterator();iterator.hasNext();){
			Option option = (Option)iterator.next();
			if(value.equals(option.getValue()))value=option.getName();
		}
		return value;
	}
	protected String getStringValue(Setting setting,String value){
		List options = setting.getOption();
		for(Iterator iterator=options.iterator();iterator.hasNext();){
			Option option = (Option)iterator.next();
			if(value.equals(option.getValue()))value=option.getName();
		}
		return value;
	}
	protected String getFileValue(Setting setting,String value){
		return value;
	}
	protected String getSelectionValue(Setting setting,String value){
		List options = setting.getOption();
		for(Iterator iterator=options.iterator();iterator.hasNext();){
			Option option = (Option)iterator.next();
			if(value.equals(option.getValue()))value=option.getName();
		}
		return value;
	}
	protected String getSequenceValue(Setting setting,String value){
		return value;
	}
	protected String getMultiSelectionValue(Setting setting,String value){
		return value;
	}
	
	
}

