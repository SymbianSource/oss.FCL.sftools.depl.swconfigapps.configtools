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

package s60cenrep.provider;

import java.util.ArrayList;
import java.util.Collection;

import interfaces.CellModifier;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ITableItemLabelProvider;

import views.OptionView;

import cenrep.CenrepPackage;
import cenrep.Value; 
import cenrep.provider.CenrepItemProviderAdapterFactory;
import cenrep.provider.KeyItemProvider;


public class ValueAdapterFactory extends CenrepItemProviderAdapterFactory
		implements IAdapterFactory {

	public ValueAdapterFactory() {
		super();
		supportedTypes.add(ITableItemLabelProvider.class);
		supportedTypes.add(CellModifier.class);
	}

	public Object getAdapter(Object adaptableObject, Class adapterType) {
		return this;
	}

	public Class[] getAdapterList() {
		return supportedTypes.toArray(new Class[supportedTypes.size()]);
	}

	public Adapter createKeyAdapter() {
		if (keyItemProvider == null) {
			keyItemProvider = new KeyItemProvider(this){
				public Collection<? extends EStructuralFeature> getChildrenFeatures(
						Object object) {
					if(childrenFeatures==null){
						childrenFeatures=new ArrayList<EStructuralFeature>();
						childrenFeatures.add(CenrepPackage.eINSTANCE.getKey_Value());
					}
					return childrenFeatures;
				}
			};
		}
		return keyItemProvider;
	}

	public Adapter createValueAdapter() {
		if (valueItemProvider == null) {
			valueItemProvider = new ValueItemProvider(this);
		}
		return valueItemProvider;
	}
	
	private class ValueItemProvider extends cenrep.provider.ValueItemProvider
		implements ITableItemLabelProvider,
				   CellModifier{

		public ValueItemProvider(AdapterFactory adapterFactory) {
			super(adapterFactory);
		}

		public Object getColumnImage(Object element, int column) {
			switch(column){
			case 0:
				return getImage(element);
			}
			return null;
		}

		public String getColumnText(Object element, int column) {
			Value value = (Value)element;
			switch(column){
			case 0:
				return value.getVal();
			case 1:
				return value.getValue();
			}
			return null;
		}
		
		public boolean canModify(Object element, String property) {
			return true;
		}

		public Object getValue(Object element, String property) {
			Value val = (Value)element;
			if(property.equals(OptionView.NAME_PROPERTY))
				return val.getVal()!=null?val.getVal():"";
			else if(property.equals(OptionView.VALUE_PROPERTY))
				return val.getValue()!=null?val.getValue():"";
			return null;
		}

		public void modify(Object parent,Object element, String property, Object value) {
			Value val = (Value)element;
			Command command=null;
			EditingDomain domain=AdapterFactoryEditingDomain.getEditingDomainFor(val);
			if(property.equals(OptionView.NAME_PROPERTY)){
				String currentName = val.getVal();
				if((currentName!=null&&!currentName.equals(value))||(currentName==null&&value!=null))
					command = SetCommand.create(domain, val, CenrepPackage.eINSTANCE.getValue_Val(), value);
			}else if(property.equals(OptionView.VALUE_PROPERTY)){
				String currentValue = val.getValue();
				if((currentValue!=null&&!currentValue.equals(value))||(currentValue==null&&value!=null))
					command = SetCommand.create(domain, val, CenrepPackage.eINSTANCE.getContent_Value(), value);
			}
			if(command!=null)
				domain.getCommandStack().execute(command);
		}
	}
}
