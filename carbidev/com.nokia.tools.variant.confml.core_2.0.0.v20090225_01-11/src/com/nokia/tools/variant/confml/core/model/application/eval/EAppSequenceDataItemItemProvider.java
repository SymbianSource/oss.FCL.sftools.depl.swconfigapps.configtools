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

import com.nokia.tools.variant.confml.core.model.application.EAppSequenceData;
import com.nokia.tools.vct.confml.expressions.providers.IItemConfmlExpressionProvider;

public class EAppSequenceDataItemItemProvider extends
        EAppSettingDataItemProvider implements IItemConfmlExpressionProvider {

    @Override
    public Object getChildItem(Object object, int index) {
        EAppSequenceData context = (EAppSequenceData)object;
        
        return context.getItems().size() < index ? context.getItems().get(index) : null;
    }
    
}
