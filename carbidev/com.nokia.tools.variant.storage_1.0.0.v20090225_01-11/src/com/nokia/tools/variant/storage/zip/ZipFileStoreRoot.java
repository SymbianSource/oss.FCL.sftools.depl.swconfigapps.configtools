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
 * Description: This file is part of com.nokia.tools.variant.storage component.
 */

package com.nokia.tools.variant.storage.zip;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Enumeration;
import java.util.StringTokenizer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileInfo;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.filesystem.provider.FileInfo;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;

/**
 * Zip File Store root that will handle ZIP file operations.
 * 
 * Handle zip open/close life cycle better. 
 * Now it is open until all references to this file store
 * are lost.
 * 
 */
public class ZipFileStoreRoot extends ZipFileStore {
	// Lazy evaluation flag for checking if this component
	// has been already initialized or not.
	private boolean initializing;
	private ZipFile zip;
	private IFileStore physicalStore;
		
	/**
	 * Initializes the IFileStore, but does not read any of the
	 * entries until the first call to children or
	 * resolveURI is made (e.g. lazy evaluation)
	 * 
	 * @param file the IFileStore for ZIP entries, must point to valid ZIP file
	 */
	public ZipFileStoreRoot(IFileStore file) {
		super(null, null, 
				createFileInfo(file.fetchInfo()));
		this.physicalStore = file;
		
		// Initialize the store
		init(new NullProgressMonitor());
	}
	
	/**
	 * Create file info based on assumption that we are dealing with a folder. 
	 * 
	 * @param entry the ZipEntry that this folder is associated with 
	 * @param folderName the folder name to create
	 * @return IFileInfo containing the info, corresponding the folder name
	 */
	private static IFileInfo createFolderInfo(ZipEntry entry, String folderName) {
		// Create the file info 
		// In case of directory, the name contains extraneous '/' that should be removed
		FileInfo i = new FileInfo(folderName);
		i.setDirectory(true);
		i.setLastModified(entry.getTime());
		i.setLength(entry.getSize());
		i.setExists(true);
		return i;
	}	
	
	/**
	 * Create file info based on ZipEntry information. 
	 * Assume ZipEntry always exists for Zip file.
	 * 
	 * @param entry The ZipEntry to create the information from
	 * @param name The name of the entry
	 * @return IFileInfo containing the info, corresponding the zip entry
	 */
	private static IFileInfo createFileInfo(ZipEntry entry, String name) {
		// Create the file info 
		// In case of directory, the name contains extraneous '/' that should be removed
		FileInfo i = new FileInfo(name);
		i.setDirectory(false);
		i.setLastModified(entry.getTime());
		i.setLength(entry.getSize());
		i.setExists(true);
		return i;
	}
	
	/*@Override
	protected IFileInfo getChildInfo(ZipFileStore child) {
		// Get info for the child. Note that it may be an 
		// indirect child.
		String zipPath = ZipFileSystem.toZipLocalPath(child.toURI());
		// If we are dealing with directory, the path should be appended
		// with path separator to get the correct entry
		if (child.isDirectory()) zipPath += ZipFileSystem.PATH_SEPARATOR;
		ZipEntry entry = zip.getEntry(zipPath);
				
		// Create the file info 
		FileInfo i = new FileInfo(child.getName());
		i.setDirectory(child.isDirectory());
		if (entry != null) {
			i.setLastModified(entry.getTime());
			i.setLength(entry.getSize());
		}
		i.setExists(i.isDirectory() || entry != null);
		
		return i;
	}*/

	/**
	 * Creates file info based on underlying IFileStore.
	 * Otherwise copies the attributes of underlying store, but 
	 * sets the directory flag to permit browsing zip contents.
	 * 
	 * @param parentInfo the IFileInfo to fetch the information from
	 * @return IFileInfo containing the same attributes with directory flag
	 */
	public static IFileInfo createFileInfo(IFileInfo parentInfo) {
		// Create the file info 
		FileInfo i = new FileInfo(parentInfo.getName());
		i.setDirectory(true);
		i.setLastModified(parentInfo.getLastModified());
		i.setLength(parentInfo.getLength());
		i.setExists(true);
		// Tell we're dealing with archives.
		i.setAttribute(EFS.ATTRIBUTE_ARCHIVE, true);
		return i;
	}

	/**
	 * Fetches the parent store. Delegates this call to underlying physical store
	 * 
	 * @return the underlying physical store this ZipFileStore was created with
	 * @see com.nokia.tools.variant.storage.zip.ZipFileStore#getParent()
	 */
	@Override
	public IFileStore getParent() {
		return physicalStore.getParent();
	}

	/**
	 * Fetches the parent store input stream. 
	 * Delegates this call to underlying physical store
	 * 
	 * @return InputStream to the underlying physical store
	 * @see com.nokia.tools.variant.storage.zip.ZipFileStore#openInputStream(int, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public InputStream openInputStream(int options, IProgressMonitor monitor)
			throws CoreException {
		
		return physicalStore.openInputStream(options, monitor);
	}
	
	/**
	 * Fetches the URI of the underlying physical store.
	 * Delegates this call to underlying physical store, and appends ZIP scheme prefix into it
	 * 
	 * @return the URI of the underlying physical store
	 * @see com.nokia.tools.variant.storage.zip.ZipFileStore#toURI()
	 */
	@Override
	public URI toURI() {		
		URI physicalStoreURI = physicalStore.toURI();
		try {
			URI u = new URI(ZipFileSystem.ZIP_SCHEME, 
					physicalStoreURI.toString(), null);
			return u;
		}
		catch(URISyntaxException e) {
			// Should never happen
			assert(false);
			throw new RuntimeException("Error in converting ZIP store into URI");
		}
	}	

	/**
	 * Fetches the name of the underlying physical store.
	 * Delegates this call to underlying physical store 
	 * 
	 * @return the name of underlying store
	 * @see com.nokia.tools.variant.storage.zip.ZipFileStore#getName()
	 */
	@Override
	public String getName() {
		return physicalStore.getName();
	}

	/**
	 * Initializes the hierarchical ZIP structure based on
	 * ZIP entries.
	 * 
	 * @param monitor the IProgressMonitor for updating initialization status
	 */
	private synchronized void init(IProgressMonitor monitor) {
		if (initializing) return;
		// Turn on initialization flag for the reason to prevent nested calls
		initializing = true;
		
		// Create local temporary file of the zip 
		try {
			zip = new ZipFile(physicalStore.toLocalFile(EFS.NONE, monitor));
			
			// Read the entries of zip file and constructing
			// internal hierarchy of zip entries
			Enumeration<? extends ZipEntry> entries = zip.entries();
			while (entries.hasMoreElements()) {
				// Fetch the next entry
				ZipEntry e = entries.nextElement();
				
				// Fetch the parent ZIP. It is well possible that the parent store
				// has not been created yet, e.g. create it on demand.
				createFileStructure(e);				
			}
			
			initializing = false;
			
		} catch (ZipException e) {
			e.printStackTrace();
			// We should not reach here
			throw new RuntimeException(e.getMessage(), e);			
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage(), e);
		} catch (CoreException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	
	/**
	 * Creates the given file store structure, based on given ZIP entry.
	 * The implementation checks if the parent folder structure exists,
	 * and when needed, creates it on demand.
	 */
	private void createFileStructure(ZipEntry originatingEntry) {		
		// Start from root, and iteratively create folders if needed
		StringTokenizer pathTokenizer = new StringTokenizer(originatingEntry.getName(), 
				ZipFileSystem.PATH_SEPARATOR);
		ZipFileStore current = this;
		while (pathTokenizer.hasMoreTokens()) {
			String entryName = pathTokenizer.nextToken();
			// Create entry if it doesn't exist yet
			ZipFileStore child = (ZipFileStore) current.getChild(entryName);
			if (child == null) {
				// If more tokens left, we're absolutely creating a folder, otherwise
				// check from entry whether this is file or folder
				IFileInfo i;
				if (pathTokenizer.hasMoreTokens() || originatingEntry.isDirectory()) {
					i = createFolderInfo(originatingEntry, entryName);
				}
				else {
					i = createFileInfo(originatingEntry, entryName);
				}
				child  = new ZipFileStore(current, this, i);
				current.addChild(child);				
			}
			// Iterate forward
			current = child;
		}
	}

	/**
	 * Fetches an InputStream to the nested element inside this ZIP.
	 * This is intended as a utility method for the nested ZipFileStores for
	 * fetching an input stream (they don't get access to ZIP input stream
	 * by themselves). 
	 * 
	 * @param zipFileStore the ZipFileStore to fetch the input to
	 * @param options the opening options. Not utilized at the moment
	 * @param monitor the progress monitor to monitor the opening
	 * @return
	 */
	protected InputStream openInputStream(ZipFileStore zipFileStore, int options,
			IProgressMonitor monitor) {
		// Create a ZIP entry compatible path for the child
		String relativePath = 
			ZipFileSystem.toZipLocalPath(zipFileStore.toURI());
		
		// Fetch an entry corresponding the ZIP
		ZipEntry entry = zip.getEntry(relativePath);
		
		// Open input stream for extracting the ZIP
		try {
			return zip.getInputStream(entry);
		} catch (IOException e) {
			// Instead of just printing stack trace,
			// this should be represented to the user
			e.printStackTrace();
			return null;
		}				
	}
}	
