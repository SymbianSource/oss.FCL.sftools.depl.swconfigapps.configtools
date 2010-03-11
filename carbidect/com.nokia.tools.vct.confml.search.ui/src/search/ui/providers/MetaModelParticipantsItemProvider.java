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

package search.ui.providers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.search.ui.providers.AbstractMetaModelParticipantsItemProvider;

import com.nokia.tools.vct.confml.model.confml1.EConfML1Package;
import com.nokia.tools.vct.confml.model.xsd.EXSDFacetPackage;

public class MetaModelParticipantsItemProvider extends
		AbstractMetaModelParticipantsItemProvider {
	private Collection<String> nsURIs;

	public MetaModelParticipantsItemProvider(Collection<String> nsURIs) {
		this.nsURIs = nsURIs;
	}

	public Object[] getElements(Object inputElement) {
		List<EClassifier> eClassifierList = new ArrayList<EClassifier>();

		if (nsURIs.contains(EConfML1Package.eNS_URI)) {
			eClassifierList.addAll(EConfML1Package.eINSTANCE.getEClassifiers());
		}

		if (nsURIs.contains(EXSDFacetPackage.eNS_URI)) {
			eClassifierList
					.addAll(EXSDFacetPackage.eINSTANCE.getEClassifiers());
		}

		return eClassifierList.toArray();
	}
}
