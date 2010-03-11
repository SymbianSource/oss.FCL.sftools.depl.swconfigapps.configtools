/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.nokia.tools.s60ct.model.confml.validation;

import com.nokia.tools.s60ct.model.confml.ESettingOption;
import com.nokia.tools.s60ct.model.confml.ESettingValueType;

import org.eclipse.emf.common.util.EList;

/**
 * A sample validator interface for {@link com.nokia.tools.s60ct.model.confml.ESimpleSetting}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface ESimpleSettingValidator {
	boolean validate();

	boolean validateType(ESettingValueType value);
	boolean validateMinInclusive(String value);
	boolean validateMaxInclusive(String value);
	boolean validateMinExclusive(String value);
	boolean validateMaxExclusive(String value);
	boolean validateMinLength(Integer value);
	boolean validateMaxLength(Integer value);
	boolean validateLength(Integer value);
	boolean validatePattern(EList<String> value);
	boolean validateTotalDigits(Integer value);
	boolean validateOptions(EList<ESettingOption> value);
	boolean validateChosenOption(String value);
}