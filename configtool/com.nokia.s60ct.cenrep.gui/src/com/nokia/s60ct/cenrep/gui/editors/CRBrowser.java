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
package com.nokia.s60ct.cenrep.gui.editors;

import helpers.MarkerManager;
import interfaces.DeleteEObjectSet;
import interfaces.RenameEObjectSet;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EventObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import objectview.EObjectFocusDomain;
import objectview.IObjectView;
import objectview.ObjectViewRegistry;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IMarkerDelta;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.ui.ViewerPane;
import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.action.EditingDomainActionBarContributor;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.edit.ui.provider.UnwrappingSelectionProvider;
import org.eclipse.emf.edit.ui.view.ExtendedPropertySheetPage;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.TreeEditor;
import org.eclipse.swt.custom.ViewForm;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IReusableEditor;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartConstants;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IGotoMarker;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.MultiPageEditorPart;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.PropertySheetPage;
import org.xml.sax.SAXParseException;

import s60cenrep.provider.BrowserByNameAdapterFactory;
import s60cenrep.provider.BrowserByValueAdapterFactory;
import s60cenrep.provider.CRBrowserResourceAdapterFactory;
import cenrep.CenrepPackage;
import cenrep.Key;
import cenrep.KeyRange;
import cenrep.Repository;
import cenrep.util.CenrepResourceFactoryImpl;

import com.nokia.s60ct.cenrep.gui.CenRepPlugin;
import com.nokia.s60ct.cenrep.gui.Actions.OpenCrMLFile;
import com.nokia.s60ct.cenrep.gui.view.AccessView;
import com.nokia.s60ct.cenrep.gui.view.BitmaskKeyView;
import com.nokia.s60ct.cenrep.gui.view.RangeKeyView;
import com.nokia.s60ct.cenrep.gui.view.SimpleKeyView;

public class CRBrowser extends MultiPageEditorPart implements
			   IEditingDomainProvider, 
			   IMenuListener, 
			   IViewerProvider,
			   IGotoMarker, 
			   IReusableEditor, 
			   objectview.IObjectView {

	public static final String ID ="cenrep.browser";
	
	private static CRBrowser INSTANCE = null;
	
	protected TreeViewer parentViewer;
	
	protected ViewerPane currentViewerPane;
	
	protected Viewer currentViewer;
	
	protected ComposedAdapterFactory adapterFactory;

	protected ComposedAdapterFactory byValueAdapterFactory;
	
	protected ComposedAdapterFactory byNameAdapterFactory;
	
	protected AdapterFactoryEditingDomain editingDomain;
	
	protected ISelectionChangedListener selectionChangedListener;
	
	protected PropertySheetPage propertySheetPage;
	
	protected TreeViewer selectionViewer;
	
	protected Collection<ISelectionChangedListener> selectionChangedListeners = new ArrayList<ISelectionChangedListener>();
	
	protected Collection<Resource> savedResources = new ArrayList<Resource>();
	
	protected Collection<Resource> removedResources = new ArrayList<Resource>();
	
	protected Collection<Resource> changedResources = new ArrayList<Resource>();
	
	protected boolean updateProblemIndication = true;
	
	private Timer timer = null;
	
	private final URL ICON_COLLAPSE = (URL)CenRepPlugin.INSTANCE.getImage("Collapse_All_enabled");
	//private final URL ICON_COLLAPSE_DISABLED = (URL)CenRepPlugin.INSTANCE.getImage("Collapse_All_disabled");

	private final URL ICON_EXPAND = (URL)CenRepPlugin.INSTANCE.getImage("Expand_All_enabled");
	//private final URL ICON_EXPAND_DISABLED = (URL)CenRepPlugin.INSTANCE.getImage("Expand_All_disabled");
	
	private final DeleteEObjectSet DELETE_EOBJECT_SET = new DeleteEObjectSet(){
		public Object[][] getParentFeature() {
			return PARENT_OBJECTS;
		}
		public Object[][] getRoFeatures() {
			return null;
		}
	};
	
	private final RenameEObjectSet RENAME_EOBJECT_SET = new RenameEObjectSet(){
		public Object[][] getTypes() {
			return CRBrowser.this.viewerPane2NameFeatures.get(CRBrowser.this.currentViewerPane);
		}
		
	};
	
	private static final Object[][] PARENT_OBJECTS = new Object[][]{
			new Object[]{Key.class, CenrepPackage.eINSTANCE.getRepository_Key()},
			new Object[]{KeyRange.class, CenrepPackage.eINSTANCE.getRepository_RangeKey()},
	};
	
	private static final Object[][] NAME_FEATURES_UID_NAME = new Object[][]{
		new Object[]{Repository.class,CenrepPackage.eINSTANCE.getRepository_UidName()},
		new Object[]{Key.class,CenrepPackage.eINSTANCE.getKey_Name()},
		new Object[]{KeyRange.class,CenrepPackage.eINSTANCE.getKeyRange_Name()},
	};
	
	private static final Object[][] NAME_FEATURES_UID_VALUE = new Object[][]{
		new Object[]{Repository.class,CenrepPackage.eINSTANCE.getRepository_UidValue()},
		new Object[]{Key.class,CenrepPackage.eINSTANCE.getKey_Ident()},
	};
	
	private Map<ViewerPane, Object[][]> viewerPane2NameFeatures=new HashMap<ViewerPane, Object[][]>();
	
	private EObjectFocusDomain focusDomain = new EObjectFocusDomain() {
		public boolean canShow(Object object) {
			TreePath path = toTreePath(object);
			return path.getSegmentCount() > 0 && path.getFirstSegment() instanceof Repository;
		}
		public Collection<IObjectView> getViews() {
			ArrayList<IObjectView> ret = new ArrayList<IObjectView>();
		    ret.add(CRBrowser.this); 
		 
		    // The method gets called in so early phase of the start up 
		    // that these methods need to be for the null return value. 
		    // Likely only one or two of them can be null
		    if (PlatformUI.getWorkbench() != null 
		    	&& PlatformUI.getWorkbench().getActiveWorkbenchWindow() != null 
		    	&& PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage() != null) {
			    for(IViewReference ref : PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getViewReferences()){
			    	IViewPart view = ref.getView(true);
			    	if(view != null) {
			    		IObjectView ov = (IObjectView)view.getAdapter(IObjectView.class);
			    		if (ov!=null) {
			    			ret.add(ov); 
			    		}
			    	}
			   }
		    }
			return ret;
		}
	}; 
	
	protected IPartListener partListener =
		new IPartListener() {
			public void partActivated(IWorkbenchPart p) {

				if (p == CRBrowser.this) {
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

	private static String getString(String key) {
		return CenRepPlugin.INSTANCE.getString(key);
	}
	
	public static CRBrowser getCRBrowserEditor()
	{
		return INSTANCE;
	}
	
	public void gotoMarker(IMarker marker)
	  {
		EObject eObject = null;
		EStructuralFeature eFeature = null;
	    try {
	    	if (marker.getType().equals(MarkerManager.MARKER_ID))
	    	{
		    	String uriAttribute = marker.getAttribute(MarkerManager.URL, null);
		        String fragment = marker.getAttribute(MarkerManager.FRAGMENT, null);
		        int featureId = marker.getAttribute(MarkerManager.FEATURE_ID, -1);
		        if (uriAttribute != null)
		        {
			        URI uri = URI.createURI(uriAttribute);
			        uri = uri.appendFragment(fragment);
			          
			        eObject = editingDomain.getResourceSet().getEObject(uri, false);
			          
			        if (eObject != null) {
				        if (featureId >= 0) {
				        	eFeature = eObject.eClass().getEStructuralFeature(featureId);
				        }
			        }
			        else
			        {
			        	String path = marker.getResource().getFullPath().toString();
			        	uri = URI.createFileURI(path);
			        	Resource resource  = editingDomain.getResourceSet().getResource(uri, false);
			        	if (resource != null && !resource.getContents().isEmpty())
			        		eObject = (EObject)resource.getContents().get(0);
			        }
		        }
		    }
	    }
	    catch (CoreException exception) {
	        System.out.println(exception.getStackTrace());
	    }
	    
	    if (eObject != null && eFeature != null) {
	    	focusDomain.focus(eObject, eFeature, true);
	    } else if (eObject != null) {
	    	focusDomain.focus(eObject, true);
	    }
    }
	
	public CRBrowser() {
		super();
		INSTANCE = this;
		initializeEditingDomain();
		ObjectViewRegistry.getInstance().addView(focusDomain); 
	}

	public void init(IEditorSite site, IEditorInput editorInput)
	throws PartInitException {
		setSite(site);
		setInputWithNotify(editorInput);
		site.setSelectionProvider(focusDomain);
		site.getPage().addPartListener(partListener);
	}

	public void setInput(IEditorInput input){
		CRBrowserEditorInput newInput = (CRBrowserEditorInput)input;
		CRBrowserEditorInput currentInput = (CRBrowserEditorInput)getEditorInput();
		currentInput.getFiles().addAll(newInput.getFiles());
		addIFilesToEditingDomain(
				newInput.getFiles().toArray(new IFile[newInput.getFiles().size()]));
		firePropertyChange(IWorkbenchPartConstants.PROP_INPUT);
	}
	
	protected void initializeEditingDomain() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("crml", new CenrepResourceFactoryImpl());
		// Create an adapter factory that yields item providers.
		//
		adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		byNameAdapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		byValueAdapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		
		AdapterFactory reflectiveAdapterFactory = new ReflectiveItemProviderAdapterFactory();
		AdapterFactory resourceAdapterFactory = new CRBrowserResourceAdapterFactory();
		
		byValueAdapterFactory.addAdapterFactory(new BrowserByValueAdapterFactory());
		byValueAdapterFactory.addAdapterFactory(resourceAdapterFactory);
		
		byNameAdapterFactory.addAdapterFactory(new BrowserByNameAdapterFactory());
		byNameAdapterFactory.addAdapterFactory(resourceAdapterFactory);
		
		adapterFactory.addAdapterFactory(byNameAdapterFactory);
		adapterFactory.addAdapterFactory(reflectiveAdapterFactory);
		adapterFactory.addAdapterFactory(resourceAdapterFactory);
		
		BasicCommandStack commandStack = new BasicCommandStack();

		// Add a listener to set the most recent command's affected objects to be the selection of the viewer with focus.
		//
		commandStack.addCommandStackListener
			(new CommandStackListener() {
				 public void commandStackChanged(final EventObject event) {
					 getContainer().getDisplay().asyncExec
						 (new Runnable() {
							  public void run() {
								  firePropertyChange(IEditorPart.PROP_DIRTY);
								  Command mostRecentCommand = ((CommandStack)event.getSource()).getMostRecentCommand();
								  if (mostRecentCommand != null) {
									  setSelectionToViewer(mostRecentCommand.getAffectedObjects());
									  ((TreeViewer)currentViewer).refresh(); // Update tree viewer
								  }
								  if (propertySheetPage != null && !propertySheetPage.getControl().isDisposed()) {
									  propertySheetPage.refresh();
								  }
							  }
						  });
				 }
			 });

		// Create the editing domain with a special command stack.
		//
		editingDomain = new AdapterFactoryEditingDomain(adapterFactory, commandStack, new HashMap<Resource, Boolean>());
		
		// Add resource change listener
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IResourceChangeListener listener = new IResourceChangeListener() {
			public void resourceChanged(IResourceChangeEvent event) {
				if (event.getType() != IResourceChangeEvent.POST_CHANGE) return;
			    for (IMarkerDelta delta : event.findMarkerDeltas(null, true)) {
			    	IMarker problem = delta.getMarker();
			    	for (Resource resource : editingDomain.getResourceSet().getResources()) {
			    		if (resource.getURI().lastSegment().compareTo(problem.getResource().getName()) == 0) {
			    			// Resource matches marker
			    			if (timer != null) {
			    				// Timer already active, delete old first
			    				timer.cancel();
			    				timer = null;
			    			}
			    			timer = new Timer();
			    			timer.schedule(new TimerTask() {
			    				public void run() {
			    					// Use runnable to refresh swt thread
			    					PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {
			    						public void run() {
			    							try
			    							{
				    							parentViewer.refresh();
				    							((TreeViewer)currentViewer).refresh();
			    							}
			    							catch (Exception e)
			    							{
			    								
			    							}
			    						}
			    					});
			    				}
			    			}, 1000); // Run after one second
			    			break;
			    		}
			    	}
			    }
			}
		};
		workspace.addResourceChangeListener(listener);
	}
	
	public void setSelectionToViewer(Collection<?> collection) {
		final Collection<?> theSelection = collection;
		if (theSelection != null && !theSelection.isEmpty()) {
			if (currentViewer != null) {
				currentViewer.setSelection(new StructuredSelection(theSelection.toArray()), false);
			}
		}
	}
	
	public Object getAdapter(Class key) {
		if (key.equals(IPropertySheetPage.class)) {
			return getPropertySheetPage();
		}else if(key.equals(AdapterFactoryEditingDomain.class)){
			return editingDomain;
		}else if(key.equals(DeleteEObjectSet.class)){
			return DELETE_EOBJECT_SET;
		}else if(key.equals(RenameEObjectSet.class)){
			return RENAME_EOBJECT_SET;
		}
		else {
			return super.getAdapter(key);
		}
	}
	public IPropertySheetPage getPropertySheetPage() {
		if (propertySheetPage == null) {
			propertySheetPage =
				new ExtendedPropertySheetPage(editingDomain) {
					@Override
					public void setSelectionToViewer(List<?> selection) {
						CRBrowser.this.setSelectionToViewer(selection);
						CRBrowser.this.setFocus();
					}

					@Override
					public void setActionBars(IActionBars actionBars) {
						super.setActionBars(actionBars);
//						getActionBarContributor().shareGlobalActions(this, actionBars);
					}
				};
			propertySheetPage.setPropertySourceProvider(new AdapterFactoryContentProvider(adapterFactory));
		}

		return propertySheetPage;
	}
	
	protected void handleActivate() {
		// Recompute the read only state.
		//
		if (editingDomain.getResourceToReadOnlyMap() != null) {
		  editingDomain.getResourceToReadOnlyMap().clear();

		  // Refresh any actions that may become enabled or disabled.
		  //
		  if (!settingSelection) {
			  focusDomain.setSelection(focusDomain.getSelection());
		  }
		}

		if (!removedResources.isEmpty()) {
			if (handleDirtyConflict()) {
				getSite().getPage().closeEditor(CRBrowser.this, false);
				CRBrowser.this.dispose();
			}
			else {
				removedResources.clear();
				changedResources.clear();
				savedResources.clear();
			}
		}
		else if (!changedResources.isEmpty()) {
			changedResources.removeAll(savedResources);
			handleChangedResources();
			changedResources.clear();
			savedResources.clear();
		}
	}
	
	protected void handleChangedResources() {
		if (!changedResources.isEmpty() && (!isDirty() || handleDirtyConflict())) {
			editingDomain.getCommandStack().flush();

			updateProblemIndication = false;
			for (Resource resource : changedResources) {
				if (resource.isLoaded()) {
					resource.unload();
					try {
						resource.load(Collections.EMPTY_MAP);
					}
					catch (IOException exception) {

					}
				}
			}
			updateProblemIndication = true;
		}
	}
	
	protected boolean handleDirtyConflict() {
		return
			MessageDialog.openQuestion
				(getSite().getShell(),
				 getString("_UI_FileConflict_label"),
				 getString("_WARN_FileConflict"));
	}
	
	@Override
	protected void createPages() {
		createModel();
		{
			ViewerPane viewerPane =
				new ViewerPane(getSite().getPage(), CRBrowser.this) {

				public Viewer createViewer(Composite composite) {
					TreeViewer treeViewer = new TreeViewer(composite, SWT.MULTI | SWT.H_SCROLL
							| SWT.V_SCROLL | SWT.BORDER | SWT.VIRTUAL );
					
			    	TextCellEditor textCellEditot = new TextCellEditor(treeViewer.getTree());
			    	CellEditor[] cellEditor={textCellEditot};
						
			    	String[] properties = {"Main"};
			    	treeViewer.setCellEditors(cellEditor);
			    	treeViewer.setColumnProperties(properties);
				    	
						
					TreeEditor treeEditor = new TreeEditor(treeViewer.getTree());
					treeEditor.horizontalAlignment = SWT.LEFT;
					treeEditor.minimumWidth = 10;
						
			    	return treeViewer;
				}
				public void requestActivation() {
					super.requestActivation();
					setCurrentViewerPane(this);
				}
			};
			viewerPane.createControl(getContainer());
			viewerPane2NameFeatures.put(viewerPane, NAME_FEATURES_UID_NAME);
			selectionViewer = (TreeViewer)viewerPane.getViewer();
			selectionViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
			selectionViewer.setLabelProvider(new AdapterFactoryLabelProvider(byNameAdapterFactory));
			selectionViewer.setInput(editingDomain.getResourceSet());
			selectionViewer.setSelection(new StructuredSelection(editingDomain.getResourceSet().getResources().get(0)), true);
	
			createContextMenuFor(selectionViewer);
			int pageIndex = addPage(viewerPane.getControl());
			setPageText(pageIndex,"UidName");
		}
		{
			ViewerPane viewerPane =
				new ViewerPane(getSite().getPage(), CRBrowser.this) {
				
				public Viewer createViewer(Composite composite) {
					TreeViewer treeViewer = new TreeViewer(composite, SWT.MULTI | SWT.H_SCROLL
							| SWT.V_SCROLL | SWT.BORDER | SWT.VIRTUAL );
					
			    	TextCellEditor textCellEditot = new TextCellEditor(treeViewer.getTree());
			    	CellEditor[] cellEditor={textCellEditot};
						
			    	String[] properties = {"Main"};
			    	treeViewer.setCellEditors(cellEditor);
			    	treeViewer.setColumnProperties(properties);
				    	
						
					TreeEditor treeEditor = new TreeEditor(treeViewer.getTree());
					treeEditor.horizontalAlignment = SWT.LEFT;
					treeEditor.minimumWidth = 10;
						
			    	return treeViewer;
				}
				public void requestActivation() {
					super.requestActivation();
					setCurrentViewerPane(this);
				}
			};
			
			viewerPane.createControl(getContainer());
			viewerPane2NameFeatures.put(viewerPane, NAME_FEATURES_UID_VALUE);
			parentViewer = (TreeViewer)viewerPane.getViewer();
			parentViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
			parentViewer.setLabelProvider(new AdapterFactoryLabelProvider(byValueAdapterFactory));
			parentViewer.setInput(editingDomain.getResourceSet());
			parentViewer.setSelection(new StructuredSelection(editingDomain.getResourceSet().getResources().get(0)), true);
			createContextMenuFor(parentViewer);
			int pageIndex = addPage(viewerPane.getControl());
			setPageText(pageIndex,"UidValue");
			
			addExpandAndCollapseButtons(viewerPane.getControl().getParent());
		}
	}

	protected void createContextMenuFor(StructuredViewer viewer) {
		MenuManager contextMenu = new MenuManager("#PopupMenu1");
		contextMenu.setRemoveAllWhenShown(true);
		contextMenu.addMenuListener(this);
		
		Menu menu= contextMenu.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(contextMenu, new UnwrappingSelectionProvider(viewer));

		
	}
	
	
	@Override
	public void doSave(IProgressMonitor monitor) {
		final Map<Object, Object> saveOptions = new HashMap<Object, Object>();
		saveOptions.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED, Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);

		// Do the work within an operation because this is a long running activity that modifies the workbench.
		//
		IRunnableWithProgress operation =
			new IRunnableWithProgress() {
				// This is the method that gets invoked when the operation runs.
				//
				public void run(IProgressMonitor monitor) {
					// Save the resources to the file system.
					//
					boolean first = true;
					for (Resource resource : editingDomain.getResourceSet().getResources()) {
						if ((first || !resource.getContents().isEmpty() || isPersisted(resource)) && !editingDomain.isReadOnly(resource)) {
							try {
								savedResources.add(resource);
								resource.save(saveOptions);
							}
							catch (Exception exception) {
//								resourceToDiagnosticMap.put(resource, analyzeResourceProblems(resource, exception));
							}
							first = false;
						}
					}
				}
			};

//		updateProblemIndication = false;
		try {
			// This runs the options, and shows progress.
			//
			new ProgressMonitorDialog(getSite().getShell()).run(true, false, operation);

			// Refresh the necessary state.
			//
			((BasicCommandStack)editingDomain.getCommandStack()).saveIsDone();
			firePropertyChange(IEditorPart.PROP_DIRTY);
		}
		catch (Exception exception) {
			
			CenRepPlugin.INSTANCE.log(exception);
		}
	}

	protected boolean isPersisted(Resource resource) {
		boolean result = false;
		try {
			InputStream stream = editingDomain.getResourceSet().getURIConverter().createInputStream(resource.getURI());
			if (stream != null) {
				result = true;
				stream.close();
			}
		}
		catch (IOException e) {
			// Ignore
		}
		return result;
	}
	
	@Override
	public void doSaveAs() {
		String[] fileExtension = new String[]{"*.crml"};
		String file = OpenCrMLFile.openFilePathDialog(getSite().getShell(), fileExtension, SWT.SAVE)[0];
		if (file != null) {
			if (!file.endsWith("." + fileExtension)) {
				file = file + "." + fileExtension;
			}
			URI uri = URI.createFileURI(file);
			doSaveAs(uri, new URIEditorInput(uri));
		}

	}

	protected void doSaveAs(URI uri, IEditorInput editorInput) {
		(editingDomain.getResourceSet().getResources().get(0)).setURI(uri);
		setInputWithNotify(editorInput);
		setPartName(editorInput.getName());
		IProgressMonitor progressMonitor =
			getActionBars().getStatusLineManager() != null ?
				getActionBars().getStatusLineManager().getProgressMonitor() :
				new NullProgressMonitor();
		doSave(progressMonitor);
	}
	
	public IActionBars getActionBars() {
		return getActionBarContributor().getActionBars();
	}
	public EditingDomainActionBarContributor getActionBarContributor() {
		return (EditingDomainActionBarContributor)getEditorSite().getActionBarContributor();
	}
	
	@Override
	public boolean isDirty() {
		return ((BasicCommandStack)editingDomain.getCommandStack()).isSaveNeeded();
	}
	
	@Override
	public boolean isSaveAsAllowed() {
		return true;
	}

	@Override
	public void setFocus() {
		if (currentViewerPane != null) {
			currentViewerPane.setFocus();
		}
		else {
			getControl(getActivePage()).setFocus();
		}
	}
	
	
	public void menuAboutToShow(IMenuManager menuManager) {
		fillContextMenu(menuManager);
	}
	
	protected void fillContextMenu(IMenuManager menuManager){
		IMenuManager newMenu = new MenuManager("New","new");
		newMenu.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
		menuManager.add(new Separator());
		menuManager.add(newMenu);
		menuManager.add(new Separator());
		menuManager.add(new GroupMarker("edit"));
	}
	
	public Viewer getViewer() {
		return selectionViewer;
	}

	public EditingDomain getEditingDomain() {
		
		return editingDomain;
	}
	
	public void dispose() {
		getSite().getPage().removePartListener(partListener);
		adapterFactory.dispose();
		
		MarkerManager.getInstance().deleteResourceMarkerS(editingDomain.getResourceSet().getResources());
		
		if (propertySheetPage != null) {
			propertySheetPage.dispose();
		}
		ObjectViewRegistry.getInstance().removeView(focusDomain); 
		//clean setting editor, when corresponding configuration browser is closed by user
		if(!PlatformUI.getWorkbench().isClosing()){
			IViewReference[] references = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getViewReferences();
			for (IViewReference viewReference : references) {
				if(viewReference.getId().compareTo(AccessView.ID)==0){
					AccessView view = (AccessView)viewReference.getPart(true);
			      view.cleanViewer(this);
				}
				else if(viewReference.getId().compareTo(SimpleKeyView.ID)==0){
					SimpleKeyView view = (SimpleKeyView)viewReference.getPart(true);
				    view.cleanViewer(this);
				}
				else if(viewReference.getId().compareTo(BitmaskKeyView.ID)==0){
					BitmaskKeyView view = (BitmaskKeyView)viewReference.getPart(true);
				    view.cleanViewer(this);
				}
				else if(viewReference.getId().compareTo(RangeKeyView.ID)==0){
					RangeKeyView view = (RangeKeyView)viewReference.getPart(true);
				    view.cleanViewer(this);
				}
			}
		}
		editingDomain.getResourceSet().getResources().clear(); 
		super.dispose();
	}
	
	public void setCurrentViewerPane(ViewerPane viewerPane) {
		if (currentViewerPane != viewerPane) {
			if (currentViewerPane != null) {
				currentViewerPane.showFocus(false);
			}
			currentViewerPane = viewerPane;
			
		}
		setCurrentViewer(currentViewerPane.getViewer());
	}
	
	public void setCurrentViewer(Viewer viewer) {
		// If it is changing...
		//
		if (currentViewer != viewer) {
			if (selectionChangedListener == null) {
				// Create the listener on demand.
				//
				selectionChangedListener =
					new ISelectionChangedListener() {
						// This just notifies those things that are affected by the section.
						//
						public void selectionChanged(SelectionChangedEvent selectionChangedEvent) {
							if (!settingSelection) {
								focusDomain.setSelection(selectionChangedEvent.getSelection());
							}
						}
					};
			}

			// Stop listening to the old one.
			//
			if (currentViewer != null) {
				currentViewer.removeSelectionChangedListener(selectionChangedListener);
			}

			// Start listening to the new one.
			//
			if (viewer != null) {
				viewer.addSelectionChangedListener(selectionChangedListener);
			}

			// Remember it.
			//
			currentViewer = viewer;

			// Set the editors selection based on the current viewer's selection.
			//
			if (!settingSelection) {
				focusDomain.setSelection(currentViewer == null ? StructuredSelection.EMPTY : currentViewer.getSelection());
			}
		}
	}
	
	public void createModel() {
		IEditorInput input = getEditorInput();
		if(input instanceof CRBrowserEditorInput){
			List<IFile> list = ((CRBrowserEditorInput)input).getFiles();
			addIFilesToEditingDomain(list.toArray(new IFile[list.size()]));
		}else if(input instanceof FileEditorInput){
			addIFilesToEditingDomain(new IFile[]{((FileEditorInput)input).getFile()});
		}
	}

	private void addIFilesToEditingDomain(IFile[] input) {
		boolean errorsOccured = false;
		for(IFile file : input){
			URI resourceURI = URI.createURI(file.getFullPath().toString());
			Resource resource = null;
			try {
				resource = editingDomain.getResourceSet().getResource(resourceURI, true);
			}
			catch (Exception e) {
				
				errorsOccured = true;
				Throwable cause = e.getCause();
				int lineNumber = -1;
				if (cause instanceof SAXParseException)
				{
					SAXParseException saxException = (SAXParseException)e.getCause();
					lineNumber = saxException.getLineNumber();
				}
				resource = editingDomain.getResourceSet().getResource(resourceURI, false);
				int featureId = CenrepPackage.eINSTANCE.getRepository_FileName().getFeatureID();
				String message = cause.getMessage();
				if (lineNumber!=-1)
					message = "Invalid file. "+message+" (line "+lineNumber+")";
				else
					message = "Invalid file. "+message;
				EObject obj = null;
				if(resource!=null&&!resource.getContents().isEmpty())
					obj = (EObject)resource.getContents().get(0);
				MarkerManager.getInstance().addExternalProblem(obj, file, file.getLocationURI().getPath(), featureId, message, true, false);
			}
		}
		if (errorsOccured)
		{
			try
			{
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(IPageLayout.ID_PROBLEM_VIEW);
			} 
			catch (Exception e)
			{

			}
		}
	}

	
	boolean settingSelection = false;
	
	public boolean canShow(Object object) {
		// We assume, all repository elements are displayed under this browser instance
		// These we can display straight forwardly 
		return object instanceof Repository
			   || object instanceof Key
			   || object instanceof KeyRange;
	}

	public void show(Object object, boolean tryActivate) throws IllegalArgumentException {
		if (!canShow(object)) {
			throw new IllegalArgumentException(); 
		}
		try {
			settingSelection = true; 
			selectionViewer.setSelection(new TreeSelection(new TreePath(new Object[] {object})), true);
		} finally {
			settingSelection = false;
		}
		if (tryActivate) {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().activate(this); 
		} else {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().bringToTop(this); 
		}
	}

	
	private void addExpandAndCollapseButtons(Composite parent)
	{
		CTabFolder folder = (CTabFolder)parent;
		for (Control control : folder.getChildren())
		{
			if (control instanceof ViewForm)
			{					
				ViewForm viewForm = (ViewForm)control;
				ToolItem collapseItem = new ToolItem((ToolBar)viewForm.getTopCenter(), SWT.FLAT);
				collapseItem.setImage(ImageDescriptor.createFromURL(ICON_COLLAPSE).createImage());
				collapseItem.setToolTipText("Collapse All");
				collapseItem.addSelectionListener(new SelectionAdapter(){
					public void widgetSelected(SelectionEvent e) {
						((TreeViewer)currentViewer).collapseAll();
					}
				});
				ToolItem expandItem = new ToolItem((ToolBar)viewForm.getTopRight(), SWT.FLAT);
				expandItem.setImage(ImageDescriptor.createFromURL(ICON_EXPAND).createImage());
				expandItem.setToolTipText("Expand All");
				expandItem.addSelectionListener(new SelectionAdapter(){
					public void widgetSelected(SelectionEvent e) {
						((TreeViewer)currentViewer).expandAll();
					}
				});
			}
		}
	}
}