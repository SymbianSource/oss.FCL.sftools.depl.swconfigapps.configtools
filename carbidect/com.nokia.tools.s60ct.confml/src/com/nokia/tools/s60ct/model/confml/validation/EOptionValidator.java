/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.nokia.tools.s60ct.model.confml.validation;

import com.nokia.tools.s60ct.model.confml.EOptionMap;
import com.nokia.tools.s60ct.model.confml.ESequenceSetting;

import java.util.Map;

/**
 * A sample validator interface for {@link com.nokia.tools.s60ct.model.confml.EOption}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface EOptionValidator {
	boolean validate();

	boolean validateName(String value);
	boolean validateValue(String value);
	boolean validateMap(String value);
	boolean validateMapSourceSetting(ESequenceSetting value);
	boolean validateOptionValues(Map<String, EOptionMap> value);
}
