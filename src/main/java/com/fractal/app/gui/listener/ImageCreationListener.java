package com.fractal.app.gui.listener;

import com.fractal.app.image.Image;

/**
 * This interface allows all concrete implementations to listen for when an
 * <code>Image</code> is created.
 *
 * @author  Eddie Allen
 *
 * @version 11 November 2010
 */
public interface ImageCreationListener {
    /**
     * Notifies that the specified image has been created.
     *
     * @param image The newly created image.
     */
    public void imageCreated(Image image);
}
