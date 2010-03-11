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
 * Description: This file is part of com.nokia.tools.vct.common.appmodel component.
 */

package com.nokia.tools.vct.common.appmodel.eval;

import com.nokia.tools.vct.common.confml.expressions.ConfMLExpressionsPlugin;
import com.nokia.tools.vct.common.confml.expressions.ecore.AdapterFactoryConfmlExpressionProvider;

/**
 * <p>
 * Helper class to remove runtime class loading dependency between application
 * model and expression evaluation plugin.
 * </p>
 */
public class ExpressionEvaluationHelper {

	/**
	 * Compute expression with boolean result.
	 * 
	 * @param evaluationContext Compiled expression
	 * @param contextRoot Evaluation context root
	 * @param contextThis Evaluation context
	 * @return Expression evaluation result
	 */
	public static boolean computeBoolean(Object evaluationContext,
			Object contextRoot, Object contextThis) {
		EApplicationModelItemProviderAdapterFactory adapterFactory = new EApplicationModelItemProviderAdapterFactory();
		AdapterFactoryConfmlExpressionProvider provider = new AdapterFactoryConfmlExpressionProvider(
				adapterFactory);
		boolean result = ConfMLExpressionsPlugin.evaluateBooleanExpression(
				evaluationContext, provider, contextRoot, contextThis);
		return result;
	}

	/**
	 * Compile expression
	 * 
	 * @param literal Source string to compile
	 * @return Compiled expression object
	 */
	public static Object compileExpression(String literal) {
		return ConfMLExpressionsPlugin.compileExpression(literal);
	}

}
