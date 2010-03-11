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

package com.nokia.tools.variant.editor.editors;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import com.nokia.tools.variant.confml.expressions.settings.ConfmlLexer;
import com.nokia.tools.variant.confml.expressions.settings.ConfmlParser;
import com.nokia.tools.variant.content.confml.Feature;
import com.nokia.tools.variant.content.confml.FileSystemEntrySetting;
import com.nokia.tools.variant.content.confml.SequenceItem;
import com.nokia.tools.variant.content.confml.SequenceSetting;
import com.nokia.tools.variant.content.confml.Setting;
import com.nokia.tools.variant.content.confml.View;

/**
 * Parses setting refs from relevant and constraint attributes of confml setting and feature.
 * 
 */
public class ConfMLExpressionSettingUtil {

	/**
	 * Parses settings ref from relevant attribute of the setting
	 * 
	 * @param setting
	 * @return
	 */
	public static Set<Setting> getSettingsRefFromRelevant(Setting setting) {
		String relevant = setting.getRelevant();
		if (relevant != null && !relevant.equals("")) {
			try {
				return getSettings(setting, relevant);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (RecognitionException e) {
				e.printStackTrace();
			}
		}
		return new HashSet<Setting>();
	}

	/**
	 * Parses settings ref from relevant attribute of the setting
	 * @param view 
	 * 
	 * @param setting
	 * @return
	 */
	public static Set<Setting> getSettingsRefFromOptionRelevant(View view, Setting setting,String relevant) {
		if (relevant != null && !relevant.equals("")) {
			try {
				return getSettings(view, setting, relevant);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (RecognitionException e) {
				e.printStackTrace();
			}
		}
		return new HashSet<Setting>();
	}
	
	/**
	 * Parses settings ref from constraint attribute of the setting
	 * 
	 * @param setting
	 * @param expression
	 * @return
	 */
	public static Set<Setting> getSettingsRefFromConstraint(Setting setting) {
		String constraint = setting.getConstraint();
		if (constraint != null && !constraint.equals("")) {
			try {
				return getSettings(setting, constraint);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (RecognitionException e) {
				e.printStackTrace();
			}
		}

		return new HashSet<Setting>();
	}
	
	/**
	 * Parses settings ref from relevant attribute of the feature
	 * 
	 * @param setting
	 * @return
	 */
	public static Set<Setting> getSettingsRefFromRelevant(Feature feature) {
		String relevant = feature.getRelevant();
		if (relevant != null && !relevant.equals("")) {
			try {
				return getSettings(feature, relevant);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (RecognitionException e) {
				e.printStackTrace();
			}
		}
		return new HashSet<Setting>();
	}
	
	/**
	 * Evaluates ConfML expression
	 * 
	 * @param expression
	 * @return
	 * @throws IOException
	 * @throws RecognitionException
	 */
	@SuppressWarnings("unchecked")
	private static Set<Setting> getSettings(Setting setting, String expression)
			throws IOException, RecognitionException {
		Set<Setting> result = new HashSet<Setting>();
		expression += "\r\n";

		// Create an input character stream from standard in
		ByteArrayInputStream bais = new ByteArrayInputStream(expression
				.getBytes());
		ANTLRInputStream input = new ANTLRInputStream(bais);
		// Create an ExprLexer that feeds from that stream
		ConfmlLexer lexer = new ConfmlLexer(input);
		// Create a stream of tokens fed by the lexer
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		// Create a parser that feeds off the token stream
		ConfmlParser parser = new ConfmlParser(tokens);

		// set parser . context
		parser.setSetting(setting);

		// set parser a View
		View view = null;
		if (setting.eContainer() instanceof View) { // simple setting
			view = (View) setting.eContainer();
		} else if (setting.eContainer() instanceof SequenceItem) { //
			SequenceItem si = (SequenceItem) setting.eContainer();
			EObject container = si.eContainer().eContainer();
			if (container instanceof View) {
				view = (View) container;
			}
		} else if (setting.eContainer() instanceof FileSystemEntrySetting) {
			// file's sub - setting
			FileSystemEntrySetting fileSetting = (FileSystemEntrySetting) setting
					.eContainer();

			if (fileSetting.eContainer() instanceof View) {
				// simple file
				view = (View) fileSetting.eContainer();
			} else if (fileSetting.eContainer() instanceof SequenceItem) {
				// file in sequence
				view = (View) fileSetting.eContainer().eContainer();
			}
		}
		parser.setView(view);

		// set parser a sequence item
		SequenceItem si = null;
		if (setting.eContainer() instanceof SequenceItem) {
			si = (SequenceItem) setting.eContainer();
		} else if (setting.eContainer() instanceof FileSystemEntrySetting) {
			EObject fileSetting = setting.eContainer();
			if (fileSetting.eContainer() instanceof SequenceItem) {
				si = (SequenceItem) fileSetting.eContainer();
			}
		}
		parser.setSequenceItem(si);

		// set parser a feature ref
		parser.setFeatureRef(setting.getFeatureRef());

		Object exprResult = parser.expr();

		if (exprResult instanceof Set) {
			result = (Set<Setting>) exprResult;
			result.remove(null);
		}

		return result;
	}
	
	/**
	 * Evaluates ConfML expression
	 * 
	 * @param expression
	 * @return
	 * @throws IOException
	 * @throws RecognitionException
	 */
	@SuppressWarnings("unchecked")
	private static Set<Setting> getSettings(View view, Setting setting, String expression)
			throws IOException, RecognitionException {
		Set<Setting> result = new HashSet<Setting>();
		expression += "\r\n";

		// Create an input character stream from standard in
		ByteArrayInputStream bais = new ByteArrayInputStream(expression
				.getBytes());
		ANTLRInputStream input = new ANTLRInputStream(bais);
		// Create an ExprLexer that feeds from that stream
		ConfmlLexer lexer = new ConfmlLexer(input);
		// Create a stream of tokens fed by the lexer
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		// Create a parser that feeds off the token stream
		ConfmlParser parser = new ConfmlParser(tokens);

		// set parser . context
		parser.setSetting(setting);

		// set parser a View
		parser.setView(view);

		// set parser a sequence item
		SequenceItem si = null;
		if (setting.eContainer() instanceof SequenceItem) {
			si = (SequenceItem) setting.eContainer();
		} else if (setting.eContainer() instanceof FileSystemEntrySetting) {
			EObject fileSetting = setting.eContainer();
			if (fileSetting.eContainer() instanceof SequenceItem) {
				si = (SequenceItem) fileSetting.eContainer();
			}
		}
		parser.setSequenceItem(si);

		// set parser a feature ref
		parser.setFeatureRef(setting.getFeatureRef());

		Object exprResult = parser.expr();

		if (exprResult instanceof Set) {
			result = (Set<Setting>) exprResult;
			result.remove(null);
		}

		return result;
	}
	
	
	/**
	 * Evaluates ConfML expression
	 * 
	 * @param expression
	 * @return
	 * @throws IOException
	 * @throws RecognitionException
	 */
	@SuppressWarnings("unchecked")
	private static Set<Setting> getSettings(Feature feature, String expression)
			throws IOException, RecognitionException {
		Set<Setting> result = new HashSet<Setting>();
		expression += "\r\n";

		// Create an input character stream from standard in
		ByteArrayInputStream bais = new ByteArrayInputStream(expression
				.getBytes());
		ANTLRInputStream input = new ANTLRInputStream(bais);
		// Create an ExprLexer that feeds from that stream
		ConfmlLexer lexer = new ConfmlLexer(input);
		// Create a stream of tokens fed by the lexer
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		// Create a parser that feeds off the token stream
		ConfmlParser parser = new ConfmlParser(tokens);

		// set parser . context
		parser.setFeatureRef(feature.getRef());

		// set parser a View
		View view = null;
		if (feature.eContainer() instanceof View) {
			view = (View) feature.eContainer();
		}
		parser.setView(view);

		Object exprResult = parser.expr();

		if (exprResult instanceof Set) {
			result = (Set<Setting>) exprResult;
			result.remove(null);
		}

		return result;
	}

	public static void setSettingDependencies(View view, Setting setting) {
		Set<Setting> constraint = getSettingsRefFromConstraint(setting);
		constraint.addAll(getSettingsRefFromRelevant(setting));
		for (Setting set : constraint) {
			for (Setting s : view.getSharedSettingInstances()) {
				if (s instanceof SequenceSetting) {
					handleSettingDependency(setting, set, s);
					EList<SequenceItem> sequenceItems = ((SequenceSetting) s).getSequenceItem();
					for (SequenceItem si : sequenceItems) {
						EList<Setting> settings = si.getSetting();
						for (Setting subSetting : settings) {
							handleSettingDependency(setting, set, subSetting);
						}
					}
				} else {
					handleSettingDependency(setting, set, s);
				}
			}
		}
	}

	private static void handleSettingDependency(Setting handled, Setting constraint, Setting searched) {
		if (searched.getAbsRef().equals(constraint.getAbsRef()) && !handled.getAbsRef().equals(constraint.getAbsRef())) {
			EList<Object> dependencies = searched.getDependencies();
			if (dependencies == null) {
				dependencies = new BasicEList<Object>();
				dependencies.add(handled);
				searched.setDependencies(dependencies);
			} else {
				Iterator<Object> it = dependencies.iterator();
				boolean found = false;
				while (it.hasNext()) {
					Object next = it.next();
					if (next instanceof Setting) {
						Setting nextSetting = (Setting) next;
						if (nextSetting.getAbsRef().equals(handled.getAbsRef())) {
							found = true;
						}
					}
				}
				if (found == false) {
					dependencies.add(handled);
					searched.setDependencies(dependencies);
				}
			}
		}
	}

	public static void setSettingDependencies(View view, Feature feature) {
		Set<Setting> constraint = getSettingsRefFromRelevant(feature);
		for (Setting set : constraint) {
			for (Setting s : view.getSharedSettingInstances()) {
				if (s instanceof SequenceSetting) {
					handleFeatureDependency(feature, set, s);
					EList<SequenceItem> sequenceItems = ((SequenceSetting) s).getSequenceItem();
					for (SequenceItem si : sequenceItems) {
						EList<Setting> settings = si.getSetting();
						for (Setting subSetting : settings) {
							handleFeatureDependency(feature, set, subSetting);
						}
					}
				} else {
					handleFeatureDependency(feature, set, s);
				}
			}
		}
	}

	private static void handleFeatureDependency(Feature feature, Setting constraint, Setting searched) {
		if (searched.getAbsRef().equals(constraint.getAbsRef())) {
			EList<Object> dependencies = searched.getDependencies();
			if (dependencies == null) {
				dependencies = new BasicEList<Object>();
				dependencies.add(feature);
				searched.setDependencies(dependencies);
			} else {
				Iterator<Object> it = dependencies.iterator();
				boolean found = false;
				while (it.hasNext()) {
					Object next = it.next();
					if (next instanceof Feature) {
						Feature f = (Feature) next;
						if (f.getRef().equals(feature.getRef())) {
							found = true;
						}
					}
				}
				if (found == false) {
					dependencies.add(feature);
					searched.setDependencies(dependencies);
				}
			}
		}
	}
}
