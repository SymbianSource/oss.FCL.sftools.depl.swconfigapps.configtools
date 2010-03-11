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

import org.eclipse.emf.common.util.EList;

import com.nokia.tools.vct.common.appmodel.EConfMLLayer;
import com.nokia.tools.vct.common.appmodel.EConfigurationProject;
import com.nokia.tools.vct.common.confml.expressions.ecore.IItemConfmlExpressionProvider;
import com.nokia.tools.vct.common.confml.expressions.ecore.ItemConfmlExpressionProvider;

public class EConfigurationProjectItemProvider extends ItemConfmlExpressionProvider
        implements IItemConfmlExpressionProvider {

    @Override
    public Object getChildItem(Object object, int index) {
        EConfigurationProject context = (EConfigurationProject) object;
        EList<EConfMLLayer> layers = context.getLayers();
        return layers.size() > index ? layers.get(layers.size() - index) : null;
    }
}
