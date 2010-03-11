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
// $ANTLR 3.0.1 C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g 2009-02-20 16:55:03
 
  package com.nokia.tools.vct.confml.expressions.confml.grammar;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class ConfmlParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "CURRENT_REF", "SIBLING_REF", "TOP_LEVEL_SETTING_REF", "SUB_SETTING_REF", "FILE_PATH_REF", "BOOLEAN", "OR", "AND", "EQ", "NEQ", "LT", "GT", "LE", "GE", "PLUS", "MINUS", "MUL", "DIV", "MOD", "Literal", "Number", "Ref", "NEWLINE", "WS", "'('", "')'", "'.'", "'/'", "'['", "']'"
    };
    public static final int Ref=25;
    public static final int MINUS=19;
    public static final int WS=27;
    public static final int EQ=12;
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
    public static final int LE=16;
    public static final int DIV=21;
    public static final int CURRENT_REF=4;
    public static final int SIBLING_REF=5;
    public static final int PLUS=18;
    public static final int Number=24;
    public static final int NEQ=13;

        public ConfmlParser(TokenStream input) {
            super(input);
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g"; }


      public boolean isFailed() {
        return lastErrorIndex != -1;
      }


    public static class expr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start expr
    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:51:1: expr : orExpr EOF ;
    public final expr_return expr() throws RecognitionException {
        expr_return retval = new expr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token EOF2=null;
        orExpr_return orExpr1 = null;


        CommonTree EOF2_tree=null;

        try {
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:51:5: ( orExpr EOF )
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:52:3: orExpr EOF
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_orExpr_in_expr98);
            orExpr1=orExpr();
            _fsp--;

            adaptor.addChild(root_0, orExpr1.getTree());
            EOF2=(Token)input.LT(1);
            match(input,EOF,FOLLOW_EOF_in_expr100); 

            }

            retval.stop = input.LT(-1);

                retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end expr

    public static class orExpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start orExpr
    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:56:1: orExpr : e= andExpr ( OR e2= andExpr )* ;
    public final orExpr_return orExpr() throws RecognitionException {
        orExpr_return retval = new orExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token OR3=null;
        andExpr_return e = null;

        andExpr_return e2 = null;


        CommonTree OR3_tree=null;

        try {
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:56:7: (e= andExpr ( OR e2= andExpr )* )
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:57:3: e= andExpr ( OR e2= andExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_andExpr_in_orExpr116);
            e=andExpr();
            _fsp--;

            adaptor.addChild(root_0, e.getTree());
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:58:3: ( OR e2= andExpr )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==OR) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:59:5: OR e2= andExpr
            	    {
            	    OR3=(Token)input.LT(1);
            	    match(input,OR,FOLLOW_OR_in_orExpr126); 
            	    OR3_tree = (CommonTree)adaptor.create(OR3);
            	    root_0 = (CommonTree)adaptor.becomeRoot(OR3_tree, root_0);

            	    pushFollow(FOLLOW_andExpr_in_orExpr134);
            	    e2=andExpr();
            	    _fsp--;

            	    adaptor.addChild(root_0, e2.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

                retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end orExpr

    public static class andExpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start andExpr
    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:63:1: andExpr : e= equalityExpr ( AND e2= equalityExpr )* ;
    public final andExpr_return andExpr() throws RecognitionException {
        andExpr_return retval = new andExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token AND4=null;
        equalityExpr_return e = null;

        equalityExpr_return e2 = null;


        CommonTree AND4_tree=null;

        try {
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:63:8: (e= equalityExpr ( AND e2= equalityExpr )* )
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:64:3: e= equalityExpr ( AND e2= equalityExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_equalityExpr_in_andExpr153);
            e=equalityExpr();
            _fsp--;

            adaptor.addChild(root_0, e.getTree());
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:65:3: ( AND e2= equalityExpr )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==AND) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:66:5: AND e2= equalityExpr
            	    {
            	    AND4=(Token)input.LT(1);
            	    match(input,AND,FOLLOW_AND_in_andExpr168); 
            	    AND4_tree = (CommonTree)adaptor.create(AND4);
            	    root_0 = (CommonTree)adaptor.becomeRoot(AND4_tree, root_0);

            	    pushFollow(FOLLOW_equalityExpr_in_andExpr175);
            	    e2=equalityExpr();
            	    _fsp--;

            	    adaptor.addChild(root_0, e2.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

                retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end andExpr

    public static class equalityExpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start equalityExpr
    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:70:1: equalityExpr : e= relationalExpr ( EQ e2= relationalExpr | NEQ e2= relationalExpr )* ;
    public final equalityExpr_return equalityExpr() throws RecognitionException {
        equalityExpr_return retval = new equalityExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token EQ5=null;
        Token NEQ6=null;
        relationalExpr_return e = null;

        relationalExpr_return e2 = null;


        CommonTree EQ5_tree=null;
        CommonTree NEQ6_tree=null;

        try {
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:70:13: (e= relationalExpr ( EQ e2= relationalExpr | NEQ e2= relationalExpr )* )
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:71:3: e= relationalExpr ( EQ e2= relationalExpr | NEQ e2= relationalExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_relationalExpr_in_equalityExpr202);
            e=relationalExpr();
            _fsp--;

            adaptor.addChild(root_0, e.getTree());
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:72:3: ( EQ e2= relationalExpr | NEQ e2= relationalExpr )*
            loop3:
            do {
                int alt3=3;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==EQ) ) {
                    alt3=1;
                }
                else if ( (LA3_0==NEQ) ) {
                    alt3=2;
                }


                switch (alt3) {
            	case 1 :
            	    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:73:5: EQ e2= relationalExpr
            	    {
            	    EQ5=(Token)input.LT(1);
            	    match(input,EQ,FOLLOW_EQ_in_equalityExpr212); 
            	    EQ5_tree = (CommonTree)adaptor.create(EQ5);
            	    root_0 = (CommonTree)adaptor.becomeRoot(EQ5_tree, root_0);

            	    pushFollow(FOLLOW_relationalExpr_in_equalityExpr221);
            	    e2=relationalExpr();
            	    _fsp--;

            	    adaptor.addChild(root_0, e2.getTree());

            	    }
            	    break;
            	case 2 :
            	    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:74:5: NEQ e2= relationalExpr
            	    {
            	    NEQ6=(Token)input.LT(1);
            	    match(input,NEQ,FOLLOW_NEQ_in_equalityExpr227); 
            	    NEQ6_tree = (CommonTree)adaptor.create(NEQ6);
            	    root_0 = (CommonTree)adaptor.becomeRoot(NEQ6_tree, root_0);

            	    pushFollow(FOLLOW_relationalExpr_in_equalityExpr235);
            	    e2=relationalExpr();
            	    _fsp--;

            	    adaptor.addChild(root_0, e2.getTree());

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

                retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end equalityExpr

    public static class relationalExpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start relationalExpr
    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:78:1: relationalExpr : e= additiveExpr ( LT e2= additiveExpr | GT e2= additiveExpr | LE e2= additiveExpr | GE e2= additiveExpr )* ;
    public final relationalExpr_return relationalExpr() throws RecognitionException {
        relationalExpr_return retval = new relationalExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LT7=null;
        Token GT8=null;
        Token LE9=null;
        Token GE10=null;
        additiveExpr_return e = null;

        additiveExpr_return e2 = null;


        CommonTree LT7_tree=null;
        CommonTree GT8_tree=null;
        CommonTree LE9_tree=null;
        CommonTree GE10_tree=null;

        try {
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:78:15: (e= additiveExpr ( LT e2= additiveExpr | GT e2= additiveExpr | LE e2= additiveExpr | GE e2= additiveExpr )* )
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:79:3: e= additiveExpr ( LT e2= additiveExpr | GT e2= additiveExpr | LE e2= additiveExpr | GE e2= additiveExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_additiveExpr_in_relationalExpr254);
            e=additiveExpr();
            _fsp--;

            adaptor.addChild(root_0, e.getTree());
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:80:3: ( LT e2= additiveExpr | GT e2= additiveExpr | LE e2= additiveExpr | GE e2= additiveExpr )*
            loop4:
            do {
                int alt4=5;
                switch ( input.LA(1) ) {
                case LT:
                    {
                    alt4=1;
                    }
                    break;
                case GT:
                    {
                    alt4=2;
                    }
                    break;
                case LE:
                    {
                    alt4=3;
                    }
                    break;
                case GE:
                    {
                    alt4=4;
                    }
                    break;

                }

                switch (alt4) {
            	case 1 :
            	    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:81:5: LT e2= additiveExpr
            	    {
            	    LT7=(Token)input.LT(1);
            	    match(input,LT,FOLLOW_LT_in_relationalExpr276); 
            	    LT7_tree = (CommonTree)adaptor.create(LT7);
            	    root_0 = (CommonTree)adaptor.becomeRoot(LT7_tree, root_0);

            	    pushFollow(FOLLOW_additiveExpr_in_relationalExpr285);
            	    e2=additiveExpr();
            	    _fsp--;

            	    adaptor.addChild(root_0, e2.getTree());

            	    }
            	    break;
            	case 2 :
            	    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:82:5: GT e2= additiveExpr
            	    {
            	    GT8=(Token)input.LT(1);
            	    match(input,GT,FOLLOW_GT_in_relationalExpr293); 
            	    GT8_tree = (CommonTree)adaptor.create(GT8);
            	    root_0 = (CommonTree)adaptor.becomeRoot(GT8_tree, root_0);

            	    pushFollow(FOLLOW_additiveExpr_in_relationalExpr302);
            	    e2=additiveExpr();
            	    _fsp--;

            	    adaptor.addChild(root_0, e2.getTree());

            	    }
            	    break;
            	case 3 :
            	    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:83:5: LE e2= additiveExpr
            	    {
            	    LE9=(Token)input.LT(1);
            	    match(input,LE,FOLLOW_LE_in_relationalExpr353); 
            	    LE9_tree = (CommonTree)adaptor.create(LE9);
            	    root_0 = (CommonTree)adaptor.becomeRoot(LE9_tree, root_0);

            	    pushFollow(FOLLOW_additiveExpr_in_relationalExpr361);
            	    e2=additiveExpr();
            	    _fsp--;

            	    adaptor.addChild(root_0, e2.getTree());

            	    }
            	    break;
            	case 4 :
            	    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:84:5: GE e2= additiveExpr
            	    {
            	    GE10=(Token)input.LT(1);
            	    match(input,GE,FOLLOW_GE_in_relationalExpr369); 
            	    GE10_tree = (CommonTree)adaptor.create(GE10);
            	    root_0 = (CommonTree)adaptor.becomeRoot(GE10_tree, root_0);

            	    pushFollow(FOLLOW_additiveExpr_in_relationalExpr377);
            	    e2=additiveExpr();
            	    _fsp--;

            	    adaptor.addChild(root_0, e2.getTree());

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

                retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end relationalExpr

    public static class additiveExpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start additiveExpr
    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:89:1: additiveExpr : multiplicativeExpr ( PLUS e= multiplicativeExpr | MINUS e= multiplicativeExpr )* ;
    public final additiveExpr_return additiveExpr() throws RecognitionException {
        additiveExpr_return retval = new additiveExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token PLUS12=null;
        Token MINUS13=null;
        multiplicativeExpr_return e = null;

        multiplicativeExpr_return multiplicativeExpr11 = null;


        CommonTree PLUS12_tree=null;
        CommonTree MINUS13_tree=null;

        try {
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:89:13: ( multiplicativeExpr ( PLUS e= multiplicativeExpr | MINUS e= multiplicativeExpr )* )
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:90:2: multiplicativeExpr ( PLUS e= multiplicativeExpr | MINUS e= multiplicativeExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_multiplicativeExpr_in_additiveExpr397);
            multiplicativeExpr11=multiplicativeExpr();
            _fsp--;

            adaptor.addChild(root_0, multiplicativeExpr11.getTree());
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:91:2: ( PLUS e= multiplicativeExpr | MINUS e= multiplicativeExpr )*
            loop5:
            do {
                int alt5=3;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==PLUS) ) {
                    alt5=1;
                }
                else if ( (LA5_0==MINUS) ) {
                    alt5=2;
                }


                switch (alt5) {
            	case 1 :
            	    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:92:4: PLUS e= multiplicativeExpr
            	    {
            	    PLUS12=(Token)input.LT(1);
            	    match(input,PLUS,FOLLOW_PLUS_in_additiveExpr405); 
            	    PLUS12_tree = (CommonTree)adaptor.create(PLUS12);
            	    root_0 = (CommonTree)adaptor.becomeRoot(PLUS12_tree, root_0);

            	    pushFollow(FOLLOW_multiplicativeExpr_in_additiveExpr414);
            	    e=multiplicativeExpr();
            	    _fsp--;

            	    adaptor.addChild(root_0, e.getTree());

            	    }
            	    break;
            	case 2 :
            	    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:93:7: MINUS e= multiplicativeExpr
            	    {
            	    MINUS13=(Token)input.LT(1);
            	    match(input,MINUS,FOLLOW_MINUS_in_additiveExpr423); 
            	    MINUS13_tree = (CommonTree)adaptor.create(MINUS13);
            	    root_0 = (CommonTree)adaptor.becomeRoot(MINUS13_tree, root_0);

            	    pushFollow(FOLLOW_multiplicativeExpr_in_additiveExpr432);
            	    e=multiplicativeExpr();
            	    _fsp--;

            	    adaptor.addChild(root_0, e.getTree());

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

                retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end additiveExpr

    public static class multiplicativeExpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start multiplicativeExpr
    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:97:1: multiplicativeExpr : e= unaryExpr ( MUL e2= unaryExpr | DIV e2= unaryExpr | MOD e2= unaryExpr )* ;
    public final multiplicativeExpr_return multiplicativeExpr() throws RecognitionException {
        multiplicativeExpr_return retval = new multiplicativeExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token MUL14=null;
        Token DIV15=null;
        Token MOD16=null;
        unaryExpr_return e = null;

        unaryExpr_return e2 = null;


        CommonTree MUL14_tree=null;
        CommonTree DIV15_tree=null;
        CommonTree MOD16_tree=null;

        try {
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:97:19: (e= unaryExpr ( MUL e2= unaryExpr | DIV e2= unaryExpr | MOD e2= unaryExpr )* )
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:98:2: e= unaryExpr ( MUL e2= unaryExpr | DIV e2= unaryExpr | MOD e2= unaryExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_unaryExpr_in_multiplicativeExpr451);
            e=unaryExpr();
            _fsp--;

            adaptor.addChild(root_0, e.getTree());
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:99:2: ( MUL e2= unaryExpr | DIV e2= unaryExpr | MOD e2= unaryExpr )*
            loop6:
            do {
                int alt6=4;
                switch ( input.LA(1) ) {
                case MUL:
                    {
                    alt6=1;
                    }
                    break;
                case DIV:
                    {
                    alt6=2;
                    }
                    break;
                case MOD:
                    {
                    alt6=3;
                    }
                    break;

                }

                switch (alt6) {
            	case 1 :
            	    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:100:4: MUL e2= unaryExpr
            	    {
            	    MUL14=(Token)input.LT(1);
            	    match(input,MUL,FOLLOW_MUL_in_multiplicativeExpr459); 
            	    MUL14_tree = (CommonTree)adaptor.create(MUL14);
            	    root_0 = (CommonTree)adaptor.becomeRoot(MUL14_tree, root_0);

            	    pushFollow(FOLLOW_unaryExpr_in_multiplicativeExpr468);
            	    e2=unaryExpr();
            	    _fsp--;

            	    adaptor.addChild(root_0, e2.getTree());

            	    }
            	    break;
            	case 2 :
            	    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:101:4: DIV e2= unaryExpr
            	    {
            	    DIV15=(Token)input.LT(1);
            	    match(input,DIV,FOLLOW_DIV_in_multiplicativeExpr473); 
            	    DIV15_tree = (CommonTree)adaptor.create(DIV15);
            	    root_0 = (CommonTree)adaptor.becomeRoot(DIV15_tree, root_0);

            	    pushFollow(FOLLOW_unaryExpr_in_multiplicativeExpr480);
            	    e2=unaryExpr();
            	    _fsp--;

            	    adaptor.addChild(root_0, e2.getTree());

            	    }
            	    break;
            	case 3 :
            	    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:102:4: MOD e2= unaryExpr
            	    {
            	    MOD16=(Token)input.LT(1);
            	    match(input,MOD,FOLLOW_MOD_in_multiplicativeExpr485); 
            	    MOD16_tree = (CommonTree)adaptor.create(MOD16);
            	    root_0 = (CommonTree)adaptor.becomeRoot(MOD16_tree, root_0);

            	    pushFollow(FOLLOW_unaryExpr_in_multiplicativeExpr492);
            	    e2=unaryExpr();
            	    _fsp--;

            	    adaptor.addChild(root_0, e2.getTree());

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

                retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end multiplicativeExpr

    public static class unaryExpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start unaryExpr
    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:106:1: unaryExpr : ( primaryExpr | MINUS primaryExpr );
    public final unaryExpr_return unaryExpr() throws RecognitionException {
        unaryExpr_return retval = new unaryExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token MINUS18=null;
        primaryExpr_return primaryExpr17 = null;

        primaryExpr_return primaryExpr19 = null;


        CommonTree MINUS18_tree=null;

        try {
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:106:10: ( primaryExpr | MINUS primaryExpr )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>=Literal && LA7_0<=Ref)||LA7_0==28||LA7_0==30) ) {
                alt7=1;
            }
            else if ( (LA7_0==MINUS) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("106:1: unaryExpr : ( primaryExpr | MINUS primaryExpr );", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:107:3: primaryExpr
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_primaryExpr_in_unaryExpr508);
                    primaryExpr17=primaryExpr();
                    _fsp--;

                    adaptor.addChild(root_0, primaryExpr17.getTree());

                    }
                    break;
                case 2 :
                    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:108:5: MINUS primaryExpr
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    MINUS18=(Token)input.LT(1);
                    match(input,MINUS,FOLLOW_MINUS_in_unaryExpr514); 
                    MINUS18_tree = (CommonTree)adaptor.create(MINUS18);
                    root_0 = (CommonTree)adaptor.becomeRoot(MINUS18_tree, root_0);

                    pushFollow(FOLLOW_primaryExpr_in_unaryExpr517);
                    primaryExpr19=primaryExpr();
                    _fsp--;

                    adaptor.addChild(root_0, primaryExpr19.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

                retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end unaryExpr

    public static class primaryExpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start primaryExpr
    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:111:1: primaryExpr : ( settingValueRef | '(' orExpr ')' | Literal | Number );
    public final primaryExpr_return primaryExpr() throws RecognitionException {
        primaryExpr_return retval = new primaryExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal21=null;
        Token char_literal23=null;
        Token Literal24=null;
        Token Number25=null;
        settingValueRef_return settingValueRef20 = null;

        orExpr_return orExpr22 = null;


        CommonTree char_literal21_tree=null;
        CommonTree char_literal23_tree=null;
        CommonTree Literal24_tree=null;
        CommonTree Number25_tree=null;

        try {
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:111:12: ( settingValueRef | '(' orExpr ')' | Literal | Number )
            int alt8=4;
            switch ( input.LA(1) ) {
            case Ref:
            case 30:
                {
                alt8=1;
                }
                break;
            case 28:
                {
                alt8=2;
                }
                break;
            case Literal:
                {
                alt8=3;
                }
                break;
            case Number:
                {
                alt8=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("111:1: primaryExpr : ( settingValueRef | '(' orExpr ')' | Literal | Number );", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:112:3: settingValueRef
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_settingValueRef_in_primaryExpr528);
                    settingValueRef20=settingValueRef();
                    _fsp--;

                    adaptor.addChild(root_0, settingValueRef20.getTree());

                    }
                    break;
                case 2 :
                    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:113:5: '(' orExpr ')'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    char_literal21=(Token)input.LT(1);
                    match(input,28,FOLLOW_28_in_primaryExpr534); 
                    char_literal21_tree = (CommonTree)adaptor.create(char_literal21);
                    adaptor.addChild(root_0, char_literal21_tree);

                    pushFollow(FOLLOW_orExpr_in_primaryExpr536);
                    orExpr22=orExpr();
                    _fsp--;

                    adaptor.addChild(root_0, orExpr22.getTree());
                    char_literal23=(Token)input.LT(1);
                    match(input,29,FOLLOW_29_in_primaryExpr538); 
                    char_literal23_tree = (CommonTree)adaptor.create(char_literal23);
                    adaptor.addChild(root_0, char_literal23_tree);


                    }
                    break;
                case 3 :
                    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:114:5: Literal
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    Literal24=(Token)input.LT(1);
                    match(input,Literal,FOLLOW_Literal_in_primaryExpr544); 
                    Literal24_tree = (CommonTree)adaptor.create(Literal24);
                    adaptor.addChild(root_0, Literal24_tree);


                    }
                    break;
                case 4 :
                    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:115:5: Number
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    Number25=(Token)input.LT(1);
                    match(input,Number,FOLLOW_Number_in_primaryExpr550); 
                    Number25_tree = (CommonTree)adaptor.create(Number25);
                    adaptor.addChild(root_0, Number25_tree);


                    }
                    break;

            }
            retval.stop = input.LT(-1);

                retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end primaryExpr

    public static class settingValueRef_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start settingValueRef
    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:120:1: settingValueRef : ( currentRef | siblingRef | topLevelSettingRef | subSettingRef | filePathRef );
    public final settingValueRef_return settingValueRef() throws RecognitionException {
        settingValueRef_return retval = new settingValueRef_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        currentRef_return currentRef26 = null;

        siblingRef_return siblingRef27 = null;

        topLevelSettingRef_return topLevelSettingRef28 = null;

        subSettingRef_return subSettingRef29 = null;

        filePathRef_return filePathRef30 = null;



        try {
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:120:16: ( currentRef | siblingRef | topLevelSettingRef | subSettingRef | filePathRef )
            int alt9=5;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==30) ) {
                alt9=1;
            }
            else if ( (LA9_0==Ref) ) {
                int LA9_2 = input.LA(2);

                if ( (LA9_2==31) ) {
                    int LA9_3 = input.LA(3);

                    if ( (LA9_3==Ref) ) {
                        switch ( input.LA(4) ) {
                        case 31:
                            {
                            alt9=5;
                            }
                            break;
                        case 32:
                            {
                            alt9=4;
                            }
                            break;
                        case EOF:
                        case OR:
                        case AND:
                        case EQ:
                        case NEQ:
                        case LT:
                        case GT:
                        case LE:
                        case GE:
                        case PLUS:
                        case MINUS:
                        case MUL:
                        case DIV:
                        case MOD:
                        case 29:
                            {
                            alt9=3;
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("120:1: settingValueRef : ( currentRef | siblingRef | topLevelSettingRef | subSettingRef | filePathRef );", 9, 5, input);

                            throw nvae;
                        }

                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("120:1: settingValueRef : ( currentRef | siblingRef | topLevelSettingRef | subSettingRef | filePathRef );", 9, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA9_2==EOF||(LA9_2>=OR && LA9_2<=MOD)||LA9_2==29) ) {
                    alt9=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("120:1: settingValueRef : ( currentRef | siblingRef | topLevelSettingRef | subSettingRef | filePathRef );", 9, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("120:1: settingValueRef : ( currentRef | siblingRef | topLevelSettingRef | subSettingRef | filePathRef );", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:121:3: currentRef
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_currentRef_in_settingValueRef562);
                    currentRef26=currentRef();
                    _fsp--;

                    adaptor.addChild(root_0, currentRef26.getTree());

                    }
                    break;
                case 2 :
                    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:122:5: siblingRef
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_siblingRef_in_settingValueRef568);
                    siblingRef27=siblingRef();
                    _fsp--;

                    adaptor.addChild(root_0, siblingRef27.getTree());

                    }
                    break;
                case 3 :
                    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:123:5: topLevelSettingRef
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_topLevelSettingRef_in_settingValueRef574);
                    topLevelSettingRef28=topLevelSettingRef();
                    _fsp--;

                    adaptor.addChild(root_0, topLevelSettingRef28.getTree());

                    }
                    break;
                case 4 :
                    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:124:5: subSettingRef
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_subSettingRef_in_settingValueRef580);
                    subSettingRef29=subSettingRef();
                    _fsp--;

                    adaptor.addChild(root_0, subSettingRef29.getTree());

                    }
                    break;
                case 5 :
                    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:125:5: filePathRef
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_filePathRef_in_settingValueRef586);
                    filePathRef30=filePathRef();
                    _fsp--;

                    adaptor.addChild(root_0, filePathRef30.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

                retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end settingValueRef

    public static class currentRef_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start currentRef
    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:129:1: currentRef : '.' -> CURRENT_REF[\".\"] ;
    public final currentRef_return currentRef() throws RecognitionException {
        currentRef_return retval = new currentRef_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal31=null;

        CommonTree char_literal31_tree=null;
        RewriteRuleTokenStream stream_30=new RewriteRuleTokenStream(adaptor,"token 30");

        try {
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:129:11: ( '.' -> CURRENT_REF[\".\"] )
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:130:3: '.'
            {
            char_literal31=(Token)input.LT(1);
            match(input,30,FOLLOW_30_in_currentRef597); 
            stream_30.add(char_literal31);


            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 130:7: -> CURRENT_REF[\".\"]
            {
                adaptor.addChild(root_0, adaptor.create(CURRENT_REF, "."));

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end currentRef

    public static class siblingRef_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start siblingRef
    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:134:1: siblingRef : r= Ref -> SIBLING_REF[val] ;
    public final siblingRef_return siblingRef() throws RecognitionException {
        siblingRef_return retval = new siblingRef_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token r=null;

        CommonTree r_tree=null;
        RewriteRuleTokenStream stream_Ref=new RewriteRuleTokenStream(adaptor,"token Ref");

        try {
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:134:11: (r= Ref -> SIBLING_REF[val] )
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:135:3: r= Ref
            {
            r=(Token)input.LT(1);
            match(input,Ref,FOLLOW_Ref_in_siblingRef617); 
            stream_Ref.add(r);

             String val = r.getText(); 

            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 135:42: -> SIBLING_REF[val]
            {
                adaptor.addChild(root_0, adaptor.create(SIBLING_REF, val));

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end siblingRef

    public static class topLevelSettingRef_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start topLevelSettingRef
    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:138:1: topLevelSettingRef : r1= Ref '/' r2= Ref -> TOP_LEVEL_SETTING_REF[val] ;
    public final topLevelSettingRef_return topLevelSettingRef() throws RecognitionException {
        topLevelSettingRef_return retval = new topLevelSettingRef_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token r1=null;
        Token r2=null;
        Token char_literal32=null;

        CommonTree r1_tree=null;
        CommonTree r2_tree=null;
        CommonTree char_literal32_tree=null;
        RewriteRuleTokenStream stream_Ref=new RewriteRuleTokenStream(adaptor,"token Ref");
        RewriteRuleTokenStream stream_31=new RewriteRuleTokenStream(adaptor,"token 31");

        try {
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:138:19: (r1= Ref '/' r2= Ref -> TOP_LEVEL_SETTING_REF[val] )
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:139:3: r1= Ref '/' r2= Ref
            {
            r1=(Token)input.LT(1);
            match(input,Ref,FOLLOW_Ref_in_topLevelSettingRef638); 
            stream_Ref.add(r1);

            char_literal32=(Token)input.LT(1);
            match(input,31,FOLLOW_31_in_topLevelSettingRef640); 
            stream_31.add(char_literal32);

            r2=(Token)input.LT(1);
            match(input,Ref,FOLLOW_Ref_in_topLevelSettingRef646); 
            stream_Ref.add(r2);

            String val = r1.getText()+"/"+r2.getText();

            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 139:73: -> TOP_LEVEL_SETTING_REF[val]
            {
                adaptor.addChild(root_0, adaptor.create(TOP_LEVEL_SETTING_REF, val));

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end topLevelSettingRef

    public static class subSettingRef_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start subSettingRef
    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:142:1: subSettingRef : r1= Ref '/' rx= Ref '[' n= Number ']' '/' rs= Ref -> SUB_SETTING_REF[val] ;
    public final subSettingRef_return subSettingRef() throws RecognitionException {
        subSettingRef_return retval = new subSettingRef_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token r1=null;
        Token rx=null;
        Token n=null;
        Token rs=null;
        Token char_literal33=null;
        Token char_literal34=null;
        Token char_literal35=null;
        Token char_literal36=null;

        CommonTree r1_tree=null;
        CommonTree rx_tree=null;
        CommonTree n_tree=null;
        CommonTree rs_tree=null;
        CommonTree char_literal33_tree=null;
        CommonTree char_literal34_tree=null;
        CommonTree char_literal35_tree=null;
        CommonTree char_literal36_tree=null;
        RewriteRuleTokenStream stream_32=new RewriteRuleTokenStream(adaptor,"token 32");
        RewriteRuleTokenStream stream_Ref=new RewriteRuleTokenStream(adaptor,"token Ref");
        RewriteRuleTokenStream stream_Number=new RewriteRuleTokenStream(adaptor,"token Number");
        RewriteRuleTokenStream stream_33=new RewriteRuleTokenStream(adaptor,"token 33");
        RewriteRuleTokenStream stream_31=new RewriteRuleTokenStream(adaptor,"token 31");

        try {
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:142:14: (r1= Ref '/' rx= Ref '[' n= Number ']' '/' rs= Ref -> SUB_SETTING_REF[val] )
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:143:3: r1= Ref '/' rx= Ref '[' n= Number ']' '/' rs= Ref
            {
            r1=(Token)input.LT(1);
            match(input,Ref,FOLLOW_Ref_in_subSettingRef667); 
            stream_Ref.add(r1);

            char_literal33=(Token)input.LT(1);
            match(input,31,FOLLOW_31_in_subSettingRef669); 
            stream_31.add(char_literal33);

            rx=(Token)input.LT(1);
            match(input,Ref,FOLLOW_Ref_in_subSettingRef675); 
            stream_Ref.add(rx);

            char_literal34=(Token)input.LT(1);
            match(input,32,FOLLOW_32_in_subSettingRef677); 
            stream_32.add(char_literal34);

            n=(Token)input.LT(1);
            match(input,Number,FOLLOW_Number_in_subSettingRef683); 
            stream_Number.add(n);

            char_literal35=(Token)input.LT(1);
            match(input,33,FOLLOW_33_in_subSettingRef685); 
            stream_33.add(char_literal35);

            char_literal36=(Token)input.LT(1);
            match(input,31,FOLLOW_31_in_subSettingRef687); 
            stream_31.add(char_literal36);

            rs=(Token)input.LT(1);
            match(input,Ref,FOLLOW_Ref_in_subSettingRef693); 
            stream_Ref.add(rs);

            String val = r1.getText()+"/"+rx.getText() + "[" + n.getText() + "]/" + rs.getText();

            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 144:93: -> SUB_SETTING_REF[val]
            {
                adaptor.addChild(root_0, adaptor.create(SUB_SETTING_REF, val));

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end subSettingRef

    public static class filePathRef_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start filePathRef
    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:148:1: filePathRef : r1= Ref '/' r2= Ref '/' r3= Ref -> FILE_PATH_REF[val] ;
    public final filePathRef_return filePathRef() throws RecognitionException {
        filePathRef_return retval = new filePathRef_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token r1=null;
        Token r2=null;
        Token r3=null;
        Token char_literal37=null;
        Token char_literal38=null;

        CommonTree r1_tree=null;
        CommonTree r2_tree=null;
        CommonTree r3_tree=null;
        CommonTree char_literal37_tree=null;
        CommonTree char_literal38_tree=null;
        RewriteRuleTokenStream stream_Ref=new RewriteRuleTokenStream(adaptor,"token Ref");
        RewriteRuleTokenStream stream_31=new RewriteRuleTokenStream(adaptor,"token 31");

        try {
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:148:12: (r1= Ref '/' r2= Ref '/' r3= Ref -> FILE_PATH_REF[val] )
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:149:3: r1= Ref '/' r2= Ref '/' r3= Ref
            {
            r1=(Token)input.LT(1);
            match(input,Ref,FOLLOW_Ref_in_filePathRef717); 
            stream_Ref.add(r1);

            char_literal37=(Token)input.LT(1);
            match(input,31,FOLLOW_31_in_filePathRef719); 
            stream_31.add(char_literal37);

            r2=(Token)input.LT(1);
            match(input,Ref,FOLLOW_Ref_in_filePathRef725); 
            stream_Ref.add(r2);

            char_literal38=(Token)input.LT(1);
            match(input,31,FOLLOW_31_in_filePathRef727); 
            stream_31.add(char_literal38);

            r3=(Token)input.LT(1);
            match(input,Ref,FOLLOW_Ref_in_filePathRef733); 
            stream_Ref.add(r3);

            String val = r1.getText()+"/"+r2.getText()+"/"+r3.getText();

            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 150:69: -> FILE_PATH_REF[val]
            {
                adaptor.addChild(root_0, adaptor.create(FILE_PATH_REF, val));

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end filePathRef


 

    public static final BitSet FOLLOW_orExpr_in_expr98 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_expr100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_andExpr_in_orExpr116 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_OR_in_orExpr126 = new BitSet(new long[]{0x0000000053880000L});
    public static final BitSet FOLLOW_andExpr_in_orExpr134 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_equalityExpr_in_andExpr153 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_AND_in_andExpr168 = new BitSet(new long[]{0x0000000053880000L});
    public static final BitSet FOLLOW_equalityExpr_in_andExpr175 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_relationalExpr_in_equalityExpr202 = new BitSet(new long[]{0x0000000000003002L});
    public static final BitSet FOLLOW_EQ_in_equalityExpr212 = new BitSet(new long[]{0x0000000053880000L});
    public static final BitSet FOLLOW_relationalExpr_in_equalityExpr221 = new BitSet(new long[]{0x0000000000003002L});
    public static final BitSet FOLLOW_NEQ_in_equalityExpr227 = new BitSet(new long[]{0x0000000053880000L});
    public static final BitSet FOLLOW_relationalExpr_in_equalityExpr235 = new BitSet(new long[]{0x0000000000003002L});
    public static final BitSet FOLLOW_additiveExpr_in_relationalExpr254 = new BitSet(new long[]{0x000000000003C002L});
    public static final BitSet FOLLOW_LT_in_relationalExpr276 = new BitSet(new long[]{0x0000000053880000L});
    public static final BitSet FOLLOW_additiveExpr_in_relationalExpr285 = new BitSet(new long[]{0x000000000003C002L});
    public static final BitSet FOLLOW_GT_in_relationalExpr293 = new BitSet(new long[]{0x0000000053880000L});
    public static final BitSet FOLLOW_additiveExpr_in_relationalExpr302 = new BitSet(new long[]{0x000000000003C002L});
    public static final BitSet FOLLOW_LE_in_relationalExpr353 = new BitSet(new long[]{0x0000000053880000L});
    public static final BitSet FOLLOW_additiveExpr_in_relationalExpr361 = new BitSet(new long[]{0x000000000003C002L});
    public static final BitSet FOLLOW_GE_in_relationalExpr369 = new BitSet(new long[]{0x0000000053880000L});
    public static final BitSet FOLLOW_additiveExpr_in_relationalExpr377 = new BitSet(new long[]{0x000000000003C002L});
    public static final BitSet FOLLOW_multiplicativeExpr_in_additiveExpr397 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_PLUS_in_additiveExpr405 = new BitSet(new long[]{0x0000000053880000L});
    public static final BitSet FOLLOW_multiplicativeExpr_in_additiveExpr414 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_MINUS_in_additiveExpr423 = new BitSet(new long[]{0x0000000053880000L});
    public static final BitSet FOLLOW_multiplicativeExpr_in_additiveExpr432 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_unaryExpr_in_multiplicativeExpr451 = new BitSet(new long[]{0x0000000000700002L});
    public static final BitSet FOLLOW_MUL_in_multiplicativeExpr459 = new BitSet(new long[]{0x0000000053880000L});
    public static final BitSet FOLLOW_unaryExpr_in_multiplicativeExpr468 = new BitSet(new long[]{0x0000000000700002L});
    public static final BitSet FOLLOW_DIV_in_multiplicativeExpr473 = new BitSet(new long[]{0x0000000053880000L});
    public static final BitSet FOLLOW_unaryExpr_in_multiplicativeExpr480 = new BitSet(new long[]{0x0000000000700002L});
    public static final BitSet FOLLOW_MOD_in_multiplicativeExpr485 = new BitSet(new long[]{0x0000000053880000L});
    public static final BitSet FOLLOW_unaryExpr_in_multiplicativeExpr492 = new BitSet(new long[]{0x0000000000700002L});
    public static final BitSet FOLLOW_primaryExpr_in_unaryExpr508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_unaryExpr514 = new BitSet(new long[]{0x0000000053800000L});
    public static final BitSet FOLLOW_primaryExpr_in_unaryExpr517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_settingValueRef_in_primaryExpr528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_primaryExpr534 = new BitSet(new long[]{0x0000000053880000L});
    public static final BitSet FOLLOW_orExpr_in_primaryExpr536 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_primaryExpr538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Literal_in_primaryExpr544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Number_in_primaryExpr550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_currentRef_in_settingValueRef562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_siblingRef_in_settingValueRef568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_topLevelSettingRef_in_settingValueRef574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_subSettingRef_in_settingValueRef580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_filePathRef_in_settingValueRef586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_currentRef597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ref_in_siblingRef617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ref_in_topLevelSettingRef638 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_topLevelSettingRef640 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_Ref_in_topLevelSettingRef646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ref_in_subSettingRef667 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_subSettingRef669 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_Ref_in_subSettingRef675 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_subSettingRef677 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_Number_in_subSettingRef683 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_subSettingRef685 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_subSettingRef687 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_Ref_in_subSettingRef693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ref_in_filePathRef717 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_filePathRef719 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_Ref_in_filePathRef725 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_filePathRef727 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_Ref_in_filePathRef733 = new BitSet(new long[]{0x0000000000000002L});

}