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

package com.nokia.tools.vct.common.confml.expressions.ecore;

import org.eclipse.emf.common.notify.impl.AdapterImpl;

/**
 * Base class for item providers.
 */
public class ItemConfmlExpressionProvider extends AdapterImpl implements
        IItemConfmlExpressionProvider {

    public Object getParentItem(Object object) {
        return null;
    }

    public Object getChildItem(Object object, String ref) {
        return null;
    }

    public Object getChildItem(Object object, int index) {
        return null;
    }

    public String getExpressionValue(Object object) {
        return null;
    }

    public void dispose() {

    }

}
