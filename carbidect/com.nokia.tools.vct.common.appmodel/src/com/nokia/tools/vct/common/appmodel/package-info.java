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

/**
 * Package with public interface to application model of ConfML.
 * <p>
 * The application model is a synthetic representation of the ConfML
 * configuration project. It defines resulting view on all the elements in the
 * project in a normalized form.
 * </p>
 * <p>
 * The configuration project is presented as a list of layers with feature sets
 * inside. The model is not intended for serialization and thus does not contain
 * information required for serialization in the original form, however allows
 * construction of the configuration project in a "flattened" form.
 * </p>
 * <p>
 * Some elements provide additional information on the source used for
 * construction. See {@link ESourceLocator} for additional details.
 * </p>
 */
package com.nokia.tools.vct.common.appmodel;


