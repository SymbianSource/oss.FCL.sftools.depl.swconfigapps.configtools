/*
 * Copyright (c) 2009 Nokia Corporation and/or its subsidiary(-ies). 
 * All rights reserved.
 * This component and the accompanying materials are made available
 * under the terms of the License "Eclipse Public License v1.0"
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

package com.nokia.tools.variant.confml.internal.core.project;

import java.util.List;

import com.nokia.tools.variant.common.core.utils.ArrayUtils;
import com.nokia.tools.variant.confml.core.model.application.EAppMetadata;
import com.nokia.tools.vct.confml.model.confml1.EMetaContainer;
import com.nokia.tools.vct.confml.model.confml1.EMetaContent;
import com.nokia.tools.vct.confml.model.confml1.EMetaElement;

/**
 * Some variant contributor utilities.
 * 
 */
public class ContributorUtils {

	public static void adaptMetadata(EMetaContainer source, EAppMetadata target) {
		for (EMetaElement meta : source.getMetas()) {
			if (!meta.getCustomer().isEmpty()) {
				target.setCustomer(getLastValue(meta.getCustomer()));
			}
			if (!meta.getDate().isEmpty()) {
				target.setDate(getLastValue(meta.getDate()));
			}
			if (!meta.getEditor().isEmpty()) {
				target.setEditor(getLastValue(meta.getEditor()));
			}
			if (!meta.getId().isEmpty()) {
				target.setMetaId(getLastValue(meta.getId()));
			}
			if (!meta.getOwner().isEmpty()) {
				target.setOwner(getLastValue(meta.getOwner()));
			}
			if (!meta.getPlatform().isEmpty()) {
				target.setPlatform(getLastValue(meta.getPlatform()));
			}
			if (!meta.getProduct().isEmpty()) {
				target.setProduct(getLastValue(meta.getProduct()));
			}
			if (!meta.getRelease().isEmpty()) {
				target.setRelease(getLastValue(meta.getRelease()));
			}
			if (!meta.getStatus().isEmpty()) {
				target.setStatus(getLastValue(meta.getStatus()));
			}
			if (!meta.getVersion().isEmpty()) {
				target.setVersion(getLastValue(meta.getVersion()));
			}
		}
	}

	public static void adaptMetadata(
			com.nokia.tools.vct.confml.model.confml2.EMetaContainer source,
			EAppMetadata target) {
		for (com.nokia.tools.vct.confml.model.confml2.EMetaElement meta : source
				.getMetas()) {
			if (!meta.getCustomer().isEmpty()) {
				target.setCustomer(getLastValue2(meta.getCustomer()));
			}
			if (!meta.getDate().isEmpty()) {
				target.setDate(getLastValue2(meta.getDate()));
			}
			if (!meta.getEditor().isEmpty()) {
				target.setEditor(getLastValue2(meta.getEditor()));
			}
			if (!meta.getId().isEmpty()) {
				target.setMetaId(getLastValue2(meta.getId()));
			}
			if (!meta.getOrigin().isEmpty()) {
				target.setOrigin(getLastValue2(meta.getOrigin()));
			}
			if (!meta.getOwner().isEmpty()) {
				target.setOwner(getLastValue2(meta.getOwner()));
			}
			if (!meta.getPlatform().isEmpty()) {
				target.setPlatform(getLastValue2(meta.getPlatform()));
			}
			if (!meta.getProduct().isEmpty()) {
				target.setProduct(getLastValue2(meta.getProduct()));
			}
			if (!meta.getRelease().isEmpty()) {
				target.setRelease(getLastValue2(meta.getRelease()));
			}
			if (!meta.getStatus().isEmpty()) {
				target.setStatus(getLastValue2(meta.getStatus()));
			}
			if (!meta.getTarget().isEmpty()) {
				target.setTarget(getLastValue2(meta.getTarget()));
			}
			if (!meta.getVersion().isEmpty()) {
				target.setVersion(getLastValue2(meta.getVersion()));
			}
		}
	}

	private static String getLastValue(List<EMetaContent> content) {
		return ArrayUtils.getLast(content).getValue();
	}

	private static String getLastValue2(
			List<com.nokia.tools.vct.confml.model.confml2.EMetaContent> content) {
		return ArrayUtils.getLast(content).getValue();
	}

}
