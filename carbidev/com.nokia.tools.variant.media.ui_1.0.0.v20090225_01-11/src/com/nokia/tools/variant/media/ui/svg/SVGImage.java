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

package com.nokia.tools.variant.media.ui.svg;

import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.DirectColorModel;
import java.awt.image.IndexColorModel;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscodingHints;
import org.apache.batik.transcoder.XMLAbstractTranscoder;
import org.apache.batik.transcoder.image.ImageTranscoder;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.PaletteData;
import org.eclipse.swt.graphics.RGB;

/**
 * File to handle svg image
 */
public class SVGImage {

	private Map<TranscodingHints.Key, Object> transcoderHints = new HashMap<TranscodingHints.Key, Object>();

	private RenderingHints renderingHints = null;

	private TranscoderInput input;

	private BufferedImage svgAsBufferedImage = null;

	private String preserveAspectRatio = null;

	public static final String PRESERVE_ASPECT = "xMidYMid slice";

	public static final String PRESERVE_STRETCH = "none";
	public static final String STRETCH = "STRETCH";
	public static final String ASPECT_RATIO = "PRESERVE_ASPECT_RATIO_CROP_EXCEEDING";

	/**
	 * Default constructor
	 */
	public SVGImage() {
	}

	/**
	 * Constructor
	 * 
	 * @param svgFileName
	 *            The name of the svg file to be loaded
	 * @throws IOException
	 *             if the svg file load fails
	 */
	public SVGImage(URL url) throws IOException {
		setImage(url);
	}

	/**
	 * Constructor
	 * 
	 * @param svgFileName
	 *            The name of the svg file to be loaded
	 * @param scalingMode
	 *            The scaling mode that overrides the svg aspect ratio setting.
	 * @throws IOException
	 *             if the svg file load fails
	 */
	public SVGImage(URL url, String scalingMode) throws IOException {
		setImage(url);
		setScalingMode(scalingMode);
	}

	/**
	 * Constructor
	 * 
	 * @param svgFileName
	 *            The name of the svg file to be loaded
	 * @param renderingHints
	 *            The hints for rendering
	 * @throws IOException
	 *             if the svg file load fails
	 */
	public SVGImage(URL url, RenderingHints renderingHints) throws IOException {
		setRenderingHints(renderingHints);
		setImage(url);
	}

	/**
	 * Constructor
	 * 
	 * @param svgFileName
	 *            The name of the svg file to be loaded
	 * @param renderingHints
	 *            The hints for rendering
	 * @param scalingMode
	 *            The scaling mode that overrides the svg aspect ratio setting.
	 * @throws IOException
	 *             if the svg file load fails
	 */
	public SVGImage(URL url, RenderingHints renderingHints, String scalingMode)
			throws IOException {
		setRenderingHints(renderingHints);
		setImage(url);
		setScalingMode(scalingMode);
	}

	/**
	 * Sets the file containing the svg document (image)
	 * 
	 * @param svgFile
	 *            The svg file name
	 */
	public void setImage(URL url) throws IOException {
		input = new TranscoderInput(url.openStream());
	}

	public void setInput(TranscoderInput input) {
		this.input = input;
	}

	/**
	 * Returns the svg image as a bufferedImage object
	 * 
	 * @return The svg image as buffered image
	 */
	public BufferedImage getAsBufferedImage() throws Exception {

		if (svgAsBufferedImage == null) {

			RasterTranscoder transcoder = new RasterTranscoder(
					preserveAspectRatio);
			transcoderHints.put(
					ImageTranscoder.KEY_DOCUMENT_ELEMENT_NAMESPACE_URI,
					"http://www.w3.org/2000/svg");
			transcoderHints.put(
					XMLAbstractTranscoder.KEY_XML_PARSER_VALIDATING, false);

			transcoder.setTranscodingHints(transcoderHints);

			input.setURI("file://null");
			transcoder.transcode(input, null);

			svgAsBufferedImage = transcoder.getBufferedImage();
		}

		return svgAsBufferedImage;
	}

	// public java.awt.Image toImage(BufferedImage bufferedImage) {
	//		
	// return
	// Toolkit.getDefaultToolkit().createImage(bufferedImage.getSource());
	// }

	/**
	 * 
	 */
	public static ImageData convertToSWT(BufferedImage bufferedImage) {

		if (bufferedImage.getColorModel() instanceof DirectColorModel) {
			DirectColorModel colorModel = (DirectColorModel) bufferedImage
					.getColorModel();
			PaletteData palette = new PaletteData(colorModel.getRedMask(),
					colorModel.getGreenMask(), colorModel.getBlueMask());
			ImageData data = new ImageData(bufferedImage.getWidth(),
					bufferedImage.getHeight(), colorModel.getPixelSize(),
					palette);
			WritableRaster raster = bufferedImage.getRaster();
			int[] pixelArray = new int[4];
			for (int y = 0; y < data.height; y++) {
				for (int x = 0; x < data.width; x++) {
					raster.getPixel(x, y, pixelArray);
					int pixel = palette.getPixel(new RGB(pixelArray[0],
							pixelArray[1], pixelArray[2]));
					data.setPixel(x, y, pixel);
					colorModel.getAlphaMask();
					int alpha = pixelArray[3];
					data.setAlpha(x, y, alpha);
				}
			}
			return data;
		} else if (bufferedImage.getColorModel() instanceof IndexColorModel) {
			IndexColorModel colorModel = (IndexColorModel) bufferedImage
					.getColorModel();
			int size = colorModel.getMapSize();
			byte[] reds = new byte[size];
			byte[] greens = new byte[size];
			byte[] blues = new byte[size];
			colorModel.getReds(reds);
			colorModel.getGreens(greens);
			colorModel.getBlues(blues);
			RGB[] rgbs = new RGB[size];
			for (int i = 0; i < rgbs.length; i++) {
				rgbs[i] = new RGB(reds[i] & 0xFF, greens[i] & 0xFF,
						blues[i] & 0xFF);
			}
			PaletteData palette = new PaletteData(rgbs);
			ImageData data = new ImageData(bufferedImage.getWidth(),
					bufferedImage.getHeight(), colorModel.getPixelSize(),
					palette);
			data.transparentPixel = colorModel.getTransparentPixel();
			WritableRaster raster = bufferedImage.getRaster();
			int[] pixelArray = new int[1];
			for (int y = 0; y < data.height; y++) {
				for (int x = 0; x < data.width; x++) {
					raster.getPixel(x, y, pixelArray);
					data.setPixel(x, y, pixelArray[0]);
				}
			}
			return data;
		}
		return null;
	}

	/**
	 * Sets the dimension of the rendered image. Also calls repaint once the
	 * dimension is set
	 * 
	 * @param imgWidth
	 *            The width of the image
	 * @param imgHeight
	 *            The height of the image
	 */
	public void setSize(int imgWidth, int imgHeight) {

		if (imgWidth > 0) {
			transcoderHints.put(ImageTranscoder.KEY_WIDTH, new Float(imgWidth));
		}

		if (imgHeight > 0) {
			transcoderHints.put(ImageTranscoder.KEY_HEIGHT,
					new Float(imgHeight));
		}

		/*
		 * If the width or height of the image is different from the size of the
		 * existing buffered image then set it to null (so that it will be
		 * regenerated when requested again)
		 */
		if (svgAsBufferedImage != null) {
			int bufImgHeight = svgAsBufferedImage.getHeight();
			int bugImgWidth = svgAsBufferedImage.getWidth();

			if (imgHeight > 0 && imgHeight != bufImgHeight)
				svgAsBufferedImage = null;

			if (imgWidth > 0 && imgWidth != bugImgWidth)
				svgAsBufferedImage = null;
		}
	}

	/**
	 * Sets the rendering hints
	 * 
	 * @param hints
	 *            The rendering hints
	 */
	public void setRenderingHints(RenderingHints hints) {
		renderingHints = hints;
	}

	/**
	 * Sets the scaling mode for the image
	 * 
	 * @param scalingMode
	 *            Sets the scaling mode.Currently supports
	 *            "PRESERVE_ASPECT_RATIO_CROP_EXCEEDING" and "STRETCH" modes.
	 */
	public void setScalingMode(String scalingMode) {
		String svgAspectRatioString = null;
		if (scalingMode != null) {
			scalingMode = scalingMode.trim();
		} else {
			scalingMode = "";
		}

		if (ASPECT_RATIO.equalsIgnoreCase(scalingMode)) {
			svgAspectRatioString = PRESERVE_ASPECT;
		} else if (STRETCH.equalsIgnoreCase(scalingMode))
			svgAspectRatioString = PRESERVE_STRETCH; // doesnt maintain the
		// svg aspect
		// ratio definition

		if (preserveAspectRatio != svgAspectRatioString) {
			preserveAspectRatio = svgAspectRatioString;
			svgAsBufferedImage = null; // need to reconstruct if the aspect
			// ratio setting has changed
		}
	}
}
