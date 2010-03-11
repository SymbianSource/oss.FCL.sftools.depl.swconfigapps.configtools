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
package configurationemf.tests;

import java.util.Iterator;

import junit.framework.Assert;
import configurationemf.Option;
import configurationemf.Setting;
import configurationemf.TYPE;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Setting</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link configurationemf.Setting#getBoolOptions() <em>Bool Options</em>}</li>
 *   <li>{@link configurationemf.Setting#getDefaultValue() <em>Default Value</em>}</li>
 *   <li>{@link configurationemf.Setting#getCurrentValue() <em>Current Value</em>}</li>
 *   <li>{@link configurationemf.Setting#getTopValue() <em>Top Value</em>}</li>
 *   <li>{@link configurationemf.Setting#isRo() <em>Ro</em>}</li>
 *   <li>{@link configurationemf.Setting#getPossibleValue() <em>Possible Value</em>}</li>
 *   <li>{@link configurationemf.Setting#getCurrentType() <em>Current Type</em>}</li>
 *   <li>{@link configurationemf.Setting#isValueChangeble() <em>Value Changeble</em>}</li>
 *   <li>{@link configurationemf.Setting#isRfs() <em>Rfs</em>}</li>
 * </ul>
 * </p>
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link configurationemf.Setting#getAbsRef() <em>Get Abs Ref</em>}</li>
 *   <li>{@link configurationemf.Setting#setConfValue(java.lang.String, configurationemf.Configuration) <em>Set Conf Value</em>}</li>
 *   <li>{@link configurationemf.Setting#getConfValue(configurationemf.Configuration) <em>Get Conf Value</em>}</li>
 *   <li>{@link configurationemf.Setting#getUserValue(java.lang.String) <em>Get User Value</em>}</li>
 *   <li>{@link configurationemf.Setting#getSystemValue(java.lang.String) <em>Get System Value</em>}</li>
 *   <li>{@link configurationemf.Setting#setConfRfs(boolean, configurationemf.RootConf) <em>Set Conf Rfs</em>}</li>
 *   <li>{@link configurationemf.Setting#getGValue() <em>Get GValue</em>}</li>
 *   <li>{@link configurationemf.Setting#getGConf() <em>Get GConf</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public abstract class SettingTest extends ReferableTest {

	/**
	 * Constructs a new Setting test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SettingTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Setting test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Setting getFixture() {
		return (Setting)fixture;
	}

	/**
	 * Tests the '{@link configurationemf.Setting#getBoolOptions() <em>Bool Options</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.Setting#getBoolOptions()
	 * @generated NOT
	 */
	public void testGetBoolOptions() {
		Setting setting = getFixture();
		Assert.assertTrue(setting.getBoolOptions().size()==0);
		setting.setType(TYPE.BOOLEAN);
		Assert.assertTrue(setting.getBoolOptions().size()==2);
		for(Iterator<Option>iOp=setting.getBoolOptions().iterator();iOp.hasNext();){
			Option op = iOp.next();
			if(op.getName().compareToIgnoreCase("on")==0&&op.getValue().compareTo("true")==0);
			else if(op.getName().compareToIgnoreCase("off")==0&&op.getValue().compareTo("false")==0);
			else
				Assert.assertTrue("Wrong boolean option", true);
		}
		setting.setType(TYPE.INT);
		Assert.assertFalse(setting.getBoolOptions().size()==2);
	}

	/**
	 * Tests the '{@link configurationemf.Setting#getDefaultValue() <em>Default Value</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.Setting#getDefaultValue()
	 * @generated NOT
	 */
	public void testGetDefaultValue() {
		fail();
	}

	/**
	 * Tests the '{@link configurationemf.Setting#getAbsRef() <em>Get Abs Ref</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.Setting#getAbsRef()
	 * @generated NOT
	 */
	public abstract  void testGetAbsRef();


	/**
	 * Tests the '{@link configurationemf.Setting#setConfValue(java.lang.String, configurationemf.Configuration) <em>Set Conf Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.Setting#setConfValue(java.lang.String, configurationemf.Configuration)
	 * @generated
	 */
	public void testSetConfValue__String_Configuration() {
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link configurationemf.Setting#getCurrentValue() <em>Current Value</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.Setting#getCurrentValue()
	 * @generated NOT
	 */
	public void testGetCurrentValue() {
		Setting setting =getFixture();
		Assert.assertTrue("Empty setting should have value null", setting.getCurrentValue()==null);
	}

	/**
	 * Tests the '{@link configurationemf.Setting#setCurrentValue(java.lang.String) <em>Current Value</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.Setting#setCurrentValue(java.lang.String)
	 * @generated NOT
	 */
	public abstract void testSetCurrentValue();
	

	/**
	 * Tests the '{@link configurationemf.Setting#getTopValue() <em>Top Value</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.Setting#getTopValue()
	 * @generated NOT
	 */
	public abstract void testGetTopValue();

	/**
	 * Tests the '{@link configurationemf.Setting#isRo() <em>Ro</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.Setting#isRo()
	 * @generated NOT
	 */
	public void testIsRo() {
		Setting setting = getFixture();
		assertFalse("Should be editable", setting.isRo());
	}

	/**
	 * Tests the '{@link configurationemf.Setting#getPossibleValue() <em>Possible Value</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.Setting#getPossibleValue()
	 * @generated
	 */
	public void testGetPossibleValue() {
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link configurationemf.Setting#getCurrentType() <em>Current Type</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.Setting#getCurrentType()
	 * @generated
	 */
	public void testGetCurrentType() {
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link configurationemf.Setting#setCurrentType(java.lang.String) <em>Current Type</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.Setting#setCurrentType(java.lang.String)
	 * @generated
	 */
	public void testSetCurrentType() {
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link configurationemf.Setting#isValueChangeble() <em>Value Changeble</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.Setting#isValueChangeble()
	 * @generated
	 */
	public void testIsValueChangeble() {
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link configurationemf.Setting#isRfs() <em>Rfs</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.Setting#isRfs()
	 * @generated NOT
	 */
	public abstract void testIsRfs();

	/**
	 * Tests the '{@link configurationemf.Setting#setRfs(boolean) <em>Rfs</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.Setting#setRfs(boolean)
	 * @generated NOT
	 */
	public abstract void testSetRfs();

	/**
	 * Tests the '{@link configurationemf.Setting#getConfValue(configurationemf.Configuration) <em>Get Conf Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.Setting#getConfValue(configurationemf.Configuration)
	 * @generated
	 */
	public void testGetConfValue__Configuration() {
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link configurationemf.Setting#getUserValue(java.lang.String) <em>Get User Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.Setting#getUserValue(java.lang.String)
	 * @generated
	 */
	public void testGetUserValue__String() {
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link configurationemf.Setting#getSystemValue(java.lang.String) <em>Get System Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.Setting#getSystemValue(java.lang.String)
	 * @generated
	 */
	public void testGetSystemValue__String() {
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link configurationemf.Setting#setConfRfs(boolean, configurationemf.RootConf) <em>Set Conf Rfs</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.Setting#setConfRfs(boolean, configurationemf.RootConf)
	 * @generated
	 */
	public void testSetConfRfs__boolean_RootConf() {
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link configurationemf.Setting#getGValue() <em>Get GValue</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.Setting#getGValue()
	 * @generated NOT
	 */
	public void testGetGValue() {
		
	}

	/**
	 * Tests the '{@link configurationemf.Setting#getGConf() <em>Get GConf</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.Setting#getGConf()
	 * @generated NOT
	 */
	public void testGetGConf() {
		 
	}

} //SettingTest
