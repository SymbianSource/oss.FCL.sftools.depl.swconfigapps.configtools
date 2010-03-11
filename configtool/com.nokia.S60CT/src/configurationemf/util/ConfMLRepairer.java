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
package configurationemf.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.URI;

public class ConfMLRepairer {
	public static final String regexXinclude = "http://www.w3.org/2001/xinclude";
	public static final String regexConfml2 = "http://www.s60.com/xml/confml/2";
	public static final String regexAscii = "encoding=\"ASCII\"";
	public static final String regexSchemaDefinitions1 = "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"";
	public static final String regexSchemaDefinitions2 = "xsi:schemaLocation=\"http://www.s60.com/xml/confml/1 http://www.s60.com/xml/confml/1#//confml2 http://www.w3.org/2001/XInclude http://www.s60.com/xml/confml/1#//include\"";
	
	public static final String regexFragment = "href=\".*?\\.confml\\s*?\"";
	private static final String fragment = "#/\"";
	private String charSet;
	private boolean fileModified = false;
	
	public boolean repair(URI uri) {
		charSet = ConfMLHelper.determineCharset(uri);
		charSet = fixCharset(charSet);
		String content = readAndRepairContents(uri);
		if(fileModified) {
			saveContents(content,uri);			
		}
		return true;
	}

	private void saveContents(String content, URI uri) {
		try {
			BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(uri.toFileString()),charSet));
			bWriter.write(content);
			bWriter.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String readAndRepairContents(URI uri) {
		charSet = fixCharset(charSet);
		try {
			BufferedReader bReader = new BufferedReader(new InputStreamReader
					(new FileInputStream(uri.toFileString()),charSet));
			
			String line = null;
			StringBuilder sb = new StringBuilder();
			while((line=bReader.readLine())!=null) {
				sb.append(line+System.getProperty("line.separator"));
			}
			bReader.close();
			
			String cont = sb.toString();
			
			Pattern p = Pattern.compile(regexXinclude);
			Matcher matcher = p.matcher(cont);
			
			StringBuffer sbuffer = new StringBuffer();
			while(matcher.find()) {
				matcher.appendReplacement(sbuffer, XMLCustomizerCONFML.includeNS);
				fileModified = true;
			}
			matcher.appendTail(sbuffer);
			
			cont = sbuffer.toString();
			sbuffer = new StringBuffer();
			
			p = Pattern.compile(regexFragment);
			matcher = p.matcher(cont);
			
			while(matcher.find()) {
				String rep = cont.substring(matcher.start(), matcher.end()-1) + fragment;
				matcher.appendReplacement(sbuffer, rep);
				fileModified = true;
			}
			matcher.appendTail(sbuffer);
			return sbuffer.toString();
			/*
			String cont = sb.toString();
			
			Pattern p = Pattern.compile(regexAscii);
			Matcher matcher = p.matcher(cont);
			
			StringBuffer sbuffer = new StringBuffer();
			while(matcher.find()) {
				matcher.appendReplacement(sbuffer, XMLCustomizerCONFML.utf16);
				fileModified = true;
			}
			matcher.appendTail(sbuffer);
			
			cont = sbuffer.toString();
			
			p = Pattern.compile(regexSchemaDefinitions1);
			matcher = p.matcher(cont);
			
			sbuffer = new StringBuffer();
			while(matcher.find()) {
				matcher.appendReplacement(sbuffer, XMLCustomizerCONFML.emptyString);
				fileModified = true;
			}
			matcher.appendTail(sbuffer);
			
			cont = sbuffer.toString();
			
			p = Pattern.compile(regexConfml2);
			matcher = p.matcher(cont);
			
			sbuffer = new StringBuffer();
			while(matcher.find()) {
				matcher.appendReplacement(sbuffer, XMLCustomizerCONFML.confml1);
				fileModified = true;
			}
			matcher.appendTail(sbuffer);
			
			cont = sbuffer.toString();
			
			p = Pattern.compile(regexXinclude);
			matcher = p.matcher(cont);
			
			sbuffer = new StringBuffer();
			while(matcher.find()) {
				matcher.appendReplacement(sbuffer, XMLCustomizerCONFML.includeNS);
				fileModified = true;
			}
			matcher.appendTail(sbuffer);
			
			cont = sbuffer.toString();
			
			p = Pattern.compile(regexSchemaDefinitions2);
			matcher = p.matcher(cont);
			
			sbuffer = new StringBuffer();
			while(matcher.find()) {
				matcher.appendReplacement(sbuffer, XMLCustomizerCONFML.emptyString);
				fileModified = true;
			}
			matcher.appendTail(sbuffer);
			
			cont = sbuffer.toString();
			sbuffer = new StringBuffer();
			
			p = Pattern.compile(regexFragment);
			matcher = p.matcher(cont);
			
			while(matcher.find()) {
				String rep = cont.substring(matcher.start(), matcher.end()-1) + fragment;
				matcher.appendReplacement(sbuffer, rep);
				fileModified = true;
			}
			matcher.appendTail(sbuffer);
			return sbuffer.toString();*/
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private String fixCharset(String cSet) {
		if(cSet==null) {
			cSet = "UTF-16"; 
		}
		if((cSet.equalsIgnoreCase("ansi"))||(cSet.equalsIgnoreCase("ascii"))) {			
			cSet = "UTF-8";
		}
		return cSet;
	}

}
