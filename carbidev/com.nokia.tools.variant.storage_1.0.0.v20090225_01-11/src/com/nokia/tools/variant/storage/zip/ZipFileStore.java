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

import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedHashSet;

import org.eclipse.core.filesystem.IFileInfo;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.filesystem.provider.FileStore;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

/**
 * Read-only zip file store, e.g. no handling of child insertion etc. is done.
 * Handle file names with encoded ! that is treated as special character here.
 * 
 */
public class ZipFileStore extends FileStore {
	
	private final ZipFileStoreRoot root;
	private final ZipFileStore parent;
	private IFileInfo fileInfo;

	// HashSet for quick fetch of children. Currently
	// hashCode is calculated from the ZipFileStore URI,
	// which serves the purpose well.
	private final LinkedHashSet<ZipFileStore> children;
	
	public ZipFileStore(String name, ZipFileStore parent, 
			ZipFileStoreRoot root) {
		this(parent, root, null);
	}	
	
	/**
	 * Instantiates a new ZipFileStore from the given metadata.
	 * Not intended to be used externally.
	 * 
	 * @param name entry name, must not be null & contain ZipFileStore.PATH_SEPARATOR if directory
	 * @param parent the parent ZipFileStore
	 * @param root the root ZipFileStore
	 * @param fileInfo the file metadata
	 */
	public ZipFileStore(ZipFileStore parent, 
			ZipFileStoreRoot root, IFileInfo fileInfo) {
		this.parent = parent;
		this.root = root;
		this.fileInfo = fileInfo;
		children = new LinkedHashSet<ZipFileStore>();
	}
	
	/**
	 * Convenience method for determining if the entry is a directory
	 * or not. Checks this information from metadata.
	 * 
	 *  @return true in case this entry is directory, false otherwise.
	 */
	public boolean isDirectory() {
		return fileInfo.isDirectory();
	}
	
	/**
	 * Adds a child to the file store
	 * 
	 * @param child The child to add to this FileStore
	 * @return true if the addition succeeded, false otherwise
	 */
	public boolean addChild(ZipFileStore child) {
		// Ensure that the parent-child two-direction relationship is met
		return children.add(child);
	}

	/**
	 * @see org.eclipse.core.filesystem.provider.FileStore#childNames(int, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public String[] childNames(int options, IProgressMonitor monitor)
			throws CoreException {
		String[] names = new String[children.size()];
		int i = 0;
		for (ZipFileStore s : children) {
			names[i++] = s.getName();
		}
		
		return names;
	}

	/**
	 * @see org.eclipse.core.filesystem.provider.FileStore#fetchInfo(int, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public IFileInfo fetchInfo(int options, IProgressMonitor monitor)
			throws CoreException {
		return fileInfo;
	}
		
	/**
	 * @see org.eclipse.core.filesystem.provider.FileStore#getChild(java.lang.String)
	 */
	@Override
	public IFileStore getChild(String name) {
		// Currently this is not as efficient as it could,
		// as it needs to iterate through the whole set
		for (ZipFileStore s : children)
			if (s.getName().equals(name)) return s;
		
		// This should never happen
		assert(false);
		return null;
	}	

	/**
	 * Returns the name of this entry. In case of root,
	 * it is empty.
	 * 
	 * @return the name of the file store
	 * @see org.eclipse.core.filesystem.provider.FileStore#getName()
	 */
	@Override
	public String getName() {
		return fileInfo.getName();
	}

	/**
	 * @see org.eclipse.core.filesystem.provider.FileStore#getParent()
	 */
	@Override
	public IFileStore getParent() {
		return parent;
	}

	/**
	 * @see org.eclipse.core.filesystem.provider.FileStore#openInputStream(int, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public InputStream openInputStream(int options, IProgressMonitor monitor)
			throws CoreException {
		return root.openInputStream(this, options, monitor);
	}

	/**
	 * @see org.eclipse.core.filesystem.provider.FileStore#toURI()
	 */
	@Override
	public URI toURI() {
		// In case we're bound to root, use a special separator
		String separator;
		if (this.parent == this.root) separator = ZipFileSystem.PART_SEPARATOR;
		else separator = ZipFileSystem.PATH_SEPARATOR;
		
		// Append the current URI to the parent URI path
		URI parentURI = parent.toURI();
		
		// Append the ZIP path using the ZIP separator
		try {
			URI u = new URI(parentURI.getScheme(), 
					parentURI.getSchemeSpecificPart() + separator + 
					this.getName(), null);
			return u;
		} catch (URISyntaxException e) {
			// Should be never caught.
			throw new RuntimeException("URI Encoding of ZipFileStore failed");
		}		
	}
	
	/**
	 * Returns the file info of this element
	 * 
	 * @return the IFileInfo on this element
	 */
	protected IFileInfo getFileInfo() {
		return fileInfo;
	}
	

	/**
	 * Sets the file info of this element 
	 * 
	 * @param fileInfo the new FileInfo for this element 
	 */
	protected void setFileInfo(IFileInfo fileInfo) {
		this.fileInfo = fileInfo;
	}
	
}
