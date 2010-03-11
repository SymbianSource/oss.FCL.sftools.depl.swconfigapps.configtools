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
 * Description: This file is part of com.nokia.tools.variant.navigator component.
 */

package com.nokia.tools.variant.navigator.views;

import java.util.Collections;
import java.util.List;

import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.IFontProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Widget;

import com.nokia.tools.variant.common.ui.utils.PixelConverter;
import com.nokia.tools.variant.common.ui.utils.SWTUtil;
import com.nokia.tools.variant.navigator.provider.INavigatorLabelProvider;

public class NavigatorViewer extends StructuredViewer {

	private ScrolledComposite scrolled;
	private NavigatorComposite control;
	private boolean staticFirstButton;
	

	public NavigatorViewer(Composite parent) {
		scrolled = new ScrolledComposite(parent, SWT.V_SCROLL);
		scrolled.setExpandHorizontal(true);
		scrolled.setExpandVertical(true);
		control = new NavigatorComposite(scrolled, SWT.NONE, this);
		scrolled.setContent(control);
		scrolled.addControlListener(new ControlAdapter() {
			@Override
			public void controlResized(ControlEvent e) {
				Point size;
				Rectangle ca = ((ScrolledComposite)control.getParent()).getClientArea();
				size = control.computeSize(ca.width, SWT.DEFAULT);
				// size.y = Math.max(size.y, getSize().y);
				((ScrolledComposite)control.getParent()).setMinSize(size);
				control.setSize(size);
				control.layout(true, true);
				control.redraw();
			}
		});

		scrolled.getVerticalBar().setIncrement(new PixelConverter(scrolled).convertHeightInCharsToPixels(1));
		
		control.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Object selected = null;
				if (e.item != null) {
					selected = e.item.getData();
				}
				ISelection sel = selected == null ? StructuredSelection.EMPTY : new StructuredSelection(selected);
				
				fireSelectionChanged(new SelectionChangedEvent(NavigatorViewer.this, sel));
			}
		});
	}

	@Override
	protected Widget doFindInputItem(Object element) {
		Object root = getRoot();
		if (root == null) {
			return null;
		}

		if (equals(root, element)) {
			return control;
		}
		return null;
	}

	@Override
	protected Widget doFindItem(Object element) {
		if (equals(element, getRoot())) {
			return control;
		}
		for (NavigatorButton button : control.getButtons()) {
			if (equals(element, button.getData())) {
				return button;
			}
			for (NavigatorLabel label : button.getLabels()) {
				if (equals(element, label.getData())) {
					return label;
				}
			}
		}

		return null;
	}

	@Override
	protected void doUpdateItem(Widget item, Object element, boolean fullMap) {
		if (item instanceof NavigatorButton) {
			item.setData(element);
			updateButton((NavigatorButton)item);
		} else if (item instanceof NavigatorLabel) {
			item.setData(element);
			updateLabel((NavigatorLabel)item);
		}
	}

	@Override
	protected List<?> getSelectionFromWidget() {
		Widget widget = control.getSelectedWidget();
		Object selected = widget == null || widget.isDisposed() ? null : widget.getData();
		return selected == null ? Collections.emptyList() : Collections
				.singletonList(selected);
	}

	@Override
	protected void internalRefresh(Object element) {
		IBaseLabelProvider baseLabelProvider = getLabelProvider();
		IContentProvider contentProvider = getContentProvider();

		Widget widget = doFindItem(element);
		if (widget == null) {
			return;
		}
		if(control.isDisposed()){
			return;
		}

		control.setRedraw(false);
		control.setLayoutDeferred(true);
		try {
		
		if (widget instanceof NavigatorComposite) {
			// if (baseLabelProvider instanceof ILabelProvider) {
			// ILabelProvider labelProvider = (ILabelProvider)baseLabelProvider;
			// }
			if (baseLabelProvider instanceof INavigatorLabelProvider) {
				INavigatorLabelProvider provider = (INavigatorLabelProvider) baseLabelProvider;
				control.setToolTipText(provider.getToolTipText(element));
			}

			control.disposeButtons();
			Object[] buttonElements = null;
			ITreeContentProvider tcp;

			if (!(contentProvider instanceof ITreeContentProvider)) {
				return;
			}

			tcp = (ITreeContentProvider) contentProvider;
			buttonElements = tcp.getElements(getRoot());
			buttonElements = filter(buttonElements);

			int i=0;
			for (Object buttonElement : buttonElements) {
				NavigatorButton button = control.createButton();
				if(staticFirstButton&&i==0)
				  button.setNonExpanded(true);
				button.setData(buttonElement);
				i++;
				try {
				refreshButton(button);
				updateButton(button);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		} else if (widget instanceof NavigatorButton) {
			refreshButton((NavigatorButton) widget);
		} else if (widget instanceof NavigatorLabel) {
			refreshLabel((NavigatorLabel) widget);
		}
		
		
		} finally {
			control.setLayoutDeferred(false);
			Rectangle area = scrolled.getClientArea();
			Point size = control.computeSize(area.width, SWT.DEFAULT, true);
			// size.y = Math.max(size.y, area.height);
			control.setSize(size);
			scrolled.setMinSize(size);
			
			
			control.setRedraw(true);
		}
	}

	protected void refreshButton(NavigatorButton button) {
		Object element = button.getData();

		IContentProvider contentProvider = getContentProvider();
		if (contentProvider instanceof ITreeContentProvider) {
			ITreeContentProvider tcp = (ITreeContentProvider) contentProvider;
			button.disposeLabels();
			Object[] labelElements = tcp.getChildren(element);
			labelElements = filter(labelElements);
			for (Object labelElement : labelElements) {
				NavigatorLabel label = button.createLabel();
				label.setData(labelElement);
				refreshLabel(label);
				updateLabel(label);
			}
		} else {
			button.disposeLabels();
		}
	}

	private void updateButton(NavigatorButton button) {
		Object element = button.getData();
		IBaseLabelProvider baseLabelProvider = getLabelProvider();
		if (baseLabelProvider instanceof ILabelProvider) {
			ILabelProvider provider = (ILabelProvider) baseLabelProvider;
			button.setButtonText(provider.getText(element));
			button.setImage(provider.getImage(element));
		} else {
			button.setButtonText(null);
			button.setImage(null);
		}
		if (baseLabelProvider instanceof INavigatorLabelProvider) {
			INavigatorLabelProvider provider = (INavigatorLabelProvider) baseLabelProvider;
			button.setToolTipText(provider.getToolTipText(element));
			button.setDescriptionText(provider.getDescription(element));
		} else {
			button.setToolTipText(null);
			button.setDescriptionText("");
		}
		if (baseLabelProvider instanceof IFontProvider) {
			IFontProvider provider = (IFontProvider) baseLabelProvider;
			button.setFont(provider.getFont(element));
		} else {
			button.setFont(null);
		}
//		if (baseLabelProvider instanceof IColorProvider) {
//			IColorProvider provider = (IColorProvider) baseLabelProvider;
//			button.setForeground(provider.getForeground(element));
//			button.setBackground(provider.getBackground(element));
//		} else {
//			button.setForeground(null);
//			button.setBackground(null);
//		}
	}

	protected void refreshLabel(NavigatorLabel label) {
		// label does not have children...
		
		// Object labelElement = label.getData();
		// updateLabel(label);
	}

	private void updateLabel(NavigatorLabel label) {
		Object labelElement = label.getData();
		IBaseLabelProvider baseLabelProvider = getLabelProvider();

		if (baseLabelProvider instanceof ILabelProvider) {
			ILabelProvider provider = (ILabelProvider) baseLabelProvider;
			String text = provider.getText(labelElement);
			label.setText(text);
			label.setImage(provider.getImage(labelElement));
			
		} else {
			label.setText(null);
			label.setImage(null);
		}
		if (baseLabelProvider instanceof INavigatorLabelProvider) {
			INavigatorLabelProvider provider = (INavigatorLabelProvider) baseLabelProvider;
			label.setToolTipText(provider.getToolTipText(labelElement));
			label.setDescriptionText(provider.getDescription(labelElement));
		} else {
			label.setToolTipText(null);
			label.setDescriptionText(null);
		}
		if (baseLabelProvider instanceof IFontProvider) {
			IFontProvider provider = (IFontProvider) baseLabelProvider;
			label.setFont(provider.getFont(labelElement));
		} else {
			label.setFont(null);
		}

		label.getButton().getNavigator().redraw();
	}

	@Override
	protected void inputChanged(Object input, Object oldInput) {
		refresh(input);
	}

	@Override
	protected void labelProviderChanged() {
		
		super.labelProviderChanged();
	}

	@Override
	public void reveal(Object element) {
		

	}

	@SuppressWarnings("unchecked")
	@Override
	protected void setSelectionToWidget(List l, boolean reveal) {
		Widget widget;
		if (l == null || l.isEmpty()) {
			widget = null;
		} else {
			Object object = l.get(0);
			widget = doFindItem(object);
		}
		control.setSelectedWidget(widget);
		if (reveal && widget instanceof Control) {
			SWTUtil.ensureVisible((Control)widget);
		}
	}

	@Override
	public Control getControl() {
		return scrolled;
	}
	public void setStaticFirstButton(boolean isStatic){
		this.staticFirstButton=isStatic;
		
	}

}
