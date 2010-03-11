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

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.media.Duration;
import javax.media.MediaLocator;
import javax.media.PackageManager;
import javax.media.Time;
import javax.media.protocol.ContentDescriptor;
import javax.media.protocol.FileTypeDescriptor;
import javax.media.protocol.InputSourceStream;
import javax.media.protocol.PullDataSource;
import javax.media.protocol.PullSourceStream;
import javax.media.protocol.Seekable;

import org.eclipse.core.runtime.IPath;

public class LocalDataSource extends PullDataSource {
	/** 
	 * Random access source stream
	 */
	static class RAPullSourceStream implements PullSourceStream, Seekable {
		
		private byte[] content;
		private int position;
		
		public RAPullSourceStream(byte[] content) {
			this.content = content;
			this.position = 0;
		}
		
		public long seek(long where) {
			position = (int)Math.min(where, Integer.MAX_VALUE);
			return tell();
		}

		public long tell() {
			return position;
		}

		public boolean isRandomAccess() {
			return true;
		}

		public boolean willReadBlock() {
			return false;
		}

		public int read(byte buffer[], int offset, int length)
				throws IOException {
			if (length == 0) {
				return 0;
			}
			if (position >= content.length) {
				return -1;
			}
			int limit = Math.min(length, content.length - position);
			System.arraycopy(content, position, buffer, offset, limit);
			position += limit;
			return limit;
		}

		public ContentDescriptor getContentDescriptor() {
			return null;
		}

		public long getContentLength() {
			return content.length;
		}

		public boolean endOfStream() {
			return false;
		}

		public Object[] getControls() {
			return new Object[0];
		}

		public Object getControl(String controlType) {
			return null;
		}

	}

	class ByteSourceStream extends InputSourceStream {

		public long getContentLength() {
			return content.length;
		}

		public ByteSourceStream(ContentDescriptor type) throws IOException {
			super(new ByteArrayInputStream(content), type);
		}
	}

	static final List<String> protocolPrefixes = new ArrayList<String>(
			PackageManager.getProtocolPrefixList());
	static final List<String> contentPrefixes = new ArrayList<String>(
			PackageManager.getContentPrefixList());

	protected ContentDescriptor contentType;
	protected ByteSourceStream sources[];
	protected boolean connected;
	protected byte[] content;
	protected IPath contentPath;

	public LocalDataSource(IPath path, byte[] content) throws IOException {
		setLocator(new MediaLocator(path.toPortableString()));
		this.connected = false;
		this.content = content;
		this.contentPath = path;

		System.out.println("Protocol prefixes: " + protocolPrefixes);
		System.out.println("Content prefixes: " + contentPrefixes);

		String name = "media.protocol.file.DataSource";

		List<String> classList = new ArrayList<String>();
		classList.add(name);
		for (String prefix : protocolPrefixes) {
			classList.add(prefix + "." + name);
		}
		System.out.println("Class list: " + classList);
		for (String dsName : classList) {
			//try {
				//Class<?> dsClass = Class.forName(dsName);
				System.out.println("Class : " + dsName + " is OK");
			//} catch (ClassNotFoundException e) {
				
				// e.printStackTrace();
				System.out.println("Class : " + dsName + " is ERROR");
			//}
		}
	}

	public PullSourceStream[] getStreams() {
		if (!connected)
			throw new Error("Unconnected source.");
		else
			return sources;
	}

	public void connect() throws IOException {
		connected = true;
		String ext = contentPath.getFileExtension();
		String cdName = ContentDescriptor.CONTENT_UNKNOWN;
		if ("mp3".equalsIgnoreCase(ext)) {
			cdName = FileTypeDescriptor.MPEG_AUDIO;
		} else if ("mpg".equalsIgnoreCase(ext)) {
			cdName = FileTypeDescriptor.MPEG_AUDIO;
		} else if ("mpeg".equalsIgnoreCase(ext)) {
			cdName = FileTypeDescriptor.MPEG_AUDIO;
		}

		contentType = new ContentDescriptor(cdName);
		sources = new ByteSourceStream[1];
		sources[0] = new ByteSourceStream(contentType);
	}

	public String getContentType() {
		if (!connected)
			throw new Error("Source is unconnected.");
		else
			return contentType.getContentType();
	}

	public void disconnect() {
		if (connected) {
			try {
				sources[0].close();
			} catch (IOException e) {
			}
			connected = false;
		}
	}

	public void start() throws IOException {
	}

	public void stop() throws IOException {
	}

	public Time getDuration() {
		return Duration.DURATION_UNKNOWN;
	}

	public Object[] getControls() {
		return new Object[0];
	}

	public Object getControl(String controlName) {
		return null;
	}

}
