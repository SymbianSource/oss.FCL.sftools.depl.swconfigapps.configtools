/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.nokia.tools.s60ct.model.confml.validation;

import java.net.URI;

/**
 * A sample validator interface for {@link com.nokia.tools.s60ct.model.confml.EResourceLocator}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface EResourceLocatorValidator {
	boolean validate();

	boolean validateResourceUri(URI value);
}