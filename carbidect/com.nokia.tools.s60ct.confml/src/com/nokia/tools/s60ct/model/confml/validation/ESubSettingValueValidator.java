/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.nokia.tools.s60ct.model.confml.validation;

import com.nokia.tools.s60ct.model.confml.ESimpleSetting;

/**
 * A sample validator interface for {@link com.nokia.tools.s60ct.model.confml.ESubSettingValue}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface ESubSettingValueValidator {
	boolean validate();

	boolean validateSimpleSetting(ESimpleSetting value);
}