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

package search.ui.providers;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.search.ui.providers.AbstractMetaModelParticipantsItemProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

import com.nokia.tools.vct.crml.crmodel.ECRMLPackage;

public class MetaModelParticipantsItemProvider extends
		AbstractMetaModelParticipantsItemProvider {
	private Collection<String> nsURIs;

	public MetaModelParticipantsItemProvider(Collection<String> nsURIs) {
		this.nsURIs = nsURIs;
	}

	public Object[] getElements(Object inputElement) {
		List<EClassifier> eClassifierList = new ArrayList<EClassifier>();

		if (nsURIs.contains(ECRMLPackage.eNS_URI)) {
			eClassifierList.addAll(ECRMLPackage.eINSTANCE.getEClassifiers());
		}

		return eClassifierList.toArray();
	}
}
