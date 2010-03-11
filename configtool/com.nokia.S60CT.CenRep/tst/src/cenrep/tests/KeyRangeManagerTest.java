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
package cenrep.tests;

import java.util.Arrays;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

import cenrep.Access;
import cenrep.Bit;
import cenrep.CenrepFactory;
import cenrep.Key;
import cenrep.KeyRange;
import cenrep.TYPE;
import cenrep.Value;
import cenrep.util.KeyRangeManager;
import junit.framework.TestCase;

public class KeyRangeManagerTest extends TestCase {

	KeyRangeManager manager = KeyRangeManager.INSTANCE;
	
	public KeyRangeManagerTest(String name) {
		super(name);
	}

	public void testUidToInt(){
		assertEquals(0, manager.uidToInt("0x0"));
		assertEquals(1, manager.uidToInt("0x1"));
		assertEquals(1, manager.uidToInt("0x001"));
		assertEquals(10, manager.uidToInt("0xA"));
		assertEquals(160, manager.uidToInt("0xA0"));
		assertEquals(511, manager.uidToInt("0x1ff"));
		assertEquals(8388607, manager.uidToInt("0x07fffff"));
		assertEquals(Long.valueOf("4294967295").longValue(), (long)manager.uidToInt("0xffffffff"));
	}
	
	public void testIntToUid(){
		assertEquals("0x0000001", manager.intToUid(1));
		assertEquals("0x0000000", manager.intToUid(0));
		assertEquals("0xfffffff", manager.intToUid(268435455));
	}

	public void testCreateKeysIndex(){
		KeyRangeMock range = new KeyRangeMock(new KeyMock[]{
				new KeyMock("0x0000001"),
				new KeyMock("0x0000002"),
				new KeyMock("0x000F00F"),
			});
		range.firstInt="0x07020000";
		range.lastInt="0x07FFFFFF";
		range.indexBit="0x00FF0000";
		range.firstIndex="2";
		
		
		Key[] keys0 = manager.createKeysIndex(range, 0);
		Key[] keys1 = manager.createKeysIndex(range, 1);
		
		for(Key key : keys0){
			System.out.println(key.getIdent());
		}
		
		for(Key key : keys1){
			System.out.println(key.getIdent());
		}
		assertEquals("0x7020001", keys0[0].getIdent());
		assertEquals("0x7020002", keys0[1].getIdent());
		assertEquals("0x702f00f", keys0[2].getIdent());
		
		assertEquals("0x7030001", keys1[0].getIdent());
		assertEquals("0x7030002", keys1[1].getIdent());
		assertEquals("0x703f00f", keys1[2].getIdent());
	}
	
	static class KeyRangeMock implements KeyRange{
		EList<Key> keys= new BasicEList<Key>();
		String firstInt =null;
		String lastInt = null;
		String indexBit = null;
		String firstIndex=null;
		Access access = CenrepFactory.eINSTANCE.createAccess();
		public KeyRangeMock(KeyMock[] keys){
			this.keys.addAll(Arrays.asList(keys));
		}
		@Override
		public boolean canGenerate() {
			return false;
		}

		@Override
		public String getFolder() {
			return null;
		}

		@Override
		public int getGPriority() {
			return 0;
		}

		@Override
		public Object getGvalue() {
			return null;
		}

		@Override
		public String getRef() {
			return null;
		}

		@Override
		public boolean isRfs() {
			return false;
		}

		@Override
		public void setGConf(String confName) {
			
		}

		@Override
		public void setGvalue(Object value) {
			
		}

		@Override
		public void setPriority(String prio) {
			
		}

		@Override
		public void setRef(String value) {
			
		}

		@Override
		public void setRfs(boolean value) {
			
		}

		@Override
		public EList<Access> getAccess() {
			return new BasicEList<Access>();
		}

		@Override
		public String getGAccess() {
			return null;
		}

		@Override
		public Access getReadAccess() {
			return access;
		}

		@Override
		public Access getWriteAccess() {
			return access;
		}

		@Override
		public void setReadAccess(Access value) {
			
		}

		@Override
		public void setWriteAccess(Access value) {
			
		}

		@Override
		public String getId() {
			return null;
		}

		@Override
		public void setId(String value) {
			
		}

		@Override
		public boolean isReadOnly() {
			return false;
		}

		@Override
		public void setReadOnly(boolean value) {
			
		}

		@Override
		public TreeIterator<EObject> eAllContents() {
			return null;
		}

		@Override
		public EClass eClass() {
			return null;
		}

		@Override
		public EObject eContainer() {
			return null;
		}

		@Override
		public EStructuralFeature eContainingFeature() {
			return null;
		}

		@Override
		public EReference eContainmentFeature() {
			return null;
		}

		@Override
		public EList<EObject> eContents() {
			return null;
		}

		@Override
		public EList<EObject> eCrossReferences() {
			return null;
		}

		@Override
		public Object eGet(EStructuralFeature feature, boolean resolve) {
			return null;
		}

		@Override
		public Object eGet(EStructuralFeature feature) {
			return null;
		}

		@Override
		public boolean eIsProxy() {
			return false;
		}

		@Override
		public boolean eIsSet(EStructuralFeature feature) {
			return false;
		}

		@Override
		public Resource eResource() {
			return null;
		}

		@Override
		public void eSet(EStructuralFeature feature, Object newValue) {
			
		}

		@Override
		public void eUnset(EStructuralFeature feature) {
			
		}

		@Override
		public EList<Adapter> eAdapters() {
			return null;
		}

		@Override
		public boolean eDeliver() {
			return false;
		}

		@Override
		public void eNotify(Notification notification) {
			
		}

		@Override
		public void eSetDeliver(boolean deliver) {
			
		}

		@Override
		public String getCountInt() {
			return null;
		}

		@Override
		public String getFirstIndex() {
			return firstIndex;
		}

		@Override
		public String getFirstInt() {
			return firstInt;
		}

		@Override
		public EList<Key> getGKeys() {
			return null;
		}

		@Override
		public String getIndexBits() {
			return indexBit;
		}

		@Override
		public String getInt() {
			return null;
		}

		@Override
		public EList<Key> getKeys() {
			return keys;
		}

		@Override
		public String getLastInt() {
			return lastInt;
		}

		@Override
		public String getName() {
			return null;
		}

		@Override
		public boolean isBackup() {
			return false;
		}

		@Override
		public void setBackup(boolean value) {
			
		}

		@Override
		public void setCountInt(String value) {
			
		}

		@Override
		public void setFirstIndex(String value) {
			
		}

		@Override
		public void setFirstInt(String value) {
			
		}

		@Override
		public void setIndexBits(String value) {
			
		}

		@Override
		public void setInt(String value) {
			
		}

		@Override
		public void setLastInt(String value) {
			
		}

		@Override
		public void setName(String value) {
			
		}

		@Override
		public String getDesc() {
			return null;
		}

		@Override
		public void setDesc(String value) {
			
		}
		
	}

	static class KeyMock implements Key {
		String uid=null;
		public KeyMock(String uid){
			this.uid=uid;
		}
		@Override
		public EList<Bit> getBits() {
			return null;
		}

		@Override
		public String getIdent() {
			return uid;
		}

		@Override
		public String getName() {
			return null;
		}

		@Override
		public String getShortIdent() {
			return null;
		}

		@Override
		public String getStrType() {
			return null;
		}

		@Override
		public TYPE getType() {
			return null;
		}

		@Override
		public EList<Value> getValue() {
			return null;
		}

		@Override
		public boolean isBackup() {
			return false;
		}

		@Override
		public boolean isBitmaskKey() {
			
			return false;
		}

		@Override
		public boolean isDecFormat() {
			
			return false;
		}

		@Override
		public boolean isHexFormat() {
			
			return false;
		}

		@Override
		public boolean isSimpleKey() {
			
			return false;
		}

		@Override
		public void setBackup(boolean value) {
			
			
		}

		@Override
		public void setBitmaskKey(boolean value) {
			
			
		}

		@Override
		public void setIdent(String value) {
			
			
		}

		@Override
		public void setName(String value) {
			
			
		}

		@Override
		public void setShortIdent(String value) {
			
			
		}

		@Override
		public void setSimpleKey(boolean value) {
			
			
		}

		@Override
		public void setType(TYPE value) {
			
			
		}

		@Override
		public boolean canGenerate() {
			
			return false;
		}

		@Override
		public String getFolder() {
			
			return null;
		}

		@Override
		public int getGPriority() {
			
			return 0;
		}

		@Override
		public Object getGvalue() {
			
			return null;
		}

		@Override
		public String getRef() {
			
			return null;
		}

		@Override
		public boolean isRfs() {
			
			return false;
		}

		@Override
		public void setGConf(String confName) {
			
			
		}

		@Override
		public void setGvalue(Object value) {
			
			
		}

		@Override
		public void setPriority(String prio) {
			
			
		}

		@Override
		public void setRef(String value) {
			
			
		}

		@Override
		public void setRfs(boolean value) {
			
			
		}

		@Override
		public String getDesc() {
			
			return null;
		}

		@Override
		public void setDesc(String value) {
			
			
		}

		@Override
		public String getId() {
			
			return null;
		}

		@Override
		public void setId(String value) {
			
			
		}

		@Override
		public EList<Access> getAccess() {
			
			return null;
		}

		@Override
		public String getGAccess() {
			
			return null;
		}

		@Override
		public Access getReadAccess() {
			
			return null;
		}

		@Override
		public Access getWriteAccess() {
			
			return null;
		}

		@Override
		public void setReadAccess(Access value) {
			
			
		}

		@Override
		public void setWriteAccess(Access value) {
			
			
		}

		@Override
		public TreeIterator<EObject> eAllContents() {
			
			return null;
		}

		@Override
		public EClass eClass() {
			
			return null;
		}

		@Override
		public EObject eContainer() {
			
			return null;
		}

		@Override
		public EStructuralFeature eContainingFeature() {
			
			return null;
		}

		@Override
		public EReference eContainmentFeature() {
			
			return null;
		}

		@Override
		public EList<EObject> eContents() {
			
			return null;
		}

		@Override
		public EList<EObject> eCrossReferences() {
			
			return null;
		}

		@Override
		public Object eGet(EStructuralFeature feature, boolean resolve) {
			
			return null;
		}

		@Override
		public Object eGet(EStructuralFeature feature) {
			
			return null;
		}

		@Override
		public boolean eIsProxy() {
			
			return false;
		}

		@Override
		public boolean eIsSet(EStructuralFeature feature) {
			
			return false;
		}

		@Override
		public Resource eResource() {
			
			return null;
		}

		@Override
		public void eSet(EStructuralFeature feature, Object newValue) {
			
			
		}

		@Override
		public void eUnset(EStructuralFeature feature) {
			
			
		}

		@Override
		public boolean isReadOnly() {
			
			return false;
		}

		@Override
		public void setReadOnly(boolean value) {
			
			
		}

		@Override
		public EList<Adapter> eAdapters() {
			
			return null;
		}

		@Override
		public boolean eDeliver() {
			
			return false;
		}

		@Override
		public void eNotify(Notification notification) {
			
			
		}

		@Override
		public void eSetDeliver(boolean deliver) {
			
			
		}
		
	}
}
