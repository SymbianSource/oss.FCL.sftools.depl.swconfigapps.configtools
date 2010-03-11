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
 * Description: This file is part of com.nokia.tools.variant.editor component.
 */

package com.nokia.tools.variant.editor.cli;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;

import com.nokia.tools.variant.content.confml.Setting;
import com.nokia.tools.variant.content.confml.SimpleSetting;
import com.nokia.tools.variant.editor.cpfInfo.CPFInformation;
import com.nokia.tools.variant.editor.editors.ViewEditorModel;
import com.nokia.tools.variant.editor.utils.CPFManager;
import com.nokia.tools.variant.editor.validation.SettingsValidator;
import com.nokia.tools.variant.viewer.validation.EResult;
import com.nokia.tools.variant.viewer.validation.IResult;
import com.nokia.tools.variant.viewer.validation.ValidationResult;
import com.nokia.tools.vct.cli.ICommandLineHandler;
import com.nokia.tools.vct.cli.StopException;

public class CPFOpenValidationHandler implements ICommandLineHandler {

	public CPFOpenValidationHandler() {
	}

	public void handleCommandLine(CommandLine commandLine, Options options)
			throws StopException {

		boolean processed = false;
		try {
			String[] args = commandLine.getArgs();
			if (args.length < 1) {
				return;
			}
			String cpfFile = args[0];
			URI inputURI = URI.createFileURI(cpfFile);
			if (commandLine.hasOption("/?") || commandLine.hasOption("--help")) {
				// display help and return
				processed = true;
				showHelp();
				return;
			}
			if (commandLine.hasOption("list")) {
				if (args.length == 1) {
					if (commandLine.hasOption("list")) {
						if (!cpfFile.endsWith(".cpf")) {
							System.out.println("Missing CPF file to process");
							System.out
									.println("Follow the example below or run eclipse.exe /? for help:");
							System.out.println("carbide.exe -list phone.cpf");
							processed = true;
							return;
						} else {
							// list configurations from specified CPF file
							List<CPFInformation> infos = CPFManager
									.getCPFConfigurations(inputURI);

							System.out.println("Cpf file " + cpfFile
									+ " contains these configurations:");
							System.out.println();
							System.out.println("Configuration\t\tVersion");
							System.out
									.println("-------------------------------");
							for (int i = 0; i < infos.size(); i++) {
								CPFInformation c = infos.get(i);
								System.out.println(c.getName() + "\t\t"
										+ c.getVersion());
							}
							processed = true;
							return;
						}
					}
				}
			} else if (commandLine.hasOption('v')
					|| commandLine.hasOption("validate")
					|| commandLine.hasOption('s')) {
				if (args.length == 0) {
					System.out.println("Missing cpf file!");
					processed = true;
					throw new StopException(1);
				}
				if (args.length != 1 && args.length != 3) {
					//System.err.println("Parameters for validation: <file name> (<configuration name> <version>)?");
					processed = true;
					showHelp();
					throw new StopException(1);
				}

				if (args.length == 3) {
					if (!args[0].endsWith(".cpf")) {
						System.out.println("Missing CPF file to process");
						System.out
								.println("Follow the example below or run eclipse.exe /? for help:");
						System.out
								.println("carbide.exe blueConfiguration 1.0.0 bluePhone.cpf");
						processed = true;
						return;
					}
				}

				String configName = null;
				String configVersion = null;

				if (args.length == 3) {
					configName = args[1];
					configVersion = args[2];
				}

				try {
					CPFInformation selectedInfo = null;

					List<CPFInformation> infos = CPFManager
							.getCPFConfigurations(inputURI);

					if (args.length == 3) {
						for (int i = 0; i < infos.size(); i++) {
							CPFInformation info = infos.get(i);
							if (info.getName().equalsIgnoreCase(configName)
									&& info.getVersion().equalsIgnoreCase(
											configVersion)) {
								selectedInfo = info;
								break;
							}
						}
						if (selectedInfo != null) {
							ViewEditorModel model = null;
							try {
								model = CPFManager.createModel(inputURI,
										selectedInfo.getRootConfMLPath());

								if (commandLine.hasOption("s")
										|| commandLine.hasOption("--summary")) {
									// display summary of CPF's selected configuration
									CPFInformation ci = model.getCpfMetadata();
									writeSummary(ci);

									System.out.println();
								}

								if (commandLine.hasOption("v")) {
									validateConfiguration(commandLine, model);
								}
							} catch (Throwable t) {
								t.printStackTrace();
								System.out.println("Error: Can not open "
										+ cpfFile + " configuration="
										+ configName + ", version="
										+ configVersion + ".");
								processed = true;
								throw new StopException(1);
							} finally {
								if (model != null) {
									model.dispose();
								}
							}
						} else {
							System.out.println("Configuration=" + configName
									+ " version=" + configVersion
									+ " not found in " + cpfFile + ".");
							processed = true;
							throw new StopException(1);
						}
					}
				} catch (Exception ex) {
					if (ex instanceof StopException) {
						throw new StopException(1);
					} else {
						System.out.println("Error: Can not open CPF file: "
								+ cpfFile);
						processed = true;
						throw new StopException(1);
					}
				}
				processed = true;
				System.out.println(cpfFile + " validation is OK.");
				throw new StopException(0);
			}
		} finally {
			if (!processed) {
				showHelp();
			}
		}
	}

	private void writeSummary(CPFInformation ci) {
		System.out.println("Configuration details:");
		System.out.println("----------------------");
		System.out.println("Name: \t\t" + ci.getName());
		System.out.println("Version: \t" + ci.getVersion());
		System.out.println("Description: \t" + ci.getDescription());
		System.out.println("Owner :\t\t" + ci.getOwner());
		System.out.println("Platform :\t" + ci.getPlatform());
		System.out.println("Product :\t" + ci.getProduct());
		System.out.println("Release :\t" + ci.getRelease());
		System.out.println("Date :\t\t" + ci.getDate());
		String status = "";
		if (ci.getStatus() != null) {
			status = ci.getStatus();
		}
		System.out.println("Status :\t" + status);
	}

	private void validateConfiguration(CommandLine commandLine,
			ViewEditorModel model) throws StopException {
		// Configuration project(s) included, meta information, number of files, features, settings.
		// Amount and list of settings changed from default (in variant layer).
		// Amount and list of validation errors.

		
		int numFiles = model.getVariantContributor().eResource().getResourceSet().getResources().size();

		System.out.println("CPF file contains " + numFiles + " files.");
		System.out.println("Selected configuration contains " + model.getView().getSharedFeatures().size() + " features.");
		System.out.println("Selected configuration contains " + model.getView().getSharedSettingInstances().size() + " settings.");
		
		EList<Setting> settings = model.getView().getSharedSettingInstances();
		List<String> changes = new ArrayList<String>(); 
		int numOfChangedSettingFromDefault = 0;
		for (int i = 0 ; i < settings.size() ; i++) {
			Setting s = settings.get(i);
			if (!s.isVisible()) {
				continue;
			}
			if (!s.isDefault()) {
				changes.add(s.getAbsRef() + "[" + s.getName() + "]");
				numOfChangedSettingFromDefault++;
			}
		}
		System.out.println("Selected configuration contains " + numOfChangedSettingFromDefault + " modified settings from default values.");
		if (commandLine.hasOption("l")) {
			if (changes.size() > 0) {
				System.out.println();
				System.out.println("List of changes from default:");
				System.out.println("-----------------------------");
				for (int i = 0 ; i < changes.size() ; i++) {
					System.out.println(changes.get(i));
				}
				System.out.println();
			}
		}
		
		
		int errorSettings = 0;
		List<String> errors = new ArrayList<String>();
		for (int i = 0 ; i < settings.size() ; i++) {
			Setting s = settings.get(i);
			if (s.isReadOnly()) {
				continue;
			}
			String value = null;
			if (s instanceof SimpleSetting) {
				value = ((SimpleSetting) s).getValue();
			}
			ValidationResult result = SettingsValidator.validateSetting(s, value, model.getResourceModelRoot());
			List<IResult> resultList = result.getResult();
			
			if (!resultList.contains(EResult.VALID)) {
				errors.add(s.getAbsRef() + "[" + s.getName() + "] - " + result.getResult().get(0).getErrorDescription());
				errorSettings++;
			}
		}
		if (commandLine.hasOption("l")) {
			if (errors.size() > 0) {
				System.out.println();
				System.out.println("List of error settings :");
				System.out.println("------------------------");
				for (int i = 0 ; i < errors.size() ; i++) {
					System.out.println(errors.get(i));
				}
				System.out.println();
			}
		}

		
		
		System.out.println("Selected configuration contains " + errorSettings + " setting errors.");
/*		
		if (errorSettings != 0) {
			throw new StopException(1);									
		}
*/		
/*
		If CPF is identified as Valid, the utility must exit with error code 0.
		If there is a problem with the CPF, it must be described in the output and error code should be set to specific non-zero value.
*/
	}

	private void showHelp() {
		System.out.println("CarbideV command line interface help");
		System.out.println("-------------");
		System.out.println("cli.exe \t\trun CarbideV in GUI mode");
		System.out.println("cli.exe <*.cpf> \t\trun CarbideV in GUI mode and opens cpf file");
		System.out.println("cli.exe <--help> \t\tfor help");// 1
		System.out.println("cli.exe </?> \t\t\tfor help");// 1
		System.out.println("cli.exe <-v|-validate> [-s] <*.cpf> <Configuration_name> <Configuration_version>\tvalidates specified configuration. Use -s for configuration summary");//3
		System.out.println("cli.exe <-list> <*.cpf> \tLists all configuration from cpf file");//2
		System.out.println("");
	}

}
