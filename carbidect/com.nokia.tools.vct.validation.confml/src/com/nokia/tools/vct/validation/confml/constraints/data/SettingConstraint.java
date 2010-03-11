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
package com.nokia.tools.vct.validation.confml.constraints.data;

import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;

import com.nokia.tools.vct.common.appmodel.EAppExpression;
import com.nokia.tools.vct.common.appmodel.EAppFeature;
import com.nokia.tools.vct.common.appmodel.EAppSetting;
import com.nokia.tools.vct.common.appmodel.EAppSettingType;
import com.nokia.tools.vct.common.appmodel.EAppSimpleType;
import com.nokia.tools.vct.common.appmodel.EConfMLLayer;
import com.nokia.tools.vct.common.confml.expressions.ConfMLExpressionsPlugin;
import com.nokia.tools.vct.common.confml.expressions.IConfMLSettingValuesProvider;
import com.nokia.tools.vct.confml.model.confml1.ESettingData;
import com.nokia.tools.vct.validation.confml.constraints.ConfMLUtils;

public class SettingConstraint extends AbstractModelConstraint {

	public SettingConstraint() {

	}

	@Override
	public IStatus validate(IValidationContext ctx) {

		String value = null;
		String typePath = null;
		EAppSimpleType appSimpleType = null;
		
		if (ctx.getTarget() instanceof ESettingData) {
			ESettingData settingData = (ESettingData) ctx.getTarget();
			StringBuilder tmp = new StringBuilder();
			EAppSettingType ptr = ConfMLUtils.findType(settingData, tmp);
			typePath = tmp.toString();
			if (ptr!=null)
				return constraint(ctx, typePath, ptr);
		}
		else if (ctx.getTarget() instanceof com.nokia.tools.vct.confml.model.confml2.ESettingData)
		{
			com.nokia.tools.vct.confml.model.confml2.ESettingData settingData = (com.nokia.tools.vct.confml.model.confml2.ESettingData) ctx.getTarget();
			StringBuilder tmp = new StringBuilder();
			EAppSettingType ptr = ConfMLUtils.findType(settingData, tmp);
			typePath = tmp.toString();
			if (ptr!=null)
				return constraint(ctx, typePath, ptr);
		}
		return ctx.createSuccessStatus();
	}

	public static IStatus constraint(IValidationContext ctx, String typePath, EAppSettingType settingType)
	{
		EAppExpression constraint = settingType.getConstraint();
		
		if (constraint==null || constraint.getLiteral() == null)
			return null;
		else 
		{
			String literal = constraint.getLiteral();
			
			Object constraintAST = null;
			
			constraintAST = ConfMLExpressionsPlugin.compileExpression(literal);

			boolean result =  ConfMLExpressionsPlugin.evaluateBooleanExpression(
					constraintAST, confmlValuesProvider, ConfMLUtils.getLastLayer(settingType), settingType);
			
			if (!result)
			{
				return ctx.createFailureStatus("Setting's "+typePath+" value doesn't comply with constraint "+literal);
			}
			return ctx.createSuccessStatus();
		}
	}
	
	public static final IConfMLSettingValuesProvider confmlValuesProvider = new IConfMLSettingValuesProvider() {

		public String getValue(Object object) {
//			if (object instanceof ESimpleSetting) {
//				ESimpleSetting simple = (ESimpleSetting) object;
//				return ((ESimpleValue)simple.getValue()).getValue();
//			} 
////			else if (object instanceof FilePath) {
////				FilePath path = (FilePath) object;
////				return path.getPath();
////			}
			if (object instanceof EAppSimpleType)
			{
				return ConfMLUtils.getCorrectValue((EAppSimpleType)object);
			}
			else if (object instanceof EAppSetting)
			{
				return ConfMLUtils.getCorrectValue((EAppSetting)object);
			}
			return null;
		}

		public Object getSubItem(Object object, int index) {
//			if (object instanceof ESequenceSetting) {
//				ESequenceSetting ss = (ESequenceSetting) object;
//				EList<ESetting> settings = ss.getSubTypes();
//				return settings.get(index - 1);
//				//EList<SequenceItem> sequenceItems = ss.getSequenceItem();
//				//return sequenceItems.get(index - 1);
//			}
			return null;
		}

		public Object getSubItem(Object object, String ref) {
//			if (object instanceof View) 
//			{
//				View view = (View) object;
//				EList<EFeature> sharedFeatures = view.getSharedFeatures();
//				for (int i = 0; i < sharedFeatures.size(); i++) {
//					EFeature feature = sharedFeatures.get(i);
//					if (ref.equals(feature.getRef())) {
//						return feature;
//					}
//				}
//			} 
		    if (object instanceof EAppFeature)
			{
		    	EAppFeature feature = (EAppFeature) object;
				String featureRef = feature.getRef();
				//View view = feature.getView();
				//String absRef = featureRef + "/" + ref;
				//EList<ESetting> sharedSettingInstances = view.getSharedSettingInstances();
				EMap<String, EAppSetting> settings = feature.getSettings();
				for (Map.Entry<String, EAppSetting> entry : settings)
				{
					String key = entry.getKey();
					if (key.equals(ref))
					{
						return entry.getValue();
					}
				}
			} 
		    else if (object instanceof EConfMLLayer)
		    {
		    	EConfMLLayer layer = (EConfMLLayer)object;
		    	EMap<String, EAppFeature> features = layer.getFeatures();
		    	for (Map.Entry<String, EAppFeature> entry : features)
				{
					String key = entry.getKey();
					if (key.equals(ref))
					{
						return entry.getValue();
					}
				}
		    }
//			else if (object instanceof SequenceItem) 
//			{
//				SequenceItem si = (SequenceItem) object;
//				EList<Setting> subsettings = si.getSetting();
//				for (int i = 0; i < subsettings.size(); i++) {
//					Setting setting = subsettings.get(i);
//					if (setting.getSettingRef().equals(ref)) {
//						return setting;
//					}
//				}
//			} 
//			else if (object instanceof FileSystemEntrySetting)
//			{
//				FileSystemEntrySetting fses = (FileSystemEntrySetting) object;
//				if (ref.equals("localPath")) {
//					return fses.getSourceFilePath();
//				} else if (ref.equals("targetPath")) {
//					return fses.getTargetFilePath();
//				}
//			}
			return null;
		}

		private EObject getParentFeature(EObject obj)
		{
			EObject container = obj.eContainer();
			if (container instanceof EAppFeature)
				return container;
			else
				return getParentFeature(container);
		}
		
		public Object getParentItem(Object object) {
			if (object instanceof EObject) 
			{
				EObject eobject = (EObject) object;
				
				if (eobject instanceof EAppSettingType)
				{
					return getParentFeature(eobject);
				}
				EObject container = eobject.eContainer();
				return container;
				
			}

			return null;
		}
	};
	
}
