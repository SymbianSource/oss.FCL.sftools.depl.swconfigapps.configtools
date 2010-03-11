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

package com.nokia.tools.s60ct.confml.commands;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.util.EList;

import com.nokia.tools.s60ct.model.confml.ConfmlFactory;
import com.nokia.tools.s60ct.model.confml.EExtensionPolicy;
import com.nokia.tools.s60ct.model.confml.EItemSetting;
import com.nokia.tools.s60ct.model.confml.ESequenceSetting;
import com.nokia.tools.s60ct.model.confml.ESequenceValue;
import com.nokia.tools.s60ct.model.confml.ESequenceValueItem;
import com.nokia.tools.variant.confml.core.ConfMLCore;
import com.nokia.tools.vct.common.appmodel.EAppFeature;
import com.nokia.tools.vct.common.appmodel.EConfigurationProject;




public class EmptySequenceCommand extends AbstractCommand {

	private ESequenceSetting sequenceSetting;
	private Object[] oldItems = null;
	private EExtensionPolicy oldPolicy = null;
	private ESequenceValueItem emptyItem;

	public EmptySequenceCommand(ESequenceSetting parentSq, ESequenceValueItem emptyItem) {
		this.sequenceSetting = parentSq;
		this.emptyItem = emptyItem;
		EList<ESequenceValueItem> items = ((ESequenceValue) sequenceSetting.getValue()).getItems();
		
		oldPolicy = ((ESequenceValue) sequenceSetting.getValue()).getExtensionPolicy();
		
		Object[] tempArray = items.toArray();
		
		oldItems = new Object[tempArray.length];
		
		System.arraycopy(tempArray, 0, oldItems, 0, tempArray.length);
		
	}

	public void execute() {
		if (sequenceSetting != null) {
			//sequenceItems.setRemoved(true);
			
			EList<ESequenceValueItem> items = ((ESequenceValue) sequenceSetting.getValue()).getItems();
			
			for (int i = 0 ; i < items.size() ; i++)
			{
				items.get(i).setRemoved(true);
			}
		
			items.add(emptyItem);
			
			((ESequenceValue)sequenceSetting.getValue()).setExtensionPolicy(EExtensionPolicy.REPLACE);
			
			
		}
	}

	public void undo() {
		if (oldItems != null && sequenceSetting != null) {
			
//			EList<ESequenceValueItem> items = ((ESequenceValue)sequenceSetting.getValue()).getItems();
//			if (index >= 0 && index < items.size()) {
//				items.add(index, sequenceItems);
//			} else {
//				items.add(sequenceItems);
//			}
		}
	}

	@Override
	protected boolean prepare() {
		return true;
	}

	public void redo() {
		System.out.println("RemoveSequenceItem redo()");
	}
}
