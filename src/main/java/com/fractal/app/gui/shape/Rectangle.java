package edu.wcu.cs.cs495.team1.capstone.gui.shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * This class models a rectangle and provides a method for drawing
 * a rectangle.
 *
 * @author  Eddie Allen
 *
 * @version 9 April 2010
 */
public class Rectangle extends AbstractTwoPointShape {
    /**
     * Creates a new <code>Rectangle</code> of the specified color from 
     * the two provided points.
     *
     * @param color The color of the <code>Rectangle</code>.
     * @param start The starting point of the <code>Rectangle</code>.
     * @param end   The ending point of the <code>Rectangle</code>.
     */
    public Rectangle(Color color, Point start, Point end) {
        super(color, start, end);
    }

    /**
     * Draws the <code>Rectangle</code> from the two points which comprise
     * the rectangle.
     *
     * @param g The graphic to draw.
     */
    public void draw(Graphics g) {
        super.draw(g);
        Point newPoint = getNewStart();
        g.drawRect((int) newPoint.getX(), (int) newPoint.getY(), getWidth(), getHeight());
    }
}
