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

package com.nokia.tools.variant.confml.core.model.application;

import com.nokia.tools.variant.confml.core.model.core.ESourceLocator;

/**
 * <!-- begin-user-doc -->
 * <p>
 * A single element of the sequence. The element can represent a data item or
 * template item.
 * </p>
 * <p>
 * An item contains a map of the data sub-elements and also list of URIs of the
 * source data blocks.
 * </p>
 * <!-- end-user-doc -->
 *
 *
 * @see com.nokia.tools.variant.confml.core.model.application.EApplicationPackage#getEAppSequenceDataItem()
 * @model
 * @generated
 */
public interface EAppSequenceDataItem extends EAppDataContainer, ESourceLocator {
} // EAppSequenceDataItem
