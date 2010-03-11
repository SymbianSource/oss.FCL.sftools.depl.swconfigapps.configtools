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

package com.nokia.tools.variant.editor.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import com.nokia.tools.variant.common.core.utils.FileUtils;
import com.nokia.tools.variant.confml.core.operation.CPFUtil;

/**
 * Class supports unpacking cpf file
 */
public class CpfZipUtil {

	/**
	 * Extracts cpf file defined by given file path
	 * 
	 * @param cpfFileName
	 * @return File
	 */
	public static File extractCPF(String cpfFileName) {
		File temp = null;
		File source = new File(cpfFileName);
		try {
			temp = File.createTempFile("cpf", "_" + source.getName());
			temp.delete();
			temp.mkdir();
			CpfZipUtil.extractZipFile(source, temp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return temp;

	}

	/**
	 * Unzip given source file into temporary file
	 * 
	 * @param source
	 * @param dFile
	 */
	public static void extractZipFile(File source,
			File dFile) {

		ZipInputStream zis = null;
		try {
			zis = CPFUtil.openCPFStream(source);
			
			for (ZipEntry zipEntry; (zipEntry = zis.getNextEntry())!= null; ){
				if (zipEntry.isDirectory()) {
					continue;
				}
				
				File file = new File(dFile, zipEntry.getName());
				File parent = file.getParentFile();
				parent.mkdirs();
				FileOutputStream fos = new FileOutputStream(file);
				FileUtils.copyStream(zis, fos);
				FileUtils.closeStream(fos);
			}

		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			FileUtils.closeStream(zis);
		}

	}

}
