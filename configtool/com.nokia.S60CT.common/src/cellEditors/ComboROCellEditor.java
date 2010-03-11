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
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

public class ComboROCellEditor extends ComboBoxCellEditor implements IPairItem {
	Map pairs = null;
	public ComboROCellEditor() {
		
	}

	public ComboROCellEditor(Composite parent, String[] items) {
		super(parent, items, SWT.READ_ONLY);
		// Auto-generated constructor stub
	}

	public ComboROCellEditor(Composite parent, String[] items, int style) {
		super(parent, items, SWT.READ_ONLY);
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
		String svalue = getItems()[value.intValue()];
		String result = (String)pairs.get(svalue); 
		return result!=null?result:svalue;
	}

//	 input is alaways String
	protected void doSetValue(Object value) {
		super.doSetValue(value);
	}

}
