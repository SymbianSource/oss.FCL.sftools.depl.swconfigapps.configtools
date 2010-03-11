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

package com.nokia.tools.variant.editor.adapters;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import org.apache.batik.transcoder.TranscoderInput;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.util.SafeRunnable;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

import com.nokia.tools.content.core.IContentData;
import com.nokia.tools.variant.common.core.utils.FileUtils;
import com.nokia.tools.variant.content.confml.ConfmlFactory;
import com.nokia.tools.variant.content.confml.FilePath;
import com.nokia.tools.variant.content.confml.FileSystemEntrySetting;
import com.nokia.tools.variant.content.confml.Setting;
import com.nokia.tools.variant.content.confml.SimpleSetting;
import com.nokia.tools.variant.content.confml.TYPE;
import com.nokia.tools.variant.content.confml.View;
import com.nokia.tools.variant.media.ui.MediaUIPlugin;
import com.nokia.tools.variant.media.ui.preview.FrameAnimationDescriptor;
import com.nokia.tools.variant.media.ui.svg.SVGImage;
import com.nokia.tools.variant.preview.IPreviewDescriptor;
import com.nokia.tools.variant.preview.NoDefThemeContentDescriptor;
import com.nokia.tools.variant.preview.theme.ThemeDescriptor;
import com.nokia.tools.variant.preview.theme.ThemePreviewController;
import com.nokia.tools.variant.preview.theme.ThemeDescriptor.ElementOverride;
import com.nokia.tools.variant.resourcelibrary.model.FileSystemElement;
import com.nokia.tools.variant.resourcelibrary.model.ResourceModelRoot;
import com.nokia.tools.variant.resourcelibrary.resources.ResourceUtil;
import com.nokia.tools.variant.resourcelibrary.views.ResourceStorage;

/**
 * Provides "get" methods for given parameters (elements) <br/>
 * <li>Descriptors type according to the settings ref</li> <li>Descriptors for
 * Right soft key customization</li> <br/>
 * <br/>
 * 
 * @see org.eclipse.core.runtime.IAdapterFactory
 */
public class FileSetting2PreviewAdapterFactory implements IAdapterFactory {
	static final Class<?>[] adapters = { IPreviewDescriptor.class };
	private static final String DEFAULT_THEME_FEATURE_REF = "CVC_Theme_ref";
	private static final String DEFAULT_THEME_SETTING_REF = "CVC_DefaultTheme_ref";

	private static final String APPSHELL_FEATURE_REF = "CVC_AppShell323";
	private static final String APPSHELL_FOLDER_SETTING_ABSREF = "CVC_AppShell323/CVC_AppShell323";
	private static final String APPSHELL_GRID_X_SETTING_ABSREF = "CVC_AppShell323/CVC_AppShell323X";
	private static final String APPSHELL_GRID_Y_SETTING_ABSREF = "CVC_AppShell323/CVC_AppShell323Y";

	private static final String OPERATOR_MENU_ICON_FEATURE_REF = "CVC_OperatorMenu";
	private static final String OPERATOR_MENU_ICON_FILE_SETTING_REF = "CVC_OperatorMenuIconFile";
	private static final String OPERATOR_MENU_ICON_MASK_FILE_SETTING_REF = "CVC_OperatorMenuIconMaskFile";
	private static final String ANIMATION = "AnimationSequence";
	private static final CharSequence FRAME_LOCATION = "FrameLocation";
	private static final CharSequence ANIMATION_TONE = "AnimationTone";
	private static final CharSequence ANIMATIONDURATION = "AnimationDuration";

	private static final String RSK_FEATURE_REF = "CVC_RSK";
	private static final String RSK_IDLE_SCREEN_ID = "Idle";
	private static final String RSK_ICON_FILE_SETTING_ID = "CVC_ActiveIdleRSKImage";
	private static final String RSK_ICON_FILE_MASK_SETTING_ID = "CVC_ActiveIdleRSKImageBMPMask";
	private static final String RSK_TEXT_SETTING_ID = "CVC_ActiveIdleRSKText";
	// private static final String RSK_IDLE_ICON_ID = "qgn_rsk_idle_icon";
	// private static final String RSK_IMAGE_ID = "control_pane_g2";//
	// "qgn_graf_sk_right";//"text16";//"qgn_rsk_idle_icon";

	private static String iconFilePath, maskFilePath, themeFilePath;
	private static File graphicsFile = null;
	private static File audioFile = null;
	private static String graphicsFilePath;
	private static String audioFilePath;
	protected static File[] files;
	private boolean noTheme = false;

	/**
	 * This method returns the descriptor type according to the settings ref.
	 */
	@SuppressWarnings("unchecked")
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if (adaptableObject instanceof FilePath) {
			FilePath fileSetting = (FilePath) adaptableObject;

			FilePath sourceFile = fileSetting.getParent().getSourceFilePath();
			if (fileSetting != sourceFile) {
				// there was selected target path to which we don't react
				return null;
			}

			String absRef = fileSetting.getAbsRef();
			if (absRef == null || absRef.indexOf('/') < 0) {
				return null;
			}
			String featureRef = absRef.substring(0, absRef.indexOf('/'));
			if (featureRef.equals(APPSHELL_FEATURE_REF)) {
				IPreviewDescriptor descr = createAppshellPreview(fileSetting);

				return descr;
			}

			if (featureRef.endsWith(ANIMATION)) {
				IPreviewDescriptor descr = createAnimationDescriptor(fileSetting);
				if (descr != null) {
					return descr;
				} else {
					return null;
				}
			}
			if (featureRef.equals(OPERATOR_MENU_ICON_FEATURE_REF)) {
				IPreviewDescriptor descr = createCustomerMenuIconDescriptor(fileSetting);
				if (descr != null) {
					return descr;
				} else {
					if (noTheme) {
						NoDefThemeContentDescriptor ucd = new NoDefThemeContentDescriptor();
						return ucd;
					} else {
						return null;
					}
				}
			}

			if (featureRef.equals(RSK_FEATURE_REF)) {
				IPreviewDescriptor descr = createRskDescriptor(fileSetting);
				if (descr != null) {
					return descr;
				} else {
					if (noTheme) {
						NoDefThemeContentDescriptor ucd = new NoDefThemeContentDescriptor();
						return ucd;
					}
				}
			}

			IEditorPart editor = PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow().getActivePage()
					.getActiveEditor();
			if (editor != null) {
				Object adapter = editor.getAdapter(ResourceModelRoot.class);
				if (adapter instanceof ResourceModelRoot) {
					FilePath sourceFilePath = fileSetting.getParent()
							.getSourceFilePath();
					String path = sourceFilePath.getPath();
					String choosenOption = sourceFilePath.getChoosenOption();
					if (choosenOption != null) {
						path = choosenOption;
					}
					FileSystemElement fse = ResourceUtil.getFileSystemElement(
							(ResourceModelRoot) adapter, path);
					if (fse != null) {
						ResourceStorage rs = new ResourceStorage(fse);
						return Platform.getAdapterManager().getAdapter(rs,
								adapterType);
					}
				}
			}

		} else if (adaptableObject instanceof SimpleSetting) {
			SimpleSetting ss = (SimpleSetting) adaptableObject;
			String value = (ss.getChoosenOption() != null) ? ss
					.getChoosenOption() : ss.getValue();
			String absRef = ss.getAbsRef();
			if (absRef == null || absRef.indexOf('/') < 0) {
				return null;
			}
			String featureRef = absRef.substring(0, absRef.indexOf('/'));

			if (featureRef.equals(APPSHELL_FEATURE_REF)) {
				IPreviewDescriptor descr = createAppshellPreview(ss);

				return descr;
			}

			if (featureRef.endsWith(ANIMATION)) {
				IPreviewDescriptor descr = createAnimationDescriptor(ss);
				if (descr != null) {
					return descr;
				}
			}
			if (featureRef.equals(OPERATOR_MENU_ICON_FEATURE_REF)) {
				IPreviewDescriptor descr = createCustomerMenuIconDescriptor(ss);
				if (descr != null) {
					return descr;
				} else {
					NoDefThemeContentDescriptor ucd = new NoDefThemeContentDescriptor();
					return ucd;
				}
			}

			if (featureRef.equals(RSK_FEATURE_REF)) {
				IPreviewDescriptor descr = createRskDescriptor(ss);
				if (descr != null) {
					return descr;
				} else {
					if (noTheme) {
						NoDefThemeContentDescriptor ucd = new NoDefThemeContentDescriptor();
						return ucd;
					}
				}
			}

			IEditorPart editor = PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow().getActivePage()
					.getActiveEditor();
			if (editor != null) {
				if (ss.getType().equals(TYPE.SIMPLE_FILE)
						|| (ss.getType().equals(TYPE.SIMPLE_FOLDER))) {
					Object adapter = editor.getAdapter(ResourceModelRoot.class);
					if (adapter instanceof ResourceModelRoot) {
						FileSystemElement fse = ResourceUtil
								.getFileSystemElement(
										(ResourceModelRoot) adapter, value);
						if (fse != null) {
							ResourceStorage rs = new ResourceStorage(fse);
							return Platform.getAdapterManager().getAdapter(rs,
									adapterType);
						}
					}
				}
			}

		}
		return null;
	}

	/**
	 * Returns new created descriptor for Right soft key customization.
	 * 
	 * @param set setting from selection
	 * @return theme descriptor for {@link ThemePreviewController} or null if no
	 *         default theme is set
	 */
	private IPreviewDescriptor createRskDescriptor(Setting set) {
		iconFilePath = null;
		maskFilePath = null;
		themeFilePath = null;
		View view = null;
		if (set instanceof FilePath) {
			set = ((FilePath) set).getParent();
			view = (View) set.eContainer();
		} else {
			view = (View) set.eContainer();
		}

		EList<Setting> sharedSettingInstances = view
				.getSharedSettingInstances();
		FileSystemEntrySetting iconSetting = null;
		FileSystemEntrySetting maskSetting = null;
		FileSystemEntrySetting defaultThemeSetting = null;
		String settingValue = null;

		IEditorPart editor = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		ResourceModelRoot rmr = null;
		if (editor != null) {
			Object adapter = editor.getAdapter(ResourceModelRoot.class);
			if (adapter instanceof ResourceModelRoot) {
				rmr = (ResourceModelRoot) adapter;
			}
		}
		if (rmr != null)
			for (Setting setting : sharedSettingInstances) {
				if (setting.getAbsRef().endsWith(RSK_ICON_FILE_SETTING_ID)) {
					if (setting instanceof FileSystemEntrySetting) {
						iconSetting = (FileSystemEntrySetting) setting;
						iconFilePath = rmr.getTempDirPath() + File.separator
								+ iconSetting.getSourceFilePath().getPath();
					} else {
						iconFilePath = rmr.getTempDirPath() + File.separator
								+ ((SimpleSetting) setting).getValue();
					}
				}
				if (setting.getAbsRef().endsWith(RSK_ICON_FILE_MASK_SETTING_ID)) {
					if (setting instanceof FileSystemEntrySetting) {
						maskSetting = (FileSystemEntrySetting) setting;
						maskFilePath = rmr.getTempDirPath() + File.separator
								+ maskSetting.getSourceFilePath().getPath();
					} else {
						maskFilePath = rmr.getTempDirPath() + File.separator
								+ ((SimpleSetting) setting).getValue();
					}

				}
				if (setting.getAbsRef().endsWith(RSK_TEXT_SETTING_ID)) {
					if (setting instanceof SimpleSetting) {
						settingValue = ((SimpleSetting) setting).getValue();
					}
				}
				if (setting.getFeatureRef().equals(DEFAULT_THEME_FEATURE_REF)
						&& setting.getSettingRef().equals(
								DEFAULT_THEME_SETTING_REF)) {
					if (setting instanceof FileSystemEntrySetting) {
						defaultThemeSetting = (FileSystemEntrySetting) setting;
						themeFilePath = defaultThemeSetting.getSourceFilePath()
								.getPath();
					} else {
						themeFilePath = ((SimpleSetting) setting).getValue();
					}
				}
			}
		if (themeFilePath == null) {
			noTheme = true;
			return null;
		}

		if (!"tpf".equalsIgnoreCase(FileUtils.getExtension(themeFilePath))) {
			noTheme = true;
			return null;
		}

		ThemeDescriptor descriptor = null;
		if (iconSetting != null
				&& iconSetting.getSourceFilePath().getPath() != null
				&& iconSetting.getSourceFilePath().getPath() != "") {

			ImageData iconImage = loadImage(iconFilePath);

			boolean needsMask = false;
			if (iconSetting.getSourceFilePath().getPath() != null
					&& iconSetting.getSourceFilePath().getPath() != "") {
				needsMask = "bmp".equalsIgnoreCase(FileUtils
						.getExtension(iconFilePath));
			}

			ImageData maskImage;
			if (needsMask && maskSetting != null) {
				maskImage = loadImage(maskFilePath);
			} else {
				maskImage = null;
			}

			if (editor != null) {
				Object adapter = editor.getAdapter(ResourceModelRoot.class);
				if (adapter instanceof ResourceModelRoot) {
					FileSystemElement fse = ResourceUtil.getFileSystemElement(
							(ResourceModelRoot) adapter, themeFilePath);
					if (fse != null) {
						ResourceStorage rs = new ResourceStorage(fse);
						if (iconImage == null && settingValue == null) {
							descriptor = new ThemeDescriptor(rs,
									new ScreenFilter(RSK_IDLE_SCREEN_ID));
						} else {
							ElementOverride override;
							if (set.getAbsRef().endsWith(RSK_TEXT_SETTING_ID)
									&& settingValue != null
									&& settingValue != "") {
								override = new ElementOverride(null, null,
										settingValue);
							} else {
								override = new ElementOverride(iconImage,
										maskImage, settingValue);
							}
							descriptor = new ThemeDescriptor(rs,
									new ScreenFilter(RSK_IDLE_SCREEN_ID),
									override);
						}
					}
				}
			}
		} else {
			if (editor != null) {
				Object adapter = editor.getAdapter(ResourceModelRoot.class);
				if (adapter instanceof ResourceModelRoot) {
					FileSystemElement fse = ResourceUtil.getFileSystemElement(
							(ResourceModelRoot) adapter, themeFilePath);
					if (fse != null) {
						ResourceStorage rs = new ResourceStorage(fse);
						ElementOverride override = null;
						if (settingValue != null && settingValue != "") {
							override = new ElementOverride(null, null,
									settingValue);
						} else {
							override = new ElementOverride(null, null,
									settingValue);
							descriptor = new ThemeDescriptor(rs,
									new ScreenFilter(RSK_IDLE_SCREEN_ID),
									override);
						}
						descriptor = new ThemeDescriptor(rs, new ScreenFilter(
								RSK_IDLE_SCREEN_ID), override);
					}
				}
			}
		}
		if (descriptor != null) {
			descriptor.setRsk(true);
		}
		return descriptor;
	}

	/**
	 * Returns new created descriptor for appshell.
	 * 
	 * @param setting setting from selection
	 * @return {@link AppshellSettingPreviewDescriptor} or null if there is some
	 *         error
	 */
	private IPreviewDescriptor createAppshellPreview(Setting setting) {
		View view = null;
		if (setting instanceof FilePath) {
			setting = ((FilePath) setting).getParent();
			view = (View) setting.eContainer();
		} else {
			view = (View) setting.eContainer();
		}
		EList<Setting> sharedSettingInstances = view
				.getSharedSettingInstances();

		SimpleSetting gridSizeXSetting = null;
		SimpleSetting gridSizeYSetting = null;
		FileSystemEntrySetting folderSetting = null;

		for (Setting shared : sharedSettingInstances) {
			String absRef = shared.getAbsRef();
			if (absRef.equals(APPSHELL_FOLDER_SETTING_ABSREF)) {
				if (shared instanceof FileSystemEntrySetting) {
					folderSetting = ((FileSystemEntrySetting) shared);
				}
			} else if (absRef.equals(APPSHELL_GRID_X_SETTING_ABSREF)) {
				if (shared instanceof SimpleSetting) {
					SimpleSetting ss = (SimpleSetting) shared;
					if (ss.getType() == TYPE.INT) {
						gridSizeXSetting = (SimpleSetting) shared;
					}
				}
			} else if (absRef.equals(APPSHELL_GRID_Y_SETTING_ABSREF)) {
				if (shared instanceof SimpleSetting) {
					SimpleSetting ss = (SimpleSetting) shared;
					if (ss.getType() == TYPE.INT) {
						gridSizeYSetting = (SimpleSetting) shared;
					}
				}
			}
		}

		if (folderSetting == null) {
			return null;
		}

		int sizeX = getSettingValue(gridSizeXSetting, 3);
		int sizeY = getSettingValue(gridSizeYSetting, 6);

		IEditorPart editor = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if (editor == null) {
			return null;
		}
		Object adapter = editor.getAdapter(ResourceModelRoot.class);
		if (!(adapter instanceof ResourceModelRoot)) {
			return null;
		}

		ResourceModelRoot rmr = (ResourceModelRoot) adapter;
		String pathStr = folderSetting.getSourceFilePath().getPath();
		if (pathStr == null) {

			pathStr = folderSetting.getSourceFilePath().getDefaultPath();
		}
		if (pathStr == null) {
			pathStr = "$XXX$";
		}

		IPath path = new Path(pathStr).append("appshelldata.xml");

		File dir = new File(rmr.getTempDirPath());
		File file = new File(dir, path.toOSString());

		return new AppshellSettingPreviewDescriptor(editor, file, sizeX, sizeY);
	}

	/**
	 * Returns the value from setting
	 * 
	 * @param setting from which we want to get the value
	 * @return the value or default value if the value is null
	 */
	private String getSettingValue(SimpleSetting setting) {
		if (setting == null) {
			return null;
		} else if (setting.getValue() != null) {
			return setting.getValue();
		} else {
			return setting.getDefaultValue();
		}
	}

	/**
	 * Returns the value from setting
	 * 
	 * @param setting from which we want to get the value
	 * @param def default, if getSettingValue(setting) returns null of exception
	 * @return the value or default value if the value is null
	 */
	private int getSettingValue(SimpleSetting setting, int def) {
		String literal = getSettingValue(setting);

		if (literal == null) {
			return def;
		} else {
			try {
				return Integer.parseInt(literal);
			} catch (Exception ex) {
				return def;
			}
		}
	}

	/**
	 * Override menu icon in the screen from Default Theme
	 * 
	 * @param set setting from selection
	 * @return theme descriptor for {@link ThemePreviewController} or null if no
	 *         default theme is set
	 */
	public static IPreviewDescriptor createCustomerMenuIconDescriptor(
			Setting set) {

		View view = null;
		if (set instanceof FilePath) {
			set = ((FilePath) set).getParent();
			view = (View) set.eContainer();
		} else {
			view = (View) set.eContainer();
		}

		EList<Setting> sharedSettingInstances = view
				.getSharedSettingInstances();
		FileSystemEntrySetting iconSetting = null;
		FileSystemEntrySetting maskSetting = null;
		FileSystemEntrySetting defaultThemeSetting = null;
		iconFilePath = null;
		maskFilePath = null;
		themeFilePath = null;
		IEditorPart editor = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		ResourceModelRoot rmr = null;
		if (editor != null) {
			Object adapter = editor.getAdapter(ResourceModelRoot.class);
			if (adapter instanceof ResourceModelRoot) {
				rmr = (ResourceModelRoot) adapter;
			}
		}
		for (Setting setting : sharedSettingInstances) {
			if (setting.getAbsRef().endsWith(
					OPERATOR_MENU_ICON_FILE_SETTING_REF)) {
				if (setting instanceof FileSystemEntrySetting) {
					iconSetting = (FileSystemEntrySetting) setting;
					iconFilePath = rmr.getTempDirPath() + File.separator
							+ iconSetting.getSourceFilePath().getPath();
				} else {
					iconFilePath = rmr.getTempDirPath() + File.separator
							+ ((SimpleSetting) setting).getValue();
				}
			}
			if (setting.getAbsRef().endsWith(
					OPERATOR_MENU_ICON_MASK_FILE_SETTING_REF)) {
				if (setting instanceof FileSystemEntrySetting) {
					maskSetting = (FileSystemEntrySetting) setting;
					maskFilePath = rmr.getTempDirPath() + File.separator
							+ maskSetting.getSourceFilePath().getPath();
				} else {
					maskFilePath = rmr.getTempDirPath() + File.separator
							+ ((SimpleSetting) setting).getValue();
				}

			}
			if (setting.getFeatureRef().equals(DEFAULT_THEME_FEATURE_REF)
					&& setting.getSettingRef()
							.equals(DEFAULT_THEME_SETTING_REF)) {
				if (setting instanceof FileSystemEntrySetting) {
					defaultThemeSetting = (FileSystemEntrySetting) setting;
					themeFilePath = defaultThemeSetting.getSourceFilePath()
							.getPath();
				} else {
					themeFilePath = ((SimpleSetting) setting).getValue();
				}
			}
		}
		if (themeFilePath == null) {
			return null;
		}

		if (!"tpf".equalsIgnoreCase(FileUtils.getExtension(themeFilePath))) {
			return null;
		}
		ImageData iconImage = null;
		if (iconFilePath != null) {
			iconImage = loadImage(iconFilePath);
		}

		boolean needsMask = false;
		if (iconSetting.getSourceFilePath().getPath() != null) {
			needsMask = "bmp".equalsIgnoreCase(FileUtils
					.getExtension(iconFilePath));
		}

		ImageData maskImage = null;
		if (needsMask) {
			if (maskFilePath != null) {
				maskImage = loadImage(maskFilePath);
			}
		} else {
			maskImage = null;
		}

		ThemeDescriptor descriptor = null;
		if (editor != null) {
			Object adapter = editor.getAdapter(ResourceModelRoot.class);
			if (adapter instanceof ResourceModelRoot) {
				FileSystemElement fse = ResourceUtil.getFileSystemElement(
						(ResourceModelRoot) adapter, themeFilePath);
				if (fse != null) {
					ResourceStorage rs = new ResourceStorage(fse);
					if (iconImage == null) {
						descriptor = new ThemeDescriptor(rs, new ScreenFilter(
								ThemeDescriptor.APPSHELL_SCREEN_ID));
					} else {
						ElementOverride override = new ElementOverride(
								ElementOverride.OPERATIOR_ICON_ID, iconImage,
								maskImage);
						descriptor = new ThemeDescriptor(rs, new ScreenFilter(
								ThemeDescriptor.APPSHELL_SCREEN_ID), override);
					}
				}
			}
		}

		return descriptor;
	}

	/**
	 * Returns the generated {@link FrameAnimationDescriptor} which consists
	 * from frames and audio file
	 * 
	 * @param set selected setting
	 * @return
	 */
	public static IPreviewDescriptor createAnimationDescriptor(Setting set) {
		if (set instanceof FilePath) {
			set = (Setting) set.eContainer();
		}
		View view = (View) set.eContainer();
		EList<Setting> sharedSettingInstances = view
				.getSharedSettingInstances();
		FileSystemEntrySetting graphicsSetting = null;
		FileSystemEntrySetting audioSetting = null;
		SimpleSetting duration = null;
		for (Setting setting : sharedSettingInstances) {
			String absRef = setting.getAbsRef();
			if (!set.getAbsRef().substring(0, set.getAbsRef().indexOf('/'))
					.equals(absRef.substring(0, absRef.indexOf('/')))) {
				continue;
			}
			if (absRef.contains(FRAME_LOCATION)) {
				if (setting instanceof FileSystemEntrySetting) {
					graphicsSetting = (FileSystemEntrySetting) setting;
				} else if (setting instanceof SimpleSetting) {
					SimpleSetting ss = (SimpleSetting) setting;
					FileSystemEntrySetting file = ConfmlFactory.eINSTANCE
							.createFileSystemEntrySetting();
					file.setAbsRef(ss.getAbsRef());
					file.getSourceFilePath().setPath(ss.getValue());
					file.setDescription(ss.getDescription());
					file.setType(ss.getType());
					file.setNote(ss.getNote());
					graphicsSetting = file;
				}
			}
			if (absRef.contains(ANIMATION_TONE)) {
				if (setting instanceof FileSystemEntrySetting) {
					audioSetting = (FileSystemEntrySetting) setting;
				} else if (setting instanceof SimpleSetting) {
					SimpleSetting ss = (SimpleSetting) setting;
					FileSystemEntrySetting file = ConfmlFactory.eINSTANCE
							.createFileSystemEntrySetting();
					file.setAbsRef(ss.getAbsRef());
					file.getSourceFilePath().setPath(ss.getValue());
					file.setDescription(ss.getDescription());
					file.setType(ss.getType());
					file.setNote(ss.getNote());
					audioSetting = file;
				}
			}
			if (absRef.contains(ANIMATIONDURATION)) {
				duration = (SimpleSetting) setting;
			}
		}

		IEditorPart editor = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if (editor != null) {
			Object adapter = editor.getAdapter(ResourceModelRoot.class);
			if (adapter instanceof ResourceModelRoot) {
				ResourceModelRoot rmr = (ResourceModelRoot) adapter;
				if (graphicsSetting.getSourceFilePath().getPath() == null) {
					return null;
				}
				graphicsFilePath = rmr.getTempDirPath()
						+ File.separator
						+ graphicsSetting.getSourceFilePath().getPath()
								.toString();
				if (audioSetting.getSourceFilePath().getPath() == null
						|| (audioSetting.getSourceFilePath().getPath() != null && audioSetting
								.getSourceFilePath().getPath().length() < 1)) {
					audioFilePath = "";
				} else {
					audioFilePath = rmr.getTempDirPath()
							+ File.separator
							+ audioSetting.getSourceFilePath().getPath()
									.toString();
				}
			}
		}
		graphicsFile = new File(graphicsFilePath);
		if (audioFilePath != "") {
			audioFile = new File(audioFilePath);
		} else {
			audioFile = null;
		}

		String value = duration.getValue();
		final int dur;
		int tdur;
		try {
			tdur = Integer.parseInt(value);
		} catch (Exception ex) {
			tdur = 3000;
		}
		dur = tdur / 10;

		final ArrayList<File> frameFiles = new ArrayList<File>();

		if ((graphicsFile != null) && (graphicsFile.exists())) {
			files = graphicsFile.listFiles(new FileFilter() {
				public boolean accept(File pathname) {
					String extension = FileUtils.getExtension(pathname);
					return ("bmp".equalsIgnoreCase(extension) || "svg"
							.equalsIgnoreCase(extension));
				}
			});
		} else {
			files = null;
		}

		if (files == null) {
			return null;
		}

		for (int i = 0; i < files.length; i++) {
			frameFiles.add(files[i]);
		}

		Collections.sort(frameFiles, new Comparator<File>() {
			public int compare(File o1, File o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});

		final ArrayList<ImageData> images = new ArrayList<ImageData>();
		final AtomicReference<byte[]> audioContent = new AtomicReference<byte[]>();
		SafeRunner.run(new SafeRunnable() {
			public void run() throws Exception {
				audioContent.set(getFileContent(audioFile));
				ImageLoader loader = new ImageLoader();

				int duration = 0;
				for (File imageFile : frameFiles) {
					byte[] content = getFileContent(imageFile);
					if (content != null) {
						ImageData[] frames = null;
						if ("svg".equalsIgnoreCase(FileUtils
								.getExtension(imageFile))) {
							SVGImage image = new SVGImage();
							FileInputStream fis = null;
							InputStream is = null;
							fis = new FileInputStream(imageFile
									.getAbsolutePath());
							is = new BufferedInputStream(fis);

							image.setInput(new TranscoderInput(is));
							BufferedImage bufferedImage = image
									.getAsBufferedImage();
							ImageData id = SVGImage.convertToSWT(bufferedImage);
							FileUtils.closeStream(is);
							FileUtils.closeStream(fis);
							frames = new ImageData[] { id };

						} else {
							frames = loader.load(new ByteArrayInputStream(
									content));
						}
						if (frames.length > 0) {
							frames[0].delayTime = 10;
							duration += 10;
							images.add(frames[0]);
						}
					}
				}
				if (duration < dur && images.size() > 0) {
					int delta = dur - duration;
					images.get(images.size() - 1).delayTime += delta;
				}

			}

			private byte[] getFileContent(File file) throws Exception {
				if (file != null && file.exists()) {
					InputStream is = FileUtils.createFileStorage(file)
							.getContents();
					try {
						return FileUtils.readBytes(is);
					} finally {
						FileUtils.closeStream(is);
					}
				}
				return null;
			}

		});

		try {
			FrameAnimationDescriptor descriptor;
			if (audioFilePath == "") {
				descriptor = new FrameAnimationDescriptor(images
						.toArray(new ImageData[0]), MediaUIPlugin.CT_MEDIA,
						null);
			} else {
				descriptor = new FrameAnimationDescriptor(images
						.toArray(new ImageData[0]), MediaUIPlugin.CT_AUDIO,
						new IStorage() {

							public InputStream getContents()
									throws CoreException {
								return new ByteArrayInputStream(audioContent
										.get());
							}

							public IPath getFullPath() {

								return null;
							}

							public String getName() {
								if (audioFile != null) {
									return audioFile.getName();
								} else {
									return "";
								}
							}

							public boolean isReadOnly() {

								return false;
							}

							@SuppressWarnings("unchecked")
							public Object getAdapter(Class adapter) {

								return null;
							}

						});
			}
			return descriptor;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	/**
	 * Loads image data from file
	 * 
	 * @param fullPath the fullpath of the file
	 * @return imageData of loaded image
	 */
	private static ImageData loadImage(String fullPath) {
		FileInputStream fis = null;
		InputStream is = null;
		String name = fullPath
				.substring(fullPath.lastIndexOf(File.separator) + 1);
		if (name != null && name != "") {
			if ("svg".equalsIgnoreCase(name
					.substring(name.lastIndexOf(".") + 1))) {
				// Load SVG
				SVGImage image = new SVGImage();
				try {
					fis = new FileInputStream(fullPath);
					is = new BufferedInputStream(fis);

					image.setInput(new TranscoderInput(is));
					// image.setSize(53, 53);
					BufferedImage bufferedImage = image.getAsBufferedImage();
					ImageData id = SVGImage.convertToSWT(bufferedImage);
					FileUtils.closeStream(is);
					FileUtils.closeStream(fis);
					return id;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			} else {
				// Load other
				ImageLoader loader = new ImageLoader();
				try {
					fis = new FileInputStream(fullPath);
					is = new BufferedInputStream(fis);
					ImageData[] masks = loader.load(is);
					FileUtils.closeStream(is);
					FileUtils.closeStream(fis);
					return masks[0];
				} catch (Exception ex) {
					return null;
				}
			}
		}
		return null;
	}

	/**
	 * Screen filter for Customer menu and Right soft key descriptors
	 */
	static class ScreenFilter implements IFilter {

		private List<String> ids;

		public ScreenFilter(String... ids) {
			this.ids = Arrays.asList(ids);
		}

		public boolean select(Object toTest) {
			if (!(toTest instanceof IContentData)) {
				return false;
			}
			IContentData ca = (IContentData) toTest;
			String id = ca.getId();
			return ids.contains(id);
		}
	};

	public Class<?>[] getAdapterList() {
		return adapters.clone();
	}
}
