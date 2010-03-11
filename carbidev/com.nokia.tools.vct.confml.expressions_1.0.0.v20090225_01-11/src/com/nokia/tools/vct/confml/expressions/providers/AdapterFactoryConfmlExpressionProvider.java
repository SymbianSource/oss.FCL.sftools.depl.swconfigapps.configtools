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

import org.eclipse.emf.common.notify.AdapterFactory;

import com.nokia.tools.vct.confml.expressions.confml.grammar.ConfMLSettingValuesProvider;
import com.nokia.tools.vct.confml.expressions.confml.grammar.IConfmlSettingValuesProvider;

public class AdapterFactoryConfmlExpressionProvider extends
        ConfMLSettingValuesProvider implements IConfmlSettingValuesProvider {

    private AdapterFactory adapterFactory;
    private static final Class<?> IItemConfmlExpressionProviderClass = IItemConfmlExpressionProvider.class;

    
    
    public AdapterFactoryConfmlExpressionProvider(AdapterFactory adapterFactory) {
        this.adapterFactory = adapterFactory;
    }

    @Override
    public Object getSubItem(Object object, int index) {
        IItemConfmlExpressionProvider provider = (IItemConfmlExpressionProvider) adapterFactory
                .adapt(object, IItemConfmlExpressionProviderClass);
        if (provider == null) {
            return super.getSubItem(object, index);
        } else {
            return provider.getChildItem(object, index);
        }
    }

    @Override
    public Object getSubItem(Object object, String ref) {
        IItemConfmlExpressionProvider provider = (IItemConfmlExpressionProvider) adapterFactory
                .adapt(object, IItemConfmlExpressionProviderClass);
        if (provider == null) {
            return super.getSubItem(object, ref);
        } else {
            return provider.getChildItem(object, ref);
        }
    }

    @Override
    public Object getParentItem(Object object) {
        IItemConfmlExpressionProvider provider = (IItemConfmlExpressionProvider) adapterFactory
                .adapt(object, IItemConfmlExpressionProviderClass);
        if (provider == null) {
            return super.getParentItem(object);
        } else {
            return provider.getParentItem(object);
        }
    }

    @Override
    public String getValue(Object object) {
        IItemConfmlExpressionProvider provider = (IItemConfmlExpressionProvider) adapterFactory
                .adapt(object, IItemConfmlExpressionProviderClass);
        if (provider == null) {
            return super.getValue(object);
        } else {
            return provider.getExpressionValue(object);
        }
    }
}
