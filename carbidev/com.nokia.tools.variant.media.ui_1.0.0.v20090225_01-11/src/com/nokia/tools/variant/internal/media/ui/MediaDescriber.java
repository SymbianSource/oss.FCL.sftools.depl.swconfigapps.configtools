/*
 * Copyright (c) 2009 Nokia Corporation and/or its subsidiary(-ies). 
 * All rights reserved.
 * This component and the accompanying materials are made available
 * under the terms of the License "Eclipse Public License v1.0"
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

package com.nokia.tools.variant.internal.media.ui;

import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.util.Map;
import java.util.concurrent.Semaphore;

import javax.media.ControllerEvent;
import javax.media.ControllerListener;
import javax.media.Format;
import javax.media.Manager;
import javax.media.NoProcessorException;
import javax.media.PrefetchCompleteEvent;
import javax.media.Processor;
import javax.media.StopEvent;
import javax.media.Time;
import javax.media.control.TrackControl;
import javax.media.format.AudioFormat;
import javax.media.format.VideoFormat;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.core.runtime.content.IContentDescriber;
import org.eclipse.core.runtime.content.IContentDescription;

import com.nokia.tools.variant.common.core.utils.FileUtils;
import com.nokia.tools.variant.media.ui.MediaUIPlugin;

public class MediaDescriber implements IContentDescriber, IExecutableExtension {

	private String ext;

	public MediaDescriber() {
	}

	public void setInitializationData(IConfigurationElement config,
			String propertyName, Object data) throws CoreException {
		if ("describer".equals(propertyName) && data instanceof Map) {
			Map<?, ?> map = (Map<?, ?>) data;
			Object value = map.get("extension");
			ext = (String) value;
		}
	}

	private File createTempFile(InputStream contents,
			IContentDescription description) throws Exception {
		File tempFile = File.createTempFile("temp", "."
				+ (ext == null ? "wav" : ext));
		FileOutputStream fos = new FileOutputStream(tempFile);
		try {
			long length = FileUtils.copyStream(contents, fos);
			if (description != null) {
				description.setProperty(MediaUIPlugin.SIZE, length);
			}
		} finally {
			FileUtils.closeStream(fos);
			tempFile.deleteOnExit();
		}
		return tempFile;
	}

	public static void copyFile(File in, File out) throws IOException {
		FileChannel inChannel = new FileInputStream(in).getChannel();
		FileChannel outChannel = new FileOutputStream(out).getChannel();
		try {
			inChannel.transferTo(0, inChannel.size(), outChannel);
		} catch (IOException e) {
			throw e;
		} finally {
			if (inChannel != null)
				inChannel.close();
			if (outChannel != null)
				outChannel.close();
		}
	}

	public int describe(InputStream contents, IContentDescription description)
			throws IOException {

		if (description == null) {
			return INDETERMINATE;
		}

		File tempFile = null;

		try {
			tempFile = createTempFile(contents, description);
			final Semaphore sem = new Semaphore(0);
			Processor p = null;
			try {
				// force get info - bug 5979, 8812
				String ext = FileUtils.getExtension(tempFile);
				if (ext.equalsIgnoreCase("mpeg")) {
					String path = tempFile.getAbsolutePath();
					String substring = path.substring(0, path
							.lastIndexOf(".mpeg"));
					File file = new File(substring + ".mpg");
					copyFile(tempFile, file);					
					p = Manager.createProcessor(file.toURL());
					
					file.deleteOnExit();
					
					if (p == null) {
						return INDETERMINATE;
					}
				}else{
				
					if (tempFile.length() != 0) {
						p = Manager.createProcessor(tempFile.toURL());
					} else {
						return INDETERMINATE;
					}
				}

			} catch (NoProcessorException e) {
				
			}
			p.addControllerListener(new ControllerListener() {
				public void controllerUpdate(ControllerEvent arg0) {
					if (arg0 instanceof PrefetchCompleteEvent) {
						sem.release(1);
					}
					if (arg0 instanceof StopEvent) {
						sem.release(3);
					}
				}
			});
			p.prefetch();
			sem.acquire();

			Time duration = p.getDuration();
			description.setProperty(MediaUIPlugin.DURATION, duration
					.getSeconds());

			for (TrackControl tc : p.getTrackControls()) {
				Format f = tc.getFormat();

				if (f instanceof VideoFormat) {
					VideoFormat vf = (VideoFormat) f;
					description.setProperty(MediaUIPlugin.VIDEO_CODEC, vf
							.getEncoding());
					description.setProperty(MediaUIPlugin.VIDEO_FRAMERATE, vf
							.getFrameRate());
					Dimension d = vf.getSize();
					description.setProperty(MediaUIPlugin.VIDEO_WIDTH, d.width);
					description.setProperty(MediaUIPlugin.VIDEO_HEIGHT,
							d.height);
				}
				if (f instanceof AudioFormat) {
					AudioFormat af = (AudioFormat) f;
					description.setProperty(MediaUIPlugin.AUDIO_CODEC, af
							.getEncoding());
					description.setProperty(MediaUIPlugin.AUDIO_CHANNELS, af
							.getChannels());
					description.setProperty(MediaUIPlugin.AUDIO_FRAMERATE, af
							.getFrameRate());
					description.setProperty(MediaUIPlugin.AUDIO_SAMPLERATE, af
							.getSampleRate());
				}
			}
			p.deallocate();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (tempFile != null) {
				tempFile.delete();
			}
		}

		return INDETERMINATE;
	}

	public QualifiedName[] getSupportedOptions() {
		return new QualifiedName[] { MediaUIPlugin.SIZE,
				MediaUIPlugin.DURATION, MediaUIPlugin.VIDEO_CODEC,
				MediaUIPlugin.VIDEO_FRAMERATE, MediaUIPlugin.VIDEO_WIDTH,
				MediaUIPlugin.VIDEO_HEIGHT, MediaUIPlugin.AUDIO_CODEC,
				MediaUIPlugin.AUDIO_CHANNELS, MediaUIPlugin.AUDIO_FRAMERATE,
				MediaUIPlugin.AUDIO_SAMPLERATE };
	}
}
