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
 * Description: This file is part of com.nokia.tools.variant.confml.core component.
 */

package com.nokia.tools.variant.confml.core.model.application.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import com.nokia.tools.variant.confml.core.model.application.EAppExpression;
import com.nokia.tools.variant.confml.core.model.application.EApplicationPackage;
import com.nokia.tools.variant.confml.core.model.application.eval.EApplicationModelItemProviderAdapterFactory;
import com.nokia.tools.vct.confml.expressions.ConfMLExpressionsPlugin;
import com.nokia.tools.vct.confml.expressions.providers.AdapterFactoryConfmlExpressionProvider;

/**
 * <!-- begin-user-doc -->
 * <p>
 * Expression evaluator for application model. This class integrates with ConfML
 * expression evaluation APi and uses application model adapters for providing
 * evaluation context. The literal expression is compiled on the first use.
 * </p>
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link com.nokia.tools.variant.confml.core.model.application.impl.EAppExpressionImpl#getLiteral
 * <em>Literal</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class EAppExpressionImpl extends EObjectImpl implements EAppExpression {
    /**
     * The default value of the '{@link #getLiteral() <em>Literal</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getLiteral()
     * @generated
     * @ordered
     */
    protected static final String LITERAL_EDEFAULT = null;
    /**
     * The cached value of the '{@link #getLiteral() <em>Literal</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getLiteral()
     * @generated
     * @ordered
     */
    protected String literal = LITERAL_EDEFAULT;

    protected Object evaluationContext;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected EAppExpressionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return EApplicationPackage.Literals.EAPP_EXPRESSION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getLiteral() {
        return literal;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setLiteral(String newLiteral) {
        String oldLiteral = literal;
        literal = newLiteral;
        evaluationContext = null;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    EApplicationPackage.EAPP_EXPRESSION__LITERAL, oldLiteral,
                    literal));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     */
    public boolean computeBoolean(final Object contextRoot,
            final Object contextThis) {
        if (literal == null || literal.length() == 0) {
            // quick check - if there is no expression, then the result is TRUE
            return true;
        }

        if (evaluationContext == null) {
            evaluationContext = ConfMLExpressionsPlugin
                    .compileExpression(literal);
        }

        if (evaluationContext == null) {
            return false;
        } else {
            EApplicationModelItemProviderAdapterFactory adapterFactory = new EApplicationModelItemProviderAdapterFactory();
            AdapterFactoryConfmlExpressionProvider provider = new AdapterFactoryConfmlExpressionProvider(
                    adapterFactory);
            boolean result = ConfMLExpressionsPlugin.evaluateBooleanExpression(
                    evaluationContext, provider, contextRoot, contextThis);
            return result;
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case EApplicationPackage.EAPP_EXPRESSION__LITERAL:
            return getLiteral();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case EApplicationPackage.EAPP_EXPRESSION__LITERAL:
            setLiteral((String) newValue);
            return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
        case EApplicationPackage.EAPP_EXPRESSION__LITERAL:
            setLiteral(LITERAL_EDEFAULT);
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
        case EApplicationPackage.EAPP_EXPRESSION__LITERAL:
            return LITERAL_EDEFAULT == null ? literal != null
                    : !LITERAL_EDEFAULT.equals(literal);
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy())
            return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (literal: ");
        result.append(literal);
        result.append(')');
        return result.toString();
    }

} // EAppExpressionImpl
