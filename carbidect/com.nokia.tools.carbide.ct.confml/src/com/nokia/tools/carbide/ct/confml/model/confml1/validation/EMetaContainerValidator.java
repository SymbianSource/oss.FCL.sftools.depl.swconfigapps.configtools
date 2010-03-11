/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.nokia.tools.carbide.ct.confml.model.confml1.validation;

import com.nokia.tools.carbide.ct.confml.model.confml1.EMetaElement;

import org.eclipse.emf.common.util.EList;

/**
 * A sample validator interface for {@link com.nokia.tools.carbide.ct.confml.model.confml1.EMetaContainer}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface EMetaContainerValidator {
	boolean validate();

	boolean validateMetas(EList<EMetaElement> value);
}
