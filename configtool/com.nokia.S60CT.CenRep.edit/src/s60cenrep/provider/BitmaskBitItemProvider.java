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

import interfaces.CellModifier;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ITableItemLabelProvider;
import org.eclipse.emf.edit.provider.ViewerNotification;

import cenrep.CenrepPackage;
import cenrep.Repository;
import cenrep.provider.BitItemProvider;

public class BitmaskBitItemProvider extends BitItemProvider 
	implements ITableItemLabelProvider, CellModifier{

	public static final String PROP_REF = "ref";
	
	private static final EStructuralFeature BIT_NUMBER = CenrepPackage.eINSTANCE.getBit_Number();
	private static final EStructuralFeature BIT_REF = CenrepPackage.eINSTANCE.getRVG_Ref();
	private static final EStructuralFeature BIT_STATE = CenrepPackage.eINSTANCE.getBit_State();
	
	public BitmaskBitItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	protected Collection getChildrenFeatures(Object object) {
		if(childrenFeatures==null){
			childrenFeatures = new ArrayList<EStructuralFeature>();
		}
		return childrenFeatures;
	}

	public Object getColumnImage(Object object, int columnIndex) {
		
		if (columnIndex == 0)
		{
			EObject eObject = (EObject)object;
			Boolean state = (Boolean)eObject.eGet(BIT_STATE);
			if (state.booleanValue())
				return overlayImage(object, getResourceLocator().getImage("full/obj16/1bit"));
			else
				return overlayImage(object, getResourceLocator().getImage("full/obj16/0bit"));
		}
		else
			return null;
		
		
	}

	public String getColumnText(Object object, int columnIndex) {
		EObject eObject = (EObject)object;
		switch (columnIndex) {
		case 0:
			return "bit "+String.valueOf((Integer)eObject.eGet(BIT_NUMBER));
		case 1:	
			return (String)eObject.eGet(BIT_REF);
		}
		return "";
	}

	@Override
	public List getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			itemPropertyDescriptors = new ArrayList<IItemPropertyDescriptor>();
			addRefPropertyDescriptor(object);
			addStatePropertyDescriptor(object);
			addNumberPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}
	
	public void notifyChanged(Notification notification) {
		switch (notification.getFeatureID(Repository.class)) {
		case CenrepPackage.KEY__BITS:
			fireNotifyChanged(new ViewerNotification(notification, notification
					.getNotifier(), true, false));
			return;
		}
		super.notifyChanged(notification);
	}

	public boolean canModify(Object element, String property)
	{
		if (property.equals(PROP_REF))
			return true;
		else
			return false;
	}

	public Object getValue(Object element, String property)
	{
		EObject eObject = (EObject) element;
		String result = null;
		if (property.equals(PROP_REF))
			result = (String) eObject.eGet(BIT_REF);
		return result != null ? result : "";
	}

	public void modify(Object parent, Object element, String property,
			Object value)
	{
		EObject object = (EObject) element;
		EditingDomain domain = AdapterFactoryEditingDomain
				.getEditingDomainFor(object);
		Command command = null;
		
		if (property.equals(PROP_REF)) {
			String oldRef = (String) object.eGet(BIT_REF);
			String newRef = (String) value;
			if (oldRef != newRef) {
				command = SetCommand.create(domain, object, BIT_REF, newRef);
			}
		}
		if (command != null)
			domain.getCommandStack().execute(command);
		
	}

}
