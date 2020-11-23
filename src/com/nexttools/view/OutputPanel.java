package com.nexttools.view;

import model.Calculator;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * The right hand panel that displays the calculated values.
 */
public class OutputPanel extends JPanel implements Observer {
    private Calculator calculator;
    private JLabel highHours;
    private JLabel mediumHours;
    private JLabel lowHours;
    private JLabel monthly;
    private JLabel daily;

    /**
     * Panel constructor. The layout of the text is defined here.
     * @param calculator the calculator that calculates the values to be displayed
     */
    public OutputPanel(Calculator calculator) {
        calculator.addObserver(this);

        setBackground(Color.DARK_GRAY);

        this.calculator = calculator;
        this.highHours = new JLabel();
        this.mediumHours = new JLabel();
        this.lowHours = new JLabel();
        this.monthly = new JLabel();
        this.daily = new JLabel();

        text();

        GroupLayout layout = new GroupLayout(this);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addComponent(highHours)
                                .addComponent(mediumHours)
                                .addComponent(lowHours)
                                .addComponent(monthly)
                                .addComponent(daily)
                        )
        );
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addComponent(highHours)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addComponent(mediumHours)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addComponent(lowHours)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addComponent(monthly)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addComponent(daily)
                        )
        );
        this.setLayout(layout);
    }

    /**
     * The text to be displayed and updated when new values are calculated
     */
    public void text() {
        highHours.setText("<html><font color=\"white\">High Hours Cost: " + String.format("%.3f", calculator.getComputedHigh()) + " €</font></html>");
        mediumHours.setText("<html><font color=\"white\">Medium Hours Cost: " + String.format("%.3f", calculator.getComputedMedium()) + " €</font></html>");
        lowHours.setText("<html><font color=\"white\">Low Hours Cost: " + String.format("%.3f", calculator.getComputedLow()) + " €</font></html>");
        monthly.setText("<html><font color=\"white\">Monthly Cost: " + String.format("%.3f", calculator.getTotal()) + " €</font></html>");
        daily.setText("<html><font color=\"white\">Daily Cost: " + String.format("%.3f", (calculator.getTotal() / 30)) + " €</font></html>");
    }

    @Override
    public void update(Observable o, Object arg) {
        text();
    }
}
