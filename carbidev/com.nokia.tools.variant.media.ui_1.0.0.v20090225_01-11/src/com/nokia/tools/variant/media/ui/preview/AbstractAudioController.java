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

import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IActionBars;

import com.nokia.tools.variant.preview.PluginImages;
import com.nokia.tools.variant.preview.PreviewController;


public abstract class AbstractAudioController extends PreviewController {

	protected IAudioPreviewDescriptor descriptor;

	protected Job playTask;
	protected final PlayAction playAction = new PlayAction();
	protected final Separator playSeparator = new Separator("GROUP.PLAY");

	public AbstractAudioController() {
		super();
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

	@Override
	public void dispose() {
		stopPlayback();
		setActionBars(null);
		descriptor = null;
	}
	
	protected void updateActions() {
		playAction.update();
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				if (getActionBars() != null) {
				getActionBars().updateActionBars();
//				getActionBars().getMenuManager().update();
//				getActionBars().getToolBarManager().update(true);
				}
			}
		});
	}

	protected synchronized void stopPlayback() {
		if (playTask != null) {
			Job current = playTask;
			playTask = null;
			current.cancel();
			updateActions();
		}
	}

	protected synchronized void startStopAction() {
		if (playTask != null) {
			stopPlayback();
		} else {
			playTask = createNewPlayTask();
			playTask.setPriority(Job.INTERACTIVE);
			playTask.schedule();
			updateActions();
		}
	}
	
	protected synchronized void playTaskCompleted(Job playTask) {
		if (this.playTask == playTask) {
			this.playTask = null;
			updateActions();
		}
	}
	
	protected boolean isPlaying() {
		return playTask != null;
	}
	
	protected abstract Job createNewPlayTask();

	class PlayAction extends Action {
		static final String ID = "AudioPreview.Play";

		public PlayAction() {
			super("Start Playing", PluginImages.PLAY);
			setId(ID);
		}

		@Override
		public void run() {
			startStopAction();
		}

		void update() {
			if (isPlaying()) {
				setText("Stop Playing");
				setImageDescriptor(PluginImages.STOP);
			} else {
				setText("Start Playing");
				setImageDescriptor(PluginImages.PLAY);
			}
		}
	}
}
