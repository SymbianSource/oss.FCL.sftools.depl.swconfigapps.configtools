/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.nokia.tools.carbide.ct.confml.model.confml2.validation;

import com.nokia.tools.carbide.ct.confml.model.confml2.ESettingRfs;

import org.eclipse.emf.common.util.EList;

/**
 * A sample validator interface for {@link com.nokia.tools.carbide.ct.confml.model.confml2.EFeatureRfs}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface EFeatureRfsValidator {
	boolean validate();

	boolean validateSettings(EList<ESettingRfs> value);
}