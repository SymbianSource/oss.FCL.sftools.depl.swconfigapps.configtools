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

// $ANTLR 3.0 Confml.g 2009-01-08 15:03:49
 
package com.nokia.tools.variant.confml.expressions.confml.grammar;
  
import org.antlr.runtime.BitSet;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.Parser;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.eclipse.emf.common.util.EList;

import com.nokia.tools.variant.content.confml.FilePath;
import com.nokia.tools.variant.content.confml.FileSystemEntrySetting;
import com.nokia.tools.variant.content.confml.SequenceItem;
import com.nokia.tools.variant.content.confml.SequenceSetting;
import com.nokia.tools.variant.content.confml.Setting;
import com.nokia.tools.variant.content.confml.SimpleSetting;
import com.nokia.tools.variant.content.confml.View;

public class ConfmlParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NEWLINE", "Literal", "Number", "Ref", "WS", "'or'", "'and'", "'='", "'!='", "'<'", "'>'", "'<='", "'>='", "'+'", "'-'", "'*'", "'div'", "'mod'", "'('", "')'", "'.'", "'/'", "'['", "']'"
    };
    public static final int WS=8;
    public static final int Number=6;
    public static final int Ref=7;
    public static final int Literal=5;
    public static final int EOF=-1;
    public static final int NEWLINE=4;

        public ConfmlParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "Confml.g"; }

    
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
      
      



    // $ANTLR start expr
    // Confml.g:108:1: expr returns [Object value] : ( orExpr NEWLINE )* ;
    public final Object expr() throws RecognitionException {
        Object value = null;

        Object orExpr1 = null;


        try {
            // Confml.g:109:3: ( ( orExpr NEWLINE )* )
            // Confml.g:109:3: ( orExpr NEWLINE )*
            {
            // Confml.g:109:3: ( orExpr NEWLINE )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=Literal && LA1_0<=Ref)||LA1_0==18||LA1_0==22||LA1_0==24) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Confml.g:109:4: orExpr NEWLINE
            	    {
            	    pushFollow(FOLLOW_orExpr_in_expr40);
            	    orExpr1=orExpr();
            	    _fsp--;

            	    match(input,NEWLINE,FOLLOW_NEWLINE_in_expr42); 
            	    value = orExpr1;

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
        return value;
    }
    // $ANTLR end expr


    // $ANTLR start orExpr
    // Confml.g:113:1: orExpr returns [Object value] : e= andExpr ( 'or' e2= andExpr )* ;
    public final Object orExpr() throws RecognitionException {
        Object value = null;

        Object e = null;

        Object e2 = null;


        try {
            // Confml.g:114:3: (e= andExpr ( 'or' e2= andExpr )* )
            // Confml.g:114:3: e= andExpr ( 'or' e2= andExpr )*
            {
            pushFollow(FOLLOW_andExpr_in_orExpr65);
            e=andExpr();
            _fsp--;

             value = e; 
            // Confml.g:115:3: ( 'or' e2= andExpr )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==9) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Confml.g:116:5: 'or' e2= andExpr
            	    {
            	    match(input,9,FOLLOW_9_in_orExpr97); 
            	    pushFollow(FOLLOW_andExpr_in_orExpr104);
            	    e2=andExpr();
            	    _fsp--;

            	     value = (new Boolean(e.toString()) || new Boolean(e2.toString())); 

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
        return value;
    }
    // $ANTLR end orExpr


    // $ANTLR start andExpr
    // Confml.g:120:1: andExpr returns [Object value] : e= equalityExpr ( 'and' e2= equalityExpr )* ;
    public final Object andExpr() throws RecognitionException {
        Object value = null;

        Object e = null;

        Object e2 = null;


        try {
            // Confml.g:121:3: (e= equalityExpr ( 'and' e2= equalityExpr )* )
            // Confml.g:121:3: e= equalityExpr ( 'and' e2= equalityExpr )*
            {
            pushFollow(FOLLOW_equalityExpr_in_andExpr140);
            e=equalityExpr();
            _fsp--;

             value = e; 
            // Confml.g:122:3: ( 'and' e2= equalityExpr )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==10) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Confml.g:123:5: 'and' e2= equalityExpr
            	    {
            	    match(input,10,FOLLOW_10_in_andExpr167); 
            	    pushFollow(FOLLOW_equalityExpr_in_andExpr173);
            	    e2=equalityExpr();
            	    _fsp--;

            	     value = (new Boolean(e.toString()) && new Boolean(e2.toString())); 

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
        return value;
    }
    // $ANTLR end andExpr


    // $ANTLR start equalityExpr
    // Confml.g:127:1: equalityExpr returns [Object value] : e= relationalExpr ( '=' e2= relationalExpr | '!=' e2= relationalExpr )* ;
    public final Object equalityExpr() throws RecognitionException {
        Object value = null;

        Object e = null;

        Object e2 = null;


        try {
            // Confml.g:128:3: (e= relationalExpr ( '=' e2= relationalExpr | '!=' e2= relationalExpr )* )
            // Confml.g:128:3: e= relationalExpr ( '=' e2= relationalExpr | '!=' e2= relationalExpr )*
            {
            pushFollow(FOLLOW_relationalExpr_in_equalityExpr205);
            e=relationalExpr();
            _fsp--;

             value = e; 
            // Confml.g:129:3: ( '=' e2= relationalExpr | '!=' e2= relationalExpr )*
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
            	    // Confml.g:130:5: '=' e2= relationalExpr
            	    {
            	    match(input,11,FOLLOW_11_in_equalityExpr230); 
            	    pushFollow(FOLLOW_relationalExpr_in_equalityExpr238);
            	    e2=relationalExpr();
            	    _fsp--;

            	     value = areObjectsEqual(e, e2); 

            	    }
            	    break;
            	case 2 :
            	    // Confml.g:135:5: '!=' e2= relationalExpr
            	    {
            	    match(input,12,FOLLOW_12_in_equalityExpr270); 
            	    pushFollow(FOLLOW_relationalExpr_in_equalityExpr277);
            	    e2=relationalExpr();
            	    _fsp--;

            	     value = !areObjectsEqual(e, e2); 

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
        return value;
    }
    // $ANTLR end equalityExpr


    // $ANTLR start relationalExpr
    // Confml.g:139:1: relationalExpr returns [Object value] : e= additiveExpr ( '<' e2= additiveExpr | '>' e2= additiveExpr | '<=' e2= additiveExpr | '>=' e2= additiveExpr )* ;
    public final Object relationalExpr() throws RecognitionException {
        Object value = null;

        Object e = null;

        Object e2 = null;


        try {
            // Confml.g:140:3: (e= additiveExpr ( '<' e2= additiveExpr | '>' e2= additiveExpr | '<=' e2= additiveExpr | '>=' e2= additiveExpr )* )
            // Confml.g:140:3: e= additiveExpr ( '<' e2= additiveExpr | '>' e2= additiveExpr | '<=' e2= additiveExpr | '>=' e2= additiveExpr )*
            {
            pushFollow(FOLLOW_additiveExpr_in_relationalExpr306);
            e=additiveExpr();
            _fsp--;

             value = e; 
            // Confml.g:141:3: ( '<' e2= additiveExpr | '>' e2= additiveExpr | '<=' e2= additiveExpr | '>=' e2= additiveExpr )*
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
            	    // Confml.g:142:5: '<' e2= additiveExpr
            	    {
            	    match(input,13,FOLLOW_13_in_relationalExpr333); 
            	    pushFollow(FOLLOW_additiveExpr_in_relationalExpr341);
            	    e2=additiveExpr();
            	    _fsp--;

            	    
            	                                                value = (Double.valueOf(e.toString()).compareTo(Double.valueOf(e2.toString()))) == -1;    
            	                                               

            	    }
            	    break;
            	case 2 :
            	    // Confml.g:146:5: '>' e2= additiveExpr
            	    {
            	    match(input,14,FOLLOW_14_in_relationalExpr404); 
            	    pushFollow(FOLLOW_additiveExpr_in_relationalExpr412);
            	    e2=additiveExpr();
            	    _fsp--;

            	    
            	                                                value = (Double.valueOf(e.toString()).compareTo(Double.valueOf(e2.toString()))) == 1;
            	                                               

            	    }
            	    break;
            	case 3 :
            	    // Confml.g:150:5: '<=' e2= additiveExpr
            	    {
            	    match(input,15,FOLLOW_15_in_relationalExpr475); 
            	    pushFollow(FOLLOW_additiveExpr_in_relationalExpr483);
            	    e2=additiveExpr();
            	    _fsp--;

            	    
            	                                                value = (Double.valueOf(e.toString()).compareTo(Double.valueOf(e2.toString()))) <= 0; 
            	                                               

            	    }
            	    break;
            	case 4 :
            	    // Confml.g:154:5: '>=' e2= additiveExpr
            	    {
            	    match(input,16,FOLLOW_16_in_relationalExpr546); 
            	    pushFollow(FOLLOW_additiveExpr_in_relationalExpr554);
            	    e2=additiveExpr();
            	    _fsp--;

            	    
            	                                               value = (Double.valueOf(e.toString()).compareTo(Double.valueOf(e2.toString()))) >= 0;
            	                                               

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
        return value;
    }
    // $ANTLR end relationalExpr


    // $ANTLR start additiveExpr
    // Confml.g:161:1: additiveExpr returns [Object value] : multiplicativeExpr ( '+' e= multiplicativeExpr | '-' e= multiplicativeExpr )* ;
    public final Object additiveExpr() throws RecognitionException {
        Object value = null;

        Object e = null;

        Object multiplicativeExpr2 = null;


        try {
            // Confml.g:162:2: ( multiplicativeExpr ( '+' e= multiplicativeExpr | '-' e= multiplicativeExpr )* )
            // Confml.g:162:2: multiplicativeExpr ( '+' e= multiplicativeExpr | '-' e= multiplicativeExpr )*
            {
            pushFollow(FOLLOW_multiplicativeExpr_in_additiveExpr593);
            multiplicativeExpr2=multiplicativeExpr();
            _fsp--;

             value = multiplicativeExpr2;
            // Confml.g:163:2: ( '+' e= multiplicativeExpr | '-' e= multiplicativeExpr )*
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
            	    // Confml.g:164:4: '+' e= multiplicativeExpr
            	    {
            	    match(input,17,FOLLOW_17_in_additiveExpr616); 
            	    pushFollow(FOLLOW_multiplicativeExpr_in_additiveExpr624);
            	    e=multiplicativeExpr();
            	    _fsp--;

            	     value = Double.parseDouble(value.toString()) + Double.parseDouble(e.toString()); 

            	    }
            	    break;
            	case 2 :
            	    // Confml.g:165:7: '-' e= multiplicativeExpr
            	    {
            	    match(input,18,FOLLOW_18_in_additiveExpr636); 
            	    pushFollow(FOLLOW_multiplicativeExpr_in_additiveExpr644);
            	    e=multiplicativeExpr();
            	    _fsp--;

            	     value = Double.parseDouble(value.toString()) - Double.parseDouble(e.toString()); 

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
        return value;
    }
    // $ANTLR end additiveExpr


    // $ANTLR start multiplicativeExpr
    // Confml.g:169:1: multiplicativeExpr returns [Object value] : e= unaryExpr ( '*' e2= unaryExpr | 'div' e2= unaryExpr | 'mod' e2= unaryExpr )* ;
    public final Object multiplicativeExpr() throws RecognitionException {
        Object value = null;

        Object e = null;

        Object e2 = null;


        try {
            // Confml.g:170:2: (e= unaryExpr ( '*' e2= unaryExpr | 'div' e2= unaryExpr | 'mod' e2= unaryExpr )* )
            // Confml.g:170:2: e= unaryExpr ( '*' e2= unaryExpr | 'div' e2= unaryExpr | 'mod' e2= unaryExpr )*
            {
            pushFollow(FOLLOW_unaryExpr_in_multiplicativeExpr670);
            e=unaryExpr();
            _fsp--;

             value = e; 
            // Confml.g:171:2: ( '*' e2= unaryExpr | 'div' e2= unaryExpr | 'mod' e2= unaryExpr )*
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
            	    // Confml.g:172:4: '*' e2= unaryExpr
            	    {
            	    match(input,19,FOLLOW_19_in_multiplicativeExpr698); 
            	    pushFollow(FOLLOW_unaryExpr_in_multiplicativeExpr706);
            	    e2=unaryExpr();
            	    _fsp--;

            	     value = Double.parseDouble(value.toString()) * Double.parseDouble(e2.toString()); 

            	    }
            	    break;
            	case 2 :
            	    // Confml.g:173:4: 'div' e2= unaryExpr
            	    {
            	    match(input,20,FOLLOW_20_in_multiplicativeExpr722); 
            	    pushFollow(FOLLOW_unaryExpr_in_multiplicativeExpr728);
            	    e2=unaryExpr();
            	    _fsp--;

            	     value = Double.parseDouble(value.toString()) / Double.parseDouble(e2.toString()); 

            	    }
            	    break;
            	case 3 :
            	    // Confml.g:174:4: 'mod' e2= unaryExpr
            	    {
            	    match(input,21,FOLLOW_21_in_multiplicativeExpr744); 
            	    pushFollow(FOLLOW_unaryExpr_in_multiplicativeExpr750);
            	    e2=unaryExpr();
            	    _fsp--;

            	     value = Double.parseDouble(value.toString()) % Double.parseDouble(e2.toString()); 

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
        return value;
    }
    // $ANTLR end multiplicativeExpr


    // $ANTLR start unaryExpr
    // Confml.g:178:1: unaryExpr returns [Object value] : ( primaryExpr | '-' primaryExpr );
    public final Object unaryExpr() throws RecognitionException {
        Object value = null;

        Object primaryExpr3 = null;

        Object primaryExpr4 = null;


        try {
            // Confml.g:179:3: ( primaryExpr | '-' primaryExpr )
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
                    new NoViableAltException("178:1: unaryExpr returns [Object value] : ( primaryExpr | '-' primaryExpr );", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // Confml.g:179:3: primaryExpr
                    {
                    pushFollow(FOLLOW_primaryExpr_in_unaryExpr781);
                    primaryExpr3=primaryExpr();
                    _fsp--;

                     value = primaryExpr3 ; 

                    }
                    break;
                case 2 :
                    // Confml.g:180:5: '-' primaryExpr
                    {
                    match(input,18,FOLLOW_18_in_unaryExpr809); 
                    pushFollow(FOLLOW_primaryExpr_in_unaryExpr811);
                    primaryExpr4=primaryExpr();
                    _fsp--;

                     value = -Double.parseDouble(primaryExpr4.toString()) ; 

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
        return value;
    }
    // $ANTLR end unaryExpr


    // $ANTLR start primaryExpr
    // Confml.g:183:1: primaryExpr returns [Object value] : ( settingValueRef | '(' orExpr ')' | Literal | Number );
    public final Object primaryExpr() throws RecognitionException {
        Object value = null;

        Token Literal7=null;
        Token Number8=null;
        Object settingValueRef5 = null;

        Object orExpr6 = null;


        try {
            // Confml.g:184:3: ( settingValueRef | '(' orExpr ')' | Literal | Number )
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
                    new NoViableAltException("183:1: primaryExpr returns [Object value] : ( settingValueRef | '(' orExpr ')' | Literal | Number );", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // Confml.g:184:3: settingValueRef
                    {
                    pushFollow(FOLLOW_settingValueRef_in_primaryExpr842);
                    settingValueRef5=settingValueRef();
                    _fsp--;

                     value = settingValueRef5; 

                    }
                    break;
                case 2 :
                    // Confml.g:185:5: '(' orExpr ')'
                    {
                    match(input,22,FOLLOW_22_in_primaryExpr866); 
                    pushFollow(FOLLOW_orExpr_in_primaryExpr868);
                    orExpr6=orExpr();
                    _fsp--;

                    match(input,23,FOLLOW_23_in_primaryExpr870); 
                     value = orExpr6 ; 

                    }
                    break;
                case 3 :
                    // Confml.g:186:5: Literal
                    {
                    Literal7=(Token)input.LT(1);
                    match(input,Literal,FOLLOW_Literal_in_primaryExpr893); 
                    
                                                        value = Literal7.getText();
                                                        String str = value.toString();
                                        
                    								                    if (str.contains("&amp;")) {
                    								                      value = str.replaceAll("&amp;", "&");
                    								                    }
                    								                    
                    								                    if ((str.startsWith("\"") && str.endsWith("\"")) || (str.startsWith("\'") && str.endsWith("\'"))) {
                    								                      value = str.substring(1, Literal7.getText().length() - 1);                     
                    								                    } else if (str.startsWith("&apos;") && str.endsWith("&apos;")) {
                    								                      value = str.replaceAll("&apos;", "");
                    								                    } else if (str.startsWith("&quot;") && str.endsWith("&quot;")) {
                    								                      value = str.replaceAll("&quot;", "");
                    								                    }
                                                      

                    }
                    break;
                case 4 :
                    // Confml.g:202:5: Number
                    {
                    Number8=(Token)input.LT(1);
                    match(input,Number,FOLLOW_Number_in_primaryExpr923); 
                     value = Number8.getText() ; 

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
        return value;
    }
    // $ANTLR end primaryExpr


    // $ANTLR start settingValueRef
    // Confml.g:207:1: settingValueRef returns [Object value] : ( '.' | r= Ref | (r1= Ref '/' r2= Ref ) | (r1= Ref '/' rx= Ref '[' n= Number ']' '/' rs= Ref ) | r1= Ref '/' r2= Ref '/' r3= Ref );
    public final Object settingValueRef() throws RecognitionException {
        Object value = null;

        Token r=null;
        Token r1=null;
        Token r2=null;
        Token rx=null;
        Token n=null;
        Token rs=null;
        Token r3=null;

        try {
            // Confml.g:208:3: ( '.' | r= Ref | (r1= Ref '/' r2= Ref ) | (r1= Ref '/' rx= Ref '[' n= Number ']' '/' rs= Ref ) | r1= Ref '/' r2= Ref '/' r3= Ref )
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
                                new NoViableAltException("207:1: settingValueRef returns [Object value] : ( '.' | r= Ref | (r1= Ref '/' r2= Ref ) | (r1= Ref '/' rx= Ref '[' n= Number ']' '/' rs= Ref ) | r1= Ref '/' r2= Ref '/' r3= Ref );", 10, 5, input);

                            throw nvae;
                        }

                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("207:1: settingValueRef returns [Object value] : ( '.' | r= Ref | (r1= Ref '/' r2= Ref ) | (r1= Ref '/' rx= Ref '[' n= Number ']' '/' rs= Ref ) | r1= Ref '/' r2= Ref '/' r3= Ref );", 10, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA10_2==NEWLINE||(LA10_2>=9 && LA10_2<=21)||LA10_2==23) ) {
                    alt10=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("207:1: settingValueRef returns [Object value] : ( '.' | r= Ref | (r1= Ref '/' r2= Ref ) | (r1= Ref '/' rx= Ref '[' n= Number ']' '/' rs= Ref ) | r1= Ref '/' r2= Ref '/' r3= Ref );", 10, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("207:1: settingValueRef returns [Object value] : ( '.' | r= Ref | (r1= Ref '/' r2= Ref ) | (r1= Ref '/' rx= Ref '[' n= Number ']' '/' rs= Ref ) | r1= Ref '/' r2= Ref '/' r3= Ref );", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // Confml.g:208:3: '.'
                    {
                    match(input,24,FOLLOW_24_in_settingValueRef965); 
                    											if(getSetting() instanceof FileSystemEntrySetting){
                    											   if(getSetting() instanceof FilePath){
                    											      value = ((FilePath)getSetting()).getPath();
                    										       }
                    											   else{
                    												  value = ((FileSystemEntrySetting)getSetting()).getSourceFilePath().getPath();
                    											   }
                    											}
                    											else{
                                                                  value = ((SimpleSetting)getSetting()).getValue();
                                                                }
                                                                  

                    }
                    break;
                case 2 :
                    // Confml.g:211:5: r= Ref
                    {
                    r=(Token)input.LT(1);
                    match(input,Ref,FOLLOW_Ref_in_settingValueRef1017); 
                    
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
                    break;
                case 3 :
                    // Confml.g:255:5: (r1= Ref '/' r2= Ref )
                    {
                    // Confml.g:255:5: (r1= Ref '/' r2= Ref )
                    // Confml.g:255:6: r1= Ref '/' r2= Ref
                    {
                    r1=(Token)input.LT(1);
                    match(input,Ref,FOLLOW_Ref_in_settingValueRef1064); 
                    match(input,25,FOLLOW_25_in_settingValueRef1066); 
                    r2=(Token)input.LT(1);
                    match(input,Ref,FOLLOW_Ref_in_settingValueRef1072); 

                    }

                    
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
                    break;
                case 4 :
                    // Confml.g:276:5: (r1= Ref '/' rx= Ref '[' n= Number ']' '/' rs= Ref )
                    {
                    // Confml.g:276:5: (r1= Ref '/' rx= Ref '[' n= Number ']' '/' rs= Ref )
                    // Confml.g:276:6: r1= Ref '/' rx= Ref '[' n= Number ']' '/' rs= Ref
                    {
                    r1=(Token)input.LT(1);
                    match(input,Ref,FOLLOW_Ref_in_settingValueRef1106); 
                    match(input,25,FOLLOW_25_in_settingValueRef1108); 
                    rx=(Token)input.LT(1);
                    match(input,Ref,FOLLOW_Ref_in_settingValueRef1114); 
                    match(input,26,FOLLOW_26_in_settingValueRef1116); 
                    n=(Token)input.LT(1);
                    match(input,Number,FOLLOW_Number_in_settingValueRef1122); 
                    match(input,27,FOLLOW_27_in_settingValueRef1124); 
                    match(input,25,FOLLOW_25_in_settingValueRef1126); 
                    rs=(Token)input.LT(1);
                    match(input,Ref,FOLLOW_Ref_in_settingValueRef1132); 

                    }

                    
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
                    break;
                case 5 :
                    // Confml.g:310:5: r1= Ref '/' r2= Ref '/' r3= Ref
                    {
                    r1=(Token)input.LT(1);
                    match(input,Ref,FOLLOW_Ref_in_settingValueRef1148); 
                    match(input,25,FOLLOW_25_in_settingValueRef1150); 
                    r2=(Token)input.LT(1);
                    match(input,Ref,FOLLOW_Ref_in_settingValueRef1156); 
                    match(input,25,FOLLOW_25_in_settingValueRef1158); 
                    r3=(Token)input.LT(1);
                    match(input,Ref,FOLLOW_Ref_in_settingValueRef1164); 
                      
                      
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
                                                                      value = fs.getSourceFilePath().getPath();
                                                                    } else if (r3.getText().equals("targetPath")) {
                                                                      value = fs.getTargetFilePath().getPath();
                                                                    }
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
        return value;
    }
    // $ANTLR end settingValueRef


 

    public static final BitSet FOLLOW_orExpr_in_expr40 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_NEWLINE_in_expr42 = new BitSet(new long[]{0x00000000014400E2L});
    public static final BitSet FOLLOW_andExpr_in_orExpr65 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_9_in_orExpr97 = new BitSet(new long[]{0x00000000014400E0L});
    public static final BitSet FOLLOW_andExpr_in_orExpr104 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_equalityExpr_in_andExpr140 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_10_in_andExpr167 = new BitSet(new long[]{0x00000000014400E0L});
    public static final BitSet FOLLOW_equalityExpr_in_andExpr173 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_relationalExpr_in_equalityExpr205 = new BitSet(new long[]{0x0000000000001802L});
    public static final BitSet FOLLOW_11_in_equalityExpr230 = new BitSet(new long[]{0x00000000014400E0L});
    public static final BitSet FOLLOW_relationalExpr_in_equalityExpr238 = new BitSet(new long[]{0x0000000000001802L});
    public static final BitSet FOLLOW_12_in_equalityExpr270 = new BitSet(new long[]{0x00000000014400E0L});
    public static final BitSet FOLLOW_relationalExpr_in_equalityExpr277 = new BitSet(new long[]{0x0000000000001802L});
    public static final BitSet FOLLOW_additiveExpr_in_relationalExpr306 = new BitSet(new long[]{0x000000000001E002L});
    public static final BitSet FOLLOW_13_in_relationalExpr333 = new BitSet(new long[]{0x00000000014400E0L});
    public static final BitSet FOLLOW_additiveExpr_in_relationalExpr341 = new BitSet(new long[]{0x000000000001E002L});
    public static final BitSet FOLLOW_14_in_relationalExpr404 = new BitSet(new long[]{0x00000000014400E0L});
    public static final BitSet FOLLOW_additiveExpr_in_relationalExpr412 = new BitSet(new long[]{0x000000000001E002L});
    public static final BitSet FOLLOW_15_in_relationalExpr475 = new BitSet(new long[]{0x00000000014400E0L});
    public static final BitSet FOLLOW_additiveExpr_in_relationalExpr483 = new BitSet(new long[]{0x000000000001E002L});
    public static final BitSet FOLLOW_16_in_relationalExpr546 = new BitSet(new long[]{0x00000000014400E0L});
    public static final BitSet FOLLOW_additiveExpr_in_relationalExpr554 = new BitSet(new long[]{0x000000000001E002L});
    public static final BitSet FOLLOW_multiplicativeExpr_in_additiveExpr593 = new BitSet(new long[]{0x0000000000060002L});
    public static final BitSet FOLLOW_17_in_additiveExpr616 = new BitSet(new long[]{0x00000000014400E0L});
    public static final BitSet FOLLOW_multiplicativeExpr_in_additiveExpr624 = new BitSet(new long[]{0x0000000000060002L});
    public static final BitSet FOLLOW_18_in_additiveExpr636 = new BitSet(new long[]{0x00000000014400E0L});
    public static final BitSet FOLLOW_multiplicativeExpr_in_additiveExpr644 = new BitSet(new long[]{0x0000000000060002L});
    public static final BitSet FOLLOW_unaryExpr_in_multiplicativeExpr670 = new BitSet(new long[]{0x0000000000380002L});
    public static final BitSet FOLLOW_19_in_multiplicativeExpr698 = new BitSet(new long[]{0x00000000014400E0L});
    public static final BitSet FOLLOW_unaryExpr_in_multiplicativeExpr706 = new BitSet(new long[]{0x0000000000380002L});
    public static final BitSet FOLLOW_20_in_multiplicativeExpr722 = new BitSet(new long[]{0x00000000014400E0L});
    public static final BitSet FOLLOW_unaryExpr_in_multiplicativeExpr728 = new BitSet(new long[]{0x0000000000380002L});
    public static final BitSet FOLLOW_21_in_multiplicativeExpr744 = new BitSet(new long[]{0x00000000014400E0L});
    public static final BitSet FOLLOW_unaryExpr_in_multiplicativeExpr750 = new BitSet(new long[]{0x0000000000380002L});
    public static final BitSet FOLLOW_primaryExpr_in_unaryExpr781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_unaryExpr809 = new BitSet(new long[]{0x00000000014000E0L});
    public static final BitSet FOLLOW_primaryExpr_in_unaryExpr811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_settingValueRef_in_primaryExpr842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_primaryExpr866 = new BitSet(new long[]{0x00000000014400E0L});
    public static final BitSet FOLLOW_orExpr_in_primaryExpr868 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_primaryExpr870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Literal_in_primaryExpr893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Number_in_primaryExpr923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_settingValueRef965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ref_in_settingValueRef1017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ref_in_settingValueRef1064 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_settingValueRef1066 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_Ref_in_settingValueRef1072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ref_in_settingValueRef1106 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_settingValueRef1108 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_Ref_in_settingValueRef1114 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_settingValueRef1116 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_Number_in_settingValueRef1122 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_settingValueRef1124 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_settingValueRef1126 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_Ref_in_settingValueRef1132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ref_in_settingValueRef1148 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_settingValueRef1150 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_Ref_in_settingValueRef1156 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_settingValueRef1158 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_Ref_in_settingValueRef1164 = new BitSet(new long[]{0x0000000000000002L});

}
