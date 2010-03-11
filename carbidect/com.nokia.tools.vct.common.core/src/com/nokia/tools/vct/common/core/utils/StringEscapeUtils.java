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

package com.nokia.tools.vct.common.core.utils;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

public class StringEscapeUtils
{
    public static String escapeJava(String str) {
	return escapeJavaStyleString(str, false);
    }
    
    public static void escapeJava(Writer out, String str) throws IOException {
	escapeJavaStyleString(out, str, false);
    }

    private static String escapeJavaStyleString(String str,
						boolean escapeSingleQuotes) {
	if (str == null)
	    return null;
	try {
	    StringWriter writer = new StringWriter(str.length() * 2);
	    escapeJavaStyleString(writer, str, escapeSingleQuotes);
	    return writer.toString();
	} catch (IOException ioe) {
	    ioe.printStackTrace();
	    return null;
	}
    }
    
    private static void escapeJavaStyleString
	(Writer out, String str, boolean escapeSingleQuote)
	throws IOException {
	if (out == null)
	    throw new IllegalArgumentException("The Writer must not be null");
	if (str != null) {
	    int sz = str.length();
	    for (int i = 0; i < sz; i++) {
		char ch = str.charAt(i);
		if (ch > '\u0fff')
		    out.write("\\u" + hex(ch));
		else if (ch > '\u00ff')
		    out.write("\\u0" + hex(ch));
		else if (ch > '\u007f')
		    out.write("\\u00" + hex(ch));
		else if (ch < ' ') {
		    switch (ch) {
		    case '\010':
			out.write('\\');
			out.write('b');
			break;
		    case '\n':
			out.write('\\');
			out.write('n');
			break;
		    case '\t':
			out.write('\\');
			out.write('t');
			break;
		    case '\014':
			out.write('\\');
			out.write('f');
			break;
		    case '\r':
			out.write('\\');
			out.write('r');
			break;
		    default:
			if (ch > '\017')
			    out.write("\\u00" + hex(ch));
			else
			    out.write("\\u000" + hex(ch));
		    }
		} else {
		    switch (ch) {
		    case '\'':
			if (escapeSingleQuote)
			    out.write('\\');
			out.write('\'');
			break;
		    case '\"':
			out.write('\\');
			out.write('\"');
			break;
		    case '\\':
			out.write('\\');
			out.write('\\');
			break;
		    default:
			out.write(ch);
		    }
		}
	    }
	}
    }
    
    private static String hex(char ch) {
	return Integer.toHexString(ch).toUpperCase();
    }
    
    public static String unescapeJava(String str) {
	if (str == null)
	    return null;
	try {
	    StringWriter writer = new StringWriter(str.length());
	    unescapeJava(writer, str);
	    return writer.toString();
	} catch (IOException ioe) {
	    ioe.printStackTrace();
	    return null;
	}
    }
    
    public static void unescapeJava(Writer out, String str)	throws IOException {
	if (out == null)
	    throw new IllegalArgumentException("The Writer must not be null");
	if (str != null) {
	    int sz = str.length();
	    StringBuffer unicode = new StringBuffer(4);
	    boolean hadSlash = false;
	    boolean inUnicode = false;
	    for (int i = 0; i < sz; i++) {
		char ch = str.charAt(i);
		if (inUnicode) {
		    unicode.append(ch);
		    if (unicode.length() == 4) {
				try {
				    int value
					= Integer.parseInt(unicode.toString(), 16);
				    out.write((char) value);
				    unicode.setLength(0);
				    inUnicode = false;
				    hadSlash = false;
				} catch (NumberFormatException nfe) {
				    nfe.printStackTrace();
				}
		    }
		} else if (hadSlash) {
		    hadSlash = false;
		    switch (ch) {
		    case '\\':
			out.write('\\');
			break;
		    case '\'':
			out.write('\'');
			break;
		    case '\"':
			out.write('\"');
			break;
		    case 'r':
			out.write('\r');
			break;
		    case 'f':
			out.write('\014');
			break;
		    case 't':
			out.write('\t');
			break;
		    case 'n':
			out.write('\n');
			break;
		    case 'b':
			out.write('\010');
			break;
		    case 'u':
			inUnicode = true;
			break;
		    default:
			out.write(ch);
		    }
		} else if (ch == '\\')
		    hadSlash = true;
		else
		    out.write(ch);
	    }
	    if (hadSlash)
		out.write('\\');
	}
    }
    
}
