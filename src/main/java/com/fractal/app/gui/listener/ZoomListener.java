package com.fractal.app.gui.listener;

/**
 * This class provides an interface to classes which listen for changes in 
 * zoom state.
 *
 * @author  Eddie Allen 
 *
 * @version 16 February 2011
 */
public interface ZoomListener {
    /** Notify any listeners of a change in zoom state. */
    public void zoomChanged();
}
