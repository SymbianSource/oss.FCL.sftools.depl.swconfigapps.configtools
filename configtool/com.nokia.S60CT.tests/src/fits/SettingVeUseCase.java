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

package fits;

import configurationemf.ConfigurationemfFactory;
import configurationemf.Feature;
import configurationemf.ParentSetting;
import configurationemf.RootConf;
import fit.ActionFixture;

public class SettingVeUseCase extends ActionFixture {
	RootConf c1=ConfigurationemfFactory.eINSTANCE.createRootConf();
	RootConf c2=ConfigurationemfFactory.eINSTANCE.createRootConf();
	RootConf c3=ConfigurationemfFactory.eINSTANCE.createRootConf();
	
	ParentSetting s1 = ConfigurationemfFactory.eINSTANCE.createParentSetting();
	
	public SettingVeUseCase(){
		c1.getInclude().add(c2);
		c2.getInclude().add(c3);
		Feature fea = ConfigurationemfFactory.eINSTANCE.createFeature();
		fea.setRef("f1");
		s1.setRef("s1");
		fea.getParentSetting().add(s1);
		c3.getFeature().add(fea);
	}
	
	public void setDefaultValue(String value){
		s1.setConfValue(value, c3);
	}
	public String getTopValue(){
		return s1.getTopValue();
	}
	public String getCurrentValue(){
		return s1.getCurrentValue();
	}
	public void setC2Value(String value){
		s1.setConfValue(value, c2);
	}
	public void setValue(String value){
		s1.setCurrentValue(value);
	}
	public String getDefaultValue(){
		return s1.getDefaultValue();
	}
}
