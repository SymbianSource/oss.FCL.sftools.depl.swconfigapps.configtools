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
package com.nokia.tools.s60ct.confml.widgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.widgets.Composite;

public class DateTimeDurationWidget extends StringTextBox {

	static final int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public static final int MODE_DATE = 1;
	public static final int MODE_TIME = 2;
	public static final int MODE_DATETIME = 3;
	public static final int MODE_DURATION = 4;
	
	int mode = -1;
	
	public DateTimeDurationWidget(Composite parent, int style, String widgetLabel, int mode) {
		
		super(parent, style, widgetLabel);
		
		this.mode = mode;
		String toolTip = "";
		if (mode==MODE_DATE)
		{
			toolTip = "Format is YYYY-MM-DD";
		}
		else if (mode==MODE_TIME)
		{
			toolTip = "Format is one of the following:\n hh:mm:ss \n hh:mm:ssZ \n hh:mm:ss+hh:mm";
		}
		else if (mode==MODE_DATETIME)
		{
			toolTip = "Format is one of the following:\n YYYY-MM-DD-hh:mm:ss \n YYYY-MM-DD-hh:mm:ssZ \n YYYY-MM-DD-hh:mm:ss+hh:mm";
		}
		else if (mode==MODE_DURATION)
		{
			toolTip = "Format is PnYnMnDTnHnMnS where:\n" +
					" P = start of period (required)\n" +
					" nY = number of years\n" +
					" nM = number of months\n" +
					" nD = number of days\n" +
					" T = start of time section.\n Required if hour, minute or second is specified.\n" +
					" nH = number of hours\n" +
					" nM = number of minutes\n" +
					" nS = number of seconds";
		}
		text.addKeyListener(new MyKeyListener());
		text.setToolTipText(toolTip);
		
	}
	

	
	@Override
	public void setValue(String value) {
		super.setValue(value);
		doCheck(SWT.BS);
	}



	private boolean checkDateString(char character)
	{
		String dateString = text.getText();

		if (dateString!=null && !dateString.trim().equals(""))
		{
			boolean ok = false;
			if (dateString.matches("\\d\\d\\d\\d-\\d\\d-\\d\\d")) //YYYY-MM-DD
			{
				String[] split = dateString.split("-");
				ok = checkCalendar(split);
			}
			if (character == SWT.BS || character == SWT.DEL)
				return ok;
			if (dateString.matches("\\d\\d\\d\\d") || dateString.matches("\\d\\d\\d\\d-\\d\\d"))
			{
				text.append("-");
			}
			return ok;
		}
		else
			return true;
	}
	
	private boolean checkTimeString(char character)
	{
		String timeString = text.getText();
		
		if (timeString!=null && !timeString.trim().equals(""))
		{
			boolean ok = false;
		
			if (timeString.matches("\\d\\d:\\d\\d:\\d\\d")) //hh:mm:ss
			{
				String[] split = timeString.split(":");
				ok = checkClock(split, null);
			}
			else if (timeString.matches("\\d\\d:\\d\\d:\\d\\dZ")) //hh:mm:ssZ
			{
				String[] split = timeString.split(":");
				split[2] = split[2].substring(0, 2);
				ok = checkClock(split, null);
			}
			else if (timeString.matches("\\d\\d:\\d\\d:\\d\\d[+-]\\d\\d:\\d\\d")) //hh:mm:ss+hh:mm
			{
				String[] split = timeString.split(":");
				String timeZone = timeString.substring(8);
				split[2] = split[2].substring(0, 2);
				ok = checkClock(split, timeZone);
			}
			if (character == SWT.BS || character == SWT.DEL)
				return ok;
			if (timeString.matches("\\d\\d") || 
				timeString.matches("\\d\\d:\\d\\d") || 
				timeString.matches("\\d\\d:\\d\\d:\\d\\d[+-]\\d\\d"))
			{
				text.append(":");
			}
			
			
			return ok;
		}
		return true;
	}
	
	private boolean checkDateTimeString(char character)
	{
		String dateTimeString = text.getText();
		
		if (dateTimeString!=null && !dateTimeString.trim().equals(""))
		{
			boolean ok = false;
		
			if (dateTimeString.matches("\\d\\d\\d\\d-\\d\\d-\\d\\d-\\d\\d:\\d\\d:\\d\\d")) //YYYY-MM-DD-hh:mm:ss
			{
				String[] split = dateTimeString.split("-");
				ok = checkCalendar(split, null);
			}
			else if (dateTimeString.matches("\\d\\d\\d\\d-\\d\\d-\\d\\d-\\d\\d:\\d\\d:\\d\\dZ")) //YYYY-MM-DD-hh:mm:ssZ
			{
				String[] split = dateTimeString.split("-");
				split[3] = split[3].substring(0, 8);
				ok = checkCalendar(split, null);
			}
			else if (dateTimeString.matches("\\d\\d\\d\\d-\\d\\d-\\d\\d-\\d\\d:\\d\\d:\\d\\d[+-]\\d\\d:\\d\\d")) //YYYY-MM-DD-hh:mm:ss+hh:mm
			{
				String[] split = dateTimeString.split("-");
				String timeZone = dateTimeString.substring(19);
				split[3] = split[3].substring(0, 8);
				ok = checkCalendar(split, timeZone);
			}
			if (character == SWT.BS || character == SWT.DEL)
				return ok;
			if (dateTimeString.matches("\\d\\d\\d\\d") || 
				dateTimeString.matches("\\d\\d\\d\\d-\\d\\d") || 
				dateTimeString.matches("\\d\\d\\d\\d-\\d\\d-\\d\\d"))
			{
				text.append("-");
			}
			
			if (dateTimeString.matches("\\d\\d\\d\\d-\\d\\d-\\d\\d-\\d\\d") || 
				dateTimeString.matches("\\d\\d\\d\\d-\\d\\d-\\d\\d-\\d\\d:\\d\\d") ||
				dateTimeString.matches("\\d\\d\\d\\d-\\d\\d-\\d\\d-\\d\\d:\\d\\d:\\d\\d[+-]\\d\\d"))
			
			{
				text.append(":");
			}
			return ok;
		}
		return true;
	}
	
	private boolean checkDurationString(char character)
	{
		String durationString = text.getText();
		
		if (durationString!=null && !durationString.trim().equals(""))
		{
			boolean inTime = false;
			int startIndex = 1;
			Integer years = null;
			Integer months = null;
			Integer days = null;
			Integer hours = null;
			Integer minutes = null;
			Integer seconds = null;
			
			if (!durationString.startsWith("P") || durationString.length() < 3)
				return false;
			try
			{
				for (int i = 1 ; i < durationString.length() ; i++)
				{
					char c = durationString.charAt(i);
					
					if (Character.isDigit(c))
					{
						if (i==durationString.length()-1)
							return false;
					}
					else if (!inTime)
					{
						if (c=='T')
						{
							inTime = true;
							startIndex = i+1;
						}
						else if (c=='Y' && years == null && months == null && days == null)
						{
							String duration = durationString.substring(startIndex, i);
							years = new Integer(duration);
							startIndex = i+1;
						}
						else if (c=='M' && months == null && days == null)
						{
							String duration = durationString.substring(startIndex, i);
							months = new Integer(duration);
							startIndex = i+1;
						}
						else if (c=='D' && days == null)
						{
							String duration = durationString.substring(startIndex, i);
							days = new Integer(duration);
							startIndex = i+1;
						}
						else 
							return false;
					}
					else if (inTime)
					{
						if (c=='H' && hours == null && minutes == null && seconds == null)
						{
							String duration = durationString.substring(startIndex, i);
							hours = new Integer(duration);
							startIndex = i+1;
						}
						else if (c=='M' && minutes == null && seconds == null)
						{
							String duration = durationString.substring(startIndex, i);
							minutes = new Integer(duration);
							startIndex = i+1;
						}
						else if (c=='S' && seconds == null)
						{
							String duration = durationString.substring(startIndex, i);
							seconds = new Integer(duration);
							startIndex = i+1;
						}
						else 
							return false;
					}
					else 
						return false;
				}
				return true;
			}
			catch (Exception e)
			{
				return false;
			}
			
		}
		return true;
	}
	
	class MyKeyListener implements KeyListener
	{
		public void keyPressed(KeyEvent e) {
			
		}

		public void keyReleased(KeyEvent e) {
			
			doCheck(e.character);
		}
	}

	
	private void doCheck(char typedChar)
	{
		boolean ok = true;
		
		if (mode == MODE_DATE)
			ok = checkDateString(typedChar);
		else if (mode == MODE_TIME)
			ok = checkTimeString(typedChar);
		else if (mode == MODE_DATETIME)
			ok = checkDateTimeString(typedChar);
		else if (mode == MODE_DURATION)
			ok = checkDurationString(typedChar);
		
		setValid(ok);
	}
	
	private boolean checkCalendar(String[] split)
	{
		int year = (new Integer(split[0]).intValue());
		int month = (new Integer(split[1]).intValue());
		int day = (new Integer(split[2]).intValue());
		
		if (month < 1 || month > 12)
			return false;
		int maxDays = daysInMonth[month-1];
		if (year%4==0 && month==2)
			maxDays = 29;
		if (day < 1 || day > maxDays)
			return false;
		
		return true;
	}	
	
	private boolean checkClock(String[] split, String timeZone)
	{
		int hour = (new Integer(split[0]).intValue());
		int minute = (new Integer(split[1]).intValue());
		int second = (new Integer(split[2]).intValue());
		
		if (hour > 23 || minute > 59 || second > 59)
			return false;
		
		if (timeZone!=null)
		{
			return checkTimeZone(timeZone);
		}
		return true;
	}
	
	private boolean checkCalendar(String[] split, String timeZone)
	{
		int year = (new Integer(split[0]).intValue());
		int month = (new Integer(split[1]).intValue());
		int day = (new Integer(split[2]).intValue());
		String[] splitByTime = split[3].split(":");
		int hour = (new Integer(splitByTime[0]).intValue());
		int minute = (new Integer(splitByTime[1]).intValue());
		int second = (new Integer(splitByTime[2]).intValue());
		
		if (month < 1 || month > 12)
			return false;
		int maxDays = daysInMonth[month-1];
		if (year%4==0 && month==2)
			maxDays = 29;
		if (day < 1 || day > maxDays)
			return false;
		if (hour > 23 || minute > 59 || second > 59)
			return false;
		
		if (timeZone!=null)
		{
			return checkTimeZone(timeZone);
		}
		return true;
	}
	
	private boolean checkTimeZone(String timeZone)
	{
		String[] timeZoneSplit = timeZone.split(":");
		if (timeZoneSplit[0].startsWith("+"))
			timeZoneSplit[0] = timeZoneSplit[0].substring(1);
		int tzHour = (new Integer(timeZoneSplit[0]).intValue());
		int tzMinute = (new Integer(timeZoneSplit[1]).intValue());
		
		if (tzHour >= -12 && tzHour <= 14)
		{
			if (tzMinute == 0)
			{
				return true;
			}
			else if (tzMinute == 30)
			{
				if (tzHour==11 || tzHour==10 || tzHour==9 || tzHour==6 || tzHour==5 || tzHour==4 || tzHour==3 || tzHour==-3 || tzHour==4|| tzHour==-9)
					return true;
			}
			else if (tzMinute == 45)
			{
				if (tzHour==12|| tzHour==8 || tzHour==5)
					return true;
			}
		}
		return false;
	}
	
}
