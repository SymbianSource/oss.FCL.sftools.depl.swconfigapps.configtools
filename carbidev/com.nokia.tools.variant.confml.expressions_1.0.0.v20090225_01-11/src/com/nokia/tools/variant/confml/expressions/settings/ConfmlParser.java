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
  
import java.util.HashSet;
import java.util.Set;

import org.antlr.runtime.BitSet;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.Parser;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.eclipse.emf.common.util.EList;

import com.nokia.tools.variant.content.confml.SequenceItem;
import com.nokia.tools.variant.content.confml.SequenceSetting;
import com.nokia.tools.variant.content.confml.Setting;
import com.nokia.tools.variant.content.confml.View;

public class ConfmlParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NEWLINE", "Literal", "Number", "Ref", "WS", "'or'", "'and'", "'='", "'!='", "'<'", "'>'", "'<='", "'>='", "'+'", "'-'", "'*'", "'div'", "'mod'", "'('", "')'", "'.'", "'/'", "'['", "']'"
    };
    public static final int Ref=7;
    public static final int WS=8;
    public static final int Literal=5;
    public static final int NEWLINE=4;
    public static final int Number=6;
    public static final int EOF=-1;

        public ConfmlParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g"; }


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



    // $ANTLR start expr
    // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:60:1: expr returns [Set<Setting> settings] : (e= orExpr NEWLINE )* ;
    public final Set<Setting> expr() throws RecognitionException {
        Set<Setting> settings = null;

        Set<Setting> e = null;


        try {
            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:60:37: ( (e= orExpr NEWLINE )* )
            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:61:3: (e= orExpr NEWLINE )*
            {
            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:61:3: (e= orExpr NEWLINE )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=Literal && LA1_0<=Ref)||LA1_0==18||LA1_0==22||LA1_0==24) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:61:4: e= orExpr NEWLINE
            	    {
            	    pushFollow(FOLLOW_orExpr_in_expr44);
            	    e=orExpr();
            	    _fsp--;

            	    match(input,NEWLINE,FOLLOW_NEWLINE_in_expr46); 

            	                                        settings = e;
            	                                      

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return settings;
    }
    // $ANTLR end expr


    // $ANTLR start orExpr
    // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:67:1: orExpr returns [Set<Setting> settings] : e1= andExpr ( 'or' e2= andExpr )* ;
    public final Set<Setting> orExpr() throws RecognitionException {
        Set<Setting> settings = null;

        Set<Setting> e1 = null;

        Set<Setting> e2 = null;


        try {
            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:67:39: (e1= andExpr ( 'or' e2= andExpr )* )
            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:68:3: e1= andExpr ( 'or' e2= andExpr )*
            {
            pushFollow(FOLLOW_andExpr_in_orExpr81);
            e1=andExpr();
            _fsp--;

              
                                                settings = e1;
                                              
            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:71:3: ( 'or' e2= andExpr )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==9) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:72:5: 'or' e2= andExpr
            	    {
            	    match(input,9,FOLLOW_9_in_orExpr112); 
            	    pushFollow(FOLLOW_andExpr_in_orExpr119);
            	    e2=andExpr();
            	    _fsp--;


            	                                        settings.addAll(e2);
            	                                      

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return settings;
    }
    // $ANTLR end orExpr


    // $ANTLR start andExpr
    // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:78:1: andExpr returns [Set<Setting> settings] : e1= equalityExpr ( 'and' e2= equalityExpr )* ;
    public final Set<Setting> andExpr() throws RecognitionException {
        Set<Setting> settings = null;

        Set<Setting> e1 = null;

        Set<Setting> e2 = null;


        try {
            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:78:40: (e1= equalityExpr ( 'and' e2= equalityExpr )* )
            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:79:3: e1= equalityExpr ( 'and' e2= equalityExpr )*
            {
            pushFollow(FOLLOW_equalityExpr_in_andExpr155);
            e1=equalityExpr();
            _fsp--;


                                                settings = e1;
                                              
            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:82:3: ( 'and' e2= equalityExpr )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==10) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:83:5: 'and' e2= equalityExpr
            	    {
            	    match(input,10,FOLLOW_10_in_andExpr181); 
            	    pushFollow(FOLLOW_equalityExpr_in_andExpr187);
            	    e2=equalityExpr();
            	    _fsp--;


            	                                        settings.addAll(e2);
            	                                      

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return settings;
    }
    // $ANTLR end andExpr


    // $ANTLR start equalityExpr
    // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:89:1: equalityExpr returns [Set<Setting> settings] : e1= relationalExpr ( '=' e2= relationalExpr | '!=' e2= relationalExpr )* ;
    public final Set<Setting> equalityExpr() throws RecognitionException {
        Set<Setting> settings = null;

        Set<Setting> e1 = null;

        Set<Setting> e2 = null;


        try {
            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:89:45: (e1= relationalExpr ( '=' e2= relationalExpr | '!=' e2= relationalExpr )* )
            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:90:3: e1= relationalExpr ( '=' e2= relationalExpr | '!=' e2= relationalExpr )*
            {
            pushFollow(FOLLOW_relationalExpr_in_equalityExpr219);
            e1=relationalExpr();
            _fsp--;

             
                                                settings = e1;
                                              
            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:93:3: ( '=' e2= relationalExpr | '!=' e2= relationalExpr )*
            loop4:
            do {
                int alt4=3;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==11) ) {
                    alt4=1;
                }
                else if ( (LA4_0==12) ) {
                    alt4=2;
                }


                switch (alt4) {
            	case 1 :
            	    // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:94:5: '=' e2= relationalExpr
            	    {
            	    match(input,11,FOLLOW_11_in_equalityExpr243); 
            	    pushFollow(FOLLOW_relationalExpr_in_equalityExpr251);
            	    e2=relationalExpr();
            	    _fsp--;


            	                                        settings.addAll(e2);
            	                                      

            	    }
            	    break;
            	case 2 :
            	    // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:97:5: '!=' e2= relationalExpr
            	    {
            	    match(input,12,FOLLOW_12_in_equalityExpr263); 
            	    pushFollow(FOLLOW_relationalExpr_in_equalityExpr270);
            	    e2=relationalExpr();
            	    _fsp--;


            	                                        settings.addAll(e2);
            	                                      

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return settings;
    }
    // $ANTLR end equalityExpr


    // $ANTLR start relationalExpr
    // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:103:1: relationalExpr returns [Set<Setting> settings] : e1= additiveExpr ( '<' e2= additiveExpr | '>' e2= additiveExpr | '<=' e2= additiveExpr | '>=' e2= additiveExpr )* ;
    public final Set<Setting> relationalExpr() throws RecognitionException {
        Set<Setting> settings = null;

        Set<Setting> e1 = null;

        Set<Setting> e2 = null;


        try {
            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:103:47: (e1= additiveExpr ( '<' e2= additiveExpr | '>' e2= additiveExpr | '<=' e2= additiveExpr | '>=' e2= additiveExpr )* )
            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:104:3: e1= additiveExpr ( '<' e2= additiveExpr | '>' e2= additiveExpr | '<=' e2= additiveExpr | '>=' e2= additiveExpr )*
            {
            pushFollow(FOLLOW_additiveExpr_in_relationalExpr299);
            e1=additiveExpr();
            _fsp--;

             
                                                settings = e1;
                                              
            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:107:3: ( '<' e2= additiveExpr | '>' e2= additiveExpr | '<=' e2= additiveExpr | '>=' e2= additiveExpr )*
            loop5:
            do {
                int alt5=5;
                switch ( input.LA(1) ) {
                case 13:
                    {
                    alt5=1;
                    }
                    break;
                case 14:
                    {
                    alt5=2;
                    }
                    break;
                case 15:
                    {
                    alt5=3;
                    }
                    break;
                case 16:
                    {
                    alt5=4;
                    }
                    break;

                }

                switch (alt5) {
            	case 1 :
            	    // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:108:5: '<' e2= additiveExpr
            	    {
            	    match(input,13,FOLLOW_13_in_relationalExpr325); 
            	    pushFollow(FOLLOW_additiveExpr_in_relationalExpr333);
            	    e2=additiveExpr();
            	    _fsp--;


            	                                        settings.addAll(e2);
            	                                      

            	    }
            	    break;
            	case 2 :
            	    // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:112:5: '>' e2= additiveExpr
            	    {
            	    match(input,14,FOLLOW_14_in_relationalExpr391); 
            	    pushFollow(FOLLOW_additiveExpr_in_relationalExpr399);
            	    e2=additiveExpr();
            	    _fsp--;


            	                                        settings.addAll(e2);
            	                                      

            	    }
            	    break;
            	case 3 :
            	    // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:116:5: '<=' e2= additiveExpr
            	    {
            	    match(input,15,FOLLOW_15_in_relationalExpr457); 
            	    pushFollow(FOLLOW_additiveExpr_in_relationalExpr464);
            	    e2=additiveExpr();
            	    _fsp--;


            	                                        settings.addAll(e2);
            	                                      

            	    }
            	    break;
            	case 4 :
            	    // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:120:5: '>=' e2= additiveExpr
            	    {
            	    match(input,16,FOLLOW_16_in_relationalExpr522); 
            	    pushFollow(FOLLOW_additiveExpr_in_relationalExpr529);
            	    e2=additiveExpr();
            	    _fsp--;


            	                                        settings.addAll(e2);
            	                                      

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return settings;
    }
    // $ANTLR end relationalExpr


    // $ANTLR start additiveExpr
    // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:127:1: additiveExpr returns [Set<Setting> settings] : e1= multiplicativeExpr ( '+' e2= multiplicativeExpr | '-' e2= multiplicativeExpr )* ;
    public final Set<Setting> additiveExpr() throws RecognitionException {
        Set<Setting> settings = null;

        Set<Setting> e1 = null;

        Set<Setting> e2 = null;


        try {
            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:127:46: (e1= multiplicativeExpr ( '+' e2= multiplicativeExpr | '-' e2= multiplicativeExpr )* )
            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:128:2: e1= multiplicativeExpr ( '+' e2= multiplicativeExpr | '-' e2= multiplicativeExpr )*
            {
            pushFollow(FOLLOW_multiplicativeExpr_in_additiveExpr564);
            e1=multiplicativeExpr();
            _fsp--;


            	                                  settings = e1;
            	                                
            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:131:2: ( '+' e2= multiplicativeExpr | '-' e2= multiplicativeExpr )*
            loop6:
            do {
                int alt6=3;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==17) ) {
                    alt6=1;
                }
                else if ( (LA6_0==18) ) {
                    alt6=2;
                }


                switch (alt6) {
            	case 1 :
            	    // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:132:4: '+' e2= multiplicativeExpr
            	    {
            	    match(input,17,FOLLOW_17_in_additiveExpr582); 
            	    pushFollow(FOLLOW_multiplicativeExpr_in_additiveExpr590);
            	    e2=multiplicativeExpr();
            	    _fsp--;


            	    	                                  settings.addAll(e2);
            	    	                                

            	    }
            	    break;
            	case 2 :
            	    // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:135:7: '-' e2= multiplicativeExpr
            	    {
            	    match(input,18,FOLLOW_18_in_additiveExpr601); 
            	    pushFollow(FOLLOW_multiplicativeExpr_in_additiveExpr607);
            	    e2=multiplicativeExpr();
            	    _fsp--;


            	                                        settings.addAll(e2);
            	                                      

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return settings;
    }
    // $ANTLR end additiveExpr


    // $ANTLR start multiplicativeExpr
    // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:141:1: multiplicativeExpr returns [Set<Setting> settings] : e1= unaryExpr ( '*' e2= unaryExpr | 'div' e2= unaryExpr | 'mod' e2= unaryExpr )* ;
    public final Set<Setting> multiplicativeExpr() throws RecognitionException {
        Set<Setting> settings = null;

        Setting e1 = null;

        Setting e2 = null;


        try {
            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:141:51: (e1= unaryExpr ( '*' e2= unaryExpr | 'div' e2= unaryExpr | 'mod' e2= unaryExpr )* )
            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:142:2: e1= unaryExpr ( '*' e2= unaryExpr | 'div' e2= unaryExpr | 'mod' e2= unaryExpr )*
            {
            pushFollow(FOLLOW_unaryExpr_in_multiplicativeExpr632);
            e1=unaryExpr();
            _fsp--;


            			                              settings = new HashSet<Setting>();
            			                              settings.add(e1);	
            	                                
            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:146:2: ( '*' e2= unaryExpr | 'div' e2= unaryExpr | 'mod' e2= unaryExpr )*
            loop7:
            do {
                int alt7=4;
                switch ( input.LA(1) ) {
                case 19:
                    {
                    alt7=1;
                    }
                    break;
                case 20:
                    {
                    alt7=2;
                    }
                    break;
                case 21:
                    {
                    alt7=3;
                    }
                    break;

                }

                switch (alt7) {
            	case 1 :
            	    // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:147:4: '*' e2= unaryExpr
            	    {
            	    match(input,19,FOLLOW_19_in_multiplicativeExpr659); 
            	    pushFollow(FOLLOW_unaryExpr_in_multiplicativeExpr667);
            	    e2=unaryExpr();
            	    _fsp--;


            	    			                              settings.add(e2);
            	    	                                

            	    }
            	    break;
            	case 2 :
            	    // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:150:4: 'div' e2= unaryExpr
            	    {
            	    match(input,20,FOLLOW_20_in_multiplicativeExpr683); 
            	    pushFollow(FOLLOW_unaryExpr_in_multiplicativeExpr689);
            	    e2=unaryExpr();
            	    _fsp--;


            	    			                              settings.add(e2);
            	    			                            

            	    }
            	    break;
            	case 3 :
            	    // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:153:4: 'mod' e2= unaryExpr
            	    {
            	    match(input,21,FOLLOW_21_in_multiplicativeExpr705); 
            	    pushFollow(FOLLOW_unaryExpr_in_multiplicativeExpr711);
            	    e2=unaryExpr();
            	    _fsp--;


            	    			                              settings.add(e2);
            	    			                            

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return settings;
    }
    // $ANTLR end multiplicativeExpr


    // $ANTLR start unaryExpr
    // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:159:1: unaryExpr returns [Setting setting] : (e1= primaryExpr | '-' e2= primaryExpr );
    public final Setting unaryExpr() throws RecognitionException {
        Setting setting = null;

        Setting e1 = null;

        Setting e2 = null;


        try {
            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:159:36: (e1= primaryExpr | '-' e2= primaryExpr )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=Literal && LA8_0<=Ref)||LA8_0==22||LA8_0==24) ) {
                alt8=1;
            }
            else if ( (LA8_0==18) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("159:1: unaryExpr returns [Setting setting] : (e1= primaryExpr | '-' e2= primaryExpr );", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:160:3: e1= primaryExpr
                    {
                    pushFollow(FOLLOW_primaryExpr_in_unaryExpr746);
                    e1=primaryExpr();
                    _fsp--;


                                                        setting = e1;
                                                      

                    }
                    break;
                case 2 :
                    // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:163:5: '-' e2= primaryExpr
                    {
                    match(input,18,FOLLOW_18_in_unaryExpr769); 
                    pushFollow(FOLLOW_primaryExpr_in_unaryExpr775);
                    e2=primaryExpr();
                    _fsp--;


                                                        setting = e2;
                                                      

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return setting;
    }
    // $ANTLR end unaryExpr


    // $ANTLR start primaryExpr
    // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:168:1: primaryExpr returns [Setting setting] : (e1= settingRef | '(' orExpr ')' | Literal | Number );
    public final Setting primaryExpr() throws RecognitionException {
        Setting setting = null;

        Setting e1 = null;


        try {
            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:168:38: (e1= settingRef | '(' orExpr ')' | Literal | Number )
            int alt9=4;
            switch ( input.LA(1) ) {
            case Ref:
            case 24:
                {
                alt9=1;
                }
                break;
            case 22:
                {
                alt9=2;
                }
                break;
            case Literal:
                {
                alt9=3;
                }
                break;
            case Number:
                {
                alt9=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("168:1: primaryExpr returns [Setting setting] : (e1= settingRef | '(' orExpr ')' | Literal | Number );", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:169:3: e1= settingRef
                    {
                    pushFollow(FOLLOW_settingRef_in_primaryExpr805);
                    e1=settingRef();
                    _fsp--;

                     
                                                        setting = e1;
                                                      

                    }
                    break;
                case 2 :
                    // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:172:5: '(' orExpr ')'
                    {
                    match(input,22,FOLLOW_22_in_primaryExpr829); 
                    pushFollow(FOLLOW_orExpr_in_primaryExpr831);
                    orExpr();
                    _fsp--;

                    match(input,23,FOLLOW_23_in_primaryExpr833); 
                     

                    }
                    break;
                case 3 :
                    // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:173:5: Literal
                    {
                    match(input,Literal,FOLLOW_Literal_in_primaryExpr856); 
                     

                    }
                    break;
                case 4 :
                    // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:174:5: Number
                    {
                    match(input,Number,FOLLOW_Number_in_primaryExpr886); 
                     

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return setting;
    }
    // $ANTLR end primaryExpr


    // $ANTLR start settingRef
    // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:179:1: settingRef returns [Setting setting] : ( '.' | r= Ref | (r1= Ref '/' r2= Ref ) | (r1= Ref '/' rx= Ref '[' n= Number ']' '/' rs= Ref ) | r1= Ref '/' r2= Ref '/' r3= Ref );
    public final Setting settingRef() throws RecognitionException {
        Setting setting = null;

        Token r=null;
        Token r1=null;
        Token r2=null;
        Token rx=null;
        Token n=null;
        Token rs=null;
        Token r3=null;

        try {
            // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:179:37: ( '.' | r= Ref | (r1= Ref '/' r2= Ref ) | (r1= Ref '/' rx= Ref '[' n= Number ']' '/' rs= Ref ) | r1= Ref '/' r2= Ref '/' r3= Ref )
            int alt10=5;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==24) ) {
                alt10=1;
            }
            else if ( (LA10_0==Ref) ) {
                int LA10_2 = input.LA(2);

                if ( (LA10_2==25) ) {
                    int LA10_3 = input.LA(3);

                    if ( (LA10_3==Ref) ) {
                        switch ( input.LA(4) ) {
                        case 26:
                            {
                            alt10=4;
                            }
                            break;
                        case 25:
                            {
                            alt10=5;
                            }
                            break;
                        case NEWLINE:
                        case 9:
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                        case 15:
                        case 16:
                        case 17:
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 23:
                            {
                            alt10=3;
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("179:1: settingRef returns [Setting setting] : ( '.' | r= Ref | (r1= Ref '/' r2= Ref ) | (r1= Ref '/' rx= Ref '[' n= Number ']' '/' rs= Ref ) | r1= Ref '/' r2= Ref '/' r3= Ref );", 10, 5, input);

                            throw nvae;
                        }

                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("179:1: settingRef returns [Setting setting] : ( '.' | r= Ref | (r1= Ref '/' r2= Ref ) | (r1= Ref '/' rx= Ref '[' n= Number ']' '/' rs= Ref ) | r1= Ref '/' r2= Ref '/' r3= Ref );", 10, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA10_2==NEWLINE||(LA10_2>=9 && LA10_2<=21)||LA10_2==23) ) {
                    alt10=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("179:1: settingRef returns [Setting setting] : ( '.' | r= Ref | (r1= Ref '/' r2= Ref ) | (r1= Ref '/' rx= Ref '[' n= Number ']' '/' rs= Ref ) | r1= Ref '/' r2= Ref '/' r3= Ref );", 10, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("179:1: settingRef returns [Setting setting] : ( '.' | r= Ref | (r1= Ref '/' r2= Ref ) | (r1= Ref '/' rx= Ref '[' n= Number ']' '/' rs= Ref ) | r1= Ref '/' r2= Ref '/' r3= Ref );", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:180:3: '.'
                    {
                    match(input,24,FOLLOW_24_in_settingRef928); 

                                                        setting = getSetting();
                                                      

                    }
                    break;
                case 2 :
                    // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:183:5: r= Ref
                    {
                    r=(Token)input.LT(1);
                    match(input,Ref,FOLLOW_Ref_in_settingRef968); 

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
                    break;
                case 3 :
                    // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:223:5: (r1= Ref '/' r2= Ref )
                    {
                    // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:223:5: (r1= Ref '/' r2= Ref )
                    // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:223:6: r1= Ref '/' r2= Ref
                    {
                    r1=(Token)input.LT(1);
                    match(input,Ref,FOLLOW_Ref_in_settingRef1003); 
                    match(input,25,FOLLOW_25_in_settingRef1005); 
                    r2=(Token)input.LT(1);
                    match(input,Ref,FOLLOW_Ref_in_settingRef1011); 

                    }


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
                    break;
                case 4 :
                    // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:236:5: (r1= Ref '/' rx= Ref '[' n= Number ']' '/' rs= Ref )
                    {
                    // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:236:5: (r1= Ref '/' rx= Ref '[' n= Number ']' '/' rs= Ref )
                    // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:236:6: r1= Ref '/' rx= Ref '[' n= Number ']' '/' rs= Ref
                    {
                    r1=(Token)input.LT(1);
                    match(input,Ref,FOLLOW_Ref_in_settingRef1031); 
                    match(input,25,FOLLOW_25_in_settingRef1033); 
                    rx=(Token)input.LT(1);
                    match(input,Ref,FOLLOW_Ref_in_settingRef1039); 
                    match(input,26,FOLLOW_26_in_settingRef1041); 
                    n=(Token)input.LT(1);
                    match(input,Number,FOLLOW_Number_in_settingRef1047); 
                    match(input,27,FOLLOW_27_in_settingRef1049); 
                    match(input,25,FOLLOW_25_in_settingRef1051); 
                    rs=(Token)input.LT(1);
                    match(input,Ref,FOLLOW_Ref_in_settingRef1057); 

                    }


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
                    break;
                case 5 :
                    // C:\\projects\\CarbideV2\\com.nokia.tools.variant.confml.expressions\\src\\com\\nokia\\tools\\variant\\confml\\expressions\\settings\\Confml.g:266:5: r1= Ref '/' r2= Ref '/' r3= Ref
                    {
                    r1=(Token)input.LT(1);
                    match(input,Ref,FOLLOW_Ref_in_settingRef1104); 
                    match(input,25,FOLLOW_25_in_settingRef1106); 
                    r2=(Token)input.LT(1);
                    match(input,Ref,FOLLOW_Ref_in_settingRef1112); 
                    match(input,25,FOLLOW_25_in_settingRef1114); 
                    r3=(Token)input.LT(1);
                    match(input,Ref,FOLLOW_Ref_in_settingRef1120); 

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
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return setting;
    }
    // $ANTLR end settingRef


 

    public static final BitSet FOLLOW_orExpr_in_expr44 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_NEWLINE_in_expr46 = new BitSet(new long[]{0x00000000014400E2L});
    public static final BitSet FOLLOW_andExpr_in_orExpr81 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_9_in_orExpr112 = new BitSet(new long[]{0x00000000014400E0L});
    public static final BitSet FOLLOW_andExpr_in_orExpr119 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_equalityExpr_in_andExpr155 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_10_in_andExpr181 = new BitSet(new long[]{0x00000000014400E0L});
    public static final BitSet FOLLOW_equalityExpr_in_andExpr187 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_relationalExpr_in_equalityExpr219 = new BitSet(new long[]{0x0000000000001802L});
    public static final BitSet FOLLOW_11_in_equalityExpr243 = new BitSet(new long[]{0x00000000014400E0L});
    public static final BitSet FOLLOW_relationalExpr_in_equalityExpr251 = new BitSet(new long[]{0x0000000000001802L});
    public static final BitSet FOLLOW_12_in_equalityExpr263 = new BitSet(new long[]{0x00000000014400E0L});
    public static final BitSet FOLLOW_relationalExpr_in_equalityExpr270 = new BitSet(new long[]{0x0000000000001802L});
    public static final BitSet FOLLOW_additiveExpr_in_relationalExpr299 = new BitSet(new long[]{0x000000000001E002L});
    public static final BitSet FOLLOW_13_in_relationalExpr325 = new BitSet(new long[]{0x00000000014400E0L});
    public static final BitSet FOLLOW_additiveExpr_in_relationalExpr333 = new BitSet(new long[]{0x000000000001E002L});
    public static final BitSet FOLLOW_14_in_relationalExpr391 = new BitSet(new long[]{0x00000000014400E0L});
    public static final BitSet FOLLOW_additiveExpr_in_relationalExpr399 = new BitSet(new long[]{0x000000000001E002L});
    public static final BitSet FOLLOW_15_in_relationalExpr457 = new BitSet(new long[]{0x00000000014400E0L});
    public static final BitSet FOLLOW_additiveExpr_in_relationalExpr464 = new BitSet(new long[]{0x000000000001E002L});
    public static final BitSet FOLLOW_16_in_relationalExpr522 = new BitSet(new long[]{0x00000000014400E0L});
    public static final BitSet FOLLOW_additiveExpr_in_relationalExpr529 = new BitSet(new long[]{0x000000000001E002L});
    public static final BitSet FOLLOW_multiplicativeExpr_in_additiveExpr564 = new BitSet(new long[]{0x0000000000060002L});
    public static final BitSet FOLLOW_17_in_additiveExpr582 = new BitSet(new long[]{0x00000000014400E0L});
    public static final BitSet FOLLOW_multiplicativeExpr_in_additiveExpr590 = new BitSet(new long[]{0x0000000000060002L});
    public static final BitSet FOLLOW_18_in_additiveExpr601 = new BitSet(new long[]{0x00000000014400E0L});
    public static final BitSet FOLLOW_multiplicativeExpr_in_additiveExpr607 = new BitSet(new long[]{0x0000000000060002L});
    public static final BitSet FOLLOW_unaryExpr_in_multiplicativeExpr632 = new BitSet(new long[]{0x0000000000380002L});
    public static final BitSet FOLLOW_19_in_multiplicativeExpr659 = new BitSet(new long[]{0x00000000014400E0L});
    public static final BitSet FOLLOW_unaryExpr_in_multiplicativeExpr667 = new BitSet(new long[]{0x0000000000380002L});
    public static final BitSet FOLLOW_20_in_multiplicativeExpr683 = new BitSet(new long[]{0x00000000014400E0L});
    public static final BitSet FOLLOW_unaryExpr_in_multiplicativeExpr689 = new BitSet(new long[]{0x0000000000380002L});
    public static final BitSet FOLLOW_21_in_multiplicativeExpr705 = new BitSet(new long[]{0x00000000014400E0L});
    public static final BitSet FOLLOW_unaryExpr_in_multiplicativeExpr711 = new BitSet(new long[]{0x0000000000380002L});
    public static final BitSet FOLLOW_primaryExpr_in_unaryExpr746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_unaryExpr769 = new BitSet(new long[]{0x00000000014000E0L});
    public static final BitSet FOLLOW_primaryExpr_in_unaryExpr775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_settingRef_in_primaryExpr805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_primaryExpr829 = new BitSet(new long[]{0x00000000014400E0L});
    public static final BitSet FOLLOW_orExpr_in_primaryExpr831 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_primaryExpr833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Literal_in_primaryExpr856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Number_in_primaryExpr886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_settingRef928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ref_in_settingRef968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ref_in_settingRef1003 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_settingRef1005 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_Ref_in_settingRef1011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ref_in_settingRef1031 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_settingRef1033 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_Ref_in_settingRef1039 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_settingRef1041 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_Number_in_settingRef1047 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_settingRef1049 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_settingRef1051 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_Ref_in_settingRef1057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ref_in_settingRef1104 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_settingRef1106 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_Ref_in_settingRef1112 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_settingRef1114 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_Ref_in_settingRef1120 = new BitSet(new long[]{0x0000000000000002L});

}
