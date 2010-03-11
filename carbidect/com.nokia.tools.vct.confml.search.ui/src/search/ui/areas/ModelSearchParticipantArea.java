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
 * Description: This file is part of com.nokia.tools.vct.confml.search.ui component.
 */

package search.ui.areas;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.search.ui.areas.AbstractModelSearchParticipantArea;
import org.eclipse.emf.search.ui.pages.AbstractModelSearchPage;
import org.eclipse.emf.search.ui.providers.AbstractMetaModelParticipantsItemProvider;
import org.eclipse.emf.search.utils.ModelSearchImagesUtil;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;

import search.ui.Activator;
import search.ui.providers.MetaModelParticipantsItemProvider;

import com.nokia.tools.vct.confml.model.confml1.EConfML1Package;
import com.nokia.tools.vct.confml.model.confml1.edit.provider.EConfML1ItemProviderAdapterFactory;
import com.nokia.tools.vct.confml.model.confml2.EConfML2Package;
import com.nokia.tools.vct.confml.model.confml2.provider.EConfML2ItemProviderAdapterFactory;
import com.nokia.tools.vct.confml.model.xsd.EXSDFacetPackage;
import com.nokia.tools.vct.confml.model.xsd.provider.EXSDFacetItemProviderAdapterFactory;

public final class ModelSearchParticipantArea extends
		AbstractModelSearchParticipantArea {

	private String nsURI;

	public ModelSearchParticipantArea(Composite parent,
			AbstractModelSearchPage page, int style) {
		super(parent, page, style);
		createContent();
	}

	public ModelSearchParticipantArea(Composite parent,
			AbstractModelSearchPage page, int style, String nsURI) {
		super(parent, page, style);
		this.nsURI = nsURI;
		createContent();
	}

	@Override
	protected boolean getDefaultParticpantsControlEnabling() {
		return false;
	}

	@Override
	public List<AdapterFactory> getMetaElementComposeableAdapterFactories(
			String nsURI) {
		return getMetaElementComposeableAdapterFactories();
	}

	@Override
	public List<AdapterFactory> getMetaElementComposeableAdapterFactories() {
		List<AdapterFactory> composeableAdapterFactories = new ArrayList<AdapterFactory>();
		composeableAdapterFactories.add(new EcoreItemProviderAdapterFactory());

		if (EConfML1Package.eNS_URI.equals(nsURI)) {
			composeableAdapterFactories
					.add(new EConfML1ItemProviderAdapterFactory());
		}
		if (EConfML2Package.eNS_URI.equals(nsURI)) {
			composeableAdapterFactories
					.add(new EConfML2ItemProviderAdapterFactory());
		}

		if (EXSDFacetPackage.eNS_URI.equals(nsURI)) {
			composeableAdapterFactories
					.add(new EXSDFacetItemProviderAdapterFactory());
		}

		if (nsURI == null || "".equals(nsURI)) {

			composeableAdapterFactories
					.add(new EConfML1ItemProviderAdapterFactory());

			composeableAdapterFactories
					.add(new EXSDFacetItemProviderAdapterFactory());

		}
		composeableAdapterFactories
				.add(new ResourceItemProviderAdapterFactory());
		return composeableAdapterFactories;
	}

	@Override
	public AbstractMetaModelParticipantsItemProvider getMetaModelParticipantsItemProvider() {
		return new MetaModelParticipantsItemProvider(getTargetMetaModelIDs());
	}

	@Override
	protected Collection<EPackage> getTargetModelPackages() {

		if (EConfML1Package.eNS_URI.equals(nsURI)) {
			return Arrays.asList(new EPackage[] { EConfML1Package.eINSTANCE });
		}
		if (EConfML2Package.eNS_URI.equals(nsURI)) {
			return Arrays.asList(new EPackage[] { EConfML2Package.eINSTANCE });
		}
		if (EXSDFacetPackage.eNS_URI.equals(nsURI)) {
			return Arrays.asList(new EPackage[] { EXSDFacetPackage.eINSTANCE });
		}

		return Arrays.asList(new EPackage[] {

		EConfML1Package.eINSTANCE,

		EXSDFacetPackage.eINSTANCE

		});
	}

	public Collection<String> getTargetMetaModelIDs() {

		if (EConfML1Package.eNS_URI.equals(nsURI)) {
			return Arrays.asList(new String[] { nsURI });
		}
		if (EConfML2Package.eNS_URI.equals(nsURI)) {
			return Arrays.asList(new String[] { nsURI });
		}

		if (EXSDFacetPackage.eNS_URI.equals(nsURI)) {
			return Arrays.asList(new String[] { nsURI });
		}

		return Arrays.asList(new String[] {

		EConfML1Package.eNS_URI,
		EConfML2Package.eNS_URI,
		EXSDFacetPackage.eNS_URI

		});
	}

	@Override
	protected String getTargetModelElementText(Object object) {
		return object instanceof ENamedElement ? ((ENamedElement) object)
				.getName() : null;
	}

	@Override
	protected Image getTargetModelElementImage(Object object) {
		try {
			if (object instanceof ENamedElement) {
				String imagePath = "/icons/full/obj16/" + computeElementImageName(((ENamedElement) object).getName()) + ".gif"; //$NON-NLS-1$  //$NON-NLS-2$
				URL url = FileLocator.find(
						com.nokia.tools.vct.confml.edit.ConfMLEditPlugin
								.getPlugin().getBundle(), new Path(imagePath),
						null);
				if (url != null) {
					return ModelSearchImagesUtil.getImage(url);
				}
			}
		} catch (Throwable t) {
			Activator
					.getDefault()
					.getLog()
					.log(
							new Status(
									Status.ERROR,
									Activator.PLUGIN_ID,
									"Error while attempmting to retrieve image from edit" + com.nokia.tools.vct.confml.edit.ConfMLEditPlugin.getPlugin().getBundle() + " bundle")); //$NON-NLS-1$  //$NON-NLS-2$
		}
		return null;
	}

	private String computeElementImageName(String name) {
		return name;
	}
}
