/*
 * Copyright (c) 2009 Nokia Corporation and/or its subsidiary(-ies). 
 * All rights reserved.
 * This component and the accompanying materials are made available
 * under the terms of the License "Symbian Foundation License v1.0"
 * which accompanies this distribution, and is available
 * at the URL "http://www.symbianfoundation.org/legal/sfl-v10.html".
 * 
 * Initial Contributors:
 * Nokia Corporation - Initial contribution
 * 
 * Contributors:
 * 
 * Description: This file is part of com.nokia.tools.variant.confml.core component.
 */

package com.nokia.tools.variant.confml.internal.core.application;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.nokia.tools.variant.common.core.utils.ArrayUtils;
import com.nokia.tools.variant.confml.core.model.application.EAppDataContainer;
import com.nokia.tools.variant.confml.core.model.application.EAppFeature;
import com.nokia.tools.variant.confml.core.model.application.EAppGroup;
import com.nokia.tools.variant.confml.core.model.application.EAppGroupContainer;
import com.nokia.tools.variant.confml.core.model.application.EAppIncludeElement;
import com.nokia.tools.variant.confml.core.model.application.EAppOptionContainer;
import com.nokia.tools.variant.confml.core.model.application.EAppResourceData;
import com.nokia.tools.variant.confml.core.model.application.EAppResourceType;
import com.nokia.tools.variant.confml.core.model.application.EAppRfsInfo;
import com.nokia.tools.variant.confml.core.model.application.EAppSequenceData;
import com.nokia.tools.variant.confml.core.model.application.EAppSequenceDataItem;
import com.nokia.tools.variant.confml.core.model.application.EAppSequenceType;
import com.nokia.tools.variant.confml.core.model.application.EAppSetting;
import com.nokia.tools.variant.confml.core.model.application.EAppSettingData;
import com.nokia.tools.variant.confml.core.model.application.EAppSettingOption;
import com.nokia.tools.variant.confml.core.model.application.EAppSettingRef;
import com.nokia.tools.variant.confml.core.model.application.EAppSettingType;
import com.nokia.tools.variant.confml.core.model.application.EAppSimpleData;
import com.nokia.tools.variant.confml.core.model.application.EAppSimpleType;
import com.nokia.tools.variant.confml.core.model.application.EAppTypeContainer;
import com.nokia.tools.variant.confml.core.model.application.EAppView;
import com.nokia.tools.variant.confml.core.model.application.EApplicationFactory;
import com.nokia.tools.variant.confml.core.model.application.EConfMLLayer;
import com.nokia.tools.variant.confml.core.model.application.EConfigurationProject;
import com.nokia.tools.variant.confml.core.model.application.EStorageClass;
import com.nokia.tools.variant.confml.internal.core.project.ContributorUtils;
import com.nokia.tools.vct.confml.model.confml1.EConfMLDocument;
import com.nokia.tools.vct.confml.model.confml1.EConfigurationElement;
import com.nokia.tools.vct.confml.model.confml1.EFeatureElement;
import com.nokia.tools.vct.confml.model.confml1.ESettingData;
import com.nokia.tools.vct.confml.model.confml1.ESettingElement;
import com.nokia.tools.vct.confml.model.confml1.ESettingRfs;
import com.nokia.tools.vct.confml.model.confml1.EViewElement;
import com.nokia.tools.vct.confml.model.confml1.include.EInclude;
import com.nokia.tools.vct.confml.model.confml2.EConfML2Document;
import com.nokia.tools.vct.confml.model.confml2.EFeatureData;
import com.nokia.tools.vct.confml.model.confml2.EFeatureRfs;

public class AppModelFactory {

	public AppModelFactory() {
	}

	public EConfigurationProject populateProject(ResourceSet resourceSet,
			URI projectRootURI, Collection<URI> resources) {
		try {
			return populateProject(new NullProgressMonitor(), resourceSet,
					projectRootURI, resources);
		} catch (InterruptedException e) {
			throw new OperationCanceledException();
		}
	}

	public EConfigurationProject populateProject(IProgressMonitor monitor,
			ResourceSet resourceSet, URI projectRootURI,
			Collection<URI> resources) throws InterruptedException {
		monitor.beginTask("Creating project", 100);
		if (monitor.isCanceled()) {
			throw new InterruptedException();
		}

		EConfigurationProject configurationProject = EApplicationFactory.eINSTANCE
				.createEConfigurationProject();
		configurationProject.setStorage(EStorageClass.PROJECT);
		configurationProject.setRootConfml(projectRootURI);
		Resource resource = null;
		// map for collecting of an information about view name 2 Resource in
		// which is that view located
		Map<String, Resource> viewName2ResourceMapForAllLayers = new HashMap<String, Resource>();

		try {
			monitor.subTask("Parsing root file");
			resource = resourceSet.getResource(projectRootURI, true);
			if (resource != null) {

				EObject root = resource.getContents().get(0);
				EList<EInclude> includes = null;
				if (root instanceof EConfMLDocument) {
					EConfMLDocument document = (EConfMLDocument) root;
					EConfigurationElement configuration = document
							.getConfiguration();
					configurationProject.setName(configuration.getName());
					configurationProject.setConfVersion(configuration
							.getVersion());
					ContributorUtils.adaptMetadata(configuration,
							configurationProject);
					includes = configuration.getIncludes();
				} else if (root instanceof EConfML2Document) {
					EConfML2Document document = (EConfML2Document) root;
					com.nokia.tools.vct.confml.model.confml2.EConfigurationElement configuration = document
							.getConfiguration();
					configurationProject.setName(configuration.getName());
					configurationProject.setConfVersion(configuration
							.getVersion());
					ContributorUtils.adaptMetadata(configuration,
							configurationProject);
					includes = configuration.getIncludes();
				}

				monitor.worked(5);

				if (monitor.isCanceled()) {
					throw new InterruptedException();
				}

				SubProgressMonitor monitor2 = new SubProgressMonitor(monitor,
						95);
				monitor2.beginTask("Generating layer", includes.size());

				EConfMLLayer lastLayer = null;
				for (EInclude include : includes) {
					monitor.subTask("Processing " + include.getHref());
					try {
						URI includeURI = URI.createURI(include.getHref());
						includeURI = includeURI.resolve(projectRootURI);
						URI layerURI = discoverLayerUri(includeURI, resources);
						EConfMLLayer layer = populateConfMLLayer(resourceSet,
								layerURI, includeURI, resources, lastLayer,
								viewName2ResourceMapForAllLayers);
						configurationProject.getLayers().add(layer);
						lastLayer = layer;
					} catch (Exception ex) {
						ex.printStackTrace();
					}
					monitor2.worked(1);
					if (monitor.isCanceled()) {
						throw new InterruptedException();
					}
				}
				monitor2.done();

			}
		} catch (Exception ex) {
			// ex.printStackTrace();
		}
		monitor.done();
		return configurationProject;
	}

	protected URI discoverLayerUri(URI includeURI, Collection<URI> resources) {
		OUTER: for (URI ptr : resources) {
			if (ptr.segmentCount() > includeURI.segmentCount()) {
				for (int i = 0; i < includeURI.segmentCount() - 1; i++) {
					if (!ptr.segment(i).equals(includeURI.segment(i))) {
						continue OUTER;
					}
				}
				if ("confml".equals(ptr.segment(includeURI.segmentCount() - 1))) {
					return includeURI.trimSegments(1).appendSegment("");
				}
			}
		}
		int count = includeURI.segmentCount();
		for (int i = count - 1; i > 0; i--) {
			if ("confml".equals(includeURI.segment(i))) {
				return includeURI.trimSegments(count - i).appendSegment("");
			}
		}
		return includeURI.trimSegments(1).appendSegment("");
	}

	public EConfMLLayer populateConfMLLayer(ResourceSet resourceSet,
			URI layerURI, URI rootConfmlURI, Collection<URI> resources,
			EConfMLLayer parent,
			Map<String, Resource> viewName2ResourceMapForAllLayers) {

		Resource layerResource = new ResourceImpl(layerURI);
		EConfMLLayer layer = EApplicationFactory.eINSTANCE.createEConfMLLayer();
		layer.setRootConfml(rootConfmlURI);
		layerResource.getContents().add(layer);
		resourceSet.getResources().add(layerResource);

		layer.setLayerURI(layerURI);
		layer.setParent(parent);
		for (URI uri : resources) {
			if (isBaseURI(layerURI, uri)) {
				layer.getLayerFiles().add(uri);
			}
		}

		if (parent != null) {
			for (Map.Entry<URI, URI> entry : parent.getDocumentMap()) {
				layer.getDocumentMap().put(entry.getKey(), entry.getValue());
			}
			for (Map.Entry<URI, URI> entry : parent.getResourceMap()) {
				layer.getResourceMap().put(entry.getKey(), entry.getValue());
			}
			for (Map.Entry<URI, URI> entry : parent.getImplMap()) {
				layer.getImplMap().put(entry.getKey(), entry.getValue());
			}
			Collection<Map.Entry<String, EAppView>> viewCopy = EcoreUtil
					.copyAll(parent.getViews());
			layer.getViews().addAll(viewCopy);
			Collection<Map.Entry<String, EAppFeature>> featureCopy = EcoreUtil
					.copyAll(parent.getFeatures());
			layer.getFeatures().addAll(featureCopy);
		}

		URI contentURI = ConfMLConstants.URI_CONTENT.resolve(layerURI);
		URI docURI = ConfMLConstants.URI_DOC.resolve(layerURI);
		URI implURI = ConfMLConstants.URI_IMPLML.resolve(layerURI);
		// URI confmlURI = URI_CONFML.resolve(layerURI);

		for (URI uri : resources) {
			if (isBaseURI(contentURI, uri)) {
				URI relative = relativize(contentURI, uri);
				layer.getResourceMap().put(relative, uri);
			} else if (isBaseURI(docURI, uri)) {
				URI relative = relativize(docURI, uri);
				layer.getDocumentMap().put(relative, uri);
			} else if (isBaseURI(implURI, uri)) {
				URI relative = relativize(implURI, uri);
				layer.getImplMap().put(relative, uri);
			} else {
				// other content - ignore
			}
		}

		Resource resource;
		try {
			resource = resourceSet.getResource(rootConfmlURI, true);
		} catch (Exception ex) {
			return layer;
		}

		TreeIterator<Object> it = EcoreUtil.getAllContents(resource, false);
		while (it.hasNext()) {
			Object o = it.next();
			if (o instanceof EConfigurationElement) {
				EConfigurationElement ce = (EConfigurationElement) o;
				layer.setName(ce.getName());
				ContributorUtils.adaptMetadata(ce, layer);
				break;
			}
			if (o instanceof com.nokia.tools.vct.confml.model.confml2.EConfigurationElement) {
				com.nokia.tools.vct.confml.model.confml2.EConfigurationElement ce = (com.nokia.tools.vct.confml.model.confml2.EConfigurationElement) o;
				layer.setName(ce.getName());
				ContributorUtils.adaptMetadata(ce, layer);
				break;
			}
		}
		Map<String, EObject> views = new LinkedHashMap<String, EObject>(); // String->
		// EViewElement
		Map<String, List<EObject>> types = new HashMap<String, List<EObject>>(); // String
		// -
		// >
		// EFeatureElement
		Map<String, Map<String, List<EObject>>> data = new HashMap<String, Map<String, List<EObject>>>(); // ESettingData
		Map<String, Map<String, EObject>> rfs = new HashMap<String, Map<String, EObject>>(); // ESettingRfs
		Set<URI> visitedLayers = new HashSet<URI>();
		List<EAppIncludeElement> includeChain = new ArrayList<EAppIncludeElement>();

		populateMaps(resourceSet, rootConfmlURI, visitedLayers, views, types,
				data, rfs, includeChain);

		layer.getIncludes().addAll(includeChain);

		populateResourceData(layer, views, types, data, rfs);

		return layer;
	}

	private void populateResourceData(EConfMLLayer layer,
			Map<String, EObject> views, Map<String, List<EObject>> types,
			Map<String, Map<String, List<EObject>>> data,
			Map<String, Map<String, EObject>> rfs) {

		EApplicationFactory appFactory = EApplicationFactory.eINSTANCE;

		for (Map.Entry<String, List<EObject>> entry : types.entrySet()) {
			String featureId = entry.getKey();

			EAppFeature feature = layer.getFeatures().get(featureId);

			if (feature == null) {
				// create and populate feature properties only if it is not
				// redefined.
				feature = appFactory.createEAppFeature();
				layer.getFeatures().put(featureId, feature);
				EObject ptr = entry.getValue().get(0);
				if (ptr instanceof EFeatureElement) {
					EFeatureElement first = (EFeatureElement) ptr;
					feature.setName(first.getName());
					ConfML1Helper.adaptDescription(first, feature);
					ConfML1Helper.adaptIcon(first, feature);
					feature.setRelevant(ConfML1Helper.buildAppExpression(first
							.getRelevant()));
				} else if (ptr instanceof com.nokia.tools.vct.confml.model.confml2.EFeatureElement) {
					com.nokia.tools.vct.confml.model.confml2.EFeatureElement first = (com.nokia.tools.vct.confml.model.confml2.EFeatureElement) ptr;
					feature.setName(first.getName());
					ConfML2Helper.adaptDescription(first, feature);
					ConfML2Helper.adaptIcon(first, feature);
					feature.setRelevant(ConfML2Helper.buildAppExpression(first
							.getRelevant()));
				}
			}

			// feature.setIconDescriptor(buildIconDescriptor(first));

			for (EObject featureTypeObject : entry.getValue()) {
				if (featureTypeObject instanceof EFeatureElement) {
					for (ESettingElement settingType : ((EFeatureElement) featureTypeObject)
							.getSettings()) {
						String settingId = settingType.getRef();
						EAppSetting setting = feature.getSettings().get(
								settingId);
						if (setting == null) {
							setting = appFactory.createEAppSetting();
							feature.getSettings().put(settingId, setting);
							try {
								ConfML1Helper.populateAppSetting(setting,
										settingType);
							} catch (Exception ex) {
								ex.printStackTrace();
							}
						}
					}
				} else if (featureTypeObject instanceof com.nokia.tools.vct.confml.model.confml2.EFeatureElement) {
					for (com.nokia.tools.vct.confml.model.confml2.ESettingElement settingType : ((com.nokia.tools.vct.confml.model.confml2.EFeatureElement) featureTypeObject)
							.getSettings()) {
						String settingId = settingType.getRef();
						EAppSetting setting = feature.getSettings().get(
								settingId);
						if (setting == null) {
							setting = appFactory.createEAppSetting();
							feature.getSettings().put(settingId, setting);
							try {
								ConfML2Helper.populateAppSetting(setting,
										settingType);
							} catch (Exception ex) {
								ex.printStackTrace();
							}
						}
					}

				}

			}
		}

		for (Map.Entry<String, Map<String, List<EObject>>> entry : data
				.entrySet()) {
			String featureId = entry.getKey();
			EAppFeature feature = layer.getFeatures().get(featureId);
			if (feature == null) {
				continue;
			}
			for (Map.Entry<String, List<EObject>> entry2 : entry.getValue()
					.entrySet()) {
				String settingId = entry2.getKey();
				EAppSetting appSetting = feature.getSettings().get(settingId);
				if (appSetting != null) {
					List<EObject> settingData = entry2.getValue();
					EAppSettingData appData = createSettingData(appSetting
							.getTypeInfo(), appSetting.getValueInfo(),
							settingData);
					appSetting.setValueInfo(appData);
				}
			}
		}
		for (Map.Entry<String, Map<String, EObject>> entry : rfs.entrySet()) {
			String featureId = entry.getKey();
			EAppFeature feature = layer.getFeatures().get(featureId);
			if (feature == null) {
				continue;
			}
			for (Map.Entry<String, EObject> entry2 : entry.getValue()
					.entrySet()) {
				String settingId = entry2.getKey();
				EAppSetting appSetting = feature.getSettings().get(settingId);
				if (appSetting != null) {
					populateSettingRfs(appSetting, appSetting.getRef(), entry
							.getValue());
				}
			}
		}
		Map<String, EObject> noRFS = Collections.emptyMap();
		List<EObject> noData = Collections.emptyList();

		for (Map.Entry<String, EAppFeature> entry : layer.getFeatures()) {
			for (Map.Entry<String, EAppSetting> entry2 : entry.getValue()
					.getSettings()) {
				EAppSetting appSetting = entry2.getValue();
				if (appSetting.getRfsInfo() == null) {
					populateSettingRfs(appSetting, appSetting.getRef(), noRFS);
				}
				if (appSetting.getValueInfo() == null) {
					EAppSettingData appData = createSettingData(appSetting
							.getTypeInfo(), null, noData);
					appSetting.setValueInfo(appData);
				}
			}
		}

		Set<String> updatedViews = views.keySet();
		for (Map.Entry<String, EAppView> appViewEntry : layer.getViews()) {
			if (!updatedViews.contains(appViewEntry.getKey())) {
				fixUpViewTargets(layer, appViewEntry.getValue());
			}
		}

		for (Map.Entry<String, EObject> viewEntry : views.entrySet()) {
			String viewName = viewEntry.getKey();
			EObject viewObject = viewEntry.getValue();
			layer.getViews().removeKey(viewName);
			EAppView appView = appFactory.createEAppView();
			appView.setName(viewName);
			layer.getViews().put(viewName, appView);
			URI uri = EcoreUtil.getURI(viewObject);
			appView.getUri().add(uri);
			if (viewObject instanceof EViewElement) {
				ConfML1Helper
						.populateAppGroups(appFactory, layer.getFeatures(),
								appView, (EViewElement) viewObject);
			} else if (viewObject instanceof com.nokia.tools.vct.confml.model.confml2.EViewElement) {
				ConfML2Helper
						.populateAppGroups(
								appFactory,
								layer.getFeatures(),
								appView,
								(com.nokia.tools.vct.confml.model.confml2.EViewElement) viewObject);
			}
		}
	}

	private void fixUpViewTargets(EConfMLLayer layer,
			EAppGroupContainer container) {
		for (EAppGroup group : container.getGroups()) {
			fixUpViewTargets(layer, group);
		}
		if (container instanceof EAppGroup) {
			for (EAppSettingRef ref : ((EAppGroup) container).getSettings()) {
				EAppSetting old = ref.getResolved();
				if (old != null) {
					String settingRef = old.getRef();
					String featureRef = ((EAppFeature) old.eContainer()
							.eContainer()).getRef();

					EAppFeature newFeature = layer.getFeatures()
							.get(featureRef);
					EAppSetting newSetting = newFeature.getSettings().get(
							settingRef);

					ref.setResolved(newSetting);
				}
			}
		}
	}

	private EAppSettingData createSettingData(EAppSettingType settingType,
			EAppSettingData oldData, List<EObject> settingData) {
		if (settingData == null) {
			settingData = Collections.emptyList();
		}

		if (settingType instanceof EAppSimpleType) {

			EAppSimpleData data = EApplicationFactory.eINSTANCE
					.createEAppSimpleData();
			data.setTypeInfo(settingType);
			if (settingData.size() > 0) {
				EObject obj = ArrayUtils.getLast(settingData);
				if (obj instanceof ESettingData) {
					ESettingData first = (ESettingData) obj;
					if (first.getSettings().isEmpty()) {
						String text = first.getText();

						if (isConfML1Ref(settingType, text)) {
							data.setMap(text);
							data.setValue(null);
						} else {
							data.setMap(null);
							data.setValue(text);
						}
					}
				} else if (obj instanceof com.nokia.tools.vct.confml.model.confml2.ESettingData) {
					com.nokia.tools.vct.confml.model.confml2.ESettingData first = (com.nokia.tools.vct.confml.model.confml2.ESettingData) obj;
					if (first.getSettings().isEmpty()) {
						if (first.getMap() != null) {
							data.setMap(first.getMap());
							data.setValue(null);
							data.setValue(first.getText());
						} else {
							data.setMap(null);
							data.setValue(first.getText());
						}
					}

				}
			}

			for (EObject source : settingData) {
				URI uri = EcoreUtil.getURI(source);
				data.getUri().add(uri);
			}

			return data;
		} else if (settingType instanceof EAppResourceType) {
			EAppResourceType type = (EAppResourceType) settingType;
			EAppResourceData data = EApplicationFactory.eINSTANCE
					.createEAppResourceData();
			data.setTypeInfo(settingType);

			populateCompositeData(type, data, settingData);

			// update the shortcuts
			data.setLocalPath(data.getSubSettings().get("localPath"));
			data.setTargetPath(data.getSubSettings().get("targetPath"));

			for (EObject source : settingData) {
				URI uri = EcoreUtil.getURI(source);
				data.getUri().add(uri);
			}

			return data;
		} else if (settingType instanceof EAppSequenceType) {
			EAppSequenceType type = (EAppSequenceType) settingType;
			EAppSequenceData data = (EAppSequenceData) oldData;

			if (data == null) {
				data = EApplicationFactory.eINSTANCE.createEAppSequenceData();
			}

			List<EObject> templateData = new ArrayList<EObject>(1);
			for (EObject obj : settingData) {
				if (obj instanceof ESettingData) {
					ESettingData srcData = (ESettingData) obj;
					if ("true".equalsIgnoreCase(srcData.getTemplate())) {
						templateData.add(srcData);
						break;
					}
				}
				if (obj instanceof com.nokia.tools.vct.confml.model.confml2.ESettingData) {
					com.nokia.tools.vct.confml.model.confml2.ESettingData srcData = (com.nokia.tools.vct.confml.model.confml2.ESettingData) obj;
					if ("true".equalsIgnoreCase(srcData.getTemplate())) {
						templateData.add(srcData);
						break;
					}
				}
			}
			if (data.getTemplate() == null || !templateData.isEmpty()) {
				EAppSequenceDataItem templateItem = EApplicationFactory.eINSTANCE
						.createEAppSequenceDataItem();
				for (EObject obj : templateData) {
					URI uri = EcoreUtil.getURI(obj);
					templateItem.getUri().add(uri);
				}
				populateCompositeData(type, templateItem, templateData);
				data.setTemplate(templateItem);
			}

			List<List<EObject>> scopedDataDefs = new ArrayList<List<EObject>>();

			EObject scope = null;
			String extensionPolicy = "append";
			List<EObject> scopeData = null;

			boolean first = true;
			List<EAppSequenceDataItem> prepend = new ArrayList<EAppSequenceDataItem>();
			List<EAppSequenceDataItem> append = new ArrayList<EAppSequenceDataItem>();

			outer: for (EObject next : settingData) {
				String templateString;
				String extensionPolicyString;
				if (next instanceof ESettingData) {
					ESettingData tmp = (ESettingData) next;
					templateString = tmp.getTemplate();
					extensionPolicyString = tmp.getExtensionPolicy();
				} else {
					com.nokia.tools.vct.confml.model.confml2.ESettingData tmp = (com.nokia.tools.vct.confml.model.confml2.ESettingData) next;
					templateString = tmp.getTemplate();
					extensionPolicyString = tmp.getExtensionPolicy();
				}

				if ("true".equalsIgnoreCase(templateString)) {
					continue;
				}
				if (first) {
					first = false;
					if ("append".equalsIgnoreCase(extensionPolicyString)) {
						prepend.addAll(data.getItems());
					} else if ("prefix".equalsIgnoreCase(extensionPolicyString)) {
						append.addAll(data.getItems());
					}
					data.getItems().clear();
				}

				if (scope != next.eContainer()) {

					if ("append".equalsIgnoreCase(extensionPolicy)) {
						// ok - we continue
					} else if ("prefix".equalsIgnoreCase(extensionPolicy)) {
						// ok - we continue
					} else if ("replace".equalsIgnoreCase(extensionPolicy)) {
						// we are done - last owner scope replaces the content.
						break outer;
					}

					scope = next.eContainer();
					scopeData = new ArrayList<EObject>();
					scopedDataDefs.add(scopeData);
					extensionPolicy = extensionPolicyString;
				}
				scopeData.add(next);
			}

			// normalize
			List<EObject> itemsData = new ArrayList<EObject>();
			normalizeSequenceData(itemsData, scopedDataDefs, 0);

			for (EObject itemDataObject : itemsData) {
				EAppSequenceDataItem item = EApplicationFactory.eINSTANCE
						.createEAppSequenceDataItem();
				URI uri = EcoreUtil.getURI(itemDataObject);
				item.getUri().add(uri);

				for (Map.Entry<String, EAppSettingType> subTypeEntry : type
						.getTypeMap()) {
					String subSettingId = subTypeEntry.getKey();
					EObject fieldData = null;
					if (itemDataObject instanceof ESettingData) {
						ESettingData itemData = (ESettingData) itemDataObject;
						if (!itemData.getSettings().isEmpty()) {
							for (ESettingData candidate : itemData
									.getSettings()) {
								if (candidate.getRef().equals(subSettingId)) {
									fieldData = candidate;
									break;
								}
							}
						}
					} else if (itemDataObject instanceof com.nokia.tools.vct.confml.model.confml2.ESettingData) {
						com.nokia.tools.vct.confml.model.confml2.ESettingData itemData = (com.nokia.tools.vct.confml.model.confml2.ESettingData) itemDataObject;
						if (!itemData.getSettings().isEmpty()) {
							for (com.nokia.tools.vct.confml.model.confml2.ESettingData candidate : itemData
									.getSettings()) {
								if (candidate.getRef().equals(subSettingId)) {
									fieldData = candidate;
									break;
								}
							}
						}
					} else {
						fieldData = null;
					}
					EAppSettingData subData = createNestedSettingData(
							subTypeEntry.getValue(), fieldData);

					item.getSubSettings().put(subTypeEntry.getKey(), subData);
				}

				data.getItems().add(item);
			}

			data.getItems().addAll(append);
			data.getItems().addAll(0, prepend);

			for (EObject source : settingData) {
				URI uri = EcoreUtil.getURI(source);
				data.getUri().add(uri);
			}

			return data;
		} else {
			throw new IllegalArgumentException();
		}
	}

	private boolean isConfML1Ref(EAppSettingType settingType, String text) {
		if (text == null || text.trim().length() == 0) {
			return false;
		}

		if (settingType instanceof EAppOptionContainer) {
			EAppOptionContainer simpleType = (EAppOptionContainer) settingType;
			for (EAppSettingOption option : simpleType.getOptions()) {
				if (option.getRefValue() == null) {
					continue;
				}
			}
		}

		return false;
	}

	/**
	 * Method for overriding sequence extension policy override.
	 * 
	 * @param normalized
	 *            Resulting list
	 * @param scopedDataDefs
	 *            List of frames containing ESettingData from ConfML1 or ConfML2
	 * @param index
	 *            Currently processed frame index
	 */
	protected void normalizeSequenceData(List<EObject> normalized,
			List<List<EObject>> scopedDataDefs, int index) {
		if (index >= scopedDataDefs.size()) {
			return;
		}
		List<EObject> layerData = scopedDataDefs.get(index);
		EObject first = ArrayUtils.getFirst(layerData);

		String policy = "";
		if (first instanceof ESettingData) {
			policy = ((ESettingData) first).getExtensionPolicy();
		} else if (first instanceof com.nokia.tools.vct.confml.model.confml2.ESettingData) {
			policy = ((com.nokia.tools.vct.confml.model.confml2.ESettingData) first)
					.getExtensionPolicy();
		}

		if ("append".equalsIgnoreCase(policy)) {
			normalizeSequenceData(normalized, scopedDataDefs, index + 1);
			normalized.addAll(layerData);
		} else if ("prefix".equalsIgnoreCase(policy)) {
			normalized.addAll(layerData);
			normalizeSequenceData(normalized, scopedDataDefs, index + 1);
		} else if ("replace".equalsIgnoreCase(policy)) {
			normalized.addAll(layerData);
		} else if (policy == null) {// default policy is replace according to
									// spec
			normalized.addAll(layerData);
		}
	}

	private void populateCompositeData(EAppTypeContainer type,
			EAppDataContainer data, List<EObject> settingData) {
		// find the fields one by one
		for (Map.Entry<String, EAppSettingType> subTypeEntry : type
				.getTypeMap()) {
			EObject fieldData = null;
			for (EObject itemDataObject : settingData) {
				if (itemDataObject instanceof ESettingData) {
					ESettingData itemData = (ESettingData) itemDataObject;
					if (!itemData.getSettings().isEmpty()) {
						for (ESettingData subCompositeData : itemData
								.getSettings()) {
							if (subCompositeData.getRef().equals(
									subTypeEntry.getKey())) {
								fieldData = subCompositeData;
								break;
							}
						}
					} else {
						if (itemData.getRef().equals(subTypeEntry.getKey())) {
							fieldData = itemData;
							break;
						}
					}
				} else if (itemDataObject instanceof com.nokia.tools.vct.confml.model.confml2.ESettingData) {
					com.nokia.tools.vct.confml.model.confml2.ESettingData itemData = (com.nokia.tools.vct.confml.model.confml2.ESettingData) itemDataObject;
					if (!itemData.getSettings().isEmpty()) {
						for (com.nokia.tools.vct.confml.model.confml2.ESettingData subCompositeData : itemData
								.getSettings()) {
							if (subCompositeData.getRef().equals(
									subTypeEntry.getKey())) {
								fieldData = subCompositeData;
								break;
							}
						}
					} else {
						if (itemData.getRef().equals(subTypeEntry.getKey())) {
							fieldData = itemData;
							break;
						}
					}

				}

			}
			EAppSettingData subData = createNestedSettingData(subTypeEntry
					.getValue(), fieldData);
			data.getSubSettings().put(subTypeEntry.getKey(), subData);
		}
	}

	private EAppSettingData createNestedSettingData(EAppSettingType type,
			EObject fieldData) {
		EAppSettingData subData;
		if (fieldData != null) {
			subData = createSettingData(type, null, Collections
					.singletonList(fieldData));
		} else {
			List<EObject> empty = Collections.emptyList();
			subData = createSettingData(type, null, empty);
		}
		return subData;
	}

	private void populateSettingRfs(EAppSetting setting, String settingId,
			Map<String, EObject> rfsItems) {
		EAppRfsInfo rfsInfo = setting.getRfsInfo();
		if (rfsInfo == null) {
			rfsInfo = EApplicationFactory.eINSTANCE.createEAppRfsInfo();
			setting.setRfsInfo(rfsInfo);
		}
		EObject settingRfs = rfsItems == null ? null : rfsItems.get(settingId);
		if (settingRfs != null) {
			if (settingRfs instanceof ESettingRfs) {
				rfsInfo.setRfs(Boolean.parseBoolean(((ESettingRfs) settingRfs)
						.getRfs()));
			} else if (settingRfs instanceof com.nokia.tools.vct.confml.model.confml2.ESettingRfs) {
				rfsInfo
						.setRfs(Boolean
								.parseBoolean(((com.nokia.tools.vct.confml.model.confml2.ESettingRfs) settingRfs)
										.getRfs()));
			}
		}
	}

	private void populateMaps(ResourceSet resourceSet, URI confML,
			Set<URI> visited, Map<String, EObject> views,
			Map<String, List<EObject>> types,
			Map<String, Map<String, List<EObject>>> data,
			Map<String, Map<String, EObject>> rfs,
			List<EAppIncludeElement> includeChain) {
		if (visited.contains(confML)) {
			return;
		}
		visited.add(confML);
		Resource resource;
		try {
			resource = resourceSet.getResource(confML, true);
		} catch (Exception ex) {
			return;
		}

		TreeIterator<Object> iterator = EcoreUtil.getAllContents(resource,
				false);
		while (iterator.hasNext()) {
			Object obj = iterator.next();

			if (obj instanceof EInclude) {
				URI uri = URI.createURI(((EInclude) obj).getHref());
				uri = uri.resolve(confML);

				EAppIncludeElement include = EApplicationFactory.eINSTANCE
						.createEAppIncludeElement();
				include.setSource(confML);
				include.setTarget(uri);
				includeChain.add(include);

				populateMaps(resourceSet, uri, visited, views, types, data,
						rfs, includeChain);
				iterator.prune();
			} else if (obj instanceof EViewElement) {
				EViewElement view = (EViewElement) obj;
				String id = view.getName();
				// if (views.containsKey(id)) {
				// continue;
				// }
				views.put(id, view);
				iterator.prune();
			} else if (obj instanceof com.nokia.tools.vct.confml.model.confml2.EViewElement) {
				com.nokia.tools.vct.confml.model.confml2.EViewElement view = (com.nokia.tools.vct.confml.model.confml2.EViewElement) obj;
				String id = view.getName();
				// if (views.containsKey(id)) {
				// continue;
				// }
				views.put(id, view);
				iterator.prune();
			} else if (obj instanceof EFeatureElement) {
				EFeatureElement featureElement = (EFeatureElement) obj;

				String ref = featureElement.getRef();
				List<EObject> typeList = types.get(ref);
				if (typeList == null) {
					typeList = new ArrayList<EObject>();
					types.put(ref, typeList);
				}
				typeList.add(featureElement);

				iterator.prune();
			} else if (obj instanceof com.nokia.tools.vct.confml.model.confml2.EFeatureElement) {
				com.nokia.tools.vct.confml.model.confml2.EFeatureElement featureElement = (com.nokia.tools.vct.confml.model.confml2.EFeatureElement) obj;

				String ref = featureElement.getRef();
				List<EObject> typeList = types.get(ref);
				if (typeList == null) {
					typeList = new ArrayList<EObject>();
					types.put(ref, typeList);
				}
				typeList.add(featureElement);

				iterator.prune();
			} else if (obj instanceof com.nokia.tools.vct.confml.model.confml1.EFeatureData) {
				com.nokia.tools.vct.confml.model.confml1.EFeatureData featureData = (com.nokia.tools.vct.confml.model.confml1.EFeatureData) obj;

				String ref = featureData.getRef();
				Map<String, List<EObject>> dataItems = data.get(ref);
				if (dataItems == null) {
					dataItems = new HashMap<String, List<EObject>>();
					data.put(ref, dataItems);
				}

				for (ESettingData sd : featureData.getSettings()) {
					String settingRef = sd.getRef();

					// Don't skip sequences
					// if (dataItems.containsKey(id)) {
					// continue;
					// }
					List<EObject> settingDataList = dataItems.get(settingRef);
					if (settingDataList == null) {
						settingDataList = new ArrayList<EObject>();
						dataItems.put(settingRef, settingDataList);
					}
					settingDataList.add(sd);
				}

				iterator.prune();
			} else if (obj instanceof EFeatureData) {
				EFeatureData featureData = (EFeatureData) obj;

				String ref = featureData.getRef();
				Map<String, List<EObject>> dataItems = data.get(ref);
				if (dataItems == null) {
					dataItems = new HashMap<String, List<EObject>>();
					data.put(ref, dataItems);
				}

				for (com.nokia.tools.vct.confml.model.confml2.ESettingData sd : featureData
						.getSettings()) {
					String settingRef = sd.getRef();

					// Don't skip sequences
					// if (dataItems.containsKey(id)) {
					// continue;
					// }
					List<EObject> settingDataList = dataItems.get(settingRef);
					if (settingDataList == null) {
						settingDataList = new ArrayList<EObject>();
						dataItems.put(settingRef, settingDataList);
					}
					settingDataList.add(sd);
				}

				iterator.prune();
			} else if (obj instanceof com.nokia.tools.vct.confml.model.confml1.EFeatureRfs) {
				com.nokia.tools.vct.confml.model.confml1.EFeatureRfs featureRfs = (com.nokia.tools.vct.confml.model.confml1.EFeatureRfs) obj;
				Map<String, EObject> rfsItems = rfs.get(featureRfs.getRef());
				if (rfsItems == null) {
					rfsItems = new HashMap<String, EObject>();
					rfs.put(featureRfs.getRef(), rfsItems);
				}
				for (com.nokia.tools.vct.confml.model.confml1.ESettingRfs settingRfs : featureRfs
						.getSettings()) {
					String ref = settingRfs.getRef();
					if (rfsItems.containsKey(ref)) {
						continue;
					}
					rfsItems.put(ref, settingRfs);
				}
			} else if (obj instanceof EFeatureRfs) {
				EFeatureRfs featureRfs = (EFeatureRfs) obj;
				Map<String, EObject> rfsItems = rfs.get(featureRfs.getRef());
				if (rfsItems == null) {
					rfsItems = new HashMap<String, EObject>();
					rfs.put(featureRfs.getRef(), rfsItems);
				}
				for (com.nokia.tools.vct.confml.model.confml2.ESettingRfs settingRfs : featureRfs
						.getSettings()) {
					String ref = settingRfs.getRef();
					if (rfsItems.containsKey(ref)) {
						continue;
					}
					rfsItems.put(ref, settingRfs);
				}
			}
		}
	}

	private URI relativize(URI parentURI, URI uri) {
		int i = parentURI.segmentCount();
		List<String> segments = uri.segmentsList();
		List<String> trim = segments.subList(i - 1, segments.size());
		URI relative = ConfMLConstants.EMPTY_URI.appendSegments(ArrayUtils
				.createCopy(String.class, trim));
		return relative;
	}

	private boolean isBaseURI(URI baseURI, URI uri) {
		if (uri.segmentCount() < baseURI.segmentCount()) {
			return false;
		}

		for (int i = 0; i < baseURI.segmentCount() - 1; i++) {
			if (!uri.segment(i).equals(baseURI.segment(i))) {
				return false;
			}
		}

		return true;
	}
}
