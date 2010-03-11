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
 * Description: This file is part of com.nokia.tools.variant.viewer component.
 */

package com.nokia.tools.variant.viewer.widgets.summary;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTException;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import com.nokia.tools.variant.viewer.widgets.BaseConfMLWidget;

/**
 * This class represents UI component which displayes ribbon of images. This class use ImageGallery class
 * which displayes respective images. This UI component is inserted to the editor viewer.
 *
 */
public class ProductImagesBox extends BaseConfMLWidget {
	final List<ISelectionChangedListener> listeners = new ArrayList<ISelectionChangedListener>();
	private String value;
	private String[] values;

	public ProductImagesBox(Composite parent, int style, String widgetLabel) {
		super(parent, style, widgetLabel);
	}

	public ProductImagesBox(Composite parent, int style, String widgetLabel,
			Image image) {
		super(parent, style, widgetLabel, image);
	}

	private ScrolledComposite thumbsSC;
	private ImageGallery thumbsContent;
	private List<ImageData> imageData;

	boolean isResize;

	@Override
	protected void buildMainControl() {
		if (values == null) {
			return;
		}
		thumbsSC = new ScrolledComposite(group, SWT.HORIZONTAL | SWT.BORDER);
		thumbsSC.setLayout(new GridLayout());
		thumbsSC.setExpandHorizontal(true);
		thumbsSC.setExpandVertical(false);

		thumbsSC.setBackground(group.getBackground());
		// thumbsSC.setAlwaysShowScrollBars(true);
		GridData data = new GridData();
		data.widthHint = 253;
		data.heightHint = 64;

		thumbsSC.setLayoutData(data);

		try {

			List<File> listFiles = new ArrayList<File>();
			for (String filePath : values) {
				listFiles.add(new File(filePath));
			}
			imageData = new ArrayList<ImageData>();
			for (File file : listFiles) {
				FileInputStream fis = null;
				BufferedInputStream is = null;

				try {
					fis = new FileInputStream(file.getAbsolutePath());
					is = new BufferedInputStream(fis);

					ImageLoader loader = new ImageLoader();
					try {
						ImageData[] load = loader.load(is);
						if (load.length > 0) {
							imageData.add(load[0]);
						}
					} catch (SWTException imageException) {
						// skip non-recognized image files
					}
				} catch (FileNotFoundException fnfe) {
					//do nothing
				} finally {
					if (is != null) {
						is.close();
					}
					if (fis != null) {
						fis.close();
					}

				}

			}

			ThemeContainer labelProvider = new ThemeContainer();
			thumbsContent = new ImageGallery(thumbsSC, SWT.NONE, labelProvider);

			if (imageData == null)
				return;

			for (ImageData image : imageData) {
				thumbsContent.addUserObject(labelProvider.add(image, ""));
			}

			// int h = thumbsSC.getClientArea().height;

			thumbsContent.setSize(thumbsContent.computeSize(SWT.DEFAULT,
					SWT.DEFAULT, true));

			thumbsSC.setContent(thumbsContent);

			thumbsSC.addListener(SWT.Resize, new Listener() {
				public void handleEvent(Event event) {
					Rectangle ca = thumbsSC.getClientArea();
					Point size = thumbsContent.computeSize(SWT.DEFAULT,
							ca.height);
					thumbsContent.setSize(size);
					if ((thumbsContent.getSize().x > thumbsContent
							.getNrOfImages()
							* thumbsContent.getImageSize().x)
							&& (!isResize)) {
						GridData data = new GridData();
						data.widthHint = 275;
						data.heightHint = 64 - thumbsSC.getHorizontalBar()
								.getSize().y;
						thumbsSC.setLayoutData(data);
					}
					isResize = true;
					thumbsSC.setMinSize(size);

				}
			});

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void clearErrorMessage() {
		

	}

	@Override
	public void addListener(Listener listener) {
		super.addListener(listener);
		if (thumbsContent != null) {
			thumbsContent.addListener(SWT.Selection, listener);
			thumbsContent.addListener(SWT.MouseDown, listener);
			thumbsContent.setListener(listener);
			// l.addListener(SWT.MouseDown, listener);
		}
	}

	@Override
	public String getValue() {

		return value;
	}

	@Override
	public void setValue(String value) {
		this.value = value;
		parseValues(value);
		buildMainControl();
	}

	private void parseValues(String value) {
		values = value.split(">");

	}

	public void buildWidget(Composite composite, String label,
			Map<String, String> options) {
		

	}

	public void refresh(String currentValue) {
		

	}

	public void setInitialValue(String initialValue) {
		

	}

	static class Data {
		Image image;
		String label;
	}

	static class ThemeContainer extends LabelProvider {
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

	@Override
	protected GridData layoutDataForLabel(int width) {
		GridData gridData = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING
				| GridData.VERTICAL_ALIGN_BEGINNING);
		gridData.widthHint = width;
		return gridData;
	}

	@Override
	public Object getData() {

		int index = thumbsContent.getSelectedIndex();

		if (index != -1) {

			final String chosenImagePath = values[index];
			IStorage storage = new IStorage() {

				public InputStream getContents() throws CoreException {

					try {
						return new FileInputStream(new File(chosenImagePath));
					} catch (FileNotFoundException e) {

						e.printStackTrace();
					}
					return null;
				}

				public IPath getFullPath() {

					return new Path(chosenImagePath);
				}

				public String getName() {

					return new File(chosenImagePath).getName();
				}

				public boolean isReadOnly() {

					return false;
				}

				@SuppressWarnings("unchecked")
				public Object getAdapter(Class adapter) {

					return null;
				}

			};
			return storage;
		}
		return null;

	}
}
