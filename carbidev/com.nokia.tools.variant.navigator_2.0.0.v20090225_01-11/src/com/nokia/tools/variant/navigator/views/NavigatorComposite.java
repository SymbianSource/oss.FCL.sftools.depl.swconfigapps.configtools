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
 * Description: This file is part of com.nokia.tools.variant.navigator component.
 */

package com.nokia.tools.variant.navigator.views;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.ListenerList;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.jface.window.ToolTip;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Widget;

import com.nokia.tools.variant.common.ui.utils.SWTUtil;

public class NavigatorComposite extends Canvas implements KeyListener {

	private static final class DisposeHandler implements DisposeListener {
		static final DisposeListener INSTANCE = new DisposeHandler();

		public void widgetDisposed(DisposeEvent e) {
			((NavigatorComposite) e.widget).handleDisposed();
		}
	}

	private static final class PaintHandler implements PaintListener {
		static final PaintListener INSTANCE = new PaintHandler();

		public void paintControl(PaintEvent e) {
			((NavigatorComposite) e.widget).handlePaint(e);
		}
	}

	private static final class ControlHandler extends ControlAdapter {
		static final ControlListener INSTANCE = new ControlHandler();

		@Override
		public void controlResized(ControlEvent e) {
			((NavigatorComposite) e.widget).handleResized(e);
		}
	}

	private static final Color COLOR_TT_BACKGROUND = new Color(null, new RGB(
			245, 245, 200));
	private static final Color COLOR_TT_FOREGROUND = new Color(null, new RGB(0,
			0, 0));

	/** Listeners of widget selection */
	protected final ListenerList listeners;
	/** Child widgets */
	protected final List<NavigatorButton> buttons;
	/** Currently selected widget if any */
	protected NavigatorButton selectedButton = null;

	protected final SelectionListener buttonListener;

	private Text titleText = null;

	public Text getTitleText() {
		return titleText;
	}

	public void setTitleText(Text titleText) {
		this.titleText = titleText;
	}

	public NavigatorComposite(Composite parent, int style,
			NavigatorViewer viewer) {
		super(parent, style | SWT.DOUBLE_BUFFERED);

		addKeyListener(this);
		this.listeners = new ListenerList();
		this.buttons = new ArrayList<NavigatorButton>();
		this.buttonListener = new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
				setSelectedWidget((NavigatorButton) e.widget);
			}

			public void widgetSelected(SelectionEvent e) {
				setSelectedWidget((NavigatorButton) e.widget);
			}
		};
		this.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				if (selectedButton != null
						&& selectedButton.getSelectedLabel() != null) {
					NavigatorLabel label = selectedButton.getSelectedLabel();
					label.updateColors(true);
					Rectangle bounds = label.getBounds();
					redraw(bounds.x, bounds.y, bounds.width, bounds.height,
							false);
				}
			}

			public void focusLost(FocusEvent e) {
				if (selectedButton != null
						&& selectedButton.getSelectedLabel() != null) {
					NavigatorLabel label = selectedButton.getSelectedLabel();
					label.updateColors(false);
					Rectangle bounds = label.getBounds();
					redraw(bounds.x, bounds.y, bounds.width, bounds.height,
							false);
				}
			}
		});
		setBackground(ColorConstants.white);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				setFocus();

				for (NavigatorButton button : getButtons()) {
					if (button.getBounds().contains(e.x, e.y)) {
						NavigatorLabel label = button.getSelectedLabel();

						if (button.isExpanded()) {
							for (NavigatorLabel child : button.getLabels()) {
								if (child.getBounds().contains(e.x, e.y)) {
									setSelectedWidget(child);
									return;
								}
							}
						}

						if (button.isSelected()) {
							if (button.isNonExpanded()) {
								button.setExpanded(true);
							} else {
								button.setSelectedLabel(null);
								redraw();
								setSelectedWidget(button);
								break;
								// button.setExpanded(!button.isExpanded());
							}

							setSelectedWidget(label == null ? button : button
									.isExpanded() ? label : button);
						} else {
							setSelectedWidget(label == null ? button : label);
						}

						break;
					}
				}
			}
		});
		addDisposeListener(DisposeHandler.INSTANCE);
		addPaintListener(PaintHandler.INSTANCE);
		addControlListener(ControlHandler.INSTANCE);

		new ToolTip(this, ToolTip.NO_RECREATE, false) {
			@Override
			protected Composite createToolTipContentArea(Event event,
					Composite parent) {
				Composite area = new Composite(parent, SWT.NONE);
				area.setLayout(new Layout() {
					@Override
					protected Point computeSize(Composite composite, int hint,
							int hint2, boolean flushCache) {
						Point size = new Point(5, 5);

						for (Control child : composite.getChildren()) {
							Point cs = child.computeSize(SWT.DEFAULT,
									SWT.DEFAULT);
							if (cs.x > 250) {
								cs = child.computeSize(250, SWT.DEFAULT);
							}
							size.x = Math.max(size.x, cs.x + 10);
							size.y += cs.y + 5;
						}

						return size;
					}

					@Override
					protected void layout(Composite composite,
							boolean flushCache) {
						Point csize = composite.getSize();
						int y = 5;

						for (Control child : composite.getChildren()) {
							Point cs = child.computeSize(csize.x - 10,
									SWT.DEFAULT);
							child.setBounds(5, y, cs.x, cs.y);
							y += cs.y + 5;
						}

					}
				});

				area.setBackground(COLOR_TT_BACKGROUND);
				area.setForeground(COLOR_TT_FOREGROUND);

				Label label = new Label(area, SWT.WRAP);
				label.setText("Undefined");
				label.setBackground(COLOR_TT_BACKGROUND);
				label.setForeground(COLOR_TT_FOREGROUND);

				Point point = new Point(event.x, event.y);
				String text = null;

				outer: for (NavigatorButton button : getButtons()) {
					if (button.getBounds().contains(point)) {
						text = button.getButtonDescription();
						if (button.isExpanded()) {
							for (NavigatorLabel labelItem : button.getLabels()) {
								if (labelItem.getBounds().contains(point)) {
									text = labelItem.getToolTipText();
									break outer;
								}
							}
						}
						break;
					}
				}
				if (text != null) {
					label.setText(text);
				}

				return area;
			}

			@Override
			protected Object getToolTipArea(Event event) {
				String text = null;
				Rectangle bounds = null;

				outer: for (NavigatorButton button : getButtons()) {
					if (button.getBounds().contains(event.x, event.y)) {
						text = button.getButtonDescription();
						bounds = button.getBounds();
						if (button.isExpanded()) {
							for (NavigatorLabel labelItem : button.getLabels()) {
								if (labelItem.getBounds().contains(event.x,
										event.y)) {
									text = labelItem.getToolTipText();
									bounds = labelItem.getBounds();
									break outer;
								}
							}
						}
						break;
					}
				}
				return text != null && text.length() > 0 ? bounds : null;
			}

			@Override
			public Point getLocation(Point tipSize, Event event) {
				Rectangle bounds = null;
				outer: for (NavigatorButton button : getButtons()) {
					if (button.getBounds().contains(event.x, event.y)) {
						bounds = button.getBounds();
						if (button.isExpanded()) {
							for (NavigatorLabel labelItem : button.getLabels()) {
								if (labelItem.getBounds().contains(event.x,
										event.y)) {
									bounds = labelItem.getBounds();
									break outer;
								}
							}
						}
						break;
					}
				}

				if (bounds == null) {
					return super.getLocation(tipSize, event);
				}
				ScrolledComposite sc = SWTUtil
						.getScrolledComposite(NavigatorComposite.this);
				Rectangle ca = sc.getClientArea();
				Point caBottom = sc.toDisplay(ca.x, ca.y + ca.height);
				Point display = NavigatorComposite.this.toDisplay(bounds.x,
						bounds.y + bounds.height);
				display.y = Math.min(display.y, caBottom.y);

				return display;
			}
		};

	}

	public void handleDisposed() {
		disposeButtons();
		listeners.clear();
	}

	public NavigatorButton createButton() {
		NavigatorButton button = new NavigatorButton(this);
		button.addSelectionListener(buttonListener);
		buttons.add(button);
		if (buttons.size() == 1) {
			setSelectedWidget(button);
		}

		return button;
	}

	public void keyPressed(KeyEvent e) {
		try {
			if (e.keyCode == SWT.ARROW_UP && e.stateMask == SWT.NONE) {
				if (selectedButton == null) {
					return;
				}
				if (selectedButton.isExpanded()) {
					int idx = selectedButton.getSelectedLabelIndex();
					if (idx > 0) {
						setSelectedWidget(selectedButton.getLabel(idx - 1),
								false);
					} else {
						idx = buttons.indexOf(selectedButton);
						if (idx > 0) {
							NavigatorButton button = buttons.get(idx - 1);
							if (button.getLabelCount() == 0) {
								setSelectedWidget(button, false);
							} else {
								setSelectedWidget(button.getLabel(button
										.getLabelCount() - 1), false);
							}
						}
					}
				} else {
					int idx = buttons.indexOf(selectedButton);
					if (idx > 0) {
						NavigatorButton button = buttons.get(idx - 1);
						if (button.getLabelCount() == 0) {
							setSelectedWidget(button, false);
						} else {
							setSelectedWidget(button.getLabel(button
									.getLabelCount() - 1), false);
						}
					}
				}
				return;
			} else if (e.keyCode == SWT.ARROW_DOWN && e.stateMask == SWT.NONE) {
				if (selectedButton == null) {
					return;
				}
				if (selectedButton.isExpanded()) {
					int idx = selectedButton.getSelectedLabelIndex();
					if (idx >= 0 && idx < selectedButton.getLabelCount() - 1) {
						setSelectedWidget(selectedButton.getLabel(idx + 1),
								false);
					} else {
						idx = buttons.indexOf(selectedButton);
						if (idx < buttons.size() - 1) {
							NavigatorButton button = buttons.get(idx + 1);
							if (button.getLabelCount() == 0) {
								setSelectedWidget(button, false);
							} else {
								setSelectedWidget(button.getLabel(0), false);
							}
						}
					}
				} else {
					int idx = buttons.indexOf(selectedButton);
					if (idx < buttons.size() - 1) {
						NavigatorButton button = buttons.get(idx + 1);
						if (button.getLabelCount() == 0) {
							setSelectedWidget(button, false);
						} else {
							setSelectedWidget(button.getLabel(0), false);
						}
					}

				}
				return;

			} else if (e.keyCode == SWT.ARROW_LEFT && e.stateMask == SWT.NONE) {
				if (selectedButton != null) {
					selectedButton.setExpanded(false);
					setSelectedWidget(selectedButton, false);
				}
				return;

			} else if (e.keyCode == SWT.ARROW_RIGHT && e.stateMask == SWT.NONE) {
				if (selectedButton != null) {
					selectedButton.setExpanded(true);
					NavigatorLabel label = selectedButton.getSelectedLabel();
					if (label != null) {
						setSelectedWidget(label, false);
					}
				}
				return;

			} else if (e.keyCode == SWT.TAB && e.stateMask == SWT.SHIFT) {
				int idx = buttons.indexOf(selectedButton);
				// fix bug 912 empty 1st group
				for (int i = --idx; i >= 0; i--) {
					setSelectedWidget(buttons.get(i), true);
					break;
				}
				NavigatorLabel label = selectedButton.getSelectedLabel();
				if (label != null) {
					setSelectedWidget(label, false);
				}
				return;

			} else if (e.keyCode == SWT.TAB && e.stateMask == 0) {
				int idx = buttons.indexOf(selectedButton);
				// fix bug 912 empty 1st group
				for (int i = ++idx; i < buttons.size(); i++) {
					setSelectedWidget(buttons.get(i), true);
					break;
				}
				NavigatorLabel label = selectedButton.getSelectedLabel();
				if (label != null) {
					setSelectedWidget(label, false);
				}
				return;

			} else if (e.keyCode == SWT.HOME) {
				if (!buttons.isEmpty()) {
					NavigatorButton button = buttons.get(0);
					if (button.getLabelCount() == 0) {
						setSelectedWidget(button, false);
					} else {
						setSelectedWidget(button.getLabel(0), false);
					}
				}
				return;

			} else if (e.keyCode == SWT.END) {
				if (!buttons.isEmpty()) {
					NavigatorButton button = buttons.get(buttons.size() - 1);
					if (button.getLabelCount() == 0) {
						setSelectedWidget(button, false);
					} else {
						setSelectedWidget(button.getLabel(button
								.getLabelCount() - 1), false);
					}
				}
				return;

			} else {
				e.doit = false;
			}
		} finally {
			update();
		}
	}

	protected void selectButton(NavigatorButton newSelectedButton) {

		try {
			if (selectedButton != newSelectedButton) {
				if (selectedButton != null) {
					selectedButton.setExpanded(false);
					selectedButton.setSelected(false);
					if (selectedButton.getSelectedLabel() != null) {
						selectedButton.getSelectedLabel().setSelected(false);
					}
				}

				selectedButton = newSelectedButton;
				if (selectedButton != null) {
					selectedButton.setExpanded(true);
					selectedButton.setSelected(true);
					// if (selectedButton.getSelectedLabel() == null
					// && selectedButton.getLabels().length > 0) {
					// selectedButton.setSelectedLabel(0);
					// }
					if (selectedButton.getSelectedLabel() != null) {
						selectedButton.getSelectedLabel().setSelected(true);
					}
				}
			}else if(selectedButton!=null&&selectedButton.selectedLabel!=null){
				selectedButton.selectedLabel.setSelected(false);
				selectedButton.selectedLabel = null;
				
				
			}

		} finally {
		}
	}

	public void keyReleased(KeyEvent e) {
		Event event = new Event();
		event.widget = this;
		final SelectionEvent se = new SelectionEvent(event);
		se.item = selectedWidget;
		for (Object obj : listeners.getListeners()) {
			((SelectionListener) obj).widgetSelected(se);
		}

	}

	public Widget getSelectedWidget() {
		NavigatorButton button = getSelectedButton();
		if (button == null) {
			return null;
		}
		NavigatorLabel label = button.getSelectedLabel();
		return label == null ? button : label;
	}

	public void setSelectedWidget(Widget selection) {
		setSelectedWidget(selection, true);
	}

	private Widget selectedWidget;

	public void setSelectedWidget(Widget selection, boolean notify) {
		try {
			selectedWidget = selection;

			if (selection instanceof NavigatorButton) {
				selectButton((NavigatorButton) selection);
				notify = true;
			} else if (selection instanceof NavigatorLabel) {
				NavigatorLabel label = (NavigatorLabel) selection;
				NavigatorButton button = (NavigatorButton) label.getButton();
				selectButton(button);
				button.setSelectedLabel(label);
				
			} else {
				selectButton(null);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (isDisposed()) {
				return;
			}
			Point size = getSize();
			ScrolledComposite sc = SWTUtil.getScrolledComposite(this);

			Rectangle ca = sc.getClientArea();
			size = computeSize(ca.width, SWT.DEFAULT);
			// size.y = Math.max(size.y, getSize().y);
			sc.setMinSize(size);
			sc.getVerticalBar().setPageIncrement(ca.height);
			if (getSize().equals(size)) {
				Rectangle bounds = new Rectangle(0, 0, ca.width, 0);

				for (NavigatorButton button : getButtons()) {
					Point buttonSize = button
							.computeSize(ca.width, SWT.DEFAULT);
					bounds.height = buttonSize.y;
					button.setBounds(bounds);
					bounds.y += buttonSize.y;
				}

			} else {
				setSize(size);
			}
			// layout(true, true);

			redraw();
			update();

			if (selectedButton != null) {
				Rectangle bounds = selectedButton.getSelectedLabel() == null ? selectedButton
						.getBounds()
						: selectedButton.getSelectedLabel().getBounds();

				Point controlSize = new Point(bounds.width, bounds.height);
				Point controlOrigin = SWTUtil.getControlLocation(sc, this);
				controlOrigin.x += bounds.x;
				controlOrigin.y += bounds.y;
				SWTUtil.ensureVisible(sc, controlOrigin, controlSize);
			}
		}

		if (notify) {
			Event event = new Event();
			event.widget = this;
			final SelectionEvent se = new SelectionEvent(event);
			se.item = selection;
			for (Object obj : listeners.getListeners()) {
				((SelectionListener) obj).widgetSelected(se);
			}
		}

	}

	@Override
	public boolean setFocus() {
		if (selectedButton == null && !buttons.isEmpty()) {
			setSelectedWidget(buttons.get(0));
		}
		return forceFocus();
	}

	public NavigatorButton getSelectedButton() {
		return selectedButton;
	}

	public NavigatorButton[] getButtons() {
		return buttons.toArray(new NavigatorButton[buttons.size()]);
	}

	public void addSelectionListener(SelectionListener listener) {
		listeners.add(listener);
	}

	public void removeSelectionListener(SelectionListener listener) {
		listeners.remove(listener);
	}

	public void disposeButtons() {
		setSelectedWidget(null);
		for (NavigatorButton button : getButtons()) {
			button.dispose();
		}
		buttons.clear();
	}

	void handlePaint(PaintEvent event) {
		for (NavigatorButton button : getButtons()) {
			button.paintControl(event);
		}
	}

	public void handleResized(ControlEvent e) {
		Point size = getSize();
		Rectangle bounds = new Rectangle(0, 0, size.x, 0);

		for (NavigatorButton button : getButtons()) {
			Point buttonSize = button.computeSize(size.x, SWT.DEFAULT);
			bounds.height = buttonSize.y;
			button.setBounds(bounds);
			bounds.y += buttonSize.y;
		}

	}

	@Override
	public Point computeSize(int wHint, int hHint, boolean changed) {
		int width = 0;
		int height = 0;

		for (NavigatorButton button : getButtons()) {
			Point buttonSize = button.computeSize(wHint, SWT.DEFAULT);
			width = Math.max(width, buttonSize.x);
			height += buttonSize.y;
		}
		if (wHint != SWT.DEFAULT) {
			width = wHint;
		}
		if (hHint != SWT.DEFAULT) {
			height = hHint;
		}
		return new Point(width, height);
	}
}
