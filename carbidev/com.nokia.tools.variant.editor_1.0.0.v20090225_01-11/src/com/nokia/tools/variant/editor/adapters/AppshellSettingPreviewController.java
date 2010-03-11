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

package com.nokia.tools.variant.editor.adapters;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.nokia.tools.variant.common.ui.utils.SWTUtil;
import com.nokia.tools.variant.preview.IPreviewDescriptor;
import com.nokia.tools.variant.preview.PreviewController;

public class AppshellSettingPreviewController extends PreviewController {

	private ScrolledComposite control;
	private FormToolkit toolkit;
	private Text locationText;
	private Text sizeText;
	private File file;
	private Button openButton;
	private AppshellSettingPreviewDescriptor descriptor;
	
	@Override
	public void createControl(Composite parent) {
		toolkit = new FormToolkit(parent.getDisplay());
		control = new ScrolledComposite(parent, SWT.NONE);
		toolkit.adapt(control);
		final Composite content = toolkit.createComposite(control);
		control.setContent(content);
		content.setLayout(new GridLayout(2, false));
		Label caption = toolkit.createLabel(content, "Application Shell");
		caption.setLayoutData(new GridData(SWT.CENTER, SWT.TOP, true, false, 2, 1));
		Label separator = toolkit.createSeparator(content, SWT.HORIZONTAL);
		separator.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 2, 1));
		@SuppressWarnings("unused")
		Label locationLabel = toolkit.createLabel(content, "Location:"); 
		locationText = toolkit.createText(content, "");  
		@SuppressWarnings("unused")
		Label sizeLabel = toolkit.createLabel(content, "Grid Size (Est):"); 
		sizeText = toolkit.createText(content, "");  
		
		control.addControlListener(new ControlAdapter() {
			@Override
			public void controlResized(ControlEvent e) {
				Point size = content.computeSize(control.getSize().x, SWT.DEFAULT);
				content.setSize(size);
				content.layout();
			}
		});
		
		openButton = toolkit.createButton(content, "Open Editor", SWT.FLAT);
		openButton.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 2, 1));
		openButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent event) {
				URI uri = URI.createFileURI(file.getAbsolutePath());
				IEditorPart editorPart = descriptor.getEditorPart();
				final CommandStack cs = (CommandStack)editorPart.getAdapter(CommandStack.class);
				
				IEditorInput input = new URIEditorInput(uri) {
					@SuppressWarnings("unchecked")
					@Override
					public Object getAdapter(Class adapter) {
						if (adapter == URIConverter.class) {
							return new CustomURIConverter(cs);
						}
						
						return super.getAdapter(adapter);
					}
				};
				IEditorDescriptor descr = PlatformUI.getWorkbench().getEditorRegistry().findEditor("com.nokia.tools.vct.appshell.appshellmodel.presentation.EAppshellModelEditorID");
				if (descr != null) {
					try {

						IEditorPart openEditor = editorPart.getSite().getPage().openEditor(input, descr.getId());
						List list = (List)editorPart.getAdapter(List.class);
						if (list != null) {
							list.add(openEditor);
						}
					} catch (PartInitException e) {
						e.printStackTrace();
						MessageBox box = new MessageBox(control.getShell(), SWT.ICON_ERROR | SWT.OK);
						box.open();
					}
					return;
				}
			}
		});
	}

	@Override
	public void dispose() {
		toolkit.dispose();
		control.dispose();
	}

	@Override
	public Control getControl() {
		return control;
	}

	@Override
	public void setInput(IPreviewDescriptor descriptor) {
		this.descriptor = (AppshellSettingPreviewDescriptor)descriptor;
		file = this.descriptor.getFile();
		locationText.setText(file.getName());
		openButton.setEnabled(file.exists() && file.isFile());
		Point size = this.descriptor.getSize();
		String literal = "" + size.x + " x " + size.y;
		sizeText.setText(literal);
		control.layout(new Control[] {locationText, sizeText});
	}


	static class CustomURIConverter extends ExtensibleURIConverterImpl {
		
		CommandStack commandStack;
		
		public CustomURIConverter(CommandStack stack) {
			this.commandStack = stack;
		}
		
		@Override
		public OutputStream createOutputStream(URI uri, Map<?, ?> options)
				throws IOException {
			// MARK CPFEDITOR as dirty to allow saving of the
			// resources which are changed by eclipse internal
			// editor even this editor is not changed
			SWTUtil.getStandardDisplay().asyncExec(new Runnable() {
				public void run() {
					commandStack.execute(
							new ResourceChangedCommand());
				}
			});

			return super.createOutputStream(uri, options);
		}
	}

	/**
	 * Resource has been edited by external editor
	 * 
	 */
	static final class ResourceChangedCommand extends Command {
		public ResourceChangedCommand() {
			super("Resource Change");
		}
		  
		  @Override
		public boolean canUndo() {
			return false;
		}
	}


}


