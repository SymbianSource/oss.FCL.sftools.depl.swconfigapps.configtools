/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.nokia.tools.carbide.ct.confml.model.confml2.validation;

/**
 * A sample validator interface for {@link com.nokia.tools.carbide.ct.confml.model.confml2.ETargetPathElement}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface ETargetPathElementValidator {
	boolean validate();

	boolean validateConstraint(String value);

	boolean validateReadOnly(String value);

	boolean validateRequired(String value);

	boolean validateMap(String value);
}
