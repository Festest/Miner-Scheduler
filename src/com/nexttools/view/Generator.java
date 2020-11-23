package com.nexttools.view;

import com.nexttools.view.buttons.SaveButton;

import javax.swing.*;
import java.awt.*;

public class Generator {
    private final JFrame frame;
    private final JPanel panel;

    private final JLabel mondayLabel;
    private final JLabel tuesdayLabel;
    private final JLabel wednesdayLabel;
    private final JLabel thursdayLabel;
    private final JLabel fridayLabel;
    private final JLabel saturdayLabel;
    private final JLabel sundayLabel;

    private final JFormattedTextField mondayField;
    private final JFormattedTextField tuesdayField;
    private final JFormattedTextField wednesdayField;
    private final JFormattedTextField thursdayField;
    private final JFormattedTextField fridayField;
    private final JFormattedTextField saturdayField;
    private final JFormattedTextField sundayField;

    private final SaveButton save;

    public Generator() {
        frame = new JFrame();
        panel = new JPanel();

        mondayLabel = new JLabel("<html><font color=\"white\">Monday</font></html>");
        tuesdayLabel = new JLabel("<html><font color=\"white\">Tuesday</font></html>");
        wednesdayLabel = new JLabel("<html><font color=\"white\">Wednesday</font></html>");
        thursdayLabel = new JLabel("<html><font color=\"white\">Thursday</font></html>");
        fridayLabel = new JLabel("<html><font color=\"white\">Friday</font></html>");
        saturdayLabel = new JLabel("<html><font color=\"white\">Saturday</font></html>");
        sundayLabel = new JLabel("<html><font color=\"white\">Sunday</font></html>");

        mondayField = new JFormattedTextField();
        tuesdayField = new JFormattedTextField();
        wednesdayField = new JFormattedTextField();
        thursdayField = new JFormattedTextField();
        fridayField = new JFormattedTextField();
        saturdayField = new JFormattedTextField();
        sundayField = new JFormattedTextField();

        save = new SaveButton(mondayField, tuesdayField, wednesdayField, thursdayField, fridayField, saturdayField, sundayField);

        setFrame();
    }

    private void setFrame() {
        /* Initialize all panel data */
        setPanel();

        /* Add the panel to the frame */
        frame.add(panel);

        /* Set the size of the frame */
        frame.setPreferredSize(new Dimension(450, 160));

        /* Set minimum size*/
        frame.setResizable(false);

        /* Try to make all the components at or above their preferred size */
        frame.pack();

        /* Center the frame on the screen */
        frame.setLocationRelativeTo(null);

        /* Make sure we can actually see the frame */
        frame.setVisible(true);
    }

    private void setPanel() {
        panel.setBackground(Color.darkGray);

        GroupLayout layout = new GroupLayout(panel);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addComponent(mondayLabel)
                                .addComponent(tuesdayLabel)
                                .addComponent(wednesdayLabel)
                                .addComponent(thursdayLabel)
                                .addComponent(fridayLabel)
                                .addComponent(saturdayLabel)
                                .addComponent(sundayLabel)
                                .addComponent(save)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addComponent(mondayField)
                                .addComponent(tuesdayField)
                                .addComponent(wednesdayField)
                                .addComponent(thursdayField)
                                .addComponent(fridayField)
                                .addComponent(saturdayField)
                                .addComponent(sundayField)
                        )
        );
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addComponent(mondayLabel)
                                .addComponent(mondayField)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addComponent(tuesdayLabel)
                                .addComponent(tuesdayField)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addComponent(wednesdayLabel)
                                .addComponent(wednesdayField)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addComponent(thursdayLabel)
                                .addComponent(thursdayField)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addComponent(fridayLabel)
                                .addComponent(fridayField)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addComponent(saturdayLabel)
                                .addComponent(saturdayField)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addComponent(sundayLabel)
                                .addComponent(sundayField)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addComponent(save)
                        )
        );
        panel.setLayout(layout);
    }
}
