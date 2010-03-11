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

import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ScrollPane;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editpolicies.ContainerEditPolicy;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.requests.CreateRequest;

import com.nokia.tools.vct.appshell.appshellmodel.EAppshellDocument;

public class EAppshellDocumentEditPart extends AbstractGraphicalEditPart {

	public EAppshellDocumentEditPart(EAppshellDocument document) {
		setModel(document);
	}

	@Override
	protected IFigure createFigure() {
		ScrollPane figure = new ScrollPane();
		figure.setBackgroundColor(ColorConstants.green);
		return figure;
	}

	@Override
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.CONTAINER_ROLE, new ContainerEditPolicy() {
			@Override
			protected Command getCreateCommand(CreateRequest request) {
				return UnexecutableCommand.INSTANCE;
			}
		});
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new LayoutEditPolicy() {
			@Override
			protected EditPolicy createChildEditPolicy(EditPart child) {
				return null;
			}
			@Override
			protected Command getCreateCommand(CreateRequest request) {
				return UnexecutableCommand.INSTANCE;
			}
			@Override
			protected Command getMoveChildrenCommand(Request request) {
				return UnexecutableCommand.INSTANCE;
			}
		});
	}

	@Override
	public EAppshellDocument getModel() {
		return (EAppshellDocument) super.getModel();
	}

	@Override
	protected List<?> getModelChildren() {
		return Collections.singletonList(getModel().getData().getFolder());
	}

}
