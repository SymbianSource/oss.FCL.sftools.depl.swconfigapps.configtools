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
package com.nokia.tools.carbide.ct.crml.ui.editors;


import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.viewers.IPostSelectionProvider;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FontDialog;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.MultiPageEditorPart;
import org.eclipse.wst.sse.ui.StructuredTextEditor;

import com.nokia.tools.carbide.ct.crml.ui.overview.CRMLViewer;
import com.nokia.tools.carbide.ct.crml.ui.overview.IOverviewViewer;

/**
 * An example showing how to create a multi-page editor.
 * This example has 3 pages:
 * <ul>
 * <li>page 0 contains a nested text editor.
 * <li>page 1 allows you to change the font used in page 2
 * <li>page 2 shows the words in page 0 in sorted order
 * </ul>
 */
public class CRMLMultiPageEditorPart extends MultiPageEditorPart implements IResourceChangeListener{

	/** The text editor used in page 0. */
	private TextEditor editor;

	private String title = "CRML Editor"; //will change later
	
	/** The font chosen in page 1. */
	private Font font;

	/** The text widget used in page 2. */
	private StyledText text;

	private StructuredTextEditor fTextEditor;

	private int fSourcePageIndex;

	private IOverviewViewer fOverviewViewer;

	private int fDesignPageIndex;

	private Object fTextEditorSelectionListener;
	/**
	 * Creates a multi-page editor example.
	 */
	public CRMLMultiPageEditorPart() {
		super();
		ResourcesPlugin.getWorkspace().addResourceChangeListener(this);
	}

	/**
	 * Creates the pages of the multi-page editor.
	 */
	protected void createPages() {
		try {
			createSourcePage();

//			createAndAddDesignPage();
			addSourcePage();
			
//			connectDesignPage();

//			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(IPageLayout.ID_OUTLINE);

		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	

	public String getTitle() {

		return title;
	}

	protected void createSourcePage() throws PartInitException {
		fTextEditor = createTextEditor();
		fTextEditor.setEditorPart(this);
		
		/*
		 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=134301 - XML editor
		 * does not remember font settings
		 * 
		 * @see
		 * org.eclipse.ui.texteditor.AbstractTextEditor#getSymbolicFontName()
		 */
//		fPageInitializer.sendInitializationData(fTextEditor);
//
//		if (fPropertyListener == null) {
//			fPropertyListener = new PropertyListener();
//		}
//		fTextEditor.addPropertyListener(fPropertyListener);
	}
	
	/**
	 * Adds the source page of the multi-page editor.
	 */
	private void addSourcePage() throws PartInitException {
		fSourcePageIndex = addPage(fTextEditor, getEditorInput());
		setPageText(fSourcePageIndex, "Source");

		firePropertyChange(PROP_TITLE);

		// Changes to the Text Viewer's document instance should also
		// force an
		// input refresh
		//fTextEditor.getTextViewer().addTextInputListener(new TextInputListener());
	}	
	
	private void createAndAddDesignPage() {
		IOverviewViewer designViewer = createDesignPage();

		fOverviewViewer = designViewer;
		// note: By adding the design page as a Control instead of an
		// IEditorPart, page switches will indicate
		// a "null" active editor when the design page is made active
		fDesignPageIndex = addPage(designViewer.getControl());
		setPageText(fDesignPageIndex, designViewer.getTitle());
	}
	
	protected IOverviewViewer createDesignPage() {
		CRMLViewer viewer = new CRMLViewer(getContainer());
		// Set the default infopop for XML design viewer.
//		XMLUIPlugin.getInstance().getWorkbench().getHelpSystem().setHelp(tableTreeViewer.getControl(), XMLTableTreeHelpContextIds.XML_DESIGN_VIEW_HELPID);
		return viewer;
	}
	
	/**
	 * Connects the design viewer with the viewer selection manager. Should be
	 * done after createSourcePage() is done because we need to get the
	 * ViewerSelectionManager from the TextEditor. setModel is also done here
	 * because getModel() needs to reference the TextEditor.
	 */
	private void connectDesignPage() {
		if (fOverviewViewer != null) {
			fOverviewViewer.setDocument(getDocument(),getEditorInput().getName());
		}

		/*
		 * Connect selection from the Source page to the selection provider of
		 * the Design page so that selection in the Source page will drive
		 * selection in the Design page. Prefer post selection.
		 */
		ISelectionProvider provider = getTextEditor().getSelectionProvider();
		if (fTextEditorSelectionListener == null) {
//			fTextEditorSelectionListener = new TextEditorPostSelectionAdapter();
		}
		if (provider instanceof IPostSelectionProvider) {
//			fTextEditorSelectionListener.forcePostSelection = false;
//			((IPostSelectionProvider) provider).addPostSelectionChangedListener(fTextEditorSelectionListener);
		}
		else {
//			fTextEditorSelectionListener.forcePostSelection = true;
//			provider.addSelectionChangedListener(fTextEditorSelectionListener);
		}
	}

	StructuredTextEditor getTextEditor() {
		return fTextEditor;
	}
	
	private IDocument getDocument() {
		IDocument document = null;
		if (fTextEditor != null) {
			document = fTextEditor.getDocumentProvider().getDocument(fTextEditor.getEditorInput());
		}
		return document;
	}
	
	/**
	 * Method createTextEditor.
	 * 
	 * @return StructuredTextEditor
	 */
	private StructuredTextEditor createTextEditor() {
		return new StructuredTextEditor();
	}
	
	/**
	 * The <code>MultiPageEditorPart</code> implementation of this 
	 * <code>IWorkbenchPart</code> method disposes all nested editors.
	 * Subclasses may extend.
	 */
	public void dispose() {
		ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);
		super.dispose();
	}
	/**
	 * Saves the multi-page editor's document.
	 */
	public void doSave(IProgressMonitor monitor) {
		getEditor(0).doSave(monitor);
	}
	/**
	 * Saves the multi-page editor's document as another file.
	 * Also updates the text for page 0's tab, and updates this multi-page editor's input
	 * to correspond to the nested editor's.
	 */
	public void doSaveAs() {
		IEditorPart editor = getEditor(0);
		editor.doSaveAs();
		setPageText(0, editor.getTitle());
		setInput(editor.getEditorInput());
	}
	/* (non-Javadoc)
	 * Method declared on IEditorPart
	 */
	public void gotoMarker(IMarker marker) {
		setActivePage(0);
		IDE.gotoMarker(getEditor(0), marker);
	}
	/**
	 * The <code>MultiPageEditorExample</code> implementation of this method
	 * checks that the input is an instance of <code>IFileEditorInput</code>.
	 */
	public void init(IEditorSite site, IEditorInput editorInput)
		throws PartInitException {
		if (!(editorInput instanceof IFileEditorInput))
			throw new PartInitException("Invalid Input: Must be IFileEditorInput");
		title = editorInput.getName();
		super.init(site, editorInput);
		
		//PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(IPageLayout.ID_OUTLINE);
	}
	/* (non-Javadoc)
	 * Method declared on IEditorPart.
	 */
	public boolean isSaveAsAllowed() {
		return true;
	}
	/**
	 * Calculates the contents of page 2 when the it is activated.
	 */
	protected void pageChange(int newPageIndex) {
//		System.out.println("Page id="+newPageIndex + " activated!");
		super.pageChange(newPageIndex);
	}
	/**
	 * Closes all project files on project close.
	 */
	public void resourceChanged(final IResourceChangeEvent event){
		if(event.getType() == IResourceChangeEvent.PRE_CLOSE){
			Display.getDefault().asyncExec(new Runnable(){
				public void run(){
					IWorkbenchPage[] pages = getSite().getWorkbenchWindow().getPages();
					for (int i = 0; i<pages.length; i++){
						if(((FileEditorInput)editor.getEditorInput()).getFile().getProject().equals(event.getResource())){
							IEditorPart editorPart = pages[i].findEditor(editor.getEditorInput());
							pages[i].closeEditor(editorPart,true);
						}
					}
				}            
			});
		}
	}
	/**
	 * Sets the font related data to be applied to the text in page 2.
	 */
	void setFont() {
		FontDialog fontDialog = new FontDialog(getSite().getShell());
		fontDialog.setFontList(text.getFont().getFontData());
		FontData fontData = fontDialog.open();
		if (fontData != null) {
			if (font != null)
				font.dispose();
			font = new Font(text.getDisplay(), fontData);
			text.setFont(font);
		}
	}
	
	public void setSelectionToRef(String ref)
	{
		int position = this.fTextEditor.getTextViewer().getFindReplaceTarget().findAndSelect(0, ref, true, true, false);
		IDocument doc = this.fTextEditor.getTextViewer().getDocument();
		if (position!=-1)
		{
			try 
			{
				int line = doc.getLineOfOffset(position);
				int lineLen = doc.getLineLength(line);
				int lineOffset = doc.getLineOffset(line);
				getTextEditor().getSelectionProvider().setSelection(new TextSelection(lineOffset, lineLen));
			} 
			catch (BadLocationException e)
			{
				e.printStackTrace();
			}
		}
	}
	
}
