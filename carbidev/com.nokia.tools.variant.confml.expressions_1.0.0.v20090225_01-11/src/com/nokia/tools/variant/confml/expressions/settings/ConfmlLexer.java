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
 * Description: This file is part of com.nokia.tools.variant.confml.expressions component.
 */

// $ANTLR 3.0.1 C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g 2009-01-09 10:43:47

package com.nokia.tools.variant.confml.expressions.settings;


import org.antlr.runtime.CharStream;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;

public class ConfmlLexer extends Lexer {
    public static final int T27=27;
    public static final int T26=26;
    public static final int T9=9;
    public static final int T25=25;
    public static final int Tokens=28;
    public static final int T24=24;
    public static final int EOF=-1;
    public static final int T23=23;
    public static final int T22=22;
    public static final int T21=21;
    public static final int T20=20;
    public static final int Ref=7;
    public static final int Literal=5;
    public static final int WS=8;
    public static final int NEWLINE=4;
    public static final int Number=6;
    public static final int T10=10;
    public static final int T11=11;
    public static final int T12=12;
    public static final int T13=13;
    public static final int T14=14;
    public static final int T15=15;
    public static final int T16=16;
    public static final int T17=17;
    public static final int T18=18;
    public static final int T19=19;
    public ConfmlLexer() {;} 
    public ConfmlLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g"; }

    // $ANTLR start T9
    public final void mT9() throws RecognitionException {
        try {
            int _type = T9;
            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:6:4: ( 'or' )
            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:6:6: 'or'
            {
            match("or"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T9

    // $ANTLR start T10
    public final void mT10() throws RecognitionException {
        try {
            int _type = T10;
            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:7:5: ( 'and' )
            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:7:7: 'and'
            {
            match("and"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T10

    // $ANTLR start T11
    public final void mT11() throws RecognitionException {
        try {
            int _type = T11;
            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:8:5: ( '=' )
            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:8:7: '='
            {
            match('='); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T11

    // $ANTLR start T12
    public final void mT12() throws RecognitionException {
        try {
            int _type = T12;
            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:9:5: ( '!=' )
            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:9:7: '!='
            {
            match("!="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T12

    // $ANTLR start T13
    public final void mT13() throws RecognitionException {
        try {
            int _type = T13;
            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:10:5: ( '<' )
            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:10:7: '<'
            {
            match('<'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T13

    // $ANTLR start T14
    public final void mT14() throws RecognitionException {
        try {
            int _type = T14;
            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:11:5: ( '>' )
            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:11:7: '>'
            {
            match('>'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T14

    // $ANTLR start T15
    public final void mT15() throws RecognitionException {
        try {
            int _type = T15;
            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:12:5: ( '<=' )
            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:12:7: '<='
            {
            match("<="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T15

    // $ANTLR start T16
    public final void mT16() throws RecognitionException {
        try {
            int _type = T16;
            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:13:5: ( '>=' )
            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:13:7: '>='
            {
            match(">="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T16

    // $ANTLR start T17
    public final void mT17() throws RecognitionException {
        try {
            int _type = T17;
            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:14:5: ( '+' )
            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:14:7: '+'
            {
            match('+'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T17

    // $ANTLR start T18
    public final void mT18() throws RecognitionException {
        try {
            int _type = T18;
            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:15:5: ( '-' )
            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:15:7: '-'
            {
            match('-'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T18

    // $ANTLR start T19
    public final void mT19() throws RecognitionException {
        try {
            int _type = T19;
            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:16:5: ( '*' )
            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:16:7: '*'
            {
            match('*'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T19

    // $ANTLR start T20
    public final void mT20() throws RecognitionException {
        try {
            int _type = T20;
            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:17:5: ( 'div' )
            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:17:7: 'div'
            {
            match("div"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T20

    // $ANTLR start T21
    public final void mT21() throws RecognitionException {
        try {
            int _type = T21;
            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:18:5: ( 'mod' )
            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:18:7: 'mod'
            {
            match("mod"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T21

    // $ANTLR start T22
    public final void mT22() throws RecognitionException {
        try {
            int _type = T22;
            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:19:5: ( '(' )
            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:19:7: '('
            {
            match('('); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T22

    // $ANTLR start T23
    public final void mT23() throws RecognitionException {
        try {
            int _type = T23;
            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:20:5: ( ')' )
            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:20:7: ')'
            {
            match(')'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T23

    // $ANTLR start T24
    public final void mT24() throws RecognitionException {
        try {
            int _type = T24;
            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:21:5: ( '.' )
            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:21:7: '.'
            {
            match('.'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T24

    // $ANTLR start T25
    public final void mT25() throws RecognitionException {
        try {
            int _type = T25;
            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:22:5: ( '/' )
            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:22:7: '/'
            {
            match('/'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T25

    // $ANTLR start T26
    public final void mT26() throws RecognitionException {
        try {
            int _type = T26;
            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:23:5: ( '[' )
            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:23:7: '['
            {
            match('['); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T26

    // $ANTLR start T27
    public final void mT27() throws RecognitionException {
        try {
            int _type = T27;
            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:24:5: ( ']' )
            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:24:7: ']'
            {
            match(']'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T27

    // $ANTLR start Ref
    public final void mRef() throws RecognitionException {
        try {
            int _type = Ref;
            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:285:5: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '.' | '-' | '_' )* )
            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:285:14: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '.' | '-' | '_' )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:285:37: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '.' | '-' | '_' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='-' && LA1_0<='.')||(LA1_0>='0' && LA1_0<='9')||(LA1_0>='A' && LA1_0<='Z')||LA1_0=='_'||(LA1_0>='a' && LA1_0<='z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:
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
            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:288:9: ( '\"' ( . )* '\"' | '\\'' ( . )* '\\'' | '&apos;' ( . )* '&apos;' | '&quot;' ( . )* '&quot;' )
            int alt6=4;
            switch ( input.LA(1) ) {
            case '\"':
                {
                alt6=1;
                }
                break;
            case '\'':
                {
                alt6=2;
                }
                break;
            case '&':
                {
                int LA6_3 = input.LA(2);

                if ( (LA6_3=='q') ) {
                    alt6=4;
                }
                else if ( (LA6_3=='a') ) {
                    alt6=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("288:1: Literal : ( '\"' ( . )* '\"' | '\\'' ( . )* '\\'' | '&apos;' ( . )* '&apos;' | '&quot;' ( . )* '&quot;' );", 6, 3, input);

                    throw nvae;
                }
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("288:1: Literal : ( '\"' ( . )* '\"' | '\\'' ( . )* '\\'' | '&apos;' ( . )* '&apos;' | '&quot;' ( . )* '&quot;' );", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:289:5: '\"' ( . )* '\"'
                    {
                    match('\"'); 
                    // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:289:9: ( . )*
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
                    	    // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:289:9: .
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
                    // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:290:5: '\\'' ( . )* '\\''
                    {
                    match('\''); 
                    // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:290:10: ( . )*
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
                    	    // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:290:10: .
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
                case 3 :
                    // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:291:5: '&apos;' ( . )* '&apos;'
                    {
                    match("&apos;"); 

                    // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:291:14: ( . )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0=='&') ) {
                            int LA4_1 = input.LA(2);

                            if ( (LA4_1=='a') ) {
                                int LA4_3 = input.LA(3);

                                if ( (LA4_3=='p') ) {
                                    int LA4_4 = input.LA(4);

                                    if ( (LA4_4=='o') ) {
                                        int LA4_5 = input.LA(5);

                                        if ( (LA4_5=='s') ) {
                                            int LA4_6 = input.LA(6);

                                            if ( (LA4_6==';') ) {
                                                alt4=2;
                                            }
                                            else if ( ((LA4_6>='\u0000' && LA4_6<=':')||(LA4_6>='<' && LA4_6<='\uFFFE')) ) {
                                                alt4=1;
                                            }


                                        }
                                        else if ( ((LA4_5>='\u0000' && LA4_5<='r')||(LA4_5>='t' && LA4_5<='\uFFFE')) ) {
                                            alt4=1;
                                        }


                                    }
                                    else if ( ((LA4_4>='\u0000' && LA4_4<='n')||(LA4_4>='p' && LA4_4<='\uFFFE')) ) {
                                        alt4=1;
                                    }


                                }
                                else if ( ((LA4_3>='\u0000' && LA4_3<='o')||(LA4_3>='q' && LA4_3<='\uFFFE')) ) {
                                    alt4=1;
                                }


                            }
                            else if ( ((LA4_1>='\u0000' && LA4_1<='`')||(LA4_1>='b' && LA4_1<='\uFFFE')) ) {
                                alt4=1;
                            }


                        }
                        else if ( ((LA4_0>='\u0000' && LA4_0<='%')||(LA4_0>='\'' && LA4_0<='\uFFFE')) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:291:14: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);

                    match("&apos;"); 


                    }
                    break;
                case 4 :
                    // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:292:5: '&quot;' ( . )* '&quot;'
                    {
                    match("&quot;"); 

                    // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:292:14: ( . )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0=='&') ) {
                            int LA5_1 = input.LA(2);

                            if ( (LA5_1=='q') ) {
                                int LA5_3 = input.LA(3);

                                if ( (LA5_3=='u') ) {
                                    int LA5_4 = input.LA(4);

                                    if ( (LA5_4=='o') ) {
                                        int LA5_5 = input.LA(5);

                                        if ( (LA5_5=='t') ) {
                                            int LA5_6 = input.LA(6);

                                            if ( (LA5_6==';') ) {
                                                alt5=2;
                                            }
                                            else if ( ((LA5_6>='\u0000' && LA5_6<=':')||(LA5_6>='<' && LA5_6<='\uFFFE')) ) {
                                                alt5=1;
                                            }


                                        }
                                        else if ( ((LA5_5>='\u0000' && LA5_5<='s')||(LA5_5>='u' && LA5_5<='\uFFFE')) ) {
                                            alt5=1;
                                        }


                                    }
                                    else if ( ((LA5_4>='\u0000' && LA5_4<='n')||(LA5_4>='p' && LA5_4<='\uFFFE')) ) {
                                        alt5=1;
                                    }


                                }
                                else if ( ((LA5_3>='\u0000' && LA5_3<='t')||(LA5_3>='v' && LA5_3<='\uFFFE')) ) {
                                    alt5=1;
                                }


                            }
                            else if ( ((LA5_1>='\u0000' && LA5_1<='p')||(LA5_1>='r' && LA5_1<='\uFFFE')) ) {
                                alt5=1;
                            }


                        }
                        else if ( ((LA5_0>='\u0000' && LA5_0<='%')||(LA5_0>='\'' && LA5_0<='\uFFFE')) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:292:14: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    match("&quot;"); 


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
            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:295:8: ( ( '0' .. '9' )+ ( '.' ( '0' .. '9' )+ )? | '.' ( '0' .. '9' )+ )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( ((LA11_0>='0' && LA11_0<='9')) ) {
                alt11=1;
            }
            else if ( (LA11_0=='.') ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("295:1: Number : ( ( '0' .. '9' )+ ( '.' ( '0' .. '9' )+ )? | '.' ( '0' .. '9' )+ );", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:295:10: ( '0' .. '9' )+ ( '.' ( '0' .. '9' )+ )?
                    {
                    // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:295:10: ( '0' .. '9' )+
                    int cnt7=0;
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( ((LA7_0>='0' && LA7_0<='9')) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:295:11: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt7 >= 1 ) break loop7;
                                EarlyExitException eee =
                                    new EarlyExitException(7, input);
                                throw eee;
                        }
                        cnt7++;
                    } while (true);

                    // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:295:22: ( '.' ( '0' .. '9' )+ )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='.') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:295:23: '.' ( '0' .. '9' )+
                            {
                            match('.'); 
                            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:295:27: ( '0' .. '9' )+
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
                            	    // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:295:28: '0' .. '9'
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


                    }
                    break;
                case 2 :
                    // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:296:5: '.' ( '0' .. '9' )+
                    {
                    match('.'); 
                    // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:296:9: ( '0' .. '9' )+
                    int cnt10=0;
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( ((LA10_0>='0' && LA10_0<='9')) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:296:10: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt10 >= 1 ) break loop10;
                                EarlyExitException eee =
                                    new EarlyExitException(10, input);
                                throw eee;
                        }
                        cnt10++;
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
            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:299:9: ( ( '\\r' )? '\\n' )
            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:299:11: ( '\\r' )? '\\n'
            {
            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:299:11: ( '\\r' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0=='\r') ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:299:11: '\\r'
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
            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:302:4: ( ( ' ' | '\\t' | '\\n' | '\\r' )+ )
            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:302:6: ( ' ' | '\\t' | '\\n' | '\\r' )+
            {
            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:302:6: ( ' ' | '\\t' | '\\n' | '\\r' )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>='\t' && LA13_0<='\n')||LA13_0=='\r'||LA13_0==' ') ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:
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
            	    if ( cnt13 >= 1 ) break loop13;
                        EarlyExitException eee =
                            new EarlyExitException(13, input);
                        throw eee;
                }
                cnt13++;
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
        // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:1:8: ( T9 | T10 | T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | Ref | Literal | Number | NEWLINE | WS )
        int alt14=24;
        switch ( input.LA(1) ) {
        case 'o':
            {
            int LA14_1 = input.LA(2);

            if ( (LA14_1=='r') ) {
                int LA14_24 = input.LA(3);

                if ( ((LA14_24>='-' && LA14_24<='.')||(LA14_24>='0' && LA14_24<='9')||(LA14_24>='A' && LA14_24<='Z')||LA14_24=='_'||(LA14_24>='a' && LA14_24<='z')) ) {
                    alt14=20;
                }
                else {
                    alt14=1;}
            }
            else {
                alt14=20;}
            }
            break;
        case 'a':
            {
            int LA14_2 = input.LA(2);

            if ( (LA14_2=='n') ) {
                int LA14_25 = input.LA(3);

                if ( (LA14_25=='d') ) {
                    int LA14_35 = input.LA(4);

                    if ( ((LA14_35>='-' && LA14_35<='.')||(LA14_35>='0' && LA14_35<='9')||(LA14_35>='A' && LA14_35<='Z')||LA14_35=='_'||(LA14_35>='a' && LA14_35<='z')) ) {
                        alt14=20;
                    }
                    else {
                        alt14=2;}
                }
                else {
                    alt14=20;}
            }
            else {
                alt14=20;}
            }
            break;
        case '=':
            {
            alt14=3;
            }
            break;
        case '!':
            {
            alt14=4;
            }
            break;
        case '<':
            {
            int LA14_5 = input.LA(2);

            if ( (LA14_5=='=') ) {
                alt14=7;
            }
            else {
                alt14=5;}
            }
            break;
        case '>':
            {
            int LA14_6 = input.LA(2);

            if ( (LA14_6=='=') ) {
                alt14=8;
            }
            else {
                alt14=6;}
            }
            break;
        case '+':
            {
            alt14=9;
            }
            break;
        case '-':
            {
            alt14=10;
            }
            break;
        case '*':
            {
            alt14=11;
            }
            break;
        case 'd':
            {
            int LA14_10 = input.LA(2);

            if ( (LA14_10=='i') ) {
                int LA14_30 = input.LA(3);

                if ( (LA14_30=='v') ) {
                    int LA14_36 = input.LA(4);

                    if ( ((LA14_36>='-' && LA14_36<='.')||(LA14_36>='0' && LA14_36<='9')||(LA14_36>='A' && LA14_36<='Z')||LA14_36=='_'||(LA14_36>='a' && LA14_36<='z')) ) {
                        alt14=20;
                    }
                    else {
                        alt14=12;}
                }
                else {
                    alt14=20;}
            }
            else {
                alt14=20;}
            }
            break;
        case 'm':
            {
            int LA14_11 = input.LA(2);

            if ( (LA14_11=='o') ) {
                int LA14_31 = input.LA(3);

                if ( (LA14_31=='d') ) {
                    int LA14_37 = input.LA(4);

                    if ( ((LA14_37>='-' && LA14_37<='.')||(LA14_37>='0' && LA14_37<='9')||(LA14_37>='A' && LA14_37<='Z')||LA14_37=='_'||(LA14_37>='a' && LA14_37<='z')) ) {
                        alt14=20;
                    }
                    else {
                        alt14=13;}
                }
                else {
                    alt14=20;}
            }
            else {
                alt14=20;}
            }
            break;
        case '(':
            {
            alt14=14;
            }
            break;
        case ')':
            {
            alt14=15;
            }
            break;
        case '.':
            {
            int LA14_14 = input.LA(2);

            if ( ((LA14_14>='0' && LA14_14<='9')) ) {
                alt14=22;
            }
            else {
                alt14=16;}
            }
            break;
        case '/':
            {
            alt14=17;
            }
            break;
        case '[':
            {
            alt14=18;
            }
            break;
        case ']':
            {
            alt14=19;
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
            alt14=20;
            }
            break;
        case '\"':
        case '&':
        case '\'':
            {
            alt14=21;
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
            alt14=22;
            }
            break;
        case '\r':
            {
            int LA14_21 = input.LA(2);

            if ( (LA14_21=='\n') ) {
                int LA14_22 = input.LA(3);

                if ( ((LA14_22>='\t' && LA14_22<='\n')||LA14_22=='\r'||LA14_22==' ') ) {
                    alt14=24;
                }
                else {
                    alt14=23;}
            }
            else {
                alt14=24;}
            }
            break;
        case '\n':
            {
            int LA14_22 = input.LA(2);

            if ( ((LA14_22>='\t' && LA14_22<='\n')||LA14_22=='\r'||LA14_22==' ') ) {
                alt14=24;
            }
            else {
                alt14=23;}
            }
            break;
        case '\t':
        case ' ':
            {
            alt14=24;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("1:1: Tokens : ( T9 | T10 | T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | Ref | Literal | Number | NEWLINE | WS );", 14, 0, input);

            throw nvae;
        }

        switch (alt14) {
            case 1 :
                // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:1:10: T9
                {
                mT9(); 

                }
                break;
            case 2 :
                // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:1:13: T10
                {
                mT10(); 

                }
                break;
            case 3 :
                // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:1:17: T11
                {
                mT11(); 

                }
                break;
            case 4 :
                // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:1:21: T12
                {
                mT12(); 

                }
                break;
            case 5 :
                // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:1:25: T13
                {
                mT13(); 

                }
                break;
            case 6 :
                // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:1:29: T14
                {
                mT14(); 

                }
                break;
            case 7 :
                // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:1:33: T15
                {
                mT15(); 

                }
                break;
            case 8 :
                // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:1:37: T16
                {
                mT16(); 

                }
                break;
            case 9 :
                // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:1:41: T17
                {
                mT17(); 

                }
                break;
            case 10 :
                // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:1:45: T18
                {
                mT18(); 

                }
                break;
            case 11 :
                // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:1:49: T19
                {
                mT19(); 

                }
                break;
            case 12 :
                // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:1:53: T20
                {
                mT20(); 

                }
                break;
            case 13 :
                // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:1:57: T21
                {
                mT21(); 

                }
                break;
            case 14 :
                // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:1:61: T22
                {
                mT22(); 

                }
                break;
            case 15 :
                // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:1:65: T23
                {
                mT23(); 

                }
                break;
            case 16 :
                // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:1:69: T24
                {
                mT24(); 

                }
                break;
            case 17 :
                // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:1:73: T25
                {
                mT25(); 

                }
                break;
            case 18 :
                // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:1:77: T26
                {
                mT26(); 

                }
                break;
            case 19 :
                // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:1:81: T27
                {
                mT27(); 

                }
                break;
            case 20 :
                // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:1:85: Ref
                {
                mRef(); 

                }
                break;
            case 21 :
                // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:1:89: Literal
                {
                mLiteral(); 

                }
                break;
            case 22 :
                // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:1:97: Number
                {
                mNumber(); 

                }
                break;
            case 23 :
                // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:1:104: NEWLINE
                {
                mNEWLINE(); 

                }
                break;
            case 24 :
                // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:1:112: WS
                {
                mWS(); 

                }
                break;

        }

    }


 

}
