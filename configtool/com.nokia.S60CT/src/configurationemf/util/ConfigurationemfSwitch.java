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

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import configurationemf.AttributeAndDesc;
import configurationemf.CommonAttr;
import configurationemf.Configuration;
import configurationemf.ConfigurationemfPackage;
import configurationemf.Content;
import configurationemf.Customer;
import configurationemf.DIL;
import configurationemf.Data;
import configurationemf.Date;
import configurationemf.Editor;
import configurationemf.Feature;
import configurationemf.Frame;
import configurationemf.GSetting;
import configurationemf.Group;
import configurationemf.Icon;
import configurationemf.Identification;
import configurationemf.LeafGroup;
import configurationemf.LeafSetting;
import configurationemf.LeafSettingDelegator;
import configurationemf.Length;
import configurationemf.Link;
import configurationemf.MaxExclusive;
import configurationemf.MaxInclusive;
import configurationemf.MaxLength;
import configurationemf.Meta;
import configurationemf.MinExclusive;
import configurationemf.MinInclusive;
import configurationemf.MinLength;
import configurationemf.Option;
import configurationemf.Owner;
import configurationemf.ParentGroup;
import configurationemf.ParentSetting;
import configurationemf.Pattern;
import configurationemf.Platform;
import configurationemf.Product;
import configurationemf.Property;
import configurationemf.Ref;
import configurationemf.Referable;
import configurationemf.Release;
import configurationemf.Rfs;
import configurationemf.RootConf;
import configurationemf.Setting;
import configurationemf.Status;
import configurationemf.SubConf;
import configurationemf.TotalDigits;
import configurationemf.Version;
import configurationemf.View;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see configurationemf.ConfigurationemfPackage
 * @generated
 */
public class ConfigurationemfSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ConfigurationemfPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigurationemfSwitch() {
		if (modelPackage == null) {
			modelPackage = ConfigurationemfPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ConfigurationemfPackage.CONFIGURATION: {
				Configuration configuration = (Configuration)theEObject;
				T result = caseConfiguration(configuration);
				if (result == null) result = caseAttributeAndDesc(configuration);
				if (result == null) result = caseCommonAttr(configuration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigurationemfPackage.FEATURE: {
				Feature feature = (Feature)theEObject;
				T result = caseFeature(feature);
				if (result == null) result = caseReferable(feature);
				if (result == null) result = caseAttributeAndDesc(feature);
				if (result == null) result = caseCommonAttr(feature);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigurationemfPackage.SETTING: {
				Setting setting = (Setting)theEObject;
				T result = caseSetting(setting);
				if (result == null) result = caseReferable(setting);
				if (result == null) result = caseAttributeAndDesc(setting);
				if (result == null) result = caseCommonAttr(setting);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigurationemfPackage.ATTRIBUTE_AND_DESC: {
				AttributeAndDesc attributeAndDesc = (AttributeAndDesc)theEObject;
				T result = caseAttributeAndDesc(attributeAndDesc);
				if (result == null) result = caseCommonAttr(attributeAndDesc);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigurationemfPackage.VIEW: {
				View view = (View)theEObject;
				T result = caseView(view);
				if (result == null) result = caseAttributeAndDesc(view);
				if (result == null) result = caseCommonAttr(view);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigurationemfPackage.GROUP: {
				Group group = (Group)theEObject;
				T result = caseGroup(group);
				if (result == null) result = caseAttributeAndDesc(group);
				if (result == null) result = caseCommonAttr(group);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigurationemfPackage.COMMON_ATTR: {
				CommonAttr commonAttr = (CommonAttr)theEObject;
				T result = caseCommonAttr(commonAttr);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigurationemfPackage.OPTION: {
				Option option = (Option)theEObject;
				T result = caseOption(option);
				if (result == null) result = caseAttributeAndDesc(option);
				if (result == null) result = caseCommonAttr(option);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigurationemfPackage.META: {
				Meta meta = (Meta)theEObject;
				T result = caseMeta(meta);
				if (result == null) result = caseCommonAttr(meta);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigurationemfPackage.RELEASE: {
				Release release = (Release)theEObject;
				T result = caseRelease(release);
				if (result == null) result = caseContent(release);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigurationemfPackage.IDENTIFICATION: {
				Identification identification = (Identification)theEObject;
				T result = caseIdentification(identification);
				if (result == null) result = caseContent(identification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigurationemfPackage.DATE: {
				Date date = (Date)theEObject;
				T result = caseDate(date);
				if (result == null) result = caseContent(date);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigurationemfPackage.OWNER: {
				Owner owner = (Owner)theEObject;
				T result = caseOwner(owner);
				if (result == null) result = caseContent(owner);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigurationemfPackage.EDITOR: {
				Editor editor = (Editor)theEObject;
				T result = caseEditor(editor);
				if (result == null) result = caseContent(editor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigurationemfPackage.STATUS: {
				Status status = (Status)theEObject;
				T result = caseStatus(status);
				if (result == null) result = caseContent(status);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigurationemfPackage.VERSION: {
				Version version = (Version)theEObject;
				T result = caseVersion(version);
				if (result == null) result = caseContent(version);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigurationemfPackage.PLATFORM: {
				Platform platform = (Platform)theEObject;
				T result = casePlatform(platform);
				if (result == null) result = caseContent(platform);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigurationemfPackage.PRODUCT: {
				Product product = (Product)theEObject;
				T result = caseProduct(product);
				if (result == null) result = caseContent(product);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigurationemfPackage.CUSTOMER: {
				Customer customer = (Customer)theEObject;
				T result = caseCustomer(customer);
				if (result == null) result = caseContent(customer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigurationemfPackage.GSETTING: {
				GSetting gSetting = (GSetting)theEObject;
				T result = caseGSetting(gSetting);
				if (result == null) result = caseParentSetting(gSetting);
				if (result == null) result = caseSetting(gSetting);
				if (result == null) result = caseReferable(gSetting);
				if (result == null) result = caseAttributeAndDesc(gSetting);
				if (result == null) result = caseCommonAttr(gSetting);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigurationemfPackage.PROPERTY: {
				Property property = (Property)theEObject;
				T result = caseProperty(property);
				if (result == null) result = caseAttributeAndDesc(property);
				if (result == null) result = caseCommonAttr(property);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigurationemfPackage.PATTERN: {
				Pattern pattern = (Pattern)theEObject;
				T result = casePattern(pattern);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigurationemfPackage.LENGTH: {
				Length length = (Length)theEObject;
				T result = caseLength(length);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigurationemfPackage.MAX_LENGTH: {
				MaxLength maxLength = (MaxLength)theEObject;
				T result = caseMaxLength(maxLength);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigurationemfPackage.MIN_LENGTH: {
				MinLength minLength = (MinLength)theEObject;
				T result = caseMinLength(minLength);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigurationemfPackage.MAX_EXCLUSIVE: {
				MaxExclusive maxExclusive = (MaxExclusive)theEObject;
				T result = caseMaxExclusive(maxExclusive);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigurationemfPackage.MAX_INCLUSIVE: {
				MaxInclusive maxInclusive = (MaxInclusive)theEObject;
				T result = caseMaxInclusive(maxInclusive);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigurationemfPackage.MIN_INCLUSIVE: {
				MinInclusive minInclusive = (MinInclusive)theEObject;
				T result = caseMinInclusive(minInclusive);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigurationemfPackage.MIN_EXCLUSIVE: {
				MinExclusive minExclusive = (MinExclusive)theEObject;
				T result = caseMinExclusive(minExclusive);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigurationemfPackage.TOTAL_DIGITS: {
				TotalDigits totalDigits = (TotalDigits)theEObject;
				T result = caseTotalDigits(totalDigits);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigurationemfPackage.LEAF_SETTING: {
				LeafSetting leafSetting = (LeafSetting)theEObject;
				T result = caseLeafSetting(leafSetting);
				if (result == null) result = caseSetting(leafSetting);
				if (result == null) result = caseReferable(leafSetting);
				if (result == null) result = caseAttributeAndDesc(leafSetting);
				if (result == null) result = caseCommonAttr(leafSetting);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigurationemfPackage.PARENT_SETTING: {
				ParentSetting parentSetting = (ParentSetting)theEObject;
				T result = caseParentSetting(parentSetting);
				if (result == null) result = caseSetting(parentSetting);
				if (result == null) result = caseReferable(parentSetting);
				if (result == null) result = caseAttributeAndDesc(parentSetting);
				if (result == null) result = caseCommonAttr(parentSetting);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigurationemfPackage.LEAF_GROUP: {
				LeafGroup leafGroup = (LeafGroup)theEObject;
				T result = caseLeafGroup(leafGroup);
				if (result == null) result = caseGroup(leafGroup);
				if (result == null) result = caseAttributeAndDesc(leafGroup);
				if (result == null) result = caseCommonAttr(leafGroup);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigurationemfPackage.PARENT_GROUP: {
				ParentGroup parentGroup = (ParentGroup)theEObject;
				T result = caseParentGroup(parentGroup);
				if (result == null) result = caseGroup(parentGroup);
				if (result == null) result = caseAttributeAndDesc(parentGroup);
				if (result == null) result = caseCommonAttr(parentGroup);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigurationemfPackage.CONTENT: {
				Content content = (Content)theEObject;
				T result = caseContent(content);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigurationemfPackage.ICON: {
				Icon icon = (Icon)theEObject;
				T result = caseIcon(icon);
				if (result == null) result = caseDIL(icon);
				if (result == null) result = caseCommonAttr(icon);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigurationemfPackage.LINK: {
				Link link = (Link)theEObject;
				T result = caseLink(link);
				if (result == null) result = caseDIL(link);
				if (result == null) result = caseCommonAttr(link);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigurationemfPackage.DIL: {
				DIL dil = (DIL)theEObject;
				T result = caseDIL(dil);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigurationemfPackage.ROOT_CONF: {
				RootConf rootConf = (RootConf)theEObject;
				T result = caseRootConf(rootConf);
				if (result == null) result = caseConfiguration(rootConf);
				if (result == null) result = caseAttributeAndDesc(rootConf);
				if (result == null) result = caseCommonAttr(rootConf);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigurationemfPackage.SUB_CONF: {
				SubConf subConf = (SubConf)theEObject;
				T result = caseSubConf(subConf);
				if (result == null) result = caseConfiguration(subConf);
				if (result == null) result = caseAttributeAndDesc(subConf);
				if (result == null) result = caseCommonAttr(subConf);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigurationemfPackage.DATA: {
				Data data = (Data)theEObject;
				T result = caseData(data);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigurationemfPackage.RFS: {
				Rfs rfs = (Rfs)theEObject;
				T result = caseRfs(rfs);
				if (result == null) result = caseData(rfs);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigurationemfPackage.REF: {
				Ref ref = (Ref)theEObject;
				T result = caseRef(ref);
				if (result == null) result = caseContent(ref);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigurationemfPackage.REFERABLE: {
				Referable referable = (Referable)theEObject;
				T result = caseReferable(referable);
				if (result == null) result = caseAttributeAndDesc(referable);
				if (result == null) result = caseCommonAttr(referable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigurationemfPackage.FRAME: {
				Frame frame = (Frame)theEObject;
				T result = caseFrame(frame);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigurationemfPackage.LEAF_SETTING_DELEGATOR: {
				LeafSettingDelegator leafSettingDelegator = (LeafSettingDelegator)theEObject;
				T result = caseLeafSettingDelegator(leafSettingDelegator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConfiguration(Configuration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFeature(Feature object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Setting</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Setting</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSetting(Setting object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute And Desc</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute And Desc</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeAndDesc(AttributeAndDesc object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>View</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>View</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseView(View object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Group</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGroup(Group object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Common Attr</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Common Attr</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCommonAttr(CommonAttr object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Option</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Option</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOption(Option object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Meta</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Meta</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMeta(Meta object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Identification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Identification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIdentification(Identification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Date</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Date</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDate(Date object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Owner</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Owner</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOwner(Owner object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Editor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Editor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEditor(Editor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Status</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Status</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStatus(Status object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Version</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Version</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVersion(Version object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Platform</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Platform</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePlatform(Platform object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Product</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Product</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProduct(Product object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Release</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Release</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRelease(Release object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Referable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Referable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReferable(Referable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Frame</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Frame</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFrame(Frame object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Leaf Setting Delegator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Leaf Setting Delegator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLeafSettingDelegator(LeafSettingDelegator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Customer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Customer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCustomer(Customer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>GSetting</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>GSetting</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGSetting(GSetting object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProperty(Property object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pattern</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePattern(Pattern object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Length</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Length</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLength(Length object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Max Length</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Max Length</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMaxLength(MaxLength object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Min Length</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Min Length</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMinLength(MinLength object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Max Exclusive</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Max Exclusive</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMaxExclusive(MaxExclusive object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Max Inclusive</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Max Inclusive</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMaxInclusive(MaxInclusive object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Min Inclusive</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Min Inclusive</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMinInclusive(MinInclusive object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Min Exclusive</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Min Exclusive</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMinExclusive(MinExclusive object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Total Digits</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Total Digits</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTotalDigits(TotalDigits object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Leaf Setting</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Leaf Setting</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLeafSetting(LeafSetting object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parent Setting</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parent Setting</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParentSetting(ParentSetting object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Leaf Group</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Leaf Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLeafGroup(LeafGroup object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parent Group</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parent Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParentGroup(ParentGroup object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Content</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Content</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContent(Content object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Icon</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Icon</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIcon(Icon object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLink(Link object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DIL</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DIL</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDIL(DIL object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Root Conf</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Root Conf</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRootConf(RootConf object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sub Conf</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sub Conf</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubConf(SubConf object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseData(Data object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rfs</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rfs</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRfs(Rfs object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ref</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ref</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRef(Ref object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //ConfigurationemfSwitch
