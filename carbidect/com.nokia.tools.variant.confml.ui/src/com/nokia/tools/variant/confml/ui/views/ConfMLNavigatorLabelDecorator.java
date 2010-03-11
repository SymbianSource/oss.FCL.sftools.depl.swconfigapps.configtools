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
 * Description: This file is part of com.nokia.tools.variant.confml.ui component.
 */

package com.nokia.tools.variant.confml.ui.views;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;

import com.nokia.tools.vct.common.appmodel.EAppFeature;
import com.nokia.tools.vct.common.appmodel.EAppSetting;
import com.nokia.tools.vct.common.appmodel.EConfMLLayer;

public class ConfMLNavigatorLabelDecorator extends ConfMLViewLabelProvider
		implements ILightweightLabelDecorator {

	EMap<String, EAppFeature> parentFeatures;

	public void decorate(Object element, IDecoration decoration) {
		if (element instanceof EAppFeature) {
			EAppFeature feature = (EAppFeature) element;
			EConfMLLayer layer = (EConfMLLayer)feature.eContainer().eContainer();
			
//			if (ev.getParents().size() > 0) {
//				EParentReference parentReference = ev.getParents().get(0);
//				parentFeatures = parentReference.getResolved().getFeatures();
//				EAppFeatureEntryImpl[] array = (EAppFeatureEntryImpl[]) parentFeatures
//						.toArray();
//				for (int i = 0; i < array.length; i++) {
//					if (feature.getName().equals(array[i].getValue().getName())) {
//						ImageDescriptor overlay = ConfmlUI
//								.getImageDescriptor(IConfmlImages.DEC_ALERT);
//						decoration
//								.addOverlay(overlay, IDecoration.BOTTOM_RIGHT);
//					}
//				}
//			}
		}
		if (element instanceof EAppSetting) {

			EAppSetting setting = (EAppSetting) element;
			EAppFeature feature = (EAppFeature) setting.eContainer()
					.eContainer();
			EConfMLLayer layer = (EConfMLLayer)feature.eContainer().eContainer();
//			IF (EV.GETPARENTS().SIZE() > 0) {
//				EPARENTREFERENCE PARENTREFERENCE = EV.GETPARENTS().GET(0);
//				PARENTFEATURES = PARENTREFERENCE.GETRESOLVED().GETFEATURES();
//				EAPPFEATUREENTRYIMPL[] ARRAY = (EAPPFEATUREENTRYIMPL[]) PARENTFEATURES
//						.TOARRAY();
//				FOR (INT I = 0; I < ARRAY.LENGTH; I++) {
//					IF (FEATURE.GETNAME().EQUALS(ARRAY[I].GETVALUE().GETNAME())) {
//						IMAGEDESCRIPTOR OVERLAY = CONFMLUI
//								.GETIMAGEDESCRIPTOR(ICONFMLIMAGES.DEC_ALERT);
//						DECORATION
//								.ADDOVERLAY(OVERLAY, IDECORATION.BOTTOM_RIGHT);
//					}
//				}
//			}
		}
	}
}
