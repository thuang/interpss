/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.opencim.cim.iec61970.gen.production.validation;

import org.opencim.cim.iec61970.domain.FuelType;

/**
 * A sample validator interface for {@link org.opencim.cim.iec61970.gen.production.StartMainFuelCurve}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface StartMainFuelCurveValidator {
	boolean validate();

	boolean validateMainFuelType(FuelType value);
}
