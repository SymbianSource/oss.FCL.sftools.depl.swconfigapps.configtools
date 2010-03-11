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
package com.nokia.s60ct.gui.cellEditors;

import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

public class ComboTextCellEditor extends ComboBoxCellEditor implements KeyListener{
	
	protected StringBuffer stringBuffer = new StringBuffer();
	
	public ComboTextCellEditor() {
		super();
	}

	public ComboTextCellEditor(Composite parent, String[] items, int style) {
		super(parent, items, style);
	}

	public ComboTextCellEditor(Composite parent, String[] items) {
		super(parent, items);
	}

	protected Control createControl(Composite parent) {
		final CCombo combo = (CCombo)super.createControl(parent);
		
		combo.addKeyListener(this);
		return combo;
	}

	protected Object doGetValue() {
		Object result = super.doGetValue();
		if(result instanceof Integer && ((Integer)result).equals(Integer.valueOf(-1))){
			result = stringBuffer.length()>0?stringBuffer.toString():result;
			
		}
		return result;
	}

	
	public void keyPressed(KeyEvent e) {}
	
	public void keyReleased(KeyEvent e) {
		if(Character.isLetter(e.character)||Character.isDigit(e.character)) stringBuffer.append(e.character);
		
	}
	
}
