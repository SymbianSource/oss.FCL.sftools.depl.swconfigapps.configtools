/*
* Copyright (c) 2009 Nokia Corporation and/or its subsidiary(-ies). 
* All rights reserved.
* This component and the accompanying materials are made available
* under the terms of "Eclipse Public License v1.0"
* which accompanies this distribution, and is available
* at the URL "http://www.eclipse.org/legal/epl-v10.html".
*
* Initial Contributors:
* Nokia Corporation - initial contribution.
*
* Contributors:
*
* Description:
*
*/
package actions;

import interfaces.RenameEObjectSet;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TreeEditor;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.actions.TextActionHandler;

public class RenameAction implements IObjectActionDelegate {
	
	protected EObject selectedObject = null;
	protected EAttribute selectedNameAttribute = null;
	protected EAttribute selectedROAttribute = null;
	
	private EObject inlinedObject = null;
	protected EAttribute inlinedAttribute = null;
	
	
	private Composite textEditorParent;
	
	private Text textEditor;
	
	private TextActionHandler textActionHandler;
	
	private Tree navigatorTree;
	
	private TreeEditor treeEditor;
	
	private boolean saving = false;
	
	private static Object[][] ALLOWED_TYPES = null;
	
	public RenameAction() {
	}

	public void setActivePart(IAction action, IWorkbenchPart page) {
		navigatorTree=null;
		if(page instanceof IViewerProvider){
			Viewer viewer = ((IViewerProvider)page).getViewer();
			if(viewer.getControl() instanceof Tree){
				RenameAction.this.navigatorTree=(Tree)viewer.getControl();
				RenameAction.this.treeEditor= new TreeEditor(RenameAction.this.navigatorTree);
			}
		}
		RenameEObjectSet renameEObjectSet = (RenameEObjectSet)page.getAdapter(RenameEObjectSet.class);
		if(renameEObjectSet!=null){
			ALLOWED_TYPES=renameEObjectSet.getTypes();
		}else ALLOWED_TYPES=null;
	}

	public void run(IAction action) {
		if(isObjectReadOnly(selectedObject)||navigatorTree==null)return;
		queryNewResourceNameInline((String)selectedObject.eGet(selectedNameAttribute));
	}

	public void selectionChanged(IAction action, ISelection selection) {
		selectedObject =null;
		selectedNameAttribute = null;
		selectedROAttribute = null;
		if(selection instanceof IStructuredSelection) {
	           IStructuredSelection structedSelection = (IStructuredSelection)selection;
	           if(structedSelection.size()>0&&ALLOWED_TYPES!=null&&isSupportedType(structedSelection.getFirstElement())){
	        	   selectedObject=(EObject)structedSelection.getFirstElement();
	           }
	    }
		if(selectedObject!=null&&ALLOWED_TYPES!=null&&!isObjectReadOnly(selectedObject)){
			action.setEnabled(true);
		}
		else action.setEnabled(false);
		
	}
	private boolean isObjectReadOnly(EObject object){
		return selectedROAttribute!=null?((Boolean)object.eGet(selectedROAttribute)).booleanValue():false;
		
	}
	
	private boolean isSupportedType(Object object){
		boolean result = false;
		for (int i = 0; i < ALLOWED_TYPES.length&&!result; i++) {
			Object[] pair = ALLOWED_TYPES[i];
			Class klass = (Class)pair[RenameEObjectSet.CLASS_INDEX];
			EAttribute nameAttribute = (EAttribute)pair[RenameEObjectSet.NAME_ATTRIBUTE_INDEX];
			EAttribute roAttribute = pair.length>RenameEObjectSet.RO_ATTRIBUTE_INDEX?(EAttribute)pair[RenameEObjectSet.RO_ATTRIBUTE_INDEX]:null;
			if(klass.isInstance(object)){
				selectedObject = (EObject)object;
				selectedROAttribute = roAttribute;
				this.selectedNameAttribute = nameAttribute;
				result=true;
			}
			
		}
		return result;
	}
	
	private void queryNewResourceNameInline(final String  name) {
		// Make sure text editor is created only once. Simply reset text
		// editor when action is executed more than once. Fixes error 22269.
		if (textEditorParent == null) {
			createTextEditor();
		}
		textEditor.setText(name==null?"":name);

		// Open text editor with initial size.
		textEditorParent.setVisible(true);
		Point textSize = textEditor.computeSize(SWT.DEFAULT, SWT.DEFAULT);
		textSize.x += textSize.y; // Add extra space for new characters.
		Point parentSize = textEditorParent.getSize();
		int inset = getCellEditorInset(textEditorParent);
		textEditor.setBounds(2, inset, Math.min(textSize.x, parentSize.x - 4),
				parentSize.y - 2 * inset);
		textEditorParent.redraw();
		textEditor.selectAll();
		textEditor.setFocus();
	}
	
	private static int getCellEditorInset(Control c) {
		return 1; // one pixel wide black border
	}
	
	private void createTextEditor() {
		// Create text editor parent. This draws a nice bounding rect.
		textEditorParent = createParent();
		textEditorParent.setVisible(false);
		final int inset = getCellEditorInset(textEditorParent);
		if (inset > 0) {
			textEditorParent.addListener(SWT.Paint, new Listener() {
				public void handleEvent(Event e) {
					Point textSize = textEditor.getSize();
					Point parentSize = textEditorParent.getSize();
					e.gc.drawRectangle(0, 0, Math.min(textSize.x + 4,
							parentSize.x - 1), parentSize.y - 1);
				}
			});
		}
		// Create inner text editor.
		textEditor = new Text(textEditorParent, SWT.NONE);
		textEditor.setFont(navigatorTree.getFont());
		textEditorParent.setBackground(textEditor.getBackground());
		textEditor.addListener(SWT.Modify, new Listener() {
			public void handleEvent(Event e) {
				Point textSize = textEditor.computeSize(SWT.DEFAULT,
						SWT.DEFAULT);
				textSize.x += textSize.y; // Add extra space for new
				// characters.
				Point parentSize = textEditorParent.getSize();
				textEditor.setBounds(2, inset, Math.min(textSize.x,
						parentSize.x - 4), parentSize.y - 2 * inset);
				textEditorParent.redraw();
			}
		});
		textEditor.addListener(SWT.Traverse, new Listener() {
			public void handleEvent(Event event) {

				// Workaround for error 20214 due to extra
				// traverse events
				switch (event.detail) {
				case SWT.TRAVERSE_ESCAPE:
					// Do nothing in this case
					disposeTextWidget();
					event.doit = true;
					event.detail = SWT.TRAVERSE_NONE;
					break;
				case SWT.TRAVERSE_RETURN:
					saveChangesAndDispose();
					event.doit = true;
					event.detail = SWT.TRAVERSE_NONE;
					break;
				}
			}
		});
		textEditor.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent fe) {
				saveChangesAndDispose();
			}
		});

		if (textActionHandler != null) {
			textActionHandler.addText(textEditor);
		}
	}

	Composite createParent() {
		Tree tree = getTree();
		Composite result = new Composite(tree, SWT.NONE);
		TreeItem[] selectedItems = tree.getSelection();
		treeEditor.horizontalAlignment = SWT.LEFT;
		treeEditor.grabHorizontal = true;
		treeEditor.setEditor(result, selectedItems[0]);
		return result;
	}
	private void disposeTextWidget() {
		if (textActionHandler != null) {
			textActionHandler.removeText(textEditor);
		}

		if (textEditorParent != null) {
			textEditorParent.dispose();
			textEditorParent = null;
			textEditor = null;
			treeEditor.setEditor(null, null);
		}
	}
	private void saveChangesAndDispose() {
		if (saving == true) {
			return;
		}

		saving = true;
		// Cache the resource to avoid selection loss since a selection of
		// another item can trigger this method
		inlinedObject = selectedObject;
		inlinedAttribute = this.selectedNameAttribute;
		final String newName = textEditor.getText();
		// Run this in an async to make sure that the operation that triggered
		// this action is completed. Otherwise this leads to problems when the
		// icon of the item being renamed is clicked (i.e., which causes the
		// rename
		// text widget to lose focus and trigger this method).
		Runnable query = new Runnable() {
			public void run() {
				try {
					if (!newName.equals(inlinedObject.eGet(inlinedAttribute))) {
						EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(selectedObject);
						Command command = SetCommand.create(editingDomain, inlinedObject, inlinedAttribute, newName);
						if(command!=null)
							editingDomain.getCommandStack().execute(command);
					}
					inlinedObject = null;
					// Dispose the text widget regardless
					disposeTextWidget();
					// Ensure the Navigator tree has focus, which it may not if
					// the
					// text widget previously had focus.
					if (navigatorTree != null && !navigatorTree.isDisposed()) {
						navigatorTree.setFocus();
					}
				} finally {
					saving = false;
				}
			}
		};
		getTree().getShell().getDisplay().asyncExec(query);
	}
	private Tree getTree() {
		return this.navigatorTree;
	}
}
