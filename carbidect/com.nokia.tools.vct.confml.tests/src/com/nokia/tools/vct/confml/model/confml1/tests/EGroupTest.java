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
import com.nokia.tools.vct.confml.model.confml1.EGroup;
import com.nokia.tools.vct.confml.model.confml1.ESettingElement;
import com.nokia.tools.vct.confml.model.confml1.include.EConfMLIncludeFactory;
import com.nokia.tools.vct.confml.model.confml1.include.EInclude;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>EGroup</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml1.ELinkContainer#getLinks() <em>Links</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml1.EDescriptionContainer#getDescriptions() <em>Descriptions</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml1.EIconContainer#getIcons() <em>Icons</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml1.EGroupContainer#getGroups() <em>Groups</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml1.EGroupContainer#getIncludes() <em>Includes</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml1.EGroup#getSettings() <em>Settings</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class EGroupTest extends ECommonAttrsTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(EGroupTest.class);
	}

	/**
	 * Constructs a new EGroup test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EGroupTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this EGroup test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EGroup getFixture() {
		return (EGroup) fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(EConfML1Factory.eINSTANCE.createEGroup());
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
	}

	/**
	 * Tests the '{@link com.nokia.tools.vct.confml.model.confml1.EDescriptionContainer#getDescriptions() <em>Descriptions</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.confml.model.confml1.EDescriptionContainer#getDescriptions()
	 * @generated NOT
	 */
	public void testGetDescriptions() {
	}

	/**
	 * Tests the '{@link com.nokia.tools.vct.confml.model.confml1.EIconContainer#getIcons() <em>Icons</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.confml.model.confml1.EIconContainer#getIcons()
	 * @generated NOT
	 */
	public void testGetIcons() {
	}

	/**
	 * Tests the '{@link com.nokia.tools.vct.confml.model.confml1.EGroupContainer#getGroups() <em>Groups</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.confml.model.confml1.EGroupContainer#getGroups()
	 * @generated NOT
	 */
	public void testGetGroups() {
		EGroup fix = getFixture();
		EList<EGroup> groups = fix.getGroups();
		assertNotNull(groups);
		groups.add(getFactory().createEGroup());
		assertFalse(groups.isEmpty());
	}

	/**
	 * Tests the '{@link com.nokia.tools.vct.confml.model.confml1.EGroupContainer#getIncludes() <em>Includes</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.confml.model.confml1.EGroupContainer#getIncludes()
	 * @generated NOT
	 */
	public void testGetIncludes() {
		EList<EInclude> includes = getFixture().getIncludes();
		EInclude inc = EConfMLIncludeFactory.eINSTANCE.createEInclude();
		String test = "some.confml";
		inc.setHref(test);
		includes.add(inc);
		assertFalse(includes.isEmpty());
		assertEquals(test, includes.get(0).getHref());
	}

	/**
	 * Tests the '{@link com.nokia.tools.vct.confml.model.confml1.EGroup#getSettings() <em>Settings</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.confml.model.confml1.EGroup#getSettings()
	 * @generated NOT
	 */
	public void testGetSettings() {
		EList<ESettingElement> settings = getFixture().getSettings();
		assertTrue(settings.isEmpty());
		settings.add(getFactory().createESettingElement());
		assertFalse(settings.isEmpty());
	}

} //EGroupTest
