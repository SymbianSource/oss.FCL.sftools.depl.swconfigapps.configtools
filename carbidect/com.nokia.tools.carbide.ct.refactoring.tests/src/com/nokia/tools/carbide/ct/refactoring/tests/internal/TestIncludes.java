package com.nokia.tools.carbide.ct.refactoring.tests.internal;

import java.io.File;
import java.net.URI;

import junit.framework.TestCase;

public class TestIncludes extends TestCase {
	
	public void testInclude() throws Exception {
		URI uri1 = new File("c:\\project").toURI();
		URI uri2 = new File("c:\\project\\layer1\\root.confml").toURI();
		URI uri3 = new File("c:\\project\\layer1").toURI();
		
		assertEquals(uri1.relativize(uri2).toString(), "layer1/root.confml");
		assertEquals(uri1.relativize(uri3).toString(), "layer1");
	}

}
