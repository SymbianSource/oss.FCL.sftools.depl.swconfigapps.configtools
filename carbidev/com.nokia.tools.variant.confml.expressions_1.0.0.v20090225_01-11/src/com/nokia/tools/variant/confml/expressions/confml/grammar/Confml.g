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
  package com.nokia.tools.variant.confml.expressions.confml.grammar;
  
  import com.nokia.tools.variant.content.confml.*;
  import org.eclipse.emf.common.util.*;
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

/*
  private String currentRef;
  
  public void setCurrentRef(String currentRef) {
    this.currentRef = currentRef;
  }
  
  public String getCurrentRef() {
    return currentRef;
  }
*/  
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
  
	  public boolean areObjectsEqual(Object o1, Object o2) {
		  try {
			  if (o1 instanceof Boolean) {
				  Boolean b1 = (Boolean) o1;
				  if (o2 instanceof Boolean) {
					  return b1.equals(o2);
				  } else if (o2 instanceof String) {
					  String s2 = (String) o2;
					  return b1.equals(Boolean.parseBoolean(s2));
				  } else {
					  return false;
				  }
			  } else if (o1 instanceof String) {
				  String s1 = (String) o1;
				  if (o2 instanceof Boolean) {
					  Boolean b2 = (Boolean) o2;
					  return s1.equals(b2.toString());
				  } else if (o2 instanceof String) {
					  return s1.equals(o2);
				  } else if (o2 instanceof Double) {
					  return new Double(s1).toString().equals(((Double)o2).toString());
				  }
			  } else if (o1 instanceof Double) {
				  Double d1 = (Double) o1;
				  if (o2 instanceof String) {
					  String s2 = (String) o2;
					  return d1.equals(Double.parseDouble(s2));
				  } else if (o2 instanceof Double) {
					  return d1.equals(o2);
				  }
			  }
		  } catch (Throwable t) {
			  ;
		  }
		  return false;
	  }
  
  
}

@lexer::header {
  package com.nokia.tools.variant.confml.expressions.confml.grammar;
}

// ##################### BASIC EXPRESSIONS
expr returns [Object value]: 
  (orExpr NEWLINE {value = $orExpr.value;})*
;

// ##################### BOOLEAN EXPRESSIONS
orExpr returns [Object value]:
  e = andExpr                     { value = e; }
  (
    'or'  e2 = andExpr            { value = (new Boolean(e.toString()) || new Boolean(e2.toString())); }
  )*
;

andExpr returns [Object value]:
  e = equalityExpr                { value = e; }
  (
    'and' e2 = equalityExpr       { value = (new Boolean(e.toString()) && new Boolean(e2.toString())); }
  )*
;

equalityExpr returns [Object value]: 
  e = relationalExpr              { value = e; }
  (
    '='   e2 = relationalExpr     { value = areObjectsEqual(e, e2); }
    
    
    
    
  | '!='  e2 = relationalExpr     { value = !areObjectsEqual(e, e2); }
  )*
;

relationalExpr returns [Object value]:
  e = additiveExpr                { value = e; }
  (
    '<'   e2 = additiveExpr       		   {
                                            value = (Double.valueOf(e.toString()).compareTo(Double.valueOf(e2.toString()))) == -1;    
                                           }
                                           
  | '>'   e2 = additiveExpr       		   {
                                            value = (Double.valueOf(e.toString()).compareTo(Double.valueOf(e2.toString()))) == 1;
                                           }
                                           
  | '<='   e2 = additiveExpr       		   {
                                            value = (Double.valueOf(e.toString()).compareTo(Double.valueOf(e2.toString()))) <= 0; 
                                           }
                                           
  | '>='   e2 = additiveExpr               {
                                           value = (Double.valueOf(e.toString()).compareTo(Double.valueOf(e2.toString()))) >= 0;
                                           }
  )*
;
  
// ################# Numeric Expressions
additiveExpr returns [Object value] : 
	multiplicativeExpr              { value = $multiplicativeExpr.value;}
	(
	  '+'   e = multiplicativeExpr  { value = Double.parseDouble(value.toString()) + Double.parseDouble(e.toString()); } 
    | '-'   e = multiplicativeExpr  { value = Double.parseDouble(value.toString()) - Double.parseDouble(e.toString()); } 
	)*
;

multiplicativeExpr returns [Object value]: 
	e = unaryExpr                   { value = e; }
	(
	  '*'   e2 = unaryExpr          { value = Double.parseDouble(value.toString()) * Double.parseDouble(e2.toString()); }
	| 'div' e2 = unaryExpr          { value = Double.parseDouble(value.toString()) / Double.parseDouble(e2.toString()); }
	| 'mod' e2 = unaryExpr          { value = Double.parseDouble(value.toString()) % Double.parseDouble(e2.toString()); }
	)* 
;

unaryExpr returns [Object value]: 
  primaryExpr                     { value = $primaryExpr.value ; }
  | '-' primaryExpr               { value = -Double.parseDouble($primaryExpr.value.toString()) ; }
;

primaryExpr returns [Object value]: 
  settingValueRef                 { value = $settingValueRef.value; }
  | '(' orExpr ')'                { value = $orExpr.value ; }
  | Literal                       {
                                    value = $Literal.text;
                                    String str = value.toString();
                    
								                    if (str.contains("&amp;")) {
								                      value = str.replaceAll("&amp;", "&");
								                    }
								                    
								                    if ((str.startsWith("\"") && str.endsWith("\"")) || (str.startsWith("\'") && str.endsWith("\'"))) {
								                      value = str.substring(1, $Literal.text.length() - 1);                     
								                    } else if (str.startsWith("&apos;") && str.endsWith("&apos;")) {
								                      value = str.replaceAll("&apos;", "");
								                    } else if (str.startsWith("&quot;") && str.endsWith("&quot;")) {
								                      value = str.replaceAll("&quot;", "");
								                    }
                                  }
  | Number                        { value = $Number.text ; }
;

// ################# Expression Lexical Structure

settingValueRef returns [Object value]: 
  '.'                                         {
                                              value = ((SimpleSetting)getSetting()).getValue();
                                              }
  | r = Ref                                   {
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
		                                                    value = ((SimpleSetting)si).getValue(); 
		                                                    break;
		                                                  }
		                                                }
	                                                } else {// subsetting context
	                                                  String searchSubsettingRef = r.getText();
	                                                  SequenceItem si = getSequenceItem();
	                                                  EList<Setting> subsettings = si.getSetting();
	                                                  for (int i = 0 ; i < subsettings.size() ; i++) {
	                                                    Setting ss = subsettings.get(i);
	                                                    if (ss.getSettingRef().equals(r.getText())) {
  	                                                      if (ss instanceof SimpleSetting) {
                    	                                    value = ((SimpleSetting)ss).getValue();
                    	                                    break;
                    	                                  }
                      	                                }
	                                                  }
	                                                  
	                                                }
                                                } else if (currentFeatureRef != null) {
                                                  String searchedSettingAbsRef = currentFeatureRef + "/" + r.getText();
                                                  for (int i = 0 ; i < allSettings.size() ; i++) {
                                                    Setting si = allSettings.get(i);
                                                    if (si.getAbsRef().equals(searchedSettingAbsRef)) {
                                                      value = ((SimpleSetting)si).getValue();
                                                      break;
                                                    }
                                                  }
                                                }
                                              }
  | (r1 = Ref '/' r2 = Ref)                   {
                                              String absRef = r1.getText() + "/" + r2.getText();
                                              EList<Setting> settings = view.getSharedSettingInstances();
                                              Setting s = null;
                                              for (int i = 0 ; i < settings.size() ; i++) {
                                                Setting x = settings.get(i);
                                                if (x.getAbsRef().equals(absRef)) {
                                                  s=x;
                                                  break;
                                                }
                                                
                                              }
                                               
                                              if (s instanceof SimpleSetting) {
                                                SimpleSetting ss = (SimpleSetting) s;
                                                String val = ss.getValue();
                                                value = val;
                                              }
                                            }


  | (r1 = Ref '/' rx = Ref '[' n = Number ']' '/' rs = Ref)  {
                                              int index = Integer.parseInt(n.getText());
                                              String absRef = r1.getText() + "/" + rx.getText();
                                              EList<Setting> settings = view.getSharedSettingInstances();
                                              Setting s = null;
                                              for (int i = 0 ; i < settings.size() ; i++) {
                                                Setting x = settings.get(i);
                                                if (x.getAbsRef().equals(absRef)) {
                                                  s=x;
                                                  break;
                                                }
                                                
                                              }
                                               
                                              if (s instanceof SequenceSetting) {
                                                SequenceSetting ss = (SequenceSetting) s;
                                                String subSettingAbsRef = absRef + "/" + rs.getText();
                                                EList<SequenceItem> items = ss.getSequenceItem();
                                                SequenceItem si = items.get(index);
                                                EList<Setting> subsettings = si.getSetting();
                                                for (int i = 0 ; i < subsettings.size() ; i++) {
                                                  Setting subSetting = subsettings.get(i);
                                                  if (subSetting.getAbsRef().equals(subSettingAbsRef)) {
                                                    if (subSetting instanceof SimpleSetting) {
                                                      value = ((SimpleSetting)subSetting).getValue();
		                                              break; 
            	                                    }
              	                                  }
                                                }
                                                  
                                              }
                                            }


  | r1 = Ref '/' r2 = Ref '/' r3 = Ref      {  
  
                                              String absRef = r1.getText() + "/" + r2.getText();
                                              EList<Setting> settings = view.getSharedSettingInstances();
                                              Setting s = null;
                                              for (int i = 0 ; i < settings.size() ; i++) {
                                                Setting x = settings.get(i);
                                                if (x.getAbsRef().equals(absRef)) {
                                                  s=x;
                                                  break;
                                                }
                                                
                                              }
                                               
                                              if (s instanceof FileSystemEntrySetting) {
                                                FileSystemEntrySetting fs = (FileSystemEntrySetting) s;
                                                if (r3.getText().equals("localPath")) {
                                                  value = fs.getSourcePath();
                                                } else if (r3.getText().equals("targetPath")) {
                                                  value = fs.getTargetPath();
                                                }
                                              }
                                            }
  ;
 

//IndexedRef : ('a'..'z' | 'A'..'Z' ) ('a'..'z' | 'A'..'Z' | '0'..'9' | '.' | '-')* ('*' | ('[' Number ']'))   {};
                                             
                                             
Ref :        ('a'..'z' | 'A'..'Z' ) ('a'..'z' | 'A'..'Z' | '0'..'9' | '.' | '-' | '_')*
//Ref : (('a'..'z' | 'A'..'Z' ) (('a'..'z' | 'A'..'Z' ) | ('0'..'9') | '.' | '-')*) ('*' | ('[' Number ']'))?
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

//NameChar    :   Letter | Digit | '.' | '..' | '_' | ':' | CombiningChar | Extender;  
//Name    :   (Letter | '_' | ':') (NameChar)*; 
//Names    :    Name ('\u0020' Name)*; 
//Nmtoken    :    (NameChar)+ ;
//Nmtokens    :   Nmtoken ('\u0020' Nmtoken)*; 

//CombiningChar    :    ('\u0300'..'\u0345') | ('\u0360'..'\u0361') | ('\u0483'..'\u0486') | ('\u0591'..'\u05A1') | ('\u05A3'..'\u05B9') | ('\u05BB'..'\u05BD') | '\u05BF' | ('\u05C1'..'\u05C2') | '\u05C4' | ('\u064B'..'\u0652') | '\u0670' | ('\u06D6'..'\u06DC') | ('\u06DD'..'\u06DF') | ('\u06E0'..'\u06E4') | ('\u06E7'..'\u06E8') | ('\u06EA'..'\u06ED') | ('\u0901'..'\u0903') | '\u093C' | ('\u093E'..'\u094C') | '\u094D' | ('\u0951'..'\u0954') | ('\u0962'..'\u0963') | ('\u0981'..'\u0983') | '\u09BC' | '\u09BE' | '\u09BF' | ('\u09C0'..'\u09C4') | ('\u09C7'..'\u09C8') | ('\u09CB'..'\u09CD') | '\u09D7' | ('\u09E2'..'\u09E3') | '\u0A02' | '\u0A3C' | '\u0A3E' | '\u0A3F' | ('\u0A40'..'\u0A42') | ('\u0A47'..'\u0A48') | ('\u0A4B'..'\u0A4D') | ('\u0A70'..'\u0A71') | ('\u0A81'..'\u0A83') | '\u0ABC' | ('\u0ABE'..'\u0AC5') | ('\u0AC7'..'\u0AC9') | ('\u0ACB'..'\u0ACD') | ('\u0B01'..'\u0B03') | '\u0B3C' | ('\u0B3E'..'\u0B43') | ('\u0B47'..'\u0B48') | ('\u0B4B'..'\u0B4D') | ('\u0B56'..'\u0B57') | ('\u0B82'..'\u0B83') | ('\u0BBE'..'\u0BC2') | ('\u0BC6'..'\u0BC8') | ('\u0BCA'..'\u0BCD') | '\u0BD7' | ('\u0C01'..'\u0C03') | ('\u0C3E'..'\u0C44') | ('\u0C46'..'\u0C48') | ('\u0C4A'..'\u0C4D') | ('\u0C55'..'\u0C56') | ('\u0C82'..'\u0C83') | ('\u0CBE'..'\u0CC4') | ('\u0CC6'..'\u0CC8') | ('\u0CCA'..'\u0CCD') | ('\u0CD5'..'\u0CD6') | ('\u0D02'..'\u0D03') | ('\u0D3E'..'\u0D43') | ('\u0D46'..'\u0D48') | ('\u0D4A'..'\u0D4D') | '\u0D57' | '\u0E31' | ('\u0E34'..'\u0E3A') | ('\u0E47'..'\u0E4E') | '\u0EB1' | ('\u0EB4'..'\u0EB9') | ('\u0EBB'..'\u0EBC') | ('\u0EC8'..'\u0ECD') | ('\u0F18'..'\u0F19') | '\u0F35' | '\u0F37' | '\u0F39' | '\u0F3E' | '\u0F3F' | ('\u0F71'..'\u0F84') | ('\u0F86'..'\u0F8B') | ('\u0F90'..'\u0F95') | '\u0F97' | ('\u0F99'..'\u0FAD') | ('\u0FB1'..'\u0FB7') | '\u0FB9' | ('\u20D0'..'\u20DC') | '\u20E1' | ('\u302A'..'\u302F') | '\u3099' | '\u309A'  ;
//Digit    :    ('\u0030'..'\u0039') | ('\u0660'..'\u0669') | ('\u06F0'..'\u06F9') | ('\u0966'..'\u096F') | ('\u09E6'..'\u09EF') | ('\u0A66'..'\u0A6F') | ('\u0AE6'..'\u0AEF') | ('\u0B66'..'\u0B6F') | ('\u0BE7'..'\u0BEF') | ('\u0C66'..'\u0C6F') | ('\u0CE6'..'\u0CEF') | ('\u0D66'..'\u0D6F') | ('\u0E50'..'\u0E59') | ('\u0ED0'..'\u0ED9') | ('\u0F20'..'\u0F29')  ;
//Extender    :    '\u00B7' | '\u02D0' | '\u02D1' | '\u0387' | '\u0640' | '\u0E46' | '\u0EC6' | '\u3005' | ('\u3031'..'\u3035') | ('\u309D'..'\u309E') | ('\u30FC'..'\u30FE')  ;
