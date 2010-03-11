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

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Vector;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;

import com.nokia.s60ct.generate.GenerationReport;
import com.nokia.s60ct.gui.S60CtEditorPlugin;

public class ReportDialog
{	
	private Shell shell = null;
	
	private final int  width = 800;
	private final int  height = 600;
	
	private final URL NO_ERRORS = (URL)S60CtEditorPlugin.INSTANCE.getImage("ok_small");
	private final URL ERRORS = (URL)S60CtEditorPlugin.INSTANCE.getImage("error_small");

	private final String LINE_SEPARATOR = System.getProperty("line.separator");
	
	private Clipboard cb;
	
	private final String CENREP_TAB_NAME = "CenReps";
	private final String GENCONFML_TAB_NAME = "GenConfMLs";
	private final String IBY_TAB_NAME = "IBYs";
	
	private int totalNumberOfErrors = 0;
	private int totalNumberOfGenerated = 0;
	
	private final String SEPARATOR = File.separator;
	
	public ReportDialog(Display d, Vector reports)
	{
		shell = new Shell(d, SWT.APPLICATION_MODAL | SWT.DIALOG_TRIM);
		shell.setParent(d.getActiveShell());
		Point parentLocation = d.getActiveShell().getLocation();
		Point parentSize = d.getActiveShell().getSize();
		Point parentCenter = new Point(parentLocation.x+(parentSize.x/2), parentLocation.y+(parentSize.y/2));
		Point location = new Point(parentCenter.x-(width/2), parentCenter.y-(height/2));
		shell.setLocation(location);
		shell.setLayout(new GridLayout(1,false));
		shell.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true));
		
		cb = new Clipboard(d);

		buildDialog(reports);
		
		shell.setSize(width, height);
		shell.open();
		while (!shell.isDisposed()) 
		{
			 if (!d.readAndDispatch()) d.sleep();
		}
	}
	
	
	private void buildDialog(Vector reports)
	{
		shell.setText("Generation Report");
		
		GridLayout summaryLayout = new GridLayout(2,true);
		Composite summaryComposite = new Composite(shell, SWT.RIGHT);
		summaryComposite.setLayout(summaryLayout);
		
		Label summaryLabel = new Label(summaryComposite,SWT.BOLD);
		summaryLabel.setText("Summary: XXX files generated, YYY errors");
		
		String fontName = summaryLabel.getFont().getFontData()[0].getName();
		
		Font boldFont = new Font(shell.getDisplay(), fontName, 10, SWT.BOLD);
		
		summaryLabel.setFont(boldFont);
		
		TabFolder tabs = new TabFolder(shell, SWT.TOP);
		tabs.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true));
		
		createTab(tabs, CENREP_TAB_NAME, reports);
		createTab(tabs, GENCONFML_TAB_NAME, reports);
		createTab(tabs, IBY_TAB_NAME, reports);

		GridLayout buttonLayout = new GridLayout(1,true);
		Composite buttonComposite = new Composite(shell, SWT.NONE);
		buttonComposite.setLayout(buttonLayout);
		buttonComposite.setLayoutData(new GridData(SWT.TRAIL,SWT.CENTER,true,false));
		
		GridData buttonGridData = new GridData(SWT.FILL,SWT.NONE,true,false);
		
		Button closeButton = new Button(buttonComposite,SWT.PUSH);
		closeButton.setText("    Close    "); //button can be wider than just the width of "close"

		closeButton.setLayoutData(buttonGridData);
		shell.setDefaultButton(closeButton);
		
		closeButton.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e) {
				shell.close();
				shell.dispose();
			}
		});
		
		summaryLabel.setText("Summary: "+totalNumberOfGenerated+" files generated, "+totalNumberOfErrors+" errors");	
	}
	
	
	private void createTab(TabFolder parent, String tabName, Vector vReports)
	{
		Object[] reports = vReports.toArray();
		Vector vErrors = new Vector(10);
		Vector vFiles = new Vector(10);
	
		int type = 0;
		
		if (tabName.equals(CENREP_TAB_NAME))
			type = GenerationReport.TYPE_CENREP;
		else if (tabName.equals(GENCONFML_TAB_NAME))
			type = GenerationReport.TYPE_GENCONFML;
		else if (tabName.equals(IBY_TAB_NAME))
			type = GenerationReport.TYPE_IBY;
		
		for (int i = 0 ; i < reports.length ; i++)
		{
			GenerationReport report = (GenerationReport)reports[i];
			if (report == null) 
				continue;
			GenerationReport.Error[] errors = report.getErrors(type);
			GenerationReport.GeneratedFile[] files = report.getGeneratedFiles(type);
			
			if (errors!= null)
				for (int j = 0 ; j < errors.length ; j++)
					vErrors.add(errors[j]);
			
			if (files != null)
				for (int j = 0 ; j < files.length ; j++)
					vFiles.add(files[j]);

		}
		
		int numberOfErrors = vErrors.size();
		totalNumberOfErrors +=numberOfErrors;
		int numberOfGeneratedFiles = vFiles.size();
		totalNumberOfGenerated += numberOfGeneratedFiles;
		
		TabItem tab = new TabItem (parent, SWT.NONE);
		tab.setText(tabName+" "+numberOfGeneratedFiles);
		
		GridLayout tabLayout = new GridLayout(1,true);
		GridData tabLayoutData = new GridData(SWT.FILL,SWT.NONE,true,false);
		GridData browserLayoutData = new GridData(SWT.FILL,SWT.FILL,true,true);
		
		Composite tabComposite = new Composite(parent, SWT.FILL);
		tabComposite.setLayout(tabLayout);
		tabComposite.setLayoutData(tabLayoutData);
		tab.setControl(tabComposite);
		
		GridLayout groupLayout = new GridLayout(2,false);
		Composite groupComposite = new Composite(tabComposite, SWT.CENTER);
		groupLayout.marginTop = 0;
		groupLayout.marginBottom = -10;
		groupLayout.marginLeft = -5;
		groupLayout.marginRight = -5;
		groupComposite.setLayout(groupLayout);
		groupComposite.setLayoutData(new GridData(SWT.FILL,SWT.CENTER,true,false));
		
		GridLayout labelLayout = new GridLayout(1,false);
		labelLayout.marginTop = 0;
		labelLayout.marginBottom = 0;
		labelLayout.marginLeft = -5;
		labelLayout.marginRight = 0;
		
		Composite labelComposite = new Composite(groupComposite, SWT.FILL);
		labelComposite.setLayout(labelLayout);
		labelComposite.setLayoutData(new GridData(SWT.LEFT,SWT.BOTTOM,true,false));
		
		GridLayout buttonLayout = new GridLayout(1,false);
		buttonLayout.marginTop = 0;
		buttonLayout.marginBottom = 0;
		buttonLayout.marginLeft = 0;
		buttonLayout.marginRight = 12;
		
		Composite buttonComposite = new Composite(groupComposite, SWT.FILL);
		buttonComposite.setLayout(buttonLayout);
		buttonComposite.setLayoutData(new GridData(SWT.RIGHT,SWT.CENTER,true,false));
		
		Label generatedLabel = new Label(labelComposite,SWT.NONE);
		generatedLabel.setText("Generated "+tabName+" ("+numberOfGeneratedFiles+"):");
		generatedLabel.setLayoutData(new GridData(SWT.LEFT,SWT.CENTER,false,false));
		
		final Object[] paths = getPaths(vFiles);
		
		Button openFolderButton = new Button(buttonComposite,SWT.PUSH);
		openFolderButton.setText("Open Folders...");
		openFolderButton.setLayoutData(new GridData(SWT.RIGHT,SWT.CENTER,false,false));
		openFolderButton.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e) {
				openFolders(paths);
			}
		});
		if (paths.length == 0)
			openFolderButton.setEnabled(false);
		
		Browser generatedBrowser = new Browser(tabComposite, SWT.NONE);
		generatedBrowser.setLayoutData(browserLayoutData);
		
		generatedBrowser.setText(getGenDataHTML(vFiles));
		
		if (numberOfErrors == 0)
			tab.setImage(ImageDescriptor.createFromURL(NO_ERRORS).createImage());
		else
		{
			tab.setImage(ImageDescriptor.createFromURL(ERRORS).createImage());
			
			Label empty = new Label(tabComposite,SWT.SEPARATOR | SWT.HORIZONTAL);
			empty.setLayoutData(tabLayoutData);
			empty.setText("");
			
			Composite groupComposite2 = new Composite(tabComposite, SWT.CENTER);
			groupComposite2.setLayout(groupLayout);
			groupComposite2.setLayoutData(new GridData(SWT.FILL,SWT.CENTER,true,false));
			
			Composite labelComposite2 = new Composite(groupComposite2, SWT.FILL);
			labelComposite2.setLayout(labelLayout);
			labelComposite2.setLayoutData(new GridData(SWT.LEFT,SWT.BOTTOM,true,false));
			
			Composite buttonComposite2 = new Composite(groupComposite2, SWT.FILL);
			buttonComposite2.setLayout(buttonLayout);
			buttonComposite2.setLayoutData(new GridData(SWT.RIGHT,SWT.CENTER,true,false));
			
			Label errorsLabel = new Label(labelComposite2,SWT.NONE);
			errorsLabel.setText("Errors ("+numberOfErrors+"):");
			
			final String errorText = getErrorText(vErrors);
			
			Button copyButton = new Button(buttonComposite2,SWT.PUSH);
			copyButton.setText("Copy To Clipboard");
			copyButton.setLayoutData(new GridData(SWT.RIGHT,SWT.CENTER,false,false));
			copyButton.addSelectionListener(new SelectionAdapter(){
				public void widgetSelected(SelectionEvent e) {
			        TextTransfer textTransfer = TextTransfer.getInstance();
			        cb.setContents(new Object[] { errorText },new Transfer[]{textTransfer});
				}
			});
			
			Browser errorsBrowser = new Browser(tabComposite, SWT.NONE);
			errorsBrowser.setLayoutData(browserLayoutData);
			
			errorsBrowser.setText(getErrorTextHTML(errorText));
		}
	}
	
	private String getGenDataHTML(Vector genFiles)
	{
		StringBuffer html = new StringBuffer();
		
		html.append("<html>");
		html.append("<body bgcolor=\"#ffffff\" text=\"#000000\">");
		html.append("<font face=\"Arial, Helvetica, sans-serif\" size=\"2\">");
		for (int i = 0 ; i < genFiles.size() ; i++)
		{
			GenerationReport.GeneratedFile file = (GenerationReport.GeneratedFile)genFiles.elementAt(i);
			html.append(file.getRelativePath()+SEPARATOR+file.getFileName());
			html.append("<BR>");
		}
		html.append("</font>");
		html.append("</body>");
		html.append("</html>");
		
		return html.toString();
	}
	
	private String getErrorTextHTML(String errors)
	{
		StringBuffer html = new StringBuffer();
		
		html.append("<html>");
		html.append("<body bgcolor=\"#ffffff\" text=\"#ff0000\">");
		//html.append("<font face=\"Arial, Helvetica, sans-serif\" size=\"4\">");
		html.append("<PRE>");
		html.append(errors);
		html.append("</PRE>");
		//html.append("</font>");
		html.append("</body>");
		html.append("</html>");
		
		return html.toString();
	}
	
	private String getErrorText(Vector errors)
	{
		StringBuffer errorText = new StringBuffer();
		
		for (int i = 0 ; i < errors.size() ; i++)
		{
			GenerationReport.Error error = (GenerationReport.Error)errors.elementAt(i);
			errorText.append(error.getErrorTitle());
			errorText.append(LINE_SEPARATOR);
		}
		return errorText.toString();
	}

	private Object[] getPaths(Vector vFiles)
	{
		Vector paths = new Vector(10);
		
		for (int i = 0 ; i < vFiles.size(); i++)
		{
			GenerationReport.GeneratedFile file = (GenerationReport.GeneratedFile)vFiles.elementAt(i);
			String fullPath = file.getRelativePath();

			boolean exists = false;
			
			for (int j = 0 ; j < paths.size() ; j++)
			{
				if (fullPath.equalsIgnoreCase((String)paths.elementAt(j)))
						exists = true;
			}
			if (!exists)
				paths.add(fullPath);
			
		}
		return paths.toArray();
	}
	
	private  void openFolders(Object[] paths)
	{
		
		String osName = System.getProperties().getProperty("os.name");
		
		try
		{
			if (osName.startsWith("Windows"))
			{
				for (int i = 0 ; i < paths.length ; i++)
				{
					String path = (String)paths[i];
					java.lang.Runtime.getRuntime().exec("Explorer "+path); //only for windows
				}
			}
			else
			{
				//some other OS
			}
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}	
	}
	
}
