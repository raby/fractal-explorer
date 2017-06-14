package edu.wcu.cs.cs495.team1.capstone.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

/**
 * The class provides the framework for a panel for displaying the statistics
 * about the current region being calculated.
 *
 * @author  Eddie Allen
 *
 * @version 11 November 2010
 */
public class StatPanel extends JPanel {
    /** Represents the number of rows in the panel layout. */
    private static final int NUM_ROWS = 3;

    /** Represents the number of columns in the panel layout. */
    private static final int NUM_COLS = 0;

    /** Creates a new panel for selecting different viewing options. */
    public StatPanel() {
        createStatPanel();
    }

    /** Creates the panel containing statistics about the current region. */
    public void createStatPanel() {
        setLayout(new GridLayout(NUM_ROWS, NUM_COLS));
        add(new JLabel("Coordinate Information"));
        add(new JSeparator());
        add(new JLabel("Server Information"));
    }
}
