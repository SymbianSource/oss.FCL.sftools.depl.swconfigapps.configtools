/*
* Copyright (c) 2007 Nokia Corporation and/or its subsidiary(-ies). 
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
package com.nokia.tools.s60ct.model.confml.provider;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

import com.nokia.tools.s60ct.model.confml.util.ConfmlAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ConfmlItemProviderAdapterFactory extends ConfmlAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfmlItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.nokia.tools.s60ct.model.confml.EFeature} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EFeatureItemProvider eFeatureItemProvider;

	/**
	 * This creates an adapter for a {@link com.nokia.tools.s60ct.model.confml.EFeature}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEFeatureAdapter() {
		if (eFeatureItemProvider == null) {
			eFeatureItemProvider = new EFeatureItemProvider(this);
		}

		return eFeatureItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.nokia.tools.s60ct.model.confml.ESimpleSetting} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ESimpleSettingItemProvider eSimpleSettingItemProvider;

	/**
	 * This creates an adapter for a {@link com.nokia.tools.s60ct.model.confml.ESimpleSetting}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createESimpleSettingAdapter() {
		if (eSimpleSettingItemProvider == null) {
			eSimpleSettingItemProvider = new ESimpleSettingItemProvider(this);
		}

		return eSimpleSettingItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.nokia.tools.s60ct.model.confml.ESequenceSetting} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ESequenceSettingItemProvider eSequenceSettingItemProvider;

	/**
	 * This creates an adapter for a {@link com.nokia.tools.s60ct.model.confml.ESequenceSetting}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createESequenceSettingAdapter() {
		if (eSequenceSettingItemProvider == null) {
			eSequenceSettingItemProvider = new ESequenceSettingItemProvider(this);
		}

		return eSequenceSettingItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.nokia.tools.s60ct.model.confml.EItemSetting} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EItemSettingItemProvider eItemSettingItemProvider;

	/**
	 * This creates an adapter for a {@link com.nokia.tools.s60ct.model.confml.EItemSetting}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEItemSettingAdapter() {
		if (eItemSettingItemProvider == null) {
			eItemSettingItemProvider = new EItemSettingItemProvider(this);
		}

		return eItemSettingItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.nokia.tools.s60ct.model.confml.ESubSettingValue} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ESubSettingValueItemProvider eSubSettingValueItemProvider;

	/**
	 * This creates an adapter for a {@link com.nokia.tools.s60ct.model.confml.ESubSettingValue}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createESubSettingValueAdapter() {
		if (eSubSettingValueItemProvider == null) {
			eSubSettingValueItemProvider = new ESubSettingValueItemProvider(this);
		}

		return eSubSettingValueItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.nokia.tools.s60ct.model.confml.EResourceSetting} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EResourceSettingItemProvider eResourceSettingItemProvider;

	/**
	 * This creates an adapter for a {@link com.nokia.tools.s60ct.model.confml.EResourceSetting}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEResourceSettingAdapter() {
		if (eResourceSettingItemProvider == null) {
			eResourceSettingItemProvider = new EResourceSettingItemProvider(this);
		}

		return eResourceSettingItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.nokia.tools.s60ct.model.confml.ESimpleValue} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ESimpleValueItemProvider eSimpleValueItemProvider;

	/**
	 * This creates an adapter for a {@link com.nokia.tools.s60ct.model.confml.ESimpleValue}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createESimpleValueAdapter() {
		if (eSimpleValueItemProvider == null) {
			eSimpleValueItemProvider = new ESimpleValueItemProvider(this);
		}

		return eSimpleValueItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.nokia.tools.s60ct.model.confml.ESequenceValue} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ESequenceValueItemProvider eSequenceValueItemProvider;

	/**
	 * This creates an adapter for a {@link com.nokia.tools.s60ct.model.confml.ESequenceValue}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createESequenceValueAdapter() {
		if (eSequenceValueItemProvider == null) {
			eSequenceValueItemProvider = new ESequenceValueItemProvider(this);
		}

		return eSequenceValueItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.nokia.tools.s60ct.model.confml.ESequenceValueItem} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ESequenceValueItemItemProvider eSequenceValueItemItemProvider;

	/**
	 * This creates an adapter for a {@link com.nokia.tools.s60ct.model.confml.ESequenceValueItem}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createESequenceValueItemAdapter() {
		if (eSequenceValueItemItemProvider == null) {
			eSequenceValueItemItemProvider = new ESequenceValueItemItemProvider(this);
		}

		return eSequenceValueItemItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.nokia.tools.s60ct.model.confml.EResourceValue} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EResourceValueItemProvider eResourceValueItemProvider;

	/**
	 * This creates an adapter for a {@link com.nokia.tools.s60ct.model.confml.EResourceValue}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEResourceValueAdapter() {
		if (eResourceValueItemProvider == null) {
			eResourceValueItemProvider = new EResourceValueItemProvider(this);
		}

		return eResourceValueItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.nokia.tools.s60ct.model.confml.EProperty} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EPropertyItemProvider ePropertyItemProvider;

	/**
	 * This creates an adapter for a {@link com.nokia.tools.s60ct.model.confml.EProperty}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEPropertyAdapter() {
		if (ePropertyItemProvider == null) {
			ePropertyItemProvider = new EPropertyItemProvider(this);
		}

		return ePropertyItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.nokia.tools.s60ct.model.confml.EOptionMap} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EOptionMapItemProvider eOptionMapItemProvider;

	/**
	 * This creates an adapter for a {@link com.nokia.tools.s60ct.model.confml.EOptionMap}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEOptionMapAdapter() {
		if (eOptionMapItemProvider == null) {
			eOptionMapItemProvider = new EOptionMapItemProvider(this);
		}

		return eOptionMapItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.nokia.tools.s60ct.model.confml.EOption} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EOptionItemProvider eOptionItemProvider;

	/**
	 * This creates an adapter for a {@link com.nokia.tools.s60ct.model.confml.EOption}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEOptionAdapter() {
		if (eOptionItemProvider == null) {
			eOptionItemProvider = new EOptionItemProvider(this);
		}

		return eOptionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.nokia.tools.s60ct.model.confml.EValueEditorDocument} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EValueEditorDocumentItemProvider eValueEditorDocumentItemProvider;

	/**
	 * This creates an adapter for a {@link com.nokia.tools.s60ct.model.confml.EValueEditorDocument}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEValueEditorDocumentAdapter() {
		if (eValueEditorDocumentItemProvider == null) {
			eValueEditorDocumentItemProvider = new EValueEditorDocumentItemProvider(this);
		}

		return eValueEditorDocumentItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.nokia.tools.s60ct.model.confml.Pattern} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PatternItemProvider patternItemProvider;

	/**
	 * This creates an adapter for a {@link com.nokia.tools.s60ct.model.confml.Pattern}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPatternAdapter() {
		if (patternItemProvider == null) {
			patternItemProvider = new PatternItemProvider(this);
		}

		return patternItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.nokia.tools.s60ct.model.confml.View} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ViewItemProvider viewItemProvider;

	/**
	 * This creates an adapter for a {@link com.nokia.tools.s60ct.model.confml.View}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createViewAdapter() {
		if (viewItemProvider == null) {
			viewItemProvider = new ViewItemProvider(this);
		}

		return viewItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.nokia.tools.s60ct.model.confml.EGroup} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EGroupItemProvider eGroupItemProvider;

	/**
	 * This creates an adapter for a {@link com.nokia.tools.s60ct.model.confml.EGroup}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEGroupAdapter() {
		if (eGroupItemProvider == null) {
			eGroupItemProvider = new EGroupItemProvider(this);
		}

		return eGroupItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class) || (((Class<?>)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		if (eFeatureItemProvider != null) eFeatureItemProvider.dispose();
		if (eSimpleSettingItemProvider != null) eSimpleSettingItemProvider.dispose();
		if (eSequenceSettingItemProvider != null) eSequenceSettingItemProvider.dispose();
		if (eItemSettingItemProvider != null) eItemSettingItemProvider.dispose();
		if (eSubSettingValueItemProvider != null) eSubSettingValueItemProvider.dispose();
		if (eResourceSettingItemProvider != null) eResourceSettingItemProvider.dispose();
		if (eSimpleValueItemProvider != null) eSimpleValueItemProvider.dispose();
		if (eSequenceValueItemProvider != null) eSequenceValueItemProvider.dispose();
		if (eSequenceValueItemItemProvider != null) eSequenceValueItemItemProvider.dispose();
		if (eResourceValueItemProvider != null) eResourceValueItemProvider.dispose();
		if (ePropertyItemProvider != null) ePropertyItemProvider.dispose();
		if (eOptionMapItemProvider != null) eOptionMapItemProvider.dispose();
		if (eOptionItemProvider != null) eOptionItemProvider.dispose();
		if (eValueEditorDocumentItemProvider != null) eValueEditorDocumentItemProvider.dispose();
		if (patternItemProvider != null) patternItemProvider.dispose();
		if (viewItemProvider != null) viewItemProvider.dispose();
		if (eGroupItemProvider != null) eGroupItemProvider.dispose();
	}

}
