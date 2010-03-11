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
 * Description: This file is part of com.nokia.tools.variant.resourcelibrary component.
 */

package com.nokia.tools.variant.resourcelibrary.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.BaseSelectionListenerAction;
import org.eclipse.ui.part.IContributedContentsView;
import org.eclipse.ui.part.IPageBookViewPage;

import com.nokia.tools.variant.common.core.utils.FileUtils;
import com.nokia.tools.variant.common.ui.utils.SWTUtil;
import com.nokia.tools.variant.content.confml.FilePath;
import com.nokia.tools.variant.content.confml.FileSystemEntrySetting;
import com.nokia.tools.variant.content.confml.Setting;
import com.nokia.tools.variant.content.confml.SimpleSetting;
import com.nokia.tools.variant.content.confml.TYPE;
import com.nokia.tools.variant.resourcelibrary.Activator;
import com.nokia.tools.variant.resourcelibrary.handlers.commands.ImportCommand;
import com.nokia.tools.variant.resourcelibrary.model.Directory;
import com.nokia.tools.variant.resourcelibrary.model.FileSystemElement;
import com.nokia.tools.variant.resourcelibrary.views.IResourceLibraryPage;
import com.nokia.tools.variant.resourcelibrary.views.ResourceStorage;

public class OpenEditorAction extends BaseSelectionListenerAction {
	private static final String PAUSE_DIALOG_TITLE = "External Editor Opened";
	private static final String PAUSE_MESSAGE = "Carbide.v has been paused for external editor to finish.\n\n"
			+ "Close this dialog when finished to refresh Resources.";
	private static final String PAUSE_MESSAGE_READ_ONLY = "Carbide.v has been paused for external editor to finish.\n\n"
			+ "Since the file is read-only, your changes will NOT be applied.";

	public static final String PROMPT_VIEWER_KEY = "com.nokia.tools.variant.resourcelibrary.promptExternalViewer";

	private IResourceLibraryPage page;
	private boolean openAs;

	public OpenEditorAction(IResourceLibraryPage page, boolean openAs) {
		super(openAs ? "Open With" : "Open");
		// setImageDescriptor(Activator.getImageDescriptor(
		// "icons/wordassist_co.gif"));
		this.page = page;
		this.openAs = openAs;
	}

	@Override
	protected boolean updateSelection(IStructuredSelection selection) {
		if (selection.size() != 1) {
			return false;
		}

		FileSystemElement fse = ((ResourceStorage) selection.getFirstElement())
				.getFileSystemElement();
		if (fse instanceof Directory) {
			return false;
		}

		return true;
	}

	@Override
	public void run() {
		IStructuredSelection sel = getStructuredSelection();

		ResourceStorage file = (ResourceStorage) sel.getFirstElement();
		FileSystemElement fileSystemElement = file.getFileSystemElement();
		if (!(fileSystemElement instanceof com.nokia.tools.variant.resourcelibrary.model.File)) {
			return;
		}
		final com.nokia.tools.variant.resourcelibrary.model.File fse = (com.nokia.tools.variant.resourcelibrary.model.File) fileSystemElement;

		File modelDir = new File(page.getResourceModelRoot().getTempDirPath());
		final File res = new File(modelDir, fse.getPath2().toOSString());

		final Shell sh = page.getControl().getShell();

		// Check whether or not prompt external viewer

		openExternalEditor(fse, res, openAs, sh);
	}

	static class CustomURIConverter extends ExtensibleURIConverterImpl {

		CommandStack commandStack;

		public CustomURIConverter(CommandStack stack) {
			this.commandStack = stack;
		}

		@Override
		public OutputStream createOutputStream(URI uri, Map<?, ?> options)
				throws IOException {
			// MARK CPFEDITOR as dirty to allow saving of the
			// resources which are changed by eclipse internal
			// editor even this editor is not changed
			SWTUtil.getStandardDisplay().asyncExec(new Runnable() {
				public void run() {
					commandStack.execute(new ResourceChangedCommand());
				}
			});

			return super.createOutputStream(uri, options);
		}
	}

	private void openExternalEditor(
			com.nokia.tools.variant.resourcelibrary.model.File file, File res,
			boolean promptViewer, Shell sh) {

		String path = res.getPath();
		if (res.getName().equals("appshelldata.xml") && !promptViewer) {
			URI uri = URI.createFileURI(res.getAbsolutePath());
			IEditorInput input = new URIEditorInput(uri) {
				@SuppressWarnings("unchecked")
				@Override
				public Object getAdapter(Class adapter) {
					if (adapter == URIConverter.class) {
						return new CustomURIConverter(page.getCommandStack());
					}

					return super.getAdapter(adapter);
				}
			};
			IEditorDescriptor descr = PlatformUI
					.getWorkbench()
					.getEditorRegistry()
					.findEditor(
							"com.nokia.tools.vct.appshell.appshellmodel.presentation.EAppshellModelEditorID");
			if (descr != null) {
				try {
					IContributedContentsView contrib = (IContributedContentsView) ((IAdaptable) page)
							.getAdapter(IContributedContentsView.class);
					IEditorPart activeCPFEditor = (IEditorPart) contrib
							.getContributingPart();

					IEditorPart openEditor = ((IPageBookViewPage) page)
							.getSite().getWorkbenchWindow().getActivePage()
							.openEditor(input, descr.getId());
					if (activeCPFEditor != null) {
						@SuppressWarnings("unchecked")
						List<Object> list = (List<Object>) activeCPFEditor
								.getAdapter(List.class);
						if (list != null) {
							list.add(openEditor);
						}

					}
				} catch (PartInitException e) {
					Activator.getDefault().getLog().log(
							new Status(IStatus.ERROR, Activator.PLUGIN_ID,
									"Editor open error", e));
				}
				// openConfirmFialogAfterEditing(file, sh, path, false);
				return;
			}
		}

		if (path != null) {
			try {
				String fileName = file.getName().replaceAll(" ", "");
				File tempDir = File.createTempFile("edit", null);
				tempDir.delete();
				tempDir.mkdir();
				tempDir.deleteOnExit();
				File tempContent = new File(tempDir, fileName);
				tempContent.deleteOnExit();
				if ("html".equalsIgnoreCase(FileUtils.getExtension(res))
						|| "htm".equalsIgnoreCase(FileUtils.getExtension(res))) {
					File parentFolder = res.getParentFile();
					File[] listFiles = parentFolder.listFiles();
					for (File childFile : listFiles) {
						copyFiles(childFile, tempDir);
					}
				} else {
					InputStream is = new FileInputStream(res);
					OutputStream os = new FileOutputStream(tempContent);
					FileUtils.copyStream(is, os);
					FileUtils.closeStream(is);
					FileUtils.closeStream(os);
				}

				if (promptViewer)
					Runtime.getRuntime().exec(
							"rundll32 SHELL32.DLL,OpenAs_RunDLL "
									+ tempContent.getCanonicalPath());
				else
					Runtime.getRuntime().exec(
					// previous solution
							// "rundll32 SHELL32.DLL,ShellExec_RunDLL " +
							// tempContent.toURI());
							"cmd /c start " + tempContent.getAbsolutePath());

				EList<Setting> settings = file.getSettings();
				Boolean readonly = false;
				for (Setting setting : settings) {
					if (isIsItFileSettingWithReadOnlyLocalPath(setting)) {
						readonly = true;
						break;
					}
				}
				openConfirmDialogAfterEditing(file, res, tempContent, sh, file
						.getPath2().toPortableString(), true, readonly);
			} catch (IOException e) {
				e.printStackTrace();
				// If RunDLL32 fails, it should display an error of its own. Do
				// nothing.
			}/*
			 * catch (CoreException e) { MessageBox messageBox = new
			 * MessageBox(sh, SWT.ICON_ERROR);
			 * messageBox.setMessage(REFRESH_CHANGED_RESOURCE_ERROR);
			 * messageBox.open(); }
			 */
		}
	}

	private void copyFiles(File fileToCopy, File destDirectory)
			throws IOException, FileNotFoundException {
		if (fileToCopy.isDirectory()) {
			destDirectory = new File(destDirectory, fileToCopy.getName());
			destDirectory.mkdir();
			destDirectory.deleteOnExit();
			File[] listFilesInDir = fileToCopy.listFiles();
			for (File file : listFilesInDir) {
				copyFiles(file, destDirectory);
			}
		} else {
			File tempContent = new File(destDirectory, fileToCopy.getName());
			tempContent.deleteOnExit();
			InputStream is = new FileInputStream(fileToCopy);
			OutputStream os = new FileOutputStream(tempContent);
			FileUtils.copyStream(is, os);
			FileUtils.closeStream(is);
			FileUtils.closeStream(os);
		}
	}

	public static boolean isIsItFileSettingWithReadOnlyLocalPath(Setting s) {
		if (s instanceof SimpleSetting) {
			SimpleSetting ss = (SimpleSetting) s;
			if (ss.getType().ordinal() == TYPE.FILE_VALUE
					|| ss.getType().ordinal() == TYPE.FOLDER_VALUE) {
				return !ss.isVisible();
			}
		} else if (s instanceof FileSystemEntrySetting) {
			FileSystemEntrySetting fses = (FileSystemEntrySetting) s;
			if (!fses.isVisible()) {
				return true;
			} else {
				FilePath sourceFilePath = fses.getSourceFilePath();
				if (!sourceFilePath.isVisible()) {
					return true;
				}
			}
		}
		return false;
	}

	private void openConfirmDialogAfterEditing(
			com.nokia.tools.variant.resourcelibrary.model.File file,
			File original, File tempContent, Shell sh, String fullPath,
			boolean modal, boolean readOnly) {
		// Create a modal dialog that will prompt the user to refresh
		// resource library once he's finished
		MessageBox promptRefresh = null;
		if (modal) {
			promptRefresh = new MessageBox(sh, SWT.ICON_INFORMATION);
		} else {
			promptRefresh = new MessageBox(sh, SWT.ICON_INFORMATION);
		}
		promptRefresh.setText(PAUSE_DIALOG_TITLE);
		if (readOnly) {
			promptRefresh.setMessage(PAUSE_MESSAGE_READ_ONLY);
		} else {
			promptRefresh.setMessage(PAUSE_MESSAGE);
		}
		int buttonID = promptRefresh.open();
		switch (buttonID) {
		case SWT.OK:
			if (FileUtils.compareByContent(original, tempContent)) {
				if (!tempContent.delete()) {
					MessageBox messageBox = new MessageBox(sh, SWT.ICON_WARNING
							| SWT.OK);
					messageBox.setText("Can not delete temporary file");
					messageBox
							.setMessage("Temporary file can not be deleted.\n\n"
									+ "If you have editor still opened and forgot to save the content,\n"
									+ "save it into new location and (re-)import into resource library");
					messageBox.open();
					tempContent.deleteOnExit();
				}
				tempContent.getParentFile().delete();
				return;
			}
			Command command = ImportCommand.createImportCommand(
					(Directory) file.eContainer(), tempContent, file.getName(),
					true);
			if (!readOnly && command.canExecute()) {
				command.setLabel("File Edit");
				page.getCommandStack().execute(command);
			} else {
				command.dispose();
			}

			return;
		}

	}

	/**
	 * Resource has been edited by external editor
	 * 
	 */
	private static class ResourceChangedCommand extends Command {
		public ResourceChangedCommand() {
			super("Resource Change");
		}

		@Override
		public boolean canUndo() {
			return false;
		}
	}

}
