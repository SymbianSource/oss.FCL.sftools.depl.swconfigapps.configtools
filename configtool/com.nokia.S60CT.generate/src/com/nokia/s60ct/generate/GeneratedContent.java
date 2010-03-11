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
package com.nokia.s60ct.generate;

import java.util.HashMap;
import java.util.Map;

public class GeneratedContent {

	private Map<String, String> contents = new HashMap<String, String>();
	private Map<String, String> comments = new HashMap<String, String>();
	private Map<String, String> targets = new HashMap<String, String>();
	private Map<String, String> encodings = new HashMap<String, String>();
	
	/**
	 * @param file File name
	 * @param content Content of the file
	 */
	public void put(String file, String content) {
		contents.put(file, content);
	}

	/**
	 * @param file File name
	 * @param comment Comment
	 */
	public void addComment(String file, String comment) {
		comments.put(file, comment);
	}
	
	/**
	 * @param file File name
	 * @param target Target
	 */
	public void addTarget(String file, String target) {
		targets.put(file, target);
	}
	
	/**
	 * @param file File name
	 * @param encoding Encoding
	 */
	public void addEncoding(String file, String encoding) {
		encodings.put(file, encoding);
	}

	/**
	 * @return Contents Map
	 */
	public Map<String, String> getContents() {
		return contents;
	}

	/**
	 * @return Targets Map
	 */
	public Map<String, String> getTargets() {
		return targets;
	}

	/**
	 * @return Comments Map
	 */
	public Map<String, String> getComments() {
		return comments;
	}
	
	/**
	 * @return Encodings Map
	 */
	public Map<String, String> getEncodings() {
		return encodings;
	}
}
