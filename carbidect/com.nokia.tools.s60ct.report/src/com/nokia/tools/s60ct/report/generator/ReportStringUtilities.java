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
/**
 * 
 */
package com.nokia.tools.s60ct.report.generator;

import java.util.StringTokenizer;

import org.eclipse.jface.preference.IPreferenceStore;

import com.nokia.tools.s60ct.report.ReportPlugin;

/**
 * 
 * @author 
 * 
 */
public class ReportStringUtilities {

	private static final String WBR_COUNTER = "shycounter";

	private IPreferenceStore iPreferenceStore;

	public ReportStringUtilities() {
		super();
		try {//ML
			iPreferenceStore = ReportPlugin.getDefault().getPreferenceStore();
		} catch (Exception e) {//ML

			e.printStackTrace();
		}//ML
	}

	public StringBuffer getEncodedWrappedString(String string) {
		return getEncodedString(getWrappedWord(string).toString());
	}

	public StringBuffer getEncodedString(String s) {
		StringBuffer buf = new StringBuffer();
		int len = (s == null ? -1 : s.length());

		for (int i = 0; i < len; i++) {
			char c = s.charAt(i);
			if (c >= ' ' && c <= '}') {
				buf.append(c);
			} else {
				buf.append("&#" + (int) c + ";");
			}
		}
		return buf;
	}

	public StringBuffer getWrappedWord(String val) {
		StringBuffer sb = new StringBuffer();
		if (val == null || val == "") {
			return sb;
		}
		if (val.equals("&lt;Default&gt;")) {
			sb.append("&lt;Default&gt;");
			return sb;
		}
		int number = iPreferenceStore.getInt(WBR_COUNTER);
		if (number == 0) {
			number = 8;
		}
		String tag = "<wbr/>";

		int n = 0;
		StringTokenizer st = new StringTokenizer(val, " .,;()=\\/", true);
		String text = "";
		while (st.hasMoreTokens()) {
			String token = st.nextToken();

			// int firstCharPos = val.indexOf(token, text.length())
			// + token.length();
			int lastCharPos = val.indexOf(token, text.length())
					+ token.length() + 1;
			if (lastCharPos > val.length()) {
				lastCharPos = val.length();
			}
			// String delimeter = val.substring(firstCharPos, lastCharPos);
			// System.out.println(token + "->" + delimeter + "<-");
			text += token;// + delimeter;
			if (token.length() > number) {
				for (int i = 0; i < token.length(); i++) {
					if (n == number - 1) {
						sb.append(token.charAt(i) + tag);
						n = 0;
					} else {
						sb.append(token.charAt(i));
						n++;
					}
				}
			} else {
				sb.append(token);
			}
			/*
			 * if (delimeter != null) { sb.append(delimeter); }
			 */
			n = 0;
		}
		iPreferenceStore.putValue(WBR_COUNTER, String.valueOf(number));
		return sb;
	}

}
