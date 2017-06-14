package com.fractal.app.gui.panel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.net.URL;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

/**
 * The framework for the GUI in which contains the "stop", "restart", and "go"
 * buttons for the "Fractal Explorer".
 *
 * @author  Eddie Allen
 *
 * @version 11 November 2010
 */
public class ButtonPanel extends JPanel {
    /** The number of rows in the panel layout. */
    private static final int NUM_ROWS = 3;

    /** The number of columns in the panel layout. */
    private static final int NUM_COLS = 0;

    /** A button for stopping the Mandelbrot server calculations. */
    private JButton stopButton;

    /** A button for resetting the application settings. */
    private JButton resetButton;

    /** A button for updating the application settings. */
    private JButton updateButton;

    /** The application settings. */
    private Settings settings = Settings.getInstance();

    /** Creates a new panel for selecting different viewing options. */
    public ButtonPanel() {
        createButtonPanel();
        createButtonListeners();
    }

    /** Creates the panel containing statistics about the current region. */
    public void createButtonPanel() {
        setLayout(new GridLayout(NUM_ROWS, NUM_COLS));

        JPanel button = null;

        updateButton = new JButton("\nUpdate");
        stopButton = new JButton("\nStop");
        resetButton = new JButton("\nReset");

        updateButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        updateButton.setHorizontalTextPosition(SwingConstants.CENTER);
        stopButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        stopButton.setHorizontalTextPosition(SwingConstants.CENTER);
        resetButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        resetButton.setHorizontalTextPosition(SwingConstants.CENTER);

        updateButton.setOpaque(false);
        stopButton.setOpaque(false);
        resetButton.setOpaque(false);

        // Grey out the stop button because it is currently not functional
        stopButton.setEnabled(false);

        updateButton.setIcon(createIcon("/start.png"));
        resetButton.setIcon(createIcon("/reset.png"));
        stopButton.setIcon(createIcon("/stop.png"));

        button = new JPanel(new BorderLayout());
        button.add(stopButton, BorderLayout.CENTER);
        add(button);

        button = new JPanel(new BorderLayout());
        button.add(resetButton, BorderLayout.CENTER);
        add(button);

        button = new JPanel(new BorderLayout());
        button.add(updateButton, BorderLayout.CENTER);
        add(button);
    }

    /** Creates the listeners for all of the selection options. */
    private void createButtonListeners() {
        createUpdateButtonListener();
        createStopButtonListener();
        createResetButtonListener();
    }

    /** Creates the listener for the update button. */
    private void createUpdateButtonListener() {
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                settings.notifyStateChanged();
            }
        });
    }

    /** Creates the listener for the stop button. */
    private void createStopButtonListener() {
    }

    /** Creates the listener for the reset button. */
    private void createResetButtonListener() {
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                settings.reset();
            }
        });
    }

    /**
     * Creates an icon from the specified file path.
     *
     * @param path The file path where the image file is located.
     * @return     The <code>ImageIcon</code> that was created.
     */
    private ImageIcon createIcon(String path) {
        URL imageURL = getClass().getResource(path);
        ImageIcon icon = null;

        if (imageURL != null) {
            icon = new ImageIcon(imageURL);
        }

        return icon;
    }
}
