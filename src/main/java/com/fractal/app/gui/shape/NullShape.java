package edu.wcu.cs.cs495.team1.capstone.gui.shape;

import java.awt.Graphics;

/**
 * This class models a <code>NullShape</code> and implements the Null Object
 * design pattern.
 *
 * @author  Eddie Allen
 *
 * @version 9 April 2010
 */
public class NullShape implements Shape {
    /**
     * A draw method which does not draw anything.
     *
     * @param g The graphic to draw.
     */
    public void draw(Graphics g) {
        // draw nothing
    }
}
