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
 * Description: This file is part of com.nokia.tools.vct.confml.expressions component.
 */
// $ANTLR 3.0.1 C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g 2009-02-20 16:55:04

  package com.nokia.tools.vct.confml.expressions.confml.grammar;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class ConfmlLexer extends Lexer {
    public static final int Ref=25;
    public static final int MINUS=19;
    public static final int T29=29;
    public static final int T33=33;
    public static final int WS=27;
    public static final int EQ=12;
    public static final int T28=28;
    public static final int LT=14;
    public static final int GT=15;
    public static final int Literal=23;
    public static final int MOD=22;
    public static final int SUB_SETTING_REF=7;
    public static final int OR=10;
    public static final int FILE_PATH_REF=8;
    public static final int NEWLINE=26;
    public static final int GE=17;
    public static final int MUL=20;
    public static final int AND=11;
    public static final int BOOLEAN=9;
    public static final int TOP_LEVEL_SETTING_REF=6;
    public static final int EOF=-1;
    public static final int T32=32;
    public static final int LE=16;
    public static final int Tokens=34;
    public static final int T31=31;
    public static final int CURRENT_REF=4;
    public static final int DIV=21;
    public static final int SIBLING_REF=5;
    public static final int PLUS=18;
    public static final int Number=24;
    public static final int T30=30;
    public static final int NEQ=13;
    public ConfmlLexer() {;} 
    public ConfmlLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g"; }

    // $ANTLR start T28
    public final void mT28() throws RecognitionException {
        try {
            int _type = T28;
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:6:5: ( '(' )
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:6:7: '('
            {
            match('('); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T28

    // $ANTLR start T29
    public final void mT29() throws RecognitionException {
        try {
            int _type = T29;
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:7:5: ( ')' )
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:7:7: ')'
            {
            match(')'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T29

    // $ANTLR start T30
    public final void mT30() throws RecognitionException {
        try {
            int _type = T30;
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:8:5: ( '.' )
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:8:7: '.'
            {
            match('.'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T30

    // $ANTLR start T31
    public final void mT31() throws RecognitionException {
        try {
            int _type = T31;
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:9:5: ( '/' )
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:9:7: '/'
            {
            match('/'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T31

    // $ANTLR start T32
    public final void mT32() throws RecognitionException {
        try {
            int _type = T32;
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:10:5: ( '[' )
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:10:7: '['
            {
            match('['); 

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
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:11:5: ( ']' )
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:11:7: ']'
            {
            match(']'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T33

    // $ANTLR start OR
    public final void mOR() throws RecognitionException {
        try {
            int _type = OR;
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:157:3: ( 'or' )
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:157:5: 'or'
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
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:158:4: ( 'and' )
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:158:6: 'and'
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
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:159:3: ( '=' )
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:159:5: '='
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
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:160:4: ( '!=' )
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:160:6: '!='
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
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:161:3: ( '<' )
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:161:5: '<'
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
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:162:3: ( '>' )
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:162:5: '>'
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
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:163:3: ( '<=' )
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:163:5: '<='
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
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:164:3: ( '>=' )
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:164:5: '>='
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
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:165:5: ( '+' )
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:165:7: '+'
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
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:166:6: ( '-' )
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:166:8: '-'
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
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:167:4: ( '*' )
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:167:6: '*'
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
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:168:4: ( 'div' )
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:168:6: 'div'
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
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:169:4: ( 'mod' )
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:169:6: 'mod'
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
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:172:5: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '.' | '-' | '_' )* )
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:172:14: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '.' | '-' | '_' )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:172:37: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '.' | '-' | '_' )*
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
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:176:9: ( '\"' ( . )* '\"' | '\\'' ( . )* '\\'' )
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
                    new NoViableAltException("176:1: Literal : ( '\"' ( . )* '\"' | '\\'' ( . )* '\\'' );", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:177:5: '\"' ( . )* '\"'
                    {
                    match('\"'); 
                    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:177:9: ( . )*
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
                    	    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:177:9: .
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
                    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:178:5: '\\'' ( . )* '\\''
                    {
                    match('\''); 
                    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:178:10: ( . )*
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
                    	    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:178:10: .
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

    // $ANTLR start Number
    public final void mNumber() throws RecognitionException {
        try {
            int _type = Number;
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:181:8: ( ( '0' .. '9' )+ ( '.' ( '0' .. '9' )+ )? | '.' ( '0' .. '9' )+ )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( ((LA9_0>='0' && LA9_0<='9')) ) {
                alt9=1;
            }
            else if ( (LA9_0=='.') ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("181:1: Number : ( ( '0' .. '9' )+ ( '.' ( '0' .. '9' )+ )? | '.' ( '0' .. '9' )+ );", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:181:10: ( '0' .. '9' )+ ( '.' ( '0' .. '9' )+ )?
                    {
                    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:181:10: ( '0' .. '9' )+
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
                    	    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:181:11: '0' .. '9'
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

                    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:181:22: ( '.' ( '0' .. '9' )+ )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0=='.') ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:181:23: '.' ( '0' .. '9' )+
                            {
                            match('.'); 
                            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:181:27: ( '0' .. '9' )+
                            int cnt6=0;
                            loop6:
                            do {
                                int alt6=2;
                                int LA6_0 = input.LA(1);

                                if ( ((LA6_0>='0' && LA6_0<='9')) ) {
                                    alt6=1;
                                }


                                switch (alt6) {
                            	case 1 :
                            	    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:181:28: '0' .. '9'
                            	    {
                            	    matchRange('0','9'); 

                            	    }
                            	    break;

                            	default :
                            	    if ( cnt6 >= 1 ) break loop6;
                                        EarlyExitException eee =
                                            new EarlyExitException(6, input);
                                        throw eee;
                                }
                                cnt6++;
                            } while (true);


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:182:5: '.' ( '0' .. '9' )+
                    {
                    match('.'); 
                    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:182:9: ( '0' .. '9' )+
                    int cnt8=0;
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( ((LA8_0>='0' && LA8_0<='9')) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:182:10: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

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


                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end Number

    // $ANTLR start NEWLINE
    public final void mNEWLINE() throws RecognitionException {
        try {
            int _type = NEWLINE;
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:187:9: ( ( '\\r' )? '\\n' )
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:187:11: ( '\\r' )? '\\n'
            {
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:187:11: ( '\\r' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\r') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:187:11: '\\r'
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
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:190:4: ( ( ' ' | '\\t' | '\\n' | '\\r' )+ )
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:190:6: ( ' ' | '\\t' | '\\n' | '\\r' )+
            {
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:190:6: ( ' ' | '\\t' | '\\n' | '\\r' )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='\t' && LA11_0<='\n')||LA11_0=='\r'||LA11_0==' ') ) {
                    alt11=1;
                }


                switch (alt11) {
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
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
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
        // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:1:8: ( T28 | T29 | T30 | T31 | T32 | T33 | OR | AND | EQ | NEQ | LT | GT | LE | GE | PLUS | MINUS | MUL | DIV | MOD | Ref | Literal | Number | NEWLINE | WS )
        int alt12=24;
        switch ( input.LA(1) ) {
        case '(':
            {
            alt12=1;
            }
            break;
        case ')':
            {
            alt12=2;
            }
            break;
        case '.':
            {
            int LA12_3 = input.LA(2);

            if ( ((LA12_3>='0' && LA12_3<='9')) ) {
                alt12=22;
            }
            else {
                alt12=3;}
            }
            break;
        case '/':
            {
            alt12=4;
            }
            break;
        case '[':
            {
            alt12=5;
            }
            break;
        case ']':
            {
            alt12=6;
            }
            break;
        case 'o':
            {
            int LA12_7 = input.LA(2);

            if ( (LA12_7=='r') ) {
                int LA12_25 = input.LA(3);

                if ( ((LA12_25>='-' && LA12_25<='.')||(LA12_25>='0' && LA12_25<='9')||(LA12_25>='A' && LA12_25<='Z')||LA12_25=='_'||(LA12_25>='a' && LA12_25<='z')) ) {
                    alt12=20;
                }
                else {
                    alt12=7;}
            }
            else {
                alt12=20;}
            }
            break;
        case 'a':
            {
            int LA12_8 = input.LA(2);

            if ( (LA12_8=='n') ) {
                int LA12_26 = input.LA(3);

                if ( (LA12_26=='d') ) {
                    int LA12_35 = input.LA(4);

                    if ( ((LA12_35>='-' && LA12_35<='.')||(LA12_35>='0' && LA12_35<='9')||(LA12_35>='A' && LA12_35<='Z')||LA12_35=='_'||(LA12_35>='a' && LA12_35<='z')) ) {
                        alt12=20;
                    }
                    else {
                        alt12=8;}
                }
                else {
                    alt12=20;}
            }
            else {
                alt12=20;}
            }
            break;
        case '=':
            {
            alt12=9;
            }
            break;
        case '!':
            {
            alt12=10;
            }
            break;
        case '<':
            {
            int LA12_11 = input.LA(2);

            if ( (LA12_11=='=') ) {
                alt12=13;
            }
            else {
                alt12=11;}
            }
            break;
        case '>':
            {
            int LA12_12 = input.LA(2);

            if ( (LA12_12=='=') ) {
                alt12=14;
            }
            else {
                alt12=12;}
            }
            break;
        case '+':
            {
            alt12=15;
            }
            break;
        case '-':
            {
            alt12=16;
            }
            break;
        case '*':
            {
            alt12=17;
            }
            break;
        case 'd':
            {
            int LA12_16 = input.LA(2);

            if ( (LA12_16=='i') ) {
                int LA12_31 = input.LA(3);

                if ( (LA12_31=='v') ) {
                    int LA12_36 = input.LA(4);

                    if ( ((LA12_36>='-' && LA12_36<='.')||(LA12_36>='0' && LA12_36<='9')||(LA12_36>='A' && LA12_36<='Z')||LA12_36=='_'||(LA12_36>='a' && LA12_36<='z')) ) {
                        alt12=20;
                    }
                    else {
                        alt12=18;}
                }
                else {
                    alt12=20;}
            }
            else {
                alt12=20;}
            }
            break;
        case 'm':
            {
            int LA12_17 = input.LA(2);

            if ( (LA12_17=='o') ) {
                int LA12_32 = input.LA(3);

                if ( (LA12_32=='d') ) {
                    int LA12_37 = input.LA(4);

                    if ( ((LA12_37>='-' && LA12_37<='.')||(LA12_37>='0' && LA12_37<='9')||(LA12_37>='A' && LA12_37<='Z')||LA12_37=='_'||(LA12_37>='a' && LA12_37<='z')) ) {
                        alt12=20;
                    }
                    else {
                        alt12=19;}
                }
                else {
                    alt12=20;}
            }
            else {
                alt12=20;}
            }
            break;
        case 'A':
        case 'B':
        case 'C':
        case 'D':
        case 'E':
        case 'F':
        case 'G':
        case 'H':
        case 'I':
        case 'J':
        case 'K':
        case 'L':
        case 'M':
        case 'N':
        case 'O':
        case 'P':
        case 'Q':
        case 'R':
        case 'S':
        case 'T':
        case 'U':
        case 'V':
        case 'W':
        case 'X':
        case 'Y':
        case 'Z':
        case 'b':
        case 'c':
        case 'e':
        case 'f':
        case 'g':
        case 'h':
        case 'i':
        case 'j':
        case 'k':
        case 'l':
        case 'n':
        case 'p':
        case 'q':
        case 'r':
        case 's':
        case 't':
        case 'u':
        case 'v':
        case 'w':
        case 'x':
        case 'y':
        case 'z':
            {
            alt12=20;
            }
            break;
        case '\"':
        case '\'':
            {
            alt12=21;
            }
            break;
        case '0':
        case '1':
        case '2':
        case '3':
        case '4':
        case '5':
        case '6':
        case '7':
        case '8':
        case '9':
            {
            alt12=22;
            }
            break;
        case '\r':
            {
            int LA12_21 = input.LA(2);

            if ( (LA12_21=='\n') ) {
                int LA12_22 = input.LA(3);

                if ( ((LA12_22>='\t' && LA12_22<='\n')||LA12_22=='\r'||LA12_22==' ') ) {
                    alt12=24;
                }
                else {
                    alt12=23;}
            }
            else {
                alt12=24;}
            }
            break;
        case '\n':
            {
            int LA12_22 = input.LA(2);

            if ( ((LA12_22>='\t' && LA12_22<='\n')||LA12_22=='\r'||LA12_22==' ') ) {
                alt12=24;
            }
            else {
                alt12=23;}
            }
            break;
        case '\t':
        case ' ':
            {
            alt12=24;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("1:1: Tokens : ( T28 | T29 | T30 | T31 | T32 | T33 | OR | AND | EQ | NEQ | LT | GT | LE | GE | PLUS | MINUS | MUL | DIV | MOD | Ref | Literal | Number | NEWLINE | WS );", 12, 0, input);

            throw nvae;
        }

        switch (alt12) {
            case 1 :
                // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:1:10: T28
                {
                mT28(); 

                }
                break;
            case 2 :
                // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:1:14: T29
                {
                mT29(); 

                }
                break;
            case 3 :
                // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:1:18: T30
                {
                mT30(); 

                }
                break;
            case 4 :
                // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:1:22: T31
                {
                mT31(); 

                }
                break;
            case 5 :
                // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:1:26: T32
                {
                mT32(); 

                }
                break;
            case 6 :
                // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:1:30: T33
                {
                mT33(); 

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
                // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:1:95: Number
                {
                mNumber(); 

                }
                break;
            case 23 :
                // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:1:102: NEWLINE
                {
                mNEWLINE(); 

                }
                break;
            case 24 :
                // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:1:110: WS
                {
                mWS(); 

                }
                break;

        }

    }


 

}