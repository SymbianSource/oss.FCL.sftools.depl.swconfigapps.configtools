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

package com.nokia.tools.variant.editor.properties;

import java.util.Calendar;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.core.runtime.content.IContentDescription;
import org.eclipse.core.runtime.content.IContentType;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import com.nokia.tools.variant.common.ui.properties.AutoSizePropertySection;
import com.nokia.tools.variant.common.ui.properties.fields.ChangeableLabelFieldEditor;
import com.nokia.tools.variant.common.ui.properties.fields.StringFieldEditor;
import com.nokia.tools.variant.common.ui.wizards.dialogfields.LayoutUtil;
import com.nokia.tools.variant.content.confml.FileSystemEntrySetting;
import com.nokia.tools.variant.content.confml.Setting;
import com.nokia.tools.variant.editor.actions.CopyAction;
import com.nokia.tools.variant.editor.actions.CutAction;
import com.nokia.tools.variant.editor.actions.DeleteAction;
import com.nokia.tools.variant.editor.actions.PasteAction;
import com.nokia.tools.variant.media.ui.MediaUIPlugin;
import com.nokia.tools.variant.resourcelibrary.handlers.commands.SetNoteCommand;
import com.nokia.tools.variant.resourcelibrary.model.Directory;
import com.nokia.tools.variant.resourcelibrary.model.File;
import com.nokia.tools.variant.resourcelibrary.model.FileSystemElement;
import com.nokia.tools.variant.resourcelibrary.model.resourcesPackage;
import com.nokia.tools.variant.resourcelibrary.views.ResourceStorage;

/**
 * This class provides control from the Resource Library part for the properties
 * view. With first display of properties, the components are created. The UI is
 * build according to file type and according to existence of the property, the
 * property is displayed or not. Basically, we differentiate four types of file
 * - AUDIO, IMAGE, VIDEO, OTHERS. Folder has only location and note.
 * 
 */
public class ResourceLibraryPropertySection extends AutoSizePropertySection
		 {

	private Composite control;
	private Section section;
	private Adapter adapter;

	private CutAction cutAction;
	private CopyAction copyAction;
	private PasteAction pasteAction;
	private DeleteAction deleteAction;

	private ChangeableLabelFieldEditor resourceLocation;
	private ChangeableLabelFieldEditor resourceSize;

	private ChangeableLabelFieldEditor mediaDuration;
	private ChangeableLabelFieldEditor videoCodec;
	private ChangeableLabelFieldEditor videoFramerate;
	private ChangeableLabelFieldEditor audioCodec;
	private ChangeableLabelFieldEditor audioFramerate;
	private ChangeableLabelFieldEditor audioChannels;
	private ChangeableLabelFieldEditor audioSampleRate;
	private ChangeableLabelFieldEditor imageSize;
	private ChangeableLabelFieldEditor imageColorDepth;
	private ChangeableLabelFieldEditor imageFrameCount;

	private HyperlinkFieldEditor referred;

	private ResourceStorage resourceStorage;
	private StringFieldEditor notes;
	private FileSystemElement fileSystemElement;
	private Composite mainComposite;
	private FormToolkit toolkit;
	private GridLayout gridLayout;
	private GridData gd;

	/**
	 * 
	 */
	public ResourceLibraryPropertySection() {
	}

	@Override
	protected void doRefresh() {
		if (fileSystemElement != null) {
			fileSystemElement.eAdapters().remove(adapter);
		}

		// dispose properties of the older selection
		if (mainComposite != null)
			mainComposite.dispose();

		mainComposite = toolkit.createComposite(control);
		mainComposite.setLayout(gridLayout);
		mainComposite.setLayoutData(gd);

		IStructuredSelection selection = (IStructuredSelection) getSelection();
		Object firstElement = selection.getFirstElement();

		if ((firstElement instanceof ResourceStorage)) {
			resourceStorage = (ResourceStorage) firstElement;
			fileSystemElement = resourceStorage.getFileSystemElement();

			// common for all types of files and folder
			section.setText(fileSystemElement.getName());
			if (fileSystemElement instanceof File) {
				resourceLocation.setTextValue(((File) fileSystemElement)
						.getPath());
				resourceLocation.fillIntoGrid(mainComposite, 3, toolkit);

				resourceSize
						.setTextValue(getNiceFormatSize(((File) fileSystemElement)
								.getSize()));
				resourceSize.fillIntoGrid(mainComposite, 3, toolkit);

				String note = fileSystemElement.getNote();
				if (note != null) {
					notes.setTextValue(note);
				} else {
					notes.setTextValue("");
				}

			} else if (fileSystemElement instanceof Directory) {
				Directory directory = (Directory) fileSystemElement;
				resourceLocation.setTextValue((directory.getPath()));
				resourceLocation.fillIntoGrid(mainComposite, 3, toolkit);

				long size = 0;
				size = getSizeOfDirectory(directory);
				String niceFormatSize = getNiceFormatSize(size);
				resourceSize.setTextValue(niceFormatSize);
				resourceSize.fillIntoGrid(mainComposite, 3, toolkit);

				String note = fileSystemElement.getNote();
				if (note != null) {
					notes.setTextValue(note);
				} else {
					notes.setTextValue("");
				}
			}

			IContentDescription descr = (IContentDescription) resourceStorage
					.getAdapter(IContentDescription.class);

			IContentType baseType = null;
			if (descr != null) {
				baseType = descr.getContentType().getBaseType();
			}

			if (MediaUIPlugin.CT_AUDIO.equals(baseType)) {
				Double durationInDouble = (Double) descr
						.getProperty(MediaUIPlugin.DURATION);
				mediaDuration.setTextValue(getMediaDuration(durationInDouble));
				audioCodec.setTextValue(String.valueOf(descr
						.getProperty(MediaUIPlugin.AUDIO_CODEC)));
				audioChannels.setTextValue(String.valueOf(descr
						.getProperty(MediaUIPlugin.AUDIO_CHANNELS)));
				audioFramerate.setTextValue(String.valueOf(descr
						.getProperty(MediaUIPlugin.AUDIO_FRAMERATE)));
				audioSampleRate.setTextValue(String.valueOf(descr
						.getProperty(MediaUIPlugin.AUDIO_SAMPLERATE)));

				mediaDuration.fillIntoGrid(mainComposite, 3, toolkit);
				audioCodec.fillIntoGrid(mainComposite, 3, toolkit);
				audioChannels.fillIntoGrid(mainComposite, 3, toolkit);
				audioFramerate.fillIntoGrid(mainComposite, 3, toolkit);
				audioSampleRate.fillIntoGrid(mainComposite, 3, toolkit);
			}

			if (MediaUIPlugin.CT_IMAGE.equals(baseType)) {
				String width = descr.getProperty(MediaUIPlugin.VIDEO_WIDTH)
						.toString();
				String height = descr.getProperty(MediaUIPlugin.VIDEO_HEIGHT)
						.toString();
				imageSize.setTextValue(width + "x" + height + " px");
				imageSize.fillIntoGrid(mainComposite, 3, toolkit);

				// no Color Depth for SVG images
				if (!("com.nokia.tools.variant.contenttype.image.svg"
						.equals(descr.getContentType().toString()))) {
					imageColorDepth.setTextValue(String.valueOf(descr
							.getProperty(MediaUIPlugin.COLOR_DEPTH))
							+ " bits");
					imageColorDepth.fillIntoGrid(mainComposite, 3, toolkit);
				}

				imageFrameCount.setTextValue(String.valueOf(descr
						.getProperty(MediaUIPlugin.FRAME_COUNT)));
				imageFrameCount.fillIntoGrid(mainComposite, 3, toolkit);
			}

			if (MediaUIPlugin.CT_VIDEO.equals(baseType)) {
				Double durationInDouble = (Double) descr
						.getProperty(MediaUIPlugin.DURATION);
				mediaDuration.setTextValue(getMediaDuration(durationInDouble));
				videoCodec.setTextValue(String.valueOf(descr
						.getProperty(MediaUIPlugin.VIDEO_CODEC)));
				videoFramerate.setTextValue(String.valueOf(descr
						.getProperty(MediaUIPlugin.VIDEO_FRAMERATE))
						+ " fps");
				Object videoWidth = descr
						.getProperty(MediaUIPlugin.VIDEO_WIDTH);
				String width = videoWidth != null ? videoWidth.toString() : "";
				Object videoHeight = descr
						.getProperty(MediaUIPlugin.VIDEO_HEIGHT);
				String height = videoHeight != null ? videoHeight.toString()
						: "";
				if (width != "" && height != "") {
					imageSize.setTextValue(width + "x" + height + " px");
				} else {
					imageSize.setTextValue("null");
				}

				imageSize.fillIntoGrid(mainComposite, 3, toolkit);
				mediaDuration.fillIntoGrid(mainComposite, 3, toolkit);
				videoCodec.fillIntoGrid(mainComposite, 3, toolkit);
				videoFramerate.fillIntoGrid(mainComposite, 3, toolkit);
			}

			EList<Setting> settings = fileSystemElement.getSettings();

			adapter = new AdapterImpl() {

				public void notifyChanged(Notification notification) {

					if (notification.getFeatureID(FileSystemElement.class) == resourcesPackage.FILE_SYSTEM_ELEMENT__SETTINGS) {
						if (notification.getEventType() == Notification.ADD
								|| notification.getEventType() == Notification.REMOVE) {
							refresh();
						}

					}
					super.notifyChanged(notification);
				}
			};

			fileSystemElement.eAdapters().add(adapter);

			if (!settings.isEmpty()) {
				Iterator<Setting> it = settings.iterator();
				Setting firstReferredSetting = it.next();
				if (firstReferredSetting instanceof FileSystemEntrySetting) {
					firstReferredSetting = ((FileSystemEntrySetting) firstReferredSetting)
							.getSourceFilePath();
				}
				if (firstReferredSetting.isVisible()) {
					referred = new HyperlinkFieldEditor(SWT.WRAP,
							firstReferredSetting, "Referred from:");					
					referred.fillIntoGrid(mainComposite, 3, toolkit);
				}

				while (it.hasNext()) {
					Setting nextReferrefSetting = it.next();
					if (nextReferrefSetting instanceof FileSystemEntrySetting) {
						nextReferrefSetting = ((FileSystemEntrySetting) nextReferrefSetting)
								.getSourceFilePath();
					}
					if (nextReferrefSetting.isVisible()){
						referred = new HyperlinkFieldEditor(SWT.WRAP,
								nextReferrefSetting, null);
						referred.fillIntoGrid(mainComposite, 3, toolkit);
					}
				}
			}

			addNoteField();

			createActions(notes);

			MenuManager mm = new MenuManager();
			mm.addMenuListener(new MenuListener(notes.getTextControl()));
			mm.setRemoveAllWhenShown(true);
			Menu menu = mm.createContextMenu(notes.getTextControl());
			notes.getTextControl().setMenu(menu);
		}
	}

	private void createActions(Object control) {
		ViewPart findView = (ViewPart) PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage().findView(
						"org.eclipse.ui.views.PropertySheet");

		cutAction = new CutAction(control);
		((CutAction) cutAction).init();
		findView.getViewSite().getActionBars().setGlobalActionHandler(
				ActionFactory.CUT.getId(), cutAction);

		copyAction = new CopyAction(control);
		((CopyAction) copyAction).init();
		findView.getViewSite().getActionBars().setGlobalActionHandler(
				ActionFactory.COPY.getId(), copyAction);

		pasteAction = new PasteAction(control);
		((PasteAction) pasteAction).init();
		findView.getViewSite().getActionBars().setGlobalActionHandler(
				ActionFactory.PASTE.getId(), pasteAction);

		deleteAction = new DeleteAction(control);
		((DeleteAction) deleteAction).init();
		findView.getViewSite().getActionBars().setGlobalActionHandler(
				ActionFactory.DELETE.getId(), deleteAction);
	}

	private long totalSize = 0;

	private long getSizeOfDirectory(Directory directory) {
		totalSize = 0;
		long size = 0;
		EList<FileSystemElement> childrens = directory.getChildren();
		for (FileSystemElement fileSystemElement : childrens) {
			if (fileSystemElement instanceof Directory) {
				totalSize += getSizeOfDirectory((Directory) fileSystemElement);
			} else {
				size = ((File) fileSystemElement).getSize();
				totalSize += size;
			}
		}
		return totalSize;
	}

	private String getMediaDuration(Double time) {
		if (time == null) {
			return "";
		}

		String duration = "";
		Calendar calendar = Calendar.getInstance();
		Double multiplier = 1000.0;

		calendar.setTimeInMillis((long) (time * multiplier));
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		int milis = calendar.get(Calendar.MILLISECOND);
		String milisResult = String.valueOf(milis);

		if (minute != 0) {
			duration = minute + " m " + second + " s " + milisResult + " ms";
		} else {
			duration = second + " s " + milisResult + " ms";
		}

		return duration;
	}

	private void addNoteField() {
		String note = fileSystemElement.getNote();
		if (note != null) {
			notes.setTextValue(note);
		} else {
			notes.setTextValue("");
		}
		notes.fillIntoGrid(mainComposite, 3, toolkit);
		LayoutUtil.setHorizontalSpan(notes.getTextControl(), 3);
		notes.addObserver(new Observer() {
			public void update(Observable o, Object arg) {

				IStructuredSelection selection = (IStructuredSelection) getSelection();
				Object firstElement = selection.getFirstElement();

				if ((firstElement instanceof ResourceStorage)) {
					resourceStorage = (ResourceStorage) firstElement;

					fileSystemElement = resourceStorage.getFileSystemElement();

					String textValue = notes.getTextValue();
					String note = fileSystemElement.getNote();

					if (note == null) {
						note = "";
					}
					if (textValue != null && !textValue.equals(note)) {
						SetNoteCommand command = new SetNoteCommand(
								fileSystemElement, textValue);

						IEditorPart activeEditor = PlatformUI.getWorkbench()
								.getActiveWorkbenchWindow().getActivePage()
								.getActiveEditor();

						if (activeEditor != null) {
							Object adapter = activeEditor
									.getAdapter(CommandStack.class);
							if (adapter instanceof CommandStack) {
								((CommandStack) adapter).execute(command);
							}
						} else {
							command.execute();
						}
					}
				}
			}
		});

	}

	private String getNiceFormatSize(long size) {

		if (size < 1024) {
			return String.valueOf(size) + " B";
		}

		String result = "" + size / 1024;

		int length = result.length();
		if (length > 3) {
			if (length > 6) {
				result = result.subSequence(0, length - 6) + " "
						+ result.subSequence(length - 6, length - 3) + " "
						+ result.subSequence(length - 3, length);
			} else {
				result = result.subSequence(0, length - 3) + " "
						+ result.subSequence(length - 3, length);

			}
		}
		result = result + " KB";
		return result;
	}

	protected void createSpecificControls(Composite parent,
			TabbedPropertySheetPage tabbedPropertySheetPage) {

		toolkit = new FormToolkit(parent.getDisplay());
		toolkit.setBorderStyle(SWT.NULL);
		control = toolkit.createComposite(parent);
		GridLayout layout = new GridLayout(1, false);
		layout.marginHeight = layout.marginWidth = 0;
		control.setLayout(layout);
		section = toolkit.createSection(control, Section.TITLE_BAR);
		section.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

		// GridLayout and griddata for mainComposite
		gd = new GridData(SWT.FILL, SWT.TOP, true, false);
		gd.horizontalIndent = 5;
		gridLayout = new GridLayout(3, false);

		resourceLocation = new ChangeableLabelFieldEditor(SWT.WRAP);
		resourceLocation.setLabelText("Location:");

		resourceSize = new ChangeableLabelFieldEditor(SWT.WRAP);
		resourceSize.setLabelText("Size:");

		mediaDuration = new ChangeableLabelFieldEditor(SWT.WRAP);
		mediaDuration.setLabelText("Media Duration:");

		videoCodec = new ChangeableLabelFieldEditor(SWT.WRAP);
		videoCodec.setLabelText("Video Codec:");

		videoFramerate = new ChangeableLabelFieldEditor(SWT.WRAP);
		videoFramerate.setLabelText("Video Frame Rate:");

		audioCodec = new ChangeableLabelFieldEditor(SWT.WRAP);
		audioCodec.setLabelText("Audio Codec:");

		audioFramerate = new ChangeableLabelFieldEditor(SWT.WRAP);
		audioFramerate.setLabelText("Audio Frame Rate:");

		audioChannels = new ChangeableLabelFieldEditor(SWT.WRAP);
		audioChannels.setLabelText("Audio Channels:");

		audioSampleRate = new ChangeableLabelFieldEditor(SWT.WRAP);
		audioSampleRate.setLabelText("Audio Sample Rate:");

		imageSize = new ChangeableLabelFieldEditor(SWT.WRAP);
		imageSize.setLabelText("Image Size:");

		imageColorDepth = new ChangeableLabelFieldEditor(SWT.WRAP);
		imageColorDepth.setLabelText("Image Color Depth:");

		imageFrameCount = new ChangeableLabelFieldEditor(SWT.WRAP);
		imageFrameCount.setLabelText("Frame Count:");

		notes = new StringFieldEditor(SWT.MULTI | SWT.WRAP | SWT.BORDER
				| SWT.V_SCROLL);
		notes.setLabelText("Note:");
		notes.setEditable(true);
	}

	class MenuListener implements IMenuListener {
		private Control parent;

		public MenuListener(Control parent) {
			this.parent = parent;
		}

		public void menuAboutToShow(IMenuManager menu) {
			contextMenuAboutToShow(menu, parent);
		}

		protected void contextMenuAboutToShow(IMenuManager menu, Control parent) {
			menu.add(new Separator());
			menu.add(cutAction);
			menu.add(copyAction);
			menu.add(pasteAction);
			menu.add(deleteAction);
			menu.add(new Separator());

			cutAction.setEnabled(true);
			copyAction.setEnabled(true);
			pasteAction.setEnabled(true);
			deleteAction.setEnabled(true);
		}
	}

	



	@Override
	public void dispose() {
		if (section != null) {
			section.dispose();
		}
		if (fileSystemElement != null) {
			fileSystemElement.eAdapters().remove(adapter);
		}
		super.dispose();
	}
		
}
