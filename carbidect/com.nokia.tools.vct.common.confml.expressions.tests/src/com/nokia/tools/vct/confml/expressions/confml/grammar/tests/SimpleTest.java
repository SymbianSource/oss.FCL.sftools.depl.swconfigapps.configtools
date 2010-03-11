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
 * Description: This file is part of com.nokia.tools.vct.common.confml.expressions.tests component.
 */

package com.nokia.tools.vct.confml.expressions.confml.grammar.tests;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import junit.framework.TestCase;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;
import org.junit.Before;
import org.junit.Test;

import com.nokia.tools.vct.internal.common.confml.expressions.ConfmlExpressionEvaluator;

/**
 * This test class tests handling of constrain and relevant evaluating of Simple Settings.
 * 
 */
public class SimpleTest extends TestCase {
	
	private String result;
	private String testString;
		
	@Before
	public void setUp() throws Exception {
		
	}
	public void set() throws IOException {
		ConfmlExpressionEvaluator parser = new ConfmlExpressionEvaluator(testString);
        CommonTree tree = parser.createASTFromConfmlExpression();
        
        Map<String, String> settingValueTable = new HashMap<String, String>();
        settingValueTable.put("FeatureA/SettingA", "11");
        settingValueTable.put("FeatureA/SettingB", "22");
        settingValueTable.put("FeatureA/SettingC", "33");
        settingValueTable.put("FeatureA/SettingD", "hi");
        settingValueTable.put("FeatureA/SettingE", "hello");
        settingValueTable.put("FeatureA/SettingF", "true");
        settingValueTable.put("FeatureA/SettingG", "false");
        
        Stack<Token> stack = new Stack<Token>();
        try {
        	ConfmlExpressionEvaluator.computeResult(tree, stack, settingValueTable);
        } catch (Throwable t) {
        	ConfmlExpressionEvaluator.printTree(tree, 1);
            return;
        }
        Token token = stack.pop();
        String text = token.getText();
        if (text != null) {
            result = text;
        }
	}
	
	@Test
	public void testOr() throws RecognitionException, IOException {
		setTestString("FeatureA/SettingF or FeatureA/SettingG");
		set();
		
		if (result != null) {
			assertTrue(result.equals("true"));
		
		} else {
			fail("Result is null");
		}
	}
	@Test
	public void testAnd() throws RecognitionException, IOException {
		setTestString("FeatureA/SettingF and FeatureA/SettingG");
		set();
				
		if (result != null) {
			assertTrue(result.equals("false"));
		
		} else {
			fail("Result is null");
		}
	}
	@Test
	public void testLowerThan() throws RecognitionException, IOException {
		setTestString("FeatureA/SettingA < FeatureA/SettingB");
		set();
		
		if (result != null) {
			assertTrue(result.equals("true"));
	
		} else {
			fail("Result is null");
		}
	}

	@Test
	public void testLowerThanEquals() throws RecognitionException, IOException {
		setTestString("FeatureA/SettingB <= FeatureA/SettingB");
		set();
		
		if (result != null) {
			assertTrue(result.equals("true"));
	
		} else {
			fail("Result is null");
		}
	}

	@Test
	public void testGreaterThan() throws RecognitionException, IOException {
		setTestString("FeatureA/SettingB > FeatureA/SettingA");
		set();

		if (result != null) {
			assertTrue(result.equals("true"));
		
			
		} else {
			fail("Result is null");
		}
	}

	@Test
	public void testGreaterThanEquals() throws RecognitionException,
			IOException {
		setTestString("FeatureA/SettingB >= FeatureA/SettingB");
		set();
	
		if (result != null) {
			assertTrue(result.equals("true"));
		
		} else {
			fail("Result is null");
		}
	}

	@Test
	public void testEquals() throws RecognitionException, IOException {
		setTestString("FeatureA/SettingA = FeatureA/SettingB");
		set();
	
		if (result != null) {
			assertFalse(result.equals("true"));
		
		} else {
			fail("Result is null");
		}
	}

	@Test
	public void testNotEquals() throws RecognitionException, IOException {
		setTestString("FeatureA/SettingA != FeatureA/SettingB");
		set();
	
		if (result != null) {
			assertTrue(result.equals("true"));
		
		} else {
			fail("Result is null");
		}
	}
	@Test
	public void testPlus() throws RecognitionException, IOException {
		setTestString("FeatureA/SettingA + FeatureA/SettingB");
		set();
		
		if (result != null) {
			assertTrue(result.equals("33.0"));
		
		} else {
			fail("Result is null");
		}
	}
	@Test
	public void testMinus() throws RecognitionException, IOException {
		setTestString("FeatureA/SettingA - FeatureA/SettingB");
		set();
	
		if (result != null) {
			assertTrue(result.equals("-11.0"));
			
		} else {
			fail("Result is null");
		}
	}

	@Test
	public void testMuliply() throws RecognitionException, IOException {
		setTestString("FeatureA/SettingA * 2");
		set();

		if (result != null) {
			assertTrue(result.equals("22.0"));
		
		} else {
			fail("Result is null");
		}
	}

	@Test
	public void testDiv() throws RecognitionException, IOException {
		setTestString("FeatureA/SettingB div 2");
		set();
	
		if (result != null) {
			assertTrue(result.equals("11.0"));
		
		} else {
			fail("Result is null");
		}
	}

	@Test
	public void testMod() throws RecognitionException, IOException {
		setTestString("FeatureA/SettingA mod 3");
		set();

		if (result != null) {
			assertTrue(result.equals("2.0"));
			
		} else {
			fail("Result is null");
		}
	}

	@Test
	public void testUnary() throws RecognitionException, IOException {
		setTestString("-FeatureA/SettingA");
		set();
	
		if (result != null) {
			assertTrue(result.equals("-11.0"));
			
		} else {
			fail("Result is null");
		}
	}

	@Test
	public void testAll() throws RecognitionException, IOException {
		setTestString("FeatureA/SettingA + 3 * FeatureA/SettingB + 2 + FeatureA/SettingC - FeatureA/SettingB");
		set();
	
		if (result != null) {
			assertTrue(result.equals("90.0"));
		
		} else {
			fail("Result is null");
		}
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public void setTestString(String testString) {
		this.testString = testString;
	}
}
