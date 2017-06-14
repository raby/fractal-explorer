package com.fractal.app.logic.algorithms.math;

import com.fractal.app.logic.algorithms.color.ColoringAlgorithm;
import com.fractal.app.logic.algorithms.color.BandedColoringAlgorithm;
import com.fractal.app.logic.algorithms.color.SmoothColoringAlgorithm;

/**
 * This class models and displays a graphical representations of the well 
 * known Mandelbrot and Julia sets.
 *
 * @author  Eddie Allen
 *
 * @version 25 September 2010
 */
public class ComplexSet extends AbstractComplexSet {
    /** Represents the selection of the <code>BandedColoringAlgorithm</code>. */
    private static final int COLOR_ALG_BANDED = 0;

    /** Represents the selection of the <code>SmoothColoringAlgorithm</code>. */
    private static final int COLOR_ALG_SMOOTH = COLOR_ALG_BANDED + 1;

    /** The maximum number of iterations to perform. */
    private int maxIt;

    /** The power to which the set will be raised. */
    private int power;

    /** The algorithm used to choose colors for points within the set. */
    private ColoringAlgorithm colorAlg;

    /**
     * Creates a new <code>AbstractComplexSet</code> based on the specified
     * <code>Region</code>.
     *
     * @param region The <code>Region</code> on which to base the set.
     */
    public ComplexSet(Region region) {
        super(region);

        this.power = region.getPower();
        this.maxIt = region.getMaxIt();

        setColorAlg(region.getColorAlg());
    }

    /**
     * Tests for point inclusion within the set, based on some point.
     *
     * @param  z The point to test for set inclusion.
     * @param  c The point on which to base set, can be null.
     *
     * @return   The RGB value of the color for the point.
     */
    public int testPoint(ComplexNumber z, ComplexNumber c) {
        int color = 0;

        if (c == null) {
            color = testMandelbrotPoint(z);
        } else {
            color = testJuliaPoint(z, c);
        }

        return color;
    }

    /**
     * Sets the <code>ColoringAlgorithm</code> of the set to the specified
     * algorithm.
     *
     * @param color The new <code>ColoringAlgorithm</code> to use.
     */
    public void setColoringAlgorithm(ColoringAlgorithm colorAlg) {
        this.colorAlg = colorAlg;
    }

    /**
     * The primary method for computing the well known Mandelbrot set.
     * For each point z in the complex plane, we iterate over z = z^2 + c
     * using complex arithmetic. Iteration halts when the squared magnitude 
     * of z is greater than our threshold or we exceed the maximum number of
     * iterations. The number of iterations is returned and mapped to a color.
     *
     * @param c The point to test for set inclusion.
     *
     * @return  The RGB value of the color for the point.
     */
    private int testMandelbrotPoint(ComplexNumber c) {
        ComplexNumber z = new ComplexNumber(0.0, 0.0);

        for (int i = 0; i < maxIt; ++i) {
            for (int j = 1; j < power; ++j) {
                z = z.mult(z);
            }

            z = z.add(c);

            if (z.mag() > THRESHOLD) {
                return colorAlg.getColor(z, c, i, true);
            }
        }

        return colorAlg.getColor(z, c, maxIt - 1, true);
    }

    /**
     * The primary method for computing a Julia set. For each point z in 
     * the complex plane, we iterate over z = z^2 + c using complex 
     * arithmetic, where c is the Julia point on which the set will be based. 
     * Iteration halts when the squared magnitude of z is greater than our 
     * threshold or we exceed the maximum number of iterations. The number 
     * of iterations is returned and mapped to a color.
     *
     * @param z The point to test for set inclusion.
     * @param c The point which serves as a basis for a Julia set.
     *
     * @return  The RGB value of the color for the point.
     */
    private int testJuliaPoint(ComplexNumber z, ComplexNumber c) {
        double smoothJulia;

        for (int i = 0; i < maxIt; ++i) {
            for (int j = 1; j < power; ++j) {
                z = z.mult(z);
            }

            z = z.add(c);

            if (z.mag() > THRESHOLD) {
                return colorAlg.getColor(z, c, i, false);
            }
        }

        return colorAlg.getColor(z, c, maxIt - 1, false);
    }

    /** 
     * Instantiates the appropriate <code>ColoringAlgorithm</code>. 
     *
     * @param choice The <code>ColoringAlgorithm</code> choice. 
     */
    private void setColorAlg(int choice) {
        switch (choice) {
        case COLOR_ALG_BANDED:
            colorAlg = new BandedColoringAlgorithm(maxIt);
            break;
        case COLOR_ALG_SMOOTH:
            colorAlg = new SmoothColoringAlgorithm(maxIt);
            break;
        }
    }
}
