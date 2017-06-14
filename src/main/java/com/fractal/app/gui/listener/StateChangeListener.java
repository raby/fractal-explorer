package com.fractal.app.gui.listener;

/**
 * This class provides an interface to classes which listen for changes in 
 * GUI state.
 *
 * @author  Eddie Allen 
 *
 * @version 16 February 2011
 */
public interface StateChangeListener {
    /** Notify any listeners of a change in state. */
    public void stateChanged();
}
