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
package validation;

import helpers.MarkerManager;

import java.util.Collection;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.service.IBatchValidator;
import org.eclipse.emf.validation.service.IValidator;
import org.eclipse.emf.validation.service.ModelValidationService;

import variantdata.util.ElementRefParser;
import clientContext.GeneralValidationSelector;

import com.nokia.s60ct.generate.GenerateManager;

import configurationemf.LeafSettingDelegator;
import configurationemf.Setting;
import configurationemf.impl.LeafSettingDelegatorImpl;
import configurationemf.impl.ParentSettingImpl;

public class ConfigurableValue extends AbstractModelConstraint {

	IBatchValidator validator = null;
	
	public ConfigurableValue() {
	}

	// validate that implementations would get valid values.
	public IStatus validate(IValidationContext ctx) {
		/*
		 * 1. collect RefValue
		 * 2. setRefValue
		 * 3. ClientSelector.SELECTOR=true
		 * 4. validate
		 * 5. ClientSelector.SELECTOR=false
		 * 6. organize result
		 */
		IStatus status = null;

		EObject obj = ctx.getTarget();
		Setting setting = null;
		if (obj instanceof Setting) //even the target is Setting, ctx.getTarget() can be also LeafSettingDelegator.
			setting = (ParentSettingImpl) obj;
		else if (obj instanceof LeafSettingDelegator)
			setting = ((LeafSettingDelegatorImpl)obj).getLeafSetting();

		//System.out.println(setting.getName());
		Collection<Object> implementations = null;
		// 2. setRefValue
		implementations = GenerateManager.getInstance().getImplementations(setting);
		// 3,4,5
		if(!implementations.isEmpty()){
			implementations.remove(null); //null in the collection indicated that GenConfml implementation was found, but we don't validate genconfml so remove the null.
			if (implementations.isEmpty())
				return ctx.createSuccessStatus();
			boolean tmp = GeneralValidationSelector.SELECTOR;
			GeneralValidationSelector.SELECTOR = false;

			ConfigurableValueSelector.SELECTOR=true;
			status = getValidator().validate(implementations);
			ConfigurableValueSelector.SELECTOR=false;

			GeneralValidationSelector.SELECTOR = tmp;
			GenerateManager.getInstance().reset(implementations);
		}
		else
		{
			status = MarkerManager.getInstance().addWarning(ctx, ElementRefParser.getName(setting), "No implementation found for setting "+ElementRefParser.getName(setting)+".");
			return status;
		}
		return ctx.createSuccessStatus();
	}
	
	protected IValidator getValidator(){
		if(validator==null){
			validator = (IBatchValidator)ModelValidationService.getInstance()
			.newValidator(EvaluationMode.BATCH);
			//validator.setIncludeLiveConstraints(true);
		}
		return validator;
	}
}
