/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.nokia.tools.carbide.ct.confml.model.confml1.validation;

import com.nokia.tools.carbide.ct.confml.model.confml1.EConfigurationElement;
import com.nokia.tools.carbide.ct.confml.model.confml1.EDataElement;
import com.nokia.tools.carbide.ct.confml.model.confml1.EFeatureElement;
import com.nokia.tools.carbide.ct.confml.model.confml1.ERfsElement;
import com.nokia.tools.carbide.ct.confml.model.confml1.EViewElement;

import com.nokia.tools.carbide.ct.confml.model.confml1.include.EInclude;

import org.eclipse.emf.common.util.EList;

/**
 * A sample validator interface for {@link com.nokia.tools.carbide.ct.confml.model.confml1.EConfigurationElement}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface EConfigurationElementValidator {
	boolean validate();

	boolean validateConfigurations(EList<EConfigurationElement> value);

	boolean validateFeatures(EList<EFeatureElement> value);

	boolean validateViews(EList<EViewElement> value);

	boolean validateData(EList<EDataElement> value);

	boolean validateRfs(EList<ERfsElement> value);

	boolean validateName(String value);

	boolean validateVersion(String value);

	boolean validateIncludes(EList<EInclude> value);
}