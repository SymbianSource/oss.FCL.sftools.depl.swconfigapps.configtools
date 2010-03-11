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
package com.nokia.tools.carbide.ct.ui.refactoring.internal.wizards;

import org.eclipse.core.resources.IResource;
import org.eclipse.ltk.ui.refactoring.RefactoringWizard;

import com.nokia.tools.carbide.ct.ui.refactoring.internal.RenameConfmlProcessor;
import com.nokia.tools.carbide.ct.ui.refactoring.internal.RenameConfmlRefactoring;


public class RenameConfmlWizard extends RefactoringWizard {
	public RenameConfmlWizard(RenameConfmlRefactoring refactoring) {
		super(refactoring, DIALOG_BASED_USER_INTERFACE);
	}

	@Override
	protected void addUserInputPages() {
		RenameConfmlRefactoring ref = (RenameConfmlRefactoring) getRefactoring();
		RenameConfmlProcessor processor = (RenameConfmlProcessor) ref.getProcessor();
		IResource res = processor.getResourceToRename();
		RenameConfmlInputPage nameInputPage = new RenameConfmlInputPage( res );
		processor.setNameInputPage(nameInputPage);
	    setDefaultPageTitle( getRefactoring().getName() );
		addPage( nameInputPage );
	}
}
