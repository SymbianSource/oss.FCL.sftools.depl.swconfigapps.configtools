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

package constraints;

import cenrep.Access;
import cenrep.Key;
import cenrep.KeyRange;
import cenrep.Repository;

public class ElementRefParser
{
	public ElementRefParser()
	{
	}
	public static String getName(Repository repository)
	{
		String name = repository.getUidName();
		String value = repository.getUidValue();
		
		if (name != null && !name.equals(""))
			return name;
		else if (value != null && !value.equals(""))
			return value;
		else
			return "<unknown repository>";
	}
	public static String getName(Key key)
	{
		String ref = key.getRef();
		if (ref != null && !ref.equals(""))
			return ref;
		else
		{
			String rep = getName(key.eContainer());
			String keyName = key.getName();
			String keyIdent = key.getIdent();
			if (keyName != null && !keyName.equals(""))
				return rep+"/"+keyName;
			else if (keyIdent != null && !keyIdent.equals(""))
				return rep+"/"+keyIdent;
			else
				return rep+"/"+"<unknown key>";
		}
	}
	public static String getName(KeyRange keyRange)
	{
		String ref = keyRange.getRef();
		if (ref != null && !ref.equals(""))
			return ref;
		else
		{
			String rep = getName(keyRange.eContainer());
			String keyName = keyRange.getName();
			String firstInt = keyRange.getFirstInt();
			String LastInt = keyRange.getLastInt();
			if (keyName != null && !keyName.equals(""))
				return rep+"/"+keyName;
			else if (firstInt != null && !firstInt.equals(""))
				return rep+"/"+firstInt+"-"+LastInt;
			else
				return rep+"/"+"<unknown key>";
		}
	}
	public static String getName(Access access)
	{
		return getName(access.eContainer());
	}
	
	public static String getName(Object obj)
	{
		if (obj instanceof Repository)
		{
			Repository rep = (Repository)obj;
			return getName(rep);
		}
		else if (obj instanceof Key)
		{
			Key key = (Key)obj;
			return getName(key);
		}
		else if (obj instanceof KeyRange)
		{
			KeyRange keyRange = (KeyRange)obj;
			return getName(keyRange);
		}
		else if (obj instanceof Access)
		{
			Access access = (Access)obj;
			return getName(access.eContainer());
		}
		return "<Unhandled object type>";
	}
	
}
