/*
 * Copyright (c) 2009 Nokia Corporation and/or its subsidiary(-ies).
 * All rights reserved.
 * This component and the accompanying materials are made available
 * under the terms of "Eclipse Public License v1.0"
 * which accompanies this distribution, and is available
 * at the URL "http://www.eclipse.org/legal/epl-v10.html".
 * 
 * Initial Contributors:
 * Nokia Corporation - Initial contribution
 * 
 * Contributors:
 * 
 * Description: This file is part of com.nokia.tools.variant.confml.ui component.
 */

package com.nokia.tools.variant.confml.ui.editors;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;

/**
 * Generic interface for document manager.
 * 
 * Document (model) manager is responsible for managing the document instances.
 * The instance type depends on the particular implementation, i.e. views editor
 * model, CPF editor model etc.
 * 
 * The document is a reserved resource that requires explicit allocation and
 * destruction.
 * 
 * @param <T>
 *            Runtime type of the managed document type
 */
public interface IDocumentManager<T extends EObject> {
	/**
	 * Obtain the model reference that is bound to the given resource. Depending
	 * on the model manager implementation it can be a newly created instance or
	 * shared document instance.
	 * 
	 * The contract implies that the returned model is registered to all
	 * required content providers and is updated automatically when required.
	 * 
	 * The allocated model reference must be explicitly released with the
	 * {@link #saveModel(EObject, IProgressMonitor)} call.
	 * 
	 * The document keeps a reference of the original persistence representation
	 * for supporting out-of-domain information preservation.
	 * 
	 * @see #saveModel(EObject, IProgressMonitor)
	 * 
	 * @param file
	 *            File to load content from
	 * @param monitor
	 *            Progress monitor to use
	 * @return
	 * @throws CoreException
	 */

	T getModel(IFile file, IProgressMonitor monitor) throws CoreException;

	/**
	 * Release the document instance. The document reference must not be used
	 * after this call.
	 * 
	 * If the model has any changes that are not saved and the model is not
	 * shared, then the changes are lost.
	 * 
	 * @param document
	 *            Document instance to release
	 */
	void releaseDocument(T document);

	/**
	 * Save the data contained in the document instance.
	 * 
	 * When the document is saved, only data related to the application domain
	 * layer is updated. For example, when the original document has contained
	 * both view and data definitions and the view editor's model has been
	 * constructed, the model manipulation does not affect the data definition,
	 * which is preserved.
	 * 
	 * @param document
	 *            Document to save
	 * @param monitor
	 * @throws CoreException
	 */
	void saveModel(T document, IProgressMonitor monitor) throws CoreException;
}
