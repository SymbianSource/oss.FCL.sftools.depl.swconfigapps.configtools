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
package com.nokia.tools.carbide.ct.ui.refactoring.internal;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.CompositeChange;
import org.eclipse.ltk.core.refactoring.RefactoringChangeDescriptor;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.TextFileChange;
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;
import org.eclipse.ltk.core.refactoring.participants.IConditionChecker;
import org.eclipse.ltk.core.refactoring.participants.RefactoringParticipant;
import org.eclipse.ltk.core.refactoring.participants.RenameProcessor;
import org.eclipse.ltk.core.refactoring.participants.SharableParticipants;
import org.eclipse.ltk.core.refactoring.participants.ValidateEditChecker;
import org.eclipse.ltk.core.refactoring.resource.RenameResourceChange;
import org.eclipse.ltk.core.refactoring.resource.RenameResourceDescriptor;
import org.eclipse.text.edits.MultiTextEdit;
import org.eclipse.text.edits.ReplaceEdit;

import com.nokia.tools.carbide.ct.ui.refactoring.CarbideRefactoringUIPlugin;
import com.nokia.tools.carbide.ct.ui.refactoring.internal.wizards.RenameConfmlInputPage;


public class RenameConfmlProcessor extends RenameProcessor {
	private IResource resourceToRename;
	private final Map<IFile,List<Integer> > confmlFilesToUpdate;
	private final Map<IFile,String> fileStringReplacements;
	private String includeString = null;
	private RenameConfmlInputPage inputPage;
	private boolean handleIncludesOnly = true;
	private String PROCESSOR_NAME = "ConfML Resource Rename";
	
	/**
	 * @param resource Configuration Project resource to be renamed
	 */
	public RenameConfmlProcessor(IResource resource) {
		resourceToRename = resource;
		confmlFilesToUpdate = new HashMap<IFile,List<Integer>>();
		fileStringReplacements = new HashMap<IFile, String>();
	}

	@Override
	public RefactoringStatus checkInitialConditions(IProgressMonitor pm)
	throws CoreException, OperationCanceledException {
		// initial condition is that a ConfML file is selected. 
		// which holds because this method should be called unless ConfML file is
		// selected
		RefactoringStatus result = new RefactoringStatus();
		return result;
	}

	@Override
	public RefactoringStatus checkFinalConditions(IProgressMonitor pm,
			CheckConditionsContext ctxt) throws CoreException,
			OperationCanceledException {
		RefactoringStatus result = new RefactoringStatus();

		IContainer parent = resourceToRename.getParent();
		if(!isRoot(parent)) {
			
			// parse all ConfML files in the grand parent folder to see
			// whether any of them contains inclusion
			pm.beginTask("Find inclusions", 100);
			pm.worked(10);
			//Search for other resource which need to be edited
			search(parent, result);
			pm.worked(80);

			if( ctxt != null ) {
				IFile[] files = new IFile[confmlFilesToUpdate.size()];
				confmlFilesToUpdate.keySet().toArray(files);
				IConditionChecker checker = ctxt.getChecker( ValidateEditChecker.class );
				ValidateEditChecker editChecker = ( ValidateEditChecker )checker;
				editChecker.addFiles(files);
			}
			pm.done();  	
		}
		return result;
	}

	private boolean isRoot(IContainer grandParent) {
		return (grandParent == grandParent.getWorkspace().getRoot());	
	}

	private void search(final IContainer resource,
			final RefactoringStatus status) {
		if(isRoot(resource)) {
			return;
		}
		URI parentUri = resource.getLocationURI();
		if(resourceToRename instanceof IFolder) {
			includeString = parentUri.relativize(resourceToRename.getLocationURI()).toString()+"/";			
		} else {
			includeString = parentUri.relativize(resourceToRename.getLocationURI()).toString();			
		}

		try {
			IResource[] members = resource.members();
			for(int i = 0; i < members.length; i++) {
				if(isToRefactor(members[i])) { 
					IFile file = (IFile)members[i];
					processConfmlFile(file,status);
				}
			}
			search(resource.getParent(), status);
		} catch( final CoreException cex ) {
			status.addFatalError( cex.getMessage() );
		}
	}

	private void processConfmlFile(IFile file, RefactoringStatus status) {
		String content = readFileContent(file, status);
		int index = content.indexOf(includeString);
		while (index !=-1) {
			if(handleIncludesOnly) {
				String newline = System.getProperty("line.separator");
				
				int firstIndex = content.lastIndexOf(newline, index);
				int lastIndex = content.indexOf(newline,index);
				if((lastIndex>firstIndex)&&(firstIndex!=-1)&&(lastIndex!=-1)) {
					String subString = content.substring(firstIndex, lastIndex);
					if(subString.indexOf("include")==-1) {
						index = content.indexOf(includeString, index+includeString.length());
						continue;
					}
				}
			}
			Integer offset = new Integer(index);
			List<Integer> updates = confmlFilesToUpdate.get(file);
			if(updates==null) {
				updates = new ArrayList<Integer>();
			}
			updates.add(offset);
			
			
			
			confmlFilesToUpdate.put(file, updates);
			fileStringReplacements.put(file, new String(includeString));
			index = content.indexOf(includeString, index+includeString.length());
		}
	}

	private boolean isToRefactor(final IResource file) {
		return    "confml".equals(file.getFileExtension())
		&& !file.equals(resourceToRename);
	}

	private String readFileContent(final IFile file,
			final RefactoringStatus refStatus) {
		String result = null;
		try {
			InputStream is = file.getContents();
			String charset = file.getCharset();
			
			byte[] buf = new byte[1024];
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			int len = is.read(buf);
			while( len > 0 ) {
				bos.write( buf, 0, len );
				len = is.read( buf );
			}
			is.close();
			result = new String(bos.toByteArray(),charset);
		} catch(Exception ex) {
			String msg = ex.toString();
			refStatus.addFatalError( msg );
			String pluginId = CarbideRefactoringUIPlugin.PLUGIN_ID;
			IStatus status = new Status( IStatus.ERROR, pluginId, 0, msg, ex );
			CarbideRefactoringUIPlugin.getDefault().getLog().log( status );
		}
		return result;
	}

	@Override
	public Change createChange(IProgressMonitor pm) throws CoreException,
	OperationCanceledException {
		CompositeChange rootChange = new CompositeChange( getProcessorName() ); 
		createChange(pm, rootChange);
		return rootChange;
	}

	private void createChange(IProgressMonitor pm, CompositeChange rootChange) {
		try {
			pm.beginTask("Collecting changes", 100 );
			// create rename change for the ConfML file which is selected by the user
			rootChange.add( createRenameChange() );
			pm.worked( 10 );
			// create changes for all other including ConfML files
			rootChange.addAll(createChangesForIncludingFiles());
			pm.worked(90);
		} finally {
			pm.done();
		}
	}

	private Change[] createChangesForIncludingFiles() {
		List<Change> result = new ArrayList<Change>();
		Iterator<IFile> it = confmlFilesToUpdate.keySet().iterator();
		while( it.hasNext() ) {
			IFile file = it.next();

			TextFileChange tfc = new TextFileChange(file.getName(), file);
			MultiTextEdit fileChangeRootEdit = new MultiTextEdit();
			tfc.setEdit(fileChangeRootEdit);    

			
			List<Integer> updates = confmlFilesToUpdate.get(file);
			for (Integer update : updates) {
				String include = fileStringReplacements.get(file);
				
				ReplaceEdit edit = new ReplaceEdit(update, 
						include.length(), 
						include.replace(resourceToRename.getName(), inputPage.getNewName()) );
				fileChangeRootEdit.addChild( edit );				
			}
			
			

			result.add(tfc);
		}
		return ( Change[] )result.toArray( new Change[ result.size() ] );
	}

	
	private Change createRenameChange() {
		RenameResourceChange rename = new RenameResourceChange(resourceToRename.getFullPath(), inputPage.getNewName() );
		RenameResourceDescriptor renResDes = new RenameResourceDescriptor();
		rename.setDescriptor(new RefactoringChangeDescriptor(renResDes));
		return rename;
	}
	  
	@Override
	public Object[] getElements() {
		Object[] elements = new Object[confmlFilesToUpdate.size()+1];
		confmlFilesToUpdate.keySet().toArray(elements);
		elements[elements.length-1] = resourceToRename;
		return elements;

	}

	@Override
	public String getIdentifier() {
	    return getClass().getName();
	}

	@Override
	public String getProcessorName() {
		return PROCESSOR_NAME;
	}

	@Override
	public boolean isApplicable() throws CoreException {
		return true;
	}

	@Override
	public RefactoringParticipant[] loadParticipants(RefactoringStatus status,
			SharableParticipants sharedParticipants) throws CoreException {
		return new RefactoringParticipant[0];
	}

	public void setNameInputPage(RenameConfmlInputPage inputPage) {
		this.inputPage = inputPage;
	}

	public IResource getResourceToRename() {
		return resourceToRename;
	}
}
