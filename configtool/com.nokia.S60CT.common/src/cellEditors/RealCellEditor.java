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

public class RealCellEditor extends TextCellEditor {

	public RealCellEditor() {
		// Auto-generated constructor stub
	}

	public RealCellEditor(Composite parent) {
		super(parent);
		// Auto-generated constructor stub
	}

	public RealCellEditor(Composite parent, int style) {
		super(parent, style);
		// Auto-generated constructor stub
	}

	protected Control createControl(Composite parent) {
		super.createControl(parent);
		
		text.addVerifyListener(new VerifyListener(){
			public void verifyText(VerifyEvent e) 
			{
				String str = text.getText();
				int position = e.start;
				char c = e.character;
				if (Character.getType(c) == Character.CONTROL || c==SWT.DEL || c==SWT.BS)
				{
					e.doit=true;
				}
				else if(Character.isLetterOrDigit(c)||"-".indexOf(c)!=-1)
				{
					if(str.indexOf("-")==-1&&position==0)
					{
						e.doit="-1234567890".indexOf(c)!=-1;
					}
					else if(str.indexOf("-")!=-1&&position==0)
					{
						e.doit=false;
					}
					else
					{
						e.doit="1234567890".indexOf(c)!=-1;
					}
				}
				else if(c=='.')
				{
					if(str.indexOf(".")==-1)
						e.doit=true;
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
