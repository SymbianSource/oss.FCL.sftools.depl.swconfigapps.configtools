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
package com.nokia.tools.variant.confml.core.model.application.eval;

import org.eclipse.emf.common.util.EList;

import com.nokia.tools.variant.confml.core.model.application.EConfMLLayer;
import com.nokia.tools.variant.confml.core.model.application.EConfigurationProject;
import com.nokia.tools.vct.confml.expressions.providers.IItemConfmlExpressionProvider;
import com.nokia.tools.vct.confml.expressions.providers.ItemConfmlExpressionProvider;

public class EConfigurationProjectItemProvider extends ItemConfmlExpressionProvider
        implements IItemConfmlExpressionProvider {

    @Override
    public Object getChildItem(Object object, int index) {
        EConfigurationProject context = (EConfigurationProject) object;
        EList<EConfMLLayer> layers = context.getLayers();
        return layers.size() > index ? layers.get(layers.size() - index) : null;
    }
}