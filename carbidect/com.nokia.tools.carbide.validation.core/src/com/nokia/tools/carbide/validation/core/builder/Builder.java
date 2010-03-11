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
 * Description: This file is part of com.nokia.tools.carbide.validation.core component.
 */

package com.nokia.tools.carbide.validation.core.builder;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import javax.xml.XMLConstants;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.ValidatorHandler;

import org.apache.xerces.parsers.SAXParser;
import org.apache.xerces.parsers.XIncludeAwareParserConfiguration;
import org.apache.xerces.xni.Augmentations;
import org.apache.xerces.xni.NamespaceContext;
import org.apache.xerces.xni.QName;
import org.apache.xerces.xni.XMLAttributes;
import org.apache.xerces.xni.XMLLocator;
import org.apache.xerces.xni.XNIException;
import org.apache.xerces.xni.parser.XMLErrorHandler;
import org.apache.xerces.xni.parser.XMLInputSource;
import org.apache.xerces.xni.parser.XMLParseException;
import org.apache.xerces.xni.parser.XMLParserConfiguration;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ContentHandler;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.URIHandler;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.emf.ecore.resource.impl.PlatformResourceURIHandlerImpl;
import org.eclipse.emf.validation.marker.IMarkerConfigurator;
import org.eclipse.emf.validation.marker.MarkerUtil;
import org.eclipse.emf.validation.model.Category;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.model.IConstraintStatus;
import org.eclipse.emf.validation.model.IModelConstraint;
import org.eclipse.emf.validation.service.IBatchValidator;
import org.eclipse.emf.validation.service.IConstraintDescriptor;
import org.eclipse.emf.validation.service.ModelValidationService;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import com.nokia.tools.carbide.validation.core.ConfmlMarkerUtils;
import com.nokia.tools.carbide.validation.core.ValidationCorePlugin;
import com.nokia.tools.vct.confml.model.confml1.EFeatureData;
import com.nokia.tools.vct.confml.model.confml1.EFeatureElement;
import com.nokia.tools.vct.confml.model.confml1.EFeatureRfs;
import com.nokia.tools.vct.confml.model.confml1.EGroup;
import com.nokia.tools.vct.confml.model.confml1.ESettingData;
import com.nokia.tools.vct.confml.model.confml1.ESettingElement;
import com.nokia.tools.vct.confml.model.confml1.ESettingRfs;
import com.nokia.tools.vct.confml.model.confml1.util.CustomConfML1Handler;
import com.nokia.tools.vct.crml.crmodel.EAccess;
import com.nokia.tools.vct.crml.crmodel.EBit;
import com.nokia.tools.vct.crml.crmodel.ECRMLDocumentRoot;
import com.nokia.tools.vct.crml.crmodel.EKey;
import com.nokia.tools.vct.crml.crmodel.EKeyRange;
import com.nokia.tools.vct.crml.crmodel.EMeta;
import com.nokia.tools.vct.crml.crmodel.ERepository;
import com.nokia.tools.vct.crml.crmodel.EValue;
import com.nokia.tools.vct.crml.crmodel.util.CustomCRMLHandler;

public class Builder extends IncrementalProjectBuilder {
	private static final Path PATH_METADATA = new Path(".metadata");
	public static final String CONFML_BUILDER_ID = "com.nokia.tools.carbide.builder.confml";
	private static final String VALIDATORS_EXTENSION_POINT = "com.nokia.tools.carbide.validation";
	private static final String VALIDATORS = "validator";
	private static final String VALIDATOR_SCHEMA = "schema_uri";
	private static final String VALIDATOR_NAME = "name";
	private static final String VALIDATOR_EXTENSION = "file_extension";

	private static final URIHandler[] DEFAULT_HANDLERS = { new PlatformResourceURIHandlerImpl() };

	static class ValidationCategory {
		String markerId;
		String categoryId;
		String emfCategory;

		public ValidationCategory(String markerId, String categoryId,
				String emfCategory) {
			this.markerId = markerId;
			this.categoryId = categoryId;
			this.emfCategory = emfCategory;
		}
	}

	static class ValidatorRecord {
		String name;
		Schema schema;
		String extension;

		List<ValidationCategory> categories = new ArrayList<ValidationCategory>();

		public ValidatorRecord(String name, Schema schema, String extension) {
			this.name = name;
			this.schema = schema;
			this.extension = extension;
		}
	}

	private List<ValidatorRecord> extValidators = new ArrayList<ValidatorRecord>();

	/** All project resources, contained in CONFML and IMPLML folders */
	private ValidationResourceSet projectResources;

	private static final Set<String> SUPPORTED_EXT;
	static {
		Set<String> tmp = new HashSet<String>();
		tmp.add("confml");
		tmp.add("crml");
		tmp.add("ibyml");
		tmp.add("gcfml");
		SUPPORTED_EXT = Collections.unmodifiableSet(tmp);
	}

	public Builder() {
		projectResources = new ValidationResourceSet();
		URIConverter uriConverter = new ExtensibleURIConverterImpl(Arrays
				.asList(DEFAULT_HANDLERS), ContentHandler.Registry.INSTANCE
				.contentHandlers());
		projectResources.setURIConverter(uriConverter);

		parseExtensionMetadata();
	}



	@SuppressWarnings("unchecked")
	@Override
	protected IProject[] build(final int kind, Map args,
			IProgressMonitor monitor) throws CoreException {

		projectResources.setConfigurationProject(getProject());

		IWorkspaceRunnable runnable = new IWorkspaceRunnable() {
			public void run(IProgressMonitor monitor) throws CoreException {
				if (kind == FULL_BUILD) {
					fullBuild(monitor);
				} else {
					IResourceDelta delta = getDelta(getProject());
					if (delta == null) {
						fullBuild(monitor);
					} else {
						incrementalBuild(delta, monitor);
					}
				}
			}
		};
		ResourcesPlugin.getWorkspace().run(runnable, getProject(),
				IWorkspace.AVOID_UPDATE, monitor);
		return null;
	}

	protected void fullBuild(IProgressMonitor monitor) throws CoreException {
		deleteMarkers(getProject());
		final List<IFile> resources = new ArrayList<IFile>();
		IResourceVisitor visitor = new IResourceVisitor() {
			public boolean visit(IResource resource) throws CoreException {
				if (resource instanceof IFile) {
					IFile file = (IFile) resource;
					if (buildSupported(file)) {
						resources.add(file);
					}
				}
				return true;
			}
		};
		
		//validateResourceSet(null);
		
		getProject().accept(visitor);
		for (IFile file : resources) {
			if (file.isAccessible()) {
				buildResource(file);
			}
		}
		validateResourceSet(null);
	}

	protected void incrementalBuild(IResourceDelta delta,
			IProgressMonitor monitor) throws CoreException {
		final List<IFile> resources = new ArrayList<IFile>();
		IResourceDeltaVisitor visitor = new IResourceDeltaVisitor() {
			public boolean visit(IResourceDelta delta) throws CoreException {
				IResource resource = delta.getResource();
				if (resource instanceof IFile) {
					IFile file = (IFile) resource;
					if (buildSupported(file)) {
						resources.add(file);
					}
				}
				return true;
			}
		};
		delta.accept(visitor);
		for (IFile file : resources) {
			if (file.isAccessible()) {
				deleteMarkers(file);
				URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
				Resource resource = projectResources.getResource(uri, false);
				
				if (resource != null) {
					resource.unload();
					projectResources.getResources().remove(resource);
				}
				buildResource(file);
				
				
			} else {
				URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
				Resource resource = projectResources.getResource(uri, false);
				if (resource != null) {
					resource.unload();
					projectResources.getResources().remove(resource);
				}
			}
			
		}
		validateResourceSet(resources);
	}

	protected void validateResourceSet(List<IFile> resources) throws CoreException {
		IBatchValidator validator = (IBatchValidator) ModelValidationService
				.getInstance().newValidator(EvaluationMode.BATCH);
		List<EObject> objects = new ArrayList<EObject>();
		
		if (resources==null)
		{
			for (Resource r : projectResources.getResources()) {
				objects.addAll(r.getContents());
			}
		}
		else
		{
			for (IFile file : resources) 
			{
				if (file.isAccessible()) {
					URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
					Resource resource = projectResources.getResource(uri, false);
					if(resource!=null) {
						objects.addAll(resource.getContents());						
					}
				}
			}
		}

		IStatus status = validator.validate(objects);

		final int severityMask = IStatus.CANCEL | IStatus.ERROR | IStatus.INFO
				| IStatus.WARNING;
		MarkerUtil.createMarkers(status, severityMask,
				ConfmlMarkerUtils.CONFML_PROBLEM_MARKER,
				new IMarkerConfigurator() {
					public void appendMarkerConfiguration(IMarker marker,
							IConstraintStatus status) throws CoreException 
					{
						IModelConstraint constraint = status.getConstraint();
						IConstraintDescriptor descriptor = constraint
								.getDescriptor();
						Category first = descriptor.getCategories().iterator()
								.next();
						String id = first.getPath();
						marker.setAttribute(ConfmlMarkerUtils.CATEGORY_ID, id);
						marker.setAttribute(ConfmlMarkerUtils.PROBLEM_ID,
								descriptor.getId());

						boolean isCRML = false;
						
						EObject target = status.getTarget();
						List<String> segs = new ArrayList<String>();
						if (target instanceof EFeatureData || target instanceof ESettingData) {
							while (target instanceof ESettingData) {
								segs.add(((ESettingData)target).getRef());
								target = target.eContainer();
							}
							while (target instanceof EFeatureData) {
								segs.add(((EFeatureData)target).getRef());
								target = target.eContainer();
							}
							//segs.add("data");
						} else if (target instanceof EFeatureElement || target instanceof ESettingElement) {
							while (target instanceof ESettingElement) {
								segs.add(((ESettingElement)target).getRef());
								target = target.eContainer();
							}
							while (target instanceof EFeatureElement) {
								segs.add(((EFeatureElement)target).getRef());
								target = target.eContainer();
							}
//							if (target instanceof EGroup) {
//								segs.add("view");
//							} 
//							else {
//								segs.add("type");
//							}
						} else if (target instanceof EFeatureRfs || target instanceof ESettingRfs) {
							while (target instanceof ESettingRfs) {
								segs.add(((ESettingRfs)target).getRef());
								target = target.eContainer();
							}
							while (target instanceof EFeatureRfs) {
								segs.add(((EFeatureRfs)target).getRef());
								target = target.eContainer();
							}
							//segs.add("rfs");
						}
						
						else if (target instanceof com.nokia.tools.vct.confml.model.confml2.EFeatureData || target instanceof com.nokia.tools.vct.confml.model.confml2.ESettingData) {
							while (target instanceof com.nokia.tools.vct.confml.model.confml2.ESettingData) {
								segs.add(((com.nokia.tools.vct.confml.model.confml2.ESettingData)target).getRef());
								target = target.eContainer();
							}
							while (target instanceof com.nokia.tools.vct.confml.model.confml2.EFeatureData) {
								segs.add(((com.nokia.tools.vct.confml.model.confml2.EFeatureData)target).getRef());
								target = target.eContainer();
							}
							//segs.add("data");
						} else if (target instanceof com.nokia.tools.vct.confml.model.confml2.EFeatureElement || target instanceof com.nokia.tools.vct.confml.model.confml2.ESettingElement) {
							while (target instanceof com.nokia.tools.vct.confml.model.confml2.ESettingElement) {
								segs.add(((com.nokia.tools.vct.confml.model.confml2.ESettingElement)target).getRef());
								target = target.eContainer();
							}
							while (target instanceof com.nokia.tools.vct.confml.model.confml2.EFeatureElement) {
								segs.add(((com.nokia.tools.vct.confml.model.confml2.EFeatureElement)target).getRef());
								target = target.eContainer();
							}
//							if (target instanceof com.nokia.tools.vct.confml.model.confml2.EGroup) {
//								segs.add("view");
//							} 
//							else {
//								segs.add("type");
//							}
						} else if (target instanceof com.nokia.tools.vct.confml.model.confml2.EFeatureRfs || target instanceof com.nokia.tools.vct.confml.model.confml2.ESettingRfs) {
							while (target instanceof com.nokia.tools.vct.confml.model.confml2.ESettingRfs) {
								segs.add(((com.nokia.tools.vct.confml.model.confml2.ESettingRfs)target).getRef());
								target = target.eContainer();
							}
							while (target instanceof com.nokia.tools.vct.confml.model.confml2.EFeatureRfs) {
								segs.add(((com.nokia.tools.vct.confml.model.confml2.EFeatureRfs)target).getRef());
								target = target.eContainer();
							}
							//segs.add("rfs");
						}
						
						else if (target instanceof ERepository)
						{
							segs.add(((ERepository)target).getUidName());
							isCRML = true;
						}
						else if (target instanceof EKey)
						{
							segs.add(((EKey)target).getRef());
							isCRML = true;
						}
						else if (target instanceof EAccess)
						{
							EObject container = target.eContainer();
							if (container instanceof EKey)
							{
								segs.add(((EKey)container).getRef());
							}
							else if (container instanceof ERepository)
							{
								segs.add(((ERepository)container).getUidName());
							}
							else if (container instanceof EKeyRange)
							{
								segs.add(((EKeyRange)container).getRef());
							}
							isCRML = true;
						}
						else if (target instanceof EKeyRange)
						{
							segs.add(((EKeyRange)target).getRef());
							isCRML = true;
						}
						else if (target instanceof ECRMLDocumentRoot)
						{
							segs.add(((ECRMLDocumentRoot)target).getRepository().getUidName());
							isCRML = true;
						}
						else if (target instanceof EBit)
						{
							segs.add(((EBit)target).getRef());
							isCRML = true;
						}
//						else if (target instanceof EMeta)  //maybe not needed?
//						{
//							isCRML = true;
//						}
//						else if (target instanceof EValue)
//						{
//							isCRML = true;
//						}
						
						Collections.reverse(segs);
						
						//OLD location
						StringBuilder tmp = new StringBuilder();
						for (int i = 0; i < segs.size(); i++) {
							tmp.append(segs.get(i));
							if (i < segs.size()-1)
								tmp.append("/");
						}
						marker.setAttribute("ref", tmp.toString());
						
						
						target = status.getTarget();
						
						//NEW location as line number
						int line = 0;
						
						if (isCRML)
						{
							//marker.setAttribute(IMarker.MARKER, "CRML");
							line = CustomCRMLHandler.getStartLine(target);
						}
						else
							line = CustomConfML1Handler.getStartLine(target);
						
						if (tmp.toString().equals(""))
							marker.setAttribute(IMarker.LOCATION, "Line: "+line);
						else
							marker.setAttribute(IMarker.LOCATION, tmp.toString());
						
						marker.setAttribute(IMarker.LINE_NUMBER, line);

						String fragment = target.eResource().getURIFragment(target);
						marker.setAttribute("objectUri", fragment);
					}
				});

	}

	protected boolean buildSupported(IFile file) {
		if (file.getProjectRelativePath().equals(PATH_METADATA)) {
			return true;
		} else {
			return SUPPORTED_EXT.contains(file.getFileExtension());
		}
	}

	/**
	 * Simple method for delegating ConfML content validation to WST validation
	 * framework
	 * 
	 * The method actually overrides the default marker generation to support
	 * own problem type categorization.
	 */
	protected void buildResource(final IFile file) throws CoreException {

		final Stack<LocationCoordinate> coordinates = new Stack<LocationCoordinate>();

		XMLParserConfiguration configuration = new XIncludeAwareParserConfiguration();
		configuration.setErrorHandler(new XMLErrorHandler() {
			public void error(String arg0, String arg1, XMLParseException arg2)
					throws XNIException {
				
				System.out
						.println("Error: " + arg0 + " " + arg1 + " : " + arg2);
			}

			public void fatalError(String arg0, String arg1,
					XMLParseException arg2) throws XNIException {
				

				System.out.println("Fatal Error: " + arg0 + " " + arg1 + " "
						+ arg2);
			}

			public void warning(String arg0, String arg1, XMLParseException arg2)
					throws XNIException {
				
				System.out
						.println("Warning: " + arg0 + " " + arg1 + " " + arg2);

			}
		});
		configuration.setFeature("http://apache.org/xml/features/xinclude",
				Boolean.FALSE);
		SAXParser reader = new SAXParser(configuration) {
			private XMLLocator locator = null;

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.apache.xerces.parsers.AbstractSAXParser#startDocument(org
			 * .apache.xerces.xni.XMLLocator, java.lang.String,
			 * org.apache.xerces.xni.NamespaceContext,
			 * org.apache.xerces.xni.Augmentations)
			 */
			public void startDocument(
					org.apache.xerces.xni.XMLLocator theLocator,
					java.lang.String encoding, NamespaceContext nscontext,
					org.apache.xerces.xni.Augmentations augs) {
				locator = theLocator;
				super.startDocument(theLocator, encoding, nscontext, augs);
			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.apache.xerces.parsers.AbstractSAXParser#startElement(org.
			 * apache.xerces.xni.QName, org.apache.xerces.xni.XMLAttributes,
			 * org.apache.xerces.xni.Augmentations)
			 */
			public void startElement(QName arg0, XMLAttributes arg1,
					Augmentations arg2) throws XNIException {
				coordinates.add(new LocationCoordinate(locator.getLineNumber(),
						locator.getColumnNumber()));
				super.startElement(arg0, arg1, arg2);
			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.apache.xerces.parsers.AbstractSAXParser#endElement(org.apache
			 * .xerces.xni.QName, org.apache.xerces.xni.Augmentations)
			 */
			public void endElement(QName arg0, Augmentations arg1)
					throws XNIException {
				super.endElement(arg0, arg1);
				coordinates.pop();
			}
		};
		ValidatorRecord validatorRecord = null;

		try {
			reader
					.setFeature(
							"http://apache.org/xml/features/continue-after-fatal-error", true); //$NON-NLS-1$
			reader.setFeature(
					"http://xml.org/sax/features/namespace-prefixes", true); //$NON-NLS-1$
			reader.setFeature("http://xml.org/sax/features/namespaces", true); //$NON-NLS-1$
			reader.setFeature("http://xml.org/sax/features/validation", false); //$NON-NLS-1$
			reader.setFeature(
					"http://apache.org/xml/features/validation/schema", false); //$NON-NLS-1$
			// reader.setFeature(
			// "http://apache.org/xml/features/validation/schema-full-checking",
			// true);
			// reader.setProperty(
			// "http://apache.org/xml/properties/schema/external-noNamespaceSchemaLocation"
			// ,
			// "platform://schema");
			// reader.setFeature("http://apache.org/xml/features/xinclude", false); //$NON-NLS-1$      
			ValidatorHandler handler = null;
			for (ValidatorRecord record : extValidators) {
				if (record.extension.equals(file.getFileExtension())) {
					handler = record.schema.newValidatorHandler();
					validatorRecord = record;
					break;
				}
			}

			ErrorHandler errorHandler = new ErrorHandler() {
				public void error(SAXParseException exception)
						throws SAXException {
					report(exception, IMarker.SEVERITY_ERROR);
				}

				public void fatalError(SAXParseException exception)
						throws SAXException {
					report(exception, IMarker.SEVERITY_ERROR);
				}

				public void warning(SAXParseException exception)
						throws SAXException {
					report(exception, IMarker.SEVERITY_WARNING);
				}

				protected void report(SAXParseException ex, int sev) {
					try {
						IMarker marker = file
								.createMarker(ConfmlMarkerUtils.CONFML_PROBLEM_MARKER);
						marker.setAttributes(new String[] { IMarker.MESSAGE,
								IMarker.LOCATION, IMarker.SEVERITY,
								IMarker.LINE_NUMBER,
								ConfmlMarkerUtils.CATEGORY_ID }, new Object[] {
								ex.getMessage(), "Line: " + ex.getLineNumber(),
								sev, ex.getLineNumber(), "vct.confml/xml" });
					} catch (Exception ex1) {

					}

				}
			};

			if (handler == null) {
				System.out.println("Handler for "+file.getName() + " is not found");
				return;
			}
			handler.setErrorHandler(errorHandler);
			reader.setContentHandler(handler);

			// reader.setContentHandler(new DefaultHandler() {
			// public void startElement(String uri, String localName,
			// String qName, Attributes attributes)
			// throws SAXException {
			// // valinfo.getErrorCustomizationManager().startElement(uri,
			// // localName);
			// }
			//
			// public void endElement(String uri, String localName,
			// String qName) throws SAXException {
			// // valinfo.getErrorCustomizationManager().endElement(uri,
			// // localName);
			// }
			// });
			reader.setEntityResolver(new EntityResolver() {
				public InputSource resolveEntity(String publicId,
						String systemId) throws SAXException, IOException {
					System.out.println("resolve entity: " + publicId + "/ "
							+ systemId);

					return null;
				}
			});
			reader.setErrorHandler(errorHandler);

		} catch (Exception ex) {
			if (ex instanceof SAXParseException) {
				SAXParseException sax = (SAXParseException) ex;
				// System.err.println(""+ sax.getColumnNumber() +":"+
				// sax.getLineNumber()+ ":"+ sax.getSystemId());
				try {
					IMarker marker = file
							.createMarker(ConfmlMarkerUtils.CONFML_PROBLEM_MARKER);
					marker.setAttributes(
							new String[] { IMarker.MESSAGE, IMarker.LOCATION,
									IMarker.SEVERITY, IMarker.LINE_NUMBER,
									ConfmlMarkerUtils.CATEGORY_ID },
							new Object[] { sax.getMessage(),
									"Line: " + sax.getLineNumber(),
									IMarker.SEVERITY_ERROR,
									sax.getLineNumber(), "vct.confml/xml" });
				} catch (Exception ex1) {

				}
			}

			ex.printStackTrace();
		}

		URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(),
				true);
		XMLInputSource source = new XMLInputSource(null, uri.toString(), uri
				.toString(), file.getContents(), null);
		try {
			reader.parse(source);
		} catch (XNIException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		if (validatorRecord != null) {
			try {
				Resource res = projectResources.getResource(uri, true);
				res.load(null);

				for (Diagnostic d : res.getErrors()) {
					IMarker marker = file
							.createMarker(ConfmlMarkerUtils.CONFML_PROBLEM_MARKER);
					marker.setAttributes(
							new String[] { IMarker.MESSAGE, IMarker.LOCATION,
									IMarker.SEVERITY, IMarker.LINE_NUMBER,
									ConfmlMarkerUtils.CATEGORY_ID },
							new Object[] { d.getMessage(), d.getLocation(),
									IMarker.SEVERITY_ERROR, d.getLine(),
									"vct.confml/xml" });
				}
				for (Diagnostic d : res.getWarnings()) {
					IMarker marker = file
							.createMarker(ConfmlMarkerUtils.CONFML_PROBLEM_MARKER);
					marker.setAttributes(
							new String[] { IMarker.MESSAGE, IMarker.LOCATION,
									IMarker.SEVERITY, IMarker.LINE_NUMBER,
									ConfmlMarkerUtils.CATEGORY_ID },
							new Object[] { d.getMessage(), d.getLocation(),
									IMarker.SEVERITY_WARNING, d.getLine(),
									"vct.confml/xml" });
				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		// // kill the default XML markers
		// resource.deleteMarkers("org.eclipse.wst.xml.core.validationMarker",
		// false, IResource.DEPTH_INFINITE);

	}

	/**
	 * Delete all ConfML-related markers from the resource and it's descendants
	 * (if container).
	 */
	protected void deleteMarkers(IResource resource) throws CoreException {
		resource.deleteMarkers(ConfmlMarkerUtils.CONFML_PROBLEM_MARKER, true,
				IResource.DEPTH_INFINITE);
	}

	@Override
	protected void clean(IProgressMonitor monitor) throws CoreException {
		monitor.beginTask("Cleaning ConfML Build", 1);
		deleteMarkers(getProject());
		projectResources.getResources().clear();
		monitor.worked(1);
		monitor.done();
	}

	private void parseExtensionMetadata() {
		if (EMFPlugin.IS_ECLIPSE_RUNNING) {
			final IExtension[] extensions = Platform.getExtensionRegistry()
					.getExtensionPoint(VALIDATORS_EXTENSION_POINT)
					.getExtensions();
			for (int i = 0; i < extensions.length; i++) {
				final IConfigurationElement[] configElements = extensions[i]
						.getConfigurationElements();
				for (int j = 0; j < configElements.length; j++) {
					parseRule(configElements[j]);
				}
			}
		}
	}

	private void parseRule(IConfigurationElement configurationElement) {
		if (!configurationElement.getName().equals(VALIDATORS)) {
			return;
		} else {
			try {
				String name = configurationElement.getAttribute(VALIDATOR_NAME);
				String schemaLocation = configurationElement
						.getAttribute(VALIDATOR_SCHEMA);
				String extension = configurationElement
						.getAttribute(VALIDATOR_EXTENSION);
				String schemaContributor = configurationElement
						.getContributor().getName();

				SchemaFactory factory = SchemaFactory
						.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
				Bundle bundle = ValidationCorePlugin.getDefault().getBundle();
				BundleContext context = bundle.getBundleContext();
				for (Bundle b : context.getBundles()) {
					if (b.getSymbolicName().equals(schemaContributor)) {
						bundle = b;
						break;
					}
				}

				URL entry = bundle.getResource(schemaLocation);
				Schema schema = factory.newSchema(entry);

				ValidatorRecord record = new ValidatorRecord(name, schema,
						extension);

				extValidators.add(record);
			} catch (Exception e) {
				ValidationCorePlugin.logError(
						"Failed to activate validation extension", e);
			}
		}
	}

 
}
