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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.ScrollBar;
import org.eclipse.draw2d.ScrollPane;
import org.eclipse.draw2d.ScrollPaneLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.editpolicies.ContainerEditPolicy;
import org.eclipse.gef.editpolicies.OrderedLayoutEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.requests.GroupRequest;

import com.nokia.tools.vct.appshell.appshellmodel.EApplicationElement;
import com.nokia.tools.vct.appshell.appshellmodel.EAppshellModelPackage;
import com.nokia.tools.vct.appshell.appshellmodel.EFolderElement;
import com.nokia.tools.vct.appshell.parts.misc.EFolderElementTooltipFigure;
import com.nokia.tools.vct.appshell.parts.misc.EObjectEditPart;

public class EFolderElementEditPart extends EObjectEditPart {

	private EFolderElementTooltipFigure tooltipFigure;

	public EFolderElementEditPart(EFolderElement element) {
		super(element);
		setType("Folder");
	}

	@Override
	public EFolderElement getModel() {
		return (EFolderElement) super.getModel();
	}

	@Override
	protected IFigure createFigure() {
		if (isContainer()) {
			ScrollPane scrollpane = new ScrollPane() {
				@Override
				public Dimension getPreferredSize(int wHint, int hHint) {
					Dimension d = getMaximumSize().intersect(
							super.getPreferredSize(wHint, hHint));
					return d;
				}

				@Override
				public void setSize(int w, int h) {
					
					super.setSize(w, h);
				}
			};
			scrollpane.getViewport().setContentsTracksWidth(true);
			scrollpane.getViewport().setContentsTracksHeight(true);
			scrollpane.setMinimumSize(new Dimension(80, 0));
			scrollpane.setMaximumSize(new Dimension(80, Integer.MAX_VALUE));
			// scrollpane.setHorizontalScrollBarVisibility(ScrollPane.NEVER);
			// scrollpane.setVerticalScrollBarVisibility(ScrollPane.ALWAYS);
			scrollpane.setVerticalScrollBar(new ScrollBar());
			scrollpane.getVerticalScrollBar().setStepIncrement(20);
			scrollpane.setLayoutManager(new ScrollPaneLayout());
			scrollpane.setContents(new Figure() {
				@Override
				public Dimension getPreferredSize(int hint, int hint2) {
					Dimension tmp = new Dimension(hint, hint2);
					tmp.intersect(getMaximumSize());
					Dimension d = super.getPreferredSize(tmp.width, tmp.height);
					return d;
				}

				@Override
				public void setSize(int w, int h) {
					
					super.setSize(w, h);
				}

				@Override
				public void setBounds(Rectangle rect) {
					
					super.setBounds(rect);
				}
			});
			// scrollpane.getContents().setOpaque(true);
			scrollpane.getContents().setLayoutManager(new GridLayout(3, true));
			// scrollpane.getContents().setMaximumSize(new Dimension(80*4,
			// Integer.MAX_VALUE));
			// scrollpane.getContents().setSize(new Dimension(80*4, 0));
			scrollpane.getContents().setBorder(new LineBorder(1));
			return scrollpane;
		} else {
			return super.createFigure();
		}
	}

	@Override
	protected IFigure createNodeShape() {
		super.createNodeShape();
		tooltipFigure = new EFolderElementTooltipFigure();
		tooltipFigure.update(getModel());
		primaryShape.setToolTip(tooltipFigure);
		return primaryShape;
	}
	
	@Override
	public IFigure getContentPane() {
		IFigure figure = super.getContentPane();
		if (figure instanceof ScrollPane) {
			return ((ScrollPane) figure).getContents();
		}
		return figure;
	}

	@Override
	protected void createEditPolicies() {
		if (isContainer()) {
			installEditPolicy(EditPolicy.CONTAINER_ROLE,
					new ContainerEditPolicy() {
						@Override
						protected Command getCreateCommand(CreateRequest request) {
							return UnexecutableCommand.INSTANCE;
						}
					});
			installEditPolicy(EditPolicy.LAYOUT_ROLE,
					new OrderedLayoutEditPolicy() {

						@Override
						protected Command createAddCommand(EditPart child,
								EditPart after) {
							return UnexecutableCommand.INSTANCE;
						}

						@Override
						protected Command createMoveChildCommand(
								EditPart child, EditPart after) {
							return UnexecutableCommand.INSTANCE;
						}

						@Override
						protected EditPart getInsertionReference(Request request) {
							return null;
						}

						@Override
						protected Command getCreateCommand(CreateRequest request) {
							return UnexecutableCommand.INSTANCE;
						}

					});
			installEditPolicy(EditPolicy.COMPONENT_ROLE,
					new ComponentEditPolicy() {
				@Override
				protected Command createDeleteCommand(
						GroupRequest deleteRequest) {
					return UnexecutableCommand.INSTANCE;
				}
					});
//			installEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE,
//					new NonResizableEditPolicy());
		} else {
			super.createEditPolicies();
		}
	}

	protected boolean isContainer() {
		return getParent() instanceof RootEditPart
				|| getParent() instanceof EAppshellDocumentEditPart;
	}

	@Override
	protected List<Object> getModelChildren() {
		if (isContainer()) {
			List<Object> result = new ArrayList<Object>();
			for (FeatureMap.Entry entry : getModel().getContents()) {
				result.add(entry.getValue());
			}
			return result;
		} else {
			return Collections.emptyList();
		}
	}

	@Override
	public void setModel(Object model) {
		super.setModel(model);
		setName(getModel().getApplicationGroupName());
		
	}

	@Override
	protected void notifyChanged(Notification msg) {
		int featureId = msg.getFeatureID(EApplicationElement.class);
		if (isContainer()) {
			switch (featureId) {
			case EAppshellModelPackage.EFOLDER_ELEMENT__CONTENTS:
				refreshChildren();
				break;
			}
		} else {
			switch (featureId) {
			case EAppshellModelPackage.EFOLDER_ELEMENT__APPLICATION_GROUP_NAME:
				setName(getModel().getApplicationGroupName());
				break;
			}
			tooltipFigure.update(getModel());
		}
	}
}
