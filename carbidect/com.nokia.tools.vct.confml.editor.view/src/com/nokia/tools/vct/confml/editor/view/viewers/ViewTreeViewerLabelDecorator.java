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
 * Description: This file is part of com.nokia.tools.vct.confml.editor.view component.
 */

package com.nokia.tools.vct.confml.editor.view.viewers;

import java.net.URL;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.runtime.ListenerList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.jface.resource.FontRegistry;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;

import com.nokia.tools.variant.validation.core.builder.ConfMLBuilder;
import com.nokia.tools.vct.common.appmodel.EAppFeature;
import com.nokia.tools.vct.common.appmodel.EAppResourceData;
import com.nokia.tools.vct.common.appmodel.EAppSequenceData;
import com.nokia.tools.vct.common.appmodel.EAppSequenceDataItem;
import com.nokia.tools.vct.common.appmodel.EAppSetting;
import com.nokia.tools.vct.common.appmodel.EAppSettingData;
import com.nokia.tools.vct.common.appmodel.EAppSimpleData;
import com.nokia.tools.vct.common.appmodel.EConfMLLayer;
import com.nokia.tools.vct.confml.editor.view.ViewsEditorPlugin;
import com.nokia.tools.vct.confml.editor.view.vemodel.EFeature;
import com.nokia.tools.vct.confml.editor.view.vemodel.EGroup;
import com.nokia.tools.vct.confml.editor.view.vemodel.ERefTarget;
import com.nokia.tools.vct.confml.editor.view.vemodel.ESetting;
import com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef;
import com.nokia.tools.vct.confml.editor.view.vemodel.EView;
import com.nokia.tools.vct.confml.editor.view.vemodel.impl.ESettingEntryImpl;

public class ViewTreeViewerLabelDecorator implements ILightweightLabelDecorator {
	static final int ERROR = 1;
	static final int WARNING = 2;
	private ListenerList listeners;
	private ImageDescriptor errorDescriptor;
	private ImageDescriptor warningDescriptor;
	private ImageDescriptor readOnlyDescriptor;
	private FontRegistry fonts;
	private static Font BOLD_FONT;
	private static Font DEFAULT_FONT;

	public ViewTreeViewerLabelDecorator() {
		listeners = new ListenerList();
		lazyInit();
	}
	
	public static Display getStandardDisplay() {
		Display display;
		display = Display.getCurrent();
		if (display == null)
			display = Display.getDefault();
		return display;
	}
	
	private void lazyInit() {
		if (errorDescriptor == null) {
			URL url = ViewsEditorPlugin.getDefault().getBundle().getEntry(
					"icons/full/ovr16/ErrorObject.gif");
			errorDescriptor = ImageDescriptor.createFromURL(url);
			url = ViewsEditorPlugin.getDefault().getBundle().getEntry(
					"icons/full/ovr16/WarningObject.gif");
			warningDescriptor = ImageDescriptor.createFromURL(url);
			url = ViewsEditorPlugin.getDefault().getBundle().getEntry(
					"icons/full/ovr16/ReadOnlySetting.gif");
			readOnlyDescriptor = ImageDescriptor.createFromURL(url);
		}
		
		Display d = getStandardDisplay();
		d.syncExec(new Runnable() {
			public void run() {
				fonts = new FontRegistry(getStandardDisplay());
				DEFAULT_FONT = fonts.defaultFont();
				BOLD_FONT = fonts.getBold("bold");
			}
		});
		
	}

	private boolean hasMarker(Object element, int level, String featureRef) {
		if (element instanceof EView)
		{
			EView view = (EView) element;
			for (EGroup group : view.getGroups()) {
				if (hasMarker(group, level, null)) {
					return true;
				}
			}
			return false;
		} 
		else if (element instanceof EGroup)
		{
			EGroup group = (EGroup) element;
			for (ESettingRef setting : group.getRefs()) {
				if (hasMarker(setting, level, null)) {
					return true;
				}
			}
			for (EGroup subGroup : group.getGroups()) {
				if (hasMarker(subGroup, level, null)) {
					return true;
				}
			}
			return false;
		} 
		else if (element instanceof ESettingRef)
		{
			ESettingRef ref = (ESettingRef) element;
			switch (level) {
			case ERROR:
				return ref.getTarget() == null;
			case WARNING:
				ERefTarget target = ref.getTarget();
				if (target == null) {
					return false;
				}
				if (target instanceof EFeature) {

					for (ESetting setting : ((EFeature) target).getSettings()
							.values()) {
						if (setting.isReadOnly()) {
							return true;
						}
					}

					return false;
				}
				if (target instanceof ESetting) {
					return ((ESetting) target).isReadOnly();
				}
			}
		} 
		else if (element instanceof ESettingEntryImpl)
		{
			ESettingEntryImpl ref = (ESettingEntryImpl) element;
			switch (level) {
			case ERROR:
				return false;
			case WARNING:
				ESetting target = ref.getValue();
				return ((ESetting) target).isReadOnly();
			}
		}
		else if (element instanceof EAppFeature)
		{
			EAppFeature appFeature = (EAppFeature)element;
			for (Map.Entry<String, EAppSetting> entry : appFeature.getSettings())
			{
				if (hasMarker(entry.getValue(), level, appFeature.getRef())) {
					return true;
				}
			}
			return false;
		}
		else if (element instanceof EAppSetting)
		{
			EAppSetting appSetting = (EAppSetting)element;
			EAppSettingData data = appSetting.getValueInfo();
			
			if (data instanceof EAppSequenceData)
			{
				String settingRef = appSetting.getRef();
				if (settingRef==null)
					return false;
				EAppSequenceDataItem  dataItem = ((EAppSequenceData) data).getTemplate();
				//URI uri = dataItem.getUri().get(0);
				EMap<String, EAppSettingData> subSettings = dataItem.getSubSettings();
				Iterator<String> keys = subSettings.keySet().iterator();
				boolean found = false;
				while (keys.hasNext())
				{
					String next = keys.next();
					String absRef = featureRef+"/"+settingRef+"/"+next;
					if (level==ERROR)
						found = ConfMLBuilder.hasErrorMarkers(absRef);
					else if (level==WARNING)
						found = ConfMLBuilder.hasWarningMarkers(absRef);
					
					if (found)
						return true;
				}
				return false;
			}
			else
			{
				String settingRef = appSetting.getRef();
				if (settingRef==null)
					return false;
				
				String absRef = featureRef+"/"+settingRef;
				
				if (level==ERROR)
					return ConfMLBuilder.hasErrorMarkers(absRef);
				else if (level==WARNING)
					return ConfMLBuilder.hasWarningMarkers(absRef);
				return false;
			}
		}
		return false;
	}

	protected boolean hasErrorDecoration(Object element) {
		if (element instanceof ESettingRef) {
			ESettingRef ref = (ESettingRef) element;
			boolean error = ref.getTarget() == null;
			return error;
		} else {
			return false;
		}
	}

	public void decorate(Object element, IDecoration decoration) {
		
		if (element instanceof ESetting) 
		{
			if (((ESetting) element).isReadOnly()) {
				decoration.addOverlay(readOnlyDescriptor,
						IDecoration.TOP_RIGHT);
			}
		} 
		else if (element instanceof ESettingEntryImpl) {
			if (((ESettingEntryImpl) element).getValue().isReadOnly()) {
				decoration.addOverlay(readOnlyDescriptor,
						IDecoration.TOP_RIGHT);
				decoration.addOverlay(warningDescriptor, IDecoration.BOTTOM_LEFT);
			}
		} 
		else if (hasMarker(element, ERROR, null)) {
			decoration.addOverlay(errorDescriptor, IDecoration.BOTTOM_LEFT);
		} 
		else if (hasMarker(element, WARNING, null)) {
			decoration.addOverlay(warningDescriptor, IDecoration.BOTTOM_LEFT);
		}
		
		if (element instanceof ESettingRef) {
			ESettingRef ref = (ESettingRef)element;
			if (ref.getTarget() instanceof ESetting) { 
				if (((ESetting)ref.getTarget()).isReadOnly()) {
					decoration.addOverlay(readOnlyDescriptor,
						IDecoration.TOP_RIGHT);
				}
			}
		}
		
		if (element instanceof EAppFeature)
		{
			EAppFeature feature = (EAppFeature)element;
			if (isDefaultValue(feature))
			{
				decoration.setFont(DEFAULT_FONT);
			}
			else
			{
				decoration.setFont(BOLD_FONT);
			}
		}
	}

	private boolean isDefaultValue(EAppFeature feature)
	{
		EConfMLLayer layer = (EConfMLLayer) feature.eContainer().eContainer();
		EConfMLLayer parentLayer = layer.getParent();
		if (parentLayer==null)
			return true;
		
		for (Map.Entry<String, EAppSetting> entry : feature.getSettings())
		{
			EAppSetting setting = entry.getValue();
			EAppSettingData data = setting.getValueInfo();
			
			EAppFeature parentLayerFeature = parentLayer.getFeatures().get(feature.getRef());
			if (parentLayerFeature==null)
				return true;
			EAppSetting parentLayerSetting = parentLayerFeature.getSettings().get(setting.getRef());
			if (parentLayerSetting==null)
				return true;
			
			EAppSettingData parentLayerData = parentLayerSetting.getValueInfo();
			
			if (data instanceof EAppSimpleData)
			{
				EAppSimpleData simpleData = (EAppSimpleData)data;
				EAppSimpleData parentLayerSimpleData = (EAppSimpleData)parentLayerData;
				String v1 = simpleData.getValue();
				String v2 = parentLayerSimpleData.getValue();
				if (v1!=v2)
					return false;
			}
			else if (data instanceof EAppResourceData)
			{
				EAppResourceData resData = (EAppResourceData)data;
				EAppResourceData parentLayerResData = (EAppResourceData)parentLayerData;
				String v1 = ((EAppSimpleData)resData.getLocalPath()).getValue();
				String v2 = ((EAppSimpleData)parentLayerResData.getLocalPath()).getValue();
				if (v1!=v2)
					return false;
			}
			//sequence?
		}
		return true;
	}
	
	public void addListener(ILabelProviderListener listener) {
		listeners.add(listener);
	}

	public void dispose() {
	}

	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	public void removeListener(ILabelProviderListener listener) {
		listeners.remove(listener);
	}
}
