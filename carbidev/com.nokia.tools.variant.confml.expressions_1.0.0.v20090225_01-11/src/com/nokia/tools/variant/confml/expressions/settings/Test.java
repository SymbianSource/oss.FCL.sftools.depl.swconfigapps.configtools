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
 * Description: This file is part of com.nokia.tools.variant.confml.expressions component.
 */

package com.nokia.tools.variant.confml.expressions.settings;
import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;

import com.nokia.tools.variant.content.confml.ConfmlFactory;
import com.nokia.tools.variant.content.confml.SimpleSetting;
import com.nokia.tools.variant.content.confml.View;


public class Test {
	public static void main(String[] args) throws Exception {
		// Create an input character stream from standard in
		ANTLRInputStream input = new ANTLRInputStream(System.in);
		// Create an ExprLexer that feeds from that stream
		ConfmlLexer lexer = new ConfmlLexer(input);
		// Create a stream of tokens fed by the lexer
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		// Create a parser that feeds off the token stream
		ConfmlParser parser = new ConfmlParser(tokens);

		View view = ConfmlFactory.eINSTANCE.createView();
		SimpleSetting ss = ConfmlFactory.eINSTANCE.createSimpleSetting();
		ss.setAbsRef("featurex/settingx");
		ss.setValue("123");
		view.getSharedSettingInstances().add(ss);
		
		ss = ConfmlFactory.eINSTANCE.createSimpleSetting();
		ss.setAbsRef("featurey/settingy");
		ss.setValue("xxx");
		view.getSharedSettingInstances().add(ss);
		
		ss = ConfmlFactory.eINSTANCE.createSimpleSetting();
		ss.setAbsRef("feature_x/setting_a");
		ss.setValue("5");
		view.getSharedSettingInstances().add(ss);
		
		// set context
		parser.setView(view);
		parser.setFeatureRef("featurex");
		
		Object additiveExpr = parser.expr();
		System.out.println("result=" + additiveExpr);
	}
}
