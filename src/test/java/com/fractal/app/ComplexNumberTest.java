package edu.wcu.cs.cs495.team1.capstone.tests;

import edu.wcu.cs.cs495.team1.capstone.algorithms.math.ComplexNumber;
import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit tests for the <code>ComplexNumber</code> class.
 *
 * @author  Eddie Allen
 * @author  Russell Gaskey
 *
 * @version 28 September 2010
 */
public class ComplexNumberTest {
    /** The number to test. */
    private ComplexNumber cn;

    /** Constructs an empty <code>ComplexNumber</code>. */
    public ComplexNumberTest() {
        this.cn = null;
    }

    /** Instantiates the <code>ComplexNumber</code>. */
    @Before
    public void setup() {
        this.cn = new ComplexNumber(0.0, 0.0);
    }

    /** Cleans up the <code>ComplexNumber</code>. */
    @After
    public void cleanUp() {
        this.cn = null;
    }

    /** Tests to ensure the complex arithmetic is correct. */
    @Test
    public void testArithmetic() {
        ComplexNumber testNum = new ComplexNumber(1.0, 2.0);
        ComplexNumber squared = new ComplexNumber(-3.0, 4.0);

        cn = cn.add(testNum);
        Assert.assertTrue("Test addition", cn.equals(testNum));
        Assert.assertTrue("Test square", cn.mult(cn).equals(squared));

        this.cn                  = new ComplexNumber(0.0, 0.0);
        ComplexNumber translated = new ComplexNumber(1.0, 1.0);

        cn.translate(1.0, 1.0);
        Assert.assertTrue("Test translate", cn.equals(translated));

        this.cn = new ComplexNumber(1.0, 2.0);
        Assert.assertTrue("Test magnitude", cn.mag() == 5.0);
    }

    /** Tests the accessor methods. */
    @Test
    public void testAccessors() {
        this.cn     = new ComplexNumber(1, 1);

        Assert.assertTrue("Test real portion", cn.getX() == 1.0);
        Assert.assertTrue("Test imaginary coefficient", cn.getY() == 1.0);
    }

    /** Tests the mutator methods. */
    @Test
    public void testMutators() {
        this.cn.setX(1.0);
        this.cn.setY(1.0);

        Assert.assertTrue("Test real portion", cn.getX() == 1.0);
        Assert.assertTrue("Test imaginary coefficient", cn.getY() == 1.0);
    }

    /** Tests for the equals method of the class. */
    @Test
    public void testEquals() {
        ComplexNumber test = new ComplexNumber(1.0, 2.0);
        this.cn            = new ComplexNumber(1.0, 2.0);

        Assert.assertTrue("Test equality", cn.equals(test));
    }
}
