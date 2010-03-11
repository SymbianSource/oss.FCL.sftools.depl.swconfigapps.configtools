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
package variantdata.util;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.util.BasicExtendedMetaData;
import org.eclipse.emf.ecore.util.ExtendedMetaData;

import variantdata.VariantDataPackage;



public class XMLCustomizerVD {
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
		
		VariantDataPackage vdPackage = VariantDataPackage.eINSTANCE; 
		
		//input data
		Frame [] frames = new Frame[]{
			new Frame(vdPackage.getVariantData(), "Variant",ExtendedMetaData.ELEMENT_FEATURE),
		};
		
		// methods
		public ExtendedMetaData getExtendedMetaData() {
			if(extendedMetaData==null)
				setExtendedMetaData();
			return extendedMetaData;
			
		}

		
		private void setExtendedMetaData() {
			String includeNS = "http://www.w3.org/2001/xinclude";
			String includePREFIX = "xi";
			extendedMetaData = new BasicExtendedMetaData();
			extendedMetaData.putPackage(null, vdPackage);
			for (int i = 0; i < frames.length; i++) {
				if(frames[i].getElementEMF() instanceof EClass){
					extendedMetaData.setName((EClass)(frames[i].getElementEMF()), frames[i].getNameXML());
					extendedMetaData.setContentKind((EClass)(frames[i].getElementEMF()), frames[i].getPresentationXML());
				}
				else if(frames[i].getElementEMF() instanceof EStructuralFeature){
					extendedMetaData.setName((EStructuralFeature)(frames[i].getElementEMF()), frames[i].getNameXML());
					extendedMetaData.setFeatureKind((EStructuralFeature)(frames[i].getElementEMF()), frames[i].getPresentationXML());
					if(frames[i].getPresentationXML()==ExtendedMetaData.ELEMENT_WILDCARD_FEATURE||frames[i].getPresentationXML()==ExtendedMetaData.ELEMENT_FEATURE)
						extendedMetaData.setNamespace((EStructuralFeature)(frames[i].getElementEMF()),vdPackage.getNsURI());
				}
			}
			//xi:include
			EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
			ePackage.setNsPrefix(includePREFIX);
			ePackage.setNsURI(includeNS);
			extendedMetaData.putPackage(includeNS, ePackage);
			extendedMetaData.setNamespace(vdPackage.getVariantData_Include(),includeNS);
		}

}
