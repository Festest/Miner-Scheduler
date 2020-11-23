package com.nexttools.controler;

import com.nexttools.model.FileChooser;
import nl.rug.oop.grapheditor.model.GraphEdge;
import nl.rug.oop.grapheditor.model.GraphModel;
import nl.rug.oop.grapheditor.model.GraphNode;

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

                this.saveFile = new FileWriter(new File(directory, fileName + ".graph"));

                /* Data */
                saveFile.write(graphModel.sizeNodes() + " " + graphModel.sizeEdges());
                nodesToFile();
                edgesToFile();
                saveFile.close();
                System.out.println("Successfully wrote to the file.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * Write the information of the nodes to the file
     * @throws IOException
     */
    public void nodesToFile() throws IOException {
        for (int i = 0; i < graphModel.sizeNodes(); i++) {
            GraphNode node = graphModel.getNodes(i);
            saveFile.write("\n" + node.getX() + " " + node.getY() + " " + node.getWidth() + " " + node.getHeight() + " " + node.getName());
        }
    }

    /**
     * Write the information of the edges to the file
     * @throws IOException
     */
    public void edgesToFile() throws IOException {
        for (int j = 0; j < graphModel.sizeEdges(); j++) {
            GraphEdge edge = graphModel.getEdges(j);
            GraphNode node1 = edge.getNode1();
            GraphNode node2 = edge.getNode2();
            int index1 = -1;
            int index2 = -1;

            for (int k = 0; k < graphModel.sizeNodes(); k++) {
                if (node1 == graphModel.getNodes(k)) {
                    index1 = k;
                }
                if (node2 == graphModel.getNodes(k)) {
                    index2 = k;
                }

                if (index1 != -1 && index2 != -1) {
                    break;
                }
            }
            saveFile.write("\n" + index1 + " " + index2);
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

