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
 * Description: This file is part of com.nokia.tools.vct.confml.editor.include component.
 */

package com.nokia.tools.vct.confml.editor.include.xincmodel.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.DragAndDropFeedback;
import org.eclipse.emf.edit.domain.EditingDomain;

import com.nokia.tools.vct.confml.editor.include.xincmodel.EDocument;
import com.nokia.tools.vct.confml.editor.include.xincmodel.EInclude;
import com.nokia.tools.vct.confml.editor.include.xincmodel.EProjectFile;
import com.nokia.tools.vct.confml.editor.include.xincmodel.EXincModelFactory;
import com.nokia.tools.vct.confml.editor.include.xincmodel.EXincModelPackage;
import com.nokia.tools.vct.confml.editor.include.xincmodel.command.LinkTargetFileCommand;

public class FileDragAndDropCommand extends AbstractCommand implements DragAndDropFeedback {

	Object owner;
	float location;
	EditingDomain domain;
	Collection<?> collection;
	Command dropCommand;
	
	public FileDragAndDropCommand(EditingDomain domain, Object owner,
			float location, int operations, int operation,
			Collection<?> collection) {
		super("Include ConfML", "Include reference to ConfML file");
		this.owner = owner;
		this.location = location;
		this.domain = domain;
		this.collection = collection;
	}

	public int getFeedback() {
		if (owner instanceof EDocument) {
			return FEEDBACK_SELECT;	
		} else if (owner instanceof EInclude) {
			if (location <= 0.5f) {
				return FEEDBACK_INSERT_BEFORE;
			} else {
				return FEEDBACK_INSERT_AFTER;
			}
		}
		return FEEDBACK_NONE;
	}

	public int getOperation() {
		return DROP_MOVE;
	}

	public boolean validate(Object owner, float location, int operations,
			int operation, Collection<?> collection) {
		if (owner instanceof EDocument || owner instanceof EInclude) {
			for (Object o : collection) {
				if (!(o instanceof EProjectFile) && !(o instanceof IFile)) {
					return false;
				}
			}
			return true;
		}
		
		return false;
	}

	@Override
	protected boolean prepare() {
		return true;
	}
	
	public void execute() {
		EDocument document;
		int index;
		if (owner instanceof EInclude) {
			EInclude include = (EInclude)owner;
			document = (EDocument)include.eContainer();
			index = document.getIncludes().indexOf(include);
			if (location > 0.5f) {
				index++;
			}
		} else {
			document = (EDocument)owner;
			index = document.getIncludes().size();
		}
		List<EInclude> includes = new ArrayList<EInclude>();
		
		URI uri = document.eResource().getURI();
		uri = URI.createURI("./").resolve(uri);
		IPath uri1 = new Path(uri.toPlatformString(true));
		
		List<String> uris = new ArrayList<String>();
		for (Object obj: collection) {
			EInclude include = EXincModelFactory.eINSTANCE.createEInclude();
			IPath uri2;
			if (obj instanceof EProjectFile) {
				EProjectFile file = (EProjectFile)obj;
				uri2 = new Path(file.getProjectPath());
			} else if (obj instanceof IFile){
				uri2 = ((IFile)obj).getFullPath();
			} else {
				continue;
			}
			String result =  relativize(uri1, uri2);
			include.setHref(result);
			uris.add(result.toString());
			includes.add(include);
		}
		
		CompoundCommand command = new CompoundCommand();
		command.append(AddCommand.create(domain, document, EXincModelPackage.Literals.EDOCUMENT__INCLUDES, includes, index));
		for (int i = 0; i < uris.size(); i++) {
			Command cmd = new LinkTargetFileCommand(domain, includes.get(i));
			command.append(cmd);
		}
		
		dropCommand = command.unwrap();
		dropCommand.execute();
	}

	private String relativize(IPath base, IPath ref) {
		String[] baseSegments = base.segments();
		String[] refSegments = ref.segments();
		
		int min = Math.min(baseSegments.length, refSegments.length);
		int ptr;
		for (ptr = 0; ptr < min; ptr++) {
			if (!baseSegments[ptr].equals(refSegments[ptr])) {
				break;
			}
		}
		StringBuilder tmp = new StringBuilder();
		
		for (int i = ptr;i < baseSegments.length; i++) {
			tmp.append("../");
		}
		for (int i = ptr;i < refSegments.length; i++) {
			tmp.append(refSegments[i]).append("/");
		}
		
		return tmp.substring(0, tmp.length() - 1);
	}
	
	public void redo() {
		dropCommand.redo();
	}
	
	@Override
	public void undo() {
		dropCommand.undo();
	}

	@Override
	public Collection<?> getResult() {
	    return 
	      dropCommand != null ?
	        dropCommand.getResult() :
	        super.getResult();
	}
	
	@Override
	public Collection<?> getAffectedObjects() {
	    return 
	      dropCommand != null ?
	        dropCommand.getAffectedObjects() :
	        super.getAffectedObjects();
	}
	
	  @Override
	  public void dispose()
	  {
	    if (dropCommand != null)
	    {
	      dropCommand.dispose();
	    }
	  }

}
