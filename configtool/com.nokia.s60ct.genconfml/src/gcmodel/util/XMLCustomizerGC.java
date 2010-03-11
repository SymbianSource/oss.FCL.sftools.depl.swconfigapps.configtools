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
package gcmodel.util;

import gcmodel.GcmodelPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.BasicExtendedMetaData;
import org.eclipse.emf.ecore.util.ExtendedMetaData;

public class XMLCustomizerGC {
	/**
	 * 
	 */
	public class Frame
	{
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
	
	GcmodelPackage gcpackage = GcmodelPackage.eINSTANCE; 
	
	//input data
	Frame[] frames = new Frame[]
	{
		//configuration element, its attributes and elements
		new Frame(gcpackage.getFile(), "file",ExtendedMetaData.ELEMENT_FEATURE),
		new Frame(gcpackage.getFile_Name(), "name",ExtendedMetaData.ATTRIBUTE_FEATURE),
		new Frame(gcpackage.getFile_Settings(),"setting",ExtendedMetaData.ELEMENT_WILDCARD_FEATURE),
		new Frame(gcpackage.getSetting_Ref(),"ref",ExtendedMetaData.ATTRIBUTE_FEATURE)
	};
	
	public ExtendedMetaData getExtendedMetaData() {
		if(extendedMetaData==null)
			setExtendedMetaData();
		return extendedMetaData;
		
	}
	
	private void setExtendedMetaData() {
		extendedMetaData = new BasicExtendedMetaData();
		extendedMetaData.putPackage(gcpackage.getNsURI(), gcpackage);
		//extendedMetaData.setNamespace(confMLPackage.getConfiguration_Feature(),confMLPackage.getNsURI());
		for (int i = 0; i < frames.length; i++) {
			if(frames[i].getElementEMF() instanceof EClass){
				extendedMetaData.setName((EClass)(frames[i].getElementEMF()), frames[i].getNameXML());
				extendedMetaData.setContentKind((EClass)(frames[i].getElementEMF()), frames[i].getPresentationXML());
			}
			else if(frames[i].getElementEMF() instanceof EStructuralFeature){
				extendedMetaData.setName((EStructuralFeature)(frames[i].getElementEMF()), frames[i].getNameXML());
				extendedMetaData.setFeatureKind((EStructuralFeature)(frames[i].getElementEMF()), frames[i].getPresentationXML());
				if(frames[i].getPresentationXML()==ExtendedMetaData.ELEMENT_WILDCARD_FEATURE)
					extendedMetaData.setNamespace((EStructuralFeature)(frames[i].getElementEMF()),gcpackage.getNsURI());
			}
		}
	}
}
