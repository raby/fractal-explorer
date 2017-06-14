package edu.wcu.cs.cs495.team1.capstone.gui.shape;

import java.awt.Color;
import java.awt.Graphics;

/**
 * This class abstractly models a <code>Shape</code> and includes any 
 * functionality that is common to all <code>Shape</code> objects.
 *
 * @author  Eddie Allen
 *
 * @version 9 April 2010
 */
public abstract class AbstractShape implements Shape {
    /** The color of the <code>Shape</code>. */
    private Color color;

    /** 
     * Creates a new <code>Shape</code> of the specified <code>Color</code>. 
     * 
     * @param color The color of the <code>Shape</code> to create.
     */
    public AbstractShape(Color color) {
        this.color = color;
    }

    /**
     * Draws the shape and sets its color.
     *
     * @param g The graphic to draw.
     */
    public void draw(Graphics g) {
        g.setColor(this.color);
    }
}
