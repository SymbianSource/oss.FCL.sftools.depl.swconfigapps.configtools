/*
 * Copyright (c) 2009 Nokia Corporation and/or its subsidiary(-ies).
 * All rights reserved.
 * This component and the accompanying materials are made available
 * under the terms of "Eclipse Public License v1.0"
 * which accompanies this distribution, and is available
 * at the URL "http://www.eclipse.org/legal/epl-v10.html".
 * 
 * Initial Contributors:
 * Nokia Corporation - Initial contribution
 * 
 * Contributors:
 * 
 * Description: This file is part of com.nokia.tools.vct.confml.editor.view component.
 */

package com.nokia.tools.vct.confml.editor.view.commands;

import org.eclipse.jface.viewers.TreeViewer;

import com.nokia.tools.vct.confml.editor.view.vemodel.EGroup;
import com.nokia.tools.vct.confml.editor.view.vemodel.EViewEditorPackage;

public class SetGroupNameCommand extends SetFeatureCommand {
	
	public SetGroupNameCommand(TreeViewer viewer, EGroup ref, String newValue) {
		super(ref, EViewEditorPackage.Literals.EGROUP_ENTRY__NAME, newValue);
	}
}
