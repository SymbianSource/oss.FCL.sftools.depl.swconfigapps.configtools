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

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

import com.nokia.tools.variant.viewer.images.PluginImages;

/**
 * Widget graphically represents option possibility for every setting.
 */
public class OptionButton {

	Menu menu;
	private Button button;

	public Button getButton() {
		return button;
	}

	private SelectionListener listener;
	private BaseConfMLWidget widget;
	private Listener buttonSelectionListener;

	public Listener getButtonSelectionListener() {
		return buttonSelectionListener;
	}

	Composite parent;
	private WidgetOptions options;
	private GridData buttonLayouData;

	public OptionButton(BaseConfMLWidget widget, Composite parent) {
		this.widget = widget;
		this.parent = parent;
		init();
	}

	public OptionButton(BaseConfMLWidget widget, Composite parent,
			WidgetOptions options) {
		this(widget, parent);
		this.options = options;
	}

	public void init() {
		button = new Button(parent, SWT.ARROW | SWT.DOWN);
		buttonSelectionListener = new Listener() {
			public void handleEvent(Event event) {

				clearMenu();
				menu = createMenu();
				Point display = button.toDisplay(0, 0);
				Point size = button.getSize();
				menu.setLocation(display.x, display.y + size.y);
				menu.setVisible(true);
				if (!widget.isSelected()) {
					fireSelection();
				}
			}
		};
		button.addListener(SWT.MouseDown, buttonSelectionListener);
		buttonLayouData = new GridData();
		button.setLayoutData(buttonLayouData);
	}

	private Menu createMenu() {
		Menu menu = new Menu(parent);
		listener = new OptionSelectionListener();

		processOptions(menu);
		return menu;
	}

	private void processOptions(Menu menu) {
		if (options != null) {
			for (WidgetOption option : options.values()) {
				addMenuItem(menu, option);
			}
		}
	}

	private void addMenuItem(Menu menu, WidgetOption option) {
		if (option != null) {
			String value = option.getValue();
			if (option.getValue() != null && option.getKey() != null) {
				Image icon = null;
				if (option.isSelected()) {
					icon = PluginImages.CHECKED;
				}
				MenuItem mi = createMenuItem(menu, SWT.PUSH,
						createText(option), icon, -1, true);
				mi.setData(value);
				mi.addSelectionListener(listener);
			}
		}
	}

	private String createText(WidgetOption option) {

		return (option.getMapValue() != null) ? option.getMapValue().concat(
				" (").concat(option.getKey()).concat(")") : option.getKey()
				.concat(" (").concat(option.getValue()).concat(")");
	}

	protected MenuItem createMenuItem(Menu parent, int style, String text,
			Image icon, int accel, boolean enabled) {
		MenuItem mi = new MenuItem(parent, style);
		if (text != null) {
			mi.setText(text);
		}
		if (icon != null) {
			mi.setImage(icon);
		}
		if (accel != -1) {
			mi.setAccelerator(accel);
		}
		mi.setEnabled(enabled);

		return mi;
	}

	private class OptionSelectionListener implements SelectionListener {

		public void widgetDefaultSelected(SelectionEvent e) {
			// do nothing
		}

		public void widgetSelected(SelectionEvent e) {
			MenuItem source = (MenuItem) e.getSource();

			if (widget != null && !widget.isDisposed()) {
				widget.setValue((String) source.getData());
				fireSelection();
			}
		}
	}

	private void fireSelection() {
		Listener[] listeners = widget.getListeners(SWT.MouseDown);
		Event event = new Event();
		event.type = 123456;
		for (Listener listener : listeners) {
			listener.handleEvent(event);
		}
	}

	public void dispose() {
		if (button != null && !button.isDisposed()) {
			button.removeListener(SWT.MouseDown, buttonSelectionListener);
			buttonSelectionListener = null;
			clearMenu();
			listener = null;
		}
	}

	private void clearMenu() {
		if (menu != null) {
			for (int i = 0; i < menu.getItemCount(); i++) {
				menu.getItem(i).removeSelectionListener(listener);
			}
		}
	}

	public void setOptions(WidgetOptions options) {
		this.options = options;

	}

	public void setVisible(boolean visible) {
		if (button != null && !button.isDisposed()) {
			if (visible) {
				button.setVisible(true);
				buttonLayouData.exclude = false;
			} else {
				button.setVisible(false);
				buttonLayouData.exclude = true;
			}
		}
	}

}
