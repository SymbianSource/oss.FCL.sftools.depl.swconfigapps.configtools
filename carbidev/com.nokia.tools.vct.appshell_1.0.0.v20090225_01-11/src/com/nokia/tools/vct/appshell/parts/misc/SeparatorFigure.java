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

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;

public class SeparatorFigure extends Figure {
	/**
	 * @see org.eclipse.draw2d.IFigure#getPreferredSize(int, int)
	 */
	public Dimension getPreferredSize(int wHint, int hHint) {
		return new Dimension(wHint, 2);
	}
	
	private static final Insets CROP = new Insets(0, 0, 1, 1);

	/**
	 * 
	 * @see org.eclipse.draw2d.Figure#paintFigure(Graphics)
	 */
	protected void paintFigure(Graphics g) {
		Rectangle r = getBounds().getCropped(CROP);
		g.setForegroundColor(ColorConstants.gray);
		g.drawLine(r.getBottomLeft(), r.getTopLeft());
		g.drawLine(r.getTopLeft(), r.getTopRight());

		g.setForegroundColor(ColorConstants.buttonLightest);
		g.drawLine(r.getBottomLeft(), r.getBottomRight());
		g.drawLine(r.getBottomRight(), r.getTopRight());
	}
}
