package com.nexttools.view.buttons;

import com.nexttools.controler.Save;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class SaveButton extends JButton {
    public SaveButton(JFormattedTextField mondayField, JFormattedTextField tuesdayField, JFormattedTextField wednesdayField,
                      JFormattedTextField thursdayField, JFormattedTextField fridayField, JFormattedTextField saturdayField, JFormattedTextField sundayField) {
        super(new Save(mondayField, tuesdayField, wednesdayField, thursdayField, fridayField, saturdayField, sundayField));
        setButtonProperties();
    }

    /**
     * "ALT + S" will also trigger this button.
     */
    private void setButtonProperties() {
        setVerticalTextPosition(AbstractButton.CENTER);
        setHorizontalTextPosition(AbstractButton.CENTER);
        setMnemonic(KeyEvent.VK_S);
    }

}