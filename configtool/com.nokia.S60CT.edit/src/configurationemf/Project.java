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
package configurationemf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;

import s60ct.provider.S60CTItemProviderAdapterFactory;
import s60ct.provider.ViewEditorItemProviderAdapterFactory;
import variantdata.util.VariantDataResourceFactoryImpl;
import configurationemf.selections.ConfigurationResourceSetItemProvider;
import configurationemf.util.ConfigurationemfResourceFactoryImpl;

public class Project  {
	
	public static String BY_FEATURE = ConfigurationResourceSetItemProvider.BY_FEATURE;
	public static String BY_CONFIGURATION = ConfigurationResourceSetItemProvider.BY_CONFIGURATION;
	public static String BY_VIEW = ConfigurationResourceSetItemProvider.BY_VIEW;

	
	protected static Project instance=null;
	
	public static String EMPTY_URL =".confml";
	
	public static Project instance(){
		if(instance==null){
			instance = new Project();
		}
		return instance;
	}
	
	
	protected ComposedAdapterFactory adapterFactory=null;
	protected ComposedAdapterFactory viewEditorAdapterFactory=null;
	protected AdapterFactoryEditingDomain editingDomain=null;
	protected ResourceItemProviderAdapterFactory resourceFactory = null;
//	protected OptionAdapterFactory optionContentAF = new OptionAdapterFactory();
	public static final ParentSetting ZERO_PSETTING = ConfigurationemfFactory.eINSTANCE.createParentSetting();
	
	protected Project(){
		resourceFactory = new ResourceItemProviderAdapterFactory();
		ReflectiveItemProviderAdapterFactory reflectiveFactory = new ReflectiveItemProviderAdapterFactory();
		S60CTItemProviderAdapterFactory forFeatureView = new S60CTItemProviderAdapterFactory();
		ViewEditorItemProviderAdapterFactory forViewEditor = new ViewEditorItemProviderAdapterFactory();
		List factories = new ArrayList();
		
		//factories for FeatureView
		factories.add(forFeatureView);
		factories.add(reflectiveFactory);
		factories.add(resourceFactory);
		
		adapterFactory = new ComposedAdapterFactory(factories);
		
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("confml", new ConfigurationemfResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xml", new VariantDataResourceFactoryImpl());
		
		
		//factories for SettingEditor
		List factories2 = new ArrayList();
		factories2.add(forViewEditor);
		viewEditorAdapterFactory = new ComposedAdapterFactory(factories2);

		BasicCommandStack commandStack = new BasicCommandStack();
		editingDomain = new AdapterFactoryEditingDomain(adapterFactory, commandStack, new HashMap());
		
	}
	
	public AdapterFactoryEditingDomain getEditingDomain() {
		return editingDomain;
	}
	
	public void createEmptyConfiguration(){
		Resource resource =   this.getEditingDomain().createResource(EMPTY_URL);
		Configuration emptyConfiguration = ConfigurationemfFactory.eINSTANCE.createRootConf();
		
		emptyConfiguration.setVers("1");
		
		getEditingDomain().getResourceToReadOnlyMap().put(resource, Boolean.FALSE);
		resource.getContents().add(emptyConfiguration);
		
	}
	public Feature createEmptyFeature(){
		Feature emptyFeature = ConfigurationemfFactory.eINSTANCE.createFeature();
		return emptyFeature;
	}
	public View createEmptyView(){
		View emptyView = ConfigurationemfFactory.eINSTANCE.createView();
		return emptyView;
	}
	public Setting createEmptyParentSetting(){
		Setting emptyPSetting = ConfigurationemfFactory.eINSTANCE.createParentSetting();
		return emptyPSetting;
	}

	public Group createEmptyParentGroup(){
		Group emptyParentGroup = ConfigurationemfFactory.eINSTANCE.createParentGroup();
		return emptyParentGroup;
	}
	
	public Group createEmptyLeafGroup(){
		Group emptyLeafGroup = ConfigurationemfFactory.eINSTANCE.createLeafGroup();
		return emptyLeafGroup;
	}

	public GSetting createEmptyGSetting(){
		GSetting emptyGSetting = ConfigurationemfFactory.eINSTANCE.createGSetting();
		return emptyGSetting;
	}
	public Option createEmptyOption(){
		Option emptyOption = ConfigurationemfFactory.eINSTANCE.createOption();
		return emptyOption;
	}
	
	
	public void selectionBy(String value){
//		resourceFactory.getResourceSetIP().setSelected(value);
	}
	
	/*
	 * recursively scrolls over the tree-data structure until RootConf is found.
	 * returns true, is RootConf is not included by any other configuration.
	 */
	public boolean isEditableElement(EObject object){
		RootConf root = null;
		boolean rtr = false;
		if(object instanceof RootConf){
			root = (RootConf)object;
			rtr =  isRoot(root);
		}
		else if(object.eContainer()!=null)
			return isEditableElement(object.eContainer());
		else if(object.equals(Project.ZERO_PSETTING))
			return true;
		else return false;	
		return rtr;
	}
	
	public boolean isRoot(RootConf conf){
		return conf.getRoot()==null;
	}
	/*
	 * returns RootConf that is currently opened as a root conf
	 */
	public static RootConf getMyRootConf(EObject object){
		if(object instanceof RootConf){
			RootConf rootConf = (RootConf)object;
			if(rootConf.getRoot()==null){
				return rootConf;
			}else
				return getMyRootConf(rootConf.getRoot());
		}else if(object != null){
			return getMyRootConf(object.eContainer());
		}
		return null;
	}
	/*
	 * returns RootConf where an object is defined
	 */
	public static RootConf getMyHomeConf(EObject object){
		if(object instanceof RootConf) return (RootConf)object;
		else return getMyHomeConf(object.eContainer());
	}
	public ComposedAdapterFactory getAdapterFactory() {
		return adapterFactory;
	}

	public ComposedAdapterFactory getViewEditorAdapterFactory() {
		return viewEditorAdapterFactory;
	}

//	public OptionAdapterFactory getOptionContentAF() {
////		return optionContentAF;
//	}
}
