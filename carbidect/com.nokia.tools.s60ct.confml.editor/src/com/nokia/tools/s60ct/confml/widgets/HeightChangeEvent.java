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
package com.nokia.tools.s60ct.confml.widgets;

import org.eclipse.swt.widgets.Event;

public class HeightChangeEvent extends Event {
	
	private BaseConfMLWidget source;
	private int offset;

	public HeightChangeEvent(BaseConfMLWidget source ,int offset) {
		this.source = source;
		this.offset = offset;
	}

	public BaseConfMLWidget getSource() {
		return source;
	}
	
	public int getOffset() {
		return offset;
	}
//	
//	public BaseConfMLWidget getChanged() {
//		return lastWidget;
//	}

}
