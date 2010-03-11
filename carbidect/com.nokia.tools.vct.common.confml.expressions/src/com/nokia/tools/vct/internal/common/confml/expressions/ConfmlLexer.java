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
  package com.nokia.tools.vct.internal.common.confml.expressions;


import org.antlr.runtime.BaseRecognizer;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.DFA;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;

public class ConfmlLexer extends Lexer {
    public static final int Ref=28;
    public static final int MINUS=20;
    public static final int Exponent=29;
    public static final int T33=33;
    public static final int T36=36;
    public static final int WS=31;
    public static final int EQ=13;
    public static final int LT=15;
    public static final int GT=16;
    public static final int T35=35;
    public static final int Literal=24;
    public static final int MOD=23;
    public static final int SUB_SETTING_REF=7;
    public static final int IntegerNumber=25;
    public static final int OR=11;
    public static final int T34=34;
    public static final int FILE_PATH_REF=8;
    public static final int NEWLINE=30;
    public static final int GE=18;
    public static final int MUL=21;
    public static final int AND=12;
    public static final int T37=37;
    public static final int BOOLEAN=9;
    public static final int ScientificNumber=27;
    public static final int TOP_LEVEL_SETTING_REF=6;
    public static final int EOF=-1;
    public static final int T32=32;
    public static final int LE=17;
    public static final int Tokens=38;
    public static final int RealNumber=26;
    public static final int CURRENT_REF=4;
    public static final int DIV=22;
    public static final int SIBLING_REF=5;
    public static final int PLUS=19;
    public static final int Number=10;
    public static final int NEQ=14;

      public void reportError(RecognitionException e) {
      }

    public ConfmlLexer() {;} 
    public ConfmlLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g"; }

    // $ANTLR start T32
    public final void mT32() throws RecognitionException {
        try {
            int _type = T32;
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:10:5: ( '(' )
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:10:7: '('
            {
            match('('); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T32

    // $ANTLR start T33
    public final void mT33() throws RecognitionException {
        try {
            int _type = T33;
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:11:5: ( ')' )
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:11:7: ')'
            {
            match(')'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T33

    // $ANTLR start T34
    public final void mT34() throws RecognitionException {
        try {
            int _type = T34;
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:12:5: ( '.' )
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:12:7: '.'
            {
            match('.'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T34

    // $ANTLR start T35
    public final void mT35() throws RecognitionException {
        try {
            int _type = T35;
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:13:5: ( '/' )
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:13:7: '/'
            {
            match('/'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T35

    // $ANTLR start T36
    public final void mT36() throws RecognitionException {
        try {
            int _type = T36;
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:14:5: ( '[' )
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:14:7: '['
            {
            match('['); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T36

    // $ANTLR start T37
    public final void mT37() throws RecognitionException {
        try {
            int _type = T37;
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:15:5: ( ']' )
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:15:7: ']'
            {
            match(']'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T37

    // $ANTLR start OR
    public final void mOR() throws RecognitionException {
        try {
            int _type = OR;
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:173:3: ( 'or' )
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:173:5: 'or'
            {
            match("or"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end OR

    // $ANTLR start AND
    public final void mAND() throws RecognitionException {
        try {
            int _type = AND;
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:174:4: ( 'and' )
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:174:6: 'and'
            {
            match("and"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end AND

    // $ANTLR start EQ
    public final void mEQ() throws RecognitionException {
        try {
            int _type = EQ;
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:175:3: ( '=' )
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:175:5: '='
            {
            match('='); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end EQ

    // $ANTLR start NEQ
    public final void mNEQ() throws RecognitionException {
        try {
            int _type = NEQ;
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:176:4: ( '!=' )
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:176:6: '!='
            {
            match("!="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end NEQ

    // $ANTLR start LT
    public final void mLT() throws RecognitionException {
        try {
            int _type = LT;
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:177:3: ( '<' )
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:177:5: '<'
            {
            match('<'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end LT

    // $ANTLR start GT
    public final void mGT() throws RecognitionException {
        try {
            int _type = GT;
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:178:3: ( '>' )
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:178:5: '>'
            {
            match('>'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end GT

    // $ANTLR start LE
    public final void mLE() throws RecognitionException {
        try {
            int _type = LE;
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:179:3: ( '<=' )
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:179:5: '<='
            {
            match("<="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end LE

    // $ANTLR start GE
    public final void mGE() throws RecognitionException {
        try {
            int _type = GE;
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:180:3: ( '>=' )
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:180:5: '>='
            {
            match(">="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end GE

    // $ANTLR start PLUS
    public final void mPLUS() throws RecognitionException {
        try {
            int _type = PLUS;
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:181:5: ( '+' )
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:181:7: '+'
            {
            match('+'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end PLUS

    // $ANTLR start MINUS
    public final void mMINUS() throws RecognitionException {
        try {
            int _type = MINUS;
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:182:6: ( '-' )
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:182:8: '-'
            {
            match('-'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end MINUS

    // $ANTLR start MUL
    public final void mMUL() throws RecognitionException {
        try {
            int _type = MUL;
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:183:4: ( '*' )
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:183:6: '*'
            {
            match('*'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end MUL

    // $ANTLR start DIV
    public final void mDIV() throws RecognitionException {
        try {
            int _type = DIV;
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:184:4: ( 'div' )
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:184:6: 'div'
            {
            match("div"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end DIV

    // $ANTLR start MOD
    public final void mMOD() throws RecognitionException {
        try {
            int _type = MOD;
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:185:4: ( 'mod' )
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:185:6: 'mod'
            {
            match("mod"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end MOD

    // $ANTLR start Ref
    public final void mRef() throws RecognitionException {
        try {
            int _type = Ref;
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:188:5: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '.' | '-' | '_' )* )
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:188:14: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '.' | '-' | '_' )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:188:37: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '.' | '-' | '_' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='-' && LA1_0<='.')||(LA1_0>='0' && LA1_0<='9')||(LA1_0>='A' && LA1_0<='Z')||LA1_0=='_'||(LA1_0>='a' && LA1_0<='z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:
            	    {
            	    if ( (input.LA(1)>='-' && input.LA(1)<='.')||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end Ref

    // $ANTLR start Literal
    public final void mLiteral() throws RecognitionException {
        try {
            int _type = Literal;
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:192:9: ( '\"' ( . )* '\"' | '\\'' ( . )* '\\'' )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='\"') ) {
                alt4=1;
            }
            else if ( (LA4_0=='\'') ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("192:1: Literal : ( '\"' ( . )* '\"' | '\\'' ( . )* '\\'' );", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:193:5: '\"' ( . )* '\"'
                    {
                    match('\"'); 
                    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:193:9: ( . )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0=='\"') ) {
                            alt2=2;
                        }
                        else if ( ((LA2_0>='\u0000' && LA2_0<='!')||(LA2_0>='#' && LA2_0<='\uFFFE')) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:193:9: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:194:5: '\\'' ( . )* '\\''
                    {
                    match('\''); 
                    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:194:10: ( . )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0=='\'') ) {
                            alt3=2;
                        }
                        else if ( ((LA3_0>='\u0000' && LA3_0<='&')||(LA3_0>='(' && LA3_0<='\uFFFE')) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:194:10: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);

                    match('\''); 

                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end Literal

    // $ANTLR start IntegerNumber
    public final void mIntegerNumber() throws RecognitionException {
        try {
            int _type = IntegerNumber;
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:201:5: ( ( '0' .. '9' )+ )
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:202:8: ( '0' .. '9' )+
            {
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:202:8: ( '0' .. '9' )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:202:9: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end IntegerNumber

    // $ANTLR start Exponent
    public final void mExponent() throws RecognitionException {
        try {
            int _type = Exponent;
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:207:5: ( ( 'e' | 'E' ) ( PLUS | MINUS )? IntegerNumber )
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:207:9: ( 'e' | 'E' ) ( PLUS | MINUS )? IntegerNumber
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:207:23: ( PLUS | MINUS )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='+'||LA6_0=='-') ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse =
                            new MismatchedSetException(null,input);
                        recover(mse);    throw mse;
                    }


                    }
                    break;

            }

            mIntegerNumber(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end Exponent

    // $ANTLR start RealNumber
    public final void mRealNumber() throws RecognitionException {
        try {
            int _type = RealNumber;
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:210:12: ( IntegerNumber '.' IntegerNumber )
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:210:15: IntegerNumber '.' IntegerNumber
            {
            mIntegerNumber(); 
            match('.'); 
            mIntegerNumber(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RealNumber

    // $ANTLR start ScientificNumber
    public final void mScientificNumber() throws RecognitionException {
        try {
            int _type = ScientificNumber;
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:214:18: ( ( PLUS | MINUS ) IntegerNumber Exponent )
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:215:3: ( PLUS | MINUS ) IntegerNumber Exponent
            {
            if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            mIntegerNumber(); 
            mExponent(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end ScientificNumber

    // $ANTLR start NEWLINE
    public final void mNEWLINE() throws RecognitionException {
        try {
            int _type = NEWLINE;
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:222:9: ( ( '\\r' )? '\\n' )
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:222:11: ( '\\r' )? '\\n'
            {
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:222:11: ( '\\r' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='\r') ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:222:11: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }

            match('\n'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end NEWLINE

    // $ANTLR start WS
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:225:4: ( ( ' ' | '\\t' | '\\n' | '\\r' )+ )
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:225:6: ( ' ' | '\\t' | '\\n' | '\\r' )+
            {
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:225:6: ( ' ' | '\\t' | '\\n' | '\\r' )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\t' && LA8_0<='\n')||LA8_0=='\r'||LA8_0==' ') ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);

            skip();

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end WS

    public void mTokens() throws RecognitionException {
        // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:1:8: ( T32 | T33 | T34 | T35 | T36 | T37 | OR | AND | EQ | NEQ | LT | GT | LE | GE | PLUS | MINUS | MUL | DIV | MOD | Ref | Literal | IntegerNumber | Exponent | RealNumber | ScientificNumber | NEWLINE | WS )
        int alt9=27;
        alt9 = dfa9.predict(input);
        switch (alt9) {
            case 1 :
                // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:1:10: T32
                {
                mT32(); 

                }
                break;
            case 2 :
                // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:1:14: T33
                {
                mT33(); 

                }
                break;
            case 3 :
                // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:1:18: T34
                {
                mT34(); 

                }
                break;
            case 4 :
                // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:1:22: T35
                {
                mT35(); 

                }
                break;
            case 5 :
                // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:1:26: T36
                {
                mT36(); 

                }
                break;
            case 6 :
                // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:1:30: T37
                {
                mT37(); 

                }
                break;
            case 7 :
                // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:1:34: OR
                {
                mOR(); 

                }
                break;
            case 8 :
                // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:1:37: AND
                {
                mAND(); 

                }
                break;
            case 9 :
                // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:1:41: EQ
                {
                mEQ(); 

                }
                break;
            case 10 :
                // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:1:44: NEQ
                {
                mNEQ(); 

                }
                break;
            case 11 :
                // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:1:48: LT
                {
                mLT(); 

                }
                break;
            case 12 :
                // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:1:51: GT
                {
                mGT(); 

                }
                break;
            case 13 :
                // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:1:54: LE
                {
                mLE(); 

                }
                break;
            case 14 :
                // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:1:57: GE
                {
                mGE(); 

                }
                break;
            case 15 :
                // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:1:60: PLUS
                {
                mPLUS(); 

                }
                break;
            case 16 :
                // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:1:65: MINUS
                {
                mMINUS(); 

                }
                break;
            case 17 :
                // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:1:71: MUL
                {
                mMUL(); 

                }
                break;
            case 18 :
                // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:1:75: DIV
                {
                mDIV(); 

                }
                break;
            case 19 :
                // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:1:79: MOD
                {
                mMOD(); 

                }
                break;
            case 20 :
                // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:1:83: Ref
                {
                mRef(); 

                }
                break;
            case 21 :
                // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:1:87: Literal
                {
                mLiteral(); 

                }
                break;
            case 22 :
                // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:1:95: IntegerNumber
                {
                mIntegerNumber(); 

                }
                break;
            case 23 :
                // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:1:109: Exponent
                {
                mExponent(); 

                }
                break;
            case 24 :
                // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:1:118: RealNumber
                {
                mRealNumber(); 

                }
                break;
            case 25 :
                // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:1:129: ScientificNumber
                {
                mScientificNumber(); 

                }
                break;
            case 26 :
                // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:1:146: NEWLINE
                {
                mNEWLINE(); 

                }
                break;
            case 27 :
                // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:1:154: WS
                {
                mWS(); 

                }
                break;

        }

    }


    protected DFA9 dfa9 = new DFA9(this);
    static final String DFA9_eotS =
        "\7\uffff\2\25\2\uffff\1\34\1\36\1\40\1\41\1\uffff\3\25\1\uffff"+
        "\1\47\1\uffff\1\30\1\51\1\uffff\1\52\1\25\7\uffff\4\25\5\uffff\1"+
        "\56\1\57\1\60\3\uffff";
    static final String DFA9_eofS =
        "\61\uffff";
    static final String DFA9_minS =
        "\1\11\6\uffff\1\162\1\156\2\uffff\2\75\2\60\1\uffff\1\151\1\157"+
        "\1\53\1\uffff\1\56\1\uffff\1\12\1\11\1\uffff\1\55\1\144\7\uffff"+
        "\1\166\1\144\2\60\5\uffff\3\55\3\uffff";
    static final String DFA9_maxS =
        "\1\172\6\uffff\1\162\1\156\2\uffff\2\75\2\71\1\uffff\1\151\1\157"+
        "\1\71\1\uffff\1\71\1\uffff\1\12\1\40\1\uffff\1\172\1\144\7\uffff"+
        "\1\166\1\144\2\71\5\uffff\3\172\3\uffff";
    static final String DFA9_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\2\uffff\1\11\1\12\4\uffff\1\21"+
        "\3\uffff\1\25\1\uffff\1\24\2\uffff\1\33\2\uffff\1\15\1\13\1\16\1"+
        "\14\1\31\1\17\1\20\4\uffff\1\27\1\26\1\30\1\32\1\7\3\uffff\1\10"+
        "\1\22\1\23";
    static final String DFA9_specialS =
        "\61\uffff}>";
    static final String[] DFA9_transitionS = {
            "\1\30\1\27\2\uffff\1\26\22\uffff\1\30\1\12\1\23\4\uffff\1\23"+
            "\1\1\1\2\1\17\1\15\1\uffff\1\16\1\3\1\4\12\24\2\uffff\1\13\1"+
            "\11\1\14\2\uffff\4\25\1\22\25\25\1\5\1\uffff\1\6\3\uffff\1\10"+
            "\2\25\1\20\1\22\7\25\1\21\1\25\1\7\13\25",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\31",
            "\1\32",
            "",
            "",
            "\1\33",
            "\1\35",
            "\12\37",
            "\12\37",
            "",
            "\1\42",
            "\1\43",
            "\1\46\1\uffff\1\44\2\uffff\12\45",
            "",
            "\1\50\1\uffff\12\24",
            "",
            "\1\27",
            "\2\30\2\uffff\1\30\22\uffff\1\30",
            "",
            "\2\25\1\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32"+
            "\25",
            "\1\53",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\54",
            "\1\55",
            "\12\45",
            "\12\45",
            "",
            "",
            "",
            "",
            "",
            "\2\25\1\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32"+
            "\25",
            "\2\25\1\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32"+
            "\25",
            "\2\25\1\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32"+
            "\25",
            "",
            "",
            ""
    };

    static final short[] DFA9_eot = DFA.unpackEncodedString(DFA9_eotS);
    static final short[] DFA9_eof = DFA.unpackEncodedString(DFA9_eofS);
    static final char[] DFA9_min = DFA.unpackEncodedStringToUnsignedChars(DFA9_minS);
    static final char[] DFA9_max = DFA.unpackEncodedStringToUnsignedChars(DFA9_maxS);
    static final short[] DFA9_accept = DFA.unpackEncodedString(DFA9_acceptS);
    static final short[] DFA9_special = DFA.unpackEncodedString(DFA9_specialS);
    static final short[][] DFA9_transition;

    static {
        int numStates = DFA9_transitionS.length;
        DFA9_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA9_transition[i] = DFA.unpackEncodedString(DFA9_transitionS[i]);
        }
    }

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = DFA9_eot;
            this.eof = DFA9_eof;
            this.min = DFA9_min;
            this.max = DFA9_max;
            this.accept = DFA9_accept;
            this.special = DFA9_special;
            this.transition = DFA9_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T32 | T33 | T34 | T35 | T36 | T37 | OR | AND | EQ | NEQ | LT | GT | LE | GE | PLUS | MINUS | MUL | DIV | MOD | Ref | Literal | IntegerNumber | Exponent | RealNumber | ScientificNumber | NEWLINE | WS );";
        }
    }
 

}
