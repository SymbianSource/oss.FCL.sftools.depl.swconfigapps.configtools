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
 * Description: This file is part of com.nokia.tools.vct.validation.crml component.
 */

package com.nokia.tools.vct.validation.crml.constraints;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;

import com.nokia.tools.vct.crml.crmodel.ECRMLDocumentRoot;
import com.nokia.tools.vct.crml.crmodel.EKey;

public class DuplicateKeyRefConstraint extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx) {
		EKey key = (EKey) ctx.getTarget();
		Object cache = ctx.getCurrentConstraintData();
		if (cache == null) {
			cache = buildKeyRefCache(key);
			ctx.putCurrentConstraintData(cache);
		}
		Map<?, ?> map = (Map<?, ?>) cache;
		String ref = key.getRef();
		if (ref == null) {
			// not checked here
			return ctx.createSuccessStatus();
		}
		ref = ref.trim();
		if (ref.length() == 0) {
			// not checked here
			return ctx.createSuccessStatus();
		}
		AtomicInteger integer = (AtomicInteger) map.get(ref);
		if (integer != null && integer.get() > 1) {
			return ctx.createFailureStatus(key.getRef());
		}

		return ctx.createSuccessStatus();
	}

	protected Object buildKeyRefCache(EKey key) {
		Map<String, AtomicInteger> refs = new HashMap<String, AtomicInteger>();

		Resource tmp = key.eResource();
		ResourceSet rs = tmp.getResourceSet();
		for (Resource resource : rs.getResources()) {
			if (resource.getContents().isEmpty()) {
				continue;
			}
			EObject root = resource.getContents().get(0);
			if (!(root instanceof ECRMLDocumentRoot)) {
				continue;
			}
			ECRMLDocumentRoot repo = (ECRMLDocumentRoot) root;
			for (EKey k : repo.getRepository().getKey()) {
				String ref = k.getRef();
				if (ref == null) {
					// missing -  not checked here
					continue;
				}
				ref = ref.trim();
				if (ref.length() == 0) {
					// empty - not checked here
					continue;
				}
				AtomicInteger value = refs.get(ref);
				if (value == null) {
					value = new AtomicInteger(0);
					refs.put(ref, value);
				}
				value.incrementAndGet();
			}
		}
		return refs;
	}
}
