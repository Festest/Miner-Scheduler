package com.nexttools.view.buttons;

import com.nexttools.controler.Generate;
import com.nexttools.model.Scheduler;

import javax.swing.*;

public class GenerateScheduleButton extends JButton {
    public GenerateScheduleButton(Scheduler scheduler) {
        super(new Generate(scheduler));
        setButtonProperties();
    }

    private void setButtonProperties() {
        setVerticalTextPosition(AbstractButton.CENTER);
        setHorizontalTextPosition(AbstractButton.CENTER);
    }
}
