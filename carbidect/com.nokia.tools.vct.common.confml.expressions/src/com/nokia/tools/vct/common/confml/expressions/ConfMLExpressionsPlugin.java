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
 * Description: This file is part of com.nokia.tools.vct.common.confml.expressions component.
 */

package com.nokia.tools.vct.common.confml.expressions;

import java.util.List;

import org.antlr.runtime.tree.CommonTree;
import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

import com.nokia.tools.vct.internal.common.confml.expressions.ConfmlExpressionEvaluator;

/**
 * The activator class controls the plug-in life cycle
 */
public class ConfMLExpressionsPlugin extends Plugin {

    // The plug-in ID
    public static final String PLUGIN_ID = "com.nokia.tools.vct.common.confml.expressions";

    // The shared instance
    private static ConfMLExpressionsPlugin plugin;

    /**
     * The constructor
     */
    public ConfMLExpressionsPlugin() {
    }

    /*
     * (non-Javadoc)
     * @see
     * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
     * )
     */
    public void start(BundleContext context) throws Exception {
        super.start(context);
        plugin = this;
    }

    /*
     * (non-Javadoc)
     * @see
     * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
     * )
     */
    public void stop(BundleContext context) throws Exception {
        plugin = null;
        super.stop(context);
    }

    /**
     * Returns the shared instance
     * 
     * @return the shared instance
     */
    public static ConfMLExpressionsPlugin getDefault() {
        return plugin;
    }

    /**
     * Compile expression into binary form
     * 
     * @param expression Expression to compile
     * @return Binary form
     */
    public static Object compileExpression(String expression) {
        return new ConfmlExpressionEvaluator(expression)
                .createASTFromConfmlExpression();
    }

    
    /**
     * Evaluate expression as a boolean
     *
     * @param expression Compiled expression
     * @param provider Values provider
     * @param root Confml root object
     * @param context current confml object
     * @return Evaluation result as boolean.
     */
    public static boolean evaluateBooleanExpression(Object expression,
            IConfMLSettingValuesProvider provider, Object root, Object context) {
        return ConfmlExpressionEvaluator.evaluateConfmlAST(
                (CommonTree) expression, provider, root, context);
    }

	public static List<Object> getSetttingReferences(Object expression,
			IConfMLSettingValuesProvider settingValuesProvider, Object root,
			Object context) {
		return ConfmlExpressionEvaluator.getSetttingReferences((CommonTree)expression,
				settingValuesProvider, root, context);
	}

}
