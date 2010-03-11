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

public class ConfMLSettingValuesProvider implements
        IConfMLSettingValuesProvider {

    public ConfMLSettingValuesProvider() {
    }

    /**
     * Default implementation of the sub-item access method. User shall
     * override.
     * 
     * @return <code>null</code>
     * @see IConfMLSettingValuesProvider#getSubItem(Object, String)
     */
    public Object getSubItem(Object object, String ref) {
        return null;
    }

    /**
     * Default implementation of the sub-item access method. User shall
     * override.
     * 
     * @return <code>null</code>
     * @see IConfMLSettingValuesProvider#getSubItem(Object, int)
     */
    public Object getSubItem(Object object, int index) {
        return null;
    }

    /**
     * Default implementation of the parent item access method. User shall
     * override.
     * 
     * @return <code>null</code>
     * @see IConfMLSettingValuesProvider#getParentItem(Object)
     */
    public Object getParentItem(Object object) {
        return null;
    }

    /**
     * Default implementation of the literal value access method. User shall
     * override.
     * 
     * @return <code>null</code>
     * @see IConfMLSettingValuesProvider#getParentItem(Object)
     */
    public String getValue(Object object) {
        return null;
    }

}
