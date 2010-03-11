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

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ViewerNotification;
import command.DeleteLSDSetting;

import configurationemf.ConfigurationemfFactory;
import configurationemf.ConfigurationemfPackage;
import configurationemf.Frame;
import configurationemf.LeafSetting;
import configurationemf.LeafSettingDelegator;
import configurationemf.TYPE;

public class LSDelegateItemProvider extends ParentSettingForFeatureView 
	{
	
	static final TYPE[] POSSIBLE_TYPES = new TYPE[]{
		TYPE.BOOLEAN,
		TYPE.FILE,
		TYPE.FOLDER,
		TYPE.INT,
		TYPE.SELECTION,
//		TYPE.SEQUENCE,
		TYPE.STRING
	};
	
	public LSDelegateItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	public Collection<? extends EStructuralFeature> getChildrenFeatures(
			Object object) {
		if(childrenFeatures==null){
			childrenFeatures = new ArrayList<EStructuralFeature>();
		}
		return childrenFeatures;
	}
	
	@Override
	public Object getColumnImage(Object object, int columnIndex) {
		if(object.equals(FrameItemProvider.EMPTY_DELEGATOR))return null;
		if(columnIndex==0)return getImage(object);
		return null;
	}

	@Override
	public String getColumnText(Object object, int columnIndex) {
		if(object.equals(FrameItemProvider.EMPTY_DELEGATOR))
		{
			if(columnIndex==0)
				return "     <Add new setting>";
			else 
				return "";
		}
		return super.getColumnText(object, columnIndex);
	}

	public boolean canModify(Object element, String property) {
		if(element.equals(getZeroObject())){
			if(property.compareTo(PROP_NAME)==0)return true;
			return false;
		}
		LeafSettingDelegator delegator = (LeafSettingDelegator)element;
		if(property.compareTo(ParentSettingForFeatureView.PROP_VALUE)==0){
			return delegator.canModifyValue();
		}else{
			return delegator.canModifyAttribute();
		}
	}
	
	@Override
	protected TYPE[] getPossibleTypes() {
		return POSSIBLE_TYPES;
	}

	protected Object getZeroObject(){
		return FrameItemProvider.EMPTY_DELEGATOR;
	}
	
	
	protected Object getConfmlObject(Object object){
		LeafSettingDelegator delegator = (LeafSettingDelegator)object;
		return delegator.getLeafSetting();
	}
	
	@Override
	public Command createCommand(Object object, EditingDomain domain,
			Class<? extends Command> commandClass,
			CommandParameter commandParameter)
	{
		if (commandClass.equals(DeleteLSDSetting.class))
			return  new DeleteLSDSetting(domain,commandParameter.getEOwner(), commandParameter.getValue());
		else
			return super.createCommand(object, domain, commandClass, commandParameter);
	}

	public void modify(Object parent,Object element, String property, Object value)
	{
		if (parent!=null && ((Frame)parent).getRef()!= null && ((Frame)parent).getRef().getName()!=null)
			super.modify(parent, element, property, value);
	}
	
	protected void addNewObject(Object parent,Object object, String property, Object value ){
		Frame frame = (Frame)parent;
		LeafSetting leafSetting = ConfigurationemfFactory.eINSTANCE.createLeafSetting();
		String sValue = (String)value;
		leafSetting.setName(sValue);
		leafSetting.setRef(sValue.replaceAll(" ", ""));
		frame.addLeafSetting(leafSetting);
	}
	public void notifyChanged(Notification notification) {
		switch(notification.getFeatureID(LeafSettingDelegator.class)){
		case ConfigurationemfPackage.LEAF_SETTING_DELEGATOR__VALUE:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
			return;
		case ConfigurationemfPackage.LEAF_SETTING__NAME:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
			return;
		}
		super.notifyChanged(notification);
	}
}
