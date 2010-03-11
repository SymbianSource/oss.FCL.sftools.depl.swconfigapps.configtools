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
 * Description: This file is part of com.nokia.tools.vct.crml.edit component.
 */

package com.nokia.tools.vct.crml.crmodel.provider;

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

import com.nokia.tools.vct.crml.crmodel.util.ECRMLAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ECRMLItemProviderAdapterFactory extends ECRMLAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
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
	public ECRMLItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.nokia.tools.vct.crml.crmodel.EMeta} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EMetaItemProvider eMetaItemProvider;

	/**
	 * This creates an adapter for a {@link com.nokia.tools.vct.crml.crmodel.EMeta}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEMetaAdapter() {
		if (eMetaItemProvider == null) {
			eMetaItemProvider = new EMetaItemProvider(this);
		}

		return eMetaItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.nokia.tools.vct.crml.crmodel.EContent} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EContentItemProvider eContentItemProvider;

	/**
	 * This creates an adapter for a {@link com.nokia.tools.vct.crml.crmodel.EContent}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEContentAdapter() {
		if (eContentItemProvider == null) {
			eContentItemProvider = new EContentItemProvider(this);
		}

		return eContentItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.nokia.tools.vct.crml.crmodel.ERepository} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ERepositoryItemProvider eRepositoryItemProvider;

	/**
	 * This creates an adapter for a {@link com.nokia.tools.vct.crml.crmodel.ERepository}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createERepositoryAdapter() {
		if (eRepositoryItemProvider == null) {
			eRepositoryItemProvider = new ERepositoryItemProvider(this);
		}

		return eRepositoryItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.nokia.tools.vct.crml.crmodel.EKey} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EKeyItemProvider eKeyItemProvider;

	/**
	 * This creates an adapter for a {@link com.nokia.tools.vct.crml.crmodel.EKey}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEKeyAdapter() {
		if (eKeyItemProvider == null) {
			eKeyItemProvider = new EKeyItemProvider(this);
		}

		return eKeyItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.nokia.tools.vct.crml.crmodel.EKeyRange} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EKeyRangeItemProvider eKeyRangeItemProvider;

	/**
	 * This creates an adapter for a {@link com.nokia.tools.vct.crml.crmodel.EKeyRange}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEKeyRangeAdapter() {
		if (eKeyRangeItemProvider == null) {
			eKeyRangeItemProvider = new EKeyRangeItemProvider(this);
		}

		return eKeyRangeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.nokia.tools.vct.crml.crmodel.EAccess} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EAccessItemProvider eAccessItemProvider;

	/**
	 * This creates an adapter for a {@link com.nokia.tools.vct.crml.crmodel.EAccess}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEAccessAdapter() {
		if (eAccessItemProvider == null) {
			eAccessItemProvider = new EAccessItemProvider(this);
		}

		return eAccessItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.nokia.tools.vct.crml.crmodel.EValue} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EValueItemProvider eValueItemProvider;

	/**
	 * This creates an adapter for a {@link com.nokia.tools.vct.crml.crmodel.EValue}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEValueAdapter() {
		if (eValueItemProvider == null) {
			eValueItemProvider = new EValueItemProvider(this);
		}

		return eValueItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.nokia.tools.vct.crml.crmodel.EBit} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EBitItemProvider eBitItemProvider;

	/**
	 * This creates an adapter for a {@link com.nokia.tools.vct.crml.crmodel.EBit}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEBitAdapter() {
		if (eBitItemProvider == null) {
			eBitItemProvider = new EBitItemProvider(this);
		}

		return eBitItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.nokia.tools.vct.crml.crmodel.ECRMLDocumentRoot} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ECRMLDocumentRootItemProvider ecrmlDocumentRootItemProvider;

	/**
	 * This creates an adapter for a {@link com.nokia.tools.vct.crml.crmodel.ECRMLDocumentRoot}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createECRMLDocumentRootAdapter() {
		if (ecrmlDocumentRootItemProvider == null) {
			ecrmlDocumentRootItemProvider = new ECRMLDocumentRootItemProvider(this);
		}

		return ecrmlDocumentRootItemProvider;
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
		if (eMetaItemProvider != null) eMetaItemProvider.dispose();
		if (eContentItemProvider != null) eContentItemProvider.dispose();
		if (eRepositoryItemProvider != null) eRepositoryItemProvider.dispose();
		if (eKeyItemProvider != null) eKeyItemProvider.dispose();
		if (eKeyRangeItemProvider != null) eKeyRangeItemProvider.dispose();
		if (eAccessItemProvider != null) eAccessItemProvider.dispose();
		if (eValueItemProvider != null) eValueItemProvider.dispose();
		if (eBitItemProvider != null) eBitItemProvider.dispose();
		if (ecrmlDocumentRootItemProvider != null) ecrmlDocumentRootItemProvider.dispose();
	}

}
