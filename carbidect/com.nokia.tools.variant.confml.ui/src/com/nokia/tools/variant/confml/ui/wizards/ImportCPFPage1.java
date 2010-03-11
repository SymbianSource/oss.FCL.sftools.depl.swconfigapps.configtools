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

import java.io.File;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;

import com.nokia.tools.vct.common.appmodel.EStorageClass;
import com.nokia.tools.vct.common.appmodel.util.CPFEncryptionUtils;
import com.nokia.tools.vct.common.appmodel.util.CPFUtil;
import com.nokia.tools.vct.common.appmodel.util.ICPFContentProvider;
import com.nokia.tools.vct.common.appmodel.util.ISecureCPFContentProvider;
import com.nokia.tools.vct.common.secure.core.IKeyStoreEntry;
import com.nokia.tools.vct.common.secure.core.IKeyStoreManager;
import com.nokia.tools.vct.common.secure.core.SecurityCorePlugin;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.DialogField;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.IDialogFieldListener;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.IStringButtonAdapter;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.LayoutUtil;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.StringButtonDialogField;
import com.nokia.tools.vct.common.ui.wizards.dialogfields.StringDialogField;

public class ImportCPFPage1 extends WizardPage {

	static final String PAGE_ID = ImportCPFPage1.class.getName();
	
	private final class SecurityGroup extends Observable implements IDialogFieldListener {
		protected final StringDialogField contentEncrypted;
		protected final StringDialogField password;
		protected final StringDialogField contentSigned;

		Group group;
		
		public SecurityGroup() {
			contentEncrypted = new StringDialogField(SWT.BORDER | SWT.READ_ONLY);
			contentEncrypted.setLabelText("Encryption:");
			password = new StringDialogField(SWT.BORDER | SWT.PASSWORD);
			password.setLabelText("Password:");
			contentSigned = new StringDialogField(SWT.BORDER | SWT.READ_ONLY);
			contentSigned.setLabelText("Signatures:");
			password.setEnabled(false);
			password.setDialogFieldListener(this);
		}
		
		public void dialogFieldChanged(DialogField field) {
			setChanged();
			notifyObservers();
		}
		
		public Control createControl(Composite parent) {
			group = new Group(parent, SWT.NONE);
			group.setLayout(initGridLayout(new GridLayout(3, false),
					true));
			group.setText("Security Information");
			
			contentEncrypted.doFillIntoGrid(group, 3);
			password.doFillIntoGrid(group, 3);
			contentSigned.doFillIntoGrid(group, 3);

			LayoutUtil.setHorizontalGrabbing(contentEncrypted.getTextControl(group));
			LayoutUtil.setHorizontalGrabbing(password.getTextControl(group));
			LayoutUtil.setHorizontalGrabbing(contentSigned.getTextControl(group));
			
			return group;
		}
	}
	
	private final class SelectionGroup extends Observable implements
			IDialogFieldListener, IStringButtonAdapter {

		protected final StringButtonDialogField fileLocation;
		protected final StringDialogField projectName;


		public SelectionGroup() {
			fileLocation = new StringButtonDialogField(this);
			fileLocation.setDialogFieldListener(this);
			fileLocation.setLinkText("Source:");
			fileLocation.setButtonLabel("Browse...");
			projectName = new StringDialogField();
			projectName.setDialogFieldListener(this);
			projectName.setLabelText("Target Project:");
		}

		public Control createControl(Composite composite) {
			final int numColumns = 3;

			Group group = new Group(composite, SWT.NONE);
			group.setLayout(initGridLayout(new GridLayout(numColumns, false),
					true));
			group.setText("Import Objects");

			fileLocation.doFillIntoGrid(group, numColumns);
			projectName.doFillIntoGrid(group, numColumns);

			LayoutUtil.setHorizontalGrabbing(fileLocation.getTextControl(group));
			LayoutUtil.setHorizontalGrabbing(projectName.getTextControl(group));

			return group;
		}

		public void changeControlPressed(DialogField field) {
			if (field == fileLocation) {
				File f = new File(fileLocation.getText());
				if (!f.exists()) {
					f = null;
				}
				File d = getFile(f, new String[] { "CPF File (*.cpf)" },
						new String[] { "*.cpf" });
				if (d == null) {
					// fileLocation.setText("");
				} else {
					fileLocation.setText(d.getAbsolutePath());
					String name = d.getName();
					int idx = name.lastIndexOf('.');
					if (idx >= 0) {
						name = name.substring(0, idx);
					}
					projectName.setText(name);
				}
			} 
		}

		/**
		 * Helper to open the file chooser dialog.
		 * 
		 * @param startingDirectory
		 *            the directory to open the dialog on.
		 * @return File The File the user selected or <code>null</code> if they
		 *         do not.
		 */
		private File getFile(File startingDirectory, String[] names,
				String[] ext) {

			FileDialog dialog = new FileDialog(getShell(), SWT.OPEN);
			if (startingDirectory != null) {
				dialog.setFileName(startingDirectory.getPath());
			}
			dialog.setFilterExtensions(ext);
			dialog.setFilterNames(names);
			String file = dialog.open();
			if (file != null) {
				file = file.trim();
				if (file.length() > 0) {
					return new File(file);
				}
			}

			return null;
		}


		public void dialogFieldChanged(DialogField field) {
			
			File file = new File(fileLocation.getText().trim());
			updateImportList(file);

			fireEvent();
		}
		
		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.Observer#update(java.util.Observable,
		 * java.lang.Object)
		 */
		public void update(Observable o, Object arg) {
			fireEvent();
		}


		protected void fireEvent() {
			setChanged();
			notifyObservers();
		}

	}
	
	final class Validator implements Observer {
		public void update(Observable o, Object arg) {

			encryptionAlgorithm = null;
			keySize = 0;
			signaturesFound = false;
			contentProvider = null;
			users.clear();

			String contentEncrypted = "n/a";
			String contentSigned = "n/a";
			boolean securityEnabled = false;
			
			try {
			
			String path = selectionGroup.fileLocation.getText().trim();
			if (path.length() == 0) {
				setPageComplete(false);
				setErrorMessage("Source path: the value can not be empty");
				setMessage(null);
				return;
			}
			File file = new File(path);
			if (!file.isFile()) {
				setPageComplete(false);
				setErrorMessage("Source path: the resource does not exist");
				setMessage(null);
				return;
			}
			EStorageClass storageClass;
			
			try {
				storageClass = CPFUtil.detectStorageClass(file);
			} catch (IOException e) {
				setPageComplete(false);
				setErrorMessage("Source path: can not detect file format");
				setMessage(null);
				return;
			}
		
			path = selectionGroup.projectName.getText().trim();
			if (path.length() == 0) {
				setPageComplete(false);
				setErrorMessage("Project name: you must specify project name");
				setMessage(null);
				return;
			}
			if (ResourcesPlugin.getWorkspace().getRoot().getProject(path).exists()) {
				setPageComplete(false);
				setErrorMessage("Project name: the specified project already exists");
				setMessage(null);
				return;
			}
			
			switch (storageClass) {
			case ENCRYPTED:
				securityEnabled = true;
				try {
					ISecureCPFContentProvider tmp = CPFEncryptionUtils.createSecureContentProvider(file, null, null); 
					contentProvider = tmp;
					contentEncrypted = tmp.getBlockAlgorithm() + " " + tmp.getKeySize();
					users.addAll(Arrays.asList(tmp.getUserCertificates()));
				} catch (CoreException ex) {
					contentEncrypted = "n/a";
					setPageComplete(false);
					setErrorMessage("File format error");
					setMessage(null);
				}
				break;
			case PKZIP:
				encryptionAlgorithm = null;
				keySize = 0;
				contentEncrypted = "Unencrypted (Plain ZIP)";
				contentProvider = CPFUtil.selectCPFContentProvider(file);
				break;
			}
			PrivateKey key = null;
			X509Certificate certificate = null;

			if (contentProvider instanceof ISecureCPFContentProvider) {
				IKeyStoreManager manager = SecurityCorePlugin.getKeyStoreManager();
				IKeyStoreEntry entry = manager.getDefaultEntry();
				
				try {
					certificate = manager.getCertificate(entry);
					key = manager.getPrivateKey(entry, securityGroup.password.getText());
					securityGroup.password.setErrorMessage(null);
				} catch (Exception ex) {
					securityGroup.password.setErrorMessage("Password does not match");
					setPageComplete(false);
					setErrorMessage("Password is not correct");
					setMessage(null);
					return;
				}

				try {
					contentProvider = null;
					contentProvider = CPFEncryptionUtils.createSecureContentProvider(file, certificate, key);
				} catch (CoreException ex) {
					setPageComplete(true);
					setErrorMessage("Certificate mismatch");
					setMessage(null);
					return;
				}
				
			}
			
			if (contentProvider != null) {
				try {
					final AtomicBoolean found = new AtomicBoolean();
					IRunnableWithProgress sigTest = new IRunnableWithProgress() {
						public void run(IProgressMonitor monitor)
								throws InvocationTargetException,
								InterruptedException {
							monitor.beginTask("Signature test", 1000);
							try {
							ZipInputStream zis = CPFUtil.openCPFStream(contentProvider);
							for (ZipEntry entry = zis.getNextEntry(); ((entry = zis.getNextEntry()) != null);) {
								if (entry.getName().endsWith(".sign")) {
									found.set(true);
									break;
								}
							}
							} catch (Exception ex) {
								throw new InvocationTargetException(ex);
							} finally {
							monitor.done();
							}
						}
					};
					getContainer().run(true, false, sigTest);
					
					contentSigned = found.get() ? "Present" : "Unsigined";
				} catch (Exception ex) {
					ex.printStackTrace();
					contentSigned = "Data access error";
				}
			}
			
			
			setPageComplete(true);
			setErrorMessage(null);
			setMessage(null);
			return;
			} finally {
				securityGroup.group.setEnabled(securityEnabled);
				securityGroup.password.setEnabled(securityEnabled);
				securityGroup.contentEncrypted.setText(contentEncrypted);
				securityGroup.contentSigned.setText(contentSigned);
				
			}
		}

	
	}

	final SelectionGroup selectionGroup;
	final SecurityGroup securityGroup;
	final Validator validator;
	final List<String> validNames;
	
	String encryptionAlgorithm;
	int keySize;
	boolean signaturesFound;
	List<X509Certificate> users = new ArrayList<X509Certificate>();
	ICPFContentProvider contentProvider;
	
	public ImportCPFPage1() {
		super(PAGE_ID);
		setTitle("CPF Import Wizard"); // NON-NLS-1
		setDescription("Import CPF as a project set"); 
		selectionGroup = new SelectionGroup();
		securityGroup = new SecurityGroup();
		validator = new Validator();
		selectionGroup.addObserver(validator);
		securityGroup.addObserver(validator);
		validNames = new ArrayList<String>();
		setPageComplete(false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.dialogs.WizardNewFileCreationPage#createAdvancedControls
	 * (org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		initializeDialogUnits(parent);

		final Composite composite = new Composite(parent, SWT.NULL);
		composite.setFont(parent.getFont());
		composite.setLayout(initGridLayout(new GridLayout(1, false), true));
		composite.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));

		Control control;

		control = selectionGroup.createControl(composite);
		control.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

		control = securityGroup.createControl(composite);
		control.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

		setControl(composite);
	}

	private GridLayout initGridLayout(GridLayout layout, boolean margins) {
		layout.horizontalSpacing = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_SPACING);
		layout.verticalSpacing = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_SPACING);
		if (margins) {
			layout.marginWidth = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_MARGIN);
			layout.marginHeight = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_MARGIN);
		} else {
			layout.marginWidth = 0;
			layout.marginHeight = 0;
		}
		return layout;
	}

	public File getSourceFile() {
		return new File(selectionGroup.fileLocation.getText().trim());
	}

	static class NoCloseInputStream extends FilterInputStream {

		public NoCloseInputStream(InputStream in) {
			super(in);
		}
		
		@Override
		public void close() throws IOException {
		}
	}
	
	private void updateImportList(File file) {
		if (!file.exists() || !file.isFile()) {
			
			return;
		} else {
			return;
		}
		
//		try {
//			ZipInputStream zis = CPFUtil.openCPFStream(file);
//			
//			ZipEntry zipEntry;
//			
//			Resource rootConfml= null;
//			
//			while((zipEntry = zis.getNextEntry()) != null) {
//				if (zipEntry.isDirectory()) {
//					zis.closeEntry();
//					continue;
//				}
//				String name = zipEntry.getName();
//				URI entryURI = URI.createURI(name).resolve(CPFUtil.CPF_BASE_URI);
//				if (entryURI.segmentCount() == 1 && "confml".equals(entryURI.fileExtension())) {
//					rootConfml = new EConfML1ResourceFactoryImpl().createResource(entryURI);
//					rootConfml.load(new NoCloseInputStream(zis), null);
//					break;
//				}
//				if (rootConfml != null) {
//					// both CPF metadata and root confml are loaded
//					break;
//				}
//				zis.closeEntry();
//			}
//			FileUtils.closeStream(zis);
//			
//			List<URI> zips = new ArrayList<URI>();
//			if (rootConfml != null) {
//				TreeIterator<Object> it = EcoreUtil.getAllContents(rootConfml, false);
//				while (it.hasNext()) {
//					Object o = it.next();
//					if (o instanceof EInclude) {
//						EInclude include = (EInclude)o;
//						URI layerURI = URI.createURI(include.getHref());
//						layerURI = layerURI.resolve(rootConfml.getURI());
//						zips.add(layerURI);
//					}
//				}
//			}
//			
//			
//		} catch (Exception e) {
//			
//			e.printStackTrace();
//		}
	}
	
	public String getProjectName() {
		return selectionGroup.projectName.getText().trim();
	}

	public String getEncryptionAlgorithm() {
		return encryptionAlgorithm;
	}
	
	public int getKeySize() {
		return keySize;
	}
	
	public List<X509Certificate> getUsers() {
		return users;
	}

	public ICPFContentProvider getContentProvider() {
		return contentProvider;
	}
}
