package com.nexttools.controler;

import com.nexttools.model.Scheduler;
import com.nexttools.view.ScheduleGenerator;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Generate extends AbstractAction {
    private final Scheduler scheduler;

    public Generate(Scheduler scheduler) {
        super("Generate Schedule");
        this.scheduler = scheduler;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new ScheduleGenerator();
    }
}
