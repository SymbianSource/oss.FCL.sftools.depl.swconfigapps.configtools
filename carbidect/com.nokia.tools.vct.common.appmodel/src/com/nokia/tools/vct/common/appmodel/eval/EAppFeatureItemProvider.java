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

import com.nokia.tools.vct.common.appmodel.EAppFeature;
import com.nokia.tools.vct.common.appmodel.EAppSetting;
import com.nokia.tools.vct.common.confml.expressions.ecore.IItemConfmlExpressionProvider;
import com.nokia.tools.vct.common.confml.expressions.ecore.ItemConfmlExpressionProvider;

public class EAppFeatureItemProvider extends ItemConfmlExpressionProvider
        implements IItemConfmlExpressionProvider {

    @Override
    public Object getChildItem(Object object, String ref) {
        EAppFeature context = (EAppFeature) object;
        EAppSetting setting = context.getSettings().get(ref);
        return setting == null ? null : setting.getValueInfo();
    }

    @Override
    public Object getParentItem(Object object) {
        EAppFeature context = (EAppFeature) object;
        return context.eContainer().eContainer();
    }
}
