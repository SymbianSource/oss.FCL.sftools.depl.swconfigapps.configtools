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
 * Description: This file is part of com.nokia.tools.vct.appshell component.
 */

package com.nokia.tools.vct.appshell.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.notify.Notification;

import com.nokia.tools.vct.appshell.appshellmodel.EAppshellModelPackage;
import com.nokia.tools.vct.appshell.appshellmodel.EURLElement;
import com.nokia.tools.vct.appshell.parts.misc.EObjectEditPart;
import com.nokia.tools.vct.appshell.parts.misc.EURLElementTooltipFigure;

public class EURLElementEditPart extends  EObjectEditPart  {

	private EURLElementTooltipFigure tooltipFigure;

	public EURLElementEditPart(EURLElement element) {
		super(element);
		setType("URL");
	}
	
	@Override
	public EURLElement getModel() {
		return (EURLElement)super.getModel();
	}
	
	@Override
	public void setModel(Object model) {
		super.setModel(model);
		setName(getModel().getUrl());
	}
	
	@Override
	protected IFigure createFigure() {
		return super.createFigure();
	}

	@Override
	protected IFigure createNodeShape() {
		super.createNodeShape();
		tooltipFigure = new EURLElementTooltipFigure();
		tooltipFigure.update(getModel());
		primaryShape.setToolTip(tooltipFigure);

		return primaryShape;
	}
	
	@Override
	protected void notifyChanged(Notification msg) {
		int featureId = msg.getFeatureID(EURLElement.class);
		switch (featureId) {
		case EAppshellModelPackage.EURL_ELEMENT__URL:
			setName(getModel().getUrl());
			break;
		}
		tooltipFigure.update(getModel());
	}
}
