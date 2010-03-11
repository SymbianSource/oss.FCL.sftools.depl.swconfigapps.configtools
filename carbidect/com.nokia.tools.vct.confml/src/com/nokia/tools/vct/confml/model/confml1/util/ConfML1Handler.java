/*
 * Copyright (c) 2009-2010 Nokia Corporation and/or its subsidiary(-ies).
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
 * Description: This file is part of com.nokia.tools.vct.confml component.
 */

package com.nokia.tools.vct.confml.model.confml1.util;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.SAXXMLHandler;
import org.eclipse.emf.ecore.xmi.impl.XMLHandler;
import org.eclipse.emf.ecore.xml.type.AnyType;

import com.nokia.tools.vct.confml.model.confml1.EConfML1Package;
import com.nokia.tools.vct.confml.model.confml1.EDataElement;
import com.nokia.tools.vct.confml.model.confml1.ERefNamedElement;
import com.nokia.tools.vct.confml.model.confml1.ERfsElement;
import com.nokia.tools.vct.confml.model.confml1.ESettingDataContainer;
import com.nokia.tools.vct.confml.model.confml1.ESettingRfsContainer;
import com.nokia.tools.vct.confml.model.confml2.EConfML2Package;

/**
 * Custom handler for re-mapping instances of setting data, feature data,
 * setting RFS and feature RFS to dedicated classes.
 */
public class ConfML1Handler extends SAXXMLHandler {

	/**
	 * Public handler constructor.
	 * 
	 * @param xmiResource
	 *            Resource object
	 * @param helper
	 *            Helper class
	 * @param options
	 *            Options
	 */
	public ConfML1Handler(XMLResource xmiResource, XMLHelper helper,
			Map<?, ?> options) {
		super(xmiResource, helper, options);
	}
	/**
	 * The method overrides behavior for DATA and RFS parts of features and
	 * settings. Unlike general XMI-mapping contracts, the feature data, setting
	 * data, feature RFS and setting RFS elements are mapped to the same feature
	 * of the parent object. This facility does not allow for the given parents
	 * to have arbitrary typed children.
	 * 
	 * <pre>
	 * &lt;confml:data&gt; &lt;!-- This element maps to EDataElement (default) --&gt;
	 * 	&lt;!-- The element below maps to EFeatureData with REF=&quot;MyFeature&quot;. 
	 * 	    It is not a standard behavior. The mapping occurs for elements 
	 * 	    with any name. --&gt;
	 *     &lt;confml:MyFeature&gt;
	 *     	    &lt;!-- Any child element is mapped into ESettingData with REF=&quot;MySetting&quot;.
	 *                  It is customized in a similar way. --&gt;
	 *     		&lt;confml:MySetting&gt; 
	 *  	   	    &lt;!-- Any child element is mapped into ESettingData with REF=&quot;MySubSetting&quot;.
	 * 			         It is customized in a similar way. --&gt;
	 * 	    		&lt;confml:MySubSetting&gt; 
	 * 	    		&lt;/confml:MySubSetting&gt;
	 *     		&lt;/confml:MySetting&gt;
	 *     &lt;/confml:MyFeature&gt;
	 * &lt;/confml:data&gt;
	 * &lt;confml:rfs&gt; &lt;!-- This element maps to ERfsElement (default) --&gt;
	 *     &lt;!-- The element below maps to EFeatureRfs with REF=&quot;MyFeature&quot;. 
	 *          It is not a standard behavior. The mapping occurs for elements 
	 *          with any name. --&gt;
	 *     &lt;confml:MyFeature&gt;
	 *     	    &lt;!-- Any child element is mapped into ESettingRfs with REF=&quot;MySetting&quot;.
	 *                  It is customized in a similar way. --&gt;
	 *     		&lt;confml:MySetting&gt; 
	 *     		&lt;/confml:MySetting&gt;
	 *     &lt;/confml:MyFeature&gt;
	 * &lt;/confml:rfs&gt;
	 * </pre>
	 */
	@Override
	protected EStructuralFeature getFeature(EObject object, String prefix,
			String name, boolean isElement) {
		EStructuralFeature feature;
		if (isElement) {
			String uri = helper.getURI(prefix);
			EPackage pack = object.eClass().getEPackage();
			if (!pack.equals(EConfML1Package.eINSTANCE)
					&& !pack.equals(EConfML2Package.eINSTANCE)) {
				// Not ConfML1 and not ConfML2
				feature = super.getFeature(object, prefix, name, isElement);
			} else if (!object.eClass().getEPackage().getNsURI().equals(uri)) {
				// if the URI of child does not match URI of the parent (prefix
				// is irrelevant), then use standard facility.
				feature = super.getFeature(object, prefix, name, isElement);
			} else if (object instanceof EDataElement) {
				// Expecting feature data elements for ConfMLv1
				feature = EConfML1Package.eINSTANCE.getEDataElement_Data();
			} else if (object instanceof ERfsElement) {
				// Expecting feature RFS elements for ConfMLv1
				feature = EConfML1Package.eINSTANCE.getERfsElement_Rfs();
			} else if (object instanceof ESettingDataContainer) {
				// Expecting setting data elements for ConfMLv1
				feature = EConfML1Package.eINSTANCE
						.getESettingDataContainer_Settings();
			} else if (object instanceof ESettingRfsContainer) {
				// Expecting setting RFS elements for ConfMLv1
				feature = EConfML1Package.eINSTANCE.getESettingRfsContainer_Settings();
			} else if (object instanceof com.nokia.tools.vct.confml.model.confml2.EDataElement) {
				// Expecting feature data elements for ConfMLv2
				feature = EConfML2Package.eINSTANCE.getEDataElement_Data();
			} else if (object instanceof com.nokia.tools.vct.confml.model.confml2.ERfsElement) {
				// Expecting feature RFS elements for ConfMLv2
				feature = EConfML2Package.eINSTANCE.getERfsElement_Rfs();
			} else if (object instanceof com.nokia.tools.vct.confml.model.confml2.ESettingDataContainer) {
				// Expecting setting data elements for ConfMLv2
				feature = EConfML2Package.eINSTANCE
						.getESettingDataContainer_Settings();
			} else if (object instanceof com.nokia.tools.vct.confml.model.confml2.ESettingRfsContainer) {
				// Expecting setting RFS elements for ConfMLv2
				feature = EConfML2Package.eINSTANCE.getESettingRfsContainer_Settings();
			} else {
				// Standard element processing
				feature = super.getFeature(object, prefix, name, isElement);
			}
		} else {
			// attributes are handled in a standard way
			feature = super.getFeature(object, prefix, name, isElement);
		}

		return feature;
	}

	/**
	 * The method intercepts the element handling and updates "ref" attribute
	 * for {@link ERefNamedElement} instances.
	 * 
	 * @see XMLHandler#handleFeature
	 */
	@Override
	protected void handleFeature(String prefix, String name) {
		super.handleFeature(prefix, name);

		EObject object = objects.peekEObject();
		
		// If the type is AnyType the parser has not been able to create a 
		// valid model object for the element, therefore raise a warning as it 
		// is likely an error in the confml
		if (object instanceof AnyType){
			StringBuilder errorMessage = new StringBuilder("WARN - Element: ")
					.append(prefix)
					.append(":")
					.append(name)
					.append("[")
					.append(((AnyType)object).toString())
					.append("]");
			try {
				String location = this.documentRoot.eResource().getURI().toString();
				errorMessage.append(" (from ").append(location).append(")");
			} catch (NullPointerException e) {
				// do nothing
			}
			errorMessage.append(" is not recognised as a relevant type");
			EcorePlugin.INSTANCE.log(errorMessage);
		}
		
		if (object instanceof ERefNamedElement) {
			((ERefNamedElement) object).setRef(name);
		}
		if (object instanceof com.nokia.tools.vct.confml.model.confml2.ERefNamedElement) {
			((com.nokia.tools.vct.confml.model.confml2.ERefNamedElement) object).setRef(name);
		}
	}

}
