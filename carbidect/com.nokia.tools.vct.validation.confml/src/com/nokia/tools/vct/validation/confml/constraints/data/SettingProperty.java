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
package com.nokia.tools.vct.validation.confml.constraints.data;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.content.IContentDescription;
import org.eclipse.core.runtime.content.IContentType;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;

import com.nokia.tools.s60ct.build.builder.CrmlBuilder;
import com.nokia.tools.s60ct.resources.model.ELibraryElement;
import com.nokia.tools.s60ct.resources.model.ELibraryFile;
import com.nokia.tools.s60ct.resources.model.ELibraryRoot;
import com.nokia.tools.s60ct.resources.resources.ResourceUtil;
import com.nokia.tools.vct.common.appmodel.EAppProperty;
import com.nokia.tools.vct.common.appmodel.EAppResourceType;
import com.nokia.tools.vct.common.appmodel.EAppSettingType;
import com.nokia.tools.vct.common.appmodel.EAppSimpleType;
import com.nokia.tools.vct.common.appmodel.EConfMLLayer;
import com.nokia.tools.vct.common.core.utils.FileUtils;
import com.nokia.tools.vct.confml.model.confml1.ESettingData;
import com.nokia.tools.vct.validation.confml.constraints.ConfMLUtils;

public class SettingProperty extends AbstractModelConstraint {

	private static final String DEFAULT_SIZE_UNIT = "kB";
	private static final String FILE_TYPE_SEPARATOR = "/";

	
	public SettingProperty() {

	}

	@Override
	public IStatus validate(IValidationContext ctx) {

		String value = null;
		String typePath = null;
		EAppSimpleType appSimpleType = null;
		
		if (ctx.getTarget() instanceof ESettingData) {
			ESettingData settingData = (ESettingData) ctx.getTarget();
			StringBuilder tmp = new StringBuilder();
			EAppSettingType ptr = ConfMLUtils.findType(settingData, tmp);
			typePath = tmp.toString();
			if (ptr!=null)
				return validateProperty(ctx, typePath, ptr);
		}
		else if (ctx.getTarget() instanceof com.nokia.tools.vct.confml.model.confml2.ESettingData)
		{
			com.nokia.tools.vct.confml.model.confml2.ESettingData settingData = (com.nokia.tools.vct.confml.model.confml2.ESettingData) ctx.getTarget();
			StringBuilder tmp = new StringBuilder();
			EAppSettingType ptr = ConfMLUtils.findType(settingData, tmp);
			typePath = tmp.toString();
			if (ptr!=null)
				return validateProperty(ctx, typePath, ptr);
		}
		return ctx.createSuccessStatus();
}



private IStatus validateProperty(IValidationContext ctx, String typePath, EAppSettingType settingType)
{

	EList<EAppProperty> properties =  settingType.getProperties();
	
	if (properties==null || properties.size()==0)
		return ctx.createSuccessStatus();
	
	EConfMLLayer layer = (EConfMLLayer)ConfMLUtils.getLastLayer(settingType);
	
	if (settingType instanceof EAppResourceType)
	{
		EAppResourceType resType = (EAppResourceType)settingType;
		if (resType.isFile())
		{
			EAppSimpleType lPath = (EAppSimpleType)resType.getLocalPath();
			String value = ConfMLUtils.getCorrectValue(lPath);
			if (value != null && !value.trim().equals(""))
			{
				File file = new File(value);
				for (EAppProperty property : properties)
				{
					IStatus status =  validateFileProperty(ctx, file, property);
					if (status!=null)
						return status;
				}
			}
//			EAppSimpleType tPath = (EAppSimpleType)resType.getTargetPath();
//			value = ConfMLUtils.getCorrectValue(tPath);
//			if (value != null && !value.trim().equals(""))
//			{
//				File file = new File(value);
//				for (EAppProperty property : properties)
//				{
//					IStatus status =  validateFileProperty(ctx, file, property);
//					if (status!=null)
//						return status;
//				}
//			}
		}
	}
	return ctx.createSuccessStatus();
}

private IStatus validateFileProperty(IValidationContext ctx, File file,	EAppProperty property)
{
	
	ELibraryRoot root = CrmlBuilder.getResourceModelRoot();
	
	IContentDescription contentDescription = getContentDescription(file, root);
	
	IContentType baseType = null;
	if (contentDescription != null) {
		baseType = contentDescription.getContentType().getBaseType();
	}
	
	String propertyName = property.getName();
	String value = property.getValue();
	ELibraryElement fileSystemElement = ResourceUtil.getFileSystemElement(
			root, file.getPath());

	if (propertyName == null) {
		return null;
	}

	if (propertyName.compareTo(FileProperty.TYPE_PROPERTY) == 0) { // validate
		// type
		String fileName = file.getName();
		String fileExtension = FileUtils.getExtension(fileName);
		if (!isValidExtension(fileExtension, property)) {
			
			return ctx.createFailureStatus("Incorrect file extension. "+ fileExtension + " instead of "+ value);
		}

	} else if (propertyName.equals(FileProperty.MAX_BITS_PROPERTY)) {// validate
		// maximum number of units per pixel

		if (isBaseTypeValid(baseType, FileProperty.CT_IMAGE)) {
			String depth = contentDescription.getProperty(
					FileProperty.COLOR_DEPTH).toString();

			if (Integer.valueOf(depth) > Integer.valueOf(value)) {
				
				return ctx.createFailureStatus("Maximum number of units is exceeded. "+ depth + " bits > " + value+ " bits");
			}
		} else {
			return notApplicable(ctx, FileProperty.MAX_BITS_PROPERTY);
		}
	} else if (propertyName.equals(FileProperty.MAX_WIDTH_PROPERTY)) { // validate
		// maximum width of graphic in units

		if (isBaseTypeValid(baseType, FileProperty.CT_IMAGE)) {
			String width = contentDescription.getProperty(
					FileProperty.VIDEO_WIDTH).toString();

			if (Integer.valueOf(width) > Integer.valueOf(value)) {
				
				return ctx.createFailureStatus("Maximum width is exceeded. "+ width + " pixel > " + value+ " pixel");
			}
		} else {
			return notApplicable(ctx, FileProperty.MAX_WIDTH_PROPERTY);
		}
	} else if (propertyName.equals(FileProperty.MAX_HEIGHT_PROPERTY)) { // validate
		// maximum height of graphic in units

		if (isBaseTypeValid(baseType, FileProperty.CT_IMAGE)) {
			String height = contentDescription.getProperty(
					FileProperty.VIDEO_HEIGHT).toString();

			if (Integer.valueOf(height) > Integer.valueOf(value)) {
				
				return ctx.createFailureStatus("Maximum height is exceeded. "+ height + " pixel > " + value	+ " pixel");
			}
		} else {
			return notApplicable(ctx, FileProperty.MAX_HEIGHT_PROPERTY);
		}
	} else if (propertyName.equals(FileProperty.MIN_WIDTH_PROPERTY)) { // validate
		// minimum width of graphic in units

		if (isBaseTypeValid(baseType, FileProperty.CT_IMAGE)) {
			String width = contentDescription.getProperty(
					FileProperty.VIDEO_WIDTH).toString();

			if (Integer.valueOf(width) < Integer.valueOf(value)) {
				return ctx.createFailureStatus("Minimum width is not reached. "+ width + " pixel < " + value+ " pixel");
			}
		} else {
			return notApplicable(ctx, FileProperty.MIN_WIDTH_PROPERTY);
		}
	} else if (propertyName.equals(FileProperty.MIN_HEIGHT_PROPERTY)) { // validate
		// minimum height of graphic in units

		if (isBaseTypeValid(baseType, FileProperty.CT_IMAGE)) {

			String height = contentDescription.getProperty(
					FileProperty.VIDEO_HEIGHT).toString();

			if (Integer.valueOf(height) < Integer.valueOf(value)) {
				return ctx.createFailureStatus("Minimum height is not reached. "+ height + " pixel < " + value + " pixel");
			}
		} else {
			return notApplicable(ctx, FileProperty.MIN_HEIGHT_PROPERTY);
		}
	} else if (propertyName.equals(FileProperty.WIDTH_PROPERTY)) { // validate
		// width

		if (isBaseTypeValid(baseType, FileProperty.CT_IMAGE)) {
			String width = contentDescription.getProperty(
					FileProperty.VIDEO_WIDTH).toString();

			if (!Integer.valueOf(width).equals(Integer.valueOf(value))) {
				return ctx.createFailureStatus("Width does not match. "+ width + " pixel != " + value + " pixel");
			}
		} else {
			return notApplicable(ctx, FileProperty.WIDTH_PROPERTY);
		}
	} else if (propertyName.equals(FileProperty.HEIGHT_PROPERTY)) { // validate
		// height

		if (isBaseTypeValid(baseType, FileProperty.CT_IMAGE)) {

			String height = contentDescription.getProperty(
					FileProperty.VIDEO_HEIGHT).toString();

			if (!Integer.valueOf(height).equals(Integer.valueOf(value))) {
				return ctx.createFailureStatus("Height does not match. "+ height + " pixel != " + value	+ " pixel");
			}
		} else {
			return notApplicable(ctx, FileProperty.HEIGHT_PROPERTY);
		}
	} else if (propertyName.equals(FileProperty.MAX_COLOR_PROPERTY)) { // validate
		// maximum number of distinct color values
		if (baseType != null) {
			if (isBaseTypeValid(baseType, FileProperty.CT_IMAGE)) {
				String filePath = root.getTempDirPath() + File.separator
						+ file.getPath();

				ImageData[] load = new ImageLoader().load(filePath);

				final Set<Integer> distinctColors = new HashSet<Integer>();

				for (ImageData imageData : load) {
					for (int x = 0; x < imageData.width; x++) {
						for (int y = 0; y < imageData.height; y++) {
							int pixel = imageData.getPixel(x, y);
							distinctColors.add(pixel);
						}
					}
				}
				int color = distinctColors.size();

				if (color > Integer.valueOf(value)) {
					return ctx.createFailureStatus("Maximum number of distinct color values is exceeded. "+ color + " > " + value);
				}

			} else {
				return notApplicable(ctx, FileProperty.MAX_COLOR_PROPERTY);
			}
		}
	}

	if (fileSystemElement instanceof ELibraryFile) {
		ELibraryFile fileToValidate = (ELibraryFile)

		fileSystemElement;

		if (propertyName.compareTo(FileProperty.MAX_FILE_SIZE_PROPERTY) == 0) {

			if (DEFAULT_SIZE_UNIT.equals(property.getUnit())) {
				if (getSize(fileToValidate, DEFAULT_SIZE_UNIT) > new Long(property.getValue())) {
					return ctx.createFailureStatus("Max size is exceeded. "+getSize(fileToValidate,DEFAULT_SIZE_UNIT)
							+ " kB > " + value + " kB");
				}
			} else if (property.getUnit().equals("MB")) {
				if (getSize(fileToValidate, "MB") > new Long(property.getValue())) {
					return ctx.createFailureStatus("Max size is exceeded. "+getSize(fileToValidate,
					"MB")+ " MB > " + value + " MB");
				}
			}
		} else if (propertyName
				.compareTo(FileProperty.RECOMMENDED_FILE_SIZE_PROPERTY) == 0) {
			if (DEFAULT_SIZE_UNIT.equals(property.getUnit())) {
				if (getSize(fileToValidate, DEFAULT_SIZE_UNIT) > new Long(property.getValue())) {
					return ctx.createFailureStatus("Recommended size is exceeded. "+getSize(fileToValidate,
							DEFAULT_SIZE_UNIT)+ " kB > " + value + " kB");
				}
			} else if (property.getUnit().equals("MB")) {
				if (getSize(fileToValidate, "MB") > new Long(property.getValue())) {
					return ctx.createFailureStatus("Recommended size is exceeded. "+getSize(fileToValidate,
					"MB")+ " MB > " + value + " MB");
				}
			}
		}
	}
	return null;
}

private static IStatus notApplicable(IValidationContext ctx, String property) {
//	IStatus result = new Result();
//	result.constructMessage(Result.CONSTRAINT, property,
//			Result.NOT_APPLICABLE);
//	return result;
	
	return ctx.createFailureStatus("Setting constraint "+property+" is not applicable.");
}



private static boolean isBaseTypeValid(IContentType baseType,
		IContentType iContentType) {

	if (baseType != null) {
		if (FileProperty.CT_IMAGE.equals(baseType)) {
			return true;
		}
	}
	return false;
}

private static boolean isValidExtension(String fileExtension, EAppProperty property) {
	
	if (fileExtension == null) {
		return false;
	}

	List<String> supportedFileTypes = supportedFileTypes(property
			.getValue());
	if (supportedFileTypes.contains(fileExtension.toLowerCase()))
		return true;
	return false;
}

private static List<String> supportedFileTypes(
		String spaceSeparatedFileTypes) {
	List<String> extensions = new ArrayList<String>();
	String[] fileTypes = spaceSeparatedFileTypes.split(" ");
	for (String fileType : fileTypes) {
		if (fileType.contains(FILE_TYPE_SEPARATOR)) {
			extensions.add(extractFileType(fileType).toLowerCase());
		}
	}
	return extensions;
}

private static String extractFileType(String fileType) {
	return fileType.substring(indexOfFileType(fileType));
}

private static int indexOfFileType(String fileType) {
	return fileType.indexOf(FILE_TYPE_SEPARATOR) + 1;
}

private static float getSize(ELibraryFile fileToValidate,String unit) {

	if (unit.equals(DEFAULT_SIZE_UNIT)) {
		return fileToValidate.getSize() / (float) 1024;
	} else if (unit.equals("MB")) {
		return fileToValidate.getSize() / (float) 1024 * 1024;
	}
	return fileToValidate.getSize();
}

private static IContentDescription getContentDescription(File file,	ELibraryRoot root) {

	ELibraryElement fileSystemElement = ResourceUtil.getFileSystemElement(
			root, file.getPath());

	if (fileSystemElement instanceof ELibraryFile) {
		ELibraryFile file2 = (ELibraryFile)fileSystemElement;
		return file2.getContentDescription();
	}
	return null;
}

}