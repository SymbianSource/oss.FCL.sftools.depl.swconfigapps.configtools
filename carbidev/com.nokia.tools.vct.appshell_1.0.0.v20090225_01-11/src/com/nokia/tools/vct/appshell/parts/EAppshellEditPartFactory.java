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
 * Description: This file is part of com.nokia.tools.vct.appshell component.
 */

package com.nokia.tools.vct.appshell.parts;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.ui.IEditorPart;

import com.nokia.tools.variant.common.core.utils.PlatformUtil;
import com.nokia.tools.vct.appshell.appshellmodel.EApplicationElement;
import com.nokia.tools.vct.appshell.appshellmodel.EAppshellDocument;
import com.nokia.tools.vct.appshell.appshellmodel.EFolderElement;
import com.nokia.tools.vct.appshell.appshellmodel.EURLElement;
import com.nokia.tools.vct.appshell.appshellmodel.util.EAppshellModelSwitch;
import com.nokia.tools.vct.appshell.parts.misc.ApplicationIdMap;

public class EAppshellEditPartFactory extends EAppshellModelSwitch<EditPart> implements EditPartFactory {

	IEditorPart editor;
	
	public EAppshellEditPartFactory(IEditorPart editor) {
		this.editor = editor;
	}
	
	public EditPart createEditPart(EditPart context, Object model) {
		if (model == null) {
			return null;
		}
		return doSwitch((EObject)model);
	}

	@Override
	public EditPart caseEApplicationElement(EApplicationElement object) {
		ApplicationIdMap idMap = PlatformUtil.getAdapter(editor, ApplicationIdMap.class, false);
		return new EApplicationElementEditPart(object, idMap);
	}
	@Override
	public EditPart caseEAppshellDocument(EAppshellDocument object) {
		return null;
	}
	@Override
	public EditPart caseEFolderElement(EFolderElement object) {
		return new EFolderElementEditPart(object);
	}
	@Override
	public EditPart caseEURLElement(EURLElement object) {
		return new EURLElementEditPart(object);
	}
	
}
