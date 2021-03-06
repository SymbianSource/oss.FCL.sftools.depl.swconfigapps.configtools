@echo OFF
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



setlocal
REM set the eclipse params
REM application to CLI 
REM noSplash screen
REM unrem the following line if you want all output to console
REM set CONSOLE_LOG=-consoleLog

set path=%path%;\s60\tools\toolsextensions\ConfigurationTool

set ECLIPSE_PARAMS=-application com.nokia.S60CT.CLI.application -noSplash %CONSOLE_LOG% --launcher.suppressErrors 
set CMD_LINE_ARGS=
:set_args_loop
if "%1"=="" goto after_set_args_loop
set CMD_LINE_ARGS=%CMD_LINE_ARGS% %1
shift
goto set_args_loop

:after_set_args_loop
S60CLI.exe %ECLIPSE_PARAMS% -build %CMD_LINE_ARGS%

endlocal
exit /b %errorlevel%