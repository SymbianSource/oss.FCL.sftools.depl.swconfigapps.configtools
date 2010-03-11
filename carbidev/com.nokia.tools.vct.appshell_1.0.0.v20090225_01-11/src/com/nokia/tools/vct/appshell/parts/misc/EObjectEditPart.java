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

package com.nokia.tools.vct.appshell.parts.misc;

import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IWrapperItemProvider;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;

import com.nokia.tools.vct.appshell.AppshellPlugin;

public class EObjectEditPart extends AbstractGraphicalEditPart {

	protected IFigure contentPane;
	protected IFigure primaryShape;
	protected String type = "<...>";
	protected String name = "<...>";

	final class EObjectAdapter extends AdapterImpl {
		@Override
		public void notifyChanged(Notification msg) {
			EObjectEditPart.this.notifyChanged(msg);
		}
	}

	protected final EObjectAdapter adapter;

	public EObjectEditPart(EObject target) {
		this.adapter = new EObjectAdapter();
		setModel(target);
	}

	protected void notifyChanged(Notification msg) {
	}

	@Override
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new ComponentEditPolicy() {
		});
		installEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE,
				new NonResizableEditPolicy() {
					@Override
					protected void showSelection() {
						
						Color color = AppshellPlugin.getColorRegistry().get("navigatorSelection");
						getFigure().setBackgroundColor(color);
						getFigure().setOpaque(true);
						super.showSelection();
					}

					@Override
					protected void hideSelection() {
						super.hideSelection();
						getFigure().setBackgroundColor(null);
						getFigure().setOpaque(false);
					}
				});
	}

	@Override
	protected IFigure createFigure() {
		IFigure figure = createNodePlate();
		figure.setLayoutManager(new GridLayout(1, true));
		IFigure shape = createNodeShape();
		figure.add(shape);
		GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true);
		figure.getLayoutManager().setConstraint(shape, gd);
		contentPane = setupContentPane(shape);
		return figure;
	}

	protected IFigure setupContentPane(IFigure nodeShape) {
		if (nodeShape.getLayoutManager() == null) {
			ToolbarLayout layout = new ToolbarLayout();
			layout.setSpacing(5);
			nodeShape.setLayoutManager(layout);
		}
		return nodeShape; // use nodeShape itself as contentPane
	}

	protected IFigure createNodeShape() {
		ObjectFigure figure = new ObjectFigure();
		figure.getTypeFigure().setText(type);
		figure.getNameFigure().setText(name);
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public IFigure getPrimaryShape() {
		return primaryShape;
	}

	static public IFigureFactoryItemProvider getFigureFactoryItemProviderFor(
			Object object) {
		if (object instanceof EObject) {
			EObject eObject = (EObject) object;
			EditingDomain editingDomain = AdapterFactoryEditingDomain
					.getEditingDomainFor(eObject);
			if (editingDomain instanceof AdapterFactoryEditingDomain) {
				object = ((AdapterFactoryEditingDomain) editingDomain)
						.getAdapterFactory().adapt(eObject,
								IFigureFactoryItemProvider.class);
			}
		}

		return object instanceof IFigureFactoryItemProvider ? (IFigureFactoryItemProvider) object
				: object instanceof IWrapperItemProvider ? getFigureFactoryItemProviderFor(((IWrapperItemProvider) object)
						.getValue())
						: object instanceof FeatureMap.Entry ? getFigureFactoryItemProviderFor(((FeatureMap.Entry) object)
								.getValue())
								: null;
	}

	@Override
	public EObject getModel() {
		return (EObject) super.getModel();
	}

	protected IFigure createNodePlate() {
		IFigure figure = new DefaultSizeFigure(80, 80);
		figure.setBorder(new LineBorder(1));
		return figure;
	}

	@Override
	public void activate() {
		if (isActive()) {
			return;
		}
		getModel().eAdapters().add(adapter);
		super.activate();
	}

	@Override
	public void deactivate() {
		if (!isActive()) {
			return;
		}
		getModel().eAdapters().remove(adapter);

		super.deactivate();
	}

	public void setType(String type) {
		this.type = type;
		if (primaryShape instanceof ObjectFigure) {
			((ObjectFigure) primaryShape).getTypeFigure().setText(type);
		}
	}

	public void setName(String name) {
		this.name = name;
		if (primaryShape instanceof ObjectFigure) {
			((ObjectFigure) primaryShape).getNameFigure().setText(name);
			getFigure().invalidateTree();
		}
	}
}
