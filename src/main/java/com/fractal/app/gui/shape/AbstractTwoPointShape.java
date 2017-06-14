package edu.wcu.cs.cs495.team1.capstone.gui.shape;

import java.awt.Color;
import java.awt.Point;

/**
 * This abstract class models a <code>Shape</code> which can be described by 
 * two points and includes any shape functionality common to all two point 
 * shapes.
 *
 * @author  Eddie Allen
 *
 * @version 9 April 2010
 */
public abstract class AbstractTwoPointShape extends AbstractShape {
    /** The starting point of the <code>AbstractTwoPointShape</code>. */
    private Point start;

    /** The ending point of the <code>AbstractTwoPointShape</code>. */
    private Point end;

    /**
     * Creates a new <code>AbstractTwoPointShape</code> of the specified
     * color from the two points provided.
     *
     * @param color The color of the <code>AbstractTwoPointShape</code>.
     * @param start The starting point of the 
     *              <code>AbstractTwoPointShape</code>.
     * @param end The ending point of the 
     *              <code>AbstractTwoPointShape</code>.
     */
    public AbstractTwoPointShape(Color color, Point start, Point end) {
        super(color);
        this.start = start;
        this.end = end;
    }

    /**
     * Returns the starting point of the <code>AbstractTwoPointShape</code>.
     *
     * @return The starting point of the <code>AbstractTwoPointShape</code>.
     */
    // ARD: Should be protected
    public Point getStart() {
        return this.start;
    }

    /**
     * Returns the ending point of the <code>AbstractTwoPointShape</code>.
     *
     * @return The ending point of the <code>AbstractTwoPointShape</code>.
     */
    // ARD: Should be protected
    public Point getEnd() {
        return this.end;
    }

    /**
     * Returns a <code>Point</code> which is the upper left corner of the
     * <code>AbstractTwoPointShape</code>.
     *
     * @return A <code>Point</code> which is the upper left corner of the
     *         <code>AbstractTwoPointShape</code>.
     */
    // ARD: Should be protected
    public Point getNewStart() {
        Point newPoint = new Point(this.start);
        if (this.end.getX() < this.start.getX()) {
            newPoint.setLocation(this.end.getX(), newPoint.getY());
        }
        if (this.end.getY() < this.start.getY()) {
            newPoint.setLocation(newPoint.getX(), this.end.getY());
        }
        return newPoint;
    }

    /**
     * Returns the width of the <code>AbstractTwoPointShape</code>.
     *
     * @return The width of the <code>AbstractTwoPointShape</code>.
     */
    public int getWidth() {
        return (int) Math.abs(this.end.getX() - this.start.getX());
    }

    /**
     * Returns the height of the <code>AbstractTwoPointShape</code>.
     *
     * @return The height of the <code>AbstractTwoPointShape</code>.
     */
    public int getHeight() {
        return (int) Math.abs(this.end.getY() - this.start.getY());
    }
}
