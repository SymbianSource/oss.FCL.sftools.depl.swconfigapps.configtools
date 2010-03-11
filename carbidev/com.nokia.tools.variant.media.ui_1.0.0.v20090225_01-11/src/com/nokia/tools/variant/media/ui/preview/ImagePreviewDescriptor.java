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
 * Description: This file is part of com.nokia.tools.variant.media.ui component.
 */

package com.nokia.tools.variant.media.ui.preview;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferInt;
import java.awt.image.SinglePixelPackedSampleModel;
import java.io.BufferedInputStream;
import java.io.InputStream;

import org.apache.batik.transcoder.TranscoderInput;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.content.IContentType;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;

import com.nokia.tools.variant.common.core.utils.FileUtils;
import com.nokia.tools.variant.media.ui.MediaUIPlugin;
import com.nokia.tools.variant.media.ui.svg.SVGImage;
import com.nokia.tools.variant.preview.PreviewController;

public class ImagePreviewDescriptor implements IImagePreviewDescriptor {

	private ImageData[] imageData;
	private IStorage content;
	private IContentType contentType;
	private ImageLoader imageLoader;

	public ImagePreviewDescriptor(IContentType contentType, IStorage content)
			throws Exception {
		this.content = content;
		this.contentType = contentType;
	}

	public ImagePreviewDescriptor(ImageData... images) throws Exception {
		this.imageData = images;
	}

	public ImageData getFrame(int frame) {
		buildImageData();
		return imageData[frame];
	}

	public int getFrameCount() {
		buildImageData();
		return imageData.length;
	}

	public PreviewController createPreviewControl() {
		return new ImagePreviewController();
	}

	protected void buildImageData() {
		if (imageData != null) {
			return;
		}
		imageData = buildImageData(contentType, content);
	}
	
	ImageData[] buildImageData(IContentType contentType, IStorage content) {
		InputStream is = null;
		try {
			is = new BufferedInputStream(content.getContents());
			if (contentType.isKindOf(MediaUIPlugin.CT_IMAGE_SVG)) {
				return new ImageData[] { buildSVGImageData(is) };
			} else {
				ImageLoader loader = new ImageLoader();
				imageLoader = loader;
				return loader.load(is);
			}
		} catch (Exception ex) {
			return new ImageData[0];
		} finally {
			FileUtils.closeStream(is);
		}
		
	}
	

	protected static ImageData buildSVGImageData(InputStream content)
			throws Exception {
		TranscoderInput input = new TranscoderInput(content);
		SVGImage svgImage = new SVGImage();
		svgImage.setInput(input);

		BufferedImage bufferedImage = svgImage.getAsBufferedImage();

		int width2 = bufferedImage.getWidth();
		int height2 = bufferedImage.getHeight();

		// pixel data packed
		SinglePixelPackedSampleModel singlePixelPackedSampleModel = new SinglePixelPackedSampleModel(
				DataBuffer.TYPE_INT, 5, width2, height2,
				new int[] { 224, 24, 7 });

		// set white background
		forceTransparentWhite(bufferedImage, singlePixelPackedSampleModel);

		return SVGImage.convertToSWT(bufferedImage);

	}

	/**
	 * 
	 * @param img
	 * @param sppsm
	 */
	private static void forceTransparentWhite(BufferedImage img,
			SinglePixelPackedSampleModel sppsm) {

		//
		// This is a trick so that viewers which do not support
		// the alpha channel will see a white background (and not
		// a black one).
		//
		int w = img.getWidth();
		int h = img.getHeight();
		DataBufferInt biDB = (DataBufferInt) img.getRaster().getDataBuffer();
		int scanStride = sppsm.getScanlineStride();
		int dbOffset = biDB.getOffset();
		int[] pixels = biDB.getBankData()[0];
		int p = dbOffset;
		int adjust = scanStride - w;
		int a = 0, r = 0, g = 0, b = 0, pel = 0;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				pel = pixels[p];
				a = (pel >> 24) & 0xff;
				r = (pel >> 16) & 0xff;
				g = (pel >> 8) & 0xff;
				b = pel & 0xff;
				r = (255 * (255 - a) + a * r) / 255;
				g = (255 * (255 - a) + a * g) / 255;
				b = (255 * (255 - a) + a * b) / 255;
				pixels[p++] = (a << 24 & 0xff000000) | (r << 16 & 0xff0000)
						| (g << 8 & 0xff00) | (b & 0xff);
			}
			p += adjust;
		}

	}

	public ImageLoader getImageLoader() {
		return imageLoader;
	}

}
