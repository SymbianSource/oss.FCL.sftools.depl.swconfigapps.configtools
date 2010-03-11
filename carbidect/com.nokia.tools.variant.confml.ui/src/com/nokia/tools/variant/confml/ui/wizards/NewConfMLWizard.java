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
 * Description: This file is part of com.nokia.tools.variant.confml.ui component.
 */

package com.nokia.tools.variant.confml.ui.wizards;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.ui.WorkbenchException;

import com.nokia.tools.variant.confml.core.ConfMLCore;
import com.nokia.tools.vct.common.appmodel.EConfMLLayer;
import com.nokia.tools.vct.common.appmodel.EConfigurationProject;
import com.nokia.tools.vct.confml.model.confml1.EConfML1Factory;
import com.nokia.tools.vct.confml.model.confml1.EConfMLDocument;
import com.nokia.tools.vct.confml.model.confml1.EConfigurationElement;
import com.nokia.tools.vct.confml.model.confml1.EDataElement;
import com.nokia.tools.vct.confml.model.confml1.EDescriptionElement;
import com.nokia.tools.vct.confml.model.confml1.EFeatureData;
import com.nokia.tools.vct.confml.model.confml1.EFeatureElement;
import com.nokia.tools.vct.confml.model.confml1.EGroup;
import com.nokia.tools.vct.confml.model.confml1.ESettingData;
import com.nokia.tools.vct.confml.model.confml1.ESettingElement;
import com.nokia.tools.vct.confml.model.confml1.EViewElement;
import com.nokia.tools.vct.confml.model.confml1.include.EConfMLIncludeFactory;
import com.nokia.tools.vct.confml.model.confml1.include.EInclude;
import com.nokia.tools.vct.confml.model.confml1.util.EConfML1ResourceFactoryImpl;
import com.nokia.tools.vct.confml.model.confml2.EConfML2Document;
import com.nokia.tools.vct.confml.model.confml2.EConfML2Factory;
import com.nokia.tools.vct.confml.model.confml2.util.EConfML2ResourceFactoryImpl;

public class NewConfMLWizard extends NewElementWizard {

	private static final String CONFML_VIEW_EDITOR_ID = "com.nokia.tools.variant.editor.ViewEditor";
	private static final String CONFML_GENERIC_EDITOR_ID = "com.nokia.tools.vct.confml.model.confml1.edit.presentation.EConfML1EditorID";
	private static final String CONFML_EDITOR_ID = "com.nokia.tools.carbide.ct.confml.ui.editors.ConfMLMultiPageEditorPart";
	private static final String CONFML_INCLUSION_EDITOR_ID = "com.nokia.tools.vct.confml.editor.include.xincmodel.presentation.EXincModelEditorID";
	private NewConfMLWizardPageOne pageOne;
	private NewConfMLWizardPageTwo pageTwo;
	private NewConfMLWizardInitViewPage initViewPage;

	private IFile createdElement;

	/**
	 * Constructor for NewConfMLWizard.
	 */
	public NewConfMLWizard() {
		super();
		setNeedsProgressMonitor(true);
	}

	/**
	 * Adding the page to the wizard.
	 */

	public void addPages() {
		pageOne = new NewConfMLWizardPageOne();

		for (Object obj : getSelection().toArray()) {
			if (obj instanceof IContainer) {
				pageOne.setInitialContainer((IContainer) obj);
				break;
			} else if (obj instanceof IResource) {
				pageOne.setInitialContainer(((IResource) obj).getParent());
				break;
			}
		}
		;
		addPage(pageOne);
		pageTwo = new NewConfMLWizardPageTwo();
		addPage(pageTwo);
		initViewPage = new NewConfMLWizardInitViewPage();
		addPage(initViewPage);
	}

	@Override
	public boolean canFinish() {
		return pageOne.isPageComplete();
	}

	@Override
	public IWizardPage getNextPage(IWizardPage page) {
		if (page == pageOne) {
			pageTwo.setFile(pageOne.getSelectedFile());
			return pageTwo;
		}
		if (page == pageTwo) {
			if (pageTwo.isViewContentType()) {
				return initViewPage;
			}
		}
		return null;
	}

	@Override
	public IWizardPage getPreviousPage(IWizardPage page) {
		if (page == initViewPage) {
			return pageTwo;
		}
		if (page == pageTwo) {
			return pageOne;
		}
		return null;
	}

	@Override
	protected void finishPage(IProgressMonitor monitor)
	throws InterruptedException, CoreException {
		final IFile file = pageOne.getSelectedFile();

		Resource.Factory rfactory;
		String editorId;
		boolean versionOne = pageTwo.isVersionOne();
		if (versionOne) {
			rfactory = new EConfML1ResourceFactoryImpl();
		} else {
			rfactory = new EConfML2ResourceFactoryImpl();
		}
		URI uri = URI.createPlatformResourceURI(file.getFullPath()
				.toPortableString(), true);
		Resource resource = rfactory.createResource(uri);

		if (versionOne) {
			EConfML1Factory factory = EConfML1Factory.eINSTANCE;
			EConfMLDocument document = factory.createEConfMLDocument();
			resource.getContents().add(document);

			EConfigurationElement configuration = factory
			.createEConfigurationElement();
			document.setConfiguration(configuration);

			if (pageTwo.isDataContentType()) {
				EDataElement data = factory.createEDataElement();
				configuration.getData().add(data);
				editorId = CONFML_GENERIC_EDITOR_ID;
			} else if (pageTwo.isTypeContentType()) {
				EFeatureElement type = factory.createEFeatureElement();
				type.setRef("SampleFeature");
				type.setName("New Sample Feature");
				
				EDescriptionElement desc = factory.createEDescriptionElement();
				desc.setDescription("A new sample feature");
				type.getDescriptions().add(desc);
				
				//sample setting
				ESettingElement setting = factory.createESettingElement();
				setting.setType("string");
				setting.setName("New Sample Setting");
				setting.setRef("SampleSetting");
				desc = factory.createEDescriptionElement();
				desc.setDescription("A new sample setting");
				setting.getDescriptions().add(desc);
				
				type.getSettings().add(setting);
				
				EDataElement data = factory.createEDataElement();
				EFeatureData fdata = factory.createEFeatureData();
				fdata.setRef(type.getRef());
				ESettingData sdata = factory.createESettingData();
				sdata.setText("Sample");
				fdata.getSettings().add(sdata);
				data.getData().add(fdata);
				configuration.getFeatures().add(type);
				configuration.getData().add(data);
				editorId = CONFML_EDITOR_ID;
			} else if (pageTwo.isViewContentType()) {
				EViewElement view = factory.createEViewElement();

				view.setName(initViewPage.getViewName());

				EDescriptionElement descr = factory.createEDescriptionElement();
				descr.setDescription(initViewPage.getViewDescription());
				view.getDescriptions().add(descr);
				EGroup group = factory.createEGroup();
				group.setName("Sample Top Level Group");
				descr = factory.createEDescriptionElement();
				descr.setDescription("Sample Description");
				group.getDescriptions().add(descr);

				EGroup group2 = factory.createEGroup();
				group2.setName("Sample Second Level Group");
				descr = factory.createEDescriptionElement();
				descr.setDescription("Sample Description");
				group2.getDescriptions().add(descr);
				group.getGroups().add(group2);

				// ESettingElement ref = factory.createESettingElement();
				// ref.setRef("someFeature/*");
				// group.getSettings().add(ref);
				view.getGroups().add(group);
				configuration.getViews().add(view);
				editorId = CONFML_VIEW_EDITOR_ID;
			} else if (pageTwo.isInclusionType()) {
				// inclusion content
				editorId = CONFML_INCLUSION_EDITOR_ID;
			} else { // if (pageOne.isEmptyContentType())
				// empty content
				editorId = CONFML_GENERIC_EDITOR_ID;
			}
		} else {
			EConfML2Factory factory = EConfML2Factory.eINSTANCE;
			EConfML2Document document = factory.createEConfML2Document();
			resource.getContents().add(document);

			com.nokia.tools.vct.confml.model.confml2.EConfigurationElement configuration = factory
			.createEConfigurationElement();
			document.setConfiguration(configuration);

			if (pageTwo.isDataContentType()) {
				com.nokia.tools.vct.confml.model.confml2.EDataElement data = factory.createEDataElement();
				configuration.getData().add(data);
				editorId = CONFML_GENERIC_EDITOR_ID;
			} else if (pageTwo.isTypeContentType()) {
				com.nokia.tools.vct.confml.model.confml2.EFeatureElement type = factory.createEFeatureElement();
				type.setRef("SampleFeature");
				type.setName("New Sample Feature");
				
				com.nokia.tools.vct.confml.model.confml2.EDescriptionElement desc = factory.createEDescriptionElement();
				desc.setDescription("A new sample feature");
				type.getDescriptions().add(desc);
				
				//sample setting
				com.nokia.tools.vct.confml.model.confml2.ESettingElement setting = factory.createESettingElement();
				setting.setType("string");
				setting.setName("New Sample Setting");
				setting.setRef("SampleSetting");
				desc = factory.createEDescriptionElement();
				desc.setDescription("A new sample setting");
				setting.getDescriptions().add(desc);
				
				type.getSettings().add(setting);
				
				com.nokia.tools.vct.confml.model.confml2.EDataElement data = factory.createEDataElement();
				com.nokia.tools.vct.confml.model.confml2.EFeatureData fdata = factory.createEFeatureData();
				fdata.setRef(type.getRef());
				com.nokia.tools.vct.confml.model.confml2.ESettingData sdata = factory.createESettingData();
				sdata.setText("Sample");
				sdata.setRef(setting.getRef());
				fdata.getSettings().add(sdata);
				data.getData().add(fdata);
				configuration.getFeatures().add(type);
				configuration.getData().add(data);
				editorId = CONFML_EDITOR_ID;

			} else if (pageTwo.isViewContentType()) {
				com.nokia.tools.vct.confml.model.confml2.EViewElement view = factory.createEViewElement();

				view.setName(initViewPage.getViewName());

				com.nokia.tools.vct.confml.model.confml2.EDescriptionElement descr = factory.createEDescriptionElement();
				descr.setDescription(initViewPage.getViewDescription());
				view.getDescriptions().add(descr);
				com.nokia.tools.vct.confml.model.confml2.EGroup group = factory.createEGroup();
				group.setName("Sample Top Level Group");
				descr = factory.createEDescriptionElement();
				descr.setDescription("Sample Description");
				group.getDescriptions().add(descr);

				com.nokia.tools.vct.confml.model.confml2.EGroup group2 = factory.createEGroup();
				group2.setName("Sample Second Level Group");
				descr = factory.createEDescriptionElement();
				descr.setDescription("Sample Description");
				group2.getDescriptions().add(descr);
				group.getGroups().add(group2);

				// ESettingElement ref = factory.createESettingElement();
				// ref.setRef("someFeature/*");
				// group.getSettings().add(ref);
				view.getGroups().add(group);
				configuration.getViews().add(view);
				editorId = CONFML_VIEW_EDITOR_ID;
			} else if (pageTwo.isInclusionType()) {
				// inclusion content
				editorId = CONFML_INCLUSION_EDITOR_ID;
			} else { // if (pageOne.isEmptyContentType())
				// empty content
				editorId = CONFML_GENERIC_EDITOR_ID;
			}

		}
		try {
			Map<Object, Object> options = new HashMap<Object, Object>();
			options.put(XMLResource.OPTION_ENCODING,
			"UTF-8");
			resource.save(options);
		} catch (IOException e) {
			throw new WorkbenchException("Error", e);
		}

		if (pageTwo.isAddToLayer()) {
			EConfMLLayer layer = ConfMLCore.getLayer(file);
			URI rootUri = null;
			boolean accessible = false;
			if(layer!=null) {
				rootUri = layer.getRootConfml();
				accessible = true;
			} else {
				IProject proj = file.getProject();
				EConfigurationProject project = ConfMLCore.getProjectModel(proj);
				rootUri = project.getRootConfml();
				String name = rootUri.segment(rootUri.segmentCount()-1);
				if(name!=null) {
					IFile rootFile = proj.getFile(name);
					if(rootFile.exists()) {
						accessible = true;
					}					
				}
			}

			if(rootUri!=null && accessible) {				
				EInclude include = EConfMLIncludeFactory.eINSTANCE
				.createEInclude();
				URI rel = uri.deresolve(rootUri);
				include.setHref(rel.toString());
				
				try {
					Resource layerRoot = rfactory.createResource(rootUri);
					layerRoot.load(null);
					EObject root = layerRoot.getContents().get(0);
					if (root instanceof EConfMLDocument) {
						EConfMLDocument document2 = (EConfMLDocument) root;
						document2.getConfiguration().getIncludes().add(include);
					} else if (root instanceof EConfML2Document) {
						EConfML2Document document2 = (EConfML2Document) root;
						document2.getConfiguration().getIncludes().add(include);
					}
					layerRoot.save(null);
				} catch (IOException e) {
					throw new WorkbenchException("Error", e);
				}
			}
		}

		createdElement = file;
		openResource(file, editorId);
	}

	@Override
	public Object getCreatedElement() {
		return createdElement;
	}

}
