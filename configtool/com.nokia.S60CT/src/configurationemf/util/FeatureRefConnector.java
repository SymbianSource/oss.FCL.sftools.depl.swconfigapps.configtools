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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EStructuralFeature;

import configurationemf.ConfigurationemfFactory;
import configurationemf.ConfigurationemfPackage;
import configurationemf.Data;
import configurationemf.Feature;
import configurationemf.ParentSetting;
import configurationemf.Ref;
import configurationemf.RootConf;
import configurationemf.SubConf;


public class FeatureRefConnector{
	private RootConf root=null;
	private List<Feature> featureRepository=null;
	private List<Ref> refRepository=null;
	private List<Ref> notConnectedRFSRefs = new ArrayList<Ref>();
	
	private static final EStructuralFeature CONF_DATA = ConfigurationemfPackage.eINSTANCE.getConfiguration_Data();
	private static final EStructuralFeature CONF_RFS = ConfigurationemfPackage.eINSTANCE.getRootConf_Rfs();
	
	public FeatureRefConnector(RootConf root){
		this.root = root;
	}
	private List<Feature> collectFeatures(){
		if(featureRepository==null){
			featureRepository=new ArrayList<Feature>();
			collectFeatures(root);
		}
		return featureRepository;
	}
	private void collectRefs(EStructuralFeature sFeature){
		if(refRepository==null)refRepository = new ArrayList<Ref>();
		refRepository.clear();
		notConnectedRFSRefs.clear();
		collectRefs(root, sFeature);
	}
	private void collectRefs(RootConf configuration,EStructuralFeature sFeature){
		Data data = (Data)configuration.eGet(sFeature);
		if(data!=null)
			refRepository.addAll(removeDuplicateRef(data.getRef()));
		for(Iterator<RootConf> itrIncConf=configuration.getInclude().iterator(); itrIncConf.hasNext();){
			RootConf conf=(RootConf)itrIncConf.next();
			this.collectRefs(conf,sFeature);
		}
	}
	private Collection<? extends Ref> removeDuplicateRef(EList<Ref> refs) {
		Map<String,Ref> noDpl = new HashMap<String, Ref>();
		for(Iterator<Ref> theRef=refs.iterator();theRef.hasNext();){
			Ref ref = theRef.next();
			Ref temp = noDpl.get(ref.getName());
			if(temp!=null){
				theRef.remove();
				temp.getRef().addAll(ref.getRef());
			}else
				noDpl.put(ref.getName(), ref);
		}
		return noDpl.values();
	}

	private void collectFeatures(RootConf configuration){
		featureRepository.addAll(configuration.getFeature());
		for(Iterator<SubConf> itrSubConf=configuration.getSubConf().iterator(); itrSubConf.hasNext();){
			SubConf conf=(SubConf)itrSubConf.next();
			featureRepository.addAll(conf.getFeature());
		}
		for(Iterator<RootConf> itrIncConf=configuration.getInclude().iterator(); itrIncConf.hasNext();){
			RootConf conf=(RootConf)itrIncConf.next();
			this.collectFeatures(conf);
		}		
		 
	}
	public void connectData(){
		collectFeatures();
		collectRefs(CONF_DATA);
		for(Iterator<Feature> itrFeature=featureRepository.iterator(); itrFeature.hasNext();){
			Feature feature=(Feature)itrFeature.next();
			List<Ref> refs=getRefObject(feature.getRef());
			for (Ref ref : refs) {
				if(ref!=null){
					feature.getRefs().add(ref);
					connectSettingsToValue(feature, ref);
				}
			}
		}
	}
	
	public void reset(){
		featureRepository=null;
		refRepository=null;
		notConnectedRFSRefs.clear();
	}
	public void connectRfs()throws SettingNotFound{
		collectFeatures();
		collectRefs(CONF_RFS);
		for(Iterator<Ref> itrRef=refRepository.iterator(); itrRef.hasNext();){
			Ref ref = itrRef.next();
			Feature feature = getFeature(ref.getName());
			if(feature!=null){
				feature.getRfsRefs().add(ref);
				connectSettingsToRfs(feature, ref);
			}else{
				notConnectedRFSRefs.add(ref);
			}
		}
		if(!notConnectedRFSRefs.isEmpty()){
			SettingNotFound exception = new SettingNotFound(notConnectedRFSRefs);
		}
	}
	
	private Feature getFeature(String str){
		Feature result=null;
		if(str!=null){
			for(Iterator<Feature> itrFeature=featureRepository.iterator();itrFeature.hasNext()&&result==null;){
				Feature feature=itrFeature.next();
				String ref = feature.getRef();
				if(ref!=null&&str.compareTo(ref)== 0)
					result=feature;
				
			}
		}
		return result;
	}
	
	private List<Ref> getRefObject(String refString) {
		List refs = new ArrayList();
		if(refString!=null){
			for(Iterator<Ref> itrRef=refRepository.iterator();itrRef.hasNext();){
				Ref refInRep=itrRef.next();
				if(refInRep.getName()!=null&&refString.compareTo(refInRep.getName())== 0)
					refs.add(refInRep);
				
			}
		}
		return refs;
	}
		
	private void connectSettingsToValue(Feature feature, Ref ref){
		for(Iterator<ParentSetting> itrSetting=feature.getParentSetting().iterator();itrSetting.hasNext();){
			ParentSetting setting=itrSetting.next();
			for(Iterator<Ref> itrRef=ref.getRef().iterator(); itrRef.hasNext();){
				Ref refChild=itrRef.next();
				if(refChild.getName().compareTo(setting.getRef())==0){
					setting.getRefs().add(refChild);
//					break;
				}
				
			}
			
		}
	}
	private void connectSettingsToRfs(Feature feature, Ref ref){
		for(Iterator<ParentSetting> itrSetting=feature.getParentSetting().iterator();itrSetting.hasNext();){
			ParentSetting setting=itrSetting.next();
			for(Iterator<Ref> itrRef=ref.getRef().iterator(); itrRef.hasNext();){
				Ref refChild=itrRef.next();
				if(refChild.getName().compareTo(setting.getRef())==0){
					setting.getRfsRefs().add(refChild);
					break;
				}
				
			}
			
		}
	}
	public class SettingNotFound extends Exception {
		public List<Ref> notConnectedRefs;
		public SettingNotFound(List<Ref> notConnectedRefs){
			this.notConnectedRefs=notConnectedRefs;
		}
	};
}
