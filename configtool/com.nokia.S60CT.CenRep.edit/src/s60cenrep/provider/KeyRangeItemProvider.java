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
import cenrep.KeyRange;
import cenrep.Repository;

public class KeyRangeItemProvider extends cenrep.provider.KeyRangeItemProvider
		implements ITableItemLabelProvider, CellModifier {

	public static final String PROP_NAME = "name";
	public static final String PROP_REF = "ref";
	public static final String PROP_FIRSTINT = "firstInt";
	public static final String PROP_LASTINT = "lastInt";

	//public static final EStructuralFeature FIRST_IDENT = CenrepPackage.eINSTANCE.getKeyRange_FirstInt();
	//public static final EStructuralFeature LAST_IDENT = CenrepPackage.eINSTANCE.getKeyRange_LastInt();
	
	public static final EStructuralFeature NAME_FEATURE = CenrepPackage.eINSTANCE.getKeyRange_Name();
	public static final EStructuralFeature REF_FEATURE = CenrepPackage.eINSTANCE.getRVG_Ref();
	public static final EStructuralFeature FIRSTINT_FEATURE = CenrepPackage.eINSTANCE.getKeyRange_FirstInt();
	public static final EStructuralFeature LASTINT_FEATURE = CenrepPackage.eINSTANCE.getKeyRange_LastInt();

	private final EStructuralFeature[] REPOSITORY_CHILDREN = new EStructuralFeature[] { CenrepPackage.Literals.REPOSITORY__RANGE_KEY };
	private final EStructuralFeature[] RANGE_CHILDREN = new EStructuralFeature[] { CenrepPackage.Literals.KEY_RANGE__KEYS };

//	private static Key emptyKey = CenrepFactory.eINSTANCE.createKey();
	
	public KeyRangeItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
//		emptyKey.setName("<Add new key>");
	}

	@Override
	public Collection<EStructuralFeature> getChildrenFeatures(Object object) {
		if (object instanceof Repository)
			return Arrays.asList(REPOSITORY_CHILDREN);
		else if (object instanceof KeyRange)
			return Arrays.asList(RANGE_CHILDREN);
		return null;
	}

	@Override
	public Collection<Key> getChildren(Object object) {
		Collection<Key> children = (Collection<Key>) super.getChildren(object);
//		if (object instanceof KeyRange) children.add(emptyKey);
		return children;
	}
	
	public Object getColumnImage(Object object, int columnIndex) {
		if (columnIndex == 0)
			return getImage(object);
		return null;
	}

	public String getColumnText(Object object, int columnIndex) {
		EObject eObject = (EObject) object;
		switch (columnIndex) {
		case 0:
			return (String) eObject.eGet(NAME_FEATURE);
		case 1:
			return (String) eObject.eGet(REF_FEATURE);
		case 2:
			return null;
		case 3:
			return null;
		case 4:
			return (String) eObject.eGet(FIRSTINT_FEATURE);
		case 5:
			return (String) eObject.eGet(LASTINT_FEATURE);
		}
		return null;
	}

	public boolean canModify(Object element, String property) {
		if (property.equals(PROP_NAME) || property.equals(PROP_REF) || property.equals(PROP_FIRSTINT) || property.equals(PROP_LASTINT))
			return true;
		else 
			return false;
	}

	public Object getValue(Object element, String property) {
		EObject eObject = (EObject) element;
		String result = null;
		if (property.equals(PROP_NAME))
			result = (String) eObject.eGet(NAME_FEATURE);
		else if (property.equals(PROP_REF))
			result = (String) eObject.eGet(REF_FEATURE);
		else if(property.equals(PROP_FIRSTINT))
			result = (String) eObject.eGet(FIRSTINT_FEATURE);
		else if(property.equals(PROP_LASTINT))
			result = (String) eObject.eGet(LASTINT_FEATURE);
		return result != null ? result : "";
	}

	public void modify(Object parent, Object element, String property,
			Object value) {
		EObject object = (EObject) element;
		EditingDomain domain = AdapterFactoryEditingDomain
				.getEditingDomainFor(object);
		Command command = null;
		if (property.equals(PROP_NAME)) {
			String oldValue = (String) object.eGet(NAME_FEATURE);
			String newValue = (String) value;
			if (newValue != oldValue) 
				command = SetCommand.create(domain, object, NAME_FEATURE, value);
		} else if (property.equals(PROP_REF)) {
			String oldRef = (String) object.eGet(REF_FEATURE);
			String newRef = (String) value;
			if (oldRef != newRef) {
				command = SetCommand.create(domain, object, REF_FEATURE, newRef);
			}
		} else if (property.equals(PROP_FIRSTINT)) {
			String oldFI = (String) object.eGet(FIRSTINT_FEATURE);
			String newFI = (String) value;
			if (newFI.startsWith("0x") || newFI.startsWith("0X"))
				newFI = "0x"+newFI.substring(2).toUpperCase();
			else
				newFI = "0x"+newFI.toUpperCase();
			if (oldFI != newFI) {
				command = SetCommand.create(domain, object, FIRSTINT_FEATURE, newFI);
			}
		} else if (property.equals(PROP_LASTINT)) {
			String oldLI = (String) object.eGet(LASTINT_FEATURE);
			String newLI = (String) value;
			if (newLI.startsWith("0x") || newLI.startsWith("0X"))
				newLI = "0x"+newLI.substring(2).toUpperCase();
			else
				newLI = "0x"+newLI.toUpperCase();
			if (oldLI != newLI) {
				command = SetCommand.create(domain, object, LASTINT_FEATURE, newLI);
			}
		}
		if (command != null)
			domain.getCommandStack().execute(command);
	}

	@Override
	public List getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			itemPropertyDescriptors = new ArrayList<IItemPropertyDescriptor>();
			addBackupPropertyDescriptor(object);
			addReadOnlyPropertyDescriptor(object);
			addRefPropertyDescriptor(object);
			addNamePropertyDescriptor(object);
			addFirstIntPropertyDescriptor(object);
			addLastIntPropertyDescriptor(object);
			addIntPropertyDescriptor(object);
			addIndexBitsPropertyDescriptor(object);
			addCountIntPropertyDescriptor(object);
			addFirstIndexPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	public void notifyChanged(Notification notification) {
		switch (notification.getFeatureID(Repository.class)) {
			case CenrepPackage.REPOSITORY__RANGE_KEY:
			case CenrepPackage.KEY_RANGE__KEYS:
				fireNotifyChanged(new ViewerNotification(notification, notification
						.getNotifier(), true, false));
				return;	
			case CenrepPackage.KEY_RANGE__NAME:
			case CenrepPackage.KEY_RANGE__REF:
				fireNotifyChanged(new ViewerNotification(notification, notification
						.getNotifier(), false, true));
				return;	
		}
		super.notifyChanged(notification);
	}
}
