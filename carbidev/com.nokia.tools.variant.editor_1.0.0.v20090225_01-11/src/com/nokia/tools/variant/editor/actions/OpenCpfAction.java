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
 * Description: This file is part of com.nokia.tools.variant.editor component.
 */

package com.nokia.tools.variant.editor.actions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.emf.edit.ui.util.EditUIUtil;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.XMLMemento;
import org.eclipse.ui.internal.EditorHistory;
import org.eclipse.ui.internal.EditorHistoryItem;
import org.eclipse.ui.internal.IWorkbenchConstants;
import org.eclipse.ui.internal.Workbench;
import org.eclipse.ui.internal.WorkbenchPlugin;

import com.nokia.tools.variant.editor.editors.CPFEditor;
import com.nokia.tools.variant.editor.editors.Messages;
import com.nokia.tools.variant.editor.utils.CPFManager;

/**
 * Action opens CPF file to CPF editor. Opening can fail on low memory.
 */
@SuppressWarnings("restriction")
public class OpenCpfAction implements IWorkbenchWindowActionDelegate {

	private IWorkbenchWindow window;
	private IWorkbenchPage page;
	private String filePath;

	private boolean cpfFileExist = true;

	private long heapMaxSize;
	private long heapSize;
	private static long lastUsedHeapSize = 0;
	private static long lastCpfSize = 0;

	public void dispose() {

	}

	public void init(IWorkbenchWindow window) {
		this.window = window;
	}

	public void run(IAction action) {
		filePath = openFileDialog();
		if (!cpfFileExist) {
			return;
		}

		if (canBeOutOfMemory(filePath)) {
			return;
		}

		if (page == null) {
			page = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
					.getActivePage();
		}
		if (wasFileOpened(page, filePath)) {
			return;
		}

		IEditorInput input = CPFManager.createInput(filePath);
		openEditor(input);

		handleHeapCheck(new File(filePath));
	}

	private boolean wasFileOpened(final IWorkbenchPage page, String filePath) {
		if (page != null) {
			IEditorReference[] editorReferences = page.getEditorReferences();
			for (IEditorReference editorReference : editorReferences) {
				final IEditorPart editor = editorReference.getEditor(false);
				if (editor instanceof CPFEditor) {
					String cpfFilePath = ((CPFEditor) editor)
							.getViewEditorModel().getCpfFilePath();
					File cpfFile = new File(cpfFilePath);
					final File file = new File(filePath);

					if (file.equals(cpfFile)) {

						Display.getDefault().asyncExec(new Runnable() {

							public void run() {
								page.bringToTop(editor);
								Path path = new Path(file.getPath());
								String[] segments = path.segments();
								MessageDialog.openInformation(Display
										.getDefault().getActiveShell(),
										"One CPF cannot be opened twice",
										"File" + " "
												+ segments[segments.length - 1]
												+ " "
												+ "has already been opened");

							}

						});

						return true;
					}
				}
			}

		}
		return false;
	}

	private CPFEditor openEditor(IEditorInput editorInput) {
		CPFEditor editor = null;
		try {
			editor = (CPFEditor) window.getActivePage().openEditor(editorInput,
					"com.nokia.tools.variant.editor.editors.CPFEditor");
			saveEditorHistory();
		} catch (PartInitException e) {

			e.printStackTrace();
		}

		return editor;
	}

	/**
	 * save EditorHistory to file
	 * 
	 * @param file
	 */
	public static void saveEditorHistory() {
		clearHistoryTable();
		XMLMemento memento = XMLMemento.createWriteRoot("editorhistory");
		final IStatus status = ((Workbench) PlatformUI.getWorkbench())
				.getEditorHistory().saveState(
						memento.createChild(IWorkbenchConstants.TAG_MRU_LIST));
		if (status.getSeverity() != IStatus.OK) {
			MessageDialog.openError((Shell) null, Messages.SaveProblem,
					Messages.SaveEditorHistory);
		} else {
			saveMementoToFile(memento, getEditorHistoryFile());
		}
	}

	/**
	 * load EditorHistory from file
	 * 
	 * @param file
	 */
	public static void loadEditorHistory() {
		XMLMemento memento = loadMementoFromFile(getEditorHistoryFile());
		if (memento != null) {
			IMemento mruMemento = memento
					.getChild(IWorkbenchConstants.TAG_MRU_LIST);
			final IStatus status = ((Workbench) PlatformUI.getWorkbench())
					.getEditorHistory().restoreState(mruMemento);
			if (status.getSeverity() != IStatus.OK) {
				MessageDialog.openError((Shell) null, Messages.LoadProblem,
						Messages.LoadEditorHistory);
			}
		}
	}

	/**
	 * @return editorhistory.xml file
	 */
	private static File getEditorHistoryFile() {
		IPath path = WorkbenchPlugin.getDefault().getDataLocation();
		if (path == null) {
			return null;
		}
		path = path.append("editorhistory.xml");
		File file = path.toFile();
		return file;
	}

	/**
	 * Save the memento to a file.
	 */
	private static boolean saveMementoToFile(XMLMemento memento, File file) {
		// Save it to a file.
		if (file == null) {
			return false;
		}
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				MessageDialog.openError((Shell) null,
						Messages.CreateFileProblem, "Can not create file "
								+ file.getPath());
			}
		}
		try {
			FileOutputStream stream = new FileOutputStream(file);
			OutputStreamWriter writer = new OutputStreamWriter(stream, "utf-8"); //$NON-NLS-1$
			memento.save(writer);
			writer.close();
		} catch (IOException e) {
			file.delete();
			MessageDialog.openError((Shell) null, Messages.SaveProblem,
					Messages.SaveEditorHistory);
			return false;
		}

		// Success !
		return true;
	}

	/**
	 * @param file
	 * @return memento from File
	 */
	private static XMLMemento loadMementoFromFile(File file) {
		XMLMemento memento = null;
		if (file != null) {
			if (file.exists()) {
				try {
					FileInputStream input = new FileInputStream(file);
					BufferedReader reader = new BufferedReader(
							new InputStreamReader(input, "utf-8")); //$NON-NLS-1$
					memento = XMLMemento.createReadRoot(reader);
					reader.close();
				} catch (Exception e) {
					MessageDialog.openError((Shell) null, Messages.LoadProblem,
							Messages.LoadMemento);
				}
			}
		}
		return memento;
	}

	/**
	 * remove double and invalidate items from EditorHistory
	 */
	public static void clearHistoryTable() {
		EditorHistory history = getEditorHistory();
		// ((Workbench) PlatformUI.getWorkbench()).getEditorHistory();
		EditorHistoryItem items[] = history.getItems();
		List<EditorHistoryItem> removelist = new ArrayList<EditorHistoryItem>();
		int length = items.length;
		if (length > 0) {
			ExtensibleURIConverterImpl uriConverter = new ExtensibleURIConverterImpl();
			Set<URI> duplicates = new HashSet<URI>();
			for (EditorHistoryItem item : items) {
				IEditorInput input = item.getInput();
				if (input != null) {
					URI uri = EditUIUtil.getURI(input);
					if (duplicates.contains(uri)) {
						removelist.add(item);
						continue;
					}
					duplicates.add(uri);
					if (!uriConverter.exists(uri, null)) {
						removelist.add(item);
					}
				}
			}

			for (Object item : removelist.toArray()) {
				history.remove((EditorHistoryItem) item);
			}
		}
	}

	public static EditorHistory getEditorHistory() {
		EditorHistory history = ((Workbench) PlatformUI.getWorkbench())
				.getEditorHistory();
		return history;
	}

	private String openFileDialog() {
		FileDialog fileDialog = new FileDialog(window.getShell());
		fileDialog.setFilterExtensions(new String[] { "*.cpf", "*.zip" });
		String filePath = fileDialog.open();

		if (filePath == null) {
			cpfFileExist = false;
			return null;
		}

		File f = new File(filePath);
		Path path = new Path(filePath);
		String[] segments = path.segments();
		if (!f.exists()) {
			cpfFileExist = false;
			MessageDialog.openInformation(
					Display.getDefault().getActiveShell(),
					"   File does not exist", "File "
							+ segments[segments.length - 1]
							+ " does not exist.");
		} else if (!filePath.endsWith(".cpf")) {
			cpfFileExist = false;
			MessageDialog.openInformation(
					Display.getDefault().getActiveShell(), "   Invalid file",
					"File " + segments[segments.length - 1] + " is not valid.");
		} else {
			cpfFileExist = true;
		}

		return filePath;
	}

	public void selectionChanged(IAction action, ISelection selection) {

	}

	public void importProject(String filePath) {
		if (filePath == null) {
			return;
		}

		if (canBeOutOfMemory(filePath)) {
			return;
		}

		if (page == null) {
			page = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
					.getActivePage();
		}

		if (wasFileOpened(page, filePath)) {
			return;
		}

		File cpffile = new File(filePath);

		if (cpffile.exists() && cpffile.getPath().endsWith(".cpf")) { //$NON-NLS-1$
			IEditorInput input = CPFManager.createInput(filePath);

			try {
				page.openEditor(input,
						"com.nokia.tools.variant.editor.editors.CPFEditor");
				saveEditorHistory();
			} catch (PartInitException e) {
				e.printStackTrace();
			} finally {
				handleHeapCheck(cpffile);
			}
		}
	}

	private void handleHeapCheck(File cpffile) {
		Runtime.getRuntime().gc();
		lastCpfSize = cpffile.length();
		long heapSizeAfterOpen = Runtime.getRuntime().totalMemory();
		if ((heapSizeAfterOpen - heapSize) != 0) {
			lastUsedHeapSize = heapSizeAfterOpen - heapSize;
		}
	}

	public boolean canBeOutOfMemory(String filePath) {
		Runtime.getRuntime().gc();

		heapMaxSize = Runtime.getRuntime().maxMemory();
		heapSize = Runtime.getRuntime().totalMemory();

		File cpf = new File(filePath);
		long cpfSize = cpf.length();

		long availableHeapSize = heapMaxSize - heapSize;

		long heapNeeded = cpfSize;
		if (lastCpfSize != 0) {
			heapNeeded = lastUsedHeapSize;
		}

		if (availableHeapSize < heapNeeded) {
			Path path = new Path(filePath);
			String[] segments = path.segments();
			MessageDialog.openInformation(
					Display.getDefault().getActiveShell(), "Out of memory",
					"File" + " " + segments[segments.length - 1] + " "
							+ "will not be open due to out of memory error.");

			return true;
		}

		return false;
	}

}
