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
package com.nokia.s60ct.gui.preferences;

import java.io.File;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.osgi.service.prefs.BackingStoreException;

import constants.IS60CTCommonConstants;

/**
 * A field editor for an enumeration type preference.
 * The choices are presented as a list of radio buttons.
 */
public class CustomRadioGroupFieldEditor extends FieldEditor {

    /**
     * List of radio button entries of the form [label,value].
     */
    private String[][] labelsAndValues;

    /**
     * Number of columns into which to arrange the radio buttons.
     */
    private int numColumns;

    /**
     * Indent used for the first column of the radion button matrix.
     */
    private int indent = HORIZONTAL_GAP;

    /**
     * The current value, or <code>null</code> if none.
     */
    private String value;

    /**
     * The box of radio buttons, or <code>null</code> if none
     * (before creation and after disposal).
     */
    private Composite radioBox;

    /**
     * The radio buttons, or <code>null</code> if none
     * (before creation and after disposal).
     */
    private Button[] radioButtons;

    private Text[] textFields;
    
    private String environment;
    
    private boolean isValid = true;
    
    private String[] invalidCTFolders = new String[]{"configuration",
    												"genconfml",
    												"ibyml",
    												"jre",
    												"plugins",
    												"workspace"
    												};
    
    private String[] invalidEpocFolders = new String[]{"epoc32" //something else???
														};
    /**
     * Whether to use a Group control.
     */
    //private boolean useGroup;

    /**
     * Creates a new radio group field editor 
     */
    protected CustomRadioGroupFieldEditor() {
    }

    /**
     * Creates a radio group field editor.  
     * This constructor does not use a <code>Group</code> to contain the radio buttons.
     * It is equivalent to using the following constructor with <code>false</code>
     * for the <code>useGroup</code> argument.
     * <p>
     * Example usage:
     * <pre>
     *		RadioGroupFieldEditor editor= new RadioGroupFieldEditor(
     *			"GeneralPage.DoubleClick", resName, 1,
     *			new String[][] {
     *				{"Open Browser", "open"},
     *				{"Expand Tree", "expand"}
     *			},
     *          parent);	
     * </pre>
     * </p>
     * 
     * @param name the name of the preference this field editor works on
     * @param labelText the label text of the field editor
     * @param numColumns the number of columns for the radio button presentation
     * @param labelAndValues list of radio button [label, value] entries;
     *  the value is returned when the radio button is selected
     * @param parent the parent of the field editor's control
     */
    public CustomRadioGroupFieldEditor(String name, String labelText, int numColumns,
            String[][] labelAndValues, Composite parent) {
        this(name, labelText, numColumns, labelAndValues, parent, false);
    }

    /**
     * Creates a radio group field editor.
     * <p>
     * Example usage:
     * <pre>
     *		RadioGroupFieldEditor editor= new RadioGroupFieldEditor(
     *			"GeneralPage.DoubleClick", resName, 1,
     *			new String[][] {
     *				{"Open Browser", "open"},
     *				{"Expand Tree", "expand"}
     *			},
     *          parent,
     *          true);	
     * </pre>
     * </p>
     * 
     * @param name the name of the preference this field editor works on
     * @param labelText the label text of the field editor
     * @param numColumns the number of columns for the radio button presentation
     * @param labelAndValues list of radio button [label, value] entries;
     *  the value is returned when the radio button is selected
     * @param parent the parent of the field editor's control
     * @param useGroup whether to use a Group control to contain the radio buttons
     */
    public CustomRadioGroupFieldEditor(String name, String labelText, int numColumns,
            String[][] labelAndValues, Composite parent, boolean useGroup) {
        init(name, labelText);
        Assert.isTrue(checkArray(labelAndValues));
        this.labelsAndValues = labelAndValues;
        this.numColumns = numColumns;
        createControl(parent);
    }

    /* (non-Javadoc)
     * Method declared on FieldEditor.
     */
    protected void adjustForNumColumns(int numColumns) {
        Control control = getLabelControl();
        if (control != null) {
            ((GridData) control.getLayoutData()).horizontalSpan = numColumns;
        }
        ((GridData) radioBox.getLayoutData()).horizontalSpan = numColumns;
    }

    /**
     * Checks whether given <code>String[][]</code> is of "type" 
     * <code>String[][2]</code>.
     * @param table
     *
     * @return <code>true</code> if it is ok, and <code>false</code> otherwise
     */
    private boolean checkArray(String[][] table) {
        if (table == null) {
			return false;
		}
        for (int i = 0; i < table.length; i++) {
            String[] array = table[i];
            if (array == null || array.length != 2) {
				return false;
			}
        }
        return true;
    }

    /* (non-Javadoc)
     * Method declared on FieldEditor.
     */
    protected void doFillIntoGrid(Composite parent, int numColumns) {
        
        Control control = getLabelControl(parent);
        GridData gd = new GridData();
        gd.horizontalSpan = numColumns;
        control.setLayoutData(gd);
        control = getRadioBoxControl(parent);
        gd = new GridData();
        gd.horizontalSpan = numColumns;
        gd.horizontalIndent = indent;
        control.setLayoutData(gd);
    }

    /* (non-Javadoc)
     * Method declared on FieldEditor.
     */
    protected void doLoad() {
        updateValue(getPreferenceStore().getString(getPreferenceName()));
    }

    /* (non-Javadoc)
     * Method declared on FieldEditor.
     */
    protected void doLoadDefault() {
        updateValue(getPreferenceStore().getDefaultString(getPreferenceName()));
    }

    /* (non-Javadoc)
     * Method declared on FieldEditor.
     */
    protected void doStore() {
        if (value == null) {
            getPreferenceStore().setToDefault(getPreferenceName());
            return;
        }

        getPreferenceStore().setValue(getPreferenceName(), value);
        storeToGlobal();
    }

    /* (non-Javadoc)
     * Method declared on FieldEditor.
     */
    public int getNumberOfControls() {
        return 1;
    }

    /**
     * Returns this field editor's radio group control.
     * @param parent The parent to create the radioBox in
     * @return the radio group control
     */
    public Composite getRadioBoxControl(Composite parent) {
        if (radioBox == null) {

            Font font = parent.getFont();

            radioBox = new Composite(parent, SWT.NONE);
            GridLayout layout = new GridLayout(2, true);
            GridData gridData = new GridData(SWT.FILL,SWT.NONE,true,false);
            layout.marginWidth = 0;
            layout.marginHeight = 0;
            layout.horizontalSpacing = HORIZONTAL_GAP;
            layout.numColumns = numColumns;
            radioBox.setLayout(layout);
            radioBox.setFont(font);
            
            radioButtons = new Button[labelsAndValues.length];
            textFields = new Text[labelsAndValues.length];
            for (int i = 0; i < labelsAndValues.length; i++) {
                Button radio = new Button(radioBox, SWT.RADIO | SWT.LEFT);
                radioButtons[i] = radio;
                final String[] labelAndValue = labelsAndValues[i];
                radio.setText(labelAndValue[0]);
                radio.setData(labelAndValue[1]);
                if (labelAndValue[1].equals(IS60CTCommonConstants.CTFOLDER))
                	radio.setToolTipText(System.getProperty("user.dir"));
                
                radio.setFont(font);
                radio.addSelectionListener(new SelectionAdapter() {
                    public void widgetSelected(SelectionEvent event) {
                        for (int t = 0 ; t < textFields.length ; t++)
                        {
                        	if (event.widget.equals(radioButtons[t]))
                        	{
                        		textFields[t].setEnabled(true);
                        		setValue(t);
                        	}
                        	else
                        		textFields[t].setEnabled(false);
                        }
                    }
                });
                
                Text textField = new Text(radioBox, SWT.BORDER);
                textField.setLayoutData(gridData);
                textFields[i] = textField;
                if (labelAndValue[1].equals("IBYML"))
                {
                	textField.setVisible(false);
                }
                else
                {
                	textField.setEnabled(false);
                	
                }
                textField.addKeyListener(new KeyListener(){

					@Override
					public void keyPressed(KeyEvent e) {
						
					}
					@Override
					public void keyReleased(KeyEvent e) {
						for (int t = 0 ; t < textFields.length ; t++)
                        {
                        	if (e.widget.equals(textFields[t]))
                        	{
                        		setValue(t);
                        	}
                        }
					}
                });
            }
            radioBox.addDisposeListener(new DisposeListener() {
                public void widgetDisposed(DisposeEvent event) {
                    radioBox = null;
                    radioButtons = null;
                }
            });
        } else {
            checkParent(radioBox, parent);
        }
        return radioBox;
    }

    private void setValue(int index)
    {
    	String oldValue = value;
    	value = radioButtons[index].getData()+"\\"+textFields[index].getText();
    	
    	if (radioButtons[index].getData().equals(IS60CTCommonConstants.EPOCROOT))
    		checkIsEpocFolderValid(textFields[index].getText());	
    	
    	if (radioButtons[index].getData().equals(IS60CTCommonConstants.CTFOLDER))
        	checkIsCTFolderValid(textFields[index].getText());	
    	
    	if (isValid() || radioButtons[index].getData().equals(IS60CTCommonConstants.IBYML))
    		clearErrorMessage();
    	
        setPresentsDefaultValue(false);
        fireValueChanged(VALUE, oldValue, value);
        
    }
    
    private void storeToGlobal()
    {
    	IEclipsePreferences ePref= new ConfigurationScope().getNode(IS60CTCommonConstants.S60_PREFERENCES);
    	String folder = value.substring(value.indexOf(File.separator)+1);
		String[] foldersArray = null;
    	
		if (value.startsWith(IS60CTCommonConstants.IBYML))
		{
			foldersArray =  new String[]{""}; //empty user folder means that IBY output folder(s) should be used
		}
		else if (value.startsWith(IS60CTCommonConstants.CTFOLDER))
		{
			String userDir = System.getProperty("user.dir");
			foldersArray =  new String[]{userDir+File.separator+folder};
		}
		else if (value.startsWith(IS60CTCommonConstants.EPOCROOT))
		{
			String epocRoot = environment;
			foldersArray =  new String[]{epocRoot+folder};
		}	
		
		StringBuffer folders = new StringBuffer();
		for (int i = 0 ; i < foldersArray.length ; i++)
		{
			folders.append(foldersArray[i]);
			if (i < foldersArray.length-1)
				folders.append(";");
		}
		
		ePref.put(IS60CTCommonConstants.USER_OUTPUT_FOLDER, folders.toString());
		ePref.put(IS60CTCommonConstants.USED_ENVIRONMENT, environment);

		try 
		{
			ePref.flush();
		} 
		catch (BackingStoreException e)
		{
			e.printStackTrace();
		}
    }
    

    @Override
	public boolean isValid() {
		return isValid;
	}

    
    private void checkIsEpocFolderValid(String folder)
    {
    	boolean newValid = true;
    	boolean oldValid = isValid;
    	if (folder.equals(""))
    	{
    		newValid =  false;
			showErrorMessage("Generating to root of "+environment+" is not allowed.");
    	}
    	else
	    	for (int i = 0 ; i < invalidEpocFolders.length ; i++)
	    	{
	    		if (folder.equalsIgnoreCase(invalidEpocFolders[i]))
	    		{
	    			newValid =  false;
	    			showErrorMessage("Generating to "+environment+folder+" is not allowed.");
	    			break;
	    		}
	    	}
		isValid = newValid;
		fireStateChanged(IS_VALID, oldValid, newValid);
    }
	private void checkIsCTFolderValid(String folder)
    {
    	boolean newValid = true;
    	boolean oldValid = isValid;
    	if (folder.equals(""))
    	{
    		newValid =  false;
			showErrorMessage("Generating to Configuration Tool's main folder is not allowed.");
    	}
    	else
			for (int i = 0 ; i < invalidCTFolders.length ; i++)
	    	{
	    		if (folder.equalsIgnoreCase(invalidCTFolders[i]))
	    		{
	    			showErrorMessage("Generating to \""+folder+"\" folder is not allowed.");
	    			newValid =  false;
	    			break;
	    		}
	    	}
		isValid = newValid;
		fireStateChanged(IS_VALID, oldValid, newValid);
    }
    
    /**
     * Sets the indent used for the first column of the radion button matrix.
     *
     * @param indent the indent (in pixels)
     */
    public void setIndent(int indent) {
        if (indent < 0) {
			this.indent = 0;
		} else {
			this.indent = indent;
		}
    }

    /**
     * Select the radio button that conforms to the given value.
     *
     * @param selectedValue the selected value
     */
    private void updateValue(String selectedValue) {
        this.value = selectedValue;
        if (radioButtons == null) {
			return;
		}

        if (this.value != null) {
            boolean found = false;
            for (int i = 0; i < radioButtons.length; i++) {
                Button radio = radioButtons[i];
                boolean selection = false;
                if (selectedValue.startsWith((String) radio.getData())) {
                    selection = true;
                    found = true;
                    String trimmedValue = selectedValue.substring(selectedValue.indexOf("\\")+1);
                    textFields[i].setText(trimmedValue);
                    textFields[i].setEnabled(true);
                }
                radio.setSelection(selection);
            }
            if (found) {
				return;
			}
        }

        // We weren't able to find the value. So we select the first
        // radio button as a default.
        if (radioButtons.length > 0) {
            radioButtons[0].setSelection(true);
            this.value = (String) radioButtons[0].getData();
        }
        return;
    }

    /*
     * @see FieldEditor.setEnabled(boolean,Composite).
     */
    public void setEnabled(boolean enabled, Composite parent) {
       
        for (int i = 0; i < radioButtons.length; i++) {
            radioButtons[i].setEnabled(enabled);
            textFields[i].setEnabled(enabled);
        }

    }
    
    public void setEnvironment(String env)
    {
    	this.environment = env;
    	if (env!=null && !env.equals("") && !env.equals(PreferenceConstants.NO_ENV_FOUND))
    	{
    		radioButtons[1].setText("Environment "+env);
    		radioButtons[1].setEnabled(true);
    	}
    	else
    	{
    		radioButtons[1].setText("Environment");
    		radioButtons[1].setEnabled(false);
    	}
    }
}
