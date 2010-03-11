lexer grammar Confml;
@header {
  package com.nokia.tools.variant.confml.expressions.settings;
}

T9 : 'or' ;
T10 : 'and' ;
T11 : '=' ;
T12 : '!=' ;
T13 : '<' ;
T14 : '>' ;
T15 : '<=' ;
T16 : '>=' ;
T17 : '+' ;
T18 : '-' ;
T19 : '*' ;
T20 : 'div' ;
T21 : 'mod' ;
T22 : '(' ;
T23 : ')' ;
T24 : '.' ;
T25 : '/' ;
T26 : '[' ;
T27 : ']' ;

// $ANTLR src "C:\projects\CarbideV2\com.nokia.tools.variant.confml.expressions\src\com\nokia\tools\variant\confml\expressions\settings\Confml.g" 285
Ref :        ('a'..'z' | 'A'..'Z' ) ('a'..'z' | 'A'..'Z' | '0'..'9' | '.' | '-' | '_')*
;

// $ANTLR src "C:\projects\CarbideV2\com.nokia.tools.variant.confml.expressions\src\com\nokia\tools\variant\confml\expressions\settings\Confml.g" 288
Literal :
    '"' .* '"'
  | '\'' .* '\''
  | '&apos;' .* '&apos;'
  | '&quot;' .* '&quot;'
;

// $ANTLR src "C:\projects\CarbideV2\com.nokia.tools.variant.confml.expressions\src\com\nokia\tools\variant\confml\expressions\settings\Confml.g" 295
Number : ('0'..'9')+ ('.' ('0'..'9')+)?
  | '.' ('0'..'9')+
;

// $ANTLR src "C:\projects\CarbideV2\com.nokia.tools.variant.confml.expressions\src\com\nokia\tools\variant\confml\expressions\settings\Confml.g" 299
NEWLINE : '\r' ? '\n'
;

// $ANTLR src "C:\projects\CarbideV2\com.nokia.tools.variant.confml.expressions\src\com\nokia\tools\variant\confml\expressions\settings\Confml.g" 302
WS : (' ' |'\t' |'\n' |'\r' )+ {skip();}
;