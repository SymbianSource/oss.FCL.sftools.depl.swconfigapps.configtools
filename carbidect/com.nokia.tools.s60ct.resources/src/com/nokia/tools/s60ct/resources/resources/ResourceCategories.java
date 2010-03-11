/*
 * Copyright (c) 2009 Nokia Corporation and/or its subsidiary(-ies). 
 * All rights reserved.
 * This component and the accompanying materials are made available
 * under the terms of "Eclipse Public License v1.0"
 * which accompanies this distribution, and is available
 * at the URL "http://www.eclipse.org/legal/epl-v10.html".
 * 
 * Initial Contributors:
 * Nokia Corporation - Initial contribution
 * 
 * Contributors:
 * 
 * Description: This file is part of com.nokia.tools.variant.resourcelibrary component.
 */

package com.nokia.tools.s60ct.resources.resources;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeMap;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.content.IContentDescription;
import org.eclipse.core.runtime.content.IContentType;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

import com.nokia.tools.s60ct.resources.Activator;
import com.nokia.tools.s60ct.resources.model.ELibraryDirectory;
import com.nokia.tools.s60ct.resources.model.ELibraryElement;
import com.nokia.tools.s60ct.resources.model.ELibraryFile;

/**
 *
 * Current implementation between directories & other types etc. is bad. 
 * Refactor to support the file extension API of Eclipse.
 * 
 */
public class ResourceCategories {

	public static final String EXTENSION_POINT_ID = 
		"com.nokia.tools.s60ct.resources.resourceCategory";
	public static final String CATEGORY_ID = "defaultCategory";
	public static final String DEFAULT_CATEGORY_ID = "category";
	
	public static final String CATEGORY_KEY = "resourceCategory";
	public static final String SUFFIXES_KEY = "fileSuffixes";
	public static final String ICON_KEY = "icon";
	public static final String SUFFIX_SEPARATOR = " ";
	
	public static final String DIRECTORY_TEXT = "Directory";	
	
	private static List<ResourceCategory> allCategories;
	private static List<ResourceCategory> unmodifiableCategories;
	private static TreeMap<String, ResourceCategory> suffixCategoryMapping;
	private static DefaultResourceCategory defaultCategory;
	
	private static boolean initialized = false;
	
	public static void init() {
		try {		
			allCategories = new java.util.ArrayList<ResourceCategory>();
			suffixCategoryMapping = new TreeMap<String, 
				ResourceCategory>(new ExtensionComparator());
			
			// Create unmodifiable view to resource categories
			unmodifiableCategories = Collections.unmodifiableList(allCategories);
			
			// Read all extensions from extension points list
			IExtensionPoint point = 
				Platform.getExtensionRegistry().getExtensionPoint(EXTENSION_POINT_ID);
			IExtension[] extensions = point.getExtensions();
				
			for(IExtension ext : extensions) {
				
				IConfigurationElement[] elements = ext.getConfigurationElements();
				for(IConfigurationElement element : elements){
					
					// Fetch category name
					String categoryName = element.getAttribute(CATEGORY_KEY);
					String suffixesStr = element.getAttribute(SUFFIXES_KEY);
					String iconStr = element.getAttribute(ICON_KEY);
					
					// Load icon
					Image icon = loadIcon(iconStr);
					
					if (suffixesStr != null && !"".equals(suffixesStr)) {
						// Separate tokens into a readable collection
						StringTokenizer set = new StringTokenizer(suffixesStr, " ");
						List<String> suffixes = new java.util.ArrayList<String>();
						while (set.hasMoreTokens())
							suffixes.add(set.nextToken());
						
						// Create & store a category that corresponds this data
						ResourceCategory e = new ResourceCategory(categoryName, suffixes, icon); 
						allCategories.add(e);
						
						// Populate suffix to category mapping for fast retrieval
						for (String suffix : e.getCategorySuffixes())
							suffixCategoryMapping.put(suffix, e);
					}
					else {
						// No suffix, must be default category
						defaultCategory = new DefaultResourceCategory(categoryName, icon);
					}
				}
			}
		}
		catch(RuntimeException e) {
			System.err.println("Could not initialize resource image " +
					"registry. Reason: " +  e.getMessage());
			e.printStackTrace();
		}
		
		assert(defaultCategory != null);
		initialized = true;
	}
	
	public static Image loadIcon(String pathInPlugin) {		
		ImageDescriptor desc = Activator.getImageDescriptor(pathInPlugin);
		if (desc != null) return desc.createImage();
		return null;
	}
	
	/**
	 * Fetches a correct category for a given resource by checking its file extension.
	 * 
	 * @param res Resource to find the ResourceCategory for
	 * @return instance of ResourceCategory if matching suffix exists, 
	 * DefaultResourceCategory otherwise
	 */	
	public static ResourceCategory getResourceCategory(ELibraryElement res) {
		if (!initialized) init();
				
		// Check the resource file type
		int index = res.getName().lastIndexOf(".");
		if (index>=0 && index<res.getName().length()-1){
		String ext = res.getName().substring(index+1);
		
		// Find the asset category that matches the icon
		ResourceCategory cat = suffixCategoryMapping.get(ext);
		if (cat != null)
			return cat;
		}
		return defaultCategory ;		
	}
	
	public static String getResourceCategoryText(ELibraryElement res) {
		// Since this will be used for resource library, the object is		
		// always IResource
		IContentType type = null;
		if (res instanceof ELibraryFile) {
			IContentDescription descr = ((ELibraryFile)res).getContentDescription();
			type = descr != null ? descr.getContentType(): null;
		}
		
		return type == null ? "none" : type.getName();
	}
	
	public static List<ResourceCategory> getCategories() {
		if (!initialized) init();
		return unmodifiableCategories;
	}
	
	public static int compare(ELibraryElement r1, ELibraryElement r2) {
		// In the battle, everything wins the normal file
		int t1 = (r1 instanceof ELibraryDirectory)?1:0;
		int t2 = (r2 instanceof ELibraryDirectory)?1:0;
		
		// Same type
		if (t1 == t2 && t2 == 1)// directory
			return r2.getName().compareToIgnoreCase(r1.getName());
		if (r1 instanceof ELibraryDirectory) return 1;
		if (r2 instanceof ELibraryDirectory) return -1;
		
		String cat1 = getResourceCategoryText(r1);
		String cat2 = getResourceCategoryText(r2);
		int catDiff = cat2.compareToIgnoreCase(cat1);
		if (catDiff != 0) return catDiff;		
		else return r2.getName().compareToIgnoreCase(r1.getName());		
	}
}

class ExtensionComparator implements Comparator<String> {

	public int compare(String s1, String s2) {			
		// Test referential equality
		if (s1 == s2) return 0;
		
		// Test other one is  null
		if (s1 == null) return -1;
		else if (s2 == null) return 1;
		
		// Then do the real comparison
		return s1.compareToIgnoreCase(s2);
	}	
}
