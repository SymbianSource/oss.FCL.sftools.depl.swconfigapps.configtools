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
 * Description: This file is part of com.nokia.tools.vct.appshell component.
 */

package com.nokia.tools.vct.appshell.parts.misc;

import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.Panel;
import org.eclipse.draw2d.ScrollPane;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.resource.FontRegistry;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;

import com.nokia.tools.vct.appshell.appshellmodel.EBooleanFlag;
import com.nokia.tools.vct.appshell.appshellmodel.EHideDescriptor;
import com.nokia.tools.vct.appshell.appshellmodel.EIconDescriptor;
import com.nokia.tools.vct.appshell.appshellmodel.ELockDescriptor;
import com.nokia.tools.vct.appshell.appshellmodel.ENameDescriptor;

public class TooltipFigure extends ScrollPane {

	private Label shortNameLabel;
	private Label longNameLabel;
	private Label titleNameLabel;
	private Label m3gIconFileLabel;
	private Label maskIdLabel;
	private Label iconIdLabel;
	private Label iconFileLabel;
	private Label skinMajorIdLabel;
	private Label skinMinorIdLabel;
	private Label lockDeleteLabel;
	private Label lockIconLabel;
	private Label lockNameLabel;
	private Label lockOrganizeLabel;
	private Label hideAnimatedIcon;
	private Label hideChangeSkinLabel;
	private Label hideDownloadLabel;
	private Label hideMemoryDetailsLabel;

	public TooltipFigure(String name) {
		Panel panel = new Panel();
		setContents(panel);
		GridLayout gridLayout = new GridLayout(2, false);
		// gridLayout.marginWidth = gridLayout.marginHeight = 0;
		panel.setLayoutManager(gridLayout);
		
		Label label;
		FontRegistry fr = new FontRegistry();
		Font bold = fr.getBold(JFaceResources.DEFAULT_FONT);

		label = new Label(name);
		label.setFont(bold);
		panel.add(label, new GridData(SWT.CENTER, SWT.CENTER, true, false, 2, 1));

		createGeneralSection(panel, bold);
		createCommonSection(panel, bold);
	}

	protected void createCommonSection(Panel panel, Font bold) {
		Label label;
		panel.add(new SeparatorFigure(), new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));

		label = new Label("Names");
		label.setFont(bold);
		panel.add(label, new GridData(SWT.LEFT, SWT.CENTER, true, false, 2, 1));

		label = new Label("Short Name");
		panel.add(label);
		shortNameLabel = new Label("name value");
		panel.add(shortNameLabel);
		label = new Label("Long Name");
		panel.add(label);
		longNameLabel = new Label("name value");
		panel.add(longNameLabel);
		label = new Label("Title Name");
		panel.add(label);
		titleNameLabel = new Label("name value");
		panel.add(titleNameLabel);

		
		panel.add(new SeparatorFigure(), new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));

		label = new Label("Icons");
		label.setFont(bold);
		panel.add(label, new GridData(SWT.LEFT, SWT.CENTER, true, false, 2, 1));

		label = new Label("M3G Icon File");
		panel.add(label);
		m3gIconFileLabel = new Label("icon");
		panel.add(m3gIconFileLabel);
		label = new Label("Mask ID");
		panel.add(label);
		maskIdLabel = new Label("id");
		panel.add(maskIdLabel);
		label = new Label("Icon File");
		panel.add(label);
		iconFileLabel = new Label("icon");
		panel.add(iconFileLabel);
		label = new Label("Icon ID");
		panel.add(label);
		iconIdLabel = new Label("Icon ID");
		panel.add(iconIdLabel);

		label = new Label("Skin Major ID");
		panel.add(label);
		skinMajorIdLabel = new Label("icon");
		panel.add(skinMajorIdLabel);
		label = new Label("Skin Minor ID");
		panel.add(label);
		skinMinorIdLabel = new Label("icon");
		panel.add(skinMinorIdLabel);
		
		panel.add(new SeparatorFigure(), new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		
		label = new Label("Lock Options");
		label.setFont(bold);
		panel.add(label, new GridData(SWT.LEFT, SWT.CENTER, true, false, 2, 1));

		label = new Label("Lock Delete");
		panel.add(label);
		lockDeleteLabel = new Label("true/false");
		panel.add(lockDeleteLabel);
		label = new Label("Lock Icon");
		panel.add(label);
		lockIconLabel = new Label("true/false");
		panel.add(lockIconLabel);
		label = new Label("Lock Name");
		panel.add(label);
		lockNameLabel = new Label("true/false");
		panel.add(lockNameLabel);
		label = new Label("Lock Organize");
		panel.add(label);
		lockOrganizeLabel = new Label("true/false");
		panel.add(lockOrganizeLabel);

		panel.add(new SeparatorFigure(), new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		
		label = new Label("Hide Options");
		label.setFont(bold);
		panel.add(label, new GridData(SWT.LEFT, SWT.CENTER, true, false, 2, 1));

		label = new Label("Hide Animated");
		panel.add(label);
		hideAnimatedIcon = new Label("true/false");
		panel.add(hideAnimatedIcon);
		label = new Label("Hide Change Skin");
		panel.add(label);
		hideChangeSkinLabel = new Label("true/false");
		panel.add(hideChangeSkinLabel);
		label = new Label("Hide Download");
		panel.add(label);
		hideDownloadLabel = new Label("true/false");
		panel.add(hideDownloadLabel);
		label = new Label("Hide Memory Details");
		panel.add(label);
		hideMemoryDetailsLabel = new Label("true/false");
		panel.add(hideMemoryDetailsLabel);
	}

	protected void createGeneralSection(Panel panel, Font bold) {
		Label label;
		panel.add(new SeparatorFigure(), new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));

		label = new Label("General");
		label.setFont(bold);
		panel.add(label, new GridData(SWT.LEFT, SWT.CENTER, true, false, 2, 1));
		
	}

	public void update(EObject model) {
		if (model instanceof EHideDescriptor) {
			EHideDescriptor desc = (EHideDescriptor)model;

			hideAnimatedIcon.setText(convert(desc.getHideAnimatedIcons()));
			hideChangeSkinLabel.setText(convert(desc.getHideChangeSkin()));
			hideDownloadLabel.setText(convert(desc.getHideDownload()));
			hideMemoryDetailsLabel.setText(convert(desc.getHideMemDetails()));
		} else {
			hideAnimatedIcon.setText("");
			hideChangeSkinLabel.setText("");
			hideDownloadLabel.setText("");
			hideMemoryDetailsLabel.setText("");
		}

		if (model instanceof ENameDescriptor) {
			ENameDescriptor desc = (ENameDescriptor)model;
			
			shortNameLabel.setText(desc.getShortName());
			longNameLabel.setText(desc.getLongName());
			titleNameLabel.setText(desc.getTitleName());
		} else {
			shortNameLabel.setText("");
			longNameLabel.setText("");
			titleNameLabel.setText("");
		}
		
		if (model instanceof EIconDescriptor) {
			EIconDescriptor descr = (EIconDescriptor)model;
			iconFileLabel.setText(descr.getIconFile());
			iconIdLabel.setText(descr.getIconId());
			skinMajorIdLabel.setText(descr.getIconSkinMajorId());
			skinMinorIdLabel.setText(descr.getIconSkinMinorId());
			m3gIconFileLabel.setText(descr.getM3gIconFile());
			maskIdLabel.setText(descr.getMaskId());
		} else {
			iconFileLabel.setText("");
			iconIdLabel.setText("");
			skinMajorIdLabel.setText("");
			skinMinorIdLabel.setText("");
			m3gIconFileLabel.setText("");
			maskIdLabel.setText("");
		}

		if (model instanceof ELockDescriptor) {
			ELockDescriptor descr = (ELockDescriptor)model;
			lockDeleteLabel.setText(convert(descr.getLockDelete()));
			lockIconLabel.setText(convert(descr.getLockIcon()));
			lockNameLabel.setText(convert(descr.getLockName()));
			lockOrganizeLabel.setText(convert(descr.getLockOrganize()));
		} else {
			lockDeleteLabel.setText("");
			lockIconLabel.setText("");
			lockNameLabel.setText("");
			lockOrganizeLabel.setText("");
		}

		invalidateTree();
	}
	
	protected String convert(EBooleanFlag flag) {
		switch (flag) {
		case OFF:
			return "off";
		case ON:
			return "on";
		default:
			return "";
		}
	}
}
