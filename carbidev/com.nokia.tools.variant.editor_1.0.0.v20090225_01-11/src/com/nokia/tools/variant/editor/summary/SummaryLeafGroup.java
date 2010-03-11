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
 * Description: This file is part of com.nokia.tools.variant.editor component.
 */

package com.nokia.tools.variant.editor.summary;

import com.nokia.tools.variant.content.confml.impl.LeafGroupImpl;
import com.nokia.tools.variant.views.changesview.ChangesView;
import com.nokia.tools.variant.views.errorview.ErrorsView;
import com.nokia.tools.variant.views.notesview.NotesView;

/**
 * It represents the leaf group of the Summary Page. The attribute of constructor definies
 * the type of leaf group (title, notes, errors, changes)
 * The leaf groups - notes, errors and changes contain ID of respective view page.
 */
public class SummaryLeafGroup extends LeafGroupImpl{
	/**
	 * The type of leaf group
	 */
	public enum TypeGroup{TITLE, NOTES,CHANGES,ERRORS}
	/**
	 * Information about the type of leaf group
	 */
	private TypeGroup typeGroup;
	/**
	 * ID of respective view page
	 */
	private String showedViewId;
	
	
	public SummaryLeafGroup(TypeGroup type){
		super();
		typeGroup=type;
		switch(type){
		    case TITLE:setName("CPF title");break;
			case NOTES:setName("Notes");showedViewId=NotesView.VIEW_ID;break;
			case ERRORS:setName("Errors");showedViewId=ErrorsView.VIEW_ID;break;
			case CHANGES:setName("Changes");showedViewId=ChangesView.VIEW_ID;break;
		}
		
	}

	/**
	 * return ID of view page which belong to respective leaf group
	 * @return
	 */
	public String getShowedViewId(){
		return showedViewId;
	}
	
	/**
	 * set type of leaf group
	 * @param typeGroup
	 */
	public void setTypeGroup(TypeGroup typeGroup) {
		this.typeGroup = typeGroup;
	}


	/**
	 * get type of leaf group 
	 * @return
	 */
	public TypeGroup getTypeGroup() {
		return typeGroup;
	}


}
