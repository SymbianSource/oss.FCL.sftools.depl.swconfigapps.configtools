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

import java.beans.PropertyChangeListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetEffect;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.ui.forms.widgets.ScrolledForm;

import com.nokia.tools.variant.viewer.Activator;
import com.nokia.tools.variant.viewer.actions.EditorAction;
import com.nokia.tools.variant.viewer.composite.RulerComposite;
import com.nokia.tools.variant.viewer.extensionregistry.ContributorsRegistry;
import com.nokia.tools.variant.viewer.images.PluginImages;
import com.nokia.tools.variant.viewer.listeners.EditorDropEffect;

/**
 * Base widget class for Carbide.V editor. All edit widget classes in editor has to
 * extend this class. It provides interface for correct handling of selection,
 * errors, default states and so on.
 */
public abstract class BaseConfMLWidget extends Composite implements BasicWidget {

	public static final int CONTROL_WIDTH_HINT = 240;
	public static final int TEXT_WIDTH_HINT = 243;
	private static final int DECORATION_SIZE = 16;

	/**
	 * Flag for displaying error dialog for leaving the fields focus
	 */
	private boolean wasErrorDialogShown;

	protected Composite dirtyComposite;
	protected Composite noteComposite;
	protected Composite errorComposite;
	protected Composite group;
	protected String oldErrorMessage;
	protected Label label;
	protected boolean selected;
	protected boolean hasFocus = false;
	protected boolean disposed = false;
	protected boolean dirty = false;
	private GraphicsWidgetModel graphicsModel;
	private PaintListener paint;
	protected Image image;
	protected List<Composite> additionalComposites;

	protected WidgetOptions options;

	protected Composite toolBar;

	private RulerComposite ruler;

	protected Label dirtyLabel;

	protected Canvas decorator;

	private boolean hasError;

	private boolean hasNote;

	private boolean propagateDirty;
	private boolean propagateNote;
	private boolean propagateError;

	private DragSource labelDragSource;

	private DragSource groupDragSource;

	private DropTarget labelDropTarget;

	private DropTarget groupDropTarget;

	private Listener listener;

	private DropTargetEffect labelDropEffect;

	private DropTargetEffect rulerDropEffect;

	private DropTargetListener dropTargetListener;

	private OptionButton optionButton;
	private boolean reveal;

	public BaseConfMLWidget(Composite parent, int style) {
		super(parent, style);
		setBackground(parent.getBackground());
		additionalComposites = new ArrayList<Composite>();
	}

	public BaseConfMLWidget(Composite parent, int style, String string) {
		this(parent, style);
		initializeLayout();
		buildWidget(this, string);
		layout(true, true);
	}

	public BaseConfMLWidget(Composite parent, int style, String string,
			WidgetOptions options) {
		this(parent, style);
		this.options = options;
		initializeLayout();
		buildWidget(this, string);
		layout(true, true);
	}

	public BaseConfMLWidget(Composite parent, int style, String string,
			WidgetOptions options, Image image) {
		this(parent, style);
		this.image = image;
		this.options = options;
		initializeLayout();
		buildWidget(this, string);
		layout(true, true);
	}

	public BaseConfMLWidget(Composite parent, int style, String string,
			Image image) {
		this(parent, style);
		this.image = image;
		initializeLayout();
		buildWidget(this, string);
		layout(true, true);
	}

	private void initializeLayout() {
		GridLayout gridLayout = new GridLayout();

		setLayout(gridLayout);
		GridData gd = new GridData(SWT.CENTER | GridData.FILL_HORIZONTAL);
		gd.verticalAlignment = SWT.CENTER;
		setLayoutData(gd);
	}

	public abstract String getValue();

	public boolean isDirty() {
		return dirty;

	}

	public void buildWidget(Composite composite, String widgetLabel) {
		buildControl(composite, widgetLabel);
		initializeColors(composite);
	}

	protected void buildControl(Composite composite, String widgetLabel) {
		buildControlContainer(composite);
		setLayout();
		buildImage();
		if (widgetLabel == null) {
			widgetLabel = "";
		}
		buildLabel(widgetLabel);

		buildMainControl();
		buildToolBar();
		buildOptions();

	}

	protected boolean buildOptions() {
		if (options != null && options.size() > 0 && optionButton == null) {
			optionButton = new OptionButton(this, this, options);
			return true;
		}
		return false;
	}

	protected void buildToolBar() {

		List<Class<EditorAction>> contributors = ContributorsRegistry
				.getInstance().getContributors(
						this.getClass().getCanonicalName());

		if (contributors != null) {
			toolBar = new ToolBar(group, SWT.NONE | SWT.FLAT);
			toolBar.setBackground(group.getBackground());
			toolBar.addDisposeListener(new DisposeListener() {

				public void widgetDisposed(DisposeEvent e) {
					if (toolBar instanceof ToolBar) {
						ToolItem[] items = ((ToolBar) toolBar).getItems();
						for (ToolItem toolItem : items) {
							Object data = toolItem.getData();
							EditorAction action = (EditorAction) ((ActionContributionItem) data)
									.getAction();
							action.dispose();
						}
					}
					toolBar.removeDisposeListener(this);
				}
			});
			RowLayout gl = new RowLayout();
			toolBar.setLayout(gl);

			ToolBarManager tbm = new ToolBarManager((ToolBar) toolBar);
			for (Class<EditorAction> editorAction : contributors) {

				// EditorAction action =

				EditorAction action = null;
				try {
					action = editorAction.newInstance();
					action.setWidget(this);
					IContributionItem item = new ActionContributionItem(action);
					tbm.add(item);
				} catch (InstantiationException e) {
					Activator.getDefault().getLog().log(
							new Status(IStatus.ERROR, Activator.PLUGIN_ID,
									"Failed to initialize action - ".concat(
											editorAction.getCanonicalName())
											.concat("\n")
											.concat(e.getMessage())));
				} catch (IllegalAccessException e) {
					Activator.getDefault().getLog().log(
							new Status(IStatus.ERROR, Activator.PLUGIN_ID,
									"Failed to initialize action - ".concat(
											editorAction.getCanonicalName())
											.concat("\n")
											.concat(e.getMessage())));
				}
			}
			tbm.update(true);
		}

	}

	public void setDefaultMark(boolean isDefault) {
		if (label.isDisposed()) {
			return;
		}

		if (!isDefault) {
			label.setFont(Activator.getBoldFont());
			if (label.isVisible())
				label.redraw();
		} else {
			label.setFont(Activator.getDefaultFont());
			if (label.isVisible())
				label.redraw();
		}
	}

	protected void initializeColors(Composite composite) {
		// composite.setBackground(getDisplay().getSystemColor(SWT.COLOR_WHITE));
	}

	@Override
	public void dispose() {
		disposed = true;
		if (groupDropTarget != null) {
			groupDropTarget.setDropTargetEffect(null);
		}
		rulerDropEffect = null;
		if (labelDropTarget != null) {
			labelDropTarget.setDropTargetEffect(null);
		}
		labelDropEffect = null;
		removeListeners();
		if (optionButton != null) {
			optionButton.dispose();
		}
		additionalComposites.clear();
		super.dispose();
	}

	protected void removeListeners() {
		propertyListeners.clear();

	}

	public boolean hasFocus() {

		return false;
	}

	public void attachListeners() {

		listener = new Listener() {

			public void handleEvent(Event event) {
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

		};
		Control control = group;
		while (control.getParent() != null) {
			control.addListener(SWT.MouseDown, listener);
			control = control.getParent();
		}
		// groupDisposeListener
		label.addDisposeListener(new DisposeListener() {

			public void widgetDisposed(DisposeEvent e) {

			}

		});

		paint = new PaintListener() {
			public void paintControl(PaintEvent e) {
				Color color = new Color(null, 0, 0, 0);
				if (isSelected())
					color = (hasFocus()) ? GUIConstants.COLOR_BORDER_SELECTED_FOCUS
							: GUIConstants.COLOR_SELECTED_BACKGROUND;
				else
					color = (hasFocus()) ? GUIConstants.COLOR_BORDER_DESELECTED_FOCUS
							: GUIConstants.COLOR_DESELECTED_BACKGROUND;

				e.gc.setForeground(color);
				e.gc.setLineStyle(SWT.LINE_DOT);
				e.gc.drawRectangle(0, 0, group.getSize().x - 1,
						group.getSize().y - 1);
			}
		};

		// group.addPaintListener(paint);

		group.addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {

				group.removeDisposeListener(this);
				Control control = group;
				while (control.getParent() != null) {
					control.removeListener(SWT.MouseDown, listener);
					control = control.getParent();
				}
				// group.removeListener(SWT.MouseDown, widgetController);
				group.removePaintListener(paint);
			}
		});

	}

	public boolean setFocus() {
		if (!isDisposed() && !super.isDisposed()) {
			return super.setFocus();
		} else {
			return false;
		}
	}

	public abstract void clearErrorMessage();

	public void select() {
		if (!isSelected()) {
			if (!group.isDisposed()) {
				// expand collapsed sequences
				Composite parent = getParent();
				if (parent instanceof SequenceWidgetItem) {
					SequenceWidgetItem item = (SequenceWidgetItem) parent;
					SequenceWidget sWidget = (SequenceWidget) item.getParent();
					boolean changed = false;
					if (sWidget.isCollapsed()) {
						sWidget.setCollapsed(false);
						changed = true;
					}
					if (item.isCollapsed() && item.getFirstControl() != this) {
						item.setCollapsed(false);
						changed = true;
					}
					if (changed) {
						parent.getParent().getParent().getParent().getParent()
								.getParent().getParent().layout(true, true);
					}

				}

			}
			Display.getCurrent().asyncExec(new Runnable() {

				public void run() {
					setFocus();

				}

			});
			if (isReveal()) {
				Composite parent = group.getParent();
				while (!(parent instanceof ScrolledComposite) && parent != null) {
					parent = parent.getParent();
				}

				ScrolledComposite sc = (ScrolledComposite) parent;

				scrollToLabel(sc);
				reveal = false;
			}
			selected = true;

		}

		drawSelectUI();
	}

	public void deselect() {
		if (isSelected()) {
			selected = false;
			drawDeselectUI();
		}

	}

	public boolean isSelected() {
		return selected;
	}

	public void focus() {
		// IMPROVEMENT change focus/unfocus into setFocusState(boolean)

		if (!group.isDisposed()) {
			Composite parent = group.getParent();
			while (!(parent instanceof ScrolledComposite) && parent != null) {
				parent = parent.getParent();
			}

			ScrolledComposite sc = (ScrolledComposite) parent;

			scrollToLabel(sc);

			hasFocus = true;
			setFocus();
			drawFocusUI();
			drawSelectUI();

		}

	}

	public void scrollToLabel(ScrolledComposite scrolledComposite) {
		Control control = label;
		if (control != null) {
			Point controlLocation = control.getLocation();
			Point controlSize = control.getSize();

			while (control.getParent() != scrolledComposite) {
				controlLocation.x += control.getLocation().x;
				controlLocation.y += control.getLocation().y;
				control = control.getParent();
			}

			Rectangle rect = new Rectangle(scrolledComposite.getOrigin().x,
					scrolledComposite.getOrigin().y, scrolledComposite
							.getClientArea().width, scrolledComposite
							.getClientArea().height);

			if (controlSize.y > rect.height) {
				// both control corners are outside scrollbar window, do
				// nothing...
				return;
			}

			if (rect.y + rect.height < controlLocation.y + controlSize.y) {
				scrolledComposite.setOrigin(scrolledComposite.getOrigin().x,
						controlLocation.y + controlSize.y - rect.height);
			} else if (controlLocation.y < rect.y) {
				scrolledComposite.setOrigin(scrolledComposite.getOrigin().x,
						controlLocation.y - controlSize.y);
			}

		}
	}

	protected void drawFocusUI() {
		if (!group.isDisposed())
			group.redraw();

	}

	public void unfocus() {
		// IMPROVEMENT change focus/unfocus into setFocusState(boolean)

		if (disposed) {
			return;
		}
		if (hasFocus) {
			drawUnFocusUI();
			if (!isSelected()) {
				drawDeselectUI();
			}
			Composite parent = group.getParent();
			while (!(parent instanceof ScrolledForm) && parent != null) {
				parent = parent.getParent();
			}
			hasFocus = false;
			this.clearErrorMessage();
		}

	}

	protected void drawUnFocusUI() {
		if (!group.isDisposed())
			group.redraw();
	}

	protected void buildControlContainer(Composite composite) {

		group = composite;
		group.setBackground(new Color(Display.getDefault(), 255, 255, 255));

		group.setData("group");

	}

	protected void setLayout() {
		group.setLayout(buildContainerLayout());
		group.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	}

	protected abstract void buildMainControl();

	public void setImage(Image image) {
		if (this.image != null) {
			this.image.dispose();
			this.image = null;
		}

		if (image != null) {
			this.image = new Image(getDisplay(), image.getImageData().scaledTo(
					DECORATION_SIZE, DECORATION_SIZE));
		}
	}

	protected void buildImage() {
		// image.getImageData()
		if (image != null) {
			decorator = new Canvas(group, SWT.NONE);
			decorator.setBackground(group.getBackground());
			decorator.setLayout(new GridLayout());
			decorator.setLayoutData(new GridData(DECORATION_SIZE,
					DECORATION_SIZE));
			final Rectangle bounds = decorator.getBounds();
			decorator.setBounds(bounds);
			decorator.setSize(bounds.width, bounds.height);
			decorator.addPaintListener(new PaintListener() {

				public void paintControl(PaintEvent e) {
					if (image != null) {
						e.gc.drawImage(image, bounds.x, bounds.y);
					}
				}
			});
		}

	}

	protected void buildLabel(String widgetLabel) {
		label = new /* InflatableLabel(group, SWT.NONE) */Label(group, SWT.NONE);
		label.setBackground(group.getBackground());
		label.setText(widgetLabel);
		if (widgetLabel.length() > 45) {
			label.setToolTipText(widgetLabel);
			StringBuffer sb = new StringBuffer(widgetLabel);
			widgetLabel = sb.substring(0, 44);
			label.setText(widgetLabel + "...");
		}
		int width = DEFAULT_WIDTH_LABEL;
		if (image != null) {
			width = width - DECORATION_SIZE - 5;
		}
		if (graphicsModel != null)
			width = graphicsModel.getWidthLabelSettting();
		// label.setMaxPixels(width);
		label.setLayoutData(layoutDataForLabel(width));
	}

	protected GridData layoutDataForLabel(int width) {
		GridData gridData = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
		gridData.widthHint = width;
		return gridData;
	}

	protected GridData layoutDataForGroup() {
		GridData gridData = new GridData(/* GridData.HORIZONTAL_ALIGN_BEGINNING */);
		gridData.widthHint = CONTROL_WIDTH_HINT;
		return gridData;
	}

	protected Layout buildContainerLayout() {
		GridLayout layout = new GridLayout((image == null) ? 3 : 4, false);
		return layout;
	}

	protected boolean isValidDefaultValue(String defaultValue) {
		return null != defaultValue;// && !empty(defaultValue);
	}

	public abstract void setValue(String value);

	public void cut() {
	};

	public void copy() {
	};

	public void paste() {
	};

	public void delete() {
	};

	public void setValid(boolean isValid) {

	}

	protected void drawDeselectUI() {
		if (group != null && !group.isDisposed()) {
			Color colorWhite = GUIConstants.COLOR_WHITE;
			label.setBackground(colorWhite);
			group.setBackground(colorWhite);
			setBackground(colorWhite);
			if (toolBar != null) {
				toolBar.setBackground(colorWhite);
			}
			Color systemColor = group.getDisplay().getSystemColor(
					SWT.COLOR_WIDGET_BACKGROUND);
			label.setForeground(group.getDisplay().getSystemColor(
					SWT.COLOR_WIDGET_FOREGROUND));
			// additonalCompositesSetBG(systemColor);
			for (int i = 0; i < additionalComposites.size(); i++) {
				additionalComposites.get(i).setBackground(colorWhite);
			}
			if (decorator != null && !decorator.isDisposed()) {
				decorator.setBackground(colorWhite);
			}
			if (dirtyLabel != null) {
				dirtyLabel.setBackground(systemColor);
			}
			group.redraw();
		}
	}

	protected void drawSelectUI() {

		if (group != null && !group.isDisposed()) {
			Color selectionColor = PluginImages.BACKGROUND_COLOR;
			label.setBackground(selectionColor);
			group.setBackground(selectionColor);
			setBackground(selectionColor);
			// additonalCompositesSetBG(selectionColor);
			for (int i = 0; i < additionalComposites.size(); i++) {
				additionalComposites.get(i).setBackground(selectionColor);
			}

			if (decorator != null && !decorator.isDisposed()) {
				decorator.setBackground(selectionColor);
			}
			if (dirtyLabel != null) {
				dirtyLabel.setBackground(selectionColor);
			}
			if (toolBar != null) {
				toolBar.setBackground(selectionColor);
			}
			group.redraw();
		}
	}

	public void addListener(final Listener listener) {
		if (group != null) {
			group.addListener(SWT.MouseDown, listener);
		}

		if (label == null) {
			return;
		}
		label.addListener(SWT.MouseDown, listener);

		List<Listener> listenerList = Arrays
				.asList(getListeners(SWT.MouseDown));

		if (!listenerList.contains(listener)) {
			addListener(SWT.MouseDown, listener);
		}

		label.addDisposeListener(new BWDisposeListener(listener));
	}

	class BWDisposeListener implements DisposeListener {
		private Listener listener;

		public BWDisposeListener(Listener listener) {
			this.listener = listener;
		}

		public void widgetDisposed(DisposeEvent e) {
			label.removeDisposeListener(this);
			label.removeListener(SWT.MouseDown, listener);
			group.removeListener(SWT.MouseDown, listener);
			removeListener(SWT.MouseDown, listener);
			listener = null;
			label.removeDisposeListener(this);
		}
	}

	@Override
	public void setBackground(Color color) {
		super.setBackground(color);
		if (group != null && group != this) {
			group.setBackground(color);
		}
		if (label != null) {
			label.setBackground(color);
		}
	}

	public void setDirtyComposite(Composite dirtyComposite) {
		this.dirtyComposite = dirtyComposite;
		if (dirty || propagateDirty) {
			// dirtyComposite.removePaintListener(dirtyListener);
			// dirtyComposite.addPaintListener(dirtyListener);
			if (getParent() instanceof SequenceWidgetItem) {
				propagateDirty(propagateDirty || dirty);
			}
		}
	}

	public Composite getDirtyComposite() {
		return dirtyComposite;
	}

	public void setNoteComposite(Composite noteComposite) {
		this.noteComposite = noteComposite;

	}

	public Composite getNoteComposite() {
		return noteComposite;
	}

	public void setErrorComposite(Composite errorComposite) {
		this.errorComposite = errorComposite;

	}

	public Composite getErrorComposite() {
		return errorComposite;
	}

	public void setDirty(boolean dirty) {
		this.dirty = dirty;

	}

	public boolean hasError() {
		return hasError;
	}

	public List<Composite> getRowComposites() {
		return additionalComposites;
	}

	@Override
	public String toString() {
		String label = (this.label != null) ? this.label.getText() : "";
		if (getValue() == null) {
			return super.toString().concat("[").concat(label).concat("]");
		} else {
			return this.getClass().getSimpleName().concat("[").concat(label)
					.concat("]").concat("{").concat(getValue()).concat("}");
		}
	}

	public boolean hasNote() {
		return hasNote;
	}

	public void addDragListener(DragSourceListener listener) {
		if (label != null) {
			if (labelDragSource == null) {
				labelDragSource = initDragSource(label);
			}
			labelDragSource.addDragListener(listener);
		}
		if (group != null) {
			if (groupDragSource == null) {
				groupDragSource = initDragSource(group);
			}
			groupDragSource.addDragListener(listener);
		}
	}

	protected DragSource initDragSource(Control control) {
		Object data = control.getData(DND.DRAG_SOURCE_KEY);
		if (data != null && data instanceof DragSource) {
			return (DragSource) data;
		}
		Transfer[] transfers = new Transfer[] {
				LocalSelectionTransfer.getTransfer(),
				TextTransfer.getInstance() };
		int ops = DND.DROP_COPY | DND.DROP_MOVE;
		DragSource dragSource = new DragSource(control, ops);
		dragSource.setTransfer(transfers);
		return dragSource;
	}

	public void addDropListener(DropTargetListener listener) {
		this.dropTargetListener = listener;

		initDropTarget(listener);

	}

	private void initDropTarget(DropTargetListener listener) {
		if (label != null) {
			if (labelDropTarget == null) {
				labelDropTarget = initDropTarget(label);
				labelDropTarget.addDisposeListener(new DisposeListener() {
					public void widgetDisposed(DisposeEvent e) {
						labelDropTarget.setDropTargetEffect(null);
						labelDropTarget.removeDisposeListener(this);
					}
				});
			}
			labelDropTarget.addDropListener(listener);

			if (ruler != null) {
				if (labelDropEffect == null) {
					labelDropEffect = new EditorDropEffect(label, ruler);
				}
				labelDropTarget.setDropTargetEffect(labelDropEffect);
			}
		}
		if (group != null) {
			if (groupDropTarget == null) {
				groupDropTarget = initDropTarget(group);
				groupDropTarget.addDisposeListener(new DisposeListener() {
					public void widgetDisposed(DisposeEvent e) {
						groupDropTarget.setDropTargetEffect(null);
						groupDropTarget.removeDisposeListener(this);
					}
				});
			}
			groupDropTarget.addDropListener(listener);
			if (ruler != null) {
				if (rulerDropEffect == null) {
					rulerDropEffect = new EditorDropEffect(group, ruler);
				}
				groupDropTarget.setDropTargetEffect(rulerDropEffect);
			}
		}
	}

	protected DropTarget initDropTarget(Control control) {
		Object data = control.getData(DND.DROP_TARGET_KEY);
		if (data != null && data instanceof DropTarget) {
			return (DropTarget) data;
		}
		Transfer[] transfers = new Transfer[] {
				LocalSelectionTransfer.getTransfer(),
				TextTransfer.getInstance() };
		int ops = DND.DROP_COPY | DND.DROP_MOVE;
		DropTarget dropTarget = new DropTarget(control, ops);
		dropTarget.setTransfer(transfers);
		return dropTarget;
	}

	public boolean isDirtyPropagated() {
		return propagateDirty;
	}

	public void propagateDirty(boolean propagateDirty) {

	}

	public boolean isNotePropagated() {
		return propagateNote;
	}

	public boolean isErrorPropagated() {
		return propagateError;
	}

	public void propagateError(boolean propagateError) {

	}

	public void setRuler(RulerComposite ruler) {
		this.ruler = ruler;
	}

	public RulerComposite getRuler() {
		return ruler;
	}

	private Set<PropertyChangeListener> propertyListeners = new HashSet<PropertyChangeListener>();
	public static final String PROPERTY_DIRTY = "property dirty";
	public static final String PROPERTY_NOTE = "property note";
	public static final String PROPERTY_ERROR = "property error";
	public static final String PROPERTY_PROPAGATE_DIRTY = "property propagate dirty";
	public static final String PROPERTY_PROPAGATE_NOTE = "property propagate note";
	public static final String PROPERTY_PROPAGATE_ERROR = "property propagate error";

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		propertyListeners.add(listener);
	}

	public void removePropertyChnageListener(PropertyChangeListener listener) {
		propertyListeners.remove(listener);
	}

	protected boolean hasFocus(Control control) {
		Method focusMethod = getHasFocusMethod();
		try {
			Boolean focus = (Boolean) focusMethod.invoke(control);
			return focus;
		} catch (IllegalArgumentException e) {

			e.printStackTrace();
		} catch (IllegalAccessException e) {

			e.printStackTrace();
		} catch (InvocationTargetException e) {

			e.printStackTrace();
		}
		return false;

	}

	private Method getHasFocusMethod() {
		Method declaredMethod = null;
		try {
			declaredMethod = Control.class.getDeclaredMethod("hasFocus");
		} catch (SecurityException e) {

			e.printStackTrace();
		} catch (NoSuchMethodException e) {

			e.printStackTrace();
		}
		declaredMethod.setAccessible(true);
		return declaredMethod;

	}

	public boolean isWasErrorDialogShown() {
		return wasErrorDialogShown;
	}

	public void setWasErrorDialogShown(boolean wasErrorDialogShown) {
		this.wasErrorDialogShown = wasErrorDialogShown;
	}

	public void setOptions(WidgetOptions options) {
		this.options = options;
		if (buildOptions()) {
			layout(true, true);
		}
		if (optionButton != null) {
			optionButton.setOptions(options);
			if (options == null || options.size() < 1) {
				optionButton.setVisible(false);
			} else {
				optionButton.setVisible(true);
			}

		}

	}

	public void setReveal(boolean reveal) {
		this.reveal = reveal;
	}

	public boolean isReveal() {
		return reveal;
	}
}
