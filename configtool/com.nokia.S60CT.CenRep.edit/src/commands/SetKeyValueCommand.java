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
package commands;

import java.util.Collection;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.command.AbstractOverrideableCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import cenrep.Key;

public class SetKeyValueCommand extends  AbstractOverrideableCommand {
	
	Key keyObj = null;
	String value = null;
	
	public static Command create(EditingDomain domain, Key keyObj,String value){
		return new SetKeyValueCommand(domain,keyObj,value); 
	}
	
	public SetKeyValueCommand(EditingDomain domain,Key keyObj, String value){
		super(domain);
		this.keyObj = keyObj;
		this.value = value;
	}
	public void doExecute() {
		
	}
	public boolean doCanExecute() {
		/*
		 * check that the setting is valid
		 */
		
		return true;
	}
	public boolean doCanUndo() {
		
		return super.doCanUndo();
	}
	public void doDispose() {
		
		super.doDispose();
	}
	public Collection doGetAffectedObjects() {
		
		return super.doGetAffectedObjects();
	}
	public Collection doGetChildrenToCopy() {
		
		return super.doGetChildrenToCopy();
	}
	public String doGetDescription() {
		
		return super.doGetDescription();
	}
	public String doGetLabel() {
		
		return super.doGetLabel();
	}
	public Collection doGetResult() {
		
		return super.doGetResult();
	}
	public EditingDomain getDomain() {
		
		return super.getDomain();
	}
	public Command getOverride() {
		
		return super.getOverride();
	}
	public void setOverride(Command overrideCommand) {
		
		super.setOverride(overrideCommand);
	}
	public String toString() {
		
		return super.toString();
	}
	

	public void doRedo() {
		
		
	}

	public void doUndo() {
		
		
	}
	
	 

	
}
