package com.fractal.app.image;

/**
 * This class provides a wrapper for transmitting byte array representations
 * of images arrays over a network.
 *
 * @author  Eddie Allen
 *
 * @version 25 September 2010
 */
public class ImageByteArrayWrapper {
    /** The byte array representation of the image. */
    private byte[] image;

    /** A unique id associated with this image. */
    private int id;

    /** The x-value image buffer index. */
    private int xCoord;

    /** The y-value image buffer index. */
    private int yCoord;

    /** 
     * Wraps the specified byte array in a <code>ImageByteArrayWrapper</code>
     * and assigns it the specified id.
     *
     * @param image   The byte array representation of the image.
     * @param id      The unique id associated with this image.
     * @param xCoord  The x-value image buffer index.
     * @param yCoord  The y-value image buffer index.
     */
    public ImageByteArrayWrapper(byte[] image, int id, int xCoord, int yCoord) {
        this.image = image;
        this.id = id;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    /**
     * Returns the byte array representation of the image.
     *
     * @return The byte array representation of the image.
     */
    public byte[] getImageByteArray() {
        return image;
    }

    /**
     * Returns the unique id associated with this image. 
     *
     * @return The unique id associated with this image.
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the x-value offset into the image buffer.
     *
     * @return The x-value offset into the image buffer.
     */
    public int getX() {
        return xCoord;
    }

    /**
     * Returns the y-value offset into the image buffer.
     *
     * @return The y-value offset into the image buffer.
     */
    public int getY() {
        return yCoord;
    }
}
