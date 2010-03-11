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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.util.BasicExtendedMetaData;
import org.eclipse.emf.ecore.util.ExtendedMetaData;

import configurationemf.ConfigurationemfPackage;

public class XMLCustomizerCONFML {
	/*
	 * Class Frame
	 * the main cell to keep EML customization data
	 * element to customize - elementEMF;
	 * name in xml related to the elementEMF - nameXML;
	 * presentation in XML - presentationXML (ELEMENT,CONTENT,ATTRIBUTE)
	 */
	public class Frame{
		ENamedElement elementEMF=null;
		String nameXML=null;
		int presentationXML;
		
		public Frame(ENamedElement elementEMF,String nameXML,int presentationXML){
			this.elementEMF = elementEMF;
			this.nameXML = nameXML;
			this.presentationXML = presentationXML;
		}
		public ENamedElement getElementEMF() {
			return elementEMF;
		}
		public void setElementEMF(ENamedElement elementEMF) {
			this.elementEMF = elementEMF;
		}
		public String getNameXML() {
			return nameXML;
		}
		public void setNameXML(String nameXML) {
			this.nameXML = nameXML;
		}
		public int getPresentationXML() {
			return presentationXML;
		}
		public void setPresentationXML(int presentationXML) {
			this.presentationXML = presentationXML;
		}
	}

	public static String includeNS = "http://www.w3.org/2001/XInclude";
	public static String confml1 = "http://www.s60.com/xml/confml/1";
	public static String utf16 = "encoding=\"UTF-8\"";
	public static String emptyString = "";
	//XMLCustomization body
	//map for ConfigurationML
	
	ExtendedMetaData extendedMetaData = null;
	
	public static final int SAVE = 0;
	public static final int LOAD = 1;
	
	ConfigurationemfPackage confMLPackage = ConfigurationemfPackage.eINSTANCE; 
	
	//input data
	Frame [] frames = new Frame[]{
		//configuration element, its attributes and elements
		new Frame(confMLPackage.getRootConf(), "configuration",ExtendedMetaData.ELEMENT_FEATURE),
		new Frame(confMLPackage.getRootConf_SubConf(),"configuration",ExtendedMetaData.ELEMENT_WILDCARD_FEATURE),
		new Frame(confMLPackage.getRootConf_Include(),"include",ExtendedMetaData.ELEMENT_WILDCARD_FEATURE),
		new Frame(confMLPackage.getConfiguration_Vers(), "version", ExtendedMetaData.ATTRIBUTE_FEATURE),
		new Frame(confMLPackage.getConfiguration_Name(), "name", ExtendedMetaData.ATTRIBUTE_FEATURE),
		new Frame(confMLPackage.getConfiguration_Feature(), "feature", ExtendedMetaData.ELEMENT_WILDCARD_FEATURE),
		new Frame(confMLPackage.getConfiguration_View(), "view", ExtendedMetaData.ELEMENT_WILDCARD_FEATURE),
		new Frame(confMLPackage.getConfiguration_Data(), "data", ExtendedMetaData.ELEMENT_WILDCARD_FEATURE),
		new Frame(confMLPackage.getRootConf_Rfs(), "rfs", ExtendedMetaData.ELEMENT_WILDCARD_FEATURE),
		//feature's attributes and elements
		new Frame(confMLPackage.getFeature_Name(), "name", ExtendedMetaData.ATTRIBUTE_FEATURE),
		new Frame(confMLPackage.getFeature_Relevant(), "relevant", ExtendedMetaData.ATTRIBUTE_FEATURE),
		new Frame(confMLPackage.getFeature_ParentSetting(), "setting", ExtendedMetaData.ELEMENT_WILDCARD_FEATURE),
		//setting's attribute % elements
		new Frame(confMLPackage.getSetting_Name(),"name",ExtendedMetaData.ATTRIBUTE_FEATURE),
		new Frame(confMLPackage.getSetting_Type(), "type",ExtendedMetaData.ATTRIBUTE_FEATURE),
		new Frame(confMLPackage.getSetting_Constraint(), "constraint",ExtendedMetaData.ATTRIBUTE_FEATURE),
		new Frame(confMLPackage.getSetting_Option(), "option",ExtendedMetaData.ELEMENT_WILDCARD_FEATURE),
		new Frame(confMLPackage.getSetting_Property(), "property",ExtendedMetaData.ELEMENT_FEATURE),
		new Frame(confMLPackage.getSetting_ReadOnly(), "readOnly",ExtendedMetaData.ATTRIBUTE_FEATURE),
		new Frame(confMLPackage.getSetting_Relevant(), "relevant",ExtendedMetaData.ATTRIBUTE_FEATURE),
		new Frame(confMLPackage.getSetting_Required(), "required",ExtendedMetaData.ATTRIBUTE_FEATURE),
		//parent setting's attribute
		new Frame(confMLPackage.getParentSetting_LeafSetting(),"setting",ExtendedMetaData.ELEMENT_WILDCARD_FEATURE),
		new Frame(confMLPackage.getParentSetting_MinOccurs(), "minOccurs",ExtendedMetaData.ATTRIBUTE_FEATURE),
		new Frame(confMLPackage.getParentSetting_MaxOccurs(), "maxOccurs",ExtendedMetaData.ATTRIBUTE_FEATURE),
		new Frame(confMLPackage.getOption_Name(),"name",ExtendedMetaData.ATTRIBUTE_FEATURE),
		new Frame(confMLPackage.getOption_Relevant(),"relevant",ExtendedMetaData.ATTRIBUTE_FEATURE),
		//property's attributes
		new Frame(confMLPackage.getProperty_Name(),"name",ExtendedMetaData.ATTRIBUTE_FEATURE),
		new Frame(confMLPackage.getProperty_Unit(),"unit",ExtendedMetaData.ATTRIBUTE_FEATURE),
		new Frame(confMLPackage.getProperty_Value(),"value",ExtendedMetaData.ATTRIBUTE_FEATURE),
		//view's attribute & elements
//		new Frame(confMLPackage.getView(),"view",ExtendedMetaData.ELEMENT_FEATURE),
		new Frame(confMLPackage.getView_Name(),"name",ExtendedMetaData.ATTRIBUTE_FEATURE),
		new Frame(confMLPackage.getView_ParentGroup(),"group",ExtendedMetaData.ELEMENT_WILDCARD_FEATURE),
		//parent group's group
		new Frame(confMLPackage.getParentGroup_LeafGroup(),"group",ExtendedMetaData.ELEMENT_WILDCARD_FEATURE),
		//group's attribute & elements
		new Frame(confMLPackage.getGroup_Name(),"name",ExtendedMetaData.ATTRIBUTE_FEATURE),
		new Frame(confMLPackage.getGroup_GSetting(),"setting",ExtendedMetaData.ELEMENT_WILDCARD_FEATURE),
		new Frame(confMLPackage.getGroup_Icon(),"icon",ExtendedMetaData.ELEMENT_WILDCARD_FEATURE),
		//CommonAttributes
		new Frame(confMLPackage.getCommonAttr_Id(),"id",ExtendedMetaData.ATTRIBUTE_FEATURE),
		//meta
		new Frame(confMLPackage.getConfiguration_Meta(),"meta",ExtendedMetaData.ELEMENT_FEATURE),
		new Frame(confMLPackage.getView_Meta(),"meta",ExtendedMetaData.ELEMENT_WILDCARD_FEATURE),
		new Frame(confMLPackage.getMeta_Customer(),"customer",ExtendedMetaData.ELEMENT_WILDCARD_FEATURE),
		new Frame(confMLPackage.getMeta_Date(),"date",ExtendedMetaData.ELEMENT_WILDCARD_FEATURE),
		new Frame(confMLPackage.getMeta_Editor(),"editor",ExtendedMetaData.ELEMENT_WILDCARD_FEATURE),
		new Frame(confMLPackage.getMeta_Identification(),"id",ExtendedMetaData.ELEMENT_WILDCARD_FEATURE),
		new Frame(confMLPackage.getMeta_Owner(),"owner",ExtendedMetaData.ELEMENT_WILDCARD_FEATURE),
		new Frame(confMLPackage.getMeta_Platform(),"platform",ExtendedMetaData.ELEMENT_FEATURE),
		new Frame(confMLPackage.getMeta_Product(),"product",ExtendedMetaData.ELEMENT_WILDCARD_FEATURE),
		new Frame(confMLPackage.getMeta_Status(),"status",ExtendedMetaData.ELEMENT_WILDCARD_FEATURE),
		new Frame(confMLPackage.getMeta_Version(),"version",ExtendedMetaData.ELEMENT_WILDCARD_FEATURE),
		new Frame(confMLPackage.getMeta_Release(),"release",ExtendedMetaData.ELEMENT_WILDCARD_FEATURE),
		
		new Frame(confMLPackage.getSetting_MinLength(),"minLength",ExtendedMetaData.ELEMENT_FEATURE),
		new Frame(confMLPackage.getMinLength_Value(),"value",ExtendedMetaData.ATTRIBUTE_FEATURE),
	
		new Frame(confMLPackage.getSetting_MaxLength(),"maxLength",ExtendedMetaData.ELEMENT_WILDCARD_FEATURE),
		new Frame(confMLPackage.getMaxLength_Value(),"value",ExtendedMetaData.ATTRIBUTE_FEATURE),
	
		new Frame(confMLPackage.getSetting_Length(),"length",ExtendedMetaData.ELEMENT_WILDCARD_FEATURE),
		new Frame(confMLPackage.getLength_Value(),"value",ExtendedMetaData.ATTRIBUTE_FEATURE),
	
		new Frame(confMLPackage.getSetting_Pattern(),"pattern",ExtendedMetaData.ELEMENT_WILDCARD_FEATURE),
		new Frame(confMLPackage.getPattern_Value(),"value",ExtendedMetaData.ATTRIBUTE_FEATURE),
	
		new Frame(confMLPackage.getSetting_MaxExclusive(),"maxExclusive",ExtendedMetaData.ELEMENT_WILDCARD_FEATURE),
		new Frame(confMLPackage.getMaxExclusive_Value(),"value",ExtendedMetaData.ATTRIBUTE_FEATURE),
	
		new Frame(confMLPackage.getSetting_MaxInclusive(),"maxInclusive",ExtendedMetaData.ELEMENT_WILDCARD_FEATURE),
		new Frame(confMLPackage.getMaxInclusive_Value(),"value",ExtendedMetaData.ATTRIBUTE_FEATURE),
	
		new Frame(confMLPackage.getSetting_MinInclusive(),"minInclusive",ExtendedMetaData.ELEMENT_WILDCARD_FEATURE),
		new Frame(confMLPackage.getMinInclusive_Value(),"value",ExtendedMetaData.ATTRIBUTE_FEATURE),
	
		new Frame(confMLPackage.getSetting_MinExclusive(),"minExclusive",ExtendedMetaData.ELEMENT_WILDCARD_FEATURE),
		new Frame(confMLPackage.getMinExclusive_Value(),"value",ExtendedMetaData.ATTRIBUTE_FEATURE),
	
		new Frame(confMLPackage.getSetting_TotalDigits(),"totalDigits",ExtendedMetaData.ELEMENT_WILDCARD_FEATURE),
		new Frame(confMLPackage.getTotalDigits_Value(),"value",ExtendedMetaData.ATTRIBUTE_FEATURE),
		
		//common Elements
		new Frame(confMLPackage.getAttributeAndDesc_Desc(),"desc",ExtendedMetaData.ELEMENT_FEATURE),
		
		//Ref
		new Frame(confMLPackage.getRef_Template(),"template",ExtendedMetaData.ATTRIBUTE_FEATURE),
		new Frame(confMLPackage.getRef_ExtensionPolicy(),"extensionPolicy",ExtendedMetaData.ATTRIBUTE_FEATURE),
		new Frame(confMLPackage.getRef_Empty(),"empty",ExtendedMetaData.ATTRIBUTE_FEATURE)
	};
	
	// methods
	public ExtendedMetaData getExtendedMetaData() {
		if(extendedMetaData==null)
			setExtendedMetaData();
		return extendedMetaData;
		
	}

	
	private void setExtendedMetaData() {
		String includens = "http://www.w3.org/2001/XInclude";
		String includePREFIX = "xi";
		String xlinkNS = "http://www.w3.org/1999/xlink";
		String xlinklPREFIX = "xl";
		extendedMetaData = new BasicExtendedMetaData();
		extendedMetaData.putPackage(confMLPackage.getNsURI(), confMLPackage);
		for (int i = 0; i < frames.length; i++) {
			if (frames[i].getElementEMF() instanceof EClass) {
				extendedMetaData.setName((EClass) (frames[i].getElementEMF()),
				    frames[i].getNameXML());
				extendedMetaData.setContentKind((EClass) (frames[i]
				    .getElementEMF()), frames[i].getPresentationXML());
			} else if (frames[i].getElementEMF() instanceof EStructuralFeature) {
				extendedMetaData.setName((EStructuralFeature) (frames[i]
				    .getElementEMF()), frames[i].getNameXML());
				extendedMetaData.setFeatureKind((EStructuralFeature) (frames[i]
				    .getElementEMF()), frames[i].getPresentationXML());
				if (frames[i].getPresentationXML() == ExtendedMetaData.ELEMENT_WILDCARD_FEATURE
				    || frames[i].getPresentationXML() == ExtendedMetaData.ELEMENT_FEATURE)
					extendedMetaData.setNamespace(
					    (EStructuralFeature) (frames[i].getElementEMF()),
					    confMLPackage.getNsURI());
			}
		}
		// xi:include
		EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();

		ePackage.setNsPrefix(includePREFIX);
		ePackage.setNsURI(includens);
		extendedMetaData.putPackage(includens, ePackage);
		extendedMetaData.setNamespace(confMLPackage.getRootConf_Include(),
				includens);

		// xl:href
		ePackage = EcoreFactory.eINSTANCE.createEPackage();
		ePackage.setNsPrefix(xlinklPREFIX);
		ePackage.setNsURI(xlinkNS);
		extendedMetaData.putPackage(xlinkNS, ePackage);
		extendedMetaData.setNamespace(confMLPackage.getDIL_Href(), xlinkNS);
	}
}
