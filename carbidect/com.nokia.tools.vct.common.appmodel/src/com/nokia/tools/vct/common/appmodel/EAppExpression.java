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

package com.nokia.tools.vct.common.appmodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * <p>
 * Application expression container used for expression evaluation in the ConfML
 * domain. The expression must be attached to the container type and can be used
 * for value evaluation.
 * </p>
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.EAppExpression#getLiteral <em>Literal</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEAppExpression()
 * @model
 * @generated
 */
public interface EAppExpression extends EObject {

    /**
	 * Returns the value of the '<em><b>Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <p>
     * Get the literal value of the ConfML expression
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Literal</em>' attribute.
	 * @see #setLiteral(String)
	 * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEAppExpression_Literal()
	 * @model
	 * @generated
	 */
    String getLiteral();

    /**
	 * Sets the value of the '{@link com.nokia.tools.vct.common.appmodel.EAppExpression#getLiteral <em>Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <p>
     * Set the literal value of the ConfML expression
     * </p>
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Literal</em>' attribute.
	 * @see #getLiteral()
	 * @generated
	 */
    void setLiteral(String value);

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @model required="true" contextRootRequired="true" contextThisRequired="true"
	 * @generated
	 */
    boolean computeBoolean(Object contextRoot, Object contextThis);
} // EAppExpression
