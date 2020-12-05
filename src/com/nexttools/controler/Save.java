package com.nexttools.controler;

import com.nexttools.view.FileChooser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Class to save the graph to a file
 */
public class Save extends AbstractAction{
    private FileWriter saveFile;

    private final JFormattedTextField mondayField;
    private final JFormattedTextField tuesdayField;
    private final JFormattedTextField wednesdayField;
    private final JFormattedTextField thursdayField;
    private final JFormattedTextField fridayField;
    private final JFormattedTextField saturdayField;
    private final JFormattedTextField sundayField;

    /**
     * The Save button
     * @param mondayField the text field containing the schedule for this day
     * @param tuesdayField the text field containing the schedule for this day
     * @param wednesdayField the text field containing the schedule for this day
     * @param thursdayField the text field containing the schedule for this day
     * @param fridayField the text field containing the schedule for this day
     * @param saturdayField the text field containing the schedule for this day
     * @param sundayField the text field containing the schedule for this day
     */

    public Save(JFormattedTextField mondayField, JFormattedTextField tuesdayField, JFormattedTextField wednesdayField, JFormattedTextField thursdayField, JFormattedTextField fridayField, JFormattedTextField saturdayField, JFormattedTextField sundayField) {
        super("Save");
        this.mondayField = mondayField;
        this.tuesdayField = tuesdayField;
        this.wednesdayField = wednesdayField;
        this.thursdayField = thursdayField;
        this.fridayField = fridayField;
        this.saturdayField = saturdayField;
        this.sundayField = sundayField;
    }

    /**
     * Write the data of the model into a file in the desired format
     */
    public void saveModelToFile() {
        try {
            JFileChooser chooser = FileChooser.start();

            if (chooser.showSaveDialog(chooser) == JFileChooser.APPROVE_OPTION) {
                /* Paths & Names */
                String fileName = chooser.getSelectedFile().getName();
                String directory = String.valueOf(chooser.getCurrentDirectory());

                this.saveFile = new FileWriter(new File(directory, fileName + ".sch"));

                /* Data */
                write();
                saveFile.close();
                System.out.println("Successfully wrote to the file.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    void write() {
        try {
            saveFile.write("Monday\n");
            String[] lines = this.mondayField.getText().split(", ");
            for (String string: lines) {
                saveFile.write(string + "\n");
            }
            saveFile.write("Tuesday\n");
            lines = this.tuesdayField.getText().split(", ");
            for (String string: lines) {
                saveFile.write(string + "\n");
            }
            saveFile.write("Wednesday\n");
            lines = this.wednesdayField.getText().split(", ");
            for (String string: lines) {
                saveFile.write(string + "\n");
            }
            saveFile.write("Thursday\n");
            lines = this.thursdayField.getText().split(", ");
            for (String string: lines) {
                saveFile.write(string + "\n");
            }
            saveFile.write("Friday\n");
            lines = this.fridayField.getText().split(", ");
            for (String string: lines) {
                saveFile.write(string + "\n");
            }
            saveFile.write("Saturday\n");
            lines = this.saturdayField.getText().split(", ");
            for (String string: lines) {
                saveFile.write(string + "\n");
            }
            saveFile.write("Sunday\n");
            lines = this.sundayField.getText().split(", ");
            for (String string: lines) {
                saveFile.write(string + "\n");
            }
        } catch (IOException e) {
            System.err.println("Unable to write to new file");
        }
    }

    /**
     * Saves the current model to a file
     * @param e ActionEvent that is raised from the user action
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        saveModelToFile();
    }
}

