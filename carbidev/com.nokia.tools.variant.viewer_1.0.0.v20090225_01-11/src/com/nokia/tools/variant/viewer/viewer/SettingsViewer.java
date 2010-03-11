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

package com.nokia.tools.variant.viewer.viewer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.swt.dnd.FileTransfer;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseTrackListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.internal.SWTEventListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TypedListener;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.PluginTransfer;
import org.eclipse.ui.part.ResourceTransfer;

import com.nokia.tools.variant.common.ui.utils.SWTUtil;
import com.nokia.tools.variant.viewer.composite.RulerComposite;
import com.nokia.tools.variant.viewer.images.PluginImages;
import com.nokia.tools.variant.viewer.validation.EResult;
import com.nokia.tools.variant.viewer.validation.ValidationResult;
import com.nokia.tools.variant.viewer.widgets.BaseConfMLWidget;
import com.nokia.tools.variant.viewer.widgets.BooleanCheckBox;
import com.nokia.tools.variant.viewer.widgets.DateTimeWidget;
import com.nokia.tools.variant.viewer.widgets.DateWidget;
import com.nokia.tools.variant.viewer.widgets.DurationWidget;
import com.nokia.tools.variant.viewer.widgets.ErrorToolTipMouseTrackListener;
import com.nokia.tools.variant.viewer.widgets.ErrorToolTipWidget;
import com.nokia.tools.variant.viewer.widgets.FileTextBox;
import com.nokia.tools.variant.viewer.widgets.IntegerTextBox;
import com.nokia.tools.variant.viewer.widgets.MultiSelectionWidget;
import com.nokia.tools.variant.viewer.widgets.SelectionComboBox;
import com.nokia.tools.variant.viewer.widgets.SequenceWidget;
import com.nokia.tools.variant.viewer.widgets.SequenceWidgetItem;
import com.nokia.tools.variant.viewer.widgets.StringTextBox;
import com.nokia.tools.variant.viewer.widgets.TimeWidget;
import com.nokia.tools.variant.viewer.widgets.TitleWidget;
import com.nokia.tools.variant.viewer.widgets.WidgetOptions;
import com.nokia.tools.variant.viewer.widgets.summary.ContentsBox;
import com.nokia.tools.variant.viewer.widgets.summary.LinkBox;
import com.nokia.tools.variant.viewer.widgets.summary.MultiStringTextBox;
import com.nokia.tools.variant.viewer.widgets.summary.ProductImagesBox;
import com.nokia.tools.variant.viewer.widgets.summary.ShortStringTextBox;
import com.nokia.tools.variant.viewer.widgets.summary.SimpleLinkWidget;
import com.nokia.tools.variant.viewer.widgets.summary.TableBox;

/**
 * Viewer for editing elements with values, contains widgets
 * {@link BaseConfMLWidget} Needs {@link IValuesContentProvider} as content
 * provider and {@link ISettingsLabelProvider} as label provider
 * 
 */
@SuppressWarnings("restriction")
public class SettingsViewer extends StructuredViewer {

	private static final FontData FONT_DATA = JFaceResources.getDefaultFont()
			.getFontData()[0];
	private RulerComposite rulerControl;
	/**
	 * Keys are elements, values are widgets used for editing
	 */
	private Map<Object, Composite> elementToWidgetMap = new HashMap<Object, Composite>();

	public Map<Object, Composite> getElementToWidgetMap() {
		return elementToWidgetMap;
	}

	Image errorImage = PlatformUI.getWorkbench().getSharedImages().getImage(
			ISharedImages.IMG_OBJS_ERROR_TSK);

	private Map<Object, List<Composite>> elementToErrorMap = new HashMap<Object, List<Composite>>();
	private Map<Object, BaseConfMLWidget> elementToDirtyMap = new HashMap<Object, BaseConfMLWidget>();
	private Label label;
	private Composite co;
	private String groupName;
	private Composite composite2;
	private Composite fourth;
	private Canvas first;
	private Canvas third;

	private Font titleWidgetFont = new Font(Display.getDefault(), FONT_DATA
			.getName(), 12, SWT.BOLD);
	private static Color borderColor = new Color(Display.getCurrent(), 0x7f,
			0x9d, 0xb9);
	private Canvas second;
	private MouseListener errorButtonListener;
	private MouseListener dirtyButtonListener;
	private MouseListener noteButtonListener;
	private SorterButton errorSorterButton;
	private SorterButton noteSorterButton;
	private SorterButton dirtySorterButton;
	private MouseListener topButtonListener;
	private Composite top;
	private Listener filter;
	private Map<Object, ErrorToolTipMouseTrackListener> elementToErrorListenerMap = new HashMap<Object, ErrorToolTipMouseTrackListener>();
	private Map<Object, String> elementToPropagatedErrorMap = new HashMap<Object, String>();
	private List<Object> elementToPropagatedDirtyList = new ArrayList<Object>();
	private Listener activationListener;
	private Listener deactivationListener;

	public SettingsViewer(Composite parent) {

		co = new Composite(parent, SWT.NONE);
		GridLayout gridLayout = new GridLayout();
		gridLayout.verticalSpacing = 0;
		gridLayout.horizontalSpacing = 0;
		gridLayout.marginHeight = 0;
		gridLayout.marginWidth = 0;
		co.setLayout(gridLayout);
		activationListener = new Listener() {

			public void handleEvent(Event event) {

				if (!first.isDisposed()) {
					PluginImages.BACKGROUND_COLOR = PluginImages.ACTIVATED_BACKGROUND_COLOR;
					redrawWidgetsToChangeSelectionColor();
				}

			}
		};
		co.addListener(SWT.Activate, activationListener);
		deactivationListener = new Listener() {

			public void handleEvent(Event event) {

				if (!first.isDisposed()) {
					PluginImages.BACKGROUND_COLOR = PluginImages.DEACTIVATED_BACKGROUND_COLOR;
					redrawWidgetsToChangeSelectionColor();
				}

			}
		};
		co.addListener(SWT.Deactivate, deactivationListener);
		filter = new Listener() {
			// handle traversing
			public void handleEvent(Event event) {
				if (event.detail == SWT.TRAVERSE_ARROW_NEXT) {
					if (event.stateMask == SWT.SHIFT) {
						IStructuredSelection selection = (IStructuredSelection) getSelection();
						Object child = selection.getFirstElement();
						Widget focussedItem = getFocussedItem();
						if (focussedItem != null) {
							child = focussedItem.getData();
						}
						Object[] children = getFlatStructure().toArray();
						for (int i = 0; i < children.length; i++) {
							Object object = children[i];
							if (object.equals(child)) {
								Widget doFindItem = null;
								for (int j = 1; children.length > i + j; j++) {
									doFindItem = doFindItem(children[i + j]);
									if (doFindItem != null
											&& !doFindItem
													.equals(doFindItem(child))) {
										break;
									}
								}

								if (doFindItem instanceof BaseConfMLWidget) {

									BaseConfMLWidget doFindItem2 = (BaseConfMLWidget) doFindItem;
									Composite composite = doFindItem2
											.getParent();
									if ((composite instanceof SequenceWidgetItem
											&& ((SequenceWidgetItem) composite)
													.isCollapsed() && !composite
											.getChildren()[1]
											.equals(doFindItem2))
											|| (composite instanceof SequenceWidget && ((SequenceWidget) composite)
													.isCollapsed())) {
										Control[] children2 = composite
												.getParent().getChildren();
										int indexOf = Arrays.asList(children2)
												.indexOf(composite);
										if (children2.length > indexOf + 1) {
											Control control = children2[indexOf + 1];
											if (control instanceof BaseConfMLWidget) {
												doFindItem2 = (BaseConfMLWidget) control;
											}
										}
									}
									if ((!doFindItem2.isSelected())
											&& (!(doFindItem2 instanceof SequenceWidgetItem && ((SequenceWidgetItem) doFindItem2)
													.getFirstControl()
													.isSelected()))) {
										doFindItem2.select();
										createFullSelection(doFindItem2);
										reveal(object);
										fireSelection(doFindItem2);
									} else {

										BaseConfMLWidget doFindItem3 = (BaseConfMLWidget) doFindItem(child);

										doFindItem3.deselect();
										removeFullSelection(doFindItem3);
										fireSelection(doFindItem2);
										doFindItem2.setFocus();
										if (doFindItem2 instanceof SequenceWidgetItem) {
											SequenceWidgetItem item = (SequenceWidgetItem) doFindItem2;
											item.getFirstControl().setFocus();
										}
									}

								}
							}
						}
					}
				}
				if (event.detail == SWT.TRAVERSE_ARROW_PREVIOUS) {
					if (event.stateMask == SWT.SHIFT) {
						IStructuredSelection selection = (IStructuredSelection) getSelection();
						Object child = selection.getFirstElement();
						Widget focussedItem = getFocussedItem();
						if (focussedItem != null) {
							child = focussedItem.getData();
						}
						Object[] children = getFlatStructure().toArray();
						for (int i = 0; i < children.length; i++) {
							Object object = children[i];
							if (object.equals(child)) {
								Widget doFindItem = null;
								for (int j = 1; i - j >= 0; j++) {
									doFindItem = doFindItem(children[i - j]);
									if (doFindItem != null
											&& !doFindItem
													.equals(doFindItem(child))) {
										break;
									}
								}

								if (doFindItem instanceof BaseConfMLWidget) {

									BaseConfMLWidget doFindItem2 = (BaseConfMLWidget) doFindItem;
									Composite composite = doFindItem2
											.getParent();
									if ((composite instanceof SequenceWidgetItem
											&& ((SequenceWidgetItem) composite)
													.isCollapsed() && !composite
											.getChildren()[1]
											.equals(doFindItem2))
											|| (composite instanceof SequenceWidget && ((SequenceWidget) composite)
													.isCollapsed())) {
										Control[] children2 = composite
												.getParent().getChildren();
										int indexOf = Arrays.asList(children2)
												.indexOf(composite);
										if (children2.length > indexOf) {
											Control control = children2[indexOf];
											if (control instanceof BaseConfMLWidget) {
												doFindItem2 = (BaseConfMLWidget) control;
											}
										}
									}
									if (!doFindItem2.isSelected()
											&& (!(doFindItem2 instanceof SequenceWidgetItem && ((SequenceWidgetItem) doFindItem2)
													.getFirstControl()
													.isSelected()))) {
										doFindItem2.select();
										createFullSelection(doFindItem2);
										reveal(object);
										fireSelection(doFindItem2);
									} else {
										BaseConfMLWidget doFindItem3 = (BaseConfMLWidget) doFindItem(child);
										doFindItem3.deselect();
										removeFullSelection(doFindItem3);
										fireSelection(doFindItem2);
										doFindItem2.setFocus();
										if (doFindItem2 instanceof SequenceWidgetItem) {
											SequenceWidgetItem item = (SequenceWidgetItem) doFindItem2;
											item.getFirstControl().setFocus();
										}
									}
								}
							}
						}
					}
				}
				if (event.detail == SWT.TRAVERSE_TAB_NEXT) {
					IStructuredSelection selection = (IStructuredSelection) getSelection();
					Object child = selection.getFirstElement();

					Object[] children = getFlatStructure().toArray();
					for (int i = 0; i < children.length; i++) {
						Object object = children[i];
						if (object.equals(child)) {
							Widget doFindItem = null;
							for (int j = 1; children.length > i + j; j++) {
								doFindItem = doFindItem(children[i + j]);
								if (doFindItem != null) {
									break;
								}
							}

							if (doFindItem instanceof BaseConfMLWidget) {
								Widget focussedItem = getFocussedItem();
								if (focussedItem instanceof MultiSelectionWidget) {
									MultiSelectionWidget w = (MultiSelectionWidget) focussedItem;
									Control[] children2 = w.getChildren();
									Composite composite = (Composite) children2[children2.length - 1];
									Control[] children3 = composite
											.getChildren();
									Control control = children3[children3.length - 1];
									if (!control.isFocusControl()) {
										return;
									}

								}
								internalDeselectAllWidgets();

								BaseConfMLWidget baseConfMLWidget = (BaseConfMLWidget) doFindItem;
								baseConfMLWidget.setReveal(true);
								baseConfMLWidget.select();
								createFullSelection((BaseConfMLWidget) doFindItem);

								fireSelection((BaseConfMLWidget) doFindItem);
							}
						}
					}
				}
				if (event.detail == SWT.TRAVERSE_TAB_PREVIOUS) {
					IStructuredSelection selection = (IStructuredSelection) getSelection();
					Object child = selection.getFirstElement();

					Object[] children = getFlatStructure().toArray();
					for (int i = 0; i < children.length; i++) {
						Object object = children[i];
						if (object.equals(child)) {
							Widget doFindItem = null;
							for (int j = 1; i - j >= 0; j++) {
								doFindItem = doFindItem(children[i - j]);
								if (doFindItem != null) {
									break;
								}
							}

							if (doFindItem instanceof BaseConfMLWidget) {
								Widget focussedItem = getFocussedItem();
								if (focussedItem instanceof MultiSelectionWidget) {
									MultiSelectionWidget w = (MultiSelectionWidget) focussedItem;
									Control[] children2 = w.getChildren();
									Composite composite = (Composite) children2[children2.length - 1];
									Control[] children3 = composite
											.getChildren();
									Control control = children3[0];
									if (!control.isFocusControl()) {
										return;
									}

								}
								internalDeselectAllWidgets();
								BaseConfMLWidget baseConfMLWidget = (BaseConfMLWidget) doFindItem;
								baseConfMLWidget.setReveal(true);
								baseConfMLWidget.select();
								createFullSelection((BaseConfMLWidget) doFindItem);

								fireSelection((BaseConfMLWidget) doFindItem);
							}
						}
					}
				}
			}

		};
		Display.getCurrent().addFilter(SWT.Traverse, filter);
	}

	private Widget getFocussedItem() {
		IStructuredSelection selection = (IStructuredSelection) getSelection();
		Object[] array = selection.toArray();
		for (Object object : array) {
			Widget doFindItem = doFindItem(object);
			if (doFindItem instanceof Composite) {
				Composite comp = (Composite) doFindItem;
				if (comp.isFocusControl()) {
					return comp;
				}
				Control[] children = comp.getChildren();
				for (Control control : children) {
					if (control.isFocusControl()) {
						return comp;
					}
					if (control instanceof Composite) {
						Control[] children2 = ((Composite) control)
								.getChildren();
						for (Control control2 : children2) {
							if (control2.isFocusControl()) {
								return comp;
							}
						}
					}
				}
			}
		}
		return null;
	}

	/**
	 * Shows error marker for element with errorDescription as tooltip
	 * 
	 * @param element
	 * @param errorDescription
	 */
	public void createError(final Object element, final String errorDescription) {
		if (first == null || first != null && first.isDisposed()) {
			return;
		}

		if (elementToErrorMap.containsKey(element)) {
			removeError(element);
		}
		IValuesContentProvider contentProvider = (IValuesContentProvider) getContentProvider();

		Object parentElement = contentProvider.getParent(element);
		if (parentElement != null) {
			ISettingsLabelProvider provider = (ISettingsLabelProvider) getLabelProvider();
			Type type = provider.getType(parentElement);
			if (type.equals(Type.ITEM)) {
				Object parentOfParentElement = contentProvider
						.getParent(parentElement);
				if (parentOfParentElement != null) {
					elementToPropagatedErrorMap.put(parentElement,
							errorDescription);
					elementToPropagatedErrorMap.put(parentOfParentElement,
							errorDescription);
				}
			}
		}
		Widget item = doFindItem(element);

		List<Composite> list = new ArrayList<Composite>();
		final Composite comm = new Composite(fourth, SWT.NONE);
		list.add(comm);
		comm.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_RED));
		Composite composite = elementToWidgetMap.get(element);
		if (composite == null) {
			return;
		}
		Point location = SWTUtil.getControlLocation(rulerControl
				.getScrolledComposite(), composite);
		Composite parent = composite.getParent();
		if (parent instanceof SequenceWidgetItem) {
			if (((SequenceWidgetItem) parent).isCollapsed()) {
				composite = parent;
				parent = composite.getParent();
				if (parent instanceof SequenceWidget) {
					if (((SequenceWidget) parent).isCollapsed()) {
						composite = parent;
					}
				}
			}

		}
		final Composite comp = composite;
		int absoluteLocation = location.y + composite.getSize().y / 2;
		float controlHeight = composite2.getSize().y;
		float fourthHeight = fourth.getSize().y;
		float ratio = fourthHeight / controlHeight;
		Float commLocation = ratio * absoluteLocation;
		comm.setLocation(0, commLocation.intValue());
		comm.setSize(10, 3);
		fourth.addControlListener(new ControlListener() {

			public void controlMoved(ControlEvent e) {

			}

			public void controlResized(ControlEvent e) {
				computeErrorLineLocation(comm, comp);

			}

		});

		comm.addMouseTrackListener(new MouseTrackListener() {

			public void mouseEnter(MouseEvent e) {
				comm.getShell().setCursor(
						Display.getCurrent().getSystemCursor(SWT.CURSOR_HAND));

			}

			public void mouseExit(MouseEvent e) {
				comm.getShell().setCursor(
						Display.getCurrent().getSystemCursor(SWT.DEFAULT));

			}

			public void mouseHover(MouseEvent e) {

			}

		});

		comm.addMouseListener(new MouseListener() {

			public void mouseDoubleClick(MouseEvent e) {

			}

			public void mouseDown(MouseEvent e) {

			}

			public void mouseUp(MouseEvent e) {
				setSelection(new StructuredSelection(element), true);

			}

		});
		first.addPaintListener(new ErrorPaintListener((Composite) item));

		first.redraw();
		ErrorToolTipMouseTrackListener listener = new ErrorToolTipMouseTrackListener(
				ErrorToolTipWidget.createNewErrorToolTip(first,
						errorDescription), first, rulerControl
						.getScrolledComposite(), (Composite) item);

		first.addMouseTrackListener(listener);
		elementToErrorListenerMap.put(element, listener);
		elementToErrorMap.put(element, list);

	}

	@Override
	protected Widget doFindInputItem(Object element) {
		Object root = getRoot();
		if (root == null) {
			return null;
		}

		if (equals(root, element)) {
			return rulerControl;
		}
		return null;
	}

	@Override
	protected Widget doFindItem(Object element) {
		if (elementToErrorMap == null) {
			return null;
		}
		return elementToWidgetMap.get(element);
	}

	@Override
	protected void doUpdateItem(Widget item, Object element, boolean fullMap) {
		IContentProvider contentProvider = getContentProvider();
		if (contentProvider instanceof IValuesContentProvider) {
			IValuesContentProvider valuesProvider = (IValuesContentProvider) contentProvider;
			String value = valuesProvider.getValue(element);
			validate(element, value);
			handleNote(valuesProvider, element);
			handleDirty(element);
			handleDefault(element);
			BaseConfMLWidget confMLWidget = (BaseConfMLWidget) item;
			ISettingsLabelProvider labelProvider = (ISettingsLabelProvider) getLabelProvider();
			WidgetOptions options = labelProvider.getOptions(element);

			confMLWidget.setOptions(options);
			if (confMLWidget.getValue() == null) {
				return;
			}
			if (value != null && confMLWidget.getValue().equals(value)) {

				return;
			}

			confMLWidget.setValue(value);

		}

	}

	private void handleNote(IValuesContentProvider valuesProvider,
			Object element) {
		removeNote(element);
		if (valuesProvider.hasNote(element)) {
			createNote(element);
		}

	}

	private void createNote(Object element) {

		Composite composite = elementToWidgetMap.get(element);
		if (composite instanceof BaseConfMLWidget) {

			second.addPaintListener(new NotePaintListener(composite));
		}
	}

	private void removeNote(Object element) {
		Composite composite = elementToWidgetMap.get(element);
		if (composite instanceof BaseConfMLWidget) {

			if (!second.isDisposed()) {
				Listener[] listeners = second.getListeners(SWT.Paint);
				for (Listener listener : listeners) {
					if (listener instanceof TypedListener) {
						TypedListener typedListener = (TypedListener) listener;
						SWTEventListener eventListener = typedListener
								.getEventListener();
						if (eventListener instanceof NotePaintListener) {
							NotePaintListener noteListener = (NotePaintListener) eventListener;
							if (noteListener.getTextBox().equals(composite)) {
								second.removeListener(SWT.Paint, listener);
							}
						}
					}
				}
				second.redraw();
			}
		}

	}

	@Override
	protected void preservingSelection(Runnable updateCode) {
		updateCode.run();
	}

	@SuppressWarnings("unchecked")
	@Override
	protected List getSelectionFromWidget() {
		List<Object> selectionList = new ArrayList<Object>();

		Set<Object> keySet = elementToWidgetMap.keySet();
		for (Object key : keySet) {
			Composite composite = elementToWidgetMap.get(key);
			if (composite instanceof BaseConfMLWidget) {
				BaseConfMLWidget confmlWidget = (BaseConfMLWidget) composite;
				if (confmlWidget.isSelected()) {
					selectionList.add(key);
				}
			}
		}
		return selectionList;
	}

	@Override
	protected void internalRefresh(final Object element) {
		if (element == null) {

			return;
		}

		PluginImages.BACKGROUND_COLOR = PluginImages.ACTIVATED_BACKGROUND_COLOR;
		Shell shell = getControl().getShell();
		Cursor oldCursor = shell.getCursor();
		shell.setCursor(shell.getDisplay().getSystemCursor(SWT.CURSOR_WAIT));

		try {
			if (element.equals(getRoot())) {

				Object[] array = elementToWidgetMap.keySet().toArray();
				for (int i = 0; i < array.length; i++) {
					Composite composite = elementToWidgetMap.get(array[i]);
					composite.dispose();
				}
				elementToWidgetMap.clear();
				elementToErrorMap.clear();
				elementToErrorListenerMap.clear();
				elementToPropagatedErrorMap.clear();
				elementToPropagatedDirtyList.clear();
				Control[] controls = co.getChildren();
				for (Control control : controls) {
					control.dispose();
				}

				createMainControl();
				IContentProvider contentProvider = getContentProvider();
				IBaseLabelProvider baseLabelProvider = getLabelProvider();
				if (contentProvider instanceof IValuesContentProvider
						&& baseLabelProvider instanceof ILabelProvider) {
					ILabelProvider labelProvider = (ILabelProvider) baseLabelProvider;
					IValuesContentProvider valuesContentProvider = (IValuesContentProvider) contentProvider;
					Object root = getRoot();
					Object[] elements = valuesContentProvider.getElements(root);
					elements = filter(elements);
					for (int i = 0; i < elements.length; i++) {

						createWidget(composite2, elements[i], labelProvider,
								valuesContentProvider, null, i);
					}

				}

				co.layout(true, true);

				rulerControl.getRuler().layout(true, true);

				if (contentProvider instanceof IValuesContentProvider) {
					IValuesContentProvider valuesContentProvider = (IValuesContentProvider) contentProvider;
					Set<Object> keySet = elementToWidgetMap.keySet();

					for (Object object : keySet) {

						String value = valuesContentProvider.getValue(object);
						validate(object, value);
						handleDirty(object);
						handleNote(valuesContentProvider, object);

					}
				}
			} else {
				handleStructuralChanges(element);

			}
		} finally {
			shell.setCursor(oldCursor);
		}

	}

	private void handleStructuralChanges(final Object element) {
		IValuesContentProvider valuesContentProvider = (IValuesContentProvider) getContentProvider();
		Object parent = valuesContentProvider.getParent(element);
		if (parent == null) {
			Control doFindItem = (Control) doFindItem(element);
			if (doFindItem == null) {
				ITreeContentProvider contentProvider = (ITreeContentProvider) getContentProvider();
				Object[] children = contentProvider.getChildren(element);

				if (children != null && children.length > 0) {
					for (Object object : children) {
						doFindItem = elementToWidgetMap.get(object);
						if (doFindItem instanceof Widget) {
							doFindItem.dispose();
						}
						removeError(object);
						removeDirtyFlag(object);
						removeNote(object);
					}
					doFindItem = elementToWidgetMap.get(children[0]);

				}
			}
			if (doFindItem != null && !doFindItem.isDisposed()) {
				Composite parent2 = doFindItem.getParent();
				if (parent2 instanceof SequenceWidgetItem) {
					doFindItem = parent2;
				}
			}
			if (doFindItem instanceof Composite) {
				Composite com = (Composite) doFindItem;
				if (com.isDisposed()) {
					return;
				}
				Composite p2 = com.getParent();

				elementToWidgetMap.remove(element);
				elementToDirtyMap.remove(element);
				elementToErrorMap.remove(element);
				elementToPropagatedDirtyList.remove(element);
				elementToPropagatedErrorMap.remove(element);
				removeError(element);
				removeDirtyFlag(element);
				removeNote(element);
				com.dispose();

				p2.layout(false, false);

				if (p2 instanceof SequenceWidget) {
					p2.layout(true, true);
					p2.getParent().layout(false, false);

				}

			}
		} else {
			Control widget = (Control) doFindItem(element);
			if (widget == null) {
				createWidget(composite2, element,
						(ILabelProvider) getLabelProvider(),
						valuesContentProvider, null, -1);
				Object[] children = getTopStructure().toArray();
				Widget doFindItem = null;
				for (int i = 0; i < children.length; i++) {
					Object object = children[i];
					if (object.equals(element)) {

						for (int j = 1; children.length > i + j; j++) {
							doFindItem = doFindItem(children[i + j]);
							if (doFindItem != null) {
								break;
							}
						}
					}
				}

				Composite composite = elementToWidgetMap.get(element);
				if (composite == null) {
					ITreeContentProvider contentProvider = (ITreeContentProvider) getContentProvider();
					Object[] children1 = contentProvider.getChildren(element);

					if (children1 != null && children1.length > 0) {

						composite = elementToWidgetMap.get(children1[0]);

					}
				}
				if (composite != null) {
					Control doFindItem2 = (Control) doFindItem;

					if (doFindItem2 instanceof TitleWidget) {
						doFindItem2 = doFindItem2.getParent();
					}
					if (doFindItem2 != null) {
						while (!doFindItem2.getParent().equals(composite2)) {
							doFindItem2 = doFindItem2.getParent();
						}
						while (!composite.getParent().equals(composite2)) {
							composite = composite.getParent();
						}

						if (composite.equals(doFindItem2)
								&& composite instanceof FileTextBox) {
							handleFileWidget((FileTextBox) composite);
						} else {
							composite.moveAbove(doFindItem2);
						}
					}
					validate(element, valuesContentProvider.getValue(element));
					handleDefault(element);
					handleDirty(element);
					composite2.layout(false, false);

				}
			}
		}
	}

	private void handleFileWidget(FileTextBox textBox) {
		Object data = textBox.getData();
		IValuesContentProvider contentProvider = (IValuesContentProvider) getContentProvider();
		Object[] children = contentProvider.getChildren(contentProvider
				.getParent(data));
		Widget doFindItem = null;
		for (int i = 0; i < children.length; i++) {
			Object object = children[i];
			if (object.equals(data)) {

				for (int j = 1; children.length > i + j; j++) {
					doFindItem = doFindItem(children[i + j]);
					if (doFindItem != null) {
						break;
					}
				}
			}
		}
		if(doFindItem==null){
			return;
		}
		Object data2 = doFindItem.getData();

		Object[] children2 = getFlatStructure().toArray();
		Widget doFindItem2 = null;
		for (int i = 0; i < children2.length; i++) {
			Object object = children2[i];
			if (object.equals(data2)) {

				for (int j = 1; children2.length > i + j; j++) {
					doFindItem2 = doFindItem(children2[i + j]);
					if (doFindItem2 != null) {
						break;
					}
				}
			}
		}
		if (doFindItem2 instanceof TitleWidget) {
			doFindItem2 = ((Control) doFindItem2).getParent();
		}
		if (doFindItem2 != null) {
			((Control) doFindItem).moveAbove((Control) doFindItem2);
			textBox.moveAbove((Control) doFindItem);
		}

	}

	private void createWidget(Composite parent, Object object,
			ILabelProvider labelProvider,
			final IValuesContentProvider valuesContentProvider, Image image,
			int i) {

		String text = labelProvider.getText(object);
		Composite s = parent;
		GridLayout gl = new GridLayout();
		gl.marginHeight = 0;
		gl.marginWidth = 0;
		gl.verticalSpacing = 0;
		s.setLayout(gl);
		s.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		Type type2 = ((ISettingsLabelProvider) labelProvider).getType(object);
		if (type2.equals(Type.TITLE)) {
			Composite subTitle = new Composite(s, SWT.NONE);
			subTitle.setBackground(borderColor);
			gl = new GridLayout();
			gl.marginHeight = 0;
			gl.marginTop = (i == 0) ? 0 : 1;
			gl.marginBottom = 1;
			gl.marginWidth = 0;
			gl.verticalSpacing = 0;
			subTitle.setLayout(gl);
			subTitle.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			TitleWidget title = new TitleWidget(subTitle, SWT.NONE, text);
			title.setBackground(title.getDisplay().getSystemColor(
					SWT.COLOR_WIDGET_BACKGROUND));
			initializeWidget(valuesContentProvider, object, title);
		} else {
			s.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

			Composite settingComposite = s;
			GridData gd = new GridData(GridData.FILL_HORIZONTAL);
			GridLayout gridLayout = new GridLayout();
			gridLayout.marginHeight = 0;
			gridLayout.marginWidth = 0;
			gridLayout.verticalSpacing = 0;
			settingComposite.setLayout(gridLayout);
			settingComposite.setLayoutData(gd);
			settingComposite.setBackground(s.getBackground());
			String labelText = labelProvider.getText(object);
			Composite textBox = null;
			if (labelProvider instanceof ISettingsLabelProvider) {
				ISettingsLabelProvider settingsLabelProvider = (ISettingsLabelProvider) labelProvider;
				Type type = settingsLabelProvider.getType(object);
				WidgetOptions options = settingsLabelProvider
						.getOptions(object);
				if (type.equals(Type.SELECTION)) {
					textBox = new SelectionComboBox(settingComposite, SWT.NONE,
							labelText, options, image);
				}
				if (type.equals(Type.MULTISELECTION)) {
					// IMPROVEMENT replace with correct widget
					textBox = new MultiSelectionWidget(settingComposite,
							SWT.NONE, labelText, options);
				}
				if (type.equals(Type.BOOLEAN)) {
					textBox = new BooleanCheckBox(settingComposite, SWT.NONE,
							labelText, options, image);
				}

				if (type.equals(Type.STRING)) {
					textBox = new StringTextBox(settingComposite, SWT.NONE,
							labelText, options, image);
				}
				if (type.equals(Type.SIMPLE_FILE)) {
					textBox = createSourcePathWidget(object,
							valuesContentProvider, options, image,
							settingComposite, labelText, object);
					return;
				}
				if (type.equals(Type.FILE)) {
					Object[] fileValues = valuesContentProvider
							.getChildren(object);
					if (fileValues.length == 0) {
						return;
					}

					for (Object object2 : fileValues) {
						if (settingsLabelProvider.getType(object2).equals(
								Type.FILESOURCE)) {
							textBox = createSourcePathWidget(object,
									valuesContentProvider,
									settingsLabelProvider.getOptions(object2),
									image, settingComposite, labelText,
									fileValues[0]);

						}
						if (settingsLabelProvider.getType(object2).equals(
								Type.FILETARGET)) {
							Image arrowImage = PluginImages.FILE;
							String targetPathLabel = "Location in Phone";
							if (fileValues.length == 1) {
								targetPathLabel = labelText + " - "
										+ targetPathLabel;
								arrowImage = null;
							}
							textBox = new StringTextBox(settingComposite,
									SWT.NONE, targetPathLabel, arrowImage);
							initializeWidget(valuesContentProvider, object2,
									textBox);
						}
					}

					return;

				}
				if (type.equals(Type.SEQUENCE)) {
					textBox = createSequenceWidget(settingComposite, SWT.NONE,
							object, settingsLabelProvider,
							valuesContentProvider);
					return;
				}
				if (type.equals(Type.CONTENTS)) {
					textBox = new ContentsBox(settingComposite, SWT.NONE,
							labelText, image);
					((BaseConfMLWidget) textBox).setOptions(options);
				}

				if (type.equals(Type.DESCRIPTION)) {
					textBox = new MultiStringTextBox(settingComposite,
							SWT.NONE, labelText, image);

				}
				if (type.equals(Type.ELEMENT_READONLY)) {
					textBox = new ShortStringTextBox(settingComposite,
							SWT.NONE, labelText, image, SWT.BORDER | SWT.RIGHT);

				}
				if (type.equals(Type.ELEMENT_EDITABLE)) {
					textBox = new StringTextBox(settingComposite, SWT.NONE,
							labelText, image);

				}
				if (type.equals(Type.DATE)) {
					textBox = new DateWidget(settingComposite, SWT.NONE,
							labelText, options);

				}
				if (type.equals(Type.DATE_TIME)) {
					textBox = new DateTimeWidget(settingComposite, SWT.NONE,
							labelText, options);

				}
				if (type.equals(Type.TIME)) {
					textBox = new TimeWidget(settingComposite, SWT.NONE,
							labelText, options);

				}
				if (type.equals(Type.DURATION)) {
					textBox = new DurationWidget(settingComposite, SWT.NONE,
							labelText, options);

				}
				if (type.equals(Type.GUIDELINE)) {
					textBox = new LinkBox(settingComposite, SWT.NONE,
							labelText, image);

				}
				if (type.equals(Type.PRODUCTIMAGES)) {
					textBox = new ProductImagesBox(settingComposite, SWT.NONE,
							labelText, image);
				}
				if (type.equals(Type.HISTORY)) {
					textBox = new TableBox(settingComposite, SWT.NONE,
							labelText, image);
					((BaseConfMLWidget) textBox).setOptions(options);
				}
				if (type.equals(Type.INT)) {
					textBox = new IntegerTextBox(settingComposite, SWT.NONE,
							labelText, options, image);
				}
				if (type.equals(Type.AVR)) {
					textBox = new SimpleLinkWidget(settingComposite, SWT.NONE,
							labelText, image);
				}
			}

			if (textBox != null) {
				initializeWidget(valuesContentProvider, object, textBox);
			}
		}
		Object[] children = valuesContentProvider.getChildren(object);
		children = filter(children);
		for (int j = 0; j < children.length; j++) {
			createWidget(parent, children[j], labelProvider,
					valuesContentProvider, image, j);
		}

	}

	private FileTextBox createSourcePathWidget(Object object,
			final IValuesContentProvider valuesContentProvider,
			WidgetOptions options, Image image, Composite settingComposite,
			String labelText, Object fileSetting) {
		FileTextBox textBox = new FileTextBox(settingComposite, SWT.NONE,
				labelText, options, image);

		Transfer[] transfers = new Transfer[] {
				LocalSelectionTransfer.getTransfer(),
				ResourceTransfer.getInstance(), FileTransfer.getInstance(),
				PluginTransfer.getInstance(), TextTransfer.getInstance() };
		int ops = DND.DROP_COPY | DND.DROP_MOVE;
		DropTargetListener adapter = valuesContentProvider
				.getDropTargetListener(object);
		DropTarget dropTarget = new DropTarget(textBox, ops | DND.DROP_DEFAULT);
		dropTarget.setTransfer(transfers);
		dropTarget.addDropListener(adapter);

		((BaseConfMLWidget) textBox).addDropListener(adapter);

		initializeWidget(valuesContentProvider, fileSetting, textBox);

		return textBox;
	}

	private void createSequenceWidget(
			final SequenceWidgetItem settingComposite,
			final Object parentElement, final ILabelProvider labelProvider,
			final IValuesContentProvider valuesContentProvider,
			final Image image) {

		Object[] children = valuesContentProvider.getChildren(parentElement);
		int j = 0;
		for (int i = 0; i < children.length; i++, j++) {
			Object child = children[i];
			String labelText = labelProvider.getText(child);
			Composite textBox = null;
			if (labelProvider instanceof ISettingsLabelProvider) {
				ISettingsLabelProvider settingsLabelProvider = (ISettingsLabelProvider) labelProvider;
				Type type = settingsLabelProvider.getType(child);
				WidgetOptions options = settingsLabelProvider.getOptions(child);
				if (type.equals(Type.INT)) {
					textBox = new IntegerTextBox(settingComposite, SWT.NONE,
							labelText, options, image);
				}
				if (type.equals(Type.SELECTION)) {
					textBox = new SelectionComboBox(settingComposite, SWT.NONE,
							labelText, options, image);
				}
				if (type.equals(Type.MULTISELECTION)) {
					// IMPROVEMENT replace with correct widget
					textBox = new MultiSelectionWidget(settingComposite,
							SWT.NONE, labelText, settingsLabelProvider
									.getOptions(child));
				}
				if (type.equals(Type.BOOLEAN)) {
					textBox = new BooleanCheckBox(settingComposite, SWT.NONE,
							labelText, options, image);
				}

				if (type.equals(Type.STRING)) {
					textBox = new StringTextBox(settingComposite, SWT.NONE,
							labelText, options, image);
				}
				if (type.equals(Type.FILE)) {
					Object[] fileValues = valuesContentProvider
							.getChildren(child);
					if (fileValues.length == 0) {
						continue;
					}

					for (Object object2 : fileValues) {
						if (settingsLabelProvider.getType(object2).equals(
								Type.FILESOURCE)) {
							textBox = createSourcePathWidget(child,
									valuesContentProvider,
									settingsLabelProvider
											.getOptions(fileValues[0]), image,
									settingComposite, labelText, fileValues[0]);
							shiftWidget(j, textBox);
							j++;
						}
						if (settingsLabelProvider.getType(object2).equals(
								Type.FILETARGET)) {
							textBox = new StringTextBox(settingComposite,
									SWT.NONE, "Location in Phone",
									PluginImages.FILE);
							initializeWidget(valuesContentProvider,
									fileValues[1], textBox);
							shiftWidget(j, textBox);
							j++;
						}
					}

					continue;

				}
				if (type.equals(Type.SIMPLE_FILE)) {
					textBox = createSourcePathWidget(child,
							valuesContentProvider, options, image,
							settingComposite, labelText, child);
				}
				if (type.equals(Type.SEQUENCE)) {
					textBox = createSequenceWidget(settingComposite,
							SWT.BORDER, child, settingsLabelProvider,
							valuesContentProvider);
				}
				if (type.equals(Type.CONTENTS)) {
					textBox = new ContentsBox(settingComposite, SWT.NONE,
							labelText, image);
				}
				if (type.equals(Type.PRODUCTIMAGES)) {
					textBox = new ProductImagesBox(settingComposite,
							SWT.BORDER, labelText, image);
				}
				if (type.equals(Type.DATE)) {
					textBox = new DateWidget(settingComposite, SWT.NONE,
							labelText, options);

				}
				if (type.equals(Type.DATE_TIME)) {
					textBox = new DateTimeWidget(settingComposite, SWT.NONE,
							labelText, options);

				}
				if (type.equals(Type.TIME)) {
					textBox = new TimeWidget(settingComposite, SWT.NONE,
							labelText, options);

				}
				if (type.equals(Type.DURATION)) {
					textBox = new DurationWidget(settingComposite, SWT.NONE,
							labelText, options);

				}
			}
			if (textBox == null) {
				textBox = new IntegerTextBox(settingComposite, SWT.NONE,
						labelText, image);
			}
			shiftWidget(i, textBox);
			((BaseConfMLWidget) textBox)
					.addPropertyChangeListener(settingComposite
							.getItemPropertyListener());
			initializeWidget(valuesContentProvider, child, textBox);

		}

	}

	private void shiftWidget(int i, Composite textBox) {
		if (i > 0 && textBox instanceof BaseConfMLWidget) {
			Layout layout = ((BaseConfMLWidget) textBox).getLayout();
			if (layout instanceof GridLayout) {
				GridLayout gl = (GridLayout) layout;
				gl.marginLeft = 2 * SequenceWidget.LEFT_CONTROL_WIDTH;
			}
		}
	}

	private void initializeWidget(
			final IValuesContentProvider valuesContentProvider,
			final Object child, final Composite textBox) {
		textBox.setData(child);
		String value = valuesContentProvider.getValue(child);
		if (textBox instanceof BaseConfMLWidget) {

			BaseConfMLWidget widget = (BaseConfMLWidget) textBox;
			widget.setValue(value);
			elementToWidgetMap.put(child, textBox);
			if (!(widget instanceof TitleWidget)) {
				handleDefault(child);
			} else {
				Object parent = valuesContentProvider.getParent(child);
				ISettingsLabelProvider labelProvider = (ISettingsLabelProvider) getLabelProvider();
				if (labelProvider.getType(parent).equals(Type.TITLE)) {
					TitleWidget titleWidget = (TitleWidget) elementToWidgetMap
							.get(parent);

					titleWidget.setLabelFont(titleWidgetFont);

					Object layoutData = titleWidget.getLayoutData();
					if (layoutData instanceof GridData) {
						GridData gd = (GridData) layoutData;
						gd.heightHint = 40;
					}
				}
			}
			widget.setDirty(valuesContentProvider.isDirty(child));

			widget.setRuler(rulerControl);
			addListener(widget);
			addDNDListener(widget);

		}
	}

	private void addDNDListener(BaseConfMLWidget widget) {
		if (widget.getParent() instanceof SequenceWidgetItem) {
			widget.setRuler(rulerControl);
			IValuesContentProvider provider = (IValuesContentProvider) getContentProvider();
			widget.addDragListener(provider.getDragSourceListener(widget
					.getData()));
			widget.addDropListener(provider.getDropTargetListener(widget));

		}
	}

	private Composite createSequenceWidget(Composite parent, int style,
			Object parentElement, ISettingsLabelProvider settingsLabelProvider,
			final IValuesContentProvider valuesContentProvider) {
		String text = settingsLabelProvider.getText(parentElement);
		if (text == null) {
			text = "";
		}
		SequenceWidget sWidget = new SequenceWidget(parent, style, text);
		sWidget.setErrorComposite(first);
		sWidget.setNoteComposite(second);
		sWidget.setDirtyComposite(third);
		sWidget.addExpandListener(new Listener() {

			public void handleEvent(Event event) {
				computeAllErrorsLocation(valuesContentProvider);
			}

		});
		initializeWidget(valuesContentProvider, parentElement, sWidget);

		Object[] children = valuesContentProvider.getChildren(parentElement);
		if (children != null) {
			for (int i = 0; i < children.length; i++) {
				SequenceWidgetItem sqItem = new SequenceWidgetItem(sWidget,
						style);
				sqItem.setErrorComposite(first);
				sqItem.setNoteComposite(second);
				sqItem.setDirtyComposite(third);
				sqItem.setData(children[i]);
				createSequenceWidget(sqItem, children[i],
						settingsLabelProvider, valuesContentProvider, null);

				addListener(sqItem);
				sqItem.setRuler(rulerControl);
			}
		}
		return sWidget;
	}

	class TextBoxListener implements Listener {
		private BaseConfMLWidget textBox;

		public TextBoxListener(BaseConfMLWidget textBox) {
			this.textBox = textBox;
		}

		public void handleEvent(Event event) {

			switch (event.type) {
			case SWT.KeyDown:
				if (event.character == '\r') {
					String value = textBox.getValue();
					Object data = textBox.getData();
					textBox.setWasErrorDialogShown(false);
					fireValueChanged(value, data);

					// update selection - for example: update state of the
					// preview view
					handleSelection(textBox, event);
					createContextMenu(event);
				}

				// Reseting the value to the previous by pressing ESC key
				if (event.character == SWT.ESC) {
					doUpdateItem(textBox, textBox.getData(), true);
				}
				break;

			case SWT.Modify:
				if (/*
					 * textBox instanceof FileTextBox ||
					 */textBox instanceof DateWidget
						|| textBox instanceof TimeWidget
						|| textBox instanceof DateTimeWidget
						|| textBox instanceof DurationWidget) {
					String value4 = textBox.getValue();
					Object data4 = textBox.getData();
					textBox.setWasErrorDialogShown(false);

					fireValueChanged(value4, data4);

				} else {
					textBox.setWasErrorDialogShown(false);
				}
				break;

			case SWT.Dispose:

				String value1 = textBox.getValue();
				Object data1 = textBox.getData();
				if (!(textBox instanceof SelectionComboBox))
					fireValueChanged(value1, data1);

				break;
			case SWT.FocusOut:
				String value = textBox.getValue();
				final Object data = textBox.getData();
				if (!(textBox instanceof SelectionComboBox)) {
					fireValueChanged(value, data);
				}
				if (textBox.isDirty() && textBox.hasError()) {
					if (textBox.isWasErrorDialogShown()) {
						break;
					}
					textBox.setWasErrorDialogShown(true);
					MessageDialog dialog = new MessageDialog(
							getControl().getShell(),
							"Invalid value entered",
							null,
							"You have entered invalid value.\nDo you want to continue or go back and resolve the problem?",
							MessageDialog.QUESTION, new String[] { "Continue",
									"Go Back" }, 0);

					int result = dialog.open();
					if (result == 1) {
						getControl().getDisplay().asyncExec(new Runnable() {
							public void run() {
								setSelection(new StructuredSelection(data));
							}
						});
					}
				}
				break;
			case SWT.MouseDown:
				handleSelection(textBox, event);

				// display context menu
				createContextMenu(event);
				break;

			case SWT.Selection:
				textBox.select();

				fireSelection(textBox);

				String value2 = textBox.getValue();
				Object data2 = textBox.getData();
				textBox.setWasErrorDialogShown(false);
				if (textBox instanceof SelectionComboBox) {
					fireValueChangedFromComboBox(value2, data2);
				} else {
					fireValueChanged(value2, data2);
				}
				break;

			case 123456:
				handleSelection(textBox, event);
				if (!(textBox instanceof SelectionComboBox)) {
					fireValueChanged(textBox.getValue(), textBox.getData());
				}
				break;
			}
		}
	}

	private void addListener(BaseConfMLWidget textBox) {
		textBox.addListener(new TextBoxListener(textBox));
	}

	/**
	 * Display first popup menu from component or its parent tree. Needed for
	 * NoMoreHandles problem
	 * 
	 * @param event
	 */
	private void createContextMenu(Event event) {
		if (event.button == 3) {
			Control control = (Control) event.widget;
			Point absoluteLoc = control.toDisplay(event.x, event.y);
			while (control != null && control.getMenu() == null) {
				control = control.getParent();
			}
			if (control != null) {
				control.getMenu().setLocation(absoluteLoc);
				control.getMenu().setVisible(true);
			}
		}
	}

	@Override
	public void reveal(Object element) {
		Widget item = doFindItem(element);
		if (item == null) {

			ITreeContentProvider contentProvider = (ITreeContentProvider) getContentProvider();
			Object[] children = contentProvider.getChildren(element);

			if (children != null && children.length > 0) {

				item = elementToWidgetMap.get(children[0]);

			}

		}
		if (item instanceof BaseConfMLWidget) {
			SWTUtil.ensureVisible(((BaseConfMLWidget) item).getRuler()
					.getScrolledComposite(), (Control) item);
		}
		if (item instanceof Control) {
			SWTUtil.ensureVisible((Control) item);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void setSelectionToWidget(List l, boolean reveal) {
		internalDeselectAllWidgets();
		for (Object object : l) {
			Composite composite = elementToWidgetMap.get(object);
			if (composite == null) {
				ITreeContentProvider contentProvider = (ITreeContentProvider) getContentProvider();
				Object[] children = contentProvider.getChildren(object);

				if (children != null && children.length > 0) {

					composite = elementToWidgetMap.get(children[0]);

				}
			}
			if (composite instanceof BaseConfMLWidget) {
				BaseConfMLWidget confMLWidget = (BaseConfMLWidget) composite;

				confMLWidget.select();
				createFullSelection(confMLWidget);
				if (reveal) {
					reveal(object);
				}
			}
		}

	}

	@Override
	public Control getControl() {

		return co;
	}

	/**
	 * Notifies content provider {@link IValuesContentProvider}, if widget has
	 * changed its value and model needs to be updated
	 * 
	 * @param newValue
	 * @param element
	 */
	public void fireValueChanged(String newValue, Object element) {
		IContentProvider contentProvider = getContentProvider();
		if (contentProvider instanceof IValuesContentProvider) {
			IValuesContentProvider valuesContentProvider = (IValuesContentProvider) contentProvider;
			String value = valuesContentProvider.getValue(element);

			if (value == null && newValue == null || newValue != null
					&& newValue.equals("") && value == null || value != null
					&& value.equals("") && newValue == null) {

				return;
			}

			if (newValue != null && value != null && newValue.equals(value)) {

				return;
			}
			valuesContentProvider.valueChanged(newValue, element);
			validate(element, newValue);
			handleDefault(element);
			handleDirty(element);
		}
	}

	private void fireValueChangedFromComboBox(String newValue, Object element) {
		IContentProvider contentProvider = getContentProvider();
		if (contentProvider instanceof IValuesContentProvider) {
			IValuesContentProvider valuesContentProvider = (IValuesContentProvider) contentProvider;
			String value = valuesContentProvider.getValue(element);
			handleDirty(element);
			handleDefault(element);
			if (value == null && newValue == null || newValue != null
					&& newValue.equals("") && value == null || value != null
					&& value.equals("") && newValue == null) {

				return;
			}

			valuesContentProvider.valueChanged(newValue, element);
			validate(element, newValue);
		}
	}

	private void handleDirty(Object element) {
		IContentProvider contentProvider = getContentProvider();
		if (contentProvider instanceof IValuesContentProvider) {
			IValuesContentProvider provider = (IValuesContentProvider) contentProvider;
			if (provider.isDirty(element)) {
				setDirty(element, true);
			} else {
				setDirty(element, false);
			}
		}

	}

	private void handleDefault(Object element) {
		ITreeContentProvider contentProvider = (ITreeContentProvider) getContentProvider();
		if (contentProvider instanceof IValuesContentProvider) {
			IValuesContentProvider provider = (IValuesContentProvider) contentProvider;

			Widget widget = doFindItem(element);
			if (widget instanceof BaseConfMLWidget) {
				BaseConfMLWidget confMLWidget = (BaseConfMLWidget) widget;
				confMLWidget.setDefaultMark(provider.isDefault(element));

			}

		}
	}

	private void setDirty(Object element, boolean dirty) {
		if (dirty) {
			createDirtyFlag(element);
		} else {
			if (elementToDirtyMap.containsKey(element)) {
				removeDirtyFlag(element);
			}
		}

	}

	private void removeDirtyFlag(Object element) {
		if (third != null && !third.isDisposed()) {
			IValuesContentProvider contentProvider = (IValuesContentProvider) getContentProvider();

			Object parentElement = contentProvider.getParent(element);
			if (parentElement != null) {
				ISettingsLabelProvider provider = (ISettingsLabelProvider) getLabelProvider();
				Type type = provider.getType(parentElement);
				if (type.equals(Type.ITEM)) {
					elementToPropagatedDirtyList.remove(parentElement);
					Object parent = contentProvider.getParent(parentElement);
					if (parent != null) {
						elementToPropagatedDirtyList.remove(parent);
					}
				}
			}
			Composite composite = elementToWidgetMap.get(element);
			if (composite instanceof BaseConfMLWidget) {
				BaseConfMLWidget w = (BaseConfMLWidget) composite;
				w.setDirty(false);
				Listener[] listeners = third.getListeners(SWT.Paint);
				for (Listener listener : listeners) {
					if (listener instanceof TypedListener
							&& ((TypedListener) listener).getEventListener() instanceof DirtyPaintListener) {
						DirtyPaintListener eventListener = (DirtyPaintListener) ((TypedListener) listener)
								.getEventListener();
						if (eventListener.getTextBox().equals(composite)) {
							third.removeListener(SWT.Paint, listener);

						}
					}
				}
				if (composite!=null&&!composite.isDisposed()&&composite.isVisible()) {
					third.redraw();
				}
			}

		}

	}

	private void createDirtyFlag(Object element) {
		if (third == null || third != null && third.isDisposed()) {
			return;
		}
		IValuesContentProvider contentProvider = (IValuesContentProvider) getContentProvider();

		Object parentElement = contentProvider.getParent(element);
		if (parentElement != null) {
			ISettingsLabelProvider provider = (ISettingsLabelProvider) getLabelProvider();
			Type type = provider.getType(parentElement);
			if (type.equals(Type.ITEM)) {
				Object parentOfParentElement = contentProvider
						.getParent(parentElement);
				if (parentOfParentElement != null) {
					elementToPropagatedDirtyList.add(parentElement);
					elementToPropagatedDirtyList.add(parentOfParentElement);
				}
			}
		}
		Composite composite = elementToWidgetMap.get(element);
		if (composite instanceof BaseConfMLWidget) {
			BaseConfMLWidget w = (BaseConfMLWidget) composite;
			w.setDirty(true);

			third.addPaintListener(new DirtyPaintListener(composite));
			if (composite.isVisible()) {
				third.redraw();
			}

			elementToDirtyMap.put(element, w);

		}

	}

	@SuppressWarnings("unchecked")
	private void fireSelection(BaseConfMLWidget widget) {
		Object data = widget.getData();
		IStructuredSelection selection = (IStructuredSelection) getSelection();
		if (widget.isSelected()) {
			List<Object> list = new ArrayList<Object>();
			list.addAll(selection.toList());
			list.remove(data);
			list.add(0, data);
			selection = new StructuredSelection(list);
		}
		fireSelectionChanged(new SelectionChangedEvent(SettingsViewer.this,
				selection));
	}

	public void dispose() {
		titleWidgetFont.dispose();
		Display.getCurrent().removeFilter(SWT.Traverse, filter);
		elementToPropagatedDirtyList.clear();
		elementToPropagatedDirtyList = null;
		elementToPropagatedErrorMap.clear();
		elementToPropagatedErrorMap = null;
		elementToErrorListenerMap.clear();
		elementToErrorListenerMap = null;
		filter = null;
		elementToDirtyMap.clear();
		elementToDirtyMap = null;
		elementToErrorMap.clear();
		elementToErrorMap = null;
		elementToWidgetMap.clear();
		elementToWidgetMap = null;
		if (rulerControl != null) {
			rulerControl.dispose();
			rulerControl = null;
		}
		if (co != null && !co.isDisposed()) {

			co.removeListener(SWT.Activate, activationListener);
			activationListener = null;
			co.removeListener(SWT.Deactivate, deactivationListener);
			deactivationListener = null;
			co.dispose();
			co = null;
		}
		setInput(null);

	}

	/**
	 * Sets main title
	 * 
	 * @param groupName
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	private void createMainControl() {

		Composite borderGroup = new Composite(co, SWT.NONE);
		borderGroup.setBackground(borderColor);
		GridLayout gl = new GridLayout();
		gl.verticalSpacing = 0;
		gl.horizontalSpacing = 0;
		gl.marginHeight = 1;
		gl.marginWidth = 1;

		borderGroup.setLayout(gl);
		borderGroup.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		Composite group = new Composite(borderGroup, SWT.NONE);

		group.setLayout(new GridLayout());
		group.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		label = new Label(group, SWT.NONE);
		if (groupName != null) {
			label.setText(groupName);
		}

		label.setFont(titleWidgetFont);
		label.setLayoutData(new GridData(GridData.FILL_BOTH));

		Composite borderTop = new Composite(co, SWT.NONE);
		borderTop.setBackground(borderColor);
		gl = new GridLayout();
		gl.verticalSpacing = 0;
		gl.horizontalSpacing = 0;
		gl.marginHeight = 0;
		gl.marginWidth = 1;
		gl.marginBottom = 1;
		borderTop.setLayout(gl);
		borderTop.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		top = new Composite(borderTop, SWT.NONE);

		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		data.heightHint = 14;
		top.setLayoutData(data);
		gl = new GridLayout(3, false);
		gl.verticalSpacing = 0;
		gl.horizontalSpacing = 0;
		gl.marginHeight = 0;
		gl.marginWidth = 0;
		top.setLayout(gl);
		if (topButtonListener != null) {
			top.addMouseListener(topButtonListener);
		}

		Composite errorComposite = createCompositeForButton();
		errorSorterButton = new SorterButton(errorComposite, SWT.NONE,
				PluginImages.ERROR_SORTER, 0, 1);
		GridLayout layout6 = new GridLayout();
		layout6.marginHeight = 0;
		layout6.marginWidth = -2;
		errorSorterButton.setLayout(layout6);
		if (errorButtonListener != null) {
			errorSorterButton.addMouseListener(errorButtonListener);
		}
		Composite noteComposite = createCompositeForButton();
		noteSorterButton = new SorterButton(noteComposite, SWT.NONE,
				PluginImages.NOTE, 0, 2);
		if (noteButtonListener != null) {
			noteSorterButton.addMouseListener(noteButtonListener);
		}
		Composite dirtyComposite = createCompositeForButton();
		dirtySorterButton = new SorterButton(dirtyComposite, SWT.NONE,
				PluginImages.DIRTY, 0, 1);
		if (dirtyButtonListener != null) {
			dirtySorterButton.addMouseListener(dirtyButtonListener);
		}
		Composite composite = new Composite(co, SWT.NONE);
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));
		GridLayout parentLayout = new GridLayout();
		parentLayout.horizontalSpacing = 0;
		parentLayout.verticalSpacing = 0;
		parentLayout.numColumns = 2;
		parentLayout.marginHeight = 0;
		parentLayout.marginWidth = 0;

		composite.setLayout(parentLayout);

		rulerControl = new RulerComposite(composite, SWT.NONE);// toolkit.

		Composite body = new Composite(rulerControl.getRuler(), SWT.NONE);

		GridData gridData2 = new GridData(GridData.FILL_BOTH);
		gridData2.grabExcessHorizontalSpace = true;
		gridData2.grabExcessVerticalSpace = true;
		body.setLayoutData(gridData2);

		GridData gridData4 = new GridData(GridData.FILL_BOTH);
		gridData4.grabExcessHorizontalSpace = true;
		gridData4.grabExcessVerticalSpace = true;
		rulerControl.setLayoutData(gridData4);
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		layout.horizontalSpacing = 1;
		layout.verticalSpacing = 0;
		layout.marginBottom = 1;
		layout.marginHeight = 0;
		layout.marginWidth = 1;
		body.setLayout(layout);
		body.setBackground(borderColor);
		first = new Canvas(body, SWT.NONE);

		GridData gridData = new GridData(GridData.FILL_VERTICAL);
		gridData.widthHint = 13;

		first.setLayoutData(gridData);

		second = new Canvas(body, SWT.NONE);

		gridData = new GridData(GridData.FILL_VERTICAL);
		gridData.widthHint = 13;

		second.setLayoutData(gridData);
		third = new Canvas(body, SWT.NONE);
		gridData = new GridData(GridData.FILL_VERTICAL);
		gridData.widthHint = 13;

		third.setLayoutData(gridData);

		composite2 = new Composite(rulerControl.getScrolledComposite(),
				SWT.NONE);
		rulerControl.setContent(composite2);
		layout = new GridLayout();
		layout.horizontalSpacing = 0;
		layout.verticalSpacing = 0;
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		composite2.setLayout(layout);

		gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		composite2.setBackground(Display.getCurrent().getSystemColor(
				SWT.COLOR_WHITE));
		composite2.setLayoutData(gridData);
		Composite borderFourth = new Composite(composite, SWT.NONE);
		layout = new GridLayout();
		layout.horizontalSpacing = 1;
		layout.verticalSpacing = 0;
		layout.marginHeight = 0;
		layout.marginBottom = 1;
		layout.marginWidth = 1;
		borderFourth.setLayout(layout);
		borderFourth.setBackground(borderColor);
		gridData = new GridData(GridData.FILL_VERTICAL);
		gridData.horizontalAlignment = SWT.RIGHT;
		borderFourth.setLayoutData(gridData);

		fourth = new Composite(borderFourth, SWT.NONE);

		gridData = new GridData(GridData.FILL_VERTICAL);
		gridData.widthHint = 12;
		gridData.horizontalAlignment = SWT.RIGHT;
		fourth.setLayoutData(gridData);

	}

	private Composite createCompositeForButton() {
		Composite errorBackground = new Composite(top, SWT.NONE);
		errorBackground.setBackground(borderColor);
		GridData d = new GridData();
		d.widthHint = 14;
		GridLayout gridLayout = new GridLayout();
		gridLayout.marginHeight = 0;
		gridLayout.marginWidth = 0;
		errorBackground.setLayout(gridLayout);
		errorBackground.setLayoutData(d);
		Composite errorComposite = new Composite(errorBackground, SWT.NONE);
		GridData gridData3 = new GridData();
		gridData3.widthHint = 13;
		gridData3.heightHint = 15;
		errorComposite.setLayoutData(gridData3);
		GridLayout gridLayout2 = new GridLayout();
		gridLayout2.marginWidth = 0;
		gridLayout2.marginHeight = 0;
		errorComposite.setLayout(gridLayout2);
		return errorComposite;
	}

	private void internalDeselectAllWidgets() {
		Iterator<Composite> values = elementToWidgetMap.values().iterator();
		while (values.hasNext()) {
			Composite next = values.next();
			if (next instanceof BaseConfMLWidget) {
				((BaseConfMLWidget) next).deselect();
			}
		}
		removeSelectionPaintListeners(first);
		removeSelectionPaintListeners(second);
		removeSelectionPaintListeners(third);

	}

	private void removeSelectionPaintListeners(Canvas canvas) {
		if (canvas != null && !canvas.isDisposed()) {
			Listener[] listeners = canvas.getListeners(SWT.Paint);
			for (Listener listener : listeners) {
				if (listener instanceof TypedListener
						&& ((TypedListener) listener).getEventListener() instanceof SelectionPaintListener) {
					canvas.removeListener(SWT.Paint, listener);
				}
			}
			canvas.redraw();
		}
	}

	/**
	 * Deselect all widgets and fire selection changed event
	 */
	public void deselectAllWidgets() {
		internalDeselectAllWidgets();
		fireSelectionChanged(new SelectionChangedEvent(SettingsViewer.this,
				StructuredSelection.EMPTY));
	}

	private ValidationResult validate(Object element, String value) {
		IContentProvider contentProvider = getContentProvider();
		if (contentProvider instanceof IValuesContentProvider) {
			IValuesContentProvider provider = (IValuesContentProvider) contentProvider;
			ValidationResult result = provider.validate(value, element);

			if (result.getResult().contains(EResult.VALID)) {
				if (elementToErrorMap.containsKey(element)) {
					removeError(element);
				}

			} else {
				createError(element, result.getMessage());
			}
			return result;
		}
		return new ValidationResult(EResult.VALID);

	}

	/**
	 * Removes error marker for element
	 * 
	 * @param element
	 */
	public void removeError(Object element) {
		if (first == null || first != null && first.isDisposed()) {
			return;
		}
		IValuesContentProvider contentProvider = (IValuesContentProvider) getContentProvider();

		Object parentElement = contentProvider.getParent(element);
		if (parentElement != null) {
			ISettingsLabelProvider provider = (ISettingsLabelProvider) getLabelProvider();
			Type type = provider.getType(parentElement);
			if (type.equals(Type.ITEM)) {
				elementToPropagatedErrorMap.remove(parentElement);
				Object parent = contentProvider.getParent(parentElement);
				if (parent != null) {
					elementToPropagatedErrorMap.remove(parent);
				}
			}
		}
		List<Composite> list = elementToErrorMap.get(element);
		if (list != null) {
			for (Composite composite : list) {
				composite.dispose();

			}
			Widget item = doFindItem(element);
			if (item instanceof BaseConfMLWidget) {
				BaseConfMLWidget w = (BaseConfMLWidget) item;

				if (!first.isDisposed()) {
					Listener[] listeners = first.getListeners(SWT.Paint);
					for (Listener listener : listeners) {
						SWTEventListener eventListener = ((TypedListener) listener)
								.getEventListener();
						if (eventListener instanceof ErrorPaintListener) {
							ErrorPaintListener errorPaintListener = (ErrorPaintListener) eventListener;
							if (errorPaintListener.getTextBox().equals(w)) {
								first.removeListener(SWT.Paint, listener);
							}
						}
					}
					first.redraw();
				}
			}
			elementToErrorMap.remove(element);
			ErrorToolTipMouseTrackListener listener = elementToErrorListenerMap
					.get(element);
			if (listener != null) {
				listener.getErrorToolTipContainer().dispose();
				first.removeMouseTrackListener(listener);
			}
			elementToErrorListenerMap.remove(element);
			list.clear();
		}
	}

	private void computeErrorLineLocation(final Composite comm,
			final Composite composite) {
		if (comm.isDisposed() || composite.isDisposed()) {
			return;
		}
		Point location = SWTUtil.getControlLocation(rulerControl
				.getScrolledComposite(), composite);

		// int location = getRulerCoordinates(composite, rulerControl
		// .getScrolledComposite());
		int absoluteLocation = location.y + composite.getSize().y / 2;
		float controlHeight = rulerControl.getScrolledComposite()
				.getMinHeight();
		float fourthHeight = fourth.getSize().y;
		float ratio = fourthHeight / controlHeight;
		if (ratio > 1)
			ratio = 1;
		Float commLocation = ratio * absoluteLocation;
		comm.setLocation(0, commLocation.intValue());
	}

	public void removeDirtyMarkers() {
		Set<Object> keySet = elementToDirtyMap.keySet();
		for (Object object : keySet) {
			removeDirtyFlag(object);
		}
	}

	private class SorterButton extends Composite {

		private Label l;
		private Image img;

		public SorterButton(Composite parent, int style, Image image) {
			super(parent, style);
			this.img = image;
			setLayout(new GridLayout());
			GridData gd = new GridData();
			gd.widthHint = 13;
			gd.heightHint = 12;
			setLayoutData(gd);
			addPaintListener(new PaintListener() {

				public void paintControl(PaintEvent e) {
					e.gc.drawImage(img, -1, 0);
				}
			});

		}

		public SorterButton(Composite parent, int style, Image image,
				final int x, final int y) {
			super(parent, style);
			this.img = image;
			setLayout(new GridLayout());
			GridData gd = new GridData();
			gd.widthHint = 13;
			gd.heightHint = 12;
			setLayoutData(gd);
			addPaintListener(new PaintListener() {

				public void paintControl(PaintEvent e) {
					e.gc.drawImage(img, x, y);
				}
			});

		}

		public SorterButton(Composite parent, int style, String text) {
			super(parent, style);
			GridLayout layout = new GridLayout();
			layout.marginHeight = 3;
			layout.marginWidth = 4;
			setLayout(layout);
			GridData gd = new GridData();
			gd.widthHint = 13;
			gd.heightHint = 12;
			setLayoutData(gd);
			l = new Label(this, SWT.NONE);
			l.setText(text);

		}

		@Override
		public void addMouseListener(MouseListener listener) {
			if (l != null) {
				l.addMouseListener(listener);
			}
			super.addMouseListener(listener);
		}

		@Override
		public void dispose() {
			img.dispose();
			img = null;
			super.dispose();
		}

	}

	/**
	 * Adds MouseListener to handle error sorting
	 * 
	 * @param listener
	 */
	public void addErrorButtonListener(MouseListener listener) {
		this.errorButtonListener = listener;
		if (errorSorterButton != null) {
			errorSorterButton.addMouseListener(listener);
		}
	}

	/**
	 * Removes MouseListener which handles error sorting
	 * 
	 * @param listener
	 */
	public void removeErrorButtonListener(MouseListener listener) {
		if (errorSorterButton != null && !errorSorterButton.isDisposed()) {
			errorSorterButton.removeMouseListener(listener);
		}
		this.errorButtonListener = null;
	}

	/**
	 * Adds MouseListener to handle dirty sorting
	 * 
	 * @param listener
	 */
	public void addDirtyButtonListener(MouseListener listener) {
		this.dirtyButtonListener = listener;
		if (dirtySorterButton != null) {
			dirtySorterButton.addMouseListener(listener);
		}
	}

	/**
	 * Removes MouseListener which handles dirty sorting
	 * 
	 * @param listener
	 */
	public void removeDirtyButtonListener(MouseListener listener) {
		if (dirtySorterButton != null && !dirtySorterButton.isDisposed()) {
			dirtySorterButton.removeMouseListener(listener);
		}
		this.dirtyButtonListener = null;
	}

	/**
	 * Adds MouseListener to handle note sorting
	 * 
	 * @param listener
	 */
	public void addNotesButtonListener(MouseListener listener) {
		this.noteButtonListener = listener;
		if (noteSorterButton != null && !noteSorterButton.isDisposed()) {
			noteSorterButton.addMouseListener(listener);
		}
	}

	/**
	 * Removes MouseListener which handles note sorting
	 * 
	 * @param listener
	 */
	public void removeNotesButtonListener(MouseListener listener) {
		if (noteSorterButton != null && !noteSorterButton.isDisposed()) {
			noteSorterButton.removeMouseListener(listener);
		}
		this.noteButtonListener = null;
	}

	/**
	 * Adds MouseListener to handle default sorting
	 * 
	 * @param listener
	 */
	public void addTopButtonListener(MouseListener listener) {
		this.topButtonListener = listener;
		if (top != null) {
			noteSorterButton.addMouseListener(listener);
		}
	}

	/**
	 * Removes MouseListener which handles default sorting
	 * 
	 * @param listener
	 */
	public void removeTopButtonListener(MouseListener listener) {
		if (top != null && !noteSorterButton.isDisposed()) {
			noteSorterButton.removeMouseListener(listener);
		}
		this.topButtonListener = null;
	}

	private void createMultiSelection(BaseConfMLWidget textBox) {
		if (textBox.isSelected()) {
			textBox.deselect();
			removeFullSelection(textBox);
			fireSelection(textBox);
		} else {
			textBox.select();
			createFullSelection(textBox);
			fireSelection(textBox);

		}
	}

	/**
	 * Deselect
	 * 
	 * @param textBox
	 */
	private void removeFullSelection(BaseConfMLWidget textBox) {
		removeFullSelection(textBox, first);
		removeFullSelection(textBox, second);
		removeFullSelection(textBox, third);
		Composite parent = textBox.getParent();
		Object data = textBox.getData();
		IValuesContentProvider valuesContentProvider = (IValuesContentProvider) getContentProvider();

		if (parent instanceof SequenceWidgetItem
				&& valuesContentProvider.getChildren(valuesContentProvider
						.getParent(data))[0].equals(data)) {
			BaseConfMLWidget baseConfMLWidget = (BaseConfMLWidget) parent;
			removeFullSelection(baseConfMLWidget, first);
			removeFullSelection(baseConfMLWidget, second);
			removeFullSelection(baseConfMLWidget, third);
		}

	}

	private void removeFullSelection(BaseConfMLWidget textBox, Canvas canvas) {
		Listener[] listeners = canvas.getListeners(SWT.Paint);
		for (Listener listener : listeners) {
			if (listener instanceof TypedListener) {
				TypedListener type = (TypedListener) listener;
				SWTEventListener eventListener = type.getEventListener();
				if (eventListener instanceof SelectionPaintListener) {
					Composite textBox2 = ((SelectionPaintListener) eventListener)
							.getTextBox();
					if (textBox.equals(textBox2)) {
						canvas.removeListener(SWT.Paint, listener);
						break;
					}
				}
			}
		}
		canvas.redraw();
	}

	private void createFullSelection(final BaseConfMLWidget textBox) {
		Point location = SWTUtil.getControlLocation(rulerControl
				.getScrolledComposite(), textBox);

		// int location = getRulerCoordinates(composite, rulerControl
		// .getScrolledComposite());
		int absoluteLocation = location.y;
		int textBoxHeight = textBox.getSize().y;
		if (textBox instanceof SequenceWidget) {
			textBoxHeight = 32;
		}
		if (textBox instanceof SequenceWidgetItem) {
			textBoxHeight = 32;
		}
		first.addPaintListener(new SelectionPaintListener(textBox, first));

		first.redraw(0, absoluteLocation, 25, textBoxHeight, false);
		second.addPaintListener(new SelectionPaintListener(textBox, second));

		second.redraw(0, absoluteLocation, 25, textBoxHeight, false);
		third.addPaintListener(new SelectionPaintListener(textBox, third));

		third.redraw(0, absoluteLocation, 25, textBoxHeight, false);

	}

	private void handleSelection(final BaseConfMLWidget textBox, Event event) {
		if (event.stateMask == SWT.SHIFT) {
			handleShiftMouseSelection(textBox);
			return;
		}
		if (event.stateMask == SWT.CTRL) {

			createMultiSelection(textBox);

		} else if (event.button == 3) {

		} else {

			internalDeselectAllWidgets();
			textBox.select();
			createFullSelection(textBox);
			fireSelection(textBox);
		}

		// display context menu
		createContextMenu(event);
	}

	private void handleShiftMouseSelection(BaseConfMLWidget textBox) {
		if (!textBox.isSelected()) {
			IStructuredSelection selection = (IStructuredSelection) getSelection();
			List<Object> newSelection = new ArrayList<Object>();
			Object firstElement = selection.getFirstElement();
			Object data = textBox.getData();

			List<Object> flatStructure = getFlatStructure();
			for (Object object : flatStructure) {
				if (selection.toList().contains(object)) {
					firstElement = object;
					break;
				}
			}
			int indexOfData = flatStructure.indexOf(data);
			int indexOfFirst = flatStructure.indexOf(firstElement);
			if (indexOfData > indexOfFirst) {
				for (int i = indexOfFirst; i < indexOfData + 1; i++) {
					newSelection.add(flatStructure.get(i));
				}
			} else {
				for (int i = indexOfData; i < indexOfFirst + 1; i++) {
					newSelection.add(flatStructure.get(i));
				}
			}

			setSelection(new StructuredSelection(newSelection));
		}

	}

	/**
	 * 
	 * @return all model elements
	 */
	public List<Object> getFlatStructure() {
		List<Object> list = new ArrayList<Object>();
		IContentProvider provider = getContentProvider();
		if (provider instanceof ITreeContentProvider) {
			ITreeContentProvider treeProvider = (ITreeContentProvider) provider;
			Object[] elements = treeProvider.getElements(getInput());
			getAllElements(elements, list, treeProvider);
		}
		return list;

	}

	public List<Object> getTopStructure() {
		List<Object> list = new ArrayList<Object>();
		IContentProvider provider = getContentProvider();
		if (provider instanceof ITreeContentProvider) {
			ITreeContentProvider treeProvider = (ITreeContentProvider) provider;
			Object[] elements = treeProvider.getElements(getInput());
			getAllTopElements(elements, list, treeProvider);
		}
		return list;

	}

	private void getAllTopElements(Object[] elements, List<Object> list,
			ITreeContentProvider treeProvider) {
		ISettingsLabelProvider labelProvider2 = (ISettingsLabelProvider) getLabelProvider();
		if (elements != null) {
			for (Object object : elements) {
				list.add(object);
				if (!labelProvider2.getType(object).equals(Type.SEQUENCE)
				/* && !labelProvider2.getType(object).equals(Type.FILE) */) {
					getAllTopElements(treeProvider.getChildren(object), list,

					treeProvider);
				}
			}
		}

	}

	private void getAllElements(Object[] elements, List<Object> list,
			ITreeContentProvider treeProvider) {

		if (elements != null) {
			for (Object object : elements) {
				list.add(object);

				getAllElements(treeProvider.getChildren(object), list,
						treeProvider);
			}
		}
	}

	/**
	 * Selects all widgets, children of {@link SequenceWidget} and
	 * {@link SequenceWidgetItem} are selected only if they are expanded
	 * 
	 * @return number of selected items
	 */
	public int selectAll() {

		List<Object> flatStructure = getFlatStructure();
		List<Object> selection = new ArrayList<Object>();
		for (Object object : flatStructure) {
			Composite composite = elementToWidgetMap.get(object);
			if (composite instanceof BaseConfMLWidget
					&& !(composite instanceof TitleWidget)
					&& !(composite.getParent() instanceof SequenceWidgetItem)
					&& !(composite.getParent() instanceof SequenceWidget && ((SequenceWidget) composite
							.getParent()).isCollapsed())) {

				((BaseConfMLWidget) composite).select();
				createFullSelection((BaseConfMLWidget) composite);
				selection.add(object);
			}
		}

		fireSelectionChanged(new SelectionChangedEvent(SettingsViewer.this,
				new StructuredSelection(selection)));

		return selection.size();
	}

	private void computeErrorsLocation(
			final IValuesContentProvider valuesContentProvider,
			final SequenceWidget sWidget) {
		Set<SequenceWidgetItem> placedSequences = sWidget.getPlacedSequences();
		for (SequenceWidgetItem sequenceWidgetItem : placedSequences) {
			Object data = sequenceWidgetItem.getData();
			Object[] children2 = valuesContentProvider.getChildren(data);
			for (Object object : children2) {
				computeErrorsLocationForChildren(sWidget, sequenceWidgetItem,
						object);

				// Object[] children =
				// valuesContentProvider.getChildren(object);
				// for (Object object2 : children) {
				// computeErrorsLocationForChildren(sequenceWidgetItem,
				// object2);
				// }

			}
		}
	}

	private void computeErrorsLocationForChildren(SequenceWidget sWidget,
			final SequenceWidgetItem subWidget, Object object) {
		List<Composite> list = elementToErrorMap.get(object);
		Composite composite = elementToWidgetMap.get(object);

		if (list != null) {

			if (composite != null) {
				if (sWidget.isCollapsed()) {
					computeErrorLineLocation(list.get(0), sWidget);
				} else if (subWidget.isCollapsed()) {
					computeErrorLineLocation(list.get(0), subWidget);
				} else {

					computeErrorLineLocation(list.get(0), composite);
				}
			}
		}
	}

	public List<Object> getCollapsedElements() {
		List<Object> list = new ArrayList<Object>();
		Set<Object> keySet = elementToWidgetMap.keySet();
		for (Object object : keySet) {
			Composite composite = elementToWidgetMap.get(object);
			if (composite instanceof SequenceWidget) {
				SequenceWidget sequenceWidget = (SequenceWidget) composite;
				if (!sequenceWidget.isCollapsed()) {
					list.add(object);
				}
				Set<SequenceWidgetItem> children = sequenceWidget
						.getPlacedSequences();
				for (SequenceWidgetItem sequenceWidgetChild : children) {

					if (!sequenceWidgetChild.isCollapsed()) {
						Object data = sequenceWidgetChild.getData();
						list.add(data);
					}
				}
			}
		}
		return list;
	}

	private void computeAllErrorsLocation(
			final IValuesContentProvider valuesContentProvider) {
		Collection<Composite> collection = elementToWidgetMap.values();
		for (Composite composite : collection) {
			if (composite instanceof SequenceWidget) {
				computeErrorsLocation(valuesContentProvider,
						(SequenceWidget) composite);
			} else if (!(composite.getParent() instanceof SequenceWidgetItem)) {

				List<Composite> list = elementToErrorMap.get(composite
						.getData());
				if (list != null) {
					computeErrorLineLocation(list.get(0), composite);
				}
			}
		}
	}

	/**
	 * Validate all elements ,create errors for invalid and remove errors for
	 * valid elements
	 */
	public void createErrorsForWholeModel() {
		Set<Object> keySet = elementToWidgetMap.keySet();
		for (Object object : keySet) {
			validate(object, ((IValuesContentProvider) getContentProvider())
					.getValue(object));
		}
	}

	/**
	 * Collapse elements from the list
	 * 
	 * @param newCollapsedElementsList
	 */
	public void setCollapsedElements(List<Object> newCollapsedElementsList) {
		Composite c = null;
		Set<Composite> compositeToLayout = new HashSet<Composite>();
		for (Object object : newCollapsedElementsList) {
			Composite composite = elementToWidgetMap.get(object);
			if (composite instanceof SequenceWidget) {

				((SequenceWidget) composite).setCollapsed(false);

				compositeToLayout.add(composite);
				c = composite;
			} else if (composite != null) {

				Composite parent = composite.getParent();
				if (parent instanceof SequenceWidgetItem) {

					((SequenceWidgetItem) parent).setCollapsed(false);

					compositeToLayout.add(parent);
					c = parent;
				}

			}
		}

		while (c != null) {
			c = c.getParent();
			if (c instanceof ScrolledComposite) {

				compositeToLayout.add(c);
				break;
			}
		}
		for (Composite composite : compositeToLayout) {
			composite.layout(true, true);
		}

	}

	private int absoluteLocation(Composite textBox) {
		Point location = SWTUtil.getControlLocation(rulerControl
				.getScrolledComposite(), textBox);

		return location.y;
	}

	private void redrawWidgetsToChangeSelectionColor() {
		first.redraw();
		second.redraw();
		third.redraw();

		selectWidgetsAgainToChangeSelectionColor();

	}

	private void selectWidgetsAgainToChangeSelectionColor() {
		Collection<Composite> values = elementToWidgetMap.values();
		for (Composite composite : values) {
			if (composite instanceof BaseConfMLWidget) {
				BaseConfMLWidget baseConfMLWidget = (BaseConfMLWidget) composite;
				if (baseConfMLWidget.isSelected()) {
					baseConfMLWidget.select();
				}
			}
		}
	}

	/**
	 * Paints selection on canvas, paints also error dirty and notes markers if
	 * they are needed
	 * 
	 * 
	 * 
	 */
	class SelectionPaintListener implements PaintListener {

		private Composite textBox;
		private Canvas canvas;

		public SelectionPaintListener(Composite textBox, Canvas canvas) {

			this.textBox = textBox;

			this.canvas = canvas;
		}

		public void paintControl(PaintEvent e) {
			if (textBox == null || textBox != null && textBox.isDisposed()) {
				return;
			}
			if (textBox.getParent() instanceof SequenceWidgetItem
					|| textBox.getParent() instanceof SequenceWidget) {
				if (!(textBox.getParent().getChildren()[1].equals(textBox) && textBox
						.getParent().getParent().getSize().y > 33)) {

					if (!(textBox instanceof SequenceWidget)) {
						if (textBox.getParent().getSize().y < 33
								|| textBox.getParent().getParent().getSize().y < 33) {
							return;
						}
					}
				}
			}
			int textBoxHeight = textBox.getSize().y;
			if (textBox instanceof SequenceWidget) {
				textBoxHeight = 32;
			}
			if (textBox instanceof SequenceWidgetItem) {
				textBoxHeight = 32;
			}

			e.gc.setBackground(PluginImages.BACKGROUND_COLOR);

			canvas.drawBackground(e.gc, 0, absoluteLocation(textBox), 25,
					textBoxHeight);
			Object data = textBox.getData();
			IValuesContentProvider valuesContentProvider = (IValuesContentProvider) getContentProvider();
			if (canvas.equals(third)) {

				paintDirtyInSelection(e, data, valuesContentProvider);
			}
			if (canvas.equals(first)) {
				paintErrorsInSelection(e, data, valuesContentProvider);
			}
			if (canvas.equals(second)) {

				if (valuesContentProvider.hasNote(data)) {

					e.gc.drawImage(PluginImages.MRK_NOTE, 0,
							absoluteLocation(textBox) + 8);

				}
			}

		}

		private void paintDirtyInSelection(PaintEvent e, Object data,
				IValuesContentProvider valuesContentProvider) {
			if (elementToPropagatedDirtyList.contains(data)
					&& textBox.getSize().y < 34) {
				e.gc.drawImage(PluginImages.MRK_DIRTY, 4,
						absoluteLocation(textBox) + 10);
			}
			Object parent = valuesContentProvider.getParent(data);
			if (elementToPropagatedDirtyList.contains(parent)
					&& textBox.getParent().getSize().y < 34
					&& valuesContentProvider.getChildren(parent)[0]
							.equals(data)) {
				e.gc.drawImage(PluginImages.MRK_DIRTY, 4,
						absoluteLocation(textBox) + 10);
			}

			if (valuesContentProvider.isDirty(data)) {
				e.gc.drawImage(PluginImages.MRK_DIRTY, 4,
						absoluteLocation(textBox) + 10);
			}

		}

		private void paintErrorsInSelection(PaintEvent e, Object data,
				IValuesContentProvider valuesContentProvider) {
			if (elementToPropagatedErrorMap.containsKey(data)
					&& textBox.getSize().y < 34) {
				e.gc.drawImage(PluginImages.MRK_ERROR, 4,
						absoluteLocation(textBox) + 11);
			}

			Object parent = valuesContentProvider.getParent(data);
			Object parentOfParent = valuesContentProvider.getParent(parent);
			Composite parent2 = textBox.getParent();
			if (elementToPropagatedErrorMap.containsKey(parent)
					&& parent2.getSize().y < 34
					&& valuesContentProvider.getChildren(parent)[0]
							.equals(data)) {
				e.gc.drawImage(PluginImages.MRK_ERROR, 4,
						absoluteLocation(textBox) + 11);
			}
			String value = valuesContentProvider.getValue(data);

			ValidationResult validate = valuesContentProvider.validate(value,
					data);

			if (!validate.getResult().contains(EResult.VALID)) {

				e.gc.drawImage(PluginImages.MRK_ERROR, 4,
						absoluteLocation(textBox) + 11);

			}
			if (parent2 instanceof SequenceWidgetItem) {
				SequenceWidgetItem item = (SequenceWidgetItem) parent2;
				if ((textBox instanceof FileTextBox)
						&& item.isCollapsed()
						&& item.getChildren()[1].equals(textBox)
						&& elementToPropagatedErrorMap
								.containsKey(parentOfParent)) {
					e.gc.drawImage(PluginImages.MRK_ERROR, 4,
							absoluteLocation(textBox) + 11);
				}
			}
		}

		public Composite getTextBox() {
			return textBox;
		}

	}

	/**
	 * Paints error markers
	 * 
	 * 
	 * 
	 */
	class ErrorPaintListener implements PaintListener {

		private Composite textBox;

		public ErrorPaintListener(Composite textBox) {

			this.textBox = textBox;

		}

		public void paintControl(PaintEvent e) {
			if (textBox != null && !textBox.isDisposed()) {

				if (textBox.getParent().getParent().getSize().y < 34) {
					int y = absoluteLocation(textBox.getParent().getParent()) + 11;
					e.gc.drawImage(PluginImages.MRK_ERROR, 4, y);
				} else if (textBox.getParent().getSize().y < 34) {
					int y = absoluteLocation(textBox.getParent()) + 11;
					e.gc.drawImage(PluginImages.MRK_ERROR, 4, y);
				} else {
					int y = absoluteLocation(textBox) + 11;
					e.gc.drawImage(PluginImages.MRK_ERROR, 4, y);
				}
			}
		}

		public Composite getTextBox() {
			return textBox;
		}

	}

	/**
	 * Paints note markers
	 * 
	 * 
	 * 
	 */
	class NotePaintListener implements PaintListener {

		private Composite textBox;

		public NotePaintListener(Composite textBox) {

			this.textBox = textBox;

		}

		public void paintControl(PaintEvent e) {
			if (textBox == null || textBox != null && textBox.isDisposed()) {
				return;
			}
			e.gc.drawImage(PluginImages.MRK_NOTE, 0,
					absoluteLocation(textBox) + 8);
		}

		public Composite getTextBox() {
			return textBox;
		}

	}

	/**
	 * Paints dirty markers
	 * 
	 * 
	 * 
	 */
	class DirtyPaintListener implements PaintListener {

		private Composite textBox;

		public DirtyPaintListener(Composite textBox) {

			this.textBox = textBox;

		}

		public void paintControl(PaintEvent e) {
			if (textBox == null || textBox != null && textBox.isDisposed()) {
				return;
			}
			if (textBox.getParent().getParent().getSize().y < 34) {
				int y = absoluteLocation(textBox.getParent().getParent()) + 10;
				e.gc.drawImage(PluginImages.MRK_DIRTY, 4, y);
			} else if (textBox.getParent().getSize().y < 34) {
				int y = absoluteLocation(textBox.getParent()) + 10;
				e.gc.drawImage(PluginImages.MRK_DIRTY, 4, y);
			} else {
				int y = absoluteLocation(textBox) + 10;
				e.gc.drawImage(PluginImages.MRK_DIRTY, 4, y);
			}

		}

		public Composite getTextBox() {
			return textBox;
		}

	}

}
