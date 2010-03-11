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
 * Description: This file is part of com.nokia.tools.variant.viewer component.
 */

package com.nokia.tools.variant.viewer.widgets;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Listener;

import com.nokia.tools.variant.viewer.utils.SettingValueUtils;
/**
 * Widget graphically represents multi-selection setting.
 */
public class MultiSelectionWidget extends BaseConfMLWidget {

	private Composite widgetComposite = null;

//	private MultiSelectionType multiSelectionType;

	private Map<String, Button> optionName2CheckBoxesMap;


	public MultiSelectionWidget(Composite parent, int style, String string,
			WidgetOptions options) {
		super(parent, style, string, options);
	}

	@Override
	protected void buildMainControl() {
		// for now only cechboxes are supported
//		multiSelectionType = MultiSelectionType.ComboBoxType;

		widgetComposite = new Composite(group, SWT.BORDER | SWT.RIGHT);
		GridData data = new GridData();
		data.widthHint = 160;
		widgetComposite.setLayoutData(data);
		widgetComposite.setLayout(new GridLayout(1, true));
		// widgetComposite.
		// listenersToRemove.

//		if (multiSelectionType.equals(MultiSelectionType.ComboBoxType)) {
			optionName2CheckBoxesMap = new HashMap<String, Button>();

//			Set<String> optionNames = options.keySet();
			for (WidgetOption name : options.values()) {
				Button checkBox = new Button(widgetComposite, SWT.CHECK);
				GridData gd = new GridData(GridData.FILL_HORIZONTAL,
						SWT.DEFAULT);
				checkBox.setLayoutData(gd);
				checkBox.setText(name.getKey());
				optionName2CheckBoxesMap.put(name.getValue(), checkBox);
			}
//		}

		// attachListeners();
	}

	@Override
	public void clearErrorMessage() {

	}

	@Override
	protected boolean buildOptions() {
		return false;
	}
	@Override
	public String getValue() {
		Collection<WidgetOption> names = options.getMap().values();
		List<String> values = new ArrayList<String>();
		
		for (WidgetOption n : names) {
			if (optionName2CheckBoxesMap.get(n.getValue()).getSelection()) {
				values.add(n.getValue());
			}
		}
		return SettingValueUtils.createMultiSelectionValue(values);
	}

	@Override
	public void setValue(String value) {
		// detach listeners to avoid blinking

		// parsed values
		List<String> multiSelectionValues = SettingValueUtils
				.parseMultiSelectionValues(value);

		// list of checked option names

		Collection<WidgetOption> names = options.getMap().values();
		for (WidgetOption n : names) {
			Button button = optionName2CheckBoxesMap.get(n.getValue());
			if (multiSelectionValues.contains(n.getValue())) {
				button.setSelection(true);
			} else {
				button.setSelection(false);
			}
		}

		// re-attach listeners to avoid blinking
	}

	public void attachListeners() {
		// super.attachListeners();

		Collection<Button> checkboxes = optionName2CheckBoxesMap.values();
		for (Button b : checkboxes) {
			// handle menu showing for button
			// Listener menuShowListener = createMenuShowListenerForControl(b);
			// b.addListener(SWT.MouseDown, menuShowListener);

			// handle widget coloring according to the focus on/off
			// PaintListener widgetRepaintListener = widgetRepaintListener();
			// b.addPaintListener(widgetRepaintListener);

		}

		// widgetRepaintListener();
		//		
		// Control control = group;
		// while (control.getParent() != null) {
		// control.addListener(SWT.MouseDown, listener);
		// control = control.getParent();
		// }

		label.addDisposeListener(new DisposeListener() {

			public void widgetDisposed(DisposeEvent e) {

			}

		});

	}

	// private PaintListener widgetRepaintListener() {
	// return new PaintListener() {
	// public void paintControl(PaintEvent e) {
	// Color color = new Color(null, 0, 0, 0);
	// if (isSelected())
	// color = (hasFocus()) ? GUIConstants.COLOR_BORDER_SELECTED_FOCUS
	// : GUIConstants.COLOR_SELECTED_BACKGROUND;
	// else
	// color = (hasFocus()) ? GUIConstants.COLOR_BORDER_DESELECTED_FOCUS
	// : GUIConstants.COLOR_DESELECTED_BACKGROUND;
	//
	// e.gc.setForeground(color);
	// e.gc.setLineStyle(SWT.LINE_DOT);
	// e.gc.drawRectangle(0, 0, group.getSize().x - 1,
	// group.getSize().y - 1);
	// }
	// };
	// }

	enum MultiSelectionType {
		CheckBoxType, ComboBoxType
	}

	// private Listener createMenuShowListenerForControl(Control c) {
	// final Listener listener = new Listener() {
	//
	// public void handleEvent(Event event) {
	// if (event.button == 3) {
	// Control c = (Control) event.widget;
	// Point absoluteLoc = c.toDisplay(event.x, event.y);
	// while (c != null && c.getMenu() == null) {
	// c = c.getParent();
	// }
	//					
	// if (c != null) {
	// c.getMenu().setLocation(absoluteLoc);
	// c.getMenu().setVisible(true);
	// }
	// }
	//
	// }
	//
	// };
	// return listener;
	// }

	@Override
	public void addListener(Listener listener) {
		super.addListener(listener);

		Collection<Button> checkboxes = optionName2CheckBoxesMap.values();

		for (final Button b : checkboxes) {
			b.addListener(SWT.MouseDown, listener);
			b.addListener(SWT.Selection, listener);
		}
	}

	@Override
	public void dispose() {
		Collection<Button> values = optionName2CheckBoxesMap.values();
		for (Button b : values) {
			if (!b.isDisposed()) {
				Listener[] listeners = b.getListeners(SWT.MouseDown);
				for (int i = 0; i < listeners.length; i++) {
					b.removeListener(SWT.MouseDown, listeners[i]);
				}
				listeners = b.getListeners(SWT.Selection);
				for (int i = 0; i < listeners.length; i++) {
					b.removeListener(SWT.Selection, listeners[i]);
				}
			}
		}
//		multiSelectionType = null;
		super.dispose();
	}

//	public void select() {
//		if (!isSelected()) {
//			if (!group.isDisposed()) {
//				Composite parent = group.getParent();
//				List<Composite> rowComposites = getRowComposites();
//				if (rowComposites.size() > 0) {
//					Composite composite = rowComposites.get(0);
//					Control[] children = getParent().getChildren();
//					if (!composite.isVisible()) {
//						if (!(children.length > 1
//								&& children[0] instanceof Canvas && children[1] == this)) {
//							while (!(parent instanceof ScrolledComposite)
//									&& parent != null) {
//								if (parent instanceof SequenceWidget) {
//
//									SequenceWidget parent2 = (SequenceWidget) parent;
//
//									parent2.setCollapsed(false);
//									Composite parent3 = parent2.getParent();
//									parent3.getParent().getParent().getParent()
//											.getParent().getParent().layout(
//													true, true);
//
//								}
//								parent = parent.getParent();
//							}
//
//							ScrolledComposite sc = (ScrolledComposite) parent;
//							sc.layout(true, true);
//						}
//						// scrollToLabel(group, sc);
//
//					}
//				}
//			}
//			// Display.getCurrent().asyncExec(new Runnable(){
//			//
//			// public void run() {
//			// setFocus();
//			//					
//			// }
//			//				
//			// });
//			setFocus();
//			selected = true;
//			drawSelectUI();
//
//		}
//
//	}
	@Override
	public boolean setFocus() {
		boolean checkFocus = checkFocus();
		if (checkFocus) {
			return true;
		}
		return super.setFocus();

	}

	protected boolean checkFocus() {
		for (Button b :optionName2CheckBoxesMap.values())
		if (hasFocus(b)){
			return true;
		}
		return false;
	}

	@Override
	public void deselect() {
		if (isSelected()) {
			selected = false;
			drawDeselectUI();
		}
	}

	protected void drawDeselectUI() {
		if (group != null && !group.isDisposed()) {
			Color colorWhite = GUIConstants.COLOR_WHITE;
			label.setBackground(colorWhite);
			group.setBackground(colorWhite);
			setBackground(colorWhite);
			if (toolBar != null) {
				toolBar.setBackground(colorWhite);
			}
			Color systemColor = group.getDisplay().getSystemColor(
					SWT.COLOR_WIDGET_BACKGROUND);
			label.setForeground(group.getDisplay().getSystemColor(
					SWT.COLOR_WIDGET_FOREGROUND));
//			additonalCompositesSetBG(systemColor);
			for (int i = 0; i < additionalComposites.size(); i++) {
				additionalComposites.get(i).setBackground(colorWhite);
			}
			if (decorator != null && !decorator.isDisposed()) {
				decorator.setBackground(colorWhite);
			}
			if (dirtyLabel != null) {
				dirtyLabel.setBackground(systemColor);
			}
			group.redraw();
		}
	}
}
