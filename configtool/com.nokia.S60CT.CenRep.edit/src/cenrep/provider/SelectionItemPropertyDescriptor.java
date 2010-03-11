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

package cenrep.provider;

import java.util.Collection;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;

public abstract class SelectionItemPropertyDescriptor extends
		ItemPropertyDescriptor {

	public SelectionItemPropertyDescriptor(AdapterFactory adapterFactory,
			String displayName, String description, EStructuralFeature feature) {
		super(adapterFactory, displayName, description, feature);
		
	}

	public SelectionItemPropertyDescriptor(AdapterFactory adapterFactory,
			String displayName, String description,
			EReference[] parentReferences) {
		super(adapterFactory, displayName, description, parentReferences);
		
	}

	public SelectionItemPropertyDescriptor(AdapterFactory adapterFactory,
			ResourceLocator resourceLocator, String displayName,
			String description, EStructuralFeature feature) {
		super(adapterFactory, resourceLocator, displayName, description,
				feature);
		
	}

	public SelectionItemPropertyDescriptor(AdapterFactory adapterFactory,
			String displayName, String description, EStructuralFeature feature,
			boolean isSettable) {
		super(adapterFactory, displayName, description, feature, isSettable);
		
	}

	public SelectionItemPropertyDescriptor(AdapterFactory adapterFactory,
			ResourceLocator resourceLocator, String displayName,
			String description, EReference[] parentReferences) {
		super(adapterFactory, resourceLocator, displayName, description,
				parentReferences);
		
	}

	public SelectionItemPropertyDescriptor(AdapterFactory adapterFactory,
			String displayName, String description,
			EReference[] parentReferences, boolean isSettable) {
		super(adapterFactory, displayName, description, parentReferences,
				isSettable);
		
	}

	public SelectionItemPropertyDescriptor(AdapterFactory adapterFactory,
			ResourceLocator resourceLocator, String displayName,
			String description, EStructuralFeature feature, boolean isSettable) {
		super(adapterFactory, resourceLocator, displayName, description,
				feature, isSettable);
		
	}

	public SelectionItemPropertyDescriptor(AdapterFactory adapterFactory,
			String displayName, String description, EStructuralFeature feature,
			boolean isSettable, Object staticImage) {
		super(adapterFactory, displayName, description, feature, isSettable,
				staticImage);
		
	}

	public SelectionItemPropertyDescriptor(AdapterFactory adapterFactory,
			String displayName, String description, EStructuralFeature feature,
			boolean isSettable, String category) {
		super(adapterFactory, displayName, description, feature, isSettable,
				category);
		
	}

	public SelectionItemPropertyDescriptor(AdapterFactory adapterFactory,
			ResourceLocator resourceLocator, String displayName,
			String description, EReference[] parentReferences,
			boolean isSettable) {
		super(adapterFactory, resourceLocator, displayName, description,
				parentReferences, isSettable);
		
	}

	public SelectionItemPropertyDescriptor(AdapterFactory adapterFactory,
			String displayName, String description,
			EReference[] parentReferences, boolean isSettable, String category) {
		super(adapterFactory, displayName, description, parentReferences,
				isSettable, category);
		
	}

	public SelectionItemPropertyDescriptor(AdapterFactory adapterFactory,
			ResourceLocator resourceLocator, String displayName,
			String description, EStructuralFeature feature, boolean isSettable,
			Object staticImage) {
		super(adapterFactory, resourceLocator, displayName, description,
				feature, isSettable, staticImage);
		
	}

	public SelectionItemPropertyDescriptor(AdapterFactory adapterFactory,
			ResourceLocator resourceLocator, String displayName,
			String description, EStructuralFeature feature, boolean isSettable,
			String category) {
		super(adapterFactory, resourceLocator, displayName, description,
				feature, isSettable, category);
		
	}

	public SelectionItemPropertyDescriptor(AdapterFactory adapterFactory,
			String displayName, String description, EStructuralFeature feature,
			boolean isSettable, Object staticImage, String category) {
		super(adapterFactory, displayName, description, feature, isSettable,
				staticImage, category);
		
	}

	public SelectionItemPropertyDescriptor(AdapterFactory adapterFactory,
			String displayName, String description, EStructuralFeature feature,
			boolean isSettable, String category, String[] filterFlags) {
		super(adapterFactory, displayName, description, feature, isSettable,
				category, filterFlags);
		
	}

	public SelectionItemPropertyDescriptor(AdapterFactory adapterFactory,
			ResourceLocator resourceLocator, String displayName,
			String description, EReference[] parentReferences,
			boolean isSettable, String category) {
		super(adapterFactory, resourceLocator, displayName, description,
				parentReferences, isSettable, category);
		
	}

	public SelectionItemPropertyDescriptor(AdapterFactory adapterFactory,
			String displayName, String description,
			EReference[] parentReferences, boolean isSettable, String category,
			String[] filterFlags) {
		super(adapterFactory, displayName, description, parentReferences,
				isSettable, category, filterFlags);
		
	}

	public SelectionItemPropertyDescriptor(AdapterFactory adapterFactory,
			ResourceLocator resourceLocator, String displayName,
			String description, EStructuralFeature feature, boolean isSettable,
			Object staticImage, String category) {
		super(adapterFactory, resourceLocator, displayName, description,
				feature, isSettable, staticImage, category);
	}

	public SelectionItemPropertyDescriptor(AdapterFactory adapterFactory,
			ResourceLocator resourceLocator, String displayName,
			String description, EStructuralFeature feature, boolean isSettable,
			String category, String[] filterFlags) {
		super(adapterFactory, resourceLocator, displayName, description,
				feature, isSettable, category, filterFlags);
	}

	public SelectionItemPropertyDescriptor(AdapterFactory adapterFactory,
			String displayName, String description, EStructuralFeature feature,
			boolean isSettable, Object staticImage, String category,
			String[] filterFlags) {
		super(adapterFactory, displayName, description, feature, isSettable,
				staticImage, category, filterFlags);
	}

	public SelectionItemPropertyDescriptor(AdapterFactory adapterFactory,
			ResourceLocator resourceLocator, String displayName,
			String description, EReference[] parentReferences,
			boolean isSettable, String category, String[] filterFlags) {
		super(adapterFactory, resourceLocator, displayName, description,
				parentReferences, isSettable, category, filterFlags);
	}

	public SelectionItemPropertyDescriptor(AdapterFactory adapterFactory,
			ResourceLocator resourceLocator, String displayName,
			String description, EStructuralFeature feature, boolean isSettable,
			Object staticImage, String category, String[] filterFlags) {
		super(adapterFactory, resourceLocator, displayName, description,
				feature, isSettable, staticImage, category, filterFlags);
	}

	public SelectionItemPropertyDescriptor(AdapterFactory adapterFactory,
			ResourceLocator resourceLocator, String displayName,
			String description, EStructuralFeature feature, boolean isSettable,
			boolean multiLine, boolean sortChoices, Object staticImage,
			String category, String[] filterFlags) {
		super(adapterFactory, resourceLocator, displayName, description,
				feature, isSettable, multiLine, sortChoices, staticImage,
				category, filterFlags);
	}
	
	protected abstract Collection getComboBoxObjects(Object object);
}
