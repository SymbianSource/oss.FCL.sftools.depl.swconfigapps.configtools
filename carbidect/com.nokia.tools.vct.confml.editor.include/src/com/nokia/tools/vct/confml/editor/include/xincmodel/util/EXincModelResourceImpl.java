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
 * Description: This file is part of com.nokia.tools.vct.confml.editor.include component.
 */

package com.nokia.tools.vct.confml.editor.include.xincmodel.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;

import com.nokia.tools.vct.confml.editor.include.xincmodel.EConfMLVersion;
import com.nokia.tools.vct.confml.editor.include.xincmodel.EDocument;
import com.nokia.tools.vct.confml.editor.include.xincmodel.EProjectFile;
import com.nokia.tools.vct.confml.editor.include.xincmodel.EProjectFolder;
import com.nokia.tools.vct.confml.editor.include.xincmodel.EResourceContainer;
import com.nokia.tools.vct.confml.editor.include.xincmodel.EXincModelFactory;
import com.nokia.tools.vct.confml.model.confml1.EConfMLDocument;
import com.nokia.tools.vct.confml.model.confml1.include.EConfMLIncludeFactory;
import com.nokia.tools.vct.confml.model.confml1.include.EInclude;
import com.nokia.tools.vct.confml.model.confml2.EConfML2Document;

/**
 * <!-- begin-user-doc --> The <b>Resource </b> associated with the package.
 * <!-- end-user-doc -->
 * @see com.nokia.tools.vct.confml.editor.include.xincmodel.util.EXincModelResourceFactoryImpl
 * @generated
 */
public class EXincModelResourceImpl extends ResourceImpl {

	private Resource delegate;

	/**
	 * Creates an instance of the resource. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param uri
	 *            the URI of the new resource.
	 * @generated NOT
	 */
	public EXincModelResourceImpl(URI uri) {
		super(uri);

		Factory factory = Factory.Registry.INSTANCE.getFactory(uri);
		delegate = factory.createResource(uri);
	}

	@Override
	protected void doLoad(InputStream inputStream, Map<?, ?> options)
			throws IOException {
		EXincModelFactory factory = EXincModelFactory.eINSTANCE;

		try {
			delegate.load(inputStream, options);
		} catch (Exception ex) {
			ex.printStackTrace();

			throw new Resource.IOWrappedException(ex);
		}
		final EDocument root = factory.createEDocument();

		EObject srcDocument = delegate.getContents().get(0);
		EList<EInclude> srcIncludes;
		EConfMLVersion version;
		String name;
		if (srcDocument instanceof EConfMLDocument) {
			srcIncludes = ((EConfMLDocument) srcDocument).getConfiguration()
					.getIncludes();
			version = EConfMLVersion.CONFML1;
			name = ((EConfMLDocument)srcDocument).getConfiguration().getName();
		} else if (srcDocument instanceof EConfML2Document) {
			srcIncludes = ((EConfML2Document) srcDocument).getConfiguration()
					.getIncludes();
			version = EConfMLVersion.CONFML2;
			name = ((EConfML2Document)srcDocument).getConfiguration().getName();
		} else {
			throw new IOException("Unsupported source content: "
					+ srcDocument.eClass().getName());
		}
		root.setVersion(version);
		root.setName(name);

		if (srcIncludes != null) {
			for (EInclude src : srcIncludes) {
				com.nokia.tools.vct.confml.editor.include.xincmodel.EInclude inc = factory
						.createEInclude();
				inc.setHref(src.getHref());
				root.getIncludes().add(inc);
			}
		}

		URI uri = getURI();
		String proSeg = uri.segment(1);
		final StringBuilder fileRelPath = new StringBuilder("");
		for (int i = 2; i < uri.segmentCount(); i++) {
			fileRelPath.append(uri.segment(i));
			if(i!=uri.segmentCount()-1) {
				fileRelPath.append("/");
			}
		}
		if (uri.isPlatformResource()) {
			String projectName = URI.decode(proSeg);
			IProject project = ResourcesPlugin.getWorkspace().getRoot()
					.getProject(projectName);
			final Map<IPath, IResource> map = new HashMap<IPath, IResource>();
			final Map<IPath, EResourceContainer> map2 = new HashMap<IPath, EResourceContainer>();

			
			try {
				project.accept(new IResourceVisitor() {
					public boolean visit(IResource resource)
							throws CoreException {
						map.put(resource.getProjectRelativePath(), resource);
						if (resource instanceof IProject) {
							map2.put(resource.getProjectRelativePath(), root);
						} else if (resource instanceof IFolder) {
							EProjectFolder folder = EXincModelFactory.eINSTANCE
									.createEProjectFolder();
							folder.setName(resource.getName());
							folder.setProjectPath(resource.getFullPath().toPortableString());
							IPath parentPath = resource.getParent()
									.getProjectRelativePath();
							EResourceContainer parent = map2.get(parentPath);
							parent.getResources().add(folder);
							map2.put(resource.getProjectRelativePath(), folder);
						} else if (resource instanceof IFile
								&& "confml".equals(resource.getFileExtension())) {
							String relPath = resource.getProjectRelativePath().toString();
							if(!fileRelPath.toString().equals(relPath)) {
								EProjectFile file = EXincModelFactory.eINSTANCE
								.createEProjectFile();
								file.setName(resource.getName());
								file.setProjectPath(resource.getFullPath().toPortableString());
								IPath parentPath = resource.getParent()
								.getProjectRelativePath();
								EResourceContainer parent = map2.get(parentPath);
								parent.getResources().add(file);
								file.setVersion(EConfMLVersion.CONFML1);								
							}
						}

						return true;
					}
				});
			} catch (Exception e) {
				e.printStackTrace();
				throw new Resource.IOWrappedException(e);
			}

		}
		try {
			getContents().add(root);

			for (com.nokia.tools.vct.confml.editor.include.xincmodel.EInclude inc : root.getIncludes()) {
			String href = inc.getHref();
			href = EXincModelUtils.normalizeHref(href);
			EProjectFile file = EXincModelUtils.findTargetFile(root, href);
			inc.setTarget(file);
		}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	@Override
	protected void doSave(OutputStream outputStream, Map<?, ?> options)
			throws IOException {
		EDocument root = (EDocument) getContents().get(0);
		EConfMLIncludeFactory factory = EConfMLIncludeFactory.eINSTANCE;

		List<EInclude> includes = new ArrayList<EInclude>();
		for (com.nokia.tools.vct.confml.editor.include.xincmodel.EInclude src : root
				.getIncludes()) {
			EInclude include = factory.createEInclude();
			include.setHref(src.getHref());
			includes.add(include);
		}

		EObject srcDocument = delegate.getContents().get(0);
		EList<EInclude> dstIncludes;
		if (srcDocument instanceof EConfMLDocument) {
			dstIncludes = ((EConfMLDocument) srcDocument).getConfiguration()
					.getIncludes();
			((EConfMLDocument) srcDocument).getConfiguration().setName(root.getName());
		} else if (srcDocument instanceof EConfML2Document) {
			dstIncludes = ((EConfML2Document) srcDocument).getConfiguration()
					.getIncludes();
			((EConfML2Document) srcDocument).getConfiguration().setName(root.getName());
		} else {
			throw new IOException("Unsupported destination content: "
					+ srcDocument.eClass().getName());
		}
		dstIncludes.clear();
		dstIncludes.addAll(includes);

		delegate.save(outputStream, options);
	}

	@Override
	protected void doUnload() {
		delegate.unload();
		super.doUnload();
	}

} // EXincModelResourceImpl
