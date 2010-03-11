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
 * Description: This file is part of com.nokia.tools.vct.appshell component.
 */

package com.nokia.tools.vct.appshell.parts.misc;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.geometry.Dimension;

public class DefaultSizeFigure extends Figure {

	private Dimension defaultSize = new Dimension();
	
	public DefaultSizeFigure(int width, int height) {
		setDefaultSize(width, height);
		setMaximumSize(new Dimension(width, height));
		setSize(width, height);
	}

	public DefaultSizeFigure(Dimension d) {
		this(d.width, d.height);
	}

	
	/**
	 * @return a <code>Dimension</code> that represents the minimum or default
	 *         size of this figure.
	 */
	public Dimension getDefaultSize() {
		return defaultSize;
	}

	/**
	 * @param d
	 *            The <code>Dimension</code> to set that represents the minimum
	 *            or default size of this figure.
	 */
	public void setDefaultSize(Dimension d) {
		setDefaultSize(d.width, d.height);
	}

	/**
	 * @param width
	 *            the initial width to initialize the default size with
	 * @param height
	 *            the initial height to initialize the default size with
	 */
	public void setDefaultSize(int width, int height) {
		this.defaultSize.width = width;
		this.defaultSize.height = height;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.draw2d.IFigure#getPreferredSize(int, int)
	 */
	public Dimension getPreferredSize(int wHint, int hHint) {
		return getDefaultSize();
	}

}
