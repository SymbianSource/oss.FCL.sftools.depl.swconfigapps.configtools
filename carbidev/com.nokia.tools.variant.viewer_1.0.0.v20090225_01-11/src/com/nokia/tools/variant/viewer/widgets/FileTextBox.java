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
/**
 * Widget graphically represents file setting.
 */
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.action.Action;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

import com.nokia.tools.variant.viewer.Activator;
import com.nokia.tools.variant.viewer.actions.EditorAction;
import com.nokia.tools.variant.viewer.extensionregistry.ContributorsRegistry;

/**
 * File widget
 * 
 * IMPROVEMENT The drag & drop stuff should not be here, yet it must because controller
 * does not know when the SWT controls for this get created, hence cannot hook
 * into them.
 */
public class FileTextBox extends BaseTextBox {
	
	private Listener listener;

	public static final String TYPE_COLUMN_TEXT = "Type";
	public static final String NAME_COLUMN_TEXT = "Name";

	public FileTextBox(Composite parent, int style, String widgetLabel) {
		super(parent, style, widgetLabel);

	}

	public FileTextBox(Composite parent, int style, String widgetLabel,
			Image image) {
		super(parent, style, widgetLabel, image);

	}

	public FileTextBox(Composite parent, int style, String widgetLabel,
			WidgetOptions options, Image image) {
		super(parent, style, widgetLabel, options, image);
	}

	@Override
	protected void buildMainControl() {

		text = new Text(group, SWT.BORDER);
		
		text.addKeyListener(new KeyListener(){

			public void keyPressed(KeyEvent e) {
				// clear text box text after DEL key is pressed
				if (e.keyCode == SWT.DEL) {
					text.setText("");
				} else if (e.keyCode == SWT.CR) {
					Event event = new Event();
					event.type = SWT.MouseDown;
					listener.handleEvent(event);
				}
				
			}

			public void keyReleased(KeyEvent e) {
				// do nothing
			}
			
		});
		
		GridData layoutData = new GridData();
		layoutData.widthHint = TEXT_WIDTH_HINT;
		text.setLayoutData(layoutData);

		super.editable(true);

		attachListeners();
	}

	@Override
	protected Layout buildContainerLayout() {
		int columnCount = (image == null) ? 4 : 5;
		if (options!=null && options.size()>0){
			columnCount++;
		}
		GridLayout layout = new GridLayout(columnCount, false);
		return layout;
	}
	@Override
	public void addListener(final Listener listener) {
		this.listener = listener;
		text.addListener(SWT.Modify, listener);
		text.addDisposeListener(new DisposeListener() {

			public void widgetDisposed(DisposeEvent e) {
				FileTextBox.this.listener = null;
				text.removeDisposeListener(this);
				text.removeListener(SWT.Modify, listener);
			}

		});
		super.addListener(listener);
	}

	@Override
	protected void buildToolBar() {
		if (label != null) {
			toolBar = new Composite(label.getParent(), SWT.NONE);
			toolBar.setBackground(group.getBackground());

			GridLayout gl = new GridLayout();
			gl.verticalSpacing = 0;
			gl.horizontalSpacing = 0;
			gl.marginWidth = 0;
			gl.marginHeight = 0;
			toolBar.setLayout(gl);
			GridData gd = new GridData();
			gd.horizontalSpan = 0;
			gd.verticalSpan = 0;
			toolBar.setLayoutData(gd);
			List<Class<EditorAction>> contributors = ContributorsRegistry
					.getInstance().getContributors(
							this.getClass().getCanonicalName());

			if (contributors != null) {
				for (Class<EditorAction> editorAction : contributors) {

					EditorAction action = null;
					try {
						action = editorAction.newInstance();
						action.setWidget(this);
						Button item = new Button(toolBar, SWT.PUSH);
						item.addSelectionListener(new ButtonAction(action));
						item.setText(action.getText());
					} catch (InstantiationException e) {
						Activator
								.getDefault()
								.getLog()
								.log(
										new Status(
												IStatus.ERROR,
												Activator.PLUGIN_ID,
												"Failed to initialize action - "
														.concat(
																editorAction
																		.getCanonicalName())
														.concat("\n").concat(
																e.getMessage())));
					} catch (IllegalAccessException e) {
						Activator
								.getDefault()
								.getLog()
								.log(
										new Status(
												IStatus.ERROR,
												Activator.PLUGIN_ID,
												"Failed to initialize action - "
														.concat(
																editorAction
																		.getCanonicalName())
														.concat("\n").concat(
																e.getMessage())));
					}
				}
			}

		}
	}

	private class ButtonAction implements SelectionListener {

		private Action action;

		public ButtonAction(Action action) {
			this.action = action;
		}

		public void widgetDefaultSelected(SelectionEvent e) {
			// do nothing

		}

		public void widgetSelected(SelectionEvent e) {
			action.run();

		}

	}
	
	@Override
	public void cut() {
		text.cut();
	}
	
	@Override
	public void copy() {
		text.copy();
	}
	
	@Override
	public void paste() {
		text.paste();
	}
	
	@Override
	public void delete() {
		synchronized (text) {			
			Point selection = text.getSelection();			
			String content = text.getText();			
			String result = content.substring(0, selection.x);
			result += content.substring(selection.y, content.length());
			text.setText(result);
			text.update();
		}		
	}	
}
