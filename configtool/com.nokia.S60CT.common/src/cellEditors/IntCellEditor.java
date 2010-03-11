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

import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

public class IntCellEditor extends TextCellEditor {

	public IntCellEditor() {
		// Auto-generated constructor stub
		// Should this call super() or be removed?
	}

	public IntCellEditor(Composite parent) {
		super(parent);
		// Auto-generated constructor stub
	}
	
	
	public IntCellEditor(Composite parent, int style) {
		super(parent, style);
		// Auto-generated constructor stub
	}
	

	@Override
	protected void focusLost() {
		this.deactivate();
		
	}

	protected Control createControl(Composite parent) {
		super.createControl(parent);
		
		text.addVerifyListener(new VerifyListener(){
			public void verifyText(VerifyEvent e)
			{
				// '-' can be entered only in zeroth index and only once
				String str = text.getText();
				int position = e.start;
				char c = e.character;
				if (Character.getType(c) == Character.CONTROL || c==SWT.DEL || c==SWT.BS)
				{
					e.doit=true;
				}
				else if(Character.isDigit(c)||"-".indexOf(c)!=-1)
				{
					if(str.indexOf("-")==-1 && position==0)
					{
						e.doit="-1234567890".indexOf(c)!=-1;
					}
					else if(str.indexOf("-")!=-1 && position==0)
					{
						e.doit=false;
					}
					else
					{
						e.doit="1234567890".indexOf(c)!=-1;
					}
				}
				else if(Character.isLetter(c))
				{
					c = Character.toUpperCase(c);
					if(c=='X' && position==1 && str.charAt(0)=='0')
					{
						e.doit=true;
					}
					else if (str.startsWith("0x") || str.startsWith("0X"))
					{
						e.doit="ABCDEF".indexOf(c)!=-1;
					}
					else
						e.doit=false;
				}
				else
				{
					e.doit=false;
				}
			}
		});
		return text;
	}
}
