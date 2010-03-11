/*
* Copyright (c) 2008 Nokia Corporation and/or its subsidiary(-ies).
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

package com.nokia.tools.vct.confml.model.confml1.tests;

import org.eclipse.emf.common.util.EList;

import com.nokia.tools.vct.confml.model.confml1.EConfML1Factory;
import com.nokia.tools.vct.confml.model.confml1.EMetaContent;
import com.nokia.tools.vct.confml.model.confml1.EMetaElement;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>EMeta Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml1.ELinkContainer#getLinks() <em>Links</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml1.EIconContainer#getIcons() <em>Icons</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml1.EMetaElement#getId() <em>Id</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml1.EMetaElement#getDate() <em>Date</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml1.EMetaElement#getOwner() <em>Owner</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml1.EMetaElement#getEditor() <em>Editor</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml1.EMetaElement#getProduct() <em>Product</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml1.EMetaElement#getStatus() <em>Status</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml1.EMetaElement#getPlatform() <em>Platform</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml1.EMetaElement#getVersion() <em>Version</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml1.EMetaElement#getRelease() <em>Release</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml1.EMetaElement#getCustomer() <em>Customer</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml1.EMetaElement#getConfigurationProperty() <em>Configuration Property</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml1.EMetaElement#getOtherElements() <em>Other Elements</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class EMetaElementTest extends TestCase {

	/**
	 * The fixture for this EMeta Element test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EMetaElement fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(EMetaElementTest.class);
	}

	/**
	 * Constructs a new EMeta Element test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMetaElementTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this EMeta Element test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(EMetaElement fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this EMeta Element test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EMetaElement getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(EConfML1Factory.eINSTANCE.createEMetaElement());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

	/**
	 * Tests the '{@link com.nokia.tools.vct.confml.model.confml1.ELinkContainer#getLinks() <em>Links</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.confml.model.confml1.ELinkContainer#getLinks()
	 * @generated NOT
	 */
	public void testGetLinks() {
//		fail();
	}

	/**
	 * Tests the '{@link com.nokia.tools.vct.confml.model.confml1.EIconContainer#getIcons() <em>Icons</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.confml.model.confml1.EIconContainer#getIcons()
	 * @generated NOT
	 */
	public void testGetIcons() {
//		fail();
	}

	/**
	 * Tests the '{@link com.nokia.tools.vct.confml.model.confml1.EMetaElement#getId() <em>Id</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.confml.model.confml1.EMetaElement#getId()
	 * @generated NOT
	 */
	public void testGetId() {
		EList<EMetaContent> id = getFixture().getId();
		assertNotNull(id);
		EMetaContent metaContent = getFactory().createEMetaContent();
		String exId = "test";
		metaContent.setId(exId);
		metaContent.setValue("value");		
		id.add(metaContent);
		assertEquals(metaContent, id.get(0));
		assertEquals(exId, id.get(0).getId());
	}

	/**
	 * Tests the '{@link com.nokia.tools.vct.confml.model.confml1.EMetaElement#getDate() <em>Date</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.confml.model.confml1.EMetaElement#getDate()
	 * @generated NOT
	 */
	public void testGetDate() {
		EList<EMetaContent> date = getFixture().getDate();
		assertNotNull(date);
	}

	/**
	 * Tests the '{@link com.nokia.tools.vct.confml.model.confml1.EMetaElement#getOwner() <em>Owner</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.confml.model.confml1.EMetaElement#getOwner()
	 * @generated NOT
	 */
	public void testGetOwner() {
	}

	/**
	 * Tests the '{@link com.nokia.tools.vct.confml.model.confml1.EMetaElement#getEditor() <em>Editor</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.confml.model.confml1.EMetaElement#getEditor()
	 * @generated NOT
	 */
	public void testGetEditor() {
	}

	/**
	 * Tests the '{@link com.nokia.tools.vct.confml.model.confml1.EMetaElement#getProduct() <em>Product</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.confml.model.confml1.EMetaElement#getProduct()
	 * @generated NOT
	 */
	public void testGetProduct() {
	}

	/**
	 * Tests the '{@link com.nokia.tools.vct.confml.model.confml1.EMetaElement#getStatus() <em>Status</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.confml.model.confml1.EMetaElement#getStatus()
	 * @generated NOT
	 */
	public void testGetStatus() {
	}

	/**
	 * Tests the '{@link com.nokia.tools.vct.confml.model.confml1.EMetaElement#getPlatform() <em>Platform</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.confml.model.confml1.EMetaElement#getPlatform()
	 * @generated NOT
	 */
	public void testGetPlatform() {
	}

	/**
	 * Tests the '{@link com.nokia.tools.vct.confml.model.confml1.EMetaElement#getVersion() <em>Version</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.confml.model.confml1.EMetaElement#getVersion()
	 * @generated NOT
	 */
	public void testGetVersion() {
	}

	/**
	 * Tests the '{@link com.nokia.tools.vct.confml.model.confml1.EMetaElement#getRelease() <em>Release</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.confml.model.confml1.EMetaElement#getRelease()
	 * @generated NOT
	 */
	public void testGetRelease() {
	}

	/**
	 * Tests the '{@link com.nokia.tools.vct.confml.model.confml1.EMetaElement#getCustomer() <em>Customer</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.confml.model.confml1.EMetaElement#getCustomer()
	 * @generated NOT
	 */
	public void testGetCustomer() {
	}

	/**
	 * Tests the '{@link com.nokia.tools.vct.confml.model.confml1.EMetaElement#getConfigurationProperty() <em>Configuration Property</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.confml.model.confml1.EMetaElement#getConfigurationProperty()
	 * @generated NOT
	 */
	public void testGetConfigurationProperty() {
	}

	/**
	 * Tests the '{@link com.nokia.tools.vct.confml.model.confml1.EMetaElement#getOtherElements() <em>Other Elements</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.confml.model.confml1.EMetaElement#getOtherElements()
	 * @generated NOT
	 */
	public void testGetOtherElements() {
	}
	
	protected EConfML1Factory getFactory() {
		return EConfML1Factory.eINSTANCE;
	}
} //EMetaElementTest
