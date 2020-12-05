package com.nexttools.controler;

import com.nexttools.model.Schedule;
import com.nexttools.model.Scheduler;
import com.nexttools.view.FileChooser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.*;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.Scanner;

public class Load extends AbstractAction {
    private final Scheduler scheduler;

    public Load(Scheduler scheduler) {
        super("Load Schedule");
        this.scheduler = scheduler;
    }

    /**
     * Get the file from the directory specified and add the information to the model
     */
    public void fileLoad() {
        File file = createFile();
        if (file == null) {
            return;
        }

        Schedule schedule = new Schedule();

        Scanner scanner;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return;
        }

        DayOfWeek day = null;
        while (scanner.hasNextLine()) {
            String string = scanner.nextLine();

            switch (string) {
                case "Monday" -> day = DayOfWeek.MONDAY;
                case "Tuesday" -> day = DayOfWeek.TUESDAY;
                case "Wednesday" -> day = DayOfWeek.WEDNESDAY;
                case "Thursday" -> day = DayOfWeek.THURSDAY;
                case "Friday" -> day = DayOfWeek.FRIDAY;
                case "Saturday" -> day = DayOfWeek.SATURDAY;
                case "Sunday" -> day = DayOfWeek.SUNDAY;
                default -> {
                    if (day != null) {
                        parseString(day, string, schedule);
                    }
                    else {
                        System.out.println("File corrupted");
                    }
                }
            }
        }

        scheduler.setSchedule(schedule);
        System.out.println("Load successful!");
    }

    private void parseString(DayOfWeek day, String string, Schedule schedule) {
        String[] parsed = string.split("->");
        if (parsed.length == 2) {
            /* Get the next day of the week that matches day */
            LocalDateTime ldt = LocalDateTime.now();
            ldt = ldt.with(TemporalAdjusters.nextOrSame(day));

            Date date = java.util.Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());

            /* input time to milliseconds */
            char[] input = parsed[0].toCharArray();
            long pauseAt = ((10 * input[0] + input[1]) * 60 + 10 * input[3] + input[4]) * 60000;

            input = parsed[1].toCharArray();
            long resumeAt = ((10 * input[0] + input[1]) * 60 + 10 * input[3] + input[4]) * 60000;

            schedule.addPauseAt(pauseAt);
            schedule.addResumeAt(resumeAt);
        }
        else {
            System.out.println("File corrupted");
        }
    }

    /**
     * Create the file based on directory
     * @return the retrieved file
     */
    public File createFile() {
        File file;

        JFileChooser chooser = FileChooser.start();
        if (chooser.showOpenDialog(chooser) == JFileChooser.APPROVE_OPTION) {
            file = new File(String.valueOf(chooser.getSelectedFile()));
        } else return null;

        return file;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        fileLoad();
    }
}
