package com.fractal.app.logic.algorithms.math;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * This class models a complex number which takes the form c = x + yi,
 * where x and y are real numbers, and i = sqrt(-1).  This class uses
 * <code>Double</code>s and <code>BigDecimal</code>s to model a 
 * <code>ComplexNumber</code>.
 *
 * @author  Eddie Allen
 *
 * @version 25 September 2010
 */
public class ComplexNumber implements Serializable {
    /** A unique id associated with this <code>Serializable</code> object. */
    private static final long serialVersionUID = 1234567890;

    /** A math context for performing precision calculations. */
    private MathContext mc = MathContext.DECIMAL128;

    /** The real portion. */
    private double x;

    /** The coefficient of the imaginary portion. */
    private double y;

    /** The real portion with increased precision. */
    private BigDecimal px;

    /** The coefficient of the imaginary portion with increased precision. */
    private BigDecimal py;

    /**
     * Creates a <code>ComplexNumber</code> from the specified double values.
     *
     * @param x The real portion.
     * @param y The coefficient of the imaginary portion.
     */
    public ComplexNumber(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Creates a <code>ComplexNumber</code> from the specified 
     * <code>BigDecimal</code> values.
     *
     * @param px The real portion.
     * @param py The coefficient of the imaginary portion.
     */
    public ComplexNumber(BigDecimal px, BigDecimal py) {
        this.px = px;
        this.py = py;
    }

    /** 
     * Returns the sum of this and the specified 
     * <code>ComplexNumber</code>s.
     *
     * @param  c The number to add to this <code>ComplexNumber</code>.
     *
     * @return   The sum of the two <code>ComplexNumber</code>s.
     */
    public ComplexNumber add(ComplexNumber c) {
        return new ComplexNumber(x + c.x, y + c.y);
    }

    /** 
     * Returns the sum of this and the specified 
     * <code>ComplexNumber</code>s with increased precision.
     *
     * @param  c The number to add to this <code>ComplexNumber</code>.
     *
     * @return   The sum of the two <code>ComplexNumber</code>s with 
     *           increased precision.
     */
    public ComplexNumber pAdd(ComplexNumber c) {
        return new ComplexNumber(px.add(c.px, mc), py.add(c.py, mc));
    }

    /** 
     * Returns the multiplication of this and the specified 
     * <code>ComplexNumber</code>.
     *
     * @param  c The <code>ComplexNumber</code> to multiply.
     *
     * @return   The multiplication of this and the specified 
     *           <code>ComplexNumber</code>.
     */
    public ComplexNumber mult(ComplexNumber c) {
        return new ComplexNumber((x * c.x) - (y * c.y), (y * c.x) + (x * c.y));
    }

    /** 
     * Returns the multiplication of this and the specified 
     * <code>ComplexNumber</code> with increased precision.
     *
     * @param  c The <code>ComplexNumber</code> to multiply.
     *
     * @return   The multiplication of this and the specified 
     *           <code>ComplexNumber</code> with increased precision.
     */
    public ComplexNumber pMult(ComplexNumber c) {
        return new ComplexNumber(px.multiply(c.px, mc).subtract(py.multiply(c.py, mc), mc),
                py.multiply(c.px, mc).add(px.multiply(c.py, mc), mc));
    }

    /** 
     * Computes the squared magnitude of a <code>ComplexNumber</code>.
     * This method is used in determining how close the number is to infinity.
     *
     * @return The squared magnitude of this <code>ComplexNumber</code>.
     */
    public double mag() {
        return (x * x) + (y * y);
    }

    /** 
     * Computes the squared magnitude of a <code>ComplexNumber</code> with
     * increased precision. This method is used in determining how close 
     * the number is to infinity.
     *
     * @return The squared magnitude of this <code>ComplexNumber</code> 
     *         with increased precision.
     */
    public BigDecimal pMag() {
        return px.multiply(px, mc).add(py.multiply(py, mc), mc);
    }

    /** 
     * Translates the <code>ComplexNumber</code> by the specified values.
     *
     * @param dx The distance to translate the real component.
     * @param dy The distance to translate the imaginary coefficient.
     */
    public void translate(double dx, double dy) {
        x += dx;
        y += dy;
    }

    /** 
     * Translates the <code>ComplexNumber</code> by the specified values 
     * with increased precision.
     *
     * @param dx The distance to translate the real component.
     * @param dy The distance to translate the imaginary coefficient.
     */
    public void pTranslate(BigDecimal dx, BigDecimal dy) {
        px = px.add(dx, mc);
        py = py.add(dy, mc);
    }

    /**
     * Returns the real component.
     *
     * @return The real component.
     */
    public double getX() {
        return x;
    }

    /**
     * Returns the imaginary coefficient.
     *
     * @return The imaginary coefficient.
     */
    public double getY() {
        return y;
    }

    /**
     * Returns the real component with increased precision.
     *
     * @return The real component with increased precision.
     */
    public BigDecimal getPx() {
        return px;
    }

    /**
     * Returns the imaginary coefficient with increased precision.
     *
     * @return The imaginary coefficient with increased precision.
     */
    public BigDecimal getPy() {
        return py;
    }

    /**
     * Sets the value of the real component.
     *
     * @param x The new value of the real component.
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Sets the value of the imaginary coefficient.
     *
     * @param y The new value of the imaginary coefficient.
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Sets the value of the real component with increased precision.
     *
     * @param px The new value of the real component with increased precision.
     */
    public void setPx(BigDecimal px) {
        this.px = px;
    }

    /**
     * Sets the value of the imaginary coefficient with increased precision.
     *
     * @param py The new value of the imaginary coefficient with increased 
     *           precision.
     */
    public void setPy(BigDecimal py) {
        this.py = py;
    }

    /**
     * Sets the precision setting of the math context for performing precision
     * set calculations.
     *
     * @param precision The precision setting.
     */
    public void setPrecision(int precision) {
        mc = new MathContext(precision, RoundingMode.HALF_EVEN);
    }

    /**
     * Tests for the equality of the two <code>ComplexNumber</code>s.
     *
     * @return true If the two <code>ComplexNumber</code>s are equal.
     */
    @Override
    public boolean equals(Object o) {
        boolean equal = o instanceof ComplexNumber;

        if (equal && o != this) {
            ComplexNumber c = (ComplexNumber) o;

            equal = (x == c.x) && (y == c.y);
        }

        return equal;
    }

    /**
     * Tests for the equality of the two <code>ComplexNumber</code>s.
     *
     * @return true If the two <code>ComplexNumber</code>s are equal.
     */
    public boolean pEquals(Object o) {
        boolean equal = o instanceof ComplexNumber;

        if (equal && o != this) {
            ComplexNumber c = (ComplexNumber) o;

            equal = px.equals(c.px) && py.equals(c.py);
        }

        return equal;
    }

    /**
     * Returns the <code>String</code> representation of the number.
     *
     * @return The <code>String</code> representation of the number.
     */
    @Override
    public String toString() {
        return x + " + " + y + " i";
    }

    /**
     * Returns the <code>String</code> representation of the number with
     * increased precision.
     *
     * @return The <code>String</code> representation of the number with
     *         increased precision.
     */
    public String pToString() {
        return px.toString() + " + " + py.toString() + " i";
    }
}
