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

package com.nokia.tools.variant.editor.editors;

import java.io.File;

import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorRegistry;
import org.eclipse.ui.internal.WorkbenchPlugin;
import org.eclipse.ui.internal.registry.EditorDescriptor;

import com.nokia.tools.variant.common.ui.utils.ProgressBarShower;
import com.nokia.tools.variant.confml.core.model.application.EConfigurationProject;
import com.nokia.tools.variant.content.confml.View;
import com.nokia.tools.variant.editor.actions.OpenCpfAction;
import com.nokia.tools.variant.editor.dialogs.SaveAsDialog;
import com.nokia.tools.variant.editor.model.convertor.CPFInformationConvertor;
import com.nokia.tools.variant.editor.model.convertor.CPFInformationConvertorFactory;
import com.nokia.tools.variant.editor.model.convertor.UIMetadata2CPFMetadataModelConverter;
import com.nokia.tools.variant.editor.model.convertor.ViewModel2ConfMLPersistenceModelConvertor;
import com.nokia.tools.variant.editor.model.convertor.ViewModel2ConfMLPersistenceModelConvertorFactory;
import com.nokia.tools.variant.editor.utils.CPFManager;

@SuppressWarnings("restriction")
public class SaveAsUtil {
	public static int doSaveAs(final CPFEditor editor) {
		int result = Dialog.CANCEL;
		try {
			final SaveAsDialog saveAsDialog = new SaveAsDialog(editor.getSite()
					.getShell(), editor);
			result = saveAsDialog.open();

			if (result == Window.OK) {
				if (saveAsDialog.isOverride()) {
					File fileToOverride = new File(saveAsDialog.getProjectDir());
					fileToOverride.delete();
				}

				CommandStack commandStack = editor.getCommandStack();
				commandStack.markSaveLocation();
				editor.setStructuralCommandsSaveLocation(editor
						.getStructuralCommands());
				editor.updateDirtyState(false, false);
				commandStack.flush();
				editor.getActionRegistry().getAction("undo").setEnabled(false);
				final ProgressBarShower shower = new ProgressBarShower();
				Thread t = new Thread(new Runnable() {
					public void run() {
						Display.getDefault().syncExec(new Runnable() {

							public void run() {
								try {

									String newLocation = saveAsDialog
											.getProjectDir();

									String fileName = new File(newLocation)
											.getName();
									String newCPFName = fileName.substring(0,
											fileName.lastIndexOf("."));
									editor.setNote(saveAsDialog
											.getCommentsText());

									URI savePath = editor.getSavePath();
									ViewEditorModel viewEditorModel = editor
											.getViewEditorModel();
									EConfigurationProject project = viewEditorModel
											.getVariantContributor();
									ViewModel2ConfMLPersistenceModelConvertor viewModel2PersistenceModelConvertorForDataFile = ViewModel2ConfMLPersistenceModelConvertorFactory
											.getConvertor(project
													.eResource()
													.getResourceSet()
													.getResource(savePath, true));
									View view = viewEditorModel.getView();
									viewModel2PersistenceModelConvertorForDataFile
											.copyValues(view, project, "id",
													savePath);

									ViewModel2ConfMLPersistenceModelConvertor viewModel2PersistenceModelConvertorForViewFile = viewEditorModel
											.getViewConvertor();
									viewModel2PersistenceModelConvertorForViewFile
											.removeHiddenSettings(view, project);

									editor.getSummaryModelroot().getUiGroups()
											.get(0).getUiElements().get(0)
											.setValue(newCPFName);

									UIMetadata2CPFMetadataModelConverter
											.copyUIMetadata2CpfMetadata(editor
													.getSummaryModelroot(),
													viewEditorModel);

									// save summary page's metadata
									URI rootConfmlURI = project.getRootConfml();
									Resource rootConfMLResource = project
											.eResource().getResourceSet()
											.getResource(rootConfmlURI, true);
									CPFInformationConvertor cpfInformationConvertor = CPFInformationConvertorFactory
											.getCPFInformationConvertor(rootConfMLResource);
									cpfInformationConvertor
											.copyCPFInformationToResource(
													rootConfMLResource,
													viewEditorModel
															.getCpfMetadata());

									ModelSaver.saveAs(project, saveAsDialog
											.getCpfFilePath(), newLocation,
											view,
											saveAsDialog.getCpfMetadata(),
											viewEditorModel);

									viewEditorModel.setCpfFilePath(saveAsDialog
											.getProjectDir());
									viewEditorModel
											.setVariantContributor(project);
									editor.getSettingsViewer()
											.removeDirtyMarkers();

									editor.setPartName(newCPFName);
									editor.setFullPath(new Path(newLocation));

									// Recently Open Files History
									IEditorRegistry reg = WorkbenchPlugin
											.getDefault().getEditorRegistry();
									EditorDescriptor desc = (EditorDescriptor) reg
											.findEditor("com.nokia.tools.variant.editor.editors.CPFEditor");
									OpenCpfAction
											.getEditorHistory()
											.add(
													CPFManager
															.createInput(newLocation),
													desc);
									OpenCpfAction.saveEditorHistory();

								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
					}
				});
				shower.showProgressBar(t, "Saving cpf", true);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}

}
