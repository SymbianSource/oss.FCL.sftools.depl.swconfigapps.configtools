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
package mock;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

import IBY.Entry;
import IBY.FileName;
import IBY.SrcPath;
import IBY.TargetPath;

public class EntryMock implements Entry {
	SrcPath src;
	TargetPath target;
	FileName file;
	public FileName getFileName() {
		return file;
	}

	public SrcPath getSource() {
		return src;
	}

	public TargetPath getTarget() {
		return target;
	}

	public void setFileName(FileName value) {
		file=value;
	}

	public void setSource(SrcPath value) {
		src=value;
	}

	public void setTarget(TargetPath value) {
		target=value;
	}

	public TreeIterator<EObject> eAllContents() {
		return null;
	}

	public EClass eClass() {
		return null;
	}

	public EObject eContainer() {
		return null;
	}

	public EStructuralFeature eContainingFeature() {
		return null;
	}

	public EReference eContainmentFeature() {
		return null;
	}

	public EList<EObject> eContents() {
		return null;
	}

	public EList<EObject> eCrossReferences() {
		return null;
	}

	public Object eGet(EStructuralFeature feature) {
		return null;
	}

	public Object eGet(EStructuralFeature feature, boolean resolve) {
		return null;
	}

	public boolean eIsProxy() {
		return false;
	}

	public boolean eIsSet(EStructuralFeature feature) {
		return false;
	}

	public Resource eResource() {
		return null;
	}

	public void eSet(EStructuralFeature feature, Object newValue) {
	}

	public void eUnset(EStructuralFeature feature) {
	}

	public EList<Adapter> eAdapters() {
		return null;
	}

	public boolean eDeliver() {
		return false;
	}

	public void eNotify(Notification notification) {
	}

	public void eSetDeliver(boolean deliver) {

	}

}
