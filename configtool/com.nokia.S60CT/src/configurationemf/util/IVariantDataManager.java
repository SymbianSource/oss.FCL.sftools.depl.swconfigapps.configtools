/*
* Copyright (c) 2009 Nokia Corporation and/or its subsidiary(-ies). 
* All rights reserved.
* This component and the accompanying materials are made available
* under the terms of "Eclipse Public License v1.0"
* which accompanies this distribution, and is available
* at the URL "http://www.eclipse.org/legal/epl-v10.html".
*
* Initial Contributors:
* Nokia Corporation - initial contribution.
*
* Contributors:
*
* Description:
*
*/

package configurationemf.util;

import java.util.Map;
import java.util.Set;

import variantdata.VariantData;
import configurationemf.RootConf;
import configurationemf.Setting;

public interface IVariantDataManager {

	public abstract Set<String> importValues(RootConf rootConf,
			Map<String, String> vdMap, Map<Setting, Object> map);

	public abstract Map<String, String> getSingleVDMap(VariantData vd);

	public abstract Map<String, String> getChainVDMap(VariantData vd);

}