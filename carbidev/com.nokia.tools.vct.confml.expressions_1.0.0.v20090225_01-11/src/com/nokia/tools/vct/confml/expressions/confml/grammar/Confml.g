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
 * Description: This file is part of com.nokia.tools.vct.confml.expressions component.
 */
grammar Confml;

options {
  output=AST;
  ASTLabelType=CommonTree;
}
 
tokens {
  CURRENT_REF;
  SIBLING_REF;
  TOP_LEVEL_SETTING_REF;
  SUB_SETTING_REF;
  FILE_PATH_REF;
  
  BOOLEAN;
}

@header { 
  package com.nokia.tools.vct.confml.expressions.confml.grammar;
}

@lexer::header {
  package com.nokia.tools.vct.confml.expressions.confml.grammar;
}

@members {
  public boolean isFailed() {
    return lastErrorIndex != -1;
  }
}



// ##################### BASIC EXPRESSIONS
expr: 
  orExpr EOF!
;

// ##################### BOOLEAN EXPRESSIONS
orExpr:
  e = andExpr
  (
    OR^  e2 = andExpr
  )*
;

andExpr:
  e = equalityExpr     
  (
    AND^ e2 = equalityExpr       
  )*
;

equalityExpr: 
  e = relationalExpr
  (
    EQ^   e2 = relationalExpr
  | NEQ^  e2 = relationalExpr
  )*
;

relationalExpr:
  e = additiveExpr            
  (
    LT^   e2 = additiveExpr  
  | GT^   e2 = additiveExpr                                             
  | LE^  e2 = additiveExpr  
  | GE^  e2 = additiveExpr  
  )*
;
  
// ################# Numeric Expressions
additiveExpr: 
	multiplicativeExpr
	(
	  PLUS^   e = multiplicativeExpr 
    | MINUS^   e = multiplicativeExpr 
	)*
;

multiplicativeExpr: 
	e = unaryExpr
	(
	  MUL^   e2 = unaryExpr
	| DIV^ e2 = unaryExpr
	| MOD^ e2 = unaryExpr
	)* 
;

unaryExpr: 
  primaryExpr
  | MINUS^ primaryExpr
;

primaryExpr: 
  settingValueRef
  | '(' orExpr ')'
  | Literal
  | Number
;

// ################# Expression Lexical Structure

settingValueRef:
  currentRef
  | siblingRef
  | topLevelSettingRef
  | subSettingRef
  | filePathRef
;


currentRef:
  '.' -> CURRENT_REF["."]
;


siblingRef:
  r = Ref { String val = $r.getText(); } -> SIBLING_REF[val]
;

topLevelSettingRef:
  r1 = Ref '/' r2 = Ref {String val = $r1.getText()+"/"+$r2.getText();} -> TOP_LEVEL_SETTING_REF[val]
;

subSettingRef:
  r1 = Ref '/' rx = Ref '[' n = Number ']' '/' rs = Ref
  {String val = $r1.getText()+"/"+$rx.getText() + "[" + n.getText() + "]/" + rs.getText();} -> SUB_SETTING_REF[val]
;


filePathRef:
  r1 = Ref '/' r2 = Ref '/' r3 = Ref
  {String val = $r1.getText()+"/"+$r2.getText()+"/"+$r3.getText();} -> FILE_PATH_REF[val]
;


//IndexedRef : ('a'..'z' | 'A'..'Z' ) ('a'..'z' | 'A'..'Z' | '0'..'9' | '.' | '-')* ('*' | ('[' Number ']'))   {};


OR: 'or';
AND: 'and';
EQ: '=';
NEQ: '!=';     
LT: '<';  
GT: '>';                                            
LE: '<='; 
GE: '>=';
PLUS: '+'; 
MINUS: '-'; 
MUL: '*';
DIV: 'div';
MOD: 'mod';
                                        
                                             
Ref :        ('a'..'z' | 'A'..'Z' ) ('a'..'z' | 'A'..'Z' | '0'..'9' | '.' | '-' | '_')*
//Ref : (('a'..'z' | 'A'..'Z' ) (('a'..'z' | 'A'..'Z' ) | ('0'..'9') | '.' | '-')*) ('*' | ('[' Number ']'))?
;

Literal :
    '"' .* '"'
  | '\'' .* '\''
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
