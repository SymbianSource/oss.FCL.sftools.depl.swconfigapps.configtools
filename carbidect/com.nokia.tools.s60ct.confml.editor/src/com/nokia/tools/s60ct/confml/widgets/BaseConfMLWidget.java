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


import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
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
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.ui.forms.widgets.ScrolledForm;

import com.nokia.tools.s60ct.confml.actions.EditorAction;
import com.nokia.tools.s60ct.confml.editor.Activator;
import com.nokia.tools.s60ct.confml.editor.ContributorsRegistry;
import com.nokia.tools.s60ct.confml.editor.PluginImages;
import com.nokia.tools.s60ct.model.confml.EResourceSetting;
import com.nokia.tools.s60ct.model.confml.EResourceValue;
import com.nokia.tools.s60ct.model.confml.ESequenceSetting;
import com.nokia.tools.s60ct.model.confml.ESequenceValue;
import com.nokia.tools.s60ct.model.confml.ESequenceValueItem;
import com.nokia.tools.s60ct.model.confml.ESimpleSetting;
import com.nokia.tools.s60ct.model.confml.ESimpleValue;
import com.nokia.tools.vct.common.ui.CommonUIPlugin;
import com.nokia.tools.vct.common.ui.ISharedImages;


public abstract class BaseConfMLWidget extends Composite implements BasicWidget {

	public static final int CONTROL_WIDTH_HINT = 240;

	private static final int DECORATION_SIZE = 16;

	protected Composite dirtyComposite;
	protected Composite noteComposite;
	protected Composite errorComposite;
	protected Composite group;
	protected String oldErrorMessage;
	protected InflatableLabel label;
	protected boolean selected;
	protected boolean hasFocus = false;
	protected boolean disposed = false;
	protected boolean dirty = false;
	private GraphicsWidgetModel graphicsModel;
	private PaintListener paint;
	private Image image;
	protected List<Composite> additionalComposites;
	protected WidgetOptions options;
	private int severity = 0;
	private StringBuffer errorMessages = new StringBuffer();
	public boolean isGrayed = false;
	
	private List<IMarker> markers = new ArrayList<IMarker>();
	
	protected Composite toolBar;
	private OptionButton optionButton;
	private RulerComposite ruler;

	protected Label dirtyLabel;
	private Image noteImage = PluginImages.MRK_NOTE;
	private Image dirtyImage = PluginImages.MRK_DIRTY;
	private PaintListener errorListener = new PaintListener() {
		public void paintControl(PaintEvent e) {
			e.gc.drawImage(PluginImages.MRK_ERROR, 4, 9);
		}
	};
	private PaintListener noteListener = new PaintListener() {
		public void paintControl(PaintEvent e) {
			e.gc.drawImage(noteImage, 0, 6);
		}
	};
	private PaintListener dirtyListener = new PaintListener() {

		public void paintControl(PaintEvent e) {
			e.gc.drawImage(dirtyImage, 4, 6);
		}
	};

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

	public BaseConfMLWidget(Composite parent, int style, String widgetLabel,
			Image image) {
		super(parent, style);
		additionalComposites = new ArrayList<Composite>();
		setImage(image);
		setBackground(parent.getBackground());
		initializeLayout();
		buildWidget(this, widgetLabel);
		layout(true, true);
	}

	public BaseConfMLWidget(Composite parent, int style, String widgetLabel) {
		super(parent, style);
		additionalComposites = new ArrayList<Composite>();
		setBackground(parent.getBackground());
		initializeLayout();
		buildWidget(this, widgetLabel);
		layout(true, true);
	}

	public BaseConfMLWidget(Composite parent, int style, String string,
			WidgetOptions options) {
		super(parent, style);
		additionalComposites = new ArrayList<Composite>();
		this.options = options;
		setBackground(parent.getBackground());
		initializeLayout();
		buildWidget(this, string);
		layout(true, true);
	}

	public BaseConfMLWidget(Composite parent, int style, String string,
			WidgetOptions options, Image image) {
		super(parent, style);
		additionalComposites = new ArrayList<Composite>();
		this.image = image;
		this.options = options;
		setBackground(parent.getBackground());
		initializeLayout();
		buildWidget(this, string);
		layout(true, true);
	}

	private void initializeLayout() {
		GridLayout gridLayout = new GridLayout();
		gridLayout.horizontalSpacing = 0;
		gridLayout.verticalSpacing = 0;
		gridLayout.marginWidth = 0;
		gridLayout.marginHeight = 0;
		setLayout(gridLayout);
		setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	}

	public BaseConfMLWidget(Composite parent, int style) {
		super(parent, style);
		setBackground(parent.getBackground());
		additionalComposites = new ArrayList<Composite>();

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
//		buildOptions();

	}

	protected void buildToolBar() {
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
		List<Class<EditorAction>> contributors = ContributorsRegistry
				.getInstance().getContributors(
						this.getClass().getCanonicalName());

		if (contributors != null) {
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

		} else {
			GridData gd = new GridData();
			gd.widthHint = 0;
			toolBar.setLayoutData(gd);
		}

		tbm.update(true);

	}

	public void setDefaultMark(boolean isDefault) {
		if (!isDefault) 
		{
			if (this instanceof BooleanCheckBox)
			{
				this.bold(true);	
			}
			else
			{
				label.setFont(Activator.getBoldFont());
				label.redraw();
			}
		} else 
		{
			if (this instanceof BooleanCheckBox)
			{
				this.bold(false);	
			}
			else
			{
				label.setFont(Activator.getDefaultFont());
				label.redraw();
			}
		}
	}

	protected void initializeColors(Composite composite) {
		//composite.setBackground(getDisplay().getSystemColor(SWT.COLOR_WHITE));
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
		
		if (optionButton != null) {
			optionButton.dispose();
		}
		
		labelDropEffect = null;
		removeListeners();
//		if (image != null) {
//			image.dispose();
//		}
		additionalComposites.clear();
		super.dispose();
	}

	protected void removeListeners() {
		propertyListeners.clear();
		if (errorComposite != null && errorListener != null) {
			errorComposite.removePaintListener(errorListener);
		}
		errorListener = null;
		if (noteComposite != null && noteListener != null) {
			noteComposite.removePaintListener(noteListener);
		}
		noteListener = null;
		if (dirtyComposite != null && dirtyListener != null) {
			dirtyComposite.removePaintListener(dirtyListener);
		}
		dirtyListener = null;

	}

	public boolean hasFocus() {

		return false;
	}

	public void attachListeners() {

		// group.addListener(SWT.MouseDown, widgetController);
		// label.addListener(SWT.MouseDown, widgetController);
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

		// if (toolBar!=null){
		// toolBar.addListener(SWT.MouseDown, listener);
		// }
	}

	public boolean setFocus() {
		if (!isDisposed()) {
			return super.setFocus();
		} else {
			return false;
		}
	}

	// public abstract void setErrorMessage(String message);

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

			selected = true;
			drawSelectUI();

		}

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
		// change focus/unfocus into setFocusState(boolean)

		if (!group.isDisposed()) {
			Composite parent = group.getParent();
			while (!(parent instanceof ScrolledComposite) && parent != null) {
				if (parent instanceof Accordeon) {

					((Accordeon) parent).expand(true);
					((Accordeon) parent).setSelection(true);

				}
				parent = parent.getParent();
			}

			ScrolledComposite sc = (ScrolledComposite) parent;

			scrollToLabel(label, sc);

			hasFocus = true;
			setFocus();
			drawFocusUI();
			drawSelectUI();

		}

	}

	public void scrollToLabel(Control control,
			ScrolledComposite scrolledComposite) {

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
						controlLocation.y);
			}

		}
	}

	protected void drawFocusUI() {
		if (!group.isDisposed())
			group.redraw();

	}

	public void unfocus() {
		// change focus/unfocus into setFocusState(boolean)

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
				if (parent instanceof Accordeon) {

					((Accordeon) parent).expand(true);
					((Accordeon) parent).setSelection(true);

				}
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
		// composite.setBackground(new Color(composite.getDisplay(),0,0,100));
		// Layout layout = composite.getLayout();
		// Object layoutData = composite.getLayoutData();
		group = new Composite(composite, SWT.NONE);
		// group.setBackground(new Color(Display.getDefault(), 255, 255, 255));
		group.setBackground(composite.getBackground());
		group.setData("group");
		if (composite.getData() instanceof GraphicsWidgetModel)
			graphicsModel = (GraphicsWidgetModel) composite.getData();
	}

	protected void setLayout() {
		group.setLayout(buildContainerLayout());
		group.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	}

	protected abstract void buildMainControl();

	public void setImage(Image image) {
//		if (this.image != null) {
//			this.image.dispose();
//			this.image = null;
//		}

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
			// decorator.setBounds(bounds);
			// decorator.setSize(bounds.width,bounds.height);
			decorator.addPaintListener(new PaintListener() {

				public void paintControl(PaintEvent e) {
					if (image != null) {
						e.gc.drawImage(image, 0, 0);
					}
				}
			});
		}

	}

	protected boolean buildOptions(Composite c) 
	{
		if (this instanceof SelectionComboBox || this instanceof MultiSelectionWidget)
			return false;
		
		if (options != null && options.size() > 0 && optionButton == null) {
			optionButton = new OptionButton(this, c, options);
			return true;
		}
		return false;
	}
	
	protected void buildLabel(String widgetLabel) {
		label = new InflatableLabel(group, SWT.NONE);
		label.setBackground(group.getBackground());
		label.setText(widgetLabel);
		int width = DEFAULT_WIDTH_LABEL;
		if (image != null) {
			width = width - DECORATION_SIZE - 5;
		}
		if (graphicsModel != null)
			width = graphicsModel.getWidthLabelSettting();
		label.setMaxPixels(width);
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

	public Layout buildContainerLayout() {
		GridLayout layout = new GridLayout((image == null) ? 3 : 4, false);
		return layout;
	}

	protected boolean isValidDefaultValue(String defaultValue) {
		return null != defaultValue;// && !empty(defaultValue);
	}

	public void setOptions(WidgetOptions options) {
		this.options = options;
//		if (buildOptions()) {
//			layout(true, true);
//		}
		if (optionButton != null) {
			optionButton.setOptions(options);
			if (options == null || options.size() < 1) {
				optionButton.setVisible(false);
			} else {
				optionButton.setVisible(true);
			}
		}
	}
	
	public void refreshOptions()
	{

	}
	
	public void refreshToolBar()
	{
		toolBar.redraw();
	}
	
	
	public abstract void setValue(String value);

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
			
//			if (isEnabled())
//				label.setForeground(group.getDisplay().getSystemColor(
//						SWT.COLOR_WIDGET_FOREGROUND));
//			else
//				label.setForeground(group.getDisplay().getSystemColor(
//						SWT.COLOR_GRAY));
			
			additonalCompositesSetBG(systemColor);
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
			additonalCompositesSetBG(selectionColor);
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

	protected final void additonalCompositesSetBG(Color color) {
		if (errorComposite != null) {
			errorComposite.setBackground(color);
		}
		if (noteComposite != null) {
			noteComposite.setBackground(color);
		}
		if (dirtyComposite != null) {
			dirtyComposite.setBackground(color);
		}

	}

	public void addListener(Listener listener) {
		if (group != null) {
			group.addListener(SWT.MouseDown, listener);
		}

		if (label == null) {
			return;
		}
		label.addListener(SWT.MouseDown, listener);
		addListener(SWT.MouseDown, listener);

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
		if (group != null) {
			group.setBackground(color);
		}
		if (label != null) {
			label.setBackground(color);
		}
	}

	public void setDirtyComposite(Composite dirtyComposite) {
		this.dirtyComposite = dirtyComposite;
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
		if (dirtyComposite != null) {
			if (dirty) {
				dirtyComposite.removePaintListener(dirtyListener);
				dirtyComposite.addPaintListener(dirtyListener);
				dirtyComposite.redraw();
			} else {
				dirtyComposite.removePaintListener(dirtyListener);
				dirtyComposite.redraw();
			}
		}
		fireProperty(this, PROPERTY_DIRTY, !dirty, dirty);
	}

	public void createError(String message) {
		boolean temp = hasError;
		hasError = true;
		if (errorComposite != null) {
			errorComposite.removePaintListener(errorListener);
			errorComposite.addPaintListener(errorListener);
			errorComposite.redraw();
			// errorComposite.setToolTipText(message);

			toolTip = ErrorToolTipWidget.createNewErrorToolTip(errorComposite,
					message);
			errorToolTipListener = new ErrorToolTipMouseTrackListener(toolTip,
					errorComposite);
			errorComposite.addMouseTrackListener(errorToolTipListener);
		}
		// setToolTipText(message);

		fireProperty(this, PROPERTY_ERROR, temp, true);
		hasError = true;
	}

	public void removeError() {
		if (errorToolTipListener != null) {
			errorComposite.removeMouseTrackListener(errorToolTipListener);

		}
		if (toolTip != null && !toolTip.isDisposed()) {
			toolTip.dispose();
		}
		errorComposite.removePaintListener(errorListener);
		errorComposite.redraw();
		boolean temp = hasError;
		hasError = false;
		fireProperty(this, PROPERTY_ERROR, temp, false);
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

	public void createNote() {
		if (noteComposite != null) {
			noteComposite.addPaintListener(noteListener);
			noteComposite.redraw();
		}
		boolean temp = hasNote;
		hasNote = true;
		fireProperty(this, PROPERTY_NOTE, temp, true);

	}

	public void removeNote() {
		if (noteComposite != null) {
			noteComposite.removePaintListener(noteListener);
			noteComposite.redraw();
		}
		boolean temp = hasNote;
		hasNote = false;
		fireProperty(this, PROPERTY_NOTE, temp, false);
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
		if (label != null) {
			if (labelDropTarget == null) {
				labelDropTarget = initDropTarget(label);
				// labelDropTarget.addDisposeListener(new DisposeListener(){
				//
				// public void widgetDisposed(DisposeEvent e) {
				// labelDropTarget.setDropTargetEffect(null);
				// labelDropTarget.removeDisposeListener(this);
				// }});
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
				// groupDropTarget.addDisposeListener(new DisposeListener(){
				//
				// public void widgetDisposed(DisposeEvent e) {
				// groupDropTarget.setDropTargetEffect(null);
				// groupDropTarget.removeDisposeListener(this);
				// }
				//					
				// });
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
		boolean temp = this.propagateDirty;
		if (this.propagateDirty != propagateDirty) {
			this.propagateDirty = propagateDirty;
			if (dirtyComposite != null) {
				if (propagateDirty) {
					dirtyComposite.removePaintListener(dirtyListener);
					dirtyComposite.addPaintListener(dirtyListener);
				} else if (!dirty) {
					dirtyComposite.removePaintListener(dirtyListener);
				}
				dirtyComposite.redraw();
			}
		}
		fireProperty(this, PROPERTY_PROPAGATE_DIRTY, temp, propagateDirty);
	}

	public boolean isNotePropagated() {
		return propagateNote;
	}

	public void propagateNote(boolean propagateNote) {
		boolean temp = this.propagateNote;
		if (this.propagateNote != propagateNote) {
			this.propagateNote = propagateNote;
			if (noteComposite != null) {
				if (propagateNote) {
					noteComposite.removePaintListener(noteListener);
					noteComposite.addPaintListener(noteListener);
				} else if (!hasNote) {
					noteComposite.removePaintListener(noteListener);
				}
				noteComposite.redraw();
			}
		}
		fireProperty(this, PROPERTY_PROPAGATE_NOTE, temp, propagateNote);
	}

	public boolean isErrorPropagated() {
		return propagateError;
	}

	public void propagateError(boolean propagateError) {
		boolean temp = this.propagateError;
		if (this.propagateError != propagateError) {
			this.propagateError = propagateError;
			if (errorComposite != null) {
				if (propagateError) {
					errorComposite.removePaintListener(errorListener);
					errorComposite.addPaintListener(errorListener);
				} else if (!hasError) {
					errorComposite.removePaintListener(errorListener);
				}
				errorComposite.redraw();
			}
		}
		fireProperty(this, PROPERTY_PROPAGATE_ERROR, temp, propagateError);
	}

	public void setRuler(RulerComposite ruler) {
		this.ruler = ruler;
	}

	public RulerComposite getRuler() {
		return ruler;
	}

	private List<PropertyChangeListener> propertyListeners = new ArrayList<PropertyChangeListener>();
	public static final String PROPERTY_DIRTY = "property dirty";
	public static final String PROPERTY_NOTE = "property note";
	public static final String PROPERTY_ERROR = "property error";
	public static final String PROPERTY_PROPAGATE_DIRTY = "property propagate dirty";
	public static final String PROPERTY_PROPAGATE_NOTE = "property propagate note";
	public static final String PROPERTY_PROPAGATE_ERROR = "property propagate error";

	private Shell toolTip;

	private ErrorToolTipMouseTrackListener errorToolTipListener;

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		propertyListeners.add(listener);
	}

	public void removePropertyChnageListener(PropertyChangeListener listener) {
		propertyListeners.remove(listener);
	}

	private void fireProperty(Object source, String propertyName,
			Object oldValue, Object newValue) {
		PropertyChangeListener[] array = propertyListeners
				.toArray(new PropertyChangeListener[propertyListeners.size()]);
		for (int i = 0; i < array.length; i++) {
			array[i].propertyChange(new PropertyChangeEvent(source,
					propertyName, oldValue, newValue));
		}
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

	public boolean isEditable()
	{
	
		if (!this.isEnabled()) return false;
		
		
		Object data = getData();

		if (data instanceof ESimpleSetting)
		{
			ESimpleSetting simpleSetting = (ESimpleSetting)data;
			
			if (simpleSetting.eContainer() instanceof ESequenceSetting)
			{
				//doesn't come here ever?
			}
			return !simpleSetting.isReadOnly();
		}
		else if (data instanceof EResourceSetting)
		{
			EResourceSetting resourceSetting = (EResourceSetting)data;
			return !resourceSetting.isReadOnly();
		}
		else if (data instanceof ESequenceSetting)
		{
			ESequenceSetting seqSet = (ESequenceSetting)data;
			return !seqSet.isReadOnly();
		}
		else if (data instanceof ESimpleValue) //sequence or template sub setting
		{
			ESimpleValue sValue = (ESimpleValue)data;
			
			if (sValue.eContainer() instanceof ESequenceValueItem)
			{
				ESequenceValueItem seqValItem = (ESequenceValueItem)sValue.eContainer();
				if (seqValItem.isEditable())
					return !sValue.getType().isReadOnly();
				else
					return false;
			}
			return !sValue.getType().isReadOnly();
		}
		else if (data instanceof EResourceValue) //sequence or template sub setting
		{
			EResourceValue rValue = (EResourceValue)data;
			
			if (rValue.eContainer() instanceof ESequenceValueItem)
			{
				ESequenceValueItem seqValItem = (ESequenceValueItem)rValue.eContainer();
				if (seqValItem.isEditable())
					return !rValue.getType().isReadOnly();
				else
					return false;
			}
			return !rValue.getType().isReadOnly();
		}
		else if(data instanceof ESequenceValue)
		{
			if (this instanceof ExtensionPolicyWidget)
			{
				ESequenceSetting ss = (ESequenceSetting)((ESequenceValue)data).eContainer();
				return !ss.isReadOnly(); 
			}
			else
			{
				System.out.println("Unimplemented ESequenceValue in isEditable");
			}
		}
		else if(data instanceof ESequenceValueItem)
		{
			ESequenceValueItem svi = (ESequenceValueItem)data;
			ESequenceSetting ss = (ESequenceSetting)svi.eContainer().eContainer();
			return !ss.isReadOnly();
		}
		else
		{
			System.out.println("Unimplemented type in isEditable");
		}
		return true;
	}

	public void bold(boolean bold)
	{
		
	}
	
	public abstract void setGrayed(boolean grayed);
	
	public boolean isGrayed()
	{
		return isGrayed;
	}
	
	public void setOptionsEnabled(boolean enabled)
	{
		if (optionButton!= null)
			optionButton.setEnabled(enabled);
	}
	
	public void clearMarkers()
	{
		markers.clear();
		setImage(PluginImages.CLEAR);
		severity = 0;
		errorMessages.delete(0, errorMessages.length());
		if (decorator != null)
			decorator.redraw();
	}
	
	public void addMarker(IMarker marker)
	{
		boolean severityChanged = false;
		markers.add(marker);
		for (int i = 0 ; i < markers.size() ; i++)
		{
			IMarker m = markers.get(i);
			try 
			{
				String message = (String)m.getAttribute(IMarker.MESSAGE);
				if (i > 0)
					errorMessages.append("\n");
				errorMessages.append(message);
				
				int s = ((Integer)m.getAttribute(IMarker.SEVERITY)).intValue();
				if (severity != s && s > severity)
				{
					severity = s;
					severityChanged = true;
				}
			} 
			catch (CoreException e)
			{
				e.printStackTrace();
			}
		}
		if (severityChanged)
		{
			if (severity == IMarker.SEVERITY_WARNING)
			{
				setImage(PluginImages.WARNING);
				label.setToolTipText(errorMessages.toString());
				if (decorator != null)
					decorator.redraw();
			}
			else if (severity == IMarker.SEVERITY_ERROR)
			{
				setImage(PluginImages.ERROR);
				label.setToolTipText(errorMessages.toString());
				if (decorator != null)
					decorator.redraw();
			}
		}
		
	}
	
}
