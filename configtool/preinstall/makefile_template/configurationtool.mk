#
# Copyright (c) 2008 Nokia Corporation and/or its subsidiary(-ies).
# All rights reserved.
# This component and the accompanying materials are made available
# under the terms of "Eclipse Public License v1.0"
# which accompanies this distribution, and is available
# at the URL "http://www.eclipse.org/legal/epl-v10.html".
#
# Initial Contributors:
# Nokia Corporation - initial contribution.
#
# Contributors:
#
# Description:
#

# To ensure that EPOCROOT always ends with a forward slash
TMPROOT:=$(subst \,/,$(EPOCROOT))
EPOCROOT:=$(patsubst %/,%,$(TMPROOT))/

include $(EPOCROOT)epoc32/tools/shell/$(notdir $(basename $(SHELL))).mk

ifndef CONFML
$(error Variable CONFML not defined!)
endif

ifndef CRML
$(error Variable CRML not defined!)
endif

ifndef OUTPUT
$(error Variable OUTPUT not defined!)
endif

CONFM_FILES   = $(wildcard $(CONFML)/*.confml)
CRML_FILES    = $(wildcard $(CRML)/*.crml)
CONF_TOOL     := cli_build.cmd
CONF_TOOL_OPT := -no_iby
CONF_TOOL_CMD := $(CONF_TOOL) -confml "$(CONFML)" -impl "$(CRML)" -cenrep "$(OUTPUT)" $(CONF_TOOL_OPT) -master_conf master.confml

BLD         : DO_NOTHING
SAVESPACE   : DO_NOTHING
RELEASABLES : DO_NOTHING		
MAKMAKE     : DO_NOTHING
FREEZE      : DO_NOTHING
LIB         : DO_NOTHING
CLEANLIB    : DO_NOTHING
# configuration tool will be invoked here
RESOURCE    : generate.$(PLATFORM_PATH).$(CFG_PATH)
FINAL       : DO_NOTHING
CLEAN       :
	$(ERASE) generate.$(PLATFORM_PATH).$(CFG_PATH)

DO_NOTHING :
	@echo do nothing

# generate configuration with configuration tool
# create a dummy generate.platform text file to represent the output files
generate.$(PLATFORM_PATH).$(CFG_PATH): $(CONFM_FILES) $(CRML_FILES)
	@echo running configurationtool $(CONF_TOOL_CMD)
	$(CONF_TOOL_CMD)
	@echo // configurationtool generate command $(CONF_TOOL_CMD) > generate.$(PLATFORM_PATH).$(CFG_PATH)

