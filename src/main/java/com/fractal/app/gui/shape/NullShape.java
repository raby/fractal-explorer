package com.fractal.app.gui.shape;

import java.awt.Graphics;

/**
 * This class models a {@link NullShape} and implements the Null Object design pattern.
 *
 * @author Eddie Allen
 * @version 7 July 2017
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
