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
package configurationemf.provider;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
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

import configurationemf.util.ConfigurationemfAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ConfigurationemfItemProviderAdapterFactory extends ConfigurationemfAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
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
	public ConfigurationemfItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link configurationemf.Feature} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FeatureItemProvider featureItemProvider;

	/**
	 * This creates an adapter for a {@link configurationemf.Feature}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createFeatureAdapter() {
		if (featureItemProvider == null) {
			featureItemProvider = new FeatureItemProvider(this);
		}

		return featureItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link configurationemf.View} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ViewItemProvider viewItemProvider;

	/**
	 * This creates an adapter for a {@link configurationemf.View}.
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
	 * This keeps track of the one adapter used for all {@link configurationemf.Option} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OptionItemProvider optionItemProvider;

	/**
	 * This creates an adapter for a {@link configurationemf.Option}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createOptionAdapter() {
		if (optionItemProvider == null) {
			optionItemProvider = new OptionItemProvider(this);
		}

		return optionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link configurationemf.Meta} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MetaItemProvider metaItemProvider;

	/**
	 * This creates an adapter for a {@link configurationemf.Meta}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMetaAdapter() {
		if (metaItemProvider == null) {
			metaItemProvider = new MetaItemProvider(this);
		}

		return metaItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link configurationemf.Identification} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IdentificationItemProvider identificationItemProvider;

	/**
	 * This creates an adapter for a {@link configurationemf.Identification}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createIdentificationAdapter() {
		if (identificationItemProvider == null) {
			identificationItemProvider = new IdentificationItemProvider(this);
		}

		return identificationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link configurationemf.Date} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DateItemProvider dateItemProvider;

	/**
	 * This creates an adapter for a {@link configurationemf.Date}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDateAdapter() {
		if (dateItemProvider == null) {
			dateItemProvider = new DateItemProvider(this);
		}

		return dateItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link configurationemf.Owner} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OwnerItemProvider ownerItemProvider;

	/**
	 * This creates an adapter for a {@link configurationemf.Owner}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createOwnerAdapter() {
		if (ownerItemProvider == null) {
			ownerItemProvider = new OwnerItemProvider(this);
		}

		return ownerItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link configurationemf.Editor} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EditorItemProvider editorItemProvider;

	/**
	 * This creates an adapter for a {@link configurationemf.Editor}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEditorAdapter() {
		if (editorItemProvider == null) {
			editorItemProvider = new EditorItemProvider(this);
		}

		return editorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link configurationemf.Status} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StatusItemProvider statusItemProvider;

	/**
	 * This creates an adapter for a {@link configurationemf.Status}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createStatusAdapter() {
		if (statusItemProvider == null) {
			statusItemProvider = new StatusItemProvider(this);
		}

		return statusItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link configurationemf.Version} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VersionItemProvider versionItemProvider;

	/**
	 * This creates an adapter for a {@link configurationemf.Version}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createVersionAdapter() {
		if (versionItemProvider == null) {
			versionItemProvider = new VersionItemProvider(this);
		}

		return versionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link configurationemf.Platform} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PlatformItemProvider platformItemProvider;

	/**
	 * This creates an adapter for a {@link configurationemf.Platform}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPlatformAdapter() {
		if (platformItemProvider == null) {
			platformItemProvider = new PlatformItemProvider(this);
		}

		return platformItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link configurationemf.Product} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProductItemProvider productItemProvider;

	/**
	 * This creates an adapter for a {@link configurationemf.Product}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createProductAdapter() {
		if (productItemProvider == null) {
			productItemProvider = new ProductItemProvider(this);
		}

		return productItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link configurationemf.Customer} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CustomerItemProvider customerItemProvider;

	/**
	 * This creates an adapter for a {@link configurationemf.Customer}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCustomerAdapter() {
		if (customerItemProvider == null) {
			customerItemProvider = new CustomerItemProvider(this);
		}

		return customerItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link configurationemf.GSetting} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GSettingItemProvider gSettingItemProvider;

	/**
	 * This creates an adapter for a {@link configurationemf.GSetting}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createGSettingAdapter() {
		if (gSettingItemProvider == null) {
			gSettingItemProvider = new GSettingItemProvider(this);
		}

		return gSettingItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link configurationemf.Property} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertyItemProvider propertyItemProvider;

	/**
	 * This creates an adapter for a {@link configurationemf.Property}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPropertyAdapter() {
		if (propertyItemProvider == null) {
			propertyItemProvider = new PropertyItemProvider(this);
		}

		return propertyItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link configurationemf.Pattern} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PatternItemProvider patternItemProvider;

	/**
	 * This creates an adapter for a {@link configurationemf.Pattern}.
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
	 * This keeps track of the one adapter used for all {@link configurationemf.Length} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LengthItemProvider lengthItemProvider;

	/**
	 * This creates an adapter for a {@link configurationemf.Length}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createLengthAdapter() {
		if (lengthItemProvider == null) {
			lengthItemProvider = new LengthItemProvider(this);
		}

		return lengthItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link configurationemf.MaxLength} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MaxLengthItemProvider maxLengthItemProvider;

	/**
	 * This creates an adapter for a {@link configurationemf.MaxLength}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMaxLengthAdapter() {
		if (maxLengthItemProvider == null) {
			maxLengthItemProvider = new MaxLengthItemProvider(this);
		}

		return maxLengthItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link configurationemf.MinLength} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MinLengthItemProvider minLengthItemProvider;

	/**
	 * This creates an adapter for a {@link configurationemf.MinLength}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMinLengthAdapter() {
		if (minLengthItemProvider == null) {
			minLengthItemProvider = new MinLengthItemProvider(this);
		}

		return minLengthItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link configurationemf.MaxExclusive} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MaxExclusiveItemProvider maxExclusiveItemProvider;

	/**
	 * This creates an adapter for a {@link configurationemf.MaxExclusive}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMaxExclusiveAdapter() {
		if (maxExclusiveItemProvider == null) {
			maxExclusiveItemProvider = new MaxExclusiveItemProvider(this);
		}

		return maxExclusiveItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link configurationemf.MaxInclusive} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MaxInclusiveItemProvider maxInclusiveItemProvider;

	/**
	 * This creates an adapter for a {@link configurationemf.MaxInclusive}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMaxInclusiveAdapter() {
		if (maxInclusiveItemProvider == null) {
			maxInclusiveItemProvider = new MaxInclusiveItemProvider(this);
		}

		return maxInclusiveItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link configurationemf.MinInclusive} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MinInclusiveItemProvider minInclusiveItemProvider;

	/**
	 * This creates an adapter for a {@link configurationemf.MinInclusive}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMinInclusiveAdapter() {
		if (minInclusiveItemProvider == null) {
			minInclusiveItemProvider = new MinInclusiveItemProvider(this);
		}

		return minInclusiveItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link configurationemf.MinExclusive} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MinExclusiveItemProvider minExclusiveItemProvider;

	/**
	 * This creates an adapter for a {@link configurationemf.MinExclusive}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMinExclusiveAdapter() {
		if (minExclusiveItemProvider == null) {
			minExclusiveItemProvider = new MinExclusiveItemProvider(this);
		}

		return minExclusiveItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link configurationemf.TotalDigits} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TotalDigitsItemProvider totalDigitsItemProvider;

	/**
	 * This creates an adapter for a {@link configurationemf.TotalDigits}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createTotalDigitsAdapter() {
		if (totalDigitsItemProvider == null) {
			totalDigitsItemProvider = new TotalDigitsItemProvider(this);
		}

		return totalDigitsItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link configurationemf.LeafSetting} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LeafSettingItemProvider leafSettingItemProvider;

	/**
	 * This creates an adapter for a {@link configurationemf.LeafSetting}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createLeafSettingAdapter() {
		if (leafSettingItemProvider == null) {
			leafSettingItemProvider = new LeafSettingItemProvider(this);
		}

		return leafSettingItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link configurationemf.ParentSetting} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParentSettingItemProvider parentSettingItemProvider;

	/**
	 * This creates an adapter for a {@link configurationemf.ParentSetting}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createParentSettingAdapter() {
		if (parentSettingItemProvider == null) {
			parentSettingItemProvider = new ParentSettingItemProvider(this);
		}

		return parentSettingItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link configurationemf.LeafGroup} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LeafGroupItemProvider leafGroupItemProvider;

	/**
	 * This creates an adapter for a {@link configurationemf.LeafGroup}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createLeafGroupAdapter() {
		if (leafGroupItemProvider == null) {
			leafGroupItemProvider = new LeafGroupItemProvider(this);
		}

		return leafGroupItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link configurationemf.ParentGroup} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParentGroupItemProvider parentGroupItemProvider;

	/**
	 * This creates an adapter for a {@link configurationemf.ParentGroup}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createParentGroupAdapter() {
		if (parentGroupItemProvider == null) {
			parentGroupItemProvider = new ParentGroupItemProvider(this);
		}

		return parentGroupItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link configurationemf.Icon} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IconItemProvider iconItemProvider;

	/**
	 * This creates an adapter for a {@link configurationemf.Icon}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createIconAdapter() {
		if (iconItemProvider == null) {
			iconItemProvider = new IconItemProvider(this);
		}

		return iconItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link configurationemf.Link} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LinkItemProvider linkItemProvider;

	/**
	 * This creates an adapter for a {@link configurationemf.Link}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createLinkAdapter() {
		if (linkItemProvider == null) {
			linkItemProvider = new LinkItemProvider(this);
		}

		return linkItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link configurationemf.RootConf} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RootConfItemProvider rootConfItemProvider;

	/**
	 * This creates an adapter for a {@link configurationemf.RootConf}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRootConfAdapter() {
		if (rootConfItemProvider == null) {
			rootConfItemProvider = new RootConfItemProvider(this);
		}

		return rootConfItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link configurationemf.SubConf} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SubConfItemProvider subConfItemProvider;

	/**
	 * This creates an adapter for a {@link configurationemf.SubConf}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSubConfAdapter() {
		if (subConfItemProvider == null) {
			subConfItemProvider = new SubConfItemProvider(this);
		}

		return subConfItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link configurationemf.Data} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataItemProvider dataItemProvider;

	/**
	 * This creates an adapter for a {@link configurationemf.Data}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDataAdapter() {
		if (dataItemProvider == null) {
			dataItemProvider = new DataItemProvider(this);
		}

		return dataItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link configurationemf.Rfs} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RfsItemProvider rfsItemProvider;

	/**
	 * This creates an adapter for a {@link configurationemf.Rfs}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRfsAdapter() {
		if (rfsItemProvider == null) {
			rfsItemProvider = new RfsItemProvider(this);
		}

		return rfsItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link configurationemf.Ref} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RefItemProvider refItemProvider;

	/**
	 * This creates an adapter for a {@link configurationemf.Ref}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRefAdapter() {
		if (refItemProvider == null) {
			refItemProvider = new RefItemProvider(this);
		}

		return refItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link configurationemf.Frame} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FrameItemProvider frameItemProvider;

	/**
	 * This creates an adapter for a {@link configurationemf.Frame}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createFrameAdapter() {
		if (frameItemProvider == null) {
			frameItemProvider = new FrameItemProvider(this);
		}

		return frameItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link configurationemf.LeafSettingDelegator} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LeafSettingDelegatorItemProvider leafSettingDelegatorItemProvider;

	/**
	 * This creates an adapter for a {@link configurationemf.LeafSettingDelegator}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createLeafSettingDelegatorAdapter() {
		if (leafSettingDelegatorItemProvider == null) {
			leafSettingDelegatorItemProvider = new LeafSettingDelegatorItemProvider(this);
		}

		return leafSettingDelegatorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link configurationemf.Release} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReleaseItemProvider releaseItemProvider;

	/**
	 * This creates an adapter for a {@link configurationemf.Release}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createReleaseAdapter() {
		if (releaseItemProvider == null) {
			releaseItemProvider = new ReleaseItemProvider(this);
		}

		return releaseItemProvider;
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
	 * @generated NOT
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		if(!(notifier instanceof EObject))return null;
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
		if (featureItemProvider != null) featureItemProvider.dispose();
		if (viewItemProvider != null) viewItemProvider.dispose();
		if (optionItemProvider != null) optionItemProvider.dispose();
		if (metaItemProvider != null) metaItemProvider.dispose();
		if (releaseItemProvider != null) releaseItemProvider.dispose();
		if (identificationItemProvider != null) identificationItemProvider.dispose();
		if (dateItemProvider != null) dateItemProvider.dispose();
		if (ownerItemProvider != null) ownerItemProvider.dispose();
		if (editorItemProvider != null) editorItemProvider.dispose();
		if (statusItemProvider != null) statusItemProvider.dispose();
		if (versionItemProvider != null) versionItemProvider.dispose();
		if (platformItemProvider != null) platformItemProvider.dispose();
		if (productItemProvider != null) productItemProvider.dispose();
		if (customerItemProvider != null) customerItemProvider.dispose();
		if (gSettingItemProvider != null) gSettingItemProvider.dispose();
		if (propertyItemProvider != null) propertyItemProvider.dispose();
		if (patternItemProvider != null) patternItemProvider.dispose();
		if (lengthItemProvider != null) lengthItemProvider.dispose();
		if (maxLengthItemProvider != null) maxLengthItemProvider.dispose();
		if (minLengthItemProvider != null) minLengthItemProvider.dispose();
		if (maxExclusiveItemProvider != null) maxExclusiveItemProvider.dispose();
		if (maxInclusiveItemProvider != null) maxInclusiveItemProvider.dispose();
		if (minInclusiveItemProvider != null) minInclusiveItemProvider.dispose();
		if (minExclusiveItemProvider != null) minExclusiveItemProvider.dispose();
		if (totalDigitsItemProvider != null) totalDigitsItemProvider.dispose();
		if (leafSettingItemProvider != null) leafSettingItemProvider.dispose();
		if (parentSettingItemProvider != null) parentSettingItemProvider.dispose();
		if (leafGroupItemProvider != null) leafGroupItemProvider.dispose();
		if (parentGroupItemProvider != null) parentGroupItemProvider.dispose();
		if (iconItemProvider != null) iconItemProvider.dispose();
		if (linkItemProvider != null) linkItemProvider.dispose();
		if (rootConfItemProvider != null) rootConfItemProvider.dispose();
		if (subConfItemProvider != null) subConfItemProvider.dispose();
		if (dataItemProvider != null) dataItemProvider.dispose();
		if (rfsItemProvider != null) rfsItemProvider.dispose();
		if (refItemProvider != null) refItemProvider.dispose();
		if (frameItemProvider != null) frameItemProvider.dispose();
		if (leafSettingDelegatorItemProvider != null) leafSettingDelegatorItemProvider.dispose();
	}

}