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
package com.nokia.tools.s60ct.confml.viewer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.eclipse.core.internal.resources.File;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
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
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import com.nokia.tools.s60ct.build.builder.CrmlBuilder;
import com.nokia.tools.s60ct.confml.editor.PluginImages;
import com.nokia.tools.s60ct.confml.widgets.BaseConfMLWidget;
import com.nokia.tools.s60ct.confml.widgets.BooleanCheckBox;
import com.nokia.tools.s60ct.confml.widgets.DateTimeWidget;
import com.nokia.tools.s60ct.confml.widgets.DateWidget;
import com.nokia.tools.s60ct.confml.widgets.DummySeqHeader;
import com.nokia.tools.s60ct.confml.widgets.DurationWidget;
import com.nokia.tools.s60ct.confml.widgets.ExtensionPolicyWidget;
import com.nokia.tools.s60ct.confml.widgets.FileTextBox;
import com.nokia.tools.s60ct.confml.widgets.FolderTextBox;
import com.nokia.tools.s60ct.confml.widgets.GUIConstants;
import com.nokia.tools.s60ct.confml.widgets.HeightChangeEvent;
import com.nokia.tools.s60ct.confml.widgets.IntegerTextBox;
import com.nokia.tools.s60ct.confml.widgets.MultiSelectionWidget;
import com.nokia.tools.s60ct.confml.widgets.RealTextBox;
import com.nokia.tools.s60ct.confml.widgets.SelectionComboBox;
import com.nokia.tools.s60ct.confml.widgets.SequenceWidget;
import com.nokia.tools.s60ct.confml.widgets.SequenceWidgetItem;
import com.nokia.tools.s60ct.confml.widgets.StringTextBox;
import com.nokia.tools.s60ct.confml.widgets.TimeWidget;
import com.nokia.tools.s60ct.confml.widgets.WidgetOptions;
import com.nokia.tools.s60ct.model.confml.EResourceValue;
import com.nokia.tools.s60ct.model.confml.ESequenceSetting;
import com.nokia.tools.s60ct.model.confml.ESequenceValue;
import com.nokia.tools.s60ct.model.confml.ESequenceValueItem;
import com.nokia.tools.s60ct.model.confml.ESetting;
import com.nokia.tools.s60ct.model.confml.ESettingValue;
import com.nokia.tools.s60ct.model.confml.ESimpleSetting;
import com.nokia.tools.s60ct.model.confml.ESimpleValue;
import com.nokia.tools.s60ct.model.confml.View;
import com.nokia.tools.s60ct.model.confml.impl.ESequenceSettingImpl;
import com.nokia.tools.s60ct.model.confml.impl.ESettingValueImpl;
import com.nokia.tools.s60ct.model.confml.presentation.ConfmlEditor;
import com.nokia.tools.s60ct.model.confml.util.SettingEvaluator;
import com.nokia.tools.s60ct.model.confml.util.UISettingType;
import com.nokia.tools.vct.common.ui.utils.SWTUtil;

/**
 * This viewer is used in the value editor plugin and possible in other places where users 
 * manipulate features of confml specification. 
 * @author haismail
 *
 */
public class FeatureViewer extends StructuredViewer {
	private Composite mainComposite;
	private Map<Object, Composite> elementToWidgetMap = new HashMap<Object, Composite>();
	private Map<String, Composite> refToWidgetMap = new HashMap<String, Composite>();
	private Composite bodyComposite;
	private ScrolledComposite scrolledComposite;
	private List<SequenceControlListener> sequenceWidgetListeners;
	private Group featureGroupComposite;

	public FeatureViewer(Composite parent) {
		scrolledComposite = new ScrolledComposite(parent, SWT.H_SCROLL | SWT.V_SCROLL);
		mainComposite = new Composite(scrolledComposite, SWT.NONE);
		scrolledComposite.setBackground(Display.getCurrent().getSystemColor(
				SWT.COLOR_WHITE));
		mainComposite.setBackground(parent.getBackground());
		scrolledComposite.setContent(mainComposite);
		GridLayout gridLayout = new GridLayout();
		gridLayout.verticalSpacing = 0;
		gridLayout.horizontalSpacing = 0;
		gridLayout.marginHeight = 0;
		gridLayout.marginWidth = 0;
//		FillLayout fillLayout = new FillLayout();
//		fillLayout.type = SWT.VERTICAL;
		mainComposite.setLayout(gridLayout);
		scrolledComposite.setMinSize(mainComposite.computeSize(SWT.DEFAULT, SWT.DEFAULT));
	}

	public Map<Object, Composite> getElementToWidgetMap() {
		return elementToWidgetMap;
	}

	@Override
	protected Widget doFindInputItem(Object element) {
		Object root = getRoot();
		if (root == null) {
			return null;
		}

		if (equals(root, element)) {
			return mainComposite;
		}
		return null;
	}

	@Override
	protected Widget doFindItem(Object element) {
		return elementToWidgetMap.get(element);
	}

	@Override
	protected void doUpdateItem(Widget item, Object element, boolean fullMap) {
//		IContentProvider contentProvider = getContentProvider();
//		if (contentProvider instanceof IValuesContentProvider) {
//			IValuesContentProvider valuesProvider = (IValuesContentProvider) contentProvider;
//			String value = valuesProvider.getValue(element);
//			BaseConfMLWidget confMLWidget = (BaseConfMLWidget) item;
//			confMLWidget.setDefaultMark(valuesProvider.isDefault(element));
//			if (value != null && confMLWidget.getValue().equals(value)) {
//				return;
//			}
//			confMLWidget.setValue(value);
//		}
		if (mainComposite == null || (mainComposite != null && mainComposite.isDisposed())) {
			return;
		}
		IContentProvider contentProvider = getContentProvider();
		if (contentProvider instanceof IValuesContentProvider) {
			IValuesContentProvider valuesProvider = (IValuesContentProvider) contentProvider;
			String value = valuesProvider.getValue(element);
			//validate(element, value);
			

			//handleDirty(element);
			//handleDefault(element);
			BaseConfMLWidget confMLWidget = (BaseConfMLWidget) item;
			ISettingsLabelProvider labelProvider = (ISettingsLabelProvider) getLabelProvider();
			WidgetOptions options = labelProvider.getOptions(element);

			confMLWidget.setOptions(options);
			
			//boolean editable = labelProvider.isEditable(element);
			//confMLWidget.setEditable(editable);
			
			confMLWidget.setDefaultMark(valuesProvider.isDefault(element));
			if (value != null && confMLWidget.getValue().equals(value)) {
				return;
			}
			if (confMLWidget.isDisposed()) {
				return;
			}
			confMLWidget.setValue(value);

		}
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
	protected void internalRefresh(Object element) {
		System.out.println("\n*** INTERNAL REFRESH ****\n");
		Set<Object> keys = elementToWidgetMap.keySet();
		for (Iterator<Object> iterator = keys.iterator(); iterator.hasNext();) {
			Object key = iterator.next();
			Composite composite = elementToWidgetMap.get(key);
			composite.dispose();
		}
		elementToWidgetMap.clear();
		refToWidgetMap.clear();
		Control[] controls = mainComposite.getChildren();
		for (Control control : controls) {
			control.dispose();
		}
		if (element == null) {
			return;
		}
		createMainControl();
		sequenceWidgetListeners = new ArrayList<SequenceControlListener>();
		IContentProvider contentProvider = getContentProvider();
		IBaseLabelProvider baseLabelProvider = getLabelProvider();
		
		IValuesContentProvider valuesContentProvider = (IValuesContentProvider) contentProvider;
		ILabelProvider labelProvider = (ILabelProvider) baseLabelProvider;
		Object root = getRoot();
		Object[] features = valuesContentProvider.getElements(root);
		for (int i = 0; i < features.length; i++) {
			Object f = features[i];
			featureGroupComposite = new Group(bodyComposite,SWT.NONE);
			String groupLabel = labelProvider.getText(f);
			groupLabel = groupLabel.replaceAll("&", "&&");
			featureGroupComposite.setText(groupLabel);
			GridLayout layout = new GridLayout();
			layout.horizontalSpacing = 1;
			layout.verticalSpacing = 1;
			layout.marginHeight = 5;
			layout.marginWidth = 5;
			featureGroupComposite.setLayout(layout);

			GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
			featureGroupComposite.setLayoutData(gridData);
			featureGroupComposite.setBackground(Display.getCurrent().getSystemColor(
					SWT.COLOR_WHITE));
//			elementToWidgetMap.put(f, fg);
			Object[] elements = valuesContentProvider.getElements(f);
			for (int j = 0; j < elements.length; j++) {
				createWidget(featureGroupComposite, elements[j], labelProvider,
						valuesContentProvider, PluginImages.CLEAR, j);
			}
		}

		mainComposite.setSize(mainComposite.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		mainComposite.layout();
		
		ConfmlEditor editor = getEditor();
		if (editor!=null)
			editor.updateErrors();
		
	}

	public ConfmlEditor getEditor()
	{
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		ConfmlEditor editor = null;
		if (page != null) 
		{
			IEditorPart activeEditor = page.getActiveEditor();
			
			if (activeEditor != null && activeEditor instanceof ConfmlEditor)
			{
				editor = (ConfmlEditor) activeEditor;
			}
		}
		return editor;
	}
	
	private void createWidget(Composite parent, Object element,
			ILabelProvider labelProvider,
			final IValuesContentProvider valuesContentProvider, Image image,
			int i) {

		Composite comp = new Composite(parent, SWT.NONE);
		GridLayout gl = new GridLayout();
		gl.marginHeight = 1;
		gl.marginWidth = 1;
		gl.verticalSpacing = 0;
		comp.setLayout(gl);
		comp.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		Composite settingComposite = new Composite(comp, SWT.NONE);
		settingComposite.setBackground(bodyComposite.getBackground());
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		GridLayout gridLayout = new GridLayout();
		gridLayout.marginHeight = 0;
		gridLayout.marginWidth = 0;
		gridLayout.verticalSpacing = 0;
		settingComposite.setLayout(gridLayout);
		settingComposite.setLayoutData(gd);
		String labelText = labelProvider.getText(element);
		Composite textBox = null;
		if (labelProvider instanceof ISettingsLabelProvider) {
			ISettingsLabelProvider settingsLabelProvider = (ISettingsLabelProvider) labelProvider;
			UISettingType type = settingsLabelProvider.getType(element);
			
			
			if (type.equals(UISettingType.SELECTION)) {
				textBox = new SelectionComboBox(settingComposite, SWT.NONE,
						labelText,
						settingsLabelProvider.getOptions(element), image);
			}
			else if (type.equals(UISettingType.MULTISELECTION)) {
				textBox = new MultiSelectionWidget(settingComposite, SWT.NONE,
						labelText, settingsLabelProvider.getOptions(element), image);
			}
			else if (type.equals(UISettingType.BOOLEAN)) {
				textBox = new BooleanCheckBox(settingComposite, SWT.NONE,
						labelText, settingsLabelProvider.getOptions(element),image);
			}
			else if (type.equals(UISettingType.STRING)) {
				textBox = new StringTextBox(settingComposite, SWT.NONE,
						labelText, settingsLabelProvider.getOptions(element),image);
			}
			else if (type.equals(UISettingType.DATE)) {
				textBox = new DateWidget(settingComposite, SWT.NONE,
						labelText, settingsLabelProvider.getOptions(element),image);
			}
			else if (type.equals(UISettingType.TIME)) {
				textBox = new TimeWidget(settingComposite, SWT.NONE,
						labelText, settingsLabelProvider.getOptions(element),image);
			}
			else if (type.equals(UISettingType.DATETIME)) {
				textBox = new DateTimeWidget(settingComposite, SWT.NONE,
						labelText, settingsLabelProvider.getOptions(element),image);
			}
			else if (type.equals(UISettingType.DURATION)) {
				textBox = new DurationWidget(settingComposite, SWT.NONE,
						labelText, settingsLabelProvider.getOptions(element),image);
			}
			else if (type.equals(UISettingType.FILE)) {
				textBox = new FileTextBox(settingComposite, SWT.NONE,
						labelText, settingsLabelProvider.getOptions(element),image);
			}
			else if (type.equals(UISettingType.FOLDER)) {
				textBox = new FolderTextBox(settingComposite, SWT.NONE,
						labelText, settingsLabelProvider.getOptions(element),image);
			}

			else if (type.equals(UISettingType.REAL)) {
				textBox = new RealTextBox(settingComposite, SWT.NONE,labelText, settingsLabelProvider.getOptions(element),image);
			}
			
			
			//				Object[] fileValues = valuesContentProvider
			//				.getChildren(object);
			//				if (fileValues.length == 0) {
			//					return;
			//				}
			//				// Action action = new Action() {
			//				// @Override
			//				// public void run() {
			//				// }
			//				// };
			//				// action.setText("Browse");
			//
			//				textBox = new FileTextBox(settingComposite, SWT.NONE,
			//						labelText, image);
			//
			//				// FileTextBox fileTextBox = (FileTextBox) textBox;
			//				Transfer[] transfers = new Transfer[] {
			//						LocalSelectionTransfer.getTransfer(),
			//						ResourceTransfer.getInstance(),
			//						FileTransfer.getInstance(),
			//						PluginTransfer.getInstance(),
			//						TextTransfer.getInstance() };
			//				int ops = DND.DROP_COPY | DND.DROP_MOVE;
			//				DropTargetListener adapter = valuesContentProvider
			//				.getDropTargetListener(object);
			//				DropTarget dropTarget = new DropTarget(textBox, ops
			//						| DND.DROP_DEFAULT);
			//				dropTarget.setTransfer(transfers);
			//				dropTarget.addDropListener(adapter);
			//				initializeWidget(valuesContentProvider, fileValues[0],
			//						textBox);
			//				textBox = new StringTextBox(settingComposite, SWT.NONE,
			//						"Location in Phone", PluginImages.FILE);
			//				initializeWidget(valuesContentProvider, fileValues[1],
			//						textBox);
			//				return;
			//
			//			}
			else if (type.equals(UISettingType.SEQUENCE)) {
				textBox = createSequenceWidget(settingComposite, SWT.NONE,
						element, settingsLabelProvider,
						valuesContentProvider);
				return;
			}
			//			if (type.equals(Type.CONTENTS)) {
			//				textBox = new ContentsBox(settingComposite, SWT.NONE,
			//						labelText, image);
			//			}
			//			if (type.equals(Type.DESCRIPTION)) {
			//				textBox = new MultiStringTextBox(settingComposite,
			//						SWT.NONE, labelText, image);
			//
			//			}
			//			if (type.equals(Type.ELEMENT_READONLY)) {
			//				textBox = new ShortStringTextBox(settingComposite,
			//						SWT.NONE, labelText, image, SWT.BORDER | SWT.RIGHT);
			//
			//			}
			//			if (type.equals(Type.ELEMENT_EDITABLE)) {
			//				textBox = new StringTextBox(settingComposite, SWT.NONE,
			//						labelText, image);
			//
			//			}
			//			if (type.equals(Type.GUIDELINE)) {
			//				textBox = new LinkBox(settingComposite, SWT.NONE,
			//						labelText, image);
			//
			//			}
			//			if (type.equals(Type.PRODUCTIMAGES)) {
			//				textBox = new ProductImagesBox(settingComposite, SWT.NONE,
			//						labelText, image);
			//			}
			//			if (type.equals(Type.HISTORY)) {
			//				textBox = new TableBox(settingComposite, SWT.NONE,
			//						labelText, image);
			//			}
			else if (type.equals(UISettingType.INT )) {
				textBox = new IntegerTextBox(settingComposite, SWT.NONE,
						labelText, settingsLabelProvider.getOptions(element),image);
			}
		}

		if (textBox != null) {
			initializeWidget(valuesContentProvider, element, textBox);
		}
		Object[] children = valuesContentProvider.getChildren(element);

		for (int j = 0; j < children.length; j++) {
			createWidget(parent, children[j], labelProvider,
					valuesContentProvider, image, j);
		}

	}

	private void initializeWidget(
			final IValuesContentProvider valuesContentProvider,
			final Object child, final Composite textBox) 
	{
		
		textBox.setData(child);
		String value = valuesContentProvider.getValue(child);
		if (textBox instanceof BaseConfMLWidget) {
			BaseConfMLWidget widget = (BaseConfMLWidget) textBox;
			widget.setValue(value);
			widget.setDefaultMark(valuesContentProvider.isDefault(child));
			elementToWidgetMap.put(child, textBox);
			addListener(widget);
			if (child instanceof ESetting)
			{
				ESetting s = (ESetting)child;
				refToWidgetMap.put(s.getAbsRef(), textBox);
			}
			else if(child instanceof ESimpleSetting) {
				ESimpleSetting ss = (ESimpleSetting) child;
				ESimpleValue dv = (ESimpleValue) ss.getDefaultValue();
				if(/*dv.getValue()==null || */ss.isReadOnly()) {
					//widget.setEnabled(false);
					widget.setGrayed(true);
				}
				
			}
			else if(child instanceof ESequenceSetting) {
				ESequenceSetting ss = (ESequenceSetting) child;
				ESequenceValue dv = (ESequenceValue) ss.getDefaultValue();
				EList<ESequenceValueItem> items = dv.getItems();
				if(items==null || items.isEmpty() ||  ss.isReadOnly()) {
					//widget.setEnabled(false);
					widget.setGrayed(true);
				}
			}
			else if(child instanceof EResourceValue) {
				EResourceValue rv = (EResourceValue) child;
				if (rv.getType().isReadOnly())
				{
					//widget.setEnabled(false);
					widget.setGrayed(true);
				}
			}
			else if(child instanceof ESimpleValue) {
				ESimpleValue sv = (ESimpleValue) child;
				if (sv.getType().isReadOnly())
				{
					//widget.setEnabled(false);
					widget.setGrayed(true);
				}
			}
			else if(child instanceof ESequenceValue)
			{
				if (textBox instanceof ExtensionPolicyWidget)
				{
					ESequenceSetting ss = (ESequenceSetting)((ESequenceValue)child).eContainer();
					if(ss.isReadOnly()) 
					{
						widget.setGrayed(true);
					}
				}
				else
				{
					System.out.println("Unimplemented ESequenceValue in initializeWidget");
				}
			}
			else if(child instanceof ESequenceValueItem)
			{
				ESequenceValueItem svi = (ESequenceValueItem)child;
				ESequenceSetting ss = (ESequenceSetting)svi.eContainer().eContainer();
				if(ss.isReadOnly()) 
				{
					widget.setGrayed(true);
				}
			}
			else
			{
				System.out.println("Unimplemented type in initializeWidget");
			}
		}
	}

	@Override
	public void reveal(Object element) {
		Widget item = doFindItem(element);
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

				if (reveal) {
					reveal(object);
				}
			}
		}
	}

	private void internalDeselectAllWidgets() {
		Iterator<Composite> values = elementToWidgetMap.values().iterator();
		while (values.hasNext()) {
			Composite next = values.next();
			if (next instanceof BaseConfMLWidget) {
				((BaseConfMLWidget) next).deselect();
			}
		}

	}
	
	@Override
	public Control getControl() {
		return mainComposite;
	}

	private void createMainControl() {
		bodyComposite = new Composite(mainComposite,
				SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.horizontalSpacing = 1;
		layout.verticalSpacing = 1;
		layout.marginHeight = 5;
		layout.marginWidth = 5;
		bodyComposite.setLayout(layout);

		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		bodyComposite.setBackground(Display.getCurrent().getSystemColor(
				SWT.COLOR_WHITE));
		bodyComposite.setLayoutData(gridData);
		mainComposite.setSize(mainComposite.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		mainComposite.layout();
	}

	private void addListener(final BaseConfMLWidget textBox) {
		textBox.addListener(new TextBoxListener(textBox));
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
		fireSelectionChanged(new SelectionChangedEvent(FeatureViewer.this,
				selection));
	}

	public void fireValueChanged(String newValue, Object element) {
		
		IContentProvider contentProvider = getContentProvider();
		IValuesContentProvider valuesContentProvider = (IValuesContentProvider) contentProvider;
		String value = valuesContentProvider.getValue(element);

		if (value == null && newValue == null || newValue != null
				&& newValue.equals("") && value == null || value != null
				&& value.equals("") && newValue == null) {
			return;
		}
		if (newValue != null && value != null && newValue.equals(value)) {
			refresh(element);
			return;
		}
		valuesContentProvider.valueChanged(newValue, element);
		if (valuesContentProvider.isDefault(element)) {
			setDefault(element, true);
		} else {
			setDefault(element, false);
		}
		
		if (element instanceof ESetting)
		{
			EList<ESetting> changedSettings = new BasicEList<ESetting>();
			changedSettings.add((ESetting)element);
			boolean change = SettingEvaluator.reevaluateRelevantForSettings((View)CrmlBuilder.getView(), changedSettings);
			if (change)
				//internalRefresh((ESetting)element);
				relevantChange();
		}
	
	}

	public void relevantChange()
	{
		System.out.println("relevantChange");
		Set<Object> keys = elementToWidgetMap.keySet();
		for (Iterator<Object> iterator = keys.iterator(); iterator.hasNext();) {
			Object key = iterator.next();
			Composite composite = elementToWidgetMap.get(key);
			if (composite instanceof BaseConfMLWidget)
			{
				BaseConfMLWidget bw = (BaseConfMLWidget)composite;
				bw.setGrayed(!bw.isEditable());
				if (key instanceof ESetting)
				{
					ESetting setting = (ESetting)key;
					
					updateOptions(setting, bw);
				}
				else if (key instanceof ESimpleValue)
				{
					ESimpleValue sVal = (ESimpleValue)key;
					updateOptions(sVal.getType(), bw);
				}
				else if (key instanceof EResourceValue)
				{
					EResourceValue rVal = (EResourceValue)key;
					updateOptions(rVal.getType(), bw);
				}
				else if (key instanceof ESequenceValueItem)
				{
//					ESequenceValueItem sValItem = (ESequenceValueItem)key;
//					EObject container = sValItem.eContainer();
					System.out.println("*** UNIMPLEMENTED ESequenceValueItem TYPE in relevantChange ***");
					//sequence item widget can be ignored?
				}
				else if (key instanceof ESequenceValue)
				{
					ESequenceValue sVal = (ESequenceValue)key;
					if (sVal.getType()!=null) //else == extensiopn policy widget
					{
						updateOptions(sVal.getType(), bw);
					}
				}
				else
				{
					System.out.println("*** UNIMPLEMENTED TYPE in relevantChange ***");
				}
			}
		}
	}
	
	private void updateOptions(ESetting setting, BaseConfMLWidget widget)
	{
		IBaseLabelProvider baseLabelProvider = getLabelProvider();
		ILabelProvider labelProvider = (ILabelProvider) baseLabelProvider;
		if (labelProvider instanceof ISettingsLabelProvider) {
			ISettingsLabelProvider settingsLabelProvider = (ISettingsLabelProvider) labelProvider;
			WidgetOptions options = settingsLabelProvider.getOptions(setting);
			widget.setOptions(options);
			widget.refreshOptions();
		}
	}
	
	
//	private void handleDirty(Object element) {
//		IContentProvider contentProvider = getContentProvider();
//		if (contentProvider instanceof IValuesContentProvider) {
//			IValuesContentProvider provider = (IValuesContentProvider) contentProvider;
//			if (provider.isDirty(element)) {
//				setDirty(element, true);
//			} else {
//				setDirty(element, false);
//			}
//		}
//
//	}
//
//	private void handleDefault(Object element) {
//		IContentProvider contentProvider = getContentProvider();
//		if (contentProvider instanceof IValuesContentProvider) {
//			IValuesContentProvider provider = (IValuesContentProvider) contentProvider;
//			if (provider.isDefault(element)) {
//				setDefault(element, true);
//			} else {
//				setDefault(element, false);
//			}
//		}
//	}


	private void setDefault(Object element, boolean b) {
		// call setDirty on baseconfmlwidget
		Widget widget = doFindItem(element);
		if (widget instanceof BaseConfMLWidget) {
			BaseConfMLWidget confMLWidget = (BaseConfMLWidget) widget;
			confMLWidget.setDefaultMark(b);
		}
	}

//	private void setDirty(Object element, boolean dirty) {
//		Composite composite = elementToWidgetMap.get(element);
//		if (dirty) {
//			if (composite instanceof BaseConfMLWidget) {
//				BaseConfMLWidget w = (BaseConfMLWidget) composite;
//				w.setDirty(true);
//			}
//		} else {
//			if (composite instanceof BaseConfMLWidget) {
//				BaseConfMLWidget w = (BaseConfMLWidget) composite;
//				w.setDirty(false);
//			}
//		}
//	}

	private void add2SqWidgetListener(BaseConfMLWidget widget) {
		for (SequenceControlListener listener : sequenceWidgetListeners) {
			listener.addWidget(widget);
		}

	}

	private Composite createSequenceWidget(Composite parent, int style,
			Object parentElement, ISettingsLabelProvider settingsLabelProvider,
			final IValuesContentProvider valuesContentProvider) {
		String text = settingsLabelProvider.getText(parentElement);
		if (text == null) {
			text = "";
		}
		final SequenceWidget sWidget = new SequenceWidget(parent, style, text);
		sWidget.addExpandListener(new Listener() {

			public void handleEvent(Event event) {
				//computeAllErrorsLocation(valuesContentProvider);
			}

		});
		initializeWidget(valuesContentProvider, parentElement, sWidget);
		add2SqWidgetListener(sWidget);

		final ExtensionPolicyWidget extensionWidget = new ExtensionPolicyWidget(sWidget, style, "<Extension Policy>", null);
		extensionWidget.setViever(this);
		ESequenceSettingImpl seqSetImpl = null;
		if (parentElement instanceof ESequenceSettingImpl)
			seqSetImpl = (ESequenceSettingImpl)parentElement;
		else if (parentElement instanceof EResourceValue)
		{
			EResourceValue resVal = (EResourceValue)parentElement;
			seqSetImpl = (ESequenceSettingImpl)resVal.eContainer();
		}
		initializeWidget(valuesContentProvider, seqSetImpl.getValue(), extensionWidget);
		add2SqWidgetListener(extensionWidget);
		if (!extensionWidget.isEnabled())
		{
			extensionWidget.setGrayed(true);
		}
		
		Object[] children = valuesContentProvider.getChildren(parentElement);
		if (children != null) {
			for (int i = 0; i < children.length; i++) {
				final SequenceWidgetItem sqItem = new SequenceWidgetItem(
						sWidget, style);
				Object child = children[i];
				elementToWidgetMap.put(child, sqItem);
				
				sqItem.setData(child);
				createSequenceWidget(sqItem, child,
						settingsLabelProvider, valuesContentProvider, PluginImages.CLEAR);

				addListener(sqItem);
				//sqItem.setRuler(rulerControl);
				SequenceControlListener listener = new SequenceControlListener();
				sqItem.addExpandListener(listener);

				sequenceWidgetListeners.add(listener);
			}
		}
		SequenceControlListener listener = null;
		listener = new SequenceControlListener();
		sWidget.addExpandListener(listener);
		sequenceWidgetListeners.add(listener);
		return sWidget;
	}

	private void createSequenceWidget(Composite settingComposite,
			Object parentElement, ILabelProvider labelProvider,
			final IValuesContentProvider valuesContentProvider, Image image) {

		//create dummy label widget

		Object[] children = valuesContentProvider.getChildren(parentElement);
		ESequenceValueItem seqValItem = (ESequenceValueItem)parentElement;
		ESequenceValue seqVal = (ESequenceValue)seqValItem.eContainer();
		ESequenceSetting ss = (ESequenceSetting)seqValItem.eContainer().eContainer();
		String absRef = ((ESequenceSettingImpl)seqVal.eContainer()).getAbsRef();
		String headerTitle = "";
		int m = children.length;
		if (ss.getVisibleSubSettings().size()>0)
			m = Math.min(ss.getVisibleSubSettings().size(), children.length);
		for (int i = 0; i < m; i++) {
			Object child = children[i];
			if (ss.getVisibleSubSettings().size()>0)
			{
				String ref = ss.getVisibleSubSettings().get(i);
				for (int j = 0 ; j < children.length ; j++)
				{
					ESettingValue sv = (ESettingValue)children[j];
					if (sv.getRef().equals(ref))
					{
						child = children[j];
					}
				}
			}
			
			String labelText = "      "+labelProvider.getText(child);
			Composite textBox = null;

			if (i==0)
			{
				headerTitle = "";
				if (seqVal != null && seqVal.getTemplate() != null && seqVal.getTemplate().equals(seqValItem))
				{
					headerTitle = "Template";
				}
				else
				{
					for (int j = 0 ; j < seqVal.getItems().size() ; j++)
					{
						if (seqVal.getItems().get(j).equals(seqValItem))
						{
							String file = seqVal.getItems().get(j).getFrameLocationUri().lastSegment();
							headerTitle = "Sequence "+(j+1)+"  ("+file+")";
							break;
						}
					}
				}

				textBox = new DummySeqHeader(settingComposite, SWT.BOLD,
						headerTitle);

				shiftWidget(i, textBox);
				initializeWidget(valuesContentProvider, seqValItem, textBox);
				add2SqWidgetListener((BaseConfMLWidget) textBox);
			}

			if (labelProvider instanceof ISettingsLabelProvider) {
				ISettingsLabelProvider settingsLabelProvider = (ISettingsLabelProvider) labelProvider;
				UISettingType type = settingsLabelProvider.getType(child);
				if (type.equals(UISettingType.INT)) {
					textBox = new IntegerTextBox(settingComposite, SWT.NONE,
							labelText, settingsLabelProvider.getOptions(child),image);
				}
				else if (type.equals(UISettingType.SELECTION)) {
					textBox = new SelectionComboBox(settingComposite, SWT.NONE,
							labelText, settingsLabelProvider.getOptions(child),
							image);
				}
				else if (type.equals(UISettingType.MULTISELECTION)) {
					textBox = new MultiSelectionWidget(settingComposite, SWT.NONE,
							labelText, settingsLabelProvider.getOptions(child), image);
				}
				else if (type.equals(UISettingType.BOOLEAN)) {
					textBox = new BooleanCheckBox(settingComposite, SWT.NONE,
							labelText, settingsLabelProvider.getOptions(child),image);
				}

				else if (type.equals(UISettingType.STRING)) {
					textBox = new StringTextBox(settingComposite, SWT.NONE,
							labelText, settingsLabelProvider.getOptions(child),image);
				}
				
				else if (type.equals(UISettingType.REAL)) { 
					textBox = new RealTextBox(settingComposite, SWT.NONE,labelText, settingsLabelProvider.getOptions(child),image);
				}

				
				
				//				if (type.equals(UISettingType.FILE)) {
				//					Object[] fileValues = valuesContentProvider
				//							.getChildren(child);
				//
				//					textBox = new FileTextBox(settingComposite, SWT.NONE,
				//							labelText, image);
				//
				//					// FileTextBox fileTextBox = (FileTextBox) textBox;
				//
				//					DropTargetListener adapter = valuesContentProvider
				//							.getDropTargetListener(child);
				//					((BaseConfMLWidget) textBox).addDropListener(adapter);
				//					// DropTarget dropTarget = new DropTarget(textBox, ops
				//					// | DND.DROP_DEFAULT);
				//					// dropTarget.setTransfer(transfers);
				//					// dropTarget.addDropListener(adapter);
				//					shiftWidget(i, textBox);
				//					initializeWidget(valuesContentProvider, fileValues[0],
				//							textBox);
				//					add2SqWidgetListener((BaseConfMLWidget) textBox);
				//
				//					textBox = new StringTextBox(settingComposite, SWT.NONE,
				//							"Location in Phone", PluginImages.FILE);
				//					add2SqWidgetListener((BaseConfMLWidget) textBox);
				//					shiftWidget(i, textBox);
				//					initializeWidget(valuesContentProvider, fileValues[1],
				//							textBox);
				//					continue;
				//				}
				//				if (type.equals(UISettingType.SIMPLE_FILE)) {
				//					textBox = createSourcePathWidget(child,
				//							valuesContentProvider, image, settingComposite,
				//							labelText, child);
				//					DropTargetListener adapter = valuesContentProvider
				//							.getDropTargetListener(child);
				//					((BaseConfMLWidget) textBox).addDropListener(adapter);
				//				}
				else if (type.equals(UISettingType.SEQUENCE)) {
					textBox = createSequenceWidget(settingComposite,
							SWT.BORDER, child, settingsLabelProvider,
							valuesContentProvider);
				}
				
				else if (type.equals(UISettingType.FOLDER)) 
				{
					textBox = new FolderTextBox(settingComposite,SWT.NONE,labelText, settingsLabelProvider.getOptions(child),image);
				}
				
				else if (type.equals(UISettingType.FILE)) 
				{
					textBox = new FileTextBox(settingComposite,SWT.NONE,labelText, settingsLabelProvider.getOptions(child),image);
				}
				else if (type.equals(UISettingType.DATE)) {
					textBox = new DateWidget(settingComposite, SWT.NONE,
							labelText, settingsLabelProvider.getOptions(child),image);
				}
				else if (type.equals(UISettingType.TIME)) {
					textBox = new TimeWidget(settingComposite, SWT.NONE,
							labelText, settingsLabelProvider.getOptions(child),image);
				}
				else if (type.equals(UISettingType.DATETIME)) {
					textBox = new DateTimeWidget(settingComposite, SWT.NONE,
							labelText, settingsLabelProvider.getOptions(child),image);
				}
				else if (type.equals(UISettingType.DURATION)) {
					textBox = new DurationWidget(settingComposite, SWT.NONE,
							labelText, settingsLabelProvider.getOptions(child),image);
				}
				
			}
			if (textBox == null) {
				textBox = new IntegerTextBox(settingComposite, SWT.NONE,
						labelText, null,image);
			}
			shiftWidget(i+1, textBox);
			initializeWidget(valuesContentProvider, child, textBox);
			ESettingValueImpl sv = (ESettingValueImpl)child;
			URI uri = seqValItem.getFrameLocationUri();
			if (uri!=null)
			{
				String frameUri = uri.toPlatformString(true);
				String fragment = uri.fragment();
				String subRef = sv.getRef();
				refToWidgetMap.put(absRef+"/"+subRef+":"+frameUri+"#"+fragment, textBox);
			}
			if (headerTitle.equals("Template"))
			{
				String subRef = sv.getRef();
				refToWidgetMap.put(absRef+"/"+subRef, textBox);
			}
			add2SqWidgetListener((BaseConfMLWidget) textBox);
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


	public void dispose() {

		Set<Entry<Object, Composite>> s = elementToWidgetMap.entrySet();
		Iterator<Entry<Object, Composite>> iter = s.iterator();
		while (iter.hasNext())
		{
			Entry<Object, Composite> entry = iter.next();
			if (!entry.getValue().isDisposed())
				entry.getValue().dispose();
		}
		
		Set<Entry<String, Composite>> set = refToWidgetMap.entrySet();
		Iterator<Entry<String, Composite>> iter2 = set.iterator();
		while (iter2.hasNext())
		{
			Entry<String, Composite> entry = iter2.next();
			if (!entry.getValue().isDisposed())
				entry.getValue().dispose();
		}
		
		
		
		elementToWidgetMap.clear();
		elementToWidgetMap = null;
		refToWidgetMap.clear();
		refToWidgetMap = null;
		//		if (rulerControl != null) {
		//			rulerControl.dispose();
		//		}
		if (mainComposite != null) {
			mainComposite.dispose();
		}

		if (bodyComposite != null) {
			bodyComposite.dispose();
		}
		if (scrolledComposite != null) {
			scrolledComposite.dispose();
		}
		if (featureGroupComposite != null) {
			featureGroupComposite.dispose();
		}
		
		for (int i = 0 ; i < sequenceWidgetListeners.size() ; i++)
		{
			SequenceControlListener scl = sequenceWidgetListeners.get(i);
			scl.dispose();
		}
		sequenceWidgetListeners.clear();
		sequenceWidgetListeners = null;
	}
	
	

	public class SequenceControlListener implements Listener {

		Set<BaseConfMLWidget> widgets = new LinkedHashSet<BaseConfMLWidget>();
		int initSize = 0;

		public void handleEvent(Event e) {
			// move all EDN widgets
			HeightChangeEvent event = (HeightChangeEvent) e;
			int yOffset = event.getOffset();
			//			BaseConfMLWidget widgetNotChanged = event.getSource();
			BaseConfMLWidget[] array = widgets.toArray(new BaseConfMLWidget[widgets
			                                                                .size()]);
			if (array.length == 0) {
				return;
			}
			//			boolean relocate = false;
			//			if (widgetNotChanged == null) {
			//				relocate = true;
			//			}

			for (int i = 0; i < array.length; i++) {
				BaseConfMLWidget widget = array[i];
				//				if (!relocate) {
				//					if (widgetNotChanged != widget) {
				//						continue;
				//					} else {
				//						relocate = true;
				//						continue;
				//					}
				//				}
				Composite comp = widget.getDirtyComposite();
				Point location = null;
				if (comp != null) {
					location = comp.getLocation();
					location.y = location.y - yOffset;
					comp.setLocation(location);
					// }
				}
				comp = widget.getErrorComposite();
				if (comp != null) {
					if (location == null) {
						location = comp.getLocation();
						location.y = location.y - yOffset;
					}
					comp.setLocation(location);
				}
				comp = widget.getNoteComposite();
				if (comp != null) {
					if (location == null) {
						location = comp.getLocation();
						location.y = location.y + yOffset;
					}
					comp.setLocation(location);
				}
			}
		}

		public void addWidget(BaseConfMLWidget widget) {
			widgets.add(widget);
		}
		
		public void dispose()
		{
			Iterator<BaseConfMLWidget> iter = widgets.iterator();
			while (iter.hasNext())
			{
				BaseConfMLWidget entry = iter.next();
				if (!entry.isDisposed())
					entry.dispose();
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
				if (sequenceWidget.isCollapsed()) {
					list.add(object);
				}
				Set<SequenceWidgetItem> children = sequenceWidget
				.getPlacedSequences();
				for (SequenceWidgetItem sequenceWidgetChild : children) {

					if (sequenceWidgetChild.isCollapsed()) {
						Object data = sequenceWidgetChild.getData();
						list.add(data);
					}
				}
			}
		}
		return list;
	}
	/*
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
	 */

	public void setCollapsedElements(List<Object> newCollapsedElementsList) {
		Composite c = null;
		for (Object object : newCollapsedElementsList) {
			Composite composite = elementToWidgetMap.get(object);
			if (composite instanceof SequenceWidget) {

				((SequenceWidget) composite).setCollapsed(true);
				composite.layout(true, true);
				c = composite;
			} else if (composite != null) {

				Composite parent = composite.getParent();
				if (parent instanceof SequenceWidgetItem) {

					((SequenceWidgetItem) parent).setCollapsed(true);
					parent.layout(true, true);
					c = parent;
				}

			}
		}

		while (c != null) {
			c = c.getParent();
			if (c instanceof ScrolledComposite) {
				c.layout(true, true);
				break;
			}
		}
	}


	/**
	 * Event listener class for all BaseConfML widgets
	 *
	 */
	class TextBoxListener implements Listener {
		private BaseConfMLWidget textBox;

		public TextBoxListener(BaseConfMLWidget textBox) {
			this.textBox = textBox;
		}

		public void handleEvent(Event event) {

			
			switch (event.type) {

			case SWT.Modify:
				
				if (/*
						 * textBox instanceof FileTextBox ||
						 */textBox instanceof DateWidget
							|| textBox instanceof TimeWidget
							|| textBox instanceof DateTimeWidget
							|| textBox instanceof DurationWidget) {
						String value4 = textBox.getValue();
						Object data4 = textBox.getData();
						fireValueChanged(value4, data4);

					}
					else 
					{
						String value = textBox.getValue();
						Object data = textBox.getData();
						fireValueChanged(value, data);
					}
					break;

			case SWT.MouseDown:
				//textBox.setFocus();
				Set<Object> keys = elementToWidgetMap.keySet();
				for (Iterator<Object> iterator = keys.iterator(); iterator.hasNext();) {
					Object key = iterator.next();
					Composite composite = elementToWidgetMap.get(key);
					composite.setBackground(GUIConstants.COLOR_WHITE);
				}
				textBox.setBackground(GUIConstants.COLOR_LIGHT_BLUE);
				clearSelection();
				textBox.select();
				
				// display context menu
				//createContextMenu(event);
				// display context menu
				fireSelection(textBox);
				createContextMenu(event);
				break;

			case SWT.FocusIn:
				if (textBox instanceof SelectionComboBox)
					clearSelection();
				break;
				
			case SWT.Selection:
				textBox.select();
				fireSelection(textBox);

				String value1 = textBox.getValue();
				Object data1 = textBox.getData();
				fireValueChanged(value1, data1);
				break;
			}
		}
		
		private void clearSelection() {
			for(Composite comp : elementToWidgetMap.values()){
				BaseConfMLWidget widget = (BaseConfMLWidget) comp;
				widget.deselect();
			}
		}
	}


	public void setSelectionToRef(String ref)
	{
		if (ref==null)
			return;
		if (refToWidgetMap.containsKey(ref))
		{
			internalDeselectAllWidgets();
			BaseConfMLWidget widget = (BaseConfMLWidget)refToWidgetMap.get(ref);
			widget.select();
			SWTUtil.ensureVisible((Control)widget);
			fireSelection(widget);
		}
	}
	
	public void updateWidgetErrors(IMarker[] markers)
	{
		Iterator<Composite> values = refToWidgetMap.values().iterator();
		while (values.hasNext()) {
			Composite next = values.next();
			if (next instanceof BaseConfMLWidget) {
				((BaseConfMLWidget) next).clearMarkers();
			}
		}
		
		for (int i = 0 ; i < markers.length; i++)
		{
			IMarker m = markers[i];
			try 
			{
				Object isCrml = m.getAttribute(IMarker.MARKER);
				if (isCrml!=null)
					continue;
				String ref = (String)m.getAttribute("ref");
				if (ref==null)
					continue;
				if (ref.indexOf("/")!=ref.lastIndexOf("/"))
				{
					//sequence ref
					String objectUri = (String)m.getAttribute("objectUri");
					objectUri = objectUri.substring(0, objectUri.lastIndexOf("/"));
					File file = (File)m.getResource();
					String uri = file.getFullPath().toString();
					
					String customSeqRef = ref+":"+uri+"#"+objectUri;
					
					if (refToWidgetMap.containsKey(customSeqRef))
					{
						BaseConfMLWidget widget = (BaseConfMLWidget)refToWidgetMap.get(customSeqRef);
						widget.addMarker(m);
					}
					else if (refToWidgetMap.containsKey(ref))
					{
						BaseConfMLWidget widget = (BaseConfMLWidget)refToWidgetMap.get(ref);
						widget.addMarker(m);
					}
				}
				else
				{
					if (refToWidgetMap.containsKey(ref))
					{
						BaseConfMLWidget widget = (BaseConfMLWidget)refToWidgetMap.get(ref);
						widget.addMarker(m);
					}
				}
				
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
	}
	
}
