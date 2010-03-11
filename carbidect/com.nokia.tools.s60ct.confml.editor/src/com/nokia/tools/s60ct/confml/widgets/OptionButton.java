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

package com.nokia.tools.s60ct.confml.widgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

import com.nokia.tools.s60ct.confml.editor.PluginImages;

/**
 * Widget graphically represents option possibility for every setting.
 */
public class OptionButton {

	Menu menu;
	private Button button;

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
		this.options = options;
		this.widget = widget;
		this.parent = parent;
		init();
	}

	private void updateSelectionCheck()
	{
		cleanChecked();
		String value = widget.getValue();
		
		for (int i = 0 ; i < menu.getItemCount() ; i++)
		{
			MenuItem item = menu.getItem(i);
			String itemValue = (String)item.getData();
			if (value.equals(itemValue))
			{
				for (WidgetOption option : options.getOptions()) {
					if (option.getValue().equals(itemValue) || (option.getMapValue()!= null && option.getMapValue().equals(itemValue))) {
						item.setImage(PluginImages.CHECKED);
						option.setSelected(true);
						break;
					}
				}
				return;
			}
		}
	}
	
	public void init() {
		button = new Button(parent, SWT.ARROW | SWT.DOWN);
		buttonSelectionListener = new Listener() 
		{
			public void handleEvent(Event event)
			{
				// hide tool tip
				button.setToolTipText(null);
				clearMenu();
				menu = createMenu();
				Point display = button.toDisplay(0, 0);
				Point size = button.getSize();
				menu.setLocation(display.x, display.y + size.y);
				menu.setVisible(true);
				if (!widget.isSelected()) {
					fireSelection();
				}
				updateSelectionCheck();
			}
		};
		button.addListener(SWT.MouseDown, buttonSelectionListener);
		buttonLayouData = new GridData();
		buttonLayouData.horizontalIndent = 2;
		button.setLayoutData(buttonLayouData);
		menu = createMenu();
	}

	private Menu createMenu() {
		Menu menu = new Menu(parent);
		listener = new OptionSelectionListener();
		
		processOptions(menu);
		return menu;
	}

	private void processOptions(Menu menu) {
		final StringBuilder toolTip = new StringBuilder();
		toolTip.append("Suggested options:\n");
		if (options != null) {
			int index = 0, size = options.size();
			for (WidgetOption option : options.getOptions()) {
				toolTip.append(addMenuItem(menu, option));
				if (index < size - 1) {
					toolTip.append("\n");
				}
				index++;
			}
		}
		
		
		final OptionTooltipMouseTrackListener tooltipMouseTrackListener = new OptionTooltipMouseTrackListener(button,toolTip.toString());
		button.addMouseTrackListener(tooltipMouseTrackListener);
		button.addDisposeListener(new DisposeListener(){

			public void widgetDisposed(DisposeEvent e) {
				button.removeDisposeListener(this);
				button.removeMouseTrackListener(tooltipMouseTrackListener);
				tooltipMouseTrackListener.dispose();
				
			}
			
		});
	}

	private String addMenuItem(Menu menu, WidgetOption option) {
		String menuText = "";
		if (option != null) {
			String value = option.getValue();
			if (option.getValue() != null && option.getKey() != null) {
				Image icon = null;
				
				if (option.getMapValue()!=null)
					value = option.getMapValue();
				
				if (option.isSelected()) {
					icon = PluginImages.CHECKED;
				}
				menuText = createText(option);
				MenuItem mi = createMenuItem(menu, SWT.PUSH, menuText, icon,
						-1, true);
				mi.setData(value);
				mi.addSelectionListener(listener);
			}
		}
		return menuText;
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

	private void cleanChecked()
	{
		if (menu != null) {
			for (int i = 0; i < menu.getItemCount(); i++) {
				MenuItem item = menu.getItem(i);
				item.setImage(null);
				item.setSelection(false);
			}
			for (WidgetOption option : options.getOptions()) {
				option.setSelected(false);
			}
		}
	}
	
	private class OptionSelectionListener implements SelectionListener {

		public void widgetDefaultSelected(SelectionEvent e) {
			// do nothing
		}

		public void widgetSelected(SelectionEvent e) {
			
			cleanChecked();
			MenuItem source = (MenuItem) e.getSource();

			if (widget != null && !widget.isDisposed())
			{
				String data = (String) source.getData();
				widget.setValue(data);
				
				for (WidgetOption option : options.getOptions()) {
					if (option.getValue().equals(data) || (option.getMapValue()!= null && option.getMapValue().equals(data))) {
						source.setImage(PluginImages.CHECKED);
						option.setSelected(true);
						break;
					}
				}

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
			button.dispose();
			button = null;
		}

	}

	private void clearMenu() {
		if (menu != null) {
			for (int i = 0; i < menu.getItemCount(); i++) {
				MenuItem item = menu.getItem(i);
				item.removeSelectionListener(listener);
				item.dispose();
			}
			menu.dispose();
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
	
	public void setEnabled(boolean enabled) {
		if (button != null && !button.isDisposed())
		{
			button.setEnabled(enabled);
			menu.setEnabled(enabled);
		}
	}
	
	public class OptionTooltipMouseTrackListener extends MouseTrackAdapter {
		private Control control;
		private Shell tip;

		public OptionTooltipMouseTrackListener(Control control, String tooltipText) {
			this.control = control;
			tip = ToolTipWidget.createNewToolTip(control.getParent(), tooltipText);

		}

		public void mouseEnter(MouseEvent e) {
			if (tip != null && !tip.isDisposed() && control != null
					&& !control.isDisposed()) {

				Control c = control;
				while (!(c instanceof Composite)) {
					c = c.getParent();
				}
				Composite composite = (Composite) c;
				Point display = composite.toDisplay(composite.getClientArea().x
						+ composite.getSize().x, composite.getClientArea().y);
				tip.setLocation(display);
				tip.setVisible(true);
			}

		}

		public void mouseExit(MouseEvent e) {
			if (tip != null && !tip.isDisposed()) {
				tip.setVisible(false);
			}

		}

		public void dispose() {
			control = null;
			if (tip != null && !tip.isDisposed()) {
				tip.dispose();
			}
			tip = null;
		}
	}
	

}
