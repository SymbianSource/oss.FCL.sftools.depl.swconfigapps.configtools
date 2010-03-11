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
package com.nokia.s60ct.gui.views;

import interfaces.DeleteEObjectSet;

import java.util.List;

import objectview.IObjectView;

import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.UnwrappingSelectionProvider;
import org.eclipse.emf.edit.ui.view.ExtendedPropertySheetPage;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.layout.TreeColumnLayout;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DragSourceAdapter;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.PropertySheetPage;

import s60ct.provider.ParentSettingForFeatureView;
import s60ct.provider.S60CTItemProviderAdapterFactory;

import com.nokia.s60ct.gui.editors.ConfigurationBrowser;
import com.nokia.s60ct.gui.filter.ReadOnlyFilter;
import com.nokia.s60ct.gui.filter.SettingEditorFilter;
import com.nokia.s60ct.gui.viewer.DCAdapterFactoryContentProvider;
import com.nokia.s60ct.gui.viewer.DCAdapterFactoryLabelProvider;
import com.nokia.s60ct.gui.viewer.DCTreeViewer;

import concepts.EObjectStructuralFeature;
import configurationemf.ConfigurationemfPackage;
import configurationemf.Feature;
import configurationemf.Frame;
import configurationemf.LeafSetting;
import configurationemf.LeafSettingDelegator;
import configurationemf.ParentSetting;
import configurationemf.Ref;
import configurationemf.Referable;
import configurationemf.Setting;
import configurationemf.TYPE;

public class SettingEditorView 
extends ViewPart 
implements ISelectionListener, IMenuListener, IViewerProvider, IObjectView {


	public static final String ID ="com.nokia.S60CT.gui.SettingEditor";

	private Feature feature=null;
	private Composite rootComposite = null;
	DCTreeViewer viewer=null;
	SequenceMenu sequenceMenu=null;
	private ITableLabelProvider labelProvider=null;
	private IContentProvider contentProvider = null;
	PropertySheetPage propertySheetPage = null;

	private static final int STYLE = SWT.SINGLE | SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.VIRTUAL | SWT.FULL_SELECTION;

	public static int def_column_order[] = null;
	public static int value_position = 2;
	public static final String COLUMN_INT_KEY = "cint";

	private static final Object[][] NORMAL_SETTINGS = new Object[][]{
		new Object[]{ParentSetting.class, ConfigurationemfPackage.eINSTANCE.getFeature_ParentSetting()},
		new Object[]{LeafSettingDelegator.class, ConfigurationemfPackage.eINSTANCE.getParentSetting_LeafSetting()},	
		new Object[]{LeafSetting.class, ConfigurationemfPackage.eINSTANCE.getParentSetting_LeafSetting()}
	};

	private static final Object[][] RO_SETTINGS = new Object[][]{
		new Object[]{Setting.class, ConfigurationemfPackage.eINSTANCE.getSetting_Ro()}
	};

	private static final DeleteEObjectSet DELETE_EOBJECT_SET = new DeleteEObjectSet(){
		public Object[][] getParentFeature() {
			return NORMAL_SETTINGS;
		}
		public Object[][] getRoFeatures() {
			return RO_SETTINGS;
		}
	};

	private static final String[][] COLUMNS = new String[][]{
		new String[]{"Setting","Setting Name",ParentSettingForFeatureView.PROP_NAME},
		new String[]{"Type","Setting Type",ParentSettingForFeatureView.PROP_TYPE},
		new String[]{"Default","Setting Default Value",ParentSettingForFeatureView.PROP_DEF},
		new String[]{"Value","Modified Value",ParentSettingForFeatureView.PROP_VALUE},
		new String[]{"Ref","Reference",ParentSettingForFeatureView.PROP_REF},
		new String[]{"Cust.Config.","Customer Configurable",ParentSettingForFeatureView.PROP_READONLY}
	};
	private static final int COLUMN_NAME =0;
	private static final int COLUMN_TTEXT=1;
	private static final int COLUMN_PROP=2;

	public SettingEditorView() {
		labelProvider = new DCAdapterFactoryLabelProvider(new S60CTItemProviderAdapterFactory());
		contentProvider = new DCAdapterFactoryContentProvider(new S60CTItemProviderAdapterFactory());
	}

	@SuppressWarnings("unchecked")
	public Object getAdapter(Class adapter) {
		if(adapter.equals(IPropertySheetPage.class)){
			return getPropertySheetPage();
		}else if(adapter.equals(DeleteEObjectSet.class)){
			return DELETE_EOBJECT_SET;

		}
		return super.getAdapter(adapter);
	}

	public IPropertySheetPage getPropertySheetPage() {
		if (propertySheetPage == null&&feature!=null) {
			propertySheetPage =
				new ExtendedPropertySheetPage((AdapterFactoryEditingDomain)AdapterFactoryEditingDomain.getEditingDomainFor(feature)) {
				public void setSelectionToViewer(List<?> selection) {
					viewer.setSelection(new StructuredSelection(selection.toArray()), true);
				}

			};
			propertySheetPage.setPropertySourceProvider(new AdapterFactoryContentProvider(new S60CTItemProviderAdapterFactory()));
		}
		return propertySheetPage;
	}

	@Override
	public void createPartControl(Composite parent) {
		this.rootComposite = parent;
		parent.setLayout(new GridLayout(1,true));
		parent.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true));
		createTable(parent);
		//createSequenceMenu(parent);
	}


	private void setSeqMenuVisible(boolean visible)
	{
		if (visible)
		{
			if (sequenceMenu==null)
			{
				createSequenceMenu(rootComposite);
				rootComposite.layout(true);
				rootComposite.redraw();
			}
		}
		else
		{
			if (sequenceMenu!=null)
			{
				sequenceMenu.dispose();
				sequenceMenu = null;
				rootComposite.layout(true);
				rootComposite.redraw();
				
				
				
			}
		}
	}


	private void createSequenceMenu(Composite parent) {
		sequenceMenu = new SequenceMenu(parent, this);
	}

	private void createTable(Composite parent) {
		Composite container = new Composite(parent,SWT.FILL);
		TreeColumnLayout layout= new TreeColumnLayout();
		container.setLayout(layout);
		container.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true));

		final Tree tree = new Tree(container,STYLE);
		tree.setHeaderVisible(true);
		tree.setLinesVisible(true);

		viewer = new DCTreeViewer(tree);
		this.setActiveColumns(viewer);

		layout.setColumnData(tree.getColumn(0), new ColumnWeightData(4,1,true));
		for(int i=1;i<tree.getColumnCount();i++)
			layout.setColumnData(tree.getColumn(i), new ColumnWeightData(1,1,true));

		tree.setData("name", "Setting Editor");
		viewer.setLabelProvider(labelProvider);
		viewer.setContentProvider(contentProvider);
		viewer.addFilter(SettingEditorFilter.INSTANCE);

		viewer.addFilter(ReadOnlyFilter.INSTANCE);
		ReadOnlyFilter.INSTANCE.addViewer(viewer);

		DragSource source = new DragSource(viewer.getControl(), DND.DROP_DEFAULT | DND.DROP_COPY | DND.DROP_MOVE);
		Transfer[] types = new Transfer[] {TextTransfer.getInstance()};
		source.setTransfer(types);
		source.addDragListener(new DragSourceAdapter() {
			public void dragSetData(DragSourceEvent event) {
				Object object = viewer.getTree().getSelection()[0].getData();
				if (object instanceof LeafSettingDelegator ) {
					// Sequence type
					Feature feature = (Feature) viewer.getTree().getSelection()[0].getParent().getData();
					ParentSetting setting = (ParentSetting) viewer.getTree().getSelection()[0].getParentItem().getParentItem().getData();
					LeafSetting leaf = ((LeafSettingDelegator) object).getLeafSetting();
					event.data = setting.getName()+"///"+leaf.getName() + ";sequenceitem;" + feature.getRef() + "/" + setting.getRef() + ";" + leaf.getType() + ";" + leaf.getRef();
				} else {
					Setting setting = (Setting) object;
					if (setting.getType().equals(TYPE.SEQUENCE))
					{
						ParentSetting pSetting = (ParentSetting)setting;
						Frame frame = pSetting.getTemplate();
						String leafSettings = ""; //this stores the leafsettings as name1/type1/ref1;name2/type2/ref2
						for (LeafSettingDelegator lsd : frame.getLeafSettings())
						{

							String ref = lsd.getLeafSetting().getRef();
							if (ref==null)
								ref = "";
							String name = lsd.getName();
							if (name==null)
								name = "";
							leafSettings=leafSettings+";"+name+"/"+lsd.getType().getName()+"/"+ref;
						}
						event.data = setting.getName() + ";" + setting.getType() + ";" + setting.getAbsRef()+leafSettings;
					}
					else
						event.data = setting.getName() + ";" + setting.getType() + ";" + setting.getAbsRef();
				}
			}
		});

		createContextMenuFor(viewer);
		getSite().setSelectionProvider(viewer);
		getSite().getPage().addSelectionListener(this);
	}

	public void setActiveColumns(TreeViewer treeViewer){
		final Tree tree = treeViewer.getTree();
		String[] columnProp=new String[COLUMNS.length];
		for(int i=0;i<COLUMNS.length;i++){
			String name = COLUMNS[i][COLUMN_NAME];
			String tip = COLUMNS[i][COLUMN_TTEXT];
			String prop = COLUMNS[i][COLUMN_PROP];
			TreeColumn column = new TreeColumn(tree,SWT.NONE);
			column.setText(name);
			column.setToolTipText(tip);
			columnProp[i]=prop;
		}
		treeViewer.setColumnProperties(columnProp);
		treeViewer.setCellEditors(new CellEditor[tree.getColumnCount()]);
	}

	@Override
	public void setFocus() {
		viewer.getTree().setFocus();
	}

	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		Object selectedObject = null;
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structedSelection = (IStructuredSelection) selection;
			selectedObject = structedSelection.getFirstElement();
		}
		if (part instanceof ConfigurationBrowser) {
			if (canShow(selectedObject)) {
				show(selectedObject, false);
			} else {
				setFeature(null); 
			}
			updateSequenceMenu(selectedObject);
		} 
		else if (part instanceof SettingEditorView)
		{
			try
			{
				updateSequenceMenu(selectedObject);
			}
			catch (Exception exc)
			{
				System.err.println("Error:"+exc.toString());
			}
		}
	}

	private void updateSequenceMenu(Object selectedObject){

		boolean shouldBeVisible = false;
		if(selectedObject instanceof ParentSetting)
		{
			if (((ParentSetting)selectedObject).getType().equals(TYPE.SEQUENCE))
			{
				shouldBeVisible = true;
			}
		}
		else if(selectedObject instanceof Frame)
		{
			shouldBeVisible = true;
		}
		else if(selectedObject instanceof LeafSettingDelegator)
		{
			shouldBeVisible = true;
		}
		setSeqMenuVisible(shouldBeVisible);
		if (shouldBeVisible)
			sequenceMenu.setSetting(selectedObject);
	}

	protected void setFeature(Feature feature) {
		this.feature=feature;
		viewer.setInput(feature);
	}

	public void updateView()
	{
		viewer.refresh();
	}

	@Override
	public void dispose() {

		if(propertySheetPage!=null)propertySheetPage.dispose();
		if(!viewer.getTree().isDisposed())viewer.getTree().dispose();
		getSite().getPage().removeSelectionListener(this);
		super.dispose();
	}

	public void menuAboutToShow(IMenuManager manager) {

	}


	protected void createContextMenuFor(StructuredViewer viewer) {
		MenuManager contextMenu = new MenuManager("#PopupMenu");
		contextMenu.setRemoveAllWhenShown(true);
		contextMenu.addMenuListener(this);

		Menu menu= contextMenu.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(contextMenu, new UnwrappingSelectionProvider(viewer));
	}

	/**
	 * @deprecated use getViewer() (from ViewerProvider interface) instead. 
	 * @return
	 */
	public TreeViewer getTreeViewer() {
		return viewer; 
	}

	public TreeViewer getViewer() {
		return viewer; 
	}

	//clean setting editor if all configuration browsers are closed
	public void cleanViewer(EditorPart editor){
		IEditorReference[] references = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getEditorReferences();
		boolean bExist=false;
		for (IEditorReference editorReference : references) {
			if(editorReference.getId().compareTo(ConfigurationBrowser.ID)==0)
				bExist=true;
		}
		if(!bExist)
			viewer.setInput(null);
		viewer.refresh();
	}

	//
	// Showing/displaying objects
	//

	/**
	 * Returns true, if successful
	 */
	public boolean selectAttribute(Setting setting, EStructuralFeature feature) {
		selectSetting(setting); 


		TreeItem[] items = viewer.getTree().getSelection();
		for (int i = 0; i < COLUMNS.length; i++) {
			if (feature.equals(ParentSettingForFeatureView.getAttributeByProperty(COLUMNS[i][COLUMN_PROP]))) {	
				viewer.getCursor().setSelection(items[0], i);
				return true;
			}
		}
		return false; 
	}

	public void selectSetting(Setting setting) {
		// Find out the parent feature
		EObject loc = setting;
		while (loc != null && !(loc instanceof Feature)) loc = loc.eContainer();

		if (loc instanceof Feature) {
			setFeature((Feature)loc); 
			getViewer().setSelection(new TreeSelection(new TreePath(new Object[] {setting}))); 
		}
	}

	public boolean canShow(Object object) {
		if (object instanceof EObjectStructuralFeature) {
			// Able to point out to attributes
			return ((EObjectStructuralFeature)object).getEObject() instanceof Setting; 
		} else if (object instanceof Setting
				|| object instanceof Feature) {
			return true; 
		} else if (object instanceof Ref && ((Ref)object).getReferable() instanceof Setting) {
			return true;
		}
		return false;
	}

	public void show(Object object, boolean tryActivate) throws IllegalArgumentException {
		if (!canShow(object)) {
			throw new IllegalArgumentException(); 
		}
		if (object instanceof EObjectStructuralFeature) {
			EObjectStructuralFeature featureRef = (EObjectStructuralFeature)object;
			selectAttribute((Setting)featureRef.getEObject(), featureRef.getEStructuralFeature());
		} else if (object instanceof Ref) {
			Ref ref = (Ref)object;
			Referable referable = ref.getReferable();
			selectAttribute((Setting)referable, ConfigurationemfPackage.eINSTANCE.getSetting_CurrentValue()); 
		} else if (object instanceof Setting) {	
			selectSetting((Setting)object); 
		} else if (object instanceof Feature) {
			setFeature((Feature)object); 
		}
	}
}
