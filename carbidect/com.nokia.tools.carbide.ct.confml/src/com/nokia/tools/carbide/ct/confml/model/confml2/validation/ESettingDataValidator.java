/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.nokia.tools.carbide.ct.confml.model.confml2.validation;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * A sample validator interface for {@link com.nokia.tools.carbide.ct.confml.model.confml2.ESettingData}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface ESettingDataValidator {
	boolean validate();

	boolean validateTemplate(String value);

	boolean validateExtensionPolicy(String value);

	boolean validateValue(FeatureMap value);

	boolean validateText(String value);

	boolean validateMap(String value);
}
