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
import java.util.Arrays;
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
import cenrep.Key;
import cenrep.Repository;
import cenrep.TYPE;
import cenrep.provider.KeyItemProvider;

public class BitmaskKeyItemProvider extends KeyItemProvider 
	implements ITableItemLabelProvider, CellModifier{

	public static final String PROP_NAME = "name";
	public static final String PROP_TYPE = "type";
	public static final String PROP_UID = "uid";
	public static final String PROP_REF = "ref";
	
	public static final EStructuralFeature NAME_FEATURE = CenrepPackage.eINSTANCE.getKey_Name();
	public static final EStructuralFeature REF_FEATURE = CenrepPackage.eINSTANCE.getRVG_Ref();
	public static final EStructuralFeature UID_FEATURE = CenrepPackage.eINSTANCE.getKey_ShortIdent();
	//public static final EStructuralFeature STR_TYPE_FEATURE = CenrepPackage.eINSTANCE.getKey_StrType();
	public static final EStructuralFeature TYPE_FEATURE = CenrepPackage.eINSTANCE.getKey_Type();

	
	private final EStructuralFeature[] REPOSITORY_CHILDREN= new EStructuralFeature[]{
			CenrepPackage.Literals.REPOSITORY__BITMASK_KEYS
	};
	
	private final EStructuralFeature[] KEY_CHILDREN= new EStructuralFeature[]{
			CenrepPackage.Literals.KEY__BITS
	};
	
	public BitmaskKeyItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	
	@Override
	public Collection getChildrenFeatures(Object object) {
		
		if(object instanceof Repository)
			return Arrays.asList(REPOSITORY_CHILDREN); 
		else if (object instanceof Key)
			return Arrays.asList(KEY_CHILDREN);
		
		return null;
	}

	public Object getColumnImage(Object object, int columnIndex) {
		if(columnIndex==0) return getImage(object);
		return null;
	}

	public String getColumnText(Object object, int columnIndex) {
		Key key = (Key)object;
		switch(columnIndex){
		case 0:
			return key.getName();
		case 1:
			return key.getRef();
		case 2:
			return key.getShortIdent();
		case 3:
			return key.getType().getName();
		}
		return null;
	}
	
	@Override
	public List getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			itemPropertyDescriptors = new ArrayList<IItemPropertyDescriptor>();
			addBackupPropertyDescriptor(object);
			addReadOnlyPropertyDescriptor(object);
			addNamePropertyDescriptor(object);
			addShortIdentPropertyDescriptor(object);
			addTypePropertyDescriptor(object);
			addRefPropertyDescriptor(object);
			
		}
		return itemPropertyDescriptors;
	}

	@Override
	/*
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
		(createItemPropertyDescriptor
			(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
			 getResourceLocator(),
			 getString("_UI_Key_name_feature"),
			 getString("_UI_PropertyDescriptor_description", "_UI_Key_name_feature", "_UI_Key_type"),
			 CenrepPackage.Literals.KEY__NAME,
			 true,
			 false,
			 false,
			 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
			 "UidName",
			 null));
	}
	*/
	
	public boolean canModify(Object element, String property) {
		
			return true;
	}

	public Object getValue(Object element, String property) {
		EObject key = (EObject)element;
		Object result = null;
		if(property.equals(PROP_NAME))
			result = (String) key.eGet(NAME_FEATURE);
		else if(property.equals(PROP_REF))
			result = (String) key.eGet(REF_FEATURE);
		else if(property.equals(PROP_TYPE))
			result = Integer.valueOf(((TYPE)key.eGet(TYPE_FEATURE)).getValue());
		else if(property.equals(PROP_UID))
			result = (String) key.eGet(UID_FEATURE);
		return result!=null?result:"";
	}

	public void modify(Object parent,Object element, String property, Object value) {
		Command command=null;
		EObject eObject=(EObject)element;
		EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(eObject);
		if(property.equals(PROP_NAME)){
			String oldName = (String) eObject.eGet(NAME_FEATURE);
			String newName = (String) value;
			if(oldName==null || !oldName.equals(newName))
				command = SetCommand.create(domain, eObject, NAME_FEATURE, newName);
		}
		else if(property.equals(PROP_REF)){
			String oldRef = (String) eObject.eGet(REF_FEATURE);
			String newRef = (String) value;
			if(oldRef==null || !oldRef.equals(newRef))
				command = SetCommand.create(domain, eObject, REF_FEATURE, newRef);
		}
		else if(property.equals(PROP_UID)){
			String oldUid = (String) eObject.eGet(UID_FEATURE);
			String newUid = (String) value;
			if (newUid.startsWith("0x") || newUid.startsWith("0X"))
				newUid = "0x"+newUid.substring(2).toUpperCase();
			else
				newUid = "0x"+newUid.toUpperCase();
			if(oldUid==null || !oldUid.equals(newUid))
				command = SetCommand.create(domain, eObject, UID_FEATURE, newUid);
		}
		else if(property.equals(PROP_TYPE)){
			TYPE oldType = (TYPE) eObject.eGet(TYPE_FEATURE);
			TYPE newType = TYPE.get(((Integer)value).intValue());
			if(oldType==null || !oldType.equals(newType))
				command = SetCommand.create(domain, eObject, TYPE_FEATURE, newType);
		}
		if(command!=null)
			domain.getCommandStack().execute(command);
		
	}
	public void notifyChanged(Notification notification) {
		switch (notification.getFeatureID(Repository.class)) {
		case CenrepPackage.REPOSITORY__KEY:
			fireNotifyChanged(new ViewerNotification(notification, notification
					.getNotifier(), true, false));
			return;
			
		case CenrepPackage.KEY__BITS:
			fireNotifyChanged(new ViewerNotification(notification, notification
					.getNotifier(), true, false));
			return;
		}
		super.notifyChanged(notification);
	}
	
}
