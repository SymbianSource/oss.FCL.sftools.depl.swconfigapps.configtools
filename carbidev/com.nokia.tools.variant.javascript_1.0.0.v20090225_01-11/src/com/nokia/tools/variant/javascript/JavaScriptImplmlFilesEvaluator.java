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
 * Description: This file is part of com.nokia.tools.variant.javascript component.
 */

package com.nokia.tools.variant.javascript;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

import com.nokia.tools.variant.confml.core.model.application.EAppFeature;
import com.nokia.tools.variant.confml.core.model.application.EAppResourceType;
import com.nokia.tools.variant.confml.core.model.application.EAppSequenceType;
import com.nokia.tools.variant.confml.core.model.application.EAppSetting;
import com.nokia.tools.variant.confml.core.model.application.EAppSettingType;
import com.nokia.tools.variant.confml.core.model.application.EAppSimpleType;
import com.nokia.tools.variant.confml.core.model.application.EConfMLLayer;
import com.nokia.tools.variant.confml.core.model.application.EConfigurationProject;
import com.nokia.tools.variant.javascript.accesslog.AuditLogger;
import com.nokia.tools.variant.javascript.binding.ConfML;
import com.nokia.tools.variant.javascript.binding.Feature;
import com.nokia.tools.variant.javascript.binding.FileSetting;
import com.nokia.tools.variant.javascript.binding.FileSubSetting;
import com.nokia.tools.variant.javascript.binding.SequenceItem;
import com.nokia.tools.variant.javascript.binding.SequenceSetting;
import com.nokia.tools.variant.javascript.binding.SimpleSetting;
import com.nokia.tools.variant.javascript.binding.SimpleSubSetting;
import com.nokia.tools.variant.javascript.jsmodel.EJSDocument;

/**
 * Processes javascript .js implml files when loading CPF into memory. So before
 * build will be invoked, javascript manipulations are done.
 */
public class JavaScriptImplmlFilesEvaluator {

    /** Application model bound to this evaluator */
    private EConfigurationProject project;
    private AuditLogger logger;
    private Context cx;
    private Scriptable scope;

    public JavaScriptImplmlFilesEvaluator(EConfigurationProject project,
            AuditLogger accessLogger) {
        this.project = project;
        this.logger = accessLogger;
        // the JS context population

        try {
            cx = Context.enter();
            scope = cx.initStandardObjects(null);

            ScriptableObject.defineClass(scope, ConfML.class);
            ScriptableObject.defineClass(scope, Feature.class);
            ScriptableObject.defineClass(scope, FileSetting.class);
            ScriptableObject.defineClass(scope, FileSubSetting.class);
            ScriptableObject.defineClass(scope, SequenceItem.class);
            ScriptableObject.defineClass(scope, SequenceSetting.class);
            ScriptableObject.defineClass(scope, SimpleSetting.class);
            ScriptableObject.defineClass(scope, SimpleSubSetting.class);

            createBindedModel(this.project, scope, cx, logger);
        } catch (Throwable t) {
            t.printStackTrace();
        } finally {

        }

    }

    public Object evaluateJavaScript(EJSDocument document) {
        String script = document.getScript();
        String name = document.eResource().getURI().toString();

        return cx.evaluateString(scope, script, name, -1, null);
    }

    public void dispose() {
        // context disposal
        this.project = null;
        this.scope = null;
        this.cx = null;
        this.logger = null;
        Context.exit();
    }

    public static void evaluateJavaScripts(
            EConfigurationProject applicationModel, AuditLogger accessLogger)
            throws FileNotFoundException, IOException, IllegalAccessException,
            InstantiationException, InvocationTargetException {
        ResourceSet resourceSet = applicationModel.eResource().getResourceSet();
        URIConverter converter = resourceSet.getURIConverter();
        Context cx = null;
        try {
            cx = Context.enter();

            Scriptable scope = cx.initStandardObjects(null);

            ScriptableObject.defineClass(scope, ConfML.class);
            ScriptableObject.defineClass(scope, Feature.class);
            ScriptableObject.defineClass(scope, FileSetting.class);
            ScriptableObject.defineClass(scope, FileSubSetting.class);
            ScriptableObject.defineClass(scope, SequenceItem.class);
            ScriptableObject.defineClass(scope, SequenceSetting.class);
            ScriptableObject.defineClass(scope, SimpleSetting.class);
            ScriptableObject.defineClass(scope, SimpleSubSetting.class);

            createBindedModel(applicationModel, scope, cx, accessLogger);

            EConfMLLayer lastLayer = applicationModel.getLastLayer();
            EMap<URI, URI> implMap = lastLayer.getImplMap();
            Collection<URI> scripts = implMap.values();
            for (URI scriptURI : scripts) {
                if (scriptURI.toString().endsWith(".js")) {
                    InputStream inputStream = null;
                    try {
                        inputStream = converter.createInputStream(scriptURI);
                        InputStreamReader isr = new InputStreamReader(
                                inputStream);
                        executeJavaScript(applicationModel, isr, cx, scope,
                                scriptURI.toString());
                    } finally {
                        if (inputStream != null) {
                            inputStream.close();
                        }
                    }
                }
            }
            System.out.println();
        } finally {
            Context.exit();
        }
    }

    private static void createBindedModel(
            EConfigurationProject applicationModel, Scriptable scope,
            Context cx, AuditLogger logger) {
        EConfMLLayer lastLayer = applicationModel.getLastLayer();

        // ConfML root

        Object[] args = {};
        Scriptable ConfML = cx.newObject(scope, "ConfML", args);
        scope.put("ConfML", scope, ConfML);

        EMap<String, EAppFeature> features = lastLayer.getFeatures();
        Set<String> featureRefsSet = features.keySet();
        Iterator<String> featureIterator = featureRefsSet.iterator();
        while (featureIterator.hasNext()) {
            String featureRef = featureIterator.next();

            // acquired feature
            EAppFeature appFeature = features.get(featureRef);

            args = new Object[] { appFeature.getName() };
            Scriptable f = cx.newObject(scope, "Feature", args);

            ScriptableObject.putProperty(ConfML, featureRef, f);

            // process settings
            EMap<String, EAppSetting> settings = appFeature.getSettings();
            Set<String> settingRefsSet = settings.keySet();
            Iterator<String> settingsIterator = settingRefsSet.iterator();
            while (settingsIterator.hasNext()) {
                String settingRef = settingsIterator.next();

                // acquired setting
                EAppSetting appSetting = settings.get(settingRef);

                EAppSettingType aType = appSetting.getTypeInfo();

                // s - Setting
                if (aType instanceof EAppSimpleType) {
                    SimpleSetting s = (SimpleSetting) cx.newObject(scope,
                            "SimpleSetting");
                    s.setAppSetting(appSetting);
                    s.setAbsRef(featureRef + "/" + settingRef);
                    s.setLogger(logger);
                    ScriptableObject.putProperty(f, settingRef, s);
                } else if (aType instanceof EAppResourceType) {
                    FileSetting s = (FileSetting) cx.newObject(scope,
                            "FileSetting");
                    s.setAppSetting(appSetting);
                    s.setAbsRef(featureRef + "/" + settingRef);
                    s.setLogger(logger);
                    ScriptableObject.putProperty(f, settingRef, s);
                } else if (aType instanceof EAppSequenceType) {
                    SequenceSetting s = (SequenceSetting) cx.newObject(scope,
                            "SequenceSetting");
                    s.setLogger(logger);
                    s.setAbsRef(featureRef + "/" + settingRef);
                    s.fillSequenceSetting(appSetting);
                    ScriptableObject.putProperty(f, settingRef, s);
                }
            }
        }
    }

    private static void executeJavaScript(
            EConfigurationProject applicationModel,
            Reader javascriptFileReader, Context cx, Scriptable scope,
            String uri) throws IOException {

        // a Script is something that can be executed
        cx.evaluateReader(scope, javascriptFileReader, uri, -1, null);
    }

}
