package edu.wcu.cs.cs495.team1.capstone.gui.shape;

import java.awt.Graphics;

/**
 * This class defines an interface for shapes that can draw themselves.
 *
 * @author  Eddie Allen
 *
 * @version 9 April 2010
 */
public interface Shape {
    /**
     * Draws the shape.
     *
     * @param g The graphic to draw.
     */
    public void draw(Graphics g);
}
