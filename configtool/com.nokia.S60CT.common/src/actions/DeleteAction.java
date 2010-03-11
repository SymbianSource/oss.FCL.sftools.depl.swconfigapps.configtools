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
package actions;

import interfaces.DeleteEObjectSet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import views.OptionView;

public class DeleteAction implements IObjectActionDelegate {
	
	List<EObject> selectedObjects = new ArrayList<EObject>();
	
	private Object[][] RO_FEATURES=null;
	private Object[][] PARENT_FEATURE=null;
	
	public DeleteAction() {
		// Auto-generated constructor stub
	}

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		DeleteEObjectSet deleteEObjectSet = (DeleteEObjectSet)targetPart.getAdapter(DeleteEObjectSet.class);
		if(deleteEObjectSet!=null){
			RO_FEATURES=deleteEObjectSet.getRoFeatures();
			PARENT_FEATURE=deleteEObjectSet.getParentFeature();
		}else{
			RO_FEATURES=null;
			PARENT_FEATURE=null;
		}

	}

	public void run(IAction action) {
		for (Iterator<EObject> iterator = selectedObjects.iterator(); iterator.hasNext();) {
			EObject object = iterator.next();
			EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(object);
			Object[] parentAndFeature = getParentAndFeature(object);
			if(parentAndFeature!=null){	
				Command command = RemoveCommand.create(editingDomain, parentAndFeature[0], 
							parentAndFeature[1], object);
				if(command!=null) editingDomain.getCommandStack().execute(command);
			}
			
			if(PARENT_FEATURE[0][0]==OptionView.class){
				Command command = RemoveCommand.create(editingDomain, object.eContainer(), 
						object.eContainingFeature(), object);
				if(command!=null) editingDomain.getCommandStack().execute(command);
			}
		}
	}
	
	private Object[] getParentAndFeature(EObject object){
		EObject parent = object.eContainer();
		for (int i = 0; i < PARENT_FEATURE.length; i++) {
			Class klass = (Class)PARENT_FEATURE[i][0];
			EReference ref = (EReference)PARENT_FEATURE[i][1];
			if(klass.isInstance(object))
				return new Object[]{parent,ref};
		}
		return null;
	}

	public void selectionChanged(IAction action, ISelection selection) {
		selectedObjects.clear();
		if(selection instanceof IStructuredSelection) {
	           IStructuredSelection structedSelection = (IStructuredSelection)selection;
	           Object[] objects = structedSelection.toArray();
	           selectToBeRemoved(objects);
	    }
		if(!selectedObjects.isEmpty()&&PARENT_FEATURE!=null){
			action.setEnabled(true);
		}
		else action.setEnabled(false);

	}
	
	private void selectToBeRemoved(Object[] objs){
		for (int i = 0; i < objs.length; i++) {
			EObject obj = (EObject)objs[i];
			if(!isParentRO(obj)) selectedObjects.add(obj);
		}
	}
	
	private boolean isParentRO(final EObject object){
		EObject parent=object.eContainer();
//		if(RootConf.class.isInstance(object))parent=((RootConf)object).getRoot();
//		else parent=object.eContainer();
		
		if(parent!=null&&RO_FEATURES!=null){
			for (int i = 0; i < RO_FEATURES.length; i++) {
				Class klass = (Class)RO_FEATURES[i][0];
				EAttribute roAttr = (EAttribute)RO_FEATURES[i][1];
				if(klass.isInstance(object))return (Boolean)object.eGet(roAttr);
			}
		}
		return false;
	}
}
