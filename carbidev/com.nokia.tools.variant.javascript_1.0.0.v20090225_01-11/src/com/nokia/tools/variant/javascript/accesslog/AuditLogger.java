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
 * Description: This file is part of com.nokia.tools.variant.javascript component.
 */

package com.nokia.tools.variant.javascript.accesslog;

import java.util.List;

public interface AuditLogger {
	public void log(Access change);
	public List<Access> listChanges();
	public List<WriteAccess> listWriteChanges();
	public List<ReadAccess> listReadChanges();
	public void clearLog();
	public boolean isEmpty();
}
