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

package resourceProvider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.provider.resource.ResourceSetItemProvider;

public class CRepResourceSetItemProvider extends ResourceSetItemProvider {

	private ResourceSet resourceSet=null;
	
	public CRepResourceSetItemProvider(AdapterFactory arg0) {
		super(arg0);
	}
	
	public Collection getChildren(Object object)
	  {
	    List children = new ArrayList();
		this.resourceSet = (ResourceSet)object;
	    for(Iterator iResource =resourceSet.getResources().iterator();iResource.hasNext();){
	    	Resource resource =(Resource)iResource.next();
	    	if(!resource.getContents().isEmpty())
	    		children.add(resource.getContents().get(0));
	    }
		return children;
	  }
}
