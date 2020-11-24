package com.nexttools.view;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Class to setup the JFileChooser
 */
public class FileChooser extends JPanel {

    /**
     * Sets up the fileChooser
     * @return the fileChooser used to get filenames/directories
     */
    public static JFileChooser start() {
        JFrame frame = new JFrame("Select Directory");

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Schedules", "sch");
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setFileFilter(filter);
        chooser.setAcceptAllFileFilterUsed(false);

        frame.addWindowListener(
                new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                }
        );

        return chooser;
    }
}