package edu.wcu.cs.cs495.team1.capstone.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.border.LineBorder;
import javax.swing.JPanel;
import edu.wcu.cs.cs495.team1.capstone.image.Image;

/**
 * This class encapsulates the knowledge for creating the 
 * <code>DisplayPanel</code> which contains the <code>DrawPanel</code> for
 * displaying the Mandelbrot and and Julia set images as well as the
 * <code>StatPanel</code> for displaying the application statistics.
 *
 * @author  Eddie Allen
 *
 * @version 11 November, 2010
 */
public class DisplayPanel extends JPanel implements ImageCreationListener {
    /** The settings for the graphical user interface. */
    private Settings settings = Settings.getInstance();

    /** The panel for drawing the Mandelbrot and Julia set images. */
    private DrawPanel drawPanel;

    /** The panel for displaying the buttons. */
    private ButtonPanel buttonPanel;

    /** The panel for displaying the application statistics. */
    private StatPanel statPanel;

    /** 
     * Creates a new panel for displaying the current region of the 
     * Mandelbrot set as well as statistical information about the 
     * application.
     */
    public DisplayPanel() {
        createDisplayPanel();
    }

    /**
     * Notifies the <code>DrawPanel</code> that a new image was created.
     *
     * @param image The newly created image.
     */
    public void imageCreated(Image image) {
        drawPanel.imageCreated(image);
    }

    /** Creates the panel for displaying the Mandelbrot and stat panel. */
    private void createDisplayPanel() {
        setLayout(new BorderLayout());

        drawPanel = new DrawPanel();
        statPanel = new StatPanel();
        buttonPanel = new ButtonPanel();

        add(drawPanel, BorderLayout.CENTER);
        //add(statPanel, BorderLayout.EAST);
        add(buttonPanel, BorderLayout.WEST);
    }

    /** 
     * Returns the <code>DrawPanel</code> associated with this 
     * <code>DisplayPanel</code>.
     *
     * @return The <code>DrawPanel</code> associated with this 
     *         <code>DisplayPanel</code>.
     */
    public DrawPanel getDrawPanel() {
        return this.drawPanel;
    }
}
