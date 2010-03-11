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

package com.nokia.tools.variant.confml.internal.core.project;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceRuleFactory;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.MultiRule;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;

import com.nokia.tools.variant.confml.core.ConfMLCore;
import com.nokia.tools.variant.confml.core.model.application.EConfigurationProject;
import com.nokia.tools.variant.confml.core.model.core.EWorkspaceModel;
import com.nokia.tools.variant.confml.core.model.metadata.ECPFMetadata;
import com.nokia.tools.variant.confml.core.model.metadata.util.ECPFMetadataResourceFactoryImpl;
import com.nokia.tools.variant.confml.internal.core.ModelManager;
import com.nokia.tools.variant.confml.internal.core.application.AppModelFactory;
import com.nokia.tools.variant.confml.internal.core.confml.ConfMLNature;

/**
 * Class manages project variant contributions.
 * 
 * The contribution occurs automatically when a project is opened/closed and the
 * project contains ConfML nature and proper metadata annotation.
 * 
 * The contributions are synchronized on the root model object
 * 
 * @see BundleVariantAdapter for plugin contributions
 */
public class ProjectVariantAdapter {

	private class WorkspaceSynchronizeJob extends WorkspaceJob {
		private List<IProject> removedProjects;
		private List<IFile> removedFiles;
		private List<IFile> changedFiles;

		public WorkspaceSynchronizeJob(List<IProject> removedProjects,
				List<IFile> removedFiles, List<IFile> changedFiles) {
			super("Updating application model");

			this.removedFiles = removedFiles;
			this.removedProjects = removedProjects;
			this.changedFiles = changedFiles;

			setRule(calculateRule());
		}

		@Override
		public IStatus runInWorkspace(IProgressMonitor monitor)
				throws CoreException {
			try {
				TransactionalEditingDomain domain = ModelManager
						.getModelManager().getEditingDomain();
				domain.getCommandStack().execute(new RecordingCommand(domain) {
					@Override
					protected void doExecute() {
						try {
							handleResourceChangedEvent(removedProjects,
									removedFiles, changedFiles);
						} catch (Exception ex) {
							System.err
									.println("FATAL 1:************************");
							ex.printStackTrace();
						}
					}
				});
				domain.getCommandStack().flush();
			} catch (Exception ex) {
				System.err.println("********************************");
				ex.printStackTrace();
			}
			return Status.OK_STATUS;
		}

		private ISchedulingRule calculateRule() {
			ISchedulingRule result = null;

			IResourceRuleFactory factory = ResourcesPlugin.getWorkspace()
					.getRuleFactory();

			for (IResource next : removedProjects) {
				result = MultiRule.combine(result, factory.modifyRule(next));
			}
			for (IResource next : changedFiles) {
				result = MultiRule.combine(result, factory.modifyRule(next));
			}
			for (IResource next : removedFiles) {
				result = MultiRule.combine(result, factory.modifyRule(next));
			}

			return result;
		}
	}

	private class WorkspaceInitJob extends WorkspaceJob {

		public WorkspaceInitJob() {
			super("Updating application model");

			setRule(calculateRule());
		}

		@Override
		public IStatus runInWorkspace(IProgressMonitor monitor)
				throws CoreException {

			try {
				TransactionalEditingDomain domain = ModelManager
						.getModelManager().getEditingDomain();
				domain.getCommandStack().execute(new RecordingCommand(domain) {
					@Override
					protected void doExecute() {
						try {

							TransactionalEditingDomain domain = ModelManager
									.getModelManager().getEditingDomain();
							domain.getCommandStack().execute(
									new RecordingCommand(domain) {
										@Override
										protected void doExecute() {
											try {
												executeJobInternal();
											} catch (Throwable thr) {
												System.err
														.println("FATAL 2:************************");
												thr.printStackTrace();

											}
										}
									});
							domain.getCommandStack().flush();
						} catch (Exception ex) {
							System.err
									.println("FATAL 3:************************");
							ex.printStackTrace();
						}
					}
				});
			} catch (Exception ex) {
				System.err.println("********************************");
				ex.printStackTrace();
			}
			return Status.OK_STATUS;
		}

		private void executeJobInternal() {
			try {
				IProject[] projects = ResourcesPlugin.getWorkspace().getRoot()
						.getProjects();
				EWorkspaceModel workspaceModel = ModelManager.getModelManager()
						.getWorkspaceModel();

				for (IProject project : projects) {

					boolean hasNature;
					try {
						hasNature = project
								.hasNature(ConfMLNature.CONF_ML_NATURE_ID);
					} catch (CoreException e) {
						hasNature = false;
					}
					if (hasNature) {
						createProjectModel(workspaceModel, project);
					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		private ISchedulingRule calculateRule() {
			IResourceRuleFactory factory = ResourcesPlugin.getWorkspace()
					.getRuleFactory();

			return factory.modifyRule(ResourcesPlugin.getWorkspace().getRoot());
		}
	}

	/**
	 * Workspace change callback handler.
	 */
	private class WorkspaceListener implements IResourceChangeListener {
		/**
		 * Lock the workspace and initiate the model update job
		 */
		public void resourceChanged(final IResourceChangeEvent event) {
			final List<IProject> removedProjects = new ArrayList<IProject>();
			final List<IFile> removedFiles = new ArrayList<IFile>();
			final List<IFile> changedFiles = new ArrayList<IFile>();

			switch (event.getType()) {
			case IResourceChangeEvent.PRE_CLOSE:
			case IResourceChangeEvent.PRE_DELETE:
				removedProjects.add((IProject) event.getResource());
				break;
			case IResourceChangeEvent.POST_CHANGE:
				IResourceDelta delta = event.getDelta();
				if (delta == null) {
					return;
				}
				class Visitor implements IResourceDeltaVisitor {
					public boolean visit(IResourceDelta delta)
							throws CoreException {
						IResource resource = delta.getResource();
						if (resource instanceof IFile) {
							switch (delta.getKind()) {
							case IResourceDelta.REMOVED:
								removedFiles.add((IFile) resource);
								break;
							case IResourceDelta.ADDED:
								changedFiles.add((IFile) resource);
								break;
							case IResourceDelta.CHANGED:
								if (delta.getFlags() != IResourceDelta.MARKERS) {
									changedFiles.add((IFile) resource);
								}
								break;
							}
						}
						return true;
					}
				}

				try {
					delta.accept(new Visitor(), false);
				} catch (CoreException e) {
					// normal
				}
			}

			if (removedProjects.isEmpty() && removedFiles.isEmpty()
					&& changedFiles.isEmpty()) {
				return;
			}

			WorkspaceJob modelUpdateJob = new WorkspaceSynchronizeJob(
					removedProjects, removedFiles, changedFiles);
			modelUpdateJob.setUser(false);
			modelUpdateJob.setPriority(Job.SHORT);
			modelUpdateJob.schedule();
		}

	}

	private final WorkspaceListener listener;

	public ProjectVariantAdapter() {
		listener = new WorkspaceListener();
	}

	protected void handleResourceChangedEvent(List<IProject> removedProjects,
			List<IFile> removedFiles, List<IFile> changedFiles) {
		ModelManager modelManager = ModelManager.getModelManager();

		EWorkspaceModel workspaceModel = modelManager.getWorkspaceModel();
		for (IProject project : removedProjects) {
			deleteProjectModel(workspaceModel, project);
		}
		Map<IProject, List<IFile>> affected = new HashMap<IProject, List<IFile>>();
		for (IFile file : removedFiles) {
			IProject project = file.getProject();
			List<IFile> tmp = affected.get(project);
			if (tmp == null) {
				tmp = new ArrayList<IFile>();
				affected.put(project, tmp);
			}
			tmp.add(file);
		}
		for (IFile file : changedFiles) {
			IProject project = file.getProject();
			List<IFile> tmp = affected.get(project);
			if (tmp == null) {
				tmp = new ArrayList<IFile>();
				affected.put(project, tmp);
			}
			tmp.add(file);
		}
		affected.keySet().removeAll(removedProjects);

		for (Map.Entry<IProject, List<IFile>> entry : affected.entrySet()) {
			IProject project = entry.getKey();
			List<IFile> files = entry.getValue();

			boolean hasNature;
			try {
				hasNature = project.hasNature(ConfMLNature.CONF_ML_NATURE_ID);
			} catch (CoreException e) {
				hasNature = false;
			}

			if (!hasNature) {
				deleteProjectModel(workspaceModel, project);
			} else {
				EConfigurationProject projectModel = workspaceModel
						.getProjectMap().get(project.getName());
				if (projectModel == null) {
					createProjectModel(workspaceModel, project);
				} else {
					updateProjectModel(projectModel, project, files);
				}
			}
		}
	}

	private void updateProjectModel(EConfigurationProject projectModel,
			IProject project, List<IFile> files) {
		final ResourceSet resourceSet = projectModel.eResource()
				.getResourceSet();
		EWorkspaceModel workspaceModel = (EWorkspaceModel) projectModel
				.eContainer().eContainer();
		workspaceModel.getProjectMap().removeKey(project.getName());
		for (IFile file : files) {
			URI uri = URI.createPlatformResourceURI(file.getFullPath()
					.toPortableString(), true);
			Resource resource = resourceSet.getResource(uri, false);
			if (resource != null) {
				resourceSet.getResources().remove(resource);
			}
		}
		createProjectModel(workspaceModel, project);
	}

	private void createProjectModel(EWorkspaceModel workspaceModel,
			IProject project) {
		final ResourceSet resourceSet = workspaceModel.eResource()
				.getResourceSet();
		final List<URI> resources = getProjectResources(project);

		
		IFile metadataFile = project.getFile(".metadata");
		String cpfRootFile = null;
		if (metadataFile.exists()) {
			URI uri = URI.createPlatformResourceURI(metadataFile.getFullPath()
					.toPortableString(), true);
			Resource resource = new ECPFMetadataResourceFactoryImpl()
					.createResource(uri);
			try {
				resource.load(null);
				ECPFMetadata root = (ECPFMetadata) resource.getContents()
						.get(0);
				cpfRootFile = root.getCpfRootFile();
			} catch (IOException ex) {
				// ignore
			}
		}
		if (cpfRootFile == null) {
			cpfRootFile = "root.confml";
		}

		URI uri = URI.createPlatformResourceURI(project.getFile(cpfRootFile)
				.getFullPath().toPortableString(), true);
		AppModelFactory appModelFactory = new AppModelFactory() {
			@Override
			protected URI discoverLayerUri(URI includeURI,
					Collection<URI> resources) {
				return ProjectVariantAdapter.this.discoverLayerUri(includeURI);
			}
		};
		
		EConfigurationProject configurationProject = appModelFactory.populateProject(resourceSet, uri, resources); 

		workspaceModel.getProjectMap().put(project.getName(),
				configurationProject);
	}

	private URI discoverLayerUri(URI includeURI) {
		IPath path = new Path(includeURI.toPlatformString(true));
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
		IContainer ptr = file.getParent();
		IPath layerPath = ptr.getFullPath();
		if (ptr.findMember("confml") != null) {
			layerPath = ptr.getFullPath();
		} else {
			int count = path.segmentCount();
			for (int i = count - 1; i > 0; i--) {
				if ("confml".equals(path.segment(i))) {
					layerPath = path.removeLastSegments(count - i);
					break;
				}
			}
		}
		return URI
				.createPlatformResourceURI(layerPath.toPortableString(), true)
				.appendSegment("");
	}

	private List<URI> getProjectResources(IProject project) {
		final List<URI> resources = new ArrayList<URI>();
		try {
			project.accept(new IResourceVisitor() {
				public boolean visit(IResource resource) throws CoreException {
					if (resource instanceof IFile) {
						URI uri = URI.createPlatformResourceURI(resource
								.getFullPath().toPortableString(), true);
						resources.add(uri);
					}
					return true;
				}
			});
		} catch (CoreException e) {
			e.printStackTrace();
		}
		return resources;
	}

	private void deleteProjectModel(EWorkspaceModel workspaceModel,
			IProject project) {
		workspaceModel.getProjectMap().remove(project.getName());
		ResourceSet rs = workspaceModel.eResource().getResourceSet();
		for (Iterator<Resource> it = rs.getResources().iterator(); it.hasNext();) {
			Resource resource = it.next();
			URI uri = resource.getURI();
			if (uri != null && uri.isPlatformResource()) {
				String projectName = uri.segment(1);
				if (projectName.equals(project.getName())) {
					it.remove();
					TransactionUtil.disconnectFromEditingDomain(resource);
				}
			}
		}
	}

	public void start() {
		ResourcesPlugin.getWorkspace().addResourceChangeListener(listener);

		WorkspaceInitJob job = new WorkspaceInitJob();
		job.setPriority(Job.SHORT);
		job.setUser(false);
		try {
			job.runInWorkspace(null);
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

	public void stop() {
		ResourcesPlugin.getWorkspace().removeResourceChangeListener(listener);
		ConfMLCore.getEditingDomain().getCommandStack().execute(
				new RecordingCommand(ConfMLCore.getEditingDomain()) {
					@Override
					protected void doExecute() {
						EWorkspaceModel model = ModelManager.getModelManager()
								.getWorkspaceModel();
						model.getProjectMap().clear();
						ResourceSet resourceSet = model.eResource()
								.getResourceSet();
						for (Iterator<Resource> it = resourceSet.getResources()
								.iterator(); it.hasNext();) {
							Resource resource = it.next();
							if (resource.getURI() != null) {
								it.remove();
							}
						}
					}
				});
		ConfMLCore.getEditingDomain().getCommandStack().flush();
	}

}
