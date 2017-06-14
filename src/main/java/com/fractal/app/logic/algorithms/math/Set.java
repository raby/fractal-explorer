package com.fractal.app.logic.algorithms.math;

import com.fractal.app.image.Image;

/**
 * Provides an interface to a set of <code>ComplexNumber</code>s.
 *
 * @author  Eddie Allen
 *
 * @version 25 September 2010
 */
public interface Set {
    /**
     * Computes a color value for each pixel representing a point within 
     * the set.
     *
     * @param basisPoint The point on which to base the set, can be null.
     */
    public void generate(ComplexNumber basisPoint);

    /**
     * Determines whether or not a point is in the set by iterating over a 
     * function.
     *
     * @param  point      The point to test for set inclusion.
     * @param  basisPoint The point on which to base set, can be null.
     *
     * @return            The number of iterations performed.
     */
    public int testPoint(ComplexNumber point, ComplexNumber basisPoint);

    /**
     * Returns the current image.
     *
     * @return The current image.
     */
    public Image getImage();
}
