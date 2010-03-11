@echo off
rem
rem Copyright (c) 2009 Nokia Corporation and/or its subsidiary(-ies).
rem All rights reserved.
rem This component and the accompanying materials are made available
rem under the terms of "Eclipse Public License v1.0"
rem which accompanies this distribution, and is available
rem at the URL "http://www.eclipse.org/legal/epl-v10.html".
rem
rem Initial Contributors:
rem Nokia Corporation - initial contribution.
rem
rem Contributors:
rem
rem Description:
rem



REM set the eclipse params
REM application to CLI 
REM noSplash screen
REM unrem the following line if you want all output to console
REM set CONSOLE_LOG=-consoleLog
setlocal
set path=%path%;\s60\tools\toolsextensions\ConfigurationTool

set ECLIPSE_PARAMS=-application com.nokia.S60CT.CLI.application -noSplash %CONSOLE_LOG% --launcher.suppressErrors

REM set all the command line params to variable 
set COMMAND_LINE_PARAMS=%*

REM The final call, pass the eclipse params and all command line params
S60CLI.EXE %ECLIPSE_PARAMS% %COMMAND_LINE_PARAMS%
endlocal
exit /b %errorlevel%
