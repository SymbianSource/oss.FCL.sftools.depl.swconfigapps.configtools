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

package com.nokia.tools.variant.editor.properties;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

import com.nokia.tools.variant.common.ui.properties.AutoSizePropertySection;
import com.nokia.tools.variant.common.ui.properties.fields.StringFieldEditor;
import com.nokia.tools.variant.editor.actions.CopyAction;
import com.nokia.tools.variant.editor.actions.CutAction;
import com.nokia.tools.variant.editor.actions.DeleteAction;
import com.nokia.tools.variant.editor.actions.PasteAction;
import com.nokia.tools.variant.editor.model.summaryModel.SUMMARYTYPE;
import com.nokia.tools.variant.editor.model.summaryModel.UIElement;

/**
 * This class provides control from the Editor part (Summary page) for the
 * properties view. With first display of properties, the components are
 * created. The view contains input box for fill-in note of Summary element. Now
 * There is support only for AVR element
 * 
 */
public class SummaryPropertySection extends AutoSizePropertySection {

	private AdapterImpl adapter;
	private Section control;
	private StringFieldEditor notes;

	private Composite mainComposite;
	private FormToolkit toolkit;
	private Composite content;
	private GridLayout gridLayout;
	private GridData gd;
	private TabbedPropertySheetWidgetFactory factory;
	private UIElement setting;

	private CutAction cutAction;
	private CopyAction copyAction;
	private PasteAction pasteAction;
	private DeleteAction deleteAction;

	/**
	 * 
	 */
	public SummaryPropertySection() {
	}

	@Override
	protected void doRefresh() {
		if (setting != null) {
			setting.eAdapters().remove(adapter);
		}

		// dispose properties of the older selection
		if (mainComposite != null)
			mainComposite.dispose();

		mainComposite = toolkit.createComposite(content);
		mainComposite.setLayout(gridLayout);
		mainComposite.setLayoutData(gd);
		IStructuredSelection selection = (IStructuredSelection) getSelection();
		Object firstElement = null;
		if (selection != null) {
			firstElement = selection.getFirstElement();
		}
		if (firstElement instanceof UIElement) {			
			
			setting = (UIElement) firstElement;
			if (setting.getType() == SUMMARYTYPE.AVR) {
				control.setText("Additional Variation Requests");
				addNoteField();
			} else
				control.setText("");
		}
	}

	protected void resizeContent() {
		Control controll = notes.getTextControl();
		if (controll != null && !controll.isDisposed()) {
			Object o = controll.getLayoutData();
			if (o != null && o instanceof GridData) {
				GridData gd2 = (GridData) o;
				int i = 0;
				int view = 0;
				while (controll != null) {
					if (i == 9) {
						view = controll.getBounds().height;
					}
					controll = controll.getParent();
					i++;
				}
				int newValue = view - 80; // -70;
				if (gd2.heightHint != newValue) {
					gd2.heightHint = newValue;
					notes.getTextControl().setLayoutData(gd2);
				}
			}
		}
	}

	protected void createSpecificControls(Composite parent,
			TabbedPropertySheetPage tabbedPropertySheetPage) {

		factory = getWidgetFactory();
		factory.setBorderStyle(SWT.FLAT);

		toolkit = new FormToolkit(parent.getDisplay());
		control = toolkit.createSection(parent, Section.TITLE_BAR);

		content = toolkit.createComposite(control);
		control.setClient(content);
		content.setLayout(new GridLayout(2, false));

		// GridLayout and griddata for mainComposite
		gridLayout = new GridLayout(2, false);
		gridLayout.marginWidth = 0;
		gd = new GridData();
		gd.grabExcessHorizontalSpace = true;
		gd.grabExcessVerticalSpace = true;
		gd.horizontalAlignment = GridData.FILL;
		gd.verticalAlignment = GridData.FILL;
		notes = new StringFieldEditor(SWT.MULTI | SWT.WRAP | SWT.BORDER
				| SWT.V_SCROLL);
		notes.setEditable(true);
		
		createActions(notes);
	}

	private void createActions(Object control) {
		ViewPart findView = (ViewPart) PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage().findView(
						"org.eclipse.ui.views.PropertySheet");

		cutAction = new CutAction(control);
		((CutAction) cutAction).init();
		findView.getViewSite().getActionBars().setGlobalActionHandler(
				ActionFactory.CUT.getId(), cutAction);

		copyAction = new CopyAction(control);
		((CopyAction) copyAction).init();
		findView.getViewSite().getActionBars().setGlobalActionHandler(
				ActionFactory.COPY.getId(), copyAction);

		pasteAction = new PasteAction(control);
		((PasteAction) pasteAction).init();
		findView.getViewSite().getActionBars().setGlobalActionHandler(
				ActionFactory.PASTE.getId(), pasteAction);

		deleteAction = new DeleteAction(control);
		((DeleteAction) deleteAction).init();
		findView.getViewSite().getActionBars().setGlobalActionHandler(
				ActionFactory.DELETE.getId(), deleteAction);
	}

	@Override
	public void dispose() {
		if (control != null) {
			control.dispose();
		}
		super.dispose();
	}

	private static final int NUM_COLUMNS = 3;

	private void addNoteField() {
		if (setting != null) {
			String note = setting.getNote();
			if (note != null) {
				notes.setTextValue(note);
			}
		}
		notes.fillIntoGrid(mainComposite, NUM_COLUMNS, factory);		

		MenuManager mm = new MenuManager();
		mm.addMenuListener(new MenuListener(notes.getTextControl()));
		mm.setRemoveAllWhenShown(true);
		Menu menu = mm.createContextMenu(notes.getTextControl());
		notes.getTextControl().setMenu(menu);

		// final PaintListener listener2 = new PaintListener() {
		//
		// public void paintControl(PaintEvent e) {
		// // To late
		// resizeContent();
		// }
		// };
		// notes.getTextControl().addPaintListener(listener2);
		//
		// resizeContent();
		// notes.getTextControl().setLayoutData(gd);
		// notes.getLabelControl().setLayoutData(
		// new GridData(SWT.FILL, SWT.TOP, true, false, NUM_COLUMNS, 1));
		IWorkbenchPart activeEditor = getPart();
		final Text textControl = notes.getTextControl();
		final AvrTextBoxListener textBoxListener = new AvrTextBoxListener(
				textControl, setting, activeEditor);
		textControl.addListener(SWT.KeyDown, textBoxListener);
		textControl.addListener(SWT.FocusOut, textBoxListener);
		textControl.addListener(SWT.Dispose, textBoxListener);
		textControl.addDisposeListener(new DisposeListener() {

			public void widgetDisposed(DisposeEvent e) {
				textControl.removeDisposeListener(this);
				textControl.removeListener(SWT.FocusOut, textBoxListener);
				textControl.removeListener(SWT.KeyDown, textBoxListener);
				textControl.removeListener(SWT.Dispose, textBoxListener);
				// textControl.removePaintListener(listener2);
			}

		});

		adapter = new AdapterImpl() {

			public void notifyChanged(Notification notification) {
				if (notification.getEventType() == Notification.REMOVING_ADAPTER) {
					return;
				}

				String newValue = notification.getNewStringValue();
				if (newValue == null) {
					newValue = "";
				}

				String note = setting.getNote();
				if (note != null) {
					if (!note.equals(notes.getTextValue())) {
						notes.setTextValue(setting.getNote());
					}
				}

			}

		};

		setting.eAdapters().add(adapter);
		String note = setting.getNote();
		if (note == null) {
			note = "";
		}
		notes.setTextValue(note);
	}

	class MenuListener implements IMenuListener {
		private Control parent;

		public MenuListener(Control parent) {
			this.parent = parent;
		}

		public void menuAboutToShow(IMenuManager menu) {
			contextMenuAboutToShow(menu, parent);
		}

		protected void contextMenuAboutToShow(IMenuManager menu, Control parent) {
			menu.add(new Separator());
			menu.add(cutAction);
			menu.add(copyAction);
			menu.add(pasteAction);
			menu.add(deleteAction);
			menu.add(new Separator());
		}
	}	
}
