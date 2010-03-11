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
package com.nokia.s60ct.gui.editors;

import helpers.MarkerManager;
import interfaces.DeleteEObjectSet;
import interfaces.RenameEObjectSet;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EventObject;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import objectview.EObjectFocusDomain;
import objectview.IObjectView;
import objectview.ObjectViewRegistry;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IMarkerDelta;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.ui.ViewerPane;
import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
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
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.jface.viewers.ViewerFilter;
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
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IGotoMarker;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.MultiPageEditorActionBarContributor;
import org.eclipse.ui.part.MultiPageEditorPart;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.PropertySheetPage;
import org.xml.sax.SAXParseException;
import s60ct.provider.S60CTItemProviderAdapterFactory;
import variantdata.util.VariantDataResourceFactoryImpl;
import views.DescriptionView;
import views.OptionView;
import com.nokia.s60ct.gui.S60CtEditorPlugin;
import com.nokia.s60ct.gui.actions.OpenConfiguration;
import com.nokia.s60ct.gui.filter.FeatureViewFilter;
import com.nokia.s60ct.gui.filter.ReadOnlyFilter;
import com.nokia.s60ct.gui.views.SettingEditorView;
import concepts.EObjectStructuralFeature;
import configurationemf.Configuration;
import configurationemf.ConfigurationemfPackage;
import configurationemf.Feature;
import configurationemf.Group;
import configurationemf.LeafGroup;
import configurationemf.LeafSetting;
import configurationemf.ParentGroup;
import configurationemf.ParentSetting;
import configurationemf.RootConf;
import configurationemf.Setting;
import configurationemf.SubConf;
import configurationemf.TYPE;
import configurationemf.View;
import configurationemf.util.ConfigurationemfResourceFactoryImpl;
import configurationemf.util.PrioritisedConfigurationList;

public class ConfigurationBrowser extends MultiPageEditorPart 
		implements ISelectionProvider,
				   IEditingDomainProvider, 
				   IMenuListener, 
				   IViewerProvider,
				   IGotoMarker,
				   IObjectView {
	

	protected TreeViewer parentViewer;
	
	public static final String ID ="Configuration.Browser";
	
	protected ViewerPane currentViewerPane;
	
	protected Viewer currentViewer;
	
	protected ComposedAdapterFactory adapterFactory;

	protected AdapterFactoryEditingDomain editingDomain;
	
	protected ISelectionChangedListener selectionChangedListener;
	
	protected PropertySheetPage propertySheetPage;
	
	protected TreeViewer selectionViewer;
	
	private final URL ICON_COLLAPSE = (URL)S60CtEditorPlugin.INSTANCE.getImage("Collapse_All_enabled");
	//private final URL ICON_COLLAPSE_DISABLED = (URL)S60CtEditorPlugin.INSTANCE.getImage("Collapse_All_disabled");

	private final URL ICON_EXPAND = (URL)S60CtEditorPlugin.INSTANCE.getImage("Expand_All_enabled");
	//private final URL ICON_EXPAND_DISABLED = (URL)S60CtEditorPlugin.INSTANCE.getImage("Expand_All_disabled");
	
	protected Collection<ISelectionChangedListener> selectionChangedListeners = new ArrayList<ISelectionChangedListener>();
	
	protected ISelection editorSelection = StructuredSelection.EMPTY;
	
	protected Collection<Resource> savedResources = new ArrayList<Resource>();
	
	protected Collection<Resource> removedResources = new ArrayList<Resource>();
	
	protected Collection<Resource> changedResources = new ArrayList<Resource>();
	
	protected boolean updateProblemIndication = true;
	
	private static final DeleteEObjectSet DELETE_EOBJECT_SET = new DeleteEObjectSet(){
		public Object[][] getParentFeature() {
			return PARENT_FEATURES;
		}
		public Object[][] getRoFeatures() {
			return RO_FEATURES;
		}
	};

	private static final RenameEObjectSet RENAME_EOBJECT_SET = new RenameEObjectSet(){
		public Object[][] getTypes() {
			return NAME_FEATURES;
		}
	};
	
	private static final Object[][] PARENT_FEATURES = new Object[][]{
		new Object[]{Feature.class, ConfigurationemfPackage.eINSTANCE.getConfiguration_Feature()},
//		new Object[]{RootConf.class, ConfigurationemfPackage.eINSTANCE.getRootConf_Include(),ConfigurationemfPackage.eINSTANCE.getRootConf_Root()},
		new Object[]{SubConf.class, ConfigurationemfPackage.eINSTANCE.getRootConf_SubConf()},
		new Object[]{View.class, ConfigurationemfPackage.eINSTANCE.getConfiguration_View()},
		new Object[]{ParentGroup.class, ConfigurationemfPackage.eINSTANCE.getView_ParentGroup()},
		new Object[]{LeafGroup.class, ConfigurationemfPackage.eINSTANCE.getParentGroup_LeafGroup()},
		new Object[]{ParentSetting.class, ConfigurationemfPackage.eINSTANCE.getFeature_ParentSetting()},
		new Object[]{LeafSetting.class, ConfigurationemfPackage.eINSTANCE.getParentSetting_LeafSetting()}
	};
	
	private static final Object[][] RO_FEATURES = new Object[][]{
		new Object[]{Feature.class, ConfigurationemfPackage.eINSTANCE.getFeature_ReadOnly()},
		new Object[]{Setting.class, ConfigurationemfPackage.eINSTANCE.getSetting_Ro()},
		new Object[]{Configuration.class, ConfigurationemfPackage.eINSTANCE.getConfiguration_ReadOnly()},
		new Object[]{View.class, ConfigurationemfPackage.eINSTANCE.getView_ReadOnly()},
		new Object[]{Group.class, ConfigurationemfPackage.eINSTANCE.getGroup_ReadOnly()},
	};
	
	private static final Object[][] NAME_FEATURES = new Object[][]{
		new Object[]{Feature.class,ConfigurationemfPackage.eINSTANCE.getFeature_Name(),ConfigurationemfPackage.eINSTANCE.getFeature_ReadOnly()},
		new Object[]{Configuration.class,ConfigurationemfPackage.eINSTANCE.getConfiguration_Name(),ConfigurationemfPackage.eINSTANCE.getConfiguration_ReadOnly()},
		new Object[]{Setting.class,ConfigurationemfPackage.eINSTANCE.getSetting_Name(),ConfigurationemfPackage.eINSTANCE.getSetting_Ro()},
		new Object[]{Group.class,ConfigurationemfPackage.eINSTANCE.getGroup_Name(),ConfigurationemfPackage.eINSTANCE.getGroup_ReadOnly()},
		new Object[]{View.class,ConfigurationemfPackage.eINSTANCE.getView_Name(),ConfigurationemfPackage.eINSTANCE.getView_ReadOnly()}	
	};
	
	protected IPartListener partListener =
		new IPartListener() {
			public void partActivated(IWorkbenchPart p) {

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

	private Timer timer = null;
	
	private static String getString(String key) {
		return S60CtEditorPlugin.INSTANCE.getString(key);
	}
	
	private EObjectFocusDomain focusDomain = new EObjectFocusDomain() {
		
		// Display items that are associated only with this editor. 
		public boolean canShow(Object object) {
			TreePath path = toTreePath(object);
			EObject root = ((CBrowserEditorInput)getEditorInput()).getRootEObject();
			return path.getSegmentCount() > 0 
			       && path.getFirstSegment() instanceof EObject
			       && isDescendant(root, (EObject)path.getFirstSegment());
		}
		
		public Collection<IObjectView> getViews() {
			ArrayList<IObjectView> ret = new ArrayList<IObjectView>();
		    ret.add(ConfigurationBrowser.this); 
		    // The method gets called in so early phase of the start up 
		    // that these methods need to be for the null return value. 
		    // Likely only one or two of them can be null
		    if (PlatformUI.getWorkbench() != null 
		    	&& PlatformUI.getWorkbench().getActiveWorkbenchWindow() != null 
		    	&& PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage() != null) {
			    for(IViewReference ref : PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getViewReferences()){
			    	IViewPart view = ref.getView(false);// try true
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
		
	public ConfigurationBrowser() {
		super();
		initializeEditingDomain();
		ObjectViewRegistry.getInstance().addView(focusDomain); 
	}

	public void gotoMarker(IMarker marker)  {
		EObject eObject = null;
		EStructuralFeature eFeature = null;
	    try
	    {
	      if (marker.getType().equals(MarkerManager.MARKER_ID))
	      {
	    	String uriAttribute = marker.getAttribute(MarkerManager.URL, null);
	        String fragment = marker.getAttribute(MarkerManager.FRAGMENT, null);
	        int featureId = marker.getAttribute(MarkerManager.FEATURE_ID, -1);
	        if (uriAttribute != null)
	        {
	          URI uri = URI.createURI(uriAttribute);
	          URI objectUri = uri.appendFragment(fragment);
	          
	          eObject = editingDomain.getResourceSet().getEObject(objectUri, false);
	          if (eObject!=null)
	          {
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
	    catch (Exception exception) {
	    	System.out.println(exception);
	    }
	    
	    Object toShow = eObject;
	    if (eFeature != null) {
	    	toShow = new EObjectStructuralFeature(eObject, eFeature);
	    }
	    if (toShow!=null) {
	    	focusDomain.focus(toShow, true); 
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
	
	private void checkUndefinedTypes()
	{
		for (Resource resource : editingDomain.getResourceSet().getResources()) 
		{
			try 
			{
				Object obj = resource.getContents().get(0);
				if(obj instanceof RootConf)
				{
					RootConf rootConf = (RootConf)obj;
					for (Setting setting : rootConf.getAllSettings())
					{
						if (setting.getType().getValue()==TYPE.UNDEFINED_VALUE)
						{
							IWorkbench workbench = PlatformUI.getWorkbench();
							IWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();
							MessageDialog.openWarning(							
									workbenchWindow.getShell(),
									getString("_UI_Warning_title"),
									getString("_UI_UndefinedTypeWarning_message"));
							
							return;
						}
					}
				}
			}
			catch (Exception exception) {

			}
		}
	}
	
	@Override
	public void doSave(IProgressMonitor monitor) {
		
		checkUndefinedTypes();
		
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
								Object rootConf = resource.getContents().get(0);
								if(rootConf instanceof RootConf && ((RootConf)rootConf).getRoot()==null)
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
			
			S60CtEditorPlugin.INSTANCE.log(exception);
		}

	}

	@Override
	public void doSaveAs() {
		
		checkUndefinedTypes();
		
		String fileExtension = "confml";
		String file = OpenConfiguration.openFilePathDialog(getSite().getShell(), new String[]{"*."+fileExtension}, SWT.SAVE);
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

		doSave(null);
	}
	

	public IActionBars getActionBars() {
		
		return getEditorSite().getActionBars();
	}
	
	public MultiPageEditorActionBarContributor getActionBarContributor() {
		MultiPageEditorActionBarContributor contrib = (MultiPageEditorActionBarContributor)getEditorSite().getActionBarContributor();
		return contrib;
	}
	@Override
	public void init(IEditorSite site, IEditorInput editorInput)
			throws PartInitException {
		setSite(site);
		setInputWithNotify(editorInput);
		setPartName(getString("_UI_Configuration_Browser_name"));
		site.setSelectionProvider(this);
		site.getPage().addPartListener(partListener);
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
		
		PrioritisedConfigurationList prioritisedConfigurationList = PrioritisedConfigurationList.getPrioritisedConfigurationList();
		prioritisedConfigurationList.clearPrioritisedConfigurationList();
			
		if (currentViewerPane != null) {
			currentViewerPane.setFocus();
		}
		else {
			getControl(getActivePage()).setFocus();
		}
	}


	@Override
	protected void createPages() {
		createModel();
		{
			ViewerPane viewerPane =
				new ViewerPane(getSite().getPage(), ConfigurationBrowser.this) {
				
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
						
					treeViewer.addFilter(FeatureViewFilter.INSTANCE);
					treeViewer.addFilter( ReadOnlyFilter.INSTANCE );
					ReadOnlyFilter.INSTANCE.addViewer( treeViewer );
					treeViewer.getTree().setData("name", getString("_UI_Configuration_pane"));
			    	return treeViewer;
				}
				public void requestActivation() {
					super.requestActivation();
					setCurrentViewerPane(this);
				}
			};
		viewerPane.createControl(getContainer());

		selectionViewer = (TreeViewer)viewerPane.getViewer();
		selectionViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
		selectionViewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		selectionViewer.setInput(editingDomain.getResourceSet());
		selectionViewer.setSelection(new StructuredSelection(editingDomain.getResourceSet().getResources().get(0)), true);

		createContextMenuFor(selectionViewer);
		int pageIndex = addPage(viewerPane.getControl());
		setPageText(pageIndex, getString("_UI_Configuration_pane"));
		}
		{
			ViewerPane viewerPane =
				new ViewerPane(getSite().getPage(), ConfigurationBrowser.this) {
				
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
							
						treeViewer.addFilter(FeatureViewFilter.INSTANCE);
						treeViewer.addFilter(new FeaturePathFilter());
						treeViewer.setComparator(new ViewerComparator(){

							@Override
							public int compare(Viewer viewer, Object e1,
									Object e2) {
								// Auto-generated method stub
								if (e1 instanceof Feature)
								{
									Feature f1 = (Feature)e1;
									Feature f2 = (Feature)e2;
									return super.compare(viewer, f1.getName(), f2.getName());
								}
								else if (e1 instanceof Setting) //should setting be here in alphabetical order or in the same order as in confml?
								{
									Setting s1 = (Setting)e1;
									Setting s2 = (Setting)e2;
									return super.compare(viewer, s1.getName(), s2.getName());
								}
								else
								{
									return super.compare(viewer, e1, e2);
								}
							}
						});
						treeViewer.addFilter( ReadOnlyFilter.INSTANCE );
						ReadOnlyFilter.INSTANCE.addViewer( treeViewer );
				    	return treeViewer;
					}
					public void requestActivation() {
						super.requestActivation();
						setCurrentViewerPane(this);
					}
				};
			viewerPane.createControl(getContainer());

			parentViewer = (TreeViewer)viewerPane.getViewer();
			parentViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
			parentViewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
			parentViewer.setInput(editingDomain.getResourceSet());
			parentViewer.setSelection(new StructuredSelection(editingDomain.getResourceSet().getResources().get(0)), true);

			createContextMenuFor(parentViewer);
			int pageIndex = addPage(viewerPane.getControl());
			setPageText(pageIndex, getString("_UI_Feature_pane"));
		}
		{
			ViewerPane viewerPane =
				new ViewerPane(getSite().getPage(), ConfigurationBrowser.this) {
					
					@Override
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
							
						treeViewer.addFilter(FeatureViewFilter.INSTANCE);
						treeViewer.addFilter(new ViewPathFilter());
						treeViewer.addFilter( ReadOnlyFilter.INSTANCE );
						ReadOnlyFilter.INSTANCE.addViewer( treeViewer );
				    	return treeViewer;
					}
					@Override
					public void requestActivation() {
						super.requestActivation();
						setCurrentViewerPane(this);
					}
				};
			
			viewerPane.createControl(getContainer());
			parentViewer = (TreeViewer)viewerPane.getViewer();
			parentViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
			parentViewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
			parentViewer.setInput(editingDomain.getResourceSet());
			parentViewer.setSelection(new StructuredSelection(editingDomain.getResourceSet().getResources().get(0)), true);

			createContextMenuFor(parentViewer);
			int pageIndex = addPage(viewerPane.getControl());
			setPageText(pageIndex, getString("_UI_View_pane"));
			
			addExpandAndCollapseButtons(viewerPane.getControl().getParent());
			
		}
		
	}
	
	protected void createContextMenuFor(StructuredViewer viewer) {
		MenuManager contextMenu = new MenuManager("#PopupMenu");
		contextMenu.setRemoveAllWhenShown(true);
		contextMenu.addMenuListener(this);
		
		Menu menu= contextMenu.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(contextMenu, new UnwrappingSelectionProvider(viewer));

	}

	
	public void addSelectionChangedListener(ISelectionChangedListener listener) {
		selectionChangedListeners.add(listener);
		
	}

	public void removeSelectionChangedListener(ISelectionChangedListener listener) {
		selectionChangedListeners.remove(listener);
	}
	
	public ISelection getSelection() {
		return editorSelection;
	}

	public void setSelection(ISelection selection) {
		editorSelection = selection;

		for (ISelectionChangedListener listener : selectionChangedListeners) {
			listener.selectionChanged(new SelectionChangedEvent(this, selection));
		}

	}

	@Override
	public void dispose() {
		ObjectViewRegistry.getInstance().removeView(focusDomain); 
		
		getSite().getPage().removePartListener(partListener);
		adapterFactory.dispose();
		
		if (propertySheetPage != null) {
			propertySheetPage.dispose();
		}
		
		MarkerManager.getInstance().deleteResourceMarkerS(editingDomain.getResourceSet().getResources());
		
		//clean setting editor, when corresponding configuration browser is closed by user
		if(!PlatformUI.getWorkbench().isClosing()){
			IViewReference[] references = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getViewReferences();
			for (IViewReference viewReference : references) {
				if(viewReference.getId().compareTo(SettingEditorView.ID)==0){
				  SettingEditorView view = (SettingEditorView)viewReference.getPart(true);
			      view.cleanViewer(this);
				}else if(viewReference.getId().compareTo(DescriptionView.ID)==0){
					DescriptionView view = (DescriptionView)viewReference.getPart(true);
				    view.cleanViewer(this);
				}else if(viewReference.getId().compareTo(OptionView.ID)==0){
					OptionView view = (OptionView)viewReference.getPart(true);
				    view.cleanViewer(this);
				}
			}
		}
		
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
							setSelection(selectionChangedEvent.getSelection());
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
			setSelection(currentViewer == null ? StructuredSelection.EMPTY : currentViewer.getSelection());
		}
	}		

	public void createModel() {
		try
		{
			IEditorInput editorInput = getEditorInput();
			CBrowserEditorInput input=null;
			if(editorInput instanceof FileEditorInput){
				input = new CBrowserEditorInput(((FileEditorInput)editorInput).getFile());
			}else{
				input = (CBrowserEditorInput)editorInput;
			}
			URI resourceURI = URI.createFileURI(input.getFile().getRawLocation().toString());
			Resource resource = null;
			try {
				resource = editingDomain.getResourceSet().getResource(resourceURI, true);
			}catch (Exception e) 
			{
				Throwable cause = e.getCause();
				int lineNumber = -1;
				if (cause instanceof SAXParseException)
				{
					SAXParseException saxException = (SAXParseException)e.getCause();
					lineNumber = saxException.getLineNumber();
				}
				resource = editingDomain.getResourceSet().getResource(resourceURI, false);
				int featureId = ConfigurationemfPackage.eINSTANCE.getConfiguration_Name().getFeatureID();
				String message = cause.getMessage();
				if (lineNumber!=-1)
					message = "Invalid file. "+message+" (line "+lineNumber+")";
				else
					message = "Invalid file. "+message;
				EObject obj = null;
				if(resource!=null&&!resource.getContents().isEmpty())
					obj = (EObject)resource.getContents().get(0);
				MarkerManager.getInstance().addExternalProblem(obj, input.getFile(), input.getFile().getLocationURI().getPath(), featureId, message, true, false);
				try
				{
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(IPageLayout.ID_PROBLEM_VIEW);
				} 
				catch (Exception e2)
				{

				}
			}
			if(resource!=null&&!resource.getContents().isEmpty()){
				EObject rootObject = (EObject)resource.getContents().get(0);
				input.setRootEObject(rootObject);
			}
			setInput(input);
		}
		catch (ClassCastException cce)
		{
			System.out.println(cce.getMessage());
		}
	}
	
	protected void initializeEditingDomain() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("confml", new ConfigurationemfResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xml", new VariantDataResourceFactoryImpl());
		// Create an adapter factory that yields item providers.
		//
		adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		
		adapterFactory.addAdapterFactory(new S60CTItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		

		// Create the command stack that will notify this editor as commands are executed.
		//
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
		// Make sure it's okay.
		//
		if (theSelection != null && !theSelection.isEmpty()) {
			if (currentViewer != null) {
				currentViewer.setSelection(new StructuredSelection(theSelection.toArray()), false);
			}
		}
	}
	
	//path filters
	private class FeaturePathFilter extends ViewerFilter{
		public boolean select(Viewer viewer, Object parentElement, Object element) {
			return true;
		}
		public Object[] filter(Viewer viewer, Object parent, Object[] elements) {
			if(parent instanceof ResourceSet){ //parents only
				Set result = new HashSet();
				TreeViewer tviewer = (TreeViewer)viewer;
				for (int i = 0; i < elements.length; i++) {
					Object element = elements[i];
					if(element instanceof Feature)result.add(element);
					else if (element instanceof Configuration){
						Object[] children = filter(viewer,parent,((AdapterFactoryContentProvider)tviewer.getContentProvider()).getElements(elements[i]));
						result.addAll(Arrays.asList(children));
					}
				}
				return result.toArray();
			}else return super.filter(viewer, parent, elements);
		}
	}
	
	private class ViewPathFilter extends ViewerFilter{
		public boolean select(Viewer viewer, Object parentElement, Object element) {
			return true;
		}
		public Object[] filter(Viewer viewer, Object parent, Object[] elements) {
			if(parent instanceof ResourceSet){ //parents only
				Set result = new HashSet();
				TreeViewer tviewer = (TreeViewer)viewer;
				for (int i = 0; i < elements.length; i++) {
					Object element = elements[i];
					if(element instanceof View)result.add(element);
					else if (element instanceof Configuration){
						Object[] children = filter(viewer,parent,((AdapterFactoryContentProvider)tviewer.getContentProvider()).getElements(elements[i]));
						result.addAll(Arrays.asList(children));
					}
				}
				return result.toArray();
			}else return super.filter(viewer, parent, elements);
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
		}else{
			return super.getAdapter(key);
		}
	}
	
	public IPropertySheetPage getPropertySheetPage() {
		if (propertySheetPage == null) {
			propertySheetPage =
				new ExtendedPropertySheetPage(editingDomain) {
					@Override
					public void setSelectionToViewer(List<?> selection) {
						ConfigurationBrowser.this.setSelectionToViewer(selection);
						ConfigurationBrowser.this.setFocus();
					}

					@Override
					
					public void setActionBars(IActionBars actionBars) {
						super.setActionBars(actionBars);
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
		  setSelection(getSelection());
		}

		if (!removedResources.isEmpty()) {
			if (handleDirtyConflict()) {
				getSite().getPage().closeEditor(ConfigurationBrowser.this, false);
				ConfigurationBrowser.this.dispose();
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
	
	protected boolean handleDirtyConflict() {
		return
			MessageDialog.openQuestion
				(getSite().getShell(),
				 getString("_UI_FileConflict_label"),
				 getString("_WARN_FileConflict"));
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

	public EditingDomain getEditingDomain() {
		return editingDomain;
	}
	
	public void menuAboutToShow(IMenuManager menuManager) {
		fillContextMenu(menuManager);
		
	}
	
	protected void fillContextMenu(IMenuManager menuManager){
		IMenuManager newMenu = new MenuManager("New",getString("_UI_Popup_Group_New"));
		newMenu.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
		menuManager.add(new Separator());
		menuManager.add(newMenu);
		menuManager.add(new Separator());
		menuManager.add(new GroupMarker(getString("_UI_Popup_Group_Edit")));
	}

	public Viewer getViewer() {
		return currentViewer;
	}

	
	private boolean isDescendant(EObject parent, EObject child) {
		EObject loc = child;
		while (loc != null) {
			if (loc == parent) {
				return true; 
			}
			if (loc instanceof RootConf) {
				loc = ((RootConf)loc).getRoot(); 
			} else {
				loc = loc.eContainer(); 
			}
		}
		return false;
	}
	
	/**
	 * Show only objects included in ConfigurationBrowser's configuration
	 */
	public boolean canShow(Object object) {
		if (object instanceof Configuration || 
			object instanceof Feature ||
			object instanceof Setting ||
			object instanceof View ||
			object instanceof Group) {
			EObject root = ((CBrowserEditorInput)getEditorInput()).getRootEObject();
			if (isDescendant(root, (EObject)object)) {
				return true;
			}
		}
		return false;
	}
	
	public void show(Object object, boolean tryActivate) throws IllegalArgumentException {
		if (!canShow(object)) {
			throw new IllegalArgumentException(); 
		}
		selectionViewer.expandToLevel(2);
		selectionViewer.setSelection(new TreeSelection(new TreePath(new Object[] {object})), true); 
		if (tryActivate) {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().activate(this); 
		}else {
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
