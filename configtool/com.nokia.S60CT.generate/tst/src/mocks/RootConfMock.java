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
package mocks;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

import configurationemf.Data;
import configurationemf.Desc;
import configurationemf.Feature;
import configurationemf.Icon;
import configurationemf.Link;
import configurationemf.Meta;
import configurationemf.Ref;
import configurationemf.Releases;
import configurationemf.Rfs;
import configurationemf.RootConf;
import configurationemf.Setting;
import configurationemf.SubConf;
import configurationemf.View;

public class RootConfMock implements RootConf {
	 
	public int getLevel() {
		return level;
	}



	public Feature getFeatureByRef(String refFeature) {
		return null;
	}


	 
	public Rfs getRfs() {
		return null;
	}


	 
	public void setRfs(Rfs value) {
		
	}


	 
	public void setDesc(String value) {
		
	}


	 
	public String getCustomer() {
		
		return null;
	}


	 
	public String getDate() {
		
		return null;
	}


	 
	public String getEditor() {
		
		return null;
	}


	 
	public String getMetaId() {
		
		return null;
	}


	 
	public String getOwner() {
		
		return null;
	}


	 
	public String getPlatform() {
		
		return null;
	}


	 
	public String getProduct() {
		
		return null;
	}


	 
	public String getRelease() {
		
		return null;
	}


	 
	public String getStatus() {
		
		return null;
	}


	 
	public String getVersion() {
		
		return null;
	}


	 
	public void setCustomer(String value) {
		
		
	}


	 
	public void setDate(String value) {
		
		
	}


	 
	public void setEditor(String value) {
		
		
	}


	 
	public void setMetaId(String value) {
		
		
	}


	 
	public void setOwner(String value) {
		
		
	}


	 
	public void setPlatform(String value) {
		
		
	}


	 
	public void setProduct(String value) {
		
		
	}


	 
	public void setRelease(String value) {
		
		
	}


	 
	public void setStatus(String value) {
		
		
	}


	 
	public void setVersion(String value) {
		
		
	}


	EList<Setting> result = new BasicEList<Setting>();
	public RootConfMock() {
		
	}

	RootConf root = null;
	int level=0;
	
	public RootConfMock(RootConf root,int level) {
		this.root=root;
		this.root.getInclude().add(this);
		this.level=level;
	}
	String name=null;
	
	public RootConfMock(String name) {
		this.name=name;
	}
	
	public RootConfMock(String name,RootConf root,int level) {
		this.name=name;
		this.root=root;
		this.root.getInclude().add(this);
		this.level=level;
	}
	
	public EList<Setting> getAllSettings() {
		return result;
	}

	
	public EList<Feature> getFeatureRepository() {
		
		return null;
	}

	
	EList<RootConf> include = new BasicEList<RootConf>();
	public EList<RootConf> getInclude() {
		return include;
	}

	
	public EList<Ref> getRefRepository() {
		
		return null;
	}

	
	public RootConf getRoot() {
		
		return null;
	}

	
	public EList<SubConf> getSubConf() {
		
		return null;
	}

	
	public void setRoot(RootConf value) {
		

	}

	
	public Data getData() {
		
		return null;
	}

	
	public String getDesc() {
		
		return null;
	}

	
	public EList<Feature> getFeature() {
		
		return null;
	}

	
	public EList<Icon> getIcon() {
		
		return null;
	}

	
	public EList<Link> getLink() {
		
		return null;
	}

	
	public Meta getMeta() {
		
		return null;
	}

	
	public String getName() {
		return name;
	}

	
	public EList<Releases> getReleases() {
		
		return null;
	}

	
	public String getVers() {
		
		return null;
	}

	
	public EList<View> getView() {
		
		return null;
	}

	
	public boolean isReadOnly() {
		
		return false;
	}

	
	public void setData(Data value) {
		

	}

	
	public void setDesc(Desc value) {
		

	}

	
	public void setMeta(Meta value) {
		

	}

	
	public void setName(String value) {
		

	}

	
	public void setVers(String value) {
		

	}

	
	public String getId() {
		
		return null;
	}

	
	public void setId(String value) {
		

	}

	
	public TreeIterator<EObject> eAllContents() {
		
		return null;
	}

	
	public EClass eClass() {
		
		return null;
	}

	
	public EObject eContainer() {
		
		return null;
	}

	
	public EStructuralFeature eContainingFeature() {
		
		return null;
	}

	
	public EReference eContainmentFeature() {
		
		return null;
	}

	
	public EList<EObject> eContents() {
		
		return null;
	}

	
	public EList<EObject> eCrossReferences() {
		
		return null;
	}

	
	public Object eGet(EStructuralFeature feature) {

		return null;
	}

	
	public Object eGet(EStructuralFeature feature, boolean resolve) {
		return null;
	}

	
	public boolean eIsProxy() {
		return false;
	}

	
	public boolean eIsSet(EStructuralFeature feature) {
		return false;
	}

	
	public Resource eResource() {
		return null;
	}

	
	public void eSet(EStructuralFeature feature, Object newValue) {

	}

	
	public void eUnset(EStructuralFeature feature) {

	}

	
	public EList<Adapter> eAdapters() {
		return null;
	}

	
	public boolean eDeliver() {
		return false;
	}

	
	public void eNotify(Notification notification) {

	}

	
	public void eSetDeliver(boolean deliver) {

	}



	@Override
	public View getViewById(String viewId) {
		return null;
	}



	@Override
	public View getViewByName(String viewName) {
		return null;
	}

}
