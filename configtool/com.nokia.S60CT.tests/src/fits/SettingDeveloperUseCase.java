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

import configurationemf.Configuration;
import configurationemf.ConfigurationemfFactory;
import configurationemf.Feature;
import configurationemf.ParentSetting;
import fit.ActionFixture;

public class SettingDeveloperUseCase extends ActionFixture {
	Configuration conf=null;
	Feature f1=null;
	Feature f2=null;
	ParentSetting s1=null;
	ParentSetting s2=null;
	public void createConfiguration(){
		conf=ConfigurationemfFactory.eINSTANCE.createRootConf();
	}
	public void createF1(){
		f1=ConfigurationemfFactory.eINSTANCE.createFeature();
		f1.setRef("f1");
		conf.getFeature().add(f1);
	}
	public void createS1inF1(){
		s1=ConfigurationemfFactory.eINSTANCE.createParentSetting();
		s1.setRef("s1");
		f1.getParentSetting().add(s1);
	}
	public void setS1Value(String value){
		s1.setCurrentValue(value);
	}
	public String getCurrentS1Value(){
		return s1.getCurrentValue();
	}
	public String getTopS1Value(){
		return s1.getTopValue();
	}
	public String getDefaultS1Value(){
		return s1.getDefaultValue();
	}
	public void createF2(){
		f2=ConfigurationemfFactory.eINSTANCE.createFeature();
		f2.setRef("f2");
		conf.getFeature().add(f2);
	}
	public void moveS1toF2(){
		f2.getParentSetting().add(s1);
	}
	public void createS2inF2(){
		s2=ConfigurationemfFactory.eINSTANCE.createParentSetting();
		s2.setRef("s2");
		f2.getParentSetting().add(s2);
	}
	public void setS2Value(String value){
		s2.setCurrentValue(value);
	}
	public void makeEqualRef(){
		s2.setRef(s1.getRef());
	}
	public String getCurrentS2Value(){
		return s2.getCurrentValue();
	}
	public void moveS2toF1(){
		f1.getParentSetting().add(s2);
	}
}
