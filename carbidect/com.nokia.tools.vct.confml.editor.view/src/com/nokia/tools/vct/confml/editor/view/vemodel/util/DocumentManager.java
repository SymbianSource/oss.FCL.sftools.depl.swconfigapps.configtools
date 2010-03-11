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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListenerImpl;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.ui.WorkbenchException;

import com.nokia.tools.variant.confml.core.ConfMLCore;
import com.nokia.tools.variant.confml.ui.ConfmlUI;
import com.nokia.tools.variant.confml.ui.editors.IDocumentManager;
import com.nokia.tools.vct.common.core.utils.ExceptionUtils;
import com.nokia.tools.vct.confml.editor.view.vemodel.EGroup;
import com.nokia.tools.vct.confml.editor.view.vemodel.EGroupContainer;
import com.nokia.tools.vct.confml.editor.view.vemodel.ESettingRef;
import com.nokia.tools.vct.confml.editor.view.vemodel.EView;
import com.nokia.tools.vct.confml.editor.view.vemodel.EViewEditorFactory;
import com.nokia.tools.vct.confml.editor.view.vemodel.EViewsEditorDocument;
import com.nokia.tools.vct.confml.model.confml1.util.EConfML1ResourceFactoryImpl;

public class DocumentManager implements IDocumentManager<EViewsEditorDocument> {

	static class PersistenceAdapter implements Adapter {
		Resource persistenceModel;
		IFile file;
		
		public PersistenceAdapter(IFile file, Resource persistenceModel) {
			this.file = file;
			this.persistenceModel = persistenceModel;
		}
		
		EViewsEditorDocument target;
		public EViewsEditorDocument getTarget() {
			return target;
		}
		public void setTarget(Notifier newTarget) {
			this.target = (EViewsEditorDocument)newTarget;
		}
		public boolean isAdapterForType(Object type) {
			return PersistenceAdapter.class.equals(type);
		}
		public void notifyChanged(Notification notification) {
			// ignore
		}
	}
	
	static class DomainRSAdapter extends ResourceSetListenerImpl implements
			Adapter {
		EViewsEditorDocument target;

		public EViewsEditorDocument getTarget() {
			return target;
		}

		public void setTarget(Notifier newTarget) {
			target = (EViewsEditorDocument) newTarget;
			handleDomainModelUpdate();
		}

		public boolean isAdapterForType(Object type) {
			return DomainRSAdapter.class.equals(type);
		}

		public void notifyChanged(Notification notification) {
			// ignore
		}

		@Override
		public boolean isPostcommitOnly() {
			return true;
		}

		@Override
		public void resourceSetChanged(ResourceSetChangeEvent event) {
			handleDomainModelUpdate();
		}

		void handleDomainModelUpdate() {
			if (getTarget() == null) {
				// if there is no target, nothing to do
				return;
			}
			
			final URI uri = getTarget().eResource().getURI();
			
			EViewsEditorDocument importedDocument;
			TransactionalEditingDomain d1 = ConfMLCore.getEditingDomain();
			try {
				importedDocument = TransactionUtil.runExclusive(d1, new Variant2EditorConverter(uri));
			} catch (InterruptedException e) {
				e.printStackTrace();
				importedDocument = null;
			}
			
			final EViewsEditorDocument tmp = importedDocument;
			TransactionalEditingDomain d2 = TransactionUtil.getEditingDomain(getTarget());
			d2.getCommandStack().execute(new RecordingCommand(d2) {
				@Override
				protected void doExecute() {
					EViewsEditorDocument doc = getTarget();
					doc.getFeatures().clear();
					if (tmp != null) {
						doc.getFeatures().addAll(tmp.getFeatures());
					}
					for (EView view : doc.getViews().values()) {
						updateGroupRefs(doc, view);
					}
				}
				private void updateGroupRefs(EViewsEditorDocument document,
						EGroupContainer container) {

					for (EGroup group : container.getGroups()) {
						// recursively process sub-groups.
						updateGroupRefs(document, group);

						for (ESettingRef ref : group.getRefs()) {
							ConverterUtils.updateIndexReference(document, ref);
						}
					}
				}
			});
			d2.getCommandStack().flush();
		}
		
	}

	static class DocumentBuilder implements IWorkspaceRunnable {

		private IFile file;
		private EViewsEditorDocument document;

		public DocumentBuilder(IFile file) {
			this.file = file;
		}

		public void run(IProgressMonitor monitor) throws CoreException {
			final EViewsEditorDocument document = createEmptyDocument(file);
			final TransactionalEditingDomain d1 = ConfMLCore.getEditingDomain();

			try {

				{
					// Load the application model into the view
					DomainRSAdapter adapter = new DomainRSAdapter();
					d1.addResourceSetListener(adapter);
					document.eAdapters().add(adapter);
				}

				final Resource resource;
				try {
					resource = loadFileContent(file);
					
					PersistenceAdapter adapter = new PersistenceAdapter(file, resource);
					document.eAdapters().add(adapter);
					
				} catch (CoreException e) {
					throw e;
				}
				

				TransactionalEditingDomain domain = TransactionUtil
						.getEditingDomain(document);
				domain.getCommandStack().execute(new RecordingCommand(domain) {
					@Override
					protected void doExecute() {
						Persistence2EditorConverter converter = new Persistence2EditorConverter(
								resource, document);
						converter.run();
					}
				});
				domain.getCommandStack().flush();

				this.document = document;
			} catch (Throwable thr) {
				detachAdapters(document);
				ExceptionUtils.throwIfMatches(Error.class, thr);
				ExceptionUtils.throwIfMatches(RuntimeException.class, thr);
				throw ExceptionUtils.wrapCoreException(thr, ConfmlUI.PLUGIN_ID,
						"Failed to create view editor model");
			}
		}

		
		public EViewsEditorDocument getDocument() {
			return document;
		}

	}

	static void detachAdapters(final EViewsEditorDocument document) {
		final DomainRSAdapter adapter1 = (DomainRSAdapter) EcoreUtil
				.getExistingAdapter(document, DomainRSAdapter.class);
		if (adapter1 != null) {
			ConfMLCore.getEditingDomain().removeResourceSetListener(adapter1);
		}
		final PersistenceAdapter adapter2 = (PersistenceAdapter)EcoreUtil.getExistingAdapter(document, PersistenceAdapter.class);

		TransactionalEditingDomain dom = TransactionUtil.getEditingDomain(document);
		try {
			TransactionUtil.runExclusive(dom, new RunnableWithResult.Impl<Void>() {
				public void run() {
					if (adapter1 != null) {
						document.eAdapters().remove(adapter1);
					}
					if (adapter2 != null) {
						document.eAdapters().remove(adapter2);
					}
				}
			});
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}

	
	static Resource loadFileContent(IFile file) throws CoreException {
		EConfML1ResourceFactoryImpl factory = new EConfML1ResourceFactoryImpl();
		URI uri = URI.createPlatformResourceURI(file.getFullPath().toPortableString(),true);
		
		Resource resource = factory.createResource(uri);
		try {
			resource.load(null);
		} catch (IOException ex) {
			throw new WorkbenchException("Error", ex);
		} finally {
		}

		return resource;
	}

	/**
	 * Create empty document and bind it to the transaction domain.
	 * 
	 * @param file
	 *            File for which the document is created
	 * @return New document reference bound to transaction domain
	 */
	static EViewsEditorDocument createEmptyDocument(IFile file) {
		ResourceSetImpl resourceSet = new ResourceSetImpl();
		URI location = URI.createPlatformResourceURI(file.getFullPath().toPortableString(), true);
		ResourceImpl resource = new ResourceImpl(location);
		resourceSet.getResources().add(resource);

		EViewsEditorDocument document = EViewEditorFactory.eINSTANCE
				.createEViewsEditorDocument();
		document.setUseCount(1);
		resource.getContents().add(document);

		// create domain...
		TransactionalEditingDomain domain = TransactionalEditingDomain.Factory.INSTANCE
				.createEditingDomain(resourceSet);
		domain.getCommandStack().flush();

		return document;
	}

	private static DocumentManager instance = new DocumentManager();

	// private Map<URI, Resource> managed = new LinkedHashMap<URI, Resource>();

	public static DocumentManager getInstance() {
		return instance;
	}

	public EViewsEditorDocument getModel(IFile file, IProgressMonitor monitor)
			throws CoreException {

		DocumentBuilder builder = new DocumentBuilder(file);
		ResourcesPlugin.getWorkspace().run(builder, file,
				IWorkspace.AVOID_UPDATE, monitor);

		return builder.getDocument();
	}

	public void releaseDocument(final EViewsEditorDocument model){
		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(model);
		final int[] counter = {0};
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				counter[0] = model.getUseCount() - 1;
				model.setUseCount(counter[0]);
			}
		});
		if (counter[0] == 0) {
			detachAdapters(model);
		}
	}

	public void saveModel(EViewsEditorDocument model, IProgressMonitor monitor)
			throws CoreException {
		monitor.beginTask("Saving model", 100);
		try {
		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(model);
		
		PersistenceAdapter adapter = (PersistenceAdapter)EcoreUtil.getExistingAdapter(model, PersistenceAdapter.class);
		final Editor2PersistenceConverter converter = new Editor2PersistenceConverter(model, adapter.persistenceModel);
		
		monitor.subTask("Converting to persistence");
		try {
			
			TransactionUtil.runExclusive(domain, new RunnableWithResult.Impl<Void>() {
				public void run() {
					converter.run();
				};
			});
		} catch (InterruptedException e) {
			e.printStackTrace();
			throw ExceptionUtils.wrapCoreException(e, ConfmlUI.PLUGIN_ID, "Failed to serialize");
		}
		monitor.worked(30);
		
		monitor.subTask("Serializing XML");
		adapter.persistenceModel.save(null);
		} catch (IOException ex) {
			throw new WorkbenchException("Failed to save", ex);
		} finally {
			monitor.done();
		}
	}

}
