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
 * Description: This file is part of com.nokia.tools.vct.common.appmodel component.
 */

package com.nokia.tools.vct.common.appmodel;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;

/**
 * <!-- begin-user-doc --> A representation of the Configuration Project Layer.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.EConfMLLayer#getFeatures <em>Features</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.EConfMLLayer#getViews <em>Views</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.EConfMLLayer#getResourceMap <em>Resource Map</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.EConfMLLayer#getDocumentMap <em>Document Map</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.EConfMLLayer#getImplMap <em>Impl Map</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.EConfMLLayer#getLayerFiles <em>Layer Files</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.EConfMLLayer#getParent <em>Parent</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.EConfMLLayer#getRootConfml <em>Root Confml</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.EConfMLLayer#getLayerURI <em>Layer URI</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.EConfMLLayer#getName <em>Name</em>}</li>
 *   <li>{@link com.nokia.tools.vct.common.appmodel.EConfMLLayer#getIncludes <em>Includes</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEConfMLLayer()
 * @model
 * @generated
 */
public interface EConfMLLayer extends EAppMetadata {
    /**
	 * Returns the value of the '<em><b>Features</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link com.nokia.tools.vct.common.appmodel.EAppFeature},
	 * <!-- begin-user-doc -->
     * <p>
     * Return a list of named features (in a form of {@link EMap}) that belong
     * to this layer and all parent layers.
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Features</em>' map.
	 * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEConfMLLayer_Features()
	 * @model mapType="com.nokia.tools.vct.common.appmodel.EAppFeatureEntry<org.eclipse.emf.ecore.EString, com.nokia.tools.vct.common.appmodel.EAppFeature>"
	 * @generated
	 */
    EMap<String, EAppFeature> getFeatures();

    /**
	 * Returns the value of the '<em><b>Views</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link com.nokia.tools.vct.common.appmodel.EAppView},
	 * <!-- begin-user-doc -->
     * <p>
     * Return a list of named views (in a form of {@link EMap}) that belong to
     * this layer and all parent layers. If the view with the same name occurs
     * multiple times, then the last one overrides view contents.
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Views</em>' map.
	 * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEConfMLLayer_Views()
	 * @model mapType="com.nokia.tools.vct.common.appmodel.EAppViewEntry<org.eclipse.emf.ecore.EString, com.nokia.tools.vct.common.appmodel.EAppView>"
	 * @generated
	 */
    EMap<String, EAppView> getViews();

    /**
	 * Returns the value of the '<em><b>Resource Map</b></em>' map.
	 * The key is of type {@link org.eclipse.emf.common.util.URI},
	 * and the value is of type {@link org.eclipse.emf.common.util.URI},
	 * <!-- begin-user-doc -->
     * <p>
     * Get the resource map for this layer. The resource map contains a map of
     * local path URIs to the project-relative paths for the <em>resource</em>
     * contents.
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Map</em>' map.
	 * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEConfMLLayer_ResourceMap()
	 * @model mapType="com.nokia.tools.vct.common.appmodel.EAppResourceEntry<com.nokia.tools.vct.common.appmodel.Ecore_URI, com.nokia.tools.vct.common.appmodel.Ecore_URI>"
	 * @generated
	 */
    EMap<URI, URI> getResourceMap();

    /**
	 * Returns the value of the '<em><b>Document Map</b></em>' map.
	 * The key is of type {@link org.eclipse.emf.common.util.URI},
	 * and the value is of type {@link org.eclipse.emf.common.util.URI},
	 * <!-- begin-user-doc -->
     * <p>
     * Get the documentation map for this layer. The resource map contains a map
     * of local path URIs to the project-relative paths for the
     * <em>documentation</em> contents.
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Document Map</em>' map.
	 * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEConfMLLayer_DocumentMap()
	 * @model mapType="com.nokia.tools.vct.common.appmodel.EAppResourceEntry<com.nokia.tools.vct.common.appmodel.Ecore_URI, com.nokia.tools.vct.common.appmodel.Ecore_URI>"
	 * @generated
	 */
    EMap<URI, URI> getDocumentMap();

    /**
	 * Returns the value of the '<em><b>Impl Map</b></em>' map.
	 * The key is of type {@link org.eclipse.emf.common.util.URI},
	 * and the value is of type {@link org.eclipse.emf.common.util.URI},
	 * <!-- begin-user-doc -->
     * <p>
     * Get the implementation map for this layer. The resource map contains a
     * map of local path URIs to the project-relative paths for the
     * <em>implementation</em> contents.
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Impl Map</em>' map.
	 * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEConfMLLayer_ImplMap()
	 * @model mapType="com.nokia.tools.vct.common.appmodel.EAppResourceEntry<com.nokia.tools.vct.common.appmodel.Ecore_URI, com.nokia.tools.vct.common.appmodel.Ecore_URI>"
	 * @generated
	 */
    EMap<URI, URI> getImplMap();

    /**
	 * Returns the value of the '<em><b>Layer Files</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.common.util.URI}.
	 * <!-- begin-user-doc -->
     * <p>
     * Get a list of file URIs that logically belong to the given layer. This
     * list contains all URIs inside the layer data structure regardless of the
     * actual use, type or location.
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Layer Files</em>' attribute list.
	 * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEConfMLLayer_LayerFiles()
	 * @model dataType="com.nokia.tools.vct.common.appmodel.Ecore_URI"
	 * @generated
	 */
    EList<URI> getLayerFiles();

    /**
	 * Returns the value of the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
     * <p>
     * Get the parent layer if any.
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' reference.
	 * @see #setParent(EConfMLLayer)
	 * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEConfMLLayer_Parent()
	 * @model
	 * @generated
	 */
    EConfMLLayer getParent();

    /**
     * Sets the value of the '
     * {@link com.nokia.tools.vct.common.appmodel.EConfMLLayer#getParent
     * <em>Parent</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @param value the new value of the '<em>Parent</em>' reference.
     * @see #getParent()
     * @generated
     */
    void setParent(EConfMLLayer value);

    /**
     * Returns the value of the '<em><b>Root Confml</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Root Confml</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Root Confml</em>' attribute.
     * @see #setRootConfml(URI)
     * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEConfMLLayer_RootConfml()
     * @model 
     *        dataType="com.nokia.tools.variant.confml.core.model.core.Ecore_URI"
     *        required="true"
     * @generated
     */
    URI getRootConfml();

    /**
	 * Sets the value of the '{@link com.nokia.tools.vct.common.appmodel.EConfMLLayer#getRootConfml <em>Root Confml</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @param value the new value of the '<em>Root Confml</em>' attribute.
	 * @see #getRootConfml()
	 * @generated
	 */
    void setRootConfml(URI value);

    /**
     * Returns the value of the '<em><b>Layer URI</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Layer URI</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Layer URI</em>' attribute.
     * @see #setLayerURI(URI)
     * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEConfMLLayer_LayerURI()
     * @model 
     *        dataType="com.nokia.tools.variant.confml.core.model.core.Ecore_URI"
     *        required="true"
     * @generated
     */
    URI getLayerURI();

    /**
     * Sets the value of the '
     * {@link com.nokia.tools.vct.common.appmodel.EConfMLLayer#getLayerURI
     * <em>Layer URI</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @param value the new value of the '<em>Layer URI</em>' attribute.
     * @see #getLayerURI()
     * @generated
     */
    void setLayerURI(URI value);

    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEConfMLLayer_Name()
     * @model
     * @generated
     */
    String getName();

    /**
	 * Sets the value of the '{@link com.nokia.tools.vct.common.appmodel.EConfMLLayer#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
    void setName(String value);

    /**
	 * Returns the value of the '<em><b>Includes</b></em>' containment reference list.
	 * The list contents are of type {@link com.nokia.tools.vct.common.appmodel.EAppIncludeElement}.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Includes</em>' containment reference list
     * isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Includes</em>' containment reference list.
	 * @see com.nokia.tools.vct.common.appmodel.EApplicationPackage#getEConfMLLayer_Includes()
	 * @model containment="true"
	 * @generated
	 */
    EList<EAppIncludeElement> getIncludes();

} // EApplicationView
