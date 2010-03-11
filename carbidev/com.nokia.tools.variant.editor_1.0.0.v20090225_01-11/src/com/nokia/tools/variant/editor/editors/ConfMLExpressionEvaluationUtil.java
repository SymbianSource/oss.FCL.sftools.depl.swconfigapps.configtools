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
 * Description: This file is part of com.nokia.tools.variant.editor component.
 */

package com.nokia.tools.variant.editor.editors;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.eclipse.emf.ecore.EObject;

import com.nokia.tools.variant.confml.expressions.confml.grammar.ConfmlLexer;
import com.nokia.tools.variant.confml.expressions.confml.grammar.ConfmlParser;
import com.nokia.tools.variant.content.confml.Feature;
import com.nokia.tools.variant.content.confml.FileSystemEntrySetting;
import com.nokia.tools.variant.content.confml.SequenceItem;
import com.nokia.tools.variant.content.confml.SequenceSetting;
import com.nokia.tools.variant.content.confml.Setting;
import com.nokia.tools.variant.content.confml.View;


/**
 * Evaluates relevant and constraint attributes of confml setting and in future also relevant attribute of confml feature
 * 
 */
public class ConfMLExpressionEvaluationUtil {
	
	/**
	 * Evaluates relevant attribute of the setting
	 * 
	 * @param setting
	 * @return
	 */
	public static boolean evaluateSettingRelevant(Setting setting) {
		if (setting instanceof SequenceSetting) {

		}
		String relevant = setting.getRelevant();
		if (relevant != null && !relevant.equals("")) {
			try {
				return evaluate(setting, relevant);
			} catch (Throwable e) {
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Evaluates constraint attribute of the setting
	 * 
	 * @param setting
	 * @param expression
	 * @return
	 */
	public static boolean evaluateSettingConstraintValid(Setting setting) {
		String constraint = setting.getConstraint();
		if (constraint != null && !constraint.equals("")) {
			try {
				return evaluate(setting, constraint);
			} catch (Throwable t) {
				t.printStackTrace();
				return false;
			}
		}
		return true;
	}
	/**
	 * Evaluates ConfML expression 
	 * 
	 * @param expression
	 * @return
	 */
	public static boolean evaluateSetting(Setting setting, String expression){
		try {
			return evaluate(setting, expression);
		} catch (Throwable e) {
			return false; 
		}
	}
	
	/**
	 * Evaluates ConfML expression 
	 * 
	 * @param expression
	 * @return
	 */
	private static boolean evaluate(Setting setting, String expression) throws Throwable {
		expression += "\r\n";
		
		// Create an input character stream from standard in
		ByteArrayInputStream bais = new ByteArrayInputStream(expression.getBytes());
		try {
			ANTLRInputStream input = new ANTLRInputStream(bais);
			// Create an ExprLexer that feeds from that stream
			ConfmlLexer lexer = new ConfmlLexer(input);
			// Create a stream of tokens fed by the lexer
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			// Create a parser that feeds off the token stream
			ConfmlParser parser = new ConfmlParser(tokens);
			
			// set parser . context
			parser.setSetting(setting);
			
			// set parser a View
			View view = null;
			if (setting.eContainer() instanceof View) { // simple setting
				view = (View) setting.eContainer();
			} else if (setting.eContainer() instanceof SequenceItem) { //
				SequenceItem si = (SequenceItem) setting.eContainer();
				EObject container = si.eContainer().eContainer();
				if (container instanceof View) {
					view = (View) container;
				}
			} else if (setting.eContainer() instanceof FileSystemEntrySetting) {// file's sub-setting
				FileSystemEntrySetting fileSetting = (FileSystemEntrySetting) setting.eContainer();

				if (fileSetting.eContainer() instanceof View) {// simple file
					view = (View) fileSetting.eContainer();
				} else if (fileSetting.eContainer() instanceof SequenceItem) {// file in sequence
					view = (View) fileSetting.eContainer().eContainer();
				}
			}
			parser.setView(view);
			
			
			// set parser a sequence item
			SequenceItem si = null;
			if (setting.eContainer() instanceof SequenceItem) {
				si = (SequenceItem) setting.eContainer();
			} else if (setting.eContainer() instanceof FileSystemEntrySetting) {
				EObject fileSetting = setting.eContainer();
				if (fileSetting.eContainer() instanceof SequenceItem) {
					si = (SequenceItem) fileSetting.eContainer();
				}
			}
			parser.setSequenceItem(si);
			
			
			// set parser a feature ref
			parser.setFeatureRef(setting.getFeatureRef());
			
			
			Object exprResult = parser.expr();
			if (exprResult instanceof Boolean) {
				Boolean result = (Boolean) exprResult;
				if (result.booleanValue()) {
					return true;
				} else {
					return false;
				}
			}
			return false;
		} catch (IOException e) {
			return false;
		} catch (RecognitionException e) {
			return false;
		} catch (Throwable t) {
			return false;
		}
	}

	
	/**
	 * Evaluates ConfML expression 
	 * 
	 * @param expression
	 * @return
	 */
	private static boolean evaluate(Feature feature, String expression) throws Throwable {
		expression += "\r\n";
		
		// Create an input character stream from standard in
		ByteArrayInputStream bais = new ByteArrayInputStream(expression.getBytes());
		try {
			ANTLRInputStream input = new ANTLRInputStream(bais);
			// Create an ExprLexer that feeds from that stream
			ConfmlLexer lexer = new ConfmlLexer(input);
			// Create a stream of tokens fed by the lexer
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			// Create a parser that feeds off the token stream
			ConfmlParser parser = new ConfmlParser(tokens);
			
			// set parser . context
			parser.setFeatureRef(feature.getRef());
			
			// set parser a View
			View view = null;
			if (feature.eContainer() instanceof View) { // simple setting
				view = (View) feature.eContainer();
			} 
			parser.setView(view);
			
			
			Object exprResult = parser.expr();
			if (exprResult instanceof Boolean) {
				Boolean result = (Boolean) exprResult;
				if (result.booleanValue()) {
					return true;
				} else {
					return false;
				}
			}
			return false;
		} catch (IOException e) {
			return false;
		} catch (RecognitionException e) {
			return false;
		} catch (Throwable t) {
			return false;
		}
	}

	
	public static boolean evaluateFeatureRelevantValid(Feature feature) {
		String relevant = feature.getRelevant();
		if (relevant != null && !relevant.equals("")) {
			try {
				return evaluate(feature, relevant);
			} catch (Throwable t) {
				t.printStackTrace();
				return false;
			}
		}
		return true;
	}
	
	
	public static boolean evaluateFeatureConstraintValid(Feature feature) {
		throw new UnsupportedOperationException();
	}
}
