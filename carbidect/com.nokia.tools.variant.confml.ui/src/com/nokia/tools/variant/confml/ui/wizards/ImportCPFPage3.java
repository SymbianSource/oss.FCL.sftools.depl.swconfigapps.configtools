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

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.spec.SecretKeySpec;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.layout.TreeColumnLayout;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.TreeColumn;
import org.w3c.dom.Document;

import com.nokia.tools.variant.confml.ui.ConfmlUI;
import com.nokia.tools.variant.confml.ui.IConfmlImages;
import com.nokia.tools.vct.common.appmodel.EConfMLLayer;
import com.nokia.tools.vct.common.appmodel.EConfigurationProject;
import com.nokia.tools.vct.common.appmodel.EStorageClass;
import com.nokia.tools.vct.common.appmodel.util.AppModelFactory;
import com.nokia.tools.vct.common.appmodel.util.CPFSigningUtils;
import com.nokia.tools.vct.common.appmodel.util.CPFUtil;
import com.nokia.tools.vct.common.appmodel.util.ICPFContentProvider;
import com.nokia.tools.vct.common.core.utils.FileUtils;
import com.nokia.tools.vct.common.secure.core.SigningStatus;
import com.nokia.tools.vct.common.secure.core.SigningUtils;

public class ImportCPFPage3 extends WizardPage {

	class ProjectContentsLabelProvider extends LabelProvider implements
			ITableLabelProvider {
		public Image getColumnImage(Object element, int columnIndex) {
			if (columnIndex != 0) {
				return null;
			}

			if (element instanceof EConfigurationProject) {
				return ConfmlUI.getImage(IConfmlImages.FLD_PROJECT);
			} else if (element instanceof EConfMLLayer) {
				return ConfmlUI.getImage(IConfmlImages.FLD_LAYER);
			} else {
				return null;
			}
		}

		public String getColumnText(Object element, int columnIndex) {
			if (columnIndex == 0) {
				if (element instanceof EConfigurationProject) {
					EConfigurationProject project = (EConfigurationProject) element;
					URI uri = project.getRootConfml();
					if (uri.isPlatform()) {
						IPath path = new Path(uri.toPlatformString(true))
								.removeFirstSegments(1);
						;
						return path.toString();
					} else {
						return uri.path();
					}

				} else if (element instanceof EConfMLLayer) {
					EConfMLLayer layer = (EConfMLLayer) element;
					URI uri = layer.getRootConfml();
					if (uri.isPlatform()) {
						IPath path = new Path(uri.toPlatformString(true))
								.removeFirstSegments(1);
						;
						return path.toString();
					} else {
						return uri.path();
					}
				} else {
					return null;
				}
			} else if (columnIndex == 1) {
				URI uri;
				SigningStatus status;
				if (element instanceof EConfigurationProject) {
					EConfigurationProject project = (EConfigurationProject) element;
					uri = CPFSigningUtils.getSignatureURI(project);
				} else if (element instanceof EConfMLLayer) {
					EConfMLLayer layer = (EConfMLLayer) element;
					uri = CPFSigningUtils.getSignatureURI(layer);
				} else {
					return null;
				}
				status = statusMap.get(uri);
				if (status == null) {
					return "error";
				} else if (!status.signatureFound) {
					return "unsigned";
				} else if (!status.contentOK) {
					return "modified";
				} else {
					return "signed";
				}
			} else if (columnIndex == 2) {
				URI uri;
				SigningStatus status;
				if (element instanceof EConfigurationProject) {
					EConfigurationProject project = (EConfigurationProject) element;
					uri = CPFSigningUtils.getSignatureURI(project);
				} else if (element instanceof EConfMLLayer) {
					EConfMLLayer layer = (EConfMLLayer) element;
					uri = CPFSigningUtils.getSignatureURI(layer);
				} else {
					return null;
				}
				status = statusMap.get(uri);
				if (status == null) {
					return null;
				} else if (status.certificate == null) {
					return "n/a";
				} else {
					return SigningUtils.getShortName(status.certificate);
				}
			} else {
				return null;
			}
		}
	}

	static final String PAGE_NAME = ImportCPFPage3.class.getName();

	private TreeViewer viewer;
	private List<EConfigurationProject> projects = new ArrayList<EConfigurationProject>();
	private Map<URI, Document> signatures = new LinkedHashMap<URI, Document>();
	private Map<URI, SigningStatus> statusMap = new LinkedHashMap<URI, SigningStatus>();
	private Map<URI, byte[]> digestMap = new LinkedHashMap<URI, byte[]>();
	private List<URI> resources = new ArrayList<URI>();

	public ImportCPFPage3() {
		super(PAGE_NAME);

		setTitle("CPF Contents Information");
	}

	public void createControl(Composite parent) {
		Composite control = new Composite(parent, SWT.NONE);
		TreeColumnLayout layout = new TreeColumnLayout();
		control.setLayout(layout);

		viewer = new TreeViewer(control, SWT.FULL_SELECTION | SWT.BORDER);
		viewer.getTree().setHeaderVisible(true);
		TreeColumn column1 = new TreeColumn(viewer.getTree(), SWT.LEFT);
		TreeColumn column2 = new TreeColumn(viewer.getTree(), SWT.LEFT);
		TreeColumn column3 = new TreeColumn(viewer.getTree(), SWT.LEFT);
		column1.setText("Element");
		column2.setText("State");
		column3.setText("Certificate");
		layout.setColumnData(column1, new ColumnWeightData(15, 200));
		layout.setColumnData(column2, new ColumnWeightData(5, 60));
		layout.setColumnData(column3, new ColumnWeightData(10, 150));

		viewer.setLabelProvider(new ProjectContentsLabelProvider());
		viewer
				.setContentProvider(new ExportCPFPage1.ProjectContentsContentProvider());
		viewer.setInput(projects);

		setControl(control);
	}

	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		ImportCPFPage1 page1 = (ImportCPFPage1) getWizard().getPage(
				ImportCPFPage1.PAGE_ID);
		final ICPFContentProvider contentProvider = page1.getContentProvider();
		
		if (visible) {
			Display.getCurrent().asyncExec(new Runnable() {
				public void run() {

					resources.clear();
					projects.clear();
					signatures.clear();
					digestMap.clear();
					statusMap.clear();
					viewer.refresh();

					IRunnableWithProgress scan = new IRunnableWithProgress() {
						public void run(IProgressMonitor monitor)
								throws InvocationTargetException,
								InterruptedException {
							scan(monitor, contentProvider);
						}
					};
					try {
						getContainer().run(false, false, scan);
					} catch (Exception e) {
						// IMPROVEMENT Auto-generated catch block
						e.printStackTrace();
					}
					viewer.refresh();
				}
			});
		}
	}

	protected ZipInputStream openStream(File source,
			EStorageClass storageClass, Cipher cipher) throws IOException {
		InputStream is = new BufferedInputStream(new FileInputStream(source));

		switch (storageClass) {
		case PKZIP:
			return new ZipInputStream(is);
		case ENCRYPTED:
			DataInputStream dis = new DataInputStream(is);
			dis.skip(2);
			int len = dis.readInt();
			dis.skip(len - 4);
			is = new CipherInputStream(dis, cipher);
			return new ZipInputStream(is);
		default:
			throw new IOException();
		}
	}

	Cipher createCipher(String algorithm, SecretKeySpec keySpec) {
		Cipher cipher = null;
		try {
			cipher = Cipher.getInstance(algorithm);
			cipher.init(Cipher.DECRYPT_MODE, keySpec);
		} catch (Exception e) {
			// IMPROVEMENT Auto-generated catch block
			e.printStackTrace();
		}
		return cipher;
	}
	
	void scan(IProgressMonitor monitor, ICPFContentProvider contentProvider) {

		ZipInputStream zis;
		try {

			monitor.beginTask("Scanning contents", 1500);

			List<URI> roots = new ArrayList<URI>();
			ResourceSet resourceSet = CPFUtil.createCPFResourceSet(contentProvider);

			zis = CPFUtil.openCPFStream(contentProvider);
			try {
				prepare(new SubProgressMonitor(monitor, 500), zis, resourceSet,
						roots);
			} finally {
				FileUtils.closeStream(zis);
			}
			zis = CPFUtil.openCPFStream(contentProvider);
			try {
				finalize(new SubProgressMonitor(monitor, 500), resourceSet,
						roots);
			} finally {
				FileUtils.closeStream(zis);
			}
			zis = CPFUtil.openCPFStream(contentProvider);
			try {
				validate(new SubProgressMonitor(monitor, 500), resourceSet);
			} finally {
				FileUtils.closeStream(zis);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return;
		} catch (Error e) {
			e.printStackTrace();
			return;
		} finally {
			monitor.done();
		}
	}

	class HashProvider implements SigningUtils.IDigestVerifyer {

		private URI base;

		public HashProvider(URI base) {
			this.base = base;
		}

		public boolean isDigestCorrect(URI uri, byte[] digest) {
			URI resolved = uri.resolve(base);

			byte[] calculated = digestMap.get(resolved);
			if (calculated == null) {
				// missing digest
				return false;
			}
			boolean match = Arrays.equals(calculated, digest);
			return match;
		}
	}

	private void validate(IProgressMonitor monitor, ResourceSet resourceSet) {
		monitor.beginTask("Validating signatures", 10 * projects.size());

		URI baseURI = com.nokia.tools.vct.common.appmodel.util.CPFUtil.CPF_BASE_URI;
		
		for (EConfigurationProject project : projects) {
			URI signatureURI = CPFSigningUtils.getSignatureURI(project);
			Document document = signatures.get(signatureURI);

			// the content is in "/xxx.confml" form
			URI content = project.getRootConfml().deresolve(baseURI);
			content = URI.createURI(content.toString().substring(1));
			
			SigningStatus status = SigningUtils
					.getSigningStatus(
							document,
							new HashProvider(
									com.nokia.tools.vct.common.appmodel.util.CPFUtil.CPF_BASE_URI),
							Collections.singleton(content));
			statusMap.put(signatureURI, status);

			for (EConfMLLayer layer : project.getLayers()) {
				Set<URI> copy = new HashSet<URI>();
				for (URI next: layer.getLayerFiles()) {
					if ("sign".equals(next.fileExtension())) {
						continue;
					} else if (next.lastSegment().length() == 0) {
						continue;
					}
					URI uri = next.deresolve(layer.getLayerURI());
					copy.add(uri);
				}
				signatureURI = CPFSigningUtils.getSignatureURI(layer);
				document = signatures.get(signatureURI);
				status = SigningUtils.getSigningStatus(document,
						new HashProvider(layer.getLayerURI()), copy);
				statusMap.put(signatureURI, status);
			}

			monitor.worked(10);
		}

		monitor.done();
	}

	private void finalize(IProgressMonitor monitor, ResourceSet resourceSet,
			List<URI> roots) {
		monitor.beginTask("Generating models", 100 * roots.size());

		for (URI next : roots) {
			EConfigurationProject project;
			try {
				project = new AppModelFactory().populateProject(
						new SubProgressMonitor(monitor, 100), resourceSet,
						next, resources);
			} catch (InterruptedException e) {
				e.printStackTrace();
				continue;
			}
			projects.add(project);
		}
		monitor.done();
	}

	private void prepare(IProgressMonitor monitor, ZipInputStream zis,
			ResourceSet resourceSet, List<URI> roots) throws IOException,
			Exception {
		monitor.beginTask("Preloading contents & computing digests", 100);

		int totalWork = 100;
		int currentIncrement = 4;
		int halfWay = totalWork / 2;
		int nextProgress = currentIncrement;
		int worked = 0;

		for (ZipEntry entry = zis.getNextEntry(); entry != null; entry = zis
				.getNextEntry()) {
			Path path = new Path(entry.getName());
			String[] segments = path.segments();
			for (int i = 0; i < segments.length; i++) {
				segments[i] = URI.encodeSegment(segments[i], false);
			}
			
			URI entryURI = URI.createHierarchicalURI(segments, null, null).resolve(
					CPFUtil.CPF_BASE_URI);
			if (entry.isDirectory()) {
				entryURI = entryURI.appendSegment("");
			}
			
			resources.add(entryURI);

			if (!entry.isDirectory()) {
				MessageDigest digest = MessageDigest.getInstance("SHA");
				DigestInputStream disStream = new DigestInputStream(zis, digest) {
					byte[] buffer = new byte[1024];

					@Override
					public long skip(long n) throws IOException {
						long result = 0;
						while (n > 0) {
							int toSkip = (int) Math.min(buffer.length,
									n);
							int res = read(buffer, 0, toSkip);
							if (res >= 0) {
								n -= res;
								result += res;
							} else {
								break;
							}
						}
						return result;
					}

					@Override
					public void close() throws IOException {
					}
					
				};
				FilterInputStream noCloseStream = new FilterInputStream(
						disStream) {
					@Override
					public void close() throws IOException {
					}
				};

				if ("confml".equals(entryURI.fileExtension())) {

					Resource resource = resourceSet.createResource(entryURI);
					resource.load(noCloseStream, null);
					resourceSet.getResources().add(resource);

					if (entryURI.segmentCount() == 1) {
						// root confml
						roots.add(entryURI);
					}

				} else if ("sign".equals(entryURI.fileExtension())) {
					Document doc = SigningUtils
							.unmarshalSignature(noCloseStream);
					signatures.put(entryURI, doc);
				}

				noCloseStream.skip(Integer.MAX_VALUE);

				byte[] data = digest.digest();
				digestMap.put(entryURI, data);
			}

			if (--nextProgress <= 0) {
				monitor.worked(1);
				worked++;
				if (worked >= halfWay) {
					currentIncrement *= 2;
					halfWay += (totalWork - halfWay) / 2;
				}
				nextProgress = currentIncrement;
			}

			zis.closeEntry();
		}

		monitor.done();
	}
}
