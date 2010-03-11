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
 * Description: This file is part of com.nokia.tools.variant.resourcelibrary component.
 */

package com.nokia.tools.variant.resourcelibrary.views;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.commands.CommandStackEvent;
import org.eclipse.gef.commands.CommandStackEventListener;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.layout.TreeColumnLayout;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.util.SafeRunnable;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IPostSelectionProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TreeEditor;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.DropTargetAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.swt.dnd.FileTransfer;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionContext;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.part.IContributedContentsView;
import org.eclipse.ui.part.IPageSite;
import org.eclipse.ui.part.Page;
import org.eclipse.ui.part.ResourceTransfer;

import com.nokia.tools.variant.content.confml.FilePath;
import com.nokia.tools.variant.content.confml.SimpleSetting;
import com.nokia.tools.variant.resourcelibrary.actions.OpenEditorAction;
import com.nokia.tools.variant.resourcelibrary.actions.RefreshAction;
import com.nokia.tools.variant.resourcelibrary.actions.ResourceLibraryActionGroup;
import com.nokia.tools.variant.resourcelibrary.handlers.commands.CopyResourcesCommand;
import com.nokia.tools.variant.resourcelibrary.handlers.commands.ImportCommand;
import com.nokia.tools.variant.resourcelibrary.handlers.commands.MoveCommand;
import com.nokia.tools.variant.resourcelibrary.handlers.commands.RenameCommand;
import com.nokia.tools.variant.resourcelibrary.handlers.commands.ResourceLibraryCommandHelper;
import com.nokia.tools.variant.resourcelibrary.model.Directory;
import com.nokia.tools.variant.resourcelibrary.model.File;
import com.nokia.tools.variant.resourcelibrary.model.FileSystemElement;
import com.nokia.tools.variant.resourcelibrary.model.ResourceModelRoot;
import com.nokia.tools.variant.resourcelibrary.resources.ResourceUtil;

public class ResourceLibraryPage extends Page implements IResourceLibraryPage,
		ISelectionProvider, IPostSelectionProvider, ISelectionListener,
		IContributedContentsView, IAdaptable {

	public static final String SIZE_COLUMN_TEXT = "Size";
	public static final String TYPE_COLUMN_TEXT = "Type";
	public static final String NAME_COLUMN_TEXT = "Name";
	public static final String NOTE_COLUMN_TEXT = "Note";

	private Composite treeComposite;
	private TreeViewer viewer;
	private SimpleResourceComparator sortProvider;
	private IResourceLibraryContentProvider provider;

	/** Last selection object source */
	private IWorkbenchPart contributor;

	private MenuManager menuMgr;

	private ResourceLibraryActionGroup actionGroup;

	private ResourceModelRoot resorceModelRoot;

	private CommandStackEventListener commandStackEventListener = new CommandStackEventListener() {
		public void stackChanged(CommandStackEvent event) {
			if (event.isPostChangeEvent()) {
				if (ResourceLibraryCommandHelper
						.containsResourceLibraryCommand(event.getCommand())) {
					if (!viewer.getControl().isDisposed()) {
						viewer.refresh(true);
					}
				}
			}
		};
	};

	/**
	 * The constructor.
	 * 
	 */
	public ResourceLibraryPage(IWorkbenchPart contributor,
			IResourceLibraryContentProvider provider) {

		this.provider = provider;
		this.contributor = contributor;
	}

	/**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 */
	public void createControl(Composite parent) {
		// Create new composite for nesting the tree & its layout data
		treeComposite = new Composite(parent, SWT.NONE);

		// Create tree viewer
		viewer = new TreeViewer(treeComposite, SWT.MULTI | SWT.H_SCROLL
				| SWT.V_SCROLL);

		viewer.setContentProvider(provider);
		viewer.setLabelProvider(new ResourceLibraryTableLabelProvider());

		final Tree resourceTree = viewer.getTree();
		resourceTree.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent event) {
				actionGroup.handleKeyPressed(event);
			}
		});

		// Create columns
		TreeColumn nameCol = new TreeColumn(resourceTree, SWT.NONE);
		nameCol.setAlignment(SWT.LEFT);
		nameCol.setText(NAME_COLUMN_TEXT);
		nameCol.setWidth(150);

		TreeColumn typeCol = new TreeColumn(resourceTree, SWT.NONE);
		typeCol.setAlignment(SWT.RIGHT);
		typeCol.setText(SIZE_COLUMN_TEXT);
		typeCol.setWidth(50);

		TreeColumn noteCol = new TreeColumn(resourceTree, SWT.NONE);
		noteCol.setAlignment(SWT.CENTER);
		noteCol.setText(NOTE_COLUMN_TEXT);
		noteCol.setWidth(9);

		// Hook up column selection listeners for sorting
		sortProvider = new SimpleResourceComparator(viewer);
		viewer.setComparator(sortProvider);
		nameCol.addSelectionListener(sortProvider);
		typeCol.addSelectionListener(sortProvider);
		noteCol.addSelectionListener(sortProvider);

		// Set tree layout properties
		resourceTree.setHeaderVisible(true);
		resourceTree.setLinesVisible(true);
		TreeColumnLayout treeLayout = new TreeColumnLayout();
		treeComposite.setLayout(treeLayout);

		treeLayout.setColumnData(nameCol, new ColumnWeightData(80, 100, true));
		treeLayout.setColumnData(typeCol, new ColumnWeightData(20, 50, true));
		treeLayout.setColumnData(noteCol, new ColumnWeightData(9, 9, true));

		// Fetch a handle to file system.
		// viewer.setInput(this.getSite());
		hookDoubleClickAction();

		// Add drag & drop capability
		initDragAndDrop();

		// Set the selection to first element in the tree
		resorceModelRoot = (ResourceModelRoot) contributor
				.getAdapter(ResourceModelRoot.class);

		if (resorceModelRoot != null) {
			viewer.setInput(resorceModelRoot);
		}
		// Set selection provider
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(final SelectionChangedEvent event) {

				ISelection selection = createAdaptableSelection(event
						.getSelection());
				sendSelectionEvent(selection);
				updateMainMenu(selection);
			}

			private void updateMainMenu(ISelection selection2) {
				if (selection2.isEmpty()) {
					actionGroup.getDeleteResourceAction().setEnabled(false);
					actionGroup.getCopyResourceAction().setEnabled(false);
					actionGroup.getMoveResourceAction().setEnabled(false);
				} else {
					if (selection2 instanceof IStructuredSelection) {
						IStructuredSelection structuredSelection = (IStructuredSelection) selection2;
						Object object = structuredSelection.getFirstElement();

						if (object instanceof ResourceStorage) {
							ResourceStorage resourceStorage = (ResourceStorage) object;
							if (!resourceStorage.getFileSystemElement().isReadOnly()) {
//								actionGroup.getDeleteResourceAction()
//										.setEnabled(true);
//								actionGroup.getMoveResourceAction().setEnabled(
//										true);
							}
							actionGroup.getCopyResourceAction()
									.setEnabled(true);
						}
					}
				}
			}
		});
		viewer.addPostSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(final SelectionChangedEvent event) {
				sendPostSelectionEvent(createAdaptableSelection(event
						.getSelection()));
			}
		});

		// Create context menu
		menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				populateMenu(manager);
			}
		});
		Menu menu = menuMgr.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu("#PopupMenu", menuMgr, this);

		contributeToActionBars();
		viewer.setSelection(StructuredSelection.EMPTY);

		final TreeEditor editor = new TreeEditor(viewer.getTree());
		editor.horizontalAlignment = SWT.LEFT;
		editor.grabHorizontal = true;

		viewer.getControl().addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent event) {
				if (event.keyCode == SWT.F2 && event.stateMask == 0
						&& viewer.getTree().getSelectionCount() == 1) {
					event.doit = false;

					final TreeItem item = viewer.getTree().getSelection()[0];
					final FileSystemElement fes = (FileSystemElement) item
							.getData();
					if (!canRenameElement(fes)) {
						return;
					}

					final Text text = new Text(viewer.getTree(), SWT.NONE);
					text.setText(item.getText());
					text.selectAll();
					text.setFocus();

					text.addFocusListener(new FocusAdapter() {
						public void focusLost(FocusEvent event) {
							updateElementName(fes, text.getText());
							text.dispose();
						}
					});

					text.addKeyListener(new KeyAdapter() {
						public void keyPressed(KeyEvent event) {
							switch (event.keyCode) {
							case SWT.CR:
								updateElementName(fes, text.getText());
							case SWT.ESC:
								text.dispose();
								break;
							}
						}
					});
					editor.setEditor(text, item);
				}
			}
		});

		getCommandStack().addCommandStackEventListener(
				commandStackEventListener);
	}

	void updateElementName(FileSystemElement element, String newName) {
		Directory parent = (Directory) element.eContainer();
		if (Path.EMPTY.isValidSegment(newName)
				&& parent.getChild(newName) == null) {
			Command cmd = RenameCommand.createRenameCommand(element, newName);
			if (cmd.canExecute()) {
				getCommandStack().execute(cmd);
			} else {
				cmd.dispose();
			}
		}
	}

	protected void populateMenu(IMenuManager manager) {
		this.actionGroup.fillContextMenu(menuMgr);
	}

	private void initDragAndDrop() {
		int ops = DND.DROP_COPY | DND.DROP_MOVE;
		Transfer[] copyTransfers = new Transfer[] {
				LocalSelectionTransfer.getTransfer(),
				FileTransfer.getInstance(), TextTransfer.getInstance() };

		Transfer[] transfers = new Transfer[] {
				LocalSelectionTransfer.getTransfer(),
				ResourceTransfer.getInstance(), FileTransfer.getInstance(),
				TextTransfer.getInstance() };
		DragSourceListener dragListener = new DragSourceListener() {

			public void dragFinished(DragSourceEvent event) {
				LocalSelectionTransfer.getTransfer().setSelection(null);

				if (event.doit && event.detail == DND.DROP_TARGET_MOVE) {
					new RefreshAction(ResourceLibraryPage.this).run();
					refresh();
				}
			}

			public void dragSetData(DragSourceEvent event) {
				// use local selection transfer if possible
				IStructuredSelection selection = (IStructuredSelection) LocalSelectionTransfer
						.getTransfer().getSelection();

				DnDStorage.setData((IStructuredSelection) selection);

				if (LocalSelectionTransfer.getTransfer().isSupportedType(
						event.dataType)) {
					event.data = selection;
					return;
				}

				// resort to a file transfer
				if (FileTransfer.getInstance().isSupportedType(event.dataType)) {

					FileSystemElement[] selected = getSelectedFiles(selection);
					ResourceModelRoot root = (ResourceModelRoot) viewer
							.getInput();
					IPath rootFile = new Path(root.getTempDirPath());

					String[] files = new String[selected.length];
					int c = 0;
					for (FileSystemElement element : selected) {
						String path = rootFile.append(element.getPath2())
								.toOSString();
						files[c++] = path;
					}

					event.data = files;

					return;
				}

				if (TextTransfer.getInstance().isSupportedType(event.dataType)) {
					FileSystemElement[] selected = getSelectedFiles(selection);
					StringBuffer tmp = new StringBuffer();
					ResourceModelRoot root = (ResourceModelRoot) viewer
							.getInput();
					IPath rootFile = new Path(root.getTempDirPath());
					for (FileSystemElement element : selected) {
						String path = rootFile.append(element.getPath2())
								.toOSString();
						tmp.append(path).append('\n');
					}
					String string = tmp.length() == 0 ? "" : tmp.substring(0,
							tmp.length() - 1);
					event.data = string;
				}

			}

			public void dragStart(DragSourceEvent event) {
				ISelection selection = viewer.getSelection();
				if (selection.isEmpty()) {
					event.doit = false;
					return;
				}
				LocalSelectionTransfer.getTransfer().setSelection(selection);

			}
		};

		viewer.addDragSupport(ops, copyTransfers, dragListener);

		DropTargetListener adapter = new DropTargetAdapter() {

			public void drop(DropTargetEvent event) {
				CommandStack stack = (CommandStack) PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getActivePage()
						.getActiveEditor().getAdapter(CommandStack.class);

				Command cmd = createStackCommand(event);

				if (cmd.canExecute()) {
					stack.execute(cmd);
				} else {
					cmd.dispose();
				}
			}

			public void dropAccept(DropTargetEvent event) {
				// Command cmd = createStackCommand(event);
				// if (!cmd.canExecute()) {
				// event.detail = DND.DROP_NONE;
				// event.feedback = DND.FEEDBACK_NONE;
				// }
				// cmd.dispose();
			}

			private Command createStackCommand(DropTargetEvent event) {
				Command cmd = UnexecutableCommand.INSTANCE;

				Directory destination = getDestination(event.item != null ? event.item
						.getData()
						: resorceModelRoot);
				// Local transfer
				if (LocalSelectionTransfer.getTransfer().isSupportedType(
						event.currentDataType)) {
					IStructuredSelection selection = (IStructuredSelection) LocalSelectionTransfer
							.getTransfer().getSelection();
					FileSystemElement[] selected = getSelectedFiles(selection);
					if (event.detail == DND.DROP_COPY) {
						cmd = CopyResourcesCommand.createCopyCommand(
								destination, Arrays.asList(selected));
					} else if (event.detail == DND.DROP_MOVE) {
						cmd = MoveCommand.createMoveCommand(destination, Arrays
								.asList(selected));
					}
				} else if (FileTransfer.getInstance().isSupportedType(
						event.currentDataType)) {
					String[] data = (String[]) FileTransfer.getInstance()
							.nativeToJava(event.currentDataType);
					// import from OS
					List<java.io.File> files = new ArrayList<java.io.File>();
					String[] dropedFiles = data;
					if (dropedFiles != null) {
						for (int i = 0; i < dropedFiles.length; i++) {
							files.add(new java.io.File(dropedFiles[i]));
						}
						cmd = ImportCommand.createImportCommand(destination,
								files);
					}
				}
				return cmd;
			}

			private Directory getDestination(Object data) {
				if (data instanceof Directory) {
					return (Directory) data;
				} else if (data instanceof File) {
					File f = (File) data;
					return (Directory) f.eContainer();
				}
				return (ResourceModelRoot) viewer.getInput();
			}

		};

		viewer.addDropSupport(ops | DND.DROP_DEFAULT, transfers, adapter);

		/**
		 * 2653 bug fix Notify EmbeddedContentEditorContainer to allow save
		 */

	}

	protected FileSystemElement[] getSelectedFiles(
			IStructuredSelection selection) {
		List<?> list = selection.toList();
		FileSystemElement[] array = list.toArray(new FileSystemElement[list
				.size()]);

		return array;
	}

	/**
	 * Executes a command, specified with id
	 * 
	 * @param commandId
	 */
	/*
	 * private boolean executeCommand(String commandId, IStructuredSelection
	 * selection) { ICommandService commandService = (ICommandService) getSite()
	 * .getService(ICommandService.class); org.eclipse.core.commands.Command cmd
	 * = commandService .getCommand(commandId); if (!cmd.isDefined()) { return
	 * false; } IHandlerService handlerService = (IHandlerService) getSite()
	 * .getService(IHandlerService.class); EvaluationContext c = null; if
	 * (selection != null) { c = new EvaluationContext(handlerService
	 * .createContextSnapshot(false), selection.toList());
	 * c.addVariable(ISources.ACTIVE_CURRENT_SELECTION_NAME, selection); } try {
	 * if (c != null) { handlerService.executeCommandInContext( new
	 * ParameterizedCommand(cmd, null), null, c); } else {
	 * handlerService.executeCommand(commandId, null); } return true; } catch
	 * (ExecutionException e) { } catch (NotDefinedException e) { } catch
	 * (NotEnabledException e) { } catch (NotHandledException e) { } return
	 * false; }
	 */

	private void hookDoubleClickAction() {
		viewer.addDoubleClickListener(new IDoubleClickListener() {

			public void doubleClick(DoubleClickEvent event) {
				ISelection sel = event.getSelection();
				if (sel instanceof StructuredSelection) {
					FileSystemElement r = (FileSystemElement) ((StructuredSelection) sel)
							.getFirstElement();

					// For files, execute external viewer on double-click
					if (r instanceof File) {
						OpenEditorAction action = new OpenEditorAction(
								ResourceLibraryPage.this, false);
						action
								.selectionChanged((IStructuredSelection) createAdaptableSelection(sel));

						if (action.isEnabled()) {
							action.run();
						}
					}
				}
			}
		});
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {

		if (viewer != null) {
			viewer.getControl().setFocus();
		}
	}

	@Override
	public Control getControl() {
		return treeComposite;
	}

	final ListenerList listeners = new ListenerList();
	final ListenerList postListeners = new ListenerList();

	public void addSelectionChangedListener(ISelectionChangedListener listener) {
		listeners.add(listener);
	}

	public void removeSelectionChangedListener(
			ISelectionChangedListener listener) {
		listeners.remove(listener);
	}

	public void addPostSelectionChangedListener(
			ISelectionChangedListener listener) {
		postListeners.add(listener);
	}

	public void removePostSelectionChangedListener(
			ISelectionChangedListener listener) {
		postListeners.remove(listener);
	}

	public ISelection getSelection() {
		if (viewer != null) {
			return createAdaptableSelection(viewer.getSelection());
		} else {
			return StructuredSelection.EMPTY;
		}
	}

	private ISelection createAdaptableSelection(ISelection selection) {
		StructuredSelection sel = null;
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection ss = (IStructuredSelection) selection;
			ArrayList<ResourceStorage> storages = new ArrayList<ResourceStorage>();

			for (Object object : ss.toList()) {
				if (object instanceof FileSystemElement) {
					FileSystemElement fse = (FileSystemElement) object;
					ResourceStorage storage = new ResourceStorage(fse);
					storages.add(storage);
				}
			}
			Object[] array = storages.toArray();
			sel = new StructuredSelection(array);
		}

		return (sel == null) ? selection : sel;
	}

	public void setSelection(ISelection selection) {
		// forward call to viewer, it'll trigger back the selection changed
		// events
		viewer.setSelection(selection);
	}

	@Override
	public void init(IPageSite pageSite) {
		super.init(pageSite);

		this.actionGroup = new ResourceLibraryActionGroup(this);
		this.actionGroup
				.setContext(new ActionContext(StructuredSelection.EMPTY));

		pageSite.setSelectionProvider(this);

		pageSite.getActionBars().setGlobalActionHandler("cut",
				actionGroup.getMoveResourceAction());
		pageSite.getActionBars().setGlobalActionHandler("delete",
				actionGroup.getDeleteResourceAction());
		pageSite.getActionBars().setGlobalActionHandler("copy",
				actionGroup.getCopyResourceAction());

	}

	/**
	 * Utility method to removes the given resources from selection.
	 * 
	 * @param resources
	 *            The resources to remove from selection
	 */
	/*
	 * @SuppressWarnings("unchecked") public void
	 * removeFromSelection(Collection<IResource> resources) {
	 * IStructuredSelection selection = (IStructuredSelection) this
	 * .getSelection();
	 * 
	 * // Remove all resources from current selection List<Object> l = new
	 * ArrayList<Object>( ((IStructuredSelection) selection).toList());
	 * l.removeAll(resources);
	 * 
	 * // Refresh selection (in all cases) setSelection(new
	 * StructuredSelection(l));
	 * 
	 * // In principle we should not have any other selections that structured
	 * // selections, so do nothing if the selection wasn't one. }
	 */

	protected void sendSelectionEvent(ISelection selection) {
		final SelectionChangedEvent e = new SelectionChangedEvent(this,
				selection);
		for (final Object listener : listeners.getListeners()) {
			SafeRunner.run(new SafeRunnable() {
				public void run() throws Exception {
					((ISelectionChangedListener) listener).selectionChanged(e);
				};
			});
		}
	}

	protected void sendPostSelectionEvent(ISelection selection) {
		final SelectionChangedEvent e = new SelectionChangedEvent(this,
				selection);
		for (final Object listener : postListeners.getListeners()) {
			SafeRunner.run(new SafeRunnable() {
				public void run() throws Exception {
					((ISelectionChangedListener) listener).selectionChanged(e);
				};
			});
		}
	}

	/**
	 * Synchronize resource view selection with the give selection object...
	 */
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		if (part != contributor) {
			return;
		}

		Object firstElement = ((IStructuredSelection) selection)
				.getFirstElement();
		String sourcePath = null;
		if (firstElement instanceof FilePath) {
			FilePath setting = (FilePath) firstElement;
			FilePath sourceFilePath = setting.getParent().getSourceFilePath();
			if (setting != sourceFilePath) {
				// there was selected target path to which we don't react
				return;
			}
			String choosenOption = sourceFilePath.getChoosenOption();
			if (choosenOption != null) {
				sourcePath = choosenOption;
			} else {
				sourcePath = sourceFilePath.getPath();
				if (sourcePath == null) {
					sourcePath = setting.getParent().getSourceFilePath()
							.getDefaultPath();
				}
			}
		} else if (firstElement instanceof SimpleSetting) {
			SimpleSetting ss = (SimpleSetting) firstElement;
			switch (ss.getType()) {
			case FILE:
			case FOLDER:
			case SIMPLE_FILE:
			case SIMPLE_FOLDER:
				String choosenOption = ss.getChoosenOption();
				if (choosenOption != null) {
					sourcePath = choosenOption;
				} else {
					sourcePath = ss.getValue();
				}
				if (sourcePath == null) {
					sourcePath = ss.getDefaultValue();
				}
			}
		}

		if (sourcePath != null) {
			FileSystemElement element = ResourceUtil.getFileSystemElement(
					(ResourceModelRoot) viewer.getInput(), sourcePath);
			if (element != null) {
				viewer.setSelection(new StructuredSelection(element), true);
				viewer.expandToLevel(element, 1);
			} else {
				viewer.setSelection(new StructuredSelection(
						StructuredSelection.EMPTY), true);
			}
		}
	}

	/**
	 * adding actions to main toolbar
	 */
	private void contributeToActionBars() {

		IActionBars bars = getSite().getActionBars();

		this.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				actionGroup.setContext(new ActionContext(event.getSelection()));
				actionGroup.updateActionBars();
			}
		});

		this.actionGroup.fillActionBars(bars);
		this.actionGroup.fillContextMenu(menuMgr);

		this.actionGroup.setContext(new ActionContext(getSelection()));
		this.actionGroup.updateActionBars();

		/* set undo/redo handlers from parent editor */
		ActionRegistry registry = (ActionRegistry) contributor
				.getAdapter(ActionRegistry.class);
		if (registry != null) {
			bars.setGlobalActionHandler(ActionFactory.UNDO.getId(), registry
					.getAction(ActionFactory.UNDO.getId()));
			bars.setGlobalActionHandler(ActionFactory.REDO.getId(), registry
					.getAction(ActionFactory.REDO.getId()));

		}

		bars.updateActionBars();

	}

	@Override
	public void dispose() {
		// Remove selection provider
		getSite().setSelectionProvider(null);

		getCommandStack().removeCommandStackEventListener(
				commandStackEventListener);

		// dispose all controls
		treeComposite.dispose();

		this.actionGroup.dispose();
		this.actionGroup = null;

		resorceModelRoot = null;

		listeners.clear();
		postListeners.clear();

		// Do the superclass disposal
		super.dispose();
	}

	@SuppressWarnings("unchecked")
	public Object getAdapter(Class key) {
		if (CommandStack.class.equals(key)) {
			return getCommandStack();
		}
		if (IContributedContentsView.class.equals(key)) {
			return this;
		}

		return null;
	}

	public CommandStack getCommandStack() {
		return (CommandStack) contributor.getAdapter(CommandStack.class);
	}

	public ResourceModelRoot getResourceModelRoot() {
		return resorceModelRoot;
	}

	public void refresh() {
		viewer.refresh(true);
	}

	public void expandAll() {
		viewer.expandAll();
	}

	public void collapseAll() {
		viewer.collapseAll();
	}

	boolean canRenameElement(FileSystemElement element) {
		int status = ResourceLibraryCommandHelper.checkModifyStatus(element);
		if (status == ResourceLibraryCommandHelper.STATUS_OK) {
			return true;
		}

		MessageBox box = new MessageBox(getSite().getShell(),
				SWT.ICON_INFORMATION | SWT.CANCEL);
		box.setText("Rename operation is not permitted");
		box.setMessage(ResourceLibraryCommandHelper.getStatusLiteral(status));
		box.open();

		return false;
	}

	public IWorkbenchPart getContributingPart() {
		return contributor;
	}
}
