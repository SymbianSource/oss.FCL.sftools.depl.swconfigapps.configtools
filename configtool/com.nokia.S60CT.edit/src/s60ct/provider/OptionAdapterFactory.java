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

import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ITableItemLabelProvider;
import org.eclipse.emf.edit.provider.ViewerNotification;

import views.OptionView;
import configurationemf.ConfigurationemfFactory;
import configurationemf.ConfigurationemfPackage;
import configurationemf.Frame;
import configurationemf.LeafSettingDelegator;
import configurationemf.Option;
import configurationemf.Setting;
import configurationemf.TYPE;
import configurationemf.provider.ConfigurationemfItemProviderAdapterFactory;
import configurationemf.provider.LeafSettingDelegatorItemProvider;
import configurationemf.provider.ParentSettingItemProvider;

public class OptionAdapterFactory extends ConfigurationemfItemProviderAdapterFactory
	implements IAdapterFactory{
	
	private Setting selectedSetting = null;
	private static final Option EMPTY_OPTION = ConfigurationemfFactory.eINSTANCE.createOption();
	
	public OptionAdapterFactory(){
		super();
		supportedTypes.add(ITableItemLabelProvider.class);
		supportedTypes.add(CellModifier.class);
		EMPTY_OPTION.setName("<Add new option>");
	}

	public Adapter createLeafSettingDelegatorAdapter() {
		if (leafSettingDelegatorItemProvider == null) {
			leafSettingDelegatorItemProvider = new LeafSettingDelegatorItemProvider(this){
				public Collection getChildrenFeatures(Object object) {
					super.getChildrenFeatures(object);
					childrenFeatures.clear();
					childrenFeatures.add(ConfigurationemfPackage.Literals.SETTING__OPTION);
					childrenFeatures.add(ConfigurationemfPackage.Literals.SETTING__BOOL_OPTIONS);
					return childrenFeatures;
				}
				
				public Collection<?> getChildren(Object object) {
					List elements = (List) super.getChildren(object);
					LeafSettingDelegator lsd = (LeafSettingDelegator)object;
					selectedSetting = lsd.getLeafSetting();
					if(!selectedSetting.isRo() && selectedSetting.getType()!=TYPE.BOOLEAN && ((Frame)lsd.eContainer()).isTemplate())//empty option only for sequence setting template
					{
						elements.add(EMPTY_OPTION);
						
					}
					return elements;
				}

				@Override
				public void notifyChanged(Notification notification)
				{
					switch (notification.getFeatureID(LeafSettingDelegator.class)) {
					case ConfigurationemfPackage.LEAF_SETTING_DELEGATOR__VALUE:
					case ConfigurationemfPackage.LEAF_SETTING_DELEGATOR__TYPE:
					case ConfigurationemfPackage.LEAF_SETTING_DELEGATOR__NAME:
						fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
						return;
					case ConfigurationemfPackage.SETTING__OPTION:
						fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
						return;
				}
					super.notifyChanged(notification);
				}
				
				
			};
		}

		return leafSettingDelegatorItemProvider;
	}



	public Adapter createParentSettingAdapter() {
		if (parentSettingItemProvider == null) {
			parentSettingItemProvider = new ParentSettingItemProvider(this){
				public Collection getChildrenFeatures(Object object) {
					super.getChildrenFeatures(object);
					childrenFeatures.clear();
					childrenFeatures.add(ConfigurationemfPackage.Literals.SETTING__OPTION);
					childrenFeatures.add(ConfigurationemfPackage.Literals.SETTING__BOOL_OPTIONS);
					return childrenFeatures;
				}

				public Collection<?> getChildren(Object object) {
					List elements = (List) super.getChildren(object);
					Setting setting = (Setting)object;
					selectedSetting = setting;
					if(!setting.isRo() && selectedSetting.getType()!=TYPE.BOOLEAN && setting.getType().getValue() != TYPE.SEQUENCE.getValue())
					{
						elements.add(EMPTY_OPTION);
						
					}
					return elements;
				}
				
			};
		}
		return parentSettingItemProvider;
	}

	public Adapter createOptionAdapter() {
		if(optionItemProvider ==null){
			optionItemProvider = new OptionItemProvider(this);
		}
		return optionItemProvider;
	}
	
	public Class[] getAdapterList() {
		return supportedTypes.toArray(new Class[supportedTypes.size()]);
	}

	public Object getAdapter(Object adaptableObject, Class adapterType) {
		return this;
	}
	
	private class OptionItemProvider extends configurationemf.provider.OptionItemProvider
		implements ITableItemLabelProvider, CellModifier{
		
		private static final String EMPTY_VALUE = "";
		
		public OptionItemProvider(AdapterFactory adapterFactory) {
			super(adapterFactory);
		}
		
		public String getColumnText(Object object, int columnIndex) {
			Option optionObj = (Option)object;
			switch(columnIndex){
			case 0://Option's name 
				return optionObj.getName();
			case 1://option's Value
				return optionObj.getValue()==null?"":optionObj.getValue();
			}
			return null;
		}
		
		public Object getColumnImage(Object object, int columnIndex) {
			if(columnIndex==0){
				return getImage(object);
			}
			return null;
		}
		
		public boolean canModify(Object element, String property) {
			Option op = (Option)element;
			return !op.isReadOnly();
		}
		
		public Object getValue(Object element, String property) {
			Option op = (Option)element;
			if(property.compareTo(OptionView.NAME_PROPERTY)==0)return op.getName()!=null?op.getName():EMPTY_VALUE;
			else if(property.compareTo(OptionView.VALUE_PROPERTY)==0)return op.getValue()!=null?op.getValue():EMPTY_VALUE;
			else return null;
		}
		
		public void modify(Object parent,Object element, String property, Object value) {
			
			if(element.equals(EMPTY_OPTION)&&property.compareTo(OptionView.NAME_PROPERTY)==0&&value!=null)
				addNewObject(parent,element, property, value);
			else if(!element.equals(EMPTY_OPTION))
				setAttributeValue(element, property, value);
		}
		
		
		protected void addNewObject(Object parent,Object element, String property, Object value){
			
			EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(selectedSetting);
			Option newOption = ConfigurationemfFactory.eINSTANCE.createOption();
			String sValue = (String)value;
			
			if (sValue.equals(EMPTY_OPTION.getName()))
				return; //not changed.
			
			newOption.setName(sValue);
			
			int defautOptionValue = findAvailableInteger();
			
			if (defautOptionValue != -1)
				newOption.setValue(""+defautOptionValue);

			Command command = AddCommand.create(domain,selectedSetting,ConfigurationemfPackage.eINSTANCE.getSetting_Option(),newOption);

			if(command!=null)
					domain.getCommandStack().execute(command);
		}
	
		protected void setAttributeValue(Object element, String property,Object value) {
			EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(element);
			EAttribute attr = null;
			if(property.compareTo(OptionView.NAME_PROPERTY)==0) //modify option name
			{
				attr = (EAttribute)ConfigurationemfPackage.eINSTANCE.getOption_Name();
			}
			else if(property.compareTo(OptionView.VALUE_PROPERTY)==0) //modify option value
			{
				attr = (EAttribute)ConfigurationemfPackage.eINSTANCE.getOption_Value();
			}
			Object oldValue = ((EObject)element).eGet(attr);
			if(oldValue==null||!oldValue.equals(value)){
				Command command = SetCommand.create(domain, element, attr, value);
				if(command!=null)
					domain.getCommandStack().execute(command);
			}
		}

		private int findAvailableInteger()
		{
			int newValue = 0;
			Object[] optionArray = selectedSetting.getOption().toArray();
			boolean found = false;
			
			try
			{
				do
				{
					found = true;
					for (int i = 0 ; i < optionArray.length ; i++)
					{
						String sValue = ((Option)optionArray[i]).getValue();
						if (sValue != null && !sValue.equals(""))
						{
							int iValue = (new Integer(sValue)).intValue();
							if (iValue == newValue)
							{
								newValue++;
								found = false;
							}
						}
					}
				}while (!found);
				
				return newValue;
			}
			catch (NumberFormatException nfe)
			{
				return -1;
			}
		}
		
		
	
				
	}
	
	
	
}
