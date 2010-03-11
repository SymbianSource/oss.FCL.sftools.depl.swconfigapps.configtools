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
package s60cenrep.provider;

import java.util.ArrayList;
import java.util.List;

import helpers.MarkerManager;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.provider.ComposedImage;
import org.eclipse.emf.edit.provider.resource.ResourceItemProvider;

import cenrep.Repository;
import cenrep.provider.CRPluginModelEditPlugin;
import cenrep.util.CenrepResourceImpl;

public class BrowserResourceItemProvider extends ResourceItemProvider {

	
	private static Object resourceImageNormal = null;
	private static Object resourceImageWarning = null;
	private static Object resourceImageError = null;
	
	public BrowserResourceItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
		resourceImageNormal = getResourceLocator().getImage("full/obj16/Resource");
		List<Object> images = new ArrayList<Object>(2);
		images.add(resourceImageNormal);
		images.add(getResourceLocator().getImage("full/ovr16/error_co"));
		resourceImageError = new ComposedImage(images);
		images.clear();
		images.add(resourceImageNormal);
		images.add(getResourceLocator().getImage("full/ovr16/warning_co"));
		resourceImageWarning = new ComposedImage(images);
	}

	@Override
	public String getText(Object object) {
		Resource resource = (Resource)object;
		/*
		if (resource.getContents().isEmpty())
			return resource.getURI().lastSegment()+" (no content)";
		else if	(!resource.getErrors().isEmpty())
		{
			return resource.getURI().lastSegment()+" ("+resource.getErrors().get(0).getMessage()+")";
		}
		else*/
			return resource.getURI().lastSegment();
	}

	@Override
	public Object getImage(Object object) {
		
		if (((CenrepResourceImpl)object).getContents().isEmpty() || !((CenrepResourceImpl)object).getErrors().isEmpty()){
			return overlayImage(object, getResourceLocator().getImage("full/obj16/error_tsk"));
		}
		else
		{
			Repository repo = (Repository)((CenrepResourceImpl)object).getContents().get(0);
			
			if (repo!=null)
			{
				switch (MarkerManager.getInstance().getProblemStatus(repo))
				{
			      case IStatus.ERROR:
			    	  return resourceImageError;
			      case IStatus.WARNING:
			    	  return resourceImageWarning;
			      default:
			    	  return resourceImageNormal;
			    
			    }
			}
			else
				return resourceImageNormal;
		}
		
		/*
		if (((CenrepResourceImpl)object).getContents().isEmpty() || !((CenrepResourceImpl)object).getErrors().isEmpty()){
			return overlayImage(object, getResourceLocator().getImage("full/obj16/error_tsk"));
		}else{
			return super.getImage(object);
		}
		*/
	}
	
	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return CRPluginModelEditPlugin.INSTANCE;
	}
}
