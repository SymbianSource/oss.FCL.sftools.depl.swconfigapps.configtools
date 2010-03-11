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

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Timer;
import java.util.TimerTask;

import javax.media.ControllerEvent;
import javax.media.ControllerListener;
import javax.media.Manager;
import javax.media.Player;
import javax.media.RealizeCompleteEvent;
import javax.media.StartEvent;
import javax.media.StopEvent;
import javax.media.Time;

import org.eclipse.core.resources.IStorage;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.util.SafeRunnable;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.IActionBars;

import com.nokia.tools.variant.common.core.utils.ExceptionUtils;
import com.nokia.tools.variant.common.core.utils.FileUtils;
import com.nokia.tools.variant.common.core.utils.PlatformUtil;
import com.nokia.tools.variant.media.ui.MediaUIPlugin;
import com.nokia.tools.variant.preview.IPreviewDescriptor;
import com.nokia.tools.variant.preview.PluginImages;
import com.nokia.tools.variant.preview.PreviewController;

/**
 * Controller that can preview frame animation plus audio channel.
 */
public class ImagePreviewController extends PreviewController {

	private Point imageSize;
	private int scaleFactor;
	private Point canvasSize;
	private ScrolledComposite topComposite;
	private Composite imageComposite;
	private Canvas canvas;

	private int frame;
	private PlayTask playTask;
	private static final Timer timer = new Timer("Frame animation player", true);

	private IImagePreviewDescriptor descriptor;

	private final PlayAction playAction = new PlayAction();
	private final LoopAction loopAction = new LoopAction();
	private final FrameNextAction nextFrameAction = new FrameNextAction();
	private final FramePrevAction prevFrameAction = new FramePrevAction();
	private final Separator zoomSeparator = new Separator("GROUP.ZOOM");
	private final Separator playSeparator = new Separator("GROUP.PLAY");

	private Player player;
	private IAudioPreviewDescriptor audio;
	private File tempAudioFile;
	private Image firstBuffer;
	private GC firstBufferGC;

	/** Disable zoom in action when current image width exceeds MAX_IMAGE_WIDTH */
	private static final int MAX_IMAGE_WIDTH = 2280;

	/**
	 * Disable zoom in action when current image height exceeds MAX_IMAGE_HEIGHT
	 */
	private static final int MAX_IMAGE_HEIGHT = 2024;

	private ListenerList resolutionChangeListeners = new ListenerList();

	/**
	 * 
	 * @param path
	 */
	public ImagePreviewController() {
	}

	/**
	 * 
	 */
	public void createControl(Composite parent) {
		imageSize = new Point(0, 0);
		canvasSize = new Point(0, 0);
		topComposite = new ScrolledComposite(parent, SWT.H_SCROLL | SWT.V_SCROLL);
		topComposite.setExpandHorizontal(true);
		topComposite.setExpandVertical(true);
		topComposite.setBackground(ColorConstants.white);
		topComposite.setLayout(new FillLayout());

		imageComposite = new Composite(topComposite, SWT.NONE);
		imageComposite.setBackground(topComposite.getBackground());
		topComposite.setContent(imageComposite);
		imageComposite.setLayout(new GridLayout(1, false));

		Composite border = new Composite(imageComposite, SWT.NONE);
		border.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true));
		border.setLayout(new GridLayout());
		canvas = new Canvas(border, SWT.DOUBLE_BUFFERED) {
			@Override
			public Point computeSize(int hHint, int wHint, boolean changed) {
				Point im = new Point(canvasSize.x, canvasSize.y);

				if (hHint != SWT.DEFAULT) {
					im.x = hHint;
				}
				if (wHint != SWT.DEFAULT) {
					im.y = hHint;
				}

				return im;
			}
		};
		topComposite.addListener(SWT.Resize, new Listener() {
			public void handleEvent(Event event) {
				Point size = imageComposite.computeSize(SWT.DEFAULT, SWT.DEFAULT, true);
				Rectangle ca = topComposite.getClientArea();
				size.x = Math.max(size.x, ca.width);
				size.y = Math.max(size.y, ca.height);
				imageComposite.setSize(size);
				imageComposite.layout(true);
				topComposite.setMinSize(size);
			}
		});

		GridData gd = new GridData(SWT.CENTER, SWT.CENTER, true, true);
		gd.minimumHeight = canvasSize.y;
		gd.minimumWidth = canvasSize.x;
		canvas.setLayoutData(gd);
		canvas.setBackground(parent.getBackground());

		canvas.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
					drawFrame(e, frame);
			}
		});
	}

	private ImageData prevId;  

	
	protected void drawFrame(PaintEvent e, int frameId) {
		if (descriptor.getFrameCount() <= frameId) {
			// no frame to draw
			return;
		}
		
		Rectangle target = canvas.getClientArea();
		ImageData id = descriptor.getFrame(frameId);
		int w = 0;
		int h = 0;
		ImageLoader imageLoader = descriptor.getImageLoader();
		if (imageLoader != null) {
			w = imageLoader.logicalScreenWidth;
			h = imageLoader.logicalScreenHeight;
		}
		if (prevId != null) {
			if (prevId.disposalMethod == SWT.DM_FILL_BACKGROUND) {
				// Fill with the background color before drawing.
				Color bgColor = null;
				int backgroundPixel = -1;
				if (imageLoader != null) {
					backgroundPixel = imageLoader.backgroundPixel;
				}
				if (backgroundPixel != -1) {
					// Fill with the background color.
					RGB backgroundRGB = prevId.palette.getRGB(backgroundPixel);
					bgColor = new Color(null, backgroundRGB);
				}
				try {
					firstBuffer.setBackground(bgColor != null ? bgColor : firstBuffer.getBackground());
					firstBufferGC.fillRectangle(
						prevId.x,
						prevId.y,
						prevId.width,
						prevId.height);
				} finally {
					if (bgColor != null) bgColor.dispose();
				}
			} else if (prevId.disposalMethod == SWT.DM_FILL_PREVIOUS) {
				// Restore the previous image before drawing.
				firstBufferGC.drawImage(
						firstBuffer,
					0,
					0,
					prevId.width,
					prevId.height,
					prevId.x,
					prevId.y,
					prevId.width,
					prevId.height);
			}
		}
		// store previous image data
		prevId = id;  

		
		
		Image nextFrame = new Image(Display.getDefault(), id);
		firstBufferGC.drawImage(nextFrame, 0, 0, id.width,
				id.height, id.x, id.y, id.width,
				id.height);
		nextFrame.dispose();
		Rectangle b = canvas.getBounds();
		int ch = b.height;
		int cw = b.width;
		if (h == 0) {
			h = id.height;
		}
		if (w == 0) {
			w = id.width;
		}
		
		e.gc.drawImage(firstBuffer, 0, 0, w, h, 0, 0, cw, ch);
	}

	/**
	 * Send information about current size of displayed image. This information
	 * is used to enable/disable further zooming in, in case that current image
	 * is already too large.
	 * 
	 * @param width
	 *            current width
	 * @param height
	 *            current height
	 */
	private void fireNewImageSize(final int width, final int height) {
		for (final Object listener : resolutionChangeListeners.getListeners()) {
			SafeRunner.run(new SafeRunnable() {
				public void run() throws Exception {
					ResolutionChangeListener rcl = (ResolutionChangeListener) listener;
					rcl.currentResolutionChanged(width, height);
				}
			});
		}
	}

	protected void updateCanvasBounds() {
		Point newCanvasSize = new Point(imageSize.x, imageSize.y);
		if (scaleFactor > 0) {
			for (int i = 0; i < scaleFactor; i++) {
				newCanvasSize.x *= 2;
				newCanvasSize.y *= 2;
			}
		} else if (scaleFactor < 0) {
			for (int i = scaleFactor; i < 0; i++) {
				newCanvasSize.x /= 2;
				newCanvasSize.y /= 2;
			}
		}
		Point oldCanvasSize = this.canvasSize;
		this.canvasSize = newCanvasSize;

		if (canvas != null && !canvas.isDisposed()) {
			GridData gd = (GridData) canvas.getLayoutData();
			gd.minimumHeight = newCanvasSize.y;
			gd.minimumWidth = newCanvasSize.x;

			Point size = imageComposite.computeSize(SWT.DEFAULT, SWT.DEFAULT,
					true);
			Rectangle ca = topComposite.getClientArea();
			size.x = Math.max(size.x, ca.width);
			size.y = Math.max(size.y, ca.height);
			imageComposite.setSize(size);
			imageComposite.layout(new Control[] { canvas });
			imageComposite.redraw();
			topComposite.setMinSize(size);
		}
		if (!newCanvasSize.equals(oldCanvasSize)) {
			fireNewImageSize(newCanvasSize.x, newCanvasSize.y);
		}
	}

	@Override
	public Control getControl() {
		return topComposite;
	}

	@Override
	public void setInput(IPreviewDescriptor descriptor) {
		prevId = null;
		stopPlaying();
		disposeImage();
		frame = 0;

		this.descriptor = (IImagePreviewDescriptor) descriptor;

		if (this.descriptor.getFrameCount() > 0) {
			ImageData id = this.descriptor.getFrame(0);
			if (this.descriptor.getImageLoader() == null) {
				imageSize = new Point(0, 0);
			} else {
				imageSize = new Point(this.descriptor.getImageLoader().logicalScreenWidth, this.descriptor.getImageLoader().logicalScreenHeight);
			}
			if (imageSize.x == 0 && imageSize.y == 0) {
				imageSize = new Point(id.width, id.height);
			}
			firstBuffer = new Image(Display.getDefault(), imageSize.x, imageSize.y);
			firstBufferGC = new GC(firstBuffer);
			firstBufferGC.setBackground(topComposite.getBackground());
			firstBufferGC.fillRectangle(0, 0, imageSize.x,
					imageSize.y);
			
			// initialize first frame
            Image image = new Image(Display.getDefault(), id);
            firstBufferGC.drawImage(image, 0, 0, id.width, id.height,
            		id.x, id.y, id.width, id.height);
            image.dispose();
		} else {
			imageSize = new Point(0, 0);
		}

		if (descriptor instanceof IAudioPreviewDescriptor) {
			this.audio = (IAudioPreviewDescriptor) descriptor;
		} else {
			this.audio = null;
		}

		setActionBars(getActionBars());
		updateCanvasBounds();
	}

	@Override
	public void dispose() {
		disposeImage();
		cleanupAudioResources();
		resolutionChangeListeners.clear();
		resolutionChangeListeners = null;
		if (firstBuffer != null) {
			firstBuffer.dispose();
			firstBuffer = null;
		}
		if (canvas != null) {
			canvas.dispose();
			canvas = null;
		}
		if (topComposite != null) {
			if (!topComposite.isDisposed()) {
				for (Control child : topComposite.getChildren()) {
					if (child != null) {
						child.dispose();
					}
				}
			}
			topComposite.dispose();
			topComposite = null;
		}
		if (getActionBars() != null) {
			IMenuManager menu = getActionBars().getMenuManager();
			menu.removeAll();
			IToolBarManager toolBar = getActionBars().getToolBarManager();
			toolBar.removeAll();
			getActionBars().updateActionBars();
		}
	}

	private void disposeImage() {
		imageSize = new Point(0, 0);
		scaleFactor = 0;
		frame = 0;
		if (firstBuffer != null) {
			firstBuffer.dispose();
			firstBuffer = null;
		}
		// Stop loop
		if (loopAction.isChecked() == true) {
			loopAction.setChecked(false);
		}
	}

	@Override
	public void setActionBars(IActionBars actionBars) {
		unregisterActions(getActionBars());
		super.setActionBars(actionBars);
		registerActions(getActionBars());
	}

	protected void registerActions(IActionBars actionBars) {
		if (actionBars != null) {
			IMenuManager menu = actionBars.getMenuManager();
			menu.add(zoomSeparator);
			menu.add(new ZoomInAction());
			menu.add(new ZoomOutAction());
			menu.add(new Zoom11Action());

			IToolBarManager toolBar = actionBars.getToolBarManager();
			toolBar.add(zoomSeparator);
			toolBar.add(new ZoomInAction());
			toolBar.add(new ZoomOutAction());
			toolBar.add(new Zoom11Action());

			if (descriptor != null && descriptor.getFrameCount() > 1) {
				menu.add(playSeparator);
				menu.add(prevFrameAction);
				menu.add(nextFrameAction);
				menu.add(playAction);
				menu.add(loopAction);
				toolBar.add(playSeparator);
				toolBar.add(prevFrameAction);
				toolBar.add(nextFrameAction);
				toolBar.add(playAction);
				toolBar.add(loopAction);

				prevFrameAction.update();
				nextFrameAction.update();
				playAction.update();
			}

			actionBars.updateActionBars();
		}
	}

	protected void unregisterActions(IActionBars actionBars) {
		if (actionBars != null) {
			IMenuManager menu = actionBars.getMenuManager();
			menu.removeAll();
			IToolBarManager toolBar = actionBars.getToolBarManager();
			toolBar.removeAll();
			actionBars.updateActionBars();
		}
	}

	protected void zoomIn() {
		scaleFactor = Math.min(3, scaleFactor + 1);
		updateCanvasBounds();
	}

	protected void zoomOut() {
		scaleFactor = Math.max(-3, scaleFactor - 1);
		updateCanvasBounds();
	}

	protected void zoom11() {
		scaleFactor = 0;
		updateCanvasBounds();
	}

	protected void nextFrame() {
		// stopPlaying();
		if (frame < descriptor.getFrameCount()) {
			frame++;
			canvas.redraw();
		}
		updateActions();
	}

	protected void prevFrame() {
		// stopPlaying();
		if (frame > 0) {
			frame--;
			canvas.redraw();
		}
		updateActions();
	}

	/**
	 * Delay in
	 * 
	 * @return delay in miliseconds
	 */
	long getDelay() {
		ImageData frameData = descriptor.getFrame(frame);
		long delay = (long) frameData.delayTime;
		if (delay == 0) {
			delay = 20; // 0.2 ms
			return delay;
		} else {
			return delay * 10;
		}
	}

	class PlayTask extends TimerTask {
		@Override
		public void run() {
			if (frame < descriptor.getFrameCount() - 1) {
				frame++;
				playTask = new PlayTask();
				timer.schedule(playTask, getDelay());
			} else if (loopAction.isChecked()) {
				frame = 0;
				playTask = new PlayTask();
				timer.schedule(playTask, getDelay());
			} else {
				// done
				frame = 0;
				stopPlaying();
			}
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					if (canvas != null) {
						canvas.redraw();
						canvas.update();
					}
				}
			});
		}

		public void go() {
			if (frame < descriptor.getFrameCount() - 1
					|| loopAction.isChecked()) {
				playTask = new PlayTask();
				timer.schedule(playTask, getDelay());
			} else if (loopAction.isChecked()) {
				
			} else {
				frame = 0;
				stopPlaying();
			}
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					canvas.redraw();
					canvas.update();
				}
			});
		}

	};

	protected void updateActions() {
		prevFrameAction.update();
		nextFrameAction.update();
		playAction.update();
	}

	synchronized void stopPlaying() {
		if (playTask != null && loopAction.isChecked() == false) {
			playTask.cancel();
			playTask = null;
			cleanupAudioResources();
		}
		updateActions();
	}

	private void createTempAudioFile() throws Exception {
		if (audio.getAudioContent() != null) {
			String ext = FileUtils.getExtension(audio.getAudioContent()
					.getName());

			String tempExt;
			if (ext == null) {
				tempExt = ".mp3";
			} else {
				tempExt = "." + ext;
			}
			tempAudioFile = File.createTempFile("temp", tempExt);
			IStorage input = audio.getAudioContent();

			IWorkspaceRunnable copyOperation = new IWorkspaceRunnable() {
				public void run(IProgressMonitor monitor) throws CoreException {
					monitor.beginTask("Copy content", 1);
					InputStream content = audio.getAudioContent().getContents();
					try {
						FileOutputStream out = new FileOutputStream(
								tempAudioFile);
						if (content != null) {
							FileUtils.copyStream(content, out);
							FileUtils.closeStream(out);
							tempAudioFile.deleteOnExit();
						}
					} catch (IOException ex) {
						cleanupAudioResources();
						throw ExceptionUtils.wrapCoreException(ex,
								MediaUIPlugin.PLUGIN_ID, "Internal Error");
					} finally {
						FileUtils.closeStream(content);
					}

					monitor.done();
				}
			};
			ISchedulingRule rule = PlatformUtil.getAdapter(input,
					ISchedulingRule.class, true);
			ResourcesPlugin.getWorkspace().run(copyOperation, rule,
					IWorkspace.AVOID_UPDATE, new NullProgressMonitor());
		}
	}

	protected synchronized void cleanupAudioResources() {
		if (player != null) {
			player.stop();
			player.deallocate();
			player = null;
		}
		if (tempAudioFile != null) {
			tempAudioFile.delete();
			tempAudioFile = null;
		}
	}

	synchronized void togglePlay() {
		if (playTask != null) {
			loopAction.setChecked(false);
			stopPlaying();
		} else {
			playTask = new PlayTask();
			updateActions();

			if (this.audio != null && this.audio.getAudioContent() != null) {
				// if we have audio channel we synchronize frame playback start
				// with audio player.
				try {
					createTempAudioFile();
					player = Manager.createPlayer(tempAudioFile.toURL());

					long startTime = 0;
					for (int i = 0; i < frame; i++) {
						int delay = descriptor.getFrame(i).delayTime;
						startTime += delay == 0 ? 100 : delay;
					}
					final Time mediaTime = new Time(startTime * 1000000);

					player.addControllerListener(new ControllerListener() {
						boolean isPlaying = false;
						
						public void controllerUpdate(ControllerEvent event) {
							if (event instanceof RealizeCompleteEvent) {
								if (isPlaying == false) {
									player.setMediaTime(mediaTime);
								}
							} else if (event instanceof StartEvent) {
								if (isPlaying == false) {
									playTask.go();
								}
							} else if (event instanceof StopEvent) {
								if (loopAction.isChecked()) {
									isPlaying = true;
									player.setMediaTime(new Time(0));
									player.start();									
								} else {
									isPlaying = false;
									cleanupAudioResources();
								}
							}
						}
					});
					player.realize();
					player.start();

				} catch (Exception ex) {
					ex.printStackTrace();
					cleanupAudioResources();
					// continue without audio
					playTask.go();
				}
			} else {
				playTask.go();
			}
		}
	}

	class ZoomInAction extends Action implements ResolutionChangeListener {
		static final String ID = "ImagePreview.ZoomIn";

		public ZoomInAction() {
			super("Zoom In", PluginImages.ZOOM_IN);
			setId(ID);
			resolutionChangeListeners.add(this);
		}

		@Override
		public void run() {
			zoomIn();
		}

		public void currentResolutionChanged(int newWidth, int newHeight) {
			if (newWidth > MAX_IMAGE_WIDTH) {
				setEnabled(false);
			} else if (newHeight > MAX_IMAGE_HEIGHT) {
				setEnabled(false);
			} else {
				setEnabled(true);
			}
		}
	}

	class ZoomOutAction extends Action {
		static final String ID = "ImagePreview.ZoomOut";

		public ZoomOutAction() {
			super("Zoom Out", PluginImages.ZOOM_OUT);
			setId(ID);
		}

		@Override
		public void run() {
			zoomOut();
		}

	}

	class Zoom11Action extends Action {
		static final String ID = "ImagePreview.Zoom11";

		public Zoom11Action() {
			super("Zoom To Original", PluginImages.ZOOM_ORIGINAL);
			setId(ID);
		}

		@Override
		public void run() {
			zoom11();
		}

	}

	class FrameNextAction extends Action {
		static final String ID = "ImagePreview.NextFrame";

		public FrameNextAction() {
			super("Next Frame", PluginImages.FORWARD);
			setId(ID);
		}

		@Override
		public void run() {
			nextFrame();
		}

		public void update() {
			boolean enabled = playTask == null && descriptor != null
					&& frame < descriptor.getFrameCount() - 1;
			setEnabled(enabled);
		}
	}

	class FramePrevAction extends Action {
		static final String ID = "ImagePreview.NextFrame";

		public FramePrevAction() {
			super("Previous Frame", PluginImages.REWIND);
			setId(ID);
		}

		@Override
		public void run() {
			prevFrame();
		}

		public void update() {
			boolean enabled = playTask == null && descriptor != null
					&& frame > 0;
			setEnabled(enabled);
		}
	}

	class PlayAction extends Action {
		static final String ID = "ImagePreview.Play";

		public PlayAction() {
			super("Start Animation", PluginImages.PLAY);
			setId(ID);
		}

		@Override
		public void run() {
			togglePlay();
		}

		void update() {
			boolean enabled = descriptor != null
					&& descriptor.getFrameCount() > 0;
			setEnabled(enabled);
			if (playTask != null) {
				setText("Stop Animation");
				setImageDescriptor(PluginImages.STOP);
			} else {
				setText("Start Animation");
				setImageDescriptor(PluginImages.PLAY);
			}
		}
	}

	class LoopAction extends Action {
		static final String ID = "ImagePreview.Loop";

		public LoopAction() {
			super("Loop", Action.AS_CHECK_BOX);
			setImageDescriptor(PluginImages.LOOP);
			setId(ID);
		}

		@Override
		public void run() {
			playAction.run();
		}
	}

}

interface ResolutionChangeListener {
	public void currentResolutionChanged(int newWidth, int newHeight);
}
