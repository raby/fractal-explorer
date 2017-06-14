package com.fractal.app.logic.algorithms.color;

import com.fractal.app.logic.algorithms.math.ComplexNumber;
import java.awt.Color;

/**
 * This class provides an interface for a <code>ColoringAlgorithm</code>.
 *
 * @author  Eddie Allen
 *
 * @version 25 September 2010
 */
public class BandedColoringAlgorithm implements ColoringAlgorithm {
    /** Colors to use for coloring points. */
    private int[] colors;

    /** The maximum number of iterations. */
    private int maxIt;

    /**
     * Creates a new <code>BandedColoringAlgorithm</code> and initializes the
     * colors to the default colors.
     *
     * @param maxIt The maximum number of iterations.
     */
    public BandedColoringAlgorithm(int maxIt) {
        this.maxIt = maxIt;
        this.colors = new int[maxIt];

        initializeColors();
    }

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
    public int getColor(ComplexNumber z, ComplexNumber c, int iterations, boolean isMandelbrot) {
        return colors[iterations];
    }

    /** Initializes the array of <code>Color</code>s used to color points. */
    private void initializeColors() {
        for (int i = 0; i < colors.length; ++i) {
            /* Technicolor */
            //colors[maxIt - 1 - i] = (i * 4) ^ ((i * 3) << 6) ^ ((i * 7) << 13);
            colors[maxIt - 1 - i] = (i * 4) ^ ((i * 3) << 8) ^ ((i * 7) << 16);

            /* Grayscale */
            //colors[maxIt - 1 - i] = (i * 4 << 16) + (i * 4 << 8) + i * 4;
        }
    }
}