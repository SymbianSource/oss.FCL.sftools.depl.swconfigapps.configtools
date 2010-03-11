/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.nokia.tools.s60ct.model.confml.validation;

import com.nokia.tools.s60ct.model.confml.ESetting;

import org.eclipse.emf.common.util.EList;

/**
 * A sample validator interface for {@link com.nokia.tools.s60ct.model.confml.EFeature}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface EFeatureValidator {
	boolean validate();

	boolean validateSettings(EList<ESetting> value);
	boolean validateRef(String value);
	boolean validateName(String value);
	boolean validateRelevant(String value);
	boolean validateRelevantAST(Object value);
	boolean validateComputedRelevant(boolean value);
}
