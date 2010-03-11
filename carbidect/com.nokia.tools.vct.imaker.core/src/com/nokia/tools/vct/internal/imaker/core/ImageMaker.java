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

package com.nokia.tools.vct.internal.imaker.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Platform;

import com.nokia.tools.vct.imaker.core.IImageMaker;
import com.nokia.tools.vct.imaker.core.ImakerCore;

public class ImageMaker implements IImageMaker {
	private static Map<URI, IImageMaker> imakerInstallations = new HashMap<URI, IImageMaker>();
	private URI drive;
	private List<String> imakerOutput = null;
	private static String IMAKER_CMD       = "imaker.cmd";
	private static String IMAKER_PATH      = "\\epoc32\\tools";
	private static String PARAM_CONFIG     = "-conf=";
	private static String PARAM_VERBOSE    = "VERBOSE=2";
	private static String IMAKER_EXITSHELL = "IMAKER_EXITSHELL";
	private static String PARAM_WORKDIR    = "WORKDIR=";
	private static String PARAM_REPFILE          = "CONE_REPFILE=";
	private static String PARAM_RTMPLFILE        = "CONE_RTMPLFILE=";
	private Pattern TAST_ENTER             = Pattern.compile("ENTER:\\s{1}`S:(.*?),.*'.*");
	private Pattern TAST_EXIT              = Pattern.compile("EXIT:\\s{1}`S:(.*?),.*'.*");

	private ImageMaker(URI drive) {
		this.drive = drive;
		this.imakerOutput = new ArrayList<String>();
	}

	public static IImageMaker getInstance(URI drive) throws IOException {
		URI prepDrive;
		try {
			prepDrive = prepareDrive(drive);
		} catch (URISyntaxException e) {
			throw new IOException(e.getMessage());
		}
		IImageMaker imageMaker = imakerInstallations.get(prepDrive);
		if(imageMaker==null) {
			imageMaker = new ImageMaker(prepDrive);
			imakerInstallations.put(prepDrive, imageMaker);
		}
		return imageMaker;
	}

	private static URI prepareDrive(URI dr) throws URISyntaxException {
		String path = dr.getPath();
		int index = path.indexOf(":");
		if(index!=-1) {
			String sub = path.substring(index-1, index+1);
			URI ret = new URI("file:/"+sub);
			return ret;
		}
		return null;
	}

	public int createImage(URI config, URI activeRoot, URI outputLocation,
			OutputStream outputStream, IProgressMonitor monitor)
			throws IOException {
		return createImage(config, activeRoot, outputLocation, outputStream,
				monitor, null);
	}
	
	public int createImage(URI config, URI activeRoot, URI outputLocation,
			OutputStream outputStream, IProgressMonitor monitor,
			Map<String, String> environment) throws IOException {
		return createImage(config, activeRoot, outputLocation, null, null,
				outputStream, monitor, environment);
	}

	public int createImage(URI config, URI activeRoot, URI outputLocation, URI reportFile, URI reportTemplate,
			OutputStream outputStream, IProgressMonitor monitor,
			Map<String, String> environment)throws IOException {
		int totalWork = getTotalNumberOfSteps();
		if(monitor != null) {
			monitor.beginTask("Creating flashable image ...", totalWork);
		}
		List<String> command = new ArrayList<String>();
		int ret = 0;
		try {
			command.add(IMAKER_CMD);
			prepareCommand(command,config,activeRoot,outputLocation, reportFile, reportTemplate);
			if(outputStream!=null) {
				outputStream.write(command.toString().getBytes());
				outputStream.write("\n".getBytes());
			}
			ret = runCommand(command, outputStream, monitor, environment);
		} catch (IOException e) {
			command.set(0, getDriveLetter()+IMAKER_PATH+"\\"+IMAKER_CMD);
			System.out.println(command);
			if(outputStream!=null) {
				outputStream.write(command.toString().getBytes());
				outputStream.write("\n".getBytes());
			}
			ret = runCommand(command, outputStream, monitor, environment);
		} finally {
			if(monitor!=null) {
				monitor.done();
			}
		}
		return ret;
	}

	private void beginSubTask(IProgressMonitor monitor, String line) {
		if(monitor != null) {
			Matcher matcher = TAST_ENTER.matcher(line);
			if(matcher.find()) {
				int start = matcher.start(1);
				int end = matcher.end(1);
				String subTask = "Running subtask... " + line.substring(start, end);
				System.out.println(subTask);
				//monitor.subTask("");
			}
		}
	}

	private void taskWorked(IProgressMonitor monitor, String line) {
		if(monitor != null) {
			Matcher matcher = TAST_EXIT.matcher(line);
			if(matcher.find()) {
				int start = matcher.start(1);
				int end = matcher.end(1);
				String subTask = line.substring(start, end);
				System.out.println("Finished subTask... " + subTask);
				monitor.worked(1);
			}
		}
	}

	private int getTotalNumberOfSteps() {
		// 3=cone, 6=imaker
		return 3+6;
	}

	private String getDriveLetter() {
		String str = getRealPath(drive.getPath());
		int index = str.indexOf(':');
		if(index != -1) {
			return str.substring(index-1, index+1);
		}
		return "";
	}

	private void prepareCommand(List<String> command, URI config,
			URI activeRoot, URI outputLocation, URI reportFile, URI reportTemplate) {
		String str;
		command.add(PARAM_VERBOSE);
		if(config!=null && activeRoot != null) {
			String str1 = getRealPath(config.getPath());
			String str2 = getRealPath(activeRoot.getPath());
			if(str1!=null&&str1!=null) {
				if(containsWhiteSpace(str1) || containsWhiteSpace(str1)) {
					command.add(PARAM_CONFIG+"\""+str1+";"+str2+"\"");
				} else {
					command.add(PARAM_CONFIG+str1+";"+str2);
				}
			}
		} else {
			if(config!=null) {
				str = getRealPath(config.getPath());
				if(str!=null) {
					if(containsWhiteSpace(str)) {
						command.add(PARAM_CONFIG+"\""+str+"\"");
					} else {
						command.add(PARAM_CONFIG+str);
					}
				}
			}
		}
		if(outputLocation!=null) {
			str = getRealPath(outputLocation.getPath());
			if(str!=null) {
				if(containsWhiteSpace(str)) {
					command.add(PARAM_WORKDIR+"\""+str+"\"");
				} else {
					command.add(PARAM_WORKDIR+str);
				}
			}
		}
		if (reportFile != null) {
			str = getRealPath(reportFile.getPath());
			if (str != null) {
				command.add(PARAM_REPFILE + "\"" + str + "\"");
				if (reportTemplate != null)
					str = getRealPath(reportTemplate.getPath());
				if (str != null) {
					command.add(PARAM_RTMPLFILE + "\"" + str + "\"");
				}
			}

		}
	}

	private boolean containsWhiteSpace(String str) {
		for (int i = 0; i < str.length(); i++) {
			if(Character.isWhitespace(str.charAt(i))) {
				return true;
			}
		}
		return false;
	}

	private String getRealPath(String path) {
		String temp = (path.length() > 1) ? path.substring(1):null;
		if(temp!=null) {
			if(temp.charAt(temp.length()-1)=='/') {
				return temp.substring(0, temp.length()-1);
			}
		}
		return temp;
	}

	private int runCommand(List<String> command, OutputStream outputStream, IProgressMonitor monitor, Map<String, String> environment) throws IOException {
		imakerOutput.clear();
		ProcessBuilder pb = new ProcessBuilder(command);
		pb.directory(new File(drive));
		pb.redirectErrorStream(true);
		if (environment != null) {
			pb.environment().clear();
			pb.environment().putAll(environment);
		}

		pb.environment().put(IMAKER_EXITSHELL, "1");

		Process process = pb.start();
		BufferedReader br = new BufferedReader(new InputStreamReader(process
				.getInputStream()));

		String line;
		while((line = br.readLine()) != null) {
			imakerOutput.add(line);
			if (outputStream!=null) {
				if(monitor!=null) {
					if (monitor.isCanceled()) {
						process.destroy();
						throw new OperationCanceledException();
					} else {
						beginSubTask(monitor,line);
						taskWorked(monitor,line);
					}
				}
				outputStream.write(line.getBytes());
				outputStream.write("\n".getBytes());
			}
		}

		return process.exitValue();
	}

	public String getImakerVerion()  throws IOException {
		List<String> command = new ArrayList<String>();
		try {
			command.add(IMAKER_CMD);
			runCommand(command, null,null, null);
		} catch (IOException e) {
			command.set(0, getDriveLetter()+IMAKER_PATH+"\\"+IMAKER_CMD);
			runCommand(command, null,null, null);
		}
		if(!imakerOutput.isEmpty()) {
			return parseVersion(imakerOutput);
		} else {
			return "No version.";
		}
	}

	private String parseVersion(List<String> list) {
		Pattern comp = Pattern.compile("iMaker\\s*\\d{2}\\.\\d{2}\\.\\d{2}.+");
		for (String line : list) {
			Matcher matcher = comp.matcher(line);
			if(matcher.find()) {
				return line;
			}
		}
		return "No version.";
	}

	public String getVersion() {
		String pluginVersion = (String)Platform
				.getBundle(ImakerCore.PLUGIN_ID).getHeaders().get(
						"Bundle-Version");

		return pluginVersion;
	}
}
