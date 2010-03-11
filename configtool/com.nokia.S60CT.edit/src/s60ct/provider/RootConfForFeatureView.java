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
package s60ct.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ViewerNotification;

import configurationemf.Configuration;
import configurationemf.ConfigurationemfPackage;
import configurationemf.Feature;
import configurationemf.Icon;
import configurationemf.Link;
import configurationemf.ParentSetting;
import configurationemf.RootConf;
import configurationemf.impl.FeatureImpl;
import configurationemf.provider.RootConfItemProvider;

public class RootConfForFeatureView extends RootConfItemProvider{

	public Collection getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			childrenFeatures = new ArrayList();
			childrenFeatures.add(ConfigurationemfPackage.Literals.CONFIGURATION__FEATURE);
			childrenFeatures.add(ConfigurationemfPackage.Literals.CONFIGURATION__VIEW);
			childrenFeatures.add(ConfigurationemfPackage.Literals.ROOT_CONF__SUB_CONF);
			childrenFeatures.add(ConfigurationemfPackage.Literals.ROOT_CONF__INCLUDE);
		}
		return childrenFeatures;
	}

	
	
	@Override
	public Collection<?> getChildren(Object object) {
		if(object instanceof RootConf){
			RootConf conf = (RootConf)object;
			if(conf.isReadOnly()) return removeDuplicateFeatures((List<?>)super.getChildren(object));
		}
		return super.getChildren(object);
	}



	private Collection<?> removeDuplicateFeatures(List<?> collection) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object> finalResult = new ArrayList<Object>();
		for(Object child : collection){
			if(child instanceof FeatureImpl){
				Feature fea = (Feature)child;
				Feature temp = (Feature)map.get(fea.getName());
				if(temp==null){
					map.put(fea.getName(), fea);
				}else{
					if(temp instanceof FakeFeature){ // FakeFeature is in the map
						((FakeFeature)temp).addFeature(fea);
					}else{ //not in the map
						FakeFeature fake = new FakeFeature();
						fake.addFeature(fea);
						fake.addFeature(temp);
						
						map.remove(temp);
						
						map.put(fake.getName(), fake);
						
					}
				}
			}else {
				finalResult.add(child);
			}
			
		}
		finalResult.addAll(map.values());
		return finalResult;
	}



	public String getText(Object object) {
		RootConf conf = (RootConf)object;
		if(conf.eIsProxy()){
			return EcoreUtil.getURI(conf).toFileString();
		}else{
			String label = conf.getName();
			return label == null || label.length() == 0 ?
					getString("_UI_No_Name") :label;
		}
	}
	
	@Override
	public Object getImage(Object object) {
		if ( ((EObject)object).eIsProxy()){
			return overlayImage(object, getResourceLocator().getImage("full/obj16/error_tsk"));
		}else{
			return super.getImage(object);
		}
	}

	public RootConfForFeatureView(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}
	
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(RootConf.class)) {
			case ConfigurationemfPackage.ROOT_CONF__INCLUDE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}
	
	class FakeFeature extends FeatureImpl {
		
		private List<Feature> sameNameFeatures = new ArrayList<Feature>();
		
		public void addFeature(Feature fea){
			sameNameFeatures.add(fea);
		}
		

		@Override
		public Configuration getConf() {
			return getFeature().getConf();
		}

		@Override
		public EList<Icon> getIcon() {
			return getFeature().getIcon();
		}

		@Override
		public EList<Link> getLink() {
			return getFeature().getLink();
		}

		@Override
		public String getName() {
			return getFeature().getName();
		}
		private Feature getFeature() {
			return sameNameFeatures.get(0);
		}

		@Override
		public EList<ParentSetting> getParentSetting() {
			EList<ParentSetting> result = new BasicEList<ParentSetting>();
			for(Feature fea : sameNameFeatures){
				result.addAll(fea.getParentSetting());
			}
			return result;
		}

		@Override
		public String getRelevant() {
			return getFeature().getRelevant();
		}

		@Override
		public ParentSetting getSettingByRef(String refSetting) {
			return super.getSettingByRef(refSetting);
		}

		@Override
		public boolean isReadOnly() {
			
			return true;
		}

		@Override
		public String getRef() {
			
			return "<ambiguous>";
		}

		@Override
		public String getDesc() {
			return getFeature().getDesc();
		}

		@Override
		public String getId() {
			return getFeature().getId();
		}
		
	}

}
