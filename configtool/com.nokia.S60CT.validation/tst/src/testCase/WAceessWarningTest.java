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

package testCase;

import constraints.WAccessWarning;

public class WAceessWarningTest extends AbstractConstraintTest {

	@Override
	protected Pair[] getAcceptedObjects() {
		Pair[] pair = new Pair[]{
			new Pair(new WriteCapaExistanceTest.WriteAccessMock("alwayspass"),"alwaysPass should be accepted"),
			new Pair(new WriteCapaExistanceTest.WriteAccessMock("writedevicedata"),"writedevicedata should be accepted"),
			new Pair(new WriteCapaExistanceTest.WriteAccessMock("writedevicedata,alwayspass"),"writedevicedata and alwayspass should be accepted"),
			new Pair(new WriteCapaExistanceTest.WriteAccessMock("writedevicedata,smt"),"writedevicedata and smt should be accepted"),
			new Pair(new WriteCapaExistanceTest.WriteAccessMock("smt,alwayspass"),"smt and alwayspass should be accepted"),
		};
		return pair;
	}

	@Override
	protected Pair[] getRejectedObjects() {
		Pair[] pair = new Pair[]{
				new Pair(new WriteCapaExistanceTest.WriteAccessMock(null),"null should not be accepted"),
				new Pair(new WriteCapaExistanceTest.WriteAccessMock("something"),"something should not be accepted"),
			};
			return pair;
	}

	@Override
	protected void setUp() throws Exception {
		constraint = new WAccessWarning();
	}

}
