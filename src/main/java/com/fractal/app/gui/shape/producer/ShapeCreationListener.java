package edu.wcu.cs.cs495.team1.capstone.gui.shape.producer;

import edu.wcu.cs.cs495.team1.capstone.gui.shape.Shape;

/**
 * This class defines an interface to objects that know how to create 
 * <code>Shapes</code>.
 *
 * @author  Eddie Allen
 *
 * @version 9 April 2010
 */
public interface ShapeCreationListener {
    /**
     * Notifies the <code>ShapeCreationListener</code> that the specified
     * <code>Shape</code> is currently in the process of being created.
     *
     * @param shape The <code>Shape</code> that is currently in the process
     *              of being created.
     */
    public void regionSelected(int x0, int y0, int x1, int y1);

    /**
     * Notifies the <code>ShapeCreationListener</code> that the specified
     * <code>Shape</code> is currently in the process of being created.
     *
     * @param shape The <code>Shape</code> that is currently in the process
     *              of being created.
     */
    public void shapeInProgress(Shape shape);
}
