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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

import configurationemf.Configuration;
import configurationemf.Desc;
import configurationemf.Icon;
import configurationemf.Length;
import configurationemf.Link;
import configurationemf.MaxExclusive;
import configurationemf.MaxInclusive;
import configurationemf.MaxLength;
import configurationemf.MinExclusive;
import configurationemf.MinInclusive;
import configurationemf.MinLength;
import configurationemf.Option;
import configurationemf.Pattern;
import configurationemf.Property;
import configurationemf.Ref;
import configurationemf.RootConf;
import configurationemf.Setting;
import configurationemf.TYPE;
import configurationemf.TotalDigits;

public class SettingMock implements Setting {
	
	String ref = null;
	String value = null;
	RootConf rootConf = null;
	
	public SettingMock(String ref, String value,RootConf rootConf){
		this.ref = ref;
		this.value = value;
		this.rootConf=rootConf;
	}
	
	
	public void addSetting(Setting setting) {
		

	}

	
	public String getAbsRef() {
		return ref;
	}

	
	public EList<Option> getBoolOptions() {
		
		return null;
	}

	
	public String getConfValue(Configuration configuration) {
		
		return null;
	}

	
	public String getConstraint() {
		
		return null;
	}

	
	public Configuration getCurrentConf() {
		
		return null;
	}

	
	public String getCurrentType() {
		
		return null;
	}

	
	public String getCurrentValue() {
		
		return null;
	}

	
	public Configuration getDefaultConf() {
		
		return null;
	}

	
	public String getDefaultValue() {
		
		return null;
	}

	
	public String getDesc() {
		
		return null;
	}

	
	public EList<Icon> getIcon() {
		
		return null;
	}

	
	public Length getLength() {
		
		return null;
	}

	
	public EList<Link> getLink() {
		
		return null;
	}

	
	public MaxExclusive getMaxExclusive() {
		
		return null;
	}

	
	public MaxInclusive getMaxInclusive() {
		
		return null;
	}

	
	public MaxLength getMaxLength() {
		
		return null;
	}

	
	public MinExclusive getMinExclusive() {
		
		return null;
	}

	
	public MinInclusive getMinInclusive() {
		
		return null;
	}

	
	public MinLength getMinLength() {
		
		return null;
	}

	
	public String getName() {
		
		return null;
	}

	
	public EList<Option> getOption() {
		
		return null;
	}

	
	public Pattern getPattern() {
		
		return null;
	}

	
	public EList<String> getPossibleValue() {
		
		return null;
	}

	
	public Property getProperty() {
		
		return null;
	}

	
	public String getReadOnly() {
		
		return null;
	}

	
	public String getRelevant() {
		
		return null;
	}

	
	public String getRequired() {
		
		return null;
	}

	
	public String getSystemValue(String userValue) {
		
		return null;
	}

	
	public String getTopValue() {
		return value;
	}

	
	public TotalDigits getTotalDigits() {
		
		return null;
	}

	
	public TYPE getType() {
		
		return null;
	}

	
	public String getUserValue(String systemValue) {
		
		return null;
	}

	
	public boolean isRo() {
		
		return false;
	}

	
	public boolean isValueChangeble() {
		
		return false;
	}

	
	public void removeSetting(Setting setting) {
		

	}

	
	public void setConfValue(String value, Configuration conf) {
		

	}

	
	public void setConstraint(String value) {
		

	}

	
	public void setCurrentType(String value) {
		

	}

	
	public void setCurrentValue(String value) {
		

	}

	
	public void setDesc(Desc value) {
		

	}

	
	public void setLength(Length value) {
		

	}

	
	public void setMaxExclusive(MaxExclusive value) {
		

	}

	
	public void setMaxInclusive(MaxInclusive value) {
		

	}

	
	public void setMaxLength(MaxLength value) {
		

	}

	
	public void setMinExclusive(MinExclusive value) {
		

	}

	
	public void setMinInclusive(MinInclusive value) {
		

	}

	
	public void setMinLength(MinLength value) {
		

	}

	
	public void setName(String value) {
		

	}

	
	public void setPattern(Pattern value) {
		

	}

	
	public void setProperty(Property value) {
		

	}

	
	public void setReadOnly(String value) {
		

	}

	
	public void setRelevant(String value) {
		

	}

	
	public void setRequired(String value) {
		

	}

	
	public void setTotalDigits(TotalDigits value) {
		

	}

	
	public void setType(TYPE value) {
		

	}

	
	public String getRef() {
		
		return null;
	}

	
	public EList<Ref> getRefs() {
		
		return null;
	}

	
	public void setRef(String value) {
		

	}

	
	public String getFirstRelease() {
		
		return null;
	}

	
	public String getLastRelease() {
		
		return null;
	}

	
	public void setFirstRelease(String value) {
		

	}

	
	public void setLastRelease(String value) {
		

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

	
	public String getId() {
		
		return null;
	}

	
	public void setId(String value) {
		

	}


	public Object getGValue() {
		return this.value;
	}


	 
	public boolean isReadOnly() {
		
		return false;
	}


	 
	public boolean isRfs() {
		
		return false;
	}


	 
	public void setConfRfs(boolean rfs, RootConf rootConf) {
		
		
	}


	 
	public void setReadOnly(boolean value) {
		
		
	}


	 
	public void setRfs(boolean value) {
		
		
	}


	 
	public EList<Ref> getRfsRefs() {
		
		return null;
	}


	 
	public void setDesc(String value) {
		
		
	}


	public RootConf getGConf() {
		return rootConf;
	}

}
