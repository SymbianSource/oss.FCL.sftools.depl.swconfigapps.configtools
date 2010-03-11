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
import java.util.concurrent.Semaphore;

import javax.media.Controller;
import javax.media.ControllerClosedEvent;
import javax.media.ControllerEvent;
import javax.media.ControllerListener;
import javax.media.EndOfMediaEvent;
import javax.media.Manager;
import javax.media.Player;
import javax.media.PrefetchCompleteEvent;
import javax.media.Processor;
import javax.media.StopEvent;
import javax.media.Time;

import org.eclipse.core.resources.IStorage;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.IActionBars;

import com.nokia.tools.variant.common.core.utils.ExceptionUtils;
import com.nokia.tools.variant.common.core.utils.FileUtils;
import com.nokia.tools.variant.common.core.utils.PlatformUtil;
import com.nokia.tools.variant.media.ui.MediaUIPlugin;
import com.nokia.tools.variant.preview.ContentPreviewPlugin;
import com.nokia.tools.variant.preview.IPreviewDescriptor;
import com.nokia.tools.variant.preview.PluginImages;
import com.nokia.tools.variant.preview.PreviewController;


public class JMFAudioController extends PreviewController {


	private IAudioPreviewDescriptor descriptor;
	//private File xtempFile;
	private Player player;

	protected final PlayAction playAction = new PlayAction();
	protected final Separator playSeparator = new Separator("GROUP.PLAY");

	private ScrolledComposite topComposite;
	private Label visualComposite;

	public JMFAudioController() {
	}

	@Override
	public void createControl(Composite parent) {
		topComposite = new ScrolledComposite(parent, SWT.H_SCROLL
				| SWT.V_SCROLL);
		topComposite.setBackground(ColorConstants.white);
		final Composite scrollableBody = new Composite(topComposite, SWT.NONE);
		topComposite.setContent(scrollableBody);
		scrollableBody.setBackground(topComposite.getBackground());
		topComposite.addListener(SWT.Resize, new Listener() {
			public void handleEvent(Event event) {
				Point pref = scrollableBody.computeSize(SWT.DEFAULT,
						SWT.DEFAULT);
				Rectangle ca = topComposite.getClientArea();
				pref.x = Math.max(pref.x, ca.width);
				pref.y = Math.max(pref.y, ca.height);
				scrollableBody.setSize(pref);
			}
		});
		scrollableBody.addListener(SWT.Resize, new Listener() {
			public void handleEvent(Event event) {
				topComposite.setMinSize(scrollableBody.getSize());
			}
		});
		scrollableBody.setLayout(new GridLayout());
		visualComposite = new Label(scrollableBody, SWT.HORIZONTAL | SWT.VERTICAL);
		
		visualComposite.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				true, true));
		visualComposite.setBackground(scrollableBody.getBackground());
		visualComposite.setText("Press Play for Audio Preview");
		updateActions();
	}

	@Override
	public synchronized void dispose() {
		if (player != null) {
			player.stop();
			player.deallocate();
			player = null;
		}
//		if (tempFile != null) {
//			tempFile.delete();
//			tempFile = null;
//		}
		if (topComposite != null) {
			topComposite.dispose();
			topComposite = null;
		}
		unregisterActions(getActionBars());
	}

	@Override
	public Control getControl() {
		return topComposite;
	}

	@Override
	public void setInput(final IPreviewDescriptor descriptor) {
		if (this.descriptor == descriptor) {
			return;
		} else if (this.descriptor != null && this.descriptor.equals(descriptor)) {
			return;
		}
		
		synchronized (this) {
			if (player != null) {
				final Player oldPlayer = player;
				//final File oldFile = tempFile;
				//tempFile = null;
				player = null;
				Job cleanup = new Job("Cleanup") {
					@Override
					protected IStatus run(IProgressMonitor monitor) {
						oldPlayer.stop();
						oldPlayer.deallocate();
						//oldFile.delete();
						monitor.done();
						return Status.OK_STATUS;
					}
				};
				cleanup.setPriority(Job.SHORT);
				cleanup.schedule();
			}
		}
		updateActions();

		this.descriptor = (IAudioPreviewDescriptor) descriptor;

		//final Display display = topComposite.getDisplay();
		topComposite.layout(true, true);

		startNewJob();
	}
	
	private void startNewJob() {
		final Display display = topComposite.getDisplay();
		
		Job startNew = new Job("Loading media player") {
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				File temp = null;
				Player newPlayer = null;
				try {
					temp = createTempFile();
					if (temp.length() == 0) {
						display.asyncExec(new Runnable() {
							public void run() {
								visualComposite.setText("Cannot create media preview");
							}
						});						
						return Status.CANCEL_STATUS;
					}
					newPlayer = Manager.createPlayer(temp.toURL());
					final Semaphore lock = new Semaphore(0);
					newPlayer.addControllerListener(new ControllerListener() {
						public void controllerUpdate(ControllerEvent event) {
							if (event instanceof StopEvent) {
								lock.release();
								handlePlayerStopEvent(display);
							} else if (event instanceof PrefetchCompleteEvent) {
								lock.release();
							} else if (event instanceof ControllerClosedEvent) {
								lock.release();
							}
							handleControllerStateUpdate(display, event);
						}
					});
					newPlayer.prefetch();
					lock.acquire();
					if (newPlayer.getState() != Controller.Prefetched) {
						throw new Exception("Player creation failed");
					}

					final File file0 = temp;
					final Player player0 = newPlayer;
					display.asyncExec(new Runnable() {
						public void run() {
							handlePlayerReady(descriptor, file0, player0);
						}

					});

					return Status.OK_STATUS;
				} catch (Exception ex) {
					if (temp != null) {
						temp.delete();
					}
					if (newPlayer != null) {
						newPlayer.deallocate();
					}
					display.asyncExec(new Runnable() {
						public void run() {
							handlePlayerError(descriptor, "Failed to create media preview");
						}

					});
					return new Status(IStatus.WARNING,
							ContentPreviewPlugin.PLUGIN_ID,
							"Failed to construct media player", ex);
				} finally {
					monitor.done();
				}
			}
		};
		startNew.setPriority(Job.SHORT);
		startNew.schedule();
		
	}

	private synchronized void handlePlayerReady(IPreviewDescriptor descriptor,
			File file0, Player player0) {
		if (this.descriptor != descriptor) {
			return;
		}
	//	this.tempFile = file0;
		this.player = player0;
		if(topComposite != null)
			topComposite.layout(true, true);
		updateActions();
	}

	private synchronized void handlePlayerError(IPreviewDescriptor descriptor, String message)
			 {
		if (this.descriptor != descriptor) {
			return;
		}
	//	this.tempFile = null;
		this.player = null;
		topComposite.layout(true, true);
		updateActions();
	}

	void handleControllerStateUpdate(Display display,
			final ControllerEvent event) {
		if (event instanceof EndOfMediaEvent) {
			event.getSourceController().setMediaTime(new Time(0));
		}
		display.asyncExec(new Runnable() {
			public void run() {
				synchronized (JMFAudioController.this) {
					if (event.getSourceController() == player) {
						updateActions();
					}
				}
			}
		});
	}

	File createTempFile() throws Exception {
		String ext = FileUtils.getExtension(descriptor.getAudioContent().getName());
		
		String tempExt;
		if (ext == null) {
			tempExt = ".mp3";
		} else {
			tempExt = "."+ext;
		}
		final File temp = File.createTempFile("temp", tempExt);
		IStorage input = descriptor.getAudioContent();
		
		IWorkspaceRunnable copyOperation = new IWorkspaceRunnable() {
			public void run(IProgressMonitor monitor) throws CoreException {
				monitor.beginTask("Copy content", 1);
				InputStream content = descriptor.getAudioContent().getContents();
				try {
					FileOutputStream out = new FileOutputStream(temp);
					if (content != null) {
						FileUtils.copyStream(content, out);
						FileUtils.closeStream(out);
						temp.deleteOnExit();
					}
				} catch (IOException ex) {
					temp.delete();
					throw ExceptionUtils.wrapCoreException(ex, MediaUIPlugin.PLUGIN_ID, "Internal Error");
				} finally {
					FileUtils.closeStream(content);
				}

				monitor.done();
			}
		};
		ISchedulingRule rule = PlatformUtil.getAdapter(input, ISchedulingRule.class, true);
		ResourcesPlugin.getWorkspace().run(copyOperation, rule, IWorkspace.AVOID_UPDATE, new NullProgressMonitor());
		
		return temp;
	}

	protected synchronized boolean isPlaying() {
		if (player == null) {
			return false;
		}
		switch (player.getState()) {
		case Processor.Started:
			return true;
		default:
			return false;
		}
	}

	protected synchronized boolean isStopped() {
		if (player == null) {
			return false;
		}
		switch (player.getState()) {
		case Processor.Prefetched:
			return true;
		default:
			return false;
		}
	}

	protected synchronized void startStopAction() throws Exception {
		if (isPlaying()) {
			player.stop();			
			player.setMediaTime(new Time(0));
			updateActions();
		} else if (isStopped()) {
			updateActions();
			
			if(player.getState() != player.Started){	
				player.syncStart(new Time(100));
					Thread.sleep(1);
				player.stop();
				Thread.sleep(1);
				player.syncStart(new Time(100));
			}
			
		}
	}

	private void handlePlayerStopEvent(Display display) {
		display.asyncExec(new Runnable() {
			public void run() {
				updateActions();
			}
		});
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
			menu.add(playSeparator);
			menu.add(playAction);
			IToolBarManager toolBar = actionBars.getToolBarManager();
			toolBar.add(playSeparator);
			toolBar.add(playAction);
			actionBars.updateActionBars();
		}
	}

	protected void unregisterActions(IActionBars actionBars) {
		if (actionBars != null) {
			IMenuManager menu = actionBars.getMenuManager();
			menu.remove(PlayAction.ID);
			menu.remove(playSeparator.getId());
			IToolBarManager toolBar = actionBars.getToolBarManager();
			toolBar.remove(PlayAction.ID);
			toolBar.remove(playSeparator.getId());
			actionBars.updateActionBars();
		}
	}

	protected synchronized void updateActions() {
		playAction.update();
		if (getActionBars() != null) {
			getActionBars().updateActionBars();
		}
	}

	public static boolean suppports(byte[] content) {
		return true;
	}

	class PlayAction extends Action {
		static final String ID = "AudioPreview.Play";

		public PlayAction() {
			super("Start Playing", PluginImages.PLAY);
			setId(ID);
		}

		@Override
		public void run() {
			try {
				startStopAction();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}

		void update() {
			boolean enabled = isPlaying() || isStopped();
			setEnabled(enabled);

			if (isPlaying()) {
				setText("Stop Playing");
				setImageDescriptor(PluginImages.STOP);
			} else if (isStopped()) {
				setText("Start Playing");
				setImageDescriptor(PluginImages.PLAY);
			}
		}
	}
}
