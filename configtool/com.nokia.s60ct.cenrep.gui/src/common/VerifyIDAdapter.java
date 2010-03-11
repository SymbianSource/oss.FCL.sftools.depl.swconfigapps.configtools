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
package common;

import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.widgets.Text;

public class VerifyIDAdapter implements VerifyListener {
	private static final int MAX_SIZE = 10;
	private static final int MAX_SIZE_WITHOUT_X = 8;
	final int mode; //0 -with X; 1 - without X
	public static final  VerifyIDAdapter INSTANCE = new VerifyIDAdapter(0);
	public static final  VerifyIDAdapter INSTANCE_WITHOUT_X = new VerifyIDAdapter(1);
	private static final char BACKSPACE = '\b';
	private VerifyIDAdapter(int mode){
		this.mode = mode;
	}
	

	public void verifyText(VerifyEvent e) {
		
		String text = ((Text)e.getSource()).getText();//.toUpperCase(); //existing content in text field
		if(Character.isLetter(e.character)||Character.isDigit(e.character))
			text=text+(String.valueOf(e.character));
		else
			text=e.text;

		String validatedText = text;
		
		if (this.mode==1 && text.startsWith("0x"))
			validatedText = text.substring(2);

		int maxSize=0;
		if(this.mode==0)
		{
			if (validatedText.startsWith("0x"))
				maxSize=MAX_SIZE;
			else
				maxSize=MAX_SIZE_WITHOUT_X;
		}
		else if(this.mode==1)
			maxSize=MAX_SIZE_WITHOUT_X;
		
		if(validatedText.length()>maxSize)
			e.doit=false;
		else
		{
			if (this.mode==0 && validatedText.startsWith("0x"))
			{
				if (validatedText.length()>2)
				{
					validatedText = validatedText.substring(2);
					e.doit = validatedText.matches("(\\p{XDigit})+");
				}
				else if (validatedText.length()==2)
					e.doit = true;
			}
			else
				e.doit = validatedText.matches("(\\p{XDigit})+");
		}
			
		if (e.character == BACKSPACE || e.character =='\0') //this is needed to clear the existing value from the text field when selection changes
			e.doit=true;							//backspace also needed to erase single character from full field.
			
		
	}
	

}
