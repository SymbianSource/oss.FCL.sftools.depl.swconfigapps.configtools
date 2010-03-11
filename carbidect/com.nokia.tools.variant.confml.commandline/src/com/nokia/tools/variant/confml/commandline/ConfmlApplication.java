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
 * Description: This file is part of com.nokia.tools.variant.confml.commandline component.
 */

package com.nokia.tools.variant.confml.commandline;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;

import com.nokia.tools.variant.confml.core.ConfMLCore;
import com.nokia.tools.variant.confml.core.operation.ExportCPFRunnable;
import com.nokia.tools.variant.confml.core.operation.ImportConfMLFileRunnable;
import com.nokia.tools.variant.confml.core.operation.NewLayerOperation;

public class ConfmlApplication implements IApplication {
	private String separator = System.getProperty("line.separator");
	final private String DOUBLETAB = "\t\t";
	final private String SINGLETAB = "\t";

	@SuppressWarnings("unchecked")
	public Object start(IApplicationContext context) throws Exception {

		print("\n-->> VCT toolkit started <<--");

		Map args = context.getArguments();

		Object object = args.get(args.keySet().toArray()[0]);
		if (object instanceof String[]) {
			String[] s = (String[]) object;
			if (s.length > 0) {
				String string = s[0];
				if (string.equalsIgnoreCase("help")) {
					handleHelp(s);
				}

				else if (string.equalsIgnoreCase("export")) {
					handleExport(s);
				} else if (string.equalsIgnoreCase("project")) {
					handleProject(s);
				} else if (string.equalsIgnoreCase("validate")) {
					handleValidation(s);

				} else if (string.equalsIgnoreCase("importconfml")) {
					importConfml(s);

				} else if (string.equalsIgnoreCase("deleteworkspace")) {
					deleteWorkspace();

				} else if (string.equalsIgnoreCase("report")) {
					handleReport(s);

				} else {
					print("Command \"" + string + "\" was not recognized");
					this.handleHelp(new String[1]);
				}

			}
		}

		print("\n-->> VCT toolkit ended <<--");
		return EXIT_OK;
	}

	private void deleteWorkspace() {
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot()
				.getProjects();

		if (projects.length != 0) {
			try {
				for (int i = 0; i < projects.length; i++) {
					if (projects[i].exists()) {
						projects[i].refreshLocal(IProject.DEPTH_INFINITE,
								new NullProgressMonitor());
						projects[i].delete(true, true,
								new NullProgressMonitor());

					}
				}
				print("Workspace is clean");
			} catch (CoreException e) {
				e.printStackTrace();
			}
		} else
			print("Workspace is clean");
	}

	private void importConfml(String[] s) {
		boolean importDirectory = false;
		String source = null;
		String targetPath = null;
		boolean fixXInclude = false;
		boolean prettyPrint = false;
		for (int i = 0; i < s.length; i++) {
			String parameter = s[i];
			if (i + 1 < s.length) {
				if (parameter.equalsIgnoreCase("-source")) {
					source = s[i + 1];

				}
				if (parameter.equalsIgnoreCase("-targetpath")) {
					targetPath = s[i + 1];

				}
				if (parameter.equalsIgnoreCase("-fixXInclude")) {

					fixXInclude = Boolean.parseBoolean(s[i + 1]);

				}
				if (parameter.equalsIgnoreCase("-prettyprint")) {

					prettyPrint = Boolean.parseBoolean(s[i + 1]);

				}

			}
		}
		if (targetPath == null) {
			System.out.println("Parameter -targetpath required");
			return;
		}
		if (!exists(targetPath)) {
			System.out
					.println("Destination \"" + targetPath + "\" does not exist");
			return;
		}
		if (source == null) {
			System.out.println("Parameter -source required");
			return;
		}
		File file = new File(source);
		if (!file.exists()) {
			System.out.println("Source file does not exist");
			return;
		}
		if (file.isDirectory()) {
			importDirectory = true;
		}

		IFolder folder = ResourcesPlugin.getWorkspace().getRoot().getFolder(new Path(targetPath));
		
		ImportConfMLFileRunnable fileRunnable = new ImportConfMLFileRunnable(
				importDirectory, file, folder, fixXInclude,
				prettyPrint, ConfMLCore.PLUGIN_ID);
		try {
			fileRunnable.run(new NullProgressMonitor());

			print((importDirectory ? "Files in directory" : "File") + " \""
					+ source + "\" has been imported into \"" + targetPath
					+ "\" project");
		} catch (CoreException e) {

			e.printStackTrace();
		}

	}

	private void handleValidation(String[] s) {

		String uri = null;
		String projectName = null;
		for (int i = 0; i < s.length; i++) {
			String parameter = s[i];
			if (i + 1 < s.length) {
				if (parameter.equalsIgnoreCase("-file")) {
					uri = s[i + 1];

				}
				if (parameter.equalsIgnoreCase("-projectname")) {
					projectName = s[i + 1];

				}
			}

		}

		File file = null;
		if (uri != null) {
			file = new File(uri);
		}

		if (projectName != null) {
			IProject project = ResourcesPlugin.getWorkspace().getRoot()
					.getProject(projectName);
			if (project != null && project.exists()) {
				validateProject(project, file);
				if (file != null) {
					print("Validation result stored into \"" + uri + "\" file");
				}
			} else {
				print("Project \"" + projectName
						+ "\" does not exist in the given workspace");
			}
		} else {
			validateAllProjects(file);
		}
	}

	private void validateAllProjects(File file) {
		print("Validating all projects in specified workspace");
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot()
				.getProjects();
		for (IProject project : projects) {
			validateProject(project, file);

		}

	}

	private void validateProject(IProject project, File file) {
		// IMPROVEMENT The validation is broken 
/*
		try {
			ConfMLBuilder builder = new ConfMLBuilder();
			EVariantProject projectModel = ConfMLCore.getProjectModel(project,
					new NullProgressMonitor());
			ValidationResult doConfmlBuild = builder.doConfmlBuild(
					new NullProgressMonitor(), new ValidationContext(project,
							projectModel, null));
			List<ValidationMessage> messages = doConfmlBuild.getMessages();
			if (file == null) {
				for (ValidationMessage validationMessage : messages) {

					System.out.println(validationMessage.getMessage());

				}
			} else {
				FileWriter writer = null;
				try {
					writer = new FileWriter(file);
				} catch (IOException e) {

					e.printStackTrace();
				}
				for (ValidationMessage validationMessage : messages) {

					writer.write(validationMessage.getMessage() + separator);

				}
				writer.flush();
				writer.close();
			}

		} catch (CoreException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
*/
	}

	private void handleHelp(String[] s) {
		if (s.length == 1) {
			System.out
					.println("For more information on a specific command type HELP command-name");
			System.out.println("PROJECT" + " " + "Creates new confml layer");
			System.out.println("EXPORT" + "  " + "Exports cpf file");
			System.out.println("IMPORTCONFML" + "  "
					+ "Imports confml file(s) to the given project");
			System.out.println("DELETEWORKSPACE" + " "
					+ "Deletes all workspace files except metadata");
			System.out.println("VALIDATE" + " "
					+ "Validates confml files and projects");
			System.out.println("REPORT" + "  "
					+ "Creates report from chosen cpf");
		} else {
			if (s[1].equalsIgnoreCase("project")) {
				System.out.println("Creates new confml layer");
				System.out
						.println("Parameters: -projectname newProject -id layerID -version layerVersion -name layerName [-uri uri] "
								+ "[-provider provider] [-confmlpath confml] [-implmlpath implml] [-contentpath content]");
				print("");
				print("-uri" + DOUBLETAB + "Specifies URI");
				print("-projectname" + SINGLETAB
						+ "Name of project in workspace");
				print("-id" + DOUBLETAB + "ID of layer");
				print("-version"
						+ SINGLETAB
						+ "Version of the layer with the same ID in form of d.d.d where 'd' is decimal number");
				print("-name" + DOUBLETAB + "Name of the layer");
				print("-provider" + SINGLETAB + "Provider");
				print("-confmlpath" + SINGLETAB
						+ "Name of directory where confmls will be stored");
				print("-implmlpath" + SINGLETAB
						+ "Name of directory where implmls will be stored");
				print("-contentpath"
						+ SINGLETAB
						+ "Name of directory where other contents will be stored");
				print("");
				print("Example: project -projectname nameOfProject -id layerID -version 1.1.2 -name layerName");
			}
			if (s[1].equalsIgnoreCase("export")) {
				System.out.println("Exports cpf file");
				System.out
						.println("Parameters: -outputfile fileURI -projectname exportedProject -viewid viewID -cpfname nameOfCPF "
								+ "-exported layer [layer ...] [-encrypted {true|false}] [-description text]");
				print("");
				print("-outputfile" + SINGLETAB
						+ "Location and name of output file");
				print("-projectname" + SINGLETAB
						+ "Name of project in workspace");
				print("-viewid" + DOUBLETAB
						+ "ID of view that will be exported with CPF");
				print("-cpfname" + SINGLETAB + "Name of the CPF");
				print("-exported" + SINGLETAB
						+ "List of parent layers exported with CPF");
				print("-encrypted"
						+ SINGLETAB
						+ "Specifies whether to encrypt cpf. True or false are the only values. CPF is not encrypted by default");
				print("-description" + SINGLETAB
						+ "Text provided as description of CPF");
				print("-exportall" + SINGLETAB
						+ "Text provided as description of CPF");

				print("");
				print("Example: export -outputfile fileURI -projectname exportedProject -viewid viewID -cpfname nameOfCPF");

			}
			if (s[1].equalsIgnoreCase("IMPORTCONFML")) {
				System.out
						.println("Imports confml file(s) to the given project");
				System.out
						.println("Parameters: -source URI -projectname exportedProject [-removeXInclude {true|false}] "
								+ "[-skipemptycontent {true|false}] [-prettyprint {true|false}]");
				print("");
				print("-source"
						+ DOUBLETAB
						+ "Location and name of input file or folder with files");
				print("-projectname" + SINGLETAB
						+ "Name of project in workspace");
				print("-removeXInclude" + SINGLETAB
						+ "Whether to keep XInclude elements or not");
				print("-skipemptycontent" + SINGLETAB
						+ "Whether to remove whitespaces");
				print("-prettyprint" + SINGLETAB
						+ "Whether to reformat confml file(s)");
				print("");
				print("Example: importconfml -source URI -projectname exportedProject -skipemptycontent true");
			}
			if (s[1].equalsIgnoreCase("VALIDATE")) {
				System.out.println("Validates confml files and projects");
				System.out
						.println("Parameters: -projectname validatedProject [-file fileURI]");
				print("");
				print("-projectname" + SINGLETAB
						+ "Name of project in workspace");
				print("-file"
						+ DOUBLETAB
						+ "Location and name of output file with validation results");
				print("");
				print("Example: validate -projectname validatedProject -file C:\\validationResults.log");
			}
			if (s[1].equalsIgnoreCase("REPORT")) {
				System.out.println("Generates report from given cpf file.");
				System.out
						.println("Parameters: -file cpfFileName -contains {all|nondefault|withnotes|cvc|text keyword} [-grouping] [-description] [-open] [-targetfile pathToReportfile]");
				print("");
				print("-file"
						+ DOUBLETAB
						+ "Specifies the cpf file, from which the report will be created");
				print("-contains" + SINGLETAB
						+ "Defines, what settings will be reported. Options:");
				print(DOUBLETAB + "all" + DOUBLETAB + "all settings");
				print(DOUBLETAB + "nondefault" + SINGLETAB
						+ "only settings with non default value");
				print(DOUBLETAB + "withnotes" + SINGLETAB
						+ "only settings with notes");
				print(DOUBLETAB + "cvc" + DOUBLETAB
						+ "only supplementary settings (CVC)");
				print(DOUBLETAB + "text" + DOUBLETAB
						+ "only settings which contains the specified "
						+ SINGLETAB + "keyword in their name");
				print("-grouping" + SINGLETAB + "show grouping of settings");
				print("-description" + SINGLETAB
						+ "show description column in report table");
				print("-open" + DOUBLETAB
						+ "open report directly in the default browser");
				print("-targetfile"
						+ SINGLETAB
						+ "the absolute path, where the report should be created. If not specified, the report file will be created in your Documents folder with Untitled[Number].html name");
				print("");
				print("Examples:");
				print("report -file samplecpf.cpf -contains all -grouping -open");
				print("report -file mycpf.cpf -contains withnotes -description -targetfile c:\\myFolder\\report1.htm");
				print("report -file somecpf.cpf -contains text upload -grouping -description -open -targetfile c:\\workspace\\lastReport.htm");
			} else {
				print("Toolkit does not support command \"" + s[1] + "\"");
			}
		}

	}

	private void handleProject(String[] s) throws CoreException {
		String uri = null;
		String projectName = null;
		String id = null;
		String version = null;
		String name = null;
		String provider = null;
		String confmlPath = null;
		String implmlPath = null;
		String contentPath = null;
		String notesPath = null;
		for (int i = 0; i < s.length; i++) {
			String parameter = s[i];
			if (i + 1 < s.length) {
				if (parameter.equalsIgnoreCase("-uri")) {
					uri = s[i + 1];

				}
				if (parameter.equalsIgnoreCase("-projectname")) {
					projectName = s[i + 1];

				}
				if (parameter.equalsIgnoreCase("-id")) {
					id = s[i + 1];

				}
				if (parameter.equalsIgnoreCase("-version")) {
					version = s[i + 1];

				}
				if (parameter.equalsIgnoreCase("-name")) {
					name = s[i + 1];

				}
				if (parameter.equalsIgnoreCase("-provider")) {
					provider = s[i + 1];

				}

				if (parameter.equalsIgnoreCase("-confmlpath")) {
					confmlPath = s[i + 1];

				}
				if (parameter.equalsIgnoreCase("-implmlpath")) {
					implmlPath = s[i + 1];

				}
				if (parameter.equalsIgnoreCase("-notespath")) {
					notesPath = s[i + 1];

				}
				if (parameter.equalsIgnoreCase("-contentpath")) {
					contentPath = s[i + 1];

				}

			}
		}

		if (projectName == null) {
			System.out.println("Parameter -projectname required");
			return;
		}
		if (id == null) {
			System.out.println("Parameter -id required");
			return;
		}
		if (version == null) {
			System.out.println("Parameter -version required");
			return;
		}
		NewLayerOperation operation = new NewLayerOperation(projectName, id,
				version);

		if (uri != null) {
			try {
				java.net.URI locationUri = java.net.URI.create(uri);
				operation.setLocationURI(locationUri);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			}
		}
		String validate = validate(confmlPath, implmlPath, contentPath,
				notesPath);
		if (validate != null) {
			System.out.println(validate);
			return;
		}
		if (confmlPath != null) {
			operation.setConfmlPath(confmlPath);

		}
		if (implmlPath != null) {
			operation.setImplmlPath(implmlPath);
		}
		if (contentPath != null) {
			operation.setContentPath(implmlPath);
		}
		if (notesPath != null) {
			operation.setNotesPath(notesPath);
		}
		operation.setName(name);
		operation.setProvider(provider);
		operation.run(new NullProgressMonitor());
		print("Project \"" + projectName
				+ "\" has been created in the given workspace");
	}

	private void handleReport(String[] s) {
		String containing = null;
		String cpfFileName = null;
		String targetFileName = null;
		boolean grouping = false;
		boolean description = false;
		boolean open = false;
		for (int i = 0; i < s.length; i++) {
			String parameter = s[i];
			if (i + 1 < s.length) {
				if (parameter.equalsIgnoreCase("-file")) {
					cpfFileName = s[i + 1];
					if (cpfFileName != null && !cpfFileName.equals("")) {

					}
				}
				if (parameter.equalsIgnoreCase("-containing")) {
					containing = s[i + 1];
					if (containing != null && !containing.equals("")) {

					}
				}
				if (parameter.equalsIgnoreCase("-grouping")) {
					grouping = true;
				}
				if (parameter.equalsIgnoreCase("-description")) {
					description = true;
				}
				if (parameter.equalsIgnoreCase("-open")) {
					open = true;
				}
				if (parameter.equalsIgnoreCase("-targetfile")) {
					targetFileName = s[i + 1];
					if (targetFileName != null && !targetFileName.equals("")) {

					}
				}
			}
		}
	}

	private void handleExport(String[] s) throws CoreException {

		// List<String> exported = new ArrayList<String>();
		String outputFile = null;
		String projectName = null;
		boolean encrypt = false;
		boolean sign = false;
		String cpfName = null;

		for (int i = 0; i < s.length; i++) {
			String parameter = s[i];
			if (i + 1 < s.length) {
				if (parameter.equalsIgnoreCase("-outputfile")) {
					outputFile = s[i + 1];

				}
				if (parameter.equalsIgnoreCase("-projectname")) {
					projectName = s[i + 1];

				}
				if (parameter.equalsIgnoreCase("-encrypt")) {
					encrypt = s[i + 1].equalsIgnoreCase("true");
				}
				if (parameter.equalsIgnoreCase("-sign")) {
					sign = s[i + 1].equalsIgnoreCase("true");
				}
				if (parameter.equalsIgnoreCase("-cpfname")) {
					cpfName = s[i + 1];
				}
			}
		}
		if (outputFile == null) {
			System.out.println("Parameter -outputfile required");
			return;
		}
		if (projectName == null) {
			System.out.println("Parameter -projectname required");
			return;
		}
		if (!exists(projectName)) {
			System.out
					.println("Project \"" + projectName + "\" does not exist");
			return;
		}
		if (cpfName == null) {
			System.out.println("Parameter -cpfname required");
			return;
		}

		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
		File file = new File(outputFile);
		
		ExportCPFRunnable runnable = new ExportCPFRunnable(
				file, project, encrypt, sign);
		runnable.run(new NullProgressMonitor());
		print("Project \"" + projectName + "\" has been exported as \""
				+ outputFile + "\"");
	}

	private boolean isValidPath(String path) {
		if (path == null) {
			return true;
		}
		String value = path.trim();
		return new Path("").isValidSegment(value);
	}

	private boolean exists(String targetPath) {
		IPath path = new Path(targetPath);
		IFolder folder = ResourcesPlugin.getWorkspace().getRoot()
		.getFolder(path);
		
		return folder.isAccessible();
	}

	public void stop() {

	}

	private void print(String message) {
		System.out.println(message);
	}

	public String validate(String confmlPath, String implmlPath,
			String contentPath, String notesPath) {
		Map<String, String> locations = new HashMap<String, String>();

		if (!isValidPath(confmlPath)) {
			return ("Confml Location: The specified value must have single path segment");

		}
		if (confmlPath != null) {
			locations.put(confmlPath, "Confml");
		}
		if (!isValidPath(implmlPath)) {
			return ("Implml Location: The specified value must have single path segment");

		}
		if (locations.containsKey(implmlPath)) {
			return ("Implml Location: The paths must be different");

		}
		if (implmlPath != null) {
			locations.put(implmlPath, "Implml");
		}

		if (!isValidPath(contentPath)) {
			return ("Content Location: The specified value must have single path segment");

		}

		if (locations.containsKey(contentPath)) {
			return ("Content Location: The paths must be different");

		}
		if (contentPath != null) {
			locations.put(contentPath, "Content");
		}
		if (!isValidPath(notesPath)) {
			return ("Metadata Location: The specified value must have single path segment");
		}
		if (locations.containsKey(notesPath)) {
			return ("Metadata Location: The paths must be different");

		}

		return null;
	}
}
