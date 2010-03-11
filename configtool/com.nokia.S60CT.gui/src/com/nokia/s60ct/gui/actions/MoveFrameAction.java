/*
* Copyright (c) 2009 Nokia Corporation and/or its subsidiary(-ies). 
* All rights reserved.
* This component and the accompanying materials are made available
* under the terms of "Eclipse Public License v1.0"
* which accompanies this distribution, and is available
* at the URL "http://www.eclipse.org/legal/epl-v10.html".
*
* Initial Contributors:
* Nokia Corporation - initial contribution.
*
* Contributors:
*
* Description:
*
*/
package com.nokia.s60ct.gui.actions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import s60ct.provider.SequenceMenuItemProvider;

import command.RemoveFrameCommand;

import configurationemf.ConfigurationemfFactory;
import configurationemf.ConfigurationemfPackage;
import configurationemf.Frame;
import configurationemf.ParentSetting;

public abstract class MoveFrameAction implements IObjectActionDelegate, SelectionListener
{
	List<EObject> selectedObjects = new ArrayList<EObject>();
	
	SequenceMenuItemProvider itemProvider = new SequenceMenuItemProvider(null);
	
	Frame frame = null;
	
	public MoveFrameAction() 
	{

	}

	public void setActivePart(IAction action, IWorkbenchPart targetPart) 
	{
	}

	public void setFrame(Frame frame)
	{
		this.frame = frame;
	}
	
	public void move(boolean up)
	{
	
		ParentSetting parentSetting = (ParentSetting) frame.eContainer();
		EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(parentSetting);
		List myFrames = parentSetting.getMyCurrentFrames();
		int replaceFrameNumber = frame.getNumber()-1;
		int moveFrameNumber = 0;
		
		if (!up) moveFrameNumber = frame.getNumber();
		else moveFrameNumber = frame.getNumber()-2;
		
		Frame toBeMoved = (Frame)myFrames.get(moveFrameNumber);
		Frame toBeReplaced = (Frame)myFrames.get(replaceFrameNumber);

		myFrames.set(replaceFrameNumber, toBeMoved);
		myFrames.set(moveFrameNumber, toBeReplaced);

		List newList = new ArrayList<Frame>();
		for (int i = 0 ; i < myFrames.size() ; i++)
		{
			Frame oldFrame = (Frame)myFrames.get(i);
			Frame newFrame = ConfigurationemfFactory.eINSTANCE.createFrame();
			
			newFrame.setRef(oldFrame.getRef());
			newFrame.getLeafSettings().addAll(oldFrame.getLeafSettings());
			
			newList.add(newFrame);
		}
	
		removeOwn(parentSetting);
		
		for (int i = 0 ; i < newList.size() ; i++)
		{
			parentSetting.addFrame((Frame)newList.get(i));
		}
	}

	private void removeOwn(ParentSetting parentSetting)
	{
		EditingDomain domain =  AdapterFactoryEditingDomain.getEditingDomainFor(parentSetting);
		Command command = itemProvider.createCommand(parentSetting, domain, RemoveFrameCommand.class,
				new CommandParameter(parentSetting,ConfigurationemfPackage.eINSTANCE.getParentSetting_Frames(),null));
		domain.getCommandStack().execute(command);
		frame=null;
	}
	
	public void setDirtyState()
	{}
	
	public void run(IAction action) 
	{
		if ( action.getId().equals("com.nokia.S60CT.gui.movedown")) move(false);
		else  move(true);
	}

	public void selectionChanged(IAction action, ISelection selection){}
	
	public void widgetDefaultSelected(SelectionEvent e){}

	public void widgetSelected(SelectionEvent e){}
	
}
