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
package com.nokia.tools.s60ct.report.generator;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;

import com.nokia.tools.s60ct.report.ReportPlugin;
import com.nokia.tools.variant.confml.core.ConfMLCore;
import com.nokia.tools.vct.common.appmodel.EAppFeature;
import com.nokia.tools.vct.common.appmodel.EAppResourceData;
import com.nokia.tools.vct.common.appmodel.EAppResourceType;
import com.nokia.tools.vct.common.appmodel.EAppSequenceData;
import com.nokia.tools.vct.common.appmodel.EAppSequenceType;
import com.nokia.tools.vct.common.appmodel.EAppSetting;
import com.nokia.tools.vct.common.appmodel.EAppSettingData;
import com.nokia.tools.vct.common.appmodel.EAppSettingOption;
import com.nokia.tools.vct.common.appmodel.EAppSettingType;
import com.nokia.tools.vct.common.appmodel.EAppSimpleData;
import com.nokia.tools.vct.common.appmodel.EAppSimpleType;
import com.nokia.tools.vct.common.appmodel.EConfMLLayer;
import com.nokia.tools.vct.common.appmodel.EConfigurationProject;

/**
 * Class generates CPF report according to given settings.
 * 
 */
public class ReportGenerator {

	/**
	 * All settings will be added to report.
	 */
	public static int ALL = 1;
	/**
	 * Only settings with different value then default will be added to report.
	 */
	public static int NON_DEFAULT = 2;
	/**
	 * Only settings containing given text in name will be added to report.
	 */
	public static int TEXT_FILTER = 4;
	/**
	 * Only settings containing notes will be added to report.
	 */
	public static int WITH_NOTES = 8;
	/**
	 * Create report with groups separation.
	 */
	public static int BY_GROUP = 16;
	/**
	 * Include settings description to report.
	 */
	public static int DESCRIPTION = 32;
	/**
	 * Open file when report is generated.
	 */
	public static int OPEN = 64;
	/**
	 * Generate report in table/text format
	 */
	public static int TO_TABLE = 128;

	/**
	 * Generate report in table/text format
	 */
	public static int WITH_ERRORS = 256;

	/**
	 * Generated page.
	 */
	private StringBuilder content;

	/**
	 * Word used for setting filtering.
	 */
	private String keyword;

	final int NAME = 1;

	final int VALUE = 2;

	final int DEFAULT = 3;

	final int NOTE = 4;

	final int DESC = 5;

	final int NAME_COLSPAN = 1;

	final int CURRENT_VALUE_COLSPAN = 1;

	final int DESCRIPTION_COLSPAN = 1;

	final int ERRORS_COLSPAN = 1;

	final int DEFAULT_COLSPAN = 1;

	final int COLUMN_COUNTS = NAME_COLSPAN + CURRENT_VALUE_COLSPAN + DESCRIPTION_COLSPAN + ERRORS_COLSPAN + DEFAULT_COLSPAN;

	private final String defaultNotSet = "Default value is not set.";

	ReportStringUtilities reportStringUtilities = null;
	EList<Error> errors = null;
	// *********** ML *************
	//	CPFEditor editor = null;

	int filter = 0;
	private int parentCount = 1;
	private int leafCount = 1;
	private int featCount = 1;
	private int settCount = 1;
	private int subsettCount = 1;
	//private View view;
	EConfMLLayer layer = null;

	private IMarker[] markers = null;
	
	public ReportGenerator() {
		System.out.println("Created ReportGenerator!");//ML
		reportStringUtilities = new ReportStringUtilities();
	}

	/**
	 * Method generates report, looking for parent groups.
	 * 
	 * @param view
	 *            the view which is in current editor
	 * @param filter
	 *            settings from the dialog
	 * @return generated report
	 */
	public String generate(EConfMLLayer layer, int filter, String path) {
		this.filter = filter;
		//this.view = view;
		this.layer = layer;
		StringBuilder sb = new StringBuilder();
		content = new StringBuilder();
		sb.append(htmlStart());
		if (addGroups(filter)) {
			if (displayAsTable(filter)) {
				sb.append("<hr />\n");
			} else {
				sb.append("<h2 id=\"tocHeader\">Table of Contents</h2>\n");
			}
			sb.append("<ul class=\"toc\">\n");
		}
		sb.append("#content#");
		if (addGroups(filter)) {
			sb.append("</ul>\n");
			sb.append("<hr />\n");
		}

		if (!addGroups(filter) && displayAsTable(filter)) {
			sb.append("<table class=\"report\" >");
		}

		sb.append("<table class=\"report\" cellspacing=\"0\">\n");
		
		StringBuilder ge = generateFeatures(layer, filter);
		if (ge != null) {
			parentCount++;
			leafCount = 1;
			featCount = 1;
			settCount = 1;
			sb.append(ge);
		}
		
		sb.append("</table>");		
		
		if (sb == null) {
			return null;
		}
		if (!addGroups(filter) && displayAsTable(filter)) {
			sb.append("</table>");
		}
		sb.append("<br/>");
		
//		StringBuilder generatedAVR = generateAVR();
//		if (generatedAVR != null) {
//			sb.append(generatedAVR);
//			if (addGroups(filter)) {
//				if (displayAsTable(filter)) {
//					content.append("\t<li><a href=\"#avr\">Additional Variation Requests</a></li>\n");
//				} else {
//					content.append("\t<li><a href=\"#avr\">" + parentCount + ". Additional Variation Requests</a></li>\n");
//				}
//			} else {
//				content.append("<br/>");
//			}
//		}
		
		sb.append(htmlEnd());
		String report = sb.toString();
		// add navigation
		report = report.replace("#content#", content.toString());
		return report;
	}


	/**
	 * Method fills group with features.
	 * 
	 * @param group
	 *            the leaf group (subgroup)
	 * @param filter
	 *            filter from ReportDialog
	 * @return stringBuilder which contains html code of generated features with
	 *         their settings
	 */
	private StringBuilder generateFeatures(EConfMLLayer layer, int filter) {
		StringBuilder sb = new StringBuilder();
		//List<Setting> settings = group.getSettings();
		
		//List<Feature> featuresListFrom = getFeaturesList(settings);

		EMap<String, EAppFeature> featureMap = layer.getFeatures();
		
		boolean show, showFeature = false;
		// process features
		
		for (int i = 0 ; i < featureMap.size() ; i++)
		{
			Entry<String, EAppFeature> entry = featureMap.get(i);
			EAppFeature feature = entry.getValue();
		
		//for (Feature feature : featuresListFrom) {
			show = false;
//			if (feature.getRelevant() == null /*&& !feature.isComputedRelevant()*/) {
//				continue;
//			}
			StringBuilder f = new StringBuilder();

			if (displayAsTable(filter)) {

				f.append("\t<tr>\n\t\t<th class=\"featureName\" colspan=\"");
				f.append(addDescription(filter) ? COLUMN_COUNTS	: (COLUMN_COUNTS - DESCRIPTION_COLSPAN));
				f.append("\">");
				f.append(feature.getName());
				f.append("</th>\n\t</tr>\n");
				f.append("\t<tr>\n");
				f.append("\t\t<th width=\"20%\" colspan=\"" + NAME_COLSPAN + "\">Setting</th>\n");
				if (addDescription(filter)) {
					f.append("\t\t<th width=\"20%\" colspan=\""	+ DESCRIPTION_COLSPAN + "\">Description</th>\n");
				}
				f.append("\t\t<th width=\"20%\">Default Value</th>\n");
				f.append("\t\t<th width=\"20%\" colspan=\""	+ CURRENT_VALUE_COLSPAN + "\">Current Value</th>\n");
				f.append("\t\t<th width=\"20%\" colspan=\"" + ERRORS_COLSPAN + "\">Validation Error</th>\n");
				//f.append("\t\t<th width=\"20%\" colspan=\"" + NOTE_COLSPAN + "\">Note</th>\n\t</tr>\n");
			} else {
				f.append("\t\t<div class=\"feature\">\n");
				f.append("\t\t\t<h4>" + parentCount + "." + leafCount + "."	+ featCount + " " + feature.getName() + "</h4>\n");
				String featureDesc = feature.getDescription() != null ? feature.getDescription() : "";
				if (addDescription(filter)) {
					f.append("\t\t\t<p class=\"description\">" + featureDesc + "</p>\n");
				}
			}

			EMap<String, EAppSetting> settingsMap = feature.getSettings();
			
			for (int s = 0 ; s < settingsMap.size() ; s++)
			{
				Entry<String, EAppSetting> settingEntry = settingsMap.get(s);
				EAppSetting setting = settingEntry.getValue();
			
				StringBuilder gs = generateSetting(setting, filter, feature.getRef());

				if (gs != null) {
					f.append(gs);
					show = true;
				} else {
					settCount = 1;
				}
				
			}
			if (show) {
				sb.append(f);
				if (!displayAsTable(filter)) {
					sb.append("\t\t</div>\n");
				}
				featCount++;
				settCount = 1;
				subsettCount = 1;
				showFeature = true;
			}
		}
		if (showFeature) {
			return sb;
		} else {
			return null;
		}
	}

	/**
	 * This method is responsible for generating setting report of current
	 * setting
	 * 
	 * @param setting
	 * @param filter
	 *            the filter from ReportDialog
	 * @return String buffer contains generated html code
	 */
	private StringBuilder generateSetting(EAppSetting setting, int filter, String featureRef) {
		StringBuilder sb = null;

		sb = generateSimpleSetting(setting, filter, featureRef);
		
		settCount++;
		subsettCount = 1;
		return sb;
	}

	private String getFeatureRef(EAppSetting setting)
	{
		EObject cont = setting.eContainer();
		if(cont instanceof EAppFeature)
		{
			EAppFeature appFeature = (EAppFeature)cont;
			return  appFeature.getRef();			
		} else
		{
			EAppFeature appFeature = (EAppFeature)cont.eContainer();
			return appFeature.getRef();
		}
	}
	
	private List<String[]> getSettingValues(EAppSetting setting, String featureRef) {
		
		//String featureRef = getFeatureRef(setting);
		
		IProject project = ReportPlugin.getSelectedProject();

		EConfigurationProject configurationProject = ConfMLCore
				.getProjectModel(project);

		if (configurationProject == null)
			return null;
		
		EList<EConfMLLayer> layers = configurationProject.getLayers();
		
		List<String[]> prevoiusValues = new ArrayList<String[]>();
		
		String previousFileString = null;
		
		for (int i = 0 ; i < layers.size() ; i++) //latest layer is last in list
		{
			EConfMLLayer layer = layers.get(i);
			EMap<String, EAppFeature> featureMap = layer.getFeatures();
			if (featureMap.containsKey(featureRef))
			{
				EAppFeature originalFeature = featureMap.get(featureRef);
				{
					EMap<String, EAppSetting> settingMap = originalFeature.getSettings();
					EAppSetting appSetting = settingMap.get(setting.getRef());
					if (appSetting == null)
						return null;
					EAppSettingType typeInfo = appSetting.getTypeInfo();			
					EAppSettingData settingData = appSetting.getValueInfo();
					String fileString = "";
					String literalValue = null;
					EList<EAppSettingOption> options = null;
					if (settingData instanceof EAppSimpleData)
					{
						EAppSimpleType simpleType = (EAppSimpleType) typeInfo;
						options = simpleType.getOptions();
						EAppSimpleData simpleData = (EAppSimpleData)settingData;
						if (simpleData.getUri().size() == 0)
						{
							fileString = "";
						}
						else
						{
						 fileString = simpleData.getUri().get(0).toPlatformString(true);
						 fileString = fileString.substring(project.getName().length()+2);
						}
						literalValue = simpleData.getValue();
						
					}
					else if (settingData instanceof EAppResourceData)
					{
						EAppResourceData resourceData = (EAppResourceData)settingData;
						String targetPath = ((EAppSimpleData)resourceData.getTargetPath()).getValue();
						String localPath = ((EAppSimpleData)resourceData.getLocalPath()).getValue();
						literalValue = "Local path: "+localPath+"<br/>Target path: "+targetPath;
					}
					else if (settingData instanceof EAppSequenceData)
					{
						EAppSequenceData sequenceData = (EAppSequenceData)settingData;
						//how to show?
					}
					//---------
					if (previousFileString == null ||!previousFileString.equals(fileString))
					{
						previousFileString = fileString;
						
						if (literalValue != null)
							if (options!=null)
								for (EAppSettingOption appSettingOption : options) {
									if(appSettingOption!=null &&  appSettingOption.getLiteralValue() != null && appSettingOption.getLiteralValue().compareTo(literalValue)==0){
										literalValue = appSettingOption.getName();
									}
								}
						prevoiusValues.add(new String[]{literalValue,fileString});
					}
					
				}
			}
		}
		return prevoiusValues;
	}
	
	/**
	 * Method generates html code of simplesetting. It is one row in the table.
	 * 
	 * @param simpleSetting
	 *            the setting we want to generate report from
	 * @param filter
	 *            filter from ReportDialog
	 * @return generated html code in string builder
	 */
	private StringBuilder generateSimpleSetting(EAppSetting setting,int filter, String featureRef) {
		StringBuilder sb = null;
		
		List<String[]> previousValues = getSettingValues(setting, featureRef);

		//boolean isDefault = isDefaultValue(simpleSetting, false);
		
		boolean isDefault = true;
		if (previousValues.size()>1)
			isDefault = false;
		
		String value = previousValues.get(previousValues.size()-1)[0];
		String temp = previousValues.get(0)[0];
		
		String defaultValue = (temp != "") ? temp : defaultNotSet;
		if (setting.getTypeInfo().getRelevant() != null) {
			//System.out.println(simpleSetting.getTypeInfo().getName() + " " + !simpleSetting.isComputedRelevant());
		}
		//String note = getNote(simpleSetting);
		String name = setting.getTypeInfo().getName();

		if (addAllSettings(filter)
				|| (addOnlyNonDef(filter) && !isDefault)
				//|| ((addWithNotes(filter)) && (!note.equals("")))
				|| ((addWithErrors(filter)) )
				|| (addOnlyTextC(filter) && name.toLowerCase().contains(
						keyword.toLowerCase()))) {
			sb = new StringBuilder();
			// table layout
			if (displayAsTable(filter)) {
				// begining of the row
				sb.append("\t<tr>\n");

				// setting name
				sb.append("\t\t<td width=\"20%\" colspan=\"" + NAME_COLSPAN	+ "\">");
				sb.append((reportStringUtilities.getEncodedWrappedString(name)));
				sb.append("</td>\n");

				// description
				if (addDescription(filter)) {
					sb.append("\t\t<td width=\"20%\" colspan=\"" + DESCRIPTION_COLSPAN + "\">");
					sb.append((setting.getTypeInfo().getDescription() != null) ? (reportStringUtilities.getEncodedWrappedString(setting.getTypeInfo().getDescription())): "");
					sb.append("</td>\n");
				}

				sb.append("\t\t<td width=\"20%\">");
				// default value
				sb.append((reportStringUtilities.getEncodedWrappedString(defaultValue)));
				sb.append("</td>\n");

				// current value
				sb.append("\t\t<td width=\"20%\"");
				if (!isDefault) {
					sb.append(" class=\"currentValue\" colspan=\""	+ CURRENT_VALUE_COLSPAN + "\">");
					sb.append(reportStringUtilities.getEncodedWrappedString(value));
				} else {
					sb.append(" class=\"defaultValue\" colspan=\"" + CURRENT_VALUE_COLSPAN + "\">");
					sb.append("&lt;Default&gt;");
				}
				sb.append("</td>\n");

				// validation error
				sb.append("\t\t<td width=\"20%\" colspan=\"" + ERRORS_COLSPAN + "\">");
				sb.append(reportStringUtilities.getEncodedWrappedString(getErrorDesc(setting, featureRef)));
				sb.append("</td>\n");

				// end of row
				sb.append("</tr>\n");

				// text layout
			} else {
				// setting name
				sb.append("\t\t\t<div class=\"setting\">\n");
				sb.append("\t\t\t\t<h5>" + parentCount + "." + leafCount + "."
						+ featCount + "." + settCount + " "
						+ reportStringUtilities.getEncodedString(name)
						+ "</h5>\n");

				// description
				if (addDescription(filter)) {
					sb.append("\t\t\t\t<p class=\"description\">" + ((setting.getTypeInfo().getDescription() != null) ? (reportStringUtilities
											.getEncodedString(setting.getTypeInfo()
													.getDescription()))
											: "") + "</p>\n");
				}
				sb.append("\t\t\t\t<div class=\"settingValues\">\n");

				// current value
				sb.append("\t\t\t\t\t<div class=\"Property\">Value:</div>\n");
				sb.append("\t\t\t\t\t<div class=\"Value\">" + (value == "" ? "-" : (reportStringUtilities.getEncodedString(value))) + "<br/></div>\n");

				// default value
				sb.append("\t\t\t\t\t<div class=\"Property\">Default:</div>\n");
				sb.append("\t\t\t\t\t<div class=\"Value\">"
						+ (defaultValue == "" ? "-" : (reportStringUtilities
								.getEncodedString(defaultValue)))
						+ "<br/></div>\n");
				
				// validation error
				sb.append("\t\t\t\t\t<div class=\"Property\">Validation error:</div>\n");
				sb.append("\t\t\t\t\t<div class=\"Value\">"
						+ (getErrorDesc(setting, featureRef) == "" ? "-"
								: getErrorDesc(setting, featureRef))
						+ "<br/></div>\n");
				sb.append("\t\t\t\t</div>\n");
				sb.append("\t\t\t</div>\n");
			}
		}
		return sb;
	}

	

	
	
	/**
	 * Returns the description of validation error of this setting
	 * 
	 * @param setting
	 *            setting from which we want to know the validation error
	 *            description
	 * @return the error description or "" if there isn't any
	 */
	private String getErrorDesc(EAppSetting setting, String featureRef) {
		
		IMarker[] markers = getMarkers();
		StringBuffer sb = new StringBuffer();
		String absRef = featureRef+"/"+setting.getRef()+"/";
		
		for (int i = 0 ; i < markers.length ; i++)
		{
			try 
			{
				String markerRef = (String)markers[i].getAttribute("ref");	
				if (markerRef!=null && !markerRef.equals("") && markerRef.indexOf("/") != -1 && markerRef.endsWith(absRef))
				{
					if (sb.length()>0)
						sb.append("\n");
					sb.append((String)markers[i].getAttribute("message"));	
				}
				
			} catch (CoreException e)
			{
				e.printStackTrace();
			}
		}
		return sb.toString();
	}

	

	/**
	 * Generates start of html file which is similar in table and text format of
	 * generated report
	 * 
	 * @return generated start of html file
	 */
	/**
	 * Generates start of html file which is similar in table and text format of
	 * generated report
	 * 
	 * @return generated start of html file
	 */
	protected StringBuilder htmlStart() {
		StringBuilder sb = new StringBuilder();
		StringBuilder sumsb = new StringBuilder();
		String name = "";

		// ************************ ML **************************
			
			
			EConfigurationProject model = ConfMLCore.getProjectModel(ReportPlugin.getSelectedProject());
			
			System.out.println("MODEL: " + model.toString() );
	
			if (displayAsTable(filter)) {
				
				sumsb.append("<center><h2>Summary</h2></center>\n");
				sumsb.append("<table class=\"summary\" align=\"center\" cellspacing=\"0\">\n");
				sumsb.append("\t<tr>\n\t\t<th class=\"featureName\" colspan=\"2\">"	+ "Project details" + "</th>\n\t</tr>\n");
				sumsb.append("\t<tr>\n\t\t<td>" + "Product" + "</td>\n\t\t<td>" + model.getProduct() + "</td>\n\t</tr>\n");
				sumsb.append("\t<tr>\n\t\t<td>" + "Platform" + "</td>\n\t\t<td>" + model.getPlatform()+ "</td>\n\t</tr>\n");
				sumsb.append("\t<tr>\n\t\t<td>" + "Name" + "</td>\n\t\t<td>" + model.getName()+ "</td>\n\t</tr>\n");
				sumsb.append("\t<tr>\n\t\t<td>" + "Version" + "</td>\n\t\t<td>" + model.getVersion()+ "</td>\n\t</tr>\n");
				sumsb.append("\t<tr>\n\t\t<td>" + "Customer" + "</td>\n\t\t<td>" + model.getCustomer()+ "</td>\n\t</tr>\n");
				sumsb.append("\t<tr>\n\t\t<td>" + "Date" + "</td>\n\t\t<td>" + model.getDate()+ "</td>\n\t</tr>\n");
				sumsb.append("\t<tr>\n\t\t<td>" + "ConfVersion" + "</td>\n\t\t<td>" + model.getConfVersion()+ "</td>\n\t</tr>\n");
				sumsb.append("\t<tr>\n\t\t<td>" + "Origin" + "</td>\n\t\t<td>" + model.getOrigin()+ "</td>\n\t</tr>\n");
				sumsb.append("\t<tr>\n\t\t<td>" + "Owner" + "</td>\n\t\t<td>" + model.getOwner()+ "</td>\n\t</tr>\n");
				sumsb.append("\t<tr>\n\t\t<td>" + "Release" + "</td>\n\t\t<td>" + model.getRelease()+ "</td>\n\t</tr>\n");
				sumsb.append("\t<tr>\n\t\t<td>" + "Status" + "</td>\n\t\t<td>" + model.getStatus()+ "</td>\n\t</tr>\n");

				sumsb.append("</table>\n");
				
				EList<EConfMLLayer> layers = model.getLayers();
				Iterator<EConfMLLayer> layerIterator = layers.iterator();
				sumsb.append("<center><h2>Layers</h2></center>\n");
				sumsb.append("<table class=\"summary\" align=\"center\" cellspacing=\"0\">\n");
				sumsb.append("\t<tr>\n\t\t<td>" );
				while (layerIterator.hasNext()) {
					EConfMLLayer layer = (EConfMLLayer) layerIterator.next();
					sumsb.append(layer.getName() + "</td>\n\t\t<td>");
				}
				sumsb.append("</td>\n\t</tr>\n");
				
				sumsb.append("</table>\n");
			}
			
		sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
		sb.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n");
		sb.append("<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en-US\" lang=\"en-US\">\n");
		sb.append("<head profile=\"http://www.w3.org/2000/08/w3c-synd/#\">\n");
		sb.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"></meta>\n");
		sb.append("<title>" + name + "</title>\n");
		sb.append(defineCSS());
		sb.append("</head>\n");
		sb.append("<body>\n");
		if (displayAsTable(filter)) {
			sb.append("<h1>" + name + "</h1>\n");
		} else {
			sb.append("<h1 id=\"reportName\">" + name + "</h1>\n");
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy MM dd");
		sb.append("<p id=\"date\">" + sdf.format(new java.util.Date()) + "</p>\n");
		sb.append(sumsb);
		return sb;
	}

	/**
	 * Get the css style according to filter
	 * 
	 * @return Table CSS style or Text CSS style
	 */
	protected StringBuilder defineCSS() {

		return Css.getCss(displayAsTable(filter));
	}

	/**
	 * Adds end of the html file
	 * 
	 * @return end of html file
	 */
	protected StringBuilder htmlEnd() {
		StringBuilder sb = new StringBuilder();
		sb.append("</body>\n");
		sb.append("</html>");
		return sb;
	}

	/**
	 * Sets the keyword, if filtering by keyword is selected
	 * 
	 * @param keyword
	 *            the keyword to set
	 */
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	/**
	 * Decode from filter if the report will be generated wit all settings
	 * 
	 * @param filter
	 *            filter from ReportDialog
	 * @return <code>true</code> if all settings will be generated,
	 *         <code>false</code> if not
	 */
	private boolean addAllSettings(int filter) {
		if ((filter & ALL) != 0) {
			return true;
		}
		return false;
	}

	/**
	 * Decode from filter if the report will be generated only from settings
	 * which are not default
	 * 
	 * @param filter
	 *            filter from ReportDialog
	 * @return <code>true</code> if only settings with values different of
	 *         default values will be generated, <code>false</code> if not
	 */
	private boolean addOnlyNonDef(int filter) {
		if ((filter & NON_DEFAULT) != 0) {
			return true;
		}
		return false;
	}

	/**
	 * Decode from filter if the report will be generated only from settings
	 * which contains in name entered keyword
	 * 
	 * @param filter
	 *            filter from ReportDialog
	 * @return <code>true</code> if only settings with keyword in name will be
	 *         generated, <code>false</code> if not
	 */
	private boolean addOnlyTextC(int filter) {
		if ((filter & TEXT_FILTER) != 0) {
			return true;
		}
		return false;
	}


	/**
	 * Decode from filter if the report will be generated only from settings
	 * which have validation errors
	 * 
	 * @param filter
	 *            filter from ReportDialog
	 * @return <code>true</code> if only settings with validation errors will be
	 *         generated, <code>false</code> if not
	 */
	private boolean addWithErrors(int filter) {
		if ((filter & WITH_ERRORS) != 0) {
			return true;
		}
		return false;
	}

	/**
	 * Decode from filter if there will be description in html report file
	 * 
	 * @param filter
	 *            filter from ReportDialog
	 * @return <code>true</code> if user wants to show it, <code>false</code> if
	 *         user don't want to show it
	 */
	private boolean addDescription(int filter) {
		if ((filter & DESCRIPTION) != 0) {
			return true;
		}
		return false;
	}

	/**
	 * Decode from filter if user want generate table of contents and if he want
	 * to show groups of settings
	 * 
	 * @param filter
	 *            filter from ReportDialog
	 * @return <code>true</code> if groups will be generated <code>false</code>
	 *         if they won't
	 */
	private boolean addGroups(int filter) {
		if ((filter & BY_GROUP) != 0) {
			return true;
		}
		return false;
	}

	/**
	 * Decode from filter if user want to open generated report in default
	 * browser
	 * 
	 * @param filter
	 *            filter from ReportDialog
	 * @return <code>true</code> if report will be opened in default browser,
	 *         <code>false</code> if it won't
	 */
	public boolean canOpen(int filter) {
		if ((filter & OPEN) != 0) {
			return true;
		}
		return false;
	}

	/**
	 * Decode from filter if user want to generate report in table format
	 * 
	 * @param filter
	 *            filter from ReportDialog
	 * @return <code>true</code> if user wants table format, <code>false</code>
	 *         if user wants text format
	 */
	public boolean displayAsTable(int filter) {
		if ((filter & TO_TABLE) != 0) {
			return true;
		}
		return false;
	}
	
	private IMarker[] getMarkers()
	{
		if (markers==null)
		{
			try {
				markers = ResourcesPlugin.getWorkspace().getRoot().getProject(ReportPlugin.getSelectedProject().getName()).findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
				return markers;
			} catch (CoreException e) {

				e.printStackTrace();
			}
		}
		
		return markers;
		
		
	}
	

}
