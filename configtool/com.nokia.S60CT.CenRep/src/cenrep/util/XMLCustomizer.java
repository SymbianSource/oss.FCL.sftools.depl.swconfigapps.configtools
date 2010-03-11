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
package cenrep.util;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.BasicExtendedMetaData;
import org.eclipse.emf.ecore.util.ExtendedMetaData;

import cenrep.CenrepPackage;


public class XMLCustomizer {
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
	
	//XMLCustomization body
	//map for ConfigurationML
	
	ExtendedMetaData extendedMetaData = null;
	
	public static final int SAVE = 0;
	public static final int LOAD = 1;
	
	CenrepPackage cenrepPackage = CenrepPackage.eINSTANCE; 
	
	//input data
	Frame [] frames = new Frame[]{
		//repository with its content
		new Frame(cenrepPackage.getRepository(), "repository",ExtendedMetaData.ELEMENT_FEATURE),
		new Frame(cenrepPackage.getRepository_Key(),"key",ExtendedMetaData.ELEMENT_WILDCARD_FEATURE),
		new Frame(cenrepPackage.getRepository_RangeKey(),"keyRange",ExtendedMetaData.ELEMENT_WILDCARD_FEATURE),
		new Frame(cenrepPackage.getRepository_Meta(), "meta", ExtendedMetaData.ELEMENT_WILDCARD_FEATURE),
		//repository attributes
		new Frame(cenrepPackage.getRepository_Version(), "version", ExtendedMetaData.ATTRIBUTE_FEATURE),
		new Frame(cenrepPackage.getRepository_UidName(), "uidName", ExtendedMetaData.ATTRIBUTE_FEATURE),
		new Frame(cenrepPackage.getRepository_UidValue(), "uidValue", ExtendedMetaData.ATTRIBUTE_FEATURE),
		new Frame(cenrepPackage.getRepository_InitialisationFileVersion(), "initialisationFileVersion", ExtendedMetaData.ATTRIBUTE_FEATURE),
		new Frame(cenrepPackage.getRepository_Owner(), "owner", ExtendedMetaData.ATTRIBUTE_FEATURE),
		//meta
		new Frame(cenrepPackage.getRepository_Meta(),"meta",ExtendedMetaData.ELEMENT_WILDCARD_FEATURE),
		new Frame(cenrepPackage.getMeta_Date(),"date",ExtendedMetaData.ELEMENT_FEATURE),
		new Frame(cenrepPackage.getMeta_Editor(),"editor",ExtendedMetaData.ELEMENT_FEATURE),
		new Frame(cenrepPackage.getMeta_Identification(),"id",ExtendedMetaData.ELEMENT_FEATURE),
		new Frame(cenrepPackage.getMeta_Owner(),"owner",ExtendedMetaData.ELEMENT_FEATURE),
		new Frame(cenrepPackage.getMeta_Platform(),"platform",ExtendedMetaData.ELEMENT_FEATURE),
		new Frame(cenrepPackage.getMeta_Product(),"product",ExtendedMetaData.ELEMENT_FEATURE),
		new Frame(cenrepPackage.getMeta_Status(),"status",ExtendedMetaData.ELEMENT_FEATURE),
		new Frame(cenrepPackage.getMeta_Version(),"version",ExtendedMetaData.ELEMENT_FEATURE),
		//key content
//		new Frame(cenrepPackage.getKey_Access(), "access", ExtendedMetaData.ELEMENT_WILDCARD_FEATURE),
		new Frame(cenrepPackage.getKey_Value(), "value", ExtendedMetaData.ELEMENT_WILDCARD_FEATURE),
		//key attribute
		new Frame(cenrepPackage.getKey_Name(), "name", ExtendedMetaData.ATTRIBUTE_FEATURE),
		new Frame(cenrepPackage.getKey_Ident(), "int", ExtendedMetaData.ATTRIBUTE_FEATURE),
		new Frame(cenrepPackage.getKey_Type(), "type", ExtendedMetaData.ATTRIBUTE_FEATURE),
//		new Frame(cenrepPackage.getKey_ReadOnly(), "readOnly", ExtendedMetaData.ATTRIBUTE_FEATURE),
		new Frame(cenrepPackage.getIBackup_Backup(), "backup", ExtendedMetaData.ATTRIBUTE_FEATURE),
		//keyRange content
//		new Frame(cenrepPackage.getKeyRange_Access(), "access", ExtendedMetaData.ELEMENT_WILDCARD_FEATURE),
		new Frame(cenrepPackage.getKeyRange_Keys(), "key", ExtendedMetaData.ELEMENT_WILDCARD_FEATURE),
		//keyRange attribute
		new Frame(cenrepPackage.getKeyRange_Name(), "name", ExtendedMetaData.ATTRIBUTE_FEATURE),
		new Frame(cenrepPackage.getKeyRange_Int(), "int", ExtendedMetaData.ATTRIBUTE_FEATURE),
		new Frame(cenrepPackage.getKeyRange_FirstInt(), "firstInt", ExtendedMetaData.ATTRIBUTE_FEATURE),
		new Frame(cenrepPackage.getKeyRange_LastInt(), "lastInt", ExtendedMetaData.ATTRIBUTE_FEATURE),
		new Frame(cenrepPackage.getKeyRange_IndexBits(), "indexBits", ExtendedMetaData.ATTRIBUTE_FEATURE),
		new Frame(cenrepPackage.getKeyRange_FirstIndex(), "firstIndex", ExtendedMetaData.ATTRIBUTE_FEATURE),
		new Frame(cenrepPackage.getKeyRange_CountInt(), "countInt", ExtendedMetaData.ATTRIBUTE_FEATURE),
//		new Frame(cenrepPackage.getKeyRange_ReadOnly(), "readOnly", ExtendedMetaData.ATTRIBUTE_FEATURE),
//		new Frame(cenrepPackage.getKeyRange_Backup(), "backup", ExtendedMetaData.ATTRIBUTE_FEATURE),
		
		// access attributes
		new Frame(cenrepPackage.getAccess_Type(), "type", ExtendedMetaData.ATTRIBUTE_FEATURE),
		new Frame(cenrepPackage.getAccess_Capabilities(), "capabilities", ExtendedMetaData.ATTRIBUTE_FEATURE),
		new Frame(cenrepPackage.getAccess_Sid(), "sid", ExtendedMetaData.ATTRIBUTE_FEATURE),
		// value attributes
		new Frame(cenrepPackage.getRVG_Ref(), "ref", ExtendedMetaData.ATTRIBUTE_FEATURE),
		new Frame(cenrepPackage.getValue_Val(), "value", ExtendedMetaData.ATTRIBUTE_FEATURE),
		// bit and attribute
		new Frame(cenrepPackage.getKey_Bits(),"bit",ExtendedMetaData.ELEMENT_WILDCARD_FEATURE),
		new Frame(cenrepPackage.getBit_State(),"value",ExtendedMetaData.ATTRIBUTE_FEATURE),
		// commonAttrs
		new Frame(cenrepPackage.getCommonAttrs_Id(),"id",ExtendedMetaData.ATTRIBUTE_FEATURE),
		//common elements
		new Frame(cenrepPackage.getAttributeAndDescription_Desc(),"desc",ExtendedMetaData.ELEMENT_FEATURE),
		new Frame(cenrepPackage.getIReadOnly_ReadOnly(), "readOnly", ExtendedMetaData.ATTRIBUTE_FEATURE),
		new Frame(cenrepPackage.getIAccessable_Access(), "access", ExtendedMetaData.ELEMENT_WILDCARD_FEATURE)
	
	};
	
	// methods
	public ExtendedMetaData getExtendedMetaData() {
		if(extendedMetaData==null)
			setExtendedMetaData();
		return extendedMetaData;
	}

	
	private void setExtendedMetaData() {
		extendedMetaData = new BasicExtendedMetaData();
		extendedMetaData.putPackage(cenrepPackage.getNsURI(), cenrepPackage);
		//extendedMetaData.setNamespace(confMLPackage.getConfiguration_Feature(),confMLPackage.getNsURI());
		for (int i = 0; i < frames.length; i++) {
			if(frames[i].getElementEMF() instanceof EClass){
				extendedMetaData.setName((EClass)(frames[i].getElementEMF()), frames[i].getNameXML());
				extendedMetaData.setContentKind((EClass)(frames[i].getElementEMF()), frames[i].getPresentationXML());
			}
			else if(frames[i].getElementEMF() instanceof EStructuralFeature){
				extendedMetaData.setName((EStructuralFeature)(frames[i].getElementEMF()), frames[i].getNameXML());
				extendedMetaData.setFeatureKind((EStructuralFeature)(frames[i].getElementEMF()), frames[i].getPresentationXML());
				if(frames[i].getPresentationXML()==ExtendedMetaData.ELEMENT_WILDCARD_FEATURE||frames[i].getPresentationXML()==ExtendedMetaData.ELEMENT_FEATURE)
					extendedMetaData.setNamespace((EStructuralFeature)(frames[i].getElementEMF()),cenrepPackage.getNsURI());
			}
		}
	}

}

