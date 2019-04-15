package io.github.lzx2005.entity;

import io.github.lzx2005.enums.SessionType;

import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;

/**
 * 描述一次session，分为上午或者下午
 */
public class Session {

    private int totalMinutes;
    private int restMinutes;
    private LocalTime startTime;
    private SessionType sessionType;
    private List<Talk> talks;

    public Session(SessionType sessionType) {
        this.sessionType = sessionType;
        this.startTime = sessionType.getStartTime();
        this.totalMinutes = sessionType.getTotalMinutes();
        this.restMinutes = sessionType.getTotalMinutes();
        this.talks = new LinkedList<>();
    }

    public int getTotalMinutes() {
        return totalMinutes;
    }

    public int getRestMinutes() {
        return restMinutes;
    }

    public List<Talk> getTalks() {
        return talks;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void addTalk(Talk talk) {
        if (talk == null) {
            throw new NullPointerException("talk is null");
        }
        int needMinutes = talk.getMinutes();
        if (needMinutes > restMinutes) {
            throw new RuntimeException("this session is full of talks");
        }
        this.talks.add(talk);
        this.restMinutes -= talk.getMinutes();
    }

    public void removeTalk(Talk talk) {
        if (talk == null) {
            throw new NullPointerException("talk is null");
        }
        //todo
    }

    @Override
    public String toString() {
        String t = this.sessionType == SessionType.MORNING ? "AM" : "PM";
        LocalTime st = LocalTime.of(this.startTime.getHour(), this.startTime.getMinute());
        StringBuilder sb = new StringBuilder();
        for (Talk talk : this.getTalks()) {
            if (st.getHour() < 10) {
                sb.append(0);
            }
            sb.append(st.getHour()).append(":");

            if (st.getMinute() < 10) {
                sb.append(0);
            }
            sb.append(st.getMinute()).append(t).append(" ");
            sb.append(talk.getTitle()).append("\n");
            st = st.plusMinutes(talk.getMinutes());
        }
        return sb.toString();
    }
}
