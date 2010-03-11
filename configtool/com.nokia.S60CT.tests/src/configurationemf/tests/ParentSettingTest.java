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
package configurationemf.tests;

import java.io.File;
import java.util.List;

import junit.framework.Assert;
import junit.textui.TestRunner;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import configurationemf.Configuration;
import configurationemf.ConfigurationemfFactory;
import configurationemf.EXTENSION_POLICY;
import configurationemf.Feature;
import configurationemf.Frame;
import configurationemf.LeafSetting;
import configurationemf.LeafSettingDelegator;
import configurationemf.ParentSetting;
import configurationemf.Ref;
import configurationemf.RootConf;
import configurationemf.util.ConfigurationemfResourceFactoryImpl;
import configurationemf.util.ConfigurationemfResourceImpl;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Parent Setting</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link configurationemf.ParentSetting#getCurrentExtensionPolicy() <em>Current Extension Policy</em>}</li>
 * </ul>
 * </p>
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link configurationemf.ParentSetting#addFrame() <em>Add Frame</em>}</li>
 *   <li>{@link configurationemf.ParentSetting#canAddFrame() <em>Can Add Frame</em>}</li>
 *   <li>{@link configurationemf.ParentSetting#removeFrame(configurationemf.Frame) <em>Remove Frame</em>}</li>
 *   <li>{@link configurationemf.ParentSetting#canRemoveFrame(configurationemf.Frame) <em>Can Remove Frame</em>}</li>
 *   <li>{@link configurationemf.ParentSetting#canSetExtPolicy(configurationemf.EXTENSION_POLICY) <em>Can Set Ext Policy</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class ParentSettingTest extends SettingTest {

	ResourceSet resourceSet=null;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ParentSettingTest.class);
	}

	/**
	 * Constructs a new Parent Setting test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParentSettingTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Parent Setting test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected ParentSetting getFixture() {
		return (ParentSetting)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated NOT
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ConfigurationemfFactory.eINSTANCE.createParentSetting());
		resourceSet = new ResourceSetImpl();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("confml", new ConfigurationemfResourceFactoryImpl());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated NOT
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
		resourceSet=null;
	}

	public void testIsEmptySequence() {
		ParentSetting pSetting = readBasedOnSequenceSetting("inputFiles\\sequenceSettings\\isEmptySequenceTrue.confml");
		List<Frame> frames = pSetting.getFrames();
		assertTrue(frames.isEmpty());
	
		pSetting = readBasedOnSequenceSetting("inputFiles\\sequenceSettings\\isEmptySequenceFalse.confml");
		frames = pSetting.getFrames();
		String[][] expectedResult = new String[][]{
				new String[]{"John","Smith","1"},
				new String[]{"Adam","Brown","2"}
		};
		checkFrames(frames,expectedResult);
	}

	private void checkTemplate(String[] expectedValues, Frame template){
		if(template.getLeafSettings().size()==expectedValues.length){
			for (int i = 0; i < expectedValues.length; i++) {
				String expectedValue = expectedValues[i];
				LeafSettingDelegator delegator = template.getLeafSettings().get(i);
				assertEquals("Values are not equal: ",expectedValue, delegator.getValue());
			}
		}else 
			fail("Template has "+template.getLeafSettings().size()+", expected "+expectedValues.length);
	}
	
	public void testTemplateSettingNull(){
		ParentSetting pSetting = readSequenceSetting("inputFiles\\sequenceSettings\\templateSettingNull.confml");
		Frame template = pSetting.getTemplate();
		String[] expectedValue = new String[]{"X","Y",null};
		checkTemplate(expectedValue,template);
		
		pSetting.addFrame();
		List<Frame> frames = pSetting.getFrames();
		String[][] expectedResult = new String[][]{
				new String[]{"X","Y",null}
		};
		checkFrames(frames, expectedResult);
		
		LeafSettingDelegator delegator = template.getLeafSettings().get(2);
		delegator.setValue("d");
		expectedValue = new String[]{"X","Y","d"};
		checkTemplate(expectedValue,template);
		
		int sizeB4 = pSetting.getLeafSetting().size();
		LeafSetting leafSetting = ConfigurationemfFactory.eINSTANCE.createLeafSetting();
		template.addLeafSetting(leafSetting);
		assertEquals(sizeB4+1,pSetting.getLeafSetting().size());
		
	}
	
	public void testGetGValue() {
		{
			ParentSetting pSetting = readSequenceSetting("inputFiles\\sequenceSettings\\phonebook.confml");
			Object[][] expectedResult = new Object[][]{
					new Object[]{"FirstName","John","Adam"},
					new Object[]{"LastName","Smith","Brown"},
					new Object[]{"Mobile","1","2"}
			};
			checkGValue(expectedResult,pSetting.getGValue());
		}
		{
			ParentSetting pSetting = readSequenceSetting("inputFiles\\sequenceSettings\\templateSettingNull.confml");
			Object[][] expectedResult = new Object[][]{
					new Object[]{"FirstName"},
					new Object[]{"LastName"},
					new Object[]{"Mobile"}
			};
			checkGValue(expectedResult,pSetting.getGValue());
		}
	}
	
	private void checkGValue(Object aValue, Object eValue){
		if(aValue instanceof Object[][] && eValue instanceof Object[][]){
			Object[][] aObjects = (Object[][])aValue;
			Object[][] eObjects = (Object[][])eValue;
			assertEquals("Different array size",aObjects.length, eObjects.length);
			for(int i=0;i<aObjects.length;i++){
				assertEquals(aObjects[i].length, eObjects[i].length);
				assertEquals(aObjects[0].length, eObjects[i].length);
				for(int j=0;j<aObjects[i].length;j++){
					assertEquals(aObjects[i][j], eObjects[i][j]);
				}
			}
			
		}else if(aValue instanceof String && eValue instanceof String){
			
		}else 
			fail("Different types of expected and actual values.");
	}
	/**
	 * Tests the '{@link configurationemf.ParentSetting#getCurrentExtensionPolicy() <em>Current Extension Policy</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.ParentSetting#getCurrentExtensionPolicy()
	 * @generated NOT
	 */
	public void testGetCurrentExtensionPolicy() {
		
	}

	/**
	 * Tests the '{@link configurationemf.ParentSetting#setCurrentExtensionPolicy(configurationemf.EXTENSION_POLICY) <em>Current Extension Policy</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.ParentSetting#setCurrentExtensionPolicy(configurationemf.EXTENSION_POLICY)
	 * @generated NOT
	 */
	public void testSetCurrentExtensionPolicy() {
		ParentSetting pSetting = readBasedOnSequenceSetting("inputFiles\\sequenceSettings\\myReplace.confml");
		pSetting.setCurrentExtensionPolicy(EXTENSION_POLICY.APPEND);
		assertEquals(EXTENSION_POLICY.APPEND, pSetting.getCurrentExtensionPolicy());
		List<Frame> frames = pSetting.getFrames();
		String[][] expectedResult = new String[][]{
				new String[]{"John","Smith","1"},
				new String[]{"Adam","Brown","2"},
				new String[]{"The","Godfather","3"},
				new String[]{"Mickey","Mouse","4"},
		};
		checkFrames(frames,expectedResult);
		
		pSetting.setCurrentExtensionPolicy(EXTENSION_POLICY.PREFIX);
		assertEquals(EXTENSION_POLICY.PREFIX, pSetting.getCurrentExtensionPolicy());
		frames = pSetting.getFrames();
		expectedResult = new String[][]{
				new String[]{"The","Godfather","3"},
				new String[]{"Mickey","Mouse","4"},
				new String[]{"John","Smith","1"},
				new String[]{"Adam","Brown","2"}
		};
		checkFrames(frames,expectedResult);
		
		pSetting.setCurrentExtensionPolicy(EXTENSION_POLICY.REPLACE);
		assertEquals(EXTENSION_POLICY.REPLACE, pSetting.getCurrentExtensionPolicy());
		frames = pSetting.getFrames();
		expectedResult = new String[][]{
				new String[]{"The","Godfather","3"},
				new String[]{"Mickey","Mouse","4"},
		};
		checkFrames(frames,expectedResult);
	}

	public void testLongHirarchy(){
		
		int level = 1;
		
		for(int i=0;i<level;i++){
			
		}
		
	}
	
	/**
	 * Tests the '{@link configurationemf.ParentSetting#addFrame() <em>Add Frame</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.ParentSetting#addFrame()
	 * @generated NOT
	 */
	public void testAddFrame() {
		ParentSetting pSetting = readSequenceSetting("inputFiles\\sequenceSettings\\phonebook.confml");
		int initialSize= pSetting.getFrames().size();
		Configuration conf = (Configuration)((Feature)pSetting.eContainer()).eContainer();
		Ref featureRef = conf.getData().getRef().get(0);
		int initialRefSize = featureRef.getRef().size();
		
		pSetting.addFrame();
		assertEquals(initialSize+1, pSetting.getFrames().size());
		assertEquals(initialRefSize+1, featureRef.getRef().size());
		Frame newFrame = pSetting.getFrames().get(initialSize);
		Frame templateFrame = pSetting.getTemplate();
		for(LeafSettingDelegator newDelegator : newFrame.getLeafSettings()){
			for(LeafSettingDelegator templateDelegator : templateFrame.getLeafSettings())
				if(newDelegator.getRef().getName().compareTo(templateDelegator.getRef().getName())==0)
					assertEquals(newDelegator.getValue(), templateDelegator.getValue());
		}
	}

	/**
	 * Tests the '{@link configurationemf.ParentSetting#canAddFrame() <em>Can Add Frame</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.ParentSetting#canAddFrame()
	 * @generated NOT
	 */
	public void testCanAddFrame() {
		ParentSetting pSetting = readSequenceSetting("inputFiles\\sequenceSettings\\canNotAddFrame1.confml");
		assertFalse("Allows add to full sequence!",pSetting.canAddFrame());
		
		pSetting = readSequenceSetting("inputFiles\\sequenceSettings\\canNotAddFrame2.confml");
		assertFalse("Allows add when no leaf settings!",pSetting.canAddFrame());
		
		pSetting = readSequenceSetting("inputFiles\\sequenceSettings\\phonebook.confml");
		assertTrue("Forbids add when ok!",pSetting.canAddFrame());
		
		pSetting = readBasedOnSequenceSetting("inputFiles\\sequenceSettings\\canNotAddFrame3.confml");
		assertFalse("Allows add when current+basedOn=full!",pSetting.canAddFrame());
	}

	/**
	 * Tests the '{@link configurationemf.ParentSetting#removeFrame(configurationemf.Frame) <em>Remove Frame</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.ParentSetting#removeFrame(configurationemf.Frame)
	 * @generated NOT
	 */
	public void testRemoveFrame__Frame() {
		{
			ParentSetting pSetting = readSequenceSetting("inputFiles\\sequenceSettings\\phonebook.confml");
			List<Frame> frames = pSetting.getFrames();
			pSetting.removeFrame(frames.get(0));
			frames=pSetting.getFrames();
			String[][] expectedResult = new String[][]{
					new String[]{"Adam","Brown","2"}
			};
			checkFrames(frames,expectedResult);
		}
		{
			ParentSetting pSetting = readBasedOnSequenceSetting("inputFiles\\sequenceSettings\\myAppend.confml");
			List<Frame> frames = pSetting.getFrames();
			pSetting.removeFrame(frames.get(2));
			
			assertEquals(EXTENSION_POLICY.APPEND, pSetting.getCurrentExtensionPolicy());
			frames = pSetting.getFrames();
			String[][] expectedResult = new String[][]{
					new String[]{"John","Smith","1"},
					new String[]{"Adam","Brown","2"},
					new String[]{"Mickey","Mouse","4"}
			};
			
			checkFrames(frames,expectedResult);
		}
		{
			ParentSetting pSetting = readBasedOnSequenceSetting("inputFiles\\sequenceSettings\\myReplace.confml");
			assertEquals(EXTENSION_POLICY.REPLACE, pSetting.getCurrentExtensionPolicy());
			List<Frame> frames = pSetting.getFrames();
			String[][] expectedResult = new String[][]{
					new String[]{"The","Godfather","3"},
					new String[]{"Mickey","Mouse","4"},
			};
			checkFrames(frames,expectedResult);
			pSetting.removeFrame(frames.get(0));
			assertEquals(EXTENSION_POLICY.REPLACE, pSetting.getCurrentExtensionPolicy());
			frames = pSetting.getFrames();
			expectedResult = new String[][]{
					new String[]{"Mickey","Mouse","4"}
			};
			checkFrames(frames,expectedResult);
		}
	}

	/**
	 * Tests the '{@link configurationemf.ParentSetting#canRemoveFrame(configurationemf.Frame) <em>Can Remove Frame</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.ParentSetting#canRemoveFrame(configurationemf.Frame)
	 * @generated NOT
	 */
	public void testCanRemoveFrame__Frame() {
		ParentSetting pSetting = readSequenceSetting("inputFiles\\sequenceSettings\\phonebook.confml");
		List<Frame> frames = pSetting.getFrames();
		assertTrue(pSetting.canRemoveFrame(frames.get(0)));
		
		pSetting = readBasedOnSequenceSetting("inputFiles\\sequenceSettings\\myAppend.confml");
		frames = pSetting.getFrames();
		assertFalse(pSetting.canRemoveFrame(frames.get(0)));
		
		pSetting = readSequenceSetting("inputFiles\\sequenceSettings\\canNotRemoveFrame.confml");
		frames = pSetting.getFrames();
		assertFalse(pSetting.canRemoveFrame(frames.get(0)));
	}

	/**
	 * Tests the '{@link configurationemf.ParentSetting#canSetExtPolicy(configurationemf.EXTENSION_POLICY) <em>Can Set Ext Policy</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see configurationemf.ParentSetting#canSetExtPolicy(configurationemf.EXTENSION_POLICY)
	 * @generated
	 */
	public void testCanSetExtPolicy__EXTENSION_POLICY() {
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	@Override
	public void testSetCurrentValue() {
		RootConf conf = ConfigurationemfFactory.eINSTANCE.createRootConf();
		Feature feature = ConfigurationemfFactory.eINSTANCE.createFeature();
		feature.setRef("f1");
		conf.getFeature().add(feature);
		ParentSetting setting = getFixture();
		setting.setRef("s1");
		feature.getParentSetting().add(setting);
		String someValue = "someValue";
		setting.setCurrentValue(someValue);
		Assert.assertTrue("Current value set does not work", setting.getCurrentValue().compareTo(someValue)==0);
	}
	
	
	
	public void testLoadSequenceSetting(){
		ParentSetting pSetting = readSequenceSetting("inputFiles\\sequenceSettings\\phonebook.confml");
		assertNull("Default value is not null", pSetting.getDefaultValue());
		List<Frame> frames = pSetting.getFrames();
		Frame frame1 = frames.get(0);
		Frame frame2 = frames.get(1);
		
		assertEquals(frame1.getLeafSettings().size(),pSetting.getLeafSetting().size());
		LeafSettingDelegator s11 = frame1.getLeafSettings().get(0);
		LeafSettingDelegator s21 = frame2.getLeafSettings().get(0);
		assertEquals("John",s11.getValue());
		assertEquals("Adam",s21.getValue());
	}

	

	private void checkFrames(List<Frame>frames,String[][] expectedResult){
		assertEquals(expectedResult.length,frames.size());
		for(int i=0;i<frames.size();i++){
			Frame frame = frames.get(i);
			String[] frameResult = expectedResult[i];
			assertEquals(frameResult.length, frame.getLeafSettings().size());
			for(int j=0;j<frameResult.length;j++){
				LeafSettingDelegator setting = frame.getLeafSettings().get(j);
				String settingValue = frameResult[j];
				assertEquals(settingValue, setting.getValue());
			}
		}
	}
	
	public void testReplaceEP(){
		ParentSetting pSetting = readBasedOnSequenceSetting("inputFiles\\sequenceSettings\\myReplace.confml");
		assertEquals(EXTENSION_POLICY.REPLACE, pSetting.getCurrentExtensionPolicy());
		List<Frame> frames = pSetting.getFrames();
		String[][] expectedResult = new String[][]{
				new String[]{"The","Godfather","3"},
				new String[]{"Mickey","Mouse","4"},
		};
		checkFrames(frames,expectedResult);
	}
	
	public void testAppendEP(){
		ParentSetting pSetting = readBasedOnSequenceSetting("inputFiles\\sequenceSettings\\myAppend.confml");
		assertEquals(EXTENSION_POLICY.APPEND, pSetting.getCurrentExtensionPolicy());
		List<Frame> frames = pSetting.getFrames();
		String[][] expectedResult = new String[][]{
				new String[]{"John","Smith","1"},
				new String[]{"Adam","Brown","2"},
				new String[]{"The","Godfather","3"},
				new String[]{"Mickey","Mouse","4"},
		};
		checkFrames(frames,expectedResult);
	}
	
	public void testPrefixEP(){
		ParentSetting pSetting = readBasedOnSequenceSetting("inputFiles\\sequenceSettings\\myPrefix.confml");
		assertEquals(EXTENSION_POLICY.PREFIX, pSetting.getCurrentExtensionPolicy());
		List<Frame> frames = pSetting.getFrames();
		String[][] expectedResult = new String[][]{
				new String[]{"The","Godfather","3"},
				new String[]{"Mickey","Mouse","4"},
				new String[]{"John","Smith","1"},
				new String[]{"Adam","Brown","2"}
		};
		checkFrames(frames,expectedResult);
	}
	
	public void testAddToReplaceEP(){
		ParentSetting pSetting = readBasedOnSequenceSetting("inputFiles\\sequenceSettings\\myReplace.confml");
		pSetting.addFrame();
		List<Frame> frames = pSetting.getFrames();
		String[][] expectedResult = new String[][]{
				new String[]{"The","Godfather","3"},
				new String[]{"Mickey","Mouse","4"},
				new String[]{"X","Y","Z"}
		};
		checkFrames(frames,expectedResult);
	}
	
	public void testAddToAppendEP(){
		ParentSetting pSetting = readBasedOnSequenceSetting("inputFiles\\sequenceSettings\\myAppend.confml");
		pSetting.addFrame();
		List<Frame> frames = pSetting.getFrames();
		String[][] expectedResult = new String[][]{
				new String[]{"John","Smith","1"},
				new String[]{"Adam","Brown","2"},
				new String[]{"The","Godfather","3"},
				new String[]{"Mickey","Mouse","4"},
				new String[]{"X","Y","Z"}
		};
		checkFrames(frames,expectedResult);
	}
	
	public void testAddToPrefixEP(){
		ParentSetting pSetting = readBasedOnSequenceSetting("inputFiles\\sequenceSettings\\myPrefix.confml");
		pSetting.addFrame();
		List<Frame> frames = pSetting.getFrames();
		String[][] expectedResult = new String[][]{
				new String[]{"The","Godfather","3"},
				new String[]{"Mickey","Mouse","4"},
				new String[]{"X","Y","Z"},
				new String[]{"John","Smith","1"},
				new String[]{"Adam","Brown","2"}
		};
		checkFrames(frames,expectedResult);
	}
	
	
	private ParentSetting readSequenceSetting(String filePath) {
		Resource resource = new ConfigurationemfResourceImpl(URI.createFileURI(filePath));
		try{
			resource.load(null);
		}catch(Exception e){
			fail(e.getMessage());
		}
		if(!resource.getContents().isEmpty())
		{
			RootConf configuration = (RootConf)resource.getContents().get(0);
			Feature feature = configuration.getFeature().get(0);
			ParentSetting pSetting = feature.getParentSetting().get(0);
			return pSetting;
		}
		else 
			return null;
	}
	
	private ParentSetting readBasedOnSequenceSetting(String filePath) {
//		resourceSet.getResources().clear();
		Resource resource = resourceSet.createResource(URI.createFileURI(new File(filePath).getAbsolutePath()));
		
		try{
			resource.load(null);
		}catch(Exception e){
			fail(e.getMessage());
		}
		if(!resource.getContents().isEmpty())
		{
			RootConf configuration = (RootConf)resource.getContents().get(0);
			System.out.println(configuration.getName());
			RootConf basedOn = configuration.getInclude().get(0);
			System.out.println(basedOn.getName());
			Feature feature = basedOn.getFeature().get(0);
			ParentSetting pSetting = feature.getParentSetting().get(0);
			return pSetting;
		}
		else
			return null;
	}
	
	public void testGetTemplate(){
		ParentSetting pSetting = readSequenceSetting("inputFiles\\sequenceSettings\\phonebook.confml");
		Frame template = pSetting.getTemplate();
		assertNotNull(template);
		assertEquals(template.getLeafSettings().size(),pSetting.getLeafSetting().size());
		String st1 = template.getLeafSettings().get(0).getValue();
		String st2 = template.getLeafSettings().get(1).getValue();
		String st3 = template.getLeafSettings().get(2).getValue();
		assertEquals("X", st1);
		assertEquals("Y", st2);
		assertEquals("Z", st3);
		assertTrue(template.isTemplate());
	}
	
	public void testGetAbsRef() {
		assertNull(getFixture().getAbsRef());
	}

	@Override
	public void testGetTopValue() {
	}

	public void testSetRfs() {
		RootConf conf = ConfigurationemfFactory.eINSTANCE.createRootConf();
		Feature fea = ConfigurationemfFactory.eINSTANCE.createFeature();
		conf.getFeature().add(fea);
		assertEquals(false, conf.getFeature().isEmpty());
		ParentSetting setting = getFixture();
		fea.setRef("ref1");
		setting.setRef("ref2");
		fea.getParentSetting().add(setting);
		assertEquals(false, setting.isRfs());
		setting.setRfs(true);
		assertNotNull(conf.getRfs());
		assertEquals(1,conf.getRfs().getRef().size());
		assertEquals(true, setting.isRfs());
	}

	@Override
	public void testIsRfs() {
		RootConf conf = ConfigurationemfFactory.eINSTANCE.createRootConf();
		Feature fea = ConfigurationemfFactory.eINSTANCE.createFeature();
		conf.getFeature().add(fea);
		assertEquals(false, conf.getFeature().isEmpty());
		ParentSetting setting = getFixture();
		fea.setRef("ref1");
		setting.setRef("ref2");
		fea.getParentSetting().add(setting);
		
		assertEquals(false, setting.isRfs());
		setting.setRfs(true);
		assertEquals(true, setting.isRfs());
		
	}
	
	public void testEmpltySequence(){
		ParentSetting pSetting = readSequenceSetting("inputFiles\\sequenceSettings\\emptySequence.confml");
		List<Frame> frames = pSetting.getFrames();
		assertTrue(frames.isEmpty());
		pSetting.addFrame();
		frames = pSetting.getFrames();
		String[][] expectedResult = new String[][]{
				new String[]{"X","Y","Z"}
		};
		checkFrames(frames, expectedResult);
		pSetting.removeFrame(frames.get(0));
		frames=pSetting.getFrames();
		assertTrue(frames.isEmpty());
	}
	
	
} //ParentSettingTest
