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
 * Description: This file is part of com.nokia.tools.vct.imaker.core component.
 */

package com.nokia.tools.vct.imaker.core;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;

public interface IImageMaker {
	/**
	 * @return the version of this plugin
	 */
	public String getVersion();

	/**
	 * @return the version of image creation tool
	 */
	public String getImakerVerion() throws IOException;

	/**
	 * Executes Image Maker build with default environment options.
	 * 
	 * @param config
	 *            path to configuration project or CPF file
	 * @param activeRoot
	 *            the active root configuration, if config is CPF
	 * @param outputLocation
	 *            path to output location, if null output specified in imaker ConfML api is used
	 * @param outputStream
	 *            stream where image creation process output is written
	 * @param monitor
	 *            Progress monitor for image creation process
	 * @return 0 if image was successfully created
	 * @throws IOException
	 *             if image creation process couldn't be run
	 * @see #createImage(URI, URI, URI, OutputStream, IProgressMonitor, Map)
	 */
	public int createImage(URI config, URI activeRoot, URI outputLocation,
			OutputStream outputStream, IProgressMonitor monitor)
			throws IOException;

	/**
	 * Executes Image Maker build.
	 * 
	 * @param config
	 *            URI of CPF file or project
	 * @param activeRoot
	 *            Relative URI of root configuration ConfML file. Can be
	 *            <code>null</code> if the source contains only one
	 *            configuration.
	 * @param outputLocation
	 *            Working directory or <code>null</code>
	 * @param outputStream
	 *            Stream connected to console output. Both standard and error
	 *            streams are merged.
	 * @param monitor
	 *            Progress monitor for build process tracking and cancellation.
	 *            Can be <code>null</code>
	 * @param environment
	 *            Execution environment or <code>null</code>. When defined, the
	 *            launcher would replace default system environment with a given
	 *            one.
	 * @return Execution status code. <code>0</code> indicated normal completion
	 * @throws IOException
	 *             If process creation fails.
	 */
	public int createImage(URI config, URI activeRoot, URI outputLocation,
			OutputStream outputStream, IProgressMonitor monitor,
			Map<String, String> environment) throws IOException;
	
	/**
	 * Executes Image Maker build.
	 * 
	 * @param config
	 *            URI of CPF file or project
	 * @param activeRoot
	 *            Relative URI of root configuration ConfML file. Can be
	 *            <code>null</code> if the source contains only one
	 *            configuration.
	 * @param outputLocation
	 *            Working directory or <code>null</code>
	 * @param reporFile
	 *            The URI of report file.
	 * @param reportTemplate
	 *            The URI of report template file
	 * @param outputStream
	 *            Stream connected to console output. Both standard and error
	 *            streams are merged.
	 * @param monitor
	 *            Progress monitor for build process tracking and cancellation.
	 *            Can be <code>null</code>
	 * @param environment
	 *            Execution environment or <code>null</code>. When defined, the
	 *            launcher would replace default system environment with a given
	 *            one.
	 * @return Execution status code. <code>0</code> indicated normal completion
	 * @throws IOException
	 *             If process creation fails.
	 */
	public int createImage(URI config, URI activeRoot, URI outputLocation, URI reportFile, URI reportTemplate,
			OutputStream outputStream, IProgressMonitor monitor,
			Map<String, String> environment) throws IOException;

}
