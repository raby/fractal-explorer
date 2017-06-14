package edu.wcu.cs.cs495.team1.capstone.gui.shape.producer;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import edu.wcu.cs.cs495.team1.capstone.gui.Settings;
import edu.wcu.cs.cs495.team1.capstone.gui.shape.Rectangle;
import edu.wcu.cs.cs495.team1.capstone.gui.shape.NullShape;
import edu.wcu.cs.cs495.team1.capstone.gui.shape.Shape;

/**
 * This class extends <code>AbstractTwoPointShapeProducer</code> and 
 * implements the logic for creating rectangles.
 *
 * @author  Eddie Allen
 *
 * @version 9 April 2010
 */
public class NullShapeProducer extends MouseAdapter implements ShapeProducer {
    /** The settings for the graphical user interface. */
    private Settings settings = Settings.getInstance();

    /** The starting point of the <code>Square</code> */
    private Point start;

    /** Listeners that will be notified about the creation of shapes. */
    private List<ShapeCreationListener> listeners;

    /** The drawing color for the <code>Shape</code>. */
    private Color drawColor;

    /**
     * Initializes the <code>List</code> of listeners to an empty 
     * <code>List</code> and sets the default drawing color to black.
     */
    public NullShapeProducer() {
        this.listeners = new ArrayList<ShapeCreationListener>();
        this.drawColor = Color.BLACK;
    }

    /**
     * Records the point at which the mouse was pressed. 
     *
     * @param e The <code>MouseEvent</code> of interest, which for us
     *          is the mouse being pressed.
     */
    public void mousePressed(MouseEvent e) {
    }

    /** 
     * Sets the drawing color of the <code>ShapeProducer</code> to the
     * specified <code>Color</code>.
     *
     * @param color The new <code>ShapeProducer</code> drawing color.
     */
    public void setDrawColor(Color color) {
        this.drawColor = color;
    }

    /** 
     * Returns the drawing color of the current <code>ShapeProducer</code>.
     *
     * @return The current <code>ShapeProducer</code> drawing color.
     */
    public Color getDrawColor() {
        return this.drawColor;
    }

    /** 
     * Adds the specified listener to the <code>List</code> of listeners.
     *
     * @param l The listener to add to the <code>List</code> of listeners. 
     */
    public void addShapeCreationListener(ShapeCreationListener l) {
        this.listeners.add(l);
    }

    /** 
     * Removes the specified listener from the <code>List</code> of listeners.
     *
     * @param  l    The listener to remove from the <code>List</code>
     *              of listeners. 
     * @return true If the listener was successfully removed, otherwise false.
     */
    public boolean removeShapeCreationListener(ShapeCreationListener l) {
        return this.listeners.remove(l);
    }

    /** 
     * Notifies any listeners that the specified <code>Shape</code> is
     * currently in the process of being created.
     *
     * @param shape The <code>Shape</code> that is currently in progress.
     */
    public void notifyShapeInProgress(Shape shape) {
        for (ShapeCreationListener scl : this.listeners) {
            scl.shapeInProgress(shape);
        }
    }

    /** 
     * Notifies any listeners that the specified <code>Shape</code> is
     * currently in the process of being created.
     *
     * @param shape The <code>Shape</code> that is currently in progress.
     */
    public void notifyRegionSelected(int x0, int y0, int x1, int y1) {
        for (ShapeCreationListener scl : this.listeners) {
            scl.regionSelected(x0, y0, x1, y1);
        }
    }

    /**
     * Records the point at which the mouse was released and creates a new
     * <code>Rectangle</code> from this point and the starting point.  This
     * method  also notifies any listeners that a new <code>Rectangle</code>
     * has been created.
     *
     * @param e The <code>MouseEvent</code> of interest, which for us
     *          is the mouse being released.
     */
    public void mouseReleased(MouseEvent e) {
        this.start = new Point(e.getX(), e.getY());
        Settings settings = Settings.getInstance();

        int dx = 0;
        int dy = 0;
        if (e.getButton() == MouseEvent.BUTTON3) {
            dx = Math.abs(settings.getWidth() * (settings.getZoom() / 2));
            dy = dx;

            System.out.println("Mouse button 2 pressed, i.e. ZOOM OUT");
        } else {
            dx = Math.abs(settings.getWidth() / (settings.getZoom() * 2));
            dy = dx;

            System.out.println("Mouse button 1 pressed, i.e. ZOOM IN");
        }

        int x0 = (int) start.getX() - dx;
        int y0 = (int) start.getY() - dy;
        int x1 = (int) start.getX() + dx;
        int y1 = (int) start.getY() + dy;

        notifyRegionSelected(x0, y0, x1, y1);
        notifyShapeInProgress(new NullShape());
    }

    /** 
     * Notifies any listeners that a <code>Rectangle</code> is
     * currently in the process of being created.
     *
     * @param e The <code>MouseEvent</code> of interest, which for us
     *          is the mouse being dragged.
     */
    public void mouseDragged(MouseEvent e) {
    }
}
