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
package com.nokia.s60ct.gui.filter;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import configurationemf.Setting;
import configurationemf.Configuration;
import configurationemf.Feature;

public class ReadOnlyFilter extends ViewerFilter
{
	public static final ReadOnlyFilter INSTANCE = new ReadOnlyFilter();
	private boolean filtering = false;
	private List< Viewer > viewers = new ArrayList< Viewer >();
	
	public void setFiltering( boolean state )
	{
		if ( state != filtering )
		{
			filtering = state;
			List< Viewer > disposed = new ArrayList< Viewer >();
			for ( Viewer viewer : viewers )
			{
				if ( viewer.getControl().isDisposed() )
				{
					disposed.add( viewer ); // Add for later removal
				}
				else
				{
					viewer.refresh();
				}
			}
			// Remove disposed viewers
			for ( Viewer viewer : disposed )
			{
				viewers.remove( viewer );
			}
		}
	}
	
	public void addViewer( Viewer viewer )
	{
		viewers.add( viewer );
	}
	
	
	
	public boolean select( Viewer viewer, Object parentElement, Object element )
	{
		if ( filtering )
		{
			if ( element instanceof Setting )
			{
				Setting setting = ( Setting ) element;
				if ( setting.isValueChangeble() )
				{
					return false;
				}
			}
			else
			{
				if ( element instanceof Configuration )
				{
					Configuration configuration = ( Configuration ) element;
					for ( Setting setting : configuration.getAllSettings() )
					{
						if ( setting.isValueChangeble())
						{
							return true; // At least one setting not read-only, show configuration
						}
					}
					return false; // All read-only, don't show
				}
				else
				{
					if ( element instanceof Feature )
					{
						Feature feature = ( Feature ) element;
						for ( Setting setting : feature.getParentSetting() )
						{
							if ( setting.isValueChangeble() )
							{
								return true; // At least one setting not read-only, show configuration
							}
						}
						return false; // All read-only, don't show
					}
				}
			}
		}
		return true;
	}
}
