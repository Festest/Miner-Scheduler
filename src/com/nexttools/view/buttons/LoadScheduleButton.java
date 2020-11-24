package com.nexttools.view.buttons;

import com.nexttools.controler.Load;
import com.nexttools.model.Scheduler;

import javax.swing.*;

public class LoadScheduleButton extends JButton {
    public LoadScheduleButton(Scheduler scheduler) {
        super(new Load(scheduler));
        setButtonProperties();
    }

    private void setButtonProperties() {
        setVerticalTextPosition(AbstractButton.CENTER);
        setHorizontalTextPosition(AbstractButton.CENTER);
    }
}
