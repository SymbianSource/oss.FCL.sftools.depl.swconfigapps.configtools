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

import com.nokia.tools.vct.confml.model.confml1.EConfML1Factory;
import com.nokia.tools.vct.confml.model.confml1.EConfML1Package;
import com.nokia.tools.vct.confml.model.confml1.EConfMLDocument;
import com.nokia.tools.vct.confml.model.confml1.EConfigurationElement;

import com.nokia.tools.vct.confml.model.confml1.util.EConfML1ResourceFactoryImpl;

import java.io.File;
import java.io.IOException;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import org.eclipse.emf.ecore.util.Diagnostician;

import org.eclipse.emf.ecore.xmi.impl.RootXMLContentHandlerImpl;

/**
 * <!-- begin-user-doc -->
 * A sample utility for the '<em><b>confml1</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class EConfML1Example {
	/**
	 * <!-- begin-user-doc -->
	 * Load all the argument file paths or URIs as instances of the model.
	 * <!-- end-user-doc -->
	 * @param args the file paths or URIs.
	 * @generated
	 */
	public static void main(String[] args) {
		// Create a resource set to hold the resources.
		//
		ResourceSet resourceSet = new ResourceSetImpl();

		// Register the appropriate resource factory to handle the content type.
		//
		resourceSet.getResourceFactoryRegistry().getContentTypeToFactoryMap()
				.put(EConfML1Package.eCONTENT_TYPE,
						new EConfML1ResourceFactoryImpl());

		// Register the appropriate content handler for all file extensions and any element from the package's namespace.
		//
		resourceSet.getURIConverter().getContentHandlers().add(
				new RootXMLContentHandlerImpl(EConfML1Package.eCONTENT_TYPE,
						null, null, EConfML1Package.eNS_URI, null));

		// Register the package to ensure it is available during loading.
		//
		resourceSet.getPackageRegistry().put(EConfML1Package.eNS_URI,
				EConfML1Package.eINSTANCE);

		// If there are no arguments, emit an appropriate usage message.
		//
		if (args.length == 0) {
			System.out
					.println("Enter a list of file paths or URIs that have content like this:");
			try {
				Resource resource = resourceSet.createResource(URI
						.createURI("http:///My.confml"),
						EConfML1Package.eCONTENT_TYPE);
				EConfMLDocument documentRoot = EConfML1Factory.eINSTANCE
						.createEConfMLDocument();
				EConfigurationElement root = EConfML1Factory.eINSTANCE
						.createEConfigurationElement();
				documentRoot.setConfiguration(root);
				resource.getContents().add(documentRoot);
				resource.save(System.out, null);
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		} else {
			// Iterate over all the arguments.
			//
			for (int i = 0; i < args.length; ++i) {
				// Construct the URI for the instance file.
				// The argument is treated as a file path only if it denotes an existing file.
				// Otherwise, it's directly treated as a URL.
				//
				File file = new File(args[i]);
				URI uri = file.isFile() ? URI.createFileURI(file
						.getAbsolutePath()) : URI.createURI(args[0]);

				try {
					// Demand load resource for this file.
					//
					Resource resource = resourceSet.getResource(uri, true);
					System.out.println("Loaded " + uri);

					// Validate the contents of the loaded resource.
					//
					for (EObject eObject : resource.getContents()) {
						Diagnostic diagnostic = Diagnostician.INSTANCE
								.validate(eObject);
						if (diagnostic.getSeverity() != Diagnostic.OK) {
							printDiagnostic(diagnostic, "");
						}
					}
				} catch (RuntimeException exception) {
					System.out.println("Problem loading " + uri);
					exception.printStackTrace();
				}
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * Prints diagnostics with indentation.
	 * <!-- end-user-doc -->
	 * @param diagnostic the diagnostic to print.
	 * @param indent the indentation for printing.
	 * @generated
	 */
	protected static void printDiagnostic(Diagnostic diagnostic, String indent) {
		System.out.print(indent);
		System.out.println(diagnostic.getMessage());
		for (Diagnostic child : diagnostic.getChildren()) {
			printDiagnostic(child, indent + "  ");
		}
	}

} //EConfML1Example
