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
 * Description: This file is part of com.nokia.tools.variant.compare.ui component.
 */

package com.nokia.tools.variant.compare.ui.wizards;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

import com.nokia.tools.variant.common.core.utils.ArrayUtils;
import com.nokia.tools.variant.common.core.utils.FileUtils;
import com.nokia.tools.variant.common.ui.utils.ProgressBarShower;
import com.nokia.tools.variant.compare.builder.CompareModelFactory;
import com.nokia.tools.variant.compare.builder.CompareUtil;
import com.nokia.tools.variant.compare.cmodel.EDiffGroup;
import com.nokia.tools.variant.compare.cmodel.EDiffLocalPathSetting;
import com.nokia.tools.variant.compare.cmodel.EDiffResourceSetting2;
import com.nokia.tools.variant.compare.cmodel.EDiffSequence;
import com.nokia.tools.variant.compare.cmodel.EDiffSequenceItem;
import com.nokia.tools.variant.compare.cmodel.EDiffSimple;
import com.nokia.tools.variant.compare.cmodel.EModelRoot;
import com.nokia.tools.variant.compare.ui.ImportDataUIPlugin;
import com.nokia.tools.variant.confml.core.model.application.EAppIncludeElement;
import com.nokia.tools.variant.confml.core.model.application.EConfMLLayer;
import com.nokia.tools.variant.confml.core.model.application.EConfigurationProject;
import com.nokia.tools.variant.content.confml.FileSystemEntrySetting;
import com.nokia.tools.variant.content.confml.SequenceItem;
import com.nokia.tools.variant.content.confml.SequenceSetting;
import com.nokia.tools.variant.content.confml.Setting;
import com.nokia.tools.variant.content.confml.SimpleSetting;
import com.nokia.tools.variant.content.confml.TYPE;
import com.nokia.tools.variant.content.confml.View;
import com.nokia.tools.variant.editor.commands.AddSequenceItemCommand;
import com.nokia.tools.variant.editor.commands.ChangeFileSettingSourceCommand;
import com.nokia.tools.variant.editor.commands.ChangeFileSettingTargetCommand;
import com.nokia.tools.variant.editor.commands.ChangeSettingValueCommand;
import com.nokia.tools.variant.editor.cpfInfo.CPFInformation;
import com.nokia.tools.variant.editor.dialogs.SelectConfigurationDialog;
import com.nokia.tools.variant.editor.editors.CPFEditor;
import com.nokia.tools.variant.editor.editors.ModelSaver;
import com.nokia.tools.variant.editor.editors.SettingEvaluator;
import com.nokia.tools.variant.editor.editors.ViewEditorModel;
import com.nokia.tools.variant.editor.utils.CPFManager;
import com.nokia.tools.variant.resourcelibrary.handlers.commands.CreateFolderCommand;
import com.nokia.tools.variant.resourcelibrary.handlers.commands.ImportCommand;
import com.nokia.tools.variant.resourcelibrary.model.Directory;
import com.nokia.tools.variant.resourcelibrary.model.FileSystemElement;
import com.nokia.tools.variant.resourcelibrary.model.ResourceModelRoot;
import com.nokia.tools.variant.resourcelibrary.resources.ResourceUtil;

public class ImportDataWizard extends Wizard {

	private ImportDataWizardPageOne pageOne;
	private ImportDataWizardPageTwo pageTwo;

	private File sourceFile;
	private File targetFile;
	private ViewEditorModel sourceModel;
	private ViewEditorModel targetModel;
	private IWorkbenchPart targetEditor;
	private boolean copyFiles;
	private boolean loadFromEditor;

	/**
	 * If CPF is opened, then is automatically set as target CPF
	 */
	private boolean cpfOpened;

	public boolean isCpfOpened() {
		return cpfOpened;
	}

	private final String IMPORT_DIALOG_NAME = "Import data";

	/**
	 * This constructor is called, if CPF editor is opened.
	 * 
	 * @param targetEditor
	 */

	public ImportDataWizard(IWorkbenchPart targetEditor) {
		cpfOpened = true;
		setNeedsProgressMonitor(true);
		setWindowTitle(IMPORT_DIALOG_NAME);
		setDefaultPageImageDescriptor(ExtendedImageRegistry.INSTANCE
				.getImageDescriptor(ImportDataUIPlugin.INSTANCE
						.getImage("full/wizban/ImportCPFData")));
		this.targetEditor = targetEditor;
		setTargetModel(((ViewEditorModel) targetEditor
				.getAdapter(ViewEditorModel.class)));

	}

	/**
	 * This constructor is called, if no CPF editor is opened.
	 */
	public ImportDataWizard() {
		cpfOpened = false;
		setNeedsProgressMonitor(true);
		setWindowTitle(IMPORT_DIALOG_NAME);
	}

	@Override
	public void addPages() {
		pageOne = new ImportDataWizardPageOne();
		pageTwo = new ImportDataWizardPageTwo();

		pageOne.setCpfOpened(cpfOpened);

		if (cpfOpened)
			pageOne.setTargetFile(targetEditor.getTitle());

		addPage(pageOne);
		addPage(pageTwo);
	}

	@Override
	public boolean performFinish() {
		try {
			getContainer().run(false, false, new IRunnableWithProgress() {
				public void run(IProgressMonitor monitor)
						throws InvocationTargetException, InterruptedException {
					runUpdateCommand(monitor);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	protected void runUpdateCommand(IProgressMonitor monitor) {
		Object[] checkedElements = pageTwo.getCheckedElements();

		CommandStack gefCommandStack = null;
		if (cpfOpened) {
			gefCommandStack = (CommandStack) targetEditor
					.getAdapter(CommandStack.class);
		}

		CompoundCommand command = new CompoundCommand("Import Data");

		Set<String> filesToImport = new HashSet<String>();

		monitor.beginTask("Updating Model", 100);

		addValueCopyCommands(checkedElements, command, filesToImport,
				new SubProgressMonitor(monitor, 30));

		if (copyFiles) {
			addFileCopyCommands(command, sourceModel.getResourceModelRoot(),
					targetModel.getResourceModelRoot(), filesToImport,
					new SubProgressMonitor(monitor, 30));
		} else {
			monitor.worked(30);
		}

		monitor.subTask("Executing command");
		command.execute();

		if (cpfOpened) {
			gefCommandStack.execute(command);
			SettingEvaluator.initRelevantForWholeModel((View) targetEditor
					.getAdapter(View.class), false);
		} else {
			EConfigurationProject project = targetModel.getVariantContributor();
			URI savePath = getSavePath(targetModel);
			try {
				ModelSaver.save(project, new NullProgressMonitor(), targetModel
						.getCpfFilePath(), targetModel.getView(), savePath,
						new ProgressBarShower(), targetModel.getCpfMetadata(),
						targetModel, null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		monitor.worked(30);
		monitor.done();
	}

	private URI getSavePath(ViewEditorModel targetProject) {

		EConfMLLayer lastLayer = targetProject.getVariantContributor()
				.getLastLayer();

		EAppIncludeElement lastInclude = ArrayUtils.getLast(lastLayer
				.getIncludes());
		URI uri = lastInclude.getTarget();
		return uri;

	}

	private void addFileCopyCommands(CompoundCommand command,
			ResourceModelRoot sourceResourceRoot,
			ResourceModelRoot targetResourceRoot, Set<String> filesToImport,
			IProgressMonitor progressMonitor) {

		progressMonitor.beginTask("Creating File import",
				filesToImport.size() + 20);
		List<Command> fileImports = new ArrayList<Command>();
		List<Command> dirImports = new ArrayList<Command>();

		for (String source : filesToImport) {
			if (source == null || source.trim().length() == 0) {
				// skip
				progressMonitor.worked(1);
				continue;
			}

			FileSystemElement element = ResourceUtil.getFileSystemElement(
					sourceResourceRoot, source);
			if (element instanceof Directory) {
				// directory
				FileSystemElement target = ResourceUtil.getFileSystemElement(
						targetResourceRoot, source);
				if (target instanceof Directory) {
					// OK
				} else if (target instanceof File) {
					// ERROR
					System.err.println("Incompatible structure");
				} else {
					// no directory
					Command cmd = CreateFolderCommand
							.createNewDirectoryCommand(targetResourceRoot,
									element.getPath2());
					dirImports.add(cmd);

					// Copy of directory content
					Directory directory = (Directory) element;
					EList<FileSystemElement> dirContent = directory
							.getChildren();

					Set<String> filesToImport2 = new HashSet<String>();
					for (FileSystemElement fileSystemElement : dirContent) {
						filesToImport2.add(fileSystemElement.getPath2()
								.toOSString());
					}
					if (dirContent.size() > 0) {
						addFileCopyCommands(command, sourceResourceRoot,
								targetResourceRoot, filesToImport2,
								progressMonitor);
					}
				}
			} else {
				// file
				File sourceFile = new File(sourceResourceRoot.getTempDirPath(),
						element.getPath2().toOSString());
				File targetDir = new File(targetResourceRoot.getTempDirPath(),
						element.getPath2().removeLastSegments(1).toOSString());

				CreateFolderCommand cdc = null;
				if (!targetDir.exists()) {
					cdc = CreateFolderCommand.createNewDirectoryCommand(
							targetResourceRoot, element.getPath2()
									.removeLastSegments(1));
					dirImports.add(cdc);
				}

				Command cmd = ImportCommand
						.createImportCommand(targetResourceRoot, element
								.getPath2(), sourceFile, cdc);
				fileImports.add(cmd);
				progressMonitor.worked(1);
			}

		}
		for (Command cmd : dirImports) {
			command.add(cmd);
		}
		progressMonitor.worked(10);
		for (Command cmd : fileImports) {
			command.add(cmd);
		}
		progressMonitor.worked(10);
		progressMonitor.done();
	}

	private void addValueCopyCommands(Object[] checkedElements,
			CompoundCommand command, Set<String> filesToImport,
			IProgressMonitor progressMonitor) {

		progressMonitor.beginTask("Create Copy Value Command",
				checkedElements.length);
		Set<SequenceItem> checkedItems = new HashSet<SequenceItem>();
		for (Object element : checkedElements) {
			if (element instanceof EDiffSequenceItem) {
				SequenceItem item = (SequenceItem) ((EDiffSequenceItem) element)
						.getSourceObject();
				if (item != null) {
					checkedItems.add(item);
				}
			}
		}
		for (Object element : checkedElements) {

			if (element instanceof EDiffLocalPathSetting) {
				EDiffLocalPathSetting diff = (EDiffLocalPathSetting) element;
				if (diff.eContainer() instanceof EDiffResourceSetting2) {
					// part of file setting v2
					EDiffResourceSetting2 rsdiff = (EDiffResourceSetting2) diff
							.eContainer();

					FileSystemEntrySetting target = (FileSystemEntrySetting) rsdiff
							.getTargetObject();
					Command cmd = new ChangeFileSettingSourceCommand(target,
							diff.getSourceValue(), true);
					command.add(cmd);

					filesToImport.add(diff.getSourceValue());
				} else {
					// part of group in v1.
					SimpleSetting target = (SimpleSetting) diff
							.getTargetObject();
					ChangeSettingValueCommand cmd = new ChangeSettingValueCommand(
							target, diff.getSourceValue(), true);
					command.add(cmd);

					filesToImport.add(diff.getSourceValue());
				}
			} else if (element instanceof EDiffResourceSetting2) {
				// even if it is checked, only child elements are considered
			} else if (element instanceof EDiffSequence) {
				EDiffSequence sequence = (EDiffSequence) element;
				addSequenceAppendCommand(command, sequence, filesToImport,
						checkedItems);
			} else if (element instanceof EDiffSimple) {
				// simple element use cases:
				// 1. Top level element
				// 2. Target path element
				// 3. Source path element (see above EDiffLocalPathSetting)

				EDiffSimple diff = (EDiffSimple) element;
				if (diff.eContainer() instanceof EDiffGroup) {
					// parent is view group

					addSimpleValueCopy(command, diff, filesToImport);
				} else if (diff.eContainer() instanceof EDiffResourceSetting2) {
					// target path in a setting
					EDiffResourceSetting2 parent = (EDiffResourceSetting2) diff
							.eContainer();
					FileSystemEntrySetting target = (FileSystemEntrySetting) parent
							.getTargetObject();

					Command cmd = new ChangeFileSettingTargetCommand(target,
							diff.getSourceValue(), true);
					command.add(cmd);
				} else {
					throw new IllegalArgumentException("Unexpected");
				}
			}
			progressMonitor.worked(1);
		}
		progressMonitor.done();
	}

	private void addSequenceAppendCommand(CompoundCommand command,
			EDiffSequence sequence, Set<String> filesToImport,
			Set<SequenceItem> checkedItems) {
		SequenceSetting sourceSetting = (SequenceSetting) sequence
				.getSourceObject();
		SequenceSetting targetSetting = (SequenceSetting) sequence
				.getTargetObject();

		Set<String> ids = new HashSet<String>();
		for (Setting setting : targetSetting.getTemplate().getSetting()) {
			ids.add(setting.getSettingRef());
		}

		EList<SequenceItem> sequenceItems = sourceSetting.getSequenceItem();
		for (SequenceItem sourceItem : sequenceItems) {
			if (checkedItems.contains(sourceItem)) {
				SequenceItem copy = (SequenceItem) EcoreUtil.copy(sourceItem);

				for (Iterator<Setting> it = copy.getSetting().iterator(); it
						.hasNext();) {
					Setting setting = it.next();
					if (!ids.contains(setting.getSettingRef())) {
						it.remove();
						continue;
					}
					if (setting instanceof FileSystemEntrySetting) {
						FileSystemEntrySetting fsentry = (FileSystemEntrySetting) setting;
						String path = fsentry.isDefault() ? fsentry
								.getSourceFilePath().getDefaultPath() : fsentry
								.getSourceFilePath().getPath();
						filesToImport.add(path);
					}
					if (setting.getType() == TYPE.SIMPLE_FILE) {
						SimpleSetting simple = (SimpleSetting) setting;
						filesToImport.add(simple.isDefault() ? simple
								.getDefaultValue() : simple.getValue());
					}
				}

				command.add(new AddSequenceItemCommand(targetSetting, copy));
			}
		}

	}

	private void addSimpleValueCopy(CompoundCommand command, EDiffSimple diff,
			Set<String> filesToImport) {
		SimpleSetting sourceSetting = (SimpleSetting) diff.getSourceObject();
		SimpleSetting targetSetting = (SimpleSetting) diff.getTargetObject();
		String newValue = sourceSetting.isDefault() ? sourceSetting
				.getDefaultValue() : sourceSetting.getValue();

		ChangeSettingValueCommand changeSettingValueCommand = new ChangeSettingValueCommand(
				targetSetting, newValue, true);

		command.add(changeSettingValueCommand);

		if (sourceSetting.getType() == TYPE.SIMPLE_FILE) {
			filesToImport.add(newValue);
		}

	}

	@Override
	public void dispose() {
		disposeSourceModel();
		super.dispose();
	}

	public void loadSourceModel() throws Exception {
		try {
			getContainer().run(false, false, new IRunnableWithProgress() {
				public void run(IProgressMonitor monitor)
						throws InvocationTargetException, InterruptedException {
					monitor.beginTask("Loading", 100);
					File file = pageOne.getSelectedSourceFile();

					// Check if file is open also in editor
					loadFromEditor = false;
					IEditorPart[] dirtyEditors = PlatformUI.getWorkbench()
							.getActiveWorkbenchWindow().getActivePage()
							.getDirtyEditors();
					for (IEditorPart editorPart : dirtyEditors) {
						if (editorPart instanceof CPFEditor) {
							CPFEditor cPFEditor = (CPFEditor) editorPart;
							String browseDialogFilePath = File.separatorChar != '/' ? file
									.getAbsolutePath().replace(
											File.separatorChar, '/')
									: file.getAbsolutePath();
							String editorFileURI = File.separatorChar != '/' ? cPFEditor
									.getViewEditorModel().getCpfFilePath()
									.replace(File.separatorChar, '/')
									: cPFEditor.getViewEditorModel()
											.getCpfFilePath();

							if (browseDialogFilePath.toLowerCase().equals(
									editorFileURI.toLowerCase())) {

								if (MessageDialog
										.openQuestion(
												getShell(),
												"Choose import source data",
												"This file is also openned in editor and has been changed since last save.\n\n "
														+ "Would you like to use for import this changed data?")) {
									sourceModel = cPFEditor
											.getViewEditorModel();
									loadFromEditor = true;
								}
							}
						}
					}

					monitor.setTaskName("Loading source file");
					monitor.worked(10);
					if (!loadFromEditor && !file.equals(sourceFile)) {
						disposeSourceModel();

						if ("confml".equals(FileUtils.getExtension(file))) {
							sourceModel = CompareUtil.createSyntheticModel(
									targetModel, URI.createFileURI(file
											.getAbsolutePath()));
						} else {
							// allow user to choose ConfML root configuration
							URI fileURI = URI.createFileURI(file
									.getAbsolutePath());

							List<CPFInformation> infos = CPFManager
									.getCPFConfigurations(fileURI);
							String rootConfMLPath = null;
							if (infos.size() > 1) {
								Shell shell = getShell();
								SelectConfigurationDialog selectCfgDialog = new SelectConfigurationDialog(
										shell, infos);
								int open = selectCfgDialog.open();
								if (open == Window.CANCEL) {
									shell.getDisplay().asyncExec(
											new Runnable() {

												public void run() {
													getContainer().showPage(
															pageOne);
												}
											});
									return;
								}
								CPFInformation selectedConfiguration = selectCfgDialog
										.getSelectedConfiguration();
								if (selectedConfiguration != null) {
									rootConfMLPath = selectedConfiguration
											.getRootConfMLPath();
								}
							}

							sourceModel = CPFManager.createModel(fileURI,
									rootConfMLPath);
						}
						copyFiles = sourceModel.getResourceModelRoot() != null
								&& targetModel.getResourceModelRoot() != null;
						sourceFile = file;
						loadFromEditor = false;
					}
					monitor.worked(40);
					EModelRoot root = new CompareModelFactory().build(
							sourceModel, targetModel);
					pageTwo.setCompareModelRoot(root);
					monitor.worked(50);
					monitor.done();
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void setTargetModel(ViewEditorModel model) {
		this.targetModel = model;
	}

	private void disposeSourceModel() {
		if (sourceModel != null) {
			if (!loadFromEditor) {
				sourceModel.dispose();
			}
			sourceFile = null;
		}
	}

	public void loadSourceAndTargetModel() throws Exception {
		try {
			getContainer().run(false, false, new IRunnableWithProgress() {

				public void run(IProgressMonitor monitor)
						throws InvocationTargetException, InterruptedException {
					monitor.beginTask("Loading", 100);
					File sFile = pageOne.getSelectedSourceFile();
					File tFile = pageOne.getSelectedTargetFile();

					monitor.setTaskName("Loading source file");
					monitor.worked(10);
					if (!sFile.equals(sourceFile)) {
						disposeSourceModel();

						if ("confml".equals(FileUtils.getExtension(sFile))) {
							sourceModel = CompareUtil.createSyntheticModel(
									targetModel, URI.createFileURI(sFile
											.getAbsolutePath()));
						} else {
							sourceModel = CPFManager.createModel(URI
									.createFileURI(sFile.getAbsolutePath()),
									null);
						}
						loadFromEditor = false;
					}
					monitor.setTaskName("Loading target file");
					monitor.worked(40);

					if (!tFile.equals(targetFile)) {
						disposeTargetModel();

						if ("confml".equals(FileUtils.getExtension(sFile))) {
							targetModel = CompareUtil.createSyntheticModel(
									targetModel, URI.createFileURI(tFile
											.getAbsolutePath()));
						} else {
							targetModel = CPFManager.createModel(URI
									.createFileURI(tFile.getAbsolutePath()),
									null);
						}
					}
					monitor.worked(40);

					copyFiles = sourceModel.getResourceModelRoot() != null
							&& targetModel.getResourceModelRoot() != null;
					sourceFile = sFile;
					targetFile = tFile;

					EModelRoot root = new CompareModelFactory().build(
							sourceModel, targetModel);
					pageTwo.setCompareModelRoot(root);
					monitor.worked(10);
					monitor.done();
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	private void disposeTargetModel() {
		if (targetModel != null) {
			targetModel.dispose();
			targetFile = null;
		}

	}

}
