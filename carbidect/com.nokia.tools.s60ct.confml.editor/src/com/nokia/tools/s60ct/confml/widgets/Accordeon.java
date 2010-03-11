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
package com.nokia.tools.s60ct.confml.widgets;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ExpandEvent;
import org.eclipse.swt.events.ExpandListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Twistie;

public class Accordeon extends Composite {

	private MouseListener mouseListener = new SelectionAndExpandListener();
	private boolean fromTwistie;
	private Composite content;

	private Label firstLabel;

	private Label secondLabel;

	/*
	 * Expanded state of this widget
	 */
	private boolean expanded;

	/**
	 * Selection state of this widget
	 */
	private boolean selected;

	private String title;

	private String titleMessage;

	private List<ExpandListener> expandListeners = new ArrayList<ExpandListener>();

	private List<SelectionListener> selectionListeners = new ArrayList<SelectionListener>();

	private Twistie twistie;
	private Font font;

	public boolean addSelectionListener(SelectionListener selectionListener) {
		if (!this.selectionListeners.contains(selectionListener)) {
			this.selectionListeners.add(selectionListener);
			return true;
		}
		return false;
	}

	public boolean removeSelectionListener(SelectionListener selectionListener) {
		return this.selectionListeners.remove(selectionListener);
	}

	public boolean addExpandListener(ExpandListener expandListener) {
		if (!this.expandListeners.contains(expandListener)) {
			this.expandListeners.add(expandListener);
			return true;
		}
		return false;
	}

	public boolean removeExpandListener(ExpandListener expandListener) {
		return this.expandListeners.remove(expandListener);
	}

	public boolean getSelection() {
		return selected;
	}

	public void setSelection(boolean state) {
		selected = state;
		if (state) {
			firstLabel.setBackground(new Color(Display.getDefault(), 232, 242,
					255));
			secondLabel.setBackground(new Color(Display.getDefault(), 232, 242,
					255));
			twistie
					.setBackground(new Color(Display.getDefault(), 232, 242,
							255));

		} else {
			firstLabel.setBackground(firstLabel.getDisplay().getSystemColor(
					SWT.COLOR_WHITE));
			secondLabel.setBackground(secondLabel.getDisplay().getSystemColor(
					SWT.COLOR_WHITE));
			twistie.setBackground(secondLabel.getDisplay().getSystemColor(
					SWT.COLOR_WHITE));

		}

		if (getSelection() == false) {
			return;
		}
		this.selected = state;
		Event e = new Event();
		e.widget = this;
		e.data = state;
		SelectionEvent se = new SelectionEvent(e);
		fireSelectionEvent(se);
	}

	private void fireSelectionEvent(final SelectionEvent se) {
		List<SelectionListener> tempListeners = new ArrayList<SelectionListener>();
		tempListeners.addAll(selectionListeners);
		for (final SelectionListener sl : tempListeners) {
			Display.getDefault().asyncExec(new Runnable() {

				public void run() {
					sl.widgetSelected(se);
				}

			});
		}
	}

	private void fireItemExpandedEvent(final ExpandEvent ee) {
		List<ExpandListener> tempListeners = new ArrayList<ExpandListener>();
		tempListeners.addAll(expandListeners);
		for (final ExpandListener el : tempListeners) {
			// Display.getDefault().asyncExec(new Runnable() {
			// public void run() {
			el.itemExpanded(ee);
			// }
			//
			// });
		}
	}

	private void fireItemCollapsedEvent(final ExpandEvent ee) {
		List<ExpandListener> tempListeners = new ArrayList<ExpandListener>();
		tempListeners.addAll(expandListeners);
		for (final ExpandListener el : tempListeners) {
			// Display.getDefault().asyncExec(new Runnable() {
			// public void run() {
			el.itemCollapsed(ee);
			// }
			//
			// });
		}
	}

	public Accordeon(FormToolkit toolkit, Composite parent, int style) {

		super(parent, style);
		expanded = true;
		GridLayout gridLayout = new GridLayout(1, false);
		gridLayout.marginBottom = 0;
		gridLayout.marginTop = 0;
		gridLayout.marginLeft = 0;
		gridLayout.marginRight = 0;
		gridLayout.marginHeight = 0;
		gridLayout.marginWidth = 0;
		gridLayout.verticalSpacing = 0;
		gridLayout.horizontalSpacing = 0;
		setLayout(gridLayout);
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		setLayoutData(data);

		Composite titleComposite = toolkit.createComposite(this, SWT.BORDER);
		gridLayout = new GridLayout(3, false);
		gridLayout.marginBottom = 0;
		gridLayout.marginTop = 0;
		gridLayout.marginLeft = 0;
		gridLayout.marginRight = 0;
		gridLayout.marginHeight = 0;
		gridLayout.marginWidth = 0;
		gridLayout.verticalSpacing = 0;
		gridLayout.horizontalSpacing = 0;
		titleComposite.setLayout(gridLayout);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.grabExcessHorizontalSpace = true;
		titleComposite.setLayoutData(gd);
		Color color = titleComposite.getDisplay().getSystemColor(
				SWT.COLOR_WHITE);
		titleComposite.setBackground(color);
		twistie = new Twistie(titleComposite, SWT.ARROW);
		twistie.setBackground(color);
		twistie.addMouseListener(new MouseListener() {

			public void mouseDoubleClick(MouseEvent e) {

			}

			public void mouseDown(MouseEvent e) {
				fromTwistie = true;
				selected = true;
				setSelection(getSelection());
				if (twistie.isExpanded()) {
					expand(false);
				} else {
					expand(true);

				}
				fromTwistie = false;

			}

			public void mouseUp(MouseEvent e) {

			}

		});
		gd = new GridData(GridData.FILL_VERTICAL);
		twistie.setLayoutData(gd);

		firstLabel = new Label(titleComposite, SWT.NONE);
		font = new Font(null, "sansserif", 8, SWT.BOLD);
		firstLabel.setFont(font);
		GridData gridData = new GridData();
		firstLabel.setBackground(color);
		firstLabel.setLayoutData(gridData);

		secondLabel = new Label(titleComposite, SWT.NONE);
		gridData = new GridData(GridData.FILL_HORIZONTAL);
		secondLabel.setBackground(color);
		gridData.grabExcessHorizontalSpace = true;
		gridData.heightHint = 14;
		secondLabel.setLayoutData(gridData);

		firstLabel.addMouseListener(mouseListener);
		secondLabel.addMouseListener(mouseListener);
		// titleComposite.setBackground(getDisplay().getSystemColor(SWT.
		// COLOR_YELLOW));
		// titleComposite.addPaintListener(new PaintListener(){
		//
		// public void paintControl(PaintEvent e) {
		// Point size = Accordeon.this.computeSize(SWT.DEFAULT, SWT.DEFAULT);
		// e.gc.drawLine(0, size.y, 200, size.y);
		// }});

		toolkit.adapt(this);
	}

	public void setExpanded(boolean toExpand) {
		expanded = toExpand;

	}

	public void expand(boolean toExpand) {
		if (!fromTwistie) {
			twistie.setExpanded(toExpand);
		}
		setExpanded(toExpand);
		Point computeSize = null;
		if (getContent() == null) {
			return;
		}
		Object ld = getContent().getLayoutData();
		if (ld == null) {
			return;
		}
		// content.getParent().setBackground(
		// new Color(Display.getDefault(), 255, 255, 255));
		// content.getParent().getParent().setBackground(
		// new Color(Display.getDefault(), 255, 255, 255));
		if (isExpanded()) {
			GridData gd = (GridData) ld;
			gd.exclude = false;
			// setVisible(true);
			// setVisible(true);
			// computeSize = computeSize(SWT.DEFAULT, SWT.DEFAULT);
			// gd.heightHint = computeSize(SWT.DEFAULT,SWT.DEFAULT).y;
			// layout(true,true);
			// setSize(computeSize);
			// setSize(getSize().x,SWT.DEFAULT);
		} else {
			GridData gd = (GridData) ld;

			gd.exclude = true;
			// gd.heightHint = 0;

			// setVisible(false);
			// computeSize = computeSize(SWT.DEFAULT, SWT.DEFAULT);
			// layout(true,true);
			// setSize(computeSize);
			// setSize(getSize().x,computeSize.y);
		}

		Composite c = this;
		while (c.getParent() instanceof Composite) {
			c = c.getParent();
			if (c instanceof ScrolledForm) {
				ScrolledForm sf = (ScrolledForm) c;
				sf.reflow(true);
			}
		}
		// c.layout(true);
		Event e = new Event();
		e.widget = this;
		ExpandEvent ee = new ExpandEvent(e);
		if (isExpanded()) {
			fireItemExpandedEvent(ee);
		} else {
			fireItemCollapsedEvent(ee);
		}
	}

	class SelectionAndExpandListener extends MouseAdapter {
		@Override
		public void mouseDoubleClick(MouseEvent e) {
			expand(!expanded);
			System.out.println(expanded);
		}

		@Override
		public void mouseDown(MouseEvent e) {
			if (!selected) {
				selected = !selected;
			}
			// fire selection/deselection
			setSelection(getSelection());
		}
	}

	public Composite getContent() {
		return content;
	}

	public void setContent(Composite content) {
		this.content = content;
		expand(isExpanded());
	}

	private static class TestSelectionListener implements SelectionListener {
		private Label l;

		public TestSelectionListener(Label testLabel) {
			this.l = testLabel;
		}

		public void widgetDefaultSelected(SelectionEvent e) {
		}

		public void widgetSelected(SelectionEvent e) {
			Widget widget = e.widget;
			if (widget instanceof Accordeon) {
				Accordeon a = (Accordeon) widget;
				l.setText(a.getTitle());
				// l.pack();
				l.setBackground(new Color(Display.getDefault(), 250, 0, 0));
				l.getParent().layout(true, true);
			}
		}

	}

	public static void main(String[] args) {
		Shell shell = new Shell();
		shell.setSize(200, 200);
		shell.setText("Scroll sample");
		shell.setLayout(new GridLayout());

		Label l = new Label(shell, SWT.NONE);
		TestSelectionListener listener = new TestSelectionListener(l);

		for (int i = 0; i < 3; i++) {
			Accordeon a = createSampleAccordeon(shell);
			a.setTitle("Accordeon " + i);
			a.addSelectionListener(listener);
		}

		shell.open();
		Display display = Display.getDefault();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	private static Accordeon createSampleAccordeon(Shell shell) {
		Accordeon main = new Accordeon(null, shell, SWT.BORDER);
		main.setLayoutData(new GridData());
		main.setBackground(new Color(Display.getDefault(), 200, 100, 45));
		Composite content = new Composite(main, SWT.BORDER);
		GridData gridData = new GridData();
		gridData.horizontalSpan = 0;
		gridData.verticalSpan = 0;
		gridData.horizontalIndent = 0;
		gridData.verticalIndent = 0;

		content.setLayoutData(gridData);
		GridLayout gridLayout = new GridLayout(1, false);
		content.setLayout(gridLayout);
		for (int i = 0; i < 10; i++) {
			// createComp(content, i);
		}
		main.setContent(content);
		return main;
	}

	public void setTitle(String title) {
		this.title = title;
		firstLabel.setText(title);
	}

	public String getTitle() {
		return this.title;
	}

	private static void createComp(Composite content, int i) {
		Button button = new Button(content, SWT.PUSH);
		button.setText("Button " + i);
		button.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		if (i == 0) {
			// button.setVisible(true);
			// ((GridData) button.getLayoutData()).exclude = true;
		}
	}

	public boolean isExpanded() {
		return expanded;
	}

	public String getTitleMessage() {
		return titleMessage;
	}

	public void setTitleMessage(String titleMessage) {
		if (!secondLabel.isDisposed()) {
			this.titleMessage = titleMessage;
			secondLabel.setText(": " + titleMessage);
		}
	}

	@Override
	public void dispose() {
		if (font != null && !font.isDisposed()) {
			font.dispose();
		}
		super.dispose();
	}
}
