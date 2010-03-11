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

package com.nokia.tools.variant.editor.editors;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.operations.ObjectUndoContext;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.ui.util.EditUIUtil;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.commands.CommandStackEvent;
import org.eclipse.gef.commands.CommandStackEventListener;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.gef.ui.actions.EditorPartAction;
import org.eclipse.gef.ui.actions.RedoAction;
import org.eclipse.gef.ui.actions.StackAction;
import org.eclipse.gef.ui.actions.UndoAction;
import org.eclipse.gef.ui.actions.UpdateAction;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.commands.ActionHandler;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.ISaveablePart2;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.operations.RedoActionHandler;
import org.eclipse.ui.operations.UndoActionHandler;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import com.nokia.tools.variant.common.core.utils.ArrayUtils;
import com.nokia.tools.variant.common.ui.properties.NoTabControlPropertyPage;
import com.nokia.tools.variant.common.ui.utils.ProgressBarShower;
import com.nokia.tools.variant.confml.core.model.application.EAppIncludeElement;
import com.nokia.tools.variant.confml.core.model.application.EConfMLLayer;
import com.nokia.tools.variant.confml.core.model.application.EConfigurationProject;
import com.nokia.tools.variant.content.confml.ConfmlPackage;
import com.nokia.tools.variant.content.confml.Feature;
import com.nokia.tools.variant.content.confml.FilePath;
import com.nokia.tools.variant.content.confml.FileSystemEntrySetting;
import com.nokia.tools.variant.content.confml.Group;
import com.nokia.tools.variant.content.confml.LeafGroup;
import com.nokia.tools.variant.content.confml.ParentGroup;
import com.nokia.tools.variant.content.confml.SequenceItem;
import com.nokia.tools.variant.content.confml.SequenceSetting;
import com.nokia.tools.variant.content.confml.Setting;
import com.nokia.tools.variant.content.confml.SimpleSetting;
import com.nokia.tools.variant.content.confml.TYPE;
import com.nokia.tools.variant.content.confml.View;
import com.nokia.tools.variant.editor.actions.ClearSettingValueAction;
import com.nokia.tools.variant.editor.actions.CopyAction;
import com.nokia.tools.variant.editor.actions.CutAction;
import com.nokia.tools.variant.editor.actions.DeleteAction;
import com.nokia.tools.variant.editor.actions.DeselectAllSettingsAction;
import com.nokia.tools.variant.editor.actions.HideSettingsFromViewAction;
import com.nokia.tools.variant.editor.actions.PasteAction;
import com.nokia.tools.variant.editor.actions.RemoveSequenceItemsAction;
import com.nokia.tools.variant.editor.actions.ResetToDefaultAction;
import com.nokia.tools.variant.editor.actions.SelectAllSettingsAction;
import com.nokia.tools.variant.editor.adapters.SettingToErrorAdapter;
import com.nokia.tools.variant.editor.adapters.SettingToUISettingAdapter;
import com.nokia.tools.variant.editor.commands.IStructuralChangeCommand;
import com.nokia.tools.variant.editor.cpfInfo.CPFInformation;
import com.nokia.tools.variant.editor.dialogs.SelectConfigurationDialog;
import com.nokia.tools.variant.editor.editors.composites.SearchComposite;
import com.nokia.tools.variant.editor.listeners.DirtyButtonMouseListener;
import com.nokia.tools.variant.editor.listeners.ErrorButtonMouseListener;
import com.nokia.tools.variant.editor.listeners.NavigatorViewerSelectionChangedListener;
import com.nokia.tools.variant.editor.listeners.NonRecursiveAttemptListener;
import com.nokia.tools.variant.editor.listeners.NotesButtonMouseListener;
import com.nokia.tools.variant.editor.listeners.TopButtonMouseListener;
import com.nokia.tools.variant.editor.model.UIGroup;
import com.nokia.tools.variant.editor.model.UIModel;
import com.nokia.tools.variant.editor.model.UISetting;
import com.nokia.tools.variant.editor.model.convertor.ViewModelToUIModelConvertor;
import com.nokia.tools.variant.editor.model.summaryModel.Note;
import com.nokia.tools.variant.editor.model.summaryModel.SUMMARYTYPE;
import com.nokia.tools.variant.editor.model.summaryModel.SummaryModelFactory;
import com.nokia.tools.variant.editor.model.summaryModel.UIElement;
import com.nokia.tools.variant.editor.model.summaryModel.UISummaryGroup;
import com.nokia.tools.variant.editor.model.summaryModel.UISummaryModel;
import com.nokia.tools.variant.editor.summary.SummaryLeafGroup;
import com.nokia.tools.variant.editor.summary.SummaryParentGroup;
import com.nokia.tools.variant.editor.utils.CPFManager;
import com.nokia.tools.variant.editor.utils.OpenCPFErrors;
import com.nokia.tools.variant.editor.validation.SettingsValidator;
import com.nokia.tools.variant.editor.validation.ThemeValidator;
import com.nokia.tools.variant.navigator.views.NavigatorViewer;
import com.nokia.tools.variant.preview.ui.IPreviewViewPage;
import com.nokia.tools.variant.preview.ui.IPreviewViewPageContributor;
import com.nokia.tools.variant.preview.ui.PreviewViewPage;
import com.nokia.tools.variant.resourcelibrary.handlers.commands.ResourceLibraryCommandHelper;
import com.nokia.tools.variant.resourcelibrary.model.ResourceModelRoot;
import com.nokia.tools.variant.resourcelibrary.model.ThemeFile;
import com.nokia.tools.variant.resourcelibrary.views.ResourceStorage;
import com.nokia.tools.variant.viewer.validation.EResult;
import com.nokia.tools.variant.viewer.validation.ValidationResult;
import com.nokia.tools.variant.viewer.viewer.IValuesContentProvider;
import com.nokia.tools.variant.viewer.viewer.SettingsViewer;
import com.nokia.tools.variant.views.errormodel.Error;
import com.nokia.tools.variant.views.errormodel.ErrormodelFactory;
import com.nokia.tools.variant.views.errormodel.ErrorsRoot;

/**
 * Editor for cpf editing. Contains 2 viewers placed on a SashForm-
 * SettingsViewer and NavigatorViewer. NavigatorViewer is used for navigation
 * between groups, SettingsViewer contains widgets, which are used for model
 * editing. NavigatorViewerSelectionChangedListener is added on NavigatorViewer
 * to react on selection and change the input for SettingsViewer. Model is
 * changed through SettingsViewer, widget notifies the viewer and SettingsViewer
 * fires the change to {@link IValuesContentProvider} valueChanged method.
 * Updating of SettingsViewer after model changes is done by adapters
 * {@link SettingToUISettingAdapter}, {@link SettingsViewer} is refreshed after
 * an execution of a command, which made structural changes(elements added or
 * removed from model).Input for the NavigatorViewer is {@link View}, which is
 * the main model, because of sorting, another model "ui" model {@link UIModel}
 * is used for SettingsViewer input . Creating of UIModel is done in
 * {@link ViewModelToUIModelConvertor}.
 * 
 */
public class CPFEditor extends EditorPart implements
		IPreviewViewPageContributor, ISelectionProvider,
		ITabbedPropertySheetPageContributor, ISaveablePart2 {

	private static final String PROPERTIES_CONTRIBUTOR_ID = "com.nokia.tools.variant.editor.editors.CPF_EDITOR_TABBED_PROPERTIES_CONTRIBUTOR";
	private URI savePath;
	private ErrorsRoot errorsRoot;
	private ViewModelToUIModelConvertor viewModelToUIModelConvertor;
	private Control lastFocusControl;
	private Listener lastActivationListener = new Listener() {
		public void handleEvent(Event event) {
			if (event.widget instanceof Control) {
				lastFocusControl = (Control) event.widget;
			}
		}
	};

	/**
	 * Closes all internal editors which are opened from current CPF file
	 */
	private IPartListener editorClosingListener = new IPartListener() {

		public void partOpened(IWorkbenchPart part) {
		}

		public void partDeactivated(IWorkbenchPart part) {
		}

		public void partClosed(IWorkbenchPart part) {
			if (viewEditorModel != null) {
				List<?> listOfOpenedEditorParts = viewEditorModel
						.getListOfOpenedEditorParts();
				listOfOpenedEditorParts.remove(part);
			}
		}

		public void partBroughtToTop(IWorkbenchPart part) {
		}

		public void partActivated(IWorkbenchPart part) {
		}
	};

	public ErrorsRoot getErrorsRoot() {
		return errorsRoot;
	}

	private CommandStack stack;
	private List<String> stackActionIDs = new ArrayList<String>();
	private View view;

	/**
	 * Search Composite
	 */
	private SearchComposite sc;
	private SettingsViewer settingsViewer;
	private ViewerFilter settingsViewerFilter;
	private EConfigurationProject project;
	private ViewEditorModel viewEditorModel;
	private Group currentGroup;
	private IPath fullPath = null;
	private UISummaryModel summaryModelRoot;

	// root confml file
	private String rootConfMLPath;

	// popup actions
	SelectAllSettingsAction selectAll = null;
	DeselectAllSettingsAction deselectAll = null;
	HideSettingsFromViewAction hideFromView = null;
	ResetToDefaultAction resetToDefaults = null;
	RemoveSequenceItemsAction removeSequenceItemsAction = null;

	private int structuralCommands;
	private int structuralCommandsSaveLocation;
	private boolean saveAsRequired;
	private boolean dirty;

	// private boolean closeAfterSaveAs;

	/** the list of action ids that are editor actions */
	private List<String> editorActionIDs = new ArrayList<String>();
	private ActionRegistry actionRegistry;
	private RedoActionHandler redoActionHandler;
	private UndoActionHandler undoActionHandler;
	private PreviewViewPage previewViewPage;
	private ObjectUndoContext undoContext;
	private List<ISelectionChangedListener> listeners = new ArrayList<ISelectionChangedListener>();
	private TabbedPropertySheetPage propertySheetPage;
	private NavigatorViewer navigatorViewer;

	private FormToolkit formToolkit;
	private IMenuListener fMenuListener;
	private boolean dirtySorting;
	private boolean notesSorting;
	private boolean errorSorting;
	private SummaryLeafGroup summaryLeafGroup;
	private IPartListener partListener = new NonRecursiveAttemptListener();

	private CommandStackEventListener commandStackEventListener = new CommandStackEventListener() {

		public void stackChanged(CommandStackEvent event) {
			if (!event.isPostChangeEvent()) {
				return;
			}

			if (!stack.isDirty()) {
				updateDirtyState(false, false);
			} else {
				Command command = event.getCommand();
				boolean metadataChangeDetected = false;
				UISummaryModel summaryModelroot = getSummaryModelroot();
				UISummaryGroup summaryGroup = summaryModelroot.getUiGroups()
						.get(0);
				EList<UIElement> uiElements = summaryGroup.getUiElements();

				for (UIElement element : uiElements) {
					if (SUMMARYTYPE.CUSTOMER.equals(element.getType())
							|| SUMMARYTYPE.OWNER.equals(element.getType())
							|| SUMMARYTYPE.AUTHOR.equals(element.getType())
							|| SUMMARYTYPE.DESCRIPTION
									.equals(element.getType())) {
						if (!element.getValue().equals(
								element.getLastSavedValue())) {
							metadataChangeDetected = true;
							break;
						}
					}
				}
				if (command instanceof IStructuralChangeCommand) {
					switch (event.getDetail()) {
					case CommandStack.POST_EXECUTE:
						setStructuralCommands(getStructuralCommands() + 1);
						break;
					case CommandStack.POST_REDO:
						setStructuralCommands(getStructuralCommands() + 1);
						break;
					case CommandStack.POST_UNDO:
						setStructuralCommands(getStructuralCommands() - 1);
						break;
					default:
					}

				}
				updateDirtyState(
						true,
						getStructuralCommands() != getStructuralCommandsSaveLocation()
								|| metadataChangeDetected);
			}

			updateActions(stackActionIDs);

			if (shouldComputeRelevant) {
				if (currentGroup instanceof Group) {

					doStructuralRefresh = SettingEvaluator
							.initRelevantForWholeModel(view, false);
					shouldComputeRelevant = false;
				}
			}
			// we have to update errors markers after operation in Resource
			// library
			if (ResourceLibraryCommandHelper
					.containsResourceLibraryCommand(event.getCommand())) {
				settingsViewer.createErrorsForWholeModel();
			}
			 handleNotification();

		}

	};
	private boolean shouldRefresh;
	protected boolean shouldComputeRelevant;

	Adapter contentAdapter = new EContentAdapter() {

		@Override
		public void notifyChanged(Notification notification) {

			int eventType = notification.getEventType();
			if (notification.getNotifier() instanceof Setting
					&& notification.getFeatureID(Setting.class) == ConfmlPackage.SIMPLE_SETTING__VALUE
					|| notification.getNotifier() instanceof FilePath
					|| notification.getFeatureID(Setting.class) == ConfmlPackage.SETTING__VALUE_NULL) {
				updateErrors(notification);
				shouldComputeRelevant = true;
			}
			if (eventType == Notification.ADD
					|| eventType == Notification.REMOVE
					|| eventType == Notification.ADD_MANY
					|| eventType == Notification.REMOVE_MANY
					|| eventType == Notification.MOVE) {
				shouldRefresh = true;
				shouldComputeRelevant = true;
				updateErrors(notification);
//				handleNotification(notification);
			}
			super.notifyChanged(notification);
		}
	};
	private boolean doStructuralRefresh;
	private MouseListener topButtonMouseListener;
	private MouseListener notesButtonListener;
	private MouseListener dirtyButtonListener;
	private MouseListener errorButtonListener;
	private ViewerFilter filter;

	private ISelectionChangedListener selectionChangedListener;
	private ISelectionChangedListener vieverSelectionChangedListener;
	private IPropertyListener propertyListener;
	private EditorViewerContentProvider contentProvider;
	private IMenuListener contextMenuListener;
	private MenuManager mm;
	private RedoAction redoAction;
	private UndoAction undoAction;
	private ClearSettingValueAction clearSettingAction;

	// edit
	private IAction cutAction, copyAction, pasteAction, deleteAction;

	public CPFEditor() {
		super();

	}

	public void setView(View view) {
		this.view = view;
	}

	public SettingsViewer getSettingsViewer() {
		return settingsViewer;
	}

	public NavigatorViewer getNavigatorViewer() {
		return navigatorViewer;
	}

	public ViewEditorModel getViewEditorModel() {
		return viewEditorModel;
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		stack.markSaveLocation();
		setStructuralCommandsSaveLocation(getStructuralCommands());
		updateDirtyState(false, false);

		ProgressBarShower s = new ProgressBarShower();
		Thread t = new Thread(new SaveProgressBarShowerRunnable(s, monitor,
				this));

		s.showProgressBar(t, "Saving cpf", true);

		settingsViewer.removeDirtyMarkers();

	}

	/**
	 * 
	 */
	void setNote(String text) {
		Note note = SummaryModelFactory.eINSTANCE.createNote();
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		note.setDate(sdf.format(now));
		String comments = text.replaceAll("\t|\r|\n|\f", "");
		note.setContent(comments);
		viewEditorModel.getHistory().getNote().add(0, note);

		Display.getCurrent().asyncExec(new Runnable() {
			public void run() {
				settingsViewer.refresh(viewEditorModel.getHistory());
			}
		});
	}

	@Override
	public void doSaveAs() {
		doSaveAsInternal();

	}

	private int doSaveAsInternal() {
		return SaveAsUtil.doSaveAs(this);

	}

	@Override
	public void setPartName(String partName) {
		super.setPartName(partName);
	}

	private boolean closeEditorFlag = false;

	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {

		setSite(site);
		setInput(input);

		viewModelToUIModelConvertor = new ViewModelToUIModelConvertor(this);
		stack = new SelectionCommandStack();
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getPartService()
				.addPartListener(partListener);
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getPartService()
				.addPartListener(editorClosingListener);
		actionRegistry = new ActionRegistry();

		stack.addCommandStackEventListener(commandStackEventListener);
		createActions();
		// attachEditorDirtyListener();

		final URI uri = EditUIUtil.getURI(input);

		// allow user to choose ConfML root configuration
		List<CPFInformation> infos = CPFManager.getCPFConfigurations(uri);
		if (infos.size() > 1) {
			Shell shell = site.getShell();
			SelectConfigurationDialog selectCfgDialog = new SelectConfigurationDialog(
					shell, infos);
			int open = selectCfgDialog.open();
			if (open == Window.CANCEL) {
				closeEditorFlag = true;
				return;
			}
			CPFInformation selectedConfiguration = selectCfgDialog
					.getSelectedConfiguration();
			if (selectedConfiguration != null) {
				rootConfMLPath = selectedConfiguration.getRootConfMLPath();
			}
		}

		if (uri.isFile()) {
			fullPath = new Path(uri.toFileString());
		} else {
			fullPath = Path.EMPTY;
		}

		ProgressBarShower s = new ProgressBarShower();
		Thread t = new Thread(new Runnable() {

			public void run() {
				CPFEditor.this.viewEditorModel = CPFManager.createModel(uri,
						rootConfMLPath);

			}

		});

		s.showProgressBar(t, "Opening cpf", true);
		if ((OpenCPFErrors.showFatalError()) || (viewEditorModel == null)) {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow()
					.getActivePage().closeEditor(this, false);
		}
		setView(viewEditorModel.getView());
		getView().eAdapters().add(contentAdapter);
		project = viewEditorModel.getVariantContributor();
		viewEditorModel.getResourceModelRoot().eAdapters().add(
				new EContentAdapter() {
					@SuppressWarnings("deprecation")
					@Override
					public void notifyChanged(Notification notification) {
						Object newValue = notification.getNewValue();
						if (newValue instanceof ThemeFile) {
							ThemeFile themeFile = (ThemeFile) newValue;

							ThemeValidator val = new ThemeValidator(project,
									viewEditorModel.getResourceModelRoot()
											.getTempDirPath()
											+ "//" + themeFile.getPath());
							ValidationResult validate = val.validate();
							if (!validate.getResult().contains(EResult.VALID)) {
								themeFile.setValidationMessage(validate
										.getMessage());
							}
						}
						super.notifyChanged(notification);
					}
				});

		createErrors();

		getSite().setSelectionProvider(this);
		System.setProperty(
				"com.nokia.tools.variant.report.actions.GenerateReportAction",
				"enabled");
		System.setProperty(
				"com.nokia.tools.variant.compare.ui.actions.CopyValuesAction",
				"enabled");

		EConfMLLayer lastLayer = project.getLastLayer();
		// EAppView lastView =
		// ArrayUtils.getLast(lastLayer.getViews()).getValue();
		// String viewName = lastView.getName();

		EAppIncludeElement lastInclude = ArrayUtils.getLast(lastLayer
				.getIncludes());
		URI lastFile = lastInclude.getTarget();

		// uri = uri.resolve(project.getLastLayer().getLayerURI());

		setSavePath(lastFile);
		File file = new File(input.getName());
		String fileName = file.getName();
		setPartName(fileName.substring(0, fileName.lastIndexOf(".")));
	}

	/**
	 * Create errors model from settings
	 */
	private void createErrors() {
		errorsRoot = ErrormodelFactory.eINSTANCE.createErrorsRoot();
		EList<Setting> settingInstances = getView().getSharedSettingInstances();
		for (Setting setting : settingInstances) {
			updateErrorModelFor(setting);

		}

	}

	private void updateErrorModelFor(Setting setting) {
		String settingValue = "";
		if (setting instanceof SimpleSetting) {
			settingValue = ((SimpleSetting) setting).getValue();
		}
		if (setting instanceof FileSystemEntrySetting) {
			createErrorsForFile(((FileSystemEntrySetting) setting)
					.getSourceFilePath());
			createErrorsForFile(((FileSystemEntrySetting) setting)
					.getTargetFilePath());
		} else {
			if (setting instanceof SequenceSetting) {
				SequenceSetting sequenceSetting = (SequenceSetting) setting;
				EList<SequenceItem> sequenceItems = sequenceSetting
						.getSequenceItem();
				for (SequenceItem sequenceItem : sequenceItems) {
					EList<Setting> settings = sequenceItem.getSetting();
					for (Setting setting2 : settings) {
						settingValue = "";
						if (setting2 instanceof SimpleSetting) {
							SimpleSetting simpleSetting = (SimpleSetting) setting2;
							settingValue = simpleSetting.getValue();
						}
						if (setting2 instanceof FileSystemEntrySetting) {
							handleErrors(((FileSystemEntrySetting) setting2)
									.getSourceFilePath(),
									((FileSystemEntrySetting) setting2)
											.getSourceFilePath().getPath());
							handleErrors(((FileSystemEntrySetting) setting2)
									.getTargetFilePath(),
									((FileSystemEntrySetting) setting2)
											.getTargetFilePath().getPath());
						} else {
							handleErrors(setting2, settingValue);
						}
					}
				}
			} // else {
			handleErrors(setting, settingValue);
			// }
		}
	}

	private void createErrorsForFile(Setting setting) {
		String settingValue = ((FilePath) setting).getPath();
		ResourceModelRoot resourceModelRoot = viewEditorModel
				.getResourceModelRoot();
		handleErrors(setting, SettingsValidator.validateSetting(setting,
				settingValue, resourceModelRoot));
	}

	/**
	 * Update error model
	 * 
	 * @param setting
	 * @param value
	 */
	public void handleErrors(Setting setting, String value) {
		if (setting.isVisible()) {

			handleErrors(setting, SettingsValidator.validateSetting(setting,
					value, viewEditorModel.getResourceModelRoot()));
		}
	}

	private void handleErrors(Setting setting, ValidationResult result) {
		if (!setting.isVisible()) {
			return;
		}
		EList<Error> errors = errorsRoot.getErrors();
		EList<Adapter> adapters = setting.eAdapters();
		Adapter adapter = EcoreUtil.getAdapter(adapters,
				SettingToErrorAdapter.class);
		if (adapter instanceof SettingToErrorAdapter) {
			SettingToErrorAdapter settingToErrorAdapter = (SettingToErrorAdapter) adapter;
			errors.remove(settingToErrorAdapter.getError());
			adapters.remove(adapter);
		}

		if (result.getResult().size() > 0) {

			if (!result.getResult().contains(EResult.VALID)) {
				Error error = ErrormodelFactory.eINSTANCE.createError();
				error.setSetting(setting);
				error.setDescription(result.getValidationMessage());
				setting.eAdapters().add(new SettingToErrorAdapter(error));
				String location = "";
				if (setting.getLeafGroup().size() > 0) {
					LeafGroup leafGroup = setting.getLeafGroup().get(0);
					EObject container = leafGroup.eContainer();
					if (container instanceof ParentGroup) {
						ParentGroup parentGroup = (ParentGroup) container;
						location = parentGroup.getName() + " - "
								+ leafGroup.getName();
					}
				} else if ((setting.eContainer() != null)
						&& (setting.eContainer().eContainer() instanceof SequenceSetting)) {
					SequenceSetting sequenceSetting = (SequenceSetting) setting
							.eContainer().eContainer();
					if (sequenceSetting.getLeafGroup().size() > 0) {
						LeafGroup leafGroup = sequenceSetting.getLeafGroup()
								.get(0);
						EObject container = leafGroup.eContainer();
						if (container instanceof ParentGroup) {
							ParentGroup parentGroup = (ParentGroup) container;
							location = parentGroup.getName() + " - "
									+ leafGroup.getName();
						}
					} else if (sequenceSetting.getParentGroup().size() > 0) {
						ParentGroup parentGroup = sequenceSetting
								.getParentGroup().get(0);
						location = parentGroup.getName();
					}
				} else if ((setting.eContainer() != null)
						&& (setting.eContainer().eContainer() != null)
						&& (setting.eContainer().eContainer().eContainer() instanceof SequenceSetting)) {
					SequenceSetting sequenceSetting = (SequenceSetting) setting
							.eContainer().eContainer().eContainer();
					if (sequenceSetting.getLeafGroup().size() > 0) {
						LeafGroup leafGroup = sequenceSetting.getLeafGroup()
								.get(0);
						EObject container = leafGroup.eContainer();
						if (container instanceof ParentGroup) {
							ParentGroup parentGroup = (ParentGroup) container;
							location = parentGroup.getName() + " - "
									+ leafGroup.getName();
						}
					} else if (sequenceSetting.getParentGroup().size() > 0) {
						ParentGroup parentGroup = sequenceSetting
								.getParentGroup().get(0);
						location = parentGroup.getName();
					}
				} else if (setting.getParentGroup().size() > 0) {
					ParentGroup parentGroup = setting.getParentGroup().get(0);
					location = parentGroup.getName();
				}
				error.setLocation(location);
				errorsRoot.getErrors().add(error);
			}
		}

	}

	protected void updateDirtyState(boolean dirtyFlag, boolean saveAsFlag) {
		if (this.dirty == dirtyFlag && this.saveAsRequired == saveAsFlag) {
			return;
		}
		this.dirty = dirtyFlag;
		this.saveAsRequired = saveAsFlag;
		firePropertyChange(IEditorPart.PROP_DIRTY);
	}

	@Override
	public boolean isDirty() {
		return dirty;
	}

	public boolean isSaveAllowed() {
		return dirty && !saveAsRequired;
	}

	@Override
	public boolean isSaveAsAllowed() {
		// Save AS is always supported
		return true;
	}

	@Override
	public boolean isSaveOnCloseNeeded() {
		return dirty;
	}

	public int promptToSaveOnClose() {
		List<?> listOfOpenedEditorParts = viewEditorModel
				.getListOfOpenedEditorParts();
		if (!dirty && listOfOpenedEditorParts.size() == 0) {
			return NO;
		}

		// close dependent editors beforehand
		boolean closeDependentEditors = closeDependentEditors();
		if (!closeDependentEditors) {
			return CANCEL;
		}

		if (!saveAsRequired) {
			return DEFAULT;
		}

		int result = doSaveAsInternal();

		switch (result) {
		case Dialog.OK:
			return NO;
		case Dialog.CANCEL:
			return NO;
		default:
			return NO;
		}

	}

	/**
	 * Return view of confml UI model
	 * 
	 * @return view of confml UI model
	 */
	public View getView() {
		return view;
	}

	@Override
	public void createPartControl(Composite parent) {
		if (closeEditorFlag) {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow()
					.getActivePage().closeEditor(this, false);
			return;
		}
		formToolkit = new FormToolkit(parent.getDisplay());

		SashForm form = new SashForm(parent, SWT.HORIZONTAL | SWT.BORDER);
		formToolkit.adapt(form);

		Composite left = formToolkit.createComposite(form);
		GridLayout gl = new GridLayout(1, false);
		gl.verticalSpacing = 0;
		gl.marginHeight = gl.marginWidth = 0;
		left.setLayout(gl);
		createSearchComposite(left);

		Label sep = formToolkit.createSeparator(left, SWT.HORIZONTAL);
		sep.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		navigatorViewer = new NavigatorViewer(left);
		navigatorViewer.getControl().setLayoutData(
				new GridData(SWT.FILL, SWT.FILL, true, true));

		navigatorViewer.getControl().addListener(SWT.Activate,
				lastActivationListener);

		lastFocusControl = navigatorViewer.getControl();

		// here
		SettingEvaluator.initRelevantForWholeModel(getView(), true);

		settingsViewer = new SettingsViewer(form);
		settingsViewer.getControl().addListener(SWT.Activate,
				lastActivationListener);

		settingsViewerFilter = new SettingsViewerFilter();

		settingsViewer.addFilter(settingsViewerFilter);
		filter = new ViewerFilter() {

			@Override
			public boolean select(Viewer viewer, Object parentElement,
					Object element) {
				if ((element instanceof LeafGroup)
						&& !(element instanceof SummaryLeafGroup)) {
					LeafGroup subGroup = (LeafGroup) element;
					// EList<Setting> list = subGroup.getSettings();
					List<Setting> settings = filterSettings(subGroup
							.getSettings());
					if (settings.size() == 0) {
						return false;
					}
				}
				if ((element instanceof ParentGroup)
						&& !(element instanceof SummaryParentGroup)) {
					ParentGroup group = (ParentGroup) element;
					EList<Setting> parentGroupSettings = group.getSettings();
					List<Setting> filterSettings = filterSettings(parentGroupSettings);
					if (filterSettings.size() > 0) {
						return true;
					}
					EList<LeafGroup> leafGroups = group.getLeafGroup();
					for (LeafGroup subGroup : leafGroups) {
						// EList<Setting> list = subGroup.getSettings();
						List<Setting> settings = filterSettings(subGroup
								.getSettings());
						if (settings.size() > 0) {
							return true;
						}
					}
					return false;
				}
				return true;
			}
		};

		navigatorViewer.addFilter(filter);

		// create pop up menu actions
		clearSettingAction = new ClearSettingValueAction();
		clearSettingAction.setAccelerator(SWT.SHIFT | SWT.DEL);
		selectAll = SelectAllSettingsAction.getInstance();// new
		// SelectAllSettingsAction();
		deselectAll = new DeselectAllSettingsAction();
		hideFromView = new HideSettingsFromViewAction(settingsViewer);
		resetToDefaults = new ResetToDefaultAction(settingsViewer);
		removeSequenceItemsAction = new RemoveSequenceItemsAction();
		removeSequenceItemsAction
				.setActionDefinitionId("com.nokia.tools.variant.editor.removeSequenceItem");
		IWorkbenchWindow window = getSite().getWorkbenchWindow();
		clearSettingAction.init(window);
		selectAll.init(window);
		deselectAll.init(window);
		hideFromView.init(window);
		resetToDefaults.init(window);
		removeSequenceItemsAction.setEnabled(false);
		IHandlerService hs = (IHandlerService) getSite().getService(
				IHandlerService.class);
		if (hs != null) {
			hs.activateHandler("com.nokia.tools.variant.editor.selectAll",
					new ActionHandler(selectAll));
			hs.activateHandler("com.nokia.tools.variant.editor.deselectAll",
					new ActionHandler(deselectAll));
			hs.activateHandler("com.nokia.tools.variant.editor.resetToDefault",
					new ActionHandler(resetToDefaults));
			hs.activateHandler("com.nokia.tools.variant.editor.hide",
					new ActionHandler(hideFromView));
			hs.activateHandler(
					"com.nokia.tools.variant.editor.removeSequenceItem",
					new ActionHandler(removeSequenceItemsAction));
		}
		disableActions();

		// create pop up menu with actions
		contextMenuListener = contextMenuListener(form);
		mm = new MenuManager();
		mm.addMenuListener(contextMenuListener);
		mm.setRemoveAllWhenShown(true);
		Menu menu = mm.createContextMenu(form);
		form.setMenu(menu);

		dirtyButtonListener = new DirtyButtonMouseListener(this);
		settingsViewer.addDirtyButtonListener(dirtyButtonListener);
		errorButtonListener = new ErrorButtonMouseListener(this);
		settingsViewer.addErrorButtonListener(errorButtonListener);
		topButtonMouseListener = new TopButtonMouseListener(this);
		settingsViewer.addTopButtonListener(topButtonMouseListener);

		notesButtonListener = new NotesButtonMouseListener(this);

		settingsViewer.addNotesButtonListener(notesButtonListener);
		settingsViewer.getControl().setLayoutData(
				new GridData(SWT.FILL, SWT.FILL, true, true));
		contentProvider = new EditorViewerContentProvider(stack, this);
		settingsViewer.setContentProvider(contentProvider);

		vieverSelectionChangedListener = new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				IStructuredSelection selection = (IStructuredSelection) event
						.getSelection();

				ISelection convertSelection = convertSelectionToMainModel(selection);
				SelectionChangedEvent newEvent = new SelectionChangedEvent(
						CPFEditor.this, convertSelection);

				fireSelection(newEvent);

				updateEditActionState(selection);
			}

		};
		settingsViewer
				.addSelectionChangedListener(vieverSelectionChangedListener);
		selectionChangedListener = new NavigatorViewerSelectionChangedListener(
				this);

		navigatorViewer.addSelectionChangedListener(selectionChangedListener);

		navigatorViewer.setStaticFirstButton(true);
		navigatorViewer
				.setContentProvider(new NavigatorViewerContentProvider());
		navigatorViewer.setInput(getView());
		navigatorViewer.setLabelProvider(new NavigatorLabelProvider(
				viewEditorModel));
		SummaryModelInitializer.initializeSummaryGroup(getView(), this);
		shouldRefresh = false;
		form.setWeights(new int[] { 1, 2 });
		Display.getCurrent().asyncExec(new Runnable() {

			public void run() {
				navigatorViewer.setSelection(new StructuredSelection(getView()
						.getParentGroup().get(0).getLeafGroup().get(0)));

			}

		});

		SettingEvaluator.validateConstraintAttributeForAllSettings(getView(),
				errorsRoot, viewEditorModel.getResourceModelRoot(), this);

	}

	public Group getCurrentGroup() {
		return currentGroup;
	}

	/**
	 * 
	 * @param settings
	 * @return list of relevants and not read only settings
	 */
	protected List<Setting> filterSettings(List<Setting> settings) {
		// filer settings which has their's feature filtered
		// check features in LeafGroup

		if (settings.size() > 0) {
			EObject eObject = settings.get(0);
			while (eObject != null && !(eObject instanceof View)) {
				eObject = eObject.eContainer();
			}
			if (eObject instanceof View) {

				View view = (View) eObject;
				EList<Feature> featuresInView = view.getSharedFeatures();

				Map<String, Feature> allFeatures = new HashMap<String, Feature>();
				for (Feature feature : featuresInView) {
					if (feature.isComputedRelevant()) {
						allFeatures.put(feature.getRef(), feature);
					}
				}

				List<Setting> filteredSettings = new ArrayList<Setting>();
				for (Setting setting : settings) {
					if (setting != null) {
						if (setting.isComputedRelevant()
								&& setting.isVisible()) {
							filteredSettings.add(setting);
						}
					}
				}

				return filteredSettings;
			}
		}
		return settings;
	}

	/**
	 * Disables actions and waits on change in selection to enable them
	 */
	private void disableActions() {
		if (clearSettingAction.isEnabled()) {
			clearSettingAction.setEnabled(true);
			clearSettingAction.setEnabled(false);
		}

		if (deselectAll.isEnabled()) {
			deselectAll.setEnabled(true);
			deselectAll.setEnabled(false);
		}

		if (hideFromView.isEnabled()) {
			hideFromView.setEnabled(true);
			hideFromView.setEnabled(false);
		}

		if (resetToDefaults.isEnabled()) {
			resetToDefaults.setEnabled(true);
			resetToDefaults.setEnabled(false);
		}

	}

	class HanldeSummaryRunnable implements Runnable {

		private String showedViewId;

		public HanldeSummaryRunnable(String showedViewId) {
			this.showedViewId = showedViewId;
		}

		public void run() {
			if (PlatformUI.getWorkbench().getActiveWorkbenchWindow()
					.getActivePage() != null) {
				try {
					PlatformUI.getWorkbench().getActiveWorkbenchWindow()
							.getActivePage().showView(showedViewId);
				} catch (PartInitException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public void handleSummary(LeafGroup leaf) {
		if (!(leaf instanceof SummaryLeafGroup))
			return;

		SummaryLeafGroup leafGroup = (SummaryLeafGroup) leaf;

		String showedViewId = leafGroup.getShowedViewId();
		if (showedViewId != null) {
			Display.getDefault().asyncExec(
					new HanldeSummaryRunnable(showedViewId));
		}
	}

	@Override
	public void setFocus() {
		if (lastFocusControl != null && !lastFocusControl.isDisposed()) {
			lastFocusControl.setFocus();
		}
	}

	public void setProject(EConfigurationProject project) {
		this.project = project;
	}

	public EConfigurationProject getProject() {
		return project;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object getAdapter(Class adapter) {
		if (adapter == List.class) {
			return viewEditorModel.getListOfOpenedEditorParts();
		}
		if (adapter == ViewEditorModel.class) {
			return viewEditorModel;

		}
		if (adapter == ErrorsRoot.class) {
			return errorsRoot;
		}
		if (IPropertySheetPage.class.equals(adapter)) {

			propertySheetPage = new NoTabControlPropertyPage(this);

			return propertySheetPage;
		}
		if (adapter == IPreviewViewPage.class) {

			previewViewPage = new PreviewViewPage(this);

			return previewViewPage;
		}

		if (adapter == ActionRegistry.class) {
			return actionRegistry;
		}
		if (adapter == CommandStack.class) {
			if (stack == null) {
				return new CommandStack();
			}
			return stack;
		}
		if (adapter == View.class) {
			return getView();
		} else if (adapter == EConfigurationProject.class) {

			if (viewEditorModel != null) {
				return viewEditorModel.getVariantContributor();
			}
		} else if (adapter == ResourceModelRoot.class) {

			if (viewEditorModel != null) {
				return viewEditorModel.getResourceModelRoot();
			}
		}
		return super.getAdapter(adapter);
	}

	/**
	 * 
	 * @return ActionRegistry which contains actions
	 */
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
		// addEditorAction(new SaveAction(this));

		undoAction = new UndoAction(this);
		registerCommandStackAction(undoAction);
		redoAction = new RedoAction(this);
		registerCommandStackAction(redoAction);
		undoContext = new ObjectUndoContext(this);
		undoActionHandler = new UndoActionHandler(getSite(), undoContext);
		redoActionHandler = new RedoActionHandler(getSite(), undoContext);

		cutAction = new CutAction(this);
		((CutAction) cutAction).init();
		getEditorSite().getActionBars().setGlobalActionHandler(
				ActionFactory.CUT.getId(), cutAction);

		copyAction = new CopyAction(this);
		((CopyAction) copyAction).init();
		getEditorSite().getActionBars().setGlobalActionHandler(
				ActionFactory.COPY.getId(), copyAction);

		pasteAction = new PasteAction(this);
		((PasteAction) pasteAction).init();
		getEditorSite().getActionBars().setGlobalActionHandler(
				ActionFactory.PASTE.getId(), pasteAction);

		deleteAction = new DeleteAction(this);
		((DeleteAction) deleteAction).init();
		getEditorSite().getActionBars().setGlobalActionHandler(
				ActionFactory.DELETE.getId(), deleteAction);

		enableEditActions(false);
	}

	protected void addEditorAction(EditorPartAction action) {
		actionRegistry.registerAction(action);
		editorActionIDs.add(action.getId());
	}

	/**
	 * 
	 * @return CommandStack used in the editor for undo/redo
	 */
	public CommandStack getCommandStack() {
		return stack;
	}

	private void updateActions(List<String> actionIDs) {

		for (String actionID : actionIDs) {
			IAction action = actionRegistry.getAction(actionID);
			if (null != action && action instanceof UpdateAction)
				((UpdateAction) action).update();
		}
	}

	public void dispose() {
		closeDependentEditors();
		sc.dispose();
		sc = null;

		settingsViewerFilter = null;
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getPartService()
				.removePartListener(partListener);
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getPartService()
				.removePartListener(editorClosingListener);
		partListener = null;
		formToolkit.dispose();
		formToolkit = null;
		TreeIterator<EObject> allContents = view.eAllContents();
		if (propertyListener != null) {
			removePropertyListener(propertyListener);
			propertyListener = null;
		}
		navigatorViewer
				.removeSelectionChangedListener(selectionChangedListener);
		navigatorViewer.setInput(null);
		settingsViewer.dispose();

		selectionChangedListener = null;
		while (allContents.hasNext()) {
			EObject next = allContents.next();
			next.eAdapters().clear();
			next = null;
		}
		filter = null;
		getView().eAdapters().remove(contentAdapter);
		contentAdapter = null;
		project = null;
		System.setProperty(
				"com.nokia.tools.variant.report.actions.GenerateReportAction",
				"disabled");

		stack.removeCommandStackEventListener(commandStackEventListener);
		commandStackEventListener = null;
		actionRegistry.removeAction(redoAction);
		stackActionIDs.remove(redoAction.getId());
		actionRegistry.removeAction(undoAction);
		stackActionIDs.remove(undoAction.getId());
		actionRegistry.dispose();
		actionRegistry = null;
		listeners.clear();
		listeners = null;
		stack.dispose();
		stack = null;
		undoActionHandler.dispose();
		undoActionHandler = null;
		redoActionHandler.dispose();
		redoActionHandler = null;
		stackActionIDs.clear();
		stackActionIDs = null;
		editorActionIDs.clear();
		editorActionIDs = null;
		setView(null);
		viewEditorModel.dispose();
		viewEditorModel = null;
		contentProvider.dispose();
		contentProvider = null;
		vieverSelectionChangedListener = null;
		settingsViewer = null;

		commandStackEventListener = null;

		resetToDefaults.dispose();
		resetToDefaults = null;
		removeSequenceItemsAction.dispose();
		removeSequenceItemsAction = null;
		hideFromView.dispose();
		hideFromView = null;
		summaryModelRoot = null;
		errorsRoot = null;
		currentGroup = null;
		clearSettingAction.dispose();
		clearSettingAction = null;
		selectAll.dispose();
		selectAll = null;
		deselectAll.dispose();
		deselectAll = null;
		undoContext = null;
		if (propertySheetPage != null) {
			propertySheetPage.dispose();
			propertySheetPage = null;
		}
		navigatorViewer = null;

		mm.removeMenuListener(contextMenuListener);
		mm.dispose();
		mm = null;
		contextMenuListener = null;

		redoAction.dispose();
		redoAction = null;
		undoAction.dispose();
		undoAction = null;
		setInput(null);
		editorClosingListener = null;
		super.dispose();
	}

	private boolean closeDependentEditors() {
		// close all opened internal editors which are opened from this
		// CPFEditor
		List<?> listOfOpenedEditorParts = viewEditorModel
				.getListOfOpenedEditorParts();
		for (int i = listOfOpenedEditorParts.size() - 1; i >= 0; i--) {
			Object o = listOfOpenedEditorParts.get(i);
			if (o instanceof IEditorPart) {
				IEditorPart editor = (IEditorPart) o;
				boolean editorSaved = PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getActivePage()
						.closeEditor(editor, true);
				if (!editorSaved) {
					return false;
				}
			}
		}
		return true;
	}

	class Files2RemoveRunable implements Runnable {

		private List<File> filesToRemove;

		public Files2RemoveRunable(List<File> filesToRemove) {
			this.filesToRemove = filesToRemove;
		}

		public void run() {
			boolean result = true;

			for (File file : filesToRemove) {
				if (file.isDirectory()) {
					result = deleteDirectory(file);
				} else {
					result = file.delete();
				}
				if (!result) {
					if (!navigatorViewer.getControl().isDisposed()
							&& !navigatorViewer.getControl().getShell()
									.isDisposed()) {

						MessageDialog.openError(navigatorViewer.getControl()
								.getShell(), "Error", "File '" + file
								+ "' can't be deleted!");
						result = true;
					}
				}
			}
		}

	}

	/**
	 * Recursively remove files
	 * 
	 */
	public boolean deleteDirectory(File file) {
		if (file.exists()) {
			File[] files = file.listFiles();
			for (int i = 0; i < files.length; i++) {
				if (files[i].isDirectory()) {
					deleteDirectory(files[i]);
				} else {
					files[i].delete();
				}
			}
		}
		return (file.delete());
	}

	public void setSavePath(URI savePath) {
		this.savePath = savePath;
	}

	public URI getSavePath() {
		return savePath;
	}

	public void addSelectionChangedListener(ISelectionChangedListener listener) {
		listeners.add(listener);

	}

	/**
	 * Notify all listeners that selection has changed
	 * 
	 * @param event
	 */
	public void fireSelection(SelectionChangedEvent event) {

		for (int i = 0; i < listeners.size(); i++) {
			listeners.get(i).selectionChanged(event);
		}

	}

	public ISelection getSelection() {
		IStructuredSelection selection = (IStructuredSelection) settingsViewer
				.getSelection();
		return convertSelectionToMainModel(selection);
	}

	private ISelection convertSelectionToMainModel(
			IStructuredSelection selection) {
		List<Object> list = new ArrayList<Object>();
		Object[] array = selection.toArray();
		for (Object object : array) {
			if (object instanceof UIGroup) {
				UIGroup uiGroup = (UIGroup) object;
				Object model = uiGroup.getModel();
				if (model != null) {
					list.add(model);
				}
			} else if (object instanceof UISetting) {
				UISetting uiSetting = (UISetting) object;
				Setting setting = uiSetting.getSetting();
				if (setting != null) {
					list.add(setting);
				}
			} else if (object instanceof IStorage) {
				List<IStorage> list2 = new ArrayList<IStorage>();
				list2.add((IStorage) object);
				return new StructuredSelection(list2);
			} else if (object instanceof UIElement) {
				UIElement uiElement = (UIElement) object;
				return new StructuredSelection(uiElement);
			}
		}

		return new StructuredSelection(list);
	}

	protected ISelection convertSelectionToUIModel(
			IStructuredSelection selection) {
		List<UISetting> list = new ArrayList<UISetting>();
		Object[] array = selection.toArray();
		for (Object object : array) {
			if (object instanceof Setting) {
				Setting setting = (Setting) object;
				UISetting uiSetting = getUISetting(setting);
				if (uiSetting != null) {
					list.add(uiSetting);
				}
			} else if (object instanceof ResourceStorage) {
				List<ResourceStorage> list2 = new ArrayList<ResourceStorage>();
				list2.add((ResourceStorage) object);
				return new StructuredSelection(list2);
			} else if (object instanceof UIElement) {
				UIElement uiElement = (UIElement) object;
				return new StructuredSelection(uiElement);
			}
		}

		return new StructuredSelection(list);
	}

	public UISetting getUISetting(Setting setting) {
		EList<Adapter> adapters = setting.eAdapters();
		Adapter adapter = EcoreUtil.getAdapter(adapters,
				SettingToUISettingAdapter.class);
		if (adapter instanceof SettingToUISettingAdapter) {
			SettingToUISettingAdapter adapterImplementation = (SettingToUISettingAdapter) adapter;
			return adapterImplementation.getUiSetting();
		}

		return null;
	}

	public void removeSelectionChangedListener(
			ISelectionChangedListener listener) {
		if (listeners != null && listener != null) {
			listeners.remove(listener);
		}

	}

	public void setSelection(ISelection selection) {

		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			Object firstElement = structuredSelection.getFirstElement();
			if (firstElement instanceof Group) {
				navigatorViewer.setSelection(selection);
				return;
			}

			if (firstElement instanceof Setting) {
				firstElement = getTopSetting(firstElement);
				if (contains(currentGroup, (Setting) firstElement)) {

					StructuredSelection selection2 = new StructuredSelection(
							handleParentGroupSelection(structuredSelection,
									currentGroup));
					if (!navigatorViewer.getSelection().equals(selection2)) {
						navigatorViewer.setSelection(selection2);
					}
					selection = convertSelectionToUIModel((IStructuredSelection) selection);
				} else {
					Group leaf = findGroup((Setting) firstElement);
					if (leaf != null) {
						leaf = handleParentGroupSelection(structuredSelection,
								leaf);
						navigatorViewer.setSelection(new StructuredSelection(
								leaf));
						selection = convertSelectionToUIModel((IStructuredSelection) selection);
					}
				}

			} else if (firstElement instanceof UIElement) {
				if (getSummaryLeafGroup() != null)
					navigatorViewer.setSelection(new StructuredSelection(
							getSummaryLeafGroup()));
			}
		}
		settingsViewer.setSelection(selection, true);

	}

	private Group handleParentGroupSelection(
			IStructuredSelection structuredSelection, Group group) {
		if (group instanceof ParentGroup) {
			return group;
		}
		EList<Setting> settings = group.getSettings();
		List<?> list = structuredSelection.toList();
		for (Object object : list) {
			Setting topSetting = getTopSetting(object);
			if (!settings.contains(topSetting)) {

				return (Group) group.eContainer();
			}
		}
		return group;
	}

	private boolean contains(Group group, Setting setting) {
		if (group instanceof ParentGroup) {
			ParentGroup parentGroup = (ParentGroup) group;
			if (parentGroup.getSettings().contains(setting)) {
				return true;
			}
			EList<LeafGroup> leafGroups = parentGroup.getLeafGroup();
			for (LeafGroup leafGroup : leafGroups) {
				if (leafGroup.getSettings().contains(setting)) {
					return true;
				}
			}
		}
		if (group instanceof LeafGroup) {
			LeafGroup l = (LeafGroup) group;
			if (l.getSettings().contains(setting)) {
				return true;
			}
		}

		return false;

	}

	private Setting getTopSetting(Object firstElement) {
		if (firstElement instanceof FilePath) {
			FilePath filePath = (FilePath) firstElement;
			FileSystemEntrySetting parent = filePath.getParent();
			if (parent != null
					&& parent.eContainer() instanceof SequenceSetting) {
				return (Setting) parent.eContainer();
			} else {
				return parent;
			}
		}
		Setting setting = (Setting) firstElement;
		if (setting.eContainer() == null) {
			return setting;
		}
		EObject container = setting.eContainer().eContainer();
		if (container instanceof Setting) {
			firstElement = container;
		}
		return (Setting) firstElement;
	}

	private Group findGroup(Setting firstElement) {
		firstElement = getTopSetting(firstElement);
		EList<ParentGroup> parentGroups = getView().getParentGroup();
		for (ParentGroup parentGroup : parentGroups) {
			if (parentGroup.getSettings().contains(firstElement)) {
				return parentGroup;
			}
			EList<LeafGroup> leafGroups = parentGroup.getLeafGroup();
			for (LeafGroup leafGroup : leafGroups) {
				if (leafGroup.getSettings().contains(firstElement)) {
					return leafGroup;
				}
			}
		}
		return null;
	}

	public String getContributorId() {

		return PROPERTIES_CONTRIBUTOR_ID;
	}

	/**
	 * Create {@link SearchComposite}
	 * 
	 * @param parent
	 */
	public void createSearchComposite(Composite parent) {
		// search part
		sc = new SearchComposite(this);
		sc.createSearchComposite(formToolkit, parent, view);
		sc.getControl().addListener(SWT.Activate, lastActivationListener);

	}

	public int getNrOfNotes(View view) {
		int nrOfNotes = 0;
		EList<Setting> allSettings = view.getSharedSettingInstances();
		for (int i = 0; i < allSettings.size(); i++) {
			Setting setting = allSettings.get(i);
			if (!setting.isVisible()) {
				continue;
			}
			String note = setting.getNote();
			if (!(note == null)) {
				if (!note.equals("")) {
					nrOfNotes++;
				}
			}
		}
		return nrOfNotes;
	}

	public int getNrOfChanges(View view) {
		int nrOfChanges = 0;
		EList<Setting> allSettings = view.getSharedSettingInstances();

		for (int i = 0; i < allSettings.size(); i++) {
			Setting setting = allSettings.get(i);
			if (!setting.isDefault() && setting.isVisible()) {
				if (setting instanceof FileSystemEntrySetting) {
					FileSystemEntrySetting fileSystemSettingEntry = (FileSystemEntrySetting) setting;
					FilePath sourceFilePath = fileSystemSettingEntry
							.getSourceFilePath();
					FilePath targetFilePath = fileSystemSettingEntry
							.getTargetFilePath();
					if (isFileNonDefault(sourceFilePath)) {
						nrOfChanges++;
					}
					if (isFileNonDefault(targetFilePath)) {
						nrOfChanges++;
					}
				} else {
					nrOfChanges++;
				}
			}
		}
		return nrOfChanges;
	}

	private boolean isFileNonDefault(FilePath filePath) {
		if (!filePath.isDefault() && !filePath.isReadOnly()) {
			return true;
		}
		return false;
	}

	public Group getSelectedGroup() {
		IStructuredSelection selection = (IStructuredSelection) navigatorViewer
				.getSelection();
		Object firstElement = selection.getFirstElement();
		if (firstElement instanceof Group) {
			Group l = (Group) firstElement;

			return l;
		}

		return null;
	}

	/**
	 * Update errors model
	 * 
	 * @param notification
	 */
	private void updateErrors(Notification notification) {
		Object oldValue = notification.getOldValue();
		Object newValue = notification.getNewValue();
		if (oldValue instanceof SequenceItem) {
			SequenceItem item = (SequenceItem) oldValue;
			EList<Setting> settings = item.getSetting();
			for (Setting setting : settings) {
				Adapter adapter = EcoreUtil.getAdapter(setting.eAdapters(),
						SettingToErrorAdapter.class);
				if (adapter instanceof SettingToErrorAdapter) {
					SettingToErrorAdapter errorAdapter = (SettingToErrorAdapter) adapter;
					errorsRoot.getErrors().remove(errorAdapter.getError());
				}
			}
		}
		if (oldValue instanceof Setting) {
			Setting setting = (Setting) oldValue;
			Adapter adapter = EcoreUtil.getAdapter(setting.eAdapters(),
					SettingToErrorAdapter.class);
			if (adapter instanceof SettingToErrorAdapter) {
				SettingToErrorAdapter errorAdapter = (SettingToErrorAdapter) adapter;
				errorsRoot.getErrors().remove(errorAdapter.getError());
			}
		}

		if (newValue instanceof SequenceItem) {
			SequenceItem item = (SequenceItem) newValue;
			EList<Setting> settings = item.getSetting();
			for (Setting setting : settings) {

				updateErrorModelFor(setting);
			}
		}
		if (newValue instanceof Setting) {
			Setting setting = (Setting) newValue;
			updateErrorModelFor(setting);
		}
		Object notifier = notification.getNotifier();
		if (notifier instanceof Setting) {
			updateErrorModelFor((Setting) notifier);
		}

	}

	private void handleNotification() {

		if (currentGroup instanceof SummaryParentGroup
				|| currentGroup instanceof SummaryLeafGroup) {
			if (shouldRefresh) {
				navigatorViewer.refresh();
				updateSummaryStatistics();
			}
			return;
		}
		if (!shouldRefresh) {
			shouldRefresh = doStructuralRefresh;
			doStructuralRefresh = false;
		}
		if (shouldRefresh) {

			shouldRefresh = false;
			Group selectedGroup = getSelectedGroup();

			if (selectedGroup != null
					&& !(selectedGroup instanceof SummaryLeafGroup)) {
				Object model = null;
				if (isDirtySorting()) {
					model = getViewModelToUIModelConvertor()
							.createDirtyForGroup(selectedGroup);
				} else if (isErrorSorting()) {
					model = getViewModelToUIModelConvertor()
							.createErrorsForGroup(selectedGroup, errorsRoot);
				} else if (isNotesSorting()) {
					model = getViewModelToUIModelConvertor()
							.createNotesForGroup(selectedGroup);
				} else {
					model = getViewModelToUIModelConvertor().createUIModel(
							selectedGroup);
				}

				settingsViewer.setInput(model);
				refreshAndHandleWidgetState();

			}
			navigatorViewer.refresh();
		}

		Display.getCurrent().asyncExec(new Runnable() {

			public void run() {
				if (view == null) {
					return;
				}
				SettingEvaluator.validateConstraintAttributeForAllSettings(
						view, getErrorsRoot(), getViewEditorModel()
								.getResourceModelRoot(), CPFEditor.this);

			}

		});

	}

	/**
	 * Update widgets on summary
	 */
	private void updateSummaryStatistics() {
		EList<UISummaryGroup> uiGroups = summaryModelRoot.getUiGroups();
		for (UISummaryGroup summaryGroup : uiGroups) {
			EList<UIElement> uiElements = summaryGroup.getUiElements();
			for (UIElement element : uiElements) {
				settingsViewer.update(element, null);
			}
		}

	}

	void handleSelectionOnNavigator() {
		IStructuredSelection selection = (IStructuredSelection) navigatorViewer
				.getSelection();
		Object firstElement = currentGroup;

		if (firstElement instanceof Group) {
			Group l = (Group) firstElement;
			// detect deleting all settings
			// if is now undo action, this method don't know
			if (filterSettings(getAllSettings(l)).size() == 0) {
				ISelection sel = getNextItemSelection(l);
				if (sel != null) {

					navigatorViewer.setSelection(sel);

				}
			} else {
				if (!navigatorViewer.getSelection().equals(selection)) {
					navigatorViewer.setSelection(selection);
				}
			}
		}
	}

	private List<Setting> getAllSettings(Group l) {
		if (l instanceof ParentGroup) {
			List<Setting> settingList = new ArrayList<Setting>();
			settingList.addAll(l.getSettings());
			ParentGroup parentGroup = (ParentGroup) l;
			EList<LeafGroup> leafGroups = parentGroup.getLeafGroup();
			for (LeafGroup leafGroup : leafGroups) {
				settingList.addAll(leafGroup.getSettings());
			}
			return settingList;
		}
		return l.getSettings();
	}

	private ISelection getNextItemSelection(Group l) {
		if (l instanceof ParentGroup) {
			EList<ParentGroup> parentGroups = view.getParentGroup();
			int indexOf = parentGroups.indexOf(l);
			if (indexOf != -1) {
				if (parentGroups.size() > indexOf + 1) {
					ParentGroup element = parentGroups.get(indexOf + 1);
					if (filterSettings(getAllSettings(element)).size() > 0) {
						return new StructuredSelection(element);
					} else {
						return getNextItemSelection(element);
					}
				} else if (indexOf > 0) {
					ParentGroup element = parentGroups.get(indexOf - 1);
					if (filterSettings(getAllSettings(element)).size() > 0) {
						return new StructuredSelection(element);
					} else {
						return getNextItemSelection(element);
					}
				}
			} else {
				return StructuredSelection.EMPTY;
			}
		} else {
			LeafGroup newLeafGroup = null;
			ParentGroup parent = (ParentGroup) l.eContainer();
			EList<LeafGroup> leafGroups = parent.getLeafGroup();
			int index = leafGroups.indexOf(l);
			// if leafGroup is not last
			if ((leafGroups.size() - 1) > index) {
				newLeafGroup = leafGroups.get(index + 1);
				if (validateLeafGroup(newLeafGroup)) {
					return new StructuredSelection(newLeafGroup);
				}
				return getNextItemSelection(newLeafGroup);
			} else {
				View view = (View) parent.eContainer();
				EList<ParentGroup> parentGroupList = view.getParentGroup();
				index = parentGroupList.indexOf(parent);
				if ((parentGroupList.size() - 1) > index) {
					parent = parentGroupList.get(index + 1);
					leafGroups = parent.getLeafGroup();
					if (leafGroups != null && leafGroups.size() > 0)
						newLeafGroup = leafGroups.get(0);
					if (validateLeafGroup(newLeafGroup)) {
						return new StructuredSelection(newLeafGroup);
					}
					return getNextItemSelection(newLeafGroup);
				}
			}
			return getPrevItemSelection(l);
		}
		return StructuredSelection.EMPTY;
	}

	private ISelection getPrevItemSelection(Group l) {
		LeafGroup newLeafGroup = null;
		ParentGroup parent = (ParentGroup) l.eContainer();
		EList<LeafGroup> leafGroups = parent.getLeafGroup();
		int index = leafGroups.indexOf(l);
		// if leafGroup is not last
		if (index > 0) {
			newLeafGroup = leafGroups.get(index - 1);
			if (validateLeafGroup(newLeafGroup)) {
				return new StructuredSelection(newLeafGroup);
			}
			return getPrevItemSelection(newLeafGroup);
		} else {
			View view = (View) parent.eContainer();
			EList<ParentGroup> parentGroupList = view.getParentGroup();
			index = parentGroupList.indexOf(parent);
			while (index > 0) {
				newLeafGroup = null;
				parent = parentGroupList.get(index - 1);
				leafGroups = parent.getLeafGroup();
				if (leafGroups != null && leafGroups.size() > 0) {
					newLeafGroup = leafGroups.get(leafGroups.size() - 1);
				} else {
					index--;
				}
				if (validateLeafGroup(newLeafGroup)) {
					return new StructuredSelection(newLeafGroup);
				}
				if (newLeafGroup != null)
					return getPrevItemSelection(newLeafGroup);
			}
		}
		return null;
	}

	private boolean validateLeafGroup(LeafGroup newLeafGroup) {
		if (newLeafGroup == null) {
			return false;
		}
		if (newLeafGroup.getSettings() != null
				&& newLeafGroup.getSettings().size() > 0) {
			return true;
		}
		return false;
	}

	// //////////////// POPUP MENU ACTIONS //////////////////////
	protected void contextMenuAboutToShow(IMenuManager menu, Control parent) {

		menu.add(selectAll);
		menu.add(deselectAll);
		menu.add(new Separator());
		menu.add(clearSettingAction);
		menu.add(resetToDefaults);
		menu.add(new Separator());
		menu.add(hideFromView);
		menu.add(removeSequenceItemsAction);

		menu.add(new Separator());
		menu.add(cutAction);
		menu.add(copyAction);
		menu.add(pasteAction);
		menu.add(deleteAction);
		menu.add(new Separator());

		if (dirty) {
			menu.markDirty();
		}
		updateEditActionState(getSelection());
	}

	/**
	 * @param selection
	 */
	public void updateEditActionState(ISelection selection) {
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			Object element = structuredSelection.getFirstElement();

			if (element instanceof Setting) {
				switchSettingType(((Setting) element).getType());
			} else if (element instanceof UISetting) {
				UISetting uiSetting = (UISetting) element;
				switchSettingType(uiSetting.getSetting().getType());
			} else if (element instanceof UIElement) {
				UIElement uiElement = (UIElement) element;
				switchSettingType(uiElement.getType());
			} else if (element instanceof UIGroup) {
				enableEditActions(false);
			} else if (element instanceof Feature) {
				enableEditActions(false);
			} else if (element == null) {
				enableEditActions(false);
			} else {
				enableEditActions(true);
			}
		}
	}

	private void switchSettingType(SUMMARYTYPE type) {
		switch (type.getValue()) {
		case SUMMARYTYPE.DESCRIPTION_VALUE:
			enableEditActions(true);
			break;
		case SUMMARYTYPE.AVR_VALUE:
			enableEditActions(true);
			break;
		case SUMMARYTYPE.CUSTOMER_VALUE:
			enableEditActions(true);
			break;
		case SUMMARYTYPE.OWNER_VALUE:
			enableEditActions(true);
			break;
		case SUMMARYTYPE.AUTHOR_VALUE:
			enableEditActions(true);
			break;
		default:
			enableEditActions(false);
			break;
		}
	}

	private void switchSettingType(TYPE type) {
		switch (type.getValue()) {
		case TYPE.BOOLEAN_VALUE:
			enableEditActions(false);
			break;
		case TYPE.SELECTION_VALUE:
			enableEditActions(false);
			break;
		case TYPE.MULTISELECTION_VALUE:
			enableEditActions(false);
			break;
		case TYPE.SEQUENCE_VALUE:
			enableEditActions(false);
			break;
		default:
			enableEditActions(true);
			break;
		}
	}

	public void enableEditActions(boolean enable) {
		cutAction.setEnabled(enable);
		copyAction.setEnabled(enable);
		pasteAction.setEnabled(enable);
		deleteAction.setEnabled(enable);
		getEditorSite().getActionBars().updateActionBars();
	}

	class MenuListener implements IMenuListener {
		private Control parent;

		public MenuListener(Control parent) {
			this.parent = parent;
		}

		public void menuAboutToShow(IMenuManager menu) {
			contextMenuAboutToShow(menu, parent);
		}
	}

	protected IMenuListener contextMenuListener(Control parent) {
		if (fMenuListener == null) {
			fMenuListener = new MenuListener(parent);
		}
		return fMenuListener;
	}

	public UISummaryModel getSummaryModelroot() {
		return summaryModelRoot;
	}

	/**
	 * Refresh {@link SettingsViewer}, keep selection and collapsed widgets
	 */
	public void refreshAndHandleWidgetState() {

		List<Object> collapsedElementsList = settingsViewer
				.getCollapsedElements();
		List<Setting> collapsedElementsFromView = new ArrayList<Setting>();
		for (Object object : collapsedElementsList) {
			if (object instanceof UISetting) {
				UISetting ui = (UISetting) object;
				Setting setting = ui.getSetting();
				if (setting != null) {
					collapsedElementsFromView.add(setting);
				} else {
					EList<UISetting> children = ui.getChildren();
					if (children.size() > 0) {
						Setting setting2 = children.get(0).getSetting();
						if (setting2 != null) {
							collapsedElementsFromView.add(setting2);
						}
					}
				}
			}
		}
		ISelection keepSelection = getSelection();
		Display.getCurrent().asyncExec(
				new HandleWidgetStateRunnable(collapsedElementsFromView,
						keepSelection, this));

	}

	public IPath getFullPath() {
		return fullPath;
	}

	public void setFullPath(Path path) {
		this.fullPath = path;

	}

	public void setStructuralCommands(int structuralCommands) {
		this.structuralCommands = structuralCommands;
	}

	public int getStructuralCommands() {
		return structuralCommands;
	}

	public void setStructuralCommandsSaveLocation(
			int structuralCommandsSaveLocation) {
		this.structuralCommandsSaveLocation = structuralCommandsSaveLocation;
	}

	public int getStructuralCommandsSaveLocation() {
		return structuralCommandsSaveLocation;
	}

	public ViewModelToUIModelConvertor getViewModelToUIModelConvertor() {
		return viewModelToUIModelConvertor;
	}

	public void setDirtySorting(boolean dirtySorting) {
		this.dirtySorting = dirtySorting;
	}

	public boolean isDirtySorting() {
		return dirtySorting;
	}

	public void setNotesSorting(boolean notesSorting) {
		this.notesSorting = notesSorting;
	}

	public boolean isNotesSorting() {
		return notesSorting;
	}

	public void setErrorSorting(boolean errorSorting) {
		this.errorSorting = errorSorting;
	}

	public boolean isErrorSorting() {
		return errorSorting;
	}

	public void setSummaryLeafGroup(SummaryLeafGroup summaryLeafGroup) {
		this.summaryLeafGroup = summaryLeafGroup;
	}

	public SummaryLeafGroup getSummaryLeafGroup() {
		return summaryLeafGroup;
	}

	public void setSummaryModelRoot(UISummaryModel summaryModelRoot) {
		this.summaryModelRoot = summaryModelRoot;
	}

	public void setCurrentGroup(Group group) {
		currentGroup = group;

	}

	public SearchComposite getSc() {
		return sc;
	}


	protected void handleNotification(Notification notification) {
		Object oldValue = notification.getOldValue();
		Object newValue = notification.getNewValue();
		if (oldValue instanceof SequenceItem) {
			SequenceItem item = (SequenceItem) oldValue;
			EList<Setting> settings = item.getSetting();
			Setting setting = settings.get(0);
			Adapter adapter = EcoreUtil.getAdapter(setting.eAdapters(), SettingToUISettingAdapter.class);
			if(adapter instanceof SettingToUISettingAdapter){
				UISetting uiSetting = ((SettingToUISettingAdapter)adapter).getUiSetting();
				settingsViewer.refresh(uiSetting.eContainer());
			}

		}
		if (oldValue instanceof Setting) {
			Setting setting = (Setting) oldValue;
			Adapter adapter = EcoreUtil.getAdapter(setting.eAdapters(),
					SettingToUISettingAdapter.class);
			if (adapter instanceof SettingToUISettingAdapter) {
				SettingToUISettingAdapter uiSettingAdapter = (SettingToUISettingAdapter) adapter;
				UISetting uiSetting = uiSettingAdapter.getUiSetting();
				EObject container = uiSetting.eContainer();
				if(container instanceof UIGroup){
					UIGroup group = (UIGroup)container;
					uiSettingAdapter.setIndex(group.getUiSettings().indexOf(uiSetting));
					group.getUiSettings().remove(uiSetting);
				}
				settingsViewer.refresh(uiSetting);
			}
		}
		
		if (newValue instanceof SequenceItem) {
			SequenceItem item = (SequenceItem) newValue;
			EList<Setting> settings = item.getSetting();
			Setting setting = settings.get(0);
			Adapter adapter = EcoreUtil.getAdapter(setting.eAdapters(), SettingToUISettingAdapter.class);
			if(adapter instanceof SettingToUISettingAdapter){
				UISetting uiSetting = ((SettingToUISettingAdapter)adapter).getUiSetting();
				settingsViewer.refresh(uiSetting.eContainer());
			}
		}
		if (newValue instanceof Setting &&((Setting)newValue).eContainer()!=null) {
			Setting setting = (Setting) newValue;
			Adapter adapter = EcoreUtil.getAdapter(setting.eAdapters(),
					SettingToUISettingAdapter.class);
			if (adapter instanceof SettingToUISettingAdapter) {
				SettingToUISettingAdapter uiSettingAdapter = (SettingToUISettingAdapter) adapter;
				UISetting uiSetting = uiSettingAdapter.getUiSetting();
			String featureRef = setting.getFeatureRef();
			Object input = settingsViewer.getInput();
			if(input instanceof UIModel){
				UIModel model = (UIModel)input;
				EList<UIGroup> uiGroups = model.getUiGroups();
				for (UIGroup group : uiGroups) {
					Object model2 = group.getModel();
					if((model2 instanceof Feature)&&((Feature)model2).getRef().equals(featureRef)){
						
						group.getUiSettings().add(uiSettingAdapter.getIndex(), uiSetting)	;
						break;
						
					}
					EList<UIGroup> uiGroups2 = group.getUiGroups();
					for (UIGroup group2 : uiGroups2) {
						Object model3 = group2.getModel();
						if((model3 instanceof Feature)&&((Feature)model3).getRef().equals(featureRef)){
							
							group2.getUiSettings().add(uiSettingAdapter.getIndex(), uiSetting)	;
							break;
							
						}
					}
				}
			}
			if(input instanceof UIGroup){
				((UIGroup) input).getUiSettings().add(uiSettingAdapter.getIndex(), uiSetting)	;
			}
				settingsViewer.refresh(uiSetting);
			}
		}
		
	}

}
