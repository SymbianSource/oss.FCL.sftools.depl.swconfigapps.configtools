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

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Logs accesses to the confml settings via javascript
 *
 */
public class AuditLoggerImpl implements AuditLogger {

	private List<Access> log = new ArrayList<Access>();
	
	public void clearLog() {
		log.clear();
	}

	public boolean isEmpty() {
		return log.isEmpty();
	}

	public List<Access> listChanges() {
		return log;
	}

	public List<ReadAccess> listReadChanges() {
		List<ReadAccess> logReadAccessCopy = new ArrayList<ReadAccess>();
		for (int i = 0 ; i < log.size() ; i++) {
			Access a = log.get(i);
			if (a instanceof ReadAccess) {
				logReadAccessCopy.add((ReadAccess)a);
			}
			
		}
		return logReadAccessCopy;
	}

	public List<WriteAccess> listWriteChanges() {
		List<WriteAccess> logWriteAccessCopy = new ArrayList<WriteAccess>();
		for (int i = 0 ; i < log.size() ; i++) {
			Access a = log.get(i);
			if (a instanceof WriteAccess) {
				logWriteAccessCopy.add((WriteAccess)a);
			}
			
		}
		return logWriteAccessCopy;
	}

	public void log(Access change) {
		log.add(change);
	}

}
