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

package com.nokia.tools.vct.confml.editor.view;

import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EventObject;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.commands.operations.ObjectUndoContext;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.commands.CommandStackListener;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.gef.ui.actions.RedoAction;
import org.eclipse.gef.ui.actions.StackAction;
import org.eclipse.gef.ui.actions.UndoAction;
import org.eclipse.gef.ui.actions.UpdateAction;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DragSourceAdapter;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Sash;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IURIEditorInput;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.PatternFilter;
import org.eclipse.ui.forms.IFormColors;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.ide.IGotoMarker;
import org.eclipse.ui.operations.RedoActionHandler;
import org.eclipse.ui.operations.UndoActionHandler;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import com.nokia.tools.variant.confml.ui.ConfmlUI;
import com.nokia.tools.variant.confml.ui.editors.CompositeSelectionProvider;
import com.nokia.tools.variant.confml.ui.editors.IDocumentManager;
import com.nokia.tools.vct.common.appmodel.EAppFeature;
import com.nokia.tools.vct.common.appmodel.EAppSetting;
import com.nokia.tools.vct.common.core.utils.ArrayUtils;
import com.nokia.tools.vct.common.core.utils.FileUtils;
import com.nokia.tools.vct.common.ui.utils.TreeViewerFilterToolbar;
import com.nokia.tools.vct.confml.editor.view.actions.AddGroupAction;
import com.nokia.tools.vct.confml.editor.view.actions.AddOptionAction;
import com.nokia.tools.vct.confml.editor.view.actions.AddPropertyAction;
import com.nokia.tools.vct.confml.editor.view.actions.DeleteAction;
import com.nokia.tools.vct.confml.editor.view.actions.ExpandSettingRefAction;
import com.nokia.tools.vct.confml.editor.view.actions.GroupType;
import com.nokia.tools.vct.confml.editor.view.actions.OpenConfMLViewEditor;
import com.nokia.tools.vct.confml.editor.view.actions.PropertiesAction;
import com.nokia.tools.vct.confml.editor.view.actions.RenameAction;
import com.nokia.tools.vct.confml.editor.view.commands.AddSettingCommand;
import com.nokia.tools.vct.confml.editor.view.commands.DeleteCommand;
import com.nokia.tools.vct.confml.editor.view.commands.IncludeViewCommand;
import com.nokia.tools.vct.confml.editor.view.commands.MoveGroupsCommand;
import com.nokia.tools.vct.confml.editor.view.commands.MoveRefsCommand;
import com.nokia.tools.vct.confml.editor.view.commands.MoveViewsCommand;
import com.nokia.tools.vct.confml.editor.view.pages.NavigatorPreviewPage;
import com.nokia.tools.vct.confml.editor.view.vemodel.EFeature;
import com.nokia.tools.vct.confml.editor.view.vemodel.EGroup;
import com.nokia.tools.vct.confml.editor.view.vemodel.EGroupContainer;
import com.nokia.tools.vct.confml.editor.view.vemodel.ERefOption;
import com.nokia.tools.vct.confml.editor.view.vemodel.ERefProperty;
import com.nokia.tools.vct.confml.editor.view.vemodel.EResourceLocator;
import com.nokia.tools.vct.confml.editor.view.vemodel.ESetting;
import com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef;
import com.nokia.tools.vct.confml.editor.view.vemodel.EView;
import com.nokia.tools.vct.confml.editor.view.vemodel.EViewEditorFactory;
import com.nokia.tools.vct.confml.editor.view.vemodel.EViewsEditorDocument;
import com.nokia.tools.vct.confml.editor.view.vemodel.impl.EViewEntryImpl;
import com.nokia.tools.vct.confml.editor.view.vemodel.util.ConverterUtils;
import com.nokia.tools.vct.confml.editor.view.viewers.ConfmlTreeViewer;
import com.nokia.tools.vct.confml.editor.view.viewers.ConfmlTreeViewerContentProvider;
import com.nokia.tools.vct.confml.editor.view.viewers.ConfmlTreeViewerLabelProvider;
import com.nokia.tools.vct.confml.editor.view.viewers.ViewTreeViewer;
import com.nokia.tools.vct.confml.editor.view.viewers.ViewTreeViewerContentProvider;
import com.nokia.tools.vct.confml.editor.view.viewers.ViewTreeViewerLabelProvider;

public class ViewsEditor extends EditorPart implements
		ITabbedPropertySheetPageContributor, IGotoMarker {
	private CommandStack stack;
	private Form control;
	private FormToolkit formToolkit;
	private List<IAction> actionList = new ArrayList<IAction>();
	/** View model as when it is loaded */
	// private EConfMLResource viewModel;
	/** Layer model as when it is loaded */
	// private EVariantContributor layerModel;
	private List<String> stackActionIDs = new ArrayList<String>();
	/** Current editable's model viewer */
	private ViewTreeViewer viewTv;
	/** Current application model viewer */
	private ConfmlTreeViewer confmlTv;

	// disabled, setColor() need more support (delete, checkbutton, refresh)
	private boolean colors = false;

	public static final String EDITOR_ID = ConfmlUI.VIEW_EDITOR_ID;

	private static final String PROPERTIES_CONTRIBUTOR_ID = "com.nokia.tools.variant.confml.ui.editors.VIEW_EDITOR_TABBED_PROPERTIES_CONTRIBUTOR";

	private TabbedPropertySheetPage propertySheetPage;

	private CommandStackListener commandStackListener = new CommandStackListener() {
		public void commandStackChanged(EventObject event) {
			updateActions(stackActionIDs);
			setDirty(stack.isDirty());
		}
	};

	private boolean isDirty;
	private ActionRegistry actionRegistry;
	private RedoActionHandler redoAction;
	private UndoActionHandler undoAction;
	private ObjectUndoContext undoContext;
	private PatternFilter confmlPatternFilter = new PatternFilter();
	private PatternFilter viewPatternFilter = new PatternFilter();
	private ConfmlTvFilter confmlTvFilter = new ConfmlTvFilter();
	private NavigatorPreviewPage previewPage;
	private EViewsEditorDocument document;

	@Override
	public void doSave(IProgressMonitor monitor) {
		try {
			doSave(getEditorInput(), monitor);
			stack.markSaveLocation();
		} catch (CoreException e) {
			ConfmlUI.getInstance().getLog().log(e.getStatus());
		}
	}

	@Override
	public void doSaveAs() {

	}

	private void updateActions(final List<String> actionIDs) {

		for (String actionID : actionIDs) {
			IAction action = actionRegistry.getAction(actionID);
			if (null != action && action instanceof UpdateAction)
				((UpdateAction) action).update();
		}
	}

	private void doSave(IEditorInput input, IProgressMonitor monitor)
			throws CoreException {

		final IFile file;
		final URI uri;
		monitor.beginTask(Messages.Task_Saving_Content, 100);
		try {
			if (input instanceof IFileEditorInput) {
				IFileEditorInput fei = (IFileEditorInput) input;
				file = fei.getFile();
				uri = fei.getFile().getLocationURI();
			} else if (input instanceof IURIEditorInput) {
				file = null;
				uri = ((IURIEditorInput) input).getURI();
			} else {
				file = (IFile) input.getAdapter(IFile.class);
				uri = (URI) input.getAdapter(URI.class);
			}

			if (file != null) {
				IWorkspaceRunnable save = new IWorkspaceRunnable() {
					public void run(IProgressMonitor monitor)
							throws CoreException {
						ViewsEditorPlugin.getVEDocumentManager().saveModel(
								document, monitor);
					}
				};

				ResourcesPlugin.getWorkspace().run(save, file,
						IWorkspace.AVOID_UPDATE,
						new SubProgressMonitor(monitor, 100));
			} else if (uri != null) {
				ViewsEditorPlugin.getVEDocumentManager().saveModel(document,
						new SubProgressMonitor(monitor, 100));
			} else {
				throw new CoreException(new Status(IStatus.ERROR,
						ConfmlUI.PLUGIN_ID,
						Messages.Exception_Input_Type_Not_Supported));
			}
		} finally {
			monitor.done();
		}
	}

	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {

		setSite(site);
		setInputWithNotify(input);
		
		stack = new CommandStack() {
			@Override
			public void execute(Command command) {
				super.execute(command);
			}

		};
		actionRegistry = new ActionRegistry();

		stack.addCommandStackListener(commandStackListener);
		createActions();
		final IFile file;
		final URI uri;

		if (input instanceof IFileEditorInput) {
			IFileEditorInput fei = (IFileEditorInput) input;
			file = fei.getFile();
			uri = fei.getFile().getLocationURI();
			// } else if (input instanceof IURIEditorInput) {
			// file = null;
			// uri = ((IURIEditorInput) input).getURI();
		} else {
			file = (IFile) input.getAdapter(IFile.class);
			uri = (URI) input.getAdapter(URI.class);
		}

		Job fileOpenJob = new Job(Messages.Job_Loading_File) {
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				return loadContent(this, file, uri, monitor);
			}
		};
		if (file != null) {
			fileOpenJob.setRule(file);
		} else {
			fileOpenJob.setRule(ResourcesPlugin.getWorkspace().getRoot());
		}
		fileOpenJob.setUser(true);
		fileOpenJob.schedule();

		setPartName(file.getName());
	}

	@Override
	protected void setInput(IEditorInput input) {
		super.setInput(input);
	}

	static class ConfmlTvFilter extends ViewerFilter {
		@Override
		public boolean select(Viewer viewer, Object parentElement,
				Object element) {
			if (element instanceof ESetting) {

				ESetting setting = (ESetting) element;
				return setting.getRefs().isEmpty();

			} 
			else if (element instanceof EFeature)
			{
				EFeature feature = (EFeature) element;

				if (!feature.getRefs().isEmpty()) {
					return false;
				}
				for (ESetting setting : feature.getSettings().values()) {
					if (setting.getRefs().isEmpty()) {
						return true;
					}
				}

				return false;
			}
			else if (element instanceof EView)
			{
				EView view = (EView)element;
				EViewsEditorDocument doc = (EViewsEditorDocument)view.eContainer();
				EView editedView = doc.getViews().get(0).getValue();
				
				return !isViewIncluded(editedView, view);
			}

			return true;
		}
		
		private boolean isViewIncluded(EView rootView, EView otherView)
		{
			for (EView v : rootView.getIncludeViews())
			{
				if (v.getInclusionURI().equals(otherView.getInclusionURI()))
				{
					return true;
				}
				else
				{
					if (isViewIncluded(v, otherView))
						return true;
				}
			}
			return false;
		}
	}

	
	
	/**
	 * Method performs model loading. The method is executed in non-UI thread.
	 * 
	 * @param file
	 * @param uri
	 * @param monitor
	 * @return
	 */
	IStatus loadContent(final Job context, IFile file, URI uri,
			IProgressMonitor monitor) {
		SubProgressMonitor subMonitor;

		// EConfMLResource model = null;
		EViewsEditorDocument document = null;
		Throwable error = null;

		try {
			monitor.beginTask(Messages.Task_Loading_Content, 100);

			if (monitor.isCanceled()) {
				return Status.CANCEL_STATUS;
			}

			IDocumentManager<EViewsEditorDocument> manager = ViewsEditorPlugin
					.getVEDocumentManager();

			InputStream is = null;
			try {
				if (file != null) {
					subMonitor = new SubProgressMonitor(monitor, 30);
					is = file.getContents();
					// model = ConfMLCore.loadResourceModel(is, subMonitor);
					try {
						subMonitor = new SubProgressMonitor(monitor, 70);
						document = manager.getModel(file, subMonitor);
					} catch (CoreException e) {

						e.printStackTrace();
						throw new PartInitException("Failed to load model", e);
					}
					// } else if (uri != null) {
					// subMonitor = new SubProgressMonitor(monitor, 30);
					// is = EFS.getStore(uri)
					// .openInputStream(EFS.NONE, subMonitor);
					// // model = ConfMLCore.loadResourceModel(is, subMonitor);
					// subMonitor = new SubProgressMonitor(monitor, 70);
					// layerModel = ConfMLCore.getVariantContributor(uri,
					// subMonitor);
				} else {
					throw new IllegalArgumentException(
							Messages.Exception_Input_Not_Supported);
				}
			} finally {
				FileUtils.closeStream(is, ConfmlUI.getInstance());
			}

			return Status.OK_STATUS;
		} catch (Exception ex) {
			error = ex;
			return new Status(IStatus.ERROR, ConfmlUI.PLUGIN_ID,
					Messages.Status_Failed_To_Open_File, ex);
		} finally {
			// final EConfMLResource model0 = model;
			final EViewsEditorDocument document1 = document;
			final Throwable error0 = error;
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					modelLoadDone(context, document1, error0);
				}
			});

			monitor.done();
		}
	}

	/**
	 * The method shall initialize the viewer with the data provided by the
	 * model, or close the editor on error.
	 * 
	 * The method can be invoked either before or after the UI has been
	 * constructed as the {@link #setInput(IEditorInput)} is called before the
	 * {@link #createPartControl(Composite)} but the job can finish early or
	 * later
	 * 
	 * @param model
	 * @param layerModel
	 * @param error
	 */
	void modelLoadDone(Job loadJob, EViewsEditorDocument document,
			Throwable error) {
		if (error != null) {
			// we simple close this editor..
			getSite().getPage().closeEditor(this, false);
			return;
		}
		this.document = document;

		// this.viewModel = model;
		// this.layerModel = layerModel;
		if (this.control != null) {
			updateViewer();
		}
	}

	/**
	 * Method shall update the viewer with the information from the View Model.
	 * 
	 * The method is called when both the viewer is created and the model has
	 * been loaded.
	 * 
	 * @see #viewModel
	 */
	private void updateViewer() {
		((ViewTreeViewerLabelProvider) (((DecoratingLabelProvider) viewTv
				.getLabelProvider()).getLabelProvider())).bindModel(document);

		// if (!viewModel.getViews().isEmpty()) {
		// view = viewModel.getViews().get(0);
		// }

		// confmlTv.setInput(SampleData.createApplicationModel(3, 4));
		// IMPROVEMENT
		// confmlTvFilter.setViewModel(viewModel);
		// confmlTvFilter.refresh();
		// 
		viewTv.setInput(document);
		// confmlTvFilter.refresh();
		confmlTv.setInput(document);
		getPreviewPage().update(document, getEditorInput());
	}

	/**
	 * Get the preview page. Create new one if required.
	 * 
	 * Preview page is initialized together with other editor parts.
	 * 
	 * @return Preview page.
	 */
	protected NavigatorPreviewPage getPreviewPage() {
		if (previewPage == null) {
			previewPage = new NavigatorPreviewPage(this);
		}
		return previewPage;
	}

	@Override
	public boolean isDirty() {
		return isDirty;
	}

	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}

	@Override
	public void createPartControl(Composite parent) {
		formToolkit = new FormToolkit(parent.getDisplay());
		control = formToolkit.createForm(parent);
		formToolkit.decorateFormHeading(control);
		control.setText("View Editor");
		control.getBody().setLayout(new FormLayout());

		Section leftSection = formToolkit.createSection(control.getBody(),
				Section.TITLE_BAR);
		ToolBar leftToolbar = new ToolBar(leftSection, SWT.FLAT);
		leftSection.setTextClient(leftToolbar);

		Composite leftComposite = formToolkit.createComposite(leftSection,
				SWT.NONE);
		leftSection.setClient(leftComposite);
		leftSection.setText("View Design Model");
		GridLayout gl = new GridLayout(1, false);
		gl.marginHeight = gl.marginWidth = 0;
		gl.marginBottom = 5;
		leftComposite.setLayout(gl);
		final Sash sash = new Sash(control.getBody(), SWT.VERTICAL);
		formToolkit.adapt(sash, false, false);
		sash.addMouseTrackListener(new MouseTrackAdapter() {
			public void mouseEnter(MouseEvent e) {
				sash.setBackground(formToolkit.getColors().getColor(
						IFormColors.SEPARATOR));
			}

			@Override
			public void mouseExit(MouseEvent e) {
				sash.setBackground(formToolkit.getColors().getBackground());
			}
		});

		Section rightSection = formToolkit.createSection(control.getBody(),
				Section.TITLE_BAR);
		rightSection.setText("Unallocated Settings");
		ToolBar rightToolbar = new ToolBar(rightSection, SWT.FLAT);
		rightSection.setTextClient(rightToolbar);

		Composite rightComposite = formToolkit.createComposite(rightSection,
				SWT.NONE);
		rightSection.setClient(rightComposite);
		gl = new GridLayout(1, false);
		gl.marginHeight = gl.marginWidth = 0;
		gl.marginBottom = 5;
		rightComposite.setLayout(gl);

		FormData formData;

		formData = new FormData();
		formData.top = new FormAttachment(0);
		formData.bottom = new FormAttachment(100);
		formData.left = new FormAttachment(0);
		formData.right = new FormAttachment(sash, 0);
		leftSection.setLayoutData(formData);

		formData = new FormData();
		formData.top = new FormAttachment(0);
		formData.bottom = new FormAttachment(100);
		formData.left = new FormAttachment(sash, 0);
		formData.right = new FormAttachment(100, 0);
		rightSection.setLayoutData(formData);

		formData = new FormData();
		formData.top = new FormAttachment(0);
		formData.bottom = new FormAttachment(100);
		formData.left = new FormAttachment(49);
		sash.setLayoutData(formData);

		sash.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int position = e.x;
				Sash sash = (Sash) e.widget;
				FormData formData = new FormData();
				formData.top = new FormAttachment(0);
				formData.bottom = new FormAttachment(100);
				formData.left = new FormAttachment(0, position);
				sash.setLayoutData(formData);
				sash.getParent().layout(true);
			}
		});

		TreeViewerFilterToolbar viewTreeToolbar = new TreeViewerFilterToolbar();
		viewTreeToolbar.createToolbar(leftToolbar, leftComposite, formToolkit);
		createViewTreeViewer(leftComposite);
		viewTreeToolbar.init(viewTv, viewPatternFilter);

		TreeViewerFilterToolbar confmlToolbar = new TreeViewerFilterToolbar();
		confmlToolbar.createToolbar(rightToolbar, rightComposite, formToolkit);
		createConfmlTreeViewer(rightComposite);
		confmlToolbar.init(confmlTv, confmlPatternFilter);

		Transfer[] types = new Transfer[] { LocalSelectionTransfer
				.getTransfer() };
		int operations = DND.DROP_MOVE | DND.DROP_COPY | DND.DROP_LINK;
		final DragSource source = new DragSource(confmlTv.getTree(), operations);
		source.setTransfer(types);
		source.addDragListener(new DragSourceAdapter() {
			public void dragStart(DragSourceEvent event) {
				ISelection selection = confmlTv.getSelection();
				if (!selection.isEmpty()) {
					event.doit = true;
					LocalSelectionTransfer.getTransfer()
							.setSelection(selection);
				} else {
					event.doit = false;
				}
			};
		});

		Transfer[] types2 = new Transfer[] { LocalSelectionTransfer
				.getTransfer() };
		int operations2 = DND.DROP_MOVE;
		final DragSource source2 = new DragSource(viewTv.getTree(), operations2);
		source2.setTransfer(types2);
		source2.addDragListener(new DragSourceAdapter() {
			public void dragStart(DragSourceEvent event) {
				ISelection selection = viewTv.getSelection();
				if (!selection.isEmpty()) {
					event.doit = true;
					LocalSelectionTransfer.getTransfer()
							.setSelection(selection);
				} else {
					event.doit = false;
				}
			};
		});

		DropTarget target = new DropTarget(viewTv.getTree(), operations);
		target.setTransfer(types);
		target.addDropListener(getDropTargetAdapter());

		createContextMenu();

		// Object[] input = {"Group1","Group2"};
		// navigator.setInput(input);

		confmlTv.setFilters(new ViewerFilter[] { confmlTvFilter,
				confmlPatternFilter });
		viewTv.setFilters(new ViewerFilter[] { viewPatternFilter });

		if (/* viewModel != null && */document != null) {
			// if the model has been loaded by this time, populate the UI data
			updateViewer();
		}

		CompositeSelectionProvider csp = new CompositeSelectionProvider(viewTv,
				confmlTv);
		getSite().setSelectionProvider(csp);
	}

	/**
	 * Drop adapter for Drag and Drop
	 * 
	 * @return
	 */
	private DropTargetAdapter getDropTargetAdapter() {
		return new DropTargetAdapter() {

			public void dragOver(DropTargetEvent event) {

				ISelection selection = LocalSelectionTransfer.getTransfer()
						.getSelection();
				if (!(selection instanceof IStructuredSelection)
						|| selection.isEmpty()) {
					event.feedback = DND.DROP_NONE;
					event.detail = DND.DROP_NONE;
					return;
				}

				Object[] dropped = ((IStructuredSelection) selection).toArray();

				// combined drops are not supported...
				boolean hadFeatureOrSettingOrReference = false;
				boolean hadGroup = false;
				boolean hadView = false;

				for (Object obj : dropped)
				{
					if (obj instanceof ESetting || obj instanceof EFeature
							|| obj instanceof EAppSetting
							|| obj instanceof EAppFeature) 
					{
						hadFeatureOrSettingOrReference = true;
						if (hadGroup)
						{
							event.feedback = DND.DROP_NONE;
							event.detail = DND.DROP_NONE;
							return;
						}
					} 
					else if (obj instanceof ESettingRef) 
					{
						if (!isFromRootView((EObject)obj))
						{
							event.feedback = DND.DROP_NONE;
							event.detail = DND.DROP_NONE;
							return;
						}
						hadFeatureOrSettingOrReference = true;
						if (hadGroup)
						{
							event.feedback = DND.DROP_NONE;
							event.detail = DND.DROP_NONE;
							return;
						}
					}
					else if (obj instanceof EGroup)
					{
						if (!isFromRootView((EObject)obj))
						{
							event.feedback = DND.DROP_NONE;
							event.detail = DND.DROP_NONE;
							return;
						}
						hadGroup = true;
						if (hadFeatureOrSettingOrReference) {
							event.feedback = DND.DROP_NONE;
							event.detail = DND.DROP_NONE;
							return;
						}
					}
					else if (obj instanceof EView)
					{
						if (!isViewUnderRoot((EObject)obj))
						{
							event.feedback = DND.DROP_NONE;
							event.detail = DND.DROP_NONE;
							return;
						}
						hadView = true;
					}
					else 
					{
						event.feedback = DND.DROP_NONE;
						event.detail = DND.DROP_NONE;
						return;
					}
				}

				if (event.item == null) {
					event.feedback = DND.DROP_NONE;
					event.detail = DND.DROP_NONE;
					return;
				}

				if (!hadFeatureOrSettingOrReference && !hadGroup && !hadView) {
					event.feedback = DND.DROP_NONE;
					event.detail = DND.DROP_NONE;
					return;
				}

				event.feedback = DND.FEEDBACK_EXPAND | DND.FEEDBACK_SCROLL;
				event.detail = DND.DROP_MOVE;

				TreeItem item = (TreeItem) event.item;
				
				Point pt = Display.getCurrent().map(null, viewTv.getTree(),
						event.x, event.y);
				Rectangle bounds = item.getBounds();

				// we are either dropping (moving) groups or refs
				if (hadGroup) {
					// only group and view selection is allowed
					if (item.getData() instanceof EGroup) {
						
						if (isFromRootView((EGroup)item.getData()))
						{
							if (pt.y < bounds.y + bounds.height / 3) {
								event.feedback |= DND.FEEDBACK_INSERT_BEFORE;
							} else if (pt.y > bounds.y + 2 * bounds.height / 3) {
								event.feedback |= DND.FEEDBACK_INSERT_AFTER;
							} else {
								event.feedback |= DND.FEEDBACK_SELECT;
							}
						}
						else
						{
							event.feedback = DND.DROP_NONE;
							event.detail = DND.DROP_NONE;
							return;
						}
					} else if (item.getData() instanceof EView) {
						if (pt.y < bounds.y + bounds.height / 3) {
							event.feedback |= DND.FEEDBACK_INSERT_BEFORE;
						} else if (pt.y > bounds.y + 2 * bounds.height / 3) {
							event.feedback |= DND.FEEDBACK_INSERT_AFTER;
						} else {
							event.feedback = DND.DROP_NONE;
							event.detail = DND.DROP_NONE;
							return;
						}
					} else {
						event.feedback = DND.DROP_NONE;
						event.detail = DND.DROP_NONE;
						return;
					}
				} 
				else if (hadView)
				{
					Object treeRootObject = viewTv.getTree().getItems()[0].getData();
					if (item.getData()==treeRootObject)
						event.feedback |= DND.FEEDBACK_SELECT;
					else if (item.getParentItem().getData() == treeRootObject) 
					{
						if (pt.y < bounds.y + bounds.height / 3) 
						{
							event.feedback |= DND.FEEDBACK_INSERT_BEFORE;
						}
						else if (pt.y > bounds.y + 2 * bounds.height / 3) 
						{
							event.feedback |= DND.FEEDBACK_INSERT_AFTER;
						}
						else 
						{
							event.feedback = DND.DROP_NONE;
							event.detail = DND.DROP_NONE;
							return;
						}
					}
					else 
					{
						event.feedback = DND.DROP_NONE;
						event.detail = DND.DROP_NONE;
						return;
					}
				}
				else 
				{
					// Group and another reference is allowed
					if (item.getData() instanceof EGroup) 
					{
						if (!isFromRootView((EGroup)item.getData()))
						{
							event.feedback = DND.DROP_NONE;
							event.detail = DND.DROP_NONE;
							return;
						}
						
						event.feedback |= DND.FEEDBACK_SELECT;
					} 
					else if (item.getData() instanceof ESettingRef) {
						
						if (!isFromRootView((ESettingRef)item.getData()))
						{
							event.feedback = DND.DROP_NONE;
							event.detail = DND.DROP_NONE;
							return;
						}
						
						if (pt.y < bounds.y + bounds.height / 2) {
							event.feedback |= DND.FEEDBACK_INSERT_BEFORE;
						} else {
							event.feedback |= DND.FEEDBACK_INSERT_AFTER;
						}
					} 
					else {
						event.feedback = DND.DROP_NONE;
						event.detail = DND.DROP_NONE;
						return;
					}
				}
			}

			public void dropAccept(DropTargetEvent event) {
			
				ISelection selection = LocalSelectionTransfer.getTransfer()
						.getSelection();
				if (selection instanceof IStructuredSelection) {
					IStructuredSelection s = (IStructuredSelection) selection;
					Object[] dropped = s.toArray();

					// combined drops are not supported...
					boolean hadFeatureOrSetting = false;
					boolean hadGroup = false;
					boolean hadSettingReference = false;
					boolean hadView = false;

					for (Object obj : dropped) {
						if (obj instanceof ESetting || obj instanceof EFeature
								|| obj instanceof EAppSetting
								|| obj instanceof EAppFeature) {
							hadFeatureOrSetting = true;

							if (hadGroup || hadSettingReference || hadView) {
								event.detail = DND.DROP_NONE;
								return;
							}
						} else if (obj instanceof EGroup) {
							hadGroup = true;

							if (hadFeatureOrSetting || hadSettingReference || hadView) {
								event.detail = DND.DROP_NONE;
								return;
							}
						} 
						else if (obj instanceof EView)
						{
							hadView = true;
							if (hadGroup || hadSettingReference || hadFeatureOrSetting) {
								event.detail = DND.DROP_NONE;
								return;
							}
						}
						else if (obj instanceof ESettingRef) {
							hadSettingReference = true;

							if (hadFeatureOrSetting || hadGroup) {
								event.detail = DND.DROP_NONE;
								return;
							}
						} else {
							event.detail = DND.DROP_NONE;
							return;
						}
					}

				} else {
					event.detail = DND.DROP_NONE;
				}
				isDirty = true;
			}

			public void drop(DropTargetEvent event) {
				ISelection selection = (ISelection) event.data;
				List<?> dropped = Collections.emptyList();
				if (selection instanceof IStructuredSelection) {
					IStructuredSelection s = (IStructuredSelection) selection;
					dropped = s.toList();
				}
				if (dropped.isEmpty()) {
					return;
				}

				TreeItem item = (TreeItem) event.item;
				Point pt = Display.getCurrent().map(null, viewTv.getTree(),
						event.x, event.y);
				Rectangle bounds = item.getBounds();
				int operation;
				if (pt.y < bounds.y + bounds.height / 3) {
					// prepend
					operation = DND.FEEDBACK_INSERT_BEFORE;
				} else if (pt.y > bounds.y + 2 * bounds.height / 3) {
					// append
					operation = DND.FEEDBACK_INSERT_AFTER;
				} else {
					// add child
					operation = DND.FEEDBACK_SELECT;
				}

				List<ESettingRef> added = new ArrayList<ESettingRef>(dropped.size());
				List<EGroup> movedGroups = new ArrayList<EGroup>(dropped.size());
				List<EView> movedViews = new ArrayList<EView>(dropped.size());
				List<ESettingRef> movedRefs = new ArrayList<ESettingRef>(dropped.size());
				List<EView> includedViews = new ArrayList<EView>(dropped.size());
				for (Object obj : dropped) {
					ESettingRef ref = null;
					if (obj instanceof EFeature) {
						EFeature feature = (EFeature) obj;
						// move only rest setting in feature
						//
						// final EMap<String, ESetting> map = feature
						// .getSettings();
						// EList<ESettingRef> foundedSettings =
						// getUnsortedSetting(
						// feature, item);
						// for (int i = 0; i < map.size(); i++) {
						// Entry<String, ESetting> entry = map.get(i);
						// ESetting setting = (ESetting) entry.getValue();
						// ref = EViewEditorFactory.eINSTANCE
						// .createESettingRef();
						// ref.setFeatureId(getObjectId(feature));
						// ref.setSettingId(getObjectId(setting));
						// boolean add = true;
						// for (ESettingRef set : foundedSettings) {
						// if (set.getSettingId() == ref.getSettingId()) {
						// add = false;
						// }
						// }
						// if (add) {
						// added.add(ref);
						// }
						// }
						ref = null;

						ref = EViewEditorFactory.eINSTANCE.createESettingRef();
						ref.setFeatureId(getObjectId(feature));
						ref.setSettingId("*");

					} else if (obj instanceof EAppFeature) {
						/*
						 * final EMap<String, ESetting> map =
						 * feature.getSettings(); for(int i=0;i<map.size();i++){
						 * Entry entry = map.get(i); ESetting setting =
						 * (ESetting)entry.getValue(); ref =
						 * EViewEditorFactory.eINSTANCE.createESettingRef();
						 * ref.setFeatureId(((EAppFeature)
						 * obj).getType().getId()); if(i==0){
						 * ref.setSettingId("*"+getObjectId(setting)); }else{
						 * ref.setSettingId(getObjectId(setting)); }
						 * added.add(ref); }
						 */

						ref = EViewEditorFactory.eINSTANCE.createESettingRef();
						ref.setFeatureId(ConverterUtils
								.getFeatureId((EAppFeature) obj));
						ref.setSettingId("*");
					} else if (obj instanceof ESetting) {
						ESetting setting = (ESetting) obj;
						if (setting.eContainer().eContainer() instanceof EFeature)
						{
							EFeature feature = (EFeature) setting.eContainer().eContainer();
							ref = EViewEditorFactory.eINSTANCE.createESettingRef();
							ref.setFeatureId(getObjectId(feature));
							ref.setSettingId(getObjectId(setting));
						}
						else if (setting.eContainer().eContainer() instanceof ESetting)
						{
							ESetting parentSetting = (ESetting) setting.eContainer().eContainer();
							EFeature feature = (EFeature) parentSetting.eContainer().eContainer();
							ref = EViewEditorFactory.eINSTANCE.createESettingRef();
							ref.setFeatureId(getObjectId(feature));
							ref.setSettingId(getObjectId(parentSetting)+"/"+getObjectId(setting));
						}

					} else if (obj instanceof EAppSetting) {
						EAppSetting setting = (EAppSetting) obj;
						EAppFeature feature = (EAppFeature) setting
								.eContainer();

						ref = EViewEditorFactory.eINSTANCE.createESettingRef();
						ref.setFeatureId(ConverterUtils.getFeatureId(feature));
						ref.setSettingId(ConverterUtils.getSettingId(setting));
					} else if (obj instanceof EGroup) {
						movedGroups.add((EGroup) obj);
					} else if (obj instanceof ESettingRef) {
						movedRefs.add((ESettingRef) obj);
					}
					else if (obj instanceof EView)
					{
						EView includedView = (EView)obj;
						if (includedView.eContainer() instanceof EView)
							movedViews.add(includedView);
						else
						{
							includedViews.add(copyView(includedView));
						}
					}
					if (ref != null) {
						added.add(ref);
					}
				}

				if (!added.isEmpty()) {
					Object data = item.getData();
					int index;
					EGroup parentGroup;
					if (data instanceof ESettingRef) {
						ESettingRef ref = (ESettingRef) data;
						parentGroup = (EGroup) ref.eContainer();

						if (operation == DND.FEEDBACK_INSERT_BEFORE) {
							index = parentGroup.getRefs().indexOf(ref);
						} else {
							index = parentGroup.getRefs().indexOf(ref) + 1;
						}
					} else if (data instanceof EGroup) {
						parentGroup = (EGroup) data;
						index = parentGroup.getRefs().size();
					} else {
						return;
					}

					AddSettingCommand addSettingCommand = new AddSettingCommand(
							ViewsEditor.this, parentGroup, index, ArrayUtils
									.createCopy(ESettingRef.class, added));
					getCommandStack().execute(addSettingCommand);
					refreshConfmlTree();
				}
				if (!movedViews.isEmpty())
				{
					Object data = item.getData();
					int index;
					EGroupContainer parentContainer;
					if (data instanceof EView) {
						switch (operation) {
						case DND.FEEDBACK_INSERT_AFTER:
							parentContainer = (EGroupContainer)((EView) data).eContainer();
							index = parentContainer.getGroupsAndViews().indexOf(data) + 1;
							break;
						case DND.FEEDBACK_INSERT_BEFORE:
							parentContainer = (EGroupContainer)((EView) data).eContainer();
							index = parentContainer.getGroupsAndViews().indexOf(data);
							break;
						default:
							return;
						}
					} else if (data instanceof EGroup) {
						switch (operation) {
						case DND.FEEDBACK_INSERT_AFTER:
							parentContainer = (EGroupContainer) ((EGroup) data).eContainer();
							index = parentContainer.getGroupsAndViews().indexOf(data) + 1;
							break;
						case DND.FEEDBACK_INSERT_BEFORE:
							parentContainer = (EGroupContainer) ((EGroup) data).eContainer();
							index = parentContainer.getGroupsAndViews().indexOf(data);
							break;
						default:
							return;
						}
					} else {
						return;
					}
					Set<EGroupContainer> stack = new HashSet<EGroupContainer>();
					EGroupContainer ptr = parentContainer;
					while (!(ptr instanceof EView)) {
						stack.add(ptr);
						ptr = (EGroupContainer) ptr.eContainer();
					}
					boolean error = false;
					if (!stack.isEmpty()) {
						error = stack.removeAll(movedGroups);
					}
					if (!error) {
						MoveViewsCommand command = new MoveViewsCommand(
								ViewsEditor.this, parentContainer, index,
								movedViews);
						getCommandStack().execute(command);
					}
				}
				if (!movedGroups.isEmpty()) {
					// moving group(s)

					Object data = item.getData();
					int index;
					EGroupContainer parentContainer;

					if (data instanceof EView) {
						switch (operation) {
						case DND.FEEDBACK_INSERT_AFTER:
							parentContainer = (EGroupContainer)((EView) data).eContainer();
							index = parentContainer.getGroupsAndViews().indexOf(data) + 1;
							break;
						case DND.FEEDBACK_INSERT_BEFORE:
							parentContainer = (EGroupContainer)((EView) data).eContainer();
							index = parentContainer.getGroupsAndViews().indexOf(data);
							break;
						default:
							return;
						}
					} else if (data instanceof ESettingRef) {
						parentContainer = (EGroup) ((ESettingRef) data)
								.eContainer();
						index = parentContainer.getGroupsAndViews().size();
					} else if (data instanceof EGroup) {
						switch (operation) {
						case DND.FEEDBACK_SELECT:
							parentContainer = (EGroup) data;
							index = parentContainer.getGroupsAndViews().size();
							break;
						case DND.FEEDBACK_INSERT_AFTER:
							parentContainer = (EGroupContainer) ((EGroup) data)
									.eContainer();
							index = parentContainer.getGroupsAndViews().indexOf(data) + 1;
							break;
						case DND.FEEDBACK_INSERT_BEFORE:
							parentContainer = (EGroupContainer) ((EGroup) data)
									.eContainer();
							index = parentContainer.getGroupsAndViews().indexOf(data);
							break;
						default:
							return;
						}
					} else {
						return;
					}
					Set<EGroupContainer> stack = new HashSet<EGroupContainer>();
					EGroupContainer ptr = parentContainer;
					while (!(ptr instanceof EView)) {
						stack.add(ptr);
						ptr = (EGroupContainer) ptr.eContainer();
					}
					boolean error = false;
					if (!stack.isEmpty()) {
						error = stack.removeAll(movedGroups);
					}
					if (!error) {
						MoveGroupsCommand command = new MoveGroupsCommand(
								ViewsEditor.this, parentContainer, index,
								movedGroups);
						getCommandStack().execute(command);
					}
				}
				if (!movedRefs.isEmpty()) {
					// moving references
					Object data = item.getData();
					int index;
					EGroup parentContainer;
					if (data instanceof ESettingRef) {
						parentContainer = (EGroup) ((ESettingRef) data)
								.eContainer();
						switch (operation) {
						case DND.FEEDBACK_SELECT:
						case DND.FEEDBACK_INSERT_AFTER:
							index = parentContainer.getRefs().indexOf(data) + 1;
							break;
						case DND.FEEDBACK_INSERT_BEFORE:
							index = parentContainer.getRefs().indexOf(data);
							break;
						default:
							return;
						}
					} else if (data instanceof EGroup) {
						parentContainer = (EGroup) data;
						index = parentContainer.getRefs().size();
					} else {
						return;
					}
					MoveRefsCommand command = new MoveRefsCommand(
							ViewsEditor.this, parentContainer, index, movedRefs);
					try {
						getCommandStack().execute(command);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
				if (!includedViews.isEmpty())
				{
					Object data = item.getData();
					int index = -1;
					EGroupContainer parentContainer = null;
					if (data instanceof EView)
					{
						switch (operation) {
						case DND.FEEDBACK_SELECT:
							parentContainer = (EView) data;
							index = parentContainer.getGroupsAndViews().size();
							break;
						case DND.FEEDBACK_INSERT_AFTER:
							parentContainer = (EGroupContainer) ((EView) data)
									.eContainer();
							index = parentContainer.getGroupsAndViews().indexOf(data) + 1;
							break;
						case DND.FEEDBACK_INSERT_BEFORE:
							parentContainer = (EGroupContainer) ((EView) data)
									.eContainer();
							index = parentContainer.getGroupsAndViews().indexOf(data);
							break;
						default:
							return;
						}
					}
					else if (data instanceof EGroup)
					{
						switch (operation) {
						case DND.FEEDBACK_SELECT:
							parentContainer = (EGroup) data;
							index = parentContainer.getGroupsAndViews().size();
							break;
						case DND.FEEDBACK_INSERT_AFTER:
							parentContainer = (EGroupContainer) ((EGroup) data)
									.eContainer();
							index = parentContainer.getGroupsAndViews().indexOf(data) + 1;
							break;
						case DND.FEEDBACK_INSERT_BEFORE:
							parentContainer = (EGroupContainer) ((EGroup) data)
									.eContainer();
							index = parentContainer.getGroupsAndViews().indexOf(data);
							break;
						default:
							return;
						}
					}
					if (parentContainer!=null && index != -1)
					{

						IncludeViewCommand command = new IncludeViewCommand(
								ViewsEditor.this, parentContainer, index,
								includedViews);
						getCommandStack().execute(command);
						refreshConfmlTree();
						
					}
				}
			}
		};

	}

	private EView copyView(EView originalView)
	{
		return (EView)EcoreUtil.copy(originalView);
	}
	
	

	
	/**
	 * Find all settings in tree with feature's id
	 * 
	 * @param input
	 *            EFeature = feature which setting you find
	 * @param item
	 *            any item from tree
	 * @return List with founded settings
	 */
	public static EList<ESettingRef> getUnsortedSetting(Object input,
			TreeItem item) {
		EList<ESettingRef> foundedSettings = new BasicEList<ESettingRef>();
		if (input instanceof EFeature) {
			EFeature feature = (EFeature) input;
			Object data = item.getData();
			EGroup parentGroup = null;
			EView view = null;
			if (data instanceof ESettingRef) {
				ESettingRef ref = (ESettingRef) data;
				parentGroup = (EGroup) ref.eContainer();
			} else if (data instanceof EGroup) {
				parentGroup = (EGroup) data;
			}
			if (parentGroup != null) {
				Object o = parentGroup.eContainer();
				while (!(o instanceof EView)) {
					o = ((EGroup) o).eContainer();
					if (o == null)
						return null;
				}
				view = (EView) o;
				EList<EGroup> group = view.getGroups();
				EGroup[] array = new EGroup[group.size()];
				group.toArray(array);
				EList<EGroup> subgroups = new BasicEList<EGroup>();
				for (int i = 0; i < array.length; i++) {
					EList<EGroup> subgroupFromOneGroup = array[i].getGroups();
					for (EGroup subgroup : subgroupFromOneGroup) {
						subgroups.add(subgroup);
					}
				}
				// this add groups to subgroups list
				// =groups are searched for settings too
				subgroups.addAll(group);
				for (EGroup subgroup : subgroups) {
					EList<ESettingRef> listSetting = subgroup.getRefs();
					for (ESettingRef setting : listSetting) {
						if (setting.getFeatureId() == getObjectId(feature)) {
							foundedSettings.add(setting);
						}
					}
				}
			}
		}
		return foundedSettings;
	}

	static String getObjectId(EObject object) {
		if (object instanceof ESetting || object instanceof EFeature) {
			Map.Entry<?, ?> entry = (Map.Entry<?, ?>) object.eContainer();
			return (String) entry.getKey();
		}
		return null;
	}

	private void createConfmlTreeViewer(Composite parent) {
		confmlTv = new ConfmlTreeViewer(parent, SWT.MULTI | SWT.BORDER);
		confmlTv.getTree().setLayoutData(new GridData(GridData.FILL_BOTH));
		confmlTv.setContentProvider(new ConfmlTreeViewerContentProvider());
		ConfmlTreeViewerLabelProvider labelProvider = new ConfmlTreeViewerLabelProvider();
		confmlTv.setLabelProvider(new DecoratingLabelProvider(labelProvider,
				PlatformUI.getWorkbench().getDecoratorManager()
						.getLabelDecorator()));
		confmlTv.setSorter(new ViewerSorter());
		confmlTv.setAutoExpandLevel(1);
		confmlTv.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				ISelection selection = event.getSelection();
				if (selection.isEmpty()
						|| !(selection instanceof IStructuredSelection)) {
					return;
				}

				Object selected = ((IStructuredSelection) selection)
						.getFirstElement();
				if (selected == null) {
					return;
				}
				if (selected instanceof ESettingRef) {
					selected = ((ESettingRef) selected).getTarget();
				}
				if (selected instanceof EResourceLocator) {
					String uri = ((EResourceLocator) selected).getResourceUri();
					// EConfMLResource res =
					// EditorUtils.getConfMLResource((EObject)selected);
					// EditorUtils.openEditor(uri, null);
				} else {
					return;
				}
			}
		});
	}

	private void createViewTreeViewer(Composite parent) {
		viewTv = new ViewTreeViewer(parent, SWT.MULTI | SWT.BORDER);
		viewTv.getTree().setLayoutData(new GridData(GridData.FILL_BOTH));
		viewTv.setContentProvider(new ViewTreeViewerContentProvider());
		ViewTreeViewerLabelProvider labelProvider = new ViewTreeViewerLabelProvider();
		labelProvider.setViewer(viewTv);
		viewTv.setLabelProvider(new DecoratingLabelProvider(labelProvider,
				PlatformUI.getWorkbench().getDecoratorManager()
						.getLabelDecorator()));

		viewTv.setAutoExpandLevel(2);
		viewTv.getTree().addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				switch (e.keyCode) {
				case SWT.DEL:
					// do not use action here...

					IStructuredSelection selection = (IStructuredSelection) viewTv
							.getSelection();
					if (selection.isEmpty()) {
						return;
					}
					Object[] selected = selection.toArray();

					List<EObject> list = new ArrayList<EObject>();
					for (Object o : selected) {
						if (isFromRootView((EObject)o) && (o instanceof EGroup || o instanceof ESettingRef)) {
							list.add((EObject) o);
						}
						else if (isViewUnderRoot((EObject)o) && o instanceof EView)
						{
							list.add((EObject) o);
						}
					}
					if (!list.isEmpty()) {
						DeleteCommand dc = new DeleteCommand(ViewsEditor.this,
								list);
						getCommandStack().execute(dc);
					}

					break;
				default:
					break;
				}
			}
		});

		viewTv.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				ISelection selection = event.getSelection();
				if (selection.isEmpty()
						|| !(selection instanceof IStructuredSelection)) {
					return;
				}

				Object selected = ((IStructuredSelection) selection)
						.getFirstElement();
				if (selected == null) {
					return;
				}
				if (selected instanceof ESettingRef) {
					selected = ((ESettingRef) selected).getTarget();
				}
				if (selected instanceof EResourceLocator) {
					// URI uri = ((EResourceLocator) selected).getResourceUri();
					// EConfMLResource res =
					// EditorUtils.getConfMLResource((EObject)selected);
					// EditorUtils.openEditor(uri, null);
				} else {
					return;
				}
			}
		});

	}

	private void createContextMenu() {

		final OpenConfMLViewEditor openViewAction = new OpenConfMLViewEditor(this);
		final DeleteAction deleteAction = new DeleteAction(this);
		final RenameAction renameAction = new RenameAction(getCommandStack(),
				viewTv);
		final AddGroupAction addSubGroupAction = new AddGroupAction(this,
				GroupType.CHILD_GROUP);
		final AddGroupAction addGroupAction = new AddGroupAction(this,
				GroupType.SIBLING_GROUP);
		final PropertiesAction propertiesAction = new PropertiesAction(viewTv);
		final ExpandSettingRefAction expandSettingRef = new ExpandSettingRefAction(
				this);

		final AddPropertyAction addPropertyAction = new AddPropertyAction(this);
		final AddOptionAction addOptionAction = new AddOptionAction(this);
		
		
		final MenuManager subMenu = new MenuManager(Messages.Add_new);
		subMenu.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				if (viewTv.getSelection().equals(StructuredSelection.EMPTY)) {
					return;
				}
				TreeItem te = viewTv.getTree().getSelection()[0];
				if (te.getData() instanceof EView) {
					subMenu.removeAll();
					subMenu.add(addSubGroupAction);
					if (te.getParentItem()==null)
						addSubGroupAction.setEnabled(true);
					else
						addSubGroupAction.setEnabled(false);
				} else if ((te.getData() instanceof EGroup)
						&& (te.getParentItem().getData() instanceof EView)) {
					subMenu.removeAll();
					subMenu.add(addSubGroupAction);
					subMenu.add(addGroupAction); 
					addSubGroupAction.setEnabled(true);
						
				} else if ((te.getData() instanceof ESettingRef)) {
					subMenu.removeAll();
					manager.add(addOptionAction);
					manager.add(addPropertyAction);
				} else {
					subMenu.removeAll();
					subMenu.add(addGroupAction);
				}
			}
		});
		subMenu.add(addGroupAction);

		MenuManager popupMenu = new MenuManager();
		popupMenu.setRemoveAllWhenShown(true);
		popupMenu.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				if (viewTv.getSelection().equals(StructuredSelection.EMPTY)) {
					return;
				}
				TreeItem te = viewTv.getTree().getSelection()[0];
				if ((te.getData() instanceof EView)) { // View
					manager.removeAll();
					if (isFromRootView((EView)te.getData()))
					{
						manager.add(subMenu);
						manager.add(new Separator());
					}
					else if (isViewUnderRoot((EView)te.getData()))
					{
						manager.add(openViewAction);
						manager.add(deleteAction);
					}
					else
						manager.add(openViewAction);
					
					manager.add(propertiesAction);
				} else if ((te.getData() instanceof EGroup) // Group
						&& (te.getParentItem().getData() instanceof EView)) {
					manager.removeAll();
					if (isFromRootView((EGroup)te.getData()))
					{
						manager.add(subMenu);
						manager.add(renameAction);
						manager.add(deleteAction);
						manager.add(new Separator());
					}
					manager.add(propertiesAction);
				} else if ((te.getData() instanceof EGroup)) { // SubGroup
					manager.removeAll();
					if (isFromRootView((EGroup)te.getData()))
					{
						manager.add(subMenu);
						manager.add(renameAction);
						manager.add(deleteAction);
						manager.add(new Separator());
					}
					manager.add(propertiesAction);
				} else if ((te.getData() instanceof ERefOption)) { // Option
					manager.removeAll();
					if (isFromRootView((ERefOption)te.getData()))
					{
						manager.add(deleteAction);
						manager.add(new Separator());
					}
					manager.add(propertiesAction);
				} else if ((te.getData() instanceof ERefProperty)) { // Option
					manager.removeAll();
					if (isFromRootView((ERefProperty)te.getData()))
					{
						manager.add(deleteAction);
						manager.add(new Separator());
					}
					manager.add(propertiesAction);
				} else if ((te.getData() instanceof ESettingRef)) { // Ref
					manager.removeAll();
					if (isFromRootView((ESettingRef)te.getData()))
					{
						manager.add(subMenu);
						manager.add(deleteAction);
						ESettingRef ref = (ESettingRef) te.getData();
						if (ref.getSettingId().equals("*")) {
							manager.add(expandSettingRef);
						} else {
						}
						manager.add(new Separator());
					}
					manager.add(propertiesAction);
				} else { // Setting
					manager.removeAll();
					// manager.add(deleteAction);
					//manager.add(new Separator());
					manager.add(propertiesAction);
				}
			}
		});

		Menu menu = popupMenu.createContextMenu(viewTv.getControl());
		viewTv.getControl().setMenu(menu);
	}

	private boolean isViewUnderRoot(EObject view)
	{
		if (view.eContainer().eContainer() instanceof EViewEntryImpl || 
				view.eContainer() instanceof EViewsEditorDocument)
			return true;
		else 
			return false;
	}
	
	private boolean isFromRootView(EObject entry)
	{
		if (entry instanceof EView)
		{
			if (entry.eContainer() instanceof EView)
				return false;
			else 
				return true;
		}
		else
		{
			return isFromRootView(entry.eContainer());
		}
	}
	
	@Override
	public void setFocus() {
		control.setFocus();
	}

	public boolean isColors() {
		return colors;
	}

	public void setColors(boolean colors) {
		this.colors = colors;
	}

	public CommandStack getCommandStack() {
		return stack;
	}

	protected void setDirty(final boolean dirty) {
		isDirty = dirty;
		firePropertyChange(IEditorPart.PROP_DIRTY);
	}

	public void registerStackAction(IAction stackAction) {
		actionList.add(stackAction);

	}

	public ActionRegistry getActionRegistry() {
		return actionRegistry;
	}

	/**
	 * Adds an <code>CommandStack</code> action to this editor.
	 * <p>
	 * <code>CommandStack</code> actions are actions that depend and work on the
	 * <code>CommandStack</code>.
	 * 
	 * @param action
	 *            the <code>CommandStack</code> action
	 */
	protected void registerCommandStackAction(StackAction action) {
		actionRegistry.registerAction(action);
		stackActionIDs.add(action.getId());
	}

	/**
	 * Creates actions and registers them to the ActionRegistry.
	 */
	protected void createActions() {
		registerCommandStackAction(new UndoAction(this));
		registerCommandStackAction(new RedoAction(this));
		undoContext = new ObjectUndoContext(this);
		undoAction = new UndoActionHandler(getSite(), undoContext);
		redoAction = new RedoActionHandler(getSite(), undoContext);

	}

	@Override
	public void dispose() {
		stack.removeCommandStackListener(commandStackListener);
		actionRegistry.dispose();
		actionRegistry = null;

		stack = null;
		undoAction.dispose();
		redoAction.dispose();
		stackActionIDs.clear();
		actionList.clear();

		if (document != null) {
			ViewsEditorPlugin.getVEDocumentManager().releaseDocument(document);
			document = null;
		}
		propertySheetPage = null;
		super.dispose();
	}

	@SuppressWarnings("unchecked")
	public Object getAdapter(final Class adapter) {

		if (IPropertySheetPage.class.equals(adapter)) {
			if (propertySheetPage == null
					|| propertySheetPage.getWidgetFactory() == null) {
				propertySheetPage = new TabbedPropertySheetPage(this);
			}
			return propertySheetPage;
		}
		if (adapter == ActionRegistry.class) {
			return actionRegistry;
		}
		if (adapter == CommandStack.class) {
			if (stack == null) {
				return new CommandStack();// needed for save as
			}
			return stack;
		}
//		if (adapter == IPreviewViewPage.class) {
//			return getPreviewPage();
//		}

		if (adapter == ViewTreeViewer.class) {
			return viewTv;
		}
		return super.getAdapter(adapter);
	}

	public String getContributorId() {
		return PROPERTIES_CONTRIBUTOR_ID;
	}

	// public void updateFilters() {
	// // confmlTvFilter.refresh();
	// // confmlTv.refresh();
	// }

	public Control getControl() {
		return control;
	}

	public ViewTreeViewer getViewTv() {
		return viewTv;
	}

	public void gotoMarker(IMarker marker) {
		IViewPart navigator = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage().findView(
						"org.eclipse.ui.views.ResourceNavigator");
		if (navigator != null && marker.getResource() != null) {
			navigator.getViewSite().getSelectionProvider().setSelection(
					new StructuredSelection(marker.getResource()));
		}

	}

	public void refreshConfmlTree() {
		// enabled
		confmlTv.refresh();
	}

	public void refreshConfmlTree(List<?> parentsOfObjectsToRemove) {
		confmlTv.remove(parentsOfObjectsToRemove.toArray());
	}
}
