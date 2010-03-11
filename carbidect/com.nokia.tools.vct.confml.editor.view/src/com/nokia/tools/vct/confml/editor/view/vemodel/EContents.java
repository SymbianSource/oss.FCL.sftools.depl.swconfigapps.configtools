/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.nokia.tools.vct.confml.editor.view.vemodel;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EContents</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.confml.editor.view.vemodel.EContents#getContents <em>Contents</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EViewEditorPackage#getEContents()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface EContents extends EObject {
	/**
	 * Returns the value of the '<em><b>Contents</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contents</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contents</em>' attribute list.
	 * @see com.nokia.tools.vct.confml.editor.view.vemodel.EViewEditorPackage#getEContents_Contents()
	 * @model dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 * @generated
	 */
	FeatureMap getContents();

} // EContents
