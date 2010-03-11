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
 * Description: This file is part of com.nokia.tools.variant.common.core component.
 */

package com.nokia.tools.variant.common.core.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.core.runtime.Status;

import com.nokia.tools.variant.common.internal.core.CommonCorePlugin;

/**
 * File utilities
 * 
 */
public class FileUtils {
	/**
	 * true if files are the same.
	 * 
	 * @param a source file
	 * @param b target file
	 * @return
	 */
	public static boolean compareByContent(File a, File b) {
		if (a.equals(b)) {
			return true;
		}
		FileInputStream ia = null;
		FileInputStream ib = null;
		try {
			if (a.length() != b.length())
				return false;
			byte[] buf_a = new byte[32000];
			byte[] buf_b = new byte[32000];

			ia = new FileInputStream(a);
			ib = new FileInputStream(b);

			int readed = 0;
			while ((readed = ia.read(buf_a)) >= 0) {
				ib.read(buf_b, 0, readed);
				if (!Arrays.equals(buf_a, buf_b))
					return false;
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeStream(ia);
			closeStream(ib);
		}
		return false;
	}

	
	/**
	 * Silently close the stream and log a warning on error. Do nothing if the
	 * argument is <code>null</code>
	 * 
	 * @param is
	 *            Input stream to close or <code>null</code>
	 * @param caller
	 *            Caller plugin
	 */
	public static IStatus closeStream(final InputStream is, Plugin caller) {
		if (is == null) {
			return Status.OK_STATUS;
		}

		final AtomicReference<Throwable> error = new AtomicReference<Throwable>();

		SafeRunner.run(new ISafeRunnable() {
			public void handleException(Throwable exception) {
				error.set(exception);
			}

			public void run() throws Exception {
				is.close();
			};
		});

		Throwable thr = error.get();
		if (thr != null) {
			Status status;
			if (caller != null) {
				status = new Status(IStatus.WARNING, caller.getBundle()
						.getSymbolicName(), "Exception during stream close",
						thr);
				caller.getLog().log(status);
			} else {
				Plugin thisPlugin = CommonCorePlugin.getInstance();
				status = new Status(IStatus.WARNING, thisPlugin.getBundle()
						.getSymbolicName(), "Exception during stream close",
						thr);
				thisPlugin.getLog().log(status);
			}
			return status;
		}

		return Status.OK_STATUS;
	}

	public static void closeStream(InputStream is) {
		try {
			if (is != null) {
				is.close();
			}
		} catch (Throwable thr) {
			logWarning("Exception during stream close", thr);
		}
	}

	public static void closeStream(OutputStream os) {
		try {
			if (os != null) {
				os.close();
			}
		} catch (Throwable thr) {
			logWarning("Exception during stream close", thr);
		}
	}

	private static void logWarning(String message, Throwable cause)
			throws Error {
		Plugin thisPlugin = CommonCorePlugin.getInstance();
		IStatus status = new Status(IStatus.WARNING, thisPlugin.getBundle()
				.getSymbolicName(), message, cause);
		thisPlugin.getLog().log(status);
		ExceptionUtils.throwIfMatches(Error.class, cause);
	}

	/**
	 * Copy stream content.
	 * 
	 * The content is read from input stream and is written to output. Streams
	 * are not closed
	 * 
	 * @param is
	 *            Input stream
	 * @param os
	 *            Output stream
	 * @throws IOException
	 */
	public static long copyStream(InputStream is, OutputStream os)
			throws IOException {
		byte[] buffer = new byte[16384];
		int len;
		long result = 0;

		while ((len = is.read(buffer)) >= 0) {
			os.write(buffer, 0, len);
			result += len;
		}
		return result;
	}

	/**
	 * Encryption method. Encrypts content of the input stream and writes it
	 * into output. The streams are not closed.
	 * 
	 * @param is
	 *            Input stream
	 * @param os
	 *            Output stream
	 * @param cipher
	 *            Encryption cipher to use
	 * @throws IOException
	 * 
	 * @see #decode(InputStream, OutputStream, Cipher)
	 */
	public static void encode(InputStream is, OutputStream os, Cipher cipher)
			throws IOException {
		CipherOutputStream cos = new CipherOutputStream(os, cipher);
		copyStream(is, cos);
		cos.flush();
	}

	/**
	 * Decryption method. Decrypts content of the input stream and writes it
	 * into output. The streams are not closed.
	 * 
	 * @param is
	 *            Input stream
	 * @param os
	 *            Output stream
	 * @param cipher
	 *            Cipher to use
	 * @throws IOException
	 * 
	 * @see #encode(InputStream, OutputStream, Cipher)
	 */
	public static void decode(InputStream is, OutputStream os, Cipher cipher)
			throws IOException {
		CipherInputStream cis = new CipherInputStream(is, cipher);
		copyStream(cis, os);
	}

	/**
	 * Same as {@link IFile#getFileExtension()}
	 * 
	 * @param file
	 *            File to get extension for
	 * @return Extension or <code>null</code>
	 * 
	 */
	public static String getExtension(File file) {
		if (file == null) {
			return null;
		}
		return getExtension(file.getName());
	}


	/**
	 * Extract the file extension from the name.
	 * 
	 * @param name Name to extract extension from
	 * @return Extension (possibly empty) or <code>null</code>
	 */
	public static String getExtension(String name) {
		int idx = name.lastIndexOf('.');
		if (idx < 0) {
			return null;
		} else {
			return name.substring(idx + 1);
		}
	}

	
	/**
	 * Reads the input stream until the EOF marker. The input stream is not
	 * closed afterwards
	 * 
	 * @param is
	 *            Input stream
	 * @return Content read as byte array
	 * @throws IOException
	 */
	public static byte[] readBytes(InputStream is) throws IOException {
		byte[] buffer = new byte[4096];
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int len;

		while ((len = is.read(buffer)) >= 0) {
			baos.write(buffer, 0, len);
		}

		return baos.toByteArray();
	}

	/**
	 * Attempt to recursively delete the directory including all nested
	 * sub-directories and resources.
	 * 
	 * IMPROVEMENT add file locking prior to deletion attempt
	 * 
	 * @param dir
	 *            Directory to delete.
	 */
	public static void deleteDirectory(File dir) {
		File[] children = dir.listFiles();
		for (File child : children) {
			if (child.isDirectory()) {
				deleteDirectory(child);
			} else {
				child.delete();
			}
		}
		dir.delete();
	}

	public static IStorage createFileStorage(final File file) throws IOException {
		String canonical = file.getCanonicalPath();
		final IPath path = new Path(canonical);
		
		return new IStorage() {
			@SuppressWarnings("unchecked")
			public Object getAdapter(Class adapter) {
				if (adapter == File.class) {
					return file;
				}
				if (adapter == IPath.class) {
					return path;
				}
				return null;
			}
			public boolean isReadOnly() {
				return true;
			}
			public InputStream getContents() throws CoreException {
				try {
					return new FileInputStream(file);
				} catch (FileNotFoundException e) {
					throw new CoreException(new Status(IStatus.ERROR, CommonCorePlugin.PLUGIN_ID, "File open error", e));
				}
			}
			public IPath getFullPath() {
				return path;
			}
			public String getName() {
				return file.getName();
			}
		};
	}

	
	/**
	 * Finds if it is possible to create file or folder in specified directory.
	 * 
	 * @param parentDirectory destination directory where new file <code>newFileName</code> should be created
	 * @param newFileName file/folder name to create
	 * @return <code>true</code> if it is possible to create file <code>newFileName</code> in directory <code>parentDirectory</code>. Returns <code>false</code> when file <code>newFileName</code> cannot be created in directory <code>parentDirectory</code> 
	 */
	public static boolean canCreateNewChildFileOrDirectory(File parentDirectory, String newFileName) {
		if(parentDirectory == null || newFileName == null || parentDirectory.isFile()) {
			return false;
		}
		File newFileToCreate = new File(parentDirectory, newFileName);

		if(!newFileToCreate.exists()) {// if file not exists then try it to create
			try {
				boolean canBeCreated = newFileToCreate.createNewFile();

				if(canBeCreated) {// file or folder can be created
					// remove temporary test file
					newFileToCreate.delete();
				}
				
				// test if we are creating immediate child of file, if not return false
				// we cannot create multilevel children paths 
				if(!newFileToCreate.getParent().equals(parentDirectory.getPath())) {
					return false;
				}
				return canBeCreated;
			} catch (Throwable t) {// if something in file creation went wrong
				return false;
			}
		} else {
			// file already exists
			return false;
		}
	}
}
