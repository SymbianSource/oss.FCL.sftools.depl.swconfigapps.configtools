/*
* Copyright (c) 2007 Nokia Corporation and/or its subsidiary(-ies). 
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
package com.nokia.tools.s60ct.model.confml.presentation;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EventObject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.Map.Entry;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.ui.MarkerHelper;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.ui.editor.ProblemEditorPart;
import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.action.EditingDomainActionBarContributor;
import org.eclipse.emf.edit.ui.dnd.EditingDomainViewerDropAdapter;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.emf.edit.ui.dnd.ViewerDragAdapter;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.edit.ui.provider.UnwrappingSelectionProvider;
import org.eclipse.emf.edit.ui.util.EditUIMarkerHelper;
import org.eclipse.emf.edit.ui.util.EditUIUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.TransactionalCommandStack;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.WorkbenchException;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.ide.IGotoMarker;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.MultiPageEditorPart;
import org.eclipse.ui.views.contentoutline.ContentOutline;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.PropertySheet;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import com.nokia.tools.s60ct.build.builder.CrmlBuilder;
import com.nokia.tools.s60ct.build.builder.NotesBuilder;
import com.nokia.tools.s60ct.confml.actions.DuplicateSequencesAction;
import com.nokia.tools.s60ct.confml.actions.MoveDownAction;
import com.nokia.tools.s60ct.confml.actions.MoveUpAction;
import com.nokia.tools.s60ct.confml.actions.OpenConfmlAction;
import com.nokia.tools.s60ct.confml.actions.OpenDataConfmlAction;
import com.nokia.tools.s60ct.confml.actions.OpenImplementationAction;
import com.nokia.tools.s60ct.confml.actions.ResetToDefaultAction;
import com.nokia.tools.s60ct.confml.editor.ConfmlEditorUtil;
import com.nokia.tools.s60ct.confml.editor.ValueEditorInputAppFeature;
import com.nokia.tools.s60ct.confml.editor.ValueEditorInputAppGroup;
import com.nokia.tools.s60ct.confml.editor.converter.IVEModel2ConfMLPMConverter;
import com.nokia.tools.s60ct.confml.editor.converter.VEModel2ConfMLPMConverterFactory;
import com.nokia.tools.s60ct.confml.viewer.FeatureViewer;
import com.nokia.tools.s60ct.confml.viewer.NotesView;
import com.nokia.tools.s60ct.model.confml.EFeature;
import com.nokia.tools.s60ct.model.confml.ESequenceSetting;
import com.nokia.tools.s60ct.model.confml.ESequenceValue;
import com.nokia.tools.s60ct.model.confml.ESequenceValueItem;
import com.nokia.tools.s60ct.model.confml.ESetting;
import com.nokia.tools.s60ct.model.confml.EValueEditorDocument;
import com.nokia.tools.s60ct.model.confml.View;
import com.nokia.tools.s60ct.model.confml.util.AppModel2EditorModelConverter;
import com.nokia.tools.s60ct.model.confml.util.SettingEvaluator;
import com.nokia.tools.s60ct.resources.model.ELibraryRoot;
import com.nokia.tools.variant.confml.core.ConfMLCore;
import com.nokia.tools.vct.common.appmodel.EAppFeature;
import com.nokia.tools.vct.common.appmodel.EAppGroup;
import com.nokia.tools.vct.common.appmodel.EAppGroupContainer;
import com.nokia.tools.vct.common.appmodel.EAppIncludeElement;
import com.nokia.tools.vct.common.appmodel.EAppNamedItem;
import com.nokia.tools.vct.common.appmodel.EAppResourceData;
import com.nokia.tools.vct.common.appmodel.EAppSequenceData;
import com.nokia.tools.vct.common.appmodel.EAppSequenceDataItem;
import com.nokia.tools.vct.common.appmodel.EAppSetting;
import com.nokia.tools.vct.common.appmodel.EAppSettingData;
import com.nokia.tools.vct.common.appmodel.EAppSettingOption;
import com.nokia.tools.vct.common.appmodel.EAppSettingType;
import com.nokia.tools.vct.common.appmodel.EAppSimpleData;
import com.nokia.tools.vct.common.appmodel.EAppSimpleType;
import com.nokia.tools.vct.common.appmodel.EAppValueType;
import com.nokia.tools.vct.common.appmodel.EAppView;
import com.nokia.tools.vct.common.appmodel.EConfMLLayer;
import com.nokia.tools.vct.common.appmodel.EConfigurationProject;
import com.nokia.tools.vct.common.core.utils.StringEscapeUtils;
import com.nokia.tools.vct.confml.model.confml1.EConfMLDocument;
import com.nokia.tools.vct.confml.model.confml1.include.EConfMLIncludeFactory;
import com.nokia.tools.vct.confml.model.confml1.include.EInclude;
import com.nokia.tools.vct.confml.model.confml2.EConfML2Document;
import com.nokia.tools.vct.confml.model.confml2.util.EConfML2ResourceFactoryImpl;

/**
 * ConfML values editor for variant engineers.
 *
 * @generated NOT
 */
public class ConfmlEditor extends MultiPageEditorPart implements
		IEditingDomainProvider, ISelectionProvider, IMenuListener,
		IViewerProvider, ITabbedPropertySheetPageContributor, IGotoMarker {

	public static final String CONFML_EDITOR_ID = "com.nokia.tools.s60ct.model.confml.presentation.ConfmlEditorID";
	private static final String PROPERTIES_CONTRIBUTOR_ID = "com.nokia.tools.s60ct.editor.editors.CONFML_EDITOR_TABBED_PROPERTIES_CONTRIBUTOR";
	private URI resourceUri=null;
	
	// popup actions
	ResetToDefaultAction resetToDefaults = null;
	MoveUpAction moveUpAction = null;
	MoveDownAction moveDownAction = null;
	DuplicateSequencesAction duplicateAction = null;
	OpenDataConfmlAction openDataConfmlAction = null;
	OpenConfmlAction openConfmlAction = null;
	OpenImplementationAction openImplAction = null;
	//private WorkspaceJob job;
	private IMenuListener contextMenuListener;
	private IMenuListener fMenuListener;
	private MenuManager menuManager;

	//private ViewEditorModel viewEditorModel;
	
	class MenuListener implements IMenuListener {
		private Control parent;

		public MenuListener(Control parent) {
			this.parent = parent;
		}

		public void menuAboutToShow(IMenuManager menu) {
			contextMenuAboutToShow(menu, parent);
		}
	}
	/**
	 * This keeps track of the editing domain that is used to track all changes
	 * to the model. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected AdapterFactoryEditingDomain editingDomain;

	/**
	 * This is the one adapter factory used for providing views of the model.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ComposedAdapterFactory adapterFactory;

	/**
	 * This is the content outline page. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected IContentOutlinePage contentOutlinePage;

	/**
	 * This is a kludge... <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected IStatusLineManager contentOutlineStatusLineManager;

	/**
	 * This is the content outline page's viewer. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected TreeViewer contentOutlineViewer;

	/**
	 * This is the property sheet page. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected TabbedPropertySheetPage propertySheetPage;

	/**
	 * This is the viewer that shadows the selection in the content outline. The
	 * parent relation must be correctly defined for this to work. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected TreeViewer selectionViewer;

	/**
	 * This keeps track of the active content viewer, which may be either one of
	 * the viewers in the pages or the content outline viewer. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected Viewer currentViewer;

	/**
	 * This listens to which ever viewer is active. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected ISelectionChangedListener selectionChangedListener;

	/**
	 * This keeps track of all the
	 * {@link org.eclipse.jface.viewers.ISelectionChangedListener}s that are
	 * listening to this editor. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected List<ISelectionChangedListener> selectionChangedListeners = new ArrayList<ISelectionChangedListener>();

	/**
	 * This keeps track of the selection of the editor as a whole. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ISelection editorSelection = StructuredSelection.EMPTY;

	/**
	 * The MarkerHelper is responsible for creating workspace resource markers
	 * presented in Eclipse's Problems View. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected MarkerHelper markerHelper = new EditUIMarkerHelper();

	private FormToolkit formToolkit;
	private FeatureViewer featureViewer;

	private EValueEditorDocument editorModel;
	private Form form;
	private boolean isNotesDirty;


	/**
	 * This listens for when the outline becomes active <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected IPartListener partListener = new IPartListener() {
		public void partActivated(IWorkbenchPart p) {
			if (p instanceof ContentOutline) {
				if (((ContentOutline) p).getCurrentPage() == contentOutlinePage) {
					getActionBarContributor()
							.setActiveEditor(ConfmlEditor.this);

					setCurrentViewer(contentOutlineViewer);
				}
			} else if (p instanceof PropertySheet) {
				if (((PropertySheet) p).getCurrentPage() == propertySheetPage) {
					getActionBarContributor()
							.setActiveEditor(ConfmlEditor.this);
					handleActivate();
				}
			} else if (p == ConfmlEditor.this) {
				handleActivate();
			}
		}

		public void partBroughtToTop(IWorkbenchPart p) {
			// Ignore.
		}

		public void partClosed(IWorkbenchPart p) {
			// Ignore.
		}

		public void partDeactivated(IWorkbenchPart p) {
			// Ignore.
		}

		public void partOpened(IWorkbenchPart p) {
			// Ignore.
		}
	};

	/**
	 * Resources that have been removed since last activation. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected Collection<Resource> removedResources = new ArrayList<Resource>();

	/**
	 * Resources that have been changed since last activation. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected Collection<Resource> changedResources = new ArrayList<Resource>();

	/**
	 * Resources that have been saved. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	protected Collection<Resource> savedResources = new ArrayList<Resource>();

	/**
	 * Map to store the diagnostic associated with a resource. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected Map<Resource, Diagnostic> resourceToDiagnosticMap = new LinkedHashMap<Resource, Diagnostic>();

	/**
	 * Controls whether the problem indication should be updated. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected boolean updateProblemIndication = true;

	/**
	 * Adapter used to update the problem indication when resources are demanded
	 * loaded. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EContentAdapter problemIndicationAdapter = new EContentAdapter() {
		@Override
		public void notifyChanged(Notification notification) {
			if (notification.getNotifier() instanceof Resource) {
				switch (notification.getFeatureID(Resource.class)) {
				case Resource.RESOURCE__IS_LOADED:
				case Resource.RESOURCE__ERRORS:
				case Resource.RESOURCE__WARNINGS: {
					Resource resource = (Resource) notification.getNotifier();
					Diagnostic diagnostic = analyzeResourceProblems(resource,
							null);
					if (diagnostic.getSeverity() != Diagnostic.OK) {
						resourceToDiagnosticMap.put(resource, diagnostic);
					} else {
						resourceToDiagnosticMap.remove(resource);
					}

					if (updateProblemIndication) {
						getSite().getShell().getDisplay().asyncExec(
								new Runnable() {
									public void run() {
										updateProblemIndication();
									}
								});
					}
					break;
				}
				}
			} else {
				super.notifyChanged(notification);
			}
		}

		@Override
		protected void setTarget(Resource target) {
			basicSetTarget(target);
		}

		@Override
		protected void unsetTarget(Resource target) {
			basicUnsetTarget(target);
		}
	};

	/**
	 * This listens for workspace changes. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
//	protected IResourceChangeListener resourceChangeListener = new IResourceChangeListener() {
//		public void resourceChanged(IResourceChangeEvent event) {
//			IResourceDelta delta = event.getDelta();
//			try {
//				class ResourceDeltaVisitor implements IResourceDeltaVisitor {
//					protected ResourceSet resourceSet = editingDomain
//							.getResourceSet();
//					protected Collection<Resource> changedResources = new ArrayList<Resource>();
//					protected Collection<Resource> removedResources = new ArrayList<Resource>();
//
//					public boolean visit(IResourceDelta delta) {
//						if (delta.getResource().getType() == IResource.FILE) {
//							if (delta.getKind() == IResourceDelta.REMOVED
//									|| delta.getKind() == IResourceDelta.CHANGED
//									&& delta.getFlags() != IResourceDelta.MARKERS) {
//								Resource resource = resourceSet.getResource(URI
//										.createURI(delta.getFullPath()
//												.toString()), false);
//								if (resource != null) {
//									if (delta.getKind() == IResourceDelta.REMOVED) {
//										removedResources.add(resource);
//									} else if (!savedResources.remove(resource)) {
//										changedResources.add(resource);
//									}
//								}
//							}
//						}
//
//						return true;
//					}
//
//					public Collection<Resource> getChangedResources() {
//						return changedResources;
//					}
//
//					public Collection<Resource> getRemovedResources() {
//						return removedResources;
//					}
//				}
//
//				ResourceDeltaVisitor visitor = new ResourceDeltaVisitor();
//				delta.accept(visitor);
//
//				if (!visitor.getRemovedResources().isEmpty()) {
//					removedResources.addAll(visitor.getRemovedResources());
//					if (!isDirty()) {
//						getSite().getShell().getDisplay().asyncExec(
//								new Runnable() {
//									public void run() {
//										getSite().getPage().closeEditor(
//												ConfmlEditor.this, false);
//									}
//								});
//					}
//				}
//
//				if (!visitor.getChangedResources().isEmpty()) {
//					changedResources.addAll(visitor.getChangedResources());
//					if (getSite().getPage().getActiveEditor() == ConfmlEditor.this) {
//						getSite().getShell().getDisplay().asyncExec(
//								new Runnable() {
//									public void run() {
//										handleActivate();
//									}
//								});
//					}
//				}
//			} catch (CoreException exception) {
//				ConfmlFeatureEditorPlugin.INSTANCE.log(exception);
//			}
//		}
//	};

	
	
	protected IResourceChangeListener resourceChangeListener = new IResourceChangeListener() 
	{
		public void resourceChanged(IResourceChangeEvent event)
		{
			//IResourceDelta delta = event.getDelta();
			updateErrors();
		}
	};
	
	public FeatureViewer getFeatureViewer() {
		return featureViewer;
	}

	/**
	 * Handles activation of the editor or it's associated views. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void handleActivate() {
		// Recompute the read only state.
		//
		featureViewer.relevantChange();
		
		if (editingDomain.getResourceToReadOnlyMap() != null) {
			editingDomain.getResourceToReadOnlyMap().clear();

			// Refresh any actions that may become enabled or disabled.
			//
			setSelection(getSelection());
		}

		if (!removedResources.isEmpty()) {
			if (handleDirtyConflict()) {
				getSite().getPage().closeEditor(ConfmlEditor.this, false);
			} else {
				removedResources.clear();
				changedResources.clear();
				savedResources.clear();
			}
		} else if (!changedResources.isEmpty()) {
			changedResources.removeAll(savedResources);
			handleChangedResources();
			changedResources.clear();
			savedResources.clear();
		}
	}

	protected void contextMenuAboutToShow(IMenuManager menu, Control parent) {
		menu.add(resetToDefaults);
		menu.add(moveUpAction);
		menu.add(moveDownAction);
		menu.add(duplicateAction);
		menu.add(new Separator());
		menu.add(openConfmlAction);
		menu.add(openDataConfmlAction);
		menu.add(openImplAction);
//
//		if (dirty) {
//			menu.markDirty();
//		}
	}

	/**
	 * Handles what to do with changed resources on activation. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void handleChangedResources() {
		if (!changedResources.isEmpty()
				&& (!isDirty() || handleDirtyConflict())) {
			
			
			if (isDirty()) {
				changedResources.addAll(editingDomain.getResourceSet()
						.getResources());
			}
			editingDomain.getCommandStack().flush();

			updateProblemIndication = false;
			for (Resource resource : changedResources) {
				if (resource.isLoaded()) {
					resource.unload();
					try {
						resource.load(Collections.EMPTY_MAP);
					} catch (IOException exception) {
						if (!resourceToDiagnosticMap.containsKey(resource)) {
							resourceToDiagnosticMap
									.put(resource, analyzeResourceProblems(
											resource, exception));
						}
					}
				}
			}

			if (AdapterFactoryEditingDomain.isStale(editorSelection)) {
				setSelection(StructuredSelection.EMPTY);
			}

//			updateProblemIndication = true;
//			updateProblemIndication();
		}
	}

	/**
	 * Updates the problems indication with the information described in the
	 * specified diagnostic. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void updateProblemIndication() {
		if (updateProblemIndication) {
			BasicDiagnostic diagnostic = new BasicDiagnostic(Diagnostic.OK,
					"com.nokia.tools.s60ct.confml.editor", 0, null,
					new Object[] { editingDomain.getResourceSet() });
			for (Diagnostic childDiagnostic : resourceToDiagnosticMap.values()) {
				if (childDiagnostic.getSeverity() != Diagnostic.OK) {
					diagnostic.add(childDiagnostic);
				}
			}

			int lastEditorPage = getPageCount() - 1;
			if (lastEditorPage >= 0
					&& getEditor(lastEditorPage) instanceof ProblemEditorPart) {
				((ProblemEditorPart) getEditor(lastEditorPage))
						.setDiagnostic(diagnostic);
				if (diagnostic.getSeverity() != Diagnostic.OK) {
					setActivePage(lastEditorPage);
				}
			} else if (diagnostic.getSeverity() != Diagnostic.OK) {
				ProblemEditorPart problemEditorPart = new ProblemEditorPart();
				problemEditorPart.setDiagnostic(diagnostic);
				problemEditorPart.setMarkerHelper(markerHelper);
				try {
					addPage(++lastEditorPage, problemEditorPart,
							getEditorInput());
					setPageText(lastEditorPage, problemEditorPart.getPartName());
					setActivePage(lastEditorPage);
					showTabs();
				} catch (PartInitException exception) {
					ConfmlFeatureEditorPlugin.INSTANCE.log(exception);
				}
			}

			if (markerHelper.hasMarkers(editingDomain.getResourceSet())) {
				markerHelper.deleteMarkers(editingDomain.getResourceSet());
				if (diagnostic.getSeverity() != Diagnostic.OK) {
					try {
						markerHelper.createMarkers(diagnostic);
					} catch (CoreException exception) {
						ConfmlFeatureEditorPlugin.INSTANCE.log(exception);
					}
				}
			}
		}
		
		updateErrors();
		
	}

	/**
	 * Shows a dialog that asks if conflicting changes should be discarded. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected boolean handleDirtyConflict() {
		return MessageDialog.openQuestion(getSite().getShell(),
				getString("_UI_FileConflict_label"),
				getString("_WARN_FileConflict"));
	}

	/**
	 * This creates a model editor. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	public ConfmlEditor() {
		super();
		initializeEditingDomain();
	}

	/**
	 * This sets up the editing domain for the model editor. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void initializeEditingDomain() {
		// Create an adapter factory that yields item providers.
		//
		adapterFactory = new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		adapterFactory
				.addAdapterFactory(new ResourceItemProviderAdapterFactory());
//		adapterFactory
//				.addAdapterFactory(new ConfmlItemProviderAdapterFactory());
		adapterFactory
				.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

		// Create the command stack that will notify this editor as commands are
		// executed.
		//
		BasicCommandStack commandStack = new BasicCommandStack();

		// Add a listener to set the most recent command's affected objects to
		// be the selection of the viewer with focus.
		//
		commandStack.addCommandStackListener
		(new CommandStackListener() {
			public void commandStackChanged(final EventObject event) {
				getContainer().getDisplay().asyncExec
				(new Runnable() {
					public void run() {
						firePropertyChange(IEditorPart.PROP_DIRTY);

						// Try to select the affected objects.
						//
						Command mostRecentCommand =
							((CommandStack)event.getSource()).getMostRecentCommand();
						if (mostRecentCommand != null) {
							setSelectionToViewer(mostRecentCommand.getAffectedObjects());
						}
//						if (propertySheetPage != null &&
//								!propertySheetPage.getControl().isDisposed()) {
//							propertySheetPage.refresh();
//						}
					}
				});
			}
		});

		// Create the editing domain with a special command stack.
		//
		editingDomain = new AdapterFactoryEditingDomain(adapterFactory, commandStack,
				new HashMap<Resource, Boolean>());
	}

	/**
	 * This is here for the listener to be able to call it. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected void firePropertyChange(int action) {
		super.firePropertyChange(action);
	}

	/**
	 * This sets the selection into whichever viewer is active. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setSelectionToViewer(Collection<?> collection) {
		final Collection<?> theSelection = collection;
		// Make sure it's okay.
		//
		if (theSelection != null && !theSelection.isEmpty()) {
			// I don't know if this should be run this deferred
			// because we might have to give the editor a chance to process the
			// viewer update events
			// and hence to update the views first.
			//
			//
			Runnable runnable = new Runnable() {
				public void run() {
					// Try to select the items in the current content viewer of
					// the editor.
					//
					if (currentViewer != null) {
						currentViewer.setSelection(new StructuredSelection(
								theSelection.toArray()), true);
					}
				}
			};
			runnable.run();
		}
	}

	/**
	 * This returns the editing domain as required by the
	 * {@link IEditingDomainProvider} interface. This is important for
	 * implementing the static methods of {@link AdapterFactoryEditingDomain}
	 * and for supporting {@link org.eclipse.emf.edit.ui.action.CommandAction}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EditingDomain getEditingDomain() {
		return editingDomain;
	}

	
	public CommandStack getCommandStack() {
		return editingDomain.getCommandStack();
	}
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public class ReverseAdapterFactoryContentProvider extends
			AdapterFactoryContentProvider {
		/**
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		public ReverseAdapterFactoryContentProvider(
				AdapterFactory adapterFactory) {
			super(adapterFactory);
		}

		/**
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		@Override
		public Object[] getElements(Object object) {
			Object parent = super.getParent(object);
			return (parent == null ? Collections.EMPTY_SET : Collections
					.singleton(parent)).toArray();
		}

		/**
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		@Override
		public Object[] getChildren(Object object) {
			Object parent = super.getParent(object);
			return (parent == null ? Collections.EMPTY_SET : Collections
					.singleton(parent)).toArray();
		}

		/**
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		@Override
		public boolean hasChildren(Object object) {
			Object parent = super.getParent(object);
			return parent != null;
		}

		/**
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		@Override
		public Object getParent(Object object) {
			return null;
		}
	}

	/**
	 * This makes sure that one content viewer, either for the current page or
	 * the outline view, if it has focus, is the current one. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setCurrentViewer(Viewer viewer) {
		// If it is changing...
		//
		if (currentViewer != viewer) {
			if (selectionChangedListener == null) {
				// Create the listener on demand.
				//
				selectionChangedListener = new ISelectionChangedListener() {
					// This just notifies those things that are affected by the
					// section.
					//
					public void selectionChanged(
							SelectionChangedEvent selectionChangedEvent) {
						setSelection(selectionChangedEvent.getSelection());
					}
				};
			}

			// Stop listening to the old one.
			//
			if (currentViewer != null) {
				currentViewer
						.removeSelectionChangedListener(selectionChangedListener);
			}

			// Start listening to the new one.
			//
			if (viewer != null) {
				viewer.addSelectionChangedListener(selectionChangedListener);
			}

			// Remember it.
			//
			currentViewer = viewer;

			// Set the editors selection based on the current viewer's
			// selection.
			//
			setSelection(currentViewer == null ? StructuredSelection.EMPTY
					: currentViewer.getSelection());
		}
	}

	/**
	 * This returns the viewer as required by the {@link IViewerProvider}
	 * interface. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Viewer getViewer() {
		return featureViewer;
	}

	/**
	 * This creates a context menu for the viewer and adds a listener as well
	 * registering the menu for extension. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected void createContextMenuFor(StructuredViewer viewer) {
		MenuManager contextMenu = new MenuManager("#PopUp");
		contextMenu.add(new Separator("additions"));
		contextMenu.setRemoveAllWhenShown(true);
		contextMenu.addMenuListener(this);
		Menu menu = contextMenu.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(contextMenu,
				new UnwrappingSelectionProvider(viewer));

		int dndOperations = DND.DROP_COPY | DND.DROP_MOVE | DND.DROP_LINK;
		Transfer[] transfers = new Transfer[] { LocalTransfer.getInstance() };
		viewer.addDragSupport(dndOperations, transfers, new ViewerDragAdapter(
				viewer));
		viewer.addDropSupport(dndOperations, transfers,
				new EditingDomainViewerDropAdapter(editingDomain, viewer));
	}

	
	private View getAllView(IEditorInput input)
	{
		View view = (View)CrmlBuilder.getView();
		
		if (view ==null)
		{
			EConfigurationProject configurationProject = getConfigurationProject(((URIEditorInput) input).getURI());
			view = new AppModel2EditorModelConverter().createAllView(configurationProject);
			CrmlBuilder.setView(view);
			
//			viewEditorModel = new ViewEditorModel();
//			viewEditorModel.setView(view);
//			
//			viewEditorModel.setResourceModelRoot(CrmlBuilder.getResourceModelRoot());
			
			
//			SettingEvaluator.validateConstraintAttributeForAllSettings(view, null, viewEditorModel.getResourceModelRoot(), null);
		}
		return view;
	}
	
	/**
	 * This is the method called to load a resource into the editing domain's
	 * resource set based on the editor's input. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void createModel() {
		
		EObject input;
		URI resourceURI = EditUIUtil.getURI(getEditorInput());
		IEditorInput editorInput = getEditorInput();

		View v = getAllView(editorInput);
		
		if (editorInput  instanceof ValueEditorInputAppFeature) {
			ValueEditorInputAppFeature featureInput = (ValueEditorInputAppFeature) editorInput;
			input = featureInput.getFeature();
		} else if (editorInput instanceof ValueEditorInputAppGroup){
			ValueEditorInputAppGroup groupInput = (ValueEditorInputAppGroup) editorInput;
			input = groupInput.getGroup();
		} else {
			EAppNamedItem namedInput = (EAppNamedItem) getInputObjectFromWorkspace(((URIEditorInput) editorInput)
					.getURI());
			setPartName(namedInput.getName());
			input = namedInput;
		}

		AppModel2EditorModelConverter instance = AppModel2EditorModelConverter.getInstance();
		editorModel = instance.createEditorModel(input, v);
		
		Resource resource = new XMIResourceImpl(resourceURI);
		resource.getContents().add(editorModel);
		editingDomain.getResourceSet().getResources().add(resource);
		
		SettingEvaluator.initRelevantForWholeModel(v, true);
		
		//S60CTBuilder.setEditor(this);
	}

	private EConfigurationProject getConfigurationProject(URI inputUri)
	{
		String[] uriParts = inputUri.toString().split("/");
		String projectName = URI.decode(uriParts[2]);
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IProject project = root.getProject(projectName);
		String fragment = inputUri.fragment();
		return ConfMLCore.getProjectModel(project);
	}
	
	private EObject getInputObjectFromWorkspace(URI inputUri) {
		EObject ret = null;
		String[] uriParts = inputUri.toString().split("/");
		String projectName = URI.decode(uriParts[2]);
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IProject project = root.getProject(projectName);
		String fragment = inputUri.fragment();
		EConfigurationProject configurationProject = ConfMLCore
		.getProjectModel(project);
		EConfMLLayer lastLayer = configurationProject.getLastLayer();
		
		if(fragment.startsWith("@")) {
			//group input
			String realRef = fragment.substring(1);
			System.out.println("Searching group: " + realRef);
			String[] parts = realRef.split("/");
			EMap<String, EAppView> views = lastLayer.getViews();
			EAppView selectedView = null;
			for (Entry<String, EAppView> entry : views) {
				EAppView value = entry.getValue();
				if(value.getName().equals(ConfmlEditorUtil.unEscapeSpaces(parts[0]))) {
					selectedView = value;
					break;
				}
			}
			if(selectedView != null) {
				ret = searchAppGroup(selectedView,parts,1);
			}
		} else {
			//feature input
			ret = lastLayer.getFeatures().get(fragment);
		}

		return ret;
	}

	private EAppGroup searchAppGroup(EObject parent, String[] parts,
			int index) {
		String sGroup = parts[index];
		EAppGroupContainer gContainer = (EAppGroupContainer) parent;
		EList<EAppGroup> groups = gContainer.getGroups();
		for (EAppGroup appGroup : groups) {
			if(appGroup.getName().equals(ConfmlEditorUtil.unEscapeSpaces(sGroup))) {
				if(index==parts.length-1) {
					return appGroup;
				} else {
					return searchAppGroup(appGroup,parts,index+1);
				}
			}
		}
		return null;
	}

	public void updateErrors() 
	{
		//System.out.println("UPDATE ERRORS");
		
		URI featureUri = EditUIUtil.getURI(getEditorInput());
		
		String[] uriParts = featureUri.toString().split("/");
		String projectName = uriParts[2];
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IProject project = root.getProject(projectName);

		try 
		{
			if (project==null)
				return;
			final IMarker[] markers = project.findMarkers("com.nokia.tools.variant.validation.core.validationmarker", true, IResource.DEPTH_INFINITE);
			
			getSite().getShell().getDisplay().asyncExec
			(
					new Runnable() 
					{
						public void run()
						{
							try
							{
								((FeatureViewer)getViewer()).updateWidgetErrors(markers);
							}
							catch (NullPointerException npe)
							{
								
							}
						}
					});
		} 
		catch (CoreException e)
		{
			e.printStackTrace();
		}
	}
	
	
	public List<String[]> getPreviousSettingValues(URI featureUri, ESetting setting) {
		
		String featureRef;
		EObject cont = setting.eContainer();
		if(cont instanceof EFeature) {
			featureRef = ((EFeature)setting.eContainer()).getRef();			
		} else {
			featureRef = ((EFeature)cont.eContainer()).getRef();
		}
		String[] uriParts = featureUri.toString().split("/");
		String projectName = uriParts[2];
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IProject project = root.getProject(projectName);

		EConfigurationProject configurationProject = ConfMLCore
				.getProjectModel(project);

		if (configurationProject == null)
			return null;
		EAppFeature appFeature = configurationProject.getLastLayer()
		.getFeatures().get(featureRef);
		
		String ref = appFeature.getRef();
		
		EList<EConfMLLayer> layers = configurationProject.getLayers();
		
		List<String[]> prevoiusValues = new ArrayList<String[]>();
		//StringBuffer sb = new StringBuffer();
		
		String previousFileString = null;
		
		for (int i = 0 ; i < layers.size() ; i++) //latest layer is last in list
		{
			EConfMLLayer layer = layers.get(i);
			EMap<String, EAppFeature> featureMap = layer.getFeatures();
			if (featureMap.containsKey(ref))
			{
				EAppFeature originalFeature = featureMap.get(ref);
				EMap<String, EAppSetting> settingMap = originalFeature.getSettings();
				EAppSetting appSetting = settingMap.get(setting.getRef());
				if (appSetting == null)
					continue;
				EAppSettingType typeInfo = appSetting.getTypeInfo();		
				EAppSettingData settingData = appSetting.getValueInfo();
				String fileString = "";
				String literalValue = null;
				EList<EAppSettingOption> options = null;
				boolean multiSelection = false;
				if (settingData instanceof EAppSimpleData)
				{
					EAppSimpleType simpleType = (EAppSimpleType) typeInfo;
					options = simpleType.getOptions();
					if (simpleType.getType().equals(EAppValueType.MULTISELECTION))
						multiSelection = true;
					EAppSimpleData simpleData = (EAppSimpleData)settingData;
					if (simpleData.getUri().size() == 0)
					{
						fileString = "";
					}
					else
					{
					 fileString = simpleData.getUri().get(0).toPlatformString(true);
					 fileString = fileString.substring(project.getName().length()+2);
					}
					if (simpleData.getMap()!=null)
					{
						String map = simpleData.getMap();
						String[] split1 = map.split("\\[@key='");
						String[] split2 = split1[0].split("/");
						
						String fRef = split2[0];
						String sRef = split2[1];
						String mapKey = split1[1].substring(0, split1[1].length()-2);
						
						EAppFeature feature = layer.getFeatures().get(fRef);
						EAppSetting s = feature.getSettings().get(sRef);
						
						if (s.getValueInfo() instanceof EAppSequenceData)
						{
							EAppSequenceData ssData = (EAppSequenceData)s.getValueInfo();
							EList<EAppSequenceDataItem> dataItems = ssData.getItems();
							
							for (int k = 0 ; k < dataItems.size() ; k++)
							{
								EAppSequenceDataItem dataItem = dataItems.get(k);
								EMap<String, EAppSettingData> subSettings = dataItem.getSubSettings();
								if (((EAppSimpleData)subSettings.get("mapKey")).getValue().equals(mapKey))
								{
									literalValue = ((EAppSimpleData)subSettings.get("mapValue")).getValue()+" ("+mapKey+")";
								}
							}
						}
						//literalValue = simpleData.getMap();
					}
					else
						literalValue = simpleData.getValue();
					
				}
				else if (settingData instanceof EAppResourceData)
				{
					EAppResourceData resourceData = (EAppResourceData)settingData;
					//String targetPath = ((EAppSimpleData)resourceData.getTargetPath()).getValue();
					if (resourceData.getUri().size() == 0)
					{
						fileString = "";
					}
					else
					{
					 fileString = resourceData.getUri().get(0).toPlatformString(true);
					 fileString = fileString.substring(project.getName().length()+2);
					}
					String localPath = ((EAppSimpleData)resourceData.getLocalPath()).getValue();
					literalValue = localPath;
				}
				else if (settingData instanceof EAppSequenceData)
				{
					//no need for this?
				}
				//---------
				if (previousFileString == null ||!previousFileString.equals(fileString))
				{
					previousFileString = fileString;
					
					if (literalValue != null)
						if (options!=null)
						{
							if (multiSelection)
							{
								StringBuffer sb = new StringBuffer();
								for (EAppSettingOption appSettingOption : options)
								{
									if(appSettingOption!=null &&  appSettingOption.getLiteralValue() != null && literalValue.indexOf("\""+appSettingOption.getLiteralValue()+"\"")!=-1)
									{
										if (sb.length()==0)
											sb.append(appSettingOption.getName());
										else
											sb.append(", "+appSettingOption.getName());
									}
								}
								literalValue = sb.toString();
							}
							else
							{
								for (EAppSettingOption appSettingOption : options)
								{
									if(appSettingOption!=null &&  appSettingOption.getLiteralValue() != null && appSettingOption.getLiteralValue().compareTo(literalValue)==0){
										literalValue = appSettingOption.getName();
									}
								}
							}
						}
					prevoiusValues.add(new String[]{literalValue,fileString});
				}
			}
		}
		return prevoiusValues;
	}
	
	/**
	 * Returns a diagnostic describing the errors and warnings listed in the
	 * resource and the specified exception (if any). <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Diagnostic analyzeResourceProblems(Resource resource,
			Exception exception) {
		if (!resource.getErrors().isEmpty()
				|| !resource.getWarnings().isEmpty()) {
			BasicDiagnostic basicDiagnostic = new BasicDiagnostic(
					Diagnostic.ERROR,
					"com.nokia.tools.s60ct.confml.editor",
					0,
					getString("_UI_CreateModelError_message", resource.getURI()),
					new Object[] { exception == null ? (Object) resource
							: exception });
			basicDiagnostic.merge(EcoreUtil.computeDiagnostic(resource, true));
			return basicDiagnostic;
		} else if (exception != null) {
			return new BasicDiagnostic(Diagnostic.ERROR,
					"com.nokia.tools.s60ct.confml.editor", 0, getString(
							"_UI_CreateModelError_message", resource.getURI()),
					new Object[] { exception });
		} else {
			return Diagnostic.OK_INSTANCE;
		}
	}

	/**
	 * This is the method used by the framework to install your own controls.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void createPages() {
		// Creates the model from the editor input
		//
		
		createModel();

		// Only creates the other pages if there is something that can be edited
		//
		// if (!getEditingDomain().getResourceSet().getResources().isEmpty()) {
		if (editorModel != null) {
			// Create a page for the selection tree view.
			//

			/*
			 * Tree tree = new Tree(getContainer(), SWT.MULTI); selectionViewer
			 * = new TreeViewer(tree); setCurrentViewer(selectionViewer);
			 * 
			 * selectionViewer.setContentProvider(new
			 * AdapterFactoryContentProvider(adapterFactory));
			 * selectionViewer.setLabelProvider(new
			 * AdapterFactoryLabelProvider(adapterFactory));
			 * selectionViewer.setInput(editingDomain.getResourceSet());
			 * selectionViewer.setSelection(new
			 * StructuredSelection(editingDomain
			 * .getResourceSet().getResources().get(0)), true);
			 * 
			 * new AdapterFactoryTreeEditor(selectionViewer.getTree(),
			 * adapterFactory);
			 * 
			 * createContextMenuFor(selectionViewer);
			 */
			Composite parent = getContainer();
			formToolkit = new FormToolkit(parent.getDisplay());
			form = formToolkit.createForm(parent);
//			form.setText("SETTINGS - View and modify setting values in "
//					+ editorModel.getName() + ".");
			Composite client = form.getBody();
			// client.setBackground(Display.getCurrent().getSystemColor(
			// SWT.COLOR_WHITE));
			client.setLayout(new FillLayout());
			featureViewer = new FeatureViewer(client);

			featureViewer.setContentProvider(new FeatureViewerContentProvider(
					editingDomain.getCommandStack(), this));
			featureViewer.setInput(editorModel);
			featureViewer.setLabelProvider(new FeatureViewerLabelProvider(CrmlBuilder.getResourceModelRoot()));
			// featureViewer.refresh();

			featureViewer.addSelectionChangedListener(new ISelectionChangedListener(){
				
				public void selectionChanged(SelectionChangedEvent event) {
					IStructuredSelection selection = (IStructuredSelection) event
					.getSelection();

					setSelection(selection);
					
				/*	ISelection convertSelection = convertSelectionToMainModel(selection);
					SelectionChangedEvent newEvent = new SelectionChangedEvent(
							ConfmlEditor.this, convertSelection);
					fireSelection(newEvent);*/
					
				}
				
			});
			
			getSite().setSelectionProvider(featureViewer);
			// create pop up menu actions
			resetToDefaults = new ResetToDefaultAction(featureViewer);
			moveUpAction = new MoveUpAction(featureViewer,this);
			moveDownAction = new MoveDownAction(featureViewer,this);
			duplicateAction = new DuplicateSequencesAction(featureViewer,this);
			openDataConfmlAction = new OpenDataConfmlAction(featureViewer);
			openConfmlAction = new OpenConfmlAction(featureViewer);
			openImplAction = new OpenImplementationAction(featureViewer);
			
			IWorkbenchWindow window = getSite().getWorkbenchWindow();
			resetToDefaults.init(window);
			moveUpAction.init(window);
			moveDownAction.init(window);
			duplicateAction.init(window);
			openDataConfmlAction.init(window);
			openConfmlAction.init(window);
			openImplAction.init(window);
			disableActions();
			
			// create pop up menu with actions
			contextMenuListener = contextMenuListener(form);
			menuManager = new MenuManager();
			menuManager.addMenuListener(contextMenuListener);
			menuManager.setRemoveAllWhenShown(true);
			Menu menu = menuManager.createContextMenu(form);
			form.setMenu(menu);
			
			int pageIndex = addPage(form);
			setPageText(pageIndex, getString("_UI_SelectionPage_label"));

			getSite().getShell().getDisplay().asyncExec(new Runnable() {
				public void run() {
					setActivePage(0);
				}
			});
		}

		// featureViewer.addDirtyButtonListener(new MouseListener() {
		//
		// public void mouseDoubleClick(MouseEvent e) {
		//
		// }
		//
		// public void mouseDown(MouseEvent e) {
		// LeafGroup selectedGroup = getSelectedGroup();
		// if (selectedGroup != null
		// && !(selectedGroup instanceof SummaryLeafGroup)) {
		// UIGroup group = createDirtyForGroup(selectedGroup);
		// settingsViewer.setInput(group);
		// refreshAndHandleWidgetState();
		// // settingsViewer.refresh();
		// dirtySorting = true;
		// errorSorting = false;
		// notesSorting = false;
		// }
		// }
		//
		// public void mouseUp(MouseEvent e) {
		//
		// }
		//
		// });

		// Ensures that this editor will only display the page's tab
		// area if there are more than one page
		//
		getContainer().addControlListener(new ControlAdapter() {
			boolean guard = false;

			@Override
			public void controlResized(ControlEvent event) {
				if (!guard) {
					guard = true;
					hideTabs();
					guard = false;
				}
			}
		});

//		getSite().getShell().getDisplay().asyncExec(new Runnable() {
//			public void run() {
//				updateProblemIndication();
//			}
//		});
		
		updateErrors();
	}

	protected IMenuListener contextMenuListener(Control parent) {
		if (fMenuListener == null) {
			fMenuListener = new MenuListener(parent);
		}
		return fMenuListener;
	}
	
	/**
	 * Disables actions and waits on change in selection to enable them
	 */
	private void disableActions() {
		if (resetToDefaults.isEnabled()) {
			resetToDefaults.setEnabled(true);
			resetToDefaults.setEnabled(false);
		}
	}
	/**
	 * If there is just one page in the multi-page editor part, this hides the
	 * single tab at the bottom. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void hideTabs() {
		if (getPageCount() <= 1) {
			setPageText(0, "");
			if (getContainer() instanceof CTabFolder) {
				((CTabFolder) getContainer()).setTabHeight(1);
				Point point = getContainer().getSize();
				getContainer().setSize(point.x, point.y + 6);
			}
		}
	}

	/**
	 * If there is more than one page in the multi-page editor part, this shows
	 * the tabs at the bottom. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void showTabs() {
		if (getPageCount() > 1) {
			setPageText(0, getString("_UI_SelectionPage_label"));
			if (getContainer() instanceof CTabFolder) {
				((CTabFolder) getContainer()).setTabHeight(SWT.DEFAULT);
				Point point = getContainer().getSize();
				getContainer().setSize(point.x, point.y - 6);
			}
		}
	}

	/**
	 * This is used to track the active viewer. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected void pageChange(int pageIndex) {
		super.pageChange(pageIndex);

		if (contentOutlinePage != null) {
			handleContentOutlineSelection(contentOutlinePage.getSelection());
		}
	}

	/**
	 * This is how the framework determines which interfaces we implement. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Object getAdapter(Class key) {
		if (key.equals(IContentOutlinePage.class)) {
			return showOutlineView() ? getContentOutlinePage() : null;
		} 
		else if (IPropertySheetPage.class.equals(key)) {
			if (propertySheetPage == null || propertySheetPage.getWidgetFactory()==null) {
				propertySheetPage = new TabbedPropertySheetPage(this);
			}
			return propertySheetPage;
		} 
		else if (key.equals(IGotoMarker.class)) {
			return this;
		} 
		else if (key.equals(CommandStack.class)) {
			return editingDomain.getCommandStack();
		} 
		else if (key.equals(ELibraryRoot.class))
		{
			return CrmlBuilder.getResourceModelRoot();
		}
		else if (key.equals(org.eclipse.gef.commands.CommandStack.class))
		{
			return new org.eclipse.gef.commands.CommandStack();
		}
		else 
		{
			return super.getAdapter(key);
		}
	}

	/**
	 * This accesses a cached version of the content outliner. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IContentOutlinePage getContentOutlinePage() {
		if (contentOutlinePage == null) {
			// The content outline is just a tree.
			//
			class MyContentOutlinePage extends ContentOutlinePage {
				@Override
				public void createControl(Composite parent) {
					super.createControl(parent);
					contentOutlineViewer = getTreeViewer();
					contentOutlineViewer.addSelectionChangedListener(this);

					// Set up the tree viewer.
					//
					contentOutlineViewer
							.setContentProvider(new AdapterFactoryContentProvider(
									adapterFactory));
					contentOutlineViewer
							.setLabelProvider(new AdapterFactoryLabelProvider(
									adapterFactory));
					contentOutlineViewer.setInput(editingDomain
							.getResourceSet());

					// Make sure our popups work.
					//
					createContextMenuFor(contentOutlineViewer);

					if (!editingDomain.getResourceSet().getResources()
							.isEmpty()) {
						// Select the root object in the view.
						//
						contentOutlineViewer
								.setSelection(new StructuredSelection(
										editingDomain.getResourceSet()
												.getResources().get(0)), true);
					}
				}

				@Override
				public void makeContributions(IMenuManager menuManager,
						IToolBarManager toolBarManager,
						IStatusLineManager statusLineManager) {
					super.makeContributions(menuManager, toolBarManager,
							statusLineManager);
					contentOutlineStatusLineManager = statusLineManager;
				}

				@Override
				public void setActionBars(IActionBars actionBars) {
					super.setActionBars(actionBars);
					getActionBarContributor().shareGlobalActions(this,
							actionBars);
				}
			}

			contentOutlinePage = new MyContentOutlinePage();

			// Listen to selection so that we can handle it is a special way.
			//
			contentOutlinePage
					.addSelectionChangedListener(new ISelectionChangedListener() {
						// This ensures that we handle selections correctly.
						//
						public void selectionChanged(SelectionChangedEvent event) {
							handleContentOutlineSelection(event.getSelection());
						}
					});
		}

		return contentOutlinePage;
	}

	/**
	 * This accesses a cached version of the property sheet. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IPropertySheetPage getPropertySheetPage() {
		if (propertySheetPage == null) {
			propertySheetPage = new TabbedPropertySheetPage(this);
			/*
			propertySheetPage = new TabbedPropertySheetPage(this) {
				
				@Override
				public void setSelectionToViewer(List<?> selection) {
					ConfmlEditor.this.setSelectionToViewer(selection);
					ConfmlEditor.this.setFocus();
				}

				@Override
				public void setActionBars(IActionBars actionBars) {
					super.setActionBars(actionBars);
					getActionBarContributor().shareGlobalActions(this,
							actionBars);
				}
			};
			propertySheetPage
					.setPropertySourceProvider(new AdapterFactoryContentProvider(
							adapterFactory));
			*/
		}

		return propertySheetPage;
	}

	/**
	 * This deals with how we want selection in the outliner to affect the other
	 * views. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void handleContentOutlineSelection(ISelection selection) {
		if (selectionViewer != null && !selection.isEmpty()
				&& selection instanceof IStructuredSelection) {
			Iterator<?> selectedElements = ((IStructuredSelection) selection)
					.iterator();
			if (selectedElements.hasNext()) {
				// Get the first selected element.
				//
				Object selectedElement = selectedElements.next();

				ArrayList<Object> selectionList = new ArrayList<Object>();
				selectionList.add(selectedElement);
				while (selectedElements.hasNext()) {
					selectionList.add(selectedElements.next());
				}

				// Set the selection to the widget.
				//
				selectionViewer.setSelection(new StructuredSelection(
						selectionList));
			}
		}
	}

	/**
	 * This is for implementing {@link IEditorPart} and simply tests the command
	 * stack. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean isDirty() {
		if (isNotesDirty)
			return true; //notes changed
		else
			return ((BasicCommandStack)editingDomain.getCommandStack()).isSaveNeeded();
//		return isDirty;
	}

	/**
	 * This is for implementing {@link IEditorPart} and simply saves the model
	 * file. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void doSave(IProgressMonitor progressMonitor)
	{
		if (((BasicCommandStack)editingDomain.getCommandStack()).isSaveNeeded())
		{
			URIEditorInput input = (URIEditorInput) getEditorInput();
			resourceUri = input.getURI();
	
			//EList<ESetting> allSettings = new BasicEList<ESetting>();
			
			List<Resource> modifiedResources = new ArrayList<Resource>();
			Map<String, List<ESequenceValueItem>> resourceFramesMap = new HashMap<String, List<ESequenceValueItem>>();
	
			TransactionalEditingDomain domain = ConfMLCore.getEditingDomain();
	
			//step 1. save all simple settings
			modifiedResources.add(saveAllSimpleSettings(domain, resourceUri));
	
			EList<EFeature> features = editorModel.getFeatures();
			for (EFeature feature : features) {
				for (ESetting setting : feature.getSettings()) {
					//allSettings.add(setting);
					if(setting instanceof ESequenceSetting) {
						ESequenceSetting seqSetting = (ESequenceSetting) setting;
						ESequenceValue value = (ESequenceValue) seqSetting.getValue();
						for (ESequenceValueItem item : value.getItems()) {
							URI uri = item.getFrameLocationUri();
							String path = uri.path();
							String ref = setting.getRef();
							String pathAndRef = uri.scheme()+":"+path+";"+ref+";"+feature.getRef();
							if(resourceFramesMap.containsKey(pathAndRef)){
								List<ESequenceValueItem> frameList = resourceFramesMap.get(pathAndRef);
								frameList.add(item);
							}else{
								List<ESequenceValueItem> newFrameList = new ArrayList<ESequenceValueItem>();
								newFrameList.add(item);
								resourceFramesMap.put(pathAndRef, newFrameList);
							}
						}
					}
				}
			}
			
			//save sequence settings
			Set<Entry<String, List<ESequenceValueItem>>> entrySet = resourceFramesMap.entrySet();
			for (Entry<String, List<ESequenceValueItem>> entry : entrySet) {
				String pathAndRef = entry.getKey();
				String[] parts = pathAndRef.split(";");
				String path = parts[0];
				Resource resource = saveSequenceItems(domain,path,parts[2],parts[1],entry.getValue());
				if(!modifiedResources.contains(resource)) {
					modifiedResources.add(resource);				
				}
			}
	
			for (Resource resource : modifiedResources) {
				try {
					Map<Object, Object> options = getSaveOptions();
					
					resource.save(options);
				} catch (IOException e) {
					MessageDialog.openError(getSite().getShell(), "Save", "Unable to save data to the file");
				}
			}
	
			try {
				addDataConfml();
			} catch (WorkbenchException e) {
				e.printStackTrace();
			}
			((BasicCommandStack)editingDomain.getCommandStack()).saveIsDone();
			
	//		boolean change = SettingEvaluator.reevaluateRelevantForSettings(CrmlBuilder.getView(), allSettings);
	//		if (change)
	//			System.out.println("\n*** RELEVANT CHANGED ***\n");
		}
		if (isNotesDirty)
			saveNotes();
		
		firePropertyChange(IEditorPart.PROP_DIRTY);
	}

	private Map<Object, Object> getSaveOptions() {
		Map<Object, Object> options = new HashMap<Object, Object>();
		options.put(XMLResource.OPTION_ENCODING,
		"UTF-8");
		return options;
	}


	
	private void saveNotes()
	{
		URIEditorInput input = (URIEditorInput) getEditorInput();
		String uri = input.getURI().toPlatformString(true);
		Path path = new Path(uri);
		IFile iFile = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
		IProject project = iFile.getProject();
		IFile file = project.getFile(".notes");
		if (file.exists())
		{
		    try 
		    {
		    	FileInputStream is = (FileInputStream)file.getContents(true);
		    	BufferedReader bReader = new BufferedReader(new InputStreamReader(is,"UTF-8"));
		    	String line = null;
				Properties properties = new Properties();
				while((line=bReader.readLine())!=null)
				{
					if (!line.startsWith("#"))
					{
						int index = line.indexOf("=");
						if (index!=-1)
						{
							String ref = line.substring(0, index);
							String note = line.substring(index+1, line.length());
							note = StringEscapeUtils.unescapeJava(note);
							properties.setProperty(ref, note);
						}
					}
				}
				bReader.close();
				InputStream source = new ByteArrayInputStream(mergeNotes(properties).toByteArray());
				file.setContents(source, IFile.FORCE, null);
			} 
		    catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		else
		{
		    InputStream source = new ByteArrayInputStream(mergeNotes(null).toByteArray());
		    try 
		    {
				file.create(source, IResource.NONE, null);
				
			}
		    catch (CoreException e)
			{
				e.printStackTrace();
			}
		}
		isNotesDirty = false;
		NotesBuilder.getNotesBuilder().buildNotes();
		IViewPart viewPart = getSite().getPage().findView(NotesView.ID);
		if (viewPart!=null && viewPart instanceof NotesView)
		{
			NotesView notesView = (NotesView)viewPart;
			notesView.loadNotes();
		}
	}
	
	private ByteArrayOutputStream mergeNotes(Properties properties)
	{
		if (properties ==null)
			properties = new Properties();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		for (EFeature feature : editorModel.getFeatures())
		{
			for (ESetting setting : feature.getSettings())
			{
				String settingNotes = setting.getNotes();
				if (settingNotes!=null)
				{
					String absRef = setting.getAbsRef();
					if (settingNotes.trim().equals(""))
						properties.remove(absRef);
					else
						properties.setProperty(absRef, settingNotes);
				}
				if (setting instanceof ESequenceSetting)
				{
					ESequenceSetting ss = (ESequenceSetting)setting;
					for (ESetting subSetting : ss.getSubTypes())
					{
						String subSettingNotes = subSetting.getNotes();
						if (subSettingNotes!=null)
						{
							String absRef = subSetting.getAbsRef()+"/"+subSetting.getRef();
							if (subSettingNotes.trim().equals(""))
								properties.remove(absRef);
							else
								properties.setProperty(absRef, subSettingNotes);
						}
					}
				}
			}
		}
		try 
		{
			properties.store(baos, "");
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				baos.flush();
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			}
			try 
			{
				baos.close();
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		return baos;
	}
	
	private Resource saveSequenceItems(TransactionalEditingDomain domain,
			String path, final String featureRef, final String settingRef, final List<ESequenceValueItem> items) {
		URI uri = URI.createURI(path);
		TransactionalCommandStack transactionStack = (TransactionalCommandStack) domain.getCommandStack();
		
		final Resource resource = getResourceFromDomain(uri, domain) ;
		
		RecordingCommand command = new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
		
				IVEModel2ConfMLPMConverter converter = VEModel2ConfMLPMConverterFactory
				.getConvertor(resource);

				converter.mergeItemsWithResource(resource, items, featureRef, settingRef);

			}

		};
		try {
			transactionStack.execute(command,Collections.singletonMap(
			        Transaction.OPTION_NO_VALIDATION, Boolean.TRUE));
		} catch (InterruptedException e) {
			MessageDialog.openError(getSite().getShell(), "Command Failed",
            "Interrupted while waiting for a read/write transaction.");
		} catch (RollbackException e) {
			ErrorDialog.openError(getSite().getShell(), "Command Failed", "Transaction rolled back",
		            e.getStatus());
		}
		return resource;
	}

	private Resource saveAllSimpleSettings(TransactionalEditingDomain domain, URI resourceUri) {
		TransactionalCommandStack transactionStack = (TransactionalCommandStack) domain.getCommandStack();
		final Resource resource = getResourceFromDomain(resourceUri, domain);

		RecordingCommand command = new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				IVEModel2ConfMLPMConverter converter = VEModel2ConfMLPMConverterFactory
						.getConvertor(resource);
				List<Object> pmFeatures = converter
						.createPMData(editorModel);
				if(pmFeatures!=null) {
					converter.mergePMDataWithResource(resource, pmFeatures);					
				}
			}
		};
		try {
			transactionStack.execute(command,Collections.singletonMap(
			        Transaction.OPTION_NO_VALIDATION, Boolean.TRUE));
		} catch (InterruptedException e) {
			MessageDialog.openError(getSite().getShell(), "Command Failed",
            "Interrupted while waiting for a read/write transaction.");
		} catch (RollbackException e) {
			ErrorDialog.openError(getSite().getShell(), "Command Failed", "Transaction rolled back",
		            e.getStatus());
		}
		return resource;
	}

	private Resource getResourceFromDomain(URI uri,
			TransactionalEditingDomain domain) {
		Resource resource = null;
		if(uri.path().compareTo(resourceUri.path())==0)
			uri=resourceUri.trimFragment();
		
		try {
			resource = domain.getResourceSet().getResource(uri, false);
		} catch (Exception e) {
//			EConfML2ResourceFactoryImpl rFactory = new EConfML2ResourceFactoryImpl();
//			Resource rs = rFactory.createResource(uri);
//			domain.getResourceSet().getResources().add(rs);
//			resource = rs;
		}
		if (resource==null)
		{
			EConfML2ResourceFactoryImpl rFactory = new EConfML2ResourceFactoryImpl();
			Resource rs = rFactory.createResource(uri);
			domain.getResourceSet().getResources().add(rs);
			resource = rs;
		}
		return resource;
	}

	/**
	 * This returns whether something has been persisted to the URI of the
	 * specified resource. The implementation uses the URI converter from the
	 * editor's resource set to try to open an input stream. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected boolean isPersisted(Resource resource) {
		boolean result = false;
		try {
			InputStream stream = editingDomain.getResourceSet()
					.getURIConverter().createInputStream(resource.getURI());
			if (stream != null) {
				result = true;
				stream.close();
			}
		} catch (IOException e) {
			// Ignore
		}
		return result;
	}

	/**
	 * This always returns true because it is not currently supported. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}

	/**
	 * This also changes the editor's input. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void doSaveAs() {
		SaveAsDialog saveAsDialog = new SaveAsDialog(getSite().getShell());
		saveAsDialog.open();
		IPath path = saveAsDialog.getResult();
		if (path != null) {
			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
			if (file != null) {
				doSaveAs(URI.createPlatformResourceURI(file.getFullPath()
						.toString(), true), new FileEditorInput(file));
			}
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void doSaveAs(URI uri, IEditorInput editorInput) {
		(editingDomain.getResourceSet().getResources().get(0)).setURI(uri);
		setInputWithNotify(editorInput);
		setPartName(editorInput.getName());
		IProgressMonitor progressMonitor = getActionBars()
				.getStatusLineManager() != null ? getActionBars()
				.getStatusLineManager().getProgressMonitor()
				: new NullProgressMonitor();
		doSave(progressMonitor);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void gotoMarker(IMarker marker) {
		try {
			if (marker.getType().equals(EValidator.MARKER)) {
				String uriAttribute = marker.getAttribute(
						EValidator.URI_ATTRIBUTE, null);
				if (uriAttribute != null) {
					URI uri = URI.createURI(uriAttribute);
					EObject eObject = editingDomain.getResourceSet()
							.getEObject(uri, true);
					if (eObject != null) {
						setSelectionToViewer(Collections
								.singleton(editingDomain.getWrapper(eObject)));
					}
				}
			}
		} catch (CoreException exception) {
			ConfmlFeatureEditorPlugin.INSTANCE.log(exception);
		}
	}

	/**
	 * This is called during startup. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	@Override
	public void init(IEditorSite site, IEditorInput editorInput) {
		setSite(site);
		
/*		
		stack = new CommandStack();
		// actionRegistry = new ActionRegistry();

		stack.addCommandStackListener(commandStackListener);
		stack.addCommandStackEventListener(commandStackEventListener);
*/		
		setInputWithNotify(editorInput);
		setPartName(editorInput.getName());
		site.setSelectionProvider(this);
		site.getPage().addPartListener(partListener);
		
		ResourcesPlugin.getWorkspace().addResourceChangeListener(
				resourceChangeListener, IResourceChangeEvent.POST_BUILD);
		
		
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setFocus() {
		getControl(getActivePage()).setFocus();
	}

	/**
	 * This implements {@link org.eclipse.jface.viewers.ISelectionProvider}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void addSelectionChangedListener(ISelectionChangedListener listener) {
		selectionChangedListeners.add(listener);
	}

	/**
	 * This implements {@link org.eclipse.jface.viewers.ISelectionProvider}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void removeSelectionChangedListener(
			ISelectionChangedListener listener) {
		selectionChangedListeners.remove(listener);
	}

	/**
	 * This implements {@link org.eclipse.jface.viewers.ISelectionProvider} to
	 * return this editor's overall selection. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public ISelection getSelection() {
		return editorSelection;
	}

	/**
	 * This implements {@link org.eclipse.jface.viewers.ISelectionProvider} to
	 * set this editor's overall selection. Calling this result will notify the
	 * listeners. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setSelection(ISelection selection) {
		editorSelection = selection;

		for (ISelectionChangedListener listener : selectionChangedListeners) {
			listener
					.selectionChanged(new SelectionChangedEvent(this, selection));
		}
		setStatusLineManager(selection);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setStatusLineManager(ISelection selection) {
		IStatusLineManager statusLineManager = currentViewer != null
				&& currentViewer == contentOutlineViewer ? contentOutlineStatusLineManager
				: getActionBars().getStatusLineManager();

		if (statusLineManager != null) {
			if (selection instanceof IStructuredSelection) {
				Collection<?> collection = ((IStructuredSelection) selection)
						.toList();
				switch (collection.size()) {
				case 0: {
					statusLineManager
							.setMessage(getString("_UI_NoObjectSelected"));
					break;
				}
				case 1: {
					String text = new AdapterFactoryItemDelegator(
							adapterFactory).getText(collection.iterator()
							.next());
					statusLineManager.setMessage(getString(
							"_UI_SingleObjectSelected", text));
					break;
				}
				default: {
					statusLineManager.setMessage(getString(
							"_UI_MultiObjectSelected", Integer
									.toString(collection.size())));
					break;
				}
				}
			} else {
				statusLineManager.setMessage("");
			}
		}
	}

	/**
	 * This looks up a string in the plugin's plugin.properties file. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static String getString(String key) {
		return ConfmlFeatureEditorPlugin.INSTANCE.getString(key);
	}

	/**
	 * This looks up a string in plugin.properties, making a substitution. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static String getString(String key, Object s1) {
		return ConfmlFeatureEditorPlugin.INSTANCE.getString(key,
				new Object[] { s1 });
	}

	/**
	 * This implements {@link org.eclipse.jface.action.IMenuListener} to help
	 * fill the context menus with contributions from the Edit menu. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void menuAboutToShow(IMenuManager menuManager) {
		((IMenuListener) getEditorSite().getActionBarContributor())
				.menuAboutToShow(menuManager);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EditingDomainActionBarContributor getActionBarContributor() {
		return (EditingDomainActionBarContributor) getEditorSite()
				.getActionBarContributor();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IActionBars getActionBars() {
		return getActionBarContributor().getActionBars();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AdapterFactory getAdapterFactory() {
		return adapterFactory;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void dispose()
	{
		cleanViewModel();
		updateProblemIndication = false;

		ResourcesPlugin.getWorkspace().removeResourceChangeListener(
				resourceChangeListener);

		getSite().getPage().removePartListener(partListener);

		adapterFactory.dispose();

		if (getActionBarContributor().getActiveEditor() == this) {
			getActionBarContributor().setActiveEditor(null);
		}

		if (propertySheetPage != null) {
			propertySheetPage.dispose();
		}

		if (contentOutlinePage != null) {
			contentOutlinePage.dispose();
		}
		resetToDefaults.dispose();
		resetToDefaults = null;

		moveUpAction.dispose();
		moveUpAction = null;

		moveDownAction.dispose();
		moveDownAction = null;

		duplicateAction.dispose();
		duplicateAction = null;
		
		openDataConfmlAction.dispose();
		openDataConfmlAction = null;
		
		openConfmlAction.dispose();
		openConfmlAction = null;
		
		openImplAction.dispose();
		openImplAction = null;
		
		editorModel = null;
		featureViewer.dispose();
		super.dispose();
		//System.gc();
	}

	private void cleanViewModel()
	{
		View v = (View)CrmlBuilder.getView();
		
		for (EFeature feature : editorModel.getFeatures())
		{
			v.getSharedFeatures().remove(feature);
		}
	}
	
	/**
	 * Returns whether the outline view should be presented to the user. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected boolean showOutlineView() {
		return false;
	}

	public void setDirty(final boolean dirty) {
		if (isNotesDirty != dirty) {
			isNotesDirty = dirty;
			firePropertyChange(IEditorPart.PROP_DIRTY);
		}
	}
	
	private void addDataConfml() throws WorkbenchException {	
		String correctPath = resourceUri.path().replaceAll("//", "/");
		String[] uriParts = correctPath.split("/");
		String projectName = uriParts[2];
		IWorkspaceRoot root1 = ResourcesPlugin.getWorkspace().getRoot();
		IProject project = root1.getProject(projectName);
		
		EConfigurationProject configurationProject = ConfMLCore
		.getProjectModel(project);
		if(configurationProject == null) {
			return;
		}
		EConfMLLayer lastLayer = configurationProject.getLastLayer();
		EList<EAppIncludeElement> includes = lastLayer.getIncludes();
		if (includes!=null && includes.size()>0)
		{
			EAppIncludeElement lastInclude = includes.get(includes.size()-1);
			URI targetUri = lastInclude.getTarget();
			if (targetUri.path().equals(resourceUri.path()))
				return; //data confml already included. No need to touch the file and cause extra notifications
		}
		
		URI rootUri = lastLayer.getRootConfml();
		if(lastLayer==null || rootUri==null) {
			return;
		}
		correctPath = "";
		boolean add = false;
		for(int i=0; i<uriParts.length; i++){
			if(add)
				correctPath += "/"+uriParts[i];
			if(uriParts[i].compareTo("resource")==0)
				add=true;
		}
		URI correctUri = URI.createPlatformResourceURI(correctPath, false);
		URI rel = correctUri.deresolve(rootUri);
		
		TransactionalEditingDomain edomain = ConfMLCore.getEditingDomain();
		ResourceSet resourceSet = edomain.getResourceSet();
		TransactionalCommandStack tStack = (TransactionalCommandStack) edomain.getCommandStack();
		
		try {
			Resource layerRoot = resourceSet.getResource(rootUri, false);
			final EObject document = layerRoot.getContents().get(0);
			final String includeHref = rel.toString();
			if(document instanceof EConfMLDocument) {
				//confml1
				tStack.execute(new RecordingCommand(edomain) {
					
					@Override
					protected void doExecute() {						
						EConfMLDocument docRoot = (EConfMLDocument) document;
						EList<EInclude> includes = docRoot.getConfiguration().getIncludes();
						boolean contains = false;
						for (EInclude include : includes) {
							if(include.getHref().equals(includeHref)) {
								contains = true;
							}
						}
						if(!contains) {
							//add link
							EInclude include = EConfMLIncludeFactory.eINSTANCE.createEInclude();
							include.setHref(includeHref);
							includes.add(include);
						}
					}
					
				});
				
			} else {
				//confml2
				tStack.execute(new RecordingCommand(edomain) {
					
					@Override
					protected void doExecute() {						
						EConfML2Document docRoot = (EConfML2Document) document;
						EList<EInclude> includes = docRoot.getConfiguration().getIncludes();
						boolean contains = false;
						for (EInclude include : includes) {
							if(include.getHref().equals(includeHref)) {
								contains = true;
							}
						}
						if(!contains) {
							//add link
							EInclude include = EConfMLIncludeFactory.eINSTANCE.createEInclude();
							include.setHref(includeHref);
							includes.add(include);
						}
					}
					
				});
			}
			layerRoot.save(getSaveOptions());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
//	public void handleErrors(ESetting setting, String value) {
//		if (viewEditorModel != null) {
//			handleErrors(setting, SettingsValidator.validateSetting(setting,
//					value, viewEditorModel.getResourceModelRoot()));
//		}
//	}
//	
//	public ErrorsRoot getErrorsRoot() {
//		return errorsRoot;
//	}
//	
//	protected void createErrors() {
//		errorsRoot = ErrormodelFactory.eINSTANCE.createErrorsRoot();
//		updateAllErrors();
//
//	}
//	
//	private void updateAllErrors() {
//		if (job != null) {
//			job.done(new Status(IStatus.OK, Activator.PLUGIN_ID, ""));
//		}
//		job = new WorkspaceJob("Updating errors") {
//
//			@Override
//			public IStatus runInWorkspace(IProgressMonitor monitor)
//					throws CoreException {
//				EList<ESetting> settingInstances = CrmlBuilder.getView()
//						.getSharedSettingInstances();
//				for (int i = 0; i < settingInstances.size(); i++) {
//					ESetting setting = settingInstances.get(i);
//					updateErrorModelFor(setting);
//
//				}
//				Display.getDefault().syncExec(new Runnable() {
//
//					public void run() {
//						if (featureViewer != null) {
//							Object input = featureViewer.getInput();
//							if (input instanceof EObject) {
//								EObject eObject = (EObject) input;
//								TreeIterator<EObject> allContents = eObject
//										.eAllContents();
//								while (allContents.hasNext()) {
//
//									EObject next = allContents.next();
//									if (next instanceof ESetting){  //UIGROUP
//										continue;
//									}
//									featureViewer.update(next, null);
//								}
//							}
//						}
//
//					}
//
//				});
//				return new Status(IStatus.OK, Activator.PLUGIN_ID, "");
//			}
//
//		};
//		job.setSystem(true);
//		job.schedule();
//
//	}
//
//	private void updateErrorModelFor(ESetting setting) {
//		String settingValue = "";
//		if (setting instanceof ESimpleSetting) {
//			ESimpleValue sv = (ESimpleValue)((ESimpleSetting)setting).getValue();
//			settingValue = sv.getValue();
//		}
////		if (setting instanceof EResourceSetting) {
////			createErrorsForFile(((EResourceSetting) setting)
////					.getSourceFilePath());
////			createErrorsForFile(((EResourceSetting) setting)
////					.getTargetFilePath());
////		} 
//		else
//		{
////			if (setting instanceof ESequenceSetting) 
////			{
////				ESequenceSetting sequenceSetting = (ESequenceSetting) setting;
////				EList<ESequenceItem> sequenceItems = sequenceSetting
////						.getSequenceItem();
////				for (ESequenceItem sequenceItem : sequenceItems) {
////					EList<Setting> settings = sequenceItem.getSetting();
////					for (Setting setting2 : settings) {
////						settingValue = "";
////						if (setting2 instanceof ESimpleSetting) {
////							ESimpleSetting simpleSetting = (ESimpleSetting) setting2;
////							settingValue = simpleSetting.getValue();
////						}
////						if (setting2 instanceof EResourceSetting) {
////							handleErrors(((EResourceSetting) setting2)
////									.getSourceFilePath(),
////									((EResourceSetting) setting2)
////											.getSourceFilePath().getPath());
////							handleErrors(((EResourceSetting) setting2)
////									.getTargetFilePath(),
////									((EResourceSetting) setting2)
////											.getTargetFilePath().getPath());
////						} else {
////							handleErrors(setting2, settingValue);
////						}
////					}
////				}
////			}
//			handleErrors(setting, settingValue);
//
//		}
//	}
//
//	private void createErrorsForFile(Setting setting) {
//		if (viewEditorModel == null) {
//			return;
//		}
////		String settingValue = ((FilePath) setting).getPath();
////		ELibraryRoot resourceModelRoot = viewEditorModel.getResourceModelRoot();
////		handleErrors(setting, SettingsValidator.validateSetting(setting,
////				settingValue, resourceModelRoot));
//	}
//	
//	private void handleErrors(ESetting setting, ValidationResult result) {
//		
//		if (errorsRoot == null) {
//			return;
//		}
//		EList<com.nokia.tools.s60ct.confml.editor.errormodel.Error> errors = errorsRoot.getErrors();
//		EList<Adapter> adapters = setting.eAdapters();
//		Adapter adapter = EcoreUtil.getAdapter(adapters,
//				SettingToErrorAdapter.class);
//		SettingToErrorAdapter errorAdapter = null;
//		com.nokia.tools.s60ct.confml.editor.errormodel.Error settingError = null;
//		if (adapter instanceof SettingToErrorAdapter) {
//			errorAdapter = (SettingToErrorAdapter) adapter;
//			settingError = errorAdapter.getError();
//
//		}
//		if (/*!setting.isVisible() ||*/ !setting.isComputedRelevant()) {
//			if (settingError != null) {
//				errors.remove(settingError);
//				adapters.remove(adapter);
//			}
//
//			return;
//		}
//		if (setting.eContainer() instanceof ESetting) {
//			ESetting container = (ESetting) setting.eContainer();
//			if (/*!container.isVisible() ||*/ !container.isComputedRelevant()) {
//				if (settingError != null) {
//					errors.remove(settingError);
//					adapters.remove(adapter);
//				}
//				return;
//			}
//			if (container.eContainer() instanceof ESetting) {
//				ESetting containerEContainer = (ESetting) setting.eContainer();
//				if (/*!containerEContainer.isVisible()||*/ !containerEContainer.isComputedRelevant()) {
//					if (settingError != null) {
//						errors.remove(settingError);
//						adapters.remove(adapter);
//					}
//					return;
//				}
//			}
//		}
//		if (setting.eContainer() != null
//				&& setting.eContainer().eContainer() instanceof ESetting) {
//			ESetting containerEContainer = (ESetting) setting.eContainer()
//					.eContainer();
//			if (/*!containerEContainer.isVisible()||*/ !containerEContainer.isComputedRelevant()) {
//				if (settingError != null) {
//					errors.remove(settingError);
//					adapters.remove(adapter);
//				}
//				return;
//			}
//		}
//		if (result.getResult().size() > 0) {
//
//			if (!result.getResult().contains(EResult.VALID)) {
//				com.nokia.tools.s60ct.confml.editor.errormodel.Error error = ErrormodelFactory.eINSTANCE.createError();
//				error.setDescription(result.getValidationMessage());
//				if (result.getResult().contains(EResult.CONSTRAINT_FAILED)) {
//					error.setErrorType(ErrorType.CONSTRAINT);
//				}
//				if (result.getResult().contains(
//						EResult.NON_RELEVANT_DEPENDENCIES)) {
//					error.setErrorType(ErrorType.NON_RELEVANT_DEPENDENCIES);
//				}
//				String location = "";
////				if (setting.getLeafGroup().size() > 0) {
////					LeafGroup leafGroup = setting.getLeafGroup().get(0);
////					EObject container = leafGroup.eContainer();
////					if (container instanceof ParentGroup) {
////						ParentGroup parentGroup = (ParentGroup) container;
////						location = parentGroup.getName() + " - "
////								+ leafGroup.getName();
////					}
////				}
////				else if ((setting.eContainer() != null)
////						&& (setting.eContainer().eContainer() instanceof SequenceSetting)) 
////				{
////					SequenceSetting sequenceSetting = (SequenceSetting) setting
////							.eContainer().eContainer();
////					if (sequenceSetting.getLeafGroup().size() > 0) {
////						LeafGroup leafGroup = sequenceSetting.getLeafGroup()
////								.get(0);
////						EObject container = leafGroup.eContainer();
////						if (container instanceof ParentGroup) {
////							ParentGroup parentGroup = (ParentGroup) container;
////							location = parentGroup.getName() + " - "
////									+ leafGroup.getName();
////						}
////					} else if (sequenceSetting.getParentGroup().size() > 0) {
////						ParentGroup parentGroup = sequenceSetting
////								.getParentGroup().get(0);
////						location = parentGroup.getName();
////					}
////				} else if ((setting.eContainer() != null)
////						&& (setting.eContainer().eContainer() != null)
////						&& (setting.eContainer().eContainer().eContainer() instanceof SequenceSetting)) {
////					SequenceSetting sequenceSetting = (SequenceSetting) setting
////							.eContainer().eContainer().eContainer();
////					if (sequenceSetting.getLeafGroup().size() > 0) {
////						LeafGroup leafGroup = sequenceSetting.getLeafGroup()
////								.get(0);
////						EObject container = leafGroup.eContainer();
////						if (container instanceof ParentGroup) {
////							ParentGroup parentGroup = (ParentGroup) container;
////							location = parentGroup.getName() + " - "
////									+ leafGroup.getName();
////						}
////					} else if (sequenceSetting.getParentGroup().size() > 0) {
////						ParentGroup parentGroup = sequenceSetting
////								.getParentGroup().get(0);
////						location = parentGroup.getName();
////					}
////				} 
////				else if (setting.getParentGroup().size() > 0) 
////				{
////					ParentGroup parentGroup = setting.getParentGroup().get(0);
////					location = parentGroup.getName();
////				}
//				error.setLocation(location);
//				if (!(settingError != null
//						&& settingError.getDescription().equals(
//								error.getDescription()) && settingError
//						.getLocation().equals(error.getLocation()))) {
//					if (settingError != null) {
//						errors.remove(settingError);
//						adapters.remove(adapter);
//					}
//					error.setSetting(setting);
//
//					setting.eAdapters().add(new SettingToErrorAdapter(error));
//					errorsRoot.getErrors().add(error);
//				}
//			} else {
//				if (settingError != null) {
//					errors.remove(settingError);
//					adapters.remove(adapter);
//				}
//			}
//		}
//
//	}
//	
//	
//	/**
//	 * Update errors model
//	 * 
//	 * @param notification
//	 */
//	private void updateErrors(Notification notification) {
//		if (updateErrors) {
//			Object oldValue = notification.getOldValue();
//			Object newValue = notification.getNewValue();
//			if (oldValue instanceof ESequenceItem) {
//				SequenceItem item = (SequenceItem) oldValue;
//				EList<Setting> settings = item.getSetting();
//				for (Setting setting : settings) {
//
//					if(setting instanceof EResourceSetting){
//						Setting filePath= ((EResourceSetting)setting).getSourceFilePath();
//						Adapter adapter = EcoreUtil.getAdapter(filePath.eAdapters(),
//								SettingToErrorAdapter.class);
//						
//						if (adapter instanceof SettingToErrorAdapter) {
//							SettingToErrorAdapter errorAdapter = (SettingToErrorAdapter) adapter;
//							errorsRoot.getErrors().remove(errorAdapter.getError());
//						}
//						
//						filePath = ((EResourceSetting)setting).getTargetFilePath();
//						adapter = EcoreUtil.getAdapter(filePath.eAdapters(),
//								SettingToErrorAdapter.class);
//						
//						if (adapter instanceof SettingToErrorAdapter) {
//							SettingToErrorAdapter errorAdapter = (SettingToErrorAdapter) adapter;
//							errorsRoot.getErrors().remove(errorAdapter.getError());
//						}
//
//						
//					}
//					else{
//					
//					Adapter adapter = EcoreUtil.getAdapter(setting.eAdapters(),
//							SettingToErrorAdapter.class);
//					
//					if (adapter instanceof SettingToErrorAdapter) {
//						SettingToErrorAdapter errorAdapter = (SettingToErrorAdapter) adapter;
//						errorsRoot.getErrors().remove(errorAdapter.getError());
//					}
//					}
//				}
//			}
//			if (oldValue instanceof ESetting) {
//				ESetting setting = (ESetting) oldValue;
//				Adapter adapter = EcoreUtil.getAdapter(setting.eAdapters(),
//						SettingToErrorAdapter.class);
//				if (adapter instanceof SettingToErrorAdapter) {
//					SettingToErrorAdapter errorAdapter = (SettingToErrorAdapter) adapter;
//					errorsRoot.getErrors().remove(errorAdapter.getError());
//				}
//			}
//
//			if (newValue instanceof ESequenceItem) {
//				SequenceItem item = (SequenceItem) newValue;
//				EList<Setting> settings = item.getSetting();
//				for (Setting setting : settings) {
//
//					updateErrorModelFor(setting);
//				}
//			}
//			if (newValue instanceof Setting) {
//				Setting setting = (Setting) newValue;
//				updateErrorModelFor(setting);
//			}
//			Object notifier = notification.getNotifier();
//			if (notifier instanceof Setting) {
//				updateErrorModelFor((Setting) notifier);
//			}
//		}
//	}
	
	public String getContributorId() {

		return PROPERTIES_CONTRIBUTOR_ID;
	}
}
