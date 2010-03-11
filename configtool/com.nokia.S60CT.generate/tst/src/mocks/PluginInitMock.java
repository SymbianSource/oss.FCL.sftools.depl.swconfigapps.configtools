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

package mocks;

import com.nokia.s60ct.generate.PluginInit;
import com.nokia.s60ct.interfaces.IContentCreator;
import com.nokia.s60ct.interfaces.ISaveContent;

public class PluginInitMock extends PluginInit {
	
	ContentCreatorMock plugin=null;
	
	public PluginInitMock(){
	}
	
	@Override
	public void init(int mode) {
		
	}

	@Override
	public IContentCreator[] getAllPlugins() {
		return new IContentCreator[]{plugin};
	}

	@Override
	public ISaveContent[] getSaveContentPlugins(IContentCreator contentCreator,String pluginid) {
		return new ISaveContent[]{plugin};
	}
	
	public void addMockPlugin(ContentCreatorMock plugin){
		this.plugin=plugin;
	}

	@Override
	public IContentCreator[] getContentCreators() {
		return new IContentCreator[]{plugin};
	}

	@Override
	public String findPluginID(IContentCreator contentCreator) {
		return "id";
	}
	
}
