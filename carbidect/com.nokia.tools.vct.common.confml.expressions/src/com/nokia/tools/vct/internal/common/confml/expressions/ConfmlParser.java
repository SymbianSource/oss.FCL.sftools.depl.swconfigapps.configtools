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


import org.antlr.runtime.BitSet;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.Parser;
import org.antlr.runtime.ParserRuleReturnScope;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeAdaptor;
import org.antlr.runtime.tree.RewriteRuleSubtreeStream;
import org.antlr.runtime.tree.RewriteRuleTokenStream;
import org.antlr.runtime.tree.TreeAdaptor;

@SuppressWarnings("unused")
public class ConfmlParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "CURRENT_REF", "SIBLING_REF", "TOP_LEVEL_SETTING_REF", "SUB_SETTING_REF", "FILE_PATH_REF", "BOOLEAN", "Number", "OR", "AND", "EQ", "NEQ", "LT", "GT", "LE", "GE", "PLUS", "MINUS", "MUL", "DIV", "MOD", "Literal", "IntegerNumber", "RealNumber", "ScientificNumber", "Ref", "Exponent", "NEWLINE", "WS", "'('", "')'", "'.'", "'/'", "'['", "']'"
    };
    public static final int Ref=28;
    public static final int MINUS=20;
    public static final int Exponent=29;
    public static final int WS=31;
    public static final int EQ=13;
    public static final int LT=15;
    public static final int GT=16;
    public static final int Literal=24;
    public static final int MOD=23;
    public static final int SUB_SETTING_REF=7;
    public static final int IntegerNumber=25;
    public static final int OR=11;
    public static final int FILE_PATH_REF=8;
    public static final int NEWLINE=30;
    public static final int GE=18;
    public static final int MUL=21;
    public static final int AND=12;
    public static final int BOOLEAN=9;
    public static final int ScientificNumber=27;
    public static final int TOP_LEVEL_SETTING_REF=6;
    public static final int EOF=-1;
    public static final int LE=17;
    public static final int RealNumber=26;
    public static final int DIV=22;
    public static final int CURRENT_REF=4;
    public static final int SIBLING_REF=5;
    public static final int PLUS=19;
    public static final int Number=10;
    public static final int NEQ=14;

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
    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:63:1: expr : orExpr ;
    public final expr_return expr() throws RecognitionException {
        expr_return retval = new expr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        orExpr_return orExpr1 = null;



        try {
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:63:5: ( orExpr )
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:64:3: orExpr
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_orExpr_in_expr117);
            orExpr1=orExpr();
            _fsp--;

            adaptor.addChild(root_0, orExpr1.getTree());

            }

            retval.stop = input.LT(-1);

                retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

          catch (RecognitionException __exc) {
            throw __exc;
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
    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:68:1: orExpr : e= andExpr ( OR e2= andExpr )* ;
    public final orExpr_return orExpr() throws RecognitionException {
        orExpr_return retval = new orExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token OR2=null;
        andExpr_return e = null;

        andExpr_return e2 = null;


        CommonTree OR2_tree=null;

        try {
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:68:7: (e= andExpr ( OR e2= andExpr )* )
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:69:3: e= andExpr ( OR e2= andExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_andExpr_in_orExpr132);
            e=andExpr();
            _fsp--;

            adaptor.addChild(root_0, e.getTree());
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:70:3: ( OR e2= andExpr )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==OR) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:71:5: OR e2= andExpr
            	    {
            	    OR2=(Token)input.LT(1);
            	    match(input,OR,FOLLOW_OR_in_orExpr142); 
            	    OR2_tree = (CommonTree)adaptor.create(OR2);
            	    root_0 = (CommonTree)adaptor.becomeRoot(OR2_tree, root_0);

            	    pushFollow(FOLLOW_andExpr_in_orExpr150);
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

          catch (RecognitionException __exc) {
            throw __exc;
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
    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:75:1: andExpr : e= equalityExpr ( AND e2= equalityExpr )* ;
    public final andExpr_return andExpr() throws RecognitionException {
        andExpr_return retval = new andExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token AND3=null;
        equalityExpr_return e = null;

        equalityExpr_return e2 = null;


        CommonTree AND3_tree=null;

        try {
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:75:8: (e= equalityExpr ( AND e2= equalityExpr )* )
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:76:3: e= equalityExpr ( AND e2= equalityExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_equalityExpr_in_andExpr169);
            e=equalityExpr();
            _fsp--;

            adaptor.addChild(root_0, e.getTree());
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:77:3: ( AND e2= equalityExpr )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==AND) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:78:5: AND e2= equalityExpr
            	    {
            	    AND3=(Token)input.LT(1);
            	    match(input,AND,FOLLOW_AND_in_andExpr184); 
            	    AND3_tree = (CommonTree)adaptor.create(AND3);
            	    root_0 = (CommonTree)adaptor.becomeRoot(AND3_tree, root_0);

            	    pushFollow(FOLLOW_equalityExpr_in_andExpr191);
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

          catch (RecognitionException __exc) {
            throw __exc;
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
    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:82:1: equalityExpr : e= relationalExpr ( EQ e2= relationalExpr | NEQ e2= relationalExpr )* ;
    public final equalityExpr_return equalityExpr() throws RecognitionException {
        equalityExpr_return retval = new equalityExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token EQ4=null;
        Token NEQ5=null;
        relationalExpr_return e = null;

        relationalExpr_return e2 = null;


        CommonTree EQ4_tree=null;
        CommonTree NEQ5_tree=null;

        try {
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:82:13: (e= relationalExpr ( EQ e2= relationalExpr | NEQ e2= relationalExpr )* )
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:83:3: e= relationalExpr ( EQ e2= relationalExpr | NEQ e2= relationalExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_relationalExpr_in_equalityExpr218);
            e=relationalExpr();
            _fsp--;

            adaptor.addChild(root_0, e.getTree());
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:84:3: ( EQ e2= relationalExpr | NEQ e2= relationalExpr )*
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
            	    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:85:5: EQ e2= relationalExpr
            	    {
            	    EQ4=(Token)input.LT(1);
            	    match(input,EQ,FOLLOW_EQ_in_equalityExpr228); 
            	    EQ4_tree = (CommonTree)adaptor.create(EQ4);
            	    root_0 = (CommonTree)adaptor.becomeRoot(EQ4_tree, root_0);

            	    pushFollow(FOLLOW_relationalExpr_in_equalityExpr237);
            	    e2=relationalExpr();
            	    _fsp--;

            	    adaptor.addChild(root_0, e2.getTree());

            	    }
            	    break;
            	case 2 :
            	    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:86:5: NEQ e2= relationalExpr
            	    {
            	    NEQ5=(Token)input.LT(1);
            	    match(input,NEQ,FOLLOW_NEQ_in_equalityExpr243); 
            	    NEQ5_tree = (CommonTree)adaptor.create(NEQ5);
            	    root_0 = (CommonTree)adaptor.becomeRoot(NEQ5_tree, root_0);

            	    pushFollow(FOLLOW_relationalExpr_in_equalityExpr251);
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

          catch (RecognitionException __exc) {
            throw __exc;
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
    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:90:1: relationalExpr : e= additiveExpr ( LT e2= additiveExpr | GT e2= additiveExpr | LE e2= additiveExpr | GE e2= additiveExpr )* ;
    public final relationalExpr_return relationalExpr() throws RecognitionException {
        relationalExpr_return retval = new relationalExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LT6=null;
        Token GT7=null;
        Token LE8=null;
        Token GE9=null;
        additiveExpr_return e = null;

        additiveExpr_return e2 = null;


        CommonTree LT6_tree=null;
        CommonTree GT7_tree=null;
        CommonTree LE8_tree=null;
        CommonTree GE9_tree=null;

        try {
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:90:15: (e= additiveExpr ( LT e2= additiveExpr | GT e2= additiveExpr | LE e2= additiveExpr | GE e2= additiveExpr )* )
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:91:3: e= additiveExpr ( LT e2= additiveExpr | GT e2= additiveExpr | LE e2= additiveExpr | GE e2= additiveExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_additiveExpr_in_relationalExpr270);
            e=additiveExpr();
            _fsp--;

            adaptor.addChild(root_0, e.getTree());
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:92:3: ( LT e2= additiveExpr | GT e2= additiveExpr | LE e2= additiveExpr | GE e2= additiveExpr )*
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
            	    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:93:5: LT e2= additiveExpr
            	    {
            	    LT6=(Token)input.LT(1);
            	    match(input,LT,FOLLOW_LT_in_relationalExpr292); 
            	    LT6_tree = (CommonTree)adaptor.create(LT6);
            	    root_0 = (CommonTree)adaptor.becomeRoot(LT6_tree, root_0);

            	    pushFollow(FOLLOW_additiveExpr_in_relationalExpr301);
            	    e2=additiveExpr();
            	    _fsp--;

            	    adaptor.addChild(root_0, e2.getTree());

            	    }
            	    break;
            	case 2 :
            	    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:94:5: GT e2= additiveExpr
            	    {
            	    GT7=(Token)input.LT(1);
            	    match(input,GT,FOLLOW_GT_in_relationalExpr309); 
            	    GT7_tree = (CommonTree)adaptor.create(GT7);
            	    root_0 = (CommonTree)adaptor.becomeRoot(GT7_tree, root_0);

            	    pushFollow(FOLLOW_additiveExpr_in_relationalExpr318);
            	    e2=additiveExpr();
            	    _fsp--;

            	    adaptor.addChild(root_0, e2.getTree());

            	    }
            	    break;
            	case 3 :
            	    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:95:5: LE e2= additiveExpr
            	    {
            	    LE8=(Token)input.LT(1);
            	    match(input,LE,FOLLOW_LE_in_relationalExpr369); 
            	    LE8_tree = (CommonTree)adaptor.create(LE8);
            	    root_0 = (CommonTree)adaptor.becomeRoot(LE8_tree, root_0);

            	    pushFollow(FOLLOW_additiveExpr_in_relationalExpr377);
            	    e2=additiveExpr();
            	    _fsp--;

            	    adaptor.addChild(root_0, e2.getTree());

            	    }
            	    break;
            	case 4 :
            	    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:96:5: GE e2= additiveExpr
            	    {
            	    GE9=(Token)input.LT(1);
            	    match(input,GE,FOLLOW_GE_in_relationalExpr385); 
            	    GE9_tree = (CommonTree)adaptor.create(GE9);
            	    root_0 = (CommonTree)adaptor.becomeRoot(GE9_tree, root_0);

            	    pushFollow(FOLLOW_additiveExpr_in_relationalExpr393);
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

          catch (RecognitionException __exc) {
            throw __exc;
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
    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:101:1: additiveExpr : multiplicativeExpr ( PLUS e= multiplicativeExpr | MINUS e= multiplicativeExpr )* ;
    public final additiveExpr_return additiveExpr() throws RecognitionException {
        additiveExpr_return retval = new additiveExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token PLUS11=null;
        Token MINUS12=null;
        multiplicativeExpr_return e = null;

        multiplicativeExpr_return multiplicativeExpr10 = null;


        CommonTree PLUS11_tree=null;
        CommonTree MINUS12_tree=null;

        try {
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:101:13: ( multiplicativeExpr ( PLUS e= multiplicativeExpr | MINUS e= multiplicativeExpr )* )
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:102:3: multiplicativeExpr ( PLUS e= multiplicativeExpr | MINUS e= multiplicativeExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_multiplicativeExpr_in_additiveExpr414);
            multiplicativeExpr10=multiplicativeExpr();
            _fsp--;

            adaptor.addChild(root_0, multiplicativeExpr10.getTree());
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:103:3: ( PLUS e= multiplicativeExpr | MINUS e= multiplicativeExpr )*
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
            	    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:104:5: PLUS e= multiplicativeExpr
            	    {
            	    PLUS11=(Token)input.LT(1);
            	    match(input,PLUS,FOLLOW_PLUS_in_additiveExpr424); 
            	    PLUS11_tree = (CommonTree)adaptor.create(PLUS11);
            	    root_0 = (CommonTree)adaptor.becomeRoot(PLUS11_tree, root_0);

            	    pushFollow(FOLLOW_multiplicativeExpr_in_additiveExpr433);
            	    e=multiplicativeExpr();
            	    _fsp--;

            	    adaptor.addChild(root_0, e.getTree());

            	    }
            	    break;
            	case 2 :
            	    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:105:7: MINUS e= multiplicativeExpr
            	    {
            	    MINUS12=(Token)input.LT(1);
            	    match(input,MINUS,FOLLOW_MINUS_in_additiveExpr442); 
            	    MINUS12_tree = (CommonTree)adaptor.create(MINUS12);
            	    root_0 = (CommonTree)adaptor.becomeRoot(MINUS12_tree, root_0);

            	    pushFollow(FOLLOW_multiplicativeExpr_in_additiveExpr451);
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

          catch (RecognitionException __exc) {
            throw __exc;
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
    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:109:1: multiplicativeExpr : e= unaryExpr ( MUL e2= unaryExpr | DIV e2= unaryExpr | MOD e2= unaryExpr )* ;
    public final multiplicativeExpr_return multiplicativeExpr() throws RecognitionException {
        multiplicativeExpr_return retval = new multiplicativeExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token MUL13=null;
        Token DIV14=null;
        Token MOD15=null;
        unaryExpr_return e = null;

        unaryExpr_return e2 = null;


        CommonTree MUL13_tree=null;
        CommonTree DIV14_tree=null;
        CommonTree MOD15_tree=null;

        try {
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:109:19: (e= unaryExpr ( MUL e2= unaryExpr | DIV e2= unaryExpr | MOD e2= unaryExpr )* )
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:110:3: e= unaryExpr ( MUL e2= unaryExpr | DIV e2= unaryExpr | MOD e2= unaryExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_unaryExpr_in_multiplicativeExpr472);
            e=unaryExpr();
            _fsp--;

            adaptor.addChild(root_0, e.getTree());
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:111:3: ( MUL e2= unaryExpr | DIV e2= unaryExpr | MOD e2= unaryExpr )*
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
            	    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:112:5: MUL e2= unaryExpr
            	    {
            	    MUL13=(Token)input.LT(1);
            	    match(input,MUL,FOLLOW_MUL_in_multiplicativeExpr482); 
            	    MUL13_tree = (CommonTree)adaptor.create(MUL13);
            	    root_0 = (CommonTree)adaptor.becomeRoot(MUL13_tree, root_0);

            	    pushFollow(FOLLOW_unaryExpr_in_multiplicativeExpr491);
            	    e2=unaryExpr();
            	    _fsp--;

            	    adaptor.addChild(root_0, e2.getTree());

            	    }
            	    break;
            	case 2 :
            	    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:113:5: DIV e2= unaryExpr
            	    {
            	    DIV14=(Token)input.LT(1);
            	    match(input,DIV,FOLLOW_DIV_in_multiplicativeExpr497); 
            	    DIV14_tree = (CommonTree)adaptor.create(DIV14);
            	    root_0 = (CommonTree)adaptor.becomeRoot(DIV14_tree, root_0);

            	    pushFollow(FOLLOW_unaryExpr_in_multiplicativeExpr504);
            	    e2=unaryExpr();
            	    _fsp--;

            	    adaptor.addChild(root_0, e2.getTree());

            	    }
            	    break;
            	case 3 :
            	    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:114:5: MOD e2= unaryExpr
            	    {
            	    MOD15=(Token)input.LT(1);
            	    match(input,MOD,FOLLOW_MOD_in_multiplicativeExpr510); 
            	    MOD15_tree = (CommonTree)adaptor.create(MOD15);
            	    root_0 = (CommonTree)adaptor.becomeRoot(MOD15_tree, root_0);

            	    pushFollow(FOLLOW_unaryExpr_in_multiplicativeExpr517);
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

          catch (RecognitionException __exc) {
            throw __exc;
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
    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:118:1: unaryExpr : ( primaryExpr | MINUS primaryExpr );
    public final unaryExpr_return unaryExpr() throws RecognitionException {
        unaryExpr_return retval = new unaryExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token MINUS17=null;
        primaryExpr_return primaryExpr16 = null;

        primaryExpr_return primaryExpr18 = null;


        CommonTree MINUS17_tree=null;

        try {
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:118:10: ( primaryExpr | MINUS primaryExpr )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>=Literal && LA7_0<=Ref)||LA7_0==32||LA7_0==34) ) {
                alt7=1;
            }
            else if ( (LA7_0==MINUS) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("118:1: unaryExpr : ( primaryExpr | MINUS primaryExpr );", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:119:3: primaryExpr
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_primaryExpr_in_unaryExpr534);
                    primaryExpr16=primaryExpr();
                    _fsp--;

                    adaptor.addChild(root_0, primaryExpr16.getTree());

                    }
                    break;
                case 2 :
                    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:120:5: MINUS primaryExpr
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    MINUS17=(Token)input.LT(1);
                    match(input,MINUS,FOLLOW_MINUS_in_unaryExpr540); 
                    MINUS17_tree = (CommonTree)adaptor.create(MINUS17);
                    root_0 = (CommonTree)adaptor.becomeRoot(MINUS17_tree, root_0);

                    pushFollow(FOLLOW_primaryExpr_in_unaryExpr543);
                    primaryExpr18=primaryExpr();
                    _fsp--;

                    adaptor.addChild(root_0, primaryExpr18.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

                retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

          catch (RecognitionException __exc) {
            throw __exc;
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
    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:123:1: primaryExpr : ( settingValueRef | '(' orExpr ')' | l= Literal | IntegerNumber | RealNumber | ScientificNumber );
    public final primaryExpr_return primaryExpr() throws RecognitionException {
        primaryExpr_return retval = new primaryExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token l=null;
        Token char_literal20=null;
        Token char_literal22=null;
        Token IntegerNumber23=null;
        Token RealNumber24=null;
        Token ScientificNumber25=null;
        settingValueRef_return settingValueRef19 = null;

        orExpr_return orExpr21 = null;


        CommonTree l_tree=null;
        CommonTree char_literal20_tree=null;
        CommonTree char_literal22_tree=null;
        CommonTree IntegerNumber23_tree=null;
        CommonTree RealNumber24_tree=null;
        CommonTree ScientificNumber25_tree=null;

        try {
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:123:12: ( settingValueRef | '(' orExpr ')' | l= Literal | IntegerNumber | RealNumber | ScientificNumber )
            int alt8=6;
            switch ( input.LA(1) ) {
            case Ref:
            case 34:
                {
                alt8=1;
                }
                break;
            case 32:
                {
                alt8=2;
                }
                break;
            case Literal:
                {
                alt8=3;
                }
                break;
            case IntegerNumber:
                {
                alt8=4;
                }
                break;
            case RealNumber:
                {
                alt8=5;
                }
                break;
            case ScientificNumber:
                {
                alt8=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("123:1: primaryExpr : ( settingValueRef | '(' orExpr ')' | l= Literal | IntegerNumber | RealNumber | ScientificNumber );", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:124:3: settingValueRef
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_settingValueRef_in_primaryExpr554);
                    settingValueRef19=settingValueRef();
                    _fsp--;

                    adaptor.addChild(root_0, settingValueRef19.getTree());

                    }
                    break;
                case 2 :
                    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:125:5: '(' orExpr ')'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    char_literal20=(Token)input.LT(1);
                    match(input,32,FOLLOW_32_in_primaryExpr560); 
                    char_literal20_tree = (CommonTree)adaptor.create(char_literal20);
                    adaptor.addChild(root_0, char_literal20_tree);

                    pushFollow(FOLLOW_orExpr_in_primaryExpr562);
                    orExpr21=orExpr();
                    _fsp--;

                    adaptor.addChild(root_0, orExpr21.getTree());
                    char_literal22=(Token)input.LT(1);
                    match(input,33,FOLLOW_33_in_primaryExpr564); 
                    char_literal22_tree = (CommonTree)adaptor.create(char_literal22);
                    adaptor.addChild(root_0, char_literal22_tree);


                    }
                    break;
                case 3 :
                    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:126:5: l= Literal
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    l=(Token)input.LT(1);
                    match(input,Literal,FOLLOW_Literal_in_primaryExpr574); 
                    l_tree = (CommonTree)adaptor.create(l);
                    adaptor.addChild(root_0, l_tree);

                    String literal = l.getText().substring(1, l.getText().length() - 1) ; l.setText(literal);

                    }
                    break;
                case 4 :
                    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:127:5: IntegerNumber
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    IntegerNumber23=(Token)input.LT(1);
                    match(input,IntegerNumber,FOLLOW_IntegerNumber_in_primaryExpr582); 
                    IntegerNumber23_tree = (CommonTree)adaptor.create(IntegerNumber23);
                    adaptor.addChild(root_0, IntegerNumber23_tree);


                    }
                    break;
                case 5 :
                    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:128:5: RealNumber
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    RealNumber24=(Token)input.LT(1);
                    match(input,RealNumber,FOLLOW_RealNumber_in_primaryExpr589); 
                    RealNumber24_tree = (CommonTree)adaptor.create(RealNumber24);
                    adaptor.addChild(root_0, RealNumber24_tree);


                    }
                    break;
                case 6 :
                    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:129:5: ScientificNumber
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    ScientificNumber25=(Token)input.LT(1);
                    match(input,ScientificNumber,FOLLOW_ScientificNumber_in_primaryExpr596); 
                    ScientificNumber25_tree = (CommonTree)adaptor.create(ScientificNumber25);
                    adaptor.addChild(root_0, ScientificNumber25_tree);


                    }
                    break;

            }
            retval.stop = input.LT(-1);

                retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

          catch (RecognitionException __exc) {
            throw __exc;
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
    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:136:1: settingValueRef : ( currentRef | siblingRef | topLevelSettingRef | subSettingRef | filePathRef );
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
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:136:16: ( currentRef | siblingRef | topLevelSettingRef | subSettingRef | filePathRef )
            int alt9=5;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==34) ) {
                alt9=1;
            }
            else if ( (LA9_0==Ref) ) {
                int LA9_2 = input.LA(2);

                if ( (LA9_2==35) ) {
                    int LA9_3 = input.LA(3);

                    if ( (LA9_3==Ref) ) {
                        switch ( input.LA(4) ) {
                        case 36:
                            {
                            alt9=4;
                            }
                            break;
                        case 35:
                            {
                            alt9=5;
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
                        case 33:
                            {
                            alt9=3;
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("136:1: settingValueRef : ( currentRef | siblingRef | topLevelSettingRef | subSettingRef | filePathRef );", 9, 5, input);

                            throw nvae;
                        }

                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("136:1: settingValueRef : ( currentRef | siblingRef | topLevelSettingRef | subSettingRef | filePathRef );", 9, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA9_2==EOF||(LA9_2>=OR && LA9_2<=MOD)||LA9_2==33) ) {
                    alt9=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("136:1: settingValueRef : ( currentRef | siblingRef | topLevelSettingRef | subSettingRef | filePathRef );", 9, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("136:1: settingValueRef : ( currentRef | siblingRef | topLevelSettingRef | subSettingRef | filePathRef );", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:137:3: currentRef
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_currentRef_in_settingValueRef610);
                    currentRef26=currentRef();
                    _fsp--;

                    adaptor.addChild(root_0, currentRef26.getTree());

                    }
                    break;
                case 2 :
                    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:138:5: siblingRef
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_siblingRef_in_settingValueRef616);
                    siblingRef27=siblingRef();
                    _fsp--;

                    adaptor.addChild(root_0, siblingRef27.getTree());

                    }
                    break;
                case 3 :
                    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:139:5: topLevelSettingRef
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_topLevelSettingRef_in_settingValueRef622);
                    topLevelSettingRef28=topLevelSettingRef();
                    _fsp--;

                    adaptor.addChild(root_0, topLevelSettingRef28.getTree());

                    }
                    break;
                case 4 :
                    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:140:5: subSettingRef
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_subSettingRef_in_settingValueRef628);
                    subSettingRef29=subSettingRef();
                    _fsp--;

                    adaptor.addChild(root_0, subSettingRef29.getTree());

                    }
                    break;
                case 5 :
                    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:141:5: filePathRef
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_filePathRef_in_settingValueRef634);
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

          catch (RecognitionException __exc) {
            throw __exc;
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
    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:145:1: currentRef : '.' -> CURRENT_REF[\".\"] ;
    public final currentRef_return currentRef() throws RecognitionException {
        currentRef_return retval = new currentRef_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal31=null;

		CommonTree char_literal31_tree=null;
        RewriteRuleTokenStream stream_34=new RewriteRuleTokenStream(adaptor,"token 34");

        try {
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:145:11: ( '.' -> CURRENT_REF[\".\"] )
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:146:3: '.'
            {
            char_literal31=(Token)input.LT(1);
            match(input,34,FOLLOW_34_in_currentRef645); 
            stream_34.add(char_literal31);


            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 146:7: -> CURRENT_REF[\".\"]
            {
                adaptor.addChild(root_0, adaptor.create(CURRENT_REF, "."));

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

          catch (RecognitionException __exc) {
            throw __exc;
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
    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:150:1: siblingRef : r= Ref -> SIBLING_REF[val] ;
    public final siblingRef_return siblingRef() throws RecognitionException {
        siblingRef_return retval = new siblingRef_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token r=null;

        CommonTree r_tree=null;
        RewriteRuleTokenStream stream_Ref=new RewriteRuleTokenStream(adaptor,"token Ref");

        try {
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:150:11: (r= Ref -> SIBLING_REF[val] )
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:151:3: r= Ref
            {
            r=(Token)input.LT(1);
            match(input,Ref,FOLLOW_Ref_in_siblingRef665); 
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
            // 151:42: -> SIBLING_REF[val]
            {
                adaptor.addChild(root_0, adaptor.create(SIBLING_REF, val));

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

          catch (RecognitionException __exc) {
            throw __exc;
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
    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:154:1: topLevelSettingRef : r1= Ref '/' r2= Ref -> TOP_LEVEL_SETTING_REF[val] ;
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
        RewriteRuleTokenStream stream_35=new RewriteRuleTokenStream(adaptor,"token 35");

        try {
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:154:19: (r1= Ref '/' r2= Ref -> TOP_LEVEL_SETTING_REF[val] )
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:155:3: r1= Ref '/' r2= Ref
            {
            r1=(Token)input.LT(1);
            match(input,Ref,FOLLOW_Ref_in_topLevelSettingRef686); 
            stream_Ref.add(r1);

            char_literal32=(Token)input.LT(1);
            match(input,35,FOLLOW_35_in_topLevelSettingRef688); 
            stream_35.add(char_literal32);

            r2=(Token)input.LT(1);
            match(input,Ref,FOLLOW_Ref_in_topLevelSettingRef694); 
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
            // 155:73: -> TOP_LEVEL_SETTING_REF[val]
            {
                adaptor.addChild(root_0, adaptor.create(TOP_LEVEL_SETTING_REF, val));

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

          catch (RecognitionException __exc) {
            throw __exc;
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
    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:158:1: subSettingRef : r1= Ref '/' rx= Ref '[' n= IntegerNumber ']' '/' rs= Ref -> SUB_SETTING_REF[val] ;
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
        RewriteRuleTokenStream stream_Ref=new RewriteRuleTokenStream(adaptor,"token Ref");
        RewriteRuleTokenStream stream_35=new RewriteRuleTokenStream(adaptor,"token 35");
        RewriteRuleTokenStream stream_37=new RewriteRuleTokenStream(adaptor,"token 37");
        RewriteRuleTokenStream stream_IntegerNumber=new RewriteRuleTokenStream(adaptor,"token IntegerNumber");
        RewriteRuleTokenStream stream_36=new RewriteRuleTokenStream(adaptor,"token 36");

        try {
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:158:14: (r1= Ref '/' rx= Ref '[' n= IntegerNumber ']' '/' rs= Ref -> SUB_SETTING_REF[val] )
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:159:3: r1= Ref '/' rx= Ref '[' n= IntegerNumber ']' '/' rs= Ref
            {
            r1=(Token)input.LT(1);
            match(input,Ref,FOLLOW_Ref_in_subSettingRef715); 
            stream_Ref.add(r1);

            char_literal33=(Token)input.LT(1);
            match(input,35,FOLLOW_35_in_subSettingRef717); 
            stream_35.add(char_literal33);

            rx=(Token)input.LT(1);
            match(input,Ref,FOLLOW_Ref_in_subSettingRef723); 
            stream_Ref.add(rx);

            char_literal34=(Token)input.LT(1);
            match(input,36,FOLLOW_36_in_subSettingRef725); 
            stream_36.add(char_literal34);

            n=(Token)input.LT(1);
            match(input,IntegerNumber,FOLLOW_IntegerNumber_in_subSettingRef731); 
            stream_IntegerNumber.add(n);

            char_literal35=(Token)input.LT(1);
            match(input,37,FOLLOW_37_in_subSettingRef733); 
            stream_37.add(char_literal35);

            char_literal36=(Token)input.LT(1);
            match(input,35,FOLLOW_35_in_subSettingRef735); 
            stream_35.add(char_literal36);

            rs=(Token)input.LT(1);
            match(input,Ref,FOLLOW_Ref_in_subSettingRef741); 
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
            // 160:93: -> SUB_SETTING_REF[val]
            {
                adaptor.addChild(root_0, adaptor.create(SUB_SETTING_REF, val));

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

          catch (RecognitionException __exc) {
            throw __exc;
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
    // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:164:1: filePathRef : r1= Ref '/' r2= Ref '/' r3= Ref -> FILE_PATH_REF[val] ;
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
        RewriteRuleTokenStream stream_35=new RewriteRuleTokenStream(adaptor,"token 35");

        try {
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:164:12: (r1= Ref '/' r2= Ref '/' r3= Ref -> FILE_PATH_REF[val] )
            // C:\\eclipse\\workspace_vct\\com.nokia.tools.vct.confml.expressions\\src\\com\\nokia\\tools\\vct\\confml\\expressions\\confml\\grammar\\Confml.g:165:3: r1= Ref '/' r2= Ref '/' r3= Ref
            {
            r1=(Token)input.LT(1);
            match(input,Ref,FOLLOW_Ref_in_filePathRef765); 
            stream_Ref.add(r1);

            char_literal37=(Token)input.LT(1);
            match(input,35,FOLLOW_35_in_filePathRef767); 
            stream_35.add(char_literal37);

            r2=(Token)input.LT(1);
            match(input,Ref,FOLLOW_Ref_in_filePathRef773); 
            stream_Ref.add(r2);

            char_literal38=(Token)input.LT(1);
            match(input,35,FOLLOW_35_in_filePathRef775); 
            stream_35.add(char_literal38);

            r3=(Token)input.LT(1);
            match(input,Ref,FOLLOW_Ref_in_filePathRef781); 
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
            // 166:69: -> FILE_PATH_REF[val]
            {
                adaptor.addChild(root_0, adaptor.create(FILE_PATH_REF, val));

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

          catch (RecognitionException __exc) {
            throw __exc;
          }
        finally {
        }
        return retval;
    }
    // $ANTLR end filePathRef


 

    public static final BitSet FOLLOW_orExpr_in_expr117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_andExpr_in_orExpr132 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_OR_in_orExpr142 = new BitSet(new long[]{0x000000051F100000L});
    public static final BitSet FOLLOW_andExpr_in_orExpr150 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_equalityExpr_in_andExpr169 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_AND_in_andExpr184 = new BitSet(new long[]{0x000000051F100000L});
    public static final BitSet FOLLOW_equalityExpr_in_andExpr191 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_relationalExpr_in_equalityExpr218 = new BitSet(new long[]{0x0000000000006002L});
    public static final BitSet FOLLOW_EQ_in_equalityExpr228 = new BitSet(new long[]{0x000000051F100000L});
    public static final BitSet FOLLOW_relationalExpr_in_equalityExpr237 = new BitSet(new long[]{0x0000000000006002L});
    public static final BitSet FOLLOW_NEQ_in_equalityExpr243 = new BitSet(new long[]{0x000000051F100000L});
    public static final BitSet FOLLOW_relationalExpr_in_equalityExpr251 = new BitSet(new long[]{0x0000000000006002L});
    public static final BitSet FOLLOW_additiveExpr_in_relationalExpr270 = new BitSet(new long[]{0x0000000000078002L});
    public static final BitSet FOLLOW_LT_in_relationalExpr292 = new BitSet(new long[]{0x000000051F100000L});
    public static final BitSet FOLLOW_additiveExpr_in_relationalExpr301 = new BitSet(new long[]{0x0000000000078002L});
    public static final BitSet FOLLOW_GT_in_relationalExpr309 = new BitSet(new long[]{0x000000051F100000L});
    public static final BitSet FOLLOW_additiveExpr_in_relationalExpr318 = new BitSet(new long[]{0x0000000000078002L});
    public static final BitSet FOLLOW_LE_in_relationalExpr369 = new BitSet(new long[]{0x000000051F100000L});
    public static final BitSet FOLLOW_additiveExpr_in_relationalExpr377 = new BitSet(new long[]{0x0000000000078002L});
    public static final BitSet FOLLOW_GE_in_relationalExpr385 = new BitSet(new long[]{0x000000051F100000L});
    public static final BitSet FOLLOW_additiveExpr_in_relationalExpr393 = new BitSet(new long[]{0x0000000000078002L});
    public static final BitSet FOLLOW_multiplicativeExpr_in_additiveExpr414 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_PLUS_in_additiveExpr424 = new BitSet(new long[]{0x000000051F100000L});
    public static final BitSet FOLLOW_multiplicativeExpr_in_additiveExpr433 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_MINUS_in_additiveExpr442 = new BitSet(new long[]{0x000000051F100000L});
    public static final BitSet FOLLOW_multiplicativeExpr_in_additiveExpr451 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_unaryExpr_in_multiplicativeExpr472 = new BitSet(new long[]{0x0000000000E00002L});
    public static final BitSet FOLLOW_MUL_in_multiplicativeExpr482 = new BitSet(new long[]{0x000000051F100000L});
    public static final BitSet FOLLOW_unaryExpr_in_multiplicativeExpr491 = new BitSet(new long[]{0x0000000000E00002L});
    public static final BitSet FOLLOW_DIV_in_multiplicativeExpr497 = new BitSet(new long[]{0x000000051F100000L});
    public static final BitSet FOLLOW_unaryExpr_in_multiplicativeExpr504 = new BitSet(new long[]{0x0000000000E00002L});
    public static final BitSet FOLLOW_MOD_in_multiplicativeExpr510 = new BitSet(new long[]{0x000000051F100000L});
    public static final BitSet FOLLOW_unaryExpr_in_multiplicativeExpr517 = new BitSet(new long[]{0x0000000000E00002L});
    public static final BitSet FOLLOW_primaryExpr_in_unaryExpr534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_unaryExpr540 = new BitSet(new long[]{0x000000051F000000L});
    public static final BitSet FOLLOW_primaryExpr_in_unaryExpr543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_settingValueRef_in_primaryExpr554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_primaryExpr560 = new BitSet(new long[]{0x000000051F100000L});
    public static final BitSet FOLLOW_orExpr_in_primaryExpr562 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_primaryExpr564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Literal_in_primaryExpr574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IntegerNumber_in_primaryExpr582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RealNumber_in_primaryExpr589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ScientificNumber_in_primaryExpr596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_currentRef_in_settingValueRef610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_siblingRef_in_settingValueRef616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_topLevelSettingRef_in_settingValueRef622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_subSettingRef_in_settingValueRef628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_filePathRef_in_settingValueRef634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_currentRef645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ref_in_siblingRef665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ref_in_topLevelSettingRef686 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_topLevelSettingRef688 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_Ref_in_topLevelSettingRef694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ref_in_subSettingRef715 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_subSettingRef717 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_Ref_in_subSettingRef723 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_subSettingRef725 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_IntegerNumber_in_subSettingRef731 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_subSettingRef733 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_subSettingRef735 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_Ref_in_subSettingRef741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ref_in_filePathRef765 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_filePathRef767 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_Ref_in_filePathRef773 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_filePathRef775 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_Ref_in_filePathRef781 = new BitSet(new long[]{0x0000000000000002L});

}
