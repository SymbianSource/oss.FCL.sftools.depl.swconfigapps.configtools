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
package com.nokia.tools.vct.confml.expressions.providers;

/**
 * Item provider interface for working with ConfML expressions.
 */
public interface IItemConfmlExpressionProvider {
    /**
     * <p>
     * Gets the sub-item context object by referencing current context by
     * sub-item reference id.
     * </p>
     * <p>
     * The current context can be:
     * <ul>
     * <li>ConfML root - The returned context is Feature</li>
     * <li>Feature - The returned context is Setting Data</li>
     * <li>Composite Setting Data - The returned context is Setting Data</li>
     * <li>Sequence Item Data - The returned context is Setting Data</li>
     * </ul>
     * </p>
     * 
     * @param object Context object
     * @param ref Reference to access
     * @return Sub-item reference object
     */
    public Object getChildItem(Object object, String ref);

    /**
     * <p>
     * Gets the sub-item context object by referencing current context by
     * sub-item index.
     * </p>
     * <p>
     * The current context can be:
     * <ul>
     * <li>Sequence Setting Data - The returned context is Sequence Item Data</li>
     * </ul>
     * </p>
     * 
     * @param object Context object
     * @param index Reference to access
     * @return Sub-item reference object
     */
    public Object getChildItem(Object object, int index);

    /**
     * Get value of the object as string.
     * 
     * @param object Context object
     * @return Literal value
     */
    public String getExpressionValue(Object object);

    /**
     * Get the parent context
     * 
     * @param object Context object
     * @return Parent object or <code>null</code> if not accessible
     */
    public Object getParentItem(Object object);

}
