package com.nexttools.view;

import model.Calculator;

import javax.swing.*;
import java.awt.*;

/**
 * The left hand panel that manages the user input through textFields and checkBoxes.
 */
public class InputPanel extends JPanel {

    /**
     * The constructor for the panel.
     * @param calculator
     */
    public InputPanel(Calculator calculator) {
        setBackground(Color.DARK_GRAY);

        JLabel label1 = new JLabel("<html><font color=\"white\">Mining Wattage</font></html>");
        JFormattedTextField miningWattage = new JFormattedTextField();
        miningWattage.setValue(new Float(170));
        JLabel label2 = new JLabel("<html><font color=\"white\">Idle Wattage</font></html>");
        JFormattedTextField idleWattage = new JFormattedTextField();
        idleWattage.setValue(new Float(40));
        JCheckBox checkBox = new JCheckBox("Summer Time",true);
        view.CalculateButton calculateButton = new view.CalculateButton(calculator, miningWattage, idleWattage, checkBox);

        GroupLayout layout = new GroupLayout(this);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(label1)
                        .addComponent(label2)
                        .addComponent(checkBox)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(miningWattage)
                        .addComponent(idleWattage)
                        .addComponent(calculateButton)
                )
        );
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(label1)
                        .addComponent(miningWattage)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(label2)
                        .addComponent(idleWattage)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(checkBox)
                        .addComponent(calculateButton)
                )
        );
        this.setLayout(layout);
    }
}
