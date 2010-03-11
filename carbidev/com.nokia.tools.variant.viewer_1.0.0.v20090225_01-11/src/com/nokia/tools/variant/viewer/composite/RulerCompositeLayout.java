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
 * Description: This file is part of com.nokia.tools.variant.viewer component.
 */

package com.nokia.tools.variant.viewer.composite;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.ScrollBar;

class RulerCompositeLayout extends Layout {

	private EditorScrolledComposite editor;
	private Canvas ruler;
	private Composite rulerComposite;
	public Point location;

	public ScrolledComposite getEditor() {
		return editor;
	}

	public Composite getRuler() {
		return rulerComposite;
	}

	public RulerCompositeLayout(final Composite main, int style) {
		ruler = new Canvas(main, style);
		rulerComposite = new Composite(ruler, SWT.NONE);
		rulerComposite.setLayout(createGLayout());
		rulerComposite.setLayoutData(new GridData(GridData.FILL_BOTH));
		editor = new EditorScrolledComposite(main, SWT.H_SCROLL | SWT.V_SCROLL);
		editor.setExpandHorizontal(true);
		editor.setExpandVertical(true);
		editor.getVerticalBar().setIncrement(20);

		location = new Point(0, 0);
		final ScrollBar verticalBar = editor.getVerticalBar();

		// Scrool ruler - vertical bar
		verticalBar.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				scrollRulerComposite(location.x, verticalBar.getSelection());
			}
		});

	}

	private Layout createGLayout() {
		GridLayout gl = new GridLayout();
		gl.horizontalSpacing = 0;
		gl.marginHeight = 0;
		gl.marginWidth = 0;
		gl.verticalSpacing = 0;
		return gl;
	}

	@Override
	protected Point computeSize(Composite composite, int hint, int hint2,
			boolean flushCache) {
		Control[] children = composite.getChildren();
		Point s = new Point(0, 0);
		if (children.length > 0) {
			s = children[children.length - 1].computeSize(SWT.DEFAULT,
					SWT.DEFAULT, flushCache);
		}
		if (ruler != null&&!ruler.isDisposed())
			s.x += ruler.getBounds().x;
		return s;
	}

	@Override
	protected void layout(Composite composite, boolean flushCache) {
		Rectangle clArea = composite.getClientArea();

		Rectangle trim = editor.computeTrim(0, 0, 0, 0);
		int scrollbarHeight = trim.height + trim.y; // scrollbar is only under editor

		Point rulerSize = rulerComposite.computeSize(SWT.DEFAULT, SWT.DEFAULT);
		editor.setBounds(rulerSize.x, 0, clArea.width - rulerSize.x,
				clArea.height);

		int y = clArea.height;

		if (editor.getContent() != null) {
			Point editorContentSize = editor.getContent().computeSize(
					SWT.DEFAULT, SWT.DEFAULT);
			editor.setMinSize(editorContentSize);
			rulerComposite.setSize(rulerSize.x,
					editorContentSize.y > clArea.height ? editorContentSize.y
							: clArea.height);
		}
		if (editor.getHorizontalBar().isVisible()) {
			y -= scrollbarHeight;
		}
		ruler.setSize(rulerSize.x, y);
		scrollRulerComposite(location.x, editor.getOrigin().y);
		editor.getVerticalBar().setPageIncrement(editor.getClientArea().height);
	}

	private class EditorScrolledComposite extends ScrolledComposite {

		public EditorScrolledComposite(Composite parent, int style) {
			super(parent, style);
		}

		@Override
		public void setOrigin(int x, int y) {
			Point origin = getOrigin();

			if (origin.x != x || origin.y != y) {
				super.setOrigin(x, y);
				scrollRulerComposite(x, y);
			}
		}
		@Override
		public void setOrigin(Point origin) {
			super.setOrigin(origin);
			scrollRulerComposite(origin.x, origin.y);
		}
		
		@Override
		public void layout() {
			getParent().layout();
		}
		
		@Override
		public void layout(boolean changed) {
			getParent().layout(changed);
		}
		
		@Override
		public void layout(boolean changed, boolean all) {
			getParent().layout(changed, all);
		}
	}
	
	private void scrollRulerComposite(int x, int y) {
		if (editor.getContent() != null) {
			int maxOrigin = editor.getContent().getSize().y
					- editor.getClientArea().height;

			int destY = (y < 0) ? 0 : -y;
			if (maxOrigin < y) {
				destY = -maxOrigin;
			}
			Point size = rulerComposite.computeSize(SWT.DEFAULT, SWT.DEFAULT);
			ruler
					.scroll(0, destY, location.x, location.y, size.x, size.y,
							true);
			location.y = destY;
		}
	}

}
