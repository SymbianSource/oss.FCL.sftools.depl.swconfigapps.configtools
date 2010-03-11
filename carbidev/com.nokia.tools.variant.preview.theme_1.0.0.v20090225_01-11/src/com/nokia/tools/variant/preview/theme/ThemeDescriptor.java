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
 * Description: This file is part of com.nokia.tools.variant.preview.theme component.
 */

package com.nokia.tools.variant.preview.theme;

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IStorage;
import org.eclipse.jface.viewers.AcceptAllFilter;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.swt.graphics.ImageData;

import com.nokia.tools.variant.preview.IPreviewDescriptor;
import com.nokia.tools.variant.preview.PreviewController;

public class ThemeDescriptor implements IPreviewDescriptor {

	public static final String APPSHELL_SCREEN_ID = "Application Grid";
	
	private IStorage file;
	private IFilter filter;
	private ElementOverride[] overrides;

	public static class ElementOverride {
		
		public static final String OPERATIOR_ICON_ID = "qgn_menu_operator";

		private String id;
		private ImageData image;
		private ImageData mask;
		private String text;

		public ElementOverride(String id, ImageData image, ImageData mask) {
			this.id = id;
			this.image = image;
			this.mask = mask;

		}
		
		/**
		 * This constructor is used for right soft key(RSK) settings
		 * @param image
		 * @param mask
		 * @param text
		 */
		public ElementOverride(ImageData image, ImageData mask, String text) {
			this.image = image;
			this.mask = mask;
			this.text = text;
		}

		public String getId() {
			return id;
		}
		
		public ImageData getImage() {
			return image;
		}

		public ImageData getMask() {
			return mask;
		}
		
		public String getText() {
			return text;
		}
	}

	public ThemeDescriptor(IStorage file) {
		this(file, AcceptAllFilter.getInstance());
	}

	public ThemeDescriptor(IStorage file, IFilter filter, List<ElementOverride> overrides) {
		this(file, AcceptAllFilter.getInstance(), overrides.toArray(new ElementOverride[overrides.size()]));
	}

	public ThemeDescriptor(IStorage file, IFilter filter,
			ElementOverride... overrides) {
		assert file != null : "Theme file must not be NULL";
		assert overrides != null : "Theme element overrides must not be null";
		
		this.file = file;
		this.filter = filter == null ? AcceptAllFilter.getInstance() : filter;
		this.overrides = overrides;
	}

	public String getName() {
		return file.getName();
	}

	public PreviewController createPreviewControl() {
		return new ThemePreviewController();
	}

	public IStorage getFile() {
		return file;
	}

	public IFilter getFilter() {
		return filter;
	}

	public ElementOverride[] getOverrides() {
		return overrides;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof ThemeDescriptor)) {
			return false;
		}
		ThemeDescriptor arg = (ThemeDescriptor) obj;
		return this.file.equals(arg.file) && this.filter.equals(arg.filter)
				&& Arrays.equals(this.overrides, arg.overrides);
	}
	
	/** 
	 *  If selected setting is about right soft key, then rsk is set on true.
	 */
	private boolean rsk;

	public boolean isRsk() {
		return rsk;
	}

	public void setRsk(boolean rsk) {
		this.rsk = rsk;
	}
}
