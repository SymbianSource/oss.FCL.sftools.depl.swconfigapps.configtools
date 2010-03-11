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

package com.nokia.tools.variant.viewer.widgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseTrackListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * Widget graphically represents integer setting with spin increment possibility.
 */
public class IntegerSpinBox extends BaseConfMLWidget {
	private boolean runIncrement;
	private boolean runDecrement;
	protected Shell tip;
	protected Text text;
	protected Button increment;
	protected Button decrement;

	public IntegerSpinBox(Composite parent, int style, String widgetLabel) {
		super(parent, style, widgetLabel);

	}

	protected void buildMainControl() {

		Composite controls = new Composite(group, SWT.NONE);

		GridLayout gridLayout = new GridLayout(2, false);
		gridLayout.horizontalSpacing = 0;
		gridLayout.verticalSpacing = 0;
		gridLayout.marginHeight = 0;
		gridLayout.marginWidth = 0;
		gridLayout.marginBottom = 0;
		gridLayout.marginTop = 0;
		gridLayout.marginRight = 0;
		controls.setLayout(gridLayout);
		controls.setLayoutData(layoutDataForGroup());

		text = new Text(controls, SWT.BORDER);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		text.setLayoutData(gd);

		Composite buttons = new Composite(controls, SWT.NONE);
		gridLayout = new GridLayout();
		gridLayout.horizontalSpacing = 0;
		gridLayout.verticalSpacing = 0;
		gridLayout.marginHeight = 0;
		gridLayout.marginWidth = 0;
		gridLayout.marginBottom = 0;
		gridLayout.marginTop = 0;
		// gridLayout.numColumns = 1;

		buttons.setLayout(gridLayout);
		buttons.setLayoutData(new GridData(GridData.FILL_VERTICAL
				| GridData.HORIZONTAL_ALIGN_END));

		increment = new Button(buttons, SWT.ARROW | SWT.UP);
		increment.addMouseListener(new MouseAdapter() {
			private int cycleCounter;

			public void mouseDown(MouseEvent ev) {
				if (ev.button == 3) {
					return;
				}
				cycleCounter = 0;
				Thread th = new Thread() {
					public void run() {
						try {

							while (runIncrement) {
								Display.getDefault().asyncExec(new Runnable() {
									public void run() {
										increaseValue();
									}
								});
								int sleepTime = 100;
								if (cycleCounter == 0)
									sleepTime = 1000;
								sleep(sleepTime);
								cycleCounter++;
							}
						} catch (NumberFormatException exc) {
							exc.printStackTrace();
						} catch (InterruptedException e) {

							e.printStackTrace();
						}
					}
				};
				runIncrement = true;
				th.start();
			}

			public void mouseUp(MouseEvent ev) {
				runIncrement = false;
			}

		});

		increment.addMouseTrackListener(new MouseTrackListener() {
			public void mouseEnter(MouseEvent e) {
				runIncrement = true;
			}

			public void mouseExit(MouseEvent e) {
				runIncrement = false;
			}

			public void mouseHover(MouseEvent e) {
				
			}
		});
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.widthHint = 20;
		gd.heightHint = 10;
		// gd.horizontalAlignment = GridData.END;
		increment.setLayoutData(gd);

		decrement = new Button(buttons, SWT.ARROW | SWT.DOWN);
		decrement.setSize(20, 12);
		decrement.addMouseListener(new MouseAdapter() {

			private int cycleCounter;

			public void mouseDown(MouseEvent ev) {
				if (ev.button == 3) {
					return;
				}
				cycleCounter = 0;
				Thread th = new Thread() {
					public void run() {
						try {

							while (runDecrement) {
								Display.getDefault().asyncExec(new Runnable() {
									public void run() {
										decreaseValue();
									}
								});
								int sleepTime = 100;
								if (cycleCounter == 0)
									sleepTime = 1000;
								sleep(sleepTime);
								cycleCounter++;
							}
						} catch (NumberFormatException exc) {
							exc.printStackTrace();
						} catch (InterruptedException e) {

							e.printStackTrace();
						}
					}
				};
				runDecrement = true;
				th.start();
			}

			public void mouseUp(MouseEvent ev) {
				runDecrement = false;
			}
		});

		decrement.addMouseTrackListener(new MouseTrackListener() {
			public void mouseEnter(MouseEvent e) {
				runDecrement = true;
			}

			public void mouseExit(MouseEvent e) {
				runDecrement = false;
			}

			public void mouseHover(MouseEvent e) {
				
			}
		});

		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.widthHint = 20;
		gd.heightHint = 10;
		decrement.setLayoutData(gd);
	}

	protected void removeListeners() {
		super.removeListeners();
		// removeListener(text, SWT.Verify, widgetController);
		// removeListener(text, SWT.FocusIn, widgetController);
		// removeListener(text, SWT.FocusOut, widgetController);
		// removeListener(text, SWT.Modify, widgetController);
		// removeListener(text, SWT.MouseDown, widgetController);
		// removeListener(increment, SWT.MouseDown, widgetController);
		// removeListener(decrement, SWT.MouseDown, widgetController);
	}

	public void attachListeners() {
		super.attachListeners();

		// text.addListener(SWT.Verify, widgetController);
		// text.addListener(SWT.FocusIn, widgetController);
		// text.addListener(SWT.FocusOut, widgetController);
		// text.addListener(SWT.Modify, widgetController);
		// text.addListener(SWT.MouseDown, widgetController);
		// increment.addListener(SWT.MouseDown, widgetController);
		// decrement.addListener(SWT.MouseDown, widgetController);
		//
		// increment.addDisposeListener(new DisposeListener() {
		// public void widgetDisposed(DisposeEvent e) {
		// increment.removeDisposeListener(this);
		// increment.removeListener(SWT.MouseDown, widgetController);
		// }
		//
		// });
		//
		// decrement.addDisposeListener(new DisposeListener() {
		// public void widgetDisposed(DisposeEvent e) {
		// decrement.removeDisposeListener(this);
		// decrement.removeListener(SWT.MouseDown, widgetController);
		// }
		//
		// });
		//
		// text.addDisposeListener(new DisposeListener() {
		//
		// public void widgetDisposed(DisposeEvent e) {
		// text.removeDisposeListener(this);
		// text.removeListener(SWT.Verify, widgetController);
		// text.removeListener(SWT.FocusIn, widgetController);
		// text.removeListener(SWT.FocusOut, widgetController);
		// text.removeListener(SWT.Modify, widgetController);
		//
		// }
		//
		// });
	}

	private boolean needToCreateNewErrorToolTip(String message) {
		return null == tip || tip.isDisposed()
				|| !message.equals(oldErrorMessage);
	}

	private void saveOldErrorMessage(String message) {
		this.oldErrorMessage = message;
	}

	public void setErrorMessage(String message) {

		if (needToCreateNewErrorToolTip(message)) {
//			tip = ErrorToolTipWidget.createNewErrorToolTip(text, tip, message);
		}
		saveOldErrorMessage(message);
		tip.setVisible(true);
	}

	public void clearErrorMessage() {
		if (null != tip && !tip.isDisposed())
			tip.setVisible(false);
	}

	@Override
	public boolean setFocus() {
		if (!text.isDisposed()) {
			return text.setFocus();
		}
		return false;
	}

	protected void editable(boolean editable) {
		text.setEditable(editable);
	}

	public Text getControl() {
		return text;
	}

	public void setInitialValue(String initialValue) {
		if (isValidDefaultValue(initialValue)) {
			setValue(initialValue);
		}
		text.setSelection(text.getCharCount());

	}

	// public void setDefaultValue(String defaultValue) {
	// if (isValidDefaultValue(defaultValue)) {
	// setValue(defaultValue);
	// }
	// text.setSelection(text.getCharCount());
	// }

	public void refresh(String currentValue) {
		this.setValue(currentValue);
		text.setSelection(text.getCharCount());
	}

	public void update(Event event) {
		String value = text.getText();
		// Result result = this.widgetController.verifyText(value);
		// this.setValid(result == Result.VALID);
		// widgetController.updateModel(value);

	}

	@Override
	public void setValue(String value) {
		if (!text.getText().equals(value)) {
			text.setText(value);
		}
	}

	@Override
	public String getValue() {
		if (!text.isDisposed()) {
			return text.getText();
		}
		return "";
	}

	// @Override
	// public void hideFromView() {
	// text.setVisible(false);
	// super.hideFromView();
	// }
	//
	// @Override
	// public void unHideFromView() {
	// text.setVisible(true);
	// super.unHideFromView();
	// }

	public void setValid(boolean isValid) {
		if (isValid)
			this.text.setBackground(GUIConstants.COLOR_WHITE);
		else
			this.text.setBackground(GUIConstants.COLOR_ERROROUS_RED);
	}

	public void increaseValue() {
		String strValue = getValue();
		int value = 0;
		if (strValue.length() != 0)
			value = Integer.parseInt(strValue);
		if (!(value == Integer.MAX_VALUE))
			setValue(Integer.toString(++value));
	}

	public void decreaseValue() {
		String strValue = getValue();
		int value = 0;
		if (strValue.length() != 0)
			value = Integer.parseInt(strValue);
		if (!(value == Integer.MIN_VALUE))
			setValue(Integer.toString(--value));

		// Result result =
		// widgetController.verifyText(Integer.toString(--value));
		// if (result == Result.MIN_EXCL_VALUE_UNDERRUN)
		// setErrorMessage(String.format(
		// Messages.ERROR_MESSAGE_MIN_EXCLUSIVE,
		// widgetController.getModel().getMinExclusive().getValue()));
		// else if (result == Result.MIN_INCL_VALUE_UNDERRUN)
		// setErrorMessage(String.format(
		// Messages.ERROR_MESSAGE_MIN_INCLUSIVE,
		// widgetController.getModel().getMinInclusive().getValue()));
		// else
		// setValue(Integer.toString(value));
	}

	public void controlTypeLimits(String strValue) {
		// check integer
		try {
			int value = new Integer(strValue);
			if (value == Integer.MAX_VALUE)
				disableIncrement();
			else
				enableIncrement();

			if (value == Integer.MIN_VALUE)
				disableDecrement();
			else
				enableDecrement();
		} catch (NumberFormatException nfe) {
			disableDecrement();
			disableIncrement();
		}
	}

	void enableIncrement() {
		if (increment != null)
			if (!increment.isEnabled())
				increment.setEnabled(true);
	}

	void disableIncrement() {
		if (increment != null)
			if (increment.isEnabled())
				increment.setEnabled(false);
	}

	void enableDecrement() {
		if (decrement != null)
			if (!decrement.isEnabled())
				decrement.setEnabled(true);
	}

	void disableDecrement() {
		if (decrement != null)
			if (decrement.isEnabled())
				decrement.setEnabled(false);
	}

	public void hideFromView() {
		

	}

	public void unHideFromView() {
		

	}
	
	@Override
	public void cut() {
		text.cut();
	}
	
	@Override
	public void copy() {
		text.copy();
	}
	
	@Override
	public void paste() {
		text.paste();
	}
	
	@Override
	public void delete() {
		synchronized (text) {
			int caretPosition = text.getCaretPosition();
			String selectionText = text.getSelectionText();
			String content = text.getText();
			String result = "";
			result += content.substring(0, caretPosition
					- selectionText.length());
			result += content.substring(caretPosition, content.length());
			text.setText(result);
			text.update();
		}
	}
}
