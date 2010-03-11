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
package com.nokia.tools.variant.confml.core.model.application.eval;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notifier;

import com.nokia.tools.variant.confml.core.model.application.EAppResourceData;
import com.nokia.tools.variant.confml.core.model.application.EAppSequenceData;
import com.nokia.tools.variant.confml.core.model.application.EAppSequenceDataItem;
import com.nokia.tools.variant.confml.core.model.application.EConfMLLayer;
import com.nokia.tools.variant.confml.core.model.application.EConfigurationProject;
import com.nokia.tools.variant.confml.core.model.application.util.EApplicationAdapterFactory;
import com.nokia.tools.vct.confml.expressions.providers.IItemConfmlExpressionProvider;

/**
 * This is the factory that is used to provide the interfaces needed to support
 * ConfML expression evaluator. Note that most of the adapters are shared among
 * multiple instances.
 */
public class EApplicationModelItemProviderAdapterFactory extends
        EApplicationAdapterFactory implements AdapterFactory {
    /**
     * This keeps track of all the supported types checked by
     * {@link #isFactoryForType isFactoryForType}.
     */
    protected Collection<Object> supportedTypes = new ArrayList<Object>();

    /**
     * This constructs an instance.
     */
    public EApplicationModelItemProviderAdapterFactory() {
        supportedTypes.add(IItemConfmlExpressionProvider.class);
    }

    /**
     * This keeps track of the one adapter used for all {@link EAppSimpleData}
     * instances.
     */
    protected EAppSimpleDataItemProvider eAppSimpleDataItemProvider;

    @Override
    public Adapter createEAppSimpleDataAdapter() {
        if (eAppSimpleDataItemProvider == null) {
            eAppSimpleDataItemProvider = new EAppSimpleDataItemProvider();
        }
        return eAppSimpleDataItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link EAppSequenceData}
     * instances.
     */
    protected EAppSequenceDataItemProvider eAppSequenceDataItemProvider;

    @Override
    public Adapter createEAppSequenceDataAdapter() {
        if (eAppSequenceDataItemProvider == null) {
            eAppSequenceDataItemProvider = new EAppSequenceDataItemProvider();
        }
        return eAppSequenceDataItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link EAppSequenceDataItem} instances.
     */
    protected EAppSequenceDataItemItemProvider eAppSequenceDataItemItemProvider;

    @Override
    public Adapter createEAppSequenceDataItemAdapter() {
        if (eAppSequenceDataItemItemProvider == null) {
            eAppSequenceDataItemItemProvider = new EAppSequenceDataItemItemProvider();
        }
        return eAppSequenceDataItemItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link EAppResourceData}
     * instances.
     */
    protected EAppResourceDataItemProvider eAppResourceDataItemProvider;

    @Override
    public Adapter createEAppResourceDataAdapter() {
        if (eAppResourceDataItemProvider == null) {
            eAppResourceDataItemProvider = new EAppResourceDataItemProvider();
        }
        return eAppResourceDataItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link EConfMLLayer}
     * instances.
     */
    protected EConfMLLayerItemProvider eConfMLLayerItemProvider;

    @Override
    public Adapter createEConfMLLayerAdapter() {
        if (eConfMLLayerItemProvider == null) {
            eConfMLLayerItemProvider = new EConfMLLayerItemProvider();
        }
        return eConfMLLayerItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link EConfigurationProject} instances.
     */
    protected EConfigurationProjectItemProvider eConfigurationProjectItemProvider;

    @Override
    public Adapter createEConfigurationProjectAdapter() {
        if (eConfigurationProjectItemProvider == null) {
            eConfigurationProjectItemProvider = new EConfigurationProjectItemProvider();
        }
        return eConfigurationProjectItemProvider;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean isFactoryForType(Object type) {
        return supportedTypes.contains(type) || super.isFactoryForType(type);
    }

    /**
     * This implementation substitutes the factory itself as the key for the
     * adapter. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter adapt(Notifier notifier, Object type) {
        return super.adapt(notifier, this);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object adapt(Object object, Object type) {
        if (isFactoryForType(type)) {
            Object adapter = super.adapt(object, type);
            if (!(type instanceof Class)
                    || (((Class<?>) type).isInstance(adapter))) {
                return adapter;
            }
        }

        return null;
    }

    /**
     * This disposes all of the item providers created by this factory.
     */
    public void dispose() {
        if (eAppSimpleDataItemProvider != null)
            eAppSimpleDataItemProvider.dispose();
        if (eAppSequenceDataItemProvider != null)
            eAppSequenceDataItemProvider.dispose();
        if (eAppSequenceDataItemItemProvider != null)
            eAppSequenceDataItemItemProvider.dispose();
        if (eAppResourceDataItemProvider != null)
            eAppResourceDataItemProvider.dispose();
        if (eConfMLLayerItemProvider != null)
            eConfMLLayerItemProvider.dispose();
        if (eConfigurationProjectItemProvider != null)
            eConfigurationProjectItemProvider.dispose();
    }

}
