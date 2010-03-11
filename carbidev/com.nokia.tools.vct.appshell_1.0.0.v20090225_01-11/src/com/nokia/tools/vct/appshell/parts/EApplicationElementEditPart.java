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

import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.swt.SWT;

import com.nokia.tools.vct.appshell.appshellmodel.EApplicationElement;
import com.nokia.tools.vct.appshell.appshellmodel.EAppshellModelPackage;
import com.nokia.tools.vct.appshell.parts.misc.ApplicationIdMap;
import com.nokia.tools.vct.appshell.parts.misc.EApplicationElementTooltipFigure;
import com.nokia.tools.vct.appshell.parts.misc.EObjectEditPart;
import com.nokia.tools.vct.appshell.parts.misc.ObjectFigure;
import com.nokia.tools.vct.appshell.parts.misc.TooltipFigure;

public class EApplicationElementEditPart extends EObjectEditPart {

	private final ApplicationIdMap applicationIdMap;
	
	protected TooltipFigure tooltipFigure;
	
	public EApplicationElementEditPart(EApplicationElement element, ApplicationIdMap applicationIdMap) {
		super(element);
		setType("Application");
		this.applicationIdMap = applicationIdMap;
	}

	@Override
	public EApplicationElement getModel() {
		return (EApplicationElement) super.getModel();
	}

	@Override
	public void activate() {
		super.activate();
		updateName();
	}
	
	@Override
	protected void notifyChanged(Notification msg) {
		int featureId = msg.getFeatureID(EApplicationElement.class);
		switch (featureId) {
		case EAppshellModelPackage.EAPPLICATION_ELEMENT__UID:
			updateName();
			break;
		}
		tooltipFigure.update(getModel());
	}
	
	@Override
	protected IFigure createNodeShape() {
		primaryShape = new ApplicationNodeFigure();
		tooltipFigure = new EApplicationElementTooltipFigure();
		tooltipFigure.update(getModel());
		primaryShape.setToolTip(tooltipFigure);
		
		return primaryShape;
	}
	
	protected void updateName() {
		if (getModel() == null) {
			super.setName("");
			return;
		}
		
		String uid = getModel().getUid();
		super.setName(uid);
		
		tooltipFigure.update(getModel());
		getFigure().invalidate();
		
		if (uid == null) {
			((ApplicationNodeFigure) primaryShape).setApplicationNameFigure("Unspecified");
		} else {
			String name = applicationIdMap.getApplicationName(uid);
			if (name == null) {
				((ApplicationNodeFigure) primaryShape).setApplicationNameFigure("Unspecified");
			} else {
				((ApplicationNodeFigure) primaryShape).setApplicationNameFigure(name);
			}
		}
	}
	
	static class ApplicationNodeFigure extends ObjectFigure {
		protected Label applicationNameFigure;
		
		@Override
		protected void createContents() {
			super.createContents();
			
			typeFigure.setText("Application");
			
			applicationNameFigure = new Label();
			applicationNameFigure.setLabelAlignment(PositionConstants.CENTER);
			applicationNameFigure.setText("");
			
			this.add(applicationNameFigure);
			GridData gd = new GridData(SWT.FILL, SWT.TOP, true, false);
			this.getLayoutManager().setConstraint(applicationNameFigure, gd);

		}
		
		public void setApplicationNameFigure(String name) {
			this.applicationNameFigure.setText(name);
		}
	}
}
