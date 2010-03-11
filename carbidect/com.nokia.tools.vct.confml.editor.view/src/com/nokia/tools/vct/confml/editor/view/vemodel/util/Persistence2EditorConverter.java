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

package com.nokia.tools.vct.confml.editor.view.vemodel.util;

import java.io.IOException;

import org.eclipse.core.internal.resources.Folder;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.nokia.tools.vct.confml.editor.view.vemodel.EDescriptionContainer;
import com.nokia.tools.vct.confml.editor.view.vemodel.EFeature;
import com.nokia.tools.vct.confml.editor.view.vemodel.EGroup;
import com.nokia.tools.vct.confml.editor.view.vemodel.EGroupContainer;
import com.nokia.tools.vct.confml.editor.view.vemodel.EIconContainer;
import com.nokia.tools.vct.confml.editor.view.vemodel.ERefOption;
import com.nokia.tools.vct.confml.editor.view.vemodel.ERefProperty;
import com.nokia.tools.vct.confml.editor.view.vemodel.ESetting;
import com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef;
import com.nokia.tools.vct.confml.editor.view.vemodel.EView;
import com.nokia.tools.vct.confml.editor.view.vemodel.EViewEditorFactory;
import com.nokia.tools.vct.confml.editor.view.vemodel.EViewsEditorDocument;
import com.nokia.tools.vct.confml.model.confml1.EConfMLDocument;
import com.nokia.tools.vct.confml.model.confml1.EDataElement;
import com.nokia.tools.vct.confml.model.confml1.EDescriptionElement;
import com.nokia.tools.vct.confml.model.confml1.EFeatureElement;
import com.nokia.tools.vct.confml.model.confml1.EIconElement;
import com.nokia.tools.vct.confml.model.confml1.EMetaElement;
import com.nokia.tools.vct.confml.model.confml1.EOptionElement;
import com.nokia.tools.vct.confml.model.confml1.EPropertyElement;
import com.nokia.tools.vct.confml.model.confml1.ERfsElement;
import com.nokia.tools.vct.confml.model.confml1.ESettingElement;
import com.nokia.tools.vct.confml.model.confml1.EViewElement;
import com.nokia.tools.vct.confml.model.confml1.include.EInclude;
import com.nokia.tools.vct.confml.model.confml1.util.EConfML1ResourceFactoryImpl;
import com.nokia.tools.vct.confml.model.confml2.EConfML2Document;
import com.nokia.tools.vct.confml.model.xsd.EFacet;
import com.nokia.tools.vct.confml.model.xsd.EPattern;

/**
 * Class merges the persistence model with the view editor's one. The class
 * shall be executed within the editor's model update transaction.
 */
class Persistence2EditorConverter implements Runnable {

	private EViewsEditorDocument document;
	private Resource resource;

	public Persistence2EditorConverter(Resource source,
			EViewsEditorDocument target) {
		this.document = target;
		this.resource = source;
	}

	public void run() {
		updateDocumentRoot();
	}

	private void getAllViews()
	{
		URI resourceURI = resource.getURI();
		String path = resourceURI.path();
		String folder =  path.substring(9, path.lastIndexOf("/"));
		URI href = URI.createPlatformResourceURI(folder, false);
		String platformFolder = href.toPlatformString(true);
		Path resPath = new Path(platformFolder);
		IFolder rootFolder = ResourcesPlugin.getWorkspace().getRoot().getFolder(resPath);
		try 
		{
			IResource[] resources = rootFolder.members();
			findViewConfml(resources);
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void findViewConfml(IResource[] resources)
	{
		for (int i = 0 ; i < resources.length ; i++)
		{
			IResource res = resources[i];
			if (res.getType() == IResource.FILE)
			{
				String ext = res.getFileExtension();
				if (!ext.equals("confml"))
					continue;
				String path = res.getFullPath().toString();
				URI resourceURI = resource.getURI();
				String resUri = resourceURI.toPlatformString(true);
				if (resUri.equals(path))
					continue;
				URI href = org.eclipse.emf.common.util.URI.createFileURI(path);
				TreeIterator<Object> iterator = loadConfmlContent(href);
				while (iterator.hasNext()) 
				{
					Object obj = iterator.next();
					if (obj instanceof EConfML2Document)
					{
						EConfML2Document doc = (EConfML2Document)obj;
						for (com.nokia.tools.vct.confml.model.confml2.EViewElement view : doc.getConfiguration().getViews())
						{
							EView eView = createView(view, path.substring(resUri.lastIndexOf("/")+1), path);
							document.getAllViews().add(eView);
						}
					}
					if (obj instanceof EConfMLDocument)
					{
						EConfMLDocument doc = (EConfMLDocument)obj;
						for (EViewElement view : doc.getConfiguration().getViews())
						{
							EView eView = createView(view, path.substring(resUri.lastIndexOf("/")+1), path);
							document.getAllViews().add(eView);
						}
					}
				}
			}
			else if (res.getType() == IResource.FOLDER)
			{
				Folder folder = (Folder)res;
				try 
				{
					findViewConfml(folder.members());
				} 
				catch (CoreException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	private void updateDocumentRoot() {
		for (EFeature feature : document.getFeatures().values()) {
			feature.getRefs().clear();
			for (ESetting setting : feature.getSettings().values()) {
				setting.getRefs().clear();
			}
		}

		document.getViews().clear();
		document.getAllViews().clear();
		
		getAllViews();
		
		TreeIterator<Object> iterator = EcoreUtil.getAllContents(resource,
				false);
		while (iterator.hasNext()) {
			Object obj = iterator.next();
			if (obj instanceof EDataElement
					|| obj instanceof com.nokia.tools.vct.confml.model.confml2.EDataElement) {
				iterator.prune();
			} else if (obj instanceof ERfsElement
					|| obj instanceof com.nokia.tools.vct.confml.model.confml2.ERfsElement) {
				iterator.prune();
			} else if (obj instanceof EFeatureElement
					|| obj instanceof com.nokia.tools.vct.confml.model.confml2.EFeatureElement) {
				iterator.prune();
			} else if (obj instanceof EMetaElement
					|| obj instanceof com.nokia.tools.vct.confml.model.confml2.EMetaElement) {
				iterator.prune();
			} 
			else if (obj instanceof EViewElement) {
				iterator.prune();
				EViewElement viewDef = (EViewElement) obj;
				EView view = createView(viewDef, null, null);
				document.getViews().put(viewDef.getId(), view);
			} else if (obj instanceof com.nokia.tools.vct.confml.model.confml2.EViewElement) {
				iterator.prune();
				com.nokia.tools.vct.confml.model.confml2.EViewElement viewDef = (com.nokia.tools.vct.confml.model.confml2.EViewElement) obj;
				EView view = createView(viewDef, null, null);
				document.getViews().put(viewDef.getId(), view);
			}
		}

	}
	
	private EView createView(com.nokia.tools.vct.confml.model.confml2.EViewElement viewDef, String includedURI, String fileURI)
	{
		EView view = EViewEditorFactory.eINSTANCE.createEView();
		view.setName(viewDef.getName());
		view.setId(viewDef.getId());
		view.setInclusionURI(includedURI);
		view.setFileURI(fileURI);
		readDescription(viewDef, view);
		readIcon(viewDef, view);
		updateGroup(viewDef, view);
		return view;
	}
	private EView createView(EViewElement viewDef, String includedURI, String fileURI)
	{
		EView view = EViewEditorFactory.eINSTANCE.createEView();
		view.setName(viewDef.getName());
		view.setId(viewDef.getId());
		view.setInclusionURI(includedURI);
		readDescription(viewDef, view);
		readIcon(viewDef, view);
		updateGroup(viewDef, view);
		return view;
	}
	
	private void updateGroup(
			com.nokia.tools.vct.confml.model.confml1.EGroupContainer srcDef,
			EGroupContainer dst) {
		
		for (EObject obj : srcDef.eContents())
		{
			if (obj instanceof EInclude)
			{
				updateIncludedViews((EInclude)obj, dst);
			}
			else if (obj instanceof com.nokia.tools.vct.confml.model.confml1.EGroup)
			{
				com.nokia.tools.vct.confml.model.confml1.EGroup groupDef = (com.nokia.tools.vct.confml.model.confml1.EGroup)obj;
				
				EGroup group = EViewEditorFactory.eINSTANCE.createEGroup();

				group.setName(groupDef.getName());

				readDescription(groupDef, group);
				readIcon(groupDef, group);

				// recursive call
				updateGroup(groupDef, group);

				for (ESettingElement refDef : groupDef.getSettings()) {
					ESettingRef ref = EViewEditorFactory.eINSTANCE
							.createESettingRef();

					String key = refDef.getRef();
					int sep = key.indexOf('/');
					if (sep >= 0) {
						ref.setFeatureId(key.substring(0, sep).trim());
						ref.setSettingId(key.substring(sep + 1).trim());
					} else {
						ref.setFeatureId(key.trim());
					}
					ref.setName(refDef.getName());
					readDescription(refDef, ref);

					readConstraints(refDef, ref);

					ConverterUtils.updateIndexReference(document, ref);

					group.getRefs().add(ref);
				}

				dst.getGroupsAndViews().add(group);
			}
		}
	}

	private void readConstraints(ESettingElement refDef, ESettingRef ref) {
		String maxExcl = extract(refDef.getMaxExclusive(), true);
		String maxIncl = extract(refDef.getMaxInclusive(), true);
		String minExcl = extract(refDef.getMinExclusive(), false);
		String minIncl = extract(refDef.getMinInclusive(), false);

		ref.setMaxExclusive(maxExcl);
		ref.setMaxInclusive(maxIncl);
		ref.setMinExclusive(minExcl);
		ref.setMinInclusive(minIncl);

		String length = extract(refDef.getLength(), true);
		String maxLength = extract(refDef.getMaxLength(), true);
		String minLength = extract(refDef.getMinLength(), false);

		ref.setLength(length);
		ref.setMinLength(minLength);
		ref.setMaxLength(maxLength);

		StringBuilder tmp = new StringBuilder();
		for (EPattern pattern : refDef.getPattern()) {
			String value = pattern.getValue();
			if (value != null) {
				if (tmp.length() == 0) {
					tmp.append('\n');
				}
				tmp.append(value);
			}
		}
		ref.setPatterns(tmp.toString());

		for (EOptionElement src : refDef.getOptions()) {
			ERefOption refOption = EViewEditorFactory.eINSTANCE
					.createERefOption();
			refOption.setMap(src.getMap());
			refOption.setName(src.getName());
			refOption.setRelevant(src.getRelevant());
			refOption.setValue(src.getValue());
			ref.getOptions().add(refOption);
		}

		for (EPropertyElement src : refDef.getProperties()) {
			ERefProperty refProperty = EViewEditorFactory.eINSTANCE
					.createERefProperty();
			refProperty.setName(src.getName());
			refProperty.setValue(src.getValue());
			refProperty.setUnit(src.getUnit());
			ref.getProperties().add(refProperty);
		}

	}

	private String extract(EList<? extends EFacet> list, boolean max) {
		EFacet result = null;
		for (EFacet facet : list) {
			if (result == null) {
				result = facet;
			} else {
				// IMPROVEMENT: how to compare values of the facet when the type
				// is not known at this point of time?
			}
		}
		if (result != null) {
			return result.getValue() == null ? "" : result.getValue();
		} else {
			return "";
		}
	}

	private void readConstraints(
			com.nokia.tools.vct.confml.model.confml2.ESettingElement refDef,
			ESettingRef ref) {
		String maxExcl = extract(refDef.getMaxExclusive(), true);
		String maxIncl = extract(refDef.getMaxInclusive(), true);
		String minExcl = extract(refDef.getMinExclusive(), false);
		String minIncl = extract(refDef.getMinInclusive(), false);

		ref.setMaxExclusive(maxExcl);
		ref.setMaxInclusive(maxIncl);
		ref.setMinExclusive(minExcl);
		ref.setMinInclusive(minIncl);

		String length = extract(refDef.getLength(), true);
		String maxLength = extract(refDef.getMaxLength(), true);
		String minLength = extract(refDef.getMinLength(), false);

		ref.setLength(length);
		ref.setMinLength(minLength);
		ref.setMaxLength(maxLength);

		StringBuilder tmp = new StringBuilder();
		for (EPattern pattern : refDef.getPattern()) {
			String value = pattern.getValue();
			if (value != null) {
				if (tmp.length() == 0) {
					tmp.append('\n');
				}
				tmp.append(value);
			}
		}
		ref.setPatterns(tmp.toString());

		for (com.nokia.tools.vct.confml.model.confml2.EOptionElement src : refDef
				.getOptions()) {
			ERefOption refOption = EViewEditorFactory.eINSTANCE
					.createERefOption();
			refOption.setMap(src.getMap());
			refOption.setName(src.getName());
			refOption.setRelevant(src.getRelevant());
			refOption.setValue(src.getValue());
			ref.getOptions().add(refOption);
		}

		for (com.nokia.tools.vct.confml.model.confml2.EPropertyElement src : refDef
				.getProperties()) {
			ERefProperty refProperty = EViewEditorFactory.eINSTANCE
					.createERefProperty();
			refProperty.setName(src.getName());
			refProperty.setValue(src.getValue());
			refProperty.setUnit(src.getUnit());
			ref.getProperties().add(refProperty);
		}
	}

	private TreeIterator<Object> loadConfmlContent(URI href)
	{
		EConfML1ResourceFactoryImpl factory = new EConfML1ResourceFactoryImpl();
		Resource res = factory.createResource(href);
		try 
		{
			res.load(null);
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		TreeIterator<Object> iterator = EcoreUtil.getAllContents(res, false);
		return iterator;
	}
	
	private void updateIncludedViews(EInclude include, EGroupContainer rootView)
	{
		URI base = include.eResource().getURI();
		URI href = URI.createURI(include.getHref());
		try
		{
			href = href.resolve(base);
		}
		catch (IllegalArgumentException iae)
		{
			String baseString = base.toString();
			baseString = baseString.substring(0, baseString.lastIndexOf("/"));
			href = URI.createURI(baseString+"/"+href.toString());
		}
		
		TreeIterator<Object> iterator = loadConfmlContent(href);
		while (iterator.hasNext()) 
		{
			Object obj = iterator.next();
			if (obj instanceof EConfML2Document)
			{
				EConfML2Document doc = (EConfML2Document)obj;
				for (com.nokia.tools.vct.confml.model.confml2.EViewElement includedView : doc.getConfiguration().getViews())
				{
					EView view = createView(includedView, include.getHref(), href.toPlatformString(true));
					rootView.getGroupsAndViews().add(view);
					//updateGroup(includedView, rootView);
				}
			}
			if (obj instanceof EConfMLDocument)
			{
				EConfMLDocument doc = (EConfMLDocument)obj;
				for (EViewElement includedView : doc.getConfiguration().getViews())
				{
					EView view = createView(includedView, include.getHref(), href.toPlatformString(true));
					rootView.getGroupsAndViews().add(view);
					//updateGroup(includedView, rootView);
				}
			}
		}
	}
	
	private void updateGroup(com.nokia.tools.vct.confml.model.confml2.EGroupContainer srcDef,EGroupContainer dst) {
		
		for (EObject obj : srcDef.eContents())
		{
			if (obj instanceof EInclude)
			{
				updateIncludedViews((EInclude)obj, dst);
			}
			else if (obj instanceof com.nokia.tools.vct.confml.model.confml2.EGroup)
			{
				com.nokia.tools.vct.confml.model.confml2.EGroup groupDef = (com.nokia.tools.vct.confml.model.confml2.EGroup)obj;
				
				EGroup group = EViewEditorFactory.eINSTANCE.createEGroup();

				group.setName(groupDef.getName());

				readDescription(groupDef, group);
				readIcon(groupDef, group);

				// recursive call
				updateGroup(groupDef, group);

				for (com.nokia.tools.vct.confml.model.confml2.ESettingElement refDef : groupDef.getSettings()) {
					ESettingRef ref = EViewEditorFactory.eINSTANCE
							.createESettingRef();

					String key = refDef.getRef();
					int sep = key.indexOf('/');
					if (sep >= 0) {
						ref.setFeatureId(key.substring(0, sep).trim());
						ref.setSettingId(key.substring(sep + 1).trim());
					} else {
						ref.setFeatureId(key.trim());
					}
					ref.setName(refDef.getName());
					readDescription(refDef, ref);

					readConstraints(refDef, ref);

					ConverterUtils.updateIndexReference(document, ref);

					group.getRefs().add(ref);
				}

				dst.getGroupsAndViews().add(group);
			}
		}
	}

	private void readIcon(
			com.nokia.tools.vct.confml.model.confml1.EIconContainer source,
			EIconContainer target) {
		for (EIconElement icon : source.getIcons()) {
			if (icon.getHref() != null) {
				target.setIconUriTitle(icon.getTitle());
				target.setIconUri(icon.getHref());
			}
		}
	}

	private void readIcon(
			com.nokia.tools.vct.confml.model.confml2.EIconContainer source,
			EIconContainer target) {
		for (com.nokia.tools.vct.confml.model.confml2.EIconElement icon : source
				.getIcons()) {
			if (icon.getHref() != null) {
				target.setIconUriTitle(icon.getTitle());
				target.setIconUri(icon.getHref());
			}
		}
	}

	private void readDescription(
			com.nokia.tools.vct.confml.model.confml1.EDescriptionContainer source,
			EDescriptionContainer target) {
		for (EDescriptionElement descr : source.getDescriptions()) {
			if (descr.getDescription() != null) {
				target.setDescriptionText(descr.getDescription());
				break;
			}
			if (descr.getHref() != null) {
				target.setDescriptionUriTitle(descr.getTitle());
				target.setDescriptionUri(descr.getHref());
				break;
			}
		}
	}

	private void readDescription(
			com.nokia.tools.vct.confml.model.confml2.EDescriptionContainer source,
			EDescriptionContainer target) {
		for (com.nokia.tools.vct.confml.model.confml2.EDescriptionElement descr : source
				.getDescriptions()) {
			if (descr.getDescription() != null) {
				target.setDescriptionText(descr.getDescription());
				break;
			}
			if (descr.getHref() != null) {
				target.setDescriptionUriTitle(descr.getTitle());
				target.setDescriptionUri(descr.getHref());
				break;
			}
		}
	}
}
