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
 * Description: This file is part of com.nokia.tools.variant.preview.theme component.
 */

package com.nokia.tools.variant.preview.theme;

import java.awt.Component;
import java.awt.image.BufferedImage;
import java.awt.image.DirectColorModel;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.jobs.ILock;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.PaletteData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Sash;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSInput;
import org.w3c.dom.ls.LSOutput;
import org.w3c.dom.ls.LSParser;
import org.w3c.dom.ls.LSResourceResolver;
import org.w3c.dom.ls.LSSerializer;

import com.nokia.tools.content.core.ContentAttribute;
import com.nokia.tools.content.core.ContentSourceManager;
import com.nokia.tools.content.core.IContent;
import com.nokia.tools.content.core.IContentData;
import com.nokia.tools.content.core.IContentProvider;
import com.nokia.tools.editing.core.EditingUtil;
import com.nokia.tools.platform.theme.ThemeBasicData;
import com.nokia.tools.platform.theme.ThemePlatform;
import com.nokia.tools.screen.core.IScreenAdapter;
import com.nokia.tools.screen.core.IScreenContext;
import com.nokia.tools.screen.core.IScreenElement;
import com.nokia.tools.screen.core.IScreenFactory;
import com.nokia.tools.theme.content.AbstractThemeProvider;
import com.nokia.tools.theme.content.ThemeContent;
import com.nokia.tools.theme.content.ThemeData;
import com.nokia.tools.theme.s60.S60ThemeProvider;
import com.nokia.tools.variant.common.core.utils.FileUtils;
import com.nokia.tools.variant.common.core.utils.PlatformUtil;
import com.nokia.tools.variant.common.ui.utils.SWTUtil;
import com.nokia.tools.variant.preview.IPreviewDescriptor;
import com.nokia.tools.variant.preview.PreviewController;
import com.nokia.tools.variant.preview.theme.ThemeDescriptor.ElementOverride;
import com.nokia.tools.variant.resourcelibrary.model.FileSystemElement;
import com.nokia.tools.variant.resourcelibrary.model.ThemeFile;
import com.nokia.tools.variant.resourcelibrary.views.ResourceStorage;

@SuppressWarnings("restriction")
public class ThemePreviewController extends PreviewController {

	class Data {
		Image image;
		String label;
	}

	class ThemeContainer extends LabelProvider {
		List<Data> items = new ArrayList<Data>();

		public ThemeContainer() {
		}

		@Override
		public void dispose() {
			for (Data item : items) {
				item.image.dispose();
			}
			items.clear();
		}

		public Integer add(ImageData id, String name) {
			Data item = new Data();
			item.image = new Image(null, id);
			item.label = name;
			items.add(item);
			return items.size() - 1;
		}

		@Override
		public Image getImage(Object element) {
			int idx = (Integer) element;
			return items.get(idx).image;
		}

		@Override
		public String getText(Object element) {
			int idx = (Integer) element;
			return items.get(idx).label;
		}
	}

	private Composite topComposite;
	private ScrolledComposite thumbsSC;
	private ImageGallery thumbsContent;
	private ScrolledComposite imageSC;
	private Composite imageParent;
	private Canvas imageContent;
	private ThemeDescriptor descriptor;
	private ThemeContainer labelProvider = new ThemeContainer();
	private ProgressBar bar;
	private ControlResizeListener controlResizeListener;
	private ThumbsContentListener thumbsContentListener;
	private SashListener sashListener;
	private Sash sash;
	private ThumbsContentResizeListener thumbsContentResizeListener;
	private ImageSCResizeListener imageSCResizeListener;
	private ImageUpdateListener imageUpdateListener;
	private ImageContentPaintListener imageContentPaintListener;
	private IScreenElement previousScreen;
	private IScreenElement previousBGScreenElement;
	private File previousInputFile;
	private File previousTdfFile;

	private Color rskFontColor = new Color(null, 75, 88, 121);

	class ControlResizeListener implements Listener {
		public void handleEvent(Event event) {
			Rectangle ca = thumbsSC.getClientArea();
			Point size = thumbsContent.computeSize(SWT.DEFAULT, ca.height);
			thumbsContent.setSize(size);
			thumbsSC.setMinSize(size);
		}
	}

	class ThumbsContentListener implements ISelectionChangedListener {
		public void selectionChanged(SelectionChangedEvent event) {
			Point size = getSelectedImageSize();

			if (size.x * size.y == 0) {
				canvasBorder.setBackground(ColorConstants.white);
			} else {
				canvasBorder.setBackground(ColorConstants.lightGray);
			}

			GridData gd = (GridData) imageContent.getLayoutData();
			gd.minimumHeight = size.y;
			gd.minimumWidth = size.x;
			size = imageParent.computeSize(SWT.DEFAULT, SWT.DEFAULT);
			Rectangle ca = imageSC.getClientArea();
			size.x = Math.max(size.x, ca.width);
			size.y = Math.max(size.y, ca.height);
			imageParent.setSize(size);
			imageSC.setMinSize(size);
			imageSC.layout(true);
			if (thumbsContent.getSelected() != null) {
				SWTUtil.ensureVisible(thumbsSC, thumbsContent.getSelected());
			}

			// updateImageComposite();
			imageContent.redraw();
		}
	}

	class SashListener implements Listener {
		public void handleEvent(Event event) {
			Sash sash = (Sash) event.widget;
			FormData fd = (FormData) sash.getLayoutData();
			int y = Math.max(event.y, 60);
			y = Math.min(y, 150);

			fd.top = new FormAttachment(0, y);
			sash.getParent().layout(true);
		}
	}

	class ThumbsContentResizeListener implements Listener {

		public void handleEvent(Event event) {
			updateThumbsComposite();
		}

	}

	class ImageSCResizeListener implements Listener {
		public void handleEvent(Event event) {
			Point size = imageParent.computeSize(SWT.DEFAULT, SWT.DEFAULT);
			Rectangle ca = imageSC.getClientArea();
			size.x = Math.max(size.x, ca.width);
			size.y = Math.max(size.y, ca.height);
			imageParent.setSize(size);
			imageSC.setMinSize(size);
			imageSC.layout(true);
			imageContent.redraw();
		}

	}

	class ImageUpdateListener implements Listener {
		public void handleEvent(Event event) {
			updateImageComposite();
		}
	}

	@Override
	public void createControl(Composite parent) {
		FormData formData;

		topComposite = new Composite(parent, SWT.NONE);
		thumbsSC = new ScrolledComposite(topComposite, SWT.HORIZONTAL
				| SWT.BORDER);
		sash = new Sash(topComposite, SWT.HORIZONTAL);
		imageSC = new ScrolledComposite(topComposite, SWT.HORIZONTAL
				| SWT.VERTICAL | SWT.BORDER);

		topComposite.setLayout(new FormLayout());

		// topData.left = new FormAttachment(0, 0);
		// topData.top = new FormAttachment(0, 0);
		// topData.right = new FormAttachment(100, 0);
		// topData.bottom = new FormAttachment(100, 0);
		// topComposite.setLayoutData(topData);

		formData = new FormData();
		formData.left = new FormAttachment(0);
		formData.right = new FormAttachment(100);
		formData.top = new FormAttachment(0);
		formData.bottom = new FormAttachment(sash, 0);
		thumbsSC.setLayoutData(formData);
		thumbsSC.setLayout(new GridLayout());
		thumbsSC.setExpandHorizontal(true);
		thumbsSC.setExpandVertical(false);

		formData = new FormData();
		formData.left = new FormAttachment(0);
		formData.right = new FormAttachment(100);
		formData.top = new FormAttachment(0, 80);
		sash.setLayoutData(formData);
		sashListener = new SashListener();
		sash.addListener(SWT.Selection, sashListener);

		formData = new FormData();
		formData.left = new FormAttachment(0);
		formData.right = new FormAttachment(100);
		formData.top = new FormAttachment(sash, 0);
		formData.bottom = new FormAttachment(100);
		imageSC.setLayoutData(formData);
		imageSC.setLayout(new GridLayout());

		topComposite.setBackground(ColorConstants.white);
		thumbsSC.setBackground(topComposite.getBackground());
		thumbsSC.setAlwaysShowScrollBars(true);
		thumbsContent = new ImageGallery(thumbsSC, SWT.NONE, labelProvider);
		imageParent = new Composite(imageSC, SWT.NONE);
		thumbsContentResizeListener = new ThumbsContentResizeListener();
		thumbsContent.addListener(SWT.Resize, thumbsContentResizeListener);
		thumbsSC.setContent(thumbsContent);
		controlResizeListener = new ControlResizeListener();
		thumbsSC.addListener(SWT.Resize, controlResizeListener);
		thumbsContentListener = new ThumbsContentListener();
		thumbsContent.addSelectionChangedListener(thumbsContentListener);

		imageSC.setBackground(topComposite.getBackground());
		imageSCResizeListener = new ImageSCResizeListener();
		imageSC.addListener(SWT.Resize, imageSCResizeListener);
		imageParent.setBackground(imageSC.getBackground());
		imageParent.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		imageParent.setLayout(new GridLayout(1, false));

		canvasBorder = new Composite(imageParent, SWT.NONE);
		canvasBorder.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true,
				true));
		canvasBorder.setLayout(new GridLayout());
		canvasBorder.setBackground(imageParent.getBackground());

		imageContent = new Canvas(canvasBorder, SWT.DOUBLE_BUFFERED) {
			@Override
			public Point computeSize(int hint, int hint2, boolean changed) {
				return getSelectedImageSize();
			}
		};
		imageContent.setBackground(topComposite.getBackground());
		imageContent.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false,
				false));
		imageUpdateListener = new ImageUpdateListener();
		imageContent.addListener(SWT.Resize, imageUpdateListener);
		imageContentPaintListener = new ImageContentPaintListener();
		imageContent.addPaintListener(imageContentPaintListener);
		imageSC.setContent(imageParent);

		createNewProgressBar();
		updateThumbsComposite();
		updateImageComposite();
	}

	class ImageContentPaintListener implements PaintListener {
		public void paintControl(PaintEvent e) {
			Rectangle area = imageContent.getClientArea();
			Object toPaint = ((IStructuredSelection) thumbsContent
					.getSelection()).getFirstElement();
			if (toPaint == null) {
				// done;
				return;
			}
			Image image = labelProvider.getImage(toPaint);
			e.gc.drawImage(image, area.x, area.y);
		}
	}

	private void createNewProgressBar() {
		FormData formData;

		bar = new ProgressBar(topComposite, SWT.SMOOTH);

		formData = (FormData) imageSC.getLayoutData();
		formData.bottom = new FormAttachment(bar);

		bar.setBackground(topComposite.getBackground());
		bar.setForeground(ColorConstants.lightBlue);
		bar.setMaximum(100);
		bar.setMinimum(0);
		formData = new FormData();
		formData.left = new FormAttachment(0);
		formData.right = new FormAttachment(100);
		formData.bottom = new FormAttachment(100);
		bar.setLayoutData(formData);
		bar.setSelection(0);
		bar.setToolTipText("Theme loading progress");

		topComposite.layout();
	}

	protected Point getSelectedImageSize() {
		Object key = ((IStructuredSelection) thumbsContent.getSelection())
				.getFirstElement();
		if (key == null) {
			return new Point(0, 0);
		} else {
			Image image = labelProvider.getImage(key);
			Rectangle bounds = image.getBounds();
			return new Point(bounds.width, bounds.height);
		}
	}

	protected void updateThumbsComposite() {
		// Point size = thumbsContent.computeSize(SWT.DEFAULT,
		// SWT.DEFAULT, true);
		Point size = thumbsContent.getSize();
		// Rectangle ca = thumbsSC.getClientArea();
		// size.x = Math.max(size.x, ca.width);
		// size.y = Math.max(size.y, ca.height);
		// thumbsContent.setSize(size);
		thumbsSC.setMinSize(size);
		thumbsSC.layout(true);
		topComposite.layout();
	}

	protected void updateImageComposite() {
		// Point size = imageContent.computeSize(SWT.DEFAULT, SWT.DEFAULT,
		// true);
		Point size = getSelectedImageSize();
		boolean empty = size.x == 0;
		GridData gd = (GridData) imageContent.getLayoutData();
		gd.minimumHeight = size.y;
		gd.minimumWidth = size.x;
		size = imageParent.computeSize(SWT.DEFAULT, SWT.DEFAULT);
		Rectangle ca = imageSC.getClientArea();
		size.x = Math.max(size.x, ca.width);
		size.y = Math.max(size.y, ca.height);
		imageParent.setSize(size);
		imageSC.setMinSize(size);
		imageSC.layout(true);
		if (empty) {
			canvasBorder.setBackground(ColorConstants.white);
		} else {
			canvasBorder.setBackground(ColorConstants.lightGray);

		}

	}

	@Override
	public synchronized void dispose() {
		stop = true;
		ThemeContent theme = (ThemeContent) content;

		AbstractThemeProvider.clearCache(theme);
		if (theme != null) {
			theme.dispose();

		} else {
			return;
		}
		EList<Adapter> adapters = theme.getResource().eAdapters();

		adapters.clear();

		try {
			Method declaredMethod = S60ThemeProvider.class
					.getDeclaredMethod("release");
			declaredMethod.setAccessible(true);
			declaredMethod.invoke(provider);
			provider = null;
		} catch (SecurityException e) {

			e.printStackTrace();
		} catch (NoSuchMethodException e) {

			e.printStackTrace();
		} catch (IllegalArgumentException e) {

			e.printStackTrace();
		} catch (IllegalAccessException e) {

			e.printStackTrace();
		} catch (InvocationTargetException e) {

			e.printStackTrace();
		}

		try {
			Field field = ThemeContent.class.getDeclaredField("reverseLookups");
			field.setAccessible(true);
			Map<ThemeBasicData, ThemeData> reverseLookups = (Map<ThemeBasicData, ThemeData>) field
					.get(content);

			reverseLookups.clear();
			field.set(content, null);
		} catch (SecurityException e) {

			e.printStackTrace();
		} catch (NoSuchFieldException e) {

			e.printStackTrace();
		} catch (IllegalArgumentException e) {

			e.printStackTrace();
		} catch (IllegalAccessException e) {

			e.printStackTrace();
		}
		content = null;
		if (loader != null) {
			loader.cancel();
			loader = null;
			// stop = false;
		}
		if (!imageContent.isDisposed()) {
			imageContent.removeListener(SWT.Resize, imageUpdateListener);
			imageContent.removePaintListener(imageContentPaintListener);
			imageContentPaintListener = null;
			imageUpdateListener = null;
			imageContent.dispose();
			imageContent = null;
		}
		labelProvider.dispose();
		if (!thumbsSC.isDisposed()) {
			thumbsSC.removeListener(SWT.Resize, controlResizeListener);
			thumbsSC.dispose();
		}
		controlResizeListener = null;
		thumbsContent.removeSelectionChangedListener(thumbsContentListener);
		thumbsContentListener = null;
		if (!sash.isDisposed()) {
			sash.removeListener(SWT.Selection, sashListener);
			sash.dispose();
		}
		sashListener = null;
		if (!thumbsContent.isDisposed()) {
			thumbsContent.removeListener(SWT.Resize,
					thumbsContentResizeListener);
			thumbsContent.dispose();
		}
		thumbsContentResizeListener = null;
		if (!imageSC.isDisposed()) {
			imageSC.removeListener(SWT.Resize, imageSCResizeListener);
			imageSC.dispose();
		}
		imageSCResizeListener = null;

		if (topComposite != null) {
			topComposite.dispose();
			topComposite = null;
		}
		if (idDataMap != null) {
			idDataMap.clear();
			idDataMap = null;
		}
	}

	@Override
	public Control getControl() {
		return topComposite;
	}

	ImageLoader loader;
	private Composite canvasBorder;
	private LinkedHashMap<String, ElementOverride> idDataMap;

	static ILock lock = Job.getJobManager().newLock();
	private IContent content;
	private IContentProvider provider;
	public boolean stop = false;

	@Override
	public synchronized void setInput(IPreviewDescriptor descriptor) {
		if (this.descriptor == descriptor) {
			return;
		}
		if (this.descriptor != null && this.descriptor.equals(descriptor)) {
			return;
		}

		this.descriptor = (ThemeDescriptor) descriptor;

		if (topComposite != null) {
			if (loader != null) {
				loader.cancel();
				loader = null;
				stop = false;
			}

			updateBarSelection(null, 10);
			updateImageComposite();
			updateThumbsComposite();

			if (this.descriptor != null) {
				thumbsContent.cleanup();
				loader = new ImageLoader(this.descriptor);

				loader.schedule();
			} else {
			}

		}

	}

	class ImageLoader {
		ThemeDescriptor descriptor;
		private Thread task;

		public ImageLoader(ThemeDescriptor descriptor) {

			this.descriptor = descriptor;
		}

		protected void cancel() {
			if (task != null) {
				stop = true;
				task.stop();
			}
		}

		protected void schedule() {

			task = new Thread(new Runnable() {

				public void run() {
					IProgressMonitor monitor = new NullProgressMonitor();
					try {

						monitor.beginTask("Generating theme preview", 100);

						createImageInternal(loader, descriptor, monitor);

					} finally {
						monitor.done();
					}
				}
			});

			task.start();
		}
	};

	class UpdateBarSelectionRunnalbe implements Runnable {

		private ImageLoader job;
		private int value;

		public UpdateBarSelectionRunnalbe(ImageLoader job, int value) {
			this.job = job;
			this.value = value;
		}

		public void run() {

			synchronized (ThemePreviewController.this) {
				if (job != loader) {
					return;
				}
			}
			if (value == 100 && bar != null) {
				bar.dispose();
				bar = null;
				FormData formData = (FormData) imageSC.getLayoutData();
				formData.bottom = new FormAttachment(100);
				topComposite.layout(true, true);
			} else {
				if (bar == null || bar.isDisposed()) {
					createNewProgressBar();
					topComposite.layout(true, true);
				}
				bar.setSelection(value);
			}

		}

	}

	protected void updateBarSelection(ImageLoader job, int value) {
		if (topComposite != null && !topComposite.isDisposed()) {
			topComposite.getDisplay().syncExec(
					new UpdateBarSelectionRunnalbe(job, value));
		}
	}

	class CreateImageInternalRunnable implements IWorkspaceRunnable {
		private AtomicReference<File> tdfFileReference;
		private File temp;
		private ThemeDescriptor input;
		private String cpfPlatformId;

		public CreateImageInternalRunnable(ThemeDescriptor input, File temp,
				AtomicReference<File> tdfFileReference) {
			this.tdfFileReference = tdfFileReference;
			this.temp = temp;
			this.input = input;
			setCpfPlatformId();
		}
		
		private void setCpfPlatformId() {
			ResourceStorage file = (ResourceStorage) input.getFile();
			FileSystemElement element = file.getFileSystemElement();
			if (element instanceof ThemeFile) {
				ThemeFile theme = (ThemeFile) element;
				String message = theme.getValidationMessage();
				if (message.contains("is not equal")) {
					String[] split = message.split(" ");
					cpfPlatformId = split[split.length - 1];
				}
			}
		}
		
		private void handleThemeFile(File entryFile) {
			try {
				if (entryFile.getName().endsWith(".tdf")) {
					if (cpfPlatformId != null) {
						FileInputStream fis = new FileInputStream(entryFile);								
						String text = new String(FileUtils.readBytes(fis));
						fis.close();
						
						Pattern p = Pattern.compile("<phone>.*</phone>", Pattern.DOTALL);
						Matcher matcher = p.matcher(text);
						String replaced = matcher.replaceFirst("<phone><model id=\"" + cpfPlatformId + "\"/></phone>");
						
						FileOutputStream out = new FileOutputStream(entryFile);
						out.write(replaced.getBytes());
						out.close();
					}
					tdfFileReference.set(entryFile);
				}
			} catch (Exception e) {
				ThemePreviewPlugin.logError("Failed to read theme content",	e);
			}
		}

		public void run(IProgressMonitor monitor) throws CoreException {
			if (stop) {
				return;
			}
			InputStream inputContents = new BufferedInputStream(input.getFile()
					.getContents());
			
			try {
				try {
					ZipInputStream zis = new ZipInputStream(inputContents);
					ZipEntry zipEntry;
					monitor.worked(5);

					if (descriptor.isRsk()
							&& previousInputFile != null
							&& input.getFile().getFullPath().toFile().equals(
									previousInputFile)) {
						while ((zipEntry = zis.getNextEntry()) != null) {
							if (!zipEntry.getName().endsWith(".tdf")) {
								continue;
							}
							if (zipEntry.isDirectory()) {
								zis.closeEntry();
								continue;
							}
							String name = zipEntry.getName();
							File entryFile = new File(temp, name);
							File tmp = entryFile.getParentFile();
							if (!tmp.exists()) {
								tmp.mkdirs();
							}
							FileOutputStream fos = new FileOutputStream(entryFile);
							FileUtils.copyStream(zis, fos);
							fos.close();
							zis.closeEntry();
							
							handleThemeFile(entryFile);
						}
					} else {
						while ((zipEntry = zis.getNextEntry()) != null) {
							if (zipEntry.isDirectory()) {
								zis.closeEntry();
								continue;
							}
							String name = zipEntry.getName();
							File entryFile = new File(temp, name);
							File tmp = entryFile.getParentFile();
							if (!tmp.exists()) {
								tmp.mkdirs();
							}							
							FileOutputStream fos = new FileOutputStream(entryFile);
							FileUtils.copyStream(zis, fos);							
							fos.close();
							zis.closeEntry();
							
							handleThemeFile(entryFile);
						}
					}
				} catch (Exception e) {
					ThemePreviewPlugin.logError("Failed to read theme content", e);
				}
			} finally {
				FileUtils.closeStream(inputContents);
			}
		}
	}

	class LSResourceResolverImp implements LSResourceResolver {
		private DOMImplementationLS ls;

		public LSResourceResolverImp(DOMImplementationLS ls) {
			this.ls = ls;
		}

		public LSInput resolveResource(String type, String namespaceURI,
				String publicId, String systemId, String baseURI) {
			LSInput input = ls.createLSInput();
			input.setBaseURI(baseURI);
			input.setSystemId(systemId);
			input.setCharacterStream(new StringReader(""));
			return input;
		}
	}

	class ScreenContextImp implements IScreenContext {

		private IContent content;

		public ScreenContextImp(IContent content2) {
			this.content = content2;
		}

		public com.nokia.tools.platform.core.Display getDisplay() {
			String themeId = (String) content
					.getAttribute(ContentAttribute.THEME_ID.name());
			return ThemePlatform.getThemeDescriptorById(themeId)
					.getDefaultDevice().getDisplay();
		}

		@SuppressWarnings("unchecked")
		public Object getAdapter(Class adapter) {
			return null;
		}

	}

	private static final int RSK_WIDTH = 80;
	private static final int RSK_HEIGHT = 30;

	public void createImageInternal(ImageLoader job, ThemeDescriptor input,
			IProgressMonitor monitor) {
		if (stop) {
			return;
		}
		updateBarSelection(job, 10);
		monitor.setTaskName("Processing archive");
		File tempDir = null;
		File tdfFile = null;
		try {
			File temp = File.createTempFile("theme", input.getName());
			temp.delete();
			tempDir = temp;
			tempDir.mkdir();

			AtomicReference<File> tdfFileReference = new AtomicReference<File>();

			IWorkspaceRunnable runnable = new CreateImageInternalRunnable(
					input, temp, tdfFileReference);
			ISchedulingRule rule = PlatformUtil.getAdapter(input.getFile(),
					ISchedulingRule.class, true);
			ResourcesPlugin.getWorkspace().run(runnable, rule,
					IWorkspace.AVOID_UPDATE, null);
			tdfFile = tdfFileReference.get();
			if (tdfFile == null) {
				return;
			}

			if (descriptor.isRsk()
					&& input.getFile().getFullPath().toFile().equals(
							previousInputFile)) {
				IScreenElement screen = previousScreen;
				IScreenElement bgScreenElement = previousBGScreenElement;
				Image rskFinalImage = null;
				if (descriptor.isRsk()) {
					rskFinalImage = getRskImage(bgScreenElement);
				}

				Component canvas = (Component) EditingUtil.getBean(screen
						.getWidget());
				BufferedImage bi = new BufferedImage(canvas.getWidth(), canvas
						.getHeight(), BufferedImage.TYPE_INT_ARGB);
				java.awt.Graphics g = bi.getGraphics();

				canvas.printAll(g);

				g.dispose();

				ImageData imageData = convertToSWT(bi);

				if (descriptor.isRsk() && rskFinalImage != null) {
					Image image = new Image(null, imageData);
					GC gc = new GC(image);
					gc.drawImage(rskFinalImage, canvas.getWidth() - RSK_WIDTH,
							canvas.getHeight() - RSK_HEIGHT);
					gc.dispose();
					imageDecoded(job, image.getImageData(), "Idle");
				} else {
					imageDecoded(job, imageData, "Idle");
				}
				previousScreen = screen;
				previousBGScreenElement = bgScreenElement;
			} else {
				monitor.worked(10);
				monitor.setTaskName("Loading theme provider");

				provider = ContentSourceManager
						.getGlobalContentProvider(S60ThemeProvider.CONTENT_TYPE);

				ThemeDescriptor.ElementOverride[] overrides = input
						.getOverrides();

				if (overrides.length > 0) {

					DOMImplementationRegistry registry = DOMImplementationRegistry
							.newInstance();
					DOMImplementation domImpl = registry
							.getDOMImplementation("LS 3.0");
					DOMImplementationLS ls = (DOMImplementationLS) domImpl;
					LSInput lsInput = ls.createLSInput();
					InputStream is = new BufferedInputStream(
							new FileInputStream(tdfFile));
					lsInput.setByteStream(is);
					LSParser parser = ls.createLSParser(
							DOMImplementationLS.MODE_SYNCHRONOUS, null);
					parser.getDomConfig().setParameter("namespaces", false);
					parser.getDomConfig().setParameter("infoset", false);
					parser.getDomConfig().setParameter("resource-resolver",
							new LSResourceResolverImp(ls));

					idDataMap = new LinkedHashMap<String, ElementOverride>();
					Map<String, Element> idXMLMap = new HashMap<String, Element>();

					for (ElementOverride over : overrides) {
						idDataMap.put(over.getId(), over);
						idXMLMap.put(over.getId(), null);
					}

					Document doc = parser.parse(lsInput);
					monitor.worked(10);
					is.close();
					Element root = doc.getDocumentElement();
					NodeList nodes = root.getChildNodes();
					// Element qgnMenuOperator = null;
					// Element rskIdle = null;
					for (int i = 0; i < nodes.getLength(); i++) {
						if (stop) {
							return;
						}
						Node n = nodes.item(i);
						if (n instanceof Element) {
							Element element = (Element) n;
							if (!"element".equals(element.getNodeName())) {
								continue;
							}
							String id = element.getAttribute("id");

							if ("text16".equals(id)) {
								NodeList elementsByTagName = element
										.getElementsByTagName("layer");
								Node item = elementsByTagName.item(0);
								NamedNodeMap attributes = item.getAttributes();
								Node namedItem = attributes
										.getNamedItem("colourrgb");
								String hexColor = namedItem.getNodeValue();
								java.awt.Color decodeColor = java.awt.Color
										.decode(hexColor);
								rskFontColor = new Color(Display.getDefault(),
										decodeColor.getRed(), decodeColor
												.getGreen(), decodeColor
												.getBlue());
							}

							if (idDataMap.containsKey(id)) {
								idXMLMap.put(id, element);
							}

							// if ("qgn_menu_operator".equals(id)) {
							// qgnMenuOperator = element;
							// } else if (RSK_IMAGE_ID.equals(id)) {
							// rskIdle = element;
							// }
							// if (qgnMenuOperator != null && rskIdle != null) {
							// break;
							// }
						}
					}

					for (Map.Entry<String, Element> entry : idXMLMap.entrySet()) {
						if (stop) {
							return;
						}
						Element xmlElement = entry.getValue();
						if (xmlElement != null) {
							root.removeChild(xmlElement);
						}

						xmlElement = doc.createElement("element");
						xmlElement.setAttribute("id", entry.getKey());
						root.appendChild(xmlElement);

						Element graphic = doc.createElement("graphic");
						Element image = doc.createElement("image");
						Element layer = doc.createElement("layer");
						xmlElement.appendChild(graphic);
						graphic.appendChild(image);
						image.appendChild(layer);

						xmlElement
								.setAttribute("name", "Tool Preview Override");

						graphic.setAttribute("type", "still");
						graphic.setAttribute("status", "actual");

						String imageFileName = null;
						String imageMaskFileName = null;
						ElementOverride override = idDataMap
								.get(entry.getKey());
						ImageData imageData = override.getImage();
						ImageData maskData = override.getMask();
						if (imageData != null) {
							imageFileName = "operator.custom.image.png";
							org.eclipse.swt.graphics.ImageLoader loader = new org.eclipse.swt.graphics.ImageLoader();
							loader.data = new ImageData[] { imageData };
							File imageFile = new File(tdfFile.getParentFile(),
									imageFileName);
							OutputStream os = null;
							try {
								os = new BufferedOutputStream(
										new FileOutputStream(imageFile));
								loader.save(os, SWT.IMAGE_PNG);
							} finally {
								os.flush();
								os.close();
							}
						}
						if (maskData != null) {
							imageMaskFileName = "operator.custom.image.mask.png";
							org.eclipse.swt.graphics.ImageLoader loader = new org.eclipse.swt.graphics.ImageLoader();
							loader.data = new ImageData[] { maskData };
							File imageFile = new File(tdfFile.getParentFile(),
									imageMaskFileName);
							OutputStream os = null;
							try {
								os = new BufferedOutputStream(

								new FileOutputStream(imageFile));
								loader.save(os, SWT.IMAGE_PNG);
							} finally {
								os.flush();
								os.close();
							}
						}

						layer.setAttribute("name", "layer0");
						layer.setAttribute("entity_x", "0");
						layer.setAttribute("entity_y", "0");
						layer.setAttribute("image_x", "0");
						layer.setAttribute("image_y", "0");
						layer.setAttribute("angle", "0");
						layer.setAttribute("stretch", "false");
						layer.setAttribute("status", "actual");
						layer.setAttribute("colourdepth", "c16");
						if (imageFileName != null) {
							layer.setAttribute("filename", imageFileName);
						}
						if (imageMaskFileName != null) {
							layer.setAttribute("softmask", imageMaskFileName);
						}

					}

					LSSerializer serial = ls.createLSSerializer();
					serial.getDomConfig().setParameter("format-pretty-print",
							true);
					LSOutput output = ls.createLSOutput();
					OutputStream os = new BufferedOutputStream(
							new FileOutputStream(tdfFile));
					output.setByteStream(os);
					serial.write(doc, output);
					os.close();

				}
				// System.out.println("controller");
				List<IContent> list = provider
						.getRootContents(tdfFile, monitor);
				// IContentProvider s60provider = new S60ThemeProvider();
				// List<IContent> list =
				// s60provider.getRootContents(inputContents,
				// new NullProgressMonitor());

				updateBarSelection(job, 10);
				monitor.worked(5);
				monitor.setTaskName("Generating screen preview");

				if (!list.isEmpty()) {
					content = list.get(0);
					IScreenFactory factory = (IScreenFactory) content
							.getAdapter(IScreenFactory.class);

					if (factory != null) {
						IScreenContext context = new ScreenContextImp(content);
						int counter = 0;

						IContentData[] screens = factory.getScreens();
						int delta = 70 / (screens.length == 0 ? 1
								: screens.length);
						for (IContentData data : screens) {
							if (stop) {
								return;
							}
							counter++;
							int selection = ((int) (((((float) counter) / screens.length)) * 90f)) + 10;
							selection = Math.min(selection, 99);
							monitor.worked(delta);

							updateBarSelection(job, selection);

							if (monitor.isCanceled()) {
								break;
							}

							IFilter filter = input.getFilter();
							if (!filter.select(data)) {
								continue;
							}

							IScreenAdapter adapter = (IScreenAdapter) data
									.getAdapter(IScreenAdapter.class);
							if (adapter != null && adapter.isModelScreen()
									&& data.getName() != null) {

								IScreenElement screen = adapter
										.buildScreen(context);

								if (descriptor.isRsk()
										&& input.getFile().getFullPath()
												.toFile().equals(
														previousInputFile)) {
									screen = previousScreen;
								}

								screen.adaptToScreen(context);

								Image rskFinalImage = null;
								IScreenElement bgScreenElement = null;
								for (IScreenElement element : screen
										.getChildren()) {
									if (stop) {
										return;
									}
									if (monitor.isCanceled()) {
										break;
									}

									element.adaptToScreen(context);
									element.addWidgetToParent();

									if ("application_window".equals(element
											.getData().getName())) {
										bgScreenElement = element;
									}

									if (input.getFile().getFullPath().toFile()
											.equals(previousInputFile)) {
										bgScreenElement = previousBGScreenElement;
									}

									// can be also used
									// if
									//("Idle Background".equals(element.getText(
									// )))
									// {
									// bgScreenElement = element;
									// }

								}
								if (descriptor.isRsk()) {
									rskFinalImage = getRskImage(bgScreenElement);
									previousScreen = screen;
									previousBGScreenElement = bgScreenElement;
								}

								Component canvas = (Component) EditingUtil
										.getBean(screen.getWidget());
								BufferedImage bi = new BufferedImage(canvas
										.getWidth(), canvas.getHeight(),
										BufferedImage.TYPE_INT_ARGB);
								java.awt.Graphics g = bi.getGraphics();

								canvas.printAll(g);

								g.dispose();

								ImageData imageData = convertToSWT(bi);

								if (descriptor.isRsk() && rskFinalImage != null) {
									Image image = new Image(null, imageData);
									GC gc = new GC(image);
									gc.drawImage(rskFinalImage, canvas
											.getWidth()
											- RSK_WIDTH, canvas.getHeight()
											- RSK_HEIGHT);
									gc.dispose();
									imageDecoded(job, image.getImageData(),
											data.getName());
								} else {
									imageDecoded(job, imageData, data.getName());
								}
							}
						}
					}
				}

			}
			previousInputFile = input.getFile().getFullPath().toFile();
			previousTdfFile = tdfFile;
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			if (tempDir != null) {
				FileUtils.deleteDirectory(tempDir);
			}

			updateBarSelection(job, 100);
		}
	}

	/**
	 * This method returns image for the right soft key(rsk) settings. In fact,
	 * it returns only the cut of screen for rsk, which will be draw on
	 * foreground of the preview screen.
	 * 
	 * @param screen
	 * @return
	 */
	private Image getRskImage(IScreenElement screen) {
		Image rskFinalImage = null;
		ElementOverride[] overrides2 = descriptor.getOverrides();
		ImageData icon = null;
		ImageData mask = null;
		String rskText = null;

		if (overrides2.length > 0) {
			for (ElementOverride elementOverride : overrides2) {
				icon = elementOverride.getImage();
				mask = elementOverride.getMask();
				rskText = elementOverride.getText();
			}
		}

		if (icon != null) {
			rskFinalImage = getRskFromImage(screen, icon, mask);
		} else if (rskText != null && rskText != "") {
			rskFinalImage = getRskFromText(screen, rskText);
		}

		return rskFinalImage;
	}

	/**
	 * This method returns image for the right soft key(rsk) setting. The text
	 * is delineated on the original background of the screen.
	 * 
	 * @param screen
	 * @param rskText
	 * @return
	 */

	private Image getRskFromText(IScreenElement screen, String rskText) {

		Image rskFinalImage = getBackgroundSubImage(screen);

		if (rskFinalImage == null)
			return null;

		Display.getDefault().syncExec(new Runnable() {

			private String fontPath;

			@SuppressWarnings("deprecation")
			public void run() {
				try {
					URL url = Platform.find(ThemePreviewPlugin.getDefault()
							.getBundle(), new Path(""));
					String workingDir = new File(Platform.resolve(url)
							.getFile()).getAbsolutePath()
							+ File.separator + "fonts";
					fontPath = workingDir + File.separator + "S60TSB.ttf";
				} catch (IOException e) {
					e.printStackTrace();
				}
				File f = new File(fontPath);
				Display.getDefault().loadFont(f.getAbsolutePath());
			}

		});

		GC gc = new GC(rskFinalImage);
		gc.setLineStyle(SWT.LINE_SOLID);

		gc.setFont(new Font(null, "Series 60 Sans TitleSmBd", 14, SWT.NONE));

		gc.setForeground(rskFontColor);

		if (rskText.length() > 8) {
			rskText = rskText.substring(0, 8).concat("...");
		}

		int widthInPixels = gc.getFontMetrics().getAverageCharWidth()
				* rskText.length();
		int offset = (RSK_WIDTH - (widthInPixels + 5));
		if (offset >= 0) {
			gc.drawString(rskText, offset, 4, true);
		} else {
			gc.drawString(rskText, 0, 4, true);
		}
		gc.dispose();

		return rskFinalImage;
	}

	/**
	 * This method returns image for the right soft key(rsk) setting. The image
	 * is scaled to preset size.
	 * 
	 * @param icon
	 * @return
	 */
	private Image getRskFromImage(IScreenElement screen, ImageData icon,
			ImageData mask) {
		Image iconIm, maskIm;

		// If one side image is longer than prepared RSK slice, then new icon
		// proportions are computed
		float iconWidth = icon.width;
		float iconHeight = icon.height;
		float newIconWidth = RSK_WIDTH;
		float newIconHeight = RSK_HEIGHT;
		float scale;
		float widthRatio = iconWidth / RSK_WIDTH;
		float heightRatio = iconHeight / RSK_HEIGHT;

		if (widthRatio >= heightRatio && iconWidth >= RSK_WIDTH) {
			newIconWidth = RSK_WIDTH;
			scale = RSK_WIDTH / iconWidth;
			newIconHeight = (iconHeight * scale);
		} else if (iconHeight > RSK_HEIGHT) {
			newIconHeight = RSK_HEIGHT;
			scale = (float) RSK_HEIGHT / iconHeight;
			newIconWidth = (float) iconWidth * scale;
		}

		if (mask != null) {
			maskIm = new Image(Display.getDefault(), mask.scaledTo(icon.width,
					icon.height));
			int width = maskIm.getBounds().width;
			int height = maskIm.getBounds().height;
			byte[] alphaData = new byte[height * width];
			for (int y = 0; y < height; y++) {
				byte[] alphaRow = new byte[width];
				for (int x = 0; x < width; x++) {
					RGB rgb = maskIm.getImageData().palette.getRGB(maskIm
							.getImageData().getPixel(x, y));
					alphaRow[x] = (byte) ((rgb.red + rgb.green + rgb.blue) / 3);
				}
				System.arraycopy(alphaRow, 0, alphaData, y * width, width);
			}
			icon.alphaData = alphaData;
		}

		iconIm = new Image(Display.getDefault(), icon);
		Image backgroundSubImage = getBackgroundSubImage(screen);

		GC scaledGc = new GC(backgroundSubImage);

		scaledGc.setAntialias(SWT.ON);
		scaledGc.setInterpolation(SWT.HIGH);

		scaledGc.drawImage(iconIm, 0, 0, iconIm.getBounds().width, iconIm
				.getBounds().height, (RSK_WIDTH - (int) newIconWidth) / 2,
				(RSK_HEIGHT - (int) newIconHeight) / 2, (int) newIconWidth,
				(int) newIconHeight);

		scaledGc.dispose();
		return backgroundSubImage;
	}

	private Image getBackgroundSubImage(IScreenElement screen) {

		if (screen == null) {
			return null;
		}
		Component idleBgCanvas = (Component) EditingUtil.getBean(screen
				.getWidget());

		BufferedImage bg = new BufferedImage(idleBgCanvas.getWidth(),
				idleBgCanvas.getHeight(), BufferedImage.TYPE_INT_ARGB);

		java.awt.Graphics g = bg.getGraphics();

		idleBgCanvas.printAll(g);

		BufferedImage subImage = bg.getSubimage(idleBgCanvas.getWidth()
				- RSK_WIDTH, idleBgCanvas.getHeight() - RSK_HEIGHT, RSK_WIDTH,
				RSK_HEIGHT);

		ImageData subImageSwt = convertToSWT(subImage);

		return new Image(null, subImageSwt);

	}

	class ImageDecodedRunnable implements Runnable {

		private ImageLoader job;
		private ImageData imageData;
		private String name;

		public ImageDecodedRunnable(ImageLoader job, ImageData imageData,
				String name) {
			this.job = job;
			this.imageData = imageData;
			this.name = name;
		}

		public void run() {
			synchronized (ThemePreviewController.this) {
				if (topComposite == null || topComposite.isDisposed()) {
					return;
				}
				if (loader != job) {
					return;
				}
				thumbsContent.addUserObject(labelProvider.add(imageData, name));
				int h = thumbsSC.getClientArea().height;
				thumbsContent.setSize(thumbsContent.computeSize(SWT.DEFAULT, h,
						true));
			}
		}

	}

	protected void imageDecoded(ImageLoader job, ImageData imageData,
			String name) {
		Display display;
		synchronized (this) {
			if (job != loader || topComposite == null
					|| topComposite.isDisposed()) {
				return;
			}
			display = topComposite.getDisplay();
		}

		display.syncExec(new ImageDecodedRunnable(job, imageData, name));
	}

	static ImageData convertToSWT(BufferedImage bufferedImage) {
		DirectColorModel colorModel = (DirectColorModel) bufferedImage
				.getColorModel();
		PaletteData palette = new PaletteData(colorModel.getRedMask(),
				colorModel.getGreenMask(), colorModel.getBlueMask());
		ImageData data = new ImageData(bufferedImage.getWidth(), bufferedImage
				.getHeight(), colorModel.getPixelSize(), palette);

		int[] rgbArray = new int[data.width * data.height];
		bufferedImage.getRGB(0, 0, data.width, data.height, rgbArray, 0,
				data.width);
		data.setPixels(0, 0, data.width * data.height, rgbArray, 0);
		return data;

	}
}
