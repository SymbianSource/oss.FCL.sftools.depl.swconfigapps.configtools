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

package com.nokia.tools.variant.confml.expressions.confml.grammar;
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

		long a = System.nanoTime();
		View view = ConfmlFactory.eINSTANCE.createView();
		SimpleSetting ss = ConfmlFactory.eINSTANCE.createSimpleSetting();
		ss.setAbsRef("featurex/settingx");
		ss.setValue("123");
		view.getSharedSettingInstances().add(ss);
		long b = System.nanoTime();
		System.out.println("milis=" + ((b-a)));
		
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
		
		// Begin parsing at rule expr
		a = System.nanoTime();
		Object additiveExpr = parser.expr();
		b = System.nanoTime();
		System.out.println("milis=" + ((b-a)));
		System.out.println("result=" + additiveExpr);
	}
	
	  public Double toDouble(Object o) {
		  if (o instanceof Double) {
			  return (Double) o;
		  } else {
		      String s = o.toString();
			  return Double.parseDouble(s);
		  }
	  }

	  
	  public boolean areObjectsEqual(Object o1, Object o2) {
		  try {
			  if (o1 instanceof Boolean) {
				  Boolean b1 = (Boolean) o1;
				  if (o2 instanceof Boolean) {
					  return b1.equals(o2);
				  } else if (o2 instanceof String) {
					  String s2 = (String) o2;
					  return b1.equals(Boolean.parseBoolean(s2));
				  } else {
					  return false;
				  }
			  } else if (o1 instanceof String) {
				  String s1 = (String) o1;
				  if (o2 instanceof Boolean) {
					  Boolean b2 = (Boolean) o2;
					  return s1.equals(b2.toString());
				  } else if (o2 instanceof String) {
					  return s1.equals(o2);
				  } else if (o2 instanceof Double) {
					  return s1.equals(((Double)o2).toString());
				  }
			  } else if (o1 instanceof Double) {
				  Double d1 = (Double) o1;
				  if (o2 instanceof String) {
					  String s2 = (String) o2;
					  return d1.equals(Double.parseDouble(s2));
				  } else if (o2 instanceof Double) {
					  return d1.equals(o2);
				  }
			  }
		  } catch (Throwable t) {
			  ;
		  }
		  return false;
	  }
}
