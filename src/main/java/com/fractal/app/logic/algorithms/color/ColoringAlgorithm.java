package com.fractal.app.logic.algorithms.color;

import com.fractal.app.logic.algorithms.math.ComplexNumber;

/**
 * This class provides an interface for a <code>ColoringAlgorithm</code>.
 *
 * @author  Eddie Allen
 *
 * @version 25 September 2010
 */
public interface ColoringAlgorithm {
    /**
     * Gets the RGB color value for a specified point with the "escape" value
     * specified by the number of iterations taken to escape and the maximum
     * number of iterations.
     * 
     * @param z          The value of the point when it "escaped".
     * @param c          The point to color.
     * @param iterations The number of iterations taken to "escape".
     *
     * @return           The RGB value of the color to assign to the point.
     */
    public int getColor(ComplexNumber z, ComplexNumber c, int iterations, boolean isMandelbrot);
}
