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

import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.xmi.FeatureNotFoundException;
import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.SAXXMLHandler;

import variantdata.VariantData;
import configurationemf.ConfigurationemfPackage;
import configurationemf.Data;
import configurationemf.LeafSetting;
import configurationemf.Ref;


public class ConfXMLHandler extends SAXXMLHandler {
	
	  
//  must be here
	public EObject createObject(EFactory eFactory, EClassifier type, boolean documentRoot)
	  {
	    EObject newObject = helper.createObject(eFactory, type);
	    
	    if (newObject != null && !documentRoot)
	    {
	      if (disableNotify)
	      {
	        newObject.eSetDeliver(false);
	      }
	      handleObjectAttribs(newObject);
	    }
	    return newObject;
	  }

	///@Override
	protected void handleFeature(String prefix, String name) {
		EObject peekObject = objects.peekEObject();
		EStructuralFeature feature=null;
	    // This happens when processing an element with simple content that has elements content even though it shouldn't.
	    //
	    if (peekObject == null)
	    {
	      types.push(ERROR_TYPE);
	      error
	        (new FeatureNotFoundException
	          (name,
	           null,
	           getLocation(),
	           getLineNumber(),
	           getColumnNumber()));
	      return;
	    }else if(peekObject instanceof VariantData){
	    	if(prefix!=null&&prefix.compareTo("xi")==0&&name!=null&&name.compareTo("include")==0)
	    		feature = getFeature(peekObject, prefix, name, true);
	    	else feature = ConfigurationemfPackage.eINSTANCE.getData_Ref();
	    	
	    }else if(peekObject instanceof Data) {
	    	feature = ConfigurationemfPackage.eINSTANCE.getData_Ref();
		}else if (peekObject instanceof LeafSetting 
				&& name.equals("option")) {
			feature = ConfigurationemfPackage.eINSTANCE.getSetting_Option();
		}else
	    	feature = getFeature(peekObject, prefix, name, true);
	    
	    if (feature != null)
	    {
	      int kind = helper.getFeatureKind(feature);
	      if (kind == XMLHelper.DATATYPE_SINGLE || kind == XMLHelper.DATATYPE_IS_MANY)
	      {
	        objects.push(null);
	        mixedTargets.push(null);
	        types.push(feature);
	        if (!isNull())
	        {
	          text = new StringBuffer();
	        }
	      }
	      else if (extendedMetaData != null)
	      {
	        EReference eReference = (EReference)feature;
	        boolean isContainment = eReference.isContainment();      
	        if (!isContainment && !eReference.isResolveProxies() && extendedMetaData.getFeatureKind(feature) != ExtendedMetaData.UNSPECIFIED_FEATURE)
	        {
	          isIDREF = true;
	          objects.push(null);
	          mixedTargets.push(null);
	          types.push(feature);
	          text = new StringBuffer();
	        }
	        else
	        {
	          createObject(peekObject, feature);
	          EObject childObject = objects.peekEObject();
	          setRefName(name,childObject);
	          if (childObject != null)
	          {
	            if (isContainment)
	            {
	              EStructuralFeature simpleFeature = extendedMetaData.getSimpleFeature(childObject.eClass());
	              if (simpleFeature != null)
	              {
	                isSimpleFeature = true;
	                isIDREF = simpleFeature instanceof EReference;
	                objects.push(null);
	                mixedTargets.push(null);
	                types.push(simpleFeature);
	                text = new StringBuffer();
	              }
	            }
	            else if (!childObject.eIsProxy())
	            {
	              text = new StringBuffer();
	            }
	          }
	        }
	      }
	      else 
	      {
	        createObject(peekObject, feature);
	      }
	    }
	    else
	    {
	      // Try to get a general-content feature.
	      // Use a pattern that's not possible any other way.
	      //
	      if (xmlMap != null && (feature = getFeature(peekObject, null, "", true)) != null)
	      {

	        EFactory eFactory = getFactoryForPrefix(prefix);

	        // This is for the case for a local unqualified element that has been bound.
	        //
	        if (eFactory == null)
	        {
	          eFactory = feature.getEContainingClass().getEPackage().getEFactoryInstance();
	        }

	        EObject newObject = null;
	        if (useNewMethods)
	        {
	          newObject = createObject(eFactory, helper.getType(eFactory, name), false);
	        }
	        else
	        {
	            newObject = createObjectFromFactory(eFactory, name);
	        }
	        newObject = validateCreateObjectFromFactory(eFactory, name, newObject, feature);
	        if (newObject != null)
	        {
	          setFeatureValue(peekObject, feature, newObject);
	        }
	        processObject(newObject);
	      }
	      else
	      {
	        // This handles the case of a substitution group.
	        //
	        if (xmlMap != null)
	        {
	          EFactory eFactory = getFactoryForPrefix(prefix);
	          EObject newObject = createObjectFromFactory(eFactory, name);
	          validateCreateObjectFromFactory(eFactory, name, newObject);
	          if (newObject != null)
	          {
	            for (Iterator i = peekObject.eClass().getEAllReferences().iterator(); i.hasNext(); )
	            {
	              EReference eReference = (EReference)i.next();
	              if (eReference.getEType().isInstance(newObject))
	              {
	                setFeatureValue(peekObject, eReference, newObject);
	                processObject(newObject);
	                return;
	              }
	            }
	          }
	        }
	       
	        handleUnknownFeature(prefix, name, true, peekObject, null);
	      }
	    }
	}
	
	private void setRefName(String name, EObject object){
		if(object instanceof Ref)
			((Ref)object).setName(name);
		
	}
	
	public ConfXMLHandler(XMLResource xmiResource, XMLHelper helper, Map options){
		super(xmiResource, helper, options);
	}

	protected EObject createObjectByType(String arg0, String arg1, boolean arg2) {
		EObject object =super.createObjectByType(arg0, arg1, arg2); 
		return object;
	}

	
}
