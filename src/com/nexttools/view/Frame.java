package com.nexttools.view;



import com.nexttools.model.Scheduler;

import javax.swing.*;
import java.awt.*;

/**
 * The frame containing the two panels. This frame is not resizable and is 450x160.
 */
public class Frame extends JFrame {
    public Frame(Scheduler scheduler) {
        /* Create a frame for the GUI */
        super("Miner Scheduler");

        /* Make sure our program exits when we close the frame */
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* Create a view for the game */
        InputPanel inputPanel = new InputPanel(scheduler);
//        OutputPanel outputPanel = new OutputPanel(scheduler);
        JPanel filler = new JPanel();

        /* Position each panel */
        inputPanel.setBounds(0,0,230,125);
//        outputPanel.setBounds(230,0,220,125);


        /* Add the view to the frame */
        add(inputPanel);
//        add(outputPanel);
        add(filler);


        /* Set the size of the frame */
        setPreferredSize(new Dimension(450, 160));

        /* Set minimum size*/
        setResizable(false);

        /* Try to make all the components at or above their preferred size */
        pack();

        /* Center the frame on the screen */
        setLocationRelativeTo(null);

        /* Make sure we can actually see the frame */
        setVisible(true);
    }
}
