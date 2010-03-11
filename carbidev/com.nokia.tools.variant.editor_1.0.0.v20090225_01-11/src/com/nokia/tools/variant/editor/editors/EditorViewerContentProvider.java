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

import static com.nokia.tools.variant.resourcelibrary.views.DnDStorage.getData;
import static com.nokia.tools.variant.resourcelibrary.views.DnDStorage.isData;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import com.nokia.tools.variant.content.confml.FilePath;
import com.nokia.tools.variant.content.confml.FileSystemEntrySetting;
import com.nokia.tools.variant.content.confml.Setting;
import com.nokia.tools.variant.content.confml.SimpleSetting;
import com.nokia.tools.variant.content.confml.TYPE;
import com.nokia.tools.variant.editor.adapters.SettingToErrorAdapter;
import com.nokia.tools.variant.editor.commands.ChangeFileSettingCommand;
import com.nokia.tools.variant.editor.commands.ChangeSettingValueCommand;
import com.nokia.tools.variant.editor.dialogs.ResourcePickDialog;
import com.nokia.tools.variant.editor.listeners.WidgetDragSourceListener;
import com.nokia.tools.variant.editor.listeners.WidgetDropTargetListener;
import com.nokia.tools.variant.editor.model.UIGroup;
import com.nokia.tools.variant.editor.model.UIModel;
import com.nokia.tools.variant.editor.model.UISetting;
import com.nokia.tools.variant.editor.validation.SettingsValidator;
import com.nokia.tools.variant.resourcelibrary.model.Directory;
import com.nokia.tools.variant.resourcelibrary.model.File;
import com.nokia.tools.variant.resourcelibrary.model.FileSystemElement;
import com.nokia.tools.variant.resourcelibrary.model.ResourceModelRoot;
import com.nokia.tools.variant.resourcelibrary.resources.ResourceUtil;
import com.nokia.tools.variant.viewer.validation.EResult;
import com.nokia.tools.variant.viewer.validation.IResult;
import com.nokia.tools.variant.viewer.validation.ValidationResult;
import com.nokia.tools.variant.viewer.viewer.IValuesContentProvider;
import com.nokia.tools.variant.viewer.widgets.BaseConfMLWidget;

/**
 * This provider is used to map between the UIModel used as the input to the
 * SettingsViewer and the internal list structure needed by the viewer itself.
 * It has method isDirty() that returns if setting is dirty or not and method
 * isDefault() that says if setting value is default or not. The method
 * hasNote() has analogical function.
 */
public class EditorViewerContentProvider implements IValuesContentProvider {
	private CommandStack stack;
	private CPFEditor editor;

	public EditorViewerContentProvider(CommandStack stack, CPFEditor editor) {
		this.stack = stack;
		this.editor = editor;

	}

	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof UIGroup) {
			UIGroup group = (UIGroup) parentElement;
			EList<UISetting> uiSettings = group.getUiSettings();
			EList<UIGroup> uiGroups = group.getUiGroups();
			List<EObject> l = new ArrayList<EObject>();
			l.addAll(uiSettings);
			l.addAll(uiGroups);

			return l.toArray();
		}
		if (parentElement instanceof UISetting) {
			EList<UISetting> usSubsettings = ((UISetting) parentElement)
					.getChildren();

			return usSubsettings.toArray();
		}
		return new Object[] {};
	}

	public Object getParent(Object element) {
		if (element instanceof EObject) {
			return ((EObject) element).eContainer();
		}
		return null;
	}

	public boolean hasChildren(Object element) {

		return getChildren(element).length > 0;
	}

	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof UIModel) {
			return ((UIModel) inputElement).getUiGroups().toArray();
		}
		if (inputElement instanceof UIGroup) {
			EList<UISetting> uiSettings = ((UIGroup) inputElement)
					.getUiSettings();

			Object[] array = uiSettings.toArray();

			return array;
		}
		return null;
	}

	public void dispose() {
		// stack.removeCommandStackEventListener(relevantListemer);
		// stack.removeCommandStackEventListener(constraintListemer);
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

	}

	public String getValue(Object element) {
		if (element instanceof UISetting) {
			UISetting ui = (UISetting) element;
			Setting setting = ui.getSetting();
			if (setting instanceof SimpleSetting) {
				SimpleSetting simpleSetting = (SimpleSetting) setting;
				String choosenOption = simpleSetting.getChoosenOption();
				if (choosenOption != null && !"".equals(choosenOption)) {
					return choosenOption;
				}
				return simpleSetting.getValue();
			}

			if (setting instanceof FilePath) {
				FilePath fileSetting = (FilePath) setting;
				String choosenOption = fileSetting.getChoosenOption();
				if (choosenOption != null && !"".equals(choosenOption)) {
					return choosenOption;
				}
				return fileSetting.getPath();
			}
		}
		return null;
	}

	public void valueChanged(String newValue, Object element) {
		if (element instanceof UISetting) {
			UISetting uiSetting = (UISetting) element;
			Setting setting = uiSetting.getSetting();
			if (setting instanceof SimpleSetting) {
				SimpleSetting simpleSetting = (SimpleSetting) setting;
				ChangeSettingValueCommand changeSettingValueCommand = new ChangeSettingValueCommand(
						simpleSetting, newValue, true);
				stack.execute(changeSettingValueCommand);
				editor.handleErrors(setting, newValue);
			}
			if (setting instanceof FilePath) {

				// FileSystemEntrySetting fileSetting = (FileSystemEntrySetting)
				// setting;
				// if (uiSetting.getData().equals(Type.FILESOURCE)) {
				// ChangeFileSettingSourceCommand command = new
				// ChangeFileSettingSourceCommand(
				// fileSetting, newValue, true);
				// stack.execute(command);
				// } else {
				// ChangeFileSettingTargetCommand command = new
				// ChangeFileSettingTargetCommand(
				// fileSetting, newValue, true);
				// stack.execute(command);
				// }

				FilePath fileSetting = (FilePath) setting;
				ChangeFileSettingCommand command = new ChangeFileSettingCommand(
						fileSetting, newValue, true);
				stack.execute(command);
				editor.handleErrors(setting, newValue);

			}
		}
	}

	public ValidationResult validate(String value, Object element) {
		if (element instanceof UISetting) {
			UISetting ui = (UISetting) element;
			Setting setting = ui.getSetting();
			if (setting == null) {
				EList<UISetting> children = ui.getChildren();
				if (children.size() > 0) {
					UISetting firstChild = children.get(0);
					return validate(getValue(firstChild), firstChild);
				} else {
					return new ValidationResult(EResult.VALID);
				}
			}
			Adapter adapter = EcoreUtil.getAdapter(setting.eAdapters(),
					SettingToErrorAdapter.class);
			if (adapter instanceof SettingToErrorAdapter) {
				SettingToErrorAdapter errorAdapter = (SettingToErrorAdapter) adapter;
				String description = errorAdapter.getError().getDescription();
				ValidationResult result = new ValidationResult(
						new ArrayList<IResult>(), description);
				return result;
			}

		}

		return new ValidationResult(EResult.VALID);

	}

	public boolean isDirty(Object element) {

		if (element instanceof UISetting) {
			UISetting element2 = (UISetting) element;
			Setting setting = element2.getSetting();
			/*
			 * if (element2.getData() != null &&
			 * element2.getData().equals(Type.FILESOURCE)) { FilePath fs =
			 * (FilePath) setting; String lastSavedSourcePath =
			 * fs.getLastSavedPath(); String sourcePath = fs.getPath(); if
			 * (lastSavedSourcePath != null &&
			 * !lastSavedSourcePath.equals(sourcePath) || lastSavedSourcePath ==
			 * null && sourcePath != null && !sourcePath.equals("")) { return
			 * true; } else { return false; } } if (element2.getData() != null
			 * && element2.getData().equals(Type.FILETARGET)) { FilePath fs =
			 * (FilePath) setting; String lastSavedTargetPath =
			 * fs.getLastSavedPath(); String targetPath = fs.getPath(); if
			 * (lastSavedTargetPath != null &&
			 * !lastSavedTargetPath.equals(targetPath) || lastSavedTargetPath ==
			 * null && targetPath != null && !targetPath.equals("")) { return
			 * true; } else { return false; }
			 * 
			 * }
			 */
			if (setting == null) {
				return false;
			}
			return setting.isDirty();
		}
		return false;
	}

	public void contributeToToolBar(IToolBarManager manager, Object element) {
		Shell sh = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getShell();
		ResourcePickDialog dialog = new ResourcePickDialog(sh, false, "");
		dialog.open();
		Object result = dialog.getFirstResult();
		iHaveFileAndelement(result, element);
	}

	public DropTargetListener getDropTargetListener(final Object element) {
		if (element instanceof BaseConfMLWidget) {
			BaseConfMLWidget widget = (BaseConfMLWidget) element;
			return new WidgetDropTargetListener(widget, widget.getData());
		} else {
			return new DropTargetListener() {

				public void dragEnter(DropTargetEvent event) {
					event.detail = DND.DROP_NONE;
					if (isData() && (getData() instanceof StructuredSelection)) {
						StructuredSelection selection = (StructuredSelection) getData();
						Object result = selection.getFirstElement();
						if (element instanceof UISetting) {
							UISetting uiSetting = (UISetting) element;
							Setting setting = uiSetting.getSetting();
							// CPF v2
							if (setting instanceof FileSystemEntrySetting) {
								if ((((FileSystemEntrySetting) setting)
										.isFile())
										&& (result instanceof File)) {
									event.detail = DND.DROP_DEFAULT;
								}
								if (!(((FileSystemEntrySetting) setting)
										.isFile())
										&& (result instanceof Directory)) {
									event.detail = DND.DROP_DEFAULT;
								}
							}
							// CPF v1
							if (setting instanceof SimpleSetting) {
								if (setting.getType().equals(TYPE.SIMPLE_FILE)
										&& (result instanceof File)) {
									event.detail = DND.DROP_DEFAULT;
								}
								if (setting.getType()
										.equals(TYPE.SIMPLE_FOLDER)
										&& (result instanceof Directory)) {
									event.detail = DND.DROP_DEFAULT;
								}
							}
						}
					}
				}

				public void dragLeave(DropTargetEvent event) {

				}

				public void dragOperationChanged(DropTargetEvent event) {

				}

				public void dragOver(DropTargetEvent event) {

				}

				public void drop(DropTargetEvent event) {
					if (event.data != null
							&& event.data instanceof StructuredSelection) {
						StructuredSelection selection = (StructuredSelection) event.data;
						Object result = selection.getFirstElement();
						iHaveFileAndelement(result, element);
					}
				}

				public void dropAccept(DropTargetEvent event) {

				}

			};
		}

	}

	@SuppressWarnings("deprecation")
	private void iHaveFileAndelement(Object result, Object element) {
		if (result instanceof FileSystemElement) {
			FileSystemElement fse = (FileSystemElement) result;
			String fullPath = fse.getPath();
			fullPath = fullPath.replaceAll("\\\\", "/");
			UISetting uiSetting = (UISetting) element;
			Setting setting = uiSetting.getSetting();
			String sourcePath = null;
			boolean isResultFile = false;
			if (setting instanceof FileSystemEntrySetting) {
				FileSystemEntrySetting fileSystemSetting = (FileSystemEntrySetting) setting;
				isResultFile = fileSystemSetting.isFile();
				// this connection is necessary again
				sourcePath = fileSystemSetting.getSourceFilePath().getPath();
			} else if (setting.getType().equals(TYPE.SIMPLE_FILE)) {
				isResultFile = true;
				sourcePath = ((SimpleSetting) setting).getValue();
			} else if (setting.getType().equals(TYPE.SIMPLE_FOLDER)) {
				sourcePath = ((SimpleSetting) setting).getValue();
			}

			if (((result instanceof File) && !isResultFile)
					|| ((result instanceof Directory) && isResultFile))
				return;

			if (sourcePath != null) {
				Object adapter = PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getActivePage()
						.getActiveEditor().getAdapter(ResourceModelRoot.class);
				if (adapter instanceof ResourceModelRoot) {
					ResourceModelRoot root = (ResourceModelRoot) adapter;
					FileSystemElement fil = ResourceUtil.getFileSystemElement(
							root, sourcePath);
					if (fil != null) {
						fil.getSettings().remove(fil);
					}
				}
			}
			fse.getSettings().add(setting);

			// if (setting instanceof FileSystemEntrySetting) {
			//
			// ChangeFileSettingSourceCommand c = new
			// ChangeFileSettingSourceCommand(
			// (FileSystemEntrySetting) setting, fullPath, true);
			// stack.execute(c);
			// } else {
			// ChangeSettingValueCommand valueCommand = new
			// ChangeSettingValueCommand(
			// (SimpleSetting) setting, fullPath, true);
			// stack.execute(valueCommand);
			// }
			if (setting instanceof SimpleSetting) {
				ChangeFileSettingCommand c = new ChangeFileSettingCommand(
						(SimpleSetting) setting, fullPath, true);
				stack.execute(c);
			} else if (setting instanceof FileSystemEntrySetting) {
				ChangeFileSettingCommand c = new ChangeFileSettingCommand(
						((FileSystemEntrySetting) setting).getSourceFilePath(),
						fullPath, true);
				stack.execute(c);
			}
		}
	}

	public boolean hasNote(Object element) {
		if (element instanceof UISetting) {
			UISetting ui = (UISetting) element;
			Setting setting = ui.getSetting();
			if (setting != null) {
				String note = setting.getNote();
				if (note != null && !note.equals("")) {
					return true;

				}
			}
		}
		return false;
	}

	public boolean isDefault(Object element) {
		if (element instanceof UISetting) {
			Setting s = ((UISetting) element).getSetting();
			return s.isDefault();
		}
		return false;
	}

	public DragSourceListener getDragSourceListener(Object data) {
		return new WidgetDragSourceListener(data);

	}

}
