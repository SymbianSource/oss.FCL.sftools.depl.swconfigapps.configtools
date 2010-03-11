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
 * Description: This file is part of com.nokia.tools.variant.confml.core component.
 */

package com.nokia.tools.variant.confml.core.model.metadata.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;

import com.nokia.tools.variant.confml.core.model.metadata.ECPFMetadata;
import com.nokia.tools.variant.confml.core.model.metadata.EMetaProperty;
import com.nokia.tools.variant.confml.core.model.metadata.EMetadata;
import com.nokia.tools.variant.confml.core.model.metadata.EMetadataFactory;

/**
 */
public class ECPFMetadataResourceImpl extends ResourceImpl {

	private Resource delegate;

	/**
	 * Creates an instance of the resource. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param uri
	 *            the URI of the new resource.
	 */
	public ECPFMetadataResourceImpl(URI uri) {
		super(uri);
		delegate = new EMetadataResourceFactoryImpl().createResource(uri);
	}

	@Override
	protected void doLoad(InputStream inputStream, Map<?, ?> options)
			throws IOException {
		delegate.load(inputStream, options);

		if (delegate.getContents().size() != 1) {
			throw new IOException("Malformed Input");
		}
		EObject contents = delegate.getContents().get(0);
		if (!(contents instanceof EMetadata)) {
			throw new IOException("Unexpected Input");
		}
		EMetadata metadata = (EMetadata) contents;
		ECPFMetadata result = EMetadataFactory.eINSTANCE.createECPFMetadata();		 
		for (EMetaProperty property : metadata.getProperties()) {
			String name = property.getName();
			if ("cpf.name".equals(name)) {
				result.setName(property.getValue());
			} else if ("cpf.description".equals(name)) {
				result.setDescription(property.getValue());
			} else if ("cpf.viewId".equals(name)) {
				result.setViewId(property.getValue());
			} else if ("cpf.rootFile".equals(name)) {
				result.setCpfRootFile(property.getValue());
			} else if ("cpf.dataFile".equals(name)) {
				result.setDataOverrideFile(property.getValue());
			} else if ("cpf.owner".equals(name)) {
				result.setOwner(property.getValue());
			} else if ("cpf.product".equals(name)) {
				result.setProduct(property.getValue());
			} else if ("cpf.author".equals(name)) {
				result.setAuthor(property.getValue());
			} else if ("cpf.version".equals(name)) {
				result.setVersion(property.getValue());
			} else if ("cpf.customer".equals(name)) {
				result.setCustomer(property.getValue());
			} else if ("cpf.platform".equals(name)) {
				result.setPlatform(property.getValue());
			} else if ("cpf.release".equals(name)) {
				result.setRelease(property.getValue());
			} else if ("cpf.date".equals(name)) {
				result.setDate(property.getValue());
			}
			
		}

		getContents().add(result);
	}

	@Override
	protected void doSave(OutputStream outputStream, Map<?, ?> options)
			throws IOException {
		ECPFMetadata cpfMetadata = (ECPFMetadata) getContents().get(0);

		EMetadata metadata = EMetadataFactory.eINSTANCE.createEMetadata();

		addProperty(metadata, "cpf.name", cpfMetadata.getName());
		addProperty(metadata, "cpf.description", cpfMetadata.getDescription());
		addProperty(metadata, "cpf.viewId", cpfMetadata.getViewId());
		addProperty(metadata, "cpf.rootFile", cpfMetadata.getCpfRootFile());
		addProperty(metadata, "cpf.dataFile", cpfMetadata.getDataOverrideFile());
		addProperty(metadata, "cpf.author", cpfMetadata.getAuthor());
		addProperty(metadata, "cpf.version", cpfMetadata.getVersion());
		addProperty(metadata, "cpf.product", cpfMetadata.getProduct());
		addProperty(metadata, "cpf.customer", cpfMetadata.getCustomer());
		addProperty(metadata, "cpf.platform", cpfMetadata.getPlatform());
		addProperty(metadata, "cpf.release", cpfMetadata.getRelease());
		addProperty(metadata, "cpf.date", cpfMetadata.getDate());
		addProperty(metadata, "cpf.owner", cpfMetadata.getOwner());

		

		URI uri = delegate.getURI();
		if (uri == null) {
			delegate.setURI(URI.createFileURI(".metadata"));
		}
		delegate.unload();
		delegate.getContents().add(metadata);

		delegate.save(outputStream, options);
	}

	@Override
	protected void doUnload() {
		delegate.unload();
		super.doUnload();
	}

	private static void addProperty(EMetadata metadata, String name,
			String value) {
		EMetaProperty property = EMetadataFactory.eINSTANCE
				.createEMetaProperty();
		property.setName(name);
		property.setValue(value);
		metadata.getProperties().add(property);
	}

} // EMetadataResourceImpl
