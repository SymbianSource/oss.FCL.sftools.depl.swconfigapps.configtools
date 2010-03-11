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
package s60ct.provider;

import interfaces.CellModifier;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ITableItemLabelProvider;
import org.eclipse.emf.edit.provider.ViewerNotification;

import configurationemf.ConfigurationemfFactory;
import configurationemf.ConfigurationemfPackage;
import configurationemf.ICellEditorProvider;
import configurationemf.IPVContentProvider;
import configurationemf.LeafSettingDelegator;
import configurationemf.Option;
import configurationemf.ParentSetting;
import configurationemf.Project;
import configurationemf.Setting;
import configurationemf.TYPE;
import configurationemf.impl.ParentSettingImpl;
import configurationemf.provider.ParentSettingItemProvider;
import configurationemf.provider.SettingItemProvider;

public class ParentSettingForFeatureView extends ParentSettingItemProvider 
	implements 
	ITableItemLabelProvider, 
	IPVContentProvider,
	CellModifier,
	ICellEditorProvider{
	
	//properties for the column
	public static final String PROP_NAME = "name";
	public static final String PROP_TYPE = "type";
	public static final String PROP_VALUE = "cvalue";
	public static final String PROP_DEF="def";
	public static final String PROP_FEATURE="fea";
	public static final String PROP_REF ="ref";
	public static final String PROP_CONSTRAINT ="constraint";
	public static final String PROP_RELEVANCY="relevancy";
	public static final String PROP_REQUIRED="required";
	public static final String PROP_READONLY="ro";
	
	private static final EStructuralFeature[] NOT_4_PROPERY_VIEW = new EStructuralFeature[]{
		ConfigurationemfPackage.Literals.ATTRIBUTE_AND_DESC__DESC,
		ConfigurationemfPackage.Literals.REFERABLE__REF,
		ConfigurationemfPackage.Literals.SETTING__CONSTRAINT,
		ConfigurationemfPackage.Literals.SETTING__NAME,
		ConfigurationemfPackage.Literals.SETTING__BOOL_OPTIONS,
		ConfigurationemfPackage.Literals.SETTING__ICON,
		ConfigurationemfPackage.Literals.SETTING__CURRENT_CONF,
		ConfigurationemfPackage.Literals.SETTING__CURRENT_TYPE,
		ConfigurationemfPackage.Literals.SETTING__CURRENT_VALUE,
		ConfigurationemfPackage.Literals.SETTING__DEFAULT_CONF,
		ConfigurationemfPackage.Literals.SETTING__DEFAULT_VALUE,
		ConfigurationemfPackage.Literals.SETTING__LENGTH,
		ConfigurationemfPackage.Literals.SETTING__MAX_EXCLUSIVE,
		ConfigurationemfPackage.Literals.SETTING__MIN_INCLUSIVE,
		ConfigurationemfPackage.Literals.SETTING__MIN_LENGTH,
		ConfigurationemfPackage.Literals.SETTING__OPTION,
		ConfigurationemfPackage.Literals.SETTING__PATTERN,
		ConfigurationemfPackage.Literals.SETTING__POSSIBLE_VALUE,
		ConfigurationemfPackage.Literals.SETTING__PROPERTY,
		ConfigurationemfPackage.Literals.SETTING__READ_ONLY,
		ConfigurationemfPackage.Literals.SETTING__RELEVANT,
		ConfigurationemfPackage.Literals.SETTING__REQUIRED,
		ConfigurationemfPackage.Literals.SETTING__RO,
		ConfigurationemfPackage.Literals.SETTING__TOP_VALUE,
		ConfigurationemfPackage.Literals.SETTING__TOTAL_DIGITS,
		ConfigurationemfPackage.Literals.SETTING__TYPE,
		ConfigurationemfPackage.Literals.SETTING__VALUE_CHANGEBLE,
		ConfigurationemfPackage.Literals.PARENT_SETTING__CURRENT_EXTENSION_POLICY,
		ConfigurationemfPackage.Literals.PARENT_SETTING__FRAMES,
		ConfigurationemfPackage.Literals.PARENT_SETTING__LEAF_SETTING,
		ConfigurationemfPackage.Literals.PARENT_SETTING__MAX_OCCURS,
		ConfigurationemfPackage.Literals.PARENT_SETTING__MIN_OCCURS,
		ConfigurationemfPackage.Literals.PARENT_SETTING__TEMPLATE
	};
	
	private static final Object[][] PROP_ATTRIBUTE = new Object[][]{
		new Object[]{PROP_NAME,SETTING_NAME,ConfigurationemfPackage.eINSTANCE.getSetting_Name()},
		new Object[]{PROP_TYPE,SETTING_TYPE,ConfigurationemfPackage.eINSTANCE.getSetting_CurrentType()},
		new Object[]{PROP_VALUE,SETTING_VALUE,ConfigurationemfPackage.eINSTANCE.getSetting_CurrentValue()},
		new Object[]{PROP_DEF,SETTING_DEFAULT_VALUE,ConfigurationemfPackage.eINSTANCE.getSetting_DefaultValue()},
		new Object[]{PROP_REF,SETTING_REF,ConfigurationemfPackage.eINSTANCE.getReferable_Ref()},
		new Object[]{PROP_CONSTRAINT,SETTING_CONSTRAINT,ConfigurationemfPackage.eINSTANCE.getSetting_Constraint()},
		new Object[]{PROP_RELEVANCY,SETTING_RELEVANT,ConfigurationemfPackage.eINSTANCE.getSetting_Relevant()},
		new Object[]{PROP_REQUIRED,SETTING_REQUIRED,ConfigurationemfPackage.eINSTANCE.getSetting_Required()},
		new Object[]{PROP_READONLY,SETTING_READ_ONLY,ConfigurationemfPackage.eINSTANCE.getSetting_ReadOnly()}
		
	};
	private static final int PROP_NAME_INDEX=0;
	private static final int PROP_COLUMN_INDEX=1;
	private static final int PROP_ATTR_INDEX=2;
	
	private final static EAttribute RO_ATTRIBUTE = ConfigurationemfPackage.eINSTANCE.getSetting_Ro();
	
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			childrenFeatures = new ArrayList<EStructuralFeature>();
			childrenFeatures.add(ConfigurationemfPackage.Literals.PARENT_SETTING__TEMPLATE);
			childrenFeatures.add(ConfigurationemfPackage.Literals.PARENT_SETTING__FRAMES);
		}
		return childrenFeatures;
	}
	
	public String getText(Object object) {
		return super.getText(object);
	}
	public ParentSettingForFeatureView(AdapterFactory adapterFactory){
		super(adapterFactory);
	}

	protected Object getZeroObject(){
		return Project.ZERO_PSETTING;
	}
	public Object getColumnImage(Object object, int columnIndex) {
		if(object.equals(getZeroObject()))return null;
		switch (columnIndex){
		case 0:
			return getImage(object);
		}
		return null;
	}

	public String getColumnText(Object object, int columnIndex) {
		if(object.equals(getZeroObject())){
			if(columnIndex==0)
				return "     <Add new setting>";
			else return "";
		}
		EObject setting = (EObject)object;
		Object result=null;
		switch(columnIndex){
		case SettingItemProvider.SETTING_NAME://setting's name 
			result = setting.eGet(ConfigurationemfPackage.eINSTANCE.getSetting_Name());
			if(result==null)result="(no name)";
			break;
		case SettingItemProvider.SETTING_TYPE://setting's type
			result = setting.eGet(ConfigurationemfPackage.eINSTANCE.getSetting_CurrentType());
			break;
		case SettingItemProvider.SETTING_DEFAULT_VALUE:
			result = getUserValue(setting,(String)setting.eGet(ConfigurationemfPackage.eINSTANCE.getSetting_DefaultValue()));
			if(result!=null && result.equals("") && object instanceof ParentSetting){
				ParentSetting pr=(ParentSetting)object;
				if(pr.getType()==TYPE.STRING){
					result="\"\"";
				}
			}
			break;
		case SettingItemProvider.SETTING_VALUE:
			result = getUserValue(setting,(String)setting.eGet(ConfigurationemfPackage.eINSTANCE.getSetting_TopValue()));
			if(result!=null && result.equals("") && object instanceof ParentSetting){
				ParentSetting pr=(ParentSetting)object;
				if(pr.getType()==TYPE.STRING){
					result="\"\"";
				}
			}
			break;
		case SettingItemProvider.SETTING_REF:
			result = setting.eGet(ConfigurationemfPackage.eINSTANCE.getReferable_Ref());
			break;
		case SettingItemProvider.SETTING_READ_ONLY:
			result = setting.eGet(ConfigurationemfPackage.eINSTANCE.getSetting_ReadOnly());
			result=!((Boolean)result);
			break;
		case SettingItemProvider.SETTING_CONSTRAINT:
			result = setting.eGet(ConfigurationemfPackage.eINSTANCE.getSetting_Constraint());
			break;
		case SettingItemProvider.SETTING_RELEVANT:
			result = setting.eGet(ConfigurationemfPackage.eINSTANCE.getSetting_Relevant());
			break;
		case SettingItemProvider.SETTING_REQUIRED:
			result = setting.eGet(ConfigurationemfPackage.eINSTANCE.getSetting_Required());
			break;
		case SettingItemProvider.SETTING_FEATURE:
			result = "";
			break;
		default:
			result = "";
		}
		return result==null?"":String.valueOf(result);
	}
	
	
	
	

	protected String getUserValue(EObject setting, String systemValue) {
		List<Option> options = (List<Option>)setting.eGet(ConfigurationemfPackage.eINSTANCE.getSetting_Option());
		for(Iterator<Option>iOption=options.iterator();iOption.hasNext();){
			Option op = iOption.next();
			if(op.getValue()!=null&&op.getValue().equals(systemValue))return op.getName();
		}
		options = (List<Option>)setting.eGet(ConfigurationemfPackage.eINSTANCE.getSetting_BoolOptions());
		for(Iterator<Option>iOption=options.iterator();iOption.hasNext();){
			Option op = iOption.next();
			if(op.getValue()!=null&&op.getValue().equals(systemValue))return op.getName();
		}
		return systemValue;
	}
	
	protected String getSystemValue(EObject setting, String userValue) {
		List<Option> options = (List<Option>)setting.eGet(ConfigurationemfPackage.eINSTANCE.getSetting_Option());
		for(Iterator<Option>iOption=options.iterator();iOption.hasNext();){
			Option op = iOption.next();
			if(op.getName()!=null&&op.getName().equals(userValue))return op.getValue();
		}
		options = (List<Option>)setting.eGet(ConfigurationemfPackage.eINSTANCE.getSetting_BoolOptions());
		for(Iterator<Option>iOption=options.iterator();iOption.hasNext();){
			Option op = iOption.next();
			if(op.getName()!=null&&op.getName().equals(userValue))return op.getValue();
		}
		return userValue;
	}
	
	// Possible Values Interface
	public String[] getPossibleValues(Object object) {
		if(object.equals(getZeroObject()))return null;
		EObject setting = (EObject)object;
		List result = new ArrayList();
		 
		List<Option> options = (List<Option>)setting.eGet(ConfigurationemfPackage.eINSTANCE.getSetting_Option());
		for(int i=0;i<options.size();i++){
			Option option = options.get(i);
			result.add(option.getName());
			
		}
		String[] sresult = new String[result.size()];
		for (int i = 0; i < sresult.length; i++)
			sresult[i] = (String)result.get(i);
		
		return sresult;
	}
	
	public Object getValue(Object object) {
		Object value = getColumnText(object, 2);
		String[] possibleValues = getPossibleValues(object);
		int index = -1;
		if(possibleValues.length>0&&value!=null){
			for(index=0;index<possibleValues.length&&!possibleValues[index].equals(value);index++);
		}
		return index>-1 && index<possibleValues.length? Integer.valueOf(index):value;
	}
	
	
	
	public boolean canModify(Object element, String property) {
		if(element.equals(getZeroObject())){
			if(property.compareTo(PROP_NAME)==0)return true;
			else return false;
		}
		if(property.compareTo(PROP_VALUE)==0){
			return (Boolean)((EObject)element).eGet(ConfigurationemfPackage.eINSTANCE.getSetting_ValueChangeble());
		}else{
			return !(Boolean)((EObject)element).eGet(ConfigurationemfPackage.eINSTANCE.getSetting_Ro());
		}
		
	}
	public Object getValue(Object element, String property) {
		if(element.equals(getZeroObject()))return "";
		EAttribute attr=getAttributeByProperty(property);
		EObject setting = (EObject)element;
		Object result = setting.eGet(attr);
		if(property.equals(PROP_VALUE)){
			result=getUserValue(setting,(String)result);
			if(result=="" && element instanceof ParentSetting){
				ParentSetting pr=(ParentSetting)element;
				if(pr.getType()==TYPE.STRING){
					result="\"\"";
				}
				
			}
		}
		else if(property.equals(PROP_READONLY))
			result=String.valueOf(!((Boolean)result));
				
		return result==null?"":result;
	}
	public void modify(Object parent,Object element, String property, Object value) {
		
		if(element.equals(getZeroObject())&&property.compareTo(PROP_NAME)==0){
			if(value!=null&&!((String)value).trim().equals(""))
				addNewObject(parent,element, property, value);
		}else setAttributeValue(element, property, value);
	}

	protected void setAttributeValue(Object element, String property,
			Object value) {
		EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(getConfmlObject(element));
		EAttribute attr = getAttributeByProperty(property);
		Object oldValue = ((EObject)element).eGet(attr);
		Object newValue = value;
		if(property.equals(PROP_TYPE)&&element instanceof ParentSettingImpl){
			ParentSettingImpl setting = (ParentSettingImpl)element;
			if(!oldValue.equals(TYPE.SEQUENCE.getName())&&newValue.equals(TYPE.SEQUENCE.getName()))
				setting.makeTemplateRef();
			else if(oldValue.equals(TYPE.SEQUENCE.getName())&&!newValue.equals(TYPE.SEQUENCE.getName()))
				setting.removeTemplateRef();
		}
		if(property.equals(PROP_READONLY)){
			newValue = !Boolean.valueOf((String)newValue);
		}
		if(oldValue==null||!oldValue.equals(value)){
			Command command = SetCommand.create(domain, element, attr, newValue);
			if(command!=null)
				domain.getCommandStack().execute(command);
		}
	}
	
	
	
	

	protected void addNewObject(Object parent,Object object, String property, Object value){
		EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(getConfmlObject(parent));
		ParentSetting newSetting = ConfigurationemfFactory.eINSTANCE.createParentSetting();
		String sValue = (String)value;
		newSetting.setName(sValue);
		newSetting.setRef(sValue.replaceAll(" ", ""));
		Command command = AddCommand.create(domain, parent, ConfigurationemfPackage.eINSTANCE.getFeature_ParentSetting(), newSetting);
		if(command!=null)
			domain.getCommandStack().execute(command);
	}
	
	//returns object that is storable in confml. Needed to get editingDomain
	protected Object getConfmlObject(Object object){
		return object;
	}
	
	public static EAttribute getAttributeByProperty(String property){
		EAttribute attribute=null;
		for (int i = 0; i < PROP_ATTRIBUTE.length&&attribute==null; i++) {
			String prop = (String)PROP_ATTRIBUTE[i][PROP_NAME_INDEX];
			EAttribute attr = (EAttribute)PROP_ATTRIBUTE[i][PROP_ATTR_INDEX];
			if(property.equals(prop))attribute=attr;
		}
		return attribute;
	}
	
	public Map<String, String> getPairItems(Object element, int column) {
		//ui, to save
		Map<String, String> result= new HashMap<String, String>();
		EObject setting = (EObject)element;
		switch(column){
		case SettingItemProvider.SETTING_TYPE:
			TYPE[] possibleTypes = getPossibleTypes();
			for(int i=0;i<possibleTypes.length;i++){
				if (possibleTypes[i].getValue()!=TYPE.UNDEFINED_VALUE)
					result.put(possibleTypes[i].getLiteral(), possibleTypes[i].getLiteral());
			}
			break;
		case SettingItemProvider.SETTING_VALUE:
			List<String> pv = (List<String>)setting.eGet(ConfigurationemfPackage.eINSTANCE.getSetting_PossibleValue());
			for(Iterator<String>iPV = pv.iterator();iPV.hasNext();){
				String pValue = iPV.next();
				result.put(getUserValue(setting,pValue),getSystemValue(setting,pValue));
			}
			
			if (setting instanceof LeafSettingDelegator) {
				// LeafSettingDelegator cannot be casted to Setting
				if(!(Boolean)((EObject)element).eGet(ConfigurationemfPackage.eINSTANCE.getSetting_Ro()) && ((LeafSettingDelegator)setting).getType().compareTo(TYPE.BOOLEAN)!=0)
					result.put("<add new option>", "<add new option>");
				
			} else {
				if(!(Boolean)((EObject)element).eGet(ConfigurationemfPackage.eINSTANCE.getSetting_Ro()) && ((Setting)setting).getType().compareTo(TYPE.BOOLEAN)!=0)
					result.put("<add new option>", "<add new option>");
			}
			
			break;
		case SettingItemProvider.SETTING_READ_ONLY:
			result.put("true", "true");
			result.put("false","false");
			break;
		}
		return result;
	}

	protected TYPE[] getPossibleTypes(){
		return TYPE.values();
	}
	
	public int getCellEditor(Object element, int column) {
		switch(column){
		case SettingItemProvider.SETTING_FEATURE:
			return ICellEditorProvider.NO_EDITOR;
		case SettingItemProvider.SETTING_NAME:
			return ICellEditorProvider.STRING_TEXT;
		case SettingItemProvider.SETTING_TYPE:
			return ICellEditorProvider.COMBO_RO;
		case SettingItemProvider.SETTING_VALUE:
			return getValueCellEditor(element);
		case SettingItemProvider.SETTING_REF:
			return ICellEditorProvider.STRING_TEXT;
		case SettingItemProvider.SETTING_CONSTRAINT:
			return ICellEditorProvider.BOOLEAN_COMBO;
		case SettingItemProvider.SETTING_RELEVANT:
			return ICellEditorProvider.BOOLEAN_COMBO;
		case SettingItemProvider.SETTING_REQUIRED:
			return ICellEditorProvider.BOOLEAN_COMBO;
		case SettingItemProvider.SETTING_READ_ONLY:
			return ICellEditorProvider.BOOLEAN_COMBO;
		}
		return ICellEditorProvider.NO_EDITOR;
	}
	

	
	private int getValueCellEditor(Object object){
		EObject setting = (EObject)object;
		List<String> pv = (List<String>)setting.eGet(ConfigurationemfPackage.eINSTANCE.getSetting_PossibleValue());
		TYPE type = (TYPE)setting.eGet(ConfigurationemfPackage.eINSTANCE.getSetting_Type());
		switch(type.getValue()){
		case TYPE.INT_VALUE:
			return pv.size()!=0?ICellEditorProvider.COMBO_INT:ICellEditorProvider.INT_TEXT;
		case TYPE.REAL_VALUE:
			return pv.size()!=0?ICellEditorProvider.COMBO_REAL:ICellEditorProvider.REAL_TEXT;
		case TYPE.STRING_VALUE:
			return pv.size()!=0?ICellEditorProvider.COMBO_STRING:ICellEditorProvider.STRING_TEXT;
		case TYPE.BOOLEAN_VALUE:
			return ICellEditorProvider.BOOLEAN_COMBO;
		case TYPE.FILE_VALUE:
			return ICellEditorProvider.FILE_BUTTON;
		case TYPE.FOLDER_VALUE:
			return ICellEditorProvider.FOLDER_BUTTON;
		case TYPE.SEQUENCE_VALUE:
			return ICellEditorProvider.NO_EDITOR;
		case TYPE.SELECTION_VALUE:
			return ICellEditorProvider.COMBO_RO;
		}
		return ICellEditorProvider.NO_EDITOR;
	}
	
	public void notifyChanged(Notification notification) {
		updateChildren(notification);
		switch (notification.getFeatureID(ParentSetting.class)) {
			case ConfigurationemfPackage.PARENT_SETTING__CURRENT_EXTENSION_POLICY:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, true));
				return;
			case ConfigurationemfPackage.PARENT_SETTING__TYPE:
				TYPE oldValue = (TYPE)notification.getOldValue();
				TYPE newValue = (TYPE)notification.getNewValue();
				if(oldValue==TYPE.SEQUENCE||newValue==TYPE.SEQUENCE)
					fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, true));
				else
					fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case ConfigurationemfPackage.PARENT_SETTING__NAME:
				Setting setting = (Setting)notification.getNotifier();
				if(setting.getRef()==null||setting.getRef().trim().equals("")) {
					String newName = notification.getNewStringValue();
					if(newName!=null) {
						setting.setRef(newName.replaceAll(" ", ""));						
					}
				}
				
		}
		super.notifyChanged(notification);
	}

	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);
			List<IItemPropertyDescriptor> notVisibleIP = new ArrayList<IItemPropertyDescriptor>();
			for(IItemPropertyDescriptor itemPropertyDescriptor: itemPropertyDescriptors){
				Object feature = itemPropertyDescriptor.getFeature(object);
				for(EStructuralFeature notInUseFeature : NOT_4_PROPERY_VIEW)
					if(feature.equals(notInUseFeature))notVisibleIP.add(itemPropertyDescriptor);
			}
			itemPropertyDescriptors.removeAll(notVisibleIP);
		}
		
		return itemPropertyDescriptors;
	}
}
