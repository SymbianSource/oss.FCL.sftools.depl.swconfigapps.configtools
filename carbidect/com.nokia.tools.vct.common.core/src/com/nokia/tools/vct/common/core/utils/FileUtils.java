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
 * Description: This file is part of com.nokia.tools.vct.common.core component.
 */

package com.nokia.tools.vct.common.core.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
import org.eclipse.core.runtime.PlatformObject;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.core.runtime.Status;

import com.nokia.tools.vct.internal.common.core.CommonCorePlugin;

/**
 * File utilities
 */
public final class FileUtils {
	/**
	 * Adapter of {@link File} into {@link IStorage} interface. The adapter
	 * provides support for {@link IPath} and {@link File} adaptations.
	 */
	private static final class LocalFileStorage extends PlatformObject
			implements IStorage {
		/** File to operate with */
		private File file;

		/**
		 * Constructs the storage object
		 * 
		 * @param file
		 *            File to use
		 */
		public LocalFileStorage(File file) {
			this.file = file;
		}

		@SuppressWarnings("unchecked")
		public Object getAdapter(Class adapter) {
			if (adapter == File.class) {
				return file;
			}
			if (adapter == IPath.class) {
				return getFullPath();
			}
			return super.getAdapter(adapter);
		}

		public boolean isReadOnly() {
			return true;
		}

		public InputStream getContents() throws CoreException {
			try {
				return new FileInputStream(file);
			} catch (FileNotFoundException e) {
				throw new CoreException(new Status(IStatus.ERROR,
						CommonCorePlugin.PLUGIN_ID, "File open error", e));
			}
		}

		public IPath getFullPath() {
			try {
				return new Path(file.getCanonicalPath());
			} catch (IOException e) {
				logWarning("Failed to resolve file path", e);
				return null;
			}
		}

		public String getName() {
			return file.getName();
		}

		@Override
		public int hashCode() {
			return file.hashCode();
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof LocalFileStorage) {
				return file.equals(((LocalFileStorage) obj).file);
			}
			return false;
		}
	}

	/**
	 * Compares file contents
	 * 
	 * @param a
	 *            source file
	 * @param b
	 *            target file
	 * @return <code>true</code> if arguments points to the same file or both
	 *         files exist and have equal content.
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

			int reada = 0;
			int readb = 0;

			for (;;) {
				reada = readFully(ia, buf_a);
				readb = readFully(ib, buf_b);

				if (reada != readb) {
					return false;
				}
				if (reada == -1) {
					return true;
				}
				if (!Arrays.equals(buf_a, buf_b)) {
					return false;
				}
			}
		} catch (Exception e) {
			logWarning("Failed to compare file contents", e);
		} finally {
			closeStream(ia);
			closeStream(ib);
		}
		return false;
	}

	/**
	 * Helper method to read source stream until EOF.
	 * 
	 * @param is
	 *            Input stream
	 * @param dst
	 *            Destination array
	 * @return Number of bytes read, or -1 if EOF has been reached.
	 * @throws IOException
	 *             On input stream exception
	 */
	public static int readFully(InputStream is, byte[] dst) throws IOException {
		int total = 0;
		int offset = 0;
		int length = dst.length;
		int result;

		if (length == 0) {
			return 0;
		}

		while (length > 0 && (result = is.read(dst, offset, length)) >= 0) {
			total += result;
			offset += result;
			length -= result;
		}

		return total == 0 ? -1 : total;
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

	/**
	 * Helper method to close input stream. Does nothing if the stream is
	 * already closed or argument is <code>null</code>
	 * <p>
	 * Any encountered exceptions are catched and reported into log.
	 * </p>
	 * 
	 * @param is
	 *            Stream to close or <code>null</code>
	 */
	public static void closeStream(InputStream is) {
		try {
			if (is != null) {
				is.close();
			}
		} catch (Throwable thr) {
			logWarning("Exception during stream close", thr);
		}
	}

	/**
	 * Helper method to close output stream. Does nothing if the stream is
	 * already closed or argument is <code>null</code>
	 * <p>
	 * Any encountered exceptions are catched and reported into log.
	 * </p>
	 * 
	 * @param os
	 *            Stream to close or <code>null</code>
	 */
	public static void closeStream(OutputStream os) {
		try {
			if (os != null) {
				os.close();
			}
		} catch (Throwable thr) {
			logWarning("Exception during stream close", thr);
		}
	}

	/**
	 * Internal helper method to log {@link Throwable} object and re-throw
	 * {@link Error} if the argument has {@link Error} type.
	 * 
	 * @param message
	 *            Message for log
	 * @param cause
	 *            Error cause
	 * @throws Error
	 *             Error when cause casts to this type.
	 */
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
	 * Copy existing directory on srcPath into non-existing targetPath
	 * directory.
	 * 
	 * @param srcPath
	 *            source directory to copy
	 * @param targetPath
	 *            target directory which will be created by copy
	 * @return <code>true</code> if copy went OK else <code>false</code>
	 */
	public static boolean copyDirectoryContent(File srcPath, File targetPath) {
		if (srcPath.isDirectory()) {// directory
			targetPath.mkdirs();

			File[] srcChildFiles = srcPath.listFiles();
			boolean ok = true;
			for (int i = 0; i < srcChildFiles.length; i++) {
				File srcFile = srcChildFiles[i];

				boolean temp = copyDirectoryContent(srcFile, new File(
						targetPath, srcFile.getName()));
				if (!temp) {
					ok = false;
				}
			}
			return ok;
		} else {// file
			try {
				FileInputStream fis = new FileInputStream(srcPath);
				FileOutputStream fos = new FileOutputStream(targetPath);
				copyStream(fis, fos);
			} catch (FileNotFoundException e) {
				return false;
			} catch (IOException e) {
				return false;
			}
			return true;
		}
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
	 * @param name
	 *            Name to extract extension from
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
	 * @return Array of files that were not deleted due to any cause.
	 */
	public static File[] deleteDirectory(File dir) {
		List<File> undeletable = new ArrayList<File>();
		deleteDirectory(dir, undeletable);
		return ArrayUtils.createCopy(File.class, undeletable);
	}

	/*
	 * Internal helper for recursive resource deletion
	 */
	private static void deleteDirectory(File dir, List<File> undeletable) {
		File[] children = dir.listFiles();
		for (File child : children) {
			if (child.isDirectory()) {
				deleteDirectory(child, undeletable);
			} else {
				if (!child.delete()) {
					undeletable.add(child);
				}
			}
		}
		if (!dir.delete()) {
			undeletable.add(dir);
		}
	}

	/**
	 * Wraps file into {@link IStorage} interface.
	 * 
	 * @param file
	 * @return Content source interface in read only.
	 * @throws IOException
	 */
	public static IStorage createFileStorage(final File file)
			throws IOException {
		return new LocalFileStorage(file);
	}

	/**
	 * Finds if it is possible to create file or folder in specified directory.
	 * The name must be a valid segment (without path separators).
	 * 
	 * @param parentDirectory
	 *            destination directory where new file <code>newFileName</code>
	 *            should be created
	 * @param newFileName
	 *            file/folder name to create without path separators
	 * @return <code>true</code> if it is possible to create file
	 *         <code>newFileName</code> in directory
	 *         <code>parentDirectory</code>. Returns <code>false</code> when
	 *         file <code>newFileName</code> cannot be created in directory
	 *         <code>parentDirectory</code>
	 */
	public static boolean canCreateNewChildFileOrDirectory(
			File parentDirectory, String newFileName) {
		if (parentDirectory == null || newFileName == null) {
			return false;
		}

		return Path.EMPTY.isValidSegment(newFileName)
				&& FileUtils.isWriteableDirectory(parentDirectory, newFileName);
	}

	/**
	 * Finds if specified path is valid and does not exist. The valid path must
	 * be absolute, the parent directory must exists and be writable.
	 * <p>
	 * This method can be used by UI forms to verify if the user has entered a
	 * valid destination file or directory name.
	 * </p>
	 * 
	 * @param path
	 *            path to test
	 * @return Returns <code>true</code> if path is valid. Returns
	 *         <code>false</code> if path is not valid.
	 */
	public static boolean isPathValid(String path) {
		if (path == null || "".equals(path)) {
			return false;
		}
		File newFileToCreate = new File(path);
		if (!newFileToCreate.isAbsolute() || newFileToCreate.exists()) {
			// two checks: the argument must be absolute path and the target
			// file must not exists.
			return false;
		}
		File parentDir = newFileToCreate.getParentFile();
		String name = newFileToCreate.getName();
		
		// traverse up to existing directory
		while (parentDir != null && !parentDir.exists()) {
			name = parentDir.getName();
			parentDir = parentDir.getParentFile();
		}
		
		// the parent exists and is directory and is writable
		return FileUtils.isWriteableDirectory(parentDir, name);
	}

	/**
	 * Tests if the path is valid, absolute, and can be created as a directory
	 * tree.
	 * 
	 * @param path
	 *            Path to test. Can be <code>null</code> or any arbitrary
	 *            string.
	 * 
	 * @return <code>true</code> if the path is absolute, valid, the file with
	 *         the given path does not exist and the directory with the given
	 *         name can be created.
	 */
	public static boolean isDirectoryValid(String path) {
		if (path == null || "".equals(path)) {
			return false;
		}
		if (!Path.EMPTY.isValidPath(path)) {
			return false;
		}

		File newFileToCreate = new File(path);
		if (!newFileToCreate.isAbsolute() || newFileToCreate.exists()) {
			// the path must be absolute and must not exist
			return false;
		}

		File tmp = newFileToCreate.getParentFile();
		String name = newFileToCreate.getName();
		// traverse up to existing directory
		while (tmp != null && !tmp.exists()) {
			name = tmp.getName();
			tmp = tmp.getParentFile();
		}

		return FileUtils.isWriteableDirectory(tmp, name);
	}

	/**
	 * Tests if the path is valid, absolute, and can be created as a directory
	 * tree.
	 * 
	 * @param path
	 *            Path to test. Can be <code>null</code> or any arbitrary
	 *            string.
	 * @param deleteAfterTest
	 *            when <code>false</code> the method creates a directory tree.
	 * 
	 * @return <code>true</code> if the path is absolute, valid, the file with
	 *         the given path does not exist and the directory with the given
	 *         name can be created (or created when
	 *         <code>deleteAfterTest == false</code>.
	 * 
	 * @deprecated This method has an optional side effect of creating a
	 *             directory tree
	 */
	@Deprecated
	public static boolean isDirectoryValid(String path, boolean deleteAfterTest) {
		if (isDirectoryValid(path)) {
			if (!deleteAfterTest) {
				// IMPROVEMENT: test side effect - shall be removed
				File newFileToCreate = new File(path);
				newFileToCreate.mkdirs();
			}
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Method to test if the directory allows creation of a child file with the
	 * given name. The method overcomes problem with Java bug #4939819.
	 * 
	 * @param file
	 *            Directory
	 * @param name
	 *            File name
	 * @return
	 */
	private static boolean isWriteableDirectory(File file, String name) {
		if (file == null || !file.isDirectory()) {
			return false;
		}
		if (file.canWrite()) {
			return true;
		} else {
			File temp = new File(file, name);
			if (temp.exists()) {
				return false;
			}
			try {
				if (temp.createNewFile()) {
					temp.delete();
					return true;
				}
			} catch (IOException e) {
			}
			return false;
		}
	}

}
