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
package com.nokia.tools.carbide.ct.ui.refactoring.internal;

import org.eclipse.ltk.core.refactoring.participants.ProcessorBasedRefactoring;
import org.eclipse.ltk.core.refactoring.participants.RefactoringProcessor;


public class RenameConfmlRefactoring extends ProcessorBasedRefactoring {

  private final RefactoringProcessor processor;

  public RenameConfmlRefactoring( final RefactoringProcessor processor ) {
    super( processor );
    this.processor = processor;
  }

    
  public RefactoringProcessor getProcessor() {
    return processor;
  }
}
