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

import interfaces.CellModifier;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ITableItemLabelProvider;

import configurationemf.ConfigurationemfFactory;
import configurationemf.ConfigurationemfPackage;
import configurationemf.Frame;
import configurationemf.LeafSettingDelegator;

public class FrameItemProvider extends
		configurationemf.provider.FrameItemProvider 
		implements 
		ITableItemLabelProvider,
		CellModifier{

	public static final LeafSettingDelegator EMPTY_DELEGATOR = ConfigurationemfFactory.eINSTANCE.createLeafSettingDelegator(); //for Template
	
	public FrameItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(
			Object object) {
		if(childrenFeatures==null){
			childrenFeatures = new ArrayList<EStructuralFeature>();
			childrenFeatures.add(ConfigurationemfPackage.Literals.FRAME__LEAF_SETTINGS);
		}
		return childrenFeatures;
	}

	
	@Override
	public Collection<?> getChildren(Object object) {
		List elements = (List) super.getChildren(object);
		Frame frame =(Frame)object; 
		if(frame.isTemplate()&&frame.isMyFrame()){
			elements.add(EMPTY_DELEGATOR);
		}
		return elements;
	}

	public Object getColumnImage(Object object, int columnIndex) {
		if(columnIndex==0)return getImage(object);
		return null;
	}

	public String getColumnText(Object object, int columnIndex) {
		Frame frame = (Frame)object;
		if(columnIndex==0){
			if(frame.isTemplate())return "Template";
			else {
				int number = frame.getNumber();
				if(number>=0)
					return String.valueOf(number)+" ("+frame.getConfName()+")";
				else return String.valueOf(number);
			}
		}
		return "";
	}
	
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			itemPropertyDescriptors = new ArrayList<IItemPropertyDescriptor>();
		}
		return itemPropertyDescriptors;
	}

	public boolean canModify(Object element, String property) {
		return false;
	}

	public Object getValue(Object element, String property) {
		return null;
	}

	public void modify(Object parent,Object element, String property, Object value) {
	}
	
	
}
