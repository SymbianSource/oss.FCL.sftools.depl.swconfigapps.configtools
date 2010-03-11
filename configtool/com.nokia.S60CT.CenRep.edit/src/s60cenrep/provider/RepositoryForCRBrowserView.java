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
package s60cenrep.provider;

import java.util.Collection;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.domain.EditingDomain;

import cenrep.CenrepFactory;
import cenrep.CenrepPackage;
import cenrep.Repository;
import cenrep.provider.RepositoryItemProvider;

public class RepositoryForCRBrowserView extends RepositoryItemProvider {

	public RepositoryForCRBrowserView(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	public Collection getChildrenFeatures(Object object) {
		super.getChildrenFeatures(object);
		return childrenFeatures;
	}

	public String getText(Object object) {
		String label = ((Repository) object).getUidName();
		//return label == null || label.length() == 0 ? getString("_UI_No_Name")
				return label == null || label.length() == 0 ? ""
				: label;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cenrep.provider.RepositoryItemProvider#getImage(java.lang.Object)
	 */
	public Object getImage(Object object) {
		return super.getImage(object);
	}

	@Override
	public Command createCommand(Object object, EditingDomain domain,
			Class<? extends Command> commandClass,
			CommandParameter commandParameter) {
		if (commandClass.equals(AddCommand.class)) {
			EStructuralFeature feature = commandParameter
					.getEStructuralFeature();
			if (feature.equals(CenrepPackage.eINSTANCE
					.getRepository_BitmaskKeys())) {
				return new AddCommand(domain, commandParameter.getEOwner(),
						CenrepPackage.eINSTANCE.getRepository_Key(),
						CenrepFactory.eINSTANCE.createBitmask());
			} else if (feature.equals(CenrepPackage.eINSTANCE
					.getRepository_SimpleKeys())) {
				return new AddCommand(domain, commandParameter.getEOwner(),
						CenrepPackage.eINSTANCE.getRepository_Key(),
						CenrepFactory.eINSTANCE.createKey());
			} else if (feature.equals(CenrepPackage.eINSTANCE
					.getRepository_RangeKey())) {
				return new AddCommand(domain, commandParameter.getEOwner(),
						CenrepPackage.eINSTANCE.getRepository_RangeKey(),
						CenrepFactory.eINSTANCE.createKeyRange());
			}
		}
		return super.createCommand(object, domain, commandClass,
				commandParameter);
	}
	
	
}
