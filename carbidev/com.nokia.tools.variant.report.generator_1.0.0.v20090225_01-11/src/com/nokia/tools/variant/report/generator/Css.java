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
 * Description: This file is part of com.nokia.tools.variant.report.generator component.
 */

package com.nokia.tools.variant.report.generator;

/**
 * CSS styles for report
 */
public class Css {

	/**
	 * CSS styles for report
	 * 
	 * @return CSS style which will be inserted int o html head
	 */
	public static StringBuilder getCss(boolean asTable) {

		StringBuilder sb = new StringBuilder();
		if (asTable) {
			sb.append("<style type=\"text/css\">\n");

			sb.append("body {\n");
			sb
					.append("font-family: Nokia Standard Multiscript, Tahoma, Verdana, Arial;\n");
			sb.append("font-size: 0.8em;\n");
			sb.append("color: #0055B7;\n");
			sb.append("}\n");

			sb.append("h1 {\n");
			sb.append("padding: 30px 0 0 0;\n");
			sb.append("margin: 0;\n");
			sb.append("text-align: center;\n");
			sb.append("}\n");

			sb.append("#date {\n");
			sb.append("text-align: center;\n");
			sb.append("}\n");

			sb.append("hr {\n");
			sb.append("height: 1px;\n");
			sb.append("background-color: cccccc;\n");
			sb.append("color: #cccccc;\n");
			sb.append("}\n");

			sb.append("h2 h3 {\n");
			sb.append("padding: 10px 0 10px 0;\n");
			sb.append("margin: 0;\n");
			sb.append("}\n");

			sb.append("table.report {\n");
			// sb.append("table-layout: fixed\n");
			sb.append("width: 100%;\n");
			sb.append("border: 1px solid #e0dfe3;\n");
			sb.append("border-collapse: collapse;\n");
			sb.append("color: #333333;\n");
			sb.append("}\n");

			sb.append("table.report th {\n");
			sb.append("text-align: left;\n");
			sb.append("padding: 5px;\n");
			sb.append("background-color: #f9fafd;\n");
			sb.append("color: #595a5f;\n");
			sb.append("border-bottom: 1px #999999 solid;\n");
			sb.append("}\n");

			sb.append("table.report th.featureName {\n");
			sb.append("background-color: #f2f2f3;\n");
			sb.append("font: #595a5f Tahoma, Verdana, Arial bold;\n");
			sb.append("font-size: 1.1em;\n");
			sb.append("border-top: 3px #9d9da1;\n");
			sb.append("border-top-style: double;\n");
			sb.append("border-bottom: 3px #9d9da1;\n");
			sb.append("border-bottom-style: double;\n");
			sb.append("}\n");

			sb.append("table.report td {\n");
			sb.append("word-wrap: break-word;\n");
			sb.append("border: 1px #EBEBEB;\n");
			sb.append("padding: 5px;\n");
			sb.append("border-style: solid; \n");
			sb.append("vertical-align: top;\n");
			sb.append("font: Tahoma, Verdana, Arial;\n");
			sb.append("_font-size: 0.8em;\n");
			sb.append("}\n");

			sb.append("table.summary {\n");
			sb.append("border: 1px solid #e0dfe3;\n");
			sb.append("border-collapse: collapse;\n");
			sb.append("color: #333333;\n");
			sb.append("}\n");

			sb.append("table.summary th {\n");
			sb.append("text-align: left;\n");
			sb.append("padding: 5px;\n");
			sb.append("background-color: #f9fafd;\n");
			sb.append("color: #595a5f;\n");
			sb.append("border-bottom: 1px #999999 solid;\n");
			sb.append("}\n");

			sb.append("table.summary th.featureName {\n");
			sb.append("background-color: #f2f2f3;\n");
			sb.append("font: #595a5f Tahoma, Verdana, Arial bold;\n");
			sb.append("font-size: 1.1em;\n");
			sb.append("border-top: 3px #9d9da1;\n");
			sb.append("border-top-style: double;\n");
			sb.append("border-bottom: 3px #9d9da1;\n");
			sb.append("border-bottom-style: double;\n");
			sb.append("}\n");

			sb.append("table.summary td {\n");
			sb.append("word-wrap: break-word;\n");
			sb.append("border: 1px #EBEBEB;\n");
			sb.append("padding: 5px;\n");
			sb.append("border-style: solid; \n");
			sb.append("vertical-align: top;\n");
			sb.append("font: Tahoma, Verdana, Arial;\n");
			sb.append("_font-size: 0.8em;\n");
			sb.append("}\n");

			sb.append(".currentValue {\n");
			sb.append("background-color: #e8f2fe;\n");
			sb.append("}\n");

			sb.append("</style>\n");

		} else {
			sb.append("<style type=\"text/css\">\n");
			sb.append("body {\n");
			sb.append("word-wrap: break-word;\n");
			sb
					.append("font-family: Nokia Standard Multiscript, Tahoma, Verdana, Arial;\n");
			sb.append("color: #0055B7;\n");
			sb.append("padding: 0 0 0 10px;\n");
			sb.append("margin: 0;\n");
			sb.append("}\n");

			sb.append("h1#reportName {\n");
			sb.append("text-align: center;\n");
			sb.append("padding: 30px 0 0 0;\n");
			sb.append("margin: 0;\n");
			sb.append("}\n");

			sb.append("#date {\n");
			sb.append("text-align: center;\n");
			sb.append("page-break-after: always;\n");
			sb.append("padding: 0;\n");
			sb.append("margin: 0;\n");
			sb.append("}\n");

			sb.append("h2#tocHeader {\n");
			sb.append("padding: 20px 0 0 0px;\n");
			sb.append("margin: inherit;\n");
			sb.append("}\n");

			sb.append("ul.toc, ul.toc ul {\n");
			sb.append("font-size: 12px;\n");
			sb.append("margin: inherit;\n");
			sb.append("list-style-type: none;\n");
			sb.append("}\n");

			sb.append("hr {\n");
			sb.append("page-break-after: always;\n");
			sb.append("height: 1px;\n");
			sb.append("background-color: cccccc;\n");
			sb.append("color: #cccccc;\n");
			sb.append("width: 100%;\n");
			sb.append("}\n");

			sb.append(".group, .subgroup, .feature, .setting {\n");
			sb.append("padding: 10px 0 0 0px;\n");
			sb.append("margin: 0;\n");
			sb.append("}\n");

			sb.append(".subsetting {\n");
			sb.append("padding: 10px 0 0 20px;\n");
			sb.append("margin: 0;\n");
			sb.append("}\n");

			sb.append("h2, h3, h4, h5, h6 {\n");
			sb.append("padding: 0px;\n");
			sb.append("margin: 0px;\n");
			sb.append("}\n");

			sb.append(".description {\n");
			sb.append("font-size: 12px;\n");
			sb.append("margin: 0 0 0 0px;\n");
			sb.append("padding: 0px;\n");
			sb.append("color: #333333;\n");
			sb.append("}\n");

			sb.append(".settingValues {\n");
			sb.append("padding: 0px;\n");
			sb.append("margin: 5px 0 0 0px;\n");
			sb.append("color: #333333;\n");
			sb.append("font-size: 12px;\n");
			sb.append("}\n");

			sb.append(".Property {\n");
			sb.append("float: left;\n");
			sb.append("width: 200px;\n");
			sb.append("clear: both;\n");
			sb.append("}\n");

			sb.append(".Value {\n");
			sb.append("position: relative;\n");
			sb.append("}\n");

			sb.append(".PropertySum {\n");
			sb.append("float: left;\n");
			sb.append("margin-left: 50px;\n");
			sb.append("width: 200px;\n");
			sb.append("clear: both;\n");
			sb.append("}\n");

			sb.append("</style>\n");
		}
		return sb;
	}
}
