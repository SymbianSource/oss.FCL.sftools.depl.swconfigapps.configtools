/*
 * Copyright (c) 2009 Nokia Corporation and/or its subsidiary(-ies). 
 * All rights reserved.
 * This component and the accompanying materials are made available
 * under the terms of the License "Symbian Foundation License v1.0"
 * which accompanies this distribution, and is available
 * at the URL "http://www.symbianfoundation.org/legal/sfl-v10.html".
 * 
 * Initial Contributors:
 * Nokia Corporation - Initial contribution
 * 
 * Contributors:
 * 
 * Description: This file is part of com.nokia.tools.variant.confml.expressions component.
 */
grammar Confml;
 
@header { 
  package com.nokia.tools.variant.confml.expressions.settings;
  
  import java.util.HashSet;
  import java.util.Set;
  import org.eclipse.emf.common.util.*;
  import com.nokia.tools.variant.content.confml.*;
}

@members {
  private View view;

  public void setView(View view) {
    this.view = view;
  }
  
  public View getView() {
    return view;
  }

  private SequenceItem sequenceItem;
  
  public SequenceItem getSequenceItem() {
    return sequenceItem;
  }
  
  public void setSequenceItem(SequenceItem si) {
    this.sequenceItem = si;
  }
  
  private Setting setting;
  
  public void setSetting(Setting setting) {
    this.setting = setting;
  }
  
  public Setting getSetting() {
    return setting;
  }
  
  
  private String featureRef;
  
  public void setFeatureRef(String featureRef) {
    this.featureRef = featureRef;
  }
  
  public String getFeatureRef() {
    return featureRef; 
  }
}

@lexer::header {
  package com.nokia.tools.variant.confml.expressions.settings;
}

// ##################### BASIC EXPRESSIONS
expr returns [Set<Setting> settings]: 
  (e = orExpr NEWLINE             {
                                    settings = e;
                                  })*
;

// ##################### BOOLEAN EXPRESSIONS
orExpr returns [Set<Setting> settings]:
  e1 = andExpr                    {  
                                    settings = e1;
                                  }
  (
    'or'  e2 = andExpr            {
                                    settings.addAll(e2);
                                  }
  )*
;

andExpr returns [Set<Setting> settings]:
  e1 = equalityExpr               {
                                    settings = e1;
                                  }
  (
    'and' e2 = equalityExpr       {
                                    settings.addAll(e2);
                                  }
  )*
;

equalityExpr returns [Set<Setting> settings]: 
  e1 = relationalExpr             { 
                                    settings = e1;
                                  }
  (
    '='   e2 = relationalExpr     {
                                    settings.addAll(e2);
                                  }
  | '!='  e2 = relationalExpr     {
                                    settings.addAll(e2);
                                  }
  )*
;

relationalExpr returns [Set<Setting> settings]:
  e1 = additiveExpr               { 
                                    settings = e1;
                                  }
  (
    '<'   e2 = additiveExpr       {
                                    settings.addAll(e2);
                                  }
                                           
  | '>'   e2 = additiveExpr       {
                                    settings.addAll(e2);
                                  }
                                           
  | '<='  e2 = additiveExpr       {
                                    settings.addAll(e2);
                                  }
                                           
  | '>='  e2 = additiveExpr       {
                                    settings.addAll(e2);
                                  }
  )*
;
  
// ################# Numeric Expressions
additiveExpr returns [Set<Setting> settings] : 
	e1 = multiplicativeExpr         {
	                                  settings = e1;
	                                }
	(
	  '+'   e2 = multiplicativeExpr {
	                                  settings.addAll(e2);
	                                } 
    | '-' e2 = multiplicativeExpr {
                                    settings.addAll(e2);
                                  } 
	)*
;

multiplicativeExpr returns [Set<Setting> settings]: 
	e1 = unaryExpr                  {
			                              settings = new HashSet<Setting>();
			                              settings.add(e1);	
	                                }
	(
	  '*'   e2 = unaryExpr          {
			                              settings.add(e2);
	                                }
	| 'div' e2 = unaryExpr          {
			                              settings.add(e2);
			                            }
	| 'mod' e2 = unaryExpr          {
			                              settings.add(e2);
			                            }
	)* 
;

unaryExpr returns [Setting setting]: 
  e1 = primaryExpr                {
                                    setting = e1;
                                  }
  | '-' e2 = primaryExpr          {
                                    setting = e2;
                                  }
;

primaryExpr returns [Setting setting]: 
  e1 = settingRef                 { 
                                    setting = e1;
                                  }
  | '(' orExpr ')'                { }
  | Literal                       { }
  | Number                        { }
;

// ################# Expression Lexical Structure

settingRef returns [Setting setting]: 
  '.'                             {
                                    setting = getSetting();
                                  }
  | r = Ref                       {
                                    Setting s = getSetting();
	                                  String currentFeatureRef = getFeatureRef();
	                                  
	                                  EList<Setting> allSettings = view.getSharedSettingInstances();
	                                  if (s != null) {// Context is Setting
	                                   String absRef = s.getAbsRef();
	                                   String[] refs = absRef.split("/");
	                                   if (refs.length == 2) {// simple setting context
	                                    String featureRef = absRef.substring(0, absRef.indexOf('/'));
	                                    String searchSettingAbsRef = featureRef + "/" + r.getText();
	                                    for (int i = 0 ; i < allSettings.size() ; i++) {
	                                      Setting si = allSettings.get(i);
	                                      if (si.getAbsRef().equals(searchSettingAbsRef)) {
	                                        setting = si;
	                                        break;
	                                      }
	                                    }
	                                   } else {// subsetting context
	                                     SequenceItem si = getSequenceItem();
	                                     EList<Setting> subsettings = si.getSetting();
	                                     for (int i = 0 ; i < subsettings.size() ; i++) {
	                                       Setting ss = subsettings.get(i);
	                                       if (ss.getSettingRef().equals(r.getText())) {
	                                           setting = ss;
	       	                                  break;
	        	                                }
	                                     }	                                                  
	                                   }
	                                  } else if (currentFeatureRef != null) {
	                                    String searchedSettingAbsRef = currentFeatureRef + "/" + r.getText();
	                                    for (int i = 0 ; i < allSettings.size() ; i++) {
	                                      Setting si = allSettings.get(i);
	                                      if (si.getAbsRef().equals(searchedSettingAbsRef)) {
	                                        setting = si;
	                                        break;
	                                      }
	                                    }
	                                  }
                                  }
  | (r1 = Ref '/' r2 = Ref)       {
	                                  String absRef = r1.getText() + "/" + r2.getText();
	                                  EList<Setting> settings = view.getSharedSettingInstances();
	                                  Setting s = null;
	                                  for (int i = 0 ; i < settings.size() ; i++) {
	                                    Setting x = settings.get(i);
	                                    if (x.getAbsRef().equals(absRef)) {
	                                      s = x;
	                                      break;
	                                    }                                                
	                                  }                                               
	                                  setting = s;
                                  }
  | (r1 = Ref '/' rx = Ref '[' n = Number ']' '/' rs = Ref)
                                  {
                                    int index = Integer.parseInt(n.getText());
                                    String absRef = r1.getText() + "/" + rx.getText();
                                    EList<Setting> settings = view.getSharedSettingInstances();
                                    Setting s = null;
                                    for (int i = 0 ; i < settings.size() ; i++) {
                                      Setting x = settings.get(i);
                                      if (x.getAbsRef().equals(absRef)) {
                                        s = x;
                                        break;
                                      }                                                
                                    }                                               
                                    if (s instanceof SequenceSetting) {
                                      SequenceSetting ss = (SequenceSetting) s;
                                      String subSettingAbsRef = absRef + "/" + rs.getText();
                                      EList<SequenceItem> items = ss.getSequenceItem();
                                      if (index < items.size()) {
                                        SequenceItem si = items.get(index);
                                        EList<Setting> subsettings = si.getSetting();
                                        for (int i = 0 ; i < subsettings.size() ; i++) {
                                          Setting subSetting = subsettings.get(i);
                                          if (subSetting.getAbsRef().equals(subSettingAbsRef)) {
                                            setting = subSetting;
                                            break;
                                          }
                                        }
                                      }
                                    }
                                  }
  | r1 = Ref '/' r2 = Ref '/' r3 = Ref
                                  {
	                                  String absRef = r1.getText() + "/" + r2.getText();
	                                  EList<Setting> settings = view.getSharedSettingInstances();
	                                  Setting s = null;
	                                  for (int i = 0 ; i < settings.size() ; i++) {
	                                    Setting x = settings.get(i);
	                                    if (x.getAbsRef().equals(absRef)) {
	                                      s = x;
	                                      break;
	                                    }                                                
	                                  }
	                                  String text = r3.getText();
	                                  if (text.equals("localPath") || text.equals("targetPath")) {
	                                    setting = s;
	                                  }
                                  }
;

Ref :        ('a'..'z' | 'A'..'Z' ) ('a'..'z' | 'A'..'Z' | '0'..'9' | '.' | '-' | '_')*
;

Literal :
    '"' .* '"'
  | '\'' .* '\''
  | '&apos;' .* '&apos;'
  | '&quot;' .* '&quot;'
;

Number : ('0'..'9')+ ('.' ('0'..'9')+)?
  | '.' ('0'..'9')+
;

NEWLINE : '\r' ? '\n'
;

WS : (' ' |'\t' |'\n' |'\r' )+ {skip();}
;