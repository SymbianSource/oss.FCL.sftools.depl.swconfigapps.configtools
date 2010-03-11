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

import junit.textui.TestRunner;

import org.eclipse.emf.common.util.EList;

import com.nokia.tools.vct.confml.model.confml1.EConfML1Factory;
import com.nokia.tools.vct.confml.model.confml1.EDescriptionElement;
import com.nokia.tools.vct.confml.model.confml1.EIconElement;
import com.nokia.tools.vct.confml.model.confml1.ELinkElement;
import com.nokia.tools.vct.confml.model.confml1.EPropertyElement;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>EProperty Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml1.ELinkContainer#getLinks() <em>Links</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml1.EDescriptionContainer#getDescriptions() <em>Descriptions</em>}</li>
 *   <li>{@link com.nokia.tools.vct.confml.model.confml1.EIconContainer#getIcons() <em>Icons</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class EPropertyElementTest extends ECommonAttrsTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(EPropertyElementTest.class);
	}

	/**
	 * Constructs a new EProperty Element test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPropertyElementTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this EProperty Element test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPropertyElement getFixture() {
		return (EPropertyElement) fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(EConfML1Factory.eINSTANCE.createEPropertyElement());
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
		EPropertyElement fix = getFixture();
		EList<ELinkElement> links = fix.getLinks();
		assertNotNull(links);
		
		links.add(getFactory().createELinkElement());
		assertFalse(links.isEmpty());
	}

	/**
	 * Tests the '{@link com.nokia.tools.vct.confml.model.confml1.EDescriptionContainer#getDescriptions() <em>Descriptions</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.confml.model.confml1.EDescriptionContainer#getDescriptions()
	 * @generated NOT
	 */
	public void testGetDescriptions() {
		EList<EDescriptionElement> descriptions = getFixture().getDescriptions();
		assertNotNull(descriptions);
		descriptions.add(getFactory().createEDescriptionElement());
		assertFalse(descriptions.isEmpty());
	}

	/**
	 * Tests the '{@link com.nokia.tools.vct.confml.model.confml1.EIconContainer#getIcons() <em>Icons</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.nokia.tools.vct.confml.model.confml1.EIconContainer#getIcons()
	 * @generated NOT
	 */
	public void testGetIcons() {
		EList<EIconElement> icons = getFixture().getIcons();
		assertNotNull(icons);
		icons.add(getFactory().createEIconElement());
		assertFalse(icons.isEmpty());
	}

	
} //EPropertyElementTest
