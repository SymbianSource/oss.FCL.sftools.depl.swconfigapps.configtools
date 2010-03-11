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

package com.nokia.tools.vct.confml.editor.view.actions;

import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TreeEditor;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

import com.nokia.tools.vct.confml.editor.view.commands.SetGroupNameCommand;
import com.nokia.tools.vct.confml.editor.view.vemodel.EGroup;
import com.nokia.tools.vct.confml.editor.view.vemodel.EView;

public class RenameAction extends Action {

	private TreeViewer viewer;
	private CommandStack commandStack;
	private Text text;

	public RenameAction(CommandStack commandStack, TreeViewer viewer) {
		this.viewer = viewer;
		this.commandStack = commandStack;
		setText("&Rename");
	}

	@Override
	public void run() {
		super.run();
		final Tree tree = viewer.getTree();
		final TreeEditor editor = new TreeEditor(tree);
		editor.horizontalAlignment = SWT.LEFT;
		editor.grabHorizontal = true;
		if (tree.getSelectionCount() == 1) {
			final TreeItem item = tree.getSelection()[0];
			text = new Text(tree, SWT.NONE);
			text.setText(item.getText());
			text.selectAll();
			text.setFocus();

			text.addFocusListener(new FocusAdapter() {
				public void focusLost(FocusEvent event) {
					rename();
					text.dispose();
				}
			});

			text.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent event) {
					switch (event.keyCode) {
					case SWT.CR:
					case SWT.KEYPAD_CR:
						rename();
					case SWT.ESC:
						text.dispose();
						break;
					}
				}
			});
			editor.setEditor(text, item);
		}
	}

	private void rename() {
		Tree tree = viewer.getTree();
		TreeItem item = tree.getSelection()[0];
		EObject element = (EObject) item.getData();
		EView eView;
		EList<EGroup> groups;
		EGroup renamedGroup = (EGroup) element;
		if (renamedGroup.eContainer() instanceof EView) {
			eView = (EView) renamedGroup.eContainer();
			groups = eView.getGroups();
		} else {
			EGroup parentGroup = (EGroup) renamedGroup.eContainer();
			groups = parentGroup.getGroups();
		}

		for (Iterator<EGroup> iterator = groups.iterator(); iterator.hasNext();) {
			EGroup group = (EGroup) iterator.next();
			if (!group.equals(element)
					&& group.getName().equalsIgnoreCase(text.getText())) {
				text.dispose();
				MessageBox mb = new MessageBox(Display.getCurrent()
						.getActiveShell(), SWT.ICON_ERROR | SWT.OK);
				mb.setText("Group can't be renamed");
				mb
						.setMessage("Group with entered name already exists.\n Please enter unique group name.");
				mb.open();
				return;
			}
		}
		SetGroupNameCommand setNameCommand = new SetGroupNameCommand(viewer,
				((EGroup) element), text.getText().trim());
		commandStack.execute(setNameCommand);
	}
}
