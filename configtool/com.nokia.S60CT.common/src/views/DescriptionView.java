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
package views;

import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;


public class DescriptionView extends ViewPart implements ISelectionListener {

	public final static String ID = "common.description";

	private final static String BROWSER_TAB_TEXT ="desc";
	private final static String EDITOR_TAB_TEXT = "edit";

	TabFolder tabFolder=null;
	TabItem browserTab=null;
	TabItem editorTab = null;

	Browser browser = null;
	Text editor = null;

	IDescriptionPage descProvider=null;
	Object owner = null;

	KeyListener keyListener = new KeyAdapter(){
		public void keyReleased(KeyEvent e) {
			descProvider.updateDescription(owner, editor.getText());
			updateBrowser();
		}
	};


	public DescriptionView() {
	}

	public void createPartControl(Composite parent) {
		tabFolder = new TabFolder(parent,SWT.BOTTOM);
		browserTab = new TabItem(tabFolder,SWT.NONE);
		browserTab.setText(BROWSER_TAB_TEXT);
		browser = new Browser(tabFolder, SWT.BORDER);
		browserTab.setControl(browser);


		getSite().getPage().addSelectionListener(this);
	}

	private void createEditorTab() {
		if(editorTab==null){
			editorTab = new TabItem( tabFolder, SWT.NONE );
			editorTab.setText( EDITOR_TAB_TEXT );
			editor = new Text( tabFolder, SWT.MULTI | SWT.WRAP | SWT.BORDER );
			editor.addKeyListener(keyListener);
			editorTab.setControl( editor );

		}
	}

	public void disposeEditorTab(){
		if(editorTab!=null&&!editorTab.isDisposed()){
			editorTab.dispose();
		}
		editorTab=null;
	}

	public void setFocus() {
		browser.setFocus();
	}

	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		Object adapter=null;
		if(selection instanceof IStructuredSelection) {
			IStructuredSelection structedSelection = (IStructuredSelection)selection;
			owner = structedSelection.getFirstElement();
			if(owner!=null) {
				adapter = Platform.getAdapterManager().getAdapter(owner, IDescriptionPage.class);				
			}
		}
		if(adapter!=null) {
			descProvider = (IDescriptionPage)adapter;
			if(descProvider.isEditable(owner)){
				createEditorTab();
			}else{
				disposeEditorTab();
			}
			updateBrowser();
			updateEditor();
		}
	}

	private void updateEditor() {
		if(editor!=null&&!editor.isDisposed()){
			String value=descProvider.getDescValue(owner);
			value =value != null ? value:"" ;
			editor.setText(value );
			editor.update();
		}
	}

	private void updateBrowser() {
		String value=descProvider.getDescValue(owner);
		browser.setText(value!=null?value:"");
		browser.update();
	}

	//clean Description view if a configuration browser is closed
	public void cleanViewer(IEditorPart editor){
		IEditorReference[] references = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getEditorReferences();
		boolean bExist=false;
		for (IEditorReference editorReference : references) {
			if(editorReference.getEditor(true).equals(editor))
				bExist=true;

		}
		if(!bExist){
			browser.setText("");
		}

		browser.update();
	}

}
