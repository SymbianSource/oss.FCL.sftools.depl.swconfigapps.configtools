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
 * Description: This file is part of com.nokia.tools.variant.report.generator component.
 */

package com.nokia.tools.variant.report.generator;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

import com.nokia.tools.variant.content.confml.Feature;
import com.nokia.tools.variant.content.confml.FilePath;
import com.nokia.tools.variant.content.confml.FileSystemEntrySetting;
import com.nokia.tools.variant.content.confml.Group;
import com.nokia.tools.variant.content.confml.LeafGroup;
import com.nokia.tools.variant.content.confml.Option;
import com.nokia.tools.variant.content.confml.ParentGroup;
import com.nokia.tools.variant.content.confml.SequenceItem;
import com.nokia.tools.variant.content.confml.SequenceSetting;
import com.nokia.tools.variant.content.confml.Setting;
import com.nokia.tools.variant.content.confml.SimpleSetting;
import com.nokia.tools.variant.content.confml.TYPE;
import com.nokia.tools.variant.content.confml.View;
import com.nokia.tools.variant.content.confml.impl.OptionImpl;
import com.nokia.tools.variant.content.confml.util.SettingValueUtils;
import com.nokia.tools.variant.editor.editors.CPFEditor;
import com.nokia.tools.variant.editor.model.summaryModel.History;
import com.nokia.tools.variant.editor.model.summaryModel.Note;
import com.nokia.tools.variant.editor.model.summaryModel.UIElement;
import com.nokia.tools.variant.editor.model.summaryModel.UISummaryGroup;
import com.nokia.tools.variant.resourcelibrary.model.ResourceModelRoot;
import com.nokia.tools.variant.views.errormodel.Error;
import com.nokia.tools.variant.views.errormodel.ErrorsRoot;

/**
 * Class generates CPF report according to given settings.
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
	 * Generate report in table format (otherwise text format)
	 */
	public static int TO_TABLE = 128;

	/**
	 * Generate report only with settings with validation errors
	 */
	public static int WITH_ERRORS = 256;

	/**
	 * Generate report with/without validation errors column
	 */
	public static int SHOW_VALIDATION_ERROR_COLUMN = 512;

	/**
	 * Generate report with/without notes column
	 */
	public static int SHOW_NOTE_COLUMN = 1024;

	/**
	 * Generated page.
	 */
	private StringBuilder content;

	/**
	 * Word used for setting filtering.
	 */
	private String keyword;

	/**
	 * Column span for each column used in table format of report
	 */
	private int NAME_COLSPAN = 2;
	private int CURRENT_VALUE_COLSPAN = 2;
	private int DESCRIPTION_COLSPAN = 1;
	private int NOTE_COLSPAN = 2;
	private int ERRORS_COLSPAN = 1;
	private int DEFAULT_COLSPAN = 1;
	private int COLUMN_COUNTS = NAME_COLSPAN + CURRENT_VALUE_COLSPAN
			+ DESCRIPTION_COLSPAN + NOTE_COLSPAN + ERRORS_COLSPAN
			+ DEFAULT_COLSPAN;

	/**
	 * String for not set default value
	 */
	private final String defaultNotSet = Messages.DefaultValueIsNotSet;

	ReportStringUtilities reportStringUtilities = new ReportStringUtilities();
	EList<Error> errors = null;
	CPFEditor editor = null;

	/**
	 * Filter from Report Dialog. There are flags with options in this filter
	 * number
	 */
	int filter = 0;

	private int parentCount = 1;
	private int leafCount = 1;
	private int featCount = 1;
	private int settCount = 1;
	private int subsettCount = 1;
	private View view;

	/**
	 * Widths of columns, don't change this values, it is set programatically.
	 */
	private int SEQ_NAME_SPACE = 5;
	private int NAME_WIDTH = 0;
	private int DESCRIPTION_WIDTH = 0;
	private int DEFAULT_WIDTH = 0;
	private int CURRENT_WIDTH = 0;
	private int ERROR_WIDTH = 0;
	private int NOTE_WIDTH = 0;

	/**
	 * Weigths (priority) for each column. Values are from 0.1 to 0.5. Bigger
	 * number means bigger width of column. The sum of this weights should be
	 * equal 1.
	 */
	private double nameWeight = 0.2;
	private double descWeight = 0.2;
	private double defWeight = 0.1;
	private double currWeight = 0.2;
	private double errWeight = 0.1;
	private double noteWeight = 0.2;

	/**
	 * Redistributes columns width of disabled columns. If some column is
	 * disabled, its space is redistributed to other columns.
	 */
	private void redistributeColumnsWidth() {
		int count = 6;
		int full = 100;
		if (!addNotes(filter)) {
			count--;
			NOTE_COLSPAN = 0;
		} else {
			NOTE_WIDTH = (int) (full * noteWeight);
			noteWeight = 0;
		}

		if (!addValidationErrors(filter)) {
			count--;
			ERRORS_COLSPAN = 0;
		} else {
			ERROR_WIDTH = (int) (full * errWeight);
			errWeight = 0;
		}

		if (!addDescription(filter)) {
			count--;
			DESCRIPTION_COLSPAN = 0;
		} else {
			DESCRIPTION_WIDTH = (int) (full * descWeight);
			descWeight = 0;
		}

		NAME_WIDTH = (int) (full * (nameWeight + (errWeight + noteWeight + descWeight)
				/ count));
		DEFAULT_WIDTH = (int) (full * (defWeight + (errWeight + noteWeight + descWeight)
				/ count));
		CURRENT_WIDTH = (int) (full * (currWeight + (errWeight + noteWeight + descWeight)
				/ count));
	}

	/**
	 * Method generates report, looks for parent groups.
	 * 
	 * @param view the view which is in current editor
	 * @param filter settings from the dialog
	 * @return generated report
	 */
	public String generate(View view, int filter, String path) {
		this.filter = filter;
		this.view = view;
		redistributeColumnsWidth();
		StringBuilder sb = new StringBuilder();
		content = new StringBuilder();
		sb.append(htmlStart());

		if (addGroups(filter)) {
			if (displayAsTable(filter)) {
				sb.append("<hr />\n");
			} else {
				sb.append("<h2 id=\"tocHeader\">");
				sb.append(Messages.TableOfContents);
				sb.append("</h2>\n");
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

		EList<ParentGroup> parentGroups = view.getParentGroup();
		for (ParentGroup parentGroup : parentGroups) {
			if (parentGroup instanceof ParentGroup) {
				StringBuilder ge = generateParentGroup(parentGroup, filter);
				if (ge != null) {
					parentCount++;
					leafCount = 1;
					featCount = 1;
					settCount = 1;
					sb.append(ge);
				}
			}
		}

		if (sb == null) {
			return null;
		}

		if (!addGroups(filter) && displayAsTable(filter)) {
			sb.append("</table>");
		}

		sb.append("<br/>");

		StringBuilder generatedAVR = generateAVR();
		if (generatedAVR != null) {
			sb.append(generatedAVR);
			if (addGroups(filter)) {
				if (displayAsTable(filter)) {
					content.append("\t<li><a href=\"#avr\">");
					content.append(Messages.AVR);
					content.append("</a></li>\n");
				} else {
					content.append("\t<li><a href=\"#avr\">");
					content.append(parentCount);
					content.append(". ");
					content.append(Messages.AVR);
					content.append("</a></li>\n");
				}
			} else {
				content.append("<br/>");
			}
		}

		sb.append(htmlEnd());

		String report = sb.toString();

		// add navigation
		report = report.replace("#content#", content.toString());

		return report;
	}

	/**
	 * Generates AVR as html code in {@link StringBuilder}. It will be append to
	 * the end of generated report file.
	 * 
	 * @return the AVR notes in html code
	 */
	private StringBuilder generateAVR() {
		StringBuilder sb = new StringBuilder();
		EList<UIElement> uiElements = editor.getSummaryModelroot()
				.getUiGroups().get(0).getUiElements();
		String avrNote = null;
		for (UIElement element : uiElements) {
			if (Messages.AVR.equals(element.getName())) {
				avrNote = element.getNote();
			}
		}
		if (avrNote != null) {
			avrNote = avrNote.replaceAll("\n", "<br/>");
			if (displayAsTable(filter)) {
				sb.append("<a name=\"avr\"></a>\n");
				sb.append("<table class=\"report\" >\n");
				sb.append("\t<tr>\n");
				sb.append("\t\t<th class=\"featureName\" colspan=\"");
				sb.append(addDescription(filter) ? COLUMN_COUNTS
						: COLUMN_COUNTS - DESCRIPTION_COLSPAN);
				sb.append("\">");
				sb.append(Messages.AVR);
				sb.append("</th>\n");
				sb.append("\t</tr>\n");
				sb.append("\t<tr>\n");
				sb.append("\t\t<td colspan=\"");
				sb.append(addDescription(filter) ? COLUMN_COUNTS
						: COLUMN_COUNTS - DESCRIPTION_COLSPAN);
				sb.append("\">");
				if (avrNote != null) {
					sb.append(avrNote);
				}
				sb.append("\n");
				sb.append("\t\t</td>\n");
				sb.append("</tr>\n");
				sb.append("</table>\n");
			} else {
				sb.append("<a name=\"avr\"></a>\n<div class=\"feature\">\n");
				sb.append("<h2>" + parentCount + ". " + Messages.AVR
						+ "</h2>\n");
				sb.append("<br/>");
				if (avrNote != null) {

					sb.append("<p class=\"description\">" + avrNote + "</p>\n");
				}
			}
			return sb;
		} else {
			return null;
		}
	}

	/**
	 * Method fills parent group with leaf groups.
	 * 
	 * @param parentGroup
	 * @param filter
	 * @return report of parent group or null whether group should not be
	 *         displayed
	 */
	private StringBuilder generateParentGroup(ParentGroup parentGroup,
			int filter) {
		StringBuilder sb = new StringBuilder();
		StringBuilder sblg = null;
		StringBuilder settingsInside = null;
		StringBuilder lGroups = null;

		settingsInside = generateFeatures(parentGroup, filter);
		EList<LeafGroup> leafGroup = parentGroup.getLeafGroup();
		for (LeafGroup lg : leafGroup) {
			sblg = generateLeafGroup(lg, filter);
			if (sblg != null) {
				leafCount++;
				featCount = 1;
				settCount = 1;
				subsettCount = 1;
				if (lGroups == null) {
					lGroups = new StringBuilder();
				}
				lGroups.append(sblg);
			}
		}
		if (lGroups != null || settingsInside != null) {

			if (addGroups(filter)) {
				if (displayAsTable(filter)) {
					sb.append("<h2><a name=\"");
				} else {
					sb.append("<div class=\"group\">\n<h2><a name=\"");
				}
				String reference = parentGroup.getName().replaceAll(" ", "%20");
				sb.append(reportStringUtilities.getEncodedString(reference));
				sb.append("\">");
				if (displayAsTable(filter)) {
					sb.append(reportStringUtilities
							.getEncodedString(parentGroup.getName()));
				} else {
					sb.append(parentCount
							+ ". "
							+ reportStringUtilities
									.getEncodedString(parentGroup.getName()));
				}
				sb.append("</a>");
				sb.append("</h2>\n");

				// description of group
				if (!displayAsTable(filter)) {
					if (addDescription(filter)) {
						sb
								.append("\t<p class=\"description\">"
										+ (parentGroup.getDesc() != null ? reportStringUtilities
												.getEncodedString(parentGroup
														.getDesc())
												: "") + "</p>\n");
					}
				}

				// content
				content.append("\t<li><a href=\"#");
				content.append(reference);
				content.append("\">");
				if (displayAsTable(filter)) {
					content.append(reportStringUtilities
							.getEncodedString(parentGroup.getName()));
				} else {
					content.append(parentCount
							+ ". "
							+ reportStringUtilities
									.getEncodedString(parentGroup.getName()));
				}
				content.append("</a></li>\n");
				int localLeafGroupCount = 1;
				if (!displayAsTable(filter)) {
					for (LeafGroup leafGroup2 : leafGroup) {
						EList<Setting> settings = leafGroup2.getSettings();
						boolean showLeafGroup = false;
						for (Setting setting : settings) {
							if (addOnlyTextC(filter)
									&& getSettingName(setting).toLowerCase()
											.contains(keyword.toLowerCase())
									|| addWithNotes(filter)
									&& !getNote(setting).equals("")
									|| addOnlyNonDef(filter)
									&& !isDefaultValue(setting, false)
									|| addAllSettings(filter)
									|| addWithErrors(filter)
									&& hasSettingError(setting)) {
								showLeafGroup = true;
								break;
							}
						}
						if (showLeafGroup) {
							String reference2 = leafGroup2.getName()
									.replaceAll(" ", "%20");
							content.append("\t<li>\n");
							content.append("\t\t<ul>\n");
							content.append("\t\t\t<li><a href=\"#");
							content.append(reportStringUtilities
									.getEncodedString(reference2));
							content.append("\">");
							content.append(parentCount);
							content.append(".");
							content.append(localLeafGroupCount);
							content.append(" ");
							content.append(reportStringUtilities
									.getEncodedString(leafGroup2.getName()));
							content.append("</a></li>\n");
							content.append("\t\t</ul>\n");
							content.append("\t</li>\n");
							localLeafGroupCount++;
						}
					}
				}
			}
			if (settingsInside != null) {
				if (addGroups(filter)) {
					if (displayAsTable(filter)) {
						sb
								.append("<table class=\"report\" cellspacing=\"0\">\n");
					}
					sb.append(settingsInside);

					if (addGroups(filter)) {
						if (displayAsTable(filter)) {
							sb.append("</table>\n");
						} else {
							sb.append("\t</div>\n");
						}
					}
				}
			}
			if (lGroups != null) {
				sb.append(lGroups);
			}
			if (!displayAsTable(filter) && addGroups(filter)) {
				sb.append("</div>\n");
			}
			return sb;
		}

		return null;
	}

	/**
	 * Method fills leaf group with features
	 * 
	 * @param leafGroup
	 * @param filter
	 * @return leaf group report or null whether group should not be displayed
	 */
	private StringBuilder generateLeafGroup(LeafGroup leafGroup, int filter) {
		StringBuilder sb = new StringBuilder();
		StringBuilder f = generateFeatures(leafGroup, filter);
		if (f != null) {
			if (addGroups(filter)) {
				if (displayAsTable(filter)) {
					sb.append("<h3>");
					sb
							.append(reportStringUtilities
									.getEncodedString(((LeafGroup) leafGroup)
											.getName()));
					sb.append("</h3>\n");
					sb.append("<table class=\"report\" cellspacing=\"0\">\n");
				} else {
					sb.append("\t<div class=\"subgroup\">\n");
					String reference = leafGroup.getName().replaceAll(" ",
							"%20");
					sb.append("\t\t<h3><a name=\""
							+ reportStringUtilities.getEncodedString(reference)
							+ "\">");
					sb.append(parentCount
							+ "."
							+ leafCount
							+ " "
							+ reportStringUtilities
									.getEncodedString(((LeafGroup) leafGroup)
											.getName()));
					sb.append("</a></h3>\n");
					if (addDescription(filter)) {
						sb
								.append("\t\t<p class=\"description\">"
										+ (leafGroup.getDesc() != null ? reportStringUtilities
												.getEncodedString(leafGroup
														.getDesc())
												: "-") + "</p>\n");
					}
				}
			}

			sb.append(f);

			if (addGroups(filter)) {
				if (displayAsTable(filter)) {
					sb.append("</table>\n");
				} else {
					sb.append("\t</div>\n");
				}
			}
			return sb;
		}

		return null;
	}

	/**
	 * Method fills group with features and settings
	 * 
	 * @param group the leaf group (subgroup)
	 * @param filter filter from ReportDialog
	 * @return stringBuilder which contains html code of generated features with
	 *         their settings
	 */
	private StringBuilder generateFeatures(Group group, int filter) {
		StringBuilder sb = new StringBuilder();
		List<Setting> settings = group.getSettings();
		List<Feature> featuresListFrom = getFeaturesList(settings);

		boolean show, showFeature = false;
		// process features
		for (Feature feature : featuresListFrom) {
			show = false;
			if (feature.getRelevant() != null && !feature.isComputedRelevant()) {
				continue;
			}
			StringBuilder f = new StringBuilder();

			if (displayAsTable(filter)) {

				f.append("\t<tr>\n\t\t<th class=\"featureName\" colspan=\"");
				f.append(addDescription(filter) ? COLUMN_COUNTS : COLUMN_COUNTS
						- DESCRIPTION_COLSPAN);
				f.append("\">");
				f.append(feature.getName());
				f.append("</th>\n\t</tr>\n");
				f.append("\t<tr>\n");
				f.append("\t\t<th width=\"" + NAME_WIDTH + "%\" colspan=\""
						+ NAME_COLSPAN + "\">" + Messages.Setting + "</th>\n");
				if (addDescription(filter)) {
					f.append("\t\t<th width=\"" + DESCRIPTION_WIDTH
							+ "%\" colspan=\"" + DESCRIPTION_COLSPAN + "\">"
							+ Messages.Description + "</th>\n");
				}
				f.append("\t\t<th width=\"" + DEFAULT_WIDTH + "%\">"
						+ Messages.DefaultValue + "</th>\n");

				f.append("\t\t<th width=\"" + CURRENT_WIDTH + "%\" colspan=\""
						+ CURRENT_VALUE_COLSPAN + "\">" + Messages.CurrentValue
						+ "</th>\n");
				if (addValidationErrors(filter)) {
					f.append("\t\t<th width=\"" + ERROR_WIDTH
							+ "%\" colspan=\"" + ERRORS_COLSPAN + "\">"
							+ Messages.ValidationError + "</th>\n");
				}
				if (addNotes(filter)) {
					f.append("\t\t<th width=\"" + NOTE_WIDTH + "%\" colspan=\""
							+ NOTE_COLSPAN + "\">" + Messages.Note
							+ "</th>\n\t</tr>\n");
				}
			} else {
				f.append("\t\t<div class=\"feature\">\n");
				f.append("\t\t\t<h4>" + parentCount + "." + leafCount + "."
						+ featCount + " " + feature.getName() + "</h4>\n");
				String featureDesc = feature.getDescription() != null ? feature
						.getDescription() : "";
				if (addDescription(filter)) {
					f.append("\t\t\t<p class=\"description\">" + featureDesc
							+ "</p>\n");
				}
			}

			for (Setting setting : settings) {
				if (setting.isVisible()
						&& (setting.getRelevant() == null || setting
								.isComputedRelevant())
						&& getSettingFeature(setting).equals(feature)) {
					StringBuilder gs = generateSetting(setting, filter);

					if (gs != null) {
						f.append(gs);
						show = true;
					} else {
						settCount = 1;
					}
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
	 * Returns list of all used Features used in this view.
	 * 
	 * @param settings list of settings of which we want to know their features
	 * @return the list of features, which are used
	 */
	private List<Feature> getFeaturesList(List<Setting> settings) {
		List<Feature> features = new ArrayList<Feature>();

		for (Setting s : settings) {
			Feature f = getSettingFeature(s);
			boolean add = true;
			for (Feature fInList : features) {
				if (fInList.equals(f)) {
					add = false;
					break;
				}
			}

			if (add) {
				features.add(f);
			}
		}
		return features;
	}

	/**
	 * Method returns the feature of the setting
	 * 
	 * @param setting of which we need to know the feature
	 * @return the feature of the setting
	 */
	private Feature getSettingFeature(Setting setting) {
		String featureRef = setting.getFeatureRef();
		EList<Feature> sharedFeatures = view.getSharedFeatures();
		Feature returnedFeature = null;
		for (Feature feature : sharedFeatures) {
			if (feature.getRef().equals(featureRef)) {
				returnedFeature = feature;
			}
		}
		return returnedFeature;
	}

	/**
	 * This method is responsible for generating setting report of current
	 * setting
	 * 
	 * @param setting the setting which can be {@link SimpleSetting},
	 *            {@link SequenceSetting} or {@link FileSystemEntrySetting}
	 * @param filter the filter from ReportDialog
	 * @return String buffer contains generated html code
	 */
	private StringBuilder generateSetting(Setting setting, int filter) {
		StringBuilder sb = null;

		if (setting instanceof SimpleSetting) {
			SimpleSetting simpleSetting = (SimpleSetting) setting;

			sb = generateSimpleSetting(simpleSetting, filter);
		} else if (setting instanceof FileSystemEntrySetting) {
			FileSystemEntrySetting fses = (FileSystemEntrySetting) setting;

			sb = generateFileSetting(fses, filter, false, false, 2);
		} else if (setting instanceof SequenceSetting) {
			SequenceSetting sequenceSetting = (SequenceSetting) setting;
			int rowSpan = countSeqSettings(sequenceSetting);
			StringBuilder gs = generateSeq(sequenceSetting, filter, rowSpan);
			if (gs != null) {
				sb = new StringBuilder();

				if (displayAsTable(filter)) {
					sb.append("\t<tr>\n\t\t<td width=\"" + NAME_WIDTH
							+ "%\" colspan=\"" + NAME_COLSPAN + "\">");
					// rowspan=\"");
					// sb.append((rowSpan > 0) ? rowSpan : 1);
					// sb.append("\">");
					sb.append(getSettingName(sequenceSetting));
					sb.append("</td>\n");
					String desc = "";
					if (sequenceSetting.getDescription() != null) {
						desc = sequenceSetting.getDescription();
					}
					sb.append("\t\t<td colspan=\""
							+ DESCRIPTION_COLSPAN
							+ "\">"
							+ reportStringUtilities
									.getEncodedWrappedString(desc) + "</td>\n");
					sb.append("\t\t<td colspan=\""
							+ (CURRENT_VALUE_COLSPAN + DEFAULT_COLSPAN)
							+ "\"></td>\n");
					if (addValidationErrors(filter)) {
						sb
								.append("\t\t<td colspan=\""
										+ ERRORS_COLSPAN
										+ "\">"
										+ reportStringUtilities
												.getEncodedWrappedString(getErrorDesc(sequenceSetting))
										+ "</td>\n");
					}
					String note = "";
					if (getNote(sequenceSetting) != "") {
						note = getNote(sequenceSetting);
					}
					if (addNotes(filter)) {
						sb.append("\t\t<td>"
								+ reportStringUtilities
										.getEncodedWrappedString(note)
								+ "</td>\n");
					}
					sb.append("\t</tr>\n");
					// sb.append("\t<tr>\n");
					if (countSeqSettings(sequenceSetting) > 0) {
						sb.append("\t<tr>\n");
						sb.append("\t\t<td width=\"" + SEQ_NAME_SPACE
								+ "%\" rowspan=\"");
						sb.append(rowSpan + 1);
						sb.append("\">");
						sb.append("</td>\n");
						sb.append("\t</tr>\n");
					}
					sb.append(gs);
				} else {
					sb.append("\t\t\t<div class=\"setting\">\n");
					sb.append("\t\t\t\t<h5>" + parentCount + "." + leafCount
							+ "." + featCount + "." + settCount + " "
							+ getSettingName(sequenceSetting) + "</h5>\n");
					sb.append("\t\t\t<div class=\"settingValues\">\n");
					if (addNotes(filter)) {
						sb.append("\t\t\t\t<div class=\"Property\">"
								+ Messages.Note + ":</div>\n");
						String noteString = getNote(sequenceSetting) != "" ? sequenceSetting
								.getNote()
								: "-";
						sb.append("\t\t\t\t<div class=\"Value\">" + noteString
								+ "<br/></div>\n");
					}
					if (addValidationErrors(filter)) {
						sb.append("\t\t\t\t<div class=\"Property\">"
								+ Messages.ValidationError + ":</div>\n");
						String errorString = getErrorDesc(sequenceSetting) != "" ? getErrorDesc(sequenceSetting)
								: "-";
						sb.append("\t\t\t\t<div class=\"Value\">" + errorString
								+ "<br/></div>\n");
					}
					sb.append("\t\t\t</div>\n");
					sb.append(gs);
					sb.append("\t\t\t</div>\n");
				}

				// sb.append("</td></tr>\n");
			}

		}
		settCount++;
		subsettCount = 1;
		return sb;
	}

	/**
	 * Method generates html code for FileSetting. It needs two rows in the
	 * table. There is difference between generating filesetting into sequence
	 * and generating it alone.
	 * 
	 * @param fileSystemEntrySetting setting we want to generate report from
	 * @param filter the filter from ReportDialog
	 * @param intoSequence <code>true</code> if fileSetting it in sequence,
	 *            <code>false</code> if it isn't
	 * @param first <code>true</code> if fileSetting is first in sequence,
	 *            <code>false</code> if it isn't first
	 * @param rowspan row span of note column
	 * @return generated html code in string builder
	 */
	private StringBuilder generateFileSetting(
			FileSystemEntrySetting fileSystemEntrySetting, int filter,
			boolean intoSequence, boolean first, int rowspan) {
		StringBuilder sb = null;
		int fileRowSpan = 2;
		boolean dontShow = false;
		boolean sourceReadOnly = fileSystemEntrySetting.getSourceFilePath()
				.isPathReadOnly();
		boolean targetReadOnly = fileSystemEntrySetting.getTargetFilePath()
				.isPathReadOnly();
		if (!fileSystemEntrySetting.isVisible() || sourceReadOnly
				&& targetReadOnly) {
			return null;
		}
		if (sourceReadOnly || targetReadOnly) {
			rowspan--;
			fileRowSpan--;
		}

		String sourceValue = fileSystemEntrySetting.getSourceFilePath()
				.getPath() != null ? fileSystemEntrySetting.getSourceFilePath()
				.getPath() : "";
		if (sourceValue.contains(OptionImpl.OPTION_MAP_KEY)) {
			String sourceOptionValue = sourceValue.substring(sourceValue
					.indexOf(OptionImpl.OPTION_MAP_KEY)
					+ OptionImpl.OPTION_MAP_KEY.length());
			int i = sourceOptionValue.lastIndexOf("\"]");
			if (i >= 0) {
				sourceValue = sourceOptionValue.substring(0, i);
			}
		}
		boolean isDefaultSource = fileSystemEntrySetting.getSourceFilePath()
				.getDefaultPath() == fileSystemEntrySetting.getSourceFilePath()
				.getPath();

		String targetValue = fileSystemEntrySetting.getTargetFilePath()
				.getPath() != null ? fileSystemEntrySetting.getTargetFilePath()
				.getPath() : "";
		if (targetValue.contains(OptionImpl.OPTION_MAP_KEY)) {
			String targetOptionValue = targetValue.substring(targetValue
					.indexOf(OptionImpl.OPTION_MAP_KEY)
					+ OptionImpl.OPTION_MAP_KEY.length());
			int i = targetOptionValue.lastIndexOf("\"]");
			if (i >= 0) {
				targetValue = targetOptionValue.substring(0, i);
			}
		}
		boolean isDefaultTarget = fileSystemEntrySetting.getTargetFilePath()
				.getDefaultPath() == fileSystemEntrySetting.getTargetFilePath()
				.getPath();

		String note = getNote(fileSystemEntrySetting);
		String name = getSettingName(fileSystemEntrySetting);
		if (addAllSettings(filter) || addOnlyNonDef(filter)
				&& (!isDefaultSource || !isDefaultTarget) || intoSequence
				|| addWithNotes(filter) && !note.equals("")
				|| addWithErrors(filter)
				&& hasSettingError(fileSystemEntrySetting)
				|| addOnlyTextC(filter)
				&& name.toLowerCase().contains(keyword.toLowerCase())) {
			sb = new StringBuilder();
			// table layout
			if (displayAsTable(filter)) {
				// name of setting
				sb.append("\t<tr>\n");
				if (intoSequence) {
					sb.append("\t\t<td width=\""
							+ (NAME_WIDTH - SEQ_NAME_SPACE) + "%\" rowspan=\""
							+ fileRowSpan + "\"");
				} else {
					sb.append("\t\t<td width=\"" + NAME_WIDTH
							+ "%\" rowspan=\"" + fileRowSpan + "\"");
				}
				if (!intoSequence) {
					// if it isn't in sequence, we have to set name column
					// span
					sb.append("colspan=\"" + NAME_COLSPAN + "\">");
				} else {
					// else we need to only close tag
					sb.append(">");
				}
				sb.append(reportStringUtilities.getEncodedWrappedString(name));
				sb.append("</td>\n");

				// description
				if (addDescription(filter)) {
					sb.append("\t\t<td width=\"" + DESCRIPTION_WIDTH
							+ "%\" rowspan=\"" + fileRowSpan + "\" colspan=\""
							+ DESCRIPTION_COLSPAN + "\">");
					sb
							.append(fileSystemEntrySetting.getDescription() != null ? reportStringUtilities
									.getEncodedWrappedString(fileSystemEntrySetting
											.getDescription())
									: "");
					sb.append("</td>\n");
				}

				if (!sourceReadOnly) {
					// default sourcepath
					sb.append("\t\t<td width=\"" + DEFAULT_WIDTH / 2 + "%\">");
					sb.append(fileSystemEntrySetting.getSourceFilePath()
							.getDefaultPath() != null ? reportStringUtilities
							.getEncodedWrappedString(fileSystemEntrySetting
									.getSourceFilePath().getDefaultPath())
							: defaultNotSet);
					sb.append("</td>\n");

					// current sourcepath
					sb.append("\t\t<td width=\"" + CURRENT_WIDTH / 2 + "%\"");
					if (!isDefaultSource) {
						sb.append(" class=\"currentValue\">");
						sb.append(Messages.SourcePath + ": ");
						sb.append("</td>\n\t\t<td width=\""
								+ CURRENT_WIDTH
								/ 2
								+ "%\" class=\"currentValue\">"
								+ reportStringUtilities
										.getEncodedWrappedString(sourceValue));
					} else {
						sb.append(" class=\"defaultValue\">");
						sb.append(Messages.SourcePath + ": ");
						sb.append("</td>\n\t\t<td width=\"" + CURRENT_WIDTH / 2
								+ "%\" class=\"defaultValue\">");
						sb.append(Messages.DefaultTag);
					}
					sb.append("</td>\n");

					// validation error
					if (addValidationErrors(filter)) {
						sb.append("\t\t<td width=\"" + ERROR_WIDTH
								+ "%\" colspan=\"" + ERRORS_COLSPAN + "\">");
						sb
								.append(reportStringUtilities
										.getEncodedWrappedString(getErrorDesc(fileSystemEntrySetting
												.getSourceFilePath())));
						sb.append("</td>\n");
					}
					// note of fileSetting
					if (addNotes(filter)) {
						if (!intoSequence) {
							// if it isn't in sequence, it should has own note
							sb.append("\t\t<td width=\"" + NOTE_WIDTH
									+ "%\" rowspan=\"" + rowspan
									+ "\" colspan=\"" + NOTE_COLSPAN + "\">");
							sb.append(reportStringUtilities
									.getEncodedWrappedString(note));
							sb.append("</td>\n");
						} else {
							// in sequence it generates note column only if it
							// is first sequence item
							if (first) {
								sb.append("\t\t<td width=\"" + NOTE_WIDTH
										+ "%\" rowspan=\"" + rowspan
										+ "\" colspan=\"" + NOTE_COLSPAN
										+ "\">");
								sb.append("</td>\n");
							}
						}
					}
					dontShow = true;
					sb.append("\t</tr>\n");
				}

				if (!sourceReadOnly && !targetReadOnly) {
					sb.append("\t<tr>\n");
				}
				if (!targetReadOnly) {
					// default targetvalue
					sb.append("\t\t<td width=\"" + DEFAULT_WIDTH + "%\">");
					sb.append(fileSystemEntrySetting.getTargetFilePath()
							.getDefaultPath() != null ? reportStringUtilities
							.getEncodedWrappedString(fileSystemEntrySetting
									.getTargetFilePath().getDefaultPath())
							: defaultNotSet);
					sb.append("</td>\n");

					// target value
					sb.append("\t\t<td width=\"" + CURRENT_WIDTH / 2 + "%\"");
					if (!isDefaultTarget) {
						sb.append(" class=\"currentValue\">");
						sb.append(Messages.TargetPath + ": ");
						sb.append("</td>\n\t\t<td width=\""
								+ CURRENT_WIDTH
								/ 2
								+ "%\" class=\"currentValue\">"
								+ reportStringUtilities
										.getEncodedWrappedString(targetValue));
					} else {
						sb.append("class=\"defaultValue\">");
						sb.append(Messages.TargetPath + ": ");
						sb.append("</td>\n\t\t<td width=\"" + CURRENT_WIDTH / 2
								+ "%\" class=\"defaultValue\">");
						sb.append(Messages.DefaultTag);
					}
					sb.append("</td>\n");
					// validation error
					if (addValidationErrors(filter)) {
						sb.append("\t\t<td width=\"" + ERROR_WIDTH
								+ "%\" colspan=\"" + ERRORS_COLSPAN + "\">");
						sb
								.append(reportStringUtilities
										.getEncodedWrappedString(getErrorDesc(fileSystemEntrySetting
												.getTargetFilePath())));
						sb.append("</td>\n");
					}
				}
				if (!dontShow) {
					// note of fileSetting
					if (addNotes(filter)) {
						if (!intoSequence) {
							// if it isn't in sequence, it should has own note
							sb.append("\t\t<td width=\"" + NOTE_WIDTH
									+ "%\" rowspan=\"" + rowspan
									+ "\" colspan=\"" + NOTE_COLSPAN + "\">");
							sb.append(reportStringUtilities
									.getEncodedWrappedString(note));
							sb.append("</td>\n");
						} else {
							// in sequence it generates note column only if it
							// is first sequence item
							if (first) {
								sb.append("\t\t<td width=\"" + NOTE_WIDTH
										+ "%\" rowspan=\"" + rowspan
										+ "\" colspan=\"" + NOTE_COLSPAN
										+ "\">");
								sb.append("</td>\n");
							}

						}
					}
					sb.append("\t</tr>\n");
				}
				// end of row
				if (!sourceReadOnly && !targetReadOnly) {
					sb.append("\t</tr>\n");
				}
				// text layout
			} else {
				// name
				if (!intoSequence) {
					sb.append("\t\t\t<div class=\"setting\">\n");
					sb.append("\t\t\t\t<h5>" + parentCount + "." + leafCount
							+ "." + featCount + "." + settCount + " " + name
							+ "</h5>\n");
				} else {
					sb.append("\t\t\t\t<div class=\"subsetting\">\n");
					sb.append("\t\t\t\t<h6>" + parentCount + "." + leafCount
							+ "." + featCount + "." + settCount + "."
							+ subsettCount + " " + name + "</h6>\n");
				}
				// description
				if (addDescription(filter)) {
					sb
							.append("\t\t\t\t<p class=\"description\">"
									+ (fileSystemEntrySetting.getDescription() != null ? fileSystemEntrySetting
											.getDescription()
											: "") + "</p>\n");
				}
				// properties of setting
				sb.append("\t\t\t\t<div class=\"settingValues\">\n");

				// source path
				if (!sourceReadOnly) {
					sb.append("\t\t\t\t\t<div class=\"Property\">"
							+ Messages.SourcePath + ": </div>\n");
					if (!isDefaultSource) {
						sb.append("\t\t\t\t\t<div class=\"Value\">"
								+ (sourceValue == "" ? "-" : sourceValue)
								+ "<br/></div>\n");
					} else {
						sb.append("\t\t\t\t\t<div class=\"Value\">"
								+ Messages.DefaultTag + "</div>\n");
					}
					// default source path
					sb.append("\t\t\t\t\t<div class=\"Property\">"
							+ Messages.DefaultSourcePath + ": </div>\n");
					sb
							.append("\t\t\t\t\t<div class=\"Value\">"
									+ (fileSystemEntrySetting
											.getSourceFilePath()
											.getDefaultPath() != null ? fileSystemEntrySetting
											.getSourceFilePath()
											.getDefaultPath()
											: "-") + "<br/></div>\n");
				}

				if (!targetReadOnly) {
					// target path
					sb.append("\t\t\t\t\t<div class=\"Property\">"
							+ Messages.TargetPath + "</div>\n");
					if (!isDefaultTarget) {
						sb.append("\t\t\t\t\t<div class=\"Value\">"
								+ (targetValue == "" ? "-" : targetValue)
								+ "<br/></div>\n");
					} else {
						sb.append("\t\t\t\t\t<div class=\"Value\">"
								+ Messages.DefaultTag + "</div>\n");
					}

					// default target path
					sb.append("\t\t\t\t\t<div class=\"Property\">"
							+ Messages.DefaultTargetPath + ": </div>\n");
					sb
							.append("\t\t\t\t\t<div class=\"Value\">"
									+ (fileSystemEntrySetting
											.getTargetFilePath()
											.getDefaultPath() != null ? fileSystemEntrySetting
											.getTargetFilePath()
											.getDefaultPath()
											: "-") + "<br/></div>\n");
				}
				// note
				if (!intoSequence && addNotes(filter)) {
					sb.append("\t\t\t\t\t<div class=\"Property\">"
							+ Messages.Note + ":</div>\n");
					sb.append("\t\t\t\t\t<div class=\"Value\">"
							+ (note.equals("") ? "-" : note) + "<br/></div>\n");
				}

				// validation error
				if (addValidationErrors(filter)) {
					sb.append("\t\t\t\t\t<div class=\"Property\">"
							+ Messages.ValidationError + ":</div>\n");
					sb.append("\t\t\t\t\t<div class=\"Value\">"
							+ (getErrorDesc(fileSystemEntrySetting) == "" ? "-"
									: getErrorDesc(fileSystemEntrySetting))
							+ "<br/></div>\n");
				}
				sb.append("\t\t\t\t</div>\n");
				sb.append("\t\t\t</div>\n");
			}
		}
		return sb;
	}

	/**
	 * Method generates html code for simpleSetting. It needs one row in the
	 * table.
	 * 
	 * @param simpleSetting the setting we want to generate report from
	 * @param filter filter from ReportDialog
	 * @return generated html code in string builder
	 */
	private StringBuilder generateSimpleSetting(SimpleSetting simpleSetting,
			int filter) {
		StringBuilder sb = null;
		boolean isDefault = isDefaultValue(simpleSetting, false);
		String temp = getDefaultSettingValue(simpleSetting);
		String defaultValue = temp != "" ? temp : defaultNotSet;
		if (simpleSetting.getRelevant() != null) {
			System.out.println(simpleSetting.getName() + " "
					+ !simpleSetting.isComputedRelevant());
		}
		String note = getNote(simpleSetting);
		String name = getSettingName(simpleSetting);

		if (addAllSettings(filter) || addOnlyNonDef(filter) && !isDefault
				|| addWithNotes(filter) && !note.equals("")
				|| addWithErrors(filter) && hasSettingError(simpleSetting)
				|| addOnlyTextC(filter)
				&& name.toLowerCase().contains(keyword.toLowerCase())) {
			sb = new StringBuilder();
			String value = getSettingValue(simpleSetting, false);
			// table layout
			if (displayAsTable(filter)) {
				// begining of the row
				sb.append("\t<tr>\n");

				// setting name
				sb.append("\t\t<td width=\"" + NAME_WIDTH + "%\" colspan=\""
						+ NAME_COLSPAN + "\">");
				sb.append(reportStringUtilities.getEncodedWrappedString(name));
				sb.append("</td>\n");

				// description
				if (addDescription(filter)) {
					sb.append("\t\t<td width=\"" + DESCRIPTION_WIDTH
							+ "%\" colspan=\"" + DESCRIPTION_COLSPAN + "\">");
					sb
							.append(simpleSetting.getDescription() != null ? reportStringUtilities
									.getEncodedWrappedString(simpleSetting
											.getDescription())
									: "");
					sb.append("</td>\n");
				}

				// default value
				sb.append("\t\t<td width=\"" + DEFAULT_WIDTH + "%\">");
				sb.append(reportStringUtilities
						.getEncodedWrappedString(defaultValue));
				sb.append("</td>\n");

				// current value
				sb.append("\t\t<td width=\"" + CURRENT_WIDTH + "%\"");
				if (!isDefault) {
					sb.append(" class=\"currentValue\" colspan=\""
							+ CURRENT_VALUE_COLSPAN + "\">");
					sb.append(reportStringUtilities
							.getEncodedWrappedString(value));
				} else {
					sb.append(" class=\"defaultValue\" colspan=\""
							+ CURRENT_VALUE_COLSPAN + "\">");
					sb.append(Messages.DefaultTag);
				}
				sb.append("</td>\n");

				// validation error
				if (addValidationErrors(filter)) {
					sb.append("\t\t<td width=\"" + ERROR_WIDTH
							+ "%\" colspan=\"" + ERRORS_COLSPAN + "\">");
					sb
							.append(reportStringUtilities
									.getEncodedWrappedString(getErrorDesc(simpleSetting)));
					sb.append("</td>\n");
				}
				// note
				if (addNotes(filter)) {
					sb.append("\t\t<td width=\"" + NOTE_WIDTH
							+ "%\" colspan=\"" + NOTE_COLSPAN + "\">");
					sb.append(reportStringUtilities
							.getEncodedWrappedString(note));
					sb.append("</td>\n\t");
				}
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
					sb
							.append("\t\t\t\t<p class=\"description\">"
									+ (simpleSetting.getDescription() != null ? reportStringUtilities
											.getEncodedString(simpleSetting
													.getDescription())
											: "") + "</p>\n");
				}
				sb.append("\t\t\t\t<div class=\"settingValues\">\n");

				// current value
				sb.append("\t\t\t\t\t<div class=\"Property\">" + Messages.Value
						+ ":</div>\n");
				sb.append("\t\t\t\t\t<div class=\"Value\">"
						+ (value == "" ? "-" : reportStringUtilities
								.getEncodedString(value)) + "<br/></div>\n");

				// default value
				sb.append("\t\t\t\t\t<div class=\"Property\">"
						+ Messages.Default + ":</div>\n");
				sb.append("\t\t\t\t\t<div class=\"Value\">"
						+ (defaultValue == "" ? "-" : reportStringUtilities
								.getEncodedString(defaultValue))
						+ "<br/></div>\n");

				// note
				if (addNotes(filter)) {
					sb.append("\t\t\t\t\t<div class=\"Property\">"
							+ Messages.Note + ":</div>\n");
					sb.append("\t\t\t\t\t<div class=\"Value\">"
							+ (note.equals("") ? "-" : reportStringUtilities
									.getEncodedString(note)) + "<br/></div>\n");
				}

				// validation error
				if (addValidationErrors(filter)) {
					sb.append("\t\t\t\t\t<div class=\"Property\">"
							+ Messages.ValidationError + ":</div>\n");
					sb.append("\t\t\t\t\t<div class=\"Value\">"
							+ (getErrorDesc(simpleSetting) == "" ? "-"
									: getErrorDesc(simpleSetting))
							+ "<br/></div>\n");
				}

				sb.append("\t\t\t\t</div>\n");
				sb.append("\t\t\t</div>\n");
			}
		}
		return sb;
	}

	/**
	 * This method returns the name of the setting.
	 * 
	 * @param setting the setting which name we want to know
	 * @return name of the setting or "" if the name is null
	 */
	private String getSettingName(Setting setting) {
		String name = "";
		if (setting.getName() != null) {
			name = setting.getName();
		}
		return name;
	}

	/**
	 * Returns the description of validation error of this setting
	 * 
	 * @param setting setting from which we want to know the validation error
	 *            description
	 * @return the error description or "" if there isn't any
	 */
	private String getErrorDesc(Setting setting) {
		for (Error error : errors) {
			if (setting instanceof FilePath) {
				FilePath fp = (FilePath) setting;
				if (error.getSetting() == fp) {
					if (error.getDescription() != null) {
						return error.getDescription();
					}
				}
			} else if (error.getSetting() == setting) {
				if (error.getDescription() != null) {
					return error.getDescription();
				}
			}
		}
		return "";
	}

	/**
	 * Returns if the specified setting has validation error
	 * 
	 * @param setting setting, we need to know if it has validation error
	 * @return <code>true</code> if setting has validation error,
	 *         <code>false</code> if it hasn't
	 */
	private boolean hasSettingError(Setting setting) {
		if (errors.isEmpty()) {
			return false;
		} else {
			for (Error error : errors) {
				if (setting instanceof FileSystemEntrySetting) {
					FileSystemEntrySetting fses = (FileSystemEntrySetting) setting;
					if (error.getSetting() == fses.getSourceFilePath()) {
						return true;
					}
				} else if (error.getSetting() == setting) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * This method returns the setting's note.
	 * 
	 * @param s setting which note we want to get
	 * @return
	 */
	private String getNote(Setting s) {
		String note = "";
		if (s.getNote() != null) {
			note = s.getNote();
		}
		return note;
	}

	/**
	 * Returns if the setting's value is default. It means the value is the same
	 * as default value
	 * 
	 * @param setting the setting we test if it is default
	 * @return <code>true</code> if setting is default, <code>false</code> if it
	 *         isn't
	 */
	private boolean isDefaultValue(Setting setting, boolean isInSequence) {
		if (isInSequence) {
			if (setting instanceof SimpleSetting) {
				SimpleSetting ss = (SimpleSetting) setting;
				return ss.getValue() == ss.getDefaultValue();
			} else {
				return setting.isDefault();
			}
		} else {
			return setting.isDefault();
		}
	}

	/**
	 * Returns the default value of the setting
	 * 
	 * @param setting from which we want the default value
	 * @return default value of the setting in right format or
	 *         "Default value is not set."
	 */
	private String getDefaultSettingValue(Setting s) {
		if (s instanceof SimpleSetting) {
			SimpleSetting ss = (SimpleSetting) s;

			// Selection setting
			if (ss.getType() == TYPE.SELECTION) {
				String defaultValue = ss.getDefaultValue();
				if (defaultValue == null && defaultValue != "") {
					return "";
				}
				return getOptionName(ss, defaultValue);

				// Multiselection setting
			} else if (ss.getType() == TYPE.MULTISELECTION) {
				String defaultValue = ss.getDefaultValue();
				if (defaultValue == null && defaultValue != "") {
					return "";
				}
				return SettingValueUtils.getValueConvertedToOptionNames(
						defaultValue, ss.getOption());

				// Date/time setting
			} else if (ss.getType() == TYPE.DATE
					|| ss.getType() == TYPE.DURATION
					|| ss.getType() == TYPE.TIME
					|| ss.getType() == TYPE.DATE_TIME) {
				String dv = ss.getDefaultValue();
				if (dv == null && dv != "") {
					return "";
				}
				if (dv.contains(OptionImpl.OPTION_MAP_KEY)) {
					String defaultOptionValue = dv.substring(dv
							.indexOf(OptionImpl.OPTION_MAP_KEY)
							+ OptionImpl.OPTION_MAP_KEY.length());
					int i = defaultOptionValue.lastIndexOf("\"]");
					if (i >= 0) {
						dv = defaultOptionValue.substring(0, i);
					}
				}
				return getCorrectDateTimeFormat(dv, ss.getType());
			}

			// simple setting
			String defaultValue = ss.getDefaultValue();
			if (defaultValue != "" && defaultValue != null) {
				if (defaultValue.contains(OptionImpl.OPTION_MAP_KEY)) {
					String defaultOptionValue = defaultValue
							.substring(defaultValue
									.indexOf(OptionImpl.OPTION_MAP_KEY)
									+ OptionImpl.OPTION_MAP_KEY.length());
					int i = defaultOptionValue.lastIndexOf("\"]");
					if (i >= 0) {
						defaultValue = defaultOptionValue.substring(0, i);
					}
				}
				return defaultValue;
			}
		}
		return "";
	}

	/**
	 * Returns the value of the setting
	 * 
	 * @param setting from which we want the value
	 * @return setting's value in correct format or "Default" or
	 *         "Value is not defined."
	 */
	private String getSettingValue(Setting setting, boolean isInSequence) {
		if (setting instanceof SimpleSetting) {
			SimpleSetting ss = (SimpleSetting) setting;
			// simple setting
			String value = "";
			if (isDefaultValue(setting, isInSequence)) {
				return Messages.DefaultTag;
			} else if (ss.getValue() != null) {

				value = reportStringUtilities.getEncodedWrappedString(
						ss.getValue()).toString();
			} else {
				value = "*";
			}
			// Selection setting
			if (ss.getType() == TYPE.SELECTION) {
				return getOptionName(ss, ss.getValue());

				// Multiselection setting
			} else if (ss.getType() == TYPE.MULTISELECTION) {
				value = ss.getValue();
				if (value == null) {
					return "";
				}
				return reportStringUtilities.getEncodedWrappedString(
						SettingValueUtils.getValueConvertedToOptionNames(value,
								ss.getOption())).toString();

				// Date/time setting
			} else if (ss.getType() == TYPE.DATE
					|| ss.getType() == TYPE.DURATION
					|| ss.getType() == TYPE.TIME
					|| ss.getType() == TYPE.DATE_TIME) {
				value = ss.getValue();
				if (value == null) {
					return "";
				}
				if (value.contains(OptionImpl.OPTION_MAP_KEY)) {
					String defaultOptionValue = value.substring(value
							.indexOf(OptionImpl.OPTION_MAP_KEY)
							+ OptionImpl.OPTION_MAP_KEY.length());
					int i = defaultOptionValue.lastIndexOf("\"]");
					if (i >= 0) {
						value = defaultOptionValue.substring(0, i);
					}
				}
				return getCorrectDateTimeFormat(value, ss.getType());
			}
			if (ss.getChoosenOption() != null) {
				return reportStringUtilities.getEncodedWrappedString(
						ss.getChoosenOption()).toString();
			}
			return value;
		}
		return "";
	}

	/**
	 * This method returns user friendly format of date/time
	 * 
	 * @param input date/time value from setting
	 * @param type TYPE.DATE or TYPE.TIME or TYPE.DURATION or TYPE.DATE_TIME
	 * @return user friendly format of the value
	 */
	private String getCorrectDateTimeFormat(String input, TYPE type) {
		if (input == null || input == "") {
			return "";
		}
		String result = input;
		// to format 2008-11-09 Z or 2008-11-09 +06:00
		if (type == TYPE.DATE) {
			String lastSegment = "";
			int secondPos = 0;
			int firstPos = input.indexOf("-");
			if (firstPos != -1) {
				secondPos = input.indexOf("-", firstPos + 1);
				if (secondPos != -1) {
					lastSegment = input.substring(secondPos + 1);
				}
			}
			Pattern pat;
			if (lastSegment.contains("+") || lastSegment.contains("-")) {
				pat = Pattern.compile("[+ ||-]");
			} else {
				pat = Pattern.compile("[\\D &&[\\w]]");
			}
			Matcher matcher = pat.matcher(lastSegment);
			if (matcher.find()) {
				int pos = matcher.start();
				String datePart = input.substring(0, secondPos + pos + 1);
				String zonePart = input.substring(secondPos + 1 + pos);
				result = datePart.concat(" ").concat(zonePart);
			}

			// to format 1Y 2M 3D 4H 5Min 6Sec
		} else if (type == TYPE.DURATION) {
			input = input.substring(1);
			String[] segment = input.split("T");
			if (segment.length > 1) {
				String datePart = segment[0];
				String timePart = segment[1];
				timePart = timePart.replace("M", Messages.Minutes);
				timePart = timePart.replace("S", Messages.Seconds);
				input = datePart.concat(timePart);
				Pattern pat = Pattern.compile("[\\D &&[\\w]]+");
				Matcher matcher = pat.matcher(input);
				result = input;
				int i = 0;
				while (matcher.find()) {
					int pos = matcher.end();
					result = result.substring(0, pos + i).concat(" ").concat(
							input.substring(pos));
					i++;
				}
				result = result.trim();
			}

			// to format 15:33:12 +06:00 or 15:33:12 Z
		} else if (type == TYPE.TIME) {
			Pattern pat;
			if (input.contains("+") || input.contains("-")) {
				pat = Pattern.compile("[+ ||-]");
			} else {
				pat = Pattern.compile("[\\D &&[\\w]]");
			}
			Matcher matcher = pat.matcher(input);
			if (matcher.find()) {
				int pos = matcher.start();
				String datePart = input.substring(0, pos);
				String zonePart = input.substring(pos);
				result = datePart.concat(" ").concat(zonePart);
			}

			// to format 2008-02-19 15:42:12 Z or 2008-11-09 11:32:02 +06:00
		} else if (type == TYPE.DATE_TIME) {
			int firstPos = input.indexOf("T");
			if (firstPos != -1) {
				String datePart = input.substring(0, firstPos);
				String timePart = getCorrectDateTimeFormat(input
						.substring(firstPos + 1), TYPE.TIME);
				result = datePart.concat(" ").concat(timePart);
			}
		}
		return result;
	}

	/**
	 * Returns the option name for SelectionSetting, instead of number of option
	 * 
	 * @param setting the simpleSetting with type = Selection
	 * @param value the option number (from getValue() or getDefaultValue())
	 * @return the option name
	 */
	private String getOptionName(SimpleSetting setting, String value) {

		for (Option option : setting.getOption()) {
			if (option.getValue().equals(value)) {
				return option.getName();
			}
		}
		return "";
	}

	/**
	 * Method returns the count of rows in sequence. It is used only in table
	 * format. The count of rows is not the same as count of subsettings
	 * 
	 * @param sequenceSetting the sequence setting
	 * @return the number of rows in sequence html table.
	 */
	private int countSeqSettings(SequenceSetting sequenceSetting) {
		int number = 0;
		if (sequenceSetting instanceof SequenceSetting) {
			SequenceSetting seq = (SequenceSetting) sequenceSetting;
			EList<SequenceItem> sequenceItems = seq.getSequenceItem();
			for (SequenceItem sequenceItem : sequenceItems) {
				EList<Setting> settings = sequenceItem.getSetting();
				for (Setting setting : settings) {
					if (setting instanceof FileSystemEntrySetting) {
						number = number + 2;
					} else if (setting instanceof SequenceSetting) {
						number = number
								+ countSeqSettings((SequenceSetting) setting);
					} else {
						number++;
					}
				}
			}
		}
		return number;

	}

	/**
	 * Generates sequence setting and its sequence items to html code according
	 * to filter rules
	 * 
	 * @param sequenceSetting sequence setting
	 * @param filter filter from ReportDialog
	 * @param rowSpan number of rows = number of sequence settings
	 * @return generated html code in string builder
	 */
	private StringBuilder generateSeq(SequenceSetting sequenceSetting,
			int filter, int rowSpan) {
		StringBuilder sb = new StringBuilder();
		boolean isDefault;
		String note = getNote(sequenceSetting);
		String name = getSettingName(sequenceSetting);
		EList<SequenceItem> sequenceItems = sequenceSetting.getSequenceItem();

		// show this sequence - contains sequence name specified keyword?
		if (addOnlyTextC(filter)
				&& !name.toLowerCase().contains(keyword.toLowerCase())) {
			return null;
		}

		// show this sequence - has this sequence note?
		if (addWithNotes(filter) && note.equals("")) {
			return null;
		}

		// are there settings with validation errors?
		int errorsCount = 0;

		// has sequence error?
		if (addWithErrors(filter) && hasSettingError(sequenceSetting)) {
			errorsCount++;
		}
		// has any sequence item error?
		if (addWithErrors(filter)) {
			for (SequenceItem sequenceItem : sequenceItems) {
				EList<Setting> settings = sequenceItem.getSetting();
				for (Setting simpleSetting : settings) {
					if (hasSettingError(simpleSetting)) {
						errorsCount++;
					}
				}
			}
			if (errorsCount == 0) {
				return null;
			}
		}

		// is this sequence default?
		if (addOnlyNonDef(filter) && sequenceSetting.isDefault()) {
			return null;
		}

		int i = 0;
		for (SequenceItem sequenceItem : sequenceItems) {
			EList<Setting> settings = sequenceItem.getSetting();
			List<Setting> goodSettings = new ArrayList<Setting>();
			for (Setting setting : settings) {
				if (setting.getRelevant() != null
						&& !setting.isComputedRelevant()) {
					continue;
				}
				goodSettings.add(setting);
			}
			for (Setting setting : goodSettings) {
				// subsetting is simpleSetting
				if (setting instanceof SimpleSetting) {
					SimpleSetting simpleSetting = (SimpleSetting) setting;
					String sname = getSettingName(simpleSetting);

					// table layout
					if (displayAsTable(filter)) {

						// start of row
						sb.append("\t<tr>\n");

						// name
						sb.append("\t\t<td width=\""
								+ (NAME_WIDTH - SEQ_NAME_SPACE) + "%\">");
						sb.append(reportStringUtilities
								.getEncodedWrappedString(sname));
						sb.append("</td>\n");

						// description
						if (addDescription(filter)) {
							sb.append("\t\t<td width=\"" + DESCRIPTION_WIDTH
									+ "%\">");
							String desc = simpleSetting.getDescription();
							String temp = desc == null || desc.equals("") ? ""
									: desc;

							sb.append(reportStringUtilities
									.getEncodedWrappedString(temp));
							sb.append("</td>\n");
						}

						// default value
						sb.append("\t\t<td width=\"" + DEFAULT_WIDTH + "%\">");

						String temp = getDefaultSettingValue(simpleSetting);
						String defValue = temp != "" ? temp : defaultNotSet;
						sb.append(reportStringUtilities
								.getEncodedWrappedString(defValue));
						sb.append("</td>\n");

						// current value
						String value = getSettingValue(simpleSetting, true);
						isDefault = isDefaultValue(simpleSetting, true);
						sb.append("\t\t<td width=\"" + CURRENT_WIDTH + "%\"");
						if (!isDefault) {
							sb.append(" class=\"currentValue\" colspan=\""
									+ CURRENT_VALUE_COLSPAN + "\">");
							sb.append(reportStringUtilities
									.getEncodedWrappedString(value));
						} else {
							sb.append(" class=\"defaultValue\" colspan=\""
									+ CURRENT_VALUE_COLSPAN + "\">");
							sb.append(Messages.DefaultTag);
						}
						sb.append("</td>\n");

						// validation error
						if (addValidationErrors(filter)) {
							sb
									.append("\t\t<td width=\"" + ERROR_WIDTH
											+ "%\" colspan=\"" + ERRORS_COLSPAN
											+ "\">");
							sb
									.append(reportStringUtilities
											.getEncodedWrappedString(getErrorDesc(simpleSetting)));
							sb.append("</td>\n");
						}
						// end of row
						sb.append("\t</tr>\n");

						// text format
					} else {
						// name
						sb.append("\t\t\t\t<div class=\"subsetting\">\n");
						sb.append("\t\t\t\t\t<h6>" + parentCount + "."
								+ leafCount + "." + featCount + "." + settCount
								+ "." + subsettCount + " " + sname + "</h6>\n");

						// description
						String desc = reportStringUtilities.getEncodedString(
								simpleSetting.getDescription()).toString();
						String temp = desc.equals("") ? "" : desc;
						if (addDescription(filter)) {
							sb.append("\t\t\t\t\t<p class=\"description\">"
									+ temp + "</p>\n");
						}

						sb.append("\t\t\t\t\t<div class=\"settingValues\">\n");

						// current value
						sb.append("\t\t\t\t\t\t<div class=\"Property\">"
								+ Messages.Value + ":</div>\n");
						String value = reportStringUtilities.getEncodedString(
								getSettingValue(simpleSetting, true))
								.toString();
						sb.append("\t\t\t\t\t\t<div class=\"Value\">"
								+ (value.equals("") ? "-" : value)
								+ "<br/></div>\n");

						// default value
						sb.append("\t\t\t\t\t\t<div class=\"Property\">"
								+ Messages.Default + ":</div>\n");
						String tmp = getDefaultSettingValue(simpleSetting);
						String def = tmp != "" ? tmp : defaultNotSet;
						String defValue = reportStringUtilities
								.getEncodedString(def).toString();
						sb.append("\t\t\t\t\t\t<div class=\"Value\">"
								+ defValue + "<br/></div>\n");

						// validation error
						if (addValidationErrors(filter)) {
							sb.append("\t\t\t\t\t<div class=\"Property\">"
									+ Messages.ValidationError + ":</div>\n");
							sb
									.append("\t\t\t\t\t<div class=\"Value\">"
											+ (!getErrorDesc(simpleSetting)
													.equals("") ? getErrorDesc(simpleSetting)
													: "-") + "<br/></div>\n");
						}

						sb.append("\t\t\t\t\t</div>\n");
						sb.append("\t\t\t\t</div>\n");
					}

					// subsetting is fileSetting
				} else if (setting instanceof FileSystemEntrySetting) {
					FileSystemEntrySetting fss = (FileSystemEntrySetting) setting;
					sb.append(generateFileSetting(fss, filter, true, (i == 0),
							rowSpan));
				}
				i++;

			}
			subsettCount++;
		}
		return sb;
	}

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
		int nrOfErrors = 0;
		int nrOfResources = 0;
		int nrOfChanges = 0;
		int nrOfNotes = 0;
		int nrOfGroups = 0;
		int nrOfFeatures = 0;
		int nrOfSettings = 0;
		IEditorPart activeEditor = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if (activeEditor instanceof CPFEditor) {
			editor = (CPFEditor) activeEditor;
			ErrorsRoot errorsRoot = editor.getErrorsRoot();
			if (errorsRoot != null) {
				errors = errorsRoot.getErrors();
				nrOfErrors = errors.size();
			}
		}
		ResourceModelRoot resourceRoot = (ResourceModelRoot) editor
				.getAdapter(ResourceModelRoot.class);
		if (resourceRoot != null) {
			nrOfResources = resourceRoot.getSize();
		}
		EList<Setting> allSettings = view.getSharedSettingInstances();
		nrOfFeatures = view.getSharedFeatures().size();
		for (Setting setting : allSettings) {
			if (!setting.isVisible()) {
				continue;
			}
			if (!setting.isDefault()) {
				nrOfChanges++;
			}
		}
		Set<String> featureRefSet = new HashSet<String>();
		Set<String> parentGroupSet = new HashSet<String>();
		EList<Setting> sharedSettingInstances = editor.getView()
				.getSharedSettingInstances();

		// the list of settings that aren't read-only
		List<Setting> visibleSettings = new ArrayList<Setting>();
		for (Setting setting : sharedSettingInstances) {
			if (setting.isVisible()) {
				visibleSettings.add(setting);
			}
		}

		for (Setting setting : visibleSettings) {
			featureRefSet.add(setting.getFeatureRef());
			EList<LeafGroup> leafGroups = setting.getLeafGroup();
			for (LeafGroup leafGroup : leafGroups) {
				parentGroupSet.add(((ParentGroup) leafGroup.eContainer())
						.getName());
			}

			EList<ParentGroup> parentGroups = setting.getParentGroup();
			for (ParentGroup parentGroup : parentGroups) {
				parentGroupSet.add(parentGroup.getName());
			}

		}
		nrOfSettings = visibleSettings.size();
		nrOfFeatures = featureRefSet.size();
		nrOfGroups = parentGroupSet.size();
		if (editor != null) {
			nrOfChanges = editor.getNrOfChanges(view);
			nrOfNotes = editor.getNrOfNotes(view);
			EList<UISummaryGroup> uiGroups = editor.getSummaryModelroot()
					.getUiGroups();
			if (displayAsTable(filter)) {
				sumsb.append("<center><h2>" + Messages.Summary
						+ "</h2></center>\n");
				sumsb
						.append("<table class=\"summary\" align=\"center\" cellspacing=\"0\">\n");
				for (UISummaryGroup summaryGroup : uiGroups) {
					sumsb
							.append("\t<tr>\n\t\t<th class=\"featureName\" colspan=\"2\">"
									+ summaryGroup.getTitle()
									+ "</th>\n\t</tr>\n");
					EList<UIElement> uiElements = summaryGroup.getUiElements();

					for (UIElement element : uiElements) {
						if (Messages.CPFTitle.equals(element.getName())) {
							name = element.getValue();
						} else {
							String propertyName = element.getName() != null
									&& !"".equals(element.getName()) ? element
									.getName() : "";
							String propertyValue = element.getValue() != null
									&& !"".equals(element.getValue()) ? element
									.getValue() : "";
							if (propertyValue != ""
									&& !Messages.AVR.equals(propertyName)) {
								sumsb.append("\t<tr>\n\t\t<td>" + propertyName
										+ "</td>\n\t\t<td>" + propertyValue
										+ "</td>\n\t</tr>\n");
							} else {
								if (!Messages.CustomizationGuideline
										.equals(propertyName)
										&& !Messages.AVR.equals(propertyName)
										&& !Messages.ProductImages
												.equals(propertyName)) {
									sumsb.append("\t<tr>\n\t\t<td>"
											+ propertyName + "</td>\n\t\t<td>");
									if (Messages.Contents.equals(propertyName)) {
										sumsb.append(nrOfErrors + " "
												+ Messages.Errors + "<br/>");
										sumsb.append(nrOfNotes + " "
												+ Messages.Notes + "<br/>");
										sumsb.append(nrOfChanges + " "
												+ Messages.SettingsChanged
												+ "<br/>");
										sumsb.append(nrOfResources + " "
												+ Messages.Resources + "<br/>");
										sumsb.append(nrOfGroups + " "
												+ Messages.Groups + "<br/>");
										sumsb.append(nrOfFeatures + " "
												+ Messages.Features + "<br/>");
										sumsb.append(nrOfSettings + " "
												+ Messages.Settings + "<br/>");
									} else if (Messages.ChangeHistory
											.equals(propertyName)) {
										History history = editor
												.getViewEditorModel()
												.getHistory();
										EList<Note> historyNote = history
												.getNote();
										for (Note note : historyNote) {
											sumsb.append(note.getDate() + ": "
													+ note.getContent()
													+ "<br/>");
										}
									}

									sumsb.append("</td>\n");
								}
							}
						}
					}
				}
				sumsb.append("</table>\n");
			} else {
				sumsb.append("<h2>" + Messages.Summary + "</h2>\n");
				for (UISummaryGroup summaryGroup : uiGroups) {
					sumsb.append("\t<div class=\"setting\">\n");
					sumsb.append("\t\t<h5>" + summaryGroup.getTitle()
							+ "</h5>\n");
					sumsb.append("\t\t\t<div class=\"settingValues\">\n");
					EList<UIElement> uiElements = summaryGroup.getUiElements();
					for (UIElement element : uiElements) {
						if (element.getName().equals(Messages.CPFTitle)) {
							name = element.getValue();
						} else {
							String propertyName = element.getName() != null
									&& !"".equals(element.getName()) ? element
									.getName() : "-<br/>";
							String propertyValue = element.getValue() != null
									&& !"".equals(element.getValue()) ? element
									.getValue() : "-<br/>";
							if (element.getValue() != ""
									&& !Messages.AVR.equals(propertyName)) {
								sumsb
										.append("\t\t\t<div class=\"PropertySum\">"
												+ propertyName + "</div>\n");
								sumsb.append("\t\t\t<div class=\"Value\">"
										+ propertyValue + "<br/></div>\n");
							} else {
								if (!Messages.CustomizationGuideline
										.equals(propertyName)
										&& !Messages.AVR.equals(propertyName)
										&& !Messages.ProductImages
												.equals(propertyName)) {
									sumsb
											.append("\t\t\t<div class=\"PropertySum\">"
													+ propertyName + "</div>\n");
									if (Messages.Contents.equals(propertyName)) {
										sumsb
												.append("\t\t\t<div class=\"Value\">");
										sumsb.append(nrOfErrors + " "
												+ Messages.Errors
												+ "<br/></div>\n");
										sumsb
												.append("\t\t\t<div class=\"PropertySum\"><br/></div>\n");
										sumsb
												.append("\t\t\t<div class=\"Value\">");
										sumsb.append(nrOfNotes + " "
												+ Messages.Notes
												+ "<br/></div>\n");
										sumsb
												.append("\t\t\t<div class=\"PropertySum\"><br/></div>\n");
										sumsb
												.append("\t\t\t<div class=\"Value\">");
										sumsb.append(nrOfChanges + " "
												+ Messages.SettingsChanged
												+ "<br/></div>\n");
										sumsb
												.append("\t\t\t<div class=\"PropertySum\"><br/></div>\n");
										sumsb
												.append("\t\t\t<div class=\"Value\">");
										sumsb.append(nrOfResources + " "
												+ Messages.Resources
												+ "<br/></div>\n");
										sumsb
												.append("\t\t\t<div class=\"PropertySum\"><br/></div>\n");
										sumsb
												.append("\t\t\t<div class=\"Value\">");
										sumsb.append(nrOfGroups + " "
												+ Messages.Groups
												+ "<br/></div>\n");
										sumsb
												.append("\t\t\t<div class=\"PropertySum\"><br/></div>\n");
										sumsb
												.append("\t\t\t<div class=\"Value\">");
										sumsb.append(nrOfFeatures + " "
												+ Messages.Features
												+ "<br/></div>\n");
										sumsb
												.append("\t\t\t<div class=\"PropertySum\"><br/></div>\n");
										sumsb
												.append("\t\t\t<div class=\"Value\">");
										sumsb.append(nrOfSettings + " "
												+ Messages.Settings
												+ "<br/></div>\n");
									} else if (Messages.ChangeHistory
											.equals(propertyName)) {
										History history = editor
												.getViewEditorModel()
												.getHistory();
										EList<Note> historyNote = history
												.getNote();
										if (historyNote.size() == 0) {
											sumsb
													.append("\t\t\t<div class=\"PropertySum\"><br/></div>\n");
											sumsb
													.append("\t\t\t<div class=\"Value\">-<br/></div>\n");
										} else {
											for (Note note : historyNote) {
												sumsb
														.append("\t\t\t<div class=\"PropertySum\"><br/></div>\n");
												sumsb
														.append("\t\t\t<div class=\"Value\">");
												sumsb.append(note.getDate()
														+ ": "
														+ note.getContent()
														+ "<br/>");
												sumsb.append("</div>\n");
											}
										}
									} else {
										sumsb
												.append("\t\t\t<div class=\"Value\">");
										sumsb.append(propertyValue);
										sumsb.append("</div>\n");
									}
								}
							}
						}
					}
					sumsb.append("\t\t</div>\n");
					sumsb.append("\t</div>\n");
				}
			}
		}
		sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
		sb
				.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n");
		sb
				.append("<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en-US\" lang=\"en-US\">\n");
		sb.append("<head profile=\"http://www.w3.org/2000/08/w3c-synd/#\">\n");
		sb
				.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"></meta>\n");
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
		sb.append("<p id=\"date\">" + sdf.format(new java.util.Date())
				+ "</p>\n");
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
	 * @param keyword the keyword to set
	 */
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	/**
	 * Decode from filter if the report will be generated from all settings in
	 * view
	 * 
	 * @param filter filter from ReportDialog
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
	 * @param filter filter from ReportDialog
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
	 * that contain the entered keyword in their names
	 * 
	 * @param filter filter from ReportDialog
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
	 * which have notes
	 * 
	 * @param filter filter from ReportDialog
	 * @return <code>true</code> if only settings with notes will be generated,
	 *         <code>false</code> if not
	 */
	private boolean addWithNotes(int filter) {
		if ((filter & WITH_NOTES) != 0) {
			return true;
		}
		return false;
	}

	/**
	 * Decode from filter if the report will be generated only from settings
	 * which have validation errors
	 * 
	 * @param filter filter from ReportDialog
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
	 * @param filter filter from ReportDialog
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
	 * Decode from filter if user want to generate table of contents and if he
	 * want to show groups of settings
	 * 
	 * @param filter filter from ReportDialog
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
	 * @param filter filter from ReportDialog
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
	 * @param filter filter from ReportDialog
	 * @return <code>true</code> if user wants table format, <code>false</code>
	 *         if user wants text format
	 */
	public boolean displayAsTable(int filter) {
		if ((filter & TO_TABLE) != 0) {
			return true;
		}
		return false;
	}

	/**
	 * Decode from filter if user want to show column with validation errors
	 * 
	 * @param filter filter from ReportDialog
	 * @return <code>true</code> if column will be displayed <code>false</code>
	 *         if it won't
	 */
	private boolean addValidationErrors(int filter) {
		if ((filter & SHOW_VALIDATION_ERROR_COLUMN) != 0) {
			return true;
		}
		return false;
	}

	/**
	 * Decode from filter if user want to show column with notes
	 * 
	 * @param filter filter from ReportDialog
	 * @return <code>true</code> if column will be displayed <code>false</code>
	 *         if it won't
	 */
	private boolean addNotes(int filter) {
		if ((filter & SHOW_NOTE_COLUMN) != 0) {
			return true;
		}
		return false;
	}

}
