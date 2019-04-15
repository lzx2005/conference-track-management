package io.github.lzx2005.enums;

import java.time.LocalTime;

public enum SessionType {

    MORNING(180, LocalTime.of(9, 0, 0)),
    AFTERNOON(240, LocalTime.of(1, 0, 0));

    private int totalMinutes;
    private LocalTime startTime;

    SessionType(int totalMinutes, LocalTime startTime) {
        this.totalMinutes = totalMinutes;
        this.startTime = startTime;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public SessionType setStartTime(LocalTime startTime) {
        this.startTime = startTime;
        return this;
    }

    public int getTotalMinutes() {
        return totalMinutes;
    }

    public SessionType setTotalMinutes(int totalMinutes) {
        this.totalMinutes = totalMinutes;
        return this;
    }
}
