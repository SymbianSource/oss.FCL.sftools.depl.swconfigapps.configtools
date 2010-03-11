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

package helpers;

public class ExceptionMessageConverter {

	public static String convertMessage(String message)
	{
		if (message.endsWith("Content is not allowed in prolog."))
		{
			return "File is in a wrong format. Correct encoding is unicode big endian (UTF-16BE)";
		}
		else
			return message;
			

	}
}
