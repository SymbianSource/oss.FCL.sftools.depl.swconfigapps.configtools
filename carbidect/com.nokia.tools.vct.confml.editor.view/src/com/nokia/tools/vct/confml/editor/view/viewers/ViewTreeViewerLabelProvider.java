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
 * Description: This file is part of com.nokia.tools.vct.confml.editor.view component.
 */

package com.nokia.tools.vct.confml.editor.view.viewers;

import java.util.Formatter;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListener;
import org.eclipse.emf.transaction.ResourceSetListenerImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import com.nokia.tools.variant.confml.ui.ConfmlUI;
import com.nokia.tools.variant.confml.ui.IConfmlImages;
import com.nokia.tools.vct.common.ui.utils.SWTUtil;
import com.nokia.tools.vct.confml.editor.view.vemodel.EFeature;
import com.nokia.tools.vct.confml.editor.view.vemodel.EGroup;
import com.nokia.tools.vct.confml.editor.view.vemodel.ERefOption;
import com.nokia.tools.vct.confml.editor.view.vemodel.ERefProperty;
import com.nokia.tools.vct.confml.editor.view.vemodel.ERefTarget;
import com.nokia.tools.vct.confml.editor.view.vemodel.ESetting;
import com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef;
import com.nokia.tools.vct.confml.editor.view.vemodel.EView;
import com.nokia.tools.vct.confml.editor.view.vemodel.EViewsEditorDocument;
import com.nokia.tools.vct.confml.editor.view.vemodel.impl.ESettingEntryImpl;
import com.nokia.tools.vct.confml.editor.view.vemodel.impl.EViewEntryImpl;
import com.nokia.tools.vct.confml.editor.view.vemodel.util.ConverterUtils;

public class ViewTreeViewerLabelProvider extends LabelProvider implements
		IColorProvider {

	protected StructuredViewer viewer;

	protected EViewsEditorDocument document;
	protected TransactionalEditingDomain validationModelDomain;
	protected ResourceSetListener resourceSetListener = new ResourceSetListenerImpl() {
		@Override
		public void resourceSetChanged(ResourceSetChangeEvent event) {
			if (viewer.getControl().isDisposed()) {
				return;
			}
			super.resourceSetChanged(event);

			SWTUtil.getStandardDisplay().asyncExec(new Runnable() {
				public void run() {
					refreshValidationModel();
				};
			});
		}

		@Override
		public boolean isPostcommitOnly() {
			return true;
		}
	};

	public void setViewer(StructuredViewer viewer) {
		this.viewer = viewer;
	}

	public ViewTreeViewerLabelProvider() {

	}

	public void bindModel(final EViewsEditorDocument document) {
		if (this.document != null) {
			validationModelDomain
					.removeResourceSetListener(resourceSetListener);
		}
		validationModelDomain = null;
		this.document = null;

		this.document = document;
		if (this.document != null) {
			this.validationModelDomain = TransactionUtil
					.getEditingDomain(this.document);
			this.validationModelDomain
					.addResourceSetListener(resourceSetListener);
		}

		refreshValidationModel();
	}

	protected void refreshValidationModel() {
		if (viewer != null) {
			viewer.refresh(true);
		}
	}

	private static final String FMT = "%1$s (%2$s)";

	@Override
	public String getText(Object element) {
		String text;

		if (element instanceof EView) {
			String id = ConverterUtils.getViewId((EView) element);
			if (id!=null)
				return ((EView) element).getName() + " (" + id + ")";
			else
				return ((EView) element).getName();
		} 
		else if (element instanceof EGroup) {
			return ((EGroup) element).getName();
		}
		else if (element instanceof EViewEntryImpl)
		{
			EViewEntryImpl ve = (EViewEntryImpl)element;
			EView v = ve.getValue();
			String id = ConverterUtils.getViewId(v);
			return v.getName() + " (" + id + ")";
		}

		if (element instanceof ESettingRef) {
			ESettingRef ref = (ESettingRef) element;
			text = ref.getFeatureId() + "/" + ref.getSettingId();

			ERefTarget target = ref.getTarget();
			if (target != null) {
				if (target instanceof EFeature) {
					EFeature feature = (EFeature) target;
					return new Formatter().format(FMT, feature.getName(), text)
							.toString();
				}
				if (target instanceof ESetting) {
					ESetting setting = (ESetting) target;
					return new Formatter().format(FMT, setting.getName(), text)
							.toString();
				}

			}
			else 
			{
				return "Unresolved Reference (" + text + ")";
			}
		}
		if (element instanceof ESettingEntryImpl) {
			ESettingEntryImpl eSettingEntryImpl = (ESettingEntryImpl) element;
			ESetting setting = eSettingEntryImpl.getValue();
			return setting.getName();
		}
		if (element instanceof ERefOption) {
			return ((ERefOption)element).getName();
		}
		if (element instanceof ERefProperty) {
			return ((ERefProperty)element).getName();
		}
		
		return "undefined";
	}

	@Override
	public Image getImage(Object element) {
		if (element instanceof EView || element instanceof EViewEntryImpl) {
			return ConfmlUI.getImage(IConfmlImages.EDI_VIEW);
		} else if (element instanceof EGroup) {
			return ConfmlUI.getImage(IConfmlImages.EDI_GROUP);
		} else if (element instanceof ESettingRef) {
			Image image = null;
			ESettingRef ref = (ESettingRef) element;
			if (ref.getSettingId().equals("*")) {
				image = ConfmlUI.getImage(IConfmlImages.EDI_FEATURE);
			} else {
				image = ConfmlUI.getImage(IConfmlImages.EDI_SETTING);
			}
			return image;
		} else if (element instanceof ERefOption) {
			return null;
		} else if (element instanceof ERefProperty) {
			return null;
		} else if (element instanceof ESettingEntryImpl) {
			return ConfmlUI.getImage(IConfmlImages.EDI_SETTING);
		} else {
			return PlatformUI.getWorkbench().getSharedImages().getImage(
					ISharedImages.IMG_OBJ_FOLDER);
		}
	}

	@Override
	public void dispose() {
		if (this.document != null) {
			validationModelDomain
					.removeResourceSetListener(resourceSetListener);
		}
		validationModelDomain = null;
		document = null;
		super.dispose();
	}

	public Color getBackground(Object element) {
		
		return null;
	}

	private boolean isBlack(EObject entry)
	{
		if (entry instanceof EView)
		{
			if (entry.eContainer() instanceof EView)
				return false;
			else 
				return true;
		}
		else
		{
			return isBlack(entry.eContainer());
		}
	}
	
	public Color getForeground(Object element) {
		Color color = new Color(Display.getDefault(), 175, 175, 175);
		if (element instanceof ESettingEntryImpl) {
			return color;
		} 
		else 
		{
			if (isBlack((EObject)element))
				return null;
			else
				return color;
				
		}
	}

}
