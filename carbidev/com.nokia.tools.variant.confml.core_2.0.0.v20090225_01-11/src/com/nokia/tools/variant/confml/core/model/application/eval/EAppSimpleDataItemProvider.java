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

import com.nokia.tools.variant.confml.core.model.application.EAppSimpleData;
import com.nokia.tools.vct.confml.expressions.providers.IItemConfmlExpressionProvider;

public class EAppSimpleDataItemProvider extends
        EAppSettingDataItemProvider implements IItemConfmlExpressionProvider {

    @Override
    public String getExpressionValue(Object object) {
        EAppSimpleData context = (EAppSimpleData) object;
        return context.getValue();
    }

}
