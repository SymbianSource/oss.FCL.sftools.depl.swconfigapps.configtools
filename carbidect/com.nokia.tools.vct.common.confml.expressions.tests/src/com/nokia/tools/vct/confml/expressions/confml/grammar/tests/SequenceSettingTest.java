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
 * This test class tests handling of constrain and relevant evaluating of Sequence Settings.
 * 
 */
public class SequenceSettingTest extends TestCase {
	
	private String result;
	private String testString;
		
	@Before
	public void setUp() throws Exception {
		
	}
	
	public void set() throws IOException {
		ConfmlExpressionEvaluator parser = new ConfmlExpressionEvaluator(testString);
        CommonTree tree = parser.createASTFromConfmlExpression();
        
        Map<String, String> settingValueTable = new HashMap<String, String>();
        settingValueTable.put("FeatureA/Sequence[0]/Subsetting0", "000");
        settingValueTable.put("FeatureA/Sequence[1]/Subsetting1", "100");
        settingValueTable.put("FeatureA/Sequence[2]/Subsetting2", "200");
        
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
	public void test1() throws RecognitionException, IOException {
		setTestString("FeatureA/Sequence[2]/Subsetting2");
		set();
		
		if (result != null) {
			assertTrue(result.equals("200"));
		
		} else {
			fail("Result is null");
		}
	}
	
	@Test
	public void test2() throws RecognitionException, IOException {
		setTestString("FeatureA/Sequence[0]/Subsetting0");
		set();
		
		if (result != null) {
			assertTrue(result.equals("000"));
		
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
