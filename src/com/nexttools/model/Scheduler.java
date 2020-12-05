package com.nexttools.model;

import java.util.concurrent.ScheduledExecutorService;

public class Scheduler {
    private Schedule schedule;

    public Scheduler() {
        this.schedule = new Schedule();
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public Schedule getSchedule() {
        return this.schedule;
    }

    private void schedulePause() {
        for (Long time: schedule.getPauseAt()) {
            ScheduledExecutorService scheduledExecutorService;
        }
    }

    private void scheduleResume() {
        for (Long time: schedule.getResumeAt()) {
            ScheduledExecutorService scheduledExecutorService;
        }
    }
}
