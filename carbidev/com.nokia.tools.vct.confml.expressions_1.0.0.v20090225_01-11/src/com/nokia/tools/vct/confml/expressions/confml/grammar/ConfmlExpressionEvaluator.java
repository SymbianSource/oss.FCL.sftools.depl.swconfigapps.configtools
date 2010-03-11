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
 * Description: This file is part of com.nokia.tools.vct.confml.expressions component.
 */
package com.nokia.tools.vct.confml.expressions.confml.grammar;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;

import com.nokia.tools.vct.confml.expressions.confml.grammar.ConfmlParser.expr_return;

/**
 * Confml expression evaluator is a utility which uses confml parser which
 * produces confml AST which will be further evaluated as confml expression
 */
public class ConfmlExpressionEvaluator {

    private static final String TRUE = "true";
    private static final String FALSE = "false";

    private String confmlExpression;

    public ConfmlExpressionEvaluator(String confmlExpression) {
        this.confmlExpression = confmlExpression;
    }

    /**
     * @return Returns AST for parsed confml expression or null in case of
     *         failure
     */
    public CommonTree createASTFromConfmlExpression() {
        ANTLRInputStream input = null;
        try {
            ByteArrayInputStream bais = new ByteArrayInputStream(
                    confmlExpression.getBytes());
            input = new ANTLRInputStream(bais);
            ConfmlLexer lexer = new ConfmlLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            ConfmlParser parser = new ConfmlParser(tokens);
            expr_return expr = parser.expr();
            CommonTree tree = (CommonTree) expr.getTree();

            if (parser.isFailed()) {
                return null;
            }
            return tree;
        } catch (RecognitionException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param astConfmlTree CommonTree created by parsing of the
     *            <code>confmlExpression</code> by calling method
     *            <code>createASTFromConfmlExpression</code>.
     * @param settingValueTable is a map of setting reference string to its
     *            string value.
     * @return <code>true</code> if expression is evaluated to <code>true</code>
     *         else it returns <code>false</code>.
     */
    public static boolean evaulateConfmlAST(CommonTree astConfmlTree,
            Map<String, String> settingValueTable) {
        Stack<Token> stack = new Stack<Token>();
        try {
            computeResult(astConfmlTree, stack, settingValueTable);
        } catch (Throwable t) {
            t.printStackTrace();
            return false;
        }
        Token token = stack.pop();
        if (token.getType() == ConfmlLexer.BOOLEAN) {
            String text = token.getText();
            if (text != null) {
                if (text.equals(ConfmlExpressionEvaluator.TRUE)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Evaluates confml expression
     * 
     * @param astConfmlTree AST of confml expression
     * @param settingValuesProvider provider for setting values
     * @return <code>true</code> if expression was evaluated to true or
     *         <code>false</code>.
     */
    public static boolean evaluateConfmlAST(CommonTree astConfmlTree,
            IConfmlSettingValuesProvider settingValuesProvider, Object root,
            Object context) {
        List<Token> settingRefTokens = getSettingRefTokens(astConfmlTree);

        // compute symbol table using settingValuesProvider
        Map<String, String> settingValueMap = new HashMap<String, String>();
        String value = null;
        String[] refs = null;

        // process tokens and resolve setting values for them
        for (int i = 0; i < settingRefTokens.size(); i++) {
            Token token = settingRefTokens.get(i);
            String absRef = token.getText();
            switch (token.getType()) {
            case ConfmlLexer.CURRENT_REF:
                value = settingValuesProvider.getValue(context);
                settingValueMap.put(absRef, value);
                break;

            case ConfmlLexer.FILE_PATH_REF:
                refs = absRef.split("/");
                Object feature = settingValuesProvider
                        .getSubItem(root, refs[0]);
                Object fileSetting = settingValuesProvider.getSubItem(feature,
                        refs[1]);
                Object path = settingValuesProvider.getSubItem(fileSetting,
                        refs[2]);
                value = settingValuesProvider.getValue(path);
                settingValueMap.put(absRef, value);
                break;

            case ConfmlLexer.SIBLING_REF:
                Object parentItem = settingValuesProvider
                        .getParentItem(context);
                Object sibling = settingValuesProvider.getSubItem(parentItem,
                        absRef);
                value = settingValuesProvider.getValue(sibling);
                settingValueMap.put(absRef, value);
                break;

            case ConfmlLexer.SUB_SETTING_REF:
                refs = absRef.split("/[]");
                feature = settingValuesProvider.getSubItem(root, refs[0]);
                Object sequenceSetting = settingValuesProvider.getSubItem(
                        feature, refs[1]);
                Object item = settingValuesProvider.getSubItem(sequenceSetting,
                        Integer.parseInt(refs[2]));
                Object subSetting = settingValuesProvider.getSubItem(item,
                        refs[4]);
                value = settingValuesProvider.getValue(subSetting);
                settingValueMap.put(absRef, value);
                break;

            case ConfmlLexer.TOP_LEVEL_SETTING_REF:
                refs = absRef.split("/");
                Object f = settingValuesProvider.getSubItem(root, refs[0]);
                Object tls = settingValuesProvider.getSubItem(f, refs[1]);
                value = settingValuesProvider.getValue(tls);
                settingValueMap.put(absRef, value);
                break;
            }
        }

        return evaulateConfmlAST(astConfmlTree, settingValueMap);
    }

    /**
     * Example parser usage
     * 
     * @param args
     */
    public static void main(String[] args) {
        ConfmlExpressionEvaluator parserTest = new ConfmlExpressionEvaluator(
                "9 > . and F/X < 9");
        CommonTree tree = parserTest.createASTFromConfmlExpression();
        printTree(tree, 0);

        Map<String, String> settingValueTable = new HashMap<String, String>();
        settingValueTable.put("F/X", "2");
        settingValueTable.put("F/X/localPath", "6");
        settingValueTable.put(".", "6");
        boolean result = evaulateConfmlAST(tree, settingValueTable);
        System.out.println(result);
    }

    /**
     * Prints tree of tokens of the standard output
     * 
     * @param t printed tree
     * @param indent indentation level
     */
    public static void printTree(CommonTree t, int indent) {
        StringBuffer sb = new StringBuffer(indent);
        for (int i = 0; i < indent; i++)
            sb = sb.append("   ");
        if (t == null) {
            return;
        }
        Token token = t.token;
        String text = "";
        if (token.getText() != null) {
            text = token.getText();
        }
        System.out.println(sb.toString() + text);
        if (t != null) {
            for (int i = 0; i < t.getChildCount(); i++) {
                printTree((CommonTree) t.getChild(i), indent + 1);
            }
        }
    }

    /**
     * Returns a list of tokens which represents setting references inside
     * parsed confml expression. Every token has its type:
     * ConfmlLexer.CURRENT_REF, ConfmlLexer.TOP_LEVEL_SETTING_REF,
     * ConfmlLexer.SIBLING_REF, ConfmlLexer.SUB_SETTING_REF,
     * ConfmlLexer.FILE_PATH_REF and each of these tokens contains a text
     * holding a reference to confml setting in one of these forms: . DESCRIBES:
     * means current setting F/X DESCRIBES: means setting X under feature F
     * F/X/S DESCRIBES: S is one of the localPath or targetPath for file setting
     * X under feature F S DESCRIBES: S is a sibling setting in current feature
     * or sibling setting in the current sequence item F/S[n]/SS DESCRIBES: SS
     * is a subsetting in n-th sequence item of sequence setting S in feature F
     * 
     * @param tree root node of the expression's AST
     * @return
     */
    public static List<Token> getSettingRefTokens(CommonTree tree) {
        List<Token> tokenList = new ArrayList<Token>();

        getSettingRefs(tokenList, tree);

        return tokenList;
    }

    /**
     * Collects all setting reference tokens and puts them into
     * <code>tokenList</code>.
     * 
     * @param tokenList list of found "settingRef" tokens
     * @param tree starting node of the searched tree
     */
    private static void getSettingRefs(List<Token> tokenList, CommonTree tree) {
        Token token = tree.getToken();
        switch (token.getType()) {
        case ConfmlLexer.CURRENT_REF:
        case ConfmlLexer.TOP_LEVEL_SETTING_REF:
        case ConfmlLexer.SIBLING_REF:
        case ConfmlLexer.SUB_SETTING_REF:
        case ConfmlLexer.FILE_PATH_REF:
            tokenList.add(token);
            break;
        }
        int childCount = tree.getChildCount();
        for (int i = 0; i < childCount; i++) {
            Tree child = tree.getChild(i);
            if (child instanceof CommonTree) {
                CommonTree commonTreeChild = (CommonTree) child;
                getSettingRefs(tokenList, commonTreeChild);
            }
        }
    }

    /**
     * Compute result by using stack and infix traversing of the tree and
     * postfix evaluation of the stack's content. for infix expression 2 + 3 I
     * will create a stack and it will be evaluated. e.g. stack: "2 3 +" will be
     * evaluated to 5. So in this scenario I put the elements into the stack in
     * postfix order and then evaluate them according to the example above
     * 
     * @param tree root of the evaluated subtree
     * @param stack stack for storing elements for postfix evaluation
     * @param settingValueTable map of setting ref to the setting value
     */
    private static void computeResult(CommonTree tree, Stack<Token> stack,
            Map<String, String> settingValueTable) {
        int count = tree.getChildCount();
        Token token = tree.getToken();
        if (count > 0) {
            // traverse down and put all children to stack
            for (int i = 0; i < count; i++) {
                Tree child = tree.getChild(i);
                if (child instanceof CommonTree) {
                    CommonTree commonTree = (CommonTree) child;
                    computeResult(commonTree, stack, settingValueTable);
                }
            }
        }

        stack.push(token);

        // common variables
        Token n1 = null;
        Token n2 = null;
        Token numberToken = null;
        Token booleanToken = null;
        CommonToken settingValueToken = null;
        double d1 = 0;
        double d2 = 0;
        Double do1 = null;
        Double do2 = null;
        Boolean b1 = null;
        Boolean b2 = null;

        // compute new token
        switch (token.getType()) {
        case ConfmlLexer.PLUS:
            stack.pop();
            n2 = stack.pop();
            n1 = stack.pop();
            numberToken = new CommonToken(ConfmlLexer.Number);
            d1 = Double.parseDouble(n1.getText());
            d2 = Double.parseDouble(n2.getText());
            numberToken.setText(Double.toString(d1 + d2));
            stack.push(numberToken);
            break;

        case ConfmlLexer.MINUS:
            stack.pop();
            n2 = stack.pop();
            boolean binary = true;
            if (stack.isEmpty() || stack.peek().getType() != ConfmlLexer.Number) {
                binary = false;
            }

            if (binary) {// BINARY -
                n1 = stack.pop();
                numberToken = new CommonToken(ConfmlLexer.Number);
                d1 = Double.parseDouble(n1.getText());
                d2 = Double.parseDouble(n2.getText());
                numberToken.setText(Double.toString(d1 - d2));
                stack.push(numberToken);
            } else {// UNARY -
                numberToken = new CommonToken(ConfmlLexer.Number);
                d2 = Double.parseDouble(n2.getText());
                numberToken.setText(Double.toString(-d2));
                stack.push(numberToken);
            }
            break;

        case ConfmlLexer.MUL:
            stack.pop();
            n2 = stack.pop();
            n1 = stack.pop();
            numberToken = new CommonToken(ConfmlLexer.Number);
            d1 = Double.parseDouble(n1.getText());
            d2 = Double.parseDouble(n2.getText());
            numberToken.setText(Double.toString(d1 * d2));
            stack.push(numberToken);
            break;

        case ConfmlLexer.DIV:
            stack.pop();
            n2 = stack.pop();
            n1 = stack.pop();
            numberToken = new CommonToken(ConfmlLexer.Number);
            d1 = Double.parseDouble(n1.getText());
            d2 = Double.parseDouble(n2.getText());
            numberToken.setText(Double.toString(d1 / d2));
            stack.push(numberToken);
            break;

        case ConfmlLexer.MOD:
            stack.pop();
            n2 = stack.pop();
            n1 = stack.pop();
            numberToken = new CommonToken(ConfmlLexer.Number);
            d1 = Double.parseDouble(n1.getText());
            d2 = Double.parseDouble(n2.getText());
            numberToken.setText(Double.toString(d1 % d2));
            stack.push(numberToken);
            break;

        case ConfmlLexer.Number:
            break;

        case ConfmlLexer.GT:
            stack.pop();
            n2 = stack.pop();
            n1 = stack.pop();
            booleanToken = new CommonToken(ConfmlLexer.BOOLEAN);
            compareStringsOrNumbersAndUpdateStack(stack, n1, n2, booleanToken,
                    new int[] { 1 });// n1>n2
            break;

        case ConfmlLexer.LT:
            stack.pop();
            n2 = stack.pop();
            n1 = stack.pop();
            booleanToken = new CommonToken(ConfmlLexer.BOOLEAN);
            compareStringsOrNumbersAndUpdateStack(stack, n1, n2, booleanToken,
                    new int[] { -1 });// n1<n2
            break;

        case ConfmlLexer.GE:
            stack.pop();
            n2 = stack.pop();
            n1 = stack.pop();
            booleanToken = new CommonToken(ConfmlLexer.BOOLEAN);
            compareStringsOrNumbersAndUpdateStack(stack, n1, n2, booleanToken,
                    new int[] { 0, 1 });// n1>=n2
            break;

        case ConfmlLexer.LE:
            stack.pop();
            n2 = stack.pop();
            n1 = stack.pop();
            booleanToken = new CommonToken(ConfmlLexer.BOOLEAN);
            compareStringsOrNumbersAndUpdateStack(stack, n1, n2, booleanToken,
                    new int[] { -1, 0 });// n1<=n2
            break;

        case ConfmlLexer.EQ:
            stack.pop();
            n2 = stack.pop();
            n1 = stack.pop();
            booleanToken = new CommonToken(ConfmlLexer.BOOLEAN);
            compareStringsOrNumbersAndUpdateStack(stack, n1, n2, booleanToken,
                    new int[] { 0 });// n1==n2
            break;

        case ConfmlLexer.NEQ:
            stack.pop();
            n2 = stack.pop();
            n1 = stack.pop();
            booleanToken = new CommonToken(ConfmlLexer.BOOLEAN);
            compareStringsOrNumbersAndUpdateStack(stack, n1, n2, booleanToken,
                    new int[] { -1, 1 });// n1!=n2
            break;

        case ConfmlLexer.AND:
            stack.pop();
            n2 = stack.pop();
            n1 = stack.pop();
            booleanToken = new CommonToken(ConfmlLexer.BOOLEAN);
            b1 = new Boolean(n1.getText());
            b2 = new Boolean(n2.getText());
            if (b1 == true && b2 == true) {
                booleanToken.setText(ConfmlExpressionEvaluator.TRUE);
            } else {
                booleanToken.setText(ConfmlExpressionEvaluator.FALSE);
            }
            stack.push(booleanToken);
            break;

        case ConfmlLexer.OR:
            stack.pop();
            n2 = stack.pop();
            n1 = stack.pop();
            booleanToken = new CommonToken(ConfmlLexer.BOOLEAN);
            b1 = new Boolean(n1.getText());
            b2 = new Boolean(n2.getText());
            if (b1 == true || b2 == true) {
                booleanToken.setText(ConfmlExpressionEvaluator.TRUE);
            } else {
                booleanToken.setText(ConfmlExpressionEvaluator.FALSE);
            }
            stack.push(booleanToken);
            break;

        case ConfmlLexer.CURRENT_REF:
            stack.pop();
            settingValueToken = new CommonToken(ConfmlLexer.Literal);
            resolveAndConvertSettingValue(settingValueTable, token,
                    settingValueToken);
            stack.push(settingValueToken);
            break;

        case ConfmlLexer.TOP_LEVEL_SETTING_REF:
            stack.pop();
            settingValueToken = new CommonToken(ConfmlLexer.Literal);
            resolveAndConvertSettingValue(settingValueTable, token,
                    settingValueToken);
            stack.push(settingValueToken);
            break;

        case ConfmlLexer.SIBLING_REF:
            stack.pop();
            settingValueToken = new CommonToken(ConfmlLexer.Literal);
            resolveAndConvertSettingValue(settingValueTable, token,
                    settingValueToken);
            stack.push(settingValueToken);
            break;

        case ConfmlLexer.SUB_SETTING_REF:
            stack.pop();
            settingValueToken = new CommonToken(ConfmlLexer.Literal);
            resolveAndConvertSettingValue(settingValueTable, token,
                    settingValueToken);
            stack.push(settingValueToken);
            break;

        case ConfmlLexer.FILE_PATH_REF:
            stack.pop();
            settingValueToken = new CommonToken(ConfmlLexer.Literal);
            resolveAndConvertSettingValue(settingValueTable, token,
                    settingValueToken);
            stack.push(settingValueToken);
            break;

        case ConfmlLexer.Literal:
            break;
        }
    }

    private static void resolveAndConvertSettingValue(
            Map<String, String> settingValueTable, Token token,
            CommonToken settingValueToken) {
        String settingRef = token.getText();
        String settingValue = settingValueTable.get(settingRef);
        try {
            new Double(settingValue);
            settingValueToken.setType(ConfmlLexer.Number);
        } catch (Throwable t) {
        }
        settingValueToken.setText(settingValue);
    }

    /**
     * Compares 2 strings or numbers stored in tokens n1 and n2. Then the result
     * stores inside booleanToken and that token puts onto the stack
     * 
     * @param stack execution stack
     * @param n1 number/string token 1
     * @param n2 number/string token 2
     * @param booleanToken result boolean token
     * @param expectedCompareResult expected accepted results of calling
     *            compareTo method
     */
    private static void compareStringsOrNumbersAndUpdateStack(
            Stack<Token> stack, Token n1, Token n2, Token booleanToken,
            int[] expectedCompareResult) {
        Double do1;
        Double do2;
        if (n1.getType() == ConfmlLexer.Literal) {// compare strings
            int compareTo = n1.getText().compareTo(n2.getText());
            if (isContained(compareTo, expectedCompareResult)) {
                booleanToken.setText(ConfmlExpressionEvaluator.TRUE);
            } else {
                booleanToken.setText(ConfmlExpressionEvaluator.FALSE);
            }
            stack.push(booleanToken);
        } else if (n1.getType() == ConfmlLexer.Number) {// compare numbers
            do1 = new Double(n1.getText());
            do2 = new Double(n2.getText());

            int compareTo = do1.compareTo(do2);
            if (isContained(compareTo, expectedCompareResult)) {
                booleanToken.setText(ConfmlExpressionEvaluator.TRUE);
            } else {
                booleanToken.setText(ConfmlExpressionEvaluator.FALSE);
            }
            stack.push(booleanToken);
        } else {
            throw new RuntimeException("Wrong AST tree!");
        }
    }

    /**
     * Method for testing the comparison result. The result of compare operation
     * is known to be positive, zero or negative. This function normalizes the
     * result to 1, 0, or -1 respectively and then invokes the actual lookup.
     * 
     * @param value searched value
     * @param valueList list for searching a value
     * @return Returns <code>true</code> if value is contained in valueList.
     *         Else it returns <code>false</code>;
     */
    private static boolean isContained(int value, int[] valueList) {
        if (value == 0) {
            return isContained0(valueList, 0);
        } else if (value < 0) {
            return isContained0(valueList, -1);
        } else {
            return isContained0(valueList, 1);
        }
    }

    /**
     * Internal method for array lookup
     * 
     * @param valueList Array to check
     * @param expected Value to fine
     * @return <code>true</code> if value is contained inside array
     */
    private static boolean isContained0(int[] valueList, int expected) {
        for (int i = 0; i < valueList.length; i++) {
            if (valueList[i] == expected) {
                return true;
            }
        }
        return false;
    }
}
