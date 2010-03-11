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
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.PlatformUI;

import views.OptionView;
import constants.IS60CTCommonConstants;

public class BoolComboEditor extends ComboBoxCellEditor implements IPairItem {

	Map pairs = null;
	CCombo comboBox;
	int previousIndex=-1;

	@Override
	public void setFocus() {
		super.setFocus();
		 int index = comboBox.getSelectionIndex();
         if(comboBox.getItem(index).compareTo(IS60CTCommonConstants.ADD_NEW_OPTION)!=0){
        	 previousIndex = comboBox.getSelectionIndex();
         }
	
	}
	
	public BoolComboEditor(Composite parent) {
		super(parent, new String[0], SWT.READ_ONLY);
	}

	
	protected Control createControl(Composite parent) {
		Control control = super.createControl(parent);
		control.setBackground(parent.getBackground());
		comboBox = (CCombo)control;
		comboBox.addSelectionListener(new SelectionAdapter() {
	         public void widgetDefaultSelected(SelectionEvent event) {
	             
	         }

	         public void widgetSelected(SelectionEvent event) {
	             
	        	 int index = comboBox.getSelectionIndex();
	             if(comboBox.getItem(index).compareTo(IS60CTCommonConstants.ADD_NEW_OPTION)==0){
	            	try
	 				{
	            		comboBox.select(previousIndex);
	 					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(OptionView.ID);
	 				} 
	 				catch (Exception e2)
	 				{

	 				}
	             }
	             else
	            	 previousIndex = index;
	             	             
	         }
	     });
		 
		return control;
	}

	public void setPairs(Map pairs){
		if(pairs == null) return;
		this.pairs = pairs;
		String[] items = new String[pairs.size()];
		Object[] keys = pairs.keySet().toArray();
		for(int i=0;i<items.length;i++)items[i]=(String)keys[i];
		setItems(items);
		previousIndex = comboBox.getSelectionIndex();
	}
	
	protected Object doGetValue() {
		Integer value = (Integer) super.doGetValue();
		String svalue = getItems()[value.intValue()];
		String result = (String)pairs.get(svalue); 
		return result!=null?result:svalue;
	}

	protected void doSetValue(Object value) {
		String sValue=(String)value;
		int index=-1;
		if(sValue!=null){
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
		}else super.doSetValue(Integer.valueOf(-1));
	}
	
	
	
}
