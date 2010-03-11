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

import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.filesystem.URIUtil;
import org.eclipse.core.filesystem.provider.FileSystem;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;

public class ZipFileSystem extends FileSystem {

	private static final String MALFORMED_ZIP_URI_MESSAGE = "URIs for ZIP entries must conform to zip:<uri_or_path>[!/<path_in_zip>] convention.";
	public static final String ZIP_SCHEME = "zip";
	public static final String PART_SEPARATOR = "!/";
	public static final String PATH_SEPARATOR = "/";

	// Least Recently Used cache, inspired by
	// http://www.source-code.biz/snippets/java/6.htm
	// Key equals URI path, value equals ZIP entries
	private static final LinkedHashMap<String, ZipFileStoreRoot> entryCache = new LinkedHashMap<String, ZipFileStoreRoot>() {
		private static final long serialVersionUID = 1L;

		@Override
		protected boolean removeEldestEntry(
				Map.Entry<String, ZipFileStoreRoot> eldest) {
			return size() > ZipFileSystem.cacheSize;
		}
	};
	private static int cacheSize = 5;

	/**
	 * Resolves the given URI to a ZipFileStore, a "!/" separator for pointing
	 * out which part of the URI path belongs to zip file.
	 * 
	 * We expect URIs matching the following scheme: zip:<hierarchical_part>,
	 * where <hierarchical_part> can consist of embedded parts, ultimately
	 * pointing to a single resource within a zip file. Embedded schemes are all
	 * valid, e.g. the following (ANTLR) grammar applies:
	 * 
	 * <pre>
	 * zip_uri : ZIP_SCHEME  ':' scheme_specific_part;
	 * scheme_specific_part: uri_path (PART_SEPARATOR zip_path)?;
	 * zip_path : PART_TOKEN;
	 * uri_path : PART_TOKEN; 
	 * PART_TOKEN : &tilde;(PART_SEPARATOR)+;
	 * PART_SEPARATOR : '!/'
	 * ZIP_SCHEME : 'zip'
	 * </pre>
	 * 
	 * However, we do not create specific grammar for these. We test for scheme
	 * validity, and parse the hierarchical part separately, splitting out the
	 * outermost PART_SEPARATOR and delegate the matching of left-hand side to
	 * EFS.
	 * 
	 * E.g. the following are all valid:
	 * <ul>
	 * <li>zip:file://<path_to_zip>!/<path_in_zip>,(a path within zip)</li>
	 * <li>zip:<local_path_to_zip> (zip root)</li>
	 * <li>zip:<uri>!/<path_to_zip_resource>!/<path_to_resource> (recursion)</li>
	 * <ul>
	 * Note that here the "!/" acts as separator within hierarchical part.
	 * 
	 * See: <a href=
	 * "http://wiki.eclipse.org/index.php/EFS#UI_Examples:_Zip_and_Memory_file_systems"
	 * > EFS UI examples</a> for more reference.
	 * 
	 * The current implementation is dummy, e.g. only translates the scheme
	 * specific part into a format, understandable to a ZIP.
	 */
	@Override
	public IFileStore getStore(URI uri) {
		if (ZIP_SCHEME.equals(uri.getScheme())) {
			// Parse the tailing part separator as the zip path
			String schemeSpecificPart = uri.getSchemeSpecificPart();

			try {
				// If no path in URI, raise exception
				if (schemeSpecificPart == null)
					throw new URISyntaxException(uri.toString(),
							MALFORMED_ZIP_URI_MESSAGE);

				// Split the hierarchical part by the tailing PART_SEPARATOR
				// In case separator index not found, we point to root.
				// Otherwise
				// resolve the leading part pointing to the ZIP by delegating
				// that
				// to EFS (may lead to recursion in ZipFileSystem), and resolve
				// the trailing part into a valid path to Zip entry.
				int separatorIndex = schemeSpecificPart
						.lastIndexOf(PART_SEPARATOR);

				String zipFilePart;
				String zipPathPart;
				if (separatorIndex == -1) {
					zipFilePart = schemeSpecificPart;
					zipPathPart = null;
				} else {
					zipFilePart = schemeSpecificPart.substring(0, separatorIndex);
					zipPathPart = schemeSpecificPart.substring(separatorIndex
							+ PART_SEPARATOR.length());
				}

				// Check if we already have the corresponding ZIP file
				// in cache (by its path). If so, utilize cache
				// instead of fetching the handle.
				ZipFileStoreRoot entry = entryCache.get(zipFilePart);
				if (entry == null) {
					// The entry was not found from the cache. If cache
					// size exceeded, remove the last entry
					IFileStore ifs = EFS.getStore(new URI(zipFilePart));
					entry = new ZipFileStoreRoot(ifs);
					entryCache.put(zipFilePart, entry);
				}
				
				// If no pointer to embedded path, create pointer to the root 
				if (zipPathPart == null) return entry;

				// Now we have correct root entry, resolve the
				// ZIP path part
				IPath path = URIUtil.toPath(URI.create(zipPathPart));
				return entry.getFileStore(path);
			} catch (URISyntaxException e) {
				// ignore and fall through below
			} catch (CoreException e) {
				// ignore and fall through below
			}
		}
		// No match, return null the file store defined by null file system
		return EFS.getNullFileSystem().getStore(uri);
	}
	
	/**
	 * Resolves the path inside ZIP file from the given URI
	 * 
	 * @param absoluteURI the URI that has an ZIP path inside
	 * @return the path insize ZIP, null if the path does not exist
	 */
	public static String toZipLocalPath(URI absoluteURI) {
		String schemeSpecificPart = absoluteURI.getSchemeSpecificPart();
		int separatorIndex = schemeSpecificPart.lastIndexOf(PART_SEPARATOR);

		if (separatorIndex == -1) {
			return null;
		}
		else 
			return schemeSpecificPart.substring(separatorIndex
					+ PART_SEPARATOR.length());
	}
	
	/**
	 * Explicitly cleans up the cache. This should remove
	 * the possible stale references to cached zip files,
	 * e.g. streams should be closed after reference removal.
	 */
	public static void clearCache() {
		entryCache.clear();
	}

	public static int getCacheSize() {
		return cacheSize;
	}

	/**
	 * Modifies the cache size.
	 * 
	 * Most likely the cache size only gets updated on next insert.
	 * Ensure it gets updated right after the cache size update
	 * 
	 * @param cacheSize the size of the cache
	 */
	public static void setCacheSize(int cacheSize) {
		ZipFileSystem.cacheSize = cacheSize;
	}
}
