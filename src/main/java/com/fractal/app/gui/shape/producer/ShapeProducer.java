package edu.wcu.cs.cs495.team1.capstone.gui.shape.producer;

import java.awt.Color;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import edu.wcu.cs.cs495.team1.capstone.gui.shape.Shape;

/**
 * This class extends <code>AbstractTwoPointShapeProducer</code> and 
 * implements the logic for creating rectangles.
 *
 * @author  Eddie Allen
 *
 * @version 9 April 2010
 */
public interface ShapeProducer extends MouseListener, MouseMotionListener {
    /** 
     * Adds the specified listener to the <code>List</code> of listeners.
     *
     * @param l The listener to add to the <code>List</code> of listeners. 
     */
    public void addShapeCreationListener(ShapeCreationListener l);

    /** 
     * Removes the specified listener from the <code>List</code> of listeners.
     *
     * @param  l    The listener to remove from the <code>List</code>
     *              of listeners. 
     * @return true If the listener was successfully removed, otherwise false.
     */
    public boolean removeShapeCreationListener(ShapeCreationListener l);

    /** 
     * Notifies any listeners that the specified <code>Shape</code> is
     * currently in the process of being created.
     *
     * @param shape The <code>Shape</code> that is currently in progress.
     */
    public void notifyShapeInProgress(Shape shape);

    /** 
     * Sets the draw color to the specified color.
     *
     * @param color The new draw color.
     */
    public void setDrawColor(Color color);
}
