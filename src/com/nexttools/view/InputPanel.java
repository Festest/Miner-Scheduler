package com.nexttools.view;

import com.nexttools.model.Scheduler;
import com.nexttools.view.buttons.GenerateScheduleButton;
import com.nexttools.view.buttons.LoadScheduleButton;

import javax.swing.*;
import java.awt.*;

/**
 * The left hand panel that manages the user input through textFields and checkBoxes.
 */
public class InputPanel extends JPanel {
    private final LoadScheduleButton loadScheduleButton;
    private final GenerateScheduleButton generateScheduleButton;

    public InputPanel(Scheduler scheduler) {
        loadScheduleButton = new LoadScheduleButton(scheduler);
        generateScheduleButton = new GenerateScheduleButton(scheduler);

        setBackground(Color.DARK_GRAY);

        GroupLayout layout = new GroupLayout(this);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(loadScheduleButton)
                        .addComponent(generateScheduleButton)
                )
        );
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(loadScheduleButton)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(generateScheduleButton)
                )
        );
        this.setLayout(layout);
    }
}
