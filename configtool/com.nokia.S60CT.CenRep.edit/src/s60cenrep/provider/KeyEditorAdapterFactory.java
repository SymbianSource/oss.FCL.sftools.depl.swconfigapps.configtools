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

import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.edit.provider.ITableItemLabelProvider;

import cenrep.CenrepPackage;
import cenrep.provider.CenrepItemProviderAdapterFactory;
import cenrep.provider.ICellEditorProvider;
import cenrep.provider.KeyItemProvider;
import cenrep.provider.ValueItemProvider;

public class KeyEditorAdapterFactory extends
		CenrepItemProviderAdapterFactory {
	
	

	public KeyEditorAdapterFactory() {
		super();
		supportedTypes.add(ITableItemLabelProvider.class);
		supportedTypes.add(ICellEditorProvider.class);
	}
	
	public Adapter createKeyAdapter() {
		if (keyItemProvider == null) {
			keyItemProvider = new KeyItemProvider(this){
				public Collection getChildrenFeatures(Object object) {
					if (childrenFeatures == null) {
						super.getChildrenFeatures(object);
						childrenFeatures.remove(CenrepPackage.Literals.IACCESSABLE__ACCESS);
						childrenFeatures.remove(CenrepPackage.Literals.KEY__VALUE);
						childrenFeatures.add(CenrepPackage.Literals.KEY__BITS);
					}
					return childrenFeatures;
				}
			};
		}
		return keyItemProvider;
	}
		
	public Adapter createValueAdapter() {
		if (valueItemProvider == null) {
			valueItemProvider = new ValueItemProvider(this){
				public String getColumnText(Object element, int column) {
//					if(element.equals(ZERO_VALUE))return "";
//					Value value = (Value)element;
//					switch(column){
//					case 0:
//						return value.getRef();
//					}
					return null;
				}
				
			};
		}
		return valueItemProvider;
	}

//	public Adapter createBitFlagAdapter() {
//		if(bitFlagItemProvider == null){
//			bitFlagItemProvider = new BitFlagItemProvider(this){
//				protected Collection getChildrenFeatures(Object object) {
//					if(childrenFeatures==null){
//						super.getChildrenFeatures(object);
//						childrenFeatures.remove(CenrepPackage.Literals.BIT_FLAG__VALUES);
//					}
//					return childrenFeatures;
//				}
//				
//			};
//		}
//		return super.createBitFlagAdapter();
//	}

	
	
}
