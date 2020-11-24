package com.nexttools.model;

import java.util.ArrayList;

public class Schedule {
    private ArrayList<Long> pauseAt;
    private ArrayList<Long> resumeAt;

    public Schedule() {
        this.pauseAt = new ArrayList<>();
        this.resumeAt = new ArrayList<>();
    }

    public ArrayList<Long> getPauseAt() {
        return pauseAt;
    }

    public ArrayList<Long> getResumeAt() {
        return resumeAt;
    }

    public void addPauseAt(long pauseAt) {
        this.pauseAt.add(pauseAt);
    }

    public void addResumeAt(long pauseAt) {
        this.resumeAt.add(pauseAt);
    }
}
