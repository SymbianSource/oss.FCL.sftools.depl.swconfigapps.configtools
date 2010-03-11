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
 * Description: This file is part of com.nokia.tools.variant.editor component.
 */

package com.nokia.tools.variant.editor.model.convertor;

import org.eclipse.emf.common.util.EList;

import com.nokia.tools.variant.editor.cpfInfo.CPFInformation;
import com.nokia.tools.variant.editor.editors.ViewEditorModel;
import com.nokia.tools.variant.editor.model.summaryModel.SUMMARYTYPE;
import com.nokia.tools.variant.editor.model.summaryModel.UIElement;
import com.nokia.tools.variant.editor.model.summaryModel.UISummaryGroup;
import com.nokia.tools.variant.editor.model.summaryModel.UISummaryModel;

public class UIMetadata2CPFMetadataModelConverter {
	public static void copyUIMetadata2CpfMetadata(UISummaryModel model,
			ViewEditorModel viewEditorModel) {
		if (model == null)
			return;

		EList<UISummaryGroup> uiGroups = model.getUiGroups();
		if (uiGroups.size() <= 0)
			return;

		CPFInformation cpfMetadata = viewEditorModel.getCpfMetadata();

		UISummaryGroup summaryGroup = uiGroups.get(0);

		for (UIElement element : summaryGroup.getUiElements()) {

			switch (element.getType().getValue()) {
			// case SUMMARYTYPE.NAME_VALUE:
			// cpfMetadata.setName(element.getValue());
			// break;
			case SUMMARYTYPE.PRODUCT_VALUE:
				cpfMetadata.setProduct(element.getValue());
				break;
			case SUMMARYTYPE.PLATFORM_VALUE:
				cpfMetadata.setPlatform(element.getValue());
				break;
			case SUMMARYTYPE.RELEASE_VALUE:
				cpfMetadata.setRelease(element.getValue());
				break;
			case SUMMARYTYPE.DATE_VALUE:
				cpfMetadata.setDate(element.getValue());
				break;
			case SUMMARYTYPE.VERSION_VALUE:
				cpfMetadata.setVersion(element.getValue());
				break;
			case SUMMARYTYPE.CUSTOMER_VALUE:
				cpfMetadata.setCustomer(element.getValue());
				break;
			case SUMMARYTYPE.OWNER_VALUE:
				cpfMetadata.setOwner(element.getValue());
				break;
			case SUMMARYTYPE.AUTHOR_VALUE:
				cpfMetadata.setAuthor(element.getValue());
				break;
			case SUMMARYTYPE.DESCRIPTION_VALUE:
				cpfMetadata.setDescription(element.getValue());
				break;
			case SUMMARYTYPE.STATUS_VALUE:
				cpfMetadata.setStatus(element.getValue());
				break;
			case SUMMARYTYPE.ORIGIN_VALUE:
				cpfMetadata.setOrigin(element.getValue());
				break;
			case SUMMARYTYPE.TARGET_VALUE:
				cpfMetadata.setTarget(element.getValue());
				break;
			case SUMMARYTYPE.AVR_VALUE:
				viewEditorModel.setAvrProperty(element.getNote());
				break;
			}

			element.setLastSavedValue(element.getValue());
		}
	}
}
