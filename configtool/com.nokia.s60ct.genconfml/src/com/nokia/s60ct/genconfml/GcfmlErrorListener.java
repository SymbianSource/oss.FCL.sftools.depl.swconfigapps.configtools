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

package com.nokia.s60ct.genconfml;

import javax.xml.transform.ErrorListener;
import javax.xml.transform.TransformerException;

class GcfmlErrorListener implements ErrorListener
{
		private String text = "";
		
		public void error(TransformerException exception) {
			text += exception.getLocationAsString() + ": " + exception.getMessage() + "\n";
		}
		public void warning(TransformerException exception) {
			text += exception.getLocationAsString() + ": " + exception.getMessage() + "\n";
		}
		public void fatalError(TransformerException exception) {
			text += exception.getLocationAsString() + ": " + exception.getMessage() + "\n";
		}
		
		public String getErrors() {
			return text;
		}
}
