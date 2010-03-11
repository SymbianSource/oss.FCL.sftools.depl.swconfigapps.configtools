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
package release;

import java.util.ArrayList;
import java.util.List;

public class Release {
	public static String SHOW_ALL ="showall";
	public static String selectedRelease = SHOW_ALL;
	private static List views2update = new ArrayList();

	public static void setCurrentRelease(String release){
		selectedRelease = release;
	}

	public static List getRDElement(){
		return views2update;
	}

	public static void addRDElement(Object element){
		views2update.add(element);
	}
	/*
	 * Used for ReleaseAttrs, not for Ref
	 */
	public static boolean inRelease(String firstRelease,String lastRelease){
		if(selectedRelease.equals(SHOW_ALL))return true;
		Float currentRelease = Float.valueOf(selectedRelease);
		Float fRelease = firstRelease!=null?Float.valueOf(firstRelease):Float.valueOf(Float.NEGATIVE_INFINITY);
		Float lRelease = lastRelease!=null?Float.valueOf(lastRelease):Float.valueOf(Float.POSITIVE_INFINITY);
		if(currentRelease.compareTo(fRelease)>=0&&
				currentRelease.compareTo(lRelease)<=0) return true;
		return false;
	}

}
