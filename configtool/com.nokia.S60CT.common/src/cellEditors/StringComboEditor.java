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
package cellEditors;

import java.util.Map;

import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Composite;

public class StringComboEditor extends ComboBoxCellEditor implements IPairItem{
	
	Map pairs = null;
	public StringComboEditor() {
		// Auto-generated constructor stub
	}

	public StringComboEditor(Composite parent, String[] items) {
		super(parent, items);
		// Auto-generated constructor stub
	}

	public StringComboEditor(Composite parent, String[] items, int style) {
		super(parent, items, style);
		// Auto-generated constructor stub
	}

	public void setPairs(Map pairs){
		if(pairs == null) return;
		this.pairs = pairs;
		String[] items = new String[pairs.size()];
		Object[] keys = pairs.keySet().toArray();
		for(int i=0;i<items.length;i++)items[i]=(String)keys[i];
		setItems(items);
	}
	
	protected Object doGetValue() {
		Integer value = (Integer) super.doGetValue();
		String svalue=null;
		if(value.compareTo(Integer.valueOf(-1))==0){
			CCombo control = (CCombo)this.getControl();
			svalue=control.getText();
		}else svalue = getItems()[value.intValue()];
		String result = (String)pairs.get(svalue); 
		return result!=null?result:svalue;
	}
	
//	 input is alaways String
	protected void doSetValue(Object value) {
		String sValue=(String)value;
		int index=-1;
		for(int i=0;i<this.getItems().length&&index==-1;i++){
			String item = this.getItems()[i];
			if(item.compareTo(sValue)==0)index=i;
		}
		if(index==-1){
			String[] newItems = new String[this.getItems().length+1];
			System.arraycopy(this.getItems(), 0, newItems, 1, this.getItems().length);
			newItems[0]=sValue;
			this.setItems(newItems);
			this.pairs.put(sValue, sValue);
			index=0;
		}
		super.doSetValue(Integer.valueOf(index));
	}
	

}
