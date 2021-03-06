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
 * Description: This file is part of com.nokia.tools.vct.validation.confml component.
 */

package com.nokia.tools.vct.validation.confml.constraints;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;

import com.nokia.tools.vct.confml.model.confml1.EFeatureElement;

public class DuplicateFeatureName extends AbstractModelConstraint {

	public DuplicateFeatureName() {
		super();
	}

	@Override
	public IStatus validate(IValidationContext ctx) {
		Set<String> duplicates = getDuplicateContext(ctx);
		String name;
		String ref;
		if (ctx.getTarget() instanceof EFeatureElement) {
			EFeatureElement featureElement = (EFeatureElement) ctx.getTarget();
			name = featureElement.getName();
			ref = featureElement.getRef();
		} else if (ctx.getTarget() instanceof com.nokia.tools.vct.confml.model.confml2.EFeatureElement) {
			com.nokia.tools.vct.confml.model.confml2.EFeatureElement featureElement = (com.nokia.tools.vct.confml.model.confml2.EFeatureElement) ctx
					.getTarget();
			name = featureElement.getName();
			ref = featureElement.getRef();
		} else {
			throw new IllegalArgumentException();
		}

		if (duplicates.contains(name)) {
			return ctx.createFailureStatus(ref, name);
		}

		return ctx.createSuccessStatus();
	}

	@SuppressWarnings("unchecked")
	private Set<String> getDuplicateContext(IValidationContext ctx) {
		if (ctx.getCurrentConstraintData() instanceof Set) {
			return (Set<String>) ctx.getCurrentConstraintData();
		}

		Set<String> result = new HashSet<String>();
		ctx.putCurrentConstraintData(result);

		Map<String, AtomicInteger> map = new LinkedHashMap<String, AtomicInteger>();

		EObject obj = ((EObject) ctx.getTarget());
		ResourceSet rs = obj.eResource().getResourceSet();
		TreeIterator<Object> it = EcoreUtil.getAllContents(rs, false);
		while (it.hasNext()) {
			Object o = it.next();
			if (o instanceof EFeatureElement) {
				populateMap(map, (EFeatureElement) o);
				it.prune();
			} else if (o instanceof com.nokia.tools.vct.confml.model.confml2.EFeatureElement) {
				populateMap(
						map,
						(com.nokia.tools.vct.confml.model.confml2.EFeatureElement) o);
				it.prune();
			}
		}
		for (Map.Entry<String, AtomicInteger> entry : map.entrySet()) {
			if (entry.getValue().get() > 1) {
				result.add(entry.getKey());
			}
		}

		return result;
	}

	private void populateMap(Map<String, AtomicInteger> map,
			EFeatureElement featureElement) {
		String name = featureElement.getName();
		if (name == null) {
			return;
		}
		name = name.trim().toLowerCase();
		AtomicInteger value = map.get(name);
		if (value == null) {
			value = new AtomicInteger(1);
			map.put(name, value);
		} else {
			value.incrementAndGet();
		}
	}

	private void populateMap(
			Map<String, AtomicInteger> map,
			com.nokia.tools.vct.confml.model.confml2.EFeatureElement featureElement) {
		String name = featureElement.getName();
		if (name == null) {
			return;
		}
		name = name.trim().toLowerCase();
		AtomicInteger value = map.get(name);
		if (value == null) {
			value = new AtomicInteger(1);
			map.put(name, value);
		} else {
			value.incrementAndGet();
		}
	}

}
