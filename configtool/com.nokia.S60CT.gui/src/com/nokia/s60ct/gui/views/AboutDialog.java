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
package com.nokia.s60ct.gui.views;

import java.net.URL;

import org.eclipse.core.runtime.IProduct;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceColors;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.internal.ProductProperties;

import com.nokia.s60ct.gui.S60CtEditorPlugin;

public class AboutDialog extends org.eclipse.ui.internal.dialogs.AboutDialog
{
    private IProduct product;
    
    private StyledText text;
    
    private static final String pluginID = "com.nokia.S60CT.gui";
    
	public AboutDialog(Shell parentShell)
	{
		super(parentShell);
		
		product = Platform.getProduct();

	}

	protected Control createDialogArea(Composite parent)
	{
		
		final Cursor hand = new Cursor(parent.getDisplay(), SWT.CURSOR_HAND);
        final Cursor busy = new Cursor(parent.getDisplay(), SWT.CURSOR_WAIT);
        setHandCursor(hand);
        setBusyCursor(busy);
        getShell().addDisposeListener(new DisposeListener() {
            public void widgetDisposed(DisposeEvent e) {
                setHandCursor(null);
                hand.dispose();
                setBusyCursor(null);
                busy.dispose();
            }
        });

        Image aboutImage = null;
       
        if (product != null)
        {
            ImageDescriptor imageDescriptor = ProductProperties.getAboutImage(product);
            if (imageDescriptor != null)
            {
				aboutImage = imageDescriptor.createImage();
			}
        }
        else //no product. maybe run from Eclipse
        {
        	try
        	{
        		URL url = S60CtEditorPlugin.class.getResource("/about.PNG"); 
	        	ImageDescriptor imageDescriptor = ImageDescriptor.createFromURL(url);
				aboutImage = imageDescriptor.createImage();
				
        	}
        	catch (Exception e)
        	{
        	}
        }
        
        Composite workArea = new Composite(parent, SWT.NONE);
        GridLayout workLayout = new GridLayout(2, false);
        workLayout.marginHeight = 0;
        workLayout.marginWidth = 0;
        workLayout.verticalSpacing = 0;
        workLayout.horizontalSpacing = 0;
        workArea.setLayout(workLayout);
        workArea.setLayoutData(new GridData(GridData.FILL_BOTH));

        // page group
        Color background = JFaceColors.getBannerBackground(parent.getDisplay());
        Color foreground = JFaceColors.getBannerForeground(parent.getDisplay());
        
        workArea.setBackground(background);
        workArea.setForeground(foreground);
        
        //image on left side of dialog
        if (aboutImage != null) {
            Label imageLabel = new Label(workArea, SWT.NONE);
            imageLabel.setBackground(background);
            imageLabel.setForeground(foreground);

            GridData data = new GridData();
            data.horizontalAlignment = GridData.FILL;
            data.verticalAlignment = GridData.BEGINNING;
            data.grabExcessHorizontalSpace = false;
            imageLabel.setLayoutData(data);
            imageLabel.setImage(aboutImage);
        }


        // text on the right
        text = new StyledText(workArea, SWT.MULTI | SWT.READ_ONLY);
        text.setCaret(null);
        text.setFont(parent.getFont());
        GridData data = new GridData();
        data.horizontalAlignment = GridData.FILL;
        data.verticalAlignment = GridData.BEGINNING;
        data.verticalIndent = 12;
        data.grabExcessHorizontalSpace = true;
        data.grabExcessVerticalSpace = true;

        text.setText(getAboutText());
        text.setLayoutData(data);
        text.setCursor(null);
        text.setBackground(background);
        text.setForeground(foreground);

        if (aboutImage != null)
        {
        	// horizontal bar
            Label bar = new Label(workArea, SWT.HORIZONTAL | SWT.SEPARATOR);
            data = new GridData();
            data.horizontalAlignment = GridData.FILL;
            bar.setLayoutData(data);
        	
        	Label bar2 = new Label(workArea, SWT.HORIZONTAL | SWT.SEPARATOR);
        	bar2.setLayoutData(data);
        }
       
        return workArea;
	}
	
	private String getAboutText()
    {
    	String toolName=(String)Platform.getBundle(pluginID).getHeaders().get("Bundle-ToolName");  
		String pluginVersion=(String)Platform.getBundle(pluginID).getHeaders().get("Bundle-ReleaseVersion");  	
		String pluginDate=(String)Platform.getBundle(pluginID).getHeaders().get("Bundle-Date");   
		String pluginRepositoryVersion=(String)Platform.getBundle(pluginID).getHeaders().get("Bundle-RepositoryVersion"); 
		String legalText ="Copyright (c) 2009 Nokia Corporation and/or its subsidiary(-ies).\n" +
				"All rights reserved.\n" +
				"This component and the accompanying materials are made available    \n" +
				"under the terms of the License \"Eclipse Public License v1.0\"\n" +
				"which accompanies this distribution, and is available at the URL \n" +
				"\"http://www.eclipse.org/legal/epl-v10.html\".";
		
		return "\n"+toolName+"\n\n"+pluginVersion+"\n"+pluginDate+" rev."+pluginRepositoryVersion+"\n\n"+legalText;
    }
	
}
