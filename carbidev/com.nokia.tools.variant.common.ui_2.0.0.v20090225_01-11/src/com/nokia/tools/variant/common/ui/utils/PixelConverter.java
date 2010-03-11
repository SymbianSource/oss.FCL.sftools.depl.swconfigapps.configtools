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
 * Description: This file is part of com.nokia.tools.variant.common.ui component.
 */

package com.nokia.tools.variant.common.ui.utils;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.widgets.Control;

/**
 * Helper class for calculation pixel sizes of dialog areas that correspond to
 * the defined font.
 * 
 */
public class PixelConverter {
	
	/** Font metrics to use */
	private FontMetrics fontMetrics;

	/**
	 * Create converted using control's font as a parameter
	 * 
	 * @param control Control to use
	 */
	public PixelConverter(Control control) {
		GC gc = new GC(control);
		gc.setFont(control.getFont());
		fontMetrics = gc.getFontMetrics();
		gc.dispose();
	}

	/**
	 * Create converted using control's font as a parameter
	 * 
	 * @param fontMetrics
	 *            Font metrics to use
	 */
	public PixelConverter(FontMetrics fontMetrics) {
		this.fontMetrics = fontMetrics;
	}

	/**
	 * Get the font metrics used
	 * 
	 * @return Font metrics
	 */
	public FontMetrics getFontMetrics() {
		return fontMetrics;
	}

	/**
	 * Returns the number of pixels corresponding to the height of the given
	 * number of characters.
	 * 
	 * @param chars
	 *            the number of characters
	 * @return the number of pixels
	 * 
	 * @see Dialog#convertHeightInCharsToPixels(FontMetrics, int)
	 */
	public int convertHeightInCharsToPixels(int chars) {
		return Dialog.convertHeightInCharsToPixels(fontMetrics, chars);
	}

	/**
	 * Returns the number of pixels corresponding to the given number of
	 * horizontal dialog units.
	 * 
	 * @param dlus
	 *            the number of horizontal dialog units
	 * @return the number of pixels
	 * 
	 * @see Dialog#convertHorizontalDLUsToPixels(FontMetrics, int)
	 */
	public int convertHorizontalDLUsToPixels(int dlus) {
		return Dialog.convertHorizontalDLUsToPixels(fontMetrics, dlus);
	}

	/**
	 * Returns the number of pixels corresponding to the given number of
	 * vertical dialog units.
	 * 
	 * @param dlus
	 *            the number of vertical dialog units
	 * 
	 * @see Dialog#convertVerticalDLUsToPixels(FontMetrics, int)
	 */
	public int convertVerticalDLUsToPixels(int dlus) {
		return Dialog.convertVerticalDLUsToPixels(fontMetrics, dlus);
	}

	/**
	 * Returns the number of pixels corresponding to the width of the given
	 * number of characters.
	 * 
	 * @param chars
	 *            the number of characters
	 * 
	 * @see Dialog#convertWidthInCharsToPixels(FontMetrics, int)
	 */
	public int convertWidthInCharsToPixels(int chars) {
		return Dialog.convertWidthInCharsToPixels(fontMetrics, chars);
	}

}
