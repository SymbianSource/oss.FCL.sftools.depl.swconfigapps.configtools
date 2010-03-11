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

import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import com.nokia.tools.vct.common.appmodel.EAppSetting;
import com.nokia.tools.vct.common.appmodel.EAppSettingData;
import com.nokia.tools.vct.common.confml.expressions.ecore.IItemConfmlExpressionProvider;
import com.nokia.tools.vct.common.confml.expressions.ecore.ItemConfmlExpressionProvider;

public abstract class EAppSettingDataItemProvider extends ItemConfmlExpressionProvider
        implements IItemConfmlExpressionProvider {

    @Override
    public Object getParentItem(Object object) {
        EAppSettingData context = (EAppSettingData) object;
        EObject parent = context.eContainer();
        if (parent instanceof Map.Entry) {
            return parent.eContainer();
        } else if (parent instanceof EAppSetting) {
            return parent.eContainer().eContainer();
        }

        return parent;
    }
}
