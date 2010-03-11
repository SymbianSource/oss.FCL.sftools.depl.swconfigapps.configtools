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
package search.ui.areas;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.search.ui.areas.AbstractModelSearchParticipantArea;
import org.eclipse.emf.search.ui.pages.AbstractModelSearchPage;
import org.eclipse.emf.search.ui.providers.AbstractMetaModelParticipantsItemProvider;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.graphics.Image;
import org.eclipse.emf.search.utils.ModelSearchImagesUtil;
import java.net.URL;

import search.ui.Activator;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;

import java.util.Collection;

import search.util.TextualFeaturesUtils;

import search.ui.providers.MetaModelParticipantsItemProvider;

import com.nokia.tools.vct.crml.crmodel.provider.ECRMLItemProviderAdapterFactory;

import com.nokia.tools.vct.crml.crmodel.ECRMLPackage;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import java.util.Arrays;

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

		if (ECRMLPackage.eNS_URI.equals(nsURI)) {
			composeableAdapterFactories
					.add(new ECRMLItemProviderAdapterFactory());
		}

		if (nsURI == null || "".equals(nsURI)) {

			composeableAdapterFactories
					.add(new ECRMLItemProviderAdapterFactory());

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

		if (ECRMLPackage.eNS_URI.equals(nsURI)) {
			return Arrays.asList(new EPackage[] { ECRMLPackage.eINSTANCE });
		}

		return Arrays.asList(new EPackage[] {

		ECRMLPackage.eINSTANCE

		});
	}

	public Collection<String> getTargetMetaModelIDs() {

		if (ECRMLPackage.eNS_URI.equals(nsURI)) {
			return Arrays.asList(new String[] { nsURI });
		}

		return Arrays.asList(new String[] {

		ECRMLPackage.eNS_URI

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
				URL url = FileLocator
						.find(
								com.nokia.tools.vct.crml.crmodel.provider.CRMLModelEditPlugin
										.getPlugin().getBundle(), new Path(
										imagePath), null);
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
									"Error while attempmting to retrieve image from edit" + com.nokia.tools.vct.crml.crmodel.provider.CRMLModelEditPlugin.getPlugin().getBundle() + " bundle")); //$NON-NLS-1$  //$NON-NLS-2$
		}
		return null;
	}

	private String computeElementImageName(String name) {
		return name;
	}
}
