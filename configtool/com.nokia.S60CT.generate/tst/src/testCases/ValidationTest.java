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
package testCases;

import junit.framework.TestCase;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.service.IBatchValidator;
import org.eclipse.emf.validation.service.IValidator;
import org.eclipse.emf.validation.service.ModelValidationService;

import configurationemf.Configuration;
import configurationemf.ConfigurationemfFactory;
import configurationemf.Icon;
import configurationemf.Length;
import configurationemf.Link;
import configurationemf.MaxExclusive;
import configurationemf.MaxInclusive;
import configurationemf.MaxLength;
import configurationemf.MinExclusive;
import configurationemf.MinInclusive;
import configurationemf.MinLength;
import configurationemf.Option;
import configurationemf.Pattern;
import configurationemf.Property;
import configurationemf.Ref;
import configurationemf.RootConf;
import configurationemf.Setting;
import configurationemf.TYPE;
import configurationemf.TotalDigits;

public class ValidationTest extends TestCase {
	IBatchValidator validator=null;
	
	IValidator getValidator(){
		validator = (IBatchValidator)ModelValidationService.getInstance()
			.newValidator(EvaluationMode.BATCH);
//		validator.setIncludeLiveConstraints(true);
		return validator;
	}
	
	@Override
	protected void setUp() throws Exception {

		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {

		super.tearDown();
	}
	
	public void  testValidator(){
		Setting set = ConfigurationemfFactory.eINSTANCE.createParentSetting();
		this.getValidator().validate(set);
		
	}

	
	class SettingMock implements Setting{

		@Override
		public void addSetting(Setting setting) {

			
		}

		@Override
		public String getAbsRef() {

			return null;
		}

		@Override
		public EList<Option> getBoolOptions() {
			
			return null;
		}

		@Override
		public String getConfValue(Configuration configuration) {
			
			return null;
		}

		@Override
		public String getConstraint() {
			
			return null;
		}

		@Override
		public Configuration getCurrentConf() {
			
			return null;
		}

		@Override
		public String getCurrentType() {
			
			return null;
		}

		@Override
		public String getCurrentValue() {
			
			return null;
		}

		@Override
		public Configuration getDefaultConf() {
			
			return null;
		}

		@Override
		public String getDefaultValue() {
			
			return null;
		}

		@Override
		public RootConf getGConf() {
			
			return null;
		}

		@Override
		public Object getGValue() {
			
			return null;
		}

		@Override
		public EList<Icon> getIcon() {
			
			return null;
		}

		@Override
		public Length getLength() {
			
			return null;
		}

		@Override
		public EList<Link> getLink() {
			
			return null;
		}

		@Override
		public MaxExclusive getMaxExclusive() {
			
			return null;
		}

		@Override
		public MaxInclusive getMaxInclusive() {
			
			return null;
		}

		@Override
		public MaxLength getMaxLength() {
			
			return null;
		}

		@Override
		public MinExclusive getMinExclusive() {
			
			return null;
		}

		@Override
		public MinInclusive getMinInclusive() {
			
			return null;
		}

		@Override
		public MinLength getMinLength() {
			
			return null;
		}

		@Override
		public String getName() {
			
			return null;
		}

		@Override
		public EList<Option> getOption() {
			
			return null;
		}

		@Override
		public Pattern getPattern() {
			
			return null;
		}

		@Override
		public EList<String> getPossibleValue() {
			
			return null;
		}

		@Override
		public Property getProperty() {
			
			return null;
		}

		@Override
		public String getRelevant() {
			
			return null;
		}

		@Override
		public String getRequired() {
			
			return null;
		}

		@Override
		public String getSystemValue(String userValue) {
			
			return null;
		}

		@Override
		public String getTopValue() {
			
			return null;
		}

		@Override
		public TotalDigits getTotalDigits() {
			
			return null;
		}

		@Override
		public TYPE getType() {
			
			return null;
		}

		@Override
		public String getUserValue(String systemValue) {
			
			return null;
		}

		@Override
		public boolean isReadOnly() {
			
			return false;
		}

		@Override
		public boolean isRfs() {
			
			return false;
		}

		@Override
		public boolean isRo() {
			
			return false;
		}

		@Override
		public boolean isValueChangeble() {
			
			return false;
		}

		@Override
		public void removeSetting(Setting setting) {
			
			
		}

		@Override
		public void setConfRfs(boolean rfs, RootConf rootConf) {
			
			
		}

		@Override
		public void setConfValue(String value, Configuration conf) {
			
			
		}

		@Override
		public void setConstraint(String value) {
			
			
		}

		@Override
		public void setCurrentType(String value) {
			
			
		}

		@Override
		public void setCurrentValue(String value) {
			
			
		}

		@Override
		public void setLength(Length value) {
			
			
		}

		@Override
		public void setMaxExclusive(MaxExclusive value) {
			
			
		}

		@Override
		public void setMaxInclusive(MaxInclusive value) {
			
			
		}

		@Override
		public void setMaxLength(MaxLength value) {
			
			
		}

		@Override
		public void setMinExclusive(MinExclusive value) {
			
			
		}

		@Override
		public void setMinInclusive(MinInclusive value) {
			
			
		}

		@Override
		public void setMinLength(MinLength value) {
			
			
		}

		@Override
		public void setName(String value) {
			
			
		}

		@Override
		public void setPattern(Pattern value) {
			
			
		}

		@Override
		public void setProperty(Property value) {
			
			
		}

		@Override
		public void setReadOnly(boolean value) {
			
			
		}

		@Override
		public void setRelevant(String value) {
			
			
		}

		@Override
		public void setRequired(String value) {
			
			
		}

		@Override
		public void setRfs(boolean value) {
			
			
		}

		@Override
		public void setTotalDigits(TotalDigits value) {
			
			
		}

		@Override
		public void setType(TYPE value) {
			
			
		}

		@Override
		public String getRef() {
			
			return null;
		}

		@Override
		public EList<Ref> getRefs() {
			
			return null;
		}

		@Override
		public EList<Ref> getRfsRefs() {
			
			return null;
		}

		@Override
		public void setRef(String value) {
			
			
		}

		@Override
		public String getDesc() {
			
			return null;
		}

		@Override
		public void setDesc(String value) {
			
			
		}

		@Override
		public String getId() {
			
			return null;
		}

		@Override
		public void setId(String value) {
			
			
		}

		@Override
		public TreeIterator<EObject> eAllContents() {
			
			return null;
		}

		@Override
		public EClass eClass() {
			
			return null;
		}

		@Override
		public EObject eContainer() {
			
			return null;
		}

		@Override
		public EStructuralFeature eContainingFeature() {
			
			return null;
		}

		@Override
		public EReference eContainmentFeature() {
			
			return null;
		}

		@Override
		public EList<EObject> eContents() {
			
			return null;
		}

		@Override
		public EList<EObject> eCrossReferences() {
			
			return null;
		}

		@Override
		public Object eGet(EStructuralFeature feature, boolean resolve) {
			
			return null;
		}

		@Override
		public Object eGet(EStructuralFeature feature) {
			
			return null;
		}

		@Override
		public boolean eIsProxy() {
			
			return false;
		}

		@Override
		public boolean eIsSet(EStructuralFeature feature) {
			
			return false;
		}

		@Override
		public Resource eResource() {
			
			return null;
		}

		@Override
		public void eSet(EStructuralFeature feature, Object newValue) {
			
			
		}

		@Override
		public void eUnset(EStructuralFeature feature) {
			
			
		}

		@Override
		public EList<Adapter> eAdapters() {
			
			return null;
		}

		@Override
		public boolean eDeliver() {
			
			return false;
		}

		@Override
		public void eNotify(Notification notification) {
			
			
		}

		@Override
		public void eSetDeliver(boolean deliver) {
			
			
		}
		
	}
}
