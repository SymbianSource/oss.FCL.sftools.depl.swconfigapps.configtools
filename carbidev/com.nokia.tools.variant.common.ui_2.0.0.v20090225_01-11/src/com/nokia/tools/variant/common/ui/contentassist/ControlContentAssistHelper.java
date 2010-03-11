/*******************************************************************************
 * Copyright (c) 2000, 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.nokia.tools.variant.common.ui.contentassist;

import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Text;

/**
 * Helper class for content assist. The class is responsible for enabling the
 * content assist for the given controls.
 * 
 * The original code is taken from JDT.
 * 
 */
public class ControlContentAssistHelper {

	/**
	 * @param text
	 *            the text field to install ContentAssist
	 * @param processor
	 *            the <code>IContentAssistProcessor</code>
	 */
	public static void createTextContentAssistant(final Text text,
			IContentAssistProcessor processor) {
		
	}

	/**
	 * @param combo
	 *            the text field to install ContentAssist
	 * @param processor
	 *            the <code>IContentAssistProcessor</code>
	 */
	public static void createComboContentAssistant(final Combo combo,
			IContentAssistProcessor processor) {
		
	}

}
